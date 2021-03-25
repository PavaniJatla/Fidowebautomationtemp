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
	
	@Test(groups = {"RegressionSS","DashboardSS","Prepaid"})
	public void prePaidDashBoard() {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc00101056.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc00101056.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();		
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
							"Login proceed without error.", 
							"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overvew page.");
		String strCTN = TestDataHandler.tc00101056.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);

		getReporter().reportLogWithScreenshot("Dashboard View displayed");
		getReporter().hardAssert(getFidowirelessdashboardprepaidpage().verifyDataDashboardIsDisplayed(),
							"Data dashboard Verified",
							"Data Dashboard has issue, please investigate.");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyTalkDashboardDetails(),
							"Talk dashboard ",
							"Talk dashboard has issue, please investigate.");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyTextDashboardDetails(),
							"Text dashboard ",
							"Text dashboard has issue, please investigate.");
				
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLabelMyBalanceIsdisplayed(),
							"Label My Balance verified",
							"Label My Balance has issue, please investigate.");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyMyBalanceCurrencyAmountIsdisplayed(),
							"My Balance currency amount verified",
							"My Balance currency amount has issue, please investigate.");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyMyBalanceApproxIsDisplayed(),
							"My Balance approx is displayed",
							" My Balance approx is not displayed");		
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyMyBalanceExpiresOnIsDisplayed(),
							"My Balance expires on is displayed",
							"My Balance expires on is not displayed");
		//TODO
//--------------- Awaiting manual testers confirmation on below three checkpoints for fido dashboard--------------------		
		//getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyMyBalanceScheduleAutomaticRefillsIsDisplayed(),"Balance Schedule Automatic Refill is displayed","Balance Schedule Automatic Refill is not displayed");
		//getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyButtonChangeAutoRefillsIsDisplayed(),"Change Auto refill is displayed","Change auto refill is not displayed");
		//getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyButtonMybalanceRefillNowIsDisplayed(),"My balance refill now is displayed","My balance refill is not displayed");
		
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLabelMyPlanIsDisplayed(),
							"My plan is displayed",
							"My plan is not displayed");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLabelMyPlanNameIsDisplayed(),
							"My plan name is displayed",
							"My plan name is not displayed");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLabelMyPlanfeaturesIsDisplayed(),
							"My Plan feature is displayed",
							"My Plan feature is not displayed");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLabelMyPlanExtrasIsDisplayed(),
							"My Plan extras displayed",
							"My Plan extras Not displayed");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLabelMyPlanEstimatedValuesIsDisplayed(),
							"My Plan estimated value verfied",
							"My plan estimated value not verified");
		
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyMyDeviceDetails(),
							"My Device details dispalyed",
							"My device details not displayed");						
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLinkReportLostOrStolenIsDisplayed(),
							"Link report lost or stolen is displayed",
							"Link report lost or stolen not displayed");	
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLinkLostAndStolenIsValid(),
							"Link lost and stolen valid",
							"Link lost or stolen not valid");		
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLinkShopForAccessoriesIsDisplayed(),
							"Shop for accessories is displayed",
							"shop for accessories not displayed");
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLinkRetrievePUKCodeIsDisplayed(),
							"Link retreive PUK code is displayed",
							"Link retreive PUK code is not displayed");		
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLinkRetreivePUKCode(),
							"Link PUK code is verfied",
							"Link PUK code is not verified");
	
		getReporter().softAssert(getFidowirelessdashboardprepaidpage().verifyLinkShopForAccessoriesIsValid(),
							"Link shop for accessories is valid",
							"Seems the link shop for accessories is not valid");
		getFidowirelessdashboardprepaidpage().scrollToMiddleOfPage();
		getReporter().reportLogWithScreenshot("Prepaid wireless dashboad mid view");
		getFidowirelessdashboardprepaidpage().scrolltoBottomOfPage();
		getReporter().reportLogWithScreenshot("Prepaid wireless dashboad Bottom view");
		
	}
	
	

}
