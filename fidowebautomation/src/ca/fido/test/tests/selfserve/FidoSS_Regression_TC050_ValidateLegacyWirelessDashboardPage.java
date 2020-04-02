package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * The test will verify post paid account data and talk usage section of wireless dash board,
 * the test will be run for account which has Data, Talk & Text plan.
 * The test include both scenarios of limited talk or unlimited talk.
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC050_ValidateLegacyWirelessDashboardPage extends BaseTestClass{
			 	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validatePostPaidDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		fido_home_page.clkLogin();
		String userName = TestDataHandler.tc5055.getUsername();
		String password = TestDataHandler.tc5055.getPassword();		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login page, user name and password are set.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Clicked on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		
		reporter.reportLogWithScreenshot("dashboard page loaded");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDataDashBoardSectionDataBalanceRemainingIsDisplayed(),
							"Dashboard Section Data Balance Remaining Is Displayed",
							"Dashboard section data balance remaining is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDataDashBoardUsageBarIsDisplayed(),
							"Data usage bar is displayed",
							"Data usage bar is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataInUsageSectionIsDisplayed(),
							"Total Data in usage Section is displayed",
							"Total Data in usage section is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLabelDataDelayedIsDisplayed(),
							"Message data delayed is displayed for full plan dashboard",
							"Message data delayed is not displayed for full plan dashboard, please investigate");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDaysRemainingInBillCycleIsDisplayed(),
							"Days remaining in bill cycle is displayed for Non demo line account",
							"Days remaining in bill cycle is not displayed for non-demoline account");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkNTextUsageModuleIsDisplayed(),
							"Talk & Text usage module is displayed",
							"Talk & Text usage module is not displayed, please investigate");

		reporter.reportLogWithScreenshot("Wireless dashboard page usage section is displayed");

		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkUsageSectionofFullPlanIsDisplayed(),
							"Talk usage details section is displayed for full plan dashboard",
							"Talk usage details section is not displayed for full plan dashboard, please investigate");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTextUsageDetailsOfFullPlanIsDisplayed(),
							"Text usage details section is displayed for full plan dashboard",
							"Text usage details section is not displayed for full plan dashboard, please investigate");	
			
	}
	
}
