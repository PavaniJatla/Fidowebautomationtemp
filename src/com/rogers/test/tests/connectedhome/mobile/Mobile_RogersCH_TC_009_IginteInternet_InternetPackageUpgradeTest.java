package com.rogers.test.tests.connectedhome.mobile;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



/**
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class Mobile_RogersCH_TC_009_IginteInternet_InternetPackageUpgradeTest extends BaseTestClass {

    @Test(groups = {"MobileRegressionCH"})
    public void checkInternetPackageUpgradeMobile() {
        reporter.reportLogWithScreenshot("Home Page");
    	rogers_home_page.clkSignInMobile();    	
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
    	reporter.hardAssert(rogers_account_overview_page.verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_internet_dashboard_page.clkInternetBadgeMobile();
        reporter.reportLogWithScreenshot("Launched the Interent dashboard");
        rogers_internet_dashboard_page.clkSolChangeInternetPackageMobile();
        reporter.reportLogWithScreenshot("Launched the Interent packages page");
        rogers_internet_dashboard_page.selectSolarisInternetPackage(TestDataHandler.solarisInternetAccount.getAccountDetails().getUpgradePlanEn(),TestDataHandler.solarisInternetAccount.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the agreement page");
        rogers_internet_dashboard_page.clkInternetChangeOK();
		reporter.hardAssert(rogers_order_review_page.verifyAgreementPageInternet(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		
        rogers_order_review_page.clkAcceptenceCheckboxUpdateInternetMobile();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmitUpdateInternetMobile();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmationNew(),"Update order completed","Update order Failed");                             
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}
