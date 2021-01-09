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

		
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkRegisterIframe();
		getFidoaccountregistrationpage().clkRegisterNow();
		getReporter().reportLogWithScreenshot("Register now is clicked.");
		getFidoaccountregistrationpage().clkPrepaidCustomer();
		
		String strEmail = TestDataHandler.tc31.getaccountDetails().getEmail();
		String strPassword = TestDataHandler.tc31.getaccountDetails().getPassword();
		getFidoaccountregistrationpage().setFidoPrepaidEmail(strEmail);
		getFidoaccountregistrationpage().setConfirmFidoPrepaidEmail(strEmail);
		getFidoaccountregistrationpage().setFidoPrepaidPassword(strPassword);
		getFidoaccountregistrationpage().setConfirmFidoPrepaidPassword(strPassword);
		getFidoaccountregistrationpage().clkBtnContinuePrepaidRegister();
		getReporter().hardAssert(getFidoaccountregistrationpage().verifyMsgDisplayedForEmailSentToPrepaidRegisteredEmail(),
				"Message email sent to registered email displayed.",
				"Message email sent to registered email didn't display.");
		getFidoaccountregistrationpage().clkBtnOkayPrepaidRegister();
		//Login with the registered credential
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getCommonbusinessflows().loginApplication(strEmail, strPassword);
		
		getReporter().hardAssert(getFidoprepaidlinkaccountpage().verifyHeaderConnectMyAccountDisplayed(),
				"Connect my account header displayed.",
				"Connect my account header didn't display.");
		getFidoprepaidlinkaccountpage().clkLabelPrepaidService();
		String strPrepaidCtn = TestDataHandler.tc31.getaccountDetails().getPhoneNumber();
		getFidoprepaidlinkaccountpage().setFidoPrepaidCtn(strPrepaidCtn);
		getReporter().reportLogWithScreenshot("Connect a prepaid account page");
		getFidoprepaidlinkaccountpage().clkBtnSendMeCode();
//Got recaptcha here!!!

 
		

	}

}
