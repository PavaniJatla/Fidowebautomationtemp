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
 * This class contains the test method to test the Modem Return for Existing Customer 
 * 
 * @author chinnarao.vattam
 * 
 *  Test steps:
 *
 *  1. Launch SSP fido.ca. 
 *  2. Enter valid Agent credentials and click on Log In 
 *  3. In home page, scroll down and at the footer section, enter  valid Account details and Postal code and click on Search 
 *  4. Click on Continue button appearing on the Customer Authentication Reminder. 
 *  5. Click on view order details link.
 *  6. Click on return modem link.  
 *  7. Enter the modem serial number.
 *  8. Click on complete order button 
 *  9. Click on Print receipt button 
 *
 **/


public class FidoCH_Regression_TC_015_CFAHSIExistingCustomerModemReturnTest extends BaseTestClass {

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
		reporter.softAssert(fido_ssp_retailer_home_page.verifyInternet(), "Redirected to  Shop home page", "Shop home page Redirection has failed");
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
		fido_account_overview_page.clkInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");

	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.chConfig.getSspURL(),  strBrowser, strLanguage, FidoEnums.GroupName.connectedhome_anonymous, method);
		}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
