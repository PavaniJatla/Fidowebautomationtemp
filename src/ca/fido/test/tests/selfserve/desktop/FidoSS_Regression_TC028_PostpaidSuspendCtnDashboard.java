package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC028_PostpaidSuspendCtnDashboard extends BaseTestClass {

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test 
	public void postpaidSuspendedCTN() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc28.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc28.getPassword());
		reporter.reportLogWithScreenshot("After click on Login");	
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.hardAssert(fido_account_overview_page.verifyAccountSuspension(),
				"Message account suspended is displayed",
				"Message account suspended not displayed");
		reporter.reportLogWithScreenshot("Account overview page for account suspension");
		reporter.hardAssert(fido_account_overview_page.verifyAccountSuspendedWarning(),
				"Account suspension warning is displayed",
				"Account suspension warning not displayed");
		reporter.softAssert(!fido_account_overview_page.verifyTheAbsenceOfService(),
				"Button service is not displayed for suspended CTN",
				"Button service is displayed for suspended CTN, please investigate");
		fido_account_overview_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("Account overview middle page.");

	}
}
