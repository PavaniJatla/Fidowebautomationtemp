package com.rogers.test.tests.solarisconsumer;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;  
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the gwp promotion for the legacy DTV and RHP customer on Rogers.com  
 * 
 * @author Saurav.Goyal
 *
 *Important Points:-
 *After logging into the ciam application , user has been navigated to below brt link
 *"https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv" Which we need to edit once one application is ready
 *
 **/

public class RogersSC_TC_004_GWP_ExistingLegacyCustomer_DTVRHPCustomer_SameServiceAndBrowserProvinceAddressTest extends BaseTestClass {

	@Test @Parameters({"strLanguage"})
	public void gwpTestDtvRhp(String strLanguage) {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisConsumerGWPRhpDtv.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerGWPRhpDtv.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		rogers_home_page.clkServiceabilityMigration(); 
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability"); 
		rogers_home_page.clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		//Have to remove below navigation once actual flow will work properly
		getDriver().get("https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv");
		//rogers_home_page.clkUseThisAddress();
		//rogers_home_page.clkNoThanks();
		if(strLanguage.equalsIgnoreCase("fr")) {
			rogers_igniteTV_buy_page.clkChevronForBundle(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getBundelPackageNameFr());
			Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getBundelPackageNameFr()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			rogers_igniteTV_buy_page.selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getBundelPackageNameFr());
		}
		else {
			rogers_igniteTV_buy_page.clkChevronForBundle(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getBundelPackageNameEn());
			Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getBundelPackageNameEn()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			rogers_igniteTV_buy_page.selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getBundelPackageNameEn());
		}
		//rogers_igniteTV_buy_page.clkChevronForBundle("Ignite Flex 5");
		reporter.reportLogWithScreenshot("Launched the information popup");
		rogers_igniteTV_buy_page.verifyImportantInformation();
		rogers_igniteTV_buy_page.clkIUnderstand();
		//reporter.reportLogWithScreenshot("Launched the port-in popup");
		//rogers_igniteTV_buy_page.clickOptPhone();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		rogers_igniteTV_buy_page.clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_buy_page.clkChevronUpYourCart();
		rogers_igniteTV_buy_page.clkHomePhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_buy_page.clkChevronUpYourCart();
		rogers_igniteTV_buy_page.set4KTV(); 
		rogers_igniteTV_buy_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_profile_creation_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_profile_creation_page.clkChevronYourCart();
		rogers_igniteTV_profile_creation_page.clkSubmitProfile(); 
		rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_credit_check_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_credit_check_page.clkChevronYourCart();
		rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getYear());
		rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getMonth());
		rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerGWPRhpDtv.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		rogers_home_phone_selection_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_home_phone_selection_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_home_phone_selection_page.clkChevronYourCart();
		rogers_home_phone_selection_page.clkContinueHomePhoneSelection();  
		reporter.reportLogWithScreenshot("Launched the tech install page");
		rogers_tech_install_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_tech_install_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_tech_install_page.selTechInstalStartDate();
		rogers_payment_options_page.clkChevronYourCart();
		rogers_tech_install_page.selTechInstalEndDate();
		rogers_tech_install_page.setEmail();
		rogers_tech_install_page.clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		rogers_payment_options_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_payment_options_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_payment_options_page.clkChevronYourCart();
		rogers_payment_options_page.clkPaymentConfirmExistingCustomer();		
		rogers_order_review_page.verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		rogers_order_review_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_order_review_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_order_review_page.verifyAgreement();
		rogers_order_review_page.clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}