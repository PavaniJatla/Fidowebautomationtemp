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

public class FidoCH_Regression_TC_001_HSIServiceabilityModalforServiceUnavailableAddressTest extends BaseTestClass {

	
	
	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void serviceabilityModalforServiceUnavailableAddressTest() {
        getReporter().reportLogWithScreenshot("Launched the packages Page");
        //getFidoshopinternetpage().selectInternetPlan(TestDataHandler.fidoHSIUnavailableAddress.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIUnavailableAddress.getaccountDetails().getUpgradePlanCost());
        getFidoshopinternetpage().select150InternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan());
        getReporter().reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1=TestDataHandler.fidoHSIUnavailableAddress.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoHSIUnavailableAddress.getaccountDetails().getAddress().get("line2");
        getFidoshopinternetpage().setInternetAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        getReporter().reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getFidoshopinternetpage().clkServiceAvailabilityCheck();        
        getReporter().reportLogWithScreenshot("Service is unavailability");
        getReporter().hardAssert(getFidoshopinternetpage().verifyIconUnavailable(),"Service is unavailability","Service is availability");
        getFidoshopinternetpage().verifyIconCustomercare();
        getFidoshopinternetpage().clkCheckAnotherAddress();
        getReporter().reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getReporter().hardAssert(getFidoshopinternetpage().verifyAvailabilityCheck(),"Displayed to check the Service availability","Check Another Address is not working");
   	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_anonymous,method);

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
