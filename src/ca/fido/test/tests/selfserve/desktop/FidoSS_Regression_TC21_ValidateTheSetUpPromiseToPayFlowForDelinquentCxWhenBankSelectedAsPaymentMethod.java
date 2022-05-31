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
public class FidoSS_Regression_TC21_ValidateTheSetUpPromiseToPayFlowForDelinquentCxWhenBankSelectedAsPaymentMethod extends BaseTestClass{

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
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc21.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc21.getPassword());
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
				
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyPromiseToPayLink(), 
				"Set up promise to pay is displayed", 
				"Set up promise to pay is NOT displayed");
		getReporter().reportLogWithScreenshot("Set up promise to pay");
			
		getFidoaccountoverviewpage().clkSetUpAPromiseToPay();
		getReporter().reportLogWithScreenshot("Clicked on link Set up promise to pay");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySetUpPromiseToPayPageIsLoaded(), 
				"Set up promise to pay page is displayed", 
				"Set up promise to pay is page NOT displayed");
		String strBalanceValue = getFidoaccountoverviewpage().getBalanceValueForPromise();
		getFidoaccountoverviewpage().selectHowWouldYouLikeToPromiseToPay("Telephone/Online banking");
		getReporter().reportLogWithScreenshot("Payment type selected as credit card");
		String strDate = getFidoaccountoverviewpage().selectWhenYouWillIkeToPayThePromise();

		getReporter().reportLogWithScreenshot("Promise date selected");

		getFidoaccountoverviewpage().clkSetUpPromise();
		getReporter().reportLogWithScreenshot("Set up promise to pay is displayed");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyPromiseToSetUpSuccessFul(), 
				"Set up promise to pay is set up successfully , balance value: "+strBalanceValue + "Promise Date: "+strDate, 			
				"Set up promise to pay is NOT set up successfully");
		getReporter().reportLogWithScreenshot("Set up promise success page");			
		getFidoaccountoverviewpage().clkDoneSetUpPromiseAfterSuccess();		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Account overview page loaded", 
				"Account overview page didnt load");			
	}

}
