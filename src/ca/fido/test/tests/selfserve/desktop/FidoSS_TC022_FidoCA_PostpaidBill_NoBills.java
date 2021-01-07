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
 * This script will verify the post paid payment flow with No Bills Present in
 * the dropdown & Error Message Present for No Bills.
 * 
 * @author Karthic.Hasan
 *
 */
public class FidoSS_TC022_FidoCA_PostpaidBill_NoBills extends BaseTestClass {

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "strBrowser", "strLanguage" })
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,
			ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, FidoEnums.GroupName.selfserve, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

	@Test(groups = { "SanitySS", "BillingAndPaymentsSS", "TC22" })
	public void postPaidPaymentBank() throws InterruptedException {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc22.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc22.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), "Login proceed without error.",
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login succeed.", "Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc22.getaccountDetails().getBan();
		Thread.sleep(5000);
		fido_account_overview_page.clkViewBillNew(strBAN);
		reporter.reportLogWithScreenshot("View bill page is open");
		fido_bill_details_page.switchToDefaultContent();
		String billAmount = fido_bill_details_page.getBillAmountFromViewBillDropDown();
		reporter.hardAssert(billAmount.equals(""), "No bills Present in the dropdown", "Bills Present in the dropdown");
		reporter.hardAssert(
				fido_bill_details_page.verifyBillErrorMsg(),
				"No Bills Error Message Validated Successfully", "No Bills Error Message Not Present");
		fido_account_overview_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("No Bills Error Message Displayed");
	}

}
