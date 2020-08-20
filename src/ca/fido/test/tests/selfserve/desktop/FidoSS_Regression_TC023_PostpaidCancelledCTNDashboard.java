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

/**
 * This script will verify the wireless dashboard of Cancelled CTN post paid account
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC023_PostpaidCancelledCTNDashboard extends BaseTestClass{
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
	public void postpaidCancelledCTNDashBoard() throws InterruptedException, IllegalArgumentException, IllegalAccessException {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc23.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc23.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Cancelled CTN account overview page");
		reporter.hardAssert(fido_account_overview_page.verifyCancelledCTNAccountAccessLimitedMessage(),
							"CancelledCTNAccountAccessLimitedMessage",
							"CancelledCTNAccountAccessLimitedMessage not displayed");
		reporter.hardAssert(fido_account_overview_page.verifyAccountOverviewCalcelledWarningUnderYourMobileAccount(),
							"Account Overview Cancelled Warning Under Your Mobile Account",
							"Account Overview Cancelled Warning Under Your Mobile Account  not displayed");
		fido_account_overview_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("Cancelled CTN mid page view of account overview");
		reporter.hardAssert(fido_account_overview_page.getCTNUsers().keySet().size()==0,
							"The CTN is not displayed of the cancelled CTN",
							"It seems the CTN is displayed for cancelled CTN, please investigate"); //This will fail for now due to defect {CQ:CQUSR02260935} ALM 197990
		
	}

}
