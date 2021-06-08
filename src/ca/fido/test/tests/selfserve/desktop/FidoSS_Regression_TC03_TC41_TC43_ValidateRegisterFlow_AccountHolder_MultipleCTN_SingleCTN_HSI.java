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
		System.setProperty("PageLoadStrategy", "NONE");
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {   
        	{
            	TestDataHandler.tc0301.getaccountDetails().getBan()+"#"
                    	  +TestDataHandler.tc0301.getaccountDetails().getPostalCode()+"#"
                    	  +TestDataHandler.tc0301.getaccountDetails().getEmail()+"#"
						+TestDataHandler.tc0301.getaccountDetails().getDob()},
        	{

                          	TestDataHandler.tc41.getaccountDetails().getBan()+"#"
                                  	  +TestDataHandler.tc41.getaccountDetails().getPostalCode()+"#"
                                 	  +TestDataHandler.tc41.getaccountDetails().getEmail()+"#"
									+TestDataHandler.tc41.getaccountDetails().getDob()},
        	{
            	TestDataHandler.tc43.getaccountDetails().getBan()+"#"
                    	  +TestDataHandler.tc43.getaccountDetails().getPostalCode()+"#"
                    	  +TestDataHandler.tc43.getaccountDetails().getEmail()+"#"
						+TestDataHandler.tc43.getaccountDetails().getDob()}
        };
    }
 
    @Test(dataProvider = "data-provider",groups = {"RegressionSS","ProfileAndSettingSS","RegisterSS"})
	public void acctHolderValidateRegisterFlow(String strBanPostcodeEmail) throws IOException {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkRegisterIframe();
		//getFidoaccountregistrationpage().clkRegisterNow();
		getReporter().reportLogWithScreenshot("Register now is clicked.");
		getFidoaccountregistrationpage().clkAccountHolder();

			// New code ........
		//New changes from Nov 11 Onwards
		String strFidoAccountNumber = strBanPostcodeEmail.split("#")[0] ;
		String strPostalCode = strBanPostcodeEmail.split("#")[1];
		String strEmail = strBanPostcodeEmail.split("#")[2];
		String strDOB = strBanPostcodeEmail.split("#")[3];
		String strPassword = "DigiAuto@123";

		getFidorecoverpassornamepage().setUsernameIFrame(strEmail);
		getReporter().reportLogWithScreenshot("Set email/username for user registartion");
		getFidorecoverpassornamepage().clkBtnContinue();
		getFidorecoverpassornamepage().setAccountNumber(strFidoAccountNumber);
		getFidorecoverpassornamepage().setPostCode(strPostalCode);
		getFidorecoverpassornamepage().setDOB(strDOB);
		getReporter().reportLogWithScreenshot("Set Account, post code and DOB number for registration");
		getFidorecoverpassornamepage().clkBtnContinue();
		getReporter().reportLogWithScreenshot("Set account number and Postal code");
		//rogers_register_page.setAccountNumber(strBan);
		//rogers_register_page.setPostalCode(strPostalCode);
		//reporter.reportLogWithScreenshot("Account number and postal code ");
		//.clickContinue();
		if(!getFidoaccountregistrationpage().isProfileAlreadyStarted())
		{
			String strTestingTab = getDriver().getWindowHandle();
			//Go to ENS to verify email and get reset password page.
			getEnsverifications().getEmailVerifyPage(strEmail);
			getReporter().reportLogWithScreenshot("Get recovery code");
			String verificationCode = getFidorecoverpassornamepage().getVerificationCode();
			getDriver().switchTo().window(strTestingTab);
			//getFidorecoverpassornamepage().switchToSetCodeIframe();
			getFidorecoverpassornamepage().setVerificationCode(verificationCode);
			getReporter().reportLogWithScreenshot("Set verification code");
			getFidorecoverpassornamepage().clkBtnContinue();
			getReporter().reportLogWithScreenshot("Click on continue button");
			getFidorecoverpassornamepage().setNewPassword(strPassword);
			getFidorecoverpassornamepage().setConfirmPassword(strPassword);
			getReporter().reportLogWithScreenshot("Set new Password page");
			getFidorecoverpassornamepage().clkBtnContinue();
			//Login with recovered user name to verify
			getReporter().hardAssert(getFidorecoverpassornamepage().isPasswordSuccessfullySet(),
					"passoword successfully set",
					"passoword not set successfully");
			getReporter().reportLogWithScreenshot("Password success page");
			getFidorecoverpassornamepage().clkGoToMyFido();
			getReporter().reportLogWithScreenshot("Go to my rogers clicked");
			getFidorecoverpassornamepage().switchToDefaultContent();
			setImplicitWait(getDriver(), 5);
			getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
					"Login succeed.",
					"Failed to login.");
			getReporter().reportLogWithScreenshot("Account overview");
		}else
		{
			getReporter().reportLogFailWithScreenshot(" This profile is already registered");
		}






/*


		String strFidoAccountNumber = strBanPostcodeEmail.split("#")[0] ;
		String strPostalCode = strBanPostcodeEmail.split("#")[1];
		getFidoaccountregistrationpage().setFidoAccountNumber(strFidoAccountNumber);
		getFidoaccountregistrationpage().setPostalCode(strPostalCode);
		getReporter().reportLogWithScreenshot("Register the BAN.");
		getFidoaccountregistrationpage().clkContinueAccountRegister();
		
 		String strPassword = "DigiAuto@123";
		String strEmail = strBanPostcodeEmail.split("#")[2];
		if (getFidoaccountregistrationpage().isBtnSendEmailDisplayed()) {
			getFidoaccountregistrationpage().clkBtnSendEmail();
			getReporter().reportLogWithScreenshot("Verification email message");
		} else {

			getFidoaccountregistrationpage().setFidoEmail(strEmail);
			getFidoaccountregistrationpage().setFidoConfirmEmail(strEmail);
 			getFidoaccountregistrationpage().clkContinueAccountRegister();
 			
			getReporter().softAssert(getFidoaccountregistrationpage().verifyVerificationEmailMsgIsDisplayed(),
					"Verification email sent message displayed",
					"Verification email sent message does Not displayed");
			getReporter().reportLogWithScreenshot("Verification email message");
		}

		//Will open a new tab for ENS, to get verification code from ENS
		
		try {
			getEnsverifications().getEmailVerifyPage(strEmail);
			getFidosetpasswordpage().clkBtnSetPasswordInEmail();
			//Another new page opened
			getFidosetpasswordpage().switchToSetPasswordTab(3);
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
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyEmailInSignInAsLink(strEmail),
				"Registered email matches the name in Sign In As",
				"Registered email doesn't match the name in Sign In As");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Registration success, login success.",
				"Didn't successfully login.");
		getReporter().reportLogWithScreenshot("Account overview page");
	/*	
		getFidoaccountoverviewpage().clkLnkSignInAs();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(strEmail);
		getFidologinpage().setPasswordInFrame(strPassword);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame(); */

	}

}
