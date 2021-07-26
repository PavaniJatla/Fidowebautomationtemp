package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browser to Shop menu and select Bundle option
 *3. Scroll down to  Bundles section and click on How to Get it button for a Bundle
 *4. Enter home address to validate the serviceability and click on Check button
 *5. Verify the customer care contact popup
 *
 **/

public class RogersCH_TC_091_SAI_InvalidPromocode_OrganicFlowViaSAI_ValidateErrorMessageTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH"})
    public void checkOrganicFlowViaSAI_ValidateErrorMessageTest() throws InterruptedException {
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy Internet");
        getRogersHomePage().clkEasyInternet();
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyPromoCodeButton(),"Promo Code Button has displayed","Promo Code Button has not displayed");
        getRogersInternetPackageSelectionPage().clkPromoCode();
        reporter.reportLogWithScreenshot("Promo Code Button");
        getRogersInternetPackageSelectionPage().setIgniteAddressLookup("ABCDEF");
        reporter.reportLogWithScreenshot("Promo Code entered");
        getRogersInternetPackageSelectionPage().clkPromoCodeCheck();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyPromoCodeError(),"Promo Code Error has displayed","Promo Code validation has failed");
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}

