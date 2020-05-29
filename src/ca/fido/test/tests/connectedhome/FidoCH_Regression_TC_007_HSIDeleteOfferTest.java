package ca.fido.test.tests.connectedhome;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to test the delete offer flow for Fido.ca
 * 
 * @author chinnarao.vattam
 * 
 *         Test steps:
 *
 *  1. Launch fido.ca url 
 *  2. Click on home internet under shop menu. 
 *  3. Click on check Availability button. 
 *  4. Enter valid address address in service ability check pop up and click on Check availablity button. 
 *  5. Click on Buy online option 6. Select any Internet package form the list of packages available and click on Buy Now button 
 *  7. Click on Delete 
 *  8. Click on Confirm Removal.
 *
 **/

public class FidoCH_Regression_TC_007_HSIDeleteOfferTest extends BaseTestClass {

	@Test
	public void checkDeleteOffer() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkEasylogin();
		fido_home_page.clkShop();
		fido_home_page.clkHomeInternet();
		reporter.reportLogWithScreenshot("Home Internet has selected");
		fido_Shop_internet_page.clkCheckAvailability();
		reporter.reportLogWithScreenshot("Launched the Internet Page");
		String strAddressLine1 = (String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
		String strAddressLine2 = (String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
		fido_Shop_internet_page.setAddressLookup(strAddressLine1 + ", " + strAddressLine2 + ", CANADA");
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		fido_Shop_internet_page.clkCheckAvailabilityConfirmation();
		reporter.reportLogWithScreenshot("Good News for the Service availability");
		fido_Shop_internet_page.clkBuyOnline();
		reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");
		fido_Shop_internet_page.verifyPlanInfomation();
		reporter.reportLogWithScreenshot("Selected Plan information");
		fido_cart_summary_page.clkShoppingCartDelete();
		reporter.reportLogWithScreenshot("Removal confirm popup");
		fido_cart_summary_page.clkConfirmRemovalOfCart();
		reporter.reportLogWithScreenshot("Cart-summary Page with deleted package");
		reporter.hardAssert(fido_cart_summary_page.verifyEmptyCart(), "Delete cart Passed", "Delete cart Failed");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage" ,"strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage,String strGroupName, ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.fidoConfig.getFidoURL(),strBrowser,strLanguage, strGroupName,method);

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
