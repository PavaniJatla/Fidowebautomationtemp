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
 * TC02 - Regression - [FNAC BYOD] - Perform Fido Net New Activation - BYOD with Express Pickup Shipping - BOPIS_E2E
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC02_POM_RegularPromoMSF_NAC_ByodNoTermWithExpressShipping_DP_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","NACBFA","NACBFABYOD"})
	public void tc02_POMRegularPromoMSFFidoNACByodExpressShipping() {
		getReporter().reportLog("URL:" + System.getProperty("AWSUrl"));
		getReporter().reportLogWithScreenshot("Fido plan config page");
		// ***************************Promo Section************************************
		getReporter().reportLogWithScreenshot("Regular Promo MSF Applied");
		//getReporter().hardAssert(getFidobuildplanpage().verifyPromoSuccessMsg(), "Promotion Applied Successfully", "Promotion Not Applied");
		//String regularPromoName = getFidobuildplanpage().getRegularPromoName();
		//getReporter().reportLogPassWithScreenshot("Regular Promo Name " +regularPromoName);
		// ***************************Plan Builder page************************************
		getFidobuildplanpage().clkDataOption(TestDataHandler.tc02ByodExpressShipping.getDataOptionIndex(),this.getClass().getSimpleName());
		getReporter().reportLogPass("Data, Talk and Text Plan selected");
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		//getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().selectBYODdpAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection Addon option is selected");
		getFidobuildplanpage().enterDPIMEI(TestDataHandler.tc02ByodExpressShipping.getDpIMEI());
		getReporter().reportLogPassWithScreenshot("DP Addon IMEI Entered");
		getFidobuildplanpage().setDPDeviceStorage(TestDataHandler.tc02ByodExpressShipping.getDpDeviceStorage());
		getReporter().reportLogPassWithScreenshot("DP Addon Device Storage Selected");
		getFidobuildplanpage().setDPDeviceColor(TestDataHandler.tc02ByodExpressShipping.getDpDeviceColor());
		getReporter().reportLogPassWithScreenshot("DP Addon Device Color Selected");
		getFidobuildplanpage().clkDpEligCheckBtn();
		getReporter().hardAssert(getFidobuildplanpage().verifyEligibilityMsg(),"Entered IMEI is eligible for Device Protection Addon","Entered IMEI is not eligible");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogPass("Continue button on AddOns clicked");
		getFidobuildplanpage().clickeSIMContinueButton();
		getReporter().hardAssert(getFidobuildplanpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String dpAddon = getFidobuildplanpage().getDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection - " +dpAddon);
		getReporter().hardAssert(getFidobuildplanpage().verifyCartLineItem(),"Promo Discount amount Line Item displayed",
				"Promo line item not displayed");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().reportLogPass("Proceed to checkout button clicked");
		getFidoShippingCartPage().clkProceedShoppingCart();
		getReporter().hardAssert(getFidocreateuserpage().verifyCreateUserProfilePage() , "create user profile page loaded" , "create user profile page not loaded");
		getReporter().reportLogPass("User profile page");
		getFidocreateuserpage().setCommunicationDetails();
		getFidocreateuserpage().setFirstName();
		getFidocreateuserpage().setLastName();
		getReporter().reportLogWithScreenshot("Entered email,  first name and last name");
		getFidocreateuserpage().setSpecificPhoneNumber(TestDataHandler.tc02ByodExpressShipping.getContactNumber());
		getFidocreateuserpage().setHomeAddress(TestDataHandler.tc02ByodExpressShipping.getBillingAddress());
		getReporter().reportLogWithScreenshot("Phone number  and home address set");
		getFidocreateuserpage().clkContinue();
		getFidocreditcheckpage().selectDOBYear();
		//getFidoCheckOutPage().clkNoThanks();
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		//getFidocreditcheckpage().selectIdType(TestDataHandler.tc02ByodExpressShipping.getIdentificationType());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc02ByodExpressShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc02ByodExpressShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();
		getFidocreditcheckpage().clkCreditCheckConsent();
		getReporter().reportLogWithScreenshot("Credit Evaluation page");
		getFidocreditcheckpage().clkContinue();
		getFidocreditcheckpage().waitForCreditCheckProcessing();
		getFidochoosenumberpage().selectCity(TestDataHandler.tc02ByodExpressShipping.getCtnCity());
		getFidochoosenumberpage().selectFirstAvailableNumber();
		getReporter().reportLogWithScreenshot("Phone Number selected");
		getFidochoosenumberpage().clkContinue();
		getFidochoosenumberpage().clkContinueAfterFirstNameLastName();
		getFidopaymentoptionspage().setManualPaymentMethod();
		getReporter().reportLogWithScreenshot("Payment method selected");
		getFidopaymentoptionspage().clickSkipAutopay();
		getFidopaymentoptionspage().billingOptionClkContinue();
		getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
		getFidoCheckOutPage().clkShippingType("EXPRESS");
		getReporter().reportLogWithScreenshot("Shipping selected");
		getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
		getFidoCheckOutPage().clkShippingContinueButton();
		getFidoCheckOutPage().clksaveAndContinueBtnCheckoutPage();
		getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
		getFidoCheckOutPage().clkSubmitButton();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("Order Review page");
		getReporter().hardAssert(getFidoorderreviewpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String deviceProtectionAddon = getFidoorderreviewpage().getDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().setOrderCommunicationConsent();
		getReporter().reportLogPass("Terms and conditions clicked");
		getFidoorderreviewpage().clkSubmitMyOrder();
		getReporter().reportLogPass("Submit button selected");
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
