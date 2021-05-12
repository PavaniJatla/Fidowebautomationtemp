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

public class FidoCH_Regression_TC_006_HSIServiceabilityLiveChatTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkHSIServiceabilityLiveChatFlow() {
/*		getReporter().reportLogWithScreenshot("Launched the Home Page");
        getFidohomepage().clkShop();
        getFidohomepage().clkHomeInternet();*/
        getReporter().reportLogWithScreenshot("Home Internet has selected");

        getFidoshopinternetpage().clkLiveChat();
		getReporter().hardAssert(getFidoshopinternetpage().verifyLiveChat(), "Live chat frame has opened", "Live chat frame hasn't opened");
        getReporter().reportLogWithScreenshot("Launched Live chat model");
        getFidoshopinternetpage().clkCloseChat();
		getReporter().hardAssert(getFidoshopinternetpage().verifyBcHeadMenu(),"Live close Menu", "Live close Menu is Failed");
		getReporter().reportLogWithScreenshot("Launched Live close Menu");
        getFidoshopinternetpage().clkCloseChatConfirm();
		getReporter().softAssert(!getFidoshopinternetpage().verifyLiveChat(), "Live chat frame has closed", "Live chat frame hasn't closed");
        getReporter().reportLogWithScreenshot("Service availability confirm Popup");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_anonymous,  method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}

