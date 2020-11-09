package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This test will check the change method of payment functionality
 * works on French and English both
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_AO_TC074_ValidateUserCanEditAutomaticPaymentMethod extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"SanitySS","AccountOverviewSS"})
	public void postPaidChangeMOP() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		
		if(fido_account_overview_page.checkIfAutoPaymentIsSet()) {
			fido_account_overview_page.clkLnkEditAutoPayment();
			reporter.hardAssert(fido_payment_options_page.verifyPaymentMethodModalDisplayed(),
					"Change payment method modal displayed.",
					"Change payment method modal didn't display as expected.");
		} else {
			
		}
		
		fido_payment_options_page.clkCloseButton();
		reporter.reportLogWithScreenshot("Account overview page");

		
	}
	
	

}
