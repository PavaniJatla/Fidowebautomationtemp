package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class RogersCH_Auto_TC060_SAI_NAC_learnPage_ValidateSecondaryNavigationContent_linksRedirectionTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH"})
    public void rogersCH_Auto_TC060_SAI_NAC_learnPage_ValidateSecondaryNavigationContent_linksRedirection() {
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy Internet");
		getRogersHomePage().clkEasyInternet();
		reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");

		reporter.hardAssert(getRogersHomePage().isSubnavIgniteInternetPresent(),"Ignite Internet Sub nav is Present","Ignite Internet Sub nav is not Present");
		getRogersHomePage().clkSubnavIgniteInternet();
		reporter.reportLogWithScreenshot("Ignite Internet Sub nav");
		reporter.hardAssert(getRogersHomePage().isSubnavIgniteSmartStream(),"Smart Stream Sub nav is Present","Smart Stream Sub nav is not Present");
		getRogersHomePage().clkSubnavSmartStream() ;
		reporter.reportLogWithScreenshot("Smart Stream Sub nav");
		reporter.hardAssert(getRogersHomePage().isSubnavHelpAndSupport(),"Help And Support Sub nav is Present","Help And Support Sub nav is not Present");
		reporter.reportLogWithScreenshot("Help And Support Sub nav");
		getRogersHomePage().clkSubnavHelpAndSupport();

		reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Legacy Internet");
		getDriver().get(System.getProperty("QaUrl"));
		getRogersHomePage().waitforURLNavigation();
		getRogersHomePage().clkEasyInternet();
		reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");
		reporter.hardAssert(getRogersHomePage().isSubnavIgniteInternetPresent(),"Ignite Internet Sub nav is Present","Ignite Internet Sub nav is not Present");
		getRogersHomePage().clkSubnavIgniteInternet();
		reporter.reportLogWithScreenshot("Ignite Internet Sub nav");
		getRogersHomePage().clkIgniteWiFiPromise();
		reporter.reportLogWithScreenshot("clicked Ignite wifi");

		reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Legacy Internet");
		getDriver().get(System.getProperty("QaUrl"));
		getRogersHomePage().waitforURLNavigation();
		getRogersHomePage().clkEasyInternet();
		reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");
		getRogersHomePage().clkSubnavIgniteInternet();
		getRogersHomePage().clkIgniteWiFiHub();

		reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Legacy Internet");
		getDriver().get(System.getProperty("QaUrl"));
		getRogersHomePage().waitforURLNavigation();
		getRogersHomePage().clkEasyInternet();

		reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");

		getRogersHomePage().clkSubnavIgniteInternet();
		//getRogersHomePage().clkIgniteInternet();

		reporter.hardAssert(getRogersHomePage().isAboutIgniteInternetLinkPresent(),"About Ignite Internet Link is present","About Ignite Internet Link is not present");
		getRogersHomePage().clkAboutIgniteInternetLink();
		getRogersHomePage().clkInternetAvailability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
		getRogersInternetPackageSelectionPage().clkInternetPackage();
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Cart Summary Page page has Launched", "Cart Summary Page page has not Launched");
		getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
		reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersInternetProfilePage().setEmail();
		getRogersInternetProfilePage().setFirstname();
		getRogersInternetProfilePage().setLastName();
		getRogersInternetProfilePage().setPhone();
		getRogersInternetProfilePage().clkSubmitProfile();
		reporter.hardAssert(getRogersInternetCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersInternetCreditCheckPage().selectDOBYear();
		getRogersInternetCreditCheckPage().selectDOBMonth();
		getRogersInternetCreditCheckPage().selectDOBDay();
		reporter.reportLogWithScreenshot("Entered DOB details");
		getRogersInternetCreditCheckPage().selectFirstID("Driver's License");
		getRogersInternetCreditCheckPage().selectProvince("Ontario");
		getRogersInternetCreditCheckPage().selectExpiryYear();
		getRogersInternetCreditCheckPage().selectExpiryMonth();
		getRogersInternetCreditCheckPage().selectExpiryDay();
		getRogersInternetCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
		reporter.reportLogWithScreenshot("Driving License Details");
		getRogersInternetCreditCheckPage().selectSecondIDOption("Passport");
		getRogersInternetCreditCheckPage().setPassportNumber();
		getRogersInternetCreditCheckPage().selectPassportExpiryYear();
		getRogersInternetCreditCheckPage().selectPassportExpiryMonth();
		getRogersInternetCreditCheckPage().selectPassportExpiryDay();
		getRogersInternetCreditCheckPage().clkCreditConsentSai();
		reporter.reportLogWithScreenshot("Passport Details");
		getRogersInternetCreditCheckPage().clkCreditConsentSubmit();
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().clkProInstallUpgradeNo();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstallContinueSelf();
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
		getRogersTechInstallPage().clkTechInstallContinue();
		reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
		reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersPaymentOptionsPage().selectPaymentMode("Pre-authorized Credit Card");
		getRogersPaymentOptionsPage().switchToCreditCardIFrame();
		getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
		getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
		getRogersPaymentOptionsPage().setCVV();
		getRogersPaymentOptionsPage().selectExpiryMonth();
		getRogersPaymentOptionsPage().selectExpiryYear();
		reporter.reportLogWithScreenshot("Payment options Details");
		getRogersPaymentOptionsPage().clkPaymentConfirm();
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");

		String ban = getRogersOrderConfirmationPage().getBAN();
		System.out.println("BAN from the portal : " + ban);
		String DbSchema = getDbConnection().getSchemaName(System.getProperty("DbEnvUrl"));
		System.out.println("SCHEMA : " + DbSchema);
		/**
		 * DB Validations in the subscriber table
		 */
		Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl")).executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from " + DbSchema +".billing_account where BAN='" + ban + "'", false);
		reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
		reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
	}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}

