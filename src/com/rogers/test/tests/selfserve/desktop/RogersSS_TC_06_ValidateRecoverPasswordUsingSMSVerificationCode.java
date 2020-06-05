package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;


public class RogersSS_TC_06_ValidateRecoverPasswordUsingSMSVerificationCode extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validateRecoverUsernameUsingSMSVerificationCode() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn();
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clkForgotPassOrNameIframe();							
		reporter.reportLogWithScreenshot("Forgot password or name is clicked.");
		rogers_recover_pass_or_name.clkBtnPassword();
		String strUsername = TestDataHandler.tc040609.getUsername();
		String strPassword = TestDataHandler.tc040609.getPassword();
		String strAccount = TestDataHandler.tc040609.getAccountDetails().getBan();			
		rogers_recover_pass_or_name.setEmailAddress(strUsername);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();	
		reporter.reportLogWithScreenshot("Click on Text as recovery option");
		rogers_recover_pass_or_name.clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();						
		//--------------------
		try {
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc040609.getAccountDetails().getRecoveryNumber();
			String strCode = ensVerifications.getVerifyCode(strPhoneNum);			
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			reporter.reportLogWithScreenshot("Set code");
			rogers_recover_pass_or_name.switchToSetCodeIframe();
			rogers_recover_pass_or_name.setCode(strCode);
			rogers_recover_pass_or_name.clickVerifyMe();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reporter.reportLogWithScreenshot("Create New Password");
		String strNewPass = TestDataHandler.tc040609.getAccountDetails().getNewpassword();
		rogers_recover_pass_or_name.setNewPassword(strNewPass);
		rogers_recover_pass_or_name.setConfirmPassword(strNewPass);
		reporter.reportLogWithScreenshot("New passwords set");
		rogers_recover_pass_or_name.clkBtnSetPassword();
		reporter.softAssert(rogers_recover_pass_or_name.isPasswordRestSuccessIsDisplayed()
				, "Password reset success message is displayed"
				, "Password reset success message not displayed");
		rogers_recover_pass_or_name.clkLogInToMyAccount();
		//Login with old password:
		rogers_recover_pass_or_name.switchToDefaultContent();
		rogers_login_page.switchToSignInIFrame();
		common_business_flows.loginApplication(strUsername, strPassword);				
		if(rogers_login_page.verifyLoginFailMsgIframe())
		{			
			reporter.reportLogWithScreenshot("Login attempt one not successful with old password, trying with new password:"+strNewPass);							
			rogers_login_page.setUsernameIFrame(strUsername);
			rogers_login_page.setPasswordIFrame(strNewPass);
			reporter.reportLogWithScreenshot("Login with UserName: "+strUsername+" and Password: "+strNewPass);
			rogers_login_page.clkSignInIFrame();
			rogers_login_page.clkSkipIFrame();
			rogers_login_page.switchOutOfSignInIFrame();
			 if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
		        	reporter.reportLogWithScreenshot("Select an account.");
		        	rogers_account_overview_page.selectAccount(strAccount);
		        }
			reporter.reportLogWithScreenshot("Account overview page.");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}else
		{
			rogers_login_page.clkSkipIFrame();
			rogers_login_page.switchOutOfSignInIFrame();
			 if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
		        	reporter.reportLogWithScreenshot("Select an account.");
		        	rogers_account_overview_page.selectAccount(strAccount);
		        }
			reporter.reportLogWithScreenshot("Account overview page.");
			reporter.reportLogFail("Its seems the reset password didnt work correctly, please investigate");
			reporter.reportLogWithScreenshot("Login successful");
			rogers_login_page.switchOutOfSignInIFrame();
			reporter.reportLogWithScreenshot("Account overview page");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}
		
		
	}

}