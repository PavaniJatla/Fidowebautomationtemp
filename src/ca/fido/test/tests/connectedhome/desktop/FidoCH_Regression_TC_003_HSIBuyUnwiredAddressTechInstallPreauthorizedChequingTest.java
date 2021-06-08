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
 * This class contains the test method to test the HSI buy flow with un-wired address, tech-install and preauthorized chequing for Fido.ca
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Click on internet link.
 *2. Choose an offer and click on Add to Cart button.
 *3. Enter the unwired address in serviceability check overlay and click on search lens.
 *4. Click continue button in the overlay.
 *5. Click on checkout button in shopping cart summary page.
 *6. Select/fill required details in create profile page and click next.
 *7. Select/fill required details in credit check page and click next.
 *8. Select tech install as the fulfillment option, fill the required details and click next.
 *9. Select pre-authorized chequing as the payment option, fill in the required details and click next.
 *10. Click on edit option for package in review page.
 *11. Change your internet package and click next.
 *12. Click checkout in shopping cart summary page.
 *13. Select the checkbox for terms and conditions and click submit.
 *14.  Verify that order number is shown in the order confirmation page.
 *15. Verify that order is reflected in the My Account section. 
 *
 **/

public class FidoCH_Regression_TC_003_HSIBuyUnwiredAddressTechInstallPreauthorizedChequingTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableBuyCH"})
	public void checkBuyUnwiredAddressTechInstallPreauthorizedChequingTest() {
        getReporter().reportLogWithScreenshot("Launched the packages Page");
        getFidoshopinternetpage().selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        getReporter().reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
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
        getReporter().reportLogWithScreenshot("Credit evalution page has launched");
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
        getReporter().reportLogWithScreenshot(" selected the slot for Tech-Instal");
        getFidotechnicalinstallationpage().clkTechInstalConfirm();
        getReporter().reportLogWithScreenshot("Payment page has launched");
        getFidopaymentoptionspage().setCreditCardNumber(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getFidopaymentoptionspage().selectExpiryMonth();
        getFidopaymentoptionspage().selectExpiryYear();
        getFidopaymentoptionspage().setCVV();
        getReporter().reportLogWithScreenshot("Payment details has set");
        getFidopaymentoptionspage().clkPaymentConfirm();
        getReporter().reportLogWithScreenshot("Order review page has launched");
        getReporter().hardAssert(getFidointernetpackagechangerevieworderpage().verifyFidoTermsAndConditions(), "Terms And Conditions are verifed", "Terms And Conditions verification has failed");
		getFidointernetpackagechangerevieworderpage().clkscrollToElement();
		getFidointernetpackagechangerevieworderpage().chkAgreementConsentCheckbox();
		getReporter().reportLogWithScreenshot("Consent Check has Done");
		getFidointernetpackagechangerevieworderpage().clkReviewSubmitButton();
		getReporter().reportLogWithScreenshot("Order Success and order confirmation details");
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order has created", "Order hasn't created");
		getReporter().reportLogWithScreenshot("Order details");
	}
	


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,FidoEnums.GroupName.connectedhome_anonymous, method);

	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

