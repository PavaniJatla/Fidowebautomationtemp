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
		reporter.reportLogWithScreenshot("Fido Home page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc09Ppc.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc09Ppc.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		reporter.hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkViewUsageAndManageLink();
		//fido_account_overview_page.clkSpecificCTNBadge(TestDataHandler.tc09Ppc.getCtn());
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		reporter.hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		reporter.reportLogWithScreenshot("Mobile Dashboard page");
		getFidowirelessdashboardpostpaidpage().clkChangePlan();
		reporter.hardAssert(getFidochooseplanpage().verifyChangePlanPageLoad(), "Price Plan Change page loaded", "Price Plan Change page load error");
		getFidochooseplanpage().clkPlanType(TestDataHandler.tc09Ppc.getNewPlanType());
		getFidochooseplanpage().selectFirstAvailablePricePlan();
		reporter.reportLogWithScreenshot("Change Your Plan page");
		getFidochooseplanpage().clkContinue();
		getFidochooseaddonspage().clkCheckOut();
		getFidoorderreviewpage().clkTermsNConditionsConsent();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc09Ppc.getUsername());
		reporter.reportLogWithScreenshot("Order Review page");
		getFidoorderreviewpage().clkCompleteOrder();
		getFidoorderreviewpage().waitForOrderProcessing();
		reporter.hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
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
