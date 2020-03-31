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
public class FidoCH_Regression_TC_013_CFAHSIExistingCustomerValidateDashboardTest extends BaseTestClass {

	@Test(invocationCount = 1)
	public void checkSSPhsiExistingCustomerValidateDashboardTest() {
		reporter.reportLogWithScreenshot("Launched the SSP SignIn Page");
		fido_ssp_retailer_shop_page.setUserName(TestDataHandler.fidoSspHSIAccount.getUsername());
		fido_ssp_retailer_shop_page.setPassword(TestDataHandler.fidoSspHSIAccount.getPassword());
		fido_ssp_retailer_shop_page.setDealerCode(TestDataHandler.fidoSspHSIAccount.getDealercode());
		reporter.reportLogWithScreenshot("Entered the Authentication details");
		fido_ssp_retailer_shop_page.clkLogin();	
		reporter.reportLogWithScreenshot("Launched the Customer Information Security Popup");
		fido_ssp_retailer_shop_page.clkSecurityAccept();
		fido_ssp_retailer_home_page.clkSkip();
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
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failied");		
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_account_overview_page.clkInternetBadgeSsp();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
     	fido_internet_dashboard_page.clkChangePackageSsp();
		reporter.reportLogWithScreenshot("Packages page has Launched");
		reporter.hardAssert(fido_internet_dashboard_page.verifylblInternetPlans(), "The internet packages are displayed ", "Failed to display the Internet packages");	
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.fidoConfig.getSspURL(),  strBrowser, strLanguage, strGroupName,method);
		}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
