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

	@Test(groups = {"RegressionCH","FidoCableRetailCH"})
	public void checkSSPhsiExistingCustomerValidateDashboardTest() {
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
		getReporter().hardAssert(getFidoretailersearchresultspage().verifysearchResults(), "Customer details are displayed", "Customer Search has failed");
		getReporter().reportLogWithScreenshot("Customer search results");
		getFidoretailersearchresultspage().clkView();
		getReporter().hardAssert(getFidoretailersearchresultspage().verifyCustomerAuthRemainder(), "Customer Authentication remainder popup has displayed", "Customer Authentication remainder popup hasn't displayed");
		getReporter().reportLogWithScreenshot("Customer Authentication remainder popup");
		getFidoretailersearchresultspage().clkContinue();		
		getReporter().hardAssert(getFidoretailerhomepage().verifyFidoHomeInternet(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failed");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
		getFidointernetdashboardpage().clkUsageNService();
		getFidointernetdashboardpage().clkInternetService();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
     	getFidointernetdashboardpage().clkChangePackageSsp();
		getReporter().reportLogWithScreenshot("Packages page has Launched");
		getReporter().hardAssert(getFidointernetdashboardpage().verifylblInternetPlans(), "The internet packages are displayed ", "Failed to display the Internet packages");	
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("SSPUrl"),  strBrowser, strLanguage, FidoEnums.GroupName.connectedhome_ssp, method);
		}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
