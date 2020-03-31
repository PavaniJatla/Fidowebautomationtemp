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

public class FidoSS_Regression_TC031_ValidateRegisterFlow_Prepaid extends BaseTestClass{	
	
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
	public void prepaidValidateRegisterFlow() {
		/*
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkRegisterIframe();
		fido_account_registration_page.clkRegisterNow();
		reporter.reportLogWithScreenshot("Register now is clicked.");
		fido_account_registration_page.clkPrepaidCustomer();
		
		String strEmail = TestDataHandler.tc31.getaccountDetails().getEmail();
		String strPassword = TestDataHandler.tc31.getaccountDetails().getPassword();
		fido_account_registration_page.setFidoPrepaidEmail(strEmail);
		fido_account_registration_page.setConfirmFidoPrepaidEmail(strEmail);
		fido_account_registration_page.setFidoPrepaidPassword(strPassword);
		fido_account_registration_page.setConfirmFidoPrepaidPassword(strPassword);
		fido_account_registration_page.clkBtnContinuePrepaidRegister();
		reporter.softAssert(fido_account_registration_page.verifyMsgDisplayedForEmailSentToPrepaidRegisteredEmail(),
				"Message email sent to registered email displayed.",
				"Message email sent to registered email didn't display.");
		fido_account_registration_page.clkBtnOkayPrepaidRegister();
		//Login with the registered credential
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		common_business_flows.loginApplication(strEmail, strPassword);
		
		reporter.softAssert(fido_prepaid_link_account_page.verifyHeaderConnectMyAccountDisplayed(),
				"Connect my account header displayed.",
				"Connect my account header didn't display.");
		fido_prepaid_link_account_page.clkLabelPrepaidService();
		String strPrepaidCtn = TestDataHandler.tc31.getaccountDetails().getPhoneNumber();
		fido_prepaid_link_account_page.setFidoPrepaidCtn(strPrepaidCtn);
		reporter.reportLogWithScreenshot("Connect a prepaid account page");
		fido_prepaid_link_account_page.clkBtnSendMeCode();
//Got recaptcha here!!!
 * 
 * */
 
		

	}

}
