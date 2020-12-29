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
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc23.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc23.getPassword());
		String strCancelledBAN = TestDataHandler.tc23.getaccountDetails().getBan();
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		//reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
		//		"Login succeed.", 
		//		"Failed to login.");
		reporter.reportLogWithScreenshot("Cancelled CTN account overview page");
		
		/* ==== Old code  ==================
		
		reporter.hardAssert(fido_account_overview_page.verifyCancelledCTNAccountAccessLimitedMessage(),
							"CancelledCTNAccountAccessLimitedMessage",
							"CancelledCTNAccountAccessLimitedMessage not displayed");
		reporter.hardAssert(fido_account_overview_page.verifyAccountOverviewCalcelledWarningUnderYourMobileAccount(),
							"Account Overview Cancelled Warning Under Your Mobile Account",
							"Account Overview Cancelled Warning Under Your Mobile Account  not displayed");
		fido_account_overview_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("Cancelled CTN mid page view of account overview");
		reporter.hardAssert(fido_account_overview_page.getCTNUsers().keySet().size()==0,
							"The CTN is not displayed of the cancelled CTN",
							"It seems the CTN is displayed for cancelled CTN, please investigate"); //This will fail for now due to defect {CQ:CQUSR02260935} ALM 197990
		*/
		
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Account overview page Middle Page View");
		reporter.hardAssert(fido_account_overview_page.IsAnyCancelledAccountDisplayed(strCancelledBAN),
				"Cancelled account is present",
				"No cancelled account present it seems");
		
		reporter.hardAssert(fido_account_overview_page.validateAccountBalanceNotDisplayedForCancelledAccount(strCancelledBAN),
				"Account balance is not displayed for cancelled account",
				"Account balance is displayed for cancelled account");
		
		reporter.hardAssert(fido_account_overview_page.validateCancelledBadgeAndThePlacementOfBadgeInAOpage(strCancelledBAN),
				"Cancelled Badge is displayed next to the account type label in the account container",
				" It seems the Cancelled Badge is displayed NOT next to the account type label, please investigate");
			
		reporter.hardAssert(fido_account_overview_page.validateViewBillHistoryLink(strCancelledBAN),
				"View bill history link is prsent for the cancelled account",
				"View Bill history link is not present for the cancelled account");
		
		reporter.reportLogWithScreenshot("Click on View Bill History Link");
		fido_account_overview_page.clkViewBillHistoryink(strCancelledBAN);
		//User is directed to the invoice history page successfully as expected
		reporter.reportLogWithScreenshot("User is directed to the invoice history page successfully as expected ");
		reporter.hardAssert(fido_account_overview_page.validateUserIsDirectedToInvoiceHistoryPageSuccessFully(),
				"User is directed to the invoice history page successfully as expected",
				"User is NOT directed to the invoice history page successfully as expected");
		
		
	}

}
