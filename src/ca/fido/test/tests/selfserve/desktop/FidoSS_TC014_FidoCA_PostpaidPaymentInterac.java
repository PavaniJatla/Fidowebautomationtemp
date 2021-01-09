package ca.fido.test.tests.selfserve.desktop;

import ca.fido.pages.FidoMakePaymentPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_TC014_FidoCA_PostpaidPaymentInterac extends BaseTestClass{

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
	
	@Test
	public void postPaidPaymentInterac() throws InterruptedException {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc1417.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc1417.getPassword());
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
		getFidoaccountoverviewpage().waitForPayNowToBecomeClickable();
		getFidoaccountoverviewpage().clkPayNow();
		getFidomakepaymentpage().setPaymentAmount("1");
		getReporter().reportLogWithScreenshot("payment amount entered");
		getFidomakepaymentpage().selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Interac);
		getReporter().reportLogWithScreenshot("Payment type interac selected");
		getFidomakepaymentpage().clkPayOnInteracSite();
		
		if(getFidointeraconlinepage().isMsgFromInteracDisplayed()) {
			getFidointeraconlinepage().clkBtnAdvance();
			getFidointeraconlinepage().clkLinkProceed();
		}
		getReporter().reportLogWithScreenshot("Interac website");
		getFidointeraconlinepage().selectFinancialInstitution();
		getReporter().reportLogWithScreenshot("Interac details entered");
		getFidointeraconlinepage().setInteracID(TestDataHandler.paymentInfo.getInteracDetails().getInteracID());
		getFidointeraconlinepage().selectFundAPayment();		
		getReporter().reportLogWithScreenshot("reference number page");
		String refNo=getFidomakepaymentpage().getRefNumber();
		getReporter().reportLogWithScreenshot("payment reference number is :"+refNo);		
		getReporter().hardAssert(getFidomakepaymentpage().verifyPaymentSuccessfulMessageDisplayed(),
							"Interac payment is successful", 
							"Interac payment is not successful");	
		getFidomakepaymentpage().clkPaymentHistoryLinkOnConfirmationPage();
		getReporter().hardAssert(getFidopaymenthistorypage().verifyPaymentHistory(refNo,FidoMakePaymentPage.MakePayOptions.Interac),
							"Interac transaction verified in payment history",
							"seems the interac payment history record is not valid ");							
		getFidoaccountoverviewpage().clkPayNow();
		getReporter().reportLogWithScreenshot("Pay now options overlay");
		getFidomakepaymentpage().selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Bank);
		getReporter().reportLogWithScreenshot("Bank option selected");
		getReporter().hardAssert(getFidomakepaymentpage().verifyBankSection(),
							"Bank section verified",
							"Bank section not verified");
		getFidomakepaymentpage().closePayNowModal();					
											
	}

}
