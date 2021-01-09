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
		getFidohomepage().clkNavMobile();
		getReporter().reportLogWithScreenshot("Launched the Navgation card");	
		getFidohomepage().clkLoginMobile();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrameMobile();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkPayNowNew(strBAN);
		getReporter().reportLogWithScreenshot("Pay now");
		getFidomakepaymentpage().setPaymentAmount(amountEntered);
		getFidomakepaymentpage().selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Creditcard);
		getReporter().reportLogWithScreenshot("Credit card option selected");
		getFidomakepaymentpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		getFidomakepaymentpage().selectExpiryMonthMobile();
		getFidomakepaymentpage().selectCreditcardExpiryYearMobile(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		getFidomakepaymentpage().setCreditcardCVVMobile(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		getReporter().reportLogWithScreenshot("Credit card details entered");
		getFidomakepaymentpage().clkReviewAndContinueButtonMobile();
		getReporter().reportLogWithScreenshot("Account overview page");
		getFidomakepaymentpage().clkPayNowMobile();
		getReporter().reportLogWithScreenshot("reference Number page");
		String refNo=getFidomakepaymentpage().getRefNumber();	
		getReporter().reportLogWithScreenshot("reference number for payment is :"+refNo);
		getReporter().hardAssert(getFidomakepaymentpage().verifyPaymentSuccessfulMessageDisplayed(),
							"Payment successful message displayed",
							"Payment successful message not displayed");
		getFidomakepaymentpage().clkPaymentHistoryLinkOnConfirmationPageMobile();
		getReporter().reportLogWithScreenshot("Payment history page selected");
		getReporter().hardAssert(getFidopaymenthistorypage().verifyThePaymentHistoryRecordMobile(refNo,FidoMakePaymentPage.MakePayOptions.Creditcard),
							"Payment history record is verified for credit  card :"+refNo,
							"Payment history record is not verified for credit card payment ref no :"+refNo);
	}

}
