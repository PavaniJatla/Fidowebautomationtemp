package ca.fido.test.tests.selfserve;


import java.io.IOException;
import java.lang.reflect.Method;
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

public class FidoSS_Regression_TC04_ValidateRecoverPasswordByEmail extends BaseTestClass{	
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void recoverPasswordByEmail() {
		/*
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkForgotPassOrNameIframe();
//		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Forgot password or name is clicked.");
		fido_recover_pass_or_name_page.clkBtnPassword();
		String strUsername = TestDataHandler.tc04To09.getUsername();
		fido_recover_pass_or_name_page.setEmailAddress(strUsername);
		fido_recover_pass_or_name_page.clkBtnContinue();
		
		fido_recover_pass_or_name_page.clkBtnEmailNowIfAvailable();
		reporter.reportLogWithScreenshot("EmailNow is clicked.");
		//Store the parent handle 
		String strTestingTab = getDriver().getWindowHandle();
		//Go to email inbox to verify email and get reset password page.		
		
		String strPassword = TestDataHandler.tc04To09.getaccountDetails().getNewPassword();
		fido_set_password_page.switchToSetPasswordTab(2);
		fido_set_password_page.setPassword(strPassword);
		fido_set_password_page.setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Set password page.");
		fido_set_password_page.clkBtnSetPassword();
		reporter.softAssert(fido_set_password_page.verifyMsgReigistrationCompleteIsDisplayed(),
				"Registration completed message displayed",
				"Registration completed message does Not displayed");

		
		//switch to working test tab.
		getDriver().switchTo().window(strTestingTab);
		*/

		

	}

}
