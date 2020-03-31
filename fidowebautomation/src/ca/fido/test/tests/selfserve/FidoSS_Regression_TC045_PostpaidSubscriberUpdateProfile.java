package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC045_PostpaidSubscriberUpdateProfile extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage", "strGroupName" })
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, strGroupName,method);			
	}	
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void postPaidPaymentViewAndEditProfile() throws InterruptedException, ParseException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc4557.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc4557.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Login Account overview page");
		fido_account_overview_page.clkMenuProfileNSetting();	
		reporter.reportLogWithScreenshot("menu profile and settings selected");
		fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
		reporter.reportLogWithScreenshot("Check for links update contact, billing address");
		reporter.softAssert(!fido_profile_and_setting_page.isLnkUpdateContactPresent(),
				"Link update contact is not present",
				"Link update contact is present");	
		reporter.softAssert(fido_profile_and_setting_page.verifySubscriberAccountContactPreferenceSection(),
				"Subscriber account contact preference section is displayed",
				"Subscriber account cantact preference section is not displayed");		
		reporter.softAssert(!fido_profile_and_setting_page.isLnkUpdateBillingAddressPresent(),
				"Link update billing address is not present",
				"Link update billing address is present");	
		fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
		reporter.reportLogWithScreenshot("Subscriber account billing address section");
		reporter.softAssert(fido_profile_and_setting_page.verifySubscriberAccountBillingAddressSection(),
				"Subscriber account billing address section is displayed",
				"Subscriber account billing address section is not displayed");										
	}

}
