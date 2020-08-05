package ca.fido.test.tests.selfserve.desktop;

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
1. Navigate to Fido.ca
2. login with valid credentials.
3. Click on Usage and service tab 
4. Validate Data Overage details 

1. Fido.ca landing page is opened successfully.
2. Account overview page must be displayed.
3. Usage and service page should be displayed.
4. Data overage size, call out message and Overage details should be displayed


 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC66_RegressionFidoValidateDataUsageDisplayInOveragePostpaidVoiceAndDatePlan extends BaseTestClass{
			 	
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
	public void validateDemolineValidateUTEwirelessDashboardPageWithOverageDemoline() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		reporter.reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		fido_home_page.clkLogin();
		String userName = "";
		String password = "";
	
		userName = TestDataHandler.tc66.getUsername();
		password = TestDataHandler.tc66.getPassword();		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
//		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		reporter.reportLogWithScreenshot("dashboard page loaded");
		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyYouHaveAnOverageUsageBarOrGradientIsDisplayed(),
						"Data overage usage  gradient is displayed",
						"Data overage usage gradient is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLabelDataOverageSizeIsDisplayed(),
						"Data overage size is displayed",
						"Data overage size is not displayed");
		reporter.reportLogWithScreenshot("Attention Exclamation symbol for overage");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyAttentionOverageSymbolIsDisplayed(),
						"Attention Exclamation symbol is displayed for overage", 
						"Attention Exclamation symbol is not displayed for overage");		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkPlanDetailsSectionIsDisplayed(),
						"Talk plan is displayed",
						"Talk plan is not displayed");		
					
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataInUsageSectionIsDisplayed(),
						"Data Section is displayed",
						"Data section is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLabelDataDelayedIsDisplayed(),
						"Data delay message display.",
						"Data delay message didn't displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDaysRemainingInBillCycleIsDisplayed(),
						"Label N days reming for Bill cycle is displayed",
						"Label N days remaining for Bill cycle is not displayed");
		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDaysRemainingInBillCycleIsDisplayed(),
						"Days remaining in bill cycle",
						"Days remaining in bill cycle is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkNTextUsageModuleIsDisplayed(),
						"Talk & Text usage module is displayed",
						"Talk & Text usage module is not displayed, please investigate");			
		
	}
	
}
