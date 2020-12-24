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
 * This script will verify the post paid payment flow using Bank Option & Verify Bank Page Redirected Successfully or not. 
 * @author Karthic.Hasan
 *
 */
public class FidoSS_TC017_FidoCA_PostpaidPayment_Bank extends BaseTestClass{

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
	
	@Test(groups = {"SanitySS","BillingAndPaymentsSS","TC17"})
	public void postPaidPaymentBank() throws InterruptedException {
		String amountEntered="0.01";
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
		//fido_account_overview_page.waitForPayNowToBecomeClickable();
		//.clkPayNow();
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		fido_account_overview_page.clkPayNowNew(strBAN);
		reporter.reportLogWithScreenshot("Pay now");
		fido_make_payment_page.setPaymentAmount(amountEntered);
		fido_make_payment_page.selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Bank);
		reporter.reportLogWithScreenshot("Bank option selected");
		
		String strMainWindowHandle = getDriver().getWindowHandle();
		fido_make_payment_page.selectBank("CIBC");
		reporter.reportLogWithScreenshot("Banking Page");
		fido_make_payment_page.switchToCIBCBankPage(strMainWindowHandle);
		reporter.hardAssert(fido_make_payment_page.verifyBankPageOpenedSuccessfully("CIBC"),
				"The banking page open successfully",
				"The banking page did not open successfully");		
		reporter.reportLogWithScreenshot("Banking Page Successfully Redirected");
		//close the new bank page
		getDriver().close();
		getDriver().switchTo().window(strMainWindowHandle);
		reporter.reportLogWithScreenshot("Banking page closed");		
	}

}
