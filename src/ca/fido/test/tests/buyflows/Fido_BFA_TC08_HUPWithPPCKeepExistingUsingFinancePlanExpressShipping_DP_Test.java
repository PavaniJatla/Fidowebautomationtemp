package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC08_HUPWithPPCKeepExistingUsingFinancePlanExpressShipping_DP_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, FidoEnums.GroupName.buyflows, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"RegressionBFA","HUPBFA","DP"})
    public void fidoHUPWithPPC_KeepExistingUsingFinancePlanStandardShippingFlowTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc08HupPpcKeepExistingExpressShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc08HupPpcKeepExistingExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl")+"/phones");
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc08HupPpcKeepExistingExpressShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getFidochoosephonepage().selectUpgradeMyDeviceButton();
        getReporter().reportLogPassWithScreenshot("Upgrade My Device Button Selected");
        String ctn = TestDataHandler.tc08HupPpcKeepExistingExpressShipping.getCtn();
        getFidodeviceconfigpage().selectSubscriber(ctn);
        //getReporter().hardAssert(getFidodeviceconfigpage().verifyDevicesInHeader(), "Page loading fine", "Page is not loading");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(), "Continue button is displayed", "Continue button is not displayed");
        getFidodeviceconfigpage().clickContinueButton();
        getFidobuildplanpage().checkKeepMyCurrentPlanButton();
        getReporter().reportLogWithScreenshot("Keep My Current Plan checkbox is checked");
        getFidobuildplanpage().clkDownPaymentChkBox();
        getFidobuildplanpage().clkContinueDeviceCost();
        //String deviceCostIndex = TestDataHandler.tc13HupPpcKeepExistingExpressShipping.getDeviceCostIndex();
        //getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        /*String dataOptionIndex = TestDataHandler.tc10HupExistingSubsidy1.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");*/
        getFidobuildplanpage().selectDeviceProtectionAddon();
        getReporter().reportLogPass("Device Protection Addon is selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getReporter().hardAssert(getFidobuildplanpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String dpAddon = getFidobuildplanpage().getDeviceProtectionAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection - " +dpAddon);
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage(), "Shipping label displayed", "Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc08HupPpcKeepExistingExpressShipping.getShippingType();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage(), "Bopis Map displayed", "Bopis Map not displayed");
        } else {
            getReporter().reportLogWithScreenshot("Shipping selected");
        }
        getFidoCheckOutPage().clkShippingContinueButton();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        boolean isPaymentRequired = getFidoorderreviewpage().verifyPaymentRequired();
        getReporter().hardAssert(getFidoorderreviewpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String deviceProtectionAddon = getFidoorderreviewpage().getDeviceProtectionAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected");
        if(isPaymentRequired) {
            getReporter().reportLogWithScreenshot("OneTime payment page displayed");
            getFidopaymentpage().setCreditCardName();
            getFidopaymentpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber2());
            getFidopaymentpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth2() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear2());
            getFidopaymentpage().setCreditCardCvv(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCvv2());
            getReporter().reportLogWithScreenshot("OneTime payment page displayed before submitting");
            getFidoorderreviewpage().clkSubmitMyOrder();
        }
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
        getReporter().reportLogWithScreenshot("Order Confirmation page");
    }

}
