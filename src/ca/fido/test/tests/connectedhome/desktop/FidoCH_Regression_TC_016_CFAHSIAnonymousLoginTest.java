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
 * This class contains the test method to Anonymous login for the Fido SSP
 * 
 * @author chinnarao.vattam
 * 
 *  Test steps:
 *
 *  1. Launch SSP fido.ca. 
 *  2. Enter valid credentials and Dealer code and click on Log in 
 *  3. Click on Accept 
 *  4. Select the correct environment from Select drop down list 
 *  5. Click on Home Internet menu 
 *  7. Go to Internet Package section, select any package and click on Add to Cart 
 *  8. Enter valid address under "IS the Customer new to FIDO" and click on Check Availability button
 *  9. Click on COntinue. 
 *  10. Click on Checkout 
 *  11. Enter valid information in the 1) Profile section 
 *  12. Click on Next  
 *  13. Enter appropriate/valid information in all of mandatory fields then Create account section - Check the Customer agrees to this credit check 
 *  14. Click on Confirm 
 *  15. Select the Service address
 *  16. Click on COnfirm 
 *  17. Select Invoice option from drop down list  
 *  18. Click on Confirm button  
 *  19. Scroll down to Additional agreement section, scroll all the way down and check the "I  have read ….." check box 
 *  20. Click on submit
 *
 **/

public class FidoCH_Regression_TC_016_CFAHSIAnonymousLoginTest extends BaseTestClass {

	@Test(groups = {"RegressionCH", "FidoCableRetailCH"})
	public void checkSSPhsiAnonymousLogin() {
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
		getFidoretailerhomepage().selectEnvironment(TestDataHandler.fidoSspHSIAccount.getEnvironment());
		getReporter().reportLogWithScreenshot("Shop home page has Launched");
		getReporter().hardAssert(getFidoretailerhomepage().verifyInternetPlans(), "Redirected to Fido.ca", "Redirection from retailer to Fido.ca has failed");
		getReporter().reportLogWithScreenshot("Launched the Fido.ca Home page");
        getFidoshopinternetpage().selectPlan();
        String  strAddressLine1=TestDataHandler.fidoSspHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoSspHSIAccount.getaccountDetails().getAddress().get("line2");
        getFidoshopinternetpage().setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        getReporter().reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        
        getFidoshopinternetpage().clkCheckAvailabilityConfirmation(); 
        getReporter().reportLogWithScreenshot("Good News for the Service availability");
        getFidoshopinternetpage().clkpackselectedNContinue();
        getReporter().reportLogWithScreenshot("Create user page has launched to give the user information");
        getFidocreateuserpage().setEmail();
        getFidocreateuserpage().setFirstName();
        getFidocreateuserpage().setLastName();
        getReporter().reportLogWithScreenshot("Entered the user personal information");
        getFidocreateuserpage().setPhone();
        getReporter().reportLogWithScreenshot("Entered the user communication information");
        getFidocreateuserpage().clkUserProfileNext();
        getReporter().reportLogWithScreenshot("Credit evaluation page has launched");
        getFidocreditcheckpage().selectDOBYear();
        getFidocreditcheckpage().selectDOBMonthSingleDigit();
        getFidocreditcheckpage().selectDOBDay();
        getReporter().reportLogWithScreenshot("Entered the user DOB information");
        getFidocreditcheckpage().selectFirstIdOption("2");
        getFidocreditcheckpage().selectDrivingLicenseProvince("ON");
        getFidocreditcheckpage().selectDrivingLicenseExpiryYear();
        getFidocreditcheckpage().selectDrivingLicenseExpiryMonthSingleDigit();
        getFidocreditcheckpage().selectDrivingLicenseExpiryDay();
        getFidocreditcheckpage().setDrivingLicenseNumber("ONTARIO");
        getReporter().reportLogWithScreenshot("Entered the Driver's License information");
        getFidocreditcheckpage().selectSecondIdOption("4");
        getFidocreditcheckpage().setPassportNumber();
        getFidocreditcheckpage().selectPassportExpiryYear();
        getFidocreditcheckpage().selectPasspoartExpiryMonth();
        getFidocreditcheckpage().selectPasspoartExpiryDay();
        getReporter().reportLogWithScreenshot("Entered the passport information");
        getFidocreditcheckpage().clkCreditCheckConsent();
        getReporter().reportLogWithScreenshot("Credit consent Check Done");
        getFidocreditcheckpage().clkCreditCheckSubmit();
        getReporter().reportLogWithScreenshot("Tech-Install page has launched");
        getFidotechnicalinstallationpage().clkTechInstalConfirm();      
        getReporter().reportLogWithScreenshot("Order review page has launched");
		getFidointernetpackagechangerevieworderpage().clkscrollToElement();
		getFidointernetpackagechangerevieworderpage().chkAgreementConsentCheckbox();	
		getReporter().reportLogWithScreenshot("Consent Check has Done");
		getFidointernetpackagechangerevieworderpage().clkReviewSubmitButton();
		getReporter().reportLogWithScreenshot("Order Confirmation and details page");
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order has created", "Order hasn't created");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("SSPUrl"), strBrowser,strLanguage,FidoEnums.GroupName.connectedhome_ssp,  method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
