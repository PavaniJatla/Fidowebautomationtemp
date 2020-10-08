package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_064_ValidateDataUsage_InfiniteIndividualPlanReducedSpeeds extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","WirelessDashboardSS"})
    public void validateDataUsageForInfiniteNsePlanReducedSpeed() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc64.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc64.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc64.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc64.getAccountDetails().getCtn();
        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
            rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
        } else {
     	   rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedDataNoOverage(),
		        		"The unlimited data no overage is diaplyed",
		        		"The unlimited data no overage label is not displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedReducedMsg(),
						"Label using data at reduced speed is displayed",
						"Label using data at reduced speed is not displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(),
						"Link add speed pass is displayed",
						"Link add speed pass is not displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyCallOutMsgToAddSpeedPassIsDisplayed(),
						"Call out message to Add speed pass is displayed",
						"call out message to add speed pass is not displayed");
        reporter.reportLogWithScreenshot("Dashboard page of reduced speed.");          
        rogers_wireless_dashboard_page.clkCloseCallOutMsg();
        reporter.hardAssert(rogers_wireless_dashboard_page.validateCloseCallOutIsClosed(),
						"Click on close call out message successful",
						"Click on close call out message didnt succeed");
        reporter.reportLogWithScreenshot("Closed Call out message to Add speed pass on dashboard page.");  
        common_business_flows.logOutAndReSignIn(strUsername, strPassword);   
//	        rogers_account_overview_page.clkCtnBadge(last4Digit);
	        rogers_account_overview_page.clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
	        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
	            rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
	        } else {
	     	   rogers_account_overview_page.clkSubMenuWirelessUsage();
	        }

	        reporter.reportLogWithScreenshot("Navigated back to dashboard after re-sign in");     
            rogers_wireless_dashboard_page.verifyCallOutMsgToAddSpeedPassIsDisplayed();   
            reporter.reportLogWithScreenshot("Dashboard with Call out message to Add speed pass displayed");
    }
    
    
    

}
