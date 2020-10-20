package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



/**
 * This class contains the test method to test the pay now functionality for Fido.ca   
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Load fido.ca url.
 *2. Login with valid credentials
 *3. Click on internet badge in account overview page
 *4. Package details is displayed and click on View/Change package
 *
 **/

public class FidoCH_Regression_TC_009_HSIValidateDashboardTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","FidoHSIDashboardCH"})
	public void checkFidoHSIValidateDashboard() {

		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentials");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_account_overview_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_account_overview_page.clkInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		reporter.softAssert(fido_internet_dashboard_page.verifyManageSettings(),"Verified the Manage Settings link","Manage Settings link Verification has failed");
    	reporter.softAssert(fido_internet_dashboard_page.verifyIfPlanInformationLoaded(),"Verified the Plan Information Loaded link","Plan Information Loaded link Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfUsageInfoDisplayed(),"Verified the Data Usage summary","Data Usage summary Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfDailyUsageLinkVisible(),"Verified Daily Usage link","Daily Usage link Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfMonthlyUsageLinkVisible(),"Verified Monthly Usage link","Monthly Usage link Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfChangePackageLinkVisible(),"Verified Change Package link","Change Package link Verification has failed");
		reporter.reportLogWithScreenshot("Internet Dashboard Page");
	}

	@BeforeMethod (alwaysRun = true)
	@Parameters({ "strBrowser","strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
