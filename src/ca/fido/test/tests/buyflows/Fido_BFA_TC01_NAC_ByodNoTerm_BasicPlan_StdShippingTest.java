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
 * TC01 - Regression - [FNAC BYOD] - Perform Fido Net New Activation - BYOD with Standard Shipping_E2E
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC01_NAC_ByodNoTerm_BasicPlan_StdShippingTest extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","NACBFA","NACBFABYOD"})
	public void tc01_FidoNACByodTermStdShipping() {
		//getFidobuildplanpage().setProvince("Ontario");
		getReporter().reportLog("URL:" + System.getProperty("AWSUrl"));
		getReporter().reportLogWithScreenshot("Fido plan config page");
		//getFidobuildplanpage().clkDataAndTextPlan();
		getFidobuildplanpage().clkBasicTab();
		getFidobuildplanpage().selectBasicPlanAndClkContinueBtn(TestDataHandler.tc01ByodStandardShipping.getDataOptionIndex(),this.getClass().getSimpleName());
		getReporter().reportLogPass("Basic Plan selected");
		/*getFidobuildplanpage().clkFirstTierChooseYourDataAAL();
		getFidobuildplanpage().clkContinueDataOption();*/
		getFidobuildplanpage().differentPlanSelectionModal();
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		//getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		//getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getFidobuildplanpage().clkContinueDeviceProtection();
		getFidobuildplanpage().clickeSIMContinueButton();
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().reportLogPass("Proceed to checkout button clicked");
		getReporter().hardAssert(getFidocreateuserpage().verifyCreateUserProfilePage() , "create user profile page loaded" , "create user profile page not loaded");
		getReporter().reportLogPass("User profile page");
		getFidocreateuserpage().setCommunicationDetails();
		getFidocreateuserpage().setFirstName();
		getFidocreateuserpage().setLastName();
		getReporter().reportLogWithScreenshot("Entered email,  first name and last name");
		getFidocreateuserpage().setSpecificPhoneNumber(TestDataHandler.tc01ByodStandardShipping.getContactNumber());
		getFidocreateuserpage().setHomeAddress(TestDataHandler.tc01ByodStandardShipping.getBillingAddress());
		getReporter().reportLogWithScreenshot("Phone number  and home address set");
		getFidocreateuserpage().clkContinue();
		getFidocreditcheckpage().selectDOBYear();
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		//getFidocreditcheckpage().selectIdType(TestDataHandler.tc01ByodStandardShipping.getIdentificationType());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc01ByodStandardShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc01ByodStandardShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();
		getFidocreditcheckpage().clkCreditCheckConsent();
		getReporter().reportLogWithScreenshot("Credit Evaluation page");
		getFidocreditcheckpage().clkContinue();
		getFidocreditcheckpage().waitForCreditCheckProcessing();
		getFidochoosenumberpage().selectCity(TestDataHandler.tc01ByodStandardShipping.getCtnCity());
		//getFidocreditcheckpage().clkNoThanks();
		getFidochoosenumberpage().selectFirstAvailableNumber();
		getReporter().reportLogWithScreenshot("Phone Number selected");
		//getFidoCheckOutPage().clkNoThanks();
		getFidochoosenumberpage().clkContinue();
		getFidopaymentoptionspage().setManualPaymentMethod();
		getReporter().reportLogWithScreenshot("Payment method selected");
		getFidopaymentoptionspage().billingOptionClkContinue();
		//getFidoCheckOutPage().clkNoThanks();
		getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
		getFidoCheckOutPage().clkShippingType("STANDARD");
		getReporter().reportLogWithScreenshot("Shipping selected");
		getFidoCheckOutPage().clkShippingContinueButton();
		getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
		getFidoCheckOutPage().clkSubmitButton();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("Order Review page");
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getReporter().reportLogWithScreenshot("Terms and conditions clicked");
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
