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
 * TC02 - Regression - [FNAC BYOD] - Perform Fido Net New Activation - BYOD with Express Pickup Shipping - BOPIS_E2E
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC02_NAC_ByodTermWithExpressShippingTest extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","NACBFA"})
	public void fidoNACFlow() {
		getReporter().reportLog("URL:" + System.getProperty("AWSUrl"));
		getReporter().reportLogWithScreenshot("Home Page");
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc02ByodExpressShipping.getDeviceName()),"Device Found and Selected","Device Not Found");
		getReporter().reportLogWithScreenshot("Required device is selected on the choose phone page");
		Assert.assertTrue(getFidodeviceconfigpage().isModalDisplayed(),"Modal element is not present on the screen");
		getReporter().reportLogPass("Modal window displayed");
		Assert.assertTrue(getFidodeviceconfigpage().verifyGetStartedButtonOnModal(),"Get started button on the modal is not present");
		getFidodeviceconfigpage().clickGetStartedButtonOnModal();
		getReporter().reportLogPass("Clicked Get Started Button on the modal window");
		getReporter().hardAssert(getFidodeviceconfigpage().clickContinueButton(),"Continue button is visible and clicked","Continue button is not visible ");
		getReporter().reportLogWithScreenshot("Continue button clicked on the device config page");
		Assert.assertTrue(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		getReporter().reportLogPass("Fido plan config page");
		getFidobuildplanpage().clkNoTermTierInDeviceCost();
		getReporter().reportLogPass("No Term Tier selected in the Device cost");
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogPass("Continue button on select your device cost clicked");
		getFidobuildplanpage().clkContinueDataOption();
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogPass("Continue button on AddOns clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getFidocreateuserpage().setCommunicationDetails();
		getFidocreateuserpage().setFirstName();
		getFidocreateuserpage().setLastName();
		getFidocreateuserpage().setPhone();
		getFidocreateuserpage().setHomeAddress(TestDataHandler.tc02ByodExpressShipping.getBillingAddress());
		getReporter().reportLogWithScreenshot("Create User page");
		getFidocreateuserpage().clkContinue();
		getFidocreditcheckpage().selectDOBYear();
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		getFidocreditcheckpage().selectIdType(TestDataHandler.tc02ByodExpressShipping.getIdentificationType());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc02ByodExpressShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc02ByodExpressShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();
		getFidocreditcheckpage().clkCreditCheckConsent();
		getReporter().reportLogWithScreenshot("Credit Evaluation page");
		getFidocreditcheckpage().clkContinue();
		getFidocreditcheckpage().waitForCreditCheckProcessing();
		//getFidocreditcheckpage().clkBtnSecurityDepositConsentAccept();
		//getFidochoosenumberpage().clkSelectNewNumber();
		getFidochoosenumberpage().selectCity(TestDataHandler.tc02ByodExpressShipping.getCtnCity());
		getFidochoosenumberpage().selectFirstAvailableNumber();
		getReporter().reportLogWithScreenshot("Choose Phone Number page");
		getFidochoosenumberpage().clkContinue();
		getFidopaymentoptionspage().setManualPaymentMethod();
		getFidopaymentoptionspage().billingOptionClkContinue();
		getFidopaymentoptionspage().clkSubmit();
		getFidoorderreviewpage().clkAllTermsAgreementCheckboxsNAC();
		getFidoorderreviewpage().setContractDigitalCopyEmail();
		getFidoorderreviewpage().clkSubmitMyOrder();
		getFidopaymentpage().clkRadioPayWithAnotherCreditCard();
		getReporter().reportLogWithScreenshot("OneTime payment page displayed");
		getFidopaymentpage().setCreditCardName();
		getFidopaymentpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber2());
		getFidopaymentpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth2() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear2());
		getFidopaymentpage().setCreditCardCvv(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCvv2());
		getReporter().reportLogWithScreenshot("OneTime payment page displayed before submittion");
		getFidopaymentpage().clkSubmitMyOrder();
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank You message verified", "Thank You message error");
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
		getReporter().reportLogWithScreenshot("Order Confirmation page");
	}

	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
