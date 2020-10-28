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
 * This class contains the test method to test the Manage theme packs functionality in TV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 1. Launch Rogers.com
 *2. Login into the application
 *3. Click TV badge
 *4. Click Manage channels and theme packs
 *5. Click on theme pack
 *6. Add theme pack and remove it and again add it
 *7. Click confirm changes on manage channels and theme packs
 *8. Click accept the agreement and Submit the order
 **/

public class RogersCH_TC_005_Regression_4Plus1AddThemepacksfromTVDashboardPage extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	public void check4Plus1AddThemepacksfromTVDashboardPage() { 
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc05_IgniteTV4Plus1Account.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc05_IgniteTV4Plus1Account.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.tc05_IgniteTV4Plus1Account.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_solaris_tv_dashboard_page.clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		rogers_solaris_tv_dashboard_page.clkManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked on Manage channels and theme packs");
		rogers_solaris_tv_channels_and_themepacks_page.clkThemePacks();
		reporter.reportLogWithScreenshot("Clicked on themepack tab");
		rogers_solaris_tv_channels_and_themepacks_page.clkAddButtonOnThemePackListOnManageChannelsAndThemePacks4plus1();
		reporter.reportLogWithScreenshot("Clicked on confirm button");
		rogers_solaris_tv_channels_and_themepacks_page.clkContinueOnExistingChannelAlertWindow(); 
		reporter.reportLogWithScreenshot("ThemePack added");    
		rogers_solaris_tv_channels_and_themepacks_page.clkConfirmChangesOnManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked in confirm changes on manage channels and theme packs");

		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		rogers_order_review_page.clkAcceptenceCheckboxUpdate();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmitUpdate();
		reporter.hardAssert(rogers_order_confirmation_page.verifyOrderSuccess(),"Update order completed","Update order Failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		}
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
	closeSession();
	}



}

