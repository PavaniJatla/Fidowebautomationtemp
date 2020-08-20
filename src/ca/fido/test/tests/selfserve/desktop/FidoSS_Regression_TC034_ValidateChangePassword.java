package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
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

public class FidoSS_Regression_TC034_ValidateChangePassword extends BaseTestClass{
	
 	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test
	public void postPaidPaymentViewAndEditProfileUpdatePassword() throws InterruptedException, ParseException, IOException {

		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();

		String altUserName=TestDataHandler.tc34.getUsername();
		String altPassword=TestDataHandler.tc34.getPassword();
		String newPassword=TestDataHandler.tc34.getaccountDetails().getNewPassword();
		fido_login_page.setUsernameInFrame(altUserName);
		fido_login_page.setPasswordInFrame(altPassword);
		reporter.reportLogWithScreenshot("Login with UserName: "+altUserName+" and Password: "+altPassword);
		fido_login_page.clkLoginInFrame();		
		if(fido_login_page.verifyIfErrorMsgIsDisplayedInFrame())
		{			
			reporter.reportLogWithScreenshot("Login attempt one not successful, trying with alternate password:"+newPassword);
			String tempPwd=altPassword;			
			altPassword=newPassword;			
			newPassword=tempPwd;				
			fido_login_page.setUsernameInFrame(altUserName);
			fido_login_page.setPasswordInFrame(altPassword);
			reporter.reportLogWithScreenshot("Login with UserName: "+altUserName+" and Password: "+altPassword);
			fido_login_page.clkLoginInFrame();
			reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with error.");

		}
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkMenuProfileNSetting();
		reporter.reportLogWithScreenshot("Click performed on profile and settings");
		fido_profile_and_setting_page.clkChangePassword();				
		fido_profile_and_setting_page.setNewPassword(altPassword, newPassword);
		reporter.reportLogWithScreenshot("Password enetered , Old passowrd: "+altPassword+" and New Password: "+newPassword);
		fido_profile_and_setting_page.clkSaveButton();
		fido_login_page.clkSignOut();
		reporter.reportLogWithScreenshot("Sign out done");
		fido_login_page.clkResignInAs();
		reporter.reportLogWithScreenshot("Click Re Sign In");
		fido_login_page.switchToSignInFrame();
		fido_login_page.setPasswordInFrame(newPassword);
		reporter.reportLogWithScreenshot("Verify login with new password.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with new password." + newPassword);
		fido_login_page.switchOutOfSignInFrame();
		//rechange to the original one
		reporter.reportLogWithScreenshot("Login with new password succeed.");
		fido_account_overview_page.clkMenuProfileNSetting();
		fido_profile_and_setting_page.clkChangePassword();				
		fido_profile_and_setting_page.setNewPassword(newPassword,altPassword);
		reporter.reportLogWithScreenshot("Reset password back to default one.");
		fido_profile_and_setting_page.clkSaveButton();
		reporter.reportLogWithScreenshot("password reset back");

	}

}
