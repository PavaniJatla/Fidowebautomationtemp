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
import utils.FormFiller;

public class FidoSS_Regression_TC018_PostpaidUpdateSIMCard extends BaseTestClass{
	
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
	public void postpaidUpdateSIMCard() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc18.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc18.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("After click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkLnkUpdateSimCard();
		reporter.reportLogWithScreenshot("Click on Link : Update Sim card");
		String strOldSimNum = TestDataHandler.tc18.getaccountDetails().getSimCardNumber();
		fido_wireless_dashboard_postpaid_page.setOldSimNum(strOldSimNum);
		String strNewSimNum = FormFiller.generateSIMNumber();		
		fido_wireless_dashboard_postpaid_page.setNewSimNum(strNewSimNum);
		reporter.reportLogWithScreenshot("Fill old and new sim card details");
		fido_wireless_dashboard_postpaid_page.clkBtnUpdateSimNext();
		reporter.reportLogWithScreenshot("Click Button update SIM card Next button");
		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyUpdateSimReview(strOldSimNum, strNewSimNum),
				"SIM review successful",
				"SIM review is not successful, please investigate");	
		reporter.reportLogWithScreenshot("Update SIM card review page.");
	}

}
