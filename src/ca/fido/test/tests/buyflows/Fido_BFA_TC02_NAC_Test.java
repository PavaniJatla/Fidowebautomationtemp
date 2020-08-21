package ca.fido.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * TC11- E2E FNAC-Validate order is submitted for Financing plan_EN_Chrome_ON
 * @author Saurav.Goyal
 *
 */
public class Fido_BFA_TC02_NAC_Test extends BaseTestClass{

	@Test
	public void fidoNACFlow() {
		reporter.reportLog("URL:" + TestDataHandler.bfaConfig.getFidoAWSUrl());
		reporter.reportLogWithScreenshot("Home Page");
		reporter.hardAssert(fido_choose_phone_page.verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		reporter.reportLogWithScreenshot("PHONES & DEVICES page");
		reporter.hardAssert(fido_choose_phone_page.selectDevice(TestDataHandler.testCase02.getDeviceName()),"Device Found and Selected","Device Not Found");
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
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getFidoAWSUrl(), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
