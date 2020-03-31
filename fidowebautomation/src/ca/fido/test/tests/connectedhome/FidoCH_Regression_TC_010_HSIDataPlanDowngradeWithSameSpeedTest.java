package ca.fido.test.tests.connectedhome;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;



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

public class FidoCH_Regression_TC_010_HSIDataPlanDowngradeWithSameSpeedTest extends BaseTestClass {

	@Test
	public void checkFidoHSIPlanDowngrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameDowngradeSameSpeed());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentails");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Login Successful","Login Failed");
		fido_account_overview_page.clkAccountSelectionDropDown();
		fido_account_overview_page
				.selectAccountByType(TestDataHandler.fidoHSIAccountForDowngrade.getaccountDetails().getType());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_account_overview_page.clkInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		fido_internet_dashboard_page.clkChangePackage();
		reporter.reportLogWithScreenshot("Launched the packages Page");
		//fido_internet_dashboard_page.selectHSIPackageByData();
		fido_internet_dashboard_page.selectHSIPackageByBandwidth(TestDataHandler.fidoHSIAccountForDowngrade.getaccountDetails().getDowngradePlan());
		reporter.reportLogWithScreenshot("Selected the package");
		fido_internet_dashboard_page.clkConfirmPackageChange();
		reporter.reportLogWithScreenshot("Confirmed Package Change");
		reporter.hardAssert(fido_internet_dashboard_page.verifyDowngradeWithSameDownloadSpead(),"Plan downgarde ways popup has displayed","Plan downgarde ways popup hasn't displayed");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage,String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(TestDataHandler.fidoConfig.getFidoURL(),strBrowser,strLanguage, strGroupName, method);
	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
