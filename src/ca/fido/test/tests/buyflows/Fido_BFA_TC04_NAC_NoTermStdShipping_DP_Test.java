package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC04 - Regression - [FNAC TERM] - Perform Fido Net New Activation - TERM with Standard Shipping(No Term Plan)_E2E
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC04_NAC_NoTermStdShipping_DP_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","NACBFA","DP"})
	public void tc04_FidoNACNoTermStdShippingDPAddon() {
		getReporter().reportLog("URL:" + System.getProperty("AWSUrl"));
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc04NoTermStandardShipping.getDeviceName()),"Device Found and Selected","Device Not Found");
		//getReporter().reportLogWithScreenshot("Required device is selected on the choose phone page " +TestDataHandler.tc04NoTermStandardShipping.getDeviceName());
		getReporter().hardAssert(getFidodeviceconfigpage().isModalDisplayed(),"Modal element is present on the screen" , "Modal element is not present on the screen");
		//getReporter().reportLogWithScreenshot("Modal window displayed");
		getFidodeviceconfigpage().clickGetStartedButtonOnModal();
		getReporter().reportLogPass("Clicked Get Started Button on the modal window");
		getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Device config page loaded","Device config page not loaded");
		getReporter().reportLogWithScreenshot("Device config page");
		getFidodeviceconfigpage().clickContinueButton();
		getReporter().reportLogPass("Continue button clicked on the device config page");
		getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");
		//getFidobuildplanpage().clkNoTermTierInDeviceCost();
		//String deviceCostIndex = TestDataHandler.tc04NoTermStandardShipping.getDeviceCostIndex();
		//getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
		getFidobuildplanpage().clkRadioButtonNoTerm();
		getReporter().reportLogPassWithScreenshot("No Term Tier selected in the Device cost");
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogPass("Continue button on select your device cost clicked");
		//getFidobuildplanpage().clkContinueDataOption();
		getFidobuildplanpage().clkBasicTab();
		getReporter().reportLogWithScreenshot("Basic tab selected");
		getFidobuildplanpage().selectBasicPlanAndClkContinueBtn(TestDataHandler.tc04NoTermStandardShipping.getDataOptionIndex(),this.getClass().getSimpleName());
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPassWithScreenshot("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().selectDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection Addon is selected");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().hardAssert(getFidobuildplanpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String dpAddon = getFidobuildplanpage().getDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection - " +dpAddon);
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().reportLogPass("Proceed to checkout button clicked");
		getReporter().hardAssert(getFidocreateuserpage().verifyCreateUserProfilePage() , "create user profile page loaded" , "create user profile page not loaded");
		getReporter().reportLogPass("User profile page");
		getFidocreateuserpage().setCommunicationDetails();
		getFidocreateuserpage().setFirstName();
		getFidocreateuserpage().setLastName();
		getReporter().reportLogWithScreenshot("Entered email,  first name and last name");
		getFidocreateuserpage().setSpecificPhoneNumber(TestDataHandler.tc04NoTermStandardShipping.getContactNumber());
		getFidocreateuserpage().setHomeAddress(TestDataHandler.tc04NoTermStandardShipping.getBillingAddress());
		getReporter().reportLogWithScreenshot("Phone number  and home address set");
		getFidocreateuserpage().clkContinue();
		//issue in DOBYear
		getFidocreditcheckpage().selectDOBYear();
		getFidoCheckOutPage().clkBtnNoThanks();
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		//getFidocreditcheckpage().selectIdType(TestDataHandler.tc04NoTermStandardShipping.getIdentificationType());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc04NoTermStandardShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc04NoTermStandardShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();
		getFidocreditcheckpage().clkCreditCheckConsent();
		getReporter().reportLogWithScreenshot("Credit Evaluation page");
		getFidocreditcheckpage().clkContinue();
		getFidocreditcheckpage().waitForCreditCheckProcessing();
		getFidochoosenumberpage().selectCity(TestDataHandler.tc04NoTermStandardShipping.getCtnCity());
		getFidochoosenumberpage().selectFirstAvailableNumber();
		getReporter().reportLogWithScreenshot("Phone Number selected");
		getFidochoosenumberpage().clkContinue();
		getFidopaymentoptionspage().setManualPaymentMethod();
		getReporter().reportLogWithScreenshot("Payment method selected");
		getFidopaymentoptionspage().billingOptionClkContinue();
		getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
		getFidoCheckOutPage().clkShippingType("STANDARD");
		getReporter().reportLogWithScreenshot("Shipping selected");
		getFidoCheckOutPage().clkShippingContinueButton();
		getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
		getFidoCheckOutPage().clkSubmitButton();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("Order Review page");
		getReporter().hardAssert(getFidoorderreviewpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String deviceProtectionAddon = getFidoorderreviewpage().getDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getReporter().reportLogWithScreenshot("Terms and conditions clicked");
		getFidoorderreviewpage().clkSubmitMyOrder();
		getReporter().reportLogPass("Submit button selected on review page");
		//getFidopaymentpage().clkRadioPayWithAnotherCreditCard();
		getReporter().reportLogWithScreenshot("OneTime payment page displayed");
		getReporter().softAssert(getFidopaymentpage().verifyOneTimePaymentTitle(),
				"One Time Payment Page displayed","One Time Payment Page Not displayed");
		String otpAmount = getFidopaymentpage().getOneTimePaymentAmount();
		getReporter().reportLogWithScreenshot("One Time Payment Amount = " +otpAmount);
		getFidopaymentpage().setCreditCardName();
		getFidopaymentpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber2());
		getFidopaymentpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth2() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear2());
		getFidopaymentpage().setCreditCardCvv(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCvv2());
		getReporter().reportLogWithScreenshot("OneTime payment page displayed before submitting");
		getFidoorderreviewpage().clkSubmitMyOrder();
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
		getReporter().reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
