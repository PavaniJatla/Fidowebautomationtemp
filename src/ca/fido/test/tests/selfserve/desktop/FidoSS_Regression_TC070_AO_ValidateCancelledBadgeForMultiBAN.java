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
public class FidoSS_Regression_TC070_AO_ValidateCancelledBadgeForMultiBAN extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
/*
"1. Navigate to Fido.ca
2. Sign in with proper credentials.
3.Verify the account balance in AO page
4.Validate the  ""Cancelled"" badge and the placement of badge  in AO page
5.Validate the BAN Number for which the account is cancelled
6.Validate the Billing CTA buttons and AAL offer for cancelled account
7.Validate ""View Bill History"" link in AO page and click on it
8.Validate the same details for the other cancelled accounts as before
9.Verify the details for other active accounts."	
"1.Fido.ca is up and running
2.User is displayed with Account Overview page successfully
3.Account balance is not displayed for cancelled account
4.Cancelled Badge is displayed next to the account type label in the account container as per mock
5.Account number is present beneath the account type label with no services(CTN, Internet) displayed  associated 
with that account
6.Billing CTA buttons (View Billing, Make Payment) and AAL offer are not displayed as expected
7.User is directed to the invoice history page successfully as expected
8.Details  are verified for other cancelled accounts successfully
9.Details of other active accounts are displayed as usual"	
 */
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	

	@Test(groups = {"AccountOverviewSS"})
	public void validateCancelledBadgeForMultiBAN() {
		//getDriver().get(System.getProperty("QaUrl")+"/self-serve/overview");
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrameOld();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc70.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc70.getPassword());
		String strActiveBAN = TestDataHandler.tc70.getaccountDetails().getBan();
		String strCancelledBAN =TestDataHandler.tc70.getaccountDetails().getCancelledBan();
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
		
		//.Validate the BAN Number for which the account is cancelled
		//Validate the Billing CTA buttons and AAL offer for cancelled account
		//Validate ""View Bill History"" link in AO page and click on it
		//Validate the same details for the other cancelled accounts as before
		//Verify the details for other active accounts."
		getCommonbusinessflows().scrollToMiddleOfWebPage();
		getReporter().reportLogWithScreenshot("Account overview page Middle Page View");
		getReporter().hardAssert(getFidoaccountoverviewpage().IsAnyCancelledAccountDisplayed(strCancelledBAN),
				"Cancelled account is present",
				"No cancelled account present it seems");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().validateAccountBalanceNotDisplayedForCancelledAccount(strCancelledBAN),
				"Account balance is not displayed for cancelled account",
				"Account balance is displayed for cancelled account");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().validateCancelledBadgeAndThePlacementOfBadgeInAOpage(strCancelledBAN),
				"Cancelled Badge is displayed next to the account type label in the account container",
				" It seems the Cancelled Badge is displayed NOT next to the account type label, please investigate");
		
		getReporter().hardAssert(getFidoaccountoverviewpage().validateBillingCTAButtonAndAALOfferForCancelledAccount(strCancelledBAN),
				"Billing CTA buttons (View Billing, Make Payment) and AAL offer are not displayed as expected",
				"");
		getReporter().hardAssert(getFidoaccountoverviewpage().validateViewBillHistoryLink(strCancelledBAN),
				"View bill history link is present for the cancelled account",
				"View Bill history link is not present for the cancelled account");
		
		
		getReporter().hardAssert(getFidoaccountoverviewpage().validateDetailsForActiveAccounts(strActiveBAN),
				"Details of other active accounts are displayed as usual",
				"Details of other active accounts seem to be not displayed as usual, please investigate");
		
		getReporter().reportLogWithScreenshot("Click on View Bill History Link");
		getFidoaccountoverviewpage().clkViewBillHistoryink(strCancelledBAN);
		//User is directed to the invoice history page successfully as expected
		getReporter().reportLogWithScreenshot("User is directed to the invoice history page successfully as expected ");
		getReporter().hardAssert(getFidoaccountoverviewpage().validateUserIsDirectedToInvoiceHistoryPageSuccessFully(),
				"User is directed to the invoice history page successfully as expected",
				"User is NOT directed to the invoice history page successfully as expected");
							
	}
	
	

}
