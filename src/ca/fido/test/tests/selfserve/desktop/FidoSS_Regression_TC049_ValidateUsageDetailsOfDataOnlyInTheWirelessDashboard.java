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
 * The test will verify post paid account data usage section of wireless dash board,
 * the test will be run for account which has data only plan.
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC049_ValidateUsageDetailsOfDataOnlyInTheWirelessDashboard extends BaseTestClass{
			 	
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
	public void validateUsageDetailOfDataOnly() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		//getFidohomepage().clkLogin();
		String userName = TestDataHandler.tc49.getUsername();
		String password = TestDataHandler.tc49.getPassword();		
		//getFidologinpage().switchToSignInFrame();
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
		String strCTN = TestDataHandler.tc49.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		
		getReporter().reportLogWithScreenshot("dashboard page loading");
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyDataDashBoardSectionDataBalanceRemainingIsDisplayed(),
							"Dashboard Section Data Balance Is Displayed",
							"Dashboard section data balance not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDataDashBoardUsageBarIsDisplayed(),
							"usage bar is displayed",
							"usage bar is not displayed");
		
		getReporter().reportLogWithScreenshot("dashboard page usage section loaded.");
		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataInUsageSectionIsDisplayed(),
							"Data Section is displayed",
							"Data section is not displayed");		
		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLabelDataDelayedIsDisplayed(),
							"label data delayed is displayed for Non demo line account",
							"label data delayed is not displayed for non-demoline account");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDaysRemainingInBillCycleIsDisplayed(),
							"Days remaining in bill cycle is displayed for Non demo line account",
							"Days remaining in bill cycle is not displayed for non-demoline account");
			
	}
	
}
