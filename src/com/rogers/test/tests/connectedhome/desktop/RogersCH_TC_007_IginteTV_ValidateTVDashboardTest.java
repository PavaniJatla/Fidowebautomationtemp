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
 * This class contains the test method to validate the TV dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge.
 *4. Click on View 'My channel Line Up' link below the Channels at the top left.
 *5. Click on the link to view as pdf and open the pdf.
 *6. Click on 'View My Flex channel' link below the Channels in the top left.
 *7. Click on the link to view as pdf and open the pdf.
 *
 **/

public class RogersCH_TC_007_IginteTV_ValidateTVDashboardTest extends BaseTestClass {

	 @Test(groups = {"SanityCH","RegressionCH","IgniteTVDashboardCH"})
    public void checkTVDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.igniteTVAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.igniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
    	rogers_account_overview_page.selectAccount(TestDataHandler.igniteTVAccount.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_tv_dashboard_page.clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dashboard Page");          
        
        //Verifying the My Channel Line up
        rogers_solaris_tv_dashboard_page.clkViewMyChannelLineup();
        reporter.reportLogWithScreenshot("Displayed the available channels"); 
        reporter.softAssert(rogers_solaris_tv_dashboard_page.verifyChannelList(),"Channels are avilable","None of the Channels are avialabe");
        reporter.softAssert(rogers_solaris_tv_dashboard_page.clklAndVerifyViewPDF(),"all the channels are displayed in PDF","PDF is not displying");                                       
        rogers_solaris_tv_dashboard_page.clkCloseChannelsPopup();
                    
        //Verifying the Flexchannels                     
        rogers_solaris_tv_dashboard_page.clkViewfelxChannels();
        reporter.reportLogWithScreenshot("Displayed the available flex channels"); 
        reporter.softAssert(rogers_solaris_tv_dashboard_page.verifyChannelList(),"flex channels are avilable","There are no felx channels");
        reporter.softAssert(rogers_solaris_tv_dashboard_page.clklAndVerifyViewPDF(),"all the flex channels are displayed in PDF","PDF is not displying");                  
        rogers_solaris_tv_dashboard_page.clkCloseChannelsPopup();                                 
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
