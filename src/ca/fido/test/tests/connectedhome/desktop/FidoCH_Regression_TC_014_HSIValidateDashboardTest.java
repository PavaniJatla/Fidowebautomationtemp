package ca.fido.test.tests.connectedhome.desktop;

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

public class FidoCH_Regression_TC_014_HSIValidateDashboardTest extends BaseTestClass {

	@Test
	public void checkFidoHSIValidateDashboard() {
		reporter.reportLogWithScreenshot("Launched Easy login Page");
		fido_home_page.clkEasylogin();
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentails");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_account_overview_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_account_overview_page.clkInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		reporter.softAssert(fido_internet_dashboard_page.verifyManageSettings(),"Verifed the Manage Settings link","Manage Settings link Verification has failed");
    	reporter.softAssert(fido_internet_dashboard_page.verifyIfPlanInformationLoaded(),"Verifed the Plan Information Loaded link","Plan Information Loaded link Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfUsageInfoDisplayed(),"Verifed the Data Usage summary","Data Usage summary Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfDailyUsageLinkVisible(),"Verifed Daily Usage link","Daily Usage link Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfMonthlyUsageLinkVisible(),"Verifed Monthly Usage link","Monthly Usage link Verification has failed");
		reporter.softAssert(fido_internet_dashboard_page.verifyIfChangePackageLinkVisible(),"Verifed Change Package link","Change Package link Verification has failed");
		reporter.reportLogWithScreenshot("Internet Dashboard Page");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.chConfig.getFidoURL(), strBrowser,strLanguage,FidoEnums.GroupName.connectedhome_login, method);

	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}