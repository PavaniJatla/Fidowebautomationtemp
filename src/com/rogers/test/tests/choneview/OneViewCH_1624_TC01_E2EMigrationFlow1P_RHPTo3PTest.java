package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_1624_TC01_E2EMigrationFlow1P_RHPTo3PTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneViewCH_1624_TC01_E2EMigrationFlow1P_RHPTo3PTest(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PRHPTo3P.getAccountNo(), TestDataHandler.migrationData1PRHPTo3P.getContactID());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("3p selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
//		getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
		getRogersIgniteBundlesPage().clickFirstAddToCart(TestDataHandler.anonymousData.getPlanEngSAI());

		getRogersIgniteBundlesPage().clkKeepNumberbtn();
		getRogersIgniteBundlesPage().noPortInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
		getRogersIgniteBundlesPage().clickExchangeLater();
		getCustomerProfilePage().clkContinue();
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("CheckOut for Cart Summary");
		getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCreditCheckPage().goToPageBottom();
		getCustomerProfilePage().clkContinue();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		getHomePhoneSelectionPage().clkContinue();
		getCreditCheckPage().continueConfirmation();
		getCreditCheckPage().goToPageBottom();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
	    //getPaymentOptionsPage().clkContinue();
		//getPaymentOptionsPage().clkContinue();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");

    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession("", strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

