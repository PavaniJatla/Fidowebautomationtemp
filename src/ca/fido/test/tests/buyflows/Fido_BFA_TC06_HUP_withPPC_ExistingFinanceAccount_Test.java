package ca.fido.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * TC04- Fido- Validate user able to perform HUP with PPC using Existing Finance acct
 * 
 * Login to Fido.ca using valid credentials
 * Click on HUP eligible CTN 
 * Click on Upgrade my device
 * select a device 
 * Select a plan category as " Small Tier"   and Select " Pick a New plan" and continue to Addon's page
 * Select any addon's(optional) and click continue
 * Select the shipping address as Billing address and continue
 * Review your order and click on complete order
 * 
 * @author rajesh.varalli1
 */
public class Fido_BFA_TC06_HUP_withPPC_ExistingFinanceAccount_Test extends BaseTestClass{

	@Test
	public void ppcUpgradeTierFlow() {
		reporter.reportLogWithScreenshot("Fido Home page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.testCase04.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.testCase04.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		fido_account_overview_page.clkSpecificCTNBadge(TestDataHandler.testCase04.getCtn());
		fido_wireless_dashboard_postpaid_page.closeOverlayPopup();
		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		reporter.reportLogWithScreenshot("Mobile Dashboard page");
		fido_wireless_dashboard_postpaid_page.clickUpgradeDevice();
		reporter.hardAssert(fido_choose_phone_page.selectDevice(TestDataHandler.testCase03.getNewDevice()),"Device Found and Selected","Device Not Found");
		fido_build_plan_page.selectPlanCategory("Data, Talk & Text");
		reporter.hardAssert(fido_build_plan_page.selectFirstAvailablePricePlan(),"Selected first price plan","Error in Price Plan Selection");
		fido_build_plan_page.clkContinueToAddons();
		fido_choose_addons_page.selectAnyAddon();
		fido_choose_addons_page.clkContinueToShipping();
		fido_shipping_page.selectHomeAddress();
		fido_shipping_page.clkContinueToOrderReview();
		fido_order_review_page.clkTermsNConditionsConsent();
		fido_order_review_page.setContractDigitalCopyEmail(TestDataHandler.testCase04.getUsername());
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
    public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getFidoURL(), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}