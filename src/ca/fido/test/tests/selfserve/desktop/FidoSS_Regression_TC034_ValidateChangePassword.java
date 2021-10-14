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

public class FidoSS_Regression_TC034_ValidateChangePassword extends BaseTestClass{
	
 	

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
	
	
	@Test(groups = {"RegressionSS","ProfileAndSettingSS"})
	public void postPaidPaymentViewAndEditProfileUpdatePassword() throws InterruptedException, ParseException, IOException {

		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();

		String altUserName=TestDataHandler.tc34.getUsername();
		String altPassword=TestDataHandler.tc34.getPassword();
		String newPassword=TestDataHandler.tc34.getaccountDetails().getNewPassword();
		getFidologinpage().setUsernameInFrame(altUserName);
		getFidologinpage().setPasswordInFrame(altPassword);
		getReporter().reportLogWithScreenshot("Login with UserName: "+altUserName+" and Password: "+altPassword);
		getFidologinpage().clkLoginInFrame();		
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{			
			getReporter().reportLogWithScreenshot("Login attempt one not successful, trying with alternate password:"+newPassword);
			String tempPwd=altPassword;			
			altPassword=newPassword;			
			newPassword=tempPwd;				
			getFidologinpage().setUsernameInFrame(altUserName);
			getFidologinpage().setPasswordInFrame(altPassword);
			getReporter().reportLogWithScreenshot("Login with UserName: "+altUserName+" and Password: "+altPassword);
			getFidologinpage().clkLoginInFrame();
			getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with error.");

		}
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("Click performed on profile and settings");
		getFidoprofileandsettingpage().clkChangePassword();				
		getFidoprofileandsettingpage().setNewPassword(altPassword, newPassword);
		getReporter().reportLogWithScreenshot("Password enetered , Old passowrd: "+altPassword+" and New Password: "+newPassword);
		getFidoprofileandsettingpage().clkSaveButton();		
		getCommonbusinessflows().logOutAndResignIn(altUserName,newPassword);
		
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with new password." + newPassword);
		getFidologinpage().switchOutOfSignInFrame();
		//rechange to the original one
		getReporter().reportLogWithScreenshot("Login with new password succeed.");
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getFidoprofileandsettingpage().clkChangePassword();				
		getFidoprofileandsettingpage().setNewPassword(newPassword,altPassword);
		getReporter().reportLogWithScreenshot("Reset password back to default one.");
		getFidoprofileandsettingpage().clkSaveButton();
		getReporter().reportLogWithScreenshot("password reset back");

	}

}
