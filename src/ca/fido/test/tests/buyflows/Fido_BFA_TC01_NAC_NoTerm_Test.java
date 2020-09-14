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
 * TC05- E2E FNAC - Validate NAC order submission for a NO TERM device using Talk and Text plan
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC01_NAC_NoTerm_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","NACBFA"})
	public void fidoNACFlow() {
		reporter.reportLog("URL:" + System.getProperty("AWSUrl"));
		reporter.reportLogWithScreenshot("Home Page");
		reporter.hardAssert(fido_choose_phone_page.verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		reporter.reportLogWithScreenshot("PHONES & DEVICES page");
		reporter.hardAssert(fido_choose_phone_page.selectDevice(TestDataHandler.testCase01.getDeviceName()),"Device Found and Selected","Device Not Found");
		reporter.reportLogWithScreenshot("Required device is selected on the choose phone page");
		Assert.assertTrue(fido_device_config_Page.isModalDisplayed(),"Modal element is not present on the screen");
		reporter.reportLogPass("Modal window displayed");
		Assert.assertTrue(fido_device_config_Page.verifyGetStartedButtonOnModal(),"Get started button on the modal is not present");
		fido_device_config_Page.clickGetStartedButtonOnModal();
		reporter.reportLogPass("Clicked Get Started Button on the modal window");
		reporter.hardAssert(fido_device_config_Page.clickContinueButton(),"Continue button is visible and clicked","Continue button is not visible ");
		reporter.reportLogWithScreenshot("Continue button clicked on the device config page");
		Assert.assertTrue(fido_build_plan_page.verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		reporter.reportLogPass("Fido plan config page");
		fido_build_plan_page.clkNoTermTierInDeviceCost();
		reporter.reportLogPass("No Term Tier selected in the Device cost");
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
		fido_credit_check_page.setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		fido_credit_check_page.setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		fido_credit_check_page.selectIdType(TestDataHandler.testCase01.getIdentificationType());
		fido_credit_check_page.selectDrivingLicenseProvince(TestDataHandler.testCase01.getDlProvinceCode());
		fido_credit_check_page.setDrivingLicenseNumber(TestDataHandler.testCase01.getDlProvinceCode());
		fido_credit_check_page.setDrivingLicenseExpiry();
		fido_credit_check_page.clkCreditCheckConsent();
		reporter.reportLogWithScreenshot("Credit Evaluation page");
		fido_credit_check_page.clkContinue();
		fido_credit_check_page.waitForCreditCheckProcessing();
		fido_credit_check_page.clkBtnSecurityDepositConsentAccept();
		fido_choose_number_page.clkSelectNewNumber();
		fido_choose_number_page.selectCity(TestDataHandler.testCase01.getCtnCity());
		fido_choose_number_page.selectFirstAvailableNumber();
		reporter.reportLogWithScreenshot("Choose Phone Number page");
		fido_choose_number_page.clkContinue();
		fido_payment_options_page.setManualPaymentMethod();
		fido_payment_options_page.billingOptionClkContinue();
		fido_payment_options_page.clkSubmit();
		fido_order_review_page.clkAllTermsAgreementCheckboxsNAC();
		fido_order_review_page.setContractDigitalCopyEmail();
		fido_order_review_page.clkSubmitMyOrder();
		fido_payment_page.clkRadioPayWithAnotherCreditCard();
		reporter.reportLogWithScreenshot("OneTime payment page displayed");
		fido_payment_page.setCreditCardName();
		fido_payment_page.setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber2());
		fido_payment_page.setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth2() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear2());
		fido_payment_page.setCreditCardCvv(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCvv2());
		reporter.reportLogWithScreenshot("OneTime payment page displayed before submittion");
		fido_payment_page.clkSubmitMyOrder();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Thank You message verified", "Thank You message error");
		reporter.hardAssert(fido_order_confirmation_page.verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
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
