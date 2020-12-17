package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class FidoSS_Regression_TC019_PostpaidViewAndUpdateBillingAddressInEligibleUser extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	

	@Test(groups = {"SanitySS","ProfileAndSettingSS"})
	public void postPaidPaymentViewAndUpdateBillingAddress() throws InterruptedException, ParseException {		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc19.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc19.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		String newAddress;
		fido_account_overview_page.clkSubNavProfileAndSettings();
		reporter.reportLogWithScreenshot("profile and settings page");
		String existingAddress=fido_profile_and_setting_page.getOldAddress();
		if(!existingAddress.contains("4501 Valiant") 
			&& existingAddress.contains(TestDataHandler.tc1417.getaccountDetails().getAddress().get("line1")))
		{
			newAddress="201 Fleetwood Cres BRAMPTON ON L6T 2E6";
		}else
		{
			newAddress=TestDataHandler.tc1417.getaccountDetails().getAddress().get("line1")
					  +" "+TestDataHandler.tc1417.getaccountDetails().getAddress().get("line2");
		}
		fido_profile_and_setting_page.clkUpdateBillingAddress();
		if(fido_profile_and_setting_page.isVerifyYourIdentityOverlayDisplayed())
    	{
			fido_profile_and_setting_page.switchToVerifyIdentityIFrame();
			fido_profile_and_setting_page.clkContinueVerifyIdentity(); 			
    		reporter.hardAssert(fido_profile_and_setting_page.isInEligibleUser(),
    				"User is taken to eligibility failure modal",
    				"User is NOT taken to eligibility failure modal");
    		reporter.reportLogWithScreenshot("User is taken to eligibility failure modal");
    		fido_profile_and_setting_page.clkClose();
    		reporter.reportLogWithScreenshot("Clicks on close");
    		reporter.hardAssert(fido_profile_and_setting_page.IsBillingAddressDisplayed(),
    				"Profile and Settings page is displayed"
    				, "Profile and Settings page not displayed");
    		
    	}				
		
										
	}


}
