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
public class FidoSS_TC076_FidoCA_PostpaidPayment_Bank extends BaseTestClass{

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
	
	@Test(groups = {"BillingAndPaymentsSS"})
	public void postPaidPaymentBank() throws InterruptedException {
		String amountEntered="0.01";
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
/*		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.", 
				"Failed to login.");*/
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().waitForPayNowToBecomeClickable();
		//.clkPayNow();
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkPayNowNew(strBAN);
		getReporter().reportLogWithScreenshot("Pay now");

/*		getFidomakepaymentpage().setPaymentAmount(amountEntered);
		getFidomakepaymentpage().selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Bank);*/
		getFidomakepaymentpage().selectHowToPay();
		getReporter().reportLogWithScreenshot("Bank option selected");
		
		String strMainWindowHandle = getDriver().getWindowHandle();
		getFidomakepaymentpage().selectBank("cibc");
		getReporter().reportLogWithScreenshot("Banking Page");
		getFidomakepaymentpage().switchToCIBCBankPage(strMainWindowHandle);
		getReporter().hardAssert(getFidomakepaymentpage().verifyBankPageOpenedSuccessfully("CIBC"),
				"The banking page open successfully",
				"The banking page did not open successfully");		
		getReporter().reportLogWithScreenshot("Banking Page Successfully Redirected");
		//close the new bank page
		getDriver().close();
		getDriver().switchTo().window(strMainWindowHandle);
		getReporter().reportLogWithScreenshot("Banking page closed");		
	}

}
