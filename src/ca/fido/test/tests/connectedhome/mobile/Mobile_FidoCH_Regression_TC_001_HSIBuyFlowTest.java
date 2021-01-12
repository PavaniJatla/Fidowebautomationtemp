package ca.fido.test.tests.connectedhome.mobile;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


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

public class Mobile_FidoCH_Regression_TC_001_HSIBuyFlowTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableMobileCH"})
	public void checkInternetBuyFlowMobile() {

		getReporter().reportLogWithScreenshot("Launched the Home Page");
		getFidohomepage().clkNavMobile();
		getReporter().reportLogWithScreenshot("Launched the Navigation card");
		getFidohomepage().clkShopMobile();
		getReporter().reportLogWithScreenshot("Launched the Navigation shop links");
		getFidohomepage().clkHomeInternetMobile();
		getFidoshopinternetpage().selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        getReporter().reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        getFidoshopinternetpage().setInternetAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        getReporter().reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getFidoshopinternetpage().clkServiceAvailabilityCheck();
        //getFidohomepage().clkCheckAvailabilityMobile();
        getReporter().reportLogWithScreenshot("Good News for the Service availability");
        getFidoshopinternetpage().clkBuyNowReskin();
        getReporter().reportLogWithScreenshot("Cart-summary Page with the selected plan");
        getFidocartsummarypage().clkInternetCheckoutMobile();
        getReporter().reportLogWithScreenshot("Create user page has launched to give the user information");
        getFidocreateuserpage().setCommunicationDetails();
        getReporter().reportLogWithScreenshot("Entered the user mail communication information");
        getFidocreateuserpage().setFirstName();
        getFidocreateuserpage().setLastName();
        getReporter().reportLogWithScreenshot("Entered the user personal information");
        getFidocreateuserpage().setPhone();
        getReporter().reportLogWithScreenshot("Entered the user mobile information");
        getFidocreateuserpage().clkUserProfileNext();
        getReporter().reportLogWithScreenshot("Credit evaluation page has launched");
        getFidocreditcheckpage().selectDOBYear();
        getFidocreditcheckpage().selectDOBMonthSingleDigit();
        getFidocreditcheckpage().selectDOBDay();
        getReporter().reportLogWithScreenshot("Entered the user DOB information");
        getFidocreditcheckpage().selectFirstIdOption("2");
        getFidocreditcheckpage().selectDrivingLicenseProvince("ON");
        getReporter().reportLogWithScreenshot("Entered the Driver's License Province");
        getFidocreditcheckpage().selectDrivingLicenseExpiryYear();
        getFidocreditcheckpage().selectDrivingLicenseExpiryMonthSingleDigit();
        getFidocreditcheckpage().selectDrivingLicenseExpiryDay();
        getReporter().reportLogWithScreenshot("Entered the Driver's License expiry details");
        getFidocreditcheckpage().setDrivingLicenseNumber("ONTARIO");
        getReporter().reportLogWithScreenshot("Entered the Driver's License number");
        getFidocreditcheckpage().selectSecondIdOption("4");
        getFidocreditcheckpage().setPassportNumber();
        getReporter().reportLogWithScreenshot("Entered the passport details");
        getFidocreditcheckpage().selectPassportExpiryYear();
        getFidocreditcheckpage().selectPasspoartExpiryMonth();
        getFidocreditcheckpage().selectPasspoartExpiryDay();
        getReporter().reportLogWithScreenshot("Entered the passport  expiry details");
        getFidocreditcheckpage().clkCreditCheckConsent();
        getReporter().reportLogWithScreenshot("Credit consent Check Done");
        getFidocreditcheckpage().clkCreditCheckSubmit();
        
        getReporter().hardAssert(getFidotechnicalinstallationpage().verifyTechInstalPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        getReporter().reportLogWithScreenshot("Tech-Install page has launched");
        getFidotechnicalinstallationpage().clkTechInstalConfirm();
        
        getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentPage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        getReporter().reportLogWithScreenshot("Payment page has launched");        
        getFidopaymentoptionspage().setCreditCardNumber(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getReporter().reportLogWithScreenshot("Set Credit Card Number"); 
        getFidopaymentoptionspage().selectExpiryMonth();
        getFidopaymentoptionspage().selectExpiryYear();
        getReporter().reportLogWithScreenshot("set Card expiry details");
        getFidopaymentoptionspage().setCVV();     
        getReporter().reportLogWithScreenshot("Set the CVV");
        getFidopaymentoptionspage().clkPaymentConfirm();    
        
        getReporter().hardAssert(getFidointernetpackagechangerevieworderpage().verifyFidoTermsAndConditions(),"Agreement has Launched","Agreement has not Launched");
        getReporter().reportLogWithScreenshot("Order review page has launched");
		getFidointernetpackagechangerevieworderpage().clkscrollToElement();
		getFidointernetpackagechangerevieworderpage().chkAgreementConsentCheckbox();
		getReporter().reportLogWithScreenshot("Consent Check has Done");
		getFidointernetpackagechangerevieworderpage().clkReviewSubmitButton();
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order has created", "Order hasn't created");
		getReporter().reportLogWithScreenshot("Order Success and order confirmation details");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_anonymous,   method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

