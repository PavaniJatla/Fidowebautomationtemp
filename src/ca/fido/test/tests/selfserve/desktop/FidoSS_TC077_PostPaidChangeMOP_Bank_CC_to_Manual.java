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
public class FidoSS_TC077_PostPaidChangeMOP_Bank_CC_to_Manual extends BaseTestClass{

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
	
	
	@Test(groups = {"BillingAndPaymentsSS"})
	public void postPaidChangeMOP() {
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
		getReporter().reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
/*		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");
		getFidobilldetailspage().clkChangePaymentMethod();*/
		//getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getFidoaccountoverviewpage().clkSetUpAutomaticPayments(strBAN);
		getReporter().reportLogWithScreenshot("Automatic Payments Page is open");
//		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
//				"Change payment method modal displayed.",
//				"Change payment method modal didn't display as expected.");
//		getReporter().reportLogWithScreenshot("Change Method of payment overlay");
		if(getFidopaymentoptionspage().isAutopaymentAlreadySet())
		{
			getFidopaymentoptionspage().changeBtnAutoPayManual();
/*		getCommonbusinessflows().changeToManual();
			getFidobilldetailspage().clkChangePaymentMethod();*/
			//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		}
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");
		
		/*//Change from manual to BANK
				getReporter().reportLogWithScreenshot("Change method of payment from Manual to BANK");
				getCommonbusinessflows().changeToBank();		
				getReporter().reportLogWithScreenshot("Navigation to Account overview page");
				getFidobilldetailspage().clkAccountOverview();
				getReporter().reportLogWithScreenshot("Account overview page");
				//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
				getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
				getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
						"Change payment method modal displayed.",
						"Change payment method modal didn't display as expected.");
		
		
	
		//Change from Bank to CC
		getReporter().reportLogWithScreenshot("Change method of payment from Bank to CC");
		getCommonbusinessflows().changeToCC();		
		getFidobilldetailspage().clkAccountOverview();
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");
		
		//Change CC to manual
		getReporter().reportLogWithScreenshot("Change method of payment from CC to Manual");
		getCommonbusinessflows().changeToManual();
		getFidobilldetailspage().clkAccountOverview();
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getFidobilldetailspage().clkChangePaymentMethod();
		getCommonbusinessflows().changeToCC();		
		getFidobilldetailspage().clkAccountOverview();
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");
		*/
		

	}
	


}
