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

public class FidoSS_Regression_TC013_ValidateTheSavePDFLinkInViewBillPage  extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
	@Test(groups = {"BillingAndPaymentsSS",""})
	public void validateSavePDFLinkInViewBillPage() throws InterruptedException, ParseException {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Login Frame Page");
		fido_login_page.setUsernameInFrame(TestDataHandler.tc13.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc13.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(),
				"Login proceed without error.",
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overvew page.");
		fido_account_overview_page.clkViewManageBill();
		reporter.reportLogWithScreenshot("Save PDF Page");
		fido_account_overview_page.clkSavePDF();
		reporter.reportLogWithScreenshot("Save Bill Page ");
		fido_account_overview_page.clkSaveYourBill();
		reporter.reportLogWithScreenshot("Download Bill Page");
		fido_account_overview_page.clkDownloadBill();		
		reporter.hardAssert(fido_account_overview_page.verifyDownloadBill(),"Bill Downloaded successfully","Bill Not Downloaded");
		reporter.reportLogWithScreenshot("Bill downloaded Page");	
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
