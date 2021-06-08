package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC63_ValidateOnBoardWidgetAfterCompletingTasks extends BaseTestClass{




	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test
	public void userAddNumberForRecovery() {
		int itr = 1;
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		String userName1 = TestDataHandler.tc121315.getUsername();
		String password = TestDataHandler.tc1122.getPassword();
		String strUserName2 = TestDataHandler.tc1122.getUsername();
		String strUserName3 = TestDataHandler.tc121315.getUsername();
		getFidologinpage().setUsernameInFrame(userName1);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");	
					
		// we are iterating three times with different accounts in case where the recovery is already set for a given account
		for (int loop = 1; loop <= 3; loop++) {
					
			
			if(itr==2)
			{				
				getCommonbusinessflows().loginApplication(strUserName2, password);
				getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
						"Login proceed without error.", 
						"Login failed with error.");
				getFidologinpage().switchOutOfSignInFrame();
				getReporter().reportLogWithScreenshot("Account overview page");	
			}else if (itr==3)
			{
				getCommonbusinessflows().loginApplication(strUserName3, password);
				getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
						"Login proceed without error.", 
						"Login failed with error.");
				getFidologinpage().switchOutOfSignInFrame();
				getReporter().reportLogWithScreenshot("Account overview page");	
			}
			
			getReporter().hardAssert(getFidoaccountoverviewpage().isAccountSetUpProgressBarDisplayed(), 
					"Progress bar displayed",
					"progress bar is not displayed"); 		
			getReporter().softAssert(getFidoaccountoverviewpage().isAccountSetUpWidgetLoginToMyAccountPresent(), 
					"Widget Login to my account is displayed",
					"Widget Login to my account is not displayed"); 
			getReporter().softAssert(getFidoaccountoverviewpage().isAccountSetUpWidgetSetContactInfoPresent(), 
					"Widget Set Contact info is displayed",
					"Widget Set Contact info is not displayed"); 
			getReporter().softAssert(getFidoaccountoverviewpage().isAccountSetUpWidgetSetUpAutomaticPaymentPresent(), 
					"Widget Set up automatic payment is displayed",
					"Widget Set up automatic payment is not displayed"); 
			getReporter().softAssert(getFidoaccountoverviewpage().isAccountSetUpWidgetSetUpMobileRecoveryPresent(), 
					"Widget Set up Mobile recovery is  displayed",
					"Widget Set up mobile recovery is not displayed"); 
			String beforeProgressPrecent = getFidoaccountoverviewpage().getAccountSetUpProgressPercentage();
			if(getFidoaccountoverviewpage().checkIfSetUpMobileRecoveryNumberIsNotComplete())
			{
				getFidoaccountoverviewpage().clkSetUpMobileRecoveryNumber();
				getReporter().hardAssert(getFidoaccountoverviewpage().isTitleSetUpRecoveryDisplayed(),
						"Set up recovery title is displayed",
						"Set up recovery title is not displayed, please investigate");
				getFidoaccountoverviewpage().clkSetUpNowButton();
				getReporter().reportLogWithScreenshot("Set recovery number");
				String strTestingTab = getDriver().getWindowHandle();
				String strRecoveryNumber =  TestDataHandler.tc41.getaccountDetails().getCtn();
				getFidoprofileandsettingpage().switchToSetRecoveryNumIFrame();
				getFidoprofileandsettingpage().setPhoneNumberIframe(strRecoveryNumber);
				getReporter().reportLogWithScreenshot("Recovery Number");
				getFidoprofileandsettingpage().clkBtnContinueIframe();
				getReporter().reportLogWithScreenshot("click button continue");
				//Will open a new tab for ENS, to get verification code from ENS		
				try {
					getReporter().reportLogWithScreenshot("ENS verification process start");
					String strVerifyCode = getEnsverifications().getVerifyCode(strRecoveryNumber);
					getDriver().switchTo().window(strTestingTab);
					getFidoprofileandsettingpage().switchToSetRecoveryNumIFrame();
					getFidoprofileandsettingpage().setVerifyCodeIframe(strVerifyCode);
					getReporter().reportLogWithScreenshot("Set verify code");
					getFidoprofileandsettingpage().clkBtnVerifyMeIframe();
					getReporter().reportLogWithScreenshot("Button verify me clicked");
					getReporter().hardAssert(getFidoprofileandsettingpage().verifySuccessConfirmationMsg(), 
										"Recovery phone number set successfully",
										"Got error when setting recovery phone number");
					getFidoprofileandsettingpage().clkBtnContinueToMyAccountIframe();
					getFidoprofileandsettingpage().switchOutofSetRecoveryNumIframe();
					getReporter().reportLogWithScreenshot("Click button continue to my account");
				
					getFidoaccountoverviewpage().clkSubNavProfileAndSettings();

					getReporter().softAssert(getFidoprofileandsettingpage().verifyRecoveryNumberSetSuccessfully(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
										"recovery number set successfully",
										"Recovery number did not set successfully");
					getReporter().reportLogWithScreenshot("Verify recovery number set in profile and settings page.");
					getFidoprofileandsettingpage().clkAccountOverView();
					getReporter().reportLogWithScreenshot("Back to Account overview page");
					
					getReporter().hardAssert((Integer.parseInt(getFidoaccountoverviewpage().getAccountSetUpProgressPercentage())==(Integer.parseInt(beforeProgressPrecent)+25)
										&& getFidoaccountoverviewpage().checkIfSetUpMobileRecoveryNumberIsComplete()), 
							"Task bar and progress should updated instantly after recovery is completed",
							"Task bar and progress NOT updated instantly it seems, please investigate");
					
					getReporter().reportLogWithScreenshot("Progress bar is updated");
					
					
				} catch (IOException e) {
					getReporter().reportLogFail(e.getMessage());
					
					
				}
				break;
				
			}else {
								
				itr++;
				getReporter().reportLogWithScreenshot("Recovery number already set ,so signing out and resigning and trying wtih another account");
				getFidologinpage().clkSignOut();
				if(getFidohomepage().isEasyloginDisplayed())
				{
					getFidohomepage().clkEasylogin();
				}
				getReporter().reportLogWithScreenshot("Sign Out clicked.");
				getFidologinpage().clkResignInAs();
				getReporter().reportLogWithScreenshot("Clicked ReSign In");
				getFidologinpage().switchToSignInFrame();
				if(getFidohomepage().verifyIfNotYouIsDisplayed())
				{
				 getFidohomepage().clkNotUser();
				}
			}
			
			
		}
		
				
		
	}

	
	
}
