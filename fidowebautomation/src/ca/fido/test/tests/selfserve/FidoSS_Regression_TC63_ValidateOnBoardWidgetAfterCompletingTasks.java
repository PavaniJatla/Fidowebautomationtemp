package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC63_ValidateOnBoardWidgetAfterCompletingTasks extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test
	public void userAddNumberForRecovery() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		String userName = TestDataHandler.tc0301.getUsername();
		String password = TestDataHandler.tc0301.getPassword();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.waitforViewBillToLoad();
		reporter.softAssert(fido_account_overview_page.isAccountSetUpProgressBarDisplayed(), 
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
			reporter.softAssert(fido_account_overview_page.isTitleSetUpRecoveryDisplayed(),
					"Set up recovery title is displayed",
					"Set up recovery title is not displayed, please investigate");
			fido_account_overview_page.clkSetUpNowButton();
		}
				
		reporter.reportLogWithScreenshot("Set recovery number");
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveryNumber =  TestDataHandler.tc0301.getaccountDetails().getRecoveryNumber();
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
			reporter.softAssert(fido_profile_and_setting_page.verifySuccessConfirmationMsg(), 
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
								&& !fido_account_overview_page.checkIfSetUpMobileRecoveryNumberIsNotComplete()), 
					"Task bar and progress should updated instantly after recovery is completed",
					"Task bar and progress NOT updated instantly it seems, please investigate");
			
			reporter.reportLogWithScreenshot("Progress bar is updated");
			
		} catch (IOException e) {
			reporter.reportLogFail(e.getMessage());
			
			
		}
	}

}
