package com.rogers.test.tests.choneview;
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
import com.rogers.testdatamanagement.TestDataHandler;




public class OneViewCH_TC_018a_TV_HeaderFooterUserForgotPurchasePinTest extends BaseTestClass {
    @Test
    public void checkUserForgotPurchasePin() {
    			getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
    			reporter.reportLogWithScreenshot("Launched the account dashboard page");
    			getAccountOverViewPage().selectTVBadage(TestDataHandler.chOneViewConfig.getBrowser());
    			reporter.reportLogWithScreenshot("Launched the TV dashboard page");
    			reporter.softAssert(getTVDashboardPage().verifyHeader(),"Header is available","Verification of Header failed");
    			reporter.reportLogWithScreenshot("Header available on TV Dashboard page");
    			reporter.softAssert(getTVDashboardPage().verifyFooter(),"Footer is available","Verification of Header failed");
    			reporter.reportLogWithScreenshot("Footer available on TV Dashboard page");
    			getTVDashboardPage().clickCustForgotPurchasePin();
    			reporter.reportLogWithScreenshot("Customer forgot purchase pin button clicked");
    			getTVDashboardPage().clickContinueReset();
    			reporter.reportLogWithScreenshot("Continue clicked");
    			reporter.softAssert(getTVDashboardPage().verifyResetSuccess(),"Customer forgot purchase pin validation passed","Customer forgot purchase pin validation passed");
    			reporter.reportLogWithScreenshot("Customer forgot purchase pin successfull");
    			getTVDashboardPage().clickSuccessOk();
    			reporter.reportLogWithScreenshot("Ok clicked after success");
    }
    
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,strGroupName, "",TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
		  	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

