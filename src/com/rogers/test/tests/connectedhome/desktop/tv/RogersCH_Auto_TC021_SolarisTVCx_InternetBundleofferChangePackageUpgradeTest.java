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
 * This class contains the test method to verify the solaris bundle change package upgrade flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com url
 *2. Log into rogers.com url with valid Solaris Account credentials that has either Select or Popular bundle associated to the account/Profile
 *3. Go to Shop menu and select Ignite TV option
 *4. Go to Ignite TV bundle section, and select bundle that is higher than the current bundle and click on Add to Cart
 *5. Click on Ignite Internet speed
 *6. Go to bundle section and click on Rogers Ignite bundle that is higher price than the current bundle
 *7. Validate appropriate information is displayed in Review order page
 *8. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *9. Order confirmation page will be displayed with the order number and validate the order details
 *
 **/

public class RogersCH_Auto_TC021_SolarisTVCx_InternetBundleofferChangePackageUpgradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC021_SolarisTVCx_InternetBundleofferChangePackageUpgrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
  //      getDriver().get(System.getProperty("QaUrl")+"/bundles");
  //      reporter.reportLogWithScreenshot("Launched the IgniteTV page");
  //      getRogersHomePage().clkServiceability();
  //      reporter.reportLogWithScreenshot("Address confirmation popup has launched to select Ignite Internet speed button");
  //      getRogersHomePage().selectAddressOnFile();
   //     reporter.reportLogWithScreenshot("Address Selected");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet page");
        getRogersInternetDashboardPage().clkChangeInternetPkg();
        reporter.reportLogWithScreenshot("Launched Internet Package");
 //       getRogersBuyPage().clkIgniteInternetSpeed();
//        reporter.reportLogWithScreenshot("Launched the TV packages Page");
  //     getRogersInternetDashboardPage().clkInternetPopup();
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanEn(),TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanFr());
        getRogersInternetDashboardPage().clkInternetChangeOK();
        getRogersInternetDashboardPage().clkInternetchangebtn();
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageInternet(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateInternet();
        reporter.reportLogWithScreenshot("Agreement details");
 //       getRogersOrderReviewPage().clkSubmitUpdateInternet();
 //       reporter.reportLogWithScreenshot("Launched the Confirmation page");
 //       reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Update order completed","Update order Failed");
 //       reporter.reportLogWithScreenshot("Verified the Confirmation page");
    	}
	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() { closeSession();
	}


}


