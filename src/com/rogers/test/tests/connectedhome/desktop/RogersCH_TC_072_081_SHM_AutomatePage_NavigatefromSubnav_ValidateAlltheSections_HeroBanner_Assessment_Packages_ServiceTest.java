package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com
 *
 * @author chinnarao.vattam
 *
 * Test steps:
 * 1.Launch Rogers SAI Tupelo URL in QA Env and click on get it now and enter address and click on continue
 * 2. Click on continue
 * 3. Choose Internet, SmartStream checkbox and click on Load offers
 * 4. Add 1 STB and click on Add to cart
 * 5. Click on Continue
 * 6. Click on Checkout
 * 7. Click on Yes, continue
 * 8. Click on Continue
 * 9. Enter DOB, valid ID details and click on continue
 * 10. Choose Installation type as enhanced self install and click on continue
 * 11. Click on Continue
 * 12. Click on Submit
 *
 **/

public class RogersCH_TC_072_081_SHM_AutomatePage_NavigatefromSubnav_ValidateAlltheSections_HeroBanner_Assessment_Packages_ServiceTest extends BaseTestClass {
    final String strLanguage=System.getProperty("Language");


  @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkShmAutomationPageDsaBillboardTest() {
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().clkHowToGetAutomatePackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");
        getRogersSecurityPackagesPage().clkSecurityPackagesByLivechat();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyIfrmLiveChatDisplayed(), "LiveChat frame is Verified", "LiveChat frame Verification is failed");
        reporter.reportLogWithScreenshot("Options to Live chat for security package Order");
        getRogersSecurityPackagesPage().switchToLivechatIFrame();
        getRogersSecurityPackagesPage().clkNoShmOption();
        reporter.reportLogWithScreenshot("Options Live chat window questions");
        getRogersSecurityPackagesPage().clkCloseLivechat();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Options to Store for security package Order");
        getRogersSecurityPackagesPage().clkSecurityPackagesFromStore();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyStorePageDisplayed(), "Store has displayed", "Store is not displayed");
        reporter.reportLogWithScreenshot("Stores page for security package Order");
        getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
        getRogersSecurityPackagesPage().clkHowToGetAutomatePackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");
        getRogersSecurityPackagesPage().clkSecurityPackagesByCall();
        reporter.reportLogWithScreenshot("Options to call CC for security package Order");
    }

   @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkShmAutomatePagePackagesTest() {
       String actualTitle = getDriver().getTitle();
       getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
       reporter.reportLogWithScreenshot("Launched the security package Home Page");

        getRogersSecurityPackagesPage().clkAutomatePackageDetails();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomatePackageDetails(), "Automate Package Details displayed", "Protect Package Details model is not displayed");
        reporter.reportLogWithScreenshot("Protect Package Details displayed");
        getRogersSecurityPackagesPage().clkPackageDetailsCloseModal();

        getRogersSecurityPackagesPage().clkHowToGetItAutomatePack();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");

        getRogersSecurityPackagesPage().clkSecurityPackagesByLivechat();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyIfrmLiveChatDisplayed(), "LiveChat frame is Verified", "LiveChat frame Verification is failed");
        reporter.reportLogWithScreenshot("Options to Live chat for security package Order");
        getRogersSecurityPackagesPage().switchToLivechatIFrame();
        getRogersSecurityPackagesPage().clkNoShmOption();
        reporter.reportLogWithScreenshot("Options Live chat window questions");
        getRogersSecurityPackagesPage().clkCloseLivechat();
        getRogersSecurityPackagesPage().clkSecurityPackagesFromStore();
        reporter.reportLogWithScreenshot("Options to Store for security package Order");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyStorePageDisplayed(), "Store has displayed", "Store is not displayed");

       getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
        getRogersSecurityPackagesPage().clkHowToGetItAutomatePack();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");
        getRogersSecurityPackagesPage().clkSecurityPackagesByCall();
        reporter.reportLogWithScreenshot("Options to call CC for security package Order");
    }


    @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkShmSecurityPageHardwareTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyViewHardware(), "View Hardware button is displayed", "View Hardware button is not displayed");
        reporter.reportLogWithScreenshot("View Hardware button");
        getRogersSecurityPackagesPage().clkViewHardware();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHardwarePage(), "View Hardware Page is displayed", "View Hardware page is not displayed");
        reporter.reportLogWithScreenshot("View Hardware page");
        getRogersSecurityPackagesPage().ViewHardwarePackages();
        reporter.reportLogWithScreenshot("View Hardware packages");
    }

    @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkShmSecurityPageSHMfeaturesTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMfeatures(), "SHM features button is displayed", "SHM features button is not displayed");
        reporter.reportLogWithScreenshot("SHM features button");
        getRogersSecurityPackagesPage().clkSHMfeatures();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMFeasturePage(), "SHM features page is displayed", "SHM features page is not displayed");
        reporter.reportLogWithScreenshot("SHM Feasture page");
        getRogersSecurityPackagesPage().ViewSHMFeasture();
        reporter.reportLogWithScreenshot("SHM Feasture packages");
    }

    @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkHomeMonitoringAppTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHomeMonitoringapp(), "Home Monitoring app button is displayed", "Home Monitoring app button is not displayed");
        reporter.reportLogWithScreenshot("Home Monitoring app button");
        getRogersSecurityPackagesPage().clkHomeMonitoringapp();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMAppPage(), "Home Monitoring app page is displayed", "Home Monitoring app page is not displayed");

        reporter.reportLogWithScreenshot("Home Monitoring app page");
        getRogersSecurityPackagesPage().ViewSHMAppPage();
        reporter.reportLogWithScreenshot("Home Monitoring app packages");
    }

    @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void check_81_ShmAutomationPageViewSecurityPackages_RedirectTopOfSecurityPackageTestTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyViewSecurityPackage(), "View Security Package button is displayed", "View Security Package button is not displayed");
        reporter.reportLogWithScreenshot("View Security Package button");
        getRogersSecurityPackagesPage().clkViewSecurityPackage();
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().ViewSecurityPackagePage();
        reporter.reportLogWithScreenshot("security packages");

    }

   @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkAutomationPageContactUsTest() {
       String actualTitle = getDriver().getTitle();
       getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
       reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkLiveChatwithRogers();
        reporter.reportLogWithScreenshot("Smart Home Monitoring Customer care");
        getRogersSecurityPackagesPage().switchToLivechatIFrame();
        getRogersSecurityPackagesPage().clkNoShmOption();
        reporter.reportLogWithScreenshot("Options Live chat window questions");
        getRogersSecurityPackagesPage().clkCloseLivechat();
        getRogersSecurityPackagesPage().clkFindRogersStore();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyStorePageDisplayed(), "Store has displayed", "Store is not displayed");
        reporter.reportLogWithScreenshot("Smart Home Monitoring Customer care");

       getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
       getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
       reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().clkSHMCustomerCare();
        reporter.reportLogWithScreenshot("Smart Home Monitoring Customer care");
    }

     @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkShmSecurityPageSubnavValidationTest() {
         String actualTitle = getDriver().getTitle();
         getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
         reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkWhySHM();
        reporter.reportLogWithScreenshot("Why SHM");
        getRogersSecurityPackagesPage().clkAutmationPack();
         getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
         reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkAutomatePackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagePage(), "View Automate Package page is displayed", "View Automate Package page is not displayed");
        reporter.reportLogWithScreenshot("Home Monitoring app page");
        getRogersSecurityPackagesPage().ViewAutomationPackagePage();
        reporter.reportLogWithScreenshot("Home Monitoring app packages");
         getRogersSecurityPackagesPage().MoveToTopOfPage();
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkSecurityPackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().ViewHardwarePackages();
        reporter.reportLogWithScreenshot("View Hardware packages");
         getRogersSecurityPackagesPage().MoveToTopOfPage();
         getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
         getRogersSecurityPackagesPage().clkProducts();
        getRogersSecurityPackagesPage().clkFeatures();
        reporter.reportLogWithScreenshot("SHM Feasture page");
         getRogersSecurityPackagesPage().clkAutmationPack();
         getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
         reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkApp();
        reporter.reportLogWithScreenshot("SHM App");
         getRogersSecurityPackagesPage().clkAutmationPack();
         getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
         reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkHelpAndSupport();
        reporter.reportLogWithScreenshot("Help And Support");
        getRogersSecurityPackagesPage().clkSHMSupport();
        reporter.reportLogWithScreenshot("SHM Support");
         getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
         getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
         reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkHelpAndSupport();
        reporter.reportLogWithScreenshot("Help And Support");
        getRogersSecurityPackagesPage().clkMovingYourServices();
        reporter.reportLogWithScreenshot("Moving Your Services");
         getRogersSecurityPackagesPage().clkAutmationPack();
        getRogersSecurityPackagesPage().clkSeefullDetails();
       reporter.reportLogWithScreenshot("full Details");
    }


    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_shmautomation, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }



}


