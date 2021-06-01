package ca.fido.test.tests.connectedhome.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoCH_Regression_TC_017_HSI_CX_RegisterForAccountHolder extends BaseTestClass{
	

    @Test(groups = {"RegressionCH",""})
	public void acctHolderValidateRegisterFlow() {
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkRegisterIframe();
		//getFidoaccountregistrationpage().clkRegisterNow();
		getReporter().reportLogWithScreenshot("Register now is clicked.");
		getFidoaccountregistrationpage().clkAccountHolder();
		getFidoaccountregistrationpage().setFidoAccountNumber(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getBan());
		getFidoaccountregistrationpage().setPostalCode(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getPostalCode());
		getReporter().reportLogWithScreenshot("Register the BAN.");
		getFidoaccountregistrationpage().clkContinueAccountRegister();

		if (getFidoaccountregistrationpage().isBtnSendEmailDisplayed()) {
			getFidoaccountregistrationpage().clkBtnSendEmail();
			getReporter().reportLogWithScreenshot("Verification email message");
		} else {

			getFidoaccountregistrationpage().setFidoEmail(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail());
			getFidoaccountregistrationpage().setFidoConfirmEmail(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail());
 			getFidoaccountregistrationpage().clkContinueAccountRegister();
 			
			getReporter().softAssert(getFidoaccountregistrationpage().verifyVerificationEmailMsgIsDisplayed(),
					"Verification email sent message displayed",
					"Verification email sent message does Not displayed");
			getReporter().reportLogWithScreenshot("Verification email message");
		}

		//Will open a new tab for ENS, to get verification code from ENS
		
		try {
			getEnsverifications().getEmailVerifyPage(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail());
			//Another new page opened
			getFidosetpasswordpage().switchToSetPasswordTab(2);
			getFidosetpasswordpage().clkBtnSetPasswordInEmail();
			String strPassword = "DigiAuto@123";
			getFidosetpasswordpage().switchToSetPasswordTab(3);
			getFidosetpasswordpage().clkSetPassword();
			getFidosetpasswordpage().switchToSetPasswordTab(4);
			getFidosetpasswordpage().setPassword(strPassword);
			getFidosetpasswordpage().setConfirmPassword(strPassword);
			getReporter().reportLogWithScreenshot("Set password page.");
			getFidosetpasswordpage().clkBtnSetPassword();
			getReporter().hardAssert(getFidosetpasswordpage().verifyMsgReigistrationCompleteIsDisplayed(),
					"Registration completed message displayed",
					"Registration completed message does Not displayed");
			getReporter().reportLogWithScreenshot("Set password completed.");
			
		} catch (ClientProtocolException e) {
			getReporter().reportLogWithScreenshot(e.getMessage());
		} catch (IOException e) {
			getReporter().reportLogWithScreenshot(e.getMessage());
		}
		getFidosetpasswordpage().clkBtnGotoOverview();
		getFidologinpage().switchToSignInFrame();
		getReporter().reportLogWithScreenshot("Launched the SignIn popup");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentials");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Registration success, login success.",
				"Didn't successfully login.");
		getReporter().reportLogWithScreenshot("Account overview page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login,  method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
