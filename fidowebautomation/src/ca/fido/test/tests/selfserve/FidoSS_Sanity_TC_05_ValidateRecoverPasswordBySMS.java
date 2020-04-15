package ca.fido.test.tests.selfserve;

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

public class FidoSS_Sanity_TC_05_ValidateRecoverPasswordBySMS extends BaseTestClass{
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test
	public void tc05ValidateRecoverPassUsingSms() {
		fido_home_page.clkLogin();
		reporter.reportLogWithScreenshot("Login Page");
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkForgotPassOrNameIframe();	
		reporter.reportLogWithScreenshot("Clicked on Forgot Password or username");
		fido_recover_pass_or_name_page.clkBtnPassword();
		reporter.reportLogWithScreenshot("Clicked on password button");
		String strUsername = TestDataHandler.tc04To09.getUsername();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		fido_recover_pass_or_name_page.setEmailAddress(strUsername);
		reporter.reportLogWithScreenshot("Set email id and click button continue");
		fido_recover_pass_or_name_page.clkBtnContinue();		
		reporter.reportLogWithScreenshot("Click on Text as recovery option");
		fido_recover_pass_or_name_page.clkTextToAsRecoveryOption();
		reporter.reportLogWithScreenshot("Click on Text as recovery option");
		String strTestingTab = getDriver().getWindowHandle();
				
		try {
			String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
			String strCode = ensVerifications.getVerifyCode(strPhoneNum);
			
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			reporter.reportLogWithScreenshot("Set code");
			fido_recover_pass_or_name_page.switchToSetCodeIframe();
			fido_recover_pass_or_name_page.setCode(strCode);
			fido_recover_pass_or_name_page.clickVerifyMe();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reporter.reportLogWithScreenshot("Create New Password");
		String strNewPass = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();
		fido_recover_pass_or_name_page.setNewPassword(strNewPass);
		fido_recover_pass_or_name_page.setConfirmPassword(strNewPass);
		reporter.reportLogWithScreenshot("New passwords set");
		fido_recover_pass_or_name_page.clkBtnSetPassword();
		reporter.softAssert(fido_recover_pass_or_name_page.isPasswordRestSuccessIsDisplayed()
				, "Password reset success message is displayed"
				, "Password reset success message not displayed");
		fido_recover_pass_or_name_page.clkLogInToMyAccount();
		//Login with old password:
		fido_recover_pass_or_name_page.switchToDefaultContent();
		fido_login_page.switchToSignInFrame();
		common_business_flows.loginApplication(strUsername, strPassword);		
		if(fido_account_overview_page.verifyLoginFailMsgIframe())
		{			
			reporter.reportLogWithScreenshot("Login attempt one not successful with old password, trying with new password:"+strNewPass);							
			fido_login_page.setUsernameInFrame(strUsername);
			fido_login_page.setPasswordInFrame(strNewPass);
			reporter.reportLogWithScreenshot("Login with UserName: "+strUsername+" and Password: "+strNewPass);
			fido_login_page.clkLoginInFrame();
			reporter.reportLogWithScreenshot("Login successful");
			fido_login_page.switchOutOfSignInFrame();
			reporter.reportLogWithScreenshot("Account overview page");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}else
		{
			reporter.reportLogWithScreenshot("Login successful");
			fido_login_page.switchOutOfSignInFrame();
			reporter.reportLogWithScreenshot("Account overview page");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}
		
		
	
	}
			
}
