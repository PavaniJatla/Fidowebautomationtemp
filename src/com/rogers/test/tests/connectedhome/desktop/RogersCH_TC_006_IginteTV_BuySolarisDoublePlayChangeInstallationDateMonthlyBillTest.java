package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
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
 *9. Click checkout button on cart summary page.
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

public class RogersCH_TC_006_IginteTV_BuySolarisDoublePlayChangeInstallationDateMonthlyBillTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyCH"})
    public void checkBuyDigitalTVOffer() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		 rogers_home_page.clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		 rogers_home_page.clkIgniteTVExistingCustomer();
		
		reporter.hardAssert(rogers_home_page.verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		rogers_home_page.clkServiceability();
		reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		String  strAddressLine1=(String) TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=(String) TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.getAccountDetails().getAddress().get("line2");
		rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
		rogers_home_page.clkIgniteAddressLookupSubmit();
		//rogers_home_page.clkContinueIgniteMultipleAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		
		reporter.hardAssert(rogers_igniteTV_buy_page.verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		rogers_igniteTV_buy_page.clkPlusAddIgniteTVBoxes(); 
		rogers_igniteTV_buy_page.clkUpdateCart();
		rogers_igniteTV_buy_page.clkCheckout();
		
		reporter.hardAssert(rogers_igniteTV_profile_creation_page.verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkSubmitProfile();
        
        reporter.hardAssert(rogers_tech_install_page.verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
    	rogers_tech_install_page.selSelffinstallDateAndTimeMigrartion(); 
        reporter.reportLogWithScreenshot("Launched the tech install page");	        
       // rogers_tech_install_page.clkTechInstallSlot();
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.setMobielNumberExistingCustomer();
        rogers_tech_install_page.setEmailExistingCustomer();
        rogers_tech_install_page.clkTechInstalConsentExistingCustomer();
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstallContinue();
    reporter.reportLogWithScreenshot("Launched the order review page");
	reporter.hardAssert(rogers_order_review_page.verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
	reporter.reportLogWithScreenshot("Launched the order review page");
	
	reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
    
    rogers_order_review_page.clkAcceptenceCheckbox();
    reporter.reportLogWithScreenshot("Agreement details");
    rogers_order_review_page.clkSubmit();
    reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");       
    reporter.reportLogWithScreenshot("Launched the Confirmation page");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

