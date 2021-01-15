package ca.fido.test.tests.selfserve.mobile;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class Mobile_FidoSS_Regression_TC017_PostpaidViewAndEditProfile extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("sauceandroidchrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	

	@Test(groups = {"MobileSanitySS","SSPnS"})
	public void mobilePostPaidPaymentViewAndEditProfile() throws InterruptedException, ParseException {
		getFidohomepage().clkNavMobile();
		getReporter().reportLogWithScreenshot("Launched the Navgation card");	
		getFidohomepage().clkLoginMobile();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc1417.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc1417.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrameMobile();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		String newAddress;
		getFidoaccountoverviewpage().clkMenuProfileNSettingMobile();		
		getReporter().reportLogWithScreenshot("profile and settings page");
		getFidoprofileandsettingpage().clkButtonBillingSettings();
		String existingAddress=getFidoprofileandsettingpage().getOldAddress();
		if(!existingAddress.contains("4501 Valiant") 
			&& existingAddress.contains(TestDataHandler.tc1417.getaccountDetails().getAddress().get("line1")))
		{
			newAddress="201 Fleetwood Cres BRAMPTON ON L6T 2E6";
		}else
		{
			newAddress=TestDataHandler.tc1417.getaccountDetails().getAddress().get("line1")
					  +" "+TestDataHandler.tc1417.getaccountDetails().getAddress().get("line2");
		}
		getFidoprofileandsettingpage().clkUpdateBillingAddress();
		if(getFidoprofileandsettingpage().isVerifyYourIdentityOverlayDisplayed())
    	{
			getFidoprofileandsettingpage().switchToVerifyIdentityIFrame();
			getFidoprofileandsettingpage().clkContinueVerifyIdentity(); 			
    		getReporter().hardAssert(getFidoprofileandsettingpage().isInEligibleUser(),
    				"User is taken to eligibility failure modal",
    				"User is NOT taken to eligibility failure modal");
    		getReporter().reportLogWithScreenshot("User is taken to eligibility failure modal");
    		getFidoprofileandsettingpage().clkClose();
    		getReporter().reportLogWithScreenshot("Clicks on close");
    		getReporter().hardAssert(getFidoprofileandsettingpage().IsBillingAddressDisplayed(),
    				"Profile and Settings page is displayed"
    				, "Profile and Settings page not displayed");    		
    	}					
								
	}

}
