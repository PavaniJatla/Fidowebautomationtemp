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
		getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		getFidohomepage().clkLogin();
	
		String	userName = TestDataHandler.tc6062.getUsername();
		String	password = TestDataHandler.tc6062.getPassword();
		String ctn = TestDataHandler.tc6062.getaccountDetails().getCtn();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(userName);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();		
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(ctn);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		getReporter().reportLogWithScreenshot("dashboard page loaded");

		//double previousTotalData = getFidowirelessdashboardpostpaidpage().getValueTotalData();
		//double previousRemainingData = getFidowirelessdashboardpostpaidpage().getValueRemainingData();
		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		getReporter().hardAssert(getFidodatamanagementpage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		getReporter().reportLogWithScreenshot("View details page opened");
		getCommonbusinessflows().scrollToMiddleOfWebPage();
		getReporter().reportLogWithScreenshot("Manage data page middle view");
		int countOfExistSpeedPass = getFidodatamanagementpage().getAllExistingAddDataCount();
		getCommonbusinessflows().scrollToTopOfWebPage();
		Map<String, Integer> countOfActiveAndCancelledAddData = getFidodatamanagementpage().getAllExistingAddDataCountCancelledAndActive();
		Map<String, Integer> countOfAlreadyAddedData = getFidodatamanagementpage().getCountOfAllExistingAddedDataValues();
		getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
		
		int countOfExistingAddOnsInMyPlan = getFidowirelessdashboardpostpaidpage().getAllExistingAddOns();				

		getReporter().hardAssert(this.addData(countOfAlreadyAddedData),
	                         "Add on selected",
	                         "Seems no add on found having existing value less than 3 please investigate");
		
		if(getFidoadddatapage().isLimitReachedMsgDisplayed()) {
			getReporter().reportLogWithScreenshot("Add data limit reached for this account");
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
		}else
		{
		/*
		 * 4. Verify Only MDT options available (no OTT). 
		 * MDT is added and reflected in total bucket,plan section and manage data page
		  
		   6. Added Data section lists all add-ons separately and only Monthly Add ons have Cancel link
		 */
		
		
		
		// 5.All the added MDTs are reflected in total bucket,plan section and manage data page
	
		/*	getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataReflectedAddedData(previousTotalData,dataAdded),
				"The data add-on reflected in total data.",
				"The data add-on didn't reflect in total data.");	
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyRemainingDataReflectedAddedData(previousRemainingData,dataAdded),
				"The data add-on reflected in total data.",
				"The data add-on didn't reflect in total data.");	
		*/
	
		
		getFidowirelessdashboardpostpaidpage().clkLinkViewDetailInUsage();
		//Manage data page
		getReporter().hardAssert(getFidodatamanagementpage().verifyManageDataOverlayDisplayed(),
				"Manage data overlay is displayed",
				"Manage data overlay is not displayed");	
		getReporter().softAssert(getFidodatamanagementpage().verifyPlanDataInManageDataOverlayDisplayed(),
				"Plan data in Manage data overlay is displayed",
				"Plan data in Manage data overlay is not displayed");	
		getFidodatamanagementpage().scrollToMiddle();
		getReporter().reportLogWithScreenshot("Manage data overlay.");
		getReporter().softAssert(getFidodatamanagementpage().verifyAddedDataInManageDataOverlayDisplayed(),
				"Added data in Manage data overlay is displayed",
				"Added data in Manage data overlay is not displayed");	
		getReporter().softAssert(getFidodatamanagementpage().verifyTotalDataInManageDataOverlayDisplayed(),
				"Total data in Manage data overlay is displayed",
				"Total data in Manage data overlay is not displayed");			
		getFidodatamanagementpage().scrollToTop();
		countAddData = 1;// after one successful completion
		
		//add one more
		
		countOfAlreadyAddedData = getFidodatamanagementpage().getCountOfAllExistingAddedDataValues(); //update the count before one more addition
		getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
		getReporter().reportLogWithScreenshot("Adding one more add data");					
		
		if(this.addData(countOfAlreadyAddedData))
		{
			if(getFidoadddatapage().isLimitReachedMsgDisplayed()) {
				getReporter().reportLogWithScreenshot("Add data limit reached.");
				getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
			}else {
			countAddData++;
			}
		}
		
		
		getReporter().hardAssert(getFidodatamanagementpage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		getReporter().softAssert(getFidodatamanagementpage().verifyMDTAddedDataInDataDetails(countAddData, countOfExistSpeedPass),
				"MTT data is added correctly in data details","MTT data is NOT added correctly it seems in data details");
		getReporter().softAssert( getFidodatamanagementpage().verifyCancelIsDisplayedForAllActiveAndNewlyAddMDTData(countOfActiveAndCancelledAddData.get("active").intValue(),countAddData),
				"ALL the newly added MTT have the cancel link",
				"It seems AddedAdded Data section doesnt lists all add-ons separately or there is NO Cancel link next to MTT");
		
				
		//double totalDataInManageDataPage = getFidodatamanagementpage().getTotalDataInManageDataOverlay();
		getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();		
		getCommonbusinessflows().logOutAndResignIn(userName, password);
		//rechange to the original one
		if(getFidoaccountoverviewpage().verifySuccessfulLogin())
		{
			getReporter().reportLogWithScreenshot("Click on CTN badge");
			getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(ctn);
			getReporter().reportLogWithScreenshot("dashboard page");			
			//double totalDataInUsageSection = getFidowirelessdashboardpostpaidpage().getValueTotalData();
		/*	getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataAlignWithManageDataPage(totalDataInUsageSection, totalDataInManageDataPage),
					"Total data in usage section align with total data in Manage data page and displayed seperately",
					"Total data in usage section doesn't align with total data in Manage data page.");
			*/	
			getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();
			getReporter().reportLogWithScreenshot("My Plan Details");
			//All the added OTT are reflected in total bucket,plan section and manage data page
			getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyAddedDataInMyPlan(countAddData, countOfExistingAddOnsInMyPlan)
					,"My plans displayes the addons correctly","My Plan doesnt displays add ons correctly");
			
		}
		
		} //add data limit else bloc ends
			
	}
	
	public boolean addData(Map<String, Integer> countOfAlreadyAddedData)
	{
		boolean dataAdded = false;
		getFidowirelessdashboardpostpaidpage().clkAddDataButton();						
		getReporter().hardAssert(getFidoadddatapage().verifyOverlayMonthlyDataAddOnDisplayed(),
							"Monthly data add on overlay is displayed",
							"Monthly data add on overlay is not displayed");			
		getReporter().reportLogWithScreenshot("Add monthly data add on overlay");
		if(getFidoadddatapage().clkTheDataAddOnWhichAreNotAddedMoreThanThreeTime(countOfAlreadyAddedData))
		{							
			getFidoadddatapage().clkContinueBtnOnAddDataOverlay();
			getReporter().reportLogWithScreenshot("Add monthly data selected");
			getReporter().hardAssert(getFidoadddatapage().verifyConfirmPurchasingMsgDisplayed(),
								"Confirm purchasing on overlay is displayed",
								"Confirm purchasing on overlay is not displayed");	
			getReporter().reportLogWithScreenshot("Confirm purchasing on add data overlay");
			getFidoadddatapage().clkPurchaseBtnOnAddDataOverlay();
			if(getFidoadddatapage().isLimitReachedMsgDisplayed()) {
				getReporter().reportLogWithScreenshot("Add data limit reached.");
				return true;
			}else {
				getReporter().hardAssert(getFidoadddatapage().verifyAddDataSuccessMsgDisplayed(),
						"Add data success message is displayed",
						"Add data success message is not displayed");	
				dataAddedValue = getFidoadddatapage().getValueAddedData();
				getReporter().reportLogWithScreenshot("Add data success modal.");
			}			
			getReporter().reportLogWithScreenshot("Click close");
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
			getReporter().reportLogWithScreenshot("Verify added data");
			dataAdded= true;			
		}else
			
		{   
					
			getFidoadddatapage().clkTheFirstDataPlanBtnOnAddDataOverlay();
			getFidoadddatapage().clkContinueBtnOnAddDataOverlay();
			getReporter().reportLogWithScreenshot("Add monthly data selected");
			getReporter().hardAssert(getFidoadddatapage().verifyConfirmPurchasingMsgDisplayed(),
								"Confirm purchasing on overlay is displayed",
								"Confirm purchasing on overlay is not displayed");	
			getReporter().reportLogWithScreenshot("Confirm purchasing on add data overlay");
			getFidoadddatapage().clkPurchaseBtnOnAddDataOverlay();
			if(getFidoadddatapage().isLimitReachedMsgDisplayed()) {
				getReporter().reportLogWithScreenshot("Add data limit reached.");
				return true;
			}else
			{
				getReporter().hardAssert(false, "Seems the limit reach message didnt displaye",
						"The limit reached message is displayed");				
			}
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
		}
		return dataAdded;
	}
}
