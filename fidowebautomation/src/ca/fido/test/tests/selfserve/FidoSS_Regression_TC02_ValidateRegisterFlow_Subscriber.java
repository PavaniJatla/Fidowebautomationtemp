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
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC02_ValidateRegisterFlow_Subscriber extends BaseTestClass{	
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage", "strGroupName" })
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, strGroupName,method);			
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void subscriberValidateRegisterFlow() {
		fido_home_page.clkLogin();
		reporter.reportLogWithScreenshot("Login page.");
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkRegisterIframe();
		fido_account_registration_page.clkRegisterNow();
		reporter.reportLogWithScreenshot("Register now is clicked.");
		
		fido_account_registration_page.clkSubscriber();
		String strFidoSubscriberPhoneNumber = TestDataHandler.tc0203.getaccountDetails().getPhoneNumber();
		fido_account_registration_page.setPhoneNumber(strFidoSubscriberPhoneNumber);
		fido_account_registration_page.clkContinueAfterPhoneNumber();
		
		//Sometimes got captcha here!!!
		String strEmail = TestDataHandler.tc0203.getaccountDetails().getEmail();
		fido_account_registration_page.setFidoEmail(strEmail);
		fido_account_registration_page.setFidoConfirmEmail(strEmail);
	}

}
