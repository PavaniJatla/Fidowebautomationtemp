package com.rogers.test.tests.connectedhome.desktop;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browse to Shop menu and select Ignite TV option
 *3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 *4. Enter home address to validate the serviceability and click on Check Availability
 *5. Click on Continue
 *6. Click "No thanks Continue"
 *7. Click on Continue in Home phone add ons page
 *8. Select one option for   'Do you have a 4K TV'
 *9. Click “checkout” button on cart summary page.
 *10. Enter all personal information on user profile creation page - 1) Profile step
 *11. Click on Continue
 *12. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *13. Click Submit
 *14. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers
 *15. Select any one phone number
 *16. Make sure Caller ID and Directory listing fields are populated
 *17. Click on Continue
 *18. Validate minicart
 *19. Select a time in Choose your Date and Time 
 *20. Enter any valid Mobile number and email address
 *21. Click on Confirm
 *22. Select Pre-Authorized credit card option from type of payment dropdown
 *23. Enter valid Credit Card number details in Credit Card related fields
 *24. Click on Continue
 *25. Validate appropriate information is displayed in Review order page
 *26. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *27. Click on Submit
 *
 **/

public class RogersCH_TC_028_IginteTV_ExistingSolarisCustomerBuyBundleWithNewAddressTest extends BaseTestClass {

    @Test
    public void checkExistingSolarisCustomerBuyBundleWithNewAddress() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisTVAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount((TestDataHandler.solarisTVAccount.accountDetails.getBan()));
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
        rogers_home_page.clkShop(); 
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
     	rogers_home_page.clkIgniteTV();  
    	rogers_home_page.verifyIgnitepage();
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceability();
    	reporter.reportLogWithScreenshot("Launched the csutomer availability check popup");
        String  strAddressLine1=(String) TestDataHandler.solarisTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.solarisTVAccount.getAccountDetails().getAddress().get("line2");
        rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();        
  /*      rogers_igniteTV_buy_page.verifyOptNewPhone();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        rogers_igniteTV_buy_page.selectOptNewPhone();
        rogers_igniteTV_buy_page.clickOptPhone();
        rogers_igniteTV_buy_page.verifyHomePhone();
	        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
	        rogers_igniteTV_buy_page.clkHomePhone();*/
	        rogers_igniteTV_buy_page.verify4KTV();
	        reporter.reportLogWithScreenshot("Launched the cart summary page");
	        rogers_igniteTV_buy_page.set4KTV(); 
	        rogers_igniteTV_buy_page.verify4KTVSelection();
	        reporter.reportLogWithScreenshot("4k TV selected");
	        rogers_igniteTV_buy_page.clkCheckout();
	        reporter.reportLogWithScreenshot("Launched the create profile page");
	        rogers_igniteTV_profile_creation_page.clkSubmitProfile(); 
	        reporter.reportLogWithScreenshot("Launched the home phone selection page");
	/*        rogers_home_phone_selection_page.clkPhoneNumberGenerator(); 
	        rogers_home_phone_selection_page.clkChosePhoneNumber(); 
	        rogers_home_phone_selection_page.clkContinueHomePhoneSelection();*/ 
	        rogers_tech_install_page.verifyTechInstallPage(); 
	        //rogers_tech_install_page.clkPersonalizedInstall();
	        rogers_tech_install_page.selTechInstal();
	        reporter.reportLogWithScreenshot("Launched the tech install page");
	        rogers_tech_install_page.clkTechInstallSlot();
	        reporter.reportLogWithScreenshot("tech install details");
	        rogers_tech_install_page.clkTechInstalConsent();
	        rogers_tech_install_page.clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");       
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

