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
 * TC09 - FPPC Term - Regression - Fido PPC e2e
 * @author rajesh.varalli1
 */
public class Fido_BFA_TC09_PPC_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","PPCBFA"})
	public void ppcFlowTest() {
		/*getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();*/
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc09Ppc.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc09Ppc.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		//getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkViewUsageAndManageLink();
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		getReporter().reportLogWithScreenshot("Mobile Dashboard page");
		getFidowirelessdashboardpostpaidpage().clkChangePlan();
		getReporter().hardAssert(getFidochooseplanpage().verifyChangePlanPageLoad(), "Price Plan Change page loaded", "Price Plan Change page load error");
		getReporter().reportLogWithScreenshot("Choose plan page displayed");
		getFidochooseplanpage().clkPlanType(TestDataHandler.tc09Ppc.getNewPlanType());
		getFidochooseplanpage().selectFirstAvailablePricePlan();
		getReporter().reportLogWithScreenshot("Plan selected page");
		getFidochooseplanpage().clkContinue();
		getReporter().hardAssert(getFidochooseaddonspage().verifyAddonsPage(),"Addons page loaded","Addons page not loaded");
		getReporter().reportLogWithScreenshot("On addons page");
		getFidochooseaddonspage().clkCheckOut();
		getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel() , "Review page displayed" , "Review page not displayed");
		getReporter().reportLogWithScreenshot("On review page");
		getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc09Ppc.getUsername());
		getReporter().reportLogWithScreenshot("Order Review page");
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
