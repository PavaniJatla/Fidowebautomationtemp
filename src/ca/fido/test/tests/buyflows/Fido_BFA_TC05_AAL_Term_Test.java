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
 * TC02 - Fido - Regression - Perform Fido AAL TERM - AWS - e2e
 * 
 * Login to Fido.ca using valid credentials
 * Click on AAL button 
 * select a plan and Click continue
 * select a calling option and Click continue
 * Select any addon's and click continue
 * Enter the caller ID and click Continue
 * Select a number and click continue
 * Click Submit and Order confirmation page should be displayed
 * 
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC05_AAL_Term_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","AALBFA"})
	public void aalTermFlowTest() {
		reporter.reportLog("URL:" + System.getProperty("AWSUrl"));
		reporter.reportLogWithScreenshot("Fido Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.testCase05.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.testCase05.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		fido_account_overview_page.clkLnkAddALine();
		reporter.reportLogWithScreenshot("Clicked on add a line");
		fido_account_overview_page.clkButtonAALNewPhone();
		reporter.reportLogWithScreenshot("Modal dialogue appeared");
		reporter.hardAssert(fido_choose_phone_page.verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
		reporter.reportLogWithScreenshot("PHONES & DEVICES page");
		reporter.hardAssert(fido_choose_phone_page.selectDevice("Iphone XR"),"Device Found and Selected","Device Not Found");
		reporter.reportLogWithScreenshot("Required device is available on the choose phone page");
		reporter.hardAssert(fido_device_config_Page.clickContinueButton(),"Continue button is visible and clicked","Continue button is not visible ");
		reporter.reportLogWithScreenshot("Continue button clicked on the device config page");
		Assert.assertTrue(fido_build_plan_page.verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		reporter.reportLogWithScreenshot("Fido plan config page");
		fido_build_plan_page.clkContinueDeviceCost();
		reporter.reportLogWithScreenshot("Continue button on select your device cost clicked");
		fido_build_plan_page.clkContinueDataOption();
		reporter.reportLogWithScreenshot("Continue button on Data option clicked");
		fido_build_plan_page.clkContinueTalkOptions();
		reporter.reportLogWithScreenshot("Continue button on talk option clicked");
		fido_build_plan_page.clkNoBPOOfferButtonTalkOptions();
		reporter.reportLogWithScreenshot("skipped BPO option");
		fido_build_plan_page.clkContinueAddOns();
		reporter.reportLogWithScreenshot("Continue button on AddOns clicked");
		fido_build_plan_page.enterFirstName();
		fido_build_plan_page.enterSecondName();
		fido_build_plan_page.clkContinueEnterUserNameAAL();
		reporter.reportLogWithScreenshot("Continue button on enter user's name clicked");
		fido_build_plan_page.selectCityForChooseYourTelephoneNum("TOR");
		fido_build_plan_page.clkChooseNumberContinueButton();
		reporter.reportLogWithScreenshot("Continue button on choose your telephone number clicked");
		fido_build_plan_page.clkContinueBelowCartSummary();
		fido_shipping_page.clkContinueToOrderReview();
		fido_order_review_page.clkTermsNConditionsConsent();
		fido_order_review_page.setContractDigitalCopyEmail(TestDataHandler.testCase05.getUsername());
		if(fido_order_review_page.isPaymentRequired()) {
			fido_order_review_page.clkContinueToPayment();
			fido_payment_page.setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
			fido_payment_page.clkContinueOrder();
		} else {
			fido_order_review_page.clkCompleteOrder();
		}
		fido_order_review_page.waitForOrderProcessing();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}
	
	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("AWSUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
