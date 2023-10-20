package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC12_AALTabletsStdShipping_PortInNumber_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"RegressionBFA","AALBFA"})
    public void tc12_FidoAALTabletStdShippingPortInTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc12AALTabletsStandardShipping.getUsername());
        getFidologinpage().clkContinueSignIn();
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc12AALTabletsStandardShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        //getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl") + "/phones/?flowType=aal");
        getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose phone page loaded successfully", "Choose phone page not loaded successfully");
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        getFidochoosephonepage().selectTabletsCheckbox();
        String deviceName = TestDataHandler.tc12AALTabletsStandardShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        getFidodeviceconfigpage().clickContinueButton();
        getFidobuildplanpage().clkContinueDeviceCost();
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        //getFidobuildplanpage().clkDeviceBalancePopUp();
        //getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
//        String dataOptionIndex = TestDataHandler.tc12AALTabletsStandardShipping.getDataOptionIndex();
//        getFidobuildplanpage().clkDataOption(dataOptionIndex,this.getClass().getSimpleName());
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        //getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueDeviceProtection();
        getReporter().reportLogWithScreenshot("Called ID information");
        getFidobuildplanpage().clkCallerIdContinueBtn();
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
//        String cityName = TestDataHandler.tc12AALTabletsStandardShipping.getCityName();
//        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(cityName);
//        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getFidochoosenumberpage().clkExistingNumberTab();
        getReporter().reportLogPassWithScreenshot("Use an Existing Number Option is selected");
        getFidochoosenumberpage().setExistingPortInNumber(TestDataHandler.tc12AALTabletsStandardShipping.getPortInNumber());
        getReporter().reportLogPassWithScreenshot("Existing number is entered for PortIn check");
        getFidochoosenumberpage().clkCheckEligibilityBtn();
        getReporter().hardAssert(getFidochoosenumberpage().verifyPortInSuccess(),"Entered Number is eligible for PortIn","Entered Number is not eligible for PortIn");
        getFidochoosenumberpage().clkContinueChooseNumber();
        getFidopaymentoptionspage().clickSkipAutopay();
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc12AALTabletsStandardShipping.getShippingType();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
        } else {
            getReporter().reportLogWithScreenshot("Shipping selected");
        }
        getFidoCheckOutPage().clkShippingContinueButton();
        getFidoCheckOutPage().clksaveAndContinueBtnCheckoutPage();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        boolean isPaymentRequired = getFidoorderreviewpage().verifyPaymentRequired();
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected");
        if(isPaymentRequired) {
            getReporter().reportLogWithScreenshot("OneTime payment page displayed");
            getReporter().softAssert(getFidopaymentpage().verifyOneTimePaymentTitle(),
                    "One Time Payment Page displayed","One Time Payment Page Not displayed");
            String otpAmount = getFidopaymentpage().getOneTimePaymentAmount();
            getReporter().reportLogWithScreenshot("One Time Payment Amount = " +otpAmount);
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
