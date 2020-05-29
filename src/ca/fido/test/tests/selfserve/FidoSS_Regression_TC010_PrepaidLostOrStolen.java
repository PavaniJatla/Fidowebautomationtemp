package ca.fido.test.tests.selfserve;

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
 * Test script for report lost or stolen for Fido pre-paid account.
 * It will reactivate the device after suspend it. 
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC010_PrepaidLostOrStolen extends BaseTestClass {
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
	public void prepaidReportLostOrStolen() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc00101056.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc00101056.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page.");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		if (fido_wireless_dashboard_prepaid_page.isServiceSuspended()) {
			reporter.reportLogWithScreenshot("The service seems is suspended, reactivating the same again");
			fido_wireless_dashboard_prepaid_page.clkBtnReactivateDevice();
			fido_report_lost_or_stolen_page.clkBtnReactivateDevice();
			reporter.softAssert(fido_report_lost_or_stolen_page.verifyReactivateConfirmMessage(),
					"reactivate confirmation",
					"some issue with reactivate confirmation, please investigate");
			fido_account_overview_page.clkMenuUsageNService();
			reporter.reportLogWithScreenshot("click menu usage and service");
		}
		fido_wireless_dashboard_prepaid_page.clkLnkReportLostOrStolen();
		reporter.reportLogWithScreenshot("Click on lnk report lost or stolen");
		fido_report_lost_or_stolen_page.clkBtnReportLostContinue();
		fido_report_lost_or_stolen_page.clkBtnSuspend();
		reporter.reportLogWithScreenshot("After click on button suspend");
		reporter.softAssert(fido_report_lost_or_stolen_page.verifySuspendConfirmMessage(),
							"Suspended successfully", 
							"Suspend is not successful");
		reporter.reportLogWithScreenshot("Suspend confirmation page");
		//Successfully suspend the device, now need to reactivate the device
		fido_account_overview_page.clkMenuUsageNService();
		reporter.reportLogWithScreenshot("menu usage and service");
		fido_wireless_dashboard_prepaid_page.clkBtnReactivateDevice();
		reporter.reportLogWithScreenshot("Clicking the button Reactivate Device");
		fido_report_lost_or_stolen_page.clkBtnReactivateDevice();		
		reporter.reportLogWithScreenshot("After click on button re activate device");
		reporter.softAssert(fido_report_lost_or_stolen_page.verifyReactivateConfirmMessage(),
							"The Account reactivated sucessfully",
							"The acocunt didn't reactivate sucessfully");
	}

}
