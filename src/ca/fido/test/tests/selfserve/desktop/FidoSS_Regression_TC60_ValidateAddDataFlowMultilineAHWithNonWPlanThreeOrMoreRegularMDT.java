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
import java.util.Map;

/**
 * The test will verify demo-line account add data flow and manage data page, 
 * as well as verify the total data and data accuracy in manage data page. 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC60_ValidateAddDataFlowMultilineAHWithNonWPlanThreeOrMoreRegularMDT extends BaseTestClass{
	
	
	 	
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
	
	int countAddData = 0;
	double dataAddedValue = 0;
	
	@Test(groups = {"RegressionSS","DashboardSS"})
	public void verifyAddMDTDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		reporter.reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		fido_home_page.clkLogin();
	
		String	userName = TestDataHandler.tc6062.getUsername();
		String	password = TestDataHandler.tc6062.getPassword();
		
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

		//double previousTotalData = fido_wireless_dashboard_postpaid_page.getValueTotalData();
		//double previousRemainingData = fido_wireless_dashboard_postpaid_page.getValueRemainingData();
		fido_wireless_dashboard_postpaid_page.closeOverlayPopup();
		reporter.hardAssert(fido_data_management_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		reporter.reportLogWithScreenshot("View details page opened");
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Manage data page middle view");
		int countOfExistSpeedPass = fido_data_management_page.getAllExistingAddDataCount();
		common_business_flows.scrollToTopOfWebPage();
		Map<String, Integer> countOfActiveAndCancelledAddData = fido_data_management_page.getAllExistingAddDataCountCancelledAndActive();
		Map<String, Integer> countOfAlreadyAddedData = fido_data_management_page.getCountOfAllExistingAddedDataValues();
		fido_data_management_page.clkLinkBackOnManageDataOverlay();
		
		int countOfExistingAddOnsInMyPlan = fido_wireless_dashboard_postpaid_page.getAllExistingAddOns();				

		reporter.hardAssert(this.addData(countOfAlreadyAddedData),
	                         "Add on selected",
	                         "Seems no add on found having existing value less than 3 please investigate");
		
		if(fido_add_data_page.isLimitReachedMsgDisplayed()) {
			reporter.reportLogWithScreenshot("Add data limit reached for this account");
			fido_add_data_page.clkCloseBtnOnAddDataOverlay();
		}else
		{
		/*
		 * 4. Verify Only MDT options available (no OTT). 
		 * MDT is added and reflected in total bucket,plan section and manage data page
		  
		   6. Added Data section lists all add-ons separately and only Monthly Add ons have Cancel link
		 */
		
		
		
		// 5.All the added MDTs are reflected in total bucket,plan section and manage data page
	
		/*	reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataReflectedAddedData(previousTotalData,dataAdded),
				"The data add-on reflected in total data.",
				"The data add-on didn't reflect in total data.");	
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyRemainingDataReflectedAddedData(previousRemainingData,dataAdded),
				"The data add-on reflected in total data.",
				"The data add-on didn't reflect in total data.");	
		*/
	
		
		fido_wireless_dashboard_postpaid_page.clkLinkViewDetailInUsage();
		//Manage data page
		reporter.hardAssert(fido_data_management_page.verifyManageDataOverlayDisplayed(),
				"Manage data overlay is displayed",
				"Manage data overlay is not displayed");	
		reporter.softAssert(fido_data_management_page.verifyPlanDataInManageDataOverlayDisplayed(),
				"Plan data in Manage data overlay is displayed",
				"Plan data in Manage data overlay is not displayed");	
		fido_data_management_page.scrollToMiddle();
		reporter.reportLogWithScreenshot("Manage data overlay.");
		reporter.softAssert(fido_data_management_page.verifyAddedDataInManageDataOverlayDisplayed(),
				"Added data in Manage data overlay is displayed",
				"Added data in Manage data overlay is not displayed");	
		reporter.softAssert(fido_data_management_page.verifyTotalDataInManageDataOverlayDisplayed(),
				"Total data in Manage data overlay is displayed",
				"Total data in Manage data overlay is not displayed");			
		fido_data_management_page.scrollToTop();
		countAddData = 1;// after one successful completion
		
		//add one more
		
		countOfAlreadyAddedData = fido_data_management_page.getCountOfAllExistingAddedDataValues(); //update the count before one more addition
		fido_data_management_page.clkLinkBackOnManageDataOverlay();
		reporter.reportLogWithScreenshot("Adding one more add data");					
		
		if(this.addData(countOfAlreadyAddedData))
		{
			if(fido_add_data_page.isLimitReachedMsgDisplayed()) {
				reporter.reportLogWithScreenshot("Add data limit reached.");
				fido_add_data_page.clkCloseBtnOnAddDataOverlay();
			}else {
			countAddData++;
			}
		}
		
		
		reporter.hardAssert(fido_data_management_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		reporter.softAssert(fido_data_management_page.verifyMDTAddedDataInDataDetails(countAddData, countOfExistSpeedPass),
				"MTT data is added correctly in data details","MTT data is NOT added correctly it seems in data details");
		reporter.softAssert( fido_data_management_page.verifyCancelIsDisplayedForAllActiveAndNewlyAddMDTData(countOfActiveAndCancelledAddData.get("active").intValue(),countAddData),
				"ALL the newly added MTT have the cancel link",
				"It seems AddedAdded Data section doesnt lists all add-ons separately or there is NO Cancel link next to MTT");
		
				
		//double totalDataInManageDataPage = fido_data_management_page.getTotalDataInManageDataOverlay();
		fido_data_management_page.clkLinkBackOnManageDataOverlay();		
		common_business_flows.logOutAndResignIn(userName, password);
		//rechange to the original one
		if(fido_account_overview_page.verifySuccessfulLogin())
		{
			reporter.reportLogWithScreenshot("Click on CTN badge");
			fido_account_overview_page.clkCtnBadge();
			reporter.reportLogWithScreenshot("dashboard page");			
			//double totalDataInUsageSection = fido_wireless_dashboard_postpaid_page.getValueTotalData();
		/*	reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyTotalDataAlignWithManageDataPage(totalDataInUsageSection, totalDataInManageDataPage),
					"Total data in usage section align with total data in Manage data page and displayed seperately",
					"Total data in usage section doesn't align with total data in Manage data page.");
			*/	
			fido_wireless_dashboard_postpaid_page.scrollToMidOfDasboardPage();
			reporter.reportLogWithScreenshot("My Plan Details");
			//All the added OTT are reflected in total bucket,plan section and manage data page
			reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyAddedDataInMyPlan(countAddData, countOfExistingAddOnsInMyPlan)
					,"My plans displayes the addons correctly","My Plan doesnt displays add ons correctly");
			
		}
		
		} //add data limit else bloc ends
			
	}
	
	public boolean addData(Map<String, Integer> countOfAlreadyAddedData)
	{
		boolean dataAdded = false;
		fido_wireless_dashboard_postpaid_page.clkAddDataButton();						
		reporter.hardAssert(fido_add_data_page.verifyOverlayMonthlyDataAddOnDisplayed(),
							"Monthly data add on overlay is displayed",
							"Monthly data add on overlay is not displayed");			
		reporter.reportLogWithScreenshot("Add monthly data add on overlay");
		if(fido_add_data_page.clkTheDataAddOnWhichAreNotAddedMoreThanThreeTime(countOfAlreadyAddedData))
		{							
			fido_add_data_page.clkContinueBtnOnAddDataOverlay();
			reporter.reportLogWithScreenshot("Add monthly data selected");
			reporter.hardAssert(fido_add_data_page.verifyConfirmPurchasingMsgDisplayed(),
								"Confirm purchasing on overlay is displayed",
								"Confirm purchasing on overlay is not displayed");	
			reporter.reportLogWithScreenshot("Confirm purchasing on add data overlay");
			fido_add_data_page.clkPurchaseBtnOnAddDataOverlay();
			if(fido_add_data_page.isLimitReachedMsgDisplayed()) {
				reporter.reportLogWithScreenshot("Add data limit reached.");
				return true;
			}else {
				reporter.hardAssert(fido_add_data_page.verifyAddDataSuccessMsgDisplayed(),
						"Add data success message is displayed",
						"Add data success message is not displayed");	
				dataAddedValue = fido_add_data_page.getValueAddedData();
				reporter.reportLogWithScreenshot("Add data success modal.");
			}			
			reporter.reportLogWithScreenshot("Click close");
			fido_add_data_page.clkCloseBtnOnAddDataOverlay();
			reporter.reportLogWithScreenshot("Verify added data");
			dataAdded= true;			
		}else
			
		{   
					
			fido_add_data_page.clkTheFirstDataPlanBtnOnAddDataOverlay();
			fido_add_data_page.clkContinueBtnOnAddDataOverlay();
			reporter.reportLogWithScreenshot("Add monthly data selected");
			reporter.hardAssert(fido_add_data_page.verifyConfirmPurchasingMsgDisplayed(),
								"Confirm purchasing on overlay is displayed",
								"Confirm purchasing on overlay is not displayed");	
			reporter.reportLogWithScreenshot("Confirm purchasing on add data overlay");
			fido_add_data_page.clkPurchaseBtnOnAddDataOverlay();
			if(fido_add_data_page.isLimitReachedMsgDisplayed()) {
				reporter.reportLogWithScreenshot("Add data limit reached.");
				return true;
			}else
			{
				reporter.hardAssert(false, "Seems the limit reach message didnt displaye",
						"The limit reached message is displayed");				
			}
			fido_add_data_page.clkCloseBtnOnAddDataOverlay();
		}
		return dataAdded;
	}
}
