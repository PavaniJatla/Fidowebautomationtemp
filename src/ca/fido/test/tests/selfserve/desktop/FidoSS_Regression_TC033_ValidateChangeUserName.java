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

public class FidoSS_Regression_TC033_ValidateChangeUserName extends BaseTestClass{
	
 	

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
	public void postPaidPaymentViewAndEditProfileUpdateUserName() throws InterruptedException, ParseException, IOException {
		
		//First attempt
		//first login attempt with change Username credentials
		reporter.reportLogWithScreenshot("View and Update UserName");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		String oldUserName=TestDataHandler.tc33.getUsername();
		String password=TestDataHandler.tc33.getPassword();
		String newUserName=TestDataHandler.tc33.getNewUsername();
		fido_login_page.setUsernameInFrame(oldUserName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		if(fido_login_page.verifyIfErrorMsgIsDisplayedInFrame())
		{
			reporter.reportLogWithScreenshot("Login attempt one not successful, trying attempt two");
			//second attempt
			//switch the login name with the new username and attempt again
			String tempUser=oldUserName;			
			oldUserName=newUserName;
			newUserName=tempUser;
			
			fido_login_page.setUsernameInFrame(oldUserName);
			fido_login_page.setPasswordInFrame(password);
			reporter.reportLogWithScreenshot("Login Credential is entered.");
			fido_login_page.clkLoginInFrame();									
			reporter.reportLogWithScreenshot("Login attempt two submitted.");
			reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with error.");
			
		}
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page.");
		//Update userName
		fido_account_overview_page.clkMenuProfileNSetting();
		reporter.reportLogWithScreenshot("Profile and settings page");
		fido_profile_and_setting_page.clkChangeUserName();			
		fido_profile_and_setting_page.setNewUserName(newUserName);
		reporter.reportLogWithScreenshot("New username is entered.");
		fido_profile_and_setting_page.clkSaveButton();		
		reporter.hardAssert(fido_profile_and_setting_page.verifyUserNameUpdatedSuccessFullyOnProfileAndSettingsPg(newUserName),
							"Username updated successfully",
							"Username did not update successfully");
		reporter.reportLogWithScreenshot("Username updated successfully");
		fido_login_page.clkSignOut();
		reporter.reportLogWithScreenshot("Sign Out");
		if(fido_home_page.isEasyloginDisplayed())
		{
		 fido_home_page.clkEasylogin();
		}
		
		fido_login_page.clkResignInAs();
		reporter.reportLogWithScreenshot("Re Sign In");		
		fido_login_page.switchToSignInFrame();
		fido_home_page.clkNotUser();
		fido_login_page.setUsernameInFrame(newUserName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login with new username Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with new username.");
		fido_login_page.switchOutOfSignInFrame();
		
		//reset back		
		if(!newUserName.equalsIgnoreCase(oldUserName))
		{
			fido_account_overview_page.clkMenuProfileNSetting();
			fido_profile_and_setting_page.clkChangeUserName();					
			fido_profile_and_setting_page.setNewUserName(oldUserName);
			reporter.reportLogWithScreenshot("Change username back to the old one.");
			fido_profile_and_setting_page.clkSaveButton();
			reporter.hardAssert(fido_profile_and_setting_page.verifyUserNameUpdatedSuccessFullyOnProfileAndSettingsPg(oldUserName),
								"Username is successfully reset back",
								"User name reset not successful");			
			reporter.reportLogWithScreenshot("Change user name back is done.");
		}
				
	}	
	
}
