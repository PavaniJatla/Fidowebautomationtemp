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

public class FidoSS_Regression_TC017_PostpaidViewAndEditProfile extends BaseTestClass{

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
		fido_login_page.setUsernameInFrame(TestDataHandler.tc1417.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc1417.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		String newAddress;
		fido_account_overview_page.clkMenuProfileNSetting();
		reporter.reportLogWithScreenshot("profile and settings page");
		try {
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
			reporter.reportLogWithScreenshot("Update Billing address overlay");
			fido_profile_and_setting_page.setNewAddress(newAddress);
			reporter.reportLogWithScreenshot("New Address set");
			fido_profile_and_setting_page.clkContinueUpdateNewAddress();
			fido_profile_and_setting_page.clkSubmitNewAddress();	
			reporter.reportLogWithScreenshot("New address submitted");
			reporter.softAssert(fido_profile_and_setting_page.verifyAddressUpdatedSuccessFulOverlay(newAddress.substring(0, 10)),
								"Address update successful overlay message displayed",
								"Address update successful overlay message not displayed");
			reporter.softAssert(fido_profile_and_setting_page.verifyAddressUpdatedSuccessFullyOnProfileAndSettingsPg(newAddress),
								"Address updated successfully on PnS page",
								"Address did not update successful on PnS");
		}catch(Exception ex)
		{
			reporter.reportLogWithScreenshot("Exception caught");
			fido_profile_and_setting_page.scrollToProfileAndSettingsMiddlePage();
			reporter.reportLogWithScreenshot("Profile and settings middle page");
			fido_profile_and_setting_page.scrollToProfileAndSettingsBottom();
			reporter.reportLogWithScreenshot("Profile and settings bottom page");
			reporter.reportLogFail("Failed due to exception :"+ex.getMessage());
		
		}					
									
	}

}
