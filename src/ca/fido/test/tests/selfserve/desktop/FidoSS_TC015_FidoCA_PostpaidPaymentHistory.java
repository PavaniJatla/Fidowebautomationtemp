package ca.fido.test.tests.selfserve.desktop;

import ca.fido.pages.FidoAccountOverviewPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_TC015_FidoCA_PostpaidPaymentHistory extends BaseTestClass{

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
	
	@Test(groups = {"RegressionSS","BillingAndPaymentsSS"})
	public void postPaidPaymentHistoryDataValidations() throws InterruptedException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		fido_account_overview_page.clkMenuBillingAndPayments();
		reporter.reportLogWithScreenshot("Menu Billings and payments selected");
		fido_account_overview_page.selectBillingAndpaymentsSubMenus(FidoAccountOverviewPage.BillingAndPaymentsSubMenuOptions.PaymentHistory);
		//reporter.softAssert(fido_payment_history_page.getTotalRowCount()!=0,"","The row count is blank it seem");
		
		reporter.reportLogWithScreenshot("Payment history page");	
		if(fido_payment_history_page.isPaymenyHistoryTablePresent()) 
		{
			reporter.reportLogWithScreenshot("Transaction records view");
			int pageCount=fido_payment_history_page.getTotalPage();
			if(pageCount!=0)
			{
				for(int page=1;page<=pageCount;page++)
				{
					reporter.reportLogWithScreenshot("Payment history Page :"+page);
					fido_payment_history_page.clkPageNumber(page);
					reporter.hardAssert(fido_payment_history_page.verifyIfThePaymentHistoryDataIsConsistent(),
										"Payment history data is consistent in page: " + page, 
										"Payment history data is not consistent for page no: " + page);
				}
		
			}else
			{
				reporter.reportLogWithScreenshot("Payment history records");
				reporter.hardAssert(fido_payment_history_page.verifyIfThePaymentHistoryDataIsConsistent(),
									"Payment history data is consistent ",  
									"Payment history data is not consistent" );
			}
		}else {
			reporter.reportLogWithScreenshot("Payment history page view");
			reporter.hardAssert(fido_payment_history_page.verifyNoPaymentRecordMessage(),
					"No payment history records present yet for this account, please make some transactions",
					"The label No payment history records is not shown and the payment history table is also not displayed, please investigate");
			
		}
	
								
		
	}

}
