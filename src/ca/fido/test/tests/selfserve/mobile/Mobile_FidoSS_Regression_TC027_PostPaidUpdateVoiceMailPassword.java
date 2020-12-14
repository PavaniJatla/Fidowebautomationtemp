package ca.fido.test.tests.selfserve.mobile;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This script will update the voicemail passcode
 * @author Mirza.Kamran
 */
public class Mobile_FidoSS_Regression_TC027_PostPaidUpdateVoiceMailPassword extends BaseTestClass{
	
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
	
	@Test(groups = {"MobileSanitySS","MobileRegressionSS","MobileDashboardSS"})
	public void postPaidUpdateVoiceMailPassword() {
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navgation card");	
		fido_home_page.clkLoginMobile();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc2732.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc2732.getPassword());
		reporter.reportLogWithScreenshot("After click on Login");
		fido_login_page.clkLoginInFrameMobile();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		String strNewVoiceMailPassword = FormFiller.generateRandomNumber(5);	
		
		reporter.reportLogWithScreenshot("Account overview page.");	
		String strCTN = TestDataHandler.tc2732.getaccountDetails().getCtn();
		fido_account_overview_page.clkCTNsViewUsageAndManage(strCTN);
		reporter.reportLogWithScreenshot("Click on Wireless badge");
		fido_wireless_dashboard_postpaid_page.clickUpdateVoiceMailPassword();
		reporter.reportLogWithScreenshot("Update voice mail password view");
		reporter.hardAssert(fido_reset_voicemail_password_page.verifyLabelResetNewPasswordisDisplayedOnPasswordChangePage(),
							"Label reset new password is displayed",
							"Label reset new password is not displayed");
		reporter.hardAssert(fido_reset_voicemail_password_page.verifyLabelWhereToChangeTheVoiceMailPasswordisDisplayed(),
							"Label where to change the voice mail password displayed",
							"Label where to change the voice mail password Not displayed");
		reporter.softAssert(fido_reset_voicemail_password_page.verifyVoiceMailPasswordDigitRuleIsDisplayed(),
							"VoiceMail Password Digit Rule Is Displayed",
							"VoiceMail Password Digit Rule Is Not Displayed");
		
		fido_reset_voicemail_password_page.setNewVoiceMailPassword(strNewVoiceMailPassword);
		fido_reset_voicemail_password_page.setConfirmVoiceMailPassword(strNewVoiceMailPassword);
		reporter.reportLogWithScreenshot("New voice mail password "+strNewVoiceMailPassword+" is set");
		fido_reset_voicemail_password_page.clkSubmit();
		fido_reset_voicemail_password_page.waitForBackBtnVisible();
		reporter.reportLogWithScreenshot("After New voice mail password is submited");
		reporter.hardAssert(fido_reset_voicemail_password_page.verifyLabelResetNewPasswordisDisplayedOnChangeConfirmationPage(),
							"LabelResetNewPasswordisDisplayedOnChangeConfirmationPage",
							"LabelResetNewPassword is Not DisplayedOnChangeConfirmationPage");
		reporter.softAssert(fido_reset_voicemail_password_page.verifyLabelYourPasswordHasBeenChanged(),
							"Label Your Password Has Been Changed",
							"Label Your Password Has Been Changed not displayed");
		reporter.softAssert(fido_reset_voicemail_password_page.verifyLabelYourNewPasswordForCTNIs(),
							"Label Your NewPassword For CTNIs",
							"Label Your NewPassword For CTNIs  not available");		
		reporter.softAssert(fido_reset_voicemail_password_page.verifyNewPasswordDisplayed(strNewVoiceMailPassword),
							"verifyNewPasswordDisplayed :"+strNewVoiceMailPassword,
							"Verify New Password displaying failed");
		reporter.softAssert(fido_reset_voicemail_password_page.verifyLabelToAccessFidoVoiceMailfromDevice(),
							"Label To Access Fido VoiceMail from Device",
							"Label To Access Fido VoiceMail from Device  not available");
		reporter.softAssert(fido_reset_voicemail_password_page.verifyLabelLearnHowToChangeFidoVoiceMailfromDevice(),
							"Verify Label Learn How To Change Fido VoiceMail from Device succeed.",
							"verify Label Learn How To Change Fido VoiceMail from Device failed.");
		reporter.softAssert(fido_reset_voicemail_password_page.verifyLinkVoiceMailFAQ(),
							"verify Link Voice Mail FAQ",
							"Link VoiceMail FAQ not available");
		fido_reset_voicemail_password_page.clkBackToMyAccountPageButton();	
		reporter.reportLogWithScreenshot("After click on Back to My Account page button");
		reporter.softAssert(fido_account_overview_page.verifySuccessfulLogin(),
							"Back to account overview page successful",
							"Back to account overview page not successful");		
	}
	
	

}
