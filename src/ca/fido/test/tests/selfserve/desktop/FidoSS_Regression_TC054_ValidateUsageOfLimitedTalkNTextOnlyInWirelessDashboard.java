package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * The test will verify post paid account talk and text usage section on wireless dash board,
 * the test will run for account which has Talk and Text plan.
 * This test include both scenarios of limited or unlimited Talk and Text plan.
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC054_ValidateUsageOfLimitedTalkNTextOnlyInWirelessDashboard extends BaseTestClass{
	 	
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
	public void validateLimitedTalkNTextUsageinWirelessDashboard(){
		getReporter().reportLogWithScreenshot("DashBoard Talk and Text Usage verification started");
		getFidohomepage().clkLogin();
		String userName = TestDataHandler.tc54.getUsername();
		String password = TestDataHandler.tc54.getPassword();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(userName);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login page, user name and password are set.");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		String strCTN = TestDataHandler.tc54.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();

		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyTalkNTextUsageModuleIsDisplayed(),
							"Talk usage module is displayed",
							"Talk usage module is not displayed");
		getReporter().reportLogWithScreenshot("Wireless dashboard page");

		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTalkRemainingMinutesIsDisplayed(),
				"Talk usage detail is checked successfully.",	
				"Talk usage detail has issue, please investigate.");
		//getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTalkAnytimeUsageDetailsIsDisplayed(),
		//					"Talk anytime usage details section is displayed",
		//					"Talk anytime usage details section is not displayed");
		//getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTalkEveningUsageDetailsIsDisplayed(),
		//					"Talk evening and weekend usage details section is displayed",
		//					"Talk evening and weekend usage details section is not displayed");

		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTextRemainingIsDisplayed(),
							"Text usage details section is displayed",
							"Text usage details section is not displayed");
		//getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyPictureMsgDetailsIsDisplayed(),
		//					"Text usage details picture message part is displayed",
		//					"Text usage details picture message part is not displayed");
		//getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyBundlesMsgDetailsIsDisplayed(),
							//"Text usage details bundles message part is displayed",
							//"Text usage details bundles message part is not displayed");
		//getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyInternationalMsgDetailsIsDisplayed(),
		//					"Text usage details international message part is displayed",
		//					"Text usage details international message part is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDaysRemainingInBillCycleIsDisplayed(),
							"Days remaining in bill cycle for Talk&Text plan is displayed",
							"Days remaining in bill cycle for Talk&Text plan is not displayed");

		getFidowirelessdashboardpostpaidpage().scrollToBottomOfPage();
		getReporter().reportLogWithScreenshot("Wireless Dashboad bottom view");
			
	}
	
}
