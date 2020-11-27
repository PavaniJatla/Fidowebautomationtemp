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
	
	
	@Test(groups = {"RegressionSS","DashboardSS"})
	public void userAddNumberForRecovery() {
		int itr = 1;
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		String userName1 = TestDataHandler.tc121315.getUsername();
		String password = TestDataHandler.tc1122.getPassword();
		String strUserName2 = TestDataHandler.tc1122.getUsername();
		String strUserName3 = TestDataHandler.tc121315.getUsername();
		fido_login_page.setUsernameInFrame(userName1);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");	
					
		// we are iterating three times with different accounts in case where the recovery is already set for a given account
		for (int loop = 1; loop <= 3; loop++) {
					
			
			if(itr==2)
			{				
				common_business_flows.loginApplication(strUserName2, password);
				reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
						"Login proceed without error.", 
						"Login failed with error.");
				fido_login_page.switchOutOfSignInFrame();
				reporter.reportLogWithScreenshot("Account overview page");	
			}else if (itr==3)
			{
				common_business_flows.loginApplication(strUserName3, password);
				reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
						"Login proceed without error.", 
						"Login failed with error.");
				fido_login_page.switchOutOfSignInFrame();
				reporter.reportLogWithScreenshot("Account overview page");	
			}
			
			reporter.hardAssert(fido_account_overview_page.isAccountSetUpProgressBarDisplayed(), 
					"Progress bar displayed",
					"progress bar is not displayed"); 		
			reporter.softAssert(fido_account_overview_page.isAccountSetUpWidgetLoginToMyAccountPresent(), 
					"Widget Login to my account is displayed",
					"Widget Login to my account is not displayed"); 
			reporter.softAssert(fido_account_overview_page.isAccountSetUpWidgetSetContactInfoPresent(), 
					"Widget Set Contact info is displayed",
					"Widget Set Contact info is not displayed"); 
			reporter.softAssert(fido_account_overview_page.isAccountSetUpWidgetSetUpAutomaticPaymentPresent(), 
					"Widget Set up automatic payment is displayed",
					"Widget Set up automatic payment is not displayed"); 
			reporter.softAssert(fido_account_overview_page.isAccountSetUpWidgetSetUpMobileRecoveryPresent(), 
					"Widget Set up Mobile recovery is  displayed",
					"Widget Set up mobile recovery is not displayed"); 
			String beforeProgressPrecent = fido_account_overview_page.getAccountSetUpProgressPercentage();
			if(fido_account_overview_page.checkIfSetUpMobileRecoveryNumberIsNotComplete())
			{
				fido_account_overview_page.clkSetUpMobileRecoveryNumber();
				reporter.hardAssert(fido_account_overview_page.isTitleSetUpRecoveryDisplayed(),
						"Set up recovery title is displayed",
						"Set up recovery title is not displayed, please investigate");
				fido_account_overview_page.clkSetUpNowButton();
				reporter.reportLogWithScreenshot("Set recovery number");
				String strTestingTab = getDriver().getWindowHandle();
				String strRecoveryNumber =  TestDataHandler.tc41.getaccountDetails().getCtn();
				fido_profile_and_setting_page.switchToSetRecoveryNumIFrame();
				fido_profile_and_setting_page.setPhoneNumberIframe(strRecoveryNumber);
				reporter.reportLogWithScreenshot("Recovery Number");
				fido_profile_and_setting_page.clkBtnContinueIframe();
				reporter.reportLogWithScreenshot("click button continue");
				//Will open a new tab for ENS, to get verification code from ENS		
				try {
					reporter.reportLogWithScreenshot("ENS verification process start");
					String strVerifyCode = ensVerifications.getVerifyCode(strRecoveryNumber);
					getDriver().switchTo().window(strTestingTab);
					fido_profile_and_setting_page.switchToSetRecoveryNumIFrame();
					fido_profile_and_setting_page.setVerifyCodeIframe(strVerifyCode);
					reporter.reportLogWithScreenshot("Set verify code");
					fido_profile_and_setting_page.clkBtnVerifyMeIframe();
					reporter.reportLogWithScreenshot("Button verify me clicked");
					reporter.hardAssert(fido_profile_and_setting_page.verifySuccessConfirmationMsg(), 
										"Recovery phone number set successfully",
										"Got error when setting recovery phone number");
					fido_profile_and_setting_page.clkBtnContinueToMyAccountIframe();
					fido_profile_and_setting_page.switchOutofSetRecoveryNumIframe();
					reporter.reportLogWithScreenshot("Click button continue to my account");
				
					fido_account_overview_page.clkMenuProfileNSetting();

					reporter.softAssert(fido_profile_and_setting_page.verifyRecoveryNumberSetSuccessfully(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
										"recovery number set successfully",
										"Recovery number did not set successfully");
					reporter.reportLogWithScreenshot("Verify recovery number set in profile and settings page.");
					fido_profile_and_setting_page.clkAccountOverView();
					reporter.reportLogWithScreenshot("Back to Account overview page");
					
					reporter.hardAssert((Integer.parseInt(fido_account_overview_page.getAccountSetUpProgressPercentage())==(Integer.parseInt(beforeProgressPrecent)+25)
										&& fido_account_overview_page.checkIfSetUpMobileRecoveryNumberIsComplete()), 
							"Task bar and progress should updated instantly after recovery is completed",
							"Task bar and progress NOT updated instantly it seems, please investigate");
					
					reporter.reportLogWithScreenshot("Progress bar is updated");
					
					
				} catch (IOException e) {
					reporter.reportLogFail(e.getMessage());
					
					
				}
				break;
				
			}else {
								
				itr++;
				reporter.reportLogWithScreenshot("Recovery number already set ,so signing out and resigning and trying wtih another account");
				fido_login_page.clkSignOut();
				if(fido_home_page.isEasyloginDisplayed())
				{
					fido_home_page.clkEasylogin();
				}
				reporter.reportLogWithScreenshot("Sign Out clicked.");
				fido_login_page.clkResignInAs();
				reporter.reportLogWithScreenshot("Clicked ReSign In");
				fido_login_page.switchToSignInFrame();
				if(fido_home_page.verifyIfNotYouIsDisplayed())
				{
				 fido_home_page.clkNotUser();
				}
			}
			
			
		}
		
				
		
	}

	
	
}
