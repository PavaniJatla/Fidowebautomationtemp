package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_TC004_Prepaid_OneTimeRefill_Interac  extends BaseTestClass{

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
		String balanceAfterRefill = Float.toString(Float.parseFloat(balanceBeforeRefill.replaceAll(",", ".").trim()) + Float.parseFloat(refillAmount.replaceAll("\\$", "").replaceAll(",", ".").trim()));
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
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Transaction view");
		reporter.softAssert(fido_payment_history_page.verifyFidoTransactionRecord("Interac Online Interac en ligne",refillAmount), 
				"Transaction record found.",
				"Couldn't find the transaction record");
	}
}
