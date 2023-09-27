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
 * This class contains the test method to test the HSI buy flow and edit the internet package from order review page for Fido.ca   
 * Manual_Fido UTE_Regression_CX Anonymous_HSI Buy flow for an unwired address with Tech install as the Fulfillment option Pre-authorized chequing as payment method - From Review page edit the package
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Click on home internet under shop menu
 *3. Click on check Availability button
 *4. Enter valid address in serviceability check pop up and click on Check availablity button.
 *5. Click on Buy online option
 *6. Select any Internet package form the list of packages available and click on Buy Now button
 *7. Click on Check out button
 *8. Fill in valid details in 1) Profile section
 *9. Click on Next
 *10. Fill in valid details in 2) Create account section including two IDs
 *11. Check the "Sure, lets do a Credit Evaluation" check box
 *12. Click on Confirm
 *13. Select the Service address
 *14. Click on Confirm
 *15. Select PAC option from dropdown list and enter details
 *16. Click on Confirm button
 *17. On Review page, click on edit package
 *18. Select the package of your choice
 *19. Click on checkout
 *20. Click on Continue on Tech Install page
 *21. Verify order review page
 *22. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *23. Click on Submit
 *
 **/

public class FidoCH_ERM_TC01_HSIBuyFlow_Unwired_PAC_ReviewPageEditThePackageTest extends BaseTestClass {
	@Test(groups = {"ERM"})
	public void fidoCH_ERM_TC01_HSIBuyFlow_Unwired_PAC_ReviewPageEditThePackage() {
        getReporter().reportLogWithScreenshot("Launched the packages Page");
        getFidoshopinternetpage().selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
        getReporter().reportLogWithScreenshot("Launched the serviceability check page");
        String  strAddressLine1=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.fidoHSIAccount.getaccountDetails().getAddress().get("line2");
        getFidoshopinternetpage().setInternetAddressLookup(strAddressLine1+", "+strAddressLine2);
        getReporter().reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getFidoshopinternetpage().clkServiceAvailabilityCheck();
        getReporter().reportLogWithScreenshot("Multiple Address Popup is displayed");
        if(getFidoshopinternetpage().veriyMultipleAddressModal()) {
            getFidoshopinternetpage().clkContinueMultipleAddressPopup();
            getReporter().reportLogWithScreenshot("Continue to Good News Modal");
        }
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
        getFidotechnicalinstallationpage().clkTechInstalConfirm();
        getReporter().reportLogWithScreenshot("Payment page has launched");
        getFidopaymentoptionspage().selectPaymentMode("Pre-Authorized Chequing");
        getReporter().reportLogWithScreenshot("Payment Option PAC");
        getFidopaymentoptionspage().setBankTransitCode(TestDataHandler.chPaymentInfo.getBankDetails().getTransitCode());
        getFidopaymentoptionspage().setBankCode(TestDataHandler.chPaymentInfo.getBankDetails().getBankCode());
        getFidopaymentoptionspage().setAccountNumberOnBuyFlow(TestDataHandler.chPaymentInfo.getBankDetails().getAccountNumber());
        getReporter().reportLogWithScreenshot("Payment details has set");
        getFidointernetpackagechangerevieworderpage().clkscrollToEndOfAgreement();
        getReporter().reportLogWithScreenshot("Scroll to end of agreement");
        getFidointernetpackagechangerevieworderpage().chkConsentCheckboxPAC();
        getReporter().reportLogWithScreenshot("Check PAC Consent");
        getFidopaymentoptionspage().clkPaymentConfirm();
        getReporter().reportLogWithScreenshot("Order review page has launched");
        getReporter().hardAssert(getFidointernetpackagechangerevieworderpage().verifyFidoTermsAndConditions(), "Terms And Conditions are verified", "Terms And Conditions verification has failed");
        getFidointernetpackagechangerevieworderpage().clickEditPackage();
        getReporter().reportLogWithScreenshot("Clicked Edit Package on Review page");
        getFidointernetpackagechangerevieworderpage().clickYesOnEditPaymentOverLay();
        getReporter().reportLogWithScreenshot("Clicked yes to edit package");
        getFidoshopinternetpage().select150InternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan());
        getReporter().reportLogWithScreenshot("Selected another internet package");
        getReporter().reportLogWithScreenshot("Cart-summary Page with the selected plan");
        getFidocartsummarypage().clkInternetCheckout();
        getReporter().reportLogWithScreenshot("Tech-Install page has launched");
        getFidotechnicalinstallationpage().clkTechInstalConfirm();
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

