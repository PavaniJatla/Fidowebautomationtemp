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
		getReporter().reportLogWithScreenshot("Rogers outlook login page has launched");
		getFidoretailerchamppage().setUsername(System.getenv("SSPUsername"));
		getReporter().reportLogWithScreenshot("Entered the username");
		getFidoretailerchamppage().clkNext();
		getReporter().reportLogWithScreenshot("sign in has launched");
		getFidoretailerchamppage().setPassword(System.getenv("SSPPassword"));
		getReporter().reportLogWithScreenshot("Entered the password");
		getFidoretailerchamppage().clkSignIn();		
		getReporter().reportLogWithScreenshot("Notice Popup has Launched"); 
		getFidoretailerchamppage().clkAccept();
		getReporter().reportLogWithScreenshot("Dealer code page has Launched");
		getFidoretailerchamppage().setDealerCode(TestDataHandler.fidoSspHSIAccount.getDealercode());		
		getReporter().reportLogWithScreenshot("Entered the Dealer code");
		getFidoretailerchamppage().clkSubmit();
		
		getReporter().hardAssert(getFidoretailerchamppage().verifyAuthorized(),"Authorized","Authorization failed");
		getReporter().reportLogWithScreenshot("SSP launchpad has launched");
		getFidoretailerchamppage().selSSPEnvironment(TestDataHandler.fidoSspHSIAccount.getSspEnv());
		getReporter().reportLogWithScreenshot("Launched the Customer Information Security Popup");
		getFidoretailershoppage().clkSecurityAccept();
		
		getReporter().hardAssert(getFidoretailerhomepage().verifyLoginBanner(),"Launched the Login Banner","Login Banner hasn't Launched");
		getReporter().reportLogWithScreenshot("SSP dashboard has launched");
		getFidoretailerhomepage().setAccountNumber(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getBan());
		getFidoretailerhomepage().setPostalCode(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getPostalCode());
		getReporter().reportLogWithScreenshot("Set the Agent account details");
		getFidoretailerhomepage().clkSearchButton();
		getReporter().hardAssert(getFidoretailersearchresultspage().verifysearchResults(),
				"Customer details are displayed", "Customer Search has failed");
		getReporter().reportLogWithScreenshot("Customer search results");
		getFidoretailersearchresultspage().clkView();
		getReporter().hardAssert(getFidoretailersearchresultspage().verifyCustomerAuthRemainder(),
				"Customer Authentication remainder popup has displayed",
				"Customer Authentication remainder popup hasn't displayed");
		getReporter().reportLogWithScreenshot("Customer Authentication remainder popup");
		getFidoretailersearchresultspage().clkContinue();
		getReporter().hardAssert(getFidoretailerhomepage().verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failed");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
		getFidointernetdashboardpage().clkUsageNService();
		getFidointernetdashboardpage().clkInternetService();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getFidointernetdashboardpage().clkManageSettings();
		getFidointernetpackagepage().clkExchangeHardware();
		getReporter().reportLogWithScreenshot("Launched modem exchange Page");
		getFidointernetpackagepage().setEquipmentSerialNumber(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getModem());
		getFidointernetpackagepage().setNewSerial(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getNewModem());
		getReporter().reportLogWithScreenshot("Exchange modem popup with old and new Modems");
		getFidointernetpackagepage().clkConfirmTheExchange();
		getReporter().reportLogWithScreenshot("Exchange modem Success popup");
		getFidointernetpackagepage().clkPrintReceipt();
		getReporter().reportLogWithScreenshot("Launched the modem receipt page");
		getReporter().hardAssert(getFidointernetpackagepage().verifyPrintReceiptLink(),"The print receipt link is preset on the receipt to print the receipt","Self serve receipt is doesn't have the print receipt link");
		getReporter().reportLogWithScreenshot("updated modem changes receipt");
		getReporter().hardAssert(getFidointernetpackagepage().verifyAcountNumberOnReceipt(TestDataHandler.fidoSspHSIAccount.getaccountDetails().getBan()),"Verified the receipt","Self serve receipt is doesn't have the right account number");
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
