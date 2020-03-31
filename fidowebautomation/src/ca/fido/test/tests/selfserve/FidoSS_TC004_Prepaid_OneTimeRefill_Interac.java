package ca.fido.test.tests.selfserve;

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
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_TC004_Prepaid_OneTimeRefill_Interac  extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage", "strGroupName" })
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, strGroupName,method);			
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void prepaidOneTimeRefill() {
		fido_home_page.clkLogin();
		String userName=TestDataHandler.tc004.getUsername();
		String password=TestDataHandler.tc004.getPassword();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkBtnRefillNow();
		reporter.reportLogWithScreenshot("Refill now page.");
		String balanceBeforeRefill = fido_refill_page.getBalanceAmount();
		System.out.println("Balance before refill is: " + balanceBeforeRefill);
		fido_refill_page.clkOneTimeRefill();
		reporter.reportLogWithScreenshot("One time refill is clicked.");
		fido_refill_page.selectPayByInterac();		
		fido_refill_page.clkPayByInteracContinue();	
		String refillAmount = fido_refill_page.getRefillAmount();
		reporter.reportLogWithScreenshot("refill amount summary page");
		String balanceAfterRefill = Float.toString(Float.parseFloat(balanceBeforeRefill) + Float.parseFloat(refillAmount.split("\\$")[1]));
		System.out.println("Balance after refill is: " + balanceAfterRefill);
		fido_refill_page.clkSubmit();		
		//Interac page flow starts
		if(fido_interac_online_page.isMsgFromInteracDisplayed()) {
			fido_interac_online_page.clkBtnAdvance();
			fido_interac_online_page.clkLinkProceed();
		}
		reporter.reportLogWithScreenshot("Interac page");
		fido_interac_online_page.selectFinancialInstitution();
		fido_interac_online_page.setInteracID(TestDataHandler.paymentInfo.getInteracDetails().getInteracID());
		reporter.reportLogWithScreenshot("Set the interac ID");
		fido_interac_online_page.selectFundAPayment();
		reporter.reportLogWithScreenshot("Interac completed");		
		reporter.hardAssert(fido_refill_page.verifyOneTimeRefillSubmittedSuccessFully(),
				"One time refill submitted successfully", 
				"One time refill not submitted successfully");
		fido_refill_page.clkBacktoMyAccount();
		
		//Verify the transaction
		fido_account_overview_page.clkBtnViewTransaction();
		fido_account_overview_page.clkFidoTransactions();	
		reporter.reportLogWithScreenshot("To verify Fido transaction on this page.");
		reporter.softAssert(fido_payment_history_page.verifyFidoTransactionRecord("Interac Online",refillAmount), 
				"Transaction record found.",
				"Couldn't find the transaction record");
	}
}
