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

public class FidoSS_Regression_TC025_PostpaidLostOrStolen extends BaseTestClass {

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
	public void postpaidLostOrStolen() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc25.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc25.getPassword());
		reporter.reportLogWithScreenshot("After click on Login");
		fido_login_page.clkLoginInFrame();	
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("After click on CTN badge");
		if(fido_wireless_dashboard_postpaid_page.isServiceSuspended()) {
			reporter.reportLogWithScreenshot("Service suspended view");
			fido_wireless_dashboard_postpaid_page.clkLnkReactivate();
			reporter.reportLogWithScreenshot("After click on link reactivate");
			fido_report_lost_or_stolen_page.clkBtnReactivateDevice();
			reporter.reportLogWithScreenshot("After click on Button reactivate device");
			reporter.softAssert(fido_report_lost_or_stolen_page.verifyReactivateConfirmMessage(),
					"Reactivate confirmation Message is displayed",
					"Reactivate confirmation message is not displayed");
			fido_account_overview_page.clkMenuOverview();
			reporter.reportLogWithScreenshot("Menu Overview clicked.");
			fido_account_overview_page.clkCtnBadge();
			reporter.reportLogWithScreenshot("After click on CTN badge");
		} 
		fido_wireless_dashboard_postpaid_page.clkLnkReportLostOrStolen();
		reporter.reportLogWithScreenshot("After clcik on link report Lost or Stolen");
		fido_report_lost_or_stolen_page.clkBtnReportLostContinue();
		reporter.reportLogWithScreenshot("Report lost suspend");
		fido_report_lost_or_stolen_page.clkBtnSuspend();
		reporter.reportLogWithScreenshot("After click on Button Suspend");
		reporter.softAssert(fido_report_lost_or_stolen_page.verifySuspendConfirmMessage(),
							"Suspend Confirmation message is displayed",
							"Suspend Confirmation message is not displayed");
		
		//Successfully suspend the device, now need to reactivate the device
		fido_account_overview_page.clkMenuOverview();
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Navigating back to Overview page and click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkLnkReactivate();		
		fido_report_lost_or_stolen_page.clkBtnReactivateDevice();
		reporter.reportLogWithScreenshot("After click on button Reactivate");
		reporter.softAssert(fido_report_lost_or_stolen_page.verifyReactivateConfirmMessage(),
							"Reactivate confirmation Message is displayed",
							"Reactivate confirmation message is not displayed");
	}

}
