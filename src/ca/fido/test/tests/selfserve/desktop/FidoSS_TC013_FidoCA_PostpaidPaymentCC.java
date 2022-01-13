package ca.fido.test.tests.selfserve.desktop;

import ca.fido.pages.FidoMakePaymentPage;
import ca.fido.pages.FidoPaymentOptionsPage;
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
public class FidoSS_TC013_FidoCA_PostpaidPaymentCC extends BaseTestClass{

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
	
	@Test(groups = {"SanitySS","BillingAndPaymentsSS","TC13"})
	public void postPaidPaymentCC() throws InterruptedException {

		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().waitForPayNowToBecomeClickable();
		//.clkPayNow();
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getReporter().reportLogWithScreenshot("Make Payment button is clicked.");
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getFidoaccountoverviewpage().clkPayNowNew(strBAN);
		getReporter().reportLogWithScreenshot("Pay now");
		String amountEntered="2";
		getFidopaymentoptionspage().selectHowWouldYouLikeToPayNew(FidoPaymentOptionsPage.PayOptions.Creditcard);
		getFidomakepaymentpage().setPaymentAmount(amountEntered);
		getReporter().reportLogWithScreenshot("Card option selected");

		getFidomakepaymentpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() +
				TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);
		getFidomakepaymentpage().selectCreditcardExpiryYear(strDDMM);
		getFidomakepaymentpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());

		getReporter().reportLogWithScreenshot("CC details entered");
		getFidomakepaymentpage().clkReviewAndContinueButton();
		getFidomakepaymentpage().clkPayNow();

		getReporter().reportLogWithScreenshot("Payment status");
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getReporter().hardAssert(getFidomakepaymentpage().verifyPaymentSuccessful(amountEntered),
				"Payment confirmaton",
				"Payment Confirmation message Error. Refer screenshot");
		String strReferenceNumber= getFidomakepaymentpage().getTransactionReferenceNumberNew();
		getReporter().reportLogWithScreenshot("Payment Successful, Details :"+strReferenceNumber);

		getFidomakepaymentpage().clickDone();

		/*getFidomakepaymentpage().selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Creditcard);
		getReporter().reportLogWithScreenshot("Credit card option selected");
		getFidomakepaymentpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		getFidomakepaymentpage().selectExpiryMonth();
		getFidomakepaymentpage().selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		getFidomakepaymentpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		getReporter().reportLogWithScreenshot("Credit card details entered");
		getFidomakepaymentpage().clkReviewAndContinueButton();
		getReporter().reportLogWithScreenshot("Account overview page");
		getFidomakepaymentpage().clkPayNow();
		getReporter().reportLogWithScreenshot("reference Number page");
		String refNo=getFidomakepaymentpage().getRefNumber();	
		getReporter().reportLogWithScreenshot("reference number for payment is :"+refNo);
		getReporter().hardAssert(getFidomakepaymentpage().verifyPaymentSuccessfulMessageDisplayed(),
							"Payment successful message displayed",
							"Payment successful message not displayed");
		getFidomakepaymentpage().clkPaymentHistoryLinkOnConfirmationPage();
		getReporter().reportLogWithScreenshot("Payment history page selected");
		getReporter().hardAssert(getFidopaymenthistorypage().verifyPaymentHistory(refNo,FidoMakePaymentPage.MakePayOptions.Creditcard),					
				"Payment history record is verified for credit  card :"+refNo,
				"Payment history record is not verified for credit card payment ref no :"+refNo);*/
			
	}

}
