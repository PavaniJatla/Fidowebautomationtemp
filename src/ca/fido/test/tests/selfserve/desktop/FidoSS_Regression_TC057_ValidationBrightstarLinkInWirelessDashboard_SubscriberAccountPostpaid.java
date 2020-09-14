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
 * The test will do Validation of brightstar link- clicking on usage and service form postpaid consumer regular account_IW_Chrome_EN
 * 1. Sign in to Fido.ca
 * 2.Click on the usage and service on the navigation bar
 * 3.Click on the 'repair my device' link under manage my device section
 * 4.Click on the 'Continue' button on the popup window
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC057_ValidationBrightstarLinkInWirelessDashboard_SubscriberAccountPostpaid extends BaseTestClass{
	
	
	 	
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
	public void validateBrightstarLinkInWirelessDashboardForSubscriber() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		fido_home_page.clkLogin();
		String userName = "";
		String password = "";	
		userName = TestDataHandler.tc4557.getUsername();
		password = TestDataHandler.tc4557.getPassword();
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
		reporter.reportLogWithScreenshot("Usage and Services page");				
		fido_wireless_dashboard_postpaid_page.scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Dashboard view");
		reporter.hardAssert(!fido_wireless_dashboard_postpaid_page.verifyLinkRepairMyDeviceIsDisplayed(),
				"Link Start or track a phone repair claim is hidden for subscriber account",
				"Link Start or track a phone repair claim is displayed for subscriber account");		
										
	}
	
}
