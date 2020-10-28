package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the Legacy Internet usage for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com.
 *2. Login with valid credentails.
 *3. In Account Overview Page, Click on the Internet Badge.
 *4. Click on the 'View Usage Details' link
 *
 **/

public class RogersCH_TC_046_LegacyInternet_ValidateInternetUsageTest extends BaseTestClass {
	
	@Test(groups = {"SanityCH","RegressionCH","LegacyDashboardCH"})
	public void checkLegacyInternetUsage() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
	 	 rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc46_legacyInternetAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc46_legacyInternetAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		rogers_account_overview_page.selectAccount(TestDataHandler.tc46_legacyInternetAccount.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkLegacyInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		rogers_account_overview_page.clkInternetPopup();
		reporter.hardAssert(rogers_internet_dashboard_page.verifyInternetUsage(),"Verifed the Internet dashboard","Internet dashboard Verification has failed");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

	






	
}