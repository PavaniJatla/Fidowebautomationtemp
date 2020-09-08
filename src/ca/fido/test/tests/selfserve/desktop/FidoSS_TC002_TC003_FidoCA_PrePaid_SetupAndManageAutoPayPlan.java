package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_TC002_TC003_FidoCA_PrePaid_SetupAndManageAutoPayPlan extends BaseTestClass{

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
	public void prepaidSetUpAutoPayRefill() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc0203.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc0203.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkBtnRefillNow();
		reporter.reportLogWithScreenshot("Refill options page");
		if(! fido_refill_page.isRecurringAutoRefillAlreadySet())
		{
			reporter.reportLogWithScreenshot("Set up recurring auto refill");
			fido_refill_page.clkRecurringAutoRefill();
			//Credit card payment 
			if(!fido_refill_page.isCardAlreadyRegistered()) {

				fido_refill_page.setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
				fido_refill_page.selectExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
				fido_refill_page.selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
				reporter.reportLogWithScreenshot("Credit card details entered");
				fido_refill_page.setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
				fido_refill_page.clkTnC();
				reporter.reportLogWithScreenshot("Credit card T n C selected");
			}
			
			//fido_refill_page.clkRecurringAutoPayContinue();	
			fido_refill_page.clkContinue();			
			reporter.reportLogWithScreenshot("Click on continue button");
			fido_refill_page.clkSubmit();
			reporter.reportLogWithScreenshot("After click on submit button");
			reporter.hardAssert(fido_refill_page.verifyAutoRefillSubmittedSuccessFully(),
								"Auto refill submitted successfully", 
								"Auto refill not submitted successfully");
			reporter.reportLogWithScreenshot("refill success");
			fido_refill_page.clkBacktoMyAccount();
			reporter.reportLogWithScreenshot("Back to Account overview page");
			fido_account_overview_page.clkBtnRefillNow();			
			reporter.reportLogWithScreenshot("Click performed on Refill Button");
		}
				
		
		fido_refill_page.clkLowBalanceAutoRefill();
		reporter.reportLogWithScreenshot("Click on low balance auto refill perfromed");	
		
		//Assert.assertTrue(fido_refill_page.verifyRefillPage());
		fido_refill_page.selectAutoRefillDetails();
		
		//Credit card payment 
		if(!fido_refill_page.isCardAlreadyRegistered()) {
			fido_refill_page.setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			fido_refill_page.selectExpiryMonth("06");
			fido_refill_page.selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
			fido_refill_page.setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
			reporter.reportLogWithScreenshot("Credit card details entered");
		}
		fido_refill_page.clkContinue();		
		//reporter.softAssert(fido_refill_page.verifyPlanSummarySumValuesMatch(),"Plan summary sum values","Plan summary sum values didnt match");
		fido_refill_page.clkSubmit();
		reporter.hardAssert(fido_refill_page.verifyAutoRefillSubmittedSuccessFully(),
							"Auto refill submitted successfully", 
							"Auto refill didn't submit successfully");
		reporter.reportLogWithScreenshot("Page after submit auto refill.");
		fido_refill_page.clkBacktoMyAccount();
		
		
		//Stop the auto pay refill
		fido_account_overview_page.clkBtnRefillNow();
		fido_refill_page.clkLowBalanceAutoRefill();
		reporter.reportLogWithScreenshot("Low Balance Auto Refill is clicked.");
		fido_refill_page.clkStopAutoPayment();
		fido_refill_page.clkYesOnStopAutoPaymentOverlay();
		reporter.reportLogWithScreenshot("Click yes on stop auto payment overlay");
		reporter.hardAssert(fido_refill_page.verifyAutoRefillStoppedSuccessfully(),
							"Auto refill stopped",
							"Auto refill stop didnt happen successfully");

		reporter.reportLogWithScreenshot("Refill options page");
		if(fido_refill_page.isRecurringAutoRefillAlreadySet())
		{
			reporter.reportLogWithScreenshot("Set up recurring auto refill");
			fido_refill_page.clkRecurringAutoRefill();
			fido_refill_page.clkStopAutoPayment();
			fido_refill_page.clkYesOnStopAutoPaymentOverlay();
			reporter.hardAssert(fido_refill_page.verifyAutoRefillStoppedSuccessfully(),"Auto refill stopped","Auto refill stop didnt happen successfully");
		}
		
	}
	
	

}
