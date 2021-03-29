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
	
	@Test(groups = {"SanitySS","ProfileAndSettingSS","PrepaidSS","Prepaid"})
	public void prePaidPaymentViewAndEditProfile() throws InterruptedException, ParseException, IOException {
		
		getFidohomepage().clkLogin();				
		getFidologinpage().switchToSignInFrame();
		String altUserName=TestDataHandler.tc006009.getUsername();
		String altPassword=TestDataHandler.tc006009.getPassword();
		String newPassword="rogers123";//TestDataHandler.tc006009.getaccountDetails().getNewPassword();						
		getFidologinpage().setUsernameInFrame(altUserName);
		getFidologinpage().setPasswordInFrame(altPassword);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{	getReporter().reportLogWithScreenshot("Login not successful with user name :"+altUserName+"and password :"+altPassword);		
			String tempPwd=altPassword;
			altPassword=newPassword;
			newPassword=tempPwd;	
			getFidologinpage().setUsernameInFrame(altUserName);
			getFidologinpage().setPasswordInFrame(altPassword);
			getFidologinpage().clkLoginInFrame();
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
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("menu profile and setting selected");
		getReporter().softAssert(!getFidoprofileandsettingpage().isChangeUserNameLinkPresent(),
							"The change username link is not displayed for pre-paid accounts",
							"The change username is present for prepaid account");
		getFidoprofileandsettingpage().clkChangePassword();				
		getFidoprofileandsettingpage().setNewPassword(altPassword, newPassword);		
		getReporter().reportLogWithScreenshot("New password set");
		getFidoprofileandsettingpage().clkSaveButton();	
		getReporter().reportLogWithScreenshot("New password changes saved");
		getReporter().reportLogWithScreenshot("New password changes saved");
		getCommonbusinessflows().logOutAndResignIn(altUserName,newPassword);			
		getReporter().reportLogWithScreenshot("Login with new password performed");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().softAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
							"Login successful with new password.",
							"Login with new password is Not successful");
		
		//rechange to the original one		
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getFidoprofileandsettingpage().clkChangePassword();				
		getFidoprofileandsettingpage().setNewPassword(newPassword,altPassword);		
		getFidoprofileandsettingpage().clkSaveButton();
		getReporter().reportLogWithScreenshot("password set back to initial one");		
	}

}
