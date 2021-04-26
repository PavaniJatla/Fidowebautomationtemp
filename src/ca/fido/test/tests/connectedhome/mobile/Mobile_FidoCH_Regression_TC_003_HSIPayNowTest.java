package ca.fido.test.tests.connectedhome.mobile;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the pay now functionality for Fido.ca
 *
 * @author aditya.dhingra
 *
 * Test steps:
 *
 *1. Click on pay now option besides Internet icon in dashboard.
 *2. Fill in the amount and the required credit card/bank details.
 *3. Click on the internet icon in dashboard.
 *4. Click on Review and Confirm
 *5. Click on confirm button.
 *6. Verify that message conveying successful payment is displayed.
 *
 **/

public class Mobile_FidoCH_Regression_TC_003_HSIPayNowTest extends BaseTestClass {
    final String strLanguage=System.getProperty("Language");

    @Test(groups = {"RegressionCH","FidoCableMobileCH"})
    public void checkFidoHSIPayNowFunctionalityMobile() {

        getReporter().reportLogWithScreenshot("Launched the Home Page");
        getFidohomepage().clkNavMobile();
        getReporter().reportLogWithScreenshot("Launched the Navigation card");
        getFidohomepage().clkLoginMobile();
        getFidologinpage().switchToSignInFrame();
        getReporter().reportLogWithScreenshot("Launched the SignIn page");
        getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernamePay());
        getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
        getReporter().reportLogWithScreenshot("Entered the account credentials");
        getFidologinpage().clkLoginInFrameMobile();
        getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),"Login Successful","Login Failed");
        getReporter().reportLogWithScreenshot("Launched the Account Page");
        String accountBalanceBeforePayment=getFidoaccountoverviewpage().getAccountBalanceBeforePayment();
        getReporter().reportLogWithScreenshot("Launched the Account Page");
        getFidoaccountoverviewpage().clkPayNow();
        getReporter().reportLogWithScreenshot("Launched the payment widget");
        getFidopaymentpage().setPaymentAmountMobile(TestDataHandler.fidoHSIAccount.getaccountDetails().getPayment());
        getReporter().reportLogWithScreenshot("set the payment amount");
        getFidopaymentpage().selectCreditCardOption();
        // -- Need to be fixed--workaround/
        getFidopaymentpage().selectCreditCardOption();
        getReporter().reportLogWithScreenshot("set the payment mode");

        // --------------------Pass it from yaml-----------------//
        getFidopaymentpage().setCreditCardNumberIFrameMobile(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getReporter().reportLogWithScreenshot("set the credit card number");
        getFidopaymentpage().selectExpiryMonthMobile(TestDataHandler.chPaymentInfo.getCreditCardDetails().getExpiryMonth());
        getFidopaymentpage().selectExpiryYearMobile(TestDataHandler.chPaymentInfo.getCreditCardDetails().getExpiryYear());
        getFidopaymentpage().setCVVNumberMobile(TestDataHandler.chPaymentInfo.getCreditCardDetails().getCVV());
        getReporter().reportLogWithScreenshot("set the credit card information");
        getFidopaymentpage().clkReviewAndContinue();
        getReporter().reportLogWithScreenshot("payment confirmation widget");
        getFidopaymentpage().clkPayNow();
        getReporter().reportLogWithScreenshot("payment processing with payment gateway");
        getReporter().hardAssert(getFidopaymentpage().verifyPaymentConfirmation(),"Launched the payment confirmation widget","Payment confirmation widget launch failed");
        getReporter().reportLogWithScreenshot("payment success widget");
        getFidopaymentpage().clkPaymentConfirmationMobile();
        getFidoaccountoverviewpage().clkOverview();
        //getFidoaccountoverviewpage().verifyAccountPage(accountBalanceBeforePayment, strLanguage);
        getReporter().reportLogWithScreenshot("Launched the Account Page with updated account balance");
        String accountBalanceAfterPayment=getFidoaccountoverviewpage().getAccountBalanceAfterpayment();
       // getReporter().hardAssert(getFidoaccountoverviewpage().verifyPayment(accountBalanceBeforePayment,accountBalanceAfterPayment,TestDataHandler.fidoHSIAccount.getaccountDetails().getPayment(), strLanguage),"Payment Success","Payment Failed");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method)
            throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login,method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}

