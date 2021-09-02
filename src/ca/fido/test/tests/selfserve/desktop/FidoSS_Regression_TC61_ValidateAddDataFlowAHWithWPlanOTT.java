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
import java.util.HashMap;

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

	
	@Test(groups = {"RegressionSS","DashboardSS","AddDataSpeedPass"})
	public void verifyAddOTTDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		//getFidohomepage().clkLogin();
	
		String	userName = TestDataHandler.tc61.getUsername();
		String	password = TestDataHandler.tc61.getPassword();
		HashMap<String, String> speedPassPrice = new HashMap<String, String>();
		speedPassPrice.put("1", "15.00");
		speedPassPrice.put("3", "40.00");
		//getFidologinpage().switchToSignInFrame();
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
		String strCTN = TestDataHandler.tc61.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		getReporter().reportLogWithScreenshot("dashboard page loaded");
		

//		double previousTotalData = getFidowirelessdashboardpostpaidpage().getValueTotalData();
//		double previousRemainingData = getFidowirelessdashboardpostpaidpage().getValueRemainingData();

		
		getReporter().hardAssert(getFidodatamanagementpage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		int countOfExistSpeedPass = getFidodatamanagementpage().getAllExistingAddOTTCount();
		getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
		
		int countOfExistingAddOnsInMyPlan = getFidowirelessdashboardpostpaidpage().getAllExistingAddOns();
		
		
		getFidowirelessdashboardpostpaidpage().clkAddDataButton();
		//4. Complete Add OTT flow
		//4. Verify Only OTT options available (no MDT). OTT is added and reflected in total bucket,
		getReporter().hardAssert(getFidoadddatapage().verifyOverlayOTTDataAddOnDisplayed(),
							"Verify Only OTT options available (no MDT)",
							"It seems Only OTT options not available");			
		getReporter().reportLogWithScreenshot("Add OTT data add on overlay");
		getReporter().hardAssert(getFidoadddatapage().verifyIfTopUpPriceIsCorrect(speedPassPrice),
				"Top ups price verified successfully",
				"Top ups price NOT verified successfully");

		getFidoadddatapage().clkTheFirstDataPlanBtnOnAddDataOverlay();
		getFidoadddatapage().clkContinueBtnOnAddDataOverlay();


		getReporter().hardAssert(getFidoadddatapage().verifyConfirmPurchasingMsgDisplayed(System.getProperty("Language"),
				speedPassPrice),
							"Confirm purchasing on overlay is displayed",
							"Confirm purchasing on overlay is not displayed");	
		getReporter().reportLogWithScreenshot("Confirm purchasing on add data overlay");
		getFidoadddatapage().clkPurchaseBtnOnAddDataOverlay();
		double dataAdded = 0;
		String strValueAdded = null;
		if(getFidoadddatapage().isLimitReachedMsgDisplayed()) {
			getReporter().reportLogWithScreenshot("Add data limit reached for this account");
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
		}else
		 {
			getReporter().hardAssert(getFidoadddatapage().verifyAddDataSuccessMsgDisplayed(),
					"Add data success message is displayed",
					"Add data success message is not displayed");	
			strValueAdded = getFidoadddatapage().getAddedValueWithGBOrMB();
			dataAdded = getFidoadddatapage().getValueAddedData();
			getReporter().reportLogWithScreenshot("Add data success modal.");
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
			
			
			getFidowirelessdashboardpostpaidpage().clkLinkViewDetailInUsage();
			//Manage data page		
			//5. Click on View details in usage dashboard plan section and manage data page
			//5. Added Data section lists all add-ons separately and there is NO Cancel link next to OTT"
			getReporter().hardAssert(getFidodatamanagementpage().verifyManageDataOverlayDisplayed(),
					"Manage data overlay is displayed",
					"Manage data overlay is not displayed");	
			getReporter().softAssert(getFidodatamanagementpage().verifyPlanDataInManageDataOverlayDisplayed(),
					"Plan data in Manage data overlay is displayed",
					"Plan data in Manage data overlay is not displayed");	
			getReporter().reportLogWithScreenshot("Manage data overlay.");
			getReporter().softAssert(getFidodatamanagementpage().verifyAddedDataInManageDataOverlayDisplayed(),
					"Added data in Manage data overlay is displayed",
					"Added data in Manage data overlay is not displayed");	
			getReporter().softAssert(getFidodatamanagementpage().verifyTotalDataInManageDataOverlayDisplayed(),
					"Total data in Manage data overlay is displayed",
					"Total data in Manage data overlay is not displayed");	
			getReporter().hardAssert(getFidodatamanagementpage().verifyDataAccuracyManageDataOverlay("ott"),
					"Accuracy of data in Manage data overlay is verified.",
					"Accuracy of data in Manage data overlay didn't verify successfully.");		
			
			getReporter().softAssert((getFidodatamanagementpage().verifyAddedDataInDataDetails(1, countOfExistSpeedPass)
					&& getFidodatamanagementpage().verifyNoCancelLinkDisplayedForAddedData()),
					"Added Data section lists all add-ons separately and there is NO Cancel link next to OTT",
					"It seems AddedAdded Data section doesnt lists all add-ons separately or there is Cancel link next to OTT");
			
			getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
			getReporter().reportLogWithScreenshot("Back on dashboard");
			if (!getFidowirelessdashboardpostpaidpage().verifyAddedDataInMyPlan(1, countOfExistingAddOnsInMyPlan)) {
				getCommonbusinessflows().logOutAndResignIn(userName, password);
				//rechange to the original one
				if(getFidoaccountoverviewpage().verifySuccessfulLogin())
				{
					getReporter().reportLogWithScreenshot("Click on CTN badge");
					getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
					getReporter().reportLogWithScreenshot("dashboard page");			
				}
			}

			getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();
			getReporter().reportLogWithScreenshot("My Plan Details");
			//All the added OTT are reflected in total bucket,plan section and manage data page
			getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyAddedDataInMyPlan(1, countOfExistingAddOnsInMyPlan)
					,"My plans displayes the addons correctly","My Plan doesnt displays add ons correctly");
		
			if(strValueAdded.toLowerCase().contains("mo")||strValueAdded.toLowerCase().contains("mb"))
			{			
				dataAdded = (dataAdded/1000);
			}
			
		}
		
		/*
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataReflectedAddedData(previousTotalData,dataAdded),
								"The data add-on reflected in total data.",
								"The data add-on didn't reflect in total data.");	
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyRemainingDataReflectedAddedData(previousRemainingData,dataAdded),
								"The data add-on reflected in total data.",
								"The data add-on didn't reflect in total data.");
		*/					
	}
	
}
