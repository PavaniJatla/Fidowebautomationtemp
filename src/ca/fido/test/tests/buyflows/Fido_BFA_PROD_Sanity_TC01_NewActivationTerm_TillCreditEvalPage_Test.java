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
public class Fido_BFA_PROD_Sanity_TC01_NewActivationTerm_TillCreditEvalPage_Test extends BaseTestClass{

	@BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@Test(groups = {"PRODSanity","PRODNACSanity"})
	public void fidoProdSanity_NewActivation_Term() {

		getDriver().get(System.getProperty("AWSPRODUrl")+"/phones");
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
		getFidodeviceconfigpage().clickContinueButton();
		getReporter().reportLogPass("Continue button clicked on the device config page");
		getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");

		getFidobuildplanpage().clkDownPaymentChkBox();
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogPass("Continue button on select your device cost clicked");
		getFidobuildplanpage().clkDataOption(TestDataHandler.tc03TermBopis.getDataOptionIndex(),this.getClass().getSimpleName());
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidoCheckOutPage().clkNoThanks();
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().clkContinueDeviceProtection();
		getFidobuildplanpage().clkContinueBelowCartSummary();

		getReporter().reportLogPass("Proceed to checkout button clicked");
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
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidoCheckOutPage().clkNoThanks();
		getReporter().reportLogWithScreenshot("DOB details entered");
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		getReporter().reportLogWithScreenshot("Credit card details entered");
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc03TermBopis.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc03TermBopis.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
