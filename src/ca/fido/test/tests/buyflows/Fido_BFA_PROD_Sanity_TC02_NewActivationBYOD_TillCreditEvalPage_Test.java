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
public class Fido_BFA_PROD_Sanity_TC02_NewActivationBYOD_TillCreditEvalPage_Test extends BaseTestClass{

	@BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@Test(groups = {"PRODSanity","PRODNACSanity"})
	public void fidoProdSanity_NewActivation_BYOD() {

		getDriver().get(System.getProperty("AWSPRODUrl")+"/phones/bring-your-own-device?flowType=byod");
		getFidobuildplanpage().clkDataOption(TestDataHandler.tc02ByodExpressShipping.getDataOptionIndex(),this.getClass().getSimpleName());
		getReporter().reportLogPass("Data, Talk and Text Plan selected");
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidoCheckOutPage().clkNoThanks();
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().clkContinueBelowCartSummary();

		getReporter().reportLogPass("Proceed to checkout button clicked");
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
		getFidocreditcheckpage().selectDOBMonth();
		getFidocreditcheckpage().selectDOBDay();
		getFidoCheckOutPage().clkNoThanks();
		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber1());
		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth1() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear1());
		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.tc02ByodExpressShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.tc02ByodExpressShipping.getDlProvinceCode());
		getFidocreditcheckpage().setDrivingLicenseExpiry();

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
