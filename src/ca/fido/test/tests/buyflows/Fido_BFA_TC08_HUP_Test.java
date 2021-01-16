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
 * TC08 - FHUP - Regression - Fido HUP e2e
 * @author rajesh.varalli1
 */
public class Fido_BFA_TC08_HUP_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","HUPBFA"})
	public void hupFlowTest() {
		getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc08Hup.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc08Hup.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkViewUsageAndManageLink();
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		getReporter().reportLogWithScreenshot("Mobile Dashboard page");
		getFidowirelessdashboardpostpaidpage().clickUpgradeDevice();
		getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad() , "Choose Phone Page loaded" , "Choose Phone Page not loaded");
		getReporter().reportLogWithScreenshot("Choose phone page");
	    getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc08Hup.getNewDevice()),"Device Found and Selected","Device Not Found");
		getReporter().reportLogWithScreenshot("Device " + TestDataHandler.tc08Hup.getNewDevice() + " Selected");
		getFidobuildplanpage().selectPlanCategory("Data, Talk & Text");
		getReporter().reportLogPass("Data, Talk & Text plan category selected" );
		getReporter().hardAssert(getFidobuildplanpage().selectFirstAvailablePricePlan(),"Selected first price plan","Error in Price Plan Selection");
		getFidobuildplanpage().clkCloseDialogWindow();
		getFidobuildplanpage().clkContinueToAddons();
		getReporter().hardAssert(getFidochooseaddonspage().verifyAddonsPage(),"Addons page loaded","Addons page not loaded");
		getReporter().reportLogWithScreenshot("On addons page");
		getFidochooseaddonspage().selectAnyAddon();
		getFidochooseaddonspage().clkContinueToShipping();
		getReporter().hardAssert(getFidoshippingpage().verifyShippingPage() , "Shipping page displayed" , "Shipping page not displayed");
		getReporter().reportLogWithScreenshot("On Shipping page");
		getFidoshippingpage().selectHomeAddress();
		getFidoshippingpage().clkContinueToOrderReview();
		getReporter().reportLogPass("Continue button on shipping page clicked");
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("On review page");
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc08Hup.getUsername());
		getReporter().reportLogWithScreenshot("All terms and conditions selected");
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

	@BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
	}

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
