package ca.fido.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * TC05 - Regression - [FNAC TERM] - Perform Fido Net New Activation - TERM with Standard Shipping(Finance Plan)_E2E
 * @author Saurav.Goyal
 *
 */
public class Fido_BFA_TC05_NAC_TermStandardShipping_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","NACBFA"})
	public void fidoNACTermStandardShippingFlow() {
		getReporter().reportLog("URL:" + System.getProperty("AWSUrl"));
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc05TermStandardShipping.getDeviceName()),"Device Found and Selected","Device Not Found");
		getReporter().reportLogWithScreenshot("Required device is selected on the choose phone page " +TestDataHandler.tc05TermStandardShipping.getDeviceName());
		getReporter().hardAssert(getFidodeviceconfigpage().isModalDisplayed(),"Modal element is present on the screen" , "Modal element is not present on the screen");
		getReporter().reportLogWithScreenshot("Modal window displayed");
		getFidodeviceconfigpage().clickGetStartedButtonOnModal();
		getReporter().reportLogPass("Clicked Get Started Button on the modal window");
		getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Device config page loaded","Device config page not loaded");
		getReporter().reportLogWithScreenshot("Device config page");
		getFidodeviceconfigpage().clickContinueButton();
		getReporter().reportLogPass("Continue button clicked on the device config page");
		getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogPass("Continue button on select your device cost clicked");
		getFidobuildplanpage().clkContinueDataOption();
		getReporter().reportLogPassWithScreenshot("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		//getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().reportLogPass("Proceed to checkout button clicked");
		getReporter().hardAssert(getFidocreateuserpage().verifyCreateUserProfilePage() , "create user profile page loaded" , "create user profile page not loaded");
		getReporter().reportLogPass("User profile page");
		getFidocreateuserpage().setCommunicationDetails();
		getFidocreateuserpage().setFirstName();
		getFidocreateuserpage().setLastName();
		getReporter().reportLogWithScreenshot("Entered email,  first name and last name");
		getFidocreateuserpage().setSpecificPhoneNumber(TestDataHandler.tc05TermStandardShipping.getContactNumber());
		getFidocreateuserpage().setHomeAddress(TestDataHandler.tc05TermStandardShipping.getBillingAddress());
		getReporter().reportLogWithScreenshot("Phone number  and home address set");
		getFidocreateuserpage().clkContinue();
		//issue in DOBYear
		getFidocreditcheckpage().selectDOBYear();
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		//getFidocreditcheckpage().selectIdType(TestDataHandler.tc05TermStandardShipping.getIdentificationType());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc05TermStandardShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc05TermStandardShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();
		getFidocreditcheckpage().clkCreditCheckConsent();
		getReporter().reportLogWithScreenshot("Credit Evaluation page");
		getFidocreditcheckpage().clkContinue();
		getFidocreditcheckpage().waitForCreditCheckProcessing();
		getFidochoosenumberpage().selectCity(TestDataHandler.tc05TermStandardShipping.getCtnCity());
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
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
		getReporter().reportLogWithScreenshot("Terms and conditions clicked");
		getFidoorderreviewpage().clkSubmitMyOrder();
		getReporter().reportLogPass("Submit button selected");
		//getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
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
