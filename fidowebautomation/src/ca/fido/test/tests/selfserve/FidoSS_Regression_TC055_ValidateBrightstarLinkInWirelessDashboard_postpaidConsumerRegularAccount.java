package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * The test will do Validation of brightstar link- clicking on usage and service form postpaid consumer regular account_IW_Chrome_EN
 * 1. Sign in to Fido.ca
 * 2.Click on the usage and service on the navigation bar
 * 3.Click on the 'repair my device' link under manage my device section
 * 4.Click on the 'Continue' button on the popup window
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC055_ValidateBrightstarLinkInWirelessDashboard_postpaidConsumerRegularAccount extends BaseTestClass{
	
	
	 	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validateBrightstarLinkInWirelessDashboardForPostpaid() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		fido_home_page.clkLogin();		
		String userName = "";
		String password = "";	
		userName = TestDataHandler.tc5055.getUsername();
		password = TestDataHandler.tc5055.getPassword();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Usage and Services page");				
		fido_wireless_dashboard_postpaid_page.scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Dashboad veiw");
		reporter.hardAssert(fido_wireless_dashboard_postpaid_page.verifyLinkRepairMyDeviceIsDisplayed(),
				"Link Start or track a phone repair claim",
				"Link Start or track a phone repair claim is not displayed");		
		fido_wireless_dashboard_postpaid_page.clkRepairDeviceLink();
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyOverlayForRepairDeviceIsDisplayed(),
				"Overlay get help for you phone is displayed",
				"Overlay get help for you phone is displayed is not displayed");
		reporter.reportLogWithScreenshot("Overlay GET HELP FOR YOUR PHONE is displayed");
		String strParentWindowHandle = fido_wireless_dashboard_postpaid_page.clkButtonContinueOnRepairDeviceOverlay();		
		reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyBrightStarNewTabAndURL(strParentWindowHandle,
				TestDataHandler.config.getBrightStarURL()),
				"Bright star tab and url open",
				"Bright star tab and url did not open");
		reporter.reportLogWithScreenshot("BrighStar page");
	}
	
}
