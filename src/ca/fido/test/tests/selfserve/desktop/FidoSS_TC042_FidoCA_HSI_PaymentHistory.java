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
public class FidoSS_TC042_FidoCA_HSI_PaymentHistory extends BaseTestClass{

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
	public void postPaidPaymentHistoryHSI() throws InterruptedException {
		
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc4246.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc4246.getPassword());
		getReporter().reportLogWithScreenshot("HSI account credential has been set: ");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		String strBAN = TestDataHandler.tc4246.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");
		getFidoaccountoverviewpage().clkMenuBillingAndPayments();
		getReporter().reportLogWithScreenshot("Menu billing and payments selected");
		getFidoaccountoverviewpage().selectBillingAndpaymentsSubMenus(FidoAccountOverviewPage.BillingAndPaymentsSubMenuOptions.PaymentHistory);
		if(getFidoaccountoverviewpage().verifyIfAnyPaymentMade())
		{
			getReporter().reportLogWithScreenshot("Transaction record table view page");
			getReporter().hardAssert(getFidopaymenthistorypage().getTotalRowCount() != 0,
								"There have some transaction record",
								"No transaction record is found, The row count is blank it seems.");		
			if(getFidopaymenthistorypage().isPaymenyHistoryTablePresent()) 
			{
				int pageCount=getFidopaymenthistorypage().getTotalPage();
				if(pageCount!=0)
				{
					for(int page=1;page<=pageCount;page++)
					{
						getFidopaymenthistorypage().clkPageNumber(page);
						getReporter().hardAssert(getFidopaymenthistorypage().verifyIfThePaymentHistoryDataIsConsistent(),
											"The payment history data is consistent for page number "+page,
											"The payment history data is not consistent at page number"+page);
						getReporter().reportLogWithScreenshot("Page Number "+page+" is clicked");
					}
			
				}else
				{
					getReporter().hardAssert(getFidopaymenthistorypage().verifyIfThePaymentHistoryDataIsConsistent(),
										"The payment history data is consistent",
										"The payment history data is not consistent");
				}
			}else {
			
				getReporter().reportLogWithScreenshot("It seems no payment history available for this account to validate");
			}
		
		}else
		{
			getReporter().reportLogWithScreenshot("No payments exists for this user so the payment history table not displayed");
		}
	}

}
