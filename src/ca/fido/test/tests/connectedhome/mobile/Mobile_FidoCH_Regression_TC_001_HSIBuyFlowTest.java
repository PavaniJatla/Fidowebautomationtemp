package ca.fido.test.tests.connectedhome.mobile;

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
 *8. Fill in valid details in 1) Profile section
 *9. Click on Next
 *10. Fill in valid details in 2) Create account section including two IDs
 *11. Check the "Sure, lets do a Credit Evaluation" check box
 *12. Click on Confirm
 *13. Select the Service address
 *14.  Click on Confirm
 *15. Select Invoice option from dropdown list 
 *16. Click on Confirm button
 *17. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *18. Click on Submit
 *
 **/

public class Mobile_FidoCH_Regression_TC_001_HSIBuyFlowTest extends BaseTestClass {

	@Test
	public void checkInternetBuyFlow() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkkMobileNavMobile();
		fido_home_page.clkShopMobile();
		fido_home_page.clkHomeInternetMobile();
		fido_home_page.clkCheckAvailabilityMobile();
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(TestDataHandler.fidoConfig.getFidoURL(), strBrowser,strLanguage, strGroupName,  method);
	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

