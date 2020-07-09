package ca.fido.test.tests.selfserve.desktop;

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
/**
 * To validate bill notification in Billing and Setting section of Profile and Settings page, 
 * the validation depends on set the mobile phone number in contact preference, if the mobile phone is set, 
 * it will verify the bill notification area of the number and on/off switch, otherwise, it will set the mobile
 * phone first, then verify bill notification area.
 * @author ning.xue
 *
 */
public class FidoSS_Regression_TC047_PostpaidAccHolderValidateBillNotification extends BaseTestClass {

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
	public void postpaidVerifyBillNotification() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		String strUserName = TestDataHandler.tc104447.getUsername();
		fido_login_page.setUsernameInFrame(strUserName);
		fido_login_page.setPasswordInFrame(TestDataHandler.tc104447.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page.");
		fido_account_overview_page.clkMenuProfileNSetting();
		reporter.reportLogWithScreenshot("menu profile and settings selected");
		try {
			String strGetMobileNum = fido_profile_and_setting_page.getMobilePhoneNum();
			//check if the mobile phone is set or not
			if (strGetMobileNum.equalsIgnoreCase("None")) {
				fido_profile_and_setting_page.clkUpdateContactDetails();
				reporter.reportLogWithScreenshot("Update contact details selected");
				String mobilePhoneNum = TestDataHandler.tc104447.getaccountDetails().getMobilePhone();
				fido_profile_and_setting_page.setEmail(strUserName);
				fido_profile_and_setting_page.setMobilePhone(mobilePhoneNum);
				fido_profile_and_setting_page.saveContactDetails();		
				reporter.reportLogWithScreenshot("Bill Notification after add mobile phone number in contact details.");
				
				reporter.softAssert(fido_profile_and_setting_page.verifyBillNotificationUpdateSuccessfully(mobilePhoneNum),
									"Bill notification show successfully with mobile phone set.",
									"Some issue with bill notification area with mobile phone set.");
				fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
				reporter.reportLogWithScreenshot("Verify bill notification section with mobile phone set.");
			} else {			
				reporter.softAssert(fido_profile_and_setting_page.verifyBillNotificationUpdateSuccessfully(strGetMobileNum),
									"Bill notification show successfully with mobile phone set.",
									"Some issue with bill notification area with mobile phone set.");
				fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
				reporter.reportLogWithScreenshot("Verify bill notification section with mobile phone set.");
				//To clear the MobilePhone setting.
				fido_profile_and_setting_page.clkUpdateContactDetails();
				reporter.reportLogWithScreenshot("Update contact details selected");
				fido_profile_and_setting_page.clearMobilePhone();
				fido_profile_and_setting_page.saveContactDetails();	
				
				reporter.reportLogWithScreenshot("Bill Notification after cleared mobile phone in Contact details.");
				//verify bill notification area again for no mobile phone set.
				reporter.softAssert(fido_profile_and_setting_page.verifyBillNotificationWithoutMobilePhoneSet(),
						"Bill notification without mobile",
						"Some issue with bill notification area without mobile phone");
				fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
				reporter.reportLogWithScreenshot("Verify bill notification section without mobile phone set.");
			}
		
		}catch(Exception ex)
		{			
			fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
			reporter.reportLogWithScreenshot("Profile and settings middle page");
			fido_profile_and_setting_page.scrollToProfileAndSettingsBottom();
			reporter.reportLogWithScreenshot("Profile and settings bottom page");
			reporter.reportLogFail("Failed due to exception :"+ex.getMessage());
		}

	}
}
