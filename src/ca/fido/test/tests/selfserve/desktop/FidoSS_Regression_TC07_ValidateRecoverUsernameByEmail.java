package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC07_ValidateRecoverUsernameByEmail extends BaseTestClass{	
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void recoverUsernameByEmail() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkForgotPassOrNameIframe();
//		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Forgot password or name is clicked.");
		fido_recover_pass_or_name_page.clkBtnUserName();
		String strEmail = TestDataHandler.tc04To09.getaccountDetails().getEmail();
		fido_recover_pass_or_name_page.setEmailAddress(strEmail);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		fido_recover_pass_or_name_page.clkBtnContinue();
		
		fido_recover_pass_or_name_page.clkBtnEmailNowIfAvailable();
		//Go to ENS to verify email and get reset password page.		
		try {
			ensVerifications.getEmailVerifyPage(strEmail);
		} catch (IOException e) {
			reporter.reportLogFail("Failed in ENS email verification." + e.toString());
			e.printStackTrace();
		}
		String strUsername = fido_recover_pass_or_name_page.getRecoveryUsername();	
		String strPassword = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();
		reporter.reportLogWithScreenshot("Get recovered username page.");
		fido_recover_pass_or_name_page.clkBtnReturnToSignin();
		reporter.reportLogWithScreenshot("Checking if easy login is displayed");		
		 reporter.reportLogWithScreenshot("Switching to Sign in frame");
		fido_recover_pass_or_name_page.switchToSigninPage(4);
		reporter.reportLogWithScreenshot("Repointing the URL to QA env");
		fido_home_page.launchHomePage(System.getProperty("QaUrl"));
		reporter.reportLogWithScreenshot("URL refreshed");
		reporter.reportLogWithScreenshot("Checking for Contentful URL");
		if(fido_home_page.isEasyloginDisplayed())
		{
		 fido_home_page.clkEasylogin();
		 reporter.reportLogWithScreenshot("Easy login clicked");
		}
		reporter.reportLogWithScreenshot("Click Login");
		fido_home_page.clkLogin(); 
		reporter.reportLogWithScreenshot("Login button clicked");
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(strUsername);
		fido_login_page.setPasswordInFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		
		if(fido_login_page.verifyIfErrorMsgIsDisplayedInFrame())
		{
			strPassword = TestDataHandler.tc04To09.getPassword();
			fido_login_page.setPasswordInFrame(strPassword);
			reporter.reportLogWithScreenshot("Login Credential is entered.");
			fido_login_page.clkLoginInFrame();	
		}
		fido_login_page.switchOutOfSignInFrame();
		reporter.softAssert(fido_account_overview_page.verifySuccessfulLogin(),
				"Username recovered successfully.",
				"Login failed, please check the recovered username.");
		reporter.reportLogWithScreenshot("Account overview page.");

	}

}
