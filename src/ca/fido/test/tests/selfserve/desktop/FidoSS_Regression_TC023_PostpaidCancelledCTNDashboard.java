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
 * This script will verify the wireless dashboard of Cancelled CTN post paid account
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC023_PostpaidCancelledCTNDashboard extends BaseTestClass{
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
	
	@Test(groups = {"RegressionSS","DashboardSS"})
	public void postpaidCancelledCTNDashBoard() throws InterruptedException, IllegalArgumentException, IllegalAccessException {
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc23.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc23.getPassword());
		String strCancelledBAN = TestDataHandler.tc23.getaccountDetails().getBan();
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		//getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
		//		"Login succeed.", 
		//		"Failed to login.");
		getReporter().reportLogWithScreenshot("Cancelled CTN account overview page");
		
		/* ==== Old code  ==================
		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyCancelledCTNAccountAccessLimitedMessage(),
							"CancelledCTNAccountAccessLimitedMessage",
							"CancelledCTNAccountAccessLimitedMessage not displayed");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyAccountOverviewCalcelledWarningUnderYourMobileAccount(),
							"Account Overview Cancelled Warning Under Your Mobile Account",
							"Account Overview Cancelled Warning Under Your Mobile Account  not displayed");
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().reportLogWithScreenshot("Cancelled CTN mid page view of account overview");
		getReporter().hardAssert(getFidoaccountoverviewpage().getCTNUsers().keySet().size()==0,
							"The CTN is not displayed of the cancelled CTN",
							"It seems the CTN is displayed for cancelled CTN, please investigate"); //This will fail for now due to defect {CQ:CQUSR02260935} ALM 197990
		*/
		
		getCommonbusinessflows().scrollToMiddleOfWebPage();
		getReporter().reportLogWithScreenshot("Account overview page Middle Page View");
		getReporter().hardAssert(getFidoaccountoverviewpage().IsAnyCancelledAccountDisplayed(strCancelledBAN),
				"Cancelled account is present",
				"No cancelled account present it seems");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().validateAccountBalanceNotDisplayedForCancelledAccount(strCancelledBAN),
				"Account balance is not displayed for cancelled account",
				"Account balance is displayed for cancelled account");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().validateCancelledBadgeAndThePlacementOfBadgeInAOpage(strCancelledBAN),
				"Cancelled Badge is displayed next to the account type label in the account container",
				" It seems the Cancelled Badge is displayed NOT next to the account type label, please investigate");
			
		getReporter().hardAssert(getFidoaccountoverviewpage().validateViewBillHistoryLink(strCancelledBAN),
				"View bill history link is present for the cancelled account",
				"View Bill history link is not present for the cancelled account");
		
		getReporter().reportLogWithScreenshot("Click on View Bill History Link");
		getFidoaccountoverviewpage().clkViewBillHistoryink(strCancelledBAN);
		//User is directed to the invoice history page successfully as expected
		getReporter().reportLogWithScreenshot("User is directed to the invoice history page successfully as expected ");
		getReporter().hardAssert(getFidoaccountoverviewpage().validateUserIsDirectedToInvoiceHistoryPageSuccessFully(),
				"User is directed to the invoice history page successfully as expected",
				"User is NOT directed to the invoice history page successfully as expected");
		
		
	}

}
