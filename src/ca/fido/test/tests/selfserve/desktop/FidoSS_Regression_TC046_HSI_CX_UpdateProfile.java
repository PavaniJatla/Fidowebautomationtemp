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

public class FidoSS_Regression_TC046_HSI_CX_UpdateProfile extends BaseTestClass{

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
	public void postPaidPaymentViewAndEditProfileContactsForHSI() throws InterruptedException, ParseException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc4246.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc4246.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Login Account overview page");
		fido_account_overview_page.clkMenuProfileNSetting();
		reporter.reportLogWithScreenshot("menu profile and settings selected");
		Hashtable<String, String> existingContactDetailsDict=fido_profile_and_setting_page.getOldContactDetails();
		
		fido_profile_and_setting_page.clkUpdateContactDetails();	
		String strNewEmail = FormFiller.generateEmail();
		String strNewMobilePhone = FormFiller.generatePhoneNumber();
		String strNewHomePhone = FormFiller.generatePhoneNumber();
		String strNewBusinessPhone = FormFiller.generatePhoneNumber();
		reporter.reportLogWithScreenshot("Update contact details");
		fido_profile_and_setting_page.setEmail(strNewEmail);
		fido_profile_and_setting_page.setMobilePhone(strNewMobilePhone);
		fido_profile_and_setting_page.setHomePhone(strNewHomePhone);
		fido_profile_and_setting_page.setBusinessPhone(strNewBusinessPhone);
		reporter.reportLogWithScreenshot("new contact details entered");
		fido_profile_and_setting_page.saveContactDetails();		
		reporter.reportLogWithScreenshot("new contact details saved");		
		reporter.softAssert(fido_profile_and_setting_page.verifyEmailUpdated(existingContactDetailsDict.get("email"), strNewEmail),
							"The email updated on PnS page",
							"Email not updated on PnS, please investigate");
		reporter.softAssert(fido_profile_and_setting_page.verifyMobilePhoneUpdated(existingContactDetailsDict.get("mobilePhone"), strNewMobilePhone),
							"Mobile phone update",
							"Mobile phone not updated");
		reporter.softAssert(fido_profile_and_setting_page.verifyHomePhoneUpdated(existingContactDetailsDict.get("homePhone"), strNewHomePhone),
							"Home phone updated",
							"home phone not updated");
		reporter.softAssert(fido_profile_and_setting_page.verifyBusinessPhoneUpdated(existingContactDetailsDict.get("businessPhone"), strNewBusinessPhone),
							"New business phone updated",
							"New business phone not updated");	
		reporter.reportLogWithScreenshot("Update HSI account profile is done.");
									
	}

}
