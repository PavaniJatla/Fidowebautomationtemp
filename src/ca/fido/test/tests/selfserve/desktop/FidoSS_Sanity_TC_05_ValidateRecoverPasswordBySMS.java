package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Sanity_TC_05_ValidateRecoverPasswordBySMS extends BaseTestClass{
	
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
	
	
	@Test(groups = {"RegressionSS","ProfileAndSettingSS","RecoverSS"})
	public void tc05ValidateRecoverPassUsingSms() {
		//getFidohomepage().clkLogin();
		getReporter().reportLogWithScreenshot("Login Page");
		getFidologinpage().switchToSignInFrame();
		//================  new code ====================
		getFidologinpage().clkForgotPasswordIframe();
		getReporter().reportLogWithScreenshot("Forgot password link is clicked.");
		//getRogersRecoverPassOrNamePage().clkBtnPassword();
		String strUsername = TestDataHandler.tc04To09.getUsername();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		String strAccount = TestDataHandler.tc04To09.getaccountDetails().getBan();
		getFidorecoverpassornamepage().setUsernameIFrame(strUsername);
		getReporter().reportLogWithScreenshot("Set user name for password recovery");
		getFidorecoverpassornamepage().clkBtnContinue();
		//reporter.reportLogWithScreenshot("Click on Text as recovery option");
		//getRogersRecoverPassOrNamePage().clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		//--------------------
		try {


			getReporter().reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
			String strCode = getEnsverifications().getVerifyCode(strPhoneNum);
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			getReporter().reportLogWithScreenshot("Set code");
			getFidorecoverpassornamepage().switchToSetCodeIframe();
			getFidorecoverpassornamepage().setVerificationCode(strCode);
			getFidorecoverpassornamepage().clkBtnContinue();
			getFidorecoverpassornamepage().setNewPassword(strPassword);
			getFidorecoverpassornamepage().setConfirmPassword(strPassword);
			getFidorecoverpassornamepage().clkBtnContinue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		//Login with recovered user name to verify
		getReporter().hardAssert(getFidorecoverpassornamepage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover password flow",
				"passowrd reset NOT successful for recover password flow");
		getReporter().reportLogWithScreenshot("Password success page");
		getFidorecoverpassornamepage().clkGoToMyFido();
		getReporter().reportLogWithScreenshot("Go to my rogers clicked");
		getFidorecoverpassornamepage().switchToDefaultContent();
		getReporter().reportLogWithScreenshot("Switch to default content");
		getReporter().reportLogWithScreenshot("waiting for account overview....");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview");

		//===================  old code ===================================
		/*
		getReporter().reportLogWithScreenshot("Clicked on Forgot Password or username");
		getFidorecoverpassornamepage().clkBtnPassword();
		getReporter().reportLogWithScreenshot("Clicked on password button");
		String strUsername = TestDataHandler.tc04To09.getUsername();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		getFidorecoverpassornamepage().setEmailAddress(strUsername);
		getReporter().reportLogWithScreenshot("Set email id and click button continue");
		getFidorecoverpassornamepage().clkBtnContinue();		
		getReporter().reportLogWithScreenshot("Continue is clicked");
		//flow updated in May 20th release, no need to click text option.
		getFidorecoverpassornamepage().clkTextToAsRecoveryOption();

		String strTestingTab = getDriver().getWindowHandle();
				
		try {
			String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
			String strCode = getEnsverifications().getVerifyCode(strPhoneNum);
			
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			getReporter().reportLogWithScreenshot("Set code");
			getFidorecoverpassornamepage().switchToSetCodeIframe();
			getFidorecoverpassornamepage().setCode(strCode);
			getFidorecoverpassornamepage().clickVerifyMe();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getReporter().reportLogWithScreenshot("Create New Password");
		String strNewPass = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();
		getFidorecoverpassornamepage().setNewPassword(strNewPass);
		getFidorecoverpassornamepage().setConfirmPassword(strNewPass);
		getReporter().reportLogWithScreenshot("New passwords set");
		getFidorecoverpassornamepage().clkBtnSetPassword();
		getReporter().hardAssert(getFidorecoverpassornamepage().isPasswordRestSuccessIsDisplayed()
				, "Password reset success message is displayed"
				, "Password reset success message not displayed");
		getFidorecoverpassornamepage().clkLogInToMyAccount();
		//Login with old password:
		getFidorecoverpassornamepage().switchToDefaultContent();
		getFidologinpage().switchToSignInFrame();
		getCommonbusinessflows().loginApplication(strUsername, strPassword);		
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{			
			getReporter().reportLogWithScreenshot("Login attempt one not successful with old password, trying with new password:"+strNewPass);							
			getFidologinpage().setUsernameInFrame(strUsername);
			getFidologinpage().setPasswordInFrame(strNewPass);
			getReporter().reportLogWithScreenshot("Login with UserName: "+strUsername+" and Password: "+strNewPass);
			getFidologinpage().clkLoginInFrame();
			getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with error.");
			getFidologinpage().switchOutOfSignInFrame();
			getReporter().reportLogWithScreenshot("Account overview page");
			getCommonbusinessflows().resetPasswordBack(strNewPass, strPassword);
		}else
		{
			getReporter().reportLogWithScreenshot("Login successful");
			getFidologinpage().switchOutOfSignInFrame();
			getReporter().reportLogWithScreenshot("Account overview page");
			getCommonbusinessflows().resetPasswordBack(strNewPass, strPassword);
		}
		
		*/
	
	}
			
}
