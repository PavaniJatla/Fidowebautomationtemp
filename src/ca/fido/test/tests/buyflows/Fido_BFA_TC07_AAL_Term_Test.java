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
		reporter.reportLog("URL:" + System.getProperty("QaUrl"));
		reporter.reportLogWithScreenshot("Fido Home Page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc07AalTerm.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc07AalTerm.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		reporter.hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkLnkAddALine();
		reporter.reportLogWithScreenshot("Clicked on add a line");
		getFidoaccountoverviewpage().clkButtonAALNewPhone();
		reporter.reportLogWithScreenshot("Modal dialogue appeared");
		reporter.hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		reporter.reportLogWithScreenshot("PHONES & DEVICES page");
		reporter.hardAssert(getFidochoosephonepage().selectDevice("iPhone XR 1"),"Device Found and Selected","Device Not Found");
		reporter.reportLogWithScreenshot("Required device is available on the choose phone page");
		reporter.hardAssert(getFidodeviceconfigpage().clickContinueButton(),"Continue button is visible and clicked","Continue button is not visible ");
		reporter.reportLogWithScreenshot("Continue button clicked on the device config page");
		Assert.assertTrue(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		reporter.reportLogWithScreenshot("Fido plan config page");
		getFidobuildplanpage().clkContinueDeviceCost();
		reporter.reportLogWithScreenshot("Continue button on select your device cost clicked");
		getFidobuildplanpage().clkContinueDataOption();
		reporter.reportLogWithScreenshot("Continue button on Data option clicked");
		getFidobuildplanpage().clkContinueTalkOptions();
		reporter.reportLogWithScreenshot("Continue button on talk option clicked");
		getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
		reporter.reportLogWithScreenshot("skipped BPO option");
		getFidobuildplanpage().clkContinueAddOns();
		reporter.reportLogWithScreenshot("Continue button on AddOns clicked");
		getFidobuildplanpage().enterFirstName();
		getFidobuildplanpage().enterSecondName();
		getFidobuildplanpage().clkContinueEnterUserNameAAL();
		reporter.reportLogWithScreenshot("Continue button on enter user's name clicked");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getFidobuildplanpage().selectCityForChooseYourTelephoneNum("TOR");
		getFidobuildplanpage().clkChooseNumberContinueButton();
		reporter.reportLogWithScreenshot("Continue button on choose your telephone number clicked");
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
