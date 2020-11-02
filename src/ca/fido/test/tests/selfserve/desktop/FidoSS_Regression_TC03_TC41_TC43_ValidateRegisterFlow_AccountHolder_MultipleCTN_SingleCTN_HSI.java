package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC03_TC41_TC43_ValidateRegisterFlow_AccountHolder_MultipleCTN_SingleCTN_HSI extends BaseTestClass{	
	
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
	
	@DataProvider(name = "data-provider", parallel=true)
    public Object[][] dataProviderMethod() {
        return new Object[][] {   
        	{
            	TestDataHandler.tc0301.getaccountDetails().getBan()+"#"
                    	  +TestDataHandler.tc0301.getaccountDetails().getPostalCode()+"#"
                    	  +TestDataHandler.tc0301.getaccountDetails().getEmail()},
        	{
        		
                          	TestDataHandler.tc41.getaccountDetails().getBan()+"#"
                                  	  +TestDataHandler.tc41.getaccountDetails().getPostalCode()+"#"
                                 	  +TestDataHandler.tc41.getaccountDetails().getEmail()},
        	{
            	TestDataHandler.tc43.getaccountDetails().getBan()+"#"
                    	  +TestDataHandler.tc43.getaccountDetails().getPostalCode()+"#"
                    	  +TestDataHandler.tc43.getaccountDetails().getEmail()}};
    }
 
    @Test(dataProvider = "data-provider",groups = {"RegressionSS","ProfileAndSettingSS","RegisterSS"})
	public void acctHolderValidateRegisterFlow(String strBanPostcodeEmail) {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkRegisterIframe();
		//fido_account_registration_page.clkRegisterNow();
		reporter.reportLogWithScreenshot("Register now is clicked.");
		fido_account_registration_page.clkAccountHolder();
		String strFidoAccountNumber = strBanPostcodeEmail.split("#")[0] ;
		String strPostalCode = strBanPostcodeEmail.split("#")[1];
		fido_account_registration_page.setFidoAccountNumber(strFidoAccountNumber);
		fido_account_registration_page.setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Register the BAN.");
		fido_account_registration_page.clkContinueAccountRegister();
		
 		String strPassword = "DigiAuto@123";
		String strEmail = strBanPostcodeEmail.split("#")[2];
		if (fido_account_registration_page.isBtnSendEmailDisplayed()) {
			fido_account_registration_page.clkBtnSendEmail();
			reporter.reportLogWithScreenshot("Verification email message");
		} else {

			fido_account_registration_page.setFidoEmail(strEmail);
			fido_account_registration_page.setFidoConfirmEmail(strEmail);
 			fido_account_registration_page.clkContinueAccountRegister();
 			
			reporter.softAssert(fido_account_registration_page.verifyVerificationEmailMsgIsDisplayed(),
					"Verification email sent message displayed",
					"Verification email sent message does Not displayed");
			reporter.reportLogWithScreenshot("Verification email message");
		}

		//Will open a new tab for ENS, to get verification code from ENS
		
		try {
			ensVerifications.getEmailVerifyPage(strEmail);
			fido_set_password_page.clkBtnSetPasswordInEmail();
			//Another new page opened
			fido_set_password_page.switchToSetPasswordTab(3);
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
		reporter.hardAssert(fido_account_overview_page.verifyEmailInSignInAsLink(strEmail),
				"Registered email matches the name in Sign In As",
				"Registered email doesn't match the name in Sign In As");
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),
				"Registration success, login success.",
				"Didn't successfully login.");
		reporter.reportLogWithScreenshot("Account overview page");
	/*	
		fido_account_overview_page.clkLnkSignInAs();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(strEmail);
		fido_login_page.setPasswordInFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame(); */
		
	}

}
