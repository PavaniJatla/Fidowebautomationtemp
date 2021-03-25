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

public class Fido_BFA_TC15_AALUsingFinancePlanExpressShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","SanityBFA","AALBFA"})
    public void aALUsingFinancePlanExpressShippingFlowTest() {
        getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
        getFidohomepage().clkLogin();
        getFidologinpage().switchToSignInFrame();
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc15AALFinancingPlanExpressShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc15AALFinancingPlanExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
/*        getFidoaccountoverviewpage().clkViewUsageAndManageLink();
        getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
        getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
        getReporter().reportLogWithScreenshot("Mobile Dashboard page");*/
        getDriver().get(System.getProperty("AWSUrl") + "/phones");
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc15AALFinancingPlanExpressShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getFidochoosephonepage().selectAddALineButton();
        getReporter().reportLogPassWithScreenshot("Add a Line Button Selected");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyDevicesInHeader(),"Page loading fine","Page is not loading");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        getFidodeviceconfigpage().clickContinueButton();
        String deviceCostIndex = TestDataHandler.tc15AALFinancingPlanExpressShipping.getDeviceCostIndex();
        getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        String dataOptionIndex = TestDataHandler.tc15AALFinancingPlanExpressShipping.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("BPO offer Selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueCallerID();
        getReporter().reportLogWithScreenshot("Called ID information entered and continue button pressed");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        String cityName = TestDataHandler.tc15AALFinancingPlanExpressShipping.getCityName();
        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(cityName);
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc15AALFinancingPlanExpressShipping.getShippingType();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
        } else {
            getReporter().reportLogWithScreenshot("Shipping selected");
        }
        getFidoCheckOutPage().clkShippingContinueButton();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected on review page");
        getReporter().reportLogWithScreenshot("OneTime payment page displayed");
        getFidopaymentpage().setCreditCardName();
        getFidopaymentpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber2());
        getFidopaymentpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth2() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear2());
        getFidopaymentpage().setCreditCardCvv(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCvv2());
        getReporter().reportLogWithScreenshot("OneTime payment page displayed before submitting");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
        getReporter().reportLogWithScreenshot("Order Confirmation page");
    }

}
