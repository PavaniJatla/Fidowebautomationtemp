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
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkRegisterIframe();
		fido_account_registration_page.clkRegisterNow();
		reporter.reportLogWithScreenshot("Register now is clicked.");
		fido_account_registration_page.clkAccountHolder();
		String strFidoAccountNumber = TestDataHandler.tc0301.getaccountDetails().getBan();
		String strPostalCode = TestDataHandler.tc0301.getaccountDetails().getPostalCode();
		fido_account_registration_page.setFidoAccountNumber(strFidoAccountNumber);
		fido_account_registration_page.setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Register the BAN.");
		fido_account_registration_page.clkContinueAccountRegister();
		
		//Need an existing profile email here
		String strEmail = TestDataHandler.tc16.getUsername();
		fido_account_registration_page.setFidoEmail(strEmail);
		fido_account_registration_page.setFidoConfirmEmail(strEmail);
		fido_account_registration_page.clkContinueAccountRegister();
		
		reporter.softAssert(fido_account_registration_page.verifyErrorMsgEmailIsUsedIsDisplayed(),
				"Error message 'This email is being used by another My Account profile' displayed",
				"Error message does Not displayed");
		reporter.reportLogWithScreenshot("Error message");
		

	}

}
