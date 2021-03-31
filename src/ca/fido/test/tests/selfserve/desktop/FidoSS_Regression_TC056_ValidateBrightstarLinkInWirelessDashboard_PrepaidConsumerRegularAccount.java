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
 * The test will do Validation of brightstar link- clicking on usage and service form post paid consumer regular account_IW_Chrome_EN
 * 1. Sign in to Fido.ca
 * 2.Click on the usage and service on the navigation bar
 * 3.Click on the 'repair my device' link under manage my device section
 * 4.Click on the 'Continue' button on the pop up window
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC056_ValidateBrightstarLinkInWirelessDashboard_PrepaidConsumerRegularAccount extends BaseTestClass{
	
	
	 	
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
	
	@Test(groups = {"RegressionSS","DashboardSS","PrepaidSS"})
	public void validateBrightstarLinkInWirelessDashboardForPrepaid() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc00101056.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc00101056.getPassword());
		String strBAN = TestDataHandler.tc00101056.getaccountDetails().getBan();
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
		getFidoaccountoverviewpage().clkViewUsageAndServices(strBAN);
		getReporter().reportLogWithScreenshot("Usage and Services page");
					
		getReporter().hardAssert(getFidowirelessdashboardprepaidpage().verifyLinkRepairMyDeviceIsDisplayed(),
				"Link Start or track a phone repair claim",
				"Link Start or track a phone repair claim is not displayed");		
		getFidowirelessdashboardprepaidpage().clkRepairDeviceLink();
		getReporter().hardAssert(getFidowirelessdashboardprepaidpage().verifyOverlayForRepairDeviceIsDisplayed(),
				"Overlay get help for you phone is displayed",
				"Overlay get help for you phone is displayed is not displayed");
		getReporter().reportLogWithScreenshot("Overlay GET HELP FOR YOUR PHONE is displayed");
		String strParentWindowHandle = getFidowirelessdashboardprepaidpage().clkButtonContinueOnRepairDeviceOverlay();		
		getReporter().hardAssert(getFidowirelessdashboardprepaidpage().verifyBrightStarNewTabAndURL(strParentWindowHandle,
				TestDataHandler.config.getBrightStarURL()),
				"Bright star tab and url open",
				"Bright star tab and url did not open");
		getReporter().reportLogWithScreenshot("BrighStar page");								
	}
	
}
