package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * The test will verify demo-line wireless account add data flow and manage data page OTT, 
 * as well as verify the total data and data accuracy in manage data page. 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC61_ValidateAddDataFlowAHWithWPlanOTT extends BaseTestClass{
	
	
	 	
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

	
	@Test(groups = {"RegressionSS","DashboardSS"})
	public void verifyAddOTTDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		reporter.reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		fido_home_page.clkLogin();
	
		String	userName = TestDataHandler.tc61.getUsername();
		String	password = TestDataHandler.tc61.getPassword();
		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		reporter.reportLogWithScreenshot("dashboard page loaded");
		

//		double previousTotalData = fido_wireless_dashboard_postpaid_page.getValueTotalData();
//		double previousRemainingData = fido_wireless_dashboard_postpaid_page.getValueRemainingData();

		
		reporter.hardAssert(fido_data_management_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		int countOfExistSpeedPass = fido_data_management_page.getAllExistingAddOTTCount();
		fido_data_management_page.clkLinkBackOnManageDataOverlay();
		
		int countOfExistingAddOnsInMyPlan = fido_wireless_dashboard_postpaid_page.getAllExistingAddOns();
		
		
		fido_wireless_dashboard_postpaid_page.clkAddDataButton();
		//4. Complete Add OTT flow
		//4. Verify Only OTT options available (no MDT). OTT is added and reflected in total bucket,
		reporter.hardAssert(fido_add_data_page.verifyOverlayOTTDataAddOnDisplayed(),
							"Verify Only OTT options available (no MDT)",
							"It seems Only OTT options not available");			
		reporter.reportLogWithScreenshot("Add OTT data add on overlay");
				
		fido_add_data_page.clkTheFirstDataPlanBtnOnAddDataOverlay();
		fido_add_data_page.clkContinueBtnOnAddDataOverlay();
		reporter.hardAssert(fido_add_data_page.verifyConfirmPurchasingMsgDisplayed(),
							"Confirm purchasing on overlay is displayed",
							"Confirm purchasing on overlay is not displayed");	
		reporter.reportLogWithScreenshot("Confirm purchasing on add data overlay");
		fido_add_data_page.clkPurchaseBtnOnAddDataOverlay();
		double dataAdded = 0;
		String strValueAdded = null;
		if(fido_add_data_page.isLimitReachedMsgDisplayed()) {
			reporter.reportLogWithScreenshot("Add data limit reached.");
		}else {
			reporter.hardAssert(fido_add_data_page.verifyAddDataSuccessMsgDisplayed(),
					"Add data success message is displayed",
					"Add data success message is not displayed");	
			strValueAdded = fido_add_data_page.getAddedValueWithGBOrMB();
			dataAdded = fido_add_data_page.getValueAddedData();
			reporter.reportLogWithScreenshot("Add data success modal.");
		}
		fido_add_data_page.clkCloseBtnOnAddDataOverlay();
			
			
		fido_wireless_dashboard_postpaid_page.clkLinkViewDetailInUsage();
		//Manage data page		
		//5. Click on View details in usage dashboard plan section and manage data page
		//5. Added Data section lists all add-ons separately and there is NO Cancel link next to OTT"
		reporter.hardAssert(fido_data_management_page.verifyManageDataOverlayDisplayed(),
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
		reporter.hardAssert(fido_data_management_page.verifyDataAccuracyManageDataOverlay("ott"),
				"Accuracy of data in Manage data overlay is verified.",
				"Accuracy of data in Manage data overlay didn't verify successfully.");		
		
		reporter.softAssert((fido_data_management_page.verifyAddedDataInDataDetails(1, countOfExistSpeedPass)
				&& fido_data_management_page.verifyNoCancelLinkDisplayedForAddedData()),
				"Added Data section lists all add-ons separately and there is NO Cancel link next to OTT",
				"It seems AddedAdded Data section doesnt lists all add-ons separately or there is Cancel link next to OTT");
		
		fido_data_management_page.clkLinkBackOnManageDataOverlay();
		reporter.reportLogWithScreenshot("Back on dashboard");
		if (!fido_wireless_dashboard_postpaid_page.verifyAddedDataInMyPlan(1, countOfExistingAddOnsInMyPlan)) {
			fido_login_page.clkSignOut();
			reporter.reportLogWithScreenshot("Sign Out");
			reporter.reportLogWithScreenshot("Checking if easy login is displayed");
			if(fido_home_page.isEasyloginDisplayed())
			{
			 fido_home_page.clkEasylogin();
			 reporter.reportLogWithScreenshot("Easy login clicked");
			}
			reporter.reportLogWithScreenshot("Click on resign in");
			fido_login_page.clkResignInAs();
			reporter.reportLogWithScreenshot("Re Sign In");		
			fido_login_page.switchToSignInFrame();
			fido_home_page.clkNotUser();
			fido_login_page.setUsernameInFrameAfterReSignIn(userName);
			fido_login_page.setPasswordInFrame(password);

			fido_login_page.clkLoginInFrame();
			fido_login_page.switchOutOfSignInFrame();
			//rechange to the original one
			if(fido_account_overview_page.verifySuccessfulLogin())
			{
				reporter.reportLogWithScreenshot("Click on CTN badge");
				fido_account_overview_page.clkCtnBadge();
				reporter.reportLogWithScreenshot("dashboard page");			
			}
		}

		fido_wireless_dashboard_postpaid_page.scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("My Plan Details");
		//All the added OTT are reflected in total bucket,plan section and manage data page
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyAddedDataInMyPlan(1, countOfExistingAddOnsInMyPlan)
				,"My plans displayes the addons correctly","My Plan doesnt displays add ons correctly");
	
		if(strValueAdded.toLowerCase().contains("mo")||strValueAdded.toLowerCase().contains("mb"))
		{			
			dataAdded = (dataAdded/1000);
		}
		/*
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataReflectedAddedData(previousTotalData,dataAdded),
								"The data add-on reflected in total data.",
								"The data add-on didn't reflect in total data.");	
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyRemainingDataReflectedAddedData(previousRemainingData,dataAdded),
								"The data add-on reflected in total data.",
								"The data add-on didn't reflect in total data.");
		*/					
	}
	
}
