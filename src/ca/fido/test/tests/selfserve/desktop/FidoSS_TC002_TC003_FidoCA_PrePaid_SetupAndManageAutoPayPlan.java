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
	
	  	
	//@Test(groups = {"RegressionSS","BillingAndPaymentsSS","PrepaidSS"})
	public void prepaidSetUpAutoPayRefill() {
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc0203.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc0203.getPassword());
		String strBAN = TestDataHandler.tc0203.getaccountDetails().getBan();
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
		getFidoaccountoverviewpage().clkBtnRefillNowNew(strBAN);
		getReporter().reportLogWithScreenshot("Refill options page");
		if(! getFidorefillpage().isRecurringAutoRefillAlreadySet())
		{
			getReporter().reportLogWithScreenshot("Set up recurring auto refill");
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getFidorefillpage().clkRecurringAutoRefill();
			//Credit card payment 
			if(!getFidorefillpage().isCardAlreadyRegistered()) {

				getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
				getFidorefillpage().selectExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
				getFidorefillpage().selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
				getReporter().reportLogWithScreenshot("Credit card details entered");
				getFidorefillpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
				getFidoaccountoverviewpage().scrollToMiddleOfPage();
				getFidorefillpage().clkTnC();
				getReporter().reportLogWithScreenshot("Credit card T n C selected");
			}
			
			//getFidorefillpage().clkRecurringAutoPayContinue();	
			getFidorefillpage().clkContinue();			
			getReporter().reportLogWithScreenshot("Click on continue button");
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getFidorefillpage().clkSubmit();
			getReporter().reportLogWithScreenshot("After click on submit button");
			getReporter().hardAssert(getFidorefillpage().verifyAutoRefillSubmittedSuccessFully(),
								"Auto refill submitted successfully", 
								"Auto refill not submitted successfully");
			getReporter().reportLogWithScreenshot("refill success");
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getFidorefillpage().clkBacktoMyAccount();
			getReporter().reportLogWithScreenshot("Back to Account overview page");
			getFidoaccountoverviewpage().clkBtnRefillNowNew(strBAN);		
			getReporter().reportLogWithScreenshot("Click performed on Refill Button");
		}
				
		
		getFidorefillpage().clkLowBalanceAutoRefill();
		getReporter().reportLogWithScreenshot("Click on low balance auto refill perfromed");	
		
		//Assert.assertTrue(getFidorefillpage().verifyRefillPage());
		getFidorefillpage().selectAutoRefillDetails();
		
		//Credit card payment 
		if(!getFidorefillpage().isCardAlreadyRegistered()) {
			getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			getFidorefillpage().selectExpiryMonth("06");
			getFidorefillpage().selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
			getFidorefillpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
			getReporter().reportLogWithScreenshot("Credit card details entered");
		}
		getFidorefillpage().clkContinue();		
		//getReporter().softAssert(getFidorefillpage().verifyPlanSummarySumValuesMatch(),"Plan summary sum values","Plan summary sum values didnt match");
		getFidorefillpage().clkSubmit();
		getReporter().hardAssert(getFidorefillpage().verifyAutoRefillSubmittedSuccessFully(),
							"Auto refill submitted successfully", 
							"Auto refill didn't submit successfully");
		getReporter().reportLogWithScreenshot("Page after submit auto refill.");
		getFidorefillpage().clkBacktoMyAccount();
		
		
		//Stop the auto pay refill
		getFidoaccountoverviewpage().clkBtnRefillNowNew(strBAN);
		getFidorefillpage().clkLowBalanceAutoRefill();
		getReporter().reportLogWithScreenshot("Low Balance Auto Refill is clicked.");
		getFidorefillpage().clkStopAutoPayment();
		getFidorefillpage().clkYesOnStopAutoPaymentOverlay();
		getReporter().reportLogWithScreenshot("Click yes on stop auto payment overlay");
		getReporter().hardAssert(getFidorefillpage().verifyAutoRefillStoppedSuccessfully(),
							"Auto refill stopped",
							"Auto refill stop didnt happen successfully");

		getReporter().reportLogWithScreenshot("Refill options page");
		if(getFidorefillpage().isRecurringAutoRefillAlreadySet())
		{
			getReporter().reportLogWithScreenshot("Set up recurring auto refill");
			getFidorefillpage().clkRecurringAutoRefill();
			getFidorefillpage().clkStopAutoPayment();
			getFidorefillpage().clkYesOnStopAutoPaymentOverlay();
			getReporter().hardAssert(getFidorefillpage().verifyAutoRefillStoppedSuccessfully(),"Auto refill stopped","Auto refill stop didnt happen successfully");
		}
		
	}
	
	

}
