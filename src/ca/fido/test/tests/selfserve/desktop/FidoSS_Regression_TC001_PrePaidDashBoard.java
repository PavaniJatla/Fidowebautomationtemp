package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC001_PrePaidDashBoard extends BaseTestClass{
	
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
	
	@Test
	public void prePaidDashBoard() {
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc00101056.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc00101056.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
							"Login proceed without error.", 
							"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overvew page.");
		fido_account_overview_page.clkCtnBadge();

		reporter.reportLogWithScreenshot("Dashboard View displayed");
		reporter.hardAssert(fido_wireless_dashboard_prepaid_page.verifyDataDashboardIsDisplayed(),
							"Data dashboard Verified",
							"Data Dashboard has issue, please investigate.");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyTalkDashboardDetails(),
							"Talk dashboard ",
							"Talk dashboard has issue, please investigate.");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyTextDashboardDetails(),
							"Text dashboard ",
							"Text dashboard has issue, please investigate.");
				
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLabelMyBalanceIsdisplayed(),
							"Label My Balance verified",
							"Label My Balance has issue, please investigate.");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyMyBalanceCurrencyAmountIsdisplayed(),
							"My Balance currency amount verified",
							"My Balance currency amount has issue, please investigate.");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyMyBalanceApproxIsDisplayed(),
							"My Balance approx is displayed",
							" My Balance approx is not displayed");		
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyMyBalanceExpiresOnIsDisplayed(),
							"My Balance expires on is displayed",
							"My Balance expires on is not displayed");
		//TODO
//--------------- Awaiting manual testers confirmation on below three checkpoints for fido dashboard--------------------		
		//reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyMyBalanceScheduleAutomaticRefillsIsDisplayed(),"Balance Schedule Automatic Refill is displayed","Balance Schedule Automatic Refill is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyButtonChangeAutoRefillsIsDisplayed(),"Change Auto refill is displayed","Change auto refill is not displayed");
		//reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyButtonMybalanceRefillNowIsDisplayed(),"My balance refill now is displayed","My balance refill is not displayed");
		
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLabelMyPlanIsDisplayed(),
							"My plan is displayed",
							"My plan is not displayed");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLabelMyPlanNameIsDisplayed(),
							"My plan name is displayed",
							"My plan name is not displayed");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLabelMyPlanfeaturesIsDisplayed(),
							"My Plan feature is displayed",
							"My Plan feature is not displayed");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLabelMyPlanExtrasIsDisplayed(),
							"My Plan extras displayed",
							"My Plan extras Not displayed");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLabelMyPlanEstimatedValuesIsDisplayed(),
							"My Plan estimated value verfied",
							"My plan estimated value not verified");
		
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyMyDeviceDetails(),
							"My Device details dispalyed",
							"My device details not displayed");						
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLinkReportLostOrStolenIsDisplayed(),
							"Link report lost or stolen is displayed",
							"Link report lost or stolen not displayed");	
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLinkLostAndStolenIsValid(),
							"Link lost and stolen valid",
							"Link lost or stolen not valid");		
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLinkShopForAccessoriesIsDisplayed(),
							"Shop for accessories is displayed",
							"shop for accessories not displayed");
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLinkRetrievePUKCodeIsDisplayed(),
							"Link retreive PUK code is displayed",
							"Link retreive PUK code is not displayed");		
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLinkRetreivePUKCode(),
							"Link PUK code is verfied",
							"Link PUK code is not verified");
	
		reporter.softAssert(fido_wireless_dashboard_prepaid_page.verifyLinkShopForAccessoriesIsValid(),
							"Link shop for accessories is valid",
							"Seems the link shop for accessories is not valid");
		fido_wireless_dashboard_prepaid_page.scrollToMiddleOfPage();
		reporter.reportLogWithScreenshot("Prepaid wireless dashboad mid view");
		fido_wireless_dashboard_prepaid_page.scrolltoBottomOfPage();
		reporter.reportLogWithScreenshot("Prepaid wireless dashboad Bottom view");
		
	}
	
	

}
