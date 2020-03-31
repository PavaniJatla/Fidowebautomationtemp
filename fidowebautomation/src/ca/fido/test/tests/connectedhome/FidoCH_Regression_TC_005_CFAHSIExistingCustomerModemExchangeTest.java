package ca.fido.test.tests.connectedhome;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;


/**
 * This class contains the test method to test the Modem Exchange for Existing Customer 
 * 
 * @author chinnarao.vattam
 * 
 *  Test steps:
 *
 *  1. Launch SSP fido.ca. 
 *  2. Enter valid Agent credentials and click on Log In 
 *  3. In home page, scroll down and at the footer section, enter  valid Account details and Postal code and click on Search 
 *  4. Click on Continue 
 *  5. Click on Internet badge 
 *  6. Go to Usage and Services  
 *  7. Click on Exchange hardware link
 *  8. Enter Old Serial number and New Serial number and click on Confirm 
 *  9. Click on Print Receipt button 
 *
 **/

public class FidoCH_Regression_TC_005_CFAHSIExistingCustomerModemExchangeTest extends BaseTestClass {

	@Test
	public void checkSSPhsiExistingCustomerModemExchangeTest() {
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
		fido_ssp_retailer_home_page
				.setPostalCode(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getPostalCode());
		reporter.reportLogWithScreenshot("Set the Agent account details");
		fido_ssp_retailer_home_page.clkSearchButton();
		reporter.hardAssert(fido_ssp_retailer_search_results_page.verifysearchResults(),
				"Customer details are displayed", "Customer Search has failed");
		reporter.reportLogWithScreenshot("Customer search results");
		fido_ssp_retailer_search_results_page.clkView();
		reporter.hardAssert(fido_ssp_retailer_search_results_page.verifyCustomerAuthRemainder(),
				"Customer Authentication remainder popup has displayed",
				"Customer Authentication remainder popup hasn't displayed");
		reporter.reportLogWithScreenshot("Customer Authentication remainder popup");
		fido_ssp_retailer_search_results_page.clkContinue();
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failied");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_internet_dashboard_page.clkUsageNService();
		fido_internet_dashboard_page.clkInternetService();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		fido_internet_dashboard_page.clkManageSettings();
		fido_internet_package_page.clkExchangeHardware();
		reporter.reportLogWithScreenshot("Launched modem exchange Page");
		fido_internet_package_page.setEquipmentSerialNumber(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getModem());
		fido_internet_package_page.setNewSerial(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getNewModem());
		reporter.reportLogWithScreenshot("Exchange modem popup with old and new Modems");
		fido_internet_package_page.clkConfirmTheExchange();
		reporter.reportLogWithScreenshot("Exchange modem Success popup");
		fido_internet_package_page.clkPrintReceipt();
		reporter.reportLogWithScreenshot("Launched the modem receipt page");
		reporter.hardAssert(fido_internet_package_page.verifyPrintReceiptLink(),"The print receipt link is preset on the receipt to print the receipt","Selef serve receipt is doesent have the print receipt link");
		reporter.reportLogWithScreenshot("updated modem changes receipt");
		reporter.hardAssert(fido_internet_package_page.verifyAcountNumberOnReceipt(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getBan()),"Verified the receipt","Selef serve receipt is doesent have the right account number");
	}

	@BeforeMethod
	@Parameters({ "strBrowser", "strLanguage","strGroupName" })
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.fidoConfig.getSspURL(), strBrowser,strLanguage, strGroupName,method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
