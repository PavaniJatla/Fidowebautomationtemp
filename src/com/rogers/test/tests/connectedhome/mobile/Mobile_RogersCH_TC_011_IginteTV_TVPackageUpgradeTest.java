package com.rogers.test.tests.connectedhome.mobile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to verify the solaris TV package upgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on a TV account
 *4. Click on chage package button
 *5. Choose a tv package whose price is higher than the current package and click on Submit
 *6. Scroll down to the last in the page and Click on Checkout
 *7. Enter appropriate Contact details
 *8. Pick a date time in step 2 - Most Convenient Time for us to call
 *9. Click on Continue
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit
 *
 **/

public class Mobile_RogersCH_TC_011_IginteTV_TVPackageUpgradeTest extends BaseTestClass {

    @Test
    public void checkSolarisTVPackageUpgradeMobile() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignInMobile();
    	rogers_login_page.switchToSignInIFrame();
    	rogers_login_page.setUsernameIFrame(TestDataHandler.tc013132.getUsername());
    	rogers_login_page.setPasswordIFrame(TestDataHandler.tc013132.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc013132.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");   
        rogers_solaris_tv_dashboard_page.clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        rogers_solaris_tv_dashboard_page.clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        
        
        
        rogers_solaris_tv_dashboard_page.selectSolarisTVPackage(TestDataHandler.solarisTVAccountForUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.solarisTVAccountForUpgrade.accountDetails.getUpgradePlanFr());
        rogers_solaris_tv_dashboard_page.clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        rogers_solaris_tv_channels_and_themepacks_page.clkExchangeLater(); 
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
        rogers_solaris_tv_channels_and_themepacks_page.clkContinueFromThemepacks();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
        rogers_solaris_tv_channels_and_themepacks_page.clkYesIHave4K();  
        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
        rogers_solaris_tv_channels_and_themepacks_page.clk4KContent();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.rogersConfig.getRogersURL(), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}


}
