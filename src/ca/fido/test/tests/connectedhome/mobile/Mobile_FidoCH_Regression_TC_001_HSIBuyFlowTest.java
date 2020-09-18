package ca.fido.test.tests.connectedhome.mobile;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the HSI buy flow for Fido.ca   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Click on home internet under shop menu
 *3. Click on check Availability button
 *4. Enter valid address address in serviceability check pop up and click on Check availablity button.
 *5. Click on Buy online option
 *6. Select any Internet package form the list of packages available and click on Buy Now button
 *7. Click on Check out button
 *8. Fill in valid details in 1) Profile section
 *9. Click on Next
 *10. Fill in valid details in 2) Create account section including two IDs
 *11. Check the "Sure, lets do a Credit Evaluation" check box
 *12. Click on Confirm
 *13. Select the Service address
 *14.  Click on Confirm
 *15. Select Invoice option from dropdown list 
 *16. Click on Confirm button
 *17. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *18. Click on Submit
 *
 **/

public class Mobile_FidoCH_Regression_TC_001_HSIBuyFlowTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableMobileCH"})
	public void checkInternetBuyFlowMobile() {

		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navigation card");
		fido_home_page.clkShopMobile();
		reporter.reportLogWithScreenshot("Launched the Navigation shop links");
		fido_home_page.clkHomeInternetMobile();
        reporter.reportLogWithScreenshot("Launched the Internet Page");
		fido_home_page.clkCheckAvailabilityMobile();	
        reporter.reportLogWithScreenshot("Launched the Serviceability model");
        String  strAddressLine1=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setAddressLookupMobile(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Checking the Service availability");
        fido_Shop_internet_page.clkCheckAvailabilityConfirmation();        
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_Shop_internet_page.clkBuyOnline();
        reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");      
        fido_Shop_internet_page.selectPlan();
        fido_cart_summary_page.clkCheckout();
        reporter.reportLogWithScreenshot("Create user page has launched to give the user information");
        fido_create_user_page.setCommunicationDetails();
        reporter.reportLogWithScreenshot("Entered the user mail communication information");
        fido_create_user_page.setFirstName();
        fido_create_user_page.setLastName();
        reporter.reportLogWithScreenshot("Entered the user personal information");
        fido_create_user_page.setPhone();
        reporter.reportLogWithScreenshot("Entered the user mobile information");
        fido_create_user_page.clkUserProfileNext();
        reporter.reportLogWithScreenshot("Credit evaluation page has launched");
        fido_credit_check_page.selectDOBYear();
        fido_credit_check_page.selectDOBMonthSingleDigit();
        fido_credit_check_page.selectDOBDay();
        reporter.reportLogWithScreenshot("Entered the user DOB information");
        fido_credit_check_page.selectFirstIdOption("2");
        fido_credit_check_page.selectDrivingLicenseProvince("ON");
        reporter.reportLogWithScreenshot("Entered the Driver's License Province");
        fido_credit_check_page.selectDrivingLicenseExpiryYear();
        fido_credit_check_page.selectDrivingLicenseExpiryMonthSingleDigit();
        fido_credit_check_page.selectDrivingLicenseExpiryDay();
        reporter.reportLogWithScreenshot("Entered the Driver's License expiry details");
        fido_credit_check_page.setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Entered the Driver's License number");
        fido_credit_check_page.selectSecondIdOption("4");
        fido_credit_check_page.setPassportNumber();
        reporter.reportLogWithScreenshot("Entered the passport details");
        fido_credit_check_page.selectPassportExpiryYear();
        fido_credit_check_page.selectPasspoartExpiryMonth();
        fido_credit_check_page.selectPasspoartExpiryDay();
        reporter.reportLogWithScreenshot("Entered the passport  expiry details");
        fido_credit_check_page.clkCreditCheckConsent();
        reporter.reportLogWithScreenshot("Credit consent Check Done");
        fido_credit_check_page.clkCreditCheckSubmit();
        
        reporter.hardAssert(fido_technical_installation_page.verifyTechInstalPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Tech-Install page has launched");
        fido_technical_installation_page.clkTechInstalConfirm();
        
        reporter.hardAssert(fido_payment_options_page.verifyPaymentPage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Payment page has launched");        
        fido_payment_options_page.setCreditCardNumber(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        reporter.reportLogWithScreenshot("Set Credit Card Number"); 
        fido_payment_options_page.selectExpiryMonth();
        fido_payment_options_page.selectExpiryYear();
        reporter.reportLogWithScreenshot("set Card expiry details");
        fido_payment_options_page.setCVV();     
        reporter.reportLogWithScreenshot("Set the CVV");
        fido_payment_options_page.clkPaymentConfirm();    
        
        reporter.hardAssert(fido_internet_package_change_review_order_page.verifyFidoTermsAndConditions(),"Agreement has Launched","Agreement has not Launched");
        reporter.reportLogWithScreenshot("Order review page has launched");
		fido_internet_package_change_review_order_page.clkscrollToElement();
		fido_internet_package_change_review_order_page.chkAgreementConsentCheckbox();
		reporter.reportLogWithScreenshot("Consent Check has Done");
		fido_internet_package_change_review_order_page.clkReviewSubmitButton();
		reporter.hardAssert(fido_order_confirmation_page.verifyOrderConfirm(), "Order has created", "Order hasn't created");
		reporter.reportLogWithScreenshot("Order Success and order confirmation details");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_anonymous,   method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

