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
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkForgotPassOrNameIframe();
//		getFidologinpage().switchOutOfSignInFrame();
		getReporter().reportLogWithScreenshot("Forgot password or name is clicked.");


		//getFidorecoverpassornamepage().clkBtnUserName();
		String strEmail = TestDataHandler.tc04To09.getaccountDetails().getEmail();
		getFidorecoverpassornamepage().setEmailAddress(strEmail);
		getReporter().reportLogWithScreenshot("Set email for recover user name.");
		getFidorecoverpassornamepage().clkBtnContinue();



		getFidorecoverpassornamepage().clkBtnEmailNowIfAvailable();
		//Go to ENS to verify email and get reset password page.		
		try {
			getEnsverifications().getEmailVerifyPage(strEmail);
		} catch (IOException e) {
			getReporter().reportLogFail("Failed in ENS email verification." + e.toString());
			e.printStackTrace();
		}
		String strUsername = getFidorecoverpassornamepage().getRecoveryUsername();	
		String strPassword = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();
		getReporter().reportLogWithScreenshot("Get recovered username page.");
		getFidorecoverpassornamepage().clkBtnReturnToSignin();
		getReporter().reportLogWithScreenshot("Checking if easy login is displayed");		
		 getReporter().reportLogWithScreenshot("Switching to Sign in frame");
		getFidorecoverpassornamepage().switchToSigninPage(4);
		getReporter().reportLogWithScreenshot("Repointing the URL to QA env");
		getFidohomepage().launchHomePage(System.getProperty("QaUrl"));
		getReporter().reportLogWithScreenshot("URL refreshed");
		getReporter().reportLogWithScreenshot("Checking for Contentful URL");
		if(getFidohomepage().isEasyloginDisplayed())
		{
		 getFidohomepage().clkEasylogin();
		 getReporter().reportLogWithScreenshot("Easy login clicked");
		}
		getReporter().reportLogWithScreenshot("Click Login");
		getFidohomepage().clkLogin(); 
		getReporter().reportLogWithScreenshot("Login button clicked");
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(strUsername);
		getFidologinpage().setPasswordInFrame(strPassword);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();		
		
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{
			strPassword = TestDataHandler.tc04To09.getPassword();
			getFidologinpage().setPasswordInFrame(strPassword);
			getReporter().reportLogWithScreenshot("Login Credential is entered.");
			getFidologinpage().clkLoginInFrame();	
		}
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().softAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Username recovered successfully.",
				"Login failed, please check the recovered username.");
		getReporter().reportLogWithScreenshot("Account overview page.");

	}

}
