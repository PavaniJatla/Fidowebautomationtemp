package ca.fido.test.tests.selfserve.mobile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * This Test will update the password from profile and settings page for pre paid account
 * The username cannot be updated for pre paid accounts
 * @author Mirza.Kamran
 *
 */
public class Mobile_FidoSS_Regression_TC006_PrepaidUpdateProfile extends BaseTestClass{
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("sauceandroidchrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"MobileSanitySS"})
	public void mobilePrePaidPaymentViewAndEditProfile() throws InterruptedException, ParseException, IOException {
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navgation card");	
		fido_home_page.clkLoginMobile();
		fido_login_page.switchToSignInFrame();
		String altUserName=TestDataHandler.tc006009.getUsername();
		String altPassword=TestDataHandler.tc006009.getPassword();
		String newPassword=TestDataHandler.tc006009.getaccountDetails().getNewPassword();						
		fido_login_page.setUsernameInFrame(altUserName);
		fido_login_page.setPasswordInFrame(altPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrameMobile();
		if(fido_login_page.verifyIfErrorMsgIsDisplayedInFrame())
		{	reporter.reportLogWithScreenshot("Login not successful with user name :"+altUserName+"and password :"+altPassword);		
			String tempPwd=altPassword;
			altPassword=newPassword;
			newPassword=tempPwd;	
			fido_login_page.setUsernameInFrame(altUserName);
			fido_login_page.setPasswordInFrame(altPassword);
			fido_login_page.clkLoginInFrame();
			reporter.reportLogWithScreenshot("Login attempt with alternate password :"+newPassword);
			reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(),
								"Login successful",
								"Login failed with both password.");
		}
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page.");
		fido_account_overview_page.clkMenuProfileNSettingMobile();
		reporter.reportLogWithScreenshot("menu profile and setting selected");
		fido_profile_and_setting_page.clkButtonLogInDetails();
		reporter.softAssert(!fido_profile_and_setting_page.isChangeUserNameLinkPresent(),
							"The change username link is not displayed for pre-paid accounts",
							"The change username is present for prepaid account");
		fido_profile_and_setting_page.clkChangePasswordMobile();				
		fido_profile_and_setting_page.setNewPassword(altPassword, newPassword);		
		reporter.reportLogWithScreenshot("New password set");
		fido_profile_and_setting_page.clkSaveButtonMobile();	
		reporter.reportLogWithScreenshot("New password changes saved");
		reporter.reportLogWithScreenshot("Starting sign out scenario");
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Clicked Navigation elipsis");
		fido_login_page.clkSignOutMobile();
		reporter.reportLogWithScreenshot("Sign Out clicked.");
		reporter.reportLogWithScreenshot("waiting to check easy login page is avaialable or not...");
		if(fido_home_page.isEasyloginDisplayedMobile())
		{
			reporter.reportLogWithScreenshot("Easy login page is available");
			fido_home_page.clkEasylogin();
		}		
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Navigation menu clicked.");
		fido_login_page.clkResignInAsMobile();
		reporter.reportLogWithScreenshot("Clicked ReSign In");
		fido_login_page.switchToSignInFrame();
		fido_login_page.setPasswordInFrame(newPassword);			
		fido_login_page.clkLoginInFrame();
		reporter.reportLogWithScreenshot("Login with new password performed");
		fido_login_page.switchOutOfSignInFrame();
		reporter.softAssert(fido_account_overview_page.verifySuccessfulLogin(),
							"Login successful with new password.",
							"Login with new password is Not successful");
		
		//rechange to the original one		
		fido_account_overview_page.clkMenuProfileNSettingMobile();
		fido_profile_and_setting_page.clkButtonLogInDetails();
		fido_profile_and_setting_page.clkChangePasswordMobile();				
		fido_profile_and_setting_page.setNewPassword(newPassword,altPassword);		
		fido_profile_and_setting_page.clkSaveButton();
		reporter.reportLogWithScreenshot("password set back to initial one");
	}

}
