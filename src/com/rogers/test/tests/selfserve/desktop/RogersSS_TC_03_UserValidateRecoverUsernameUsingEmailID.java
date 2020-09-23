package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_03_UserValidateRecoverUsernameUsingEmailID extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"RegressionSS","ProfileAndSettingsSS"})
	public void userValidateRecoverUsernameUsingEmailID() {
		
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn(); 
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clkForgotUsernameIframe();							
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		
		//rogers_recover_pass_or_name.clkBtnUserName();
		String strEmail = TestDataHandler.tc03.getAccountDetails().getContactemail();
		String strBan = TestDataHandler.tc03.getAccountDetails().getBan();
		rogers_recover_pass_or_name.setEmailAddress(strEmail);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();
		String strUsername =  null;
		//Go to ENS to verify email and get reset password page.		
		try {
			
			ensVerifications.getEmailVerifyPage(strEmail);
									
		} catch (Exception e) {
			reporter.hardAssert(false,"","Failed in ENS email verification." + e.toString());
			e.printStackTrace();
		}
		strUsername = rogers_recover_pass_or_name.getRecoveryUsername();
		String strPassword = TestDataHandler.tc03.getPassword();
		reporter.reportLogWithScreenshot("Get recovered username page.");
		rogers_recover_pass_or_name.clkBtnReturnToSignin();	
		rogers_recover_pass_or_name.switchToSigninPage(3);
		rogers_home_page.launchHomePage(TestDataHandler.ssConfig.getRogersURL());
		rogers_home_page.clkSignIn(); 
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	
			rogers_account_overview_page.selectAccount(strBan);       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		
						
	}

}