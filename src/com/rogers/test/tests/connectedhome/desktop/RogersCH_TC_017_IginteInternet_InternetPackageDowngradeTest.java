package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to verify the solaris internet package downgrade flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on change package button.
 *5. Select a package which has price lower to the current package.
 *
 **/

public class RogersCH_TC_017_IginteInternet_InternetPackageDowngradeTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","RogersInternetCH"})
    public void checkInternetPackageDowngrade() {
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        rogers_account_overview_page.selectAccount(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_internet_dashboard_page.clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Interent dashboard");
        rogers_internet_dashboard_page.clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Interent packages page");        
        rogers_internet_dashboard_page.selectSolarisInternetPackage(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getAccountDetails().getDowngradePlanFr());
        //rogers_internet_dashboard_page.clkInternetChangeOK();
        reporter.hardAssert(rogers_internet_dashboard_page.verifyContatUSInternetDowngarde(),"Displayed the contat US popup","Download package has failed");        
        reporter.reportLogWithScreenshot("Launched the customercare popup");
    	}
	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}