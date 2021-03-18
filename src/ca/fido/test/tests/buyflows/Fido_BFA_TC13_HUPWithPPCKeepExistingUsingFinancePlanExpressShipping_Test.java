package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC13_HUPWithPPCKeepExistingUsingFinancePlanExpressShipping_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
    public void hupWithPPC_KeepExistingUsingFinancePlanStandardShippingFlowTest() {
        getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded(), "Home page loaded successfully", "Home page not loaded successfully");
        getFidohomepage().clkLogin();
        getFidologinpage().switchToSignInFrame();
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc13HupPpcKeepExistingExpressShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc13HupPpcKeepExistingExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
/*        getFidoaccountoverviewpage().clkViewUsageAndManageLink();
        getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
        getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
        getReporter().reportLogWithScreenshot("Mobile Dashboard page");*/
        getDriver().get(System.getProperty("AWSUrl"));
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc13HupPpcKeepExistingExpressShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getFidochoosephonepage().selectUpgradeMyDeviceButton();
        getReporter().reportLogPassWithScreenshot("Upgrade My Device Button Selected");
        String ctn = TestDataHandler.tc13HupPpcKeepExistingExpressShipping.getCtn();
        getFidodeviceconfigpage().selectSubscriber(ctn);
        getReporter().hardAssert(getFidodeviceconfigpage().verifyDevicesInHeader(), "Page loading fine", "Page is not loading");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(), "Continue button is displayed", "Continue button is not displayed");
        getFidodeviceconfigpage().clickContinueButton();
        getFidobuildplanpage().checkKeepMyCurrentPlanButton();
        getReporter().reportLogWithScreenshot("Keep My Current Plan checkbox is checked");
        String deviceCostIndex = TestDataHandler.tc13HupPpcKeepExistingExpressShipping.getDeviceCostIndex();
        getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        /*String dataOptionIndex = TestDataHandler.tc10HupExistingSubsidy1.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");*/
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage(), "Shipping label displayed", "Shipping label not displayed");
        getFidoCheckOutPage().clkShippingType("EXPRESS");
        getReporter().reportLogWithScreenshot("Shipping selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
        getFidoCheckOutPage().clkShippingContinueButton();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
        getReporter().reportLogWithScreenshot("Order Confirmation page");
    }

}
