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
 * The test will verify post paid account dashboard,the test will run for test demo-line account
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC058_PostPaidDashBoardUsage_DemoLine extends BaseTestClass{
	
	
	 	
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
	
	@Test(groups = {"SanitySS","DashboardSS"})
	public void verifyDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		//getFidohomepage().clkLogin();
		String userName = "";
		String password = "";
	
			userName = TestDataHandler.tc5859.getUsername();
			password = TestDataHandler.tc5859.getPassword();
		
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(userName);
		getFidologinpage().setPasswordInFrame(password);
		String strCTN = TestDataHandler.tc5859.getaccountDetails().getCtn();
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);

		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);

		getReporter().reportLogWithScreenshot("dashboard page loaded");
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyDataDashBoardSectionDataBalanceRemainingIsDisplayed(),
				"Dashboard Section Data Balance Is Displayed",
				"Dashboard section data balance not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDataDashBoardUsageBarIsDisplayed(),
				"usage bar is displayed",
				"usage bar is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataInUsageSectionIsDisplayed(),
				"Data Section is displayed",
				"Data section is not displayed");
		getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().verifyLabelDataDelayedIsDisplayed(),
				"Data delay message didn't display.",
				"Data delay message displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDaysRemainingInBillCycleIsDisplayed(),
				"Label N days reming for Bill cycle is displayed",
				"Label N days remaining for Bill cycle is not displayed");

		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getReporter().reportLogWithScreenshot("Manage Data page loaded");

		//getReporter().reportLogWithScreenshot("Demo Line account dashboard page is displayed");
		//getFidowirelessdashboardpostpaidpage().clkLinkViewDetailInUsage();
		//getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getFidowirelessdashboardpostpaidpage().clkLinkViewDetailInUsage();
		getReporter().hardAssert(getFidodatamanagementpage().verifyManageDataOverlayDisplayed(),
				"Manage data overlay is displayed",
				"Manage data overlay is not displayed");
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
		//getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTalkPlanDetailsSectionIsDisplayed(),
				"Talk plan details section is displayed",
				"Talk plan details section is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTextPlanDetailsSectionIsDisplayed(),
						"Text plan details section is displayed",
						"Text plan details section is not displayed");
	/*
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyViewDetailsIsDisplayedBelowTalkAndTextUnlimited(),
				"View details displayed below talk and text unlimited", 
				"View details is NOT displayed below talk and text unlimited");
		*/
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMyMobilePlanDashBoardSectionIsDisplayed(),
						"My Mobile plan dashboard section is displayed",
						"My mobile plan details section is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLinkViewFullPlanDetailsOnMyMobilePlanDashBoardSectionIsDisplayed(),
						"Link View Flull plan details is displayed on My mobile plan section",
						"Link View Flull plan details is NOT displayed on My mobile plan section");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyButtonChangePlanMyMobilePlanDashBoardSectionIsDisplayed(),
						"Button Change Plan MyMobilePlan DashBoard Section IsDisplayed",
						"Button Change Plan MyMobilePlan DashBoard Section Is NOT Displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyPlanBenefitsInMyMobilePlanDashBoardSectionIsDisplayed(),
						"PlanBenefits In My MobilePlan DashBoard Section Is Displayed",
						"PlanBenefits In MyMobilePlan DashBoard Section Is NOT Displayed");
			
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMyDeviceDetails(),
						"My device details is displayed",
						"My device details is not displayed");				
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyViewFullPlanDetails(),
						"Full Plan details is displayed",
						"Full plan details is not displayed");		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLinkChangeCalldisplayNameIsDisplayed(),
						"Link change display name is displayed",
						"Link change displaye name is not displayed");		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLinkChangeMyNumberIsDisplayed(),
						"Link change my number is displayed",
						"Link change my numebr is not displayed");	
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLinkReportLostOrStolenIsDisplayed(),
						"Link report lost or stolen is displayed",
						"Link report lost or stolen is not displayed");		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLinkRetrievePUKCodeIsDisplayed(),
						"Link Retrevive PUK code is dsiplayed",
						"Link Retreive PUK code is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLinkUpdateSIMCardIsDisplayed(),
						"Link Update SIM card is displayed",
						"Link update SIM card is not displayed");
		getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();
		getReporter().reportLogWithScreenshot("Dashboad mid veiw");
		getFidowirelessdashboardpostpaidpage().scrollToBottomOfPage();
		getReporter().reportLogWithScreenshot("Dashboad bottom veiw");
	}
	
}
