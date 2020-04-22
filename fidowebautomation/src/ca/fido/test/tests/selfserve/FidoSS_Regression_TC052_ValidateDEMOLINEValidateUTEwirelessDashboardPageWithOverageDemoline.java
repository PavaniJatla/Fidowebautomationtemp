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
1. Navigate to Fido.ca
2. Click on sign in with proper credentials
3. Click on CTN
4. Validate wireless Dashboard
1. Fido.ca landing page is opened successfully
2. Account Overview page is landed successfully
3. Wireless Dashboard page displayed successfully
4. Dashboard displayed with usage details
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC052_ValidateDEMOLINEValidateUTEwirelessDashboardPageWithOverageDemoline extends BaseTestClass{
			 	
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
	public void validateRegressionDemolineValidateUTEwirelessDashboardPageWithRunningLowStateDemoline() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		reporter.reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		fido_home_page.clkLogin();
		String userName = "";
		String password = "";
	
		userName = TestDataHandler.tc53.getUsername();
		password = TestDataHandler.tc53.getPassword();		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		reporter.reportLogWithScreenshot("dashboard page loaded");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDataDashBoardSectionDataBalanceRemainingIsDisplayed(),
							"Dashboard Section Data Balance Is Displayed",
							"Dashboard section data balance not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDataDashBoardUsageBarIsDisplayed(),
							"usage bar is displayed",
							"usage bar is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataInUsageSectionIsDisplayed(),
							"Data Section is displayed",
							"Data section is not displayed");
		reporter.softAssert(!fido_wireless_dashboard_postpaid_page.verifyLabelDataDelayedIsDisplayed(),
							"Data delay message didn't display.",
							"Data delay message displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDaysRemainingInBillCycleIsDisplayed(),
							"Label N days reming for Bill cycle is displayed",
							"Label N days remaining for Bill cycle is not displayed");
	
		reporter.reportLogWithScreenshot("Demo Line account dashboard page is displayed");
		//Check the data usage overage 
	
		fido_wireless_dashboard_postpaid_page.clkLinkViewDetailInUsage();
		reporter.softAssert(fido_data_management_page.verifyManageDataOverlayDisplayed(),
				"Manage data overlay is displayed",
				"Manage data overlay is not displayed");	
		fido_data_management_page.clkLinkBackOnManageDataOverlay();
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkPlanDetailsSectionIsDisplayed(),
				"Talk plan details section is displayed",
				"Talk plan details section is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTextPlanDetailsSectionIsDisplayed(),
						"Text plan details section is displayed",
						"Text plan details section is not displayed");
			
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyMyMobilePlanDashBoardSectionIsDisplayed(),
						"My Mobile plan dashboard section is displayed",
						"My mobile plan details section is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLinkViewFullPlanDetailsOnMyMobilePlanDashBoardSectionIsDisplayed(),
						"Link View Flull plan details is displayed on My mobile plan section",
						"Link View Flull plan details is NOT displayed on My mobile plan section");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyButtonChangePlanMyMobilePlanDashBoardSectionIsDisplayed(),
						"Button Change Plan MyMobilePlan DashBoard Section IsDisplayed",
						"Button Change Plan MyMobilePlan DashBoard Section Is NOT Displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyPlanBenefitsInMyMobilePlanDashBoardSectionIsDisplayed(),
						"PlanBenefits In My MobilePlan DashBoard Section Is Displayed",
						"PlanBenefits In MyMobilePlan DashBoard Section Is NOT Displayed");			
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyMyDeviceDetails(),
						"My device details is displayed",
						"My device details is not displayed");				
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyViewFullPlanDetails(),
						"Full Plan details is displayed",
						"Full plan details is not displayed");		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLinkChangeCalldisplayNameIsDisplayed(),
						"Link change display name is displayed",
						"Link change displaye name is not displayed");		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLinkChangeMyNumberIsDisplayed(),
						"Link change my number is displayed",
						"Link change my numebr is not displayed");	
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLinkReportLostOrStolenIsDisplayed(),
						"Link report lost or stolen is displayed",
						"Link report lost or stolen is not displayed");		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLinkRetrievePUKCodeIsDisplayed(),
						"Link Retrevive PUK code is dsiplayed",
						"Link Retreive PUK code is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyLinkUpdateSIMCardIsDisplayed(),
						"Link Update SIM card is displayed",
						"Link update SIM card is not displayed");
		fido_wireless_dashboard_postpaid_page.scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Dashboad mid veiw");
		fido_wireless_dashboard_postpaid_page.scrollToBottomOfPage();
		reporter.reportLogWithScreenshot("Dashboad bottom veiw");
	}
	
}
