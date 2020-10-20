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
 * This class contains the test method to validate the SSP dash board for the existing customer
 * 
 * @author chinnarao.vattam
 * 
 *  Test steps:
 *
 *  1. Load the SSP Fido URL and login with valid CFA credentials. 
 *  2. Click the Accept button in the Customer Information Security Pop -up. 
 *  3. Enter a valid BAN and Postal Code in the fields  of Agent Home Page and click on Search button. 
 *  4. Click on View button appearing on the Customer Search page. 
 *  5. Click on Continue button appearing on the Customer Authentication Reminder. 
 *  6. Click on internet badge 
 *
 **/
public class FidoCH_Regression_TC_014_CFAHSIExistingCustomerValidateDashboardTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","FidoCableRetailCH"})
	public void checkSSPhsiExistingCustomerValidateDashboardTest() {
		reporter.reportLogWithScreenshot("Rogers outlook login page has launched");
		retailer_champ_page.setUsername(System.getenv("SSPUsername"));
		reporter.reportLogWithScreenshot("Entered the username");
		retailer_champ_page.clkNext();
		reporter.reportLogWithScreenshot("sign in has launched");
		retailer_champ_page.setPassword(System.getenv("SSPPassword"));
		reporter.reportLogWithScreenshot("Entered the password");
		retailer_champ_page.clkSignIn();		
		reporter.reportLogWithScreenshot("Notice Popup has Launched"); 
		retailer_champ_page.clkAccept();
		reporter.reportLogWithScreenshot("Dealer code page has Launched");
		retailer_champ_page.setDealerCode(TestDataHandler.fidoSspHSIAccount.getDealercode());		
		reporter.reportLogWithScreenshot("Entered the Dealer code");
		retailer_champ_page.clkSubmit();
		reporter.hardAssert(retailer_champ_page.verifyAuthorized(),"Authorized","Authorization failed");
		
		reporter.reportLogWithScreenshot("SSP launchpad has launched");
		retailer_champ_page.selSSPEnvironment(TestDataHandler.fidoSspHSIAccount.getSspEnv());
		reporter.reportLogWithScreenshot("Launched the Customer Information Security Popup");
		fido_ssp_retailer_shop_page.clkSecurityAccept();
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyLoginBanner(),"Launched the Login Banner","Login Banner hasn't Launched");
		
		reporter.reportLogWithScreenshot("SSP dashboard has launched");
		fido_ssp_retailer_home_page.setAccountNumber(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getBan());
		fido_ssp_retailer_home_page.setPostalCode(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getPostalCode());
		reporter.reportLogWithScreenshot("Set the Agent account details");
		fido_ssp_retailer_home_page.clkSearchButton();	
		reporter.hardAssert(fido_ssp_retailer_search_results_page.verifysearchResults(), "Customer details are displayed", "Customer Search has failed");
		reporter.reportLogWithScreenshot("Customer search results");
		fido_ssp_retailer_search_results_page.clkView();
		reporter.hardAssert(fido_ssp_retailer_search_results_page.verifyCustomerAuthRemainder(), "Customer Authentication remainder popup has displayed", "Customer Authentication remainder popup hasn't displayed");
		reporter.reportLogWithScreenshot("Customer Authentication remainder popup");
		fido_ssp_retailer_search_results_page.clkContinue();		
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_internet_dashboard_page.clkUsageNService();
		fido_internet_dashboard_page.clkInternetService();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
     	fido_internet_dashboard_page.clkChangePackageSsp();
		reporter.reportLogWithScreenshot("Packages page has Launched");
		reporter.hardAssert(fido_internet_dashboard_page.verifylblInternetPlans(), "The internet packages are displayed ", "Failed to display the Internet packages");	
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("SSPUrl"),  strBrowser, strLanguage, FidoEnums.GroupName.connectedhome_anonymous, method);
		}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
