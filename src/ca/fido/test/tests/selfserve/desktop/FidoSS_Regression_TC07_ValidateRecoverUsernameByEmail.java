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
	public void recoverUsernameByEmail() throws IOException {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		//=============== new code ===================

		getFidologinpage().clkForgotUsernameIframe();
		getReporter().reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc04To09.getUsername();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		//getRogersRecoverPassOrNamePage().clkBtnUserName();
		getFidorecoverpassornamepage().setEmailAddress(strUserName);
		getReporter().reportLogWithScreenshot("Set email for recover user name.");
		getFidorecoverpassornamepage().clkBtnContinue();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.

		getEnsverifications().getEmailVerifyPage(strUserName);
		getReporter().reportLogWithScreenshot("Get recovery code");
		String recoveryCode = getFidorecoverpassornamepage().getVerificationCode();
		getDriver().switchTo().window(strTestingTab);
		getFidorecoverpassornamepage().switchToSetCodeIframe();
		getFidorecoverpassornamepage().setVerificationCode(recoveryCode);
		getReporter().reportLogWithScreenshot("Set recovery code");
		getFidorecoverpassornamepage().clkBtnContinue();
		strRecoveredUserName= getFidorecoverpassornamepage().getRecoveryUsernameNew();
		getReporter().reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName.trim());

		getReporter().hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The recovered username is correct",
				"The recovered username is incorrect");
		getFidorecoverpassornamepage().setNewPassword(strPassword);
		getFidorecoverpassornamepage().setConfirmPassword(strPassword);
		getReporter().reportLogWithScreenshot("Reset Password page");
		getFidorecoverpassornamepage().clkBtnContinue();
		//Login with recovered user name to verify
		getReporter().hardAssert(getFidorecoverpassornamepage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		getReporter().reportLogWithScreenshot("Password success page");
		getFidorecoverpassornamepage().clkGoToMyFido();
		getReporter().reportLogWithScreenshot("Go to my rogers clicked");
		getFidorecoverpassornamepage().switchToDefaultContent();
		setImplicitWait(getDriver(), 5);
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview");



		//================  old code ================
		/*
		getFidologinpage().clkForgotPassOrNameIframe();
//		getFidologinpage().switchOutOfSignInFrame();
		getReporter().reportLogWithScreenshot("Forgot password or name is clicked.");
		getFidorecoverpassornamepage().clkBtnUserName();
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
	*/
	}

}
