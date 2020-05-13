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

public class FidoSS_Sanity_TC_06_ValidateRecoverUsernameUsingAccountNumberBySMS extends BaseTestClass{
	
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
	public void tc06ValidtRecvUsrnameByAccNumUsingSms() {				
		fido_home_page.clkLogin();
		reporter.reportLogWithScreenshot("Login Page");
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkForgotPassOrNameIframe();	
		reporter.reportLogWithScreenshot("Clicked on Forgot Password or username");
		fido_recover_pass_or_name_page.clkBtnUserName();
		reporter.reportLogWithScreenshot("Clicked on password button");
		String strAccountNumber = TestDataHandler.tc04To09.getaccountDetails().getBan();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		fido_recover_pass_or_name_page.setAccountNumber(strAccountNumber);
		reporter.reportLogWithScreenshot("Set email id and click button continue");
		fido_recover_pass_or_name_page.clkBtnContinue();		
		reporter.reportLogWithScreenshot("Continue is clicked");
		//flow updated in May 20th release, no need to click text option.
		fido_recover_pass_or_name_page.clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName = null;		
		
		String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
		strRecoveredUserName = ensVerifications.getAccountUserName(strPhoneNum);			
		getDriver().switchTo().window(strTestingTab);
		reporter.reportLogWithScreenshot("Close the Overlay");
		fido_recover_pass_or_name_page.switchToSetCodeIframe();
		fido_recover_pass_or_name_page.clkBtnCloseWeHaveTextedUserNameOverlay();			

		//Login with username:  
		fido_home_page.clkLogin();
		reporter.reportLogWithScreenshot("Login Page");
		fido_recover_pass_or_name_page.switchToDefaultContent();
		fido_login_page.switchToSignInFrame();
		common_business_flows.loginApplication(strRecoveredUserName, strPassword);						
		reporter.reportLogWithScreenshot("Login successful");
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		
	}
	
	
}
