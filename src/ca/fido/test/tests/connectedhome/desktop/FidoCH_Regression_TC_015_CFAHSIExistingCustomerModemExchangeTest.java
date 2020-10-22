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

public class FidoCH_Regression_TC_015_CFAHSIExistingCustomerModemExchangeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableRetailCH"})
	public void checkSSPhsiExistingCustomerModemExchangeTest() {
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
		reporter.hardAssert(fido_ssp_retailer_search_results_page.verifysearchResults(),
				"Customer details are displayed", "Customer Search has failed");
		reporter.reportLogWithScreenshot("Customer search results");
		fido_ssp_retailer_search_results_page.clkView();
		reporter.hardAssert(fido_ssp_retailer_search_results_page.verifyCustomerAuthRemainder(),
				"Customer Authentication remainder popup has displayed",
				"Customer Authentication remainder popup hasn't displayed");
		reporter.reportLogWithScreenshot("Customer Authentication remainder popup");
		fido_ssp_retailer_search_results_page.clkContinue();
		reporter.hardAssert(fido_ssp_retailer_home_page.verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failed");
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
		reporter.hardAssert(fido_internet_package_page.verifyPrintReceiptLink(),"The print receipt link is preset on the receipt to print the receipt","Self serve receipt is doesn't have the print receipt link");
		reporter.reportLogWithScreenshot("updated modem changes receipt");
		reporter.hardAssert(fido_internet_package_page.verifyAcountNumberOnReceipt(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getBan()),"Verified the receipt","Self serve receipt is doesn't have the right account number");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("SSPUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_ssp, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
