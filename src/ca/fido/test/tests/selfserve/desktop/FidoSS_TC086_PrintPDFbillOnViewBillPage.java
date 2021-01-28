package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_TC086_PrintPDFbillOnViewBillPage  extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
	@Test(groups = {"BillingAndPaymentsSS",""})
	public void validateSavePDFLinkInViewBillPage() throws InterruptedException, ParseException {
		
		getFidohomepage().clkLogin();
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
		//getFidoaccountoverviewpage().clkViewManageBill();
		getReporter().reportLogWithScreenshot("Click on Print Page");
		getFidoaccountoverviewpage().clkPrintPDF();
		getReporter().reportLogWithScreenshot("Print or Save Bill Page ");
		getFidoaccountoverviewpage().clkPrintYourBill();
		getReporter().reportLogWithScreenshot("Print your Bill Page");
		//getFidoaccountoverviewpage().clkDownloadBill();		
		getReporter().hardAssert(getFidobilldetailspage().isPrintBillPDFpresent(),"Print bill window displayed",
				"Print bill window not displayed");
		getReporter().reportLogWithScreenshot("Print bill window displayed");	
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
