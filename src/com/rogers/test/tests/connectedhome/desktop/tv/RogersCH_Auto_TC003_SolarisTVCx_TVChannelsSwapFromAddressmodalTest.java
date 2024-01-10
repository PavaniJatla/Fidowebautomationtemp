package com.rogers.test.tests.connectedhome.desktop.tv;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * This class contains the test method to test the TV channels swap functionality for Rogers.com
 *
 * @author chinnarao.vattam
 * <p>
 * Test steps:
 * <p>
 * 1. Launch the Rogers.com url.
 * 2. Login with valid credentials (Solaris account credentials with TV ).
 * 3. Click on TV badge.
 * 4. Click on Exchange Flex Channels button.
 * 5. In Select Channels to remove section, select a change.
 * 6. Click  on Select in the pop up.
 * 7. In Select Channels to add section, select one  channel.
 * 8. Click  on Select in the pop up.
 * 9. Check the "Sure, lets do a Credit Evaluation" check box and click on Submit.
 * 10. Scroll down the page and click on Confirm Exchange.
 * 11. Click on Ok.
 **/

public class RogersCH_Auto_TC003_SolarisTVCx_TVChannelsSwapFromAddressmodalTest extends BaseTestClass {

    @Test(groups = {"RegressionCH", "IgniteTVDashboardCH"})
    public void rogersCH_Auto_TC003_SolarisTVCx_TVChannelsSwapFromAddressmodal() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
 /*       getDriver().get(System.getProperty("QaUrl") + "/bundles");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkServiceabilityMigration();
        reporter.reportLogWithScreenshot("Address confirmation popup has lanched to select Ignite Internet speed button");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Select Address on file Radio Button");*/
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersBuyPage().clkExchangeFlexChannel();
        reporter.reportLogWithScreenshot("TV channels pannel has displayed");
        getRogersSolarisChannelsExchangePage().verifyExchangeChannelPage();
        reporter.reportLogWithScreenshot("TV channels exchange page has launched");
        getRogersSolarisChannelsExchangePage().verifyChannelsPannel();
        reporter.reportLogWithScreenshot("TV channels pannel has displayed");

        List<WebElement> availableChannels = getRogersSolarisChannelsExchangePage().uncheckTVChannels();
        reporter.reportLogWithScreenshot("TV Channels are removed");
        getRogersSolarisChannelsExchangePage().checkTVChannels(availableChannels);
        reporter.reportLogWithScreenshot("TV Channels are added");
       /* getRogersSolarisChannelsExchangePage().swapChannelOutMobile(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapOutChannelOne());
        reporter.reportLogWithScreenshot("selected the Swap-out Channel one");
        getRogersSolarisChannelsExchangePage().clkRemoveChannel();
        reporter.reportLogWithScreenshot("removed the Swap-out Channel one");
        getRogersSolarisChannelsExchangePage().swapChannelInMobile(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapInChannelOne());
        reporter.reportLogWithScreenshot("Selected the Swap-in Channel one");
        getRogersSolarisChannelsExchangePage().clkAddChannelDifferentLogic();
        reporter.reportLogWithScreenshot("Added the Swap-in Channel one");
        getRogersSolarisChannelsExchangePage().swapChannelOutMobile(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapOutChannelTwo());
        reporter.reportLogWithScreenshot("selected the Swap-out Channel two");
        getRogersSolarisChannelsExchangePage().clkRemoveChannel();
        reporter.reportLogWithScreenshot("removed the Swap-out Channel two");
        getRogersSolarisChannelsExchangePage().swapChannelInMobile(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapInChannelTwo());
        reporter.reportLogWithScreenshot("Selected the Swap-in Channel two");
        getRogersSolarisChannelsExchangePage().clkAddChannelDifferentLogic();
        reporter.reportLogWithScreenshot("Added the Swap-in Channel two");
        getRogersSolarisChannelsExchangePage().swapChannelOutMobile(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapOutChannelThree());
        reporter.reportLogWithScreenshot("selected the Swap-out Channel three");
        getRogersSolarisChannelsExchangePage().clkRemoveChannel();
        reporter.reportLogWithScreenshot("removed the Swap-out Channel three");
        getRogersSolarisChannelsExchangePage().swapChannelInMobile(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapInChannelThree());
        reporter.reportLogWithScreenshot("Selected the Swap-in Channel three");
        getRogersSolarisChannelsExchangePage().clkAddChannelDifferentLogic();
        reporter.reportLogWithScreenshot("Added the Swap-in Channel three");*/
        getRogersSolarisChannelsExchangePage().clkConfirmSwap();

        reporter.hardAssert(getRogersSolarisChannelsExchangePage().verifyExchangeSuccess(), "Swap Success", "Swap failed");
        reporter.reportLogWithScreenshot("Swap Success popup has launched");
        getRogersSolarisChannelsExchangePage().clkReturnToDashbaord();
        reporter.reportLogWithScreenshot("Tv Dashboard has launched");

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
//login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}


