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
		getFidohomepage().clkLogin();
		String userName = "";
		String password = "";	
		userName = TestDataHandler.tc4557.getUsername();
		password = TestDataHandler.tc4557.getPassword();
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
		String strCTN = TestDataHandler.tc4557.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Usage and Services page");				
		getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();
		getReporter().reportLogWithScreenshot("Dashboard view");
		getReporter().hardAssert(!getFidowirelessdashboardpostpaidpage().verifyLinkRepairMyDeviceIsDisplayed(),
				"Link Start or track a phone repair claim is hidden for subscriber account",
				"Link Start or track a phone repair claim is displayed for subscriber account");		
										
	}
	
}
