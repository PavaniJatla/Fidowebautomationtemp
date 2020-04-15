package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Sanity_TC_10_UserAddNumberForRecovery extends BaseTestClass{

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
		String userName = TestDataHandler.tc104447.getUsername();
		String password = TestDataHandler.tc104447.getPassword();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.waitforViewBillToLoad();
		try {
			fido_account_overview_page.clkMenuProfileNSetting();
			reporter.reportLogWithScreenshot("menu profile and settings selected");
		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			fido_account_overview_page.clkMenuProfileNSetting();
			reporter.reportLogWithScreenshot("menu profile and settings selected");
		}
		reporter.reportLogWithScreenshot("Profile and Settings page");
		fido_profile_and_setting_page.clkSetRcvryNumber();
		reporter.reportLogWithScreenshot("Set recovery number");
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveryNumber =  TestDataHandler.tc104447.getaccountDetails().getRecoveryNumber();
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
//			fido_home_page.clkMenuMyAccountAfterLogin();
//			reporter.reportLogWithScreenshot("Click Menu My Account after login");
			fido_account_overview_page.clkMenuProfileNSetting();

			reporter.softAssert(fido_profile_and_setting_page.verifyRecoveryNumberSetSuccessfully(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
								"recovery number set successfully",
								"Recovery number did not set successfully");
			reporter.reportLogWithScreenshot("Verify recovery number set in profile and settings page.");
			
		} catch (IOException e) {
			reporter.reportLogFail(e.getMessage());
			
			
		}
	}

}
