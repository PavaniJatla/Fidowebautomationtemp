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
public class FidoSS_Regression_TC075_AO_ValidateMakePaymentCTAinCLMNotification_BC extends BaseTestClass{

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
	
	

	@Test(groups = {"AccountOverviewSS"})
	public void postPaidChangeMOP() {
//		getDriver().get(System.getProperty("QaUrl")+"/self-serve/overview");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc75.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc75.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLoginNew(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
				
		reporter.hardAssert(fido_account_overview_page.verifyIfCLMNotificationIsDisplayed(),
				"The user has atleast 1 active account which has already automatic payments option",
				"The user should have atleast 1 active account which has already automatic payments option");
		
		reporter.hardAssert(fido_account_overview_page.verifyIfMakePaymentIsDisplayedCLMNotificationIsDisplayed(),
				"The user has atleast 1 active account which has already automatic payments option",
				"The user should have atleast 1 active account which has already automatic payments option");
		
		fido_account_overview_page.clkMakePaymentOnCLMNotification();
		reporter.hardAssert(fido_make_payment_page.verifyPaymentModalIsDisplayed(),
				"Make payment modal displayed.",
				"Make payment modal didn't display as expected.");
							
	}
	
	

}
