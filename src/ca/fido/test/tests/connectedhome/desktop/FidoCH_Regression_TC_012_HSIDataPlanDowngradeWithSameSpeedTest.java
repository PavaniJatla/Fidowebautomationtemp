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
 * This class contains the test method to test the HSI downgrade flow with same speed for Fido.ca   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Log into fido.ca url with valid credentials.
 *3. Click on the internet icon in dashboard.
 *4. Click on View/change internet package link.
 *5. Choose another internet package and click update.
 *
 **/

public class FidoCH_Regression_TC_012_HSIDataPlanDowngradeWithSameSpeedTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoHSIDashboardCH"})
	public void checkFidoHSIPlanDowngrade() {
		getReporter().reportLogWithScreenshot("Launched the SignIn page");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameDowngradeSameSpeed());
		getReporter().reportLogWithScreenshot("Continue Login");
		getFidologinpage().clkContinueSignIn();
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentails");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
		getFidoaccountoverviewpage().clkViewUsageManage();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getFidointernetdashboardpage().clkChangePackage();
		getReporter().reportLogWithScreenshot("Launched the packages Page");
		//getFidointernetdashboardpage().selectHSIPackageByData();
		getFidointernetdashboardpage().selectHSIPackageByBandwidth(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradePlan());
		getReporter().reportLogWithScreenshot("Selected the package");
		getFidointernetdashboardpage().clkConfirmPackageChange();
		getReporter().reportLogWithScreenshot("Confirmed Package Change");
		getReporter().hardAssert(getFidointernetdashboardpage().verifyDowngradeWithSameDownloadSpead(),"Plan downgarde ways popup has displayed","Plan downgarde ways popup hasn't displayed");
		}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"),strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login, method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
