package com.rogers.test.tests.connectedhome.desktop;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the upgarde flow for Legacy TV to IgniteTV for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Select the Bundles package and Click on Add to cart
 *6. Enter home address to validate the serviceability and click on Check Availability
 *7. Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks Continue".
 *10. Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click “checkout” button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click Submit.
 *17. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers.
 *18. Select any one phone number. 
 *19. Make sure Caller ID and Directory listing fields are populated.
 *20. Click on Continue.
 *21. Select a time in Choose your Date and Time. 
 *22. Enter any valid Mobile number and email address.
 *23. Click on Confirm.
 *24. Select Pre-Authorized credit card option from type of payment dropdown.
 *25. Enter valid Credit Card number details in Credit Card related fields.
 *26. Click on Continue.
 *27. Validate appropriate information is displayed in Review order page.
 *28. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *29. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_TC_004_CartAbandon_PortinExistingLegacysignedinfromMyRogersTest extends BaseTestClass {

	@Test
	public void checkCartAbandonPortinExistingLegacySignedinfromMyRogersTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.digitalTVUpgradeToIgnite.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.digitalTVUpgradeToIgnite.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
        rogers_home_page.clkShop(); 
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
     	rogers_home_page.clkIgniteTV();
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceability();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=(String) TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getAddress().get("line2");
        rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        rogers_igniteTV_buy_page.selectOptNewPhone();
        rogers_igniteTV_buy_page.clickOptPhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_igniteTV_buy_page.clkHomePhone();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.set4KTV(); 
        rogers_igniteTV_buy_page.clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        rogers_igniteTV_credit_check_page.selectDOBYear();
        rogers_igniteTV_credit_check_page.selectDOBMonth();
        rogers_igniteTV_credit_check_page.selectDOBDay();        
        rogers_igniteTV_credit_check_page.selectFirstID("2");
        rogers_igniteTV_credit_check_page.selectProvince("ON");
        rogers_igniteTV_credit_check_page.selectExpiryYearwithSpace();
        rogers_igniteTV_credit_check_page.selectExpiryMonth();
        rogers_igniteTV_credit_check_page.selectExpiryDay();
        rogers_igniteTV_credit_check_page.setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("second option for credit evalution ");
        rogers_igniteTV_credit_check_page.selectSecondIDOption("4");
        rogers_igniteTV_credit_check_page.setPassportNumber();
        rogers_igniteTV_credit_check_page.selectPassportExpiryYear();
        rogers_igniteTV_credit_check_page.selectPassportExpiryMonth();
        rogers_igniteTV_credit_check_page.selectPassportExpiryDay();
        rogers_igniteTV_credit_check_page.clkCreditConsent();
        rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        rogers_home_phone_selection_page.clkPhoneNumberGenerator(); 
        rogers_home_phone_selection_page.clkChosePhoneNumber(); 
        rogers_home_phone_selection_page.clkContinueHomePhoneSelection();  
        reporter.reportLogWithScreenshot("Launched the tech install page");
        rogers_tech_install_page.clkTechInstallSlot();
        rogers_tech_install_page.clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        rogers_payment_options_page.clkPaymentConfirmExistingCustomer();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");  
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}