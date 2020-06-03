package ca.fido.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;

/**
 * TC02-Fido-Validate User able to perform NAC Flow - Single Line BYOP
 * 
 * Launch Fido.ca
 * Click on Shop -- plans
 * Click on BYOP 
 * Select a BYOP plan for the device and click continue on add ons
 * Choose Addon's(optional) and click continue
 * Cart summary page is displayed and click on continue
 * Enter the necessary details for profile creation and click on continue
 * Enter the credit card and Personal ID details
 * Select a number for the device and click on save
 * select any payment option and click on submit
 * Review your order and click on continue
 * 
 * @author rajesh.varalli1
 *
 */
public class Fido_BFA_TC02_NAC_SL_BYOP_Test extends BaseTestClass{

	@Test
	public void fidoSingleLineNacBYOP() {
		fido_home_page.clkShop();
		fido_home_page.clkPlans();
		reporter.reportLogWithScreenshot("Choose Plans page");
		fido_choose_plan_page.clkAllPlans();
		reporter.reportLogWithScreenshot("All plans displayed");
		fido_choose_plan_page.selectFirstAvailablePricePlan();
		reporter.reportLogWithScreenshot("Mobile Plans page");		
		fido_choose_plan_page.clkContinue();
		reporter.reportLogWithScreenshot("Existing Customer and new to Fido overlay");
		fido_build_plan_page.clkCreateAccount();
		reporter.reportLogWithScreenshot("Choose SIM page");
		fido_chosse_sim_page.clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary page");
		fido_cart_summary_page.clkContinue();
		fido_create_user_page.setCommunicationDetails();
		fido_create_user_page.setFirstName();
		fido_create_user_page.setLastName();
		fido_create_user_page.setPhone();
		fido_create_user_page.setHomeAddress(TestDataHandler.testCase02.getBillingAddress());
		reporter.reportLogWithScreenshot("Create User page");
		fido_create_user_page.clkContinue();
		fido_credit_check_page.selectDOBYear();
		fido_credit_check_page.selectDOBMonth();
		fido_credit_check_page.selectDOBDay();
		fido_credit_check_page.setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber());
		fido_credit_check_page.setCreditCardExpiryMonth(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth());
		fido_credit_check_page.setCreditCardExpiryYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear());
		fido_credit_check_page.selectDrivingLicenseProvince(TestDataHandler.testCase02.getDlProvinceCode());
		fido_credit_check_page.setDrivingLicenseNumber(TestDataHandler.testCase02.getDlProvinceCode());
		fido_credit_check_page.selectDrivingLicenseExpiryYear();
		fido_credit_check_page.selectDrivingLicenseExpiryMonth();
		fido_credit_check_page.selectDrivingLicenseExpiryDay();
		fido_credit_check_page.clkCreditCheckConsent();
		reporter.reportLogWithScreenshot("Credit Evaluation page");
		fido_credit_check_page.clkContinue();
		fido_credit_check_page.waitForCreditCheckProcessing();
		fido_credit_check_page.setSecurityDepositConsent();
		fido_choose_number_page.clkSelectNewNumber();
		fido_choose_number_page.selectCity(TestDataHandler.testCase02.getCtnCity());
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
		reporter.reportLogWithScreenshot("Waiting for Order Confirmation");
		fido_order_review_page.waitForOrderProcessing();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation Page");
	}
	
	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
    public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getFidoURL(), strBrowser,strLanguage, FidoEnums.GroupName.BUYFLOWS ,  method);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
