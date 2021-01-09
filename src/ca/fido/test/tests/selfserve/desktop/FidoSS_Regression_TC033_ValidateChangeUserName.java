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

public class FidoSS_Regression_TC033_ValidateChangeUserName extends BaseTestClass{
	
 	

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
	public void postPaidPaymentViewAndEditProfileUpdateUserName() throws InterruptedException, ParseException, IOException {
		
		//First attempt
		//first login attempt with change Username credentials
		getReporter().reportLogWithScreenshot("View and Update UserName");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		String oldUserName=TestDataHandler.tc33.getUsername();
		String password=TestDataHandler.tc33.getPassword();
		String newUserName=TestDataHandler.tc33.getNewUsername();
		getFidologinpage().setUsernameInFrame(oldUserName);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();		
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{
			getReporter().reportLogWithScreenshot("Login attempt one not successful, trying attempt two");
			//second attempt
			//switch the login name with the new username and attempt again
			String tempUser=oldUserName;			
			oldUserName=newUserName;
			newUserName=tempUser;
			
			getFidologinpage().setUsernameInFrame(oldUserName);
			getFidologinpage().setPasswordInFrame(password);
			getReporter().reportLogWithScreenshot("Login Credential is entered.");
			getFidologinpage().clkLoginInFrame();									
			getReporter().reportLogWithScreenshot("Login attempt two submitted.");
			getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with error.");
			
		}
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page.");
		//Update userName
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("Profile and settings page");
		getFidoprofileandsettingpage().clkChangeUserName();			
		getFidoprofileandsettingpage().setNewUserName(newUserName);
		getReporter().reportLogWithScreenshot("New username is entered.");
		getFidoprofileandsettingpage().clkSaveButton();		
		getReporter().hardAssert(getFidoprofileandsettingpage().verifyUserNameUpdatedSuccessFullyOnProfileAndSettingsPg(newUserName),
							"Username updated successfully",
							"Username did not update successfully");
		getReporter().reportLogWithScreenshot("Username updated successfully");
		getCommonbusinessflows().logOutAndResignIn(newUserName,password);		
		
		//reset back		
		if(!newUserName.equalsIgnoreCase(oldUserName))
		{
			getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
			getFidoprofileandsettingpage().clkChangeUserName();					
			getFidoprofileandsettingpage().setNewUserName(oldUserName);
			getReporter().reportLogWithScreenshot("Change username back to the old one.");
			getFidoprofileandsettingpage().clkSaveButton();
			getReporter().hardAssert(getFidoprofileandsettingpage().verifyUserNameUpdatedSuccessFullyOnProfileAndSettingsPg(oldUserName),
								"Username is successfully reset back",
								"User name reset not successful");			
			getReporter().reportLogWithScreenshot("Change user name back is done.");
		}
				
	}	
	
}
