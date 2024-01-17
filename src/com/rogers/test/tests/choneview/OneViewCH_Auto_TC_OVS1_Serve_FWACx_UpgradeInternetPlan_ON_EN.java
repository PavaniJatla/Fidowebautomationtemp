package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC_OVS1_Serve_FWACx_UpgradeInternetPlan_ON_EN extends BaseTestClass {
    @Test(groups = {"Baseline","ChangePackage"})
    public void OneViewCH_Auto_TC_OVS1_Serve_FWACx_UpgradeInternetPlan_ON_EN() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Serve_FWACx_UpgradeInternetPlan.accountDetails.getBan(),  TestDataHandler.Serve_FWACx_UpgradeInternetPlan.getContactID() );
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectInternetBadage();
   //     getEnvironmentSelectionPage().selectProduction();
        getInternetDashboardPage().clkProductionbtn();
        reporter.reportLogWithScreenshot("Selected Production");
 //       getEnvironmentSelectionPage().clickProceed();
        getInternetDashboardPage().clkProceedbtn();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickChangePackageButton();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().clickLoadOffers();
        reporter.reportLogWithScreenshot("Load offers button clicked");
        getInternetDashboardPage().clickSelectButtonAsPerPackageName(TestDataHandler.Serve_FWACx_UpgradeInternetPlan.accountDetails.getInternetBundle());
        reporter.reportLogWithScreenshot("Internet Package selected for upgrade");
        getInternetDashboardPage().clickContinuebtn();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");
//        getInternetDashboardPage().selectRadioImmediate();
  //      getInternetDashboardPage().clickContinueOnSelectDateChange();
    //    reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");
        getRogersIgniteBundlesPage().clkImmediatebtn();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewHeader(),"Agreement has Launched","Agreement has not Launched");
        getRogersOVOrderReviewPage().clkReview();
   //     getRogersOVOrderReviewPage().clkSubmit();
     //   reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
       // reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),TestDataHandler.Serve_FWACx_UpgradeInternetPlan.getContactID(),TestDataHandler.Serve_FWACx_UpgradeInternetPlan.getAccountNo(),"Pavani.Jatla@rci.rogers.ca", "Pavani.Jatla",  method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
}

