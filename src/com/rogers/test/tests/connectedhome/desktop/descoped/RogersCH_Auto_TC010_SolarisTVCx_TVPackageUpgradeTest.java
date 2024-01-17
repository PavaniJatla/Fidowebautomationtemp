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
 * This class contains the test method to verify the solaris TV package upgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on a TV account
 *4. Click on chage package button
 *5. Choose a tv package whose price is higher than the current package and click on Submit
 *6. Scroll down to the last in the page and Click on Checkout
 *7. Enter appropriate Contact details
 *8. Pick a date time in step 2 - Most Convenient Time for us to call
 *9. Click on Continue
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit
 *
 **/

public class RogersCH_Auto_TC010_SolarisTVCx_TVPackageUpgradeTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","TVPlanUpgardeCH"})
    public void rogersCH_Auto_TC010_SolarisTVCx_TVPackageUpgrade()
    {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc14_SolarisTVAccountFlex5Package.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc14_SolarisTVAccountFlex5Package.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc14_SolarisTVAccountFlex5Package.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");

        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc10_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.tc10_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanFr());
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackagePopupHeader(),"Verified the Change TV Package Popup Header","Change TV Package Popup Header is not verified");
      //  reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageModalContentHeader(),"Verified the Change Package modal content header", "Change Package Modal content header is not matching");
       // reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageModalContent(),"Verified the Change Package modal content", "Change Package Modal content is not matching");
      //  reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageCancelBtn(),"Verified Change TV Package cancel button", "Cancel button verification failed");
        getRogersSolarisTVDashboardPage().clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLater();
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueFromThemepacks();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
  //      getRogersSolarisTVChannelsAndThemepacksPage().clkYesIHave4K();
//        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
//        getRogersSolarisTVChannelsAndThemepacksPage().clk4KContent();
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");;
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdate();
        reporter.reportLogWithScreenshot("Agreement details");
   //     getRogersOrderReviewPage().clkSubmitUpdateTV();
   //     reporter.reportLogWithScreenshot("Launched the Confirmation page");
   //     reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
   //     reporter.reportLogWithScreenshot("Verified the Confirmation page");
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

