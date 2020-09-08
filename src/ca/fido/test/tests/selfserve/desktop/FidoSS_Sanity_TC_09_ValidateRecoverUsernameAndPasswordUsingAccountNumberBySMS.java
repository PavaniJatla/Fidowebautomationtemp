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
	
	
	@Test
	public void tc05ValidateRecoverPassUsingSms() {
		fido_home_page.clkLogin();
		reporter.reportLogWithScreenshot("Login Page");
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkForgotPassOrNameIframe();	
		reporter.reportLogWithScreenshot("Clicked on Forgot Password or username");
		fido_recover_pass_or_name_page.clkBtnBoth();
		reporter.reportLogWithScreenshot("Clicked on password button");
		String strUsername = TestDataHandler.tc04To09.getUsername();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		String strAccountNumber = TestDataHandler.tc04To09.getaccountDetails().getBan();		
		fido_recover_pass_or_name_page.setAccountNumber(strAccountNumber);
		reporter.reportLogWithScreenshot("Set email id and click button continue");
		fido_recover_pass_or_name_page.clkBtnContinue();		
		reporter.reportLogWithScreenshot("Continue is clicked");
		//flow updated in May 20th release, no need to click text option.
		fido_recover_pass_or_name_page.clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		
				
		try {
			String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
				String strCode = ensVerifications.getVerifyCode(strPhoneNum);
			
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			reporter.reportLogWithScreenshot("Set code");
			fido_recover_pass_or_name_page.switchToSetCodeIframe();
			fido_recover_pass_or_name_page.setCode(strCode);
			fido_recover_pass_or_name_page.clickVerifyMe();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reporter.reportLogWithScreenshot("Create New Password");
		String strNewPass = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();		
		fido_recover_pass_or_name_page.setNewPassword(strNewPass);
		fido_recover_pass_or_name_page.setConfirmPassword(strNewPass);
		reporter.reportLogWithScreenshot("New passwords set");
		fido_recover_pass_or_name_page.clkBtnSetPassword();
		reporter.hardAssert(fido_recover_pass_or_name_page.isPasswordRestSuccessIsDisplayed()
				, "Password reset success message is displayed"
				, "Password reset success message not displayed");
		fido_recover_pass_or_name_page.clkLogInToMyAccount();
		//Login with old password:
		fido_recover_pass_or_name_page.switchToDefaultContent();
		fido_login_page.switchToSignInFrame();
		common_business_flows.loginApplication(strUsername, strPassword);		
		if(fido_login_page.verifyIfErrorMsgIsDisplayedInFrame())
		{			
			reporter.reportLogWithScreenshot("Login attempt one not successful with old password, trying with new password:"+strNewPass);							
			fido_login_page.setUsernameInFrame(strUsername);
			fido_login_page.setPasswordInFrame(strNewPass);
			reporter.reportLogWithScreenshot("Login with UserName: "+strUsername+" and Password: "+strNewPass);
			fido_login_page.clkLoginInFrame();
			reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
					"Login proceed without error.", 
					"Login failed with recovered username and password.");
			fido_login_page.switchOutOfSignInFrame();
			reporter.reportLogWithScreenshot("Account overview page");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}else
		{
			reporter.reportLogWithScreenshot("Login successful");
			fido_login_page.switchOutOfSignInFrame();
			reporter.reportLogWithScreenshot("Account overview page");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}
		
		
	
	}
			
}
