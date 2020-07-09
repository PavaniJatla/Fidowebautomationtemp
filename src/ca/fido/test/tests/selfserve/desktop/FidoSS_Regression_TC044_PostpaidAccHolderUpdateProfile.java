package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import utils.FormFiller;

public class FidoSS_Regression_TC044_PostpaidAccHolderUpdateProfile extends BaseTestClass{	

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
	public void postPaidPaymentViewAndEditProfile() throws InterruptedException, ParseException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc104447.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc104447.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkMenuProfileNSetting();
		Hashtable<String, String> existingContactDetailsDict = fido_profile_and_setting_page.getOldContactDetails();
		reporter.reportLogWithScreenshot("profile and setting page");
		fido_profile_and_setting_page.clkUpdateContactDetails();	
		reporter.reportLogWithScreenshot("update contact details view");
		String strNewEmail = FormFiller.generateEmail();
		String strNewMobilePhone = FormFiller.generatePhoneNumber();
		String strNewHomePhone = FormFiller.generatePhoneNumber();
		String strNewBusinessPhone = FormFiller.generatePhoneNumber();
		
		fido_profile_and_setting_page.setEmail(strNewEmail);
		fido_profile_and_setting_page.setMobilePhone(strNewMobilePhone);
		fido_profile_and_setting_page.setHomePhone(strNewHomePhone);
		fido_profile_and_setting_page.setBusinessPhone(strNewBusinessPhone);
		reporter.reportLogWithScreenshot("New contact details entered");
		fido_profile_and_setting_page.saveContactDetails();		
		reporter.reportLogWithScreenshot("new contact details saved");
		reporter.softAssert(fido_profile_and_setting_page.verifyEmailUpdated(existingContactDetailsDict.get("email"), strNewEmail),
							"Email updated successfully",
							"Email did not update correctly, please investigate");
		reporter.softAssert(fido_profile_and_setting_page.verifyMobilePhoneUpdated(existingContactDetailsDict.get("mobilePhone"), strNewMobilePhone),
							"Mobile phone updated",
							"Mobile phone did not update");
		reporter.softAssert(fido_profile_and_setting_page.verifyHomePhoneUpdated(existingContactDetailsDict.get("homePhone"), strNewHomePhone),
							"home phone updated",
							"home phone didn't update");
		reporter.softAssert(fido_profile_and_setting_page.verifyBusinessPhoneUpdated(existingContactDetailsDict.get("businessPhone"), strNewBusinessPhone),
							"business phone updated",
							"business phone didn't update");		
		reporter.reportLogWithScreenshot("Contact details updated.");
									
	}

}
