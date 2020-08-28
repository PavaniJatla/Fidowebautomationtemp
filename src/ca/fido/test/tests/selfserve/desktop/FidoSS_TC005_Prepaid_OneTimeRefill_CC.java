package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_TC005_Prepaid_OneTimeRefill_CC  extends BaseTestClass{

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
	
	@Test
	public void prepaidOneTimeRefill() {
		fido_home_page.clkLogin();
		String userName=TestDataHandler.tc0405.getUsername();
		String password=TestDataHandler.tc0405.getPassword();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Prepaid account overview page.");
		fido_account_overview_page.clkBtnRefillNow();
		reporter.reportLogWithScreenshot("Refill now button is clicked.");
		String balanceBeforeRefill = fido_refill_page.getBalanceAmount();
		System.out.println("Balance before refill is: " + balanceBeforeRefill);
		fido_refill_page.clkOneTimeRefill();
		reporter.reportLogWithScreenshot("One time refill is clicked.");
		fido_refill_page.selectPayByCreditCard();
		reporter.reportLogWithScreenshot("Pay by Credit card is selected.");
		//Credit card payment 
		if(!fido_refill_page.isCardAlreadyRegistered()) {

			fido_refill_page.setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			fido_refill_page.selectExpiryMonth("06");
			fido_refill_page.selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
			fido_refill_page.setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
			fido_refill_page.chkAuthorizeTerms();

		}
		reporter.reportLogWithScreenshot("Enter credit card details before click continue.");
		fido_refill_page.clkContinue();		  
		String refillAmount = fido_refill_page.getRefillAmount();
		String balanceAfterRefill = Float.toString(Float.parseFloat(balanceBeforeRefill.replaceAll(",", ".").trim()) + Float.parseFloat(refillAmount.replaceAll("\\$", "").replaceAll(",", ".").trim()));
		System.out.println("Balance after refill is: " + balanceAfterRefill);
		reporter.reportLogWithScreenshot("Page after refill and before submit.");
		fido_refill_page.clkSubmit();		
		reporter.hardAssert(fido_refill_page.verifyOneTimeRefillSubmittedSuccessFully(),
				"One time refill submitted successfully", 
				"One time refill not submitted successfully");
		fido_refill_page.clkBacktoMyAccount();
		
		//Verify the transaction
		fido_account_overview_page.clkBtnViewTransaction();
		reporter.reportLogWithScreenshot("View transaction clicked.");
		fido_account_overview_page.clkFidoTransactions();
		fido_account_overview_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("Verify Fido transaction on this page.");
		reporter.hardAssert(fido_payment_history_page.verifyFidoTransactionRecord("Recharge card Réapprovisionnement de carte",refillAmount),
				"Transaction history records matched", 
				"transaction history records didnt match");
	}
}
