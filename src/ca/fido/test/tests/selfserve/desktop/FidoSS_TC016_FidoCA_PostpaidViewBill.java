package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class FidoSS_TC016_FidoCA_PostpaidViewBill extends BaseTestClass{

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
	
	@Test(groups = {"SanitySS","BillingAndPaymentsSS"})
	public void postPaidPaymentViewBill() throws InterruptedException, ParseException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc16.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc16.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
							"Login succeed.", 
							"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page.");
		//Integer totalCTN=fido_account_overview_page.getCTNUsers().size();		
		//fido_account_overview_page.clkViewBill();
		String strBAN = TestDataHandler.tc16.getaccountDetails().getBan();
		fido_account_overview_page.clkViewBillNew(strBAN);
		reporter.reportLogWithScreenshot("View bill page is open");
		fido_account_overview_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("Middle of view bill page");
		fido_bill_details_page.switchToDefaultContent();
		String billAmount = fido_bill_details_page.getBillAmountFromViewBillDropDown();	
		reporter.reportLogWithScreenshot("Bills selected from drop down");
		if(!billAmount.equals(""))
		{				
			fido_bill_details_page.switchToFrameViewBill();		
			String billValue = fido_bill_details_page.getMyBillValueDetails();	
			
			//===old code ======================
			/*Double subTotal = fido_bill_details_page.getBillSubTotal();
			Double balFwd =fido_bill_details_page.getBillBalanceForward();
			Double acntChargsCrdts = fido_bill_details_page.getBillAccountChargeCredits();
			Double sum = subTotal+balFwd+acntChargsCrdts; */
			
	//		DecimalFormat format = new DecimalFormat("##.00");
	//	    //sum = Double.parseDouble(format.format(sum));
	//		Double totaltoPay = fido_bill_details_page.getTotalToPayValue();
			fido_bill_details_page.switchToDefaultContent();	
			reporter.hardAssert(fido_bill_details_page.verifyIfBillValueInMainViewAndBillAmountInDropdownMatch(
					billValue.replaceAll("\\$", ""),billAmount.replaceAll(",", ".").replaceAll("\\$", "")),
					"Bill value in main view matched the bill amount in drop down",
					"Bill value in main view does not match the bill amount in drop down");
		  /*reporter.softAssert(fido_bill_details_page.verifyIfAddedSumValueMatchesTheTotalBillValueDisplayed(sum,totaltoPay)
					,"Added sum value matches the total bill value displayed"
					,"Added sum value mismatch the total bill value displayed"); */
			//reporter.softAssert(fido_bill_details_page.verifyAllCTNBillsMatchesTheSubTotalValue(subTotal)
				// 	,"The total CTN bills match the sub total value"
				//	,"The total CTN bills mismatc the sub total value");
			//reporter.hardAssert(fido_bill_details_page.verifyCTNBillCountMatchesTheTotalCTNFromOverviewPage(totalCTN),
				//	"CTN bill count matched the total number of CTN from overview page",
				//	"CTN bill count mismatch the total number of CTN from overview page");	
		
		}else
		{
			fido_bill_details_page.selectOlderBillViewBillDropDown();
			reporter.reportLogWithScreenshot("Older bills selected");
			reporter.hardAssert(fido_bill_details_page.isLabelComingSoonDisplayed(),
								"No bills generated yet for this account",
								"Some issue with bills, please investigate");
			
		}
	}

	
   
    
}
