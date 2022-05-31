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
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");

		/*getFidoaccountoverviewpage().clkMenuBillingAndPayments();
		getReporter().reportLogWithScreenshot("Menu Billings and payments selected");
		getFidoaccountoverviewpage().selectBillingAndpaymentsSubMenus(FidoAccountOverviewPage.BillingAndPaymentsSubMenuOptions.PaymentHistory);
		//getReporter().softAssert(getFidopaymenthistorypage().getTotalRowCount()!=0,"","The row count is blank it seem");*/

		getFidoaccountoverviewpage().clkPaymentHistory();

		getReporter().reportLogWithScreenshot("Payment history page");
		if(getFidopaymenthistorypage().isPaymenyHistoryTablePresent()) 
		{
			getReporter().reportLogWithScreenshot("Transaction records view");
			int pageCount=getFidopaymenthistorypage().getTotalPage();
			if(pageCount!=0)
			{
				for(int page=1;page<=pageCount;page++)
				{
					getReporter().reportLogWithScreenshot("Payment history Page :"+page);
					getFidopaymenthistorypage().clkPageNumber(page);
					getReporter().hardAssert(getFidopaymenthistorypage().verifyIfThePaymentHistoryDataIsConsistent(),
										"Payment history data is consistent in page: " + page, 
										"Payment history data is not consistent for page no: " + page);
				}
		
			}else
			{
				getReporter().reportLogWithScreenshot("Payment history records");
				getReporter().hardAssert(getFidopaymenthistorypage().verifyIfThePaymentHistoryDataIsConsistent(),
									"Payment history data is consistent ",  
									"Payment history data is not consistent" );
			}
		}else {
			getReporter().reportLogWithScreenshot("Payment history page view");
			getReporter().hardAssert(getFidopaymenthistorypage().verifyNoPaymentRecordMessage(),
					"No payment history records present yet for this account, please make some transactions",
					"The label No payment history records is not shown and the payment history table is also not displayed, please investigate");
			
		}
	
								
		
	}

}
