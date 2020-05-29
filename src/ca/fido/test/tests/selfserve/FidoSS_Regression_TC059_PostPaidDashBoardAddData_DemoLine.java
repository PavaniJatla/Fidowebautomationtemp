package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

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
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC059_PostPaidDashBoardAddData_DemoLine extends BaseTestClass{
	
	
	 	
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
	
		String	userName = TestDataHandler.tc5859.getUsername();
		String	password = TestDataHandler.tc5859.getPassword();
		
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

		double previousTotalData = fido_wireless_dashboard_postpaid_page.getValueTotalData();
		double previousRemainingData = fido_wireless_dashboard_postpaid_page.getValueRemainingData();
		fido_wireless_dashboard_postpaid_page.clkAddDataButton();
		reporter.softAssert(fido_add_data_page.verifyOverlayAddOnDisplayed(),
							"add on overlay is displayed",
							"data add on overlay is not displayed");			
		reporter.reportLogWithScreenshot("Add monthly data add on overlay");
		fido_add_data_page.clkTheFirstDataPlanBtnOnAddDataOverlay();
		fido_add_data_page.clkContinueBtnOnAddDataOverlay();
		reporter.softAssert(fido_add_data_page.verifyConfirmPurchasingMsgDisplayed(),
							"Confirm purchasing on overlay is displayed",
							"Confirm purchasing on overlay is not displayed");	
		reporter.reportLogWithScreenshot("Confirm purchasing on add data overlay");
		fido_add_data_page.clkPurchaseBtnOnAddDataOverlay();
		double dataAdded = 0;
		if(fido_add_data_page.isLimitReachedMsgDisplayed()) {
			reporter.reportLogWithScreenshot("Add data limit reached.");
		}else {
			reporter.softAssert(fido_add_data_page.verifyAddDataSuccessMsgDisplayed(),
					"Add data success message is displayed",
					"Add data success message is not displayed");	
			dataAdded = fido_add_data_page.getValueAddedData();
			reporter.reportLogWithScreenshot("Add data success modal.");
		}
		fido_add_data_page.clkCloseBtnOnAddDataOverlay();
		//log out and login
		
		reporter.reportLogWithScreenshot("Navigate back to Demo Line account dashboard page.");
		fido_login_page.clkSignOut();
		reporter.reportLogWithScreenshot("Sign out done");
		fido_login_page.clkResignInAs();
		reporter.reportLogWithScreenshot("Click Re Sign In");
		fido_login_page.switchToSignInFrame();
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Verify login with new password.");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		//rechange to the original one
		if(fido_account_overview_page.verifySuccessfulLogin())
		{
			fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
			reporter.reportLogWithScreenshot("dashboard page loaded");
			reporter.reportLogWithScreenshot("Click on CTN badge");
			fido_account_overview_page.clkCtnBadge();
			reporter.reportLogWithScreenshot("dashboard page");		
			reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataReflectedAddedData(previousTotalData,dataAdded),
					"The data add-on reflected in total data.",
					"The data add-on didn't reflect in total data.");	
			reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyRemainingDataReflectedAddedData(previousRemainingData,dataAdded),
					"The data add-on reflected in total data.",
					"The data add-on didn't reflect in total data.");	
			
			fido_wireless_dashboard_postpaid_page.clkLinkViewDetailInUsage();
			//Manage data page
			reporter.softAssert(fido_data_management_page.verifyManageDataOverlayDisplayed(),
					"Manage data overlay is displayed",
					"Manage data overlay is not displayed");	
			reporter.softAssert(fido_data_management_page.verifyPlanDataInManageDataOverlayDisplayed(),
					"Plan data in Manage data overlay is displayed",
					"Plan data in Manage data overlay is not displayed");	
			reporter.reportLogWithScreenshot("Manage data overlay.");
			reporter.softAssert(fido_data_management_page.verifyAddedDataInManageDataOverlayDisplayed(),
					"Added data in Manage data overlay is displayed",
					"Added data in Manage data overlay is not displayed");	
			reporter.softAssert(fido_data_management_page.verifyTotalDataInManageDataOverlayDisplayed(),
					"Total data in Manage data overlay is displayed",
					"Total data in Manage data overlay is not displayed");	
			reporter.hardAssert(fido_data_management_page.verifyDataAccuracyManageDataOverlay("mdt"),
					"Accuracy of data in Manage data overlay is verified.",
					"Accuracy of data in Manage data overlay didn't verify successfully.");	
			double totalDataInManageDataPage = fido_data_management_page.getTotalDataInManageDataOverlay();
			fido_data_management_page.clkLinkBackOnManageDataOverlay();
			reporter.reportLogWithScreenshot("Navigate back to Demo Line account dashboard page.");
			double totalDataInUsageSection = fido_wireless_dashboard_postpaid_page.getValueTotalData();
			reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataAlignWithManageDataPage(totalDataInUsageSection, totalDataInManageDataPage),
					"Total data in usage section align with total data in Manage data page.",
					"Total data in usage section doesn't align with total data in Manage data page.");	
		}else
		{
			reporter.reportLogFail("Login failed, please investigate");
		}
		
		
		
	}
	
}
