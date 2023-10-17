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
 * TC03 - Regression - [FNAC TERM] - Perform Fido Net New Activation - TERM with Express Pickup Shipping(Finance Plan) - BOPIS_E2E
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC03_NAC_TermExpressShipping_AutoPay_MediumRisk_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","NACBFA","SanityBFA"})
	public void tc03_FidoNACTermAutoPayExpressShippingMediumRisk() {
		getReporter().reportLog("URL:" + System.getProperty("AWSUrl"));
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc03TermBopis.getDeviceName()),"Device Found and Selected","Device Not Found");
		getReporter().reportLogWithScreenshot("Required device is selected on the choose phone page " +TestDataHandler.tc03TermBopis.getDeviceName());
		getReporter().hardAssert(getFidodeviceconfigpage().isModalDisplayed(),"Modal element is present on the screen" , "Modal element is not present on the screen");
		getReporter().reportLogWithScreenshot("Modal window displayed");
		getFidodeviceconfigpage().clickGetStartedButtonOnModal();
		getReporter().reportLogPass("Clicked Get Started Button on the modal window");
		getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Device config page loaded","Device config page not loaded");
		getReporter().reportLogWithScreenshot("Device config page");
		String deviceCost = getFidodeviceconfigpage().getDeviceFullPrice();
		String financeProgramCredit = "0.0";
		financeProgramCredit = getFidodeviceconfigpage().getFinanceProgramCreditPrice();
		getFidodeviceconfigpage().clickContinueButton();
		getReporter().reportLogPass("Continue button clicked on the device config page");
		getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");
		getFidobuildplanpage().clkDownPaymentChkBox();
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogPass("Continue button on select your device cost clicked");
//		getReporter().hardAssert(getFidobuildplanpage().verifyAutoPayPlanSelection(getFidobuildplanpage().getAutoPayPlanIndex("MSF"),this.getClass().getSimpleName()),
//				"Autopay plan is selected successfully","Autopay plan is not selected");
		//getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getFidobuildplanpage().clkContinueDataOption();
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		//getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().clkContinueDeviceProtection();
		getReporter().hardAssert(getFidobuildplanpage().verifyAutoPayDiscountInCartSummary(),"AutoPay discount is added in cart summary","AutoPay is not added in cart summary");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().reportLogPass("Proceed to checkout button clicked on Build Plan Page");
		getFidoShippingCartPage().clkProceedShoppingCart();
		getReporter().reportLogPass("Proceed to checkout button clicked on Shopping Cart");
		getReporter().hardAssert(getFidocreateuserpage().verifyCreateUserProfilePage() , "create user profile page loaded" , "create user profile page not loaded");
		getReporter().reportLogPass("User profile page");
		getFidocreateuserpage().setCommunicationDetails();
		getFidocreateuserpage().setFirstName();
		getFidocreateuserpage().setLastName();
		getReporter().reportLogWithScreenshot("Entered email,  first name and last name");
		getFidocreateuserpage().setSpecificPhoneNumber(TestDataHandler.tc03TermBopis.getContactNumber());
		getFidocreateuserpage().setHomeAddress(TestDataHandler.tc03TermBopis.getBillingAddress());
		getReporter().reportLogWithScreenshot("Phone number  and home address set");
		getFidocreateuserpage().clkContinue();
		getFidocreditcheckpage().selectDOBYear();
		//getFidocreditcheckpage().clkNoThanks();
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear());
		//getFidocreditcheckpage().selectIdType(TestDataHandler.tc03TermBopis.getIdentificationType());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc03TermBopis.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc03TermBopis.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();
		getFidocreditcheckpage().clkCreditCheckConsent();
		getReporter().reportLogWithScreenshot("Credit Evaluation page");
		getFidocreditcheckpage().clkContinue();
		getFidocreditcheckpage().waitForCreditCheckProcessing();
		String expectedDownPayment = getFidocreditcheckpage().setDownPaymentUpfrontEdge(TestDataHandler.tc03TermBopis.getRiskClass(),deviceCost,financeProgramCredit);
		getReporter().reportLog("Expected DownPayment: <b> " +expectedDownPayment +"</b>");
//		getReporter().hardAssert(getFidocreditcheckpage().verifyDownPaymentAmt(expectedDownPayment),
//				"Downpayment amount is displayed correctly", "Downpayment amount is not displayed correctly");
		getFidocreditcheckpage().clkAcceptButton();
		getFidochoosenumberpage().selectCity(TestDataHandler.tc03TermBopis.getCtnCity());
		getFidochoosenumberpage().selectFirstAvailableNumber();
		//getFidoCheckOutPage().clkNoThanks();
		getReporter().reportLogWithScreenshot("Phone Number selected");
		getFidochoosenumberpage().clkContinue();
		getFidochoosenumberpage().clkContinueAfterFirstNameLastName();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyAutoPaymentPage(),"Autopay payment page is displayed","Autopay payment page is not displayed");
		getFidopaymentoptionspage().enterBankDetails();
		getFidopaymentoptionspage().clkAutoPayConsentCheckBox();
		getReporter().reportLogWithScreenshot("AutoPay Enrolled - Bank Method");
		getFidopaymentoptionspage().billingOptionClkContinue();
		//getFidoCheckOutPage().clkNoThanks();
		getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
		getFidoCheckOutPage().clkShippingType("EXPRESS");
		getReporter().reportLogWithScreenshot("Shipping selected");
		getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
		getFidoCheckOutPage().clkShippingContinueButton();
		getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
		getFidoCheckOutPage().clksaveAndContinueBtnCheckoutPage();
		getFidoCheckOutPage().clkSubmitButton();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("Order Review page");
		boolean isPaymentRequired = getFidoorderreviewpage().verifyPaymentRequired();
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
		getFidoorderreviewpage().setOrderCommunicationConsent();
		getReporter().reportLogWithScreenshot("Terms and conditions clicked");
		getFidoorderreviewpage().clkSubmitMyOrder();
		getReporter().reportLogPass("Submit button selected on review page");
		if(isPaymentRequired) {
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
		}
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
