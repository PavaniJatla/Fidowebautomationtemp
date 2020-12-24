package ca.fido.test.tests.selfserve.desktop;

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
public class FidoSS_Regression_TC20_ValidateTheSetUpPromiseToPayFlowForDelinquentCxWhenCreditCardSelectedAsPaymentMethod extends BaseTestClass{

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
	
	@Test(groups = {"BillingAndPaymentsSS"})
	public void validateTheSetUpPromiseToPayFlowForDelinquentCxWhenCreditCardSelectedAsPaymentMethod() throws InterruptedException {		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc20.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc20.getPassword());
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
				
		reporter.hardAssert(fido_account_overview_page.verifyPromiseToPayLink(), 
				"Set up promise to pay is displayed", 
				"Set up promise to pay is NOT displayed");
		reporter.reportLogWithScreenshot("Set up promise to pay");
			
		fido_account_overview_page.clkSetUpAPromiseToPay();
		reporter.reportLogWithScreenshot("Clicked on link Set up promise to pay");
		
		reporter.hardAssert(fido_account_overview_page.verifySetUpPromiseToPayPageIsLoaded(), 
				"Set up promise to pay page is displayed", 
				"Set up promise to pay is page NOT displayed");
		String strBalanceValue = fido_account_overview_page.getBalanceValueForPromise();
		fido_account_overview_page.selectHowWouldYouLikeToPromiseToPay("Credit Card");
		reporter.reportLogWithScreenshot("Payment type selected as credit card");
		String strDate = fido_account_overview_page.selectWhenYouWillIkeToPayThePromise();

		reporter.reportLogWithScreenshot("Promise date selected");

		fido_account_overview_page.clkSetUpPromise();
		reporter.reportLogWithScreenshot("Set up promise to pay is displayed");
		
		reporter.hardAssert(fido_account_overview_page.verifyPromiseToSetUpSuccessFul(), 
				"Set up promise to pay is set up successfully , balance value: "+strBalanceValue + "Promise Date: "+strDate, 			
				"Set up promise to pay is NOT set up successfully");
		reporter.reportLogWithScreenshot("Set up promise success page");
		
		fido_account_overview_page.clkDoneSetUpPromiseAfterSuccess();		
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Account overview page loaded", 
				"Account overview page didnt load");			
	}

}
