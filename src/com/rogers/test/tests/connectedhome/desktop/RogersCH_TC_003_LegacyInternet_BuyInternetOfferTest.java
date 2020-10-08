package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
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
 *
 *1. Launch Rogers.com
 *2. Browser to Shop menu and select Bundle option
 *3. Scroll down to  Bundles section and click on How to Get it button for a Bundle
 *4. Enter home address to validate the serviceability and click on Check button
 *5. Verify the customer care contact popup
 *
 **/

public class RogersCH_TC_003_LegacyInternet_BuyInternetOfferTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","LegacyTVFlowsCH"})
    public void checkBuyInternetOffer() throws InterruptedException {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	rogers_home_page.clkExistingCustomerShop();
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy Internet");
    	rogers_home_page.clkInternet();
    	reporter.reportLogWithScreenshot("Launched the legacy Internet packages page");
    	rogers_buy_page.selectInternetPackage(TestDataHandler.legacyInternetAccount.getAccountDetails().getInternetBundle());
        String  strAddressLine1=TestDataHandler.legacyInternetAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.legacyInternetAccount.getAccountDetails().getAddress().get("line2");
        rogers_buy_page.setAddressLookup(strAddressLine1+", "+strAddressLine2);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
    	rogers_buy_page.clkAddressLookupSubmit(); 
    	reporter.reportLogWithScreenshot("Customer care contact popup has displayed");
    	reporter.hardAssert(rogers_legacy_bundle_buy_page.verifyServiceabilitySuccess(),"Displayed the popup for Contact Customer care For Legacy Internet Bundle Buy", "Customer care popup hasn't dispaly");
    	}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacyanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


