package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Sanity_TC_09_ValidateRecoverUsernameAndPasswordUsingAccountNumberBySMS extends BaseTestClass{
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","ProfileAndSettingSS","RecoverSS"})
	public void tc05ValidateRecoverPassUsingSms() {
		//getFidohomepage().clkLogin();
		getReporter().reportLogWithScreenshot("Login Page");
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkForgotPassOrNameIframe();	
		getReporter().reportLogWithScreenshot("Clicked on Forgot Password or username");
		getFidorecoverpassornamepage().clkBtnBoth();
		getReporter().reportLogWithScreenshot("Clicked on password button");
		String strUsername = TestDataHandler.tc04To09.getUsername();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		String strAccountNumber = TestDataHandler.tc04To09.getaccountDetails().getBan();		
		getFidorecoverpassornamepage().setAccountNumber(strAccountNumber);
		getReporter().reportLogWithScreenshot("Set email id and click button continue");
		getFidorecoverpassornamepage().clkBtnContinue();		
		getReporter().reportLogWithScreenshot("Continue is clicked");
		//flow updated in May 20th release, no need to click text option.
		getFidorecoverpassornamepage().clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		
				
		try {
			String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
				String strCode = getEnsverifications().getVerifyCode(strPhoneNum);
			
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			getReporter().reportLogWithScreenshot("Set code");
			getFidorecoverpassornamepage().switchToSetCodeIframe();
			getFidorecoverpassornamepage().setCode(strCode);
			getFidorecoverpassornamepage().clickVerifyMe();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getReporter().reportLogWithScreenshot("Create New Password");
		String strNewPass = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();		
		getFidorecoverpassornamepage().setNewPassword(strNewPass);
		getFidorecoverpassornamepage().setConfirmPassword(strNewPass);
		getReporter().reportLogWithScreenshot("New passwords set");
		getFidorecoverpassornamepage().clkBtnSetPassword();
		getReporter().hardAssert(getFidorecoverpassornamepage().isPasswordRestSuccessIsDisplayed()
				, "Password reset success message is displayed"
				, "Password reset success message not displayed");
		getFidorecoverpassornamepage().clkLogInToMyAccount();
		//Login with old password:
		getFidorecoverpassornamepage().switchToDefaultContent();
		getFidologinpage().switchToSignInFrame();
		getCommonbusinessflows().loginApplication(strUsername, strPassword);		
		if(getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame())
		{			
			getReporter().reportLogWithScreenshot("Login attempt one not successful with old password, trying with new password:"+strNewPass);							
			getFidologinpage().setUsernameInFrame(strUsername);
			getFidologinpage().setPasswordInFrame(strNewPass);
			getReporter().reportLogWithScreenshot("Login with UserName: "+strUsername+" and Password: "+strNewPass);
			getFidologinpage().clkLoginInFrame();
			getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with recovered username and password.");
			getFidologinpage().switchOutOfSignInFrame();
			getReporter().reportLogWithScreenshot("Account overview page");
			getCommonbusinessflows().resetPasswordBack(strNewPass, strPassword);
		}else
		{
			getReporter().reportLogWithScreenshot("Login successful");
			getFidologinpage().switchOutOfSignInFrame();
			getReporter().reportLogWithScreenshot("Account overview page");
			getCommonbusinessflows().resetPasswordBack(strNewPass, strPassword);
		}
		
		
	
	}
			
}
