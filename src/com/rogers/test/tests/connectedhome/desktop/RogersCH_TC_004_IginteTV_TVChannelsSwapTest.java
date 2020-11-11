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
 * This class contains the test method to test the TV channels swap functionality for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials (Solaris account credentials with TV ).
 *3. Click on TV badge.
 *4. Click on Exchange Flex Channels button.
 *5. In Select Channels to remove section, select a change. 
 *6. Click  on Select in the pop up.
 *7. In Select Channels to add section, select one  channel.
 *8. Click  on Select in the pop up.
 *9. Check the "Sure, lets do a Credit Evaluation" check box and click on Submit.
 *10. Scroll down the page and click on Confirm Exchange.
 *11. Click on Ok.
 *
 **/

public class RogersCH_TC_004_IginteTV_TVChannelsSwapTest extends BaseTestClass {
	
	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	
   public void checkSolarisTVSwapChannels() {
    reporter.reportLogWithScreenshot("Launched the Home Page");
    getRogersHomePage().clkSignIn();
    getRogersLoginPage().switchToSignInIFrame();
    reporter.reportLogWithScreenshot("Launched the SignIn popup");
    getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getUsername());
    getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getPassword());
    reporter.reportLogWithScreenshot("Enter the account credentails");
    getRogersLoginPage().clkSignInIFrame();
	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
    reporter.reportLogWithScreenshot("Skip popup");
    getRogersLoginPage().clkSkipIFrame();
    getRogersLoginPage().switchOutOfSignInIFrame();
    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getBan());
	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
    reporter.reportLogWithScreenshot("Launched the Account Page");              
    getRogersSolarisTVDashboardPage().clkTVBadge();
    reporter.reportLogWithScreenshot("Launched the TV dash board");
    getRogersSolarisTVDashboardPage().clkChangeFlexChannels();
    reporter.reportLogWithScreenshot("TV channels pannel has displayed");
    getRogersSolarisTVDashboardPage().clkOutChannelOne();
    getRogersSolarisTVDashboardPage().clkOutChannelTwo();
    getRogersSolarisTVDashboardPage().clkOutChannelThree();
    reporter.reportLogWithScreenshot("removed the Swap-out Channels");
    getRogersSolarisTVDashboardPage().swapChannelIn(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getSwapInChannelOne());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel one");
         getRogersSolarisTVDashboardPage().btnClearSerachResults();
         getRogersSolarisTVDashboardPage().swapChannelIn(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getSwapInChannelTwo());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel two");
         getRogersSolarisTVDashboardPage().btnClearSerachResults();
         getRogersSolarisTVDashboardPage().swapChannelIn(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getSwapInChannelThree());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel three");
         getRogersSolarisTVDashboardPage().clkConfirmSwap();
    reporter.reportLogWithScreenshot("Swap Success popup has launched");
    getRogersSolarisTVDashboardPage().clkSuccessSwap();
    reporter.reportLogWithScreenshot("Swap success");  
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


