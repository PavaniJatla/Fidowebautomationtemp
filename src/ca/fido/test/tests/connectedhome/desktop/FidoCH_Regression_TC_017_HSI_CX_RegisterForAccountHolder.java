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
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkRegisterIframe();
		//fido_account_registration_page.clkRegisterNow();
		reporter.reportLogWithScreenshot("Register now is clicked.");
		fido_account_registration_page.clkAccountHolder();
		fido_account_registration_page.setFidoAccountNumber(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getBan());
		fido_account_registration_page.setPostalCode(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getPostalCode());
		reporter.reportLogWithScreenshot("Register the BAN.");
		fido_account_registration_page.clkContinueAccountRegister();

		if (fido_account_registration_page.isBtnSendEmailDisplayed()) {
			fido_account_registration_page.clkBtnSendEmail();
			reporter.reportLogWithScreenshot("Verification email message");
		} else {

			fido_account_registration_page.setFidoEmail(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail());
			fido_account_registration_page.setFidoConfirmEmail(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail());
 			fido_account_registration_page.clkContinueAccountRegister();
 			
			reporter.softAssert(fido_account_registration_page.verifyVerificationEmailMsgIsDisplayed(),
					"Verification email sent message displayed",
					"Verification email sent message does Not displayed");
			reporter.reportLogWithScreenshot("Verification email message");
		}

		//Will open a new tab for ENS, to get verification code from ENS
		
		try {
			ensVerifications.getEmailVerifyPage(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail());
			//Another new page opened
			fido_set_password_page.switchToSetPasswordTab(3);
			fido_set_password_page.clkBtnSetPasswordInEmail();
			String strPassword = "DigiAuto@123";
			fido_set_password_page.setPassword(strPassword);
			fido_set_password_page.setConfirmPassword(strPassword);
			reporter.reportLogWithScreenshot("Set password page.");
			fido_set_password_page.clkBtnSetPassword();
			reporter.hardAssert(fido_set_password_page.verifyMsgReigistrationCompleteIsDisplayed(),
					"Registration completed message displayed",
					"Registration completed message does Not displayed");
			reporter.reportLogWithScreenshot("Set password completed.");
			
		} catch (ClientProtocolException e) {
			reporter.reportLogWithScreenshot(e.getMessage());
		} catch (IOException e) {
			reporter.reportLogWithScreenshot(e.getMessage());
		}
		fido_set_password_page.clkBtnGotoOverview();
		reporter.hardAssert(fido_account_overview_page.verifyEmailInSignInAsLink(TestDataHandler.fidoHSIRegisterAccount.getaccountDetails().getEmail()),
				"Registered email matches the name in Sign In As",
				"Registered email doesn't match the name in Sign In As");
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),
				"Registration success, login success.",
				"Didn't successfully login.");
		reporter.reportLogWithScreenshot("Account overview page");

		
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
