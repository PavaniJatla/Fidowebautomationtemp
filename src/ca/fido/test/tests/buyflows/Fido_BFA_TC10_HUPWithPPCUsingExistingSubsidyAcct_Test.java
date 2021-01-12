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
 * TC10 - Regression - Fido HUP using existing subsidy account - e2e
 * @author rajesh.varalli1
 */
public class Fido_BFA_TC10_HUPWithPPCUsingExistingSubsidyAcct_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
	public void hupWithPPCUsingExistingSubsidyAcctFlowTest() {
		reporter.reportLogWithScreenshot("Fido Home page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc10HupExistingSubsidy.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc10HupExistingSubsidy.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		reporter.hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkViewUsageAndManageLink();
		//fido_account_overview_page.clkSpecificCTNBadge(TestDataHandler.tc10HupExistingSubsidy.getCtn());
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		reporter.hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		reporter.reportLogWithScreenshot("Mobile Dashboard page");
		getFidowirelessdashboardpostpaidpage().clickUpgradeDevice();
		reporter.hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.tc10HupExistingSubsidy.getNewDevice()),"Device Found and Selected","Device Not Found");
		getFidobuildplanpage().selectPlanCategory("Data, Talk & Text");
		reporter.hardAssert(getFidobuildplanpage().selectFirstAvailablePricePlan(),"Selected first price plan","Error in Price Plan Selection");
		getFidobuildplanpage().clkCloseDialogWindow();
		getFidobuildplanpage().clkContinueToAddons();
		getFidochooseaddonspage().selectAnyAddon();
		getFidochooseaddonspage().clkContinueToShipping();
		getFidoshippingpage().selectHomeAddress();
		getFidoshippingpage().clkContinueToOrderReview();
		getFidoorderreviewpage().clkTermsNConditionsConsent();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc10HupExistingSubsidy.getUsername());
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
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
