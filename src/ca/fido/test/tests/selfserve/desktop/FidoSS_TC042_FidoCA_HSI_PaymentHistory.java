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

import ca.fido.pages.FidoAccountOverviewPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_TC042_FidoCA_HSI_PaymentHistory extends BaseTestClass{

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
	public void postPaidPaymentHistoryHSI() throws InterruptedException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc4246.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc4246.getPassword());
		reporter.reportLogWithScreenshot("HSI account credential has been set: ");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		fido_account_overview_page.clkMenuBillingAndPayments();
		reporter.reportLogWithScreenshot("Menu billing and payments selected");
		fido_account_overview_page.selectBillingAndpaymentsSubMenus(FidoAccountOverviewPage.BillingAndPaymentsSubMenuOptions.PaymentHistory);
		if(fido_account_overview_page.verifyIfAnyPaymentMade())
		{
			reporter.reportLogWithScreenshot("Transaction record table view page");
			reporter.hardAssert(fido_payment_history_page.getTotalRowCount() != 0,
								"There have some transaction record",
								"No transaction record is found, The row count is blank it seems.");		
			if(fido_payment_history_page.isPaymenyHistoryTablePresent()) 
			{
				int pageCount=fido_payment_history_page.getTotalPage();
				if(pageCount!=0)
				{
					for(int page=1;page<=pageCount;page++)
					{
						fido_payment_history_page.clkPageNumber(page);
						reporter.hardAssert(fido_payment_history_page.verifyIfThePaymentHistoryDataIsConsistent(),
											"The payment history data is consistent for page number "+page,
											"The payment history data is not consistent at page number"+page);
						reporter.reportLogWithScreenshot("Page Number "+page+" is clicked");
					}
			
				}else
				{
					reporter.hardAssert(fido_payment_history_page.verifyIfThePaymentHistoryDataIsConsistent(),
										"The payment history data is consistent",
										"The payment history data is not consistent");
				}
			}else {
			
				reporter.reportLogWithScreenshot("It seems no payment history available for this account to validate");
			}
		
		}else
		{
			reporter.reportLogWithScreenshot("No payments exists for this user so the payment history table not displayed");
		}
	}

}
