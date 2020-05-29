package ca.fido.test.tests.connectedhome;

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
import ca.fido.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to test the HSI buy flow for existing mobile customer   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Login with valid credentials
 *3. Click on home internet under shop menu
 *4. Click on check Availability button
 *5. Enter valid address address in serviceability check pop up and click on Check availablity button.
 *6. Click on Buy online option
 *7. Select any Internet package form the list of packages available and click on Buy Now button
 *8. Click on Check out button
 *9. Fill in valid details in 1) Profile section
 *10. Click on Next
 *11. Fill in valid details in 2) Create account section including two IDs
 *12. Check the "Sure, lets do a Credit Evaluation" check box
 *13. Click on Confirm
 *14. Select the Service address
 *15.  Click on Confirm
 *16. Select Invoice option from dropdown list 
 *17. Click on Confirm button
 *18. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *19. Click on Submit
 *
 **/

public class FidoCH_Regression_TC_004_HSIBuyFlowForExistingCustomerTest extends BaseTestClass {

	@Test
	public void checkInternetBuyFlowForExistingCustomer() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameMobile());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the credentials");
		fido_login_page.clkLoginInFrame();
        fido_home_page.clkShop();
        fido_home_page.clkHomeInternet();
        reporter.reportLogWithScreenshot("Home Internet has selected");        
        fido_Shop_internet_page.clkCheckAvailability();
        String  strAddressLine1=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkCheckAvailabilityConfirmation();
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_internet_dashboard_page.clkContinueForInternet();
        reporter.reportLogWithScreenshot("launche ratecard page");
        fido_Shop_internet_page.verifyPlanInfomationForExistingCustomer(TestDataHandler.fidoWirelessAccount.getaccountDetails().getDowngradePlan());
        fido_cart_summary_page.clkCheckout();
        reporter.reportLogWithScreenshot("Create user page has launched to give the user information");
        fido_create_user_page.clkUserProfileNextForExistingCustomer();
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
/*	    fido_technical_installation_page.clkFulfillmentTechInstall();
	    fido_technical_installation_page.clkTechInstallSlot();*/
	    reporter.reportLogWithScreenshot(" selected the slot for Tech-Instal");
	    fido_technical_installation_page.clkTechInstalConfirm();
	    reporter.reportLogWithScreenshot("Payment page has launched"); 
	   // fido_payment_options_page.selectPaymentMode("invoice");
        fido_payment_options_page.setCreditCardNumber(TestDataHandler.fidoPaymentInfo.getCreditCardDetails().getNumber());
        fido_payment_options_page.selectExpiryMonth();
        fido_payment_options_page.selectExpiryYear();
        fido_payment_options_page.setCVV();
        reporter.reportLogWithScreenshot("Payment details has set");
	    fido_payment_options_page.clkPaymentConfirm();
        reporter.reportLogWithScreenshot("Order review page has launched");
        //reporter.hardAssert(fido_internet_package_change_review_order_page.verifyPlanInfomation(TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlan()),"Plan information has verifed", "Plan information has failed");
        reporter.hardAssert(fido_internet_package_change_review_order_page.verifyFidoTermsAndConditions(), "Terms And Conditions are verifed", "Terms And Conditions verification has failed");
		fido_internet_package_change_review_order_page.clkscrollToElement();
		fido_internet_package_change_review_order_page.chkAgreementConsentCheckbox();
		reporter.reportLogWithScreenshot("Consent Check has Done");
		fido_internet_package_change_review_order_page.clkReviewSubmitButton();
		reporter.reportLogWithScreenshot("Order Success and order confirmation details");
		reporter.hardAssert(fido_order_confirmation_page.verifyOrderConfirm(), "Order has created", "Order hasn't created");	
        
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(TestDataHandler.fidoConfig.getFidoURL(), strBrowser,strLanguage, strGroupName, method);
	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

