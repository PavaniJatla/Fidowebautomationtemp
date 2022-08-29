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
 * This class contains the test method to test the pay now functionality for Fido.ca   
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Load fido.ca url.
 *2. Login with valid credentials
 *3. Click on internet badge in account overview page
 *4. Package details is displayed and click on View/Change package
 *
 **/

public class FidoCH_Regression_TC_021_HSIValidateRestartModemTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","FidoHSIDashboardCH","ReleaseSanity"})
	public void checkFidoHSIValidateRestartModem() {
		getReporter().reportLogWithScreenshot("Launched the sign in Page");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentials");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
		getFidoaccountoverviewpage().clkViewUsageManage();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getReporter().softAssert(getFidointernetdashboardpage().verifyManageSettings(),"Verified the Manage Settings link","Manage Settings link Verification has failed");
    	getReporter().softAssert(getFidointernetdashboardpage().verifyIfPlanInformationLoaded(),"Verified the Plan Information Loaded link","Plan Information Loaded link Verification has failed");
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfUsageInfoDisplayed(),"Verified the Data Usage summary","Data Usage summary Verification has failed");
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfDailyUsageLinkVisible(),"Verified Daily Usage link","Daily Usage link Verification has failed");
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfMonthlyUsageLinkVisible(),"Verified Monthly Usage link","Monthly Usage link Verification has failed");
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfChangePackageLinkVisible(),"Verified Change Package link","Change Package link Verification has failed");
		getReporter().reportLogWithScreenshot("Internet Dashboard Page");
		getFidointernetdashboardpage().clkManageSettings();
		getReporter().reportLogWithScreenshot("Manage setting option have displayed");
		getFidointernetdashboardpage().clkRestartModem();
		getReporter().softAssert(getFidointernetdashboardpage().verifyModemRestartModel(),"Modem Restart model is visible","Modem Restart model is not visible");
		getFidointernetdashboardpage().clkYesRestartModem();
		getReporter().softAssert(getFidointernetdashboardpage().verifySuccessModel(),"Modem Restart Success","Modem Restart not Success");
	}

	@BeforeMethod (alwaysRun = true)
	@Parameters({ "strBrowser","strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
