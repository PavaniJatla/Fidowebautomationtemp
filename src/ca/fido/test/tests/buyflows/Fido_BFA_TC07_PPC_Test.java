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
public class Fido_BFA_TC07_PPC_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","SanityBFA","PPCBFA"})
	public void ppcFlowTest() {
		getReporter().reportLogWithScreenshot("Fido Home page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.testCase07.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.testCase07.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		getFidoaccountoverviewpage().clkSpecificCTNBadge(TestDataHandler.testCase07.getCtn());
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
		getReporter().reportLogWithScreenshot("Mobile Dashboard page");
		getFidowirelessdashboardpostpaidpage().clkChangePlan();
		getReporter().hardAssert(getFidochooseplanpage().verifyChangePlanPageLoad(), "Price Plan Change page loaded", "Price Plan Change page load error");
		getFidochooseplanpage().clkPlanType(TestDataHandler.testCase07.getNewPlanType());
		getFidochooseplanpage().selectFirstAvailablePricePlan();
		getReporter().reportLogWithScreenshot("Change Your Plan page");
		getFidochooseplanpage().clkContinue();
		getFidochooseaddonspage().clkCheckOut();
		getFidoorderreviewpage().clkTermsNConditionsConsent();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.testCase07.getUsername());
		getReporter().reportLogWithScreenshot("Order Review page");
		getFidoorderreviewpage().clkCompleteOrder();
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
