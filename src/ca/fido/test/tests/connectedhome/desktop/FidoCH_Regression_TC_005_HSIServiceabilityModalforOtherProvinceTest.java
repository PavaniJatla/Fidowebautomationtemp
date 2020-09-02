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

public class FidoCH_Regression_TC_005_HSIServiceabilityModalforOtherProvinceTest extends BaseTestClass {

	
	
	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkDeleteOffer() {
		reporter.reportLogWithScreenshot("Launched Easy login Page");
		fido_home_page.clkEasylogin();
		reporter.reportLogWithScreenshot("Launched the Home Page");
        fido_home_page.clkShop();
        fido_home_page.clkHomeInternet();
        reporter.reportLogWithScreenshot("Launched the packages Page");
        fido_Shop_internet_page.selectInternetPlan(TestDataHandler.fidoHSIAnotherProvinceAddress.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        reporter.reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1=(String) TestDataHandler.fidoHSIAnotherProvinceAddress.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.fidoHSIAnotherProvinceAddress.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setInternetAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkServiceAvailabilityCheck();        
        reporter.reportLogWithScreenshot("Service is Unavailabile");
        reporter.hardAssert(fido_Shop_internet_page.verifyUnavailableInProvince(),"Service is unavailability in the given province","Service is availability");
        fido_Shop_internet_page.verifyCancel();
        fido_Shop_internet_page.verifyYes();
        fido_Shop_internet_page.clkCancel();
        reporter.reportLogWithScreenshot("Launched the packages Page");
        reporter.hardAssert(fido_Shop_internet_page.verifyPackagesPage() ,"Packages Page has launched","Packages Page hasn't launched");
        fido_Shop_internet_page.selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        reporter.reportLogWithScreenshot("Launched the serviceability check page");
        fido_Shop_internet_page.setInternetAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkServiceAvailabilityCheck();        
        reporter.reportLogWithScreenshot("Service is Unavailabile");
        reporter.hardAssert(fido_Shop_internet_page.verifyUnavailableInProvince(),"Service is unavailability in the given province","Service is availability");
        fido_Shop_internet_page.verifyCancel();
        fido_Shop_internet_page.verifyYes();
        fido_Shop_internet_page.clkYes();
        reporter.hardAssert(!fido_Shop_internet_page.verifyPackagesPage() ,"Packages Page hasn't launched","Packages Page has launched");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage" })
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
