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
		getFidohomepage().clkNavMobile();
		getReporter().reportLogWithScreenshot("Launched the Navgation card");	
		getFidohomepage().clkLoginMobile();
		getFidologinpage().switchToSignInFrame();
		String altUserName=TestDataHandler.tc006009.getUsername();
		String altPassword=TestDataHandler.tc006009.getPassword();
		String newPassword=TestDataHandler.tc006009.getaccountDetails().getNewPassword();						
		getFidologinpage().setUsernameInFrame(altUserName);
		getFidologinpage().setPasswordInFrame(altPassword);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrameMobile();
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{	getReporter().reportLogWithScreenshot("Login not successful with user name :"+altUserName+"and password :"+altPassword);		
			String tempPwd=altPassword;
			altPassword=newPassword;
			newPassword=tempPwd;	
			getFidologinpage().setUsernameInFrame(altUserName);
			getFidologinpage().setPasswordInFrame(altPassword);
			getFidologinpage().clkLoginInFrameMobile();
			getReporter().reportLogWithScreenshot("Login attempt with alternate password :"+newPassword);
			getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(),
								"Login successful",
								"Login failed with both password.");
		}
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page.");
		getFidoaccountoverviewpage().clkMenuProfileNSettingMobile();
		getReporter().reportLogWithScreenshot("menu profile and setting selected");
		getFidoprofileandsettingpage().clkButtonLogInDetails();
		getReporter().softAssert(!getFidoprofileandsettingpage().isChangeUserNameLinkPresent(),
							"The change username link is not displayed for pre-paid accounts",
							"The change username is present for prepaid account");
		getFidoprofileandsettingpage().clkChangePasswordMobile();				
		getFidoprofileandsettingpage().setNewPassword(altPassword, newPassword);		
		getReporter().reportLogWithScreenshot("New password set");
		getFidoprofileandsettingpage().clkSaveButtonMobile();	
		getReporter().reportLogWithScreenshot("New password changes saved");
		
		getCommonbusinessflows().logOutAndResignInMobile(altUserName, newPassword);
		
		getReporter().softAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
							"Login successful with new password.",
							"Login with new password is Not successful");
		
		//rechange to the original one		
		getFidoaccountoverviewpage().clkMenuProfileNSettingMobile();
		getFidoprofileandsettingpage().clkButtonLogInDetails();
		getFidoprofileandsettingpage().clkChangePasswordMobile();				
		getFidoprofileandsettingpage().setNewPassword(newPassword,altPassword);		
		getFidoprofileandsettingpage().clkSaveButtonMobile();
		getReporter().reportLogWithScreenshot("password set back to initial one");
	}

}
