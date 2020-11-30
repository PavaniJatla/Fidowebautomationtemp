	package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

/**
 * This Test will update the password from profile and settings page for pre paid account
 * The username cannot be updated for pre paid accounts
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC006_PrepaidUpdateProfile extends BaseTestClass{
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"SanitySS","ProfileAndSettingSS","PrepaidSS"})
	public void prePaidPaymentViewAndEditProfile() throws InterruptedException, ParseException, IOException {
		
		fido_home_page.clkLogin();				
		fido_login_page.switchToSignInFrame();
		String altUserName=TestDataHandler.tc006009.getUsername();
		String altPassword=TestDataHandler.tc006009.getPassword();
		String newPassword="rogers123";//TestDataHandler.tc006009.getaccountDetails().getNewPassword();						
		fido_login_page.setUsernameInFrame(altUserName);
		fido_login_page.setPasswordInFrame(altPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
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
		fido_account_overview_page.clkSubNavProfileAndSettings();
		reporter.reportLogWithScreenshot("menu profile and setting selected");
		reporter.softAssert(!fido_profile_and_setting_page.isChangeUserNameLinkPresent(),
							"The change username link is not displayed for pre-paid accounts",
							"The change username is present for prepaid account");
		fido_profile_and_setting_page.clkChangePassword();				
		fido_profile_and_setting_page.setNewPassword(altPassword, newPassword);		
		reporter.reportLogWithScreenshot("New password set");
		fido_profile_and_setting_page.clkSaveButton();	
		reporter.reportLogWithScreenshot("New password changes saved");
		reporter.reportLogWithScreenshot("New password changes saved");
		common_business_flows.logOutAndResignIn(altUserName,newPassword);			
		reporter.reportLogWithScreenshot("Login with new password performed");
		fido_login_page.switchOutOfSignInFrame();
		reporter.softAssert(fido_account_overview_page.verifySuccessfulLogin(),
							"Login successful with new password.",
							"Login with new password is Not successful");
		
		//rechange to the original one		
		fido_account_overview_page.clkSubNavProfileAndSettings();
		fido_profile_and_setting_page.clkChangePassword();				
		fido_profile_and_setting_page.setNewPassword(newPassword,altPassword);		
		fido_profile_and_setting_page.clkSaveButton();
		reporter.reportLogWithScreenshot("password set back to initial one");		
	}

}
