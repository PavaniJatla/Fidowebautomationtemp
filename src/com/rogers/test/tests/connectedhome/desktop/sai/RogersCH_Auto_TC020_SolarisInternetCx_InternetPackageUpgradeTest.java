package com.rogers.test.tests.connectedhome.desktop.sai;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



/**
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class RogersCH_Auto_TC020_SolarisInternetCx_InternetPackageUpgradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC020_SolarisInternetCx_InternetPackageUpgrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
//        getRogersInternetDashboardPage().clkInternetPopup();
        reporter.reportLogWithScreenshot("Launched the Interent dashboard");
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Interent packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getUpgradePlanEn(), TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the agreement page");
        getRogersInternetDashboardPage().clkInternetChangeOK();
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageInternet(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateInternet();
        reporter.reportLogWithScreenshot("Agreement details");
//        getRogersOrderReviewPage().clkSubmitUpdateInternet();
  //      reporter.reportLogWithScreenshot("Launched the Confirmation page");
  //      reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Update order completed", "Update order Failed");
  //      reporter.reportLogWithScreenshot("Verified the Confirmation page");
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

