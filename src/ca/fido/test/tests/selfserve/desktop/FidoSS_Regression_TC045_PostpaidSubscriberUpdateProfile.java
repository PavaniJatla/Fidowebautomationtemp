package ca.fido.test.tests.selfserve.desktop;

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
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC045_PostpaidSubscriberUpdateProfile extends BaseTestClass{

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
	public void postPaidSubscriberUpdateProfile() throws InterruptedException, ParseException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc4557.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc4557.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Login Account overview page");
		fido_account_overview_page.clkMenuProfileNSetting();	
		reporter.reportLogWithScreenshot("menu profile and settings selected");
		fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
		reporter.reportLogWithScreenshot("Check for links update contact, billing address");
		reporter.hardAssert(!fido_profile_and_setting_page.isLnkUpdateContactPresent(),
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
