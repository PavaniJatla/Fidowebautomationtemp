package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import ca.fido.pages.FidoMakePaymentPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_TC014_FidoCA_PostpaidPaymentInterac extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void postPaidPaymentInterac() throws InterruptedException {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc1417.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc1417.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.waitForPayNowToBecomeClickable();
		fido_account_overview_page.clkPayNow();
		fido_make_payment_page.setPaymentAmount("1");
		reporter.reportLogWithScreenshot("payment amount entered");
		fido_make_payment_page.selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Interac);
		reporter.reportLogWithScreenshot("Payment type interac selected");
		fido_make_payment_page.clkPayOnInteracSite();
		
		if(fido_interac_online_page.isMsgFromInteracDisplayed()) {
			fido_interac_online_page.clkBtnAdvance();
			fido_interac_online_page.clkLinkProceed();
		}
		reporter.reportLogWithScreenshot("Interac website");
		fido_interac_online_page.selectFinancialInstitution();
		reporter.reportLogWithScreenshot("Interac details entered");
		fido_interac_online_page.setInteracID(TestDataHandler.paymentInfo.getInteracDetails().getInteracID());
		fido_interac_online_page.selectFundAPayment();		
		reporter.reportLogWithScreenshot("reference number page");
		String refNo=fido_make_payment_page.getRefNumber();
		reporter.reportLogWithScreenshot("payment reference number is :"+refNo);		
		reporter.hardAssert(fido_make_payment_page.verifyPaymentSuccessfulMessageDisplayed(),
							"Interac payment is successful", 
							"Interac payment is not successful");	
		fido_make_payment_page.clkPaymentHistoryLinkOnConfirmationPage();
		reporter.hardAssert(fido_payment_history_page.verifyPaymentHistory(refNo,FidoMakePaymentPage.MakePayOptions.Interac),
							"Interac transaction verified in payment history",
							"seems the interac payment history record is not valid ");							
		fido_account_overview_page.clkPayNow();
		reporter.reportLogWithScreenshot("Pay now options overlay");
		fido_make_payment_page.selectHowWouldYouLikeToPay(FidoEnums.MakePayOptions.Bank);
		reporter.reportLogWithScreenshot("Bank option selected");
		reporter.hardAssert(fido_make_payment_page.verifyBankSection(),
							"Bank section verified",
							"Bank section not verified");
		fido_make_payment_page.closePayNowModal();					
											
	}

}
