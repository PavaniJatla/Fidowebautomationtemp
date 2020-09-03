package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the delete offer flow for Fido.ca   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Click on home internet under shop menu.
 *3. Click on check Availability button.
 *4. Enter valid address address in serviceability check pop up and click on Check availablity button.
 *5. Click on Buy online option
 *6. Select any Internet package form the list of packages available and click on Buy Now button
 *7. Click on Edit
 *8. Select any Internet package form the list of packages available and click on Buy Now button
 *9. Click on Update Cart
 *
 **/

public class FidoCH_Regression_TC_008_HSIEditfromCartTest extends BaseTestClass {
	
	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkEditfromCart()  {
		reporter.reportLogWithScreenshot("Launched Easy login Page");
		fido_home_page.clkEasylogin();
		reporter.reportLogWithScreenshot("Launched the Home Page");
        fido_home_page.clkShop();
        fido_home_page.clkHomeInternet();
        reporter.reportLogWithScreenshot("Launched the Internet Page");
        fido_Shop_internet_page.clkCheckAvailability();
        String  strAddressLine1=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkCheckAvailabilityConfirmation();
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_Shop_internet_page.clkBuyOnline();
        reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");
        fido_Shop_internet_page.selectPlanforEdit();
        reporter.reportLogWithScreenshot("Selected Plan information");
        fido_cart_summary_page.clkShoppingCartEdit();
        reporter.reportLogWithScreenshot("Internet Page to reselect new plan");
        fido_Shop_internet_page.selectNewPlan();
        reporter.reportLogWithScreenshot("Confirm Internet Package Update Popup to confiram the new plan");     
        fido_Shop_internet_page.clkUpdateCart(); 
        reporter.reportLogWithScreenshot("Cart-summary Page with the upgarded package");
        reporter.hardAssert(fido_Shop_internet_page.verifyDownloadSpeed(TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost()), "Edit cart Passed", "Edit cart Failed");      
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,FidoEnums.GroupName.connectedhome_anonymous ,method);
	

	}

	
@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

