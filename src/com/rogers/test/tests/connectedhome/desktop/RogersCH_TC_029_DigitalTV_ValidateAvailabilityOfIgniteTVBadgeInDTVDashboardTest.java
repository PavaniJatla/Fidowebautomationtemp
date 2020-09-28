package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to validate Digital TV Dashboard for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login with valid credentails
 *3. In Account Overview Page, Click on the TV Badge.
 *4. Valided
 *
 **/

public class RogersCH_TC_029_DigitalTV_ValidateAvailabilityOfIgniteTVBadgeInDTVDashboardTest extends BaseTestClass {


	@Test(groups = {"RegressionCH","LegacyTVFlowsCH"})
	public void validateAvailabilityOfIgniteTVBadgeInDTVDashboard  () {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.digitalTVAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.digitalTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.digitalTVAccount.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkTVBadge();		

		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		reporter.softAssert(rogers_digital_tv_dashboard_page.verifyBuyNowIgnite(),"Verifed the buy now option","TV dashboard Verification for buy now option has failed");
		rogers_digital_tv_dashboard_page.clkBuyNowIgnite();
		    	
    	reporter.hardAssert(rogers_home_page.verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceability();
    	reporter.reportLogWithScreenshot("Launched the csutomer availability check popup");
		
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		reporter.hardAssert(rogers_home_page.verifyServiceability(),"Verifed the buy now functionality","Inginte TV buy option has failed");
	}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
