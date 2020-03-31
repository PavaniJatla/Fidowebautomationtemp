package ca.fido.test.tests.buyflow;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * TC01-Fido-Validate User able to perform NAC Flow (Single Line) for $0 device- Without payment
 * 
 * Launch Fido.ca
 * Click on Shop->wireless->View all devices
 * select a device with $0
 * Select a plan for the device and click continue
 * Choose Addon's(optional) and click continue
 * Review cart summary page and click on continue
 * Enter the necessary details for profile creation and click on continue
 * Enter the credit card and Personal ID details
 * Select a number for the device and click on save
 * select any payment option and click on submit
 * Review your order and click on continue
 * 
 * @author rajesh.varalli1
 *
 */
public class Fido_BFA_TC01_NAC_SL_ZeroUpfront_NoPayment_Test extends BaseTestClass{

	@Test
	public void fidoSingleLineNAC() {
		reporter.reportLogWithScreenshot("Home Page");
		fido_home_page.clkShop();
		fido_home_page.clkPhones();
		reporter.hardAssert(fido_choose_phone_page.verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		reporter.reportLogWithScreenshot("PHONES & DEVICES page");
		//fido_choose_phone_page.selectFirstZeroUpfrontDeviceAvailable();
		reporter.hardAssert(fido_choose_phone_page.selectDevice("iPhone 11"),"Device Found and Selected","Device Not Found");
		fido_build_plan_page.selectDataPlanCategory();
		reporter.hardAssert(fido_build_plan_page.selectFirstAvailablePricePlan(),"Selected a Price Plan","Failed to Select a Price Plan");
		reporter.reportLogWithScreenshot("Build Plan page");
		fido_build_plan_page.clkContinue();
		reporter.reportLogWithScreenshot("Existing Customer overlay");
		fido_build_plan_page.clkCreateAccount();
		reporter.reportLogWithScreenshot("Choose Add-ons page");
		fido_choose_addons_page.clkContinue();
		reporter.reportLogWithScreenshot("CART SUMMARY page");
		fido_cart_summary_page.clkContinue();
		fido_create_user_page.setCommunicationDetails();
		fido_create_user_page.setFirstName();
		fido_create_user_page.setLastName();
		fido_create_user_page.setPhone();
		fido_create_user_page.setHomeAddress(TestDataHandler.testCase01.getBillingAddress());
		reporter.reportLogWithScreenshot("Create User page");
		fido_create_user_page.clkContinue();
		fido_credit_check_page.selectDOBYear();
		fido_credit_check_page.selectDOBMonth();
		fido_credit_check_page.selectDOBDay();
		fido_credit_check_page.setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		fido_credit_check_page.setCreditCardExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
		fido_credit_check_page.setCreditCardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		fido_credit_check_page.selectDrivingLicenseProvince(TestDataHandler.testCase01.getDlProvinceCode());
		fido_credit_check_page.setDrivingLicenseNumber(TestDataHandler.testCase01.getDlProvinceCode());
		fido_credit_check_page.selectDrivingLicenseExpiryYear();
		fido_credit_check_page.selectDrivingLicenseExpiryMonth();
		fido_credit_check_page.selectDrivingLicenseExpiryDay();
		fido_credit_check_page.clkCreditCheckConsent();
		reporter.reportLogWithScreenshot("Credit Evaluation page");
		fido_credit_check_page.clkContinue();
		fido_credit_check_page.waitForCreditCheckProcessing();
		fido_credit_check_page.setSecurityDepositConsent();
		fido_choose_number_page.clkSelectNewNumber();
		fido_choose_number_page.selectCity(TestDataHandler.testCase01.getCtnCity());
		fido_choose_number_page.clkFindAvailableNumbers();
		fido_choose_number_page.selectFirstAvailableNumber();
		reporter.reportLogWithScreenshot("Choose Phone Number page");
		fido_choose_number_page.clkContinue();
		fido_payment_options_page.setManualPaymentMethod();
		reporter.reportLogWithScreenshot("Payment Options page");
		fido_payment_options_page.clkSubmit();
		fido_order_review_page.clkTermsNConditionsConsent();
		fido_order_review_page.setContractDigitalCopyEmail();
		reporter.reportLogWithScreenshot("Order Review page");
		fido_order_review_page.clkContinueToPayment();
		fido_order_review_page.waitForOrderProcessing();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}
	
	@Parameters({"strBrowser", "strLanguage", "strGroupName"})
	@BeforeTest
    public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, String strGroupName, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.fidoConfig.getFidoURL(), strBrowser,strLanguage, strGroupName,  method);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
