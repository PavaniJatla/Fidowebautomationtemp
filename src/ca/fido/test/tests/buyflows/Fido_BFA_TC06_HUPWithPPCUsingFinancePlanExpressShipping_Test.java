package ca.fido.test.tests.buyflows;

import ca.fido.pages.FidoDeviceConfigPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC06_HUPWithPPCUsingFinancePlanExpressShipping_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
    public void tc06_FidoHUPWithPPCUsingFinancePlanExpressShippingTest() {
        getDriver().get(System.getProperty("AWSUrl")+"/phones?flowType=hup&?setLanguage=EN&?province=ON");
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc06HupPpcFinancingExpressShipping.getUsername());
        getFidologinpage().clkContinueSignIn();
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc06HupPpcFinancingExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc06HupPpcFinancingExpressShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        getFidodeviceconfigpage().clickContinueButton();
        getFidobuildplanpage().clkContinueDeviceCost();
        //String deviceCostIndex = TestDataHandler.tc11HupPpcFinancingExpressShipping.getDeviceCostIndex();
        //getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        String dataOptionIndex = TestDataHandler.tc06HupPpcFinancingExpressShipping.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex, this.getClass().getSimpleName());
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        //getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueDeviceProtection();
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getReporter().reportLogWithScreenshot("Autopay Enrollment Page");
        getFidopaymentoptionspage().clickSkipAutopay();
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc06HupPpcFinancingExpressShipping.getShippingType();
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
        getReporter().reportLogPass("Submit button selected on review page");
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

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
