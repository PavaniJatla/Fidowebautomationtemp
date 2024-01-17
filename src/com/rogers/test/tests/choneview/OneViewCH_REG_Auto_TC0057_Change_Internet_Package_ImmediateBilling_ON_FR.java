package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
/*
"1. Language - FR
2. Province - ON
3. Change Type - Change Internet. (Upgrade)
4. Add-Ons - NA
5. Bill Cycle - Immediate"
ON
 */
public class OneViewCH_REG_Auto_TC0057_Change_Internet_Package_ImmediateBilling_ON_FR extends BaseTestClass {
    @Test(groups = {"Baseline","ChangePackage"})
    public void oneViewCH_Auto_TC0057_Internet_PackageUpgrade_ImmediateBilling_ON_FR() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getBan(),  TestDataHandler.TC030_Internet_PackageUpgrade.getContactID() );
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().setLanguageFrench();
        reporter.reportLogWithScreenshot("switched to French Language");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Internet Badge selected");
        getInternetDashboardPage().clkProductionbtn();
        reporter.reportLogWithScreenshot("Click Production button");
        getInternetDashboardPage().clkProceedbtn();
        reporter.reportLogWithScreenshot("Click Proceed button");
        getInternetDashboardPage().clickChangePackageButton();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");

        getInternetDashboardPage().clkOffersbutton();
        reporter.reportLogWithScreenshot("Click Offers Button");
        getInternetDashboardPage().clickSelectbutton();
        reporter.reportLogWithScreenshot("Internet Package selected for upgrade");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");
 //       getRogersIgniteBundlesPage().clickExchangeLater();
        getRogersIgniteBundlesPage().clkImmediatebtn();
        getRogersIgniteBundlesPage().clkContinue();
 /*       getRogersIgniteBundlesPage().noTo4KTVPopup();
        getInternetDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("select immediate bill");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked");*/
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewHeader(),"Agreement has Launched","Agreement has not Launched");
        getRogersOVOrderReviewPage().clkReview();
    //  getRogersOVOrderReviewPage().clkSubmit();
        //reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        //reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),TestDataHandler.TC030_Internet_PackageUpgrade.getContactID(), TestDataHandler.TC030_Internet_PackageUpgrade.getAccountNo(), "Pavani.Jatla@rci.rogers.ca", "Pavani.Jatla", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }

}

