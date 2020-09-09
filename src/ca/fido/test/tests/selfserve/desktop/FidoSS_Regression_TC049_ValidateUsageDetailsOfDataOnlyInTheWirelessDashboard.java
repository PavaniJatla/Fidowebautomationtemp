package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * The test will verify post paid account data usage section of wireless dash board,
 * the test will be run for account which has data only plan.
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC049_ValidateUsageDetailsOfDataOnlyInTheWirelessDashboard extends BaseTestClass{
			 	
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
	public void validateUsageDetailOfDataOnly() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		fido_home_page.clkLogin();	
		String userName = TestDataHandler.tc49.getUsername();
		String password = TestDataHandler.tc49.getPassword();		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login page, user name and password are set.");
		fido_login_page.clkLoginInFrame();		
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		
		reporter.reportLogWithScreenshot("dashboard page loading");
		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyDataDashBoardSectionDataBalanceRemainingIsDisplayed(),
							"Dashboard Section Data Balance Is Displayed",
							"Dashboard section data balance not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDataDashBoardUsageBarIsDisplayed(),
							"usage bar is displayed",
							"usage bar is not displayed");
		
		reporter.reportLogWithScreenshot("dashboard page usage section loaded.");
		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataInUsageSectionIsDisplayed(),
							"Data Section is displayed",
							"Data section is not displayed");		
		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLabelDataDelayedIsDisplayed(),
							"label data delayed is displayed for Non demo line account",
							"label data delayed is not displayed for non-demoline account");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDaysRemainingInBillCycleIsDisplayed(),
							"Days remaining in bill cycle is displayed for Non demo line account",
							"Days remaining in bill cycle is not displayed for non-demoline account");
			
	}
	
}
