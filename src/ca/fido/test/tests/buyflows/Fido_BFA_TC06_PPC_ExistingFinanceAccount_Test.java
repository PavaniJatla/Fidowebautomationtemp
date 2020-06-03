package ca.fido.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;

/**
 * TC06- Fido- Validate user able to perform PPC using existing finance acct
 * 
 * Login to Fido.ca using valid credentials
 * Click on PPC eligible CTN 
 * Click on Change plan
 * Select a plan of higher category and continue to Addon's page
 * Select any addon's and click continue
 * Select the shipping address as Billing address and continue
 *  Review your order and click on complete order
 * 
 * @author rajesh.varalli1
 */
public class Fido_BFA_TC06_PPC_ExistingFinanceAccount_Test extends BaseTestClass{

	@Test
	public void ppcUpgradeTierFlow() {
		reporter.reportLogWithScreenshot("Fido Home page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.testCase06.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.testCase06.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		fido_account_overview_page.clkSpecificCTNBadge(TestDataHandler.testCase06.getCtn());
		fido_wireless_dashboard_postpaid_page.closeOverlayPopup();
		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		reporter.reportLogWithScreenshot("Mobile Dashboard page");
		fido_wireless_dashboard_postpaid_page.clkChangePlan();
		reporter.hardAssert(fido_choose_plan_page.verifyChangePlanPageLoad(), "Price Plan Change page loaded", "Price Plan Change page load error");
		fido_choose_plan_page.clkPlanType(TestDataHandler.testCase06.getNewPlanType());
		fido_choose_plan_page.selectFirstAvailablePricePlan();
		reporter.reportLogWithScreenshot("Change Your Plan page");
		fido_choose_plan_page.clkContinue();
		fido_choose_addons_page.clkCheckOut();
		fido_order_review_page.clkTermsNConditionsConsent();
		fido_order_review_page.setContractDigitalCopyEmail(TestDataHandler.testCase06.getUsername());
		reporter.reportLogWithScreenshot("Order Review page");
		fido_order_review_page.clkCompleteOrder();
		fido_order_review_page.waitForOrderProcessing();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}
	
	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
    public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getFidoURL(), strBrowser,strLanguage, FidoEnums.GroupName.BUYFLOWS ,  method);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
