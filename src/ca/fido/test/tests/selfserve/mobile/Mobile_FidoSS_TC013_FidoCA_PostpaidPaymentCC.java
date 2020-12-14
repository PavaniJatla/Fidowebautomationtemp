package ca.fido.test.tests.selfserve.mobile;

import ca.fido.pages.FidoMakePaymentPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This script will verify the post paid payment via credit card 
 * @author Mirza.Kamran
 *
 */
public class Mobile_FidoSS_TC013_FidoCA_PostpaidPaymentCC extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"MobileSanitySS","MobileBillingAndPaymentsSS"})
	public void mobilePostPaidPaymentCC() throws InterruptedException {
		String amountEntered="0.01";
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navgation card");	
		fido_home_page.clkLoginMobile();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrameMobile();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		fido_account_overview_page.clkPayNowNew(strBAN);
		reporter.reportLogWithScreenshot("Pay now");
		fido_make_payment_page.setPaymentAmount(amountEntered);
		fido_make_payment_page.selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Creditcard);
		reporter.reportLogWithScreenshot("Credit card option selected");
		fido_make_payment_page.setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		fido_make_payment_page.selectExpiryMonthMobile();
		fido_make_payment_page.selectCreditcardExpiryYearMobile(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		fido_make_payment_page.setCreditcardCVVMobile(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		reporter.reportLogWithScreenshot("Credit card details entered");
		fido_make_payment_page.clkReviewAndContinueButtonMobile();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_make_payment_page.clkPayNowMobile();
		reporter.reportLogWithScreenshot("reference Number page");
		String refNo=fido_make_payment_page.getRefNumber();	
		reporter.reportLogWithScreenshot("reference number for payment is :"+refNo);
		reporter.hardAssert(fido_make_payment_page.verifyPaymentSuccessfulMessageDisplayed(),
							"Payment successful message displayed",
							"Payment successful message not displayed");
		fido_make_payment_page.clkPaymentHistoryLinkOnConfirmationPageMobile();
		reporter.reportLogWithScreenshot("Payment history page selected");
		reporter.hardAssert(fido_payment_history_page.verifyThePaymentHistoryRecordMobile(refNo,FidoMakePaymentPage.MakePayOptions.Creditcard),
							"Payment history record is verified for credit  card :"+refNo,
							"Payment history record is not verified for credit card payment ref no :"+refNo);
	}

}
