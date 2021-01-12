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
		getFidoaccountoverviewpage().clkButtonAALNewPhone();
		getReporter().reportLogWithScreenshot("Modal dialogue appeared");
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
		getReporter().hardAssert(getFidochoosephonepage().selectDevice("iPhone XR 1"),"Device Found and Selected","Device Not Found");
		getReporter().reportLogWithScreenshot("Required device is available on the choose phone page");
		getReporter().hardAssert(getFidodeviceconfigpage().clickContinueButton(),"Continue button is visible and clicked","Continue button is not visible ");
		getReporter().reportLogWithScreenshot("Continue button clicked on the device config page");
		Assert.assertTrue(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		getReporter().reportLogWithScreenshot("Fido plan config page");
		getFidobuildplanpage().clkContinueDeviceCost();
		getReporter().reportLogWithScreenshot("Continue button on select your device cost clicked");
		getFidobuildplanpage().clkContinueDataOption();
		getReporter().reportLogWithScreenshot("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		getReporter().reportLogWithScreenshot("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		getReporter().reportLogWithScreenshot("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		getReporter().reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().enterFirstName();
		getFidobuildplanpage().enterSecondName();
		getFidobuildplanpage().clkContinueEnterUserNameAAL();
		getReporter().reportLogWithScreenshot("Continue button on enter user's name clicked");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getFidobuildplanpage().selectCityForChooseYourTelephoneNum("TOR");
		getFidobuildplanpage().clkChooseNumberContinueButton();
		getReporter().reportLogWithScreenshot("Continue button on choose your telephone number clicked");
		//getFidopaymentoptionspage().shippingClkContinue();
		getFidopaymentoptionspage().clkSubmit();
		getFidoorderreviewpage().clkTermsNConditionsConsent();
		getFidoorderreviewpage().clkTermsNConditionsConsentAAL();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc07AalTerm.getUsername());
		if(getFidoorderreviewpage().isPaymentRequired()) {
			getFidoorderreviewpage().clkContinueToPayment();
			getFidopaymentpage().setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
			getFidopaymentpage().clkContinueOrder();
		} else {
			getFidoorderreviewpage().clkCompleteOrder();
		}
		getFidoorderreviewpage().waitForOrderProcessing();
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		getReporter().reportLogWithScreenshot("Order Confirmation page");
	}
	
	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
