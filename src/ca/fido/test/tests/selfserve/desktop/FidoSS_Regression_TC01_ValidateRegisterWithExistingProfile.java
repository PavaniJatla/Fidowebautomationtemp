package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class FidoSS_Regression_TC01_ValidateRegisterWithExistingProfile extends BaseTestClass{	
	
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
	
	@Test(groups = {"RegressionSS","ProfileAndSettingSS","RegisterSS"})
	public void validateRegisterWithExistingProfile() {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkRegisterIframe();
		//getFidoaccountregistrationpage().clkRegisterNow();
		getReporter().reportLogWithScreenshot("Register now is clicked.");
		getFidoaccountregistrationpage().clkAccountHolder();
		String strFidoAccountNumber = TestDataHandler.tc0301.getaccountDetails().getBan();
		String strPostalCode = TestDataHandler.tc0301.getaccountDetails().getPostalCode();
		getFidoaccountregistrationpage().setFidoAccountNumber(strFidoAccountNumber);
		getFidoaccountregistrationpage().setPostalCode(strPostalCode);
		getReporter().reportLogWithScreenshot("Register the BAN.");
		getFidoaccountregistrationpage().clkContinueAccountRegister();
		
		//Need an existing profile email here
		String strEmail = TestDataHandler.tc16.getUsername();
		getFidoaccountregistrationpage().setFidoEmail(strEmail);
		getFidoaccountregistrationpage().setFidoConfirmEmail(strEmail);
		getFidoaccountregistrationpage().clkContinueAccountRegister();
		
		getReporter().softAssert(getFidoaccountregistrationpage().verifyErrorMsgEmailIsUsedIsDisplayed(),
				"Error message 'This email is being used by another My Account profile' displayed",
				"Error message does Not displayed");
		getReporter().reportLogWithScreenshot("Error message");
		

	}

}
