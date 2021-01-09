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
		getFidohomepage().clkNavMobile();
		getReporter().reportLogWithScreenshot("Launched the Navgation card");	
		getFidohomepage().clkLoginMobile();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc2732.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc2732.getPassword());
		getReporter().reportLogWithScreenshot("After click on Login");
		getFidologinpage().clkLoginInFrameMobile();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		String strNewVoiceMailPassword = FormFiller.generateRandomNumber(5);	
		
		getReporter().reportLogWithScreenshot("Account overview page.");	
		String strCTN = TestDataHandler.tc2732.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on Wireless badge");
		getFidowirelessdashboardpostpaidpage().clickUpdateVoiceMailPassword();
		getReporter().reportLogWithScreenshot("Update voice mail password view");
		getReporter().hardAssert(getFidoresetvoicemailpasswordpage().verifyLabelResetNewPasswordisDisplayedOnPasswordChangePage(),
							"Label reset new password is displayed",
							"Label reset new password is not displayed");
		getReporter().hardAssert(getFidoresetvoicemailpasswordpage().verifyLabelWhereToChangeTheVoiceMailPasswordisDisplayed(),
							"Label where to change the voice mail password displayed",
							"Label where to change the voice mail password Not displayed");
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyVoiceMailPasswordDigitRuleIsDisplayed(),
							"VoiceMail Password Digit Rule Is Displayed",
							"VoiceMail Password Digit Rule Is Not Displayed");
		
		getFidoresetvoicemailpasswordpage().setNewVoiceMailPassword(strNewVoiceMailPassword);
		getFidoresetvoicemailpasswordpage().setConfirmVoiceMailPassword(strNewVoiceMailPassword);
		getReporter().reportLogWithScreenshot("New voice mail password "+strNewVoiceMailPassword+" is set");
		getFidoresetvoicemailpasswordpage().clkSubmit();
		getFidoresetvoicemailpasswordpage().waitForBackBtnVisible();
		getReporter().reportLogWithScreenshot("After New voice mail password is submited");
		getReporter().hardAssert(getFidoresetvoicemailpasswordpage().verifyLabelResetNewPasswordisDisplayedOnChangeConfirmationPage(),
							"LabelResetNewPasswordisDisplayedOnChangeConfirmationPage",
							"LabelResetNewPassword is Not DisplayedOnChangeConfirmationPage");
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyLabelYourPasswordHasBeenChanged(),
							"Label Your Password Has Been Changed",
							"Label Your Password Has Been Changed not displayed");
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyLabelYourNewPasswordForCTNIs(),
							"Label Your NewPassword For CTNIs",
							"Label Your NewPassword For CTNIs  not available");		
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyNewPasswordDisplayed(strNewVoiceMailPassword),
							"verifyNewPasswordDisplayed :"+strNewVoiceMailPassword,
							"Verify New Password displaying failed");
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyLabelToAccessFidoVoiceMailfromDevice(),
							"Label To Access Fido VoiceMail from Device",
							"Label To Access Fido VoiceMail from Device  not available");
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyLabelLearnHowToChangeFidoVoiceMailfromDevice(),
							"Verify Label Learn How To Change Fido VoiceMail from Device succeed.",
							"verify Label Learn How To Change Fido VoiceMail from Device failed.");
		getReporter().softAssert(getFidoresetvoicemailpasswordpage().verifyLinkVoiceMailFAQ(),
							"verify Link Voice Mail FAQ",
							"Link VoiceMail FAQ not available");
		getFidoresetvoicemailpasswordpage().clkBackToMyAccountPageButton();	
		getReporter().reportLogWithScreenshot("After click on Back to My Account page button");
		getReporter().softAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
							"Back to account overview page successful",
							"Back to account overview page not successful");		
	}
	
	

}
