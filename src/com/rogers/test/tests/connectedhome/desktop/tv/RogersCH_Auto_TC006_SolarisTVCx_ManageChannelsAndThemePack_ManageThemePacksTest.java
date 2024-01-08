package com.rogers.test.tests.connectedhome.desktop.tv;
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
 * @author Saurav.Goyal
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

public class RogersCH_Auto_TC006_SolarisTVCx_ManageChannelsAndThemePack_ManageThemePacksTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	public void rogersCH_Auto_TC006_SolarisTVCx_ManageChannelsAndThemePack_ManageThemePacks() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.getUsername());
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersSolarisTVDashboardPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		getRogersSolarisTVDashboardPage().clkManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked on Manage channels and theme packs");
		getRogersSolarisTVChannelsAndThemepacksPage().clkThemePacks();
		reporter.reportLogWithScreenshot("Clicked on themepack tab");
		getRogersSolarisTVChannelsAndThemepacksPage().clkAddButtonOnThemePackListOnManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked on confirm button");
		 getRogersSolarisTVChannelsAndThemepacksPage().clkChannelPacks();
		 reporter.reportLogWithScreenshot("Clicked Channel tab");
		 getRogersSolarisTVChannelsAndThemepacksPage().clkAddButtononChannelPackListonManageChannelsAndThemePacks();
		 reporter.reportLogWithScreenshot("Clicked on Channelpack tab");
		//getRogersSolarisTVChannelsAndThemepacksPage().clkContinueOnExistingChannelAlertWindow();
		reporter.reportLogWithScreenshot("ThemePack added");    
		getRogersSolarisTVChannelsAndThemepacksPage().clkConfirmChangesOnManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked in confirm changes on manage channels and theme packs");
		
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckboxUpdate();
		reporter.reportLogWithScreenshot("Agreement details");
//		getRogersOrderReviewPage().clkSubmitUpdate();
//		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderSuccess(),"Update order completed","Update order Failed");
//		reporter.reportLogWithScreenshot("Launched the Confirmation page");
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


