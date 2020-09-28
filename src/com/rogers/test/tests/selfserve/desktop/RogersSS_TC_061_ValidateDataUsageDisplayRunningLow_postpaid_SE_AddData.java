package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums.GroupName;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_061_ValidateDataUsageDisplayRunningLow_postpaid_SE_AddData extends BaseTestClass {	
   	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,GroupName.selfserve, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateDataUsageDisplayForRunningLowAndAddData() {
    	reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc61.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc61.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc61.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndServiceMobile();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");

    	rogers_account_overview_page.clkSubMenuWirelessUsage();
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        
        double origTotalData = rogers_wireless_dashboard_page.getTotalDataVolume();
        double addedData = 0;
        String strCtn1 = TestDataHandler.tc61.getAccountDetails().getCtn1();
        String strCtn2 = TestDataHandler.tc61.getAccountDetails().getCtn2();
        this.verifyRunningLowTagForCtn(strCtn1);
        this.verifyRunningLowTagForCtn(strCtn2);
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAddDataButtonIsDisplayed(), 
							"Add the Data top-up button is displayed", 
							"Add the Data top-up  button is NOT displayed."); 
        //Validate add data flow
        common_business_flows.addDataFlow();
        if(rogers_add_data_page.verifyAddDataSuccessMsgIsDisplayed())
        {
        	addedData = rogers_add_data_page.getAddedDataVolume();
        	rogers_add_data_page.clkCloseOnAddDataOverlay();
        	//Sign out and re sign in to verify if added data reflected.
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");  
	        rogers_login_page.clickSignOut();
	        reporter.reportLogWithScreenshot("Sign Out clicked");  
	        rogers_login_page.clkSignInAs();
	        reporter.reportLogWithScreenshot("Re sign In");  
	        rogers_login_page.switchToSignInIFrame();
	                   
	        rogers_login_page.setPasswordIFrame(strPassword);
	        reporter.reportLogWithScreenshot("Login Credential is entered.");
			rogers_login_page.clkSignInIFrame();		
			rogers_login_page.switchOutOfSignInIFrame();		       
	        reporter.reportLogWithScreenshot("Account overview page.");        
	        rogers_account_overview_page.clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");        
	        rogers_account_overview_page.clkSubMenuWirelessUsage();
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");
	        reporter.hardAssert(!rogers_wireless_dashboard_page.verifyRunningLowStateInTheUsageBar(),
	        		"Data running low is disappeared",
	        		"It seems the data running low state is still displayed, please add more data and re validate");
	        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAddedDataReflectedInTotalDataBucket(origTotalData, addedData), 
								"Added data is reflected in total data bucket.", 
								"Added data didn't reflect in total data bucket.");
	     	        
        } else if (rogers_add_data_page.verifyErrorMsgIsDisplayed()) {
        	reporter.reportLogWithScreenshot("Add data purchase got error, please check if limit is reached.");
        	rogers_add_data_page.clkCloseOnAddDataOverlay();
        }
       
        //Validate view details link
        reporter.hardAssert(rogers_manage_data_page.validateViewDetailsLink(), 
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
        rogers_manage_data_page.clkBackOnManageDataUsagePage();
        reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
        //Verify days remaining in billing cycle displayed
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyDaysRemainingInTheBillCycleIsDisplayed(), 
							"Days left remaining in the bill cycle is displayed", 
							"Days left remaining in the bill cycle is NOT displayed");    
        //Validate Data display should be presented in GB
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBForTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded(),
        		"All amounts are coverted to GB For Total Data Displayed Below Label Total Data Plus Plan Added",
        		"it seems amount is not convertd to GB For Total Data Displayed Below Label Total Data Plus Plan Added, please investigate");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBForLabelDataRemaining(),
        		"All amounts are coverted to GB For Label Data Remaining",
        		"it seems amount is not convertd to GB For Label Data Remaining, please investigate");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBForlabelTotalDataDisplayedBelowBarRightSide(),
        		"All amounts are coverted to GB label Total Data Displayed Below Bar RightSide",
        		"it seems amount is not convertd to GB label Total Data Displayed Below Bar RightSide, please investigate");
        //All MB amounts converted in GB should be up to 2 decimal points
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesForTotalDataPlusAddedPlan(), 
				"All MB amounts converted in GB up to 2 decimal points For Total Data Plus Added Plan", 
				"MB amounts converted in GB up to 2 decimal points NOT validated For Total Data Plus Added Plan, please investigate");  
		reporter.hardAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnLabelDataRemaining(), 
			"All MB amounts converted in GB up to 2 decimal points On Label Data Remaining", 
			"MB amounts converted in GB up to 2 decimal points NOT validated On Label Data Remaining, please investigate"); 
		reporter.hardAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnTotalDataBelowUsageBarRightSide(), 
			"All MB amounts converted in GB up to 2 decimal points Total Data Below UsageBar RightSide", 
			"MB amounts converted in GB up to 2 decimal points NOT validated Total Data Below UsageBar RightSide, please investigate");                              

		rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }
    
    private void verifyRunningLowTagForCtn(String strCtn) {
        rogers_wireless_dashboard_page.clkCtnTab(strCtn);
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyRunningLowStateInTheUsageBar(),
        		"Data running low is displayed for 10% or less data",
        		"It seems the data running low state is not yet reached for this acccount, please decrease the data usage and re validate");
         reporter.hardAssert(rogers_wireless_dashboard_page.verifyCallOutMessageToAddDataIsDisplayed(),
        		 "Call out message to add data is displayed",
        		 "Call out message to add data is not displayed");
        reporter.reportLogWithScreenshot("Wireless dashboard page for CTN: " + strCtn); 
    }
    

}