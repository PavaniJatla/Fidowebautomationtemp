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

	@Test(groups = {"SanityCH","RegressionCH","FidoUpgradePlanCH"})
	public void checkFidoHSIPlanDowngrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameDowngrade());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentials");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_account_overview_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_account_overview_page.clkInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		fido_internet_dashboard_page.clkChangePackage();
		reporter.reportLogWithScreenshot("Launched the packages Page");
		fido_internet_dashboard_page.selectHSIPackageByBandwidth(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradePlan());
		reporter.reportLogWithScreenshot("Selected the package");
		fido_internet_dashboard_page.clkConfirmPackageChange();
		reporter.reportLogWithScreenshot("Plan downgrade ways popup has displayed");
		reporter.hardAssert(fido_internet_dashboard_page.verifyDowngradePopup(),"Plan downgrade ways popup has displayed","Plan downgrade ways popup hasn't displayed");
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