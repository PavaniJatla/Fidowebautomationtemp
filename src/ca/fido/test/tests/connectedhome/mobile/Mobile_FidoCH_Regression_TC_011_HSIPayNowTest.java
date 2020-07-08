package ca.fido.test.tests.connectedhome.mobile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;


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

public class Mobile_FidoCH_Regression_TC_011_HSIPayNowTest extends BaseTestClass {

	@Test
	public void checkFidoHSIPayNowFunctionalityMobile() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navgation card");	
		fido_home_page.clkLoginMobile();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn page");
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernamePay());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentails");
		fido_login_page.clkLoginInFrame();
		if(fido_account_overview_page.verifyLoginFailMsgIframe())
		{
			reporter.reportLogFailWithScreenshot("Login Failed");		
		}
		else
		{
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		String accountBalanceBeforePayment=fido_account_overview_page.getAccountBalanceBeforePayment();
		reporter.reportLogWithScreenshot("Launched the Account Page");	
		fido_account_overview_page.clkPayNow();
		reporter.reportLogWithScreenshot("Launched the payment widget");
		fido_payment_page.setPaymentAmount(TestDataHandler.fidoHSIAccount.getaccountDetails().getPayment());
		reporter.reportLogWithScreenshot("set the payment amount");
		fido_payment_page.selectCreditCardOption();
		// -- Need to be fixed--workaround/
		fido_payment_page.selectCreditCardOption();
		reporter.reportLogWithScreenshot("set the payment mode");

		// --------------------Pass it from yaml-----------------//
		fido_payment_page.setCreditCardNumberIFrame(TestDataHandler.fidoPaymentInfo.getCreditCardDetails().getNumber());
		reporter.reportLogWithScreenshot("set the credit card number");
		fido_payment_page.selectExpiryMonth(TestDataHandler.fidoPaymentInfo.getCreditCardDetails().getExpiryMonth());
		fido_payment_page.selectExpiryYear(TestDataHandler.fidoPaymentInfo.getCreditCardDetails().getExpiryYear());
		fido_payment_page.setCVVNumber(TestDataHandler.fidoPaymentInfo.getCreditCardDetails().getCVV());
		reporter.reportLogWithScreenshot("set the credit card information");
		fido_payment_page.clkReviewAndContinue();
		reporter.reportLogWithScreenshot("payment confirmation widget");
		fido_payment_page.clkPayNow();
		reporter.reportLogWithScreenshot("payment processing with payment gateway");		
		reporter.hardAssert(fido_payment_page.verifyPaymentConfirmation(),"Launched the payment confirmation widget","Payment confirmation widget launch failed");
		reporter.reportLogWithScreenshot("payment success widget");	
		fido_payment_page.clkPaymentConfirmationMobile();		
		fido_account_overview_page.verifyAccountPage(accountBalanceBeforePayment, TestDataHandler.fidoConfig.getLanguage());
		reporter.reportLogWithScreenshot("Launched the Account Page with updated account balance");
		String accountBalanceAfterpaymen=fido_account_overview_page.getAccountBalanceAfterpayment();
		reporter.hardAssert(fido_account_overview_page.verifyPayment(accountBalanceBeforePayment,accountBalanceAfterpaymen,TestDataHandler.fidoHSIAccount.getaccountDetails().getPayment(), TestDataHandler.fidoConfig.getLanguage()),"Payment Success","Payment Failed");
	}
	}
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(TestDataHandler.fidoConfig.getFidoURL(), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login,method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
