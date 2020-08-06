package ca.fido.test.tests.connectedhome.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
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


/**
 * This class contains the test method to Anonymous login for the Fido SSP
 * 
 * @author chinnarao.vattam
 * 
 *  Test steps:
 *
 *  1. Launch SSP fido.ca. 
 *  2. Enter valid credentials and Dealer code and click on Log in 
 *  3. Click on Accept 
 *  4. Select the correct environment from Select drop down list 
 *  5. Click on Home Internet menu 
 *  7. Go to Internet Package section, select any package and click on Add to Cart 
 *  8. Enter valid address under "IS the Customer new to FIDO" and click on Check Availability button
 *  9. Click on COntinue. 
 *  10. Click on Checkout 
 *  11. Enter valid information in the 1) Profile section 
 *  12. Click on Next  
 *  13. Enter appropriate/valid information in all of mandatory fields then Create account section - Check the Customer agrees to this credit check 
 *  14. Click on Confirm 
 *  15. Select the Service address
 *  16. Click on COnfirm 
 *  17. Select Invoice option from drop down list  
 *  18. Click on Confirm button  
 *  19. Scroll down to Additional agreement section, scroll all the way down and check the "I  have read ….." check box 
 *  20. Click on submit
 *
 **/

public class FidoCH_Regression_TC_006_CFAHSIAnonymousLoginTest extends BaseTestClass {

	@Test(invocationCount = 1)
	public void checkSSPhsiAnonymousLogin() {
		reporter.reportLogWithScreenshot("Rogers outlook login page has launched");
		retailer_champ_page.setUsername(TestDataHandler.fidoSspHSIAccount.getUsername());
		reporter.reportLogWithScreenshot("Entered the username");
		retailer_champ_page.clkNext();
		reporter.reportLogWithScreenshot("sign in has launched");
		retailer_champ_page.setPassword(TestDataHandler.fidoSspHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the password");
		retailer_champ_page.clkSignIn();		
		reporter.reportLogWithScreenshot("Notice Popup has Launched"); 
		retailer_champ_page.clkAccept();
		reporter.reportLogWithScreenshot("Dealercode page has Launched"); 
		retailer_champ_page.setDealerCode(TestDataHandler.fidoSspHSIAccount.getDealercode());		
		reporter.reportLogWithScreenshot("Entered the Dealercode");
		retailer_champ_page.clkSubmit();
		
		reporter.hardAssert(retailer_champ_page.verifyAuthorized(),"Authorized","Authorization failed");
		reporter.reportLogWithScreenshot("SSP launchpad has launched");
		retailer_champ_page.selSSPEnvironment(TestDataHandler.fidoSspHSIAccount.getSspEnv());
		reporter.reportLogWithScreenshot("Launched the Customer Information Security Popup");
		fido_ssp_retailer_shop_page.clkSecurityAccept();
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyLoginBanner(),"Launched the Login Banner","Login Banner hasn't Launched");
		
		reporter.reportLogWithScreenshot("SSP dashboard has launched");		
		fido_ssp_retailer_home_page.selectEnvironment(TestDataHandler.fidoSspHSIAccount.getEnvironment());
		reporter.reportLogWithScreenshot("Shop home page has Lanched");
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failied");
		reporter.reportLogWithScreenshot("Launched the Fido.ca Home page");
		reporter.reportLogWithScreenshot("Cart-summary Page to select the plan");
        fido_Shop_internet_page.selectPlan();
        String  strAddressLine1=(String) TestDataHandler.fidoSspHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.fidoSspHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkCheckAvailabilityConfirmation(); 
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_Shop_internet_page.clkpackselectedNContinue();
        reporter.reportLogWithScreenshot("Create user page has launched to give the user information");
        fido_create_user_page.setEmail();
        fido_create_user_page.setFirstName();
        fido_create_user_page.setLastName();
        reporter.reportLogWithScreenshot("Entered the user personal information");
        fido_create_user_page.setPhone();
        reporter.reportLogWithScreenshot("Entered the user communication information");
        fido_create_user_page.clkUserProfileNext();
        reporter.reportLogWithScreenshot("Credit evalution page has launched");
        fido_credit_check_page.selectDOBYear();
        fido_credit_check_page.selectDOBMonthSingleDigit();
        fido_credit_check_page.selectDOBDay();
        reporter.reportLogWithScreenshot("Entered the user DOB information");
        fido_credit_check_page.selectFirstIdOption("2");
        fido_credit_check_page.selectDrivingLicenseProvince("ON");
        fido_credit_check_page.selectDrivingLicenseExpiryYear();
        fido_credit_check_page.selectDrivingLicenseExpiryMonthSingleDigit();
        fido_credit_check_page.selectDrivingLicenseExpiryDay();
        fido_credit_check_page.setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Entered the Driver's License information");
        fido_credit_check_page.selectSecondIdOption("4");
        fido_credit_check_page.setPassportNumber();
        fido_credit_check_page.selectPassportExpiryYear();
        fido_credit_check_page.selectPasspoartExpiryMonth();
        fido_credit_check_page.selectPasspoartExpiryDay();
        reporter.reportLogWithScreenshot("Entered the passport information");
        fido_credit_check_page.clkCreditCheckConsent();
        reporter.reportLogWithScreenshot("Credit consent Check Done");
        fido_credit_check_page.clkCreditCheckSubmit();
        reporter.reportLogWithScreenshot("Tech-Install page has launched");
        fido_technical_installation_page.clkTechInstalConfirm();      
        reporter.reportLogWithScreenshot("Order review page has launched");
		fido_internet_package_change_review_order_page.clkscrollToElement();
		fido_internet_package_change_review_order_page.chkAgreementConsentCheckbox();	

		reporter.reportLogWithScreenshot("Consent Check has Done");
		fido_internet_package_change_review_order_page.clkReviewSubmitButton();
		reporter.reportLogWithScreenshot("Order Confirmation and details page");
		reporter.hardAssert(fido_order_confirmation_page.verifyOrderConfirm(), "Order has careted", "Order hasn't careted");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.chConfig.getSspURL(), strBrowser,strLanguage,FidoEnums.GroupName.connectedhome_anonymous,  method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
