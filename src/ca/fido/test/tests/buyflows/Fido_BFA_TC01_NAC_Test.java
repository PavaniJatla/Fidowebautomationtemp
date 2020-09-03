package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC01-Fido-Validate User able to perform NAC Flow (Single Line) for $0 device- Without payment
 * 
 * Launch Fido.ca
 * Click on Shop -- wireless -- View all devices
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
public class Fido_BFA_TC01_NAC_Test extends BaseTestClass{

	@Test
	public void fidoNACFlow() {
		reporter.reportLog("URL:" + System.getProperty("AWSUrl"));
		reporter.reportLogWithScreenshot("Home Page");
		reporter.hardAssert(fido_choose_phone_page.verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		reporter.reportLogWithScreenshot("PHONES & DEVICES page");
		reporter.hardAssert(fido_choose_phone_page.selectDevice(TestDataHandler.testCase01.getDeviceName()),"Device Found and Selected","Device Not Found");
		reporter.reportLogWithScreenshot("Required device is available on the choose phone page");
		reporter.hardAssert(fido_device_config_Page.clickContinueButton(),"Continue button is visible and clicked","Continue button is not visible ");
		reporter.reportLogWithScreenshot("Continue button clicked on the device config page");
		Assert.assertTrue(fido_device_config_Page.isModalDisplayed(),"Modal element is not present on the screen");
		reporter.reportLogPass("Modal window displayed");
		Assert.assertTrue(fido_device_config_Page.verifyGetStartedButtonOnModal(),"Get started button on the modal is not present");
		fido_device_config_Page.clickGetStartedButtonOnModal();
		reporter.reportLogPass("Clicked Get Started Button");
		Assert.assertTrue(fido_build_plan_page.verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		reporter.reportLogPass("Fido plan config page");
		fido_build_plan_page.clkContinueDeviceCost();
		reporter.reportLogPass("Continue button on select your device cost clicked");
		fido_build_plan_page.clkContinueDataOption();
		reporter.reportLogPass("Continue button on Data option clicked");
		fido_build_plan_page.clkContinueTalkOptions();
		reporter.reportLogPass("Continue button on talk option clicked");
		fido_build_plan_page.clkNoBPOOfferButtonTalkOptions();
		reporter.reportLogPass("skipped BPO option");
		fido_build_plan_page.clkContinueAddOns();
		reporter.reportLogPass("Continue button on AddOns clicked");
		fido_build_plan_page.clkContinueBelowCartSummary();
		reporter.reportLogPass("Checkout cart-summary page");
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
		fido_credit_check_page.setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber());
		fido_credit_check_page.setCreditCardExpiryMonth(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth());
		fido_credit_check_page.setCreditCardExpiryYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear());
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
		if(fido_order_review_page.isPaymentRequired()) {
			fido_order_review_page.clkContinueToPayment();
			fido_payment_page.setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
			fido_order_review_page.clkCompleteOrder();
			//fido_payment_page.clkContinueOrder();
		} else {
			fido_order_review_page.clkCompleteOrder();
		}
		fido_order_review_page.waitForOrderProcessing();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}

	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("AWSUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
