package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC031_ValidateRegisterFlow_Prepaid extends BaseTestClass{	
	
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
	public void prepaidValidateRegisterFlow() {

		
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
		reporter.hardAssert(fido_account_registration_page.verifyMsgDisplayedForEmailSentToPrepaidRegisteredEmail(),
				"Message email sent to registered email displayed.",
				"Message email sent to registered email didn't display.");
		fido_account_registration_page.clkBtnOkayPrepaidRegister();
		//Login with the registered credential
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		common_business_flows.loginApplication(strEmail, strPassword);
		
		reporter.hardAssert(fido_prepaid_link_account_page.verifyHeaderConnectMyAccountDisplayed(),
				"Connect my account header displayed.",
				"Connect my account header didn't display.");
		fido_prepaid_link_account_page.clkLabelPrepaidService();
		String strPrepaidCtn = TestDataHandler.tc31.getaccountDetails().getPhoneNumber();
		fido_prepaid_link_account_page.setFidoPrepaidCtn(strPrepaidCtn);
		reporter.reportLogWithScreenshot("Connect a prepaid account page");
		fido_prepaid_link_account_page.clkBtnSendMeCode();
//Got recaptcha here!!!

 
		

	}

}
