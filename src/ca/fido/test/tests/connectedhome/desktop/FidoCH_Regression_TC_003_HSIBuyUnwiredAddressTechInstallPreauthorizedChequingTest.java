package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the HSI buy flow with un-wired address, tech-install and preauthorized chequing for Fido.ca
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Click on internet link.
 *2. Choose an offer and click on Add to Cart button.
 *3. Enter the unwired address in serviceability check overlay and click on search lens.
 *4. Click continue button in the overlay.
 *5. Click on checkout button in shopping cart summary page.
 *6. Select/fill required details in create profile page and click next.
 *7. Select/fill required details in credit check page and click next.
 *8. Select tech install as the fulfillment option, fill the required details and click next.
 *9. Select pre-authorized chequing as the payment option, fill in the required details and click next.
 *10. Click on edit option for package in review page.
 *11. Change your internet package and click next.
 *12. Click checkout in shopping cart summary page.
 *13. Select the checkbox for terms and conditions and click submit.
 *14.  Verify that order number is shown in the order confirmation page.
 *15. Verify that order is reflected in the My Account section. 
 *
 **/

public class FidoCH_Regression_TC_003_HSIBuyUnwiredAddressTechInstallPreauthorizedChequingTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkBuyUnwiredAddressTechInstallPreauthorizedChequingTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
        fido_home_page.clkShop();
        fido_home_page.clkHomeInternet();
        reporter.reportLogWithScreenshot("Launched the packages Page");
        fido_Shop_internet_page.selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        reporter.reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setInternetAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkServiceAvailabilityCheck();        
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_Shop_internet_page.clkBuyNowReskin();
        reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");       
        fido_cart_summary_page.clkInternetCheckout();              
        reporter.reportLogWithScreenshot("Create user page has launched to give the user information");
        fido_create_user_page.setCommunicationDetails();
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
        reporter.reportLogWithScreenshot(" selected the slot for Tech-Instal");
        fido_technical_installation_page.clkTechInstalConfirm();
        reporter.reportLogWithScreenshot("Payment page has launched");
        fido_payment_options_page.setCreditCardNumber(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        fido_payment_options_page.selectExpiryMonth();
        fido_payment_options_page.selectExpiryYear();
        fido_payment_options_page.setCVV();
        reporter.reportLogWithScreenshot("Payment details has set");
        fido_payment_options_page.clkPaymentConfirm();
        reporter.reportLogWithScreenshot("Order review page has launched");
        reporter.hardAssert(fido_internet_package_change_review_order_page.verifyFidoTermsAndConditions(), "Terms And Conditions are verifed", "Terms And Conditions verification has failed");
		fido_internet_package_change_review_order_page.clkscrollToElement();
		fido_internet_package_change_review_order_page.chkAgreementConsentCheckbox();
		reporter.reportLogWithScreenshot("Consent Check has Done");
		fido_internet_package_change_review_order_page.clkReviewSubmitButton();
		reporter.reportLogWithScreenshot("Order Success and order confirmation details");
		reporter.hardAssert(fido_order_confirmation_page.verifyOrderConfirm(), "Order has created", "Order hasn't created");
		reporter.reportLogWithScreenshot("Order details");
	}
	


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,FidoEnums.GroupName.connectedhome_anonymous, method);

	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
