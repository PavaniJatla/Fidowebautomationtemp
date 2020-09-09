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
 * TC05- Fido- Validate user able to perform HUP Deeplink Flow - keep existing plan(Financing only)
 * 
 * Deeplink to " https://www.fido.ca/hup/#/choose-phone"  in fido
 * Enter the valid login credentials and click on login
 * select a device 
 * Select  " Keep existing plan " option and click continue
 * Select any addon's(optional) and click continue
 * Select the shipping address as Billing address and continue
 * Review your order and click on complete order
 * 
 * @author rajesh.varalli1
 */
public class Old_Fido_BFA_TC07_HUP_Deeplink_KeepExistingPlan_Test extends BaseTestClass{

	@Test
	public void ppcUpgradeTierFlow() {
		getDriver().get(TestDataHandler.bfaConfig.getHupURL());
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.testCase04.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.testCase04.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		fido_choose_phone_page.selectSubscriber(TestDataHandler.testCase04.getCtn());
		reporter.hardAssert(fido_choose_phone_page.selectDevice(TestDataHandler.testCase04.getNewDevice()),"Device Found and Selected","Device Not Found");
		fido_build_plan_page.keepExistingPlan();
		fido_build_plan_page.clkContinueToAddons();
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
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
