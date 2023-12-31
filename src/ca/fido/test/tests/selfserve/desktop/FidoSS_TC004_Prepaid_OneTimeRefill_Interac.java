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
	
	//@Test(groups = {"RegressionSS","BillingAndPaymentsSS"})
	public void prepaidOneTimeRefill() {
		//getFidohomepage().clkLogin();
		String userName=TestDataHandler.tc0405.getUsername();
		String password=TestDataHandler.tc0405.getPassword();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(userName);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
/*		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.", 
				"Failed to login.");*/
		getReporter().reportLogWithScreenshot("Account overview page");
		getFidoaccountoverviewpage().clkBtnRefillNow();
		getReporter().reportLogWithScreenshot("Refill now page.");
		String balanceBeforeRefill = getFidorefillpage().getBalanceAmount();	
		System.out.println("Balance before refill is: " + balanceBeforeRefill);
		getFidorefillpage().clkOneTimeRefill();
		getReporter().reportLogWithScreenshot("One time refill is clicked.");
		getFidorefillpage().selectPayByInterac();		
		getFidorefillpage().clkPayByInteracContinue();	
		String refillAmount = getFidorefillpage().getRefillAmount();
		getReporter().reportLogWithScreenshot("refill amount summary page");
		String balanceAfterRefill = Float.toString(Float.parseFloat(balanceBeforeRefill.replaceAll(",", ".").trim()) + Float.parseFloat(refillAmount.replaceAll("\\$", "").replaceAll(",", ".").trim()));
		System.out.println("Balance after refill is: " + balanceAfterRefill);
		getFidorefillpage().clkSubmit();		
		//Interac page flow starts
		if(getFidointeraconlinepage().isMsgFromInteracDisplayed()) {
			getFidointeraconlinepage().clkBtnAdvance();
			getFidointeraconlinepage().clkLinkProceed();
		}
		getReporter().reportLogWithScreenshot("Interac page");
		getFidointeraconlinepage().selectFinancialInstitution();
		getFidointeraconlinepage().setInteracID(TestDataHandler.paymentInfo.getInteracDetails().getInteracID());
		getReporter().reportLogWithScreenshot("Set the interac ID");
		getFidointeraconlinepage().selectFundAPayment();
		getReporter().reportLogWithScreenshot("Interac completed");		
		getReporter().hardAssert(getFidorefillpage().verifyOneTimeRefillSubmittedSuccessFully(),
				"One time refill submitted successfully", 
				"One time refill not submitted successfully");
		getFidorefillpage().clkBacktoMyAccount();
		
		//Verify the transaction
		getFidoaccountoverviewpage().clkBtnViewTransaction();
		getFidoaccountoverviewpage().clkFidoTransactions();	
		getReporter().reportLogWithScreenshot("To verify Fido transaction on this page.");
		getCommonbusinessflows().scrollToMiddleOfWebPage();
		getReporter().reportLogWithScreenshot("Transaction view");
		getReporter().softAssert(getFidopaymenthistorypage().verifyFidoTransactionRecord("Interac Online Interac en ligne",refillAmount), 
				"Transaction record found.",
				"Couldn't find the transaction record");
	}
}
