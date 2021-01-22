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
 * TC07 - FAAL Term - Regression - Fido AAL TERM -AWS - e2e
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC07_AAL_Term_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","AALBFA"})
	public void aalTermFlowTest() {
		getReporter().reportLog("URL:" + System.getProperty("QaUrl"));
		getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
		getReporter().reportLogWithScreenshot("Fido Home Page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc07AalTerm.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc07AalTerm.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkLnkAddALine();
		getReporter().reportLogWithScreenshot("Clicked on add a line");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyModalWindowAAL(), "Modal window loaded", "Modal window not loaded");
		getReporter().reportLogWithScreenshot("Modal dialogue appeared");
		getFidoaccountoverviewpage().clkButtonAALNewPhone();
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc07AalTerm.getNewDevice()),"Device Found and Selected","Device Not Found");
		getReporter().reportLogWithScreenshot("Required device selected on the choose phone page");
		getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Device config page loaded","Device config page not loaded");
		getFidodeviceconfigpage().clickContinueButton();
		getReporter().reportLogWithScreenshot("Continue button clicked on the device config page");
		getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogWithScreenshot("Continue button on select your device cost clicked");
		/*getFidobuildplanpage().clkDataAndTextPlan();
		getReporter().reportLogPass("Data and Text Plan selected");
		getFidobuildplanpage().clkFirstTierChooseYourDataAAL();*/
		getFidobuildplanpage().clkContinueDataOption();
		getReporter().reportLogPass("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogPass("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogPass("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().enterFirstName();
		getFidobuildplanpage().enterSecondName();
		getReporter().reportLogWithScreenshot("First and last name entered");
		getFidobuildplanpage().clkContinueEnterUserNameAAL();
		getReporter().reportLogPass("Continue button on enter user's name clicked");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().hardAssert(getFidoCheckOutPage().verifyCheckOutPage() , "Checkout page displayed" , "Checkout page not displayed");
		getReporter().reportLogWithScreenshot("Select a new number details");
		getFidoCheckOutPage().selectCityForChooseYourTelephoneNum("72"); //72 toronto selected
		getFidoCheckOutPage().clkChooseNumberContinueButton();
		getReporter().reportLogWithScreenshot("Continue button on choose your telephone number clicked");
		getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping displayed" , "Shipping label not displayed");
		getFidoCheckOutPage().clkShippingType("Standard");	// standard shipping selected
		getReporter().reportLogWithScreenshot("Shipping selected");
		getFidoCheckOutPage().clkShippingContinueButton();
		getReporter().reportLogWithScreenshot("Selecting submit on Shipping");
		getFidoCheckOutPage().clkSubmitButton();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("Order Review page");
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
		//getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc07AalTerm.getUsername());
		getReporter().reportLogWithScreenshot("Terms and conditions clicked");
		getFidoorderreviewpage().clkSubmitMyOrder();
		getFidoorderreviewpage().waitForOrderProcessing();
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		getReporter().reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
