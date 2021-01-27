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
public class FidoSS_TC085_SuspendedAccountBillDisplayErrorMessageOnViewBillPage extends BaseTestClass {

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

	@Test(groups = {"BillingAndPaymentsSS"})
	public void postPaidPaymentBank() throws InterruptedException {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc28.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc28.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), "Login proceed without error.",
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login succeed.", "Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc79.getaccountDetails().getBan();
		Thread.sleep(5000);
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");
		getFidobilldetailspage().switchToDefaultContent();
		String billAmount = getFidobilldetailspage().getBillAmountFromViewBillDropDown();
		getReporter().hardAssert(billAmount.equals(""), "No bills Present in the dropdown", "Bills Present in the dropdown");
		getReporter().hardAssert(
				getFidobilldetailspage().verifyBillErrorMsg(),
				"No Bills Error Message Validated Successfully", "No Bills Error Message Not Present");
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().reportLogWithScreenshot("No Bills Error Message Displayed");
	}

}
