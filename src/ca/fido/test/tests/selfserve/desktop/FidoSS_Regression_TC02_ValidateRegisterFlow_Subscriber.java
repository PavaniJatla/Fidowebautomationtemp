package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC02_ValidateRegisterFlow_Subscriber extends BaseTestClass{	
	
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
	public void subscriberValidateRegisterFlow() {
		getFidohomepage().clkLogin();
		getReporter().reportLogWithScreenshot("Login page.");
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkRegisterIframe();
		//getFidoaccountregistrationpage().clkRegisterNow();
		getReporter().reportLogWithScreenshot("Register now is clicked.");
		
		getFidoaccountregistrationpage().clkSubscriber();
		String strFidoSubscriberPhoneNumber = TestDataHandler.tc02PreRegister.getaccountDetails().getPhoneNumber();
		getFidoaccountregistrationpage().setPhoneNumber(strFidoSubscriberPhoneNumber);
		getFidoaccountregistrationpage().clkContinueAfterPhoneNumber();
		
		//Sometimes got captcha here!!!
		String strEmail = TestDataHandler.tc02PreRegister.getaccountDetails().getEmail();
		getFidoaccountregistrationpage().setFidoEmail(strEmail);
		getFidoaccountregistrationpage().setFidoConfirmEmail(strEmail);
	}

}
