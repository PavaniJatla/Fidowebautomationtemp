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
public class FidoSS_TC082_ValidateTheSetUpAutomaticPaymentFlowUsingCreditCard extends BaseTestClass{

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
/*		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.", 
				"Failed to login.");*/
		getReporter().reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getFidoaccountoverviewpage().clkSetUpAutomaticPayments(strBAN);
		getReporter().reportLogWithScreenshot("Automatic Payments Page is open");
		if(getFidopaymentoptionspage().isAutopaymentAlreadySet())
		{
			getFidopaymentoptionspage().changeBtnAutoPayManual();
			getFidoaccountoverviewpage().clkSetUpAutomaticPayments(strBAN);
			getFidopaymentoptionspage().setBtnAutoPayCreditCard();
		}
		getFidopaymentoptionspage().setBtnAutoPayCreditCard();
		getFidomakepaymentpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() +
				TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);

		getFidomakepaymentpage().selectCreditcardExpiryYear(strDDMM);

		getFidomakepaymentpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		getFidomakepaymentpage().clkReviewAndContinueButton();
		//getFidomakepaymentpage().clkContinue();
		getFidomakepaymentpage().clkPayNow();
		getFidopaymentoptionspage().clkOnDone();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");

		
/*		//Change CC to bank
		getReporter().reportLogWithScreenshot("Change method of payment from Bank to CC");
		getCommonbusinessflows().changeToCC();		
		getFidobilldetailspage().clkAccountOverview();
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		//getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().hardAssert(getFidoaccountoverviewpage().IsAutoPaymentSetUp(),
				"CC Auto payment method set up successful",
				"CC Auto payment method set up NOT successful");*/
		
		
	
	}
	

}


