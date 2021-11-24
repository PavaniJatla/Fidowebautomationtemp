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
		System.setProperty("PageLoadStrategy", "NONE");
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	

	@Test(groups = {"ProfileAndSettingSS"})
	public void postPaidPaymentViewAndUpdateBillingAddress() throws InterruptedException, ParseException {
		
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc1417.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc1417.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		String newAddress;
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("profile and settings page");

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
    		String strTestingTab = getDriver().getWindowHandle();
    		String strRecoveredUserName ="";
    		//Go to ENS to verify email and get reset password page.		
    		try {
    			
    			getEnsverifications().getEmailVerifyPage(TestDataHandler.tc1417.getUsername());
    			String recoveryCode = getFidorecoverpassornamepage().getVerificationCode();
    			getDriver().switchTo().window(strTestingTab);			
    			getReporter().reportLogWithScreenshot("Close the Overlay");
    			getFidoprofileandsettingpage().switchToVerifyIdentityIFrame();
    			getFidoprofileandsettingpage().setRecoveryCode(recoveryCode);
    			getFidoprofileandsettingpage().clkBtnContinue();    						
    						
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		
		
		getReporter().reportLogWithScreenshot("Update Billing address overlay");
		getFidoprofileandsettingpage().setNewAddress(newAddress);
		getReporter().reportLogWithScreenshot("New Address set");
		getFidoprofileandsettingpage().clkContinueUpdateNewAddress();
		getFidoprofileandsettingpage().clkSubmitNewAddress();	
		getReporter().reportLogWithScreenshot("New address submitted");
		getReporter().hardAssert(getFidoprofileandsettingpage().verifyAddressUpdatedSuccessFulOverlay(newAddress.substring(0, 10)),
							"Address update successful overlay message displayed",
							"Address update successful overlay message not displayed");
		getReporter().hardAssert(getFidoprofileandsettingpage().verifyAddressUpdatedSuccessFullyOnProfileAndSettingsPg(newAddress),
							"Address updated successfully on PnS page",
							"Address did not update successful on PnS");				
								
	}

	private Object getRogersRecoverPassOrNamePage() {
		// TODO Auto-generated method stub
		return null;
	}

}
