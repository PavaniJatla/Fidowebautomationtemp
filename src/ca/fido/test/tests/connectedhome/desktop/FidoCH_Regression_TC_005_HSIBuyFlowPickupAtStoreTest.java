package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

import static ca.fido.testdatamanagement.TestDataHandler.chPaymentInfo;
import static ca.fido.testdatamanagement.TestDataHandler.fidoHSIAccount;


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

public class FidoCH_Regression_TC_005_HSIBuyFlowPickupAtStoreTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkHSIBuyFlowPickupAtStoreFlow() {
		getReporter().reportLogWithScreenshot("Launched the Home Page");
        getFidohomepage().clkShop();
        getFidohomepage().clkHomeInternet();
        getReporter().reportLogWithScreenshot("Launched the packages Page");
        getFidoshopinternetpage().selectInternetPlan(fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(), fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        getReporter().reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1= fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        getFidoshopinternetpage().setInternetAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        getReporter().reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getFidoshopinternetpage().clkServiceAvailabilityCheck();        
        getReporter().reportLogWithScreenshot("Good News for the Service availability");
        getFidoshopinternetpage().clkBuyNowReskin();
        getReporter().reportLogWithScreenshot("Cart-summary Page with the selected plan");       
        getFidocartsummarypage().clkInternetCheckout();              
        getReporter().reportLogWithScreenshot("Create user page has launched to give the user information");
        getFidocreateuserpage().setCommunicationDetails();
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
        getFidotechnicalinstallationpage().clkPickUpAtStore();
        getReporter().reportLogWithScreenshot("Pickup at store option has launched");
        String  strAddressStore=fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        getFidotechnicalinstallationpage().setAddressLookup(strAddressStore+", CANADA");
        getReporter().reportLogWithScreenshot("new Pickup store location");
        getFidotechnicalinstallationpage().clkPickStoreConsent();
        getFidotechnicalinstallationpage().clkTechInstalConfirm();
        getReporter().reportLogWithScreenshot("Payment page has launched");        
        getFidopaymentoptionspage().setCreditCardNumber(chPaymentInfo.getCreditCardDetails().getNumber());
        getFidopaymentoptionspage().selectExpiryMonth();
        getFidopaymentoptionspage().selectExpiryYear();
        getFidopaymentoptionspage().setCVV();     
        getReporter().reportLogWithScreenshot("Payment details has set");
        getFidopaymentoptionspage().clkPaymentConfirm();        
        getReporter().reportLogWithScreenshot("Order review page has launched");
        getReporter().hardAssert(getFidointernetpackagechangerevieworderpage().verifyFidoTermsAndConditions(), "Terms And Conditions are verified", "Terms And Conditions verification has failed");
		getFidointernetpackagechangerevieworderpage().clkscrollToElement();
		getFidointernetpackagechangerevieworderpage().chkAgreementConsentCheckbox();
		getReporter().reportLogWithScreenshot("Consent Check has Done");
		getFidointernetpackagechangerevieworderpage().clkReviewSubmitButton();
		getReporter().reportLogWithScreenshot("Order Success and order confirmation details");
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order has created", "Order hasn't created");
		getReporter().reportLogWithScreenshot("Order details");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_anonymous,  method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

