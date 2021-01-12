package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_TC005_Prepaid_OneTimeRefill_CC  extends BaseTestClass{

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
	
	@Test(groups = {"RegressionSS","BillingAndPaymentsSS","PrepaidSS"})
	public void prepaidOneTimeRefill() {
		getFidohomepage().clkLogin();
		String userName=TestDataHandler.tc0405.getUsername();
		String password=TestDataHandler.tc0405.getPassword();
		String strBAN = TestDataHandler.tc0405.getaccountDetails().getBan();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(userName);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Prepaid account overview page.");
		getFidoaccountoverviewpage().clkBtnRefillNowNew(strBAN);
		getReporter().reportLogWithScreenshot("Refill options page");
		String balanceBeforeRefill = getFidorefillpage().getBalanceAmount();
		System.out.println("Balance before refill is: " + balanceBeforeRefill);
		getFidorefillpage().clkOneTimeRefill();
		getReporter().reportLogWithScreenshot("One time refill is clicked.");
		getFidorefillpage().selectPayByCreditCard();
		getReporter().reportLogWithScreenshot("Pay by Credit card is selected.");
		//Credit card payment 
		if(!getFidorefillpage().isCardAlreadyRegistered()) {

			getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			getFidorefillpage().selectExpiryMonth("06");
			getFidorefillpage().selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
			getFidorefillpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
			getFidorefillpage().chkAuthorizeTerms();

		}
		getReporter().reportLogWithScreenshot("Enter credit card details before click continue.");
		getFidorefillpage().clkContinue();		  
		String refillAmount = getFidorefillpage().getRefillAmount();
		String balanceAfterRefill = Float.toString(Float.parseFloat(balanceBeforeRefill.replaceAll(",", ".").trim()) + Float.parseFloat(refillAmount.replaceAll("\\$", "").replaceAll(",", ".").trim()));
		System.out.println("Balance after refill is: " + balanceAfterRefill);
		getReporter().reportLogWithScreenshot("Page after refill and before submit.");
		getFidorefillpage().clkSubmit();		
		getReporter().hardAssert(getFidorefillpage().verifyOneTimeRefillSubmittedSuccessFully(),
				"One time refill submitted successfully", 
				"One time refill not submitted successfully");
		getFidorefillpage().clkBacktoMyAccount();
		
		//Verify the transaction
		getFidoaccountoverviewpage().clkBtnViewTransactionsNew(strBAN);
		getReporter().reportLogWithScreenshot("View transaction clicked.");
		getFidoaccountoverviewpage().clkFidoTransactions();
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().reportLogWithScreenshot("Verify Fido transaction on this page.");
		getReporter().hardAssert(getFidopaymenthistorypage().verifyFidoTransactionRecord("Recharge card Réapprovisionnement de carte",refillAmount),
				"Transaction history records matched", 
				"transaction history records didnt match");
	}
}
