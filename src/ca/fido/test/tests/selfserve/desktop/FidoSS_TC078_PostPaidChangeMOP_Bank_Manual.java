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
public class FidoSS_TC078_PostPaidChangeMOP_Bank_Manual extends BaseTestClass{

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
	public void postPaidChangeMOP() {
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
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getFidoaccountoverviewpage().clkSetUpAutomaticPayments(strBAN);
		getReporter().reportLogWithScreenshot("Automatic Payments Page is open");
		//getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		//getReporter().reportLogWithScreenshot("View bill page is open");
		//getFidobilldetailspage().clkChangePaymentMethod();
		//getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
/*		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");
		getReporter().reportLogWithScreenshot("Change Method of payment overlay");*/
		if(getFidopaymentoptionspage().isAutopaymentAlreadySet())
		{
			getFidopaymentoptionspage().changeBtnAutoPayManual();
			//getFidobilldetailspage().clkChangePaymentMethod();
			//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		} else {
			getFidopaymentoptionspage().clkContinue();
			getFidopaymentoptionspage().setBankTransitNumber(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
			getFidopaymentoptionspage().setInstitutionNumber(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
			getFidopaymentoptionspage().setBankAccountNumer(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber());
			getFidopaymentoptionspage().clkContinueInBankSection();
			getFidopaymentoptionspage().clkAgreeTermsAndCondition();
			getFidopaymentoptionspage().clkSubmit();
			getFidopaymentoptionspage().clkOnDone();
			getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
			getFidopaymentoptionspage().changeBtnAutoPayManual();
		}
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");


	/*	//Change CC to bank
				getReporter().reportLogWithScreenshot("Change method of payment from Manual to BANK");
				getCommonbusinessflows().changeToBank();		
				getFidobilldetailspage().clkAccountOverview();
				getReporter().reportLogWithScreenshot("Account overview page");
				//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
				getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
				getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
						"Change payment method modal displayed.",
						"Change payment method modal didn't display as expected.");
		*/
		
	
	}
	

}


