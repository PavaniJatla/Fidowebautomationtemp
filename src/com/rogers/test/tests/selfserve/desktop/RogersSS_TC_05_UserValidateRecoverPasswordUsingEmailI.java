package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_05_UserValidateRecoverPasswordUsingEmailI extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		System.setProperty("PageLoadStrategy", "NONE");
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"RegressionSS","ProfileAndSettingsSS","RecoverySS"})
	public void userValidateRecoverUsernameUsingEmailID() {
		
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Clicked SIgn IN");
		//getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Switched to sign in iFrame");
		getRogersLoginPage().clkForgotPasswordIframe();							
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc013132.getUsername();
		String strPassword = TestDataHandler.tc013132.getPassword();
		//getRogersRecoverPassOrNamePage().clkBtnUserName();
		getRegisterOrAccountRecoveryPage().setUsernameIFrame(strUserName);
		reporter.reportLogWithScreenshot("Set username for recover password.");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.		
		try {
			
			getEnsVerifications().getEmailVerifyPage(strUserName);
			String recoveryCode = getRegisterOrAccountRecoveryPage().getVerificationCode();
			getDriver().switchTo().window(strTestingTab);			
			reporter.reportLogWithScreenshot("Close the Overlay");
			//getRegisterOrAccountRecoveryPage().switchToSetCodeIframe();
			getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
			strRecoveredUserName= getRegisterOrAccountRecoveryPage().getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovering password for  username : "+strRecoveredUserName.trim());			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The username on set password overlay is correct",
				"The username on set password overlay is incorrect");
		getRegisterOrAccountRecoveryPage().setNewPassword(strPassword);
		getRegisterOrAccountRecoveryPage().setConfirmPassword(strPassword);
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRegisterOrAccountRecoveryPage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		getRegisterOrAccountRecoveryPage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRegisterOrAccountRecoveryPage().switchToDefaultContent();
		reporter.reportLogWithScreenshot("Waiting for account overview to load...");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"password successfully recovered/set", "password NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");	
		
						
	}

}
