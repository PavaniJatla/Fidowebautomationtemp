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

public class FidoSS_Regression_TC017_PostpaidViewAndUpdateBillingAddress extends BaseTestClass{

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
		fido_login_page.setUsernameInFrame(TestDataHandler.tc1417.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc1417.getPassword());
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
    		String strTestingTab = getDriver().getWindowHandle();
    		String strRecoveredUserName ="";
    		//Go to ENS to verify email and get reset password page.		
    		try {
    			
    			ensVerifications.getEmailVerifyPage(TestDataHandler.tc1417.getUsername());
    			String recoveryCode = fido_recover_pass_or_name_page.getVerificationCode();
    			getDriver().switchTo().window(strTestingTab);			
    			reporter.reportLogWithScreenshot("Close the Overlay");
    			fido_profile_and_setting_page.switchToVerifyIdentityIFrame();
    			fido_profile_and_setting_page.setRecoveryCode(recoveryCode);
    			fido_profile_and_setting_page.clkBtnContinue();    						
    						
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		
		
		reporter.reportLogWithScreenshot("Update Billing address overlay");
		fido_profile_and_setting_page.setNewAddress(newAddress);
		reporter.reportLogWithScreenshot("New Address set");
		fido_profile_and_setting_page.clkContinueUpdateNewAddress();
		fido_profile_and_setting_page.clkSubmitNewAddress();	
		reporter.reportLogWithScreenshot("New address submitted");
		reporter.hardAssert(fido_profile_and_setting_page.verifyAddressUpdatedSuccessFulOverlay(newAddress.substring(0, 10)),
							"Address update successful overlay message displayed",
							"Address update successful overlay message not displayed");
		reporter.hardAssert(fido_profile_and_setting_page.verifyAddressUpdatedSuccessFullyOnProfileAndSettingsPg(newAddress),
							"Address updated successfully on PnS page",
							"Address did not update successful on PnS");				
								
	}

	private Object getRogersRecoverPassOrNamePage() {
		// TODO Auto-generated method stub
		return null;
	}

}