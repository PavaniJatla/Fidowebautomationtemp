package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

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
 * The test will verify demo-line account add data flow and manage data page, 
 * as well as verify the total data and data accuracy in manage data page. 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC64_ValidateErrorMessageWhenMDTandProfileMaximumLimit extends BaseTestClass{
	
	
	 	
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
	public void verifyAddDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		reporter.reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		fido_home_page.clkLogin();
	
		String	userName = TestDataHandler.tc6062.getUsername();
		String	password = TestDataHandler.tc6062.getPassword();
		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		reporter.reportLogWithScreenshot("dashboard page loaded");
		
		reporter.softAssert(fido_data_management_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		reporter.reportLogWithScreenshot("View details page opened");
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Manage data page middle view");
		int countOfExistSpeedPass = fido_data_management_page.getAllExistingAddDataCount();
		common_business_flows.scrollToTopOfWebPage();		
		Map<String, Integer> countOfAlreadyAddedData = fido_data_management_page.getCountOfAllExistingAddedDataValues();
		fido_data_management_page.clkLinkBackOnManageDataOverlay();
		Map.Entry<String,Integer> entry = countOfAlreadyAddedData.entrySet().iterator().next();
		 String strAddOnValue = entry.getKey();
		 Integer intValue = entry.getValue();
		
		if(!(countOfExistSpeedPass>9) && intValue!=3) {			
			for(int itr=1;itr<=(3-intValue);itr++)
			{
				completeAddDataFlow(strAddOnValue);
				reporter.softAssert(fido_add_data_page.verifyAddDataSuccessMsgDisplayed(),
						"Add data success message is displayed",
						"Add data success message is not displayed");					
				reporter.reportLogWithScreenshot("Add data success modal.");			
				fido_add_data_page.clkCloseBtnOnAddDataOverlay();
			}
			
		}
		
	
	   //Add extra time
		completeAddDataFlow(strAddOnValue);
		reporter.hardAssert(fido_add_data_page.isLimitReachedMsgDisplayed(),
				"Limit reached message is displayed for Add MDT/ OTT more than 3 times and more than 10 times",
				"Limit reached message is NOT displayed for Add MDT/ OTT more than 3 times and more than 10 times");
		reporter.reportLogWithScreenshot("Limit Reached Overlay displayed");		
		fido_add_data_page.clkCloseBtnOnAddDataOverlay();
					
	}
	
	public void completeAddDataFlow(String strDataValue) {
		fido_wireless_dashboard_postpaid_page.clkAddDataButton();						
		reporter.softAssert(fido_add_data_page.verifyOverlayMonthlyDataAddOnDisplayed(),
							"Monthly data add on overlay is displayed",
							"Monthly data add on overlay is not displayed");			
		reporter.reportLogWithScreenshot("Add monthly data add on overlay");
		
		fido_add_data_page.clkTheDataAddOnValue(strDataValue);
		fido_add_data_page.clkContinueBtnOnAddDataOverlay();
		reporter.softAssert(fido_add_data_page.verifyConfirmPurchasingMsgDisplayed(),
							"Confirm purchasing on overlay is displayed",
							"Confirm purchasing on overlay is not displayed");	
		reporter.reportLogWithScreenshot("Confirm purchasing on add data overlay");
		fido_add_data_page.clkPurchaseBtnOnAddDataOverlay();
	}
	
}
