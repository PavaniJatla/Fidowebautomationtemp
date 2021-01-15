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
 * This class contains the test method to test the HSI buy flow for existing mobile customer   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Login with valid credentials
 *3. Click on home internet under shop menu
 *4. Click on check Availability button
 *5. Enter valid address address in serviceability check pop up and click on Check availablity button.
 *6. Click on Buy online option
 *7. Select any Internet package form the list of packages available and click on Buy Now button
 *8. Click on Check out button
 *9. Fill in valid details in 1) Profile section
 *10. Click on Next
 *11. Fill in valid details in 2) Create account section including two IDs
 *12. Check the "Sure, lets do a Credit Evaluation" check box
 *13. Click on Confirm
 *14. Select the Service address
 *15.  Click on Confirm
 *16. Select Invoice option from dropdown list 
 *17. Click on Confirm button
 *18. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *19. Click on Submit
 *
 **/

public class FidoCH_Regression_TC_008_HSIBuyFlowForWirelessCustomerTest extends BaseTestClass {

	
	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkInternetBuyFlowForExistingCustomer() {
		getReporter().reportLogWithScreenshot("Launched the Home Page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameWirelessAcc());
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the credentials");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getFidologinpage().switchOutOfSignInFrame();
		//getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
        getFidohomepage().clkShop();
        //getFidohomepage().clkHomeInternet();
        getReporter().reportLogWithScreenshot("Launched the packages Page");
        getFidoshopinternetpage().selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        getReporter().reportLogWithScreenshot("Launched the serviceability check page");
		}
	
	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login, method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

