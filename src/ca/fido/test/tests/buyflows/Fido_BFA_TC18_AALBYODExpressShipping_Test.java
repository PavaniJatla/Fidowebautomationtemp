package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC18_AALBYODExpressShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"RegressionBFA","AALBFA"})
    public void fidoAALBYODStandardShippingFlowTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc18AALBYODExpressShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc18AALBYODExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl") + "/phones/bring-your-own-device?flowType=aal");
        getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
        getReporter().reportLogWithScreenshot("Fido plan config page");
        //getFidochoosephonepage().selectAddALineButton();
        //getReporter().reportLogPassWithScreenshot("Add a Line Button Selected");
        //getFidobuildplanpage().clkDeviceBalancePopUp();
        //getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        String dataOptionIndex = TestDataHandler.tc18AALBYODExpressShipping.getDataOptionIndex();
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
        String cityName = TestDataHandler.tc18AALBYODExpressShipping.getCityName();
        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(cityName);
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc18AALBYODExpressShipping.getShippingType();
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
