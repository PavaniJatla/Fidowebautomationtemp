package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the HSI downgrade flow for Fido.ca   
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Log into fido.ca url with valid credentials.
 *3. Click on the internet icon in dashboard.
 *4. Click on View/change internet package link.
 *5. Choose another internet package which is lower price than current package and click update.
 *
 **/

public class FidoCH_Regression_TC_010_HSIPlanDowngradeTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","FidoHSIDashboardCH","ReleaseSanity"})
	public void checkFidoHSIPlanDowngrade() {
		getReporter().reportLogWithScreenshot("Launched the SignIn page");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameDowngrade());
		getReporter().reportLogWithScreenshot("Continue Login");
		getFidologinpage().clkContinueSignIn();
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentials");
		getFidologinpage().clkLoginInFrame();
		getEnsverifications().setVerificationCodeCH(TestDataHandler.fidoHSIAccount.getUsername(), "sms");
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
		getFidoaccountoverviewpage().clkViewUsageManage();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getFidointernetdashboardpage().clkChangePackage();
		getReporter().reportLogWithScreenshot("Launched the packages Page");
		getFidointernetdashboardpage().selectHSIPackageByBandwidth(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradePlan());
		getReporter().reportLogWithScreenshot("Selected the 50 Mbps Download speed package to downgrade");
		getFidointernetdashboardpage().clkConfirmPackageChange();
		getReporter().reportLogWithScreenshot("Plan downgrade ways popup has displayed");
		getReporter().hardAssert(getFidointernetdashboardpage().verifyDowngradePopup(),"Plan downgrade ways popup has displayed","Plan downgrade ways popup hasn't displayed");
		}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login,method);
	
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
