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

public class FidoSS_Regression_TC081_ValidateTheSavePDFLinkInViewBillPage extends BaseTestClass{

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
		getReporter().reportLogWithScreenshot("Login Frame Page");
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
		getReporter().reportLogWithScreenshot("Account overvew page.");
		getFidoaccountoverviewpage().clkViewManageBill();
		getReporter().reportLogWithScreenshot("Save PDF Page");
		getFidoaccountoverviewpage().clkSavePDF();
		getReporter().reportLogWithScreenshot("Save Bill Page ");
		getFidoaccountoverviewpage().clkSaveYourBill();
		getReporter().reportLogWithScreenshot("Download Bill Page");
		getFidoaccountoverviewpage().clkDownloadBill();		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyDownloadBill(),"Bill Downloaded successfully","Bill Not Downloaded");
		getReporter().reportLogWithScreenshot("Bill downloaded Page");	
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
