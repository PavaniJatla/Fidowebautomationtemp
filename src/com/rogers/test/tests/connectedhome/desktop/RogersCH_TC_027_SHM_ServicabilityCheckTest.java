package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
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

public class RogersCH_TC_027_SHM_ServicabilityCheckTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","RhpAndRhmCH"})
    public void checkServicabilityRHMTest() throws InterruptedException {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	getRogersHomePage().clkShop();
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Home Monitering");
    	getRogersHomePage().clkHomeMonitering();
    	reporter.reportLogWithScreenshot("Launched the Home Monitering packages page");
    	getRogersBuyPage().selectHomeMoniteringPackage(TestDataHandler.tc27_28_RogersSHM.getAccountDetails().getRhmPackageEn(),TestDataHandler.tc27_28_RogersSHM.getAccountDetails().getRhmPackageFr());
        String  strAddressLine1=TestDataHandler.tc27_28_RogersSHM.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc27_28_RogersSHM.getAccountDetails().getAddress().get("line2");
        getRogersBuyPage().setAddressLookup(strAddressLine1+", "+strAddressLine2);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
    	getRogersBuyPage().clkAddressLookupSubmit();
    	reporter.hardAssert(getRogersLegacyBundleBuyPage().verifyServiceabilitySuccess(),"Displayed the serviceabilty sucess popup for RHM", "RHM is not serviceble in the given address");
    	reporter.reportLogWithScreenshot("Serviceability Success popup");
    }


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws  IOException  {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacyanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

