package ca.fido.test.tests.connectedhome.desktop;

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
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to test the HSI buy flow for Fido.ca   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Click on home internet under shop menu
 *3. Click on check Availability button
 *4. Enter valid address address in serviceability check pop up and click on Check availablity button.
 *5. Click on Buy online option
 *6. Select any Internet package form the list of packages available and click on Buy Now button
 *7. Click on Check out button
 *
 **/

public class FidoCH_Regression_TC_001_HSIServiceabilityLiveChatTest extends BaseTestClass {

	@Test
	public void checkHSIServiceabilityLiveChatFlow() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
        fido_home_page.clkShop();
        fido_home_page.clkHomeInternet();
        reporter.reportLogWithScreenshot("Home Internet has selected");
        fido_Shop_internet_page.clkCheckAvailability();
        reporter.reportLogWithScreenshot("Launched the Internet Page");
        String  strAddressLine1=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkCheckAvailabilityConfirmation(); 
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_Shop_internet_page.clkLiveChat();
        fido_Shop_internet_page.verifyLiveChat();
        reporter.reportLogWithScreenshot("Launched Live chat frame");
        fido_Shop_internet_page.clkMinimizeChat();
        reporter.reportLogWithScreenshot("Live chat frame has minimized");
        fido_Shop_internet_page.clkMaximizeChat();
        reporter.reportLogWithScreenshot("Launched Live chat frame");
        fido_Shop_internet_page.clkCloseChat();
        fido_Shop_internet_page.clkCloseChatConfirm();
		reporter.softAssert(!fido_Shop_internet_page.verifyLiveChat(), "Live chat frame has closed", "Live chat frame hasn't closed");
        reporter.reportLogWithScreenshot("Service availability confirm Popup");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(TestDataHandler.fidoConfig.getFidoURL(), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_anonymous,  method);
	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

