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
 * This test will check the change method of payment functionality
 * works on French and English both
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC071_AO_ValidateSubNav extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
/*
 * 1. Fido.ca up and running
2. The sign-in pop-up will be displayed
3. The account overview page will be displayed with the subnav (Account Overview + Profile & Settings)
Validate:
- Sub Nav have two options Account Overview and Profiles and Settings
- By default sub-nav is selected on Account Overview
4- User will be navigate to Profiles and Settings on old application	
 */
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	

	@Test(groups = {"AccountOverviewSS"})
	public void postPaidChangeMOP() {
		getDriver().get(System.getProperty("QaUrl")+"/self-serve/overview");
		//fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLoginNew(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
				
		reporter.hardAssert(fido_account_overview_page.verifySubNavHasAOandPnSNavigationOptions(),
				"Sub Nav have two options Account Overview and Profiles and Settings",
				"Sub Nav doesnt have two options Account Overview and Profiles and Settings");
		reporter.hardAssert(fido_account_overview_page.verifyAccountOverviewIsOpenByDefault(),
				"By default sub-nav is selected on Account Overview",
				"By default sub-nav is NOT selected on Account Overview");
		fido_account_overview_page.clkSubNavProfileAndSettings();
		reporter.reportLogWithScreenshot("click on profile and settings");
		reporter.hardAssert(fido_account_overview_page.isProfileAndSettingsPageDisplayed(),
				" User will be navigate to Profiles and Settings on old application",
				"It seems User did not navigate to Profiles and Settings on old application");
							
	}
	
	

}
