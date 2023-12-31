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
 * The test will verify demo-line account add data flow and manage data page, 
 * as well as verify the total data and data accuracy in manage data page. 
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC059_PostPaidDashBoardAddData_DemoLine extends BaseTestClass{
	
	
	 	
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
	public void verifyAddDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		//getFidohomepage().clkLogin();
		HashMap<String, String> speedPassPrice = new HashMap<String, String>();
		speedPassPrice.put("500", "10.00");
		speedPassPrice.put("2.5", "25.00");
		speedPassPrice.put("5", "40.00");
		String	userName = TestDataHandler.tc5859.getUsername();
		String	password = TestDataHandler.tc5859.getPassword();
		String strCTN = TestDataHandler.tc5859.getaccountDetails().getCtn();
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
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
//		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		getReporter().reportLogWithScreenshot("dashboard page loaded");
		getFidoaccountoverviewpage().scrollToTopOfPage();
		double previousTotalData = getFidowirelessdashboardpostpaidpage().getValueTotalData();		
		double previousRemainingData = getFidowirelessdashboardpostpaidpage().getValueRemainingData();

		getFidowirelessdashboardpostpaidpage().clkAddDataButton();
		getReporter().hardAssert(getFidoadddatapage().verifyOverlayAddOnDisplayed(),
							"add on overlay is displayed",
							"data add on overlay is not displayed");
		getReporter().reportLogWithScreenshot("Add monthly data add on overlay");
		//For more than 3 data top-up options, it will show as drop down
		getFidoadddatapage().clkTheFirstDataPlanBtnOnAddDataOverlay();
//		getFidoadddatapage().clkSelectAmountDropDown();
//		getFidoadddatapage().clkTheFirstDataPlanOptionFromDropDown();
		getFidoadddatapage().clkContinueBtnOnAddDataOverlay();
		getReporter().hardAssert(getFidoadddatapage().verifyConfirmPurchasingMsgDisplayed(System.getProperty("Language"),
				speedPassPrice),
							"Confirm purchasing on overlay is displayed",
							"Confirm purchasing on overlay is not displayed");
		getReporter().reportLogWithScreenshot("Confirm purchasing on add data overlay");
		getFidoadddatapage().clkPurchaseBtnOnAddDataOverlay();
		double dataAdded = 0;
		if(getFidoadddatapage().isLimitReachedMsgDisplayed()) {
			getReporter().reportLogWithScreenshot("Add data limit reached.");
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
			getReporter().reportLogWithScreenshot("Navigate back to Demo Line account dashboard page.");
			
		}else {
			getReporter().hardAssert(getFidoadddatapage().verifyAddDataSuccessMsgDisplayed(),
					"Add data success message is displayed",
					"Add data success message is not displayed");	
			dataAdded = getFidoadddatapage().getValueAddedData();
			getReporter().reportLogWithScreenshot("Add data success modal.");
			getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
			getReporter().reportLogWithScreenshot("Navigate back to Demo Line account dashboard page.");
			//log out and login
			getCommonbusinessflows().logOutAndResignIn(userName, password);
			
			//check added data reflecting
			getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
					"Login succeed.", 
					"Login failed, please investigate");

			getReporter().reportLogWithScreenshot("Click on CTN badge");
			getFidoaccountoverviewpage().scrollToTopOfPage();
			getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getReporter().reportLogWithScreenshot("dashboard page");
			/*getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().verifyTotalDataReflectedAddedData(previousTotalData,dataAdded),
					"The data add-on reflected in total data.",
					"The data add-on didn't reflect in total data.");
			getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().verifyRemainingDataReflectedAddedData(previousRemainingData,dataAdded),
					"The data add-on reflected in total data.",
					"The data add-on didn't reflect in total data.");	*/

		}
		
		getFidowirelessdashboardpostpaidpage().clkLinkViewDetailInUsage();
		//Manage data page
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
		getReporter().hardAssert(getFidodatamanagementpage().verifyDataAccuracyManageDataOverlay("mdt"),
				"Accuracy of data in Manage data overlay is verified.",
				"Accuracy of data in Manage data overlay didn't verify successfully.");
		double totalDataInManageDataPage = getFidodatamanagementpage().getTotalDataInManageDataOverlay("mdt");
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
		getReporter().reportLogWithScreenshot("Navigate back to Demo Line account dashboard page.");
		double totalDataInUsageSection = getFidowirelessdashboardpostpaidpage().getValueTotalData();
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataAlignWithManageDataPage(totalDataInUsageSection, totalDataInManageDataPage),
				"Total data in usage section align with total data in Manage data page.",
				"Total data in usage section doesn't align with total data in Manage data page.");	
	}
	
}
