package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC028_PostpaidSuspendCtnDashboard extends BaseTestClass {

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
	
	
	@Test (groups = {"RegressionSS","DashboardSS"})
	public void postpaidSuspendedCTN() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc28.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc28.getPassword());
		String strBan = TestDataHandler.tc28.getaccountDetails().getBan();		
		reporter.reportLogWithScreenshot("After click on Login");	
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Suspended CTN account overview page");
		reporter.hardAssert(fido_account_overview_page.validateBillingCTAButtonAddLineForSuspendedAccount(strBan),
				"CTN, View usage and manage and add line is not displayed for suspended account",
				"Suspended account overview page seems invalid, please investigate");
		
	}
}
