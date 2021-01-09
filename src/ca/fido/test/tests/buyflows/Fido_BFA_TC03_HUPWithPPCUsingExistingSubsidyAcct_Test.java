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
 * TC06-Fido-Validate user able to perform HUP with PPC using Exisitng Subsidy acct
 * 
 * Login to Fido.ca using valid credentials
 * Click on HUP eligible CTN 
 * Click on Upgrade my device
 * select a device 
 * Select a plan from higher tier and continue to Addon's page
 * Select any ADDON's(optional) and click continue
 * Select the shipping address as Billing address and continue
 * Review your order and continue to order confirmation page
 * 
 * @author rajesh.varalli1
 */
public class Fido_BFA_TC03_HUPWithPPCUsingExistingSubsidyAcct_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
	public void hupWithPPCUsingExistingSubsidyAcctFlowTest() {
		getReporter().reportLogWithScreenshot("Fido Home page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.testCase03.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.testCase03.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkSpecificCTNBadge(TestDataHandler.testCase03.getCtn());
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		getReporter().reportLogWithScreenshot("Mobile Dashboard page");
		getFidowirelessdashboardpostpaidpage().clickUpgradeDevice();
		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.testCase03.getNewDevice()),"Device Found and Selected","Device Not Found");
		getFidobuildplanpage().selectPlanCategory("Data, Talk & Text");
		getReporter().hardAssert(getFidobuildplanpage().selectFirstAvailablePricePlan(),"Selected first price plan","Error in Price Plan Selection");
		getFidobuildplanpage().clkCloseDialogWindow();
		getFidobuildplanpage().clkContinueToAddons();
		getFidochooseaddonspage().selectAnyAddon();
		getFidochooseaddonspage().clkContinueToShipping();
		getFidoshippingpage().selectHomeAddress();
		getFidoshippingpage().clkContinueToOrderReview();
		getFidoorderreviewpage().clkTermsNConditionsConsent();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.testCase03.getUsername());
		if(getFidoorderreviewpage().isPaymentRequired()) {
			getFidoorderreviewpage().clkContinueToPayment();
			getFidopaymentpage().setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
			getFidoorderreviewpage().clkCompleteOrder();
			//getFidopaymentpage().clkContinueOrder();
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
		//System.setProperty("Browser" , "saucechrome");
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
