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
 * This class contains the test method to test the HSI buy flow for Fido.ca   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Click on home internet under shop menu
 *3. Click on check Availability button
 *4. Enter valid address address in serviceability check pop up and click on Check availablity button.
 *5. Click on Buy online option
 *6. Select any Internet package form the list of packages available and click on Buy Now button
 *7. Click on Check out button
 *8. Fill in valid details in 1) Profile section
 *9. Click on Next
 *10. Fill in valid details in 2) Create account section including two IDs
 *11. Check the "Sure, lets do a Credit Evaluation" check box
 *12. Click on Confirm
 *13. Select the Service address
 *14.  Click on Confirm
 *15. Select Invoice option from dropdown list 
 *16. Click on Confirm button
 *17. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *18. Click on Submit
 *
 **/

public class FidoCH_Regression_TC_001_HSIBuyFlowPickupAtStoreTest extends BaseTestClass {

	@Test
	public void checkInternetBuyFlow() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
        fido_home_page.clkShop();
        fido_home_page.clkHomeInternet();
        reporter.reportLogWithScreenshot("Home Internet has selected");
        fido_Shop_internet_page.clkCheckAvailability();
        reporter.reportLogWithScreenshot("Launched the Internet Page");
        String  strAddressLine1=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        fido_Shop_internet_page.setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        fido_Shop_internet_page.clkCheckAvailabilityConfirmation();        
        reporter.reportLogWithScreenshot("Good News for the Service availability");
        fido_Shop_internet_page.clkBuyOnline();
        reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");
        fido_Shop_internet_page.verifyPlanInfomation();
        fido_cart_summary_page.clkCheckout();
        reporter.reportLogWithScreenshot("Create user page has launched to give the user information");
        fido_create_user_page.setCommunicationDetails();
        fido_create_user_page.setFirstName();
        fido_create_user_page.setLastName();
        reporter.reportLogWithScreenshot("Entered the user personal information");
        fido_create_user_page.setPhone();
        reporter.reportLogWithScreenshot("Entered the user communication information");
        fido_create_user_page.clkUserProfileNext();
        reporter.reportLogWithScreenshot("Credit evalution page has launched");
        fido_credit_check_page.selectDOBYear();
        fido_credit_check_page.selectDOBMonthSingleDigit();
        fido_credit_check_page.selectDOBDay();
        reporter.reportLogWithScreenshot("Entered the user DOB information");
        fido_credit_check_page.selectFirstIdOption("2");
        fido_credit_check_page.selectDrivingLicenseProvince("ON");
        fido_credit_check_page.selectDrivingLicenseExpiryYear();
        fido_credit_check_page.selectDrivingLicenseExpiryMonthSingleDigit();
        fido_credit_check_page.selectDrivingLicenseExpiryDay();
        fido_credit_check_page.setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Entered the Driver's License information");
        fido_credit_check_page.selectSecondIdOption("4");
        fido_credit_check_page.setPassportNumber();
        fido_credit_check_page.selectPassportExpiryYear();
        fido_credit_check_page.selectPasspoartExpiryMonth();
        fido_credit_check_page.selectPasspoartExpiryDay();
        reporter.reportLogWithScreenshot("Entered the passport information");
        fido_credit_check_page.clkCreditCheckConsent();
        reporter.reportLogWithScreenshot("Credit consent Check Done");
        fido_credit_check_page.clkCreditCheckSubmit();
        reporter.reportLogWithScreenshot("Tech-Install page has launched");
        

	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(TestDataHandler.fidoConfig.getFidoURL(), strBrowser,strLanguage, strGroupName,  method);
	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

