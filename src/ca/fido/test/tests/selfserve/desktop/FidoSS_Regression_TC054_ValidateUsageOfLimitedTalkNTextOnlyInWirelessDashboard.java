package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

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
 * The test will verify post paid account talk and text usage section on wireless dash board,
 * the test will run for account which has Talk and Text plan.
 * This test include both scenarios of limited or unlimited Talk and Text plan.
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC054_ValidateUsageOfLimitedTalkNTextOnlyInWirelessDashboard extends BaseTestClass{
	 	
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
	public void validateLimitedTalkNTextUsageinWirelessDashboard(){
		reporter.reportLogWithScreenshot("DashBoard Talk and Text Usage verification started");
		fido_home_page.clkLogin();
		String userName = TestDataHandler.tc54.getUsername();
		String password = TestDataHandler.tc54.getPassword();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login page, user name and password are set.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();

		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyTalkNTextUsageModuleIsDisplayed(),
							"Talk usage module is displayed",
							"Talk usage module is not displayed");
		reporter.reportLogWithScreenshot("Wireless dashboard page");

		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkUsageDetailsofTalkTextOnlyPlanIsDisplayed(),
							"Talk usage details section is displayed",
							"Talk usage details section is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkAnytimeUsageDetailsIsDisplayed(),
		//					"Talk anytime usage details section is displayed",
		//					"Talk anytime usage details section is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkEveningUsageDetailsIsDisplayed(),
		//					"Talk evening and weekend usage details section is displayed",
		//					"Talk evening and weekend usage details section is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTalkRemainingMinutesIsDisplayed(),
							"Talk usage detail is checked successfully.",	
							"Talk usage detail has issue, please investigate.");
		
		

		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTextRemainingMinutesIsDisplayed(),
							"Text usage details section is displayed",
							"Text usage details section is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyPictureMsgDetailsIsDisplayed(),
		//					"Text usage details picture message part is displayed",
		//					"Text usage details picture message part is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyBundlesMsgDetailsIsDisplayed(),
							//"Text usage details bundles message part is displayed",
							//"Text usage details bundles message part is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyInternationalMsgDetailsIsDisplayed(),
		//					"Text usage details international message part is displayed",
		//					"Text usage details international message part is not displayed");
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyDaysRemainingInBillCycleIsDisplayed(),
							"Days remaining in bill cycle for Talk&Text plan is displayed",
							"Days remaining in bill cycle for Talk&Text plan is not displayed");

		fido_wireless_dashboard_postpaid_page.scrollToBottomOfPage();
		reporter.reportLogWithScreenshot("Wireless Dashboad bottom view");
			
	}
	
}
