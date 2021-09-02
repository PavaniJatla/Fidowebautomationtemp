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
		
		//getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc16.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc16.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();		
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
							"Login succeed.", 
							"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page.");
		//Integer totalCTN=getFidoaccountoverviewpage().getCTNUsers().size();		
		//getFidoaccountoverviewpage().clkViewBill();
		String strBAN = TestDataHandler.tc16.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().reportLogWithScreenshot("Middle of view bill page");
		getFidobilldetailspage().switchToDefaultContent();
		String billAmount = getFidobilldetailspage().getBillAmountFromViewBillDropDown();	
		getReporter().reportLogWithScreenshot("Bills selected from drop down");
		if(!billAmount.equals(""))
		{				
			getFidobilldetailspage().switchToFrameViewBill();		
			String billValue = getFidobilldetailspage().getMyBillValueDetails();	
			
			//===old code ======================
			/*Double subTotal = getFidobilldetailspage().getBillSubTotal();
			Double balFwd =getFidobilldetailspage().getBillBalanceForward();
			Double acntChargsCrdts = getFidobilldetailspage().getBillAccountChargeCredits();
			Double sum = subTotal+balFwd+acntChargsCrdts; */
			
	//		DecimalFormat format = new DecimalFormat("##.00");
	//	    //sum = Double.parseDouble(format.format(sum));
	//		Double totaltoPay = getFidobilldetailspage().getTotalToPayValue();
			getFidobilldetailspage().switchToDefaultContent();	
			getReporter().hardAssert(getFidobilldetailspage().verifyIfBillValueInMainViewAndBillAmountInDropdownMatch(
					billValue.replaceAll("\\$", ""),billAmount.replaceAll(",", ".").replaceAll("\\$", "")),
					"Bill value in main view matched the bill amount in drop down",
					"Bill value in main view does not match the bill amount in drop down");
		  /*getReporter().softAssert(getFidobilldetailspage().verifyIfAddedSumValueMatchesTheTotalBillValueDisplayed(sum,totaltoPay)
					,"Added sum value matches the total bill value displayed"
					,"Added sum value mismatch the total bill value displayed"); */
			//getReporter().softAssert(getFidobilldetailspage().verifyAllCTNBillsMatchesTheSubTotalValue(subTotal)
				// 	,"The total CTN bills match the sub total value"
				//	,"The total CTN bills mismatc the sub total value");
			//getReporter().hardAssert(getFidobilldetailspage().verifyCTNBillCountMatchesTheTotalCTNFromOverviewPage(totalCTN),
				//	"CTN bill count matched the total number of CTN from overview page",
				//	"CTN bill count mismatch the total number of CTN from overview page");	
		
		}else
		{
			getFidobilldetailspage().selectOlderBillViewBillDropDown();
			getReporter().reportLogWithScreenshot("Older bills selected");
			getReporter().hardAssert(getFidobilldetailspage().isLabelComingSoonDisplayed(),
								"No bills generated yet for this account",
								"Some issue with bills, please investigate");
			
		}
	}

	
   
    
}
