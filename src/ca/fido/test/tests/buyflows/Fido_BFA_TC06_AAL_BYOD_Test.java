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
 *TC06 - FAAL BYOD - Regression - Fido AAL BYOD -AWS - e2e
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC06_AAL_BYOD_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","AALBFA"})
	public void aalBYODFlowTest() {
		getReporter().reportLog("URL:" + System.getProperty("QaUrl"));
		getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
		getReporter().reportLogWithScreenshot("Fido Home Page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc06AalByod.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc06AalByod.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkLnkAddALine();
		getReporter().reportLogWithScreenshot("Clicked on add a line");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyModalWindowAAL(), "Modal window loaded", "Modal window not loaded");
		getReporter().reportLogWithScreenshot("Modal dialogue appeared");
		getFidoaccountoverviewpage().clkButtonAddALineAlreadyHaveAPhone();
		getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido build plan page is displayed" , "Fido build plan page is not displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");
		getFidobuildplanpage().clkDataAndTextPlan();
		getReporter().reportLogPass("Data and Text Plan selected");
		getFidobuildplanpage().clkFirstTierChooseYourDataAAL();
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
		getFidoCheckOutPage().selectCityForChooseYourTelephoneNum("72");
		getFidoCheckOutPage().clkChooseNumberContinueButton();
		getReporter().reportLogWithScreenshot("Continue button on choose your telephone number clicked");
		getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping displayed" , "Shipping label not displayed");
		getFidoCheckOutPage().clkShippingType("Standard");
		getReporter().reportLogWithScreenshot("Shipping selected");
		getFidoCheckOutPage().clkShippingContinueButton();
		getReporter().reportLogWithScreenshot("Selecting submit on Shipping");
		getFidoCheckOutPage().clkSubmitButton();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("Order Review page");
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
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
