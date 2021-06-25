package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC16_AALUsingNoTermPlanStandardShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","AALBFA"})
    public void fidoAALUsingNoTermPlanStandardShippingFlowTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc16AALNoTermPlanStandardShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc16AALNoTermPlanStandardShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl")+"/phones");
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc16AALNoTermPlanStandardShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getFidochoosephonepage().selectAddALineButton();
        getReporter().reportLogPassWithScreenshot("Add a Line Button Selected");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyDevicesInHeader(),"Page loading fine","Page is not loading");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        getFidodeviceconfigpage().clickContinueButton();
        getFidobuildplanpage().clkRadioButtonNoTerm();
        getFidobuildplanpage().clkContinueDeviceCost();
        //String deviceCostIndex = TestDataHandler.tc16AALNoTermPlanStandardShipping.getDeviceCostIndex();
        //getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        //getFidobuildplanpage().clkDeviceCost1(deviceCostIndex, "Finance");
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        String dataOptionIndex = TestDataHandler.tc16AALNoTermPlanStandardShipping.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex);
        getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueCallerID();
        getReporter().reportLogWithScreenshot("Called ID information entered and continue button pressed");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        String cityName = TestDataHandler.tc16AALNoTermPlanStandardShipping.getCityName();
        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(cityName);
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc16AALNoTermPlanStandardShipping.getShippingType();
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
        boolean isPaymentRequired = getFidoorderreviewpage().verifyPaymentRequired();
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
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

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
	}

}
