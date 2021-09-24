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


public class OneViewCH_Auto_1413_TC01_E2E_NAC_3P_STBs_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void oneViewCH_Auto_1413_TC01_E2E_NAC_3P_STBs_Test(){
			reporter.reportLogWithScreenshot("oneview env");
			getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
			reporter.reportLogWithScreenshot("address");
			getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
			reporter.reportLogWithScreenshot("Service Availability");
			getRogersIgniteBundlesPage().clkContinue();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
			reporter.reportLogWithScreenshot("Select Services Customer Wants");
			getRogersIgniteBundlesPage().clkTVCheckbox();
			getRogersIgniteBundlesPage().clkInternetCheckbox();
			getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
			reporter.reportLogWithScreenshot("Triple Play Selected");
			getRogersIgniteBundlesPage().clkLoadOffers();
			getRogersIgniteBundlesPage().selectAdditionalIgniteTVBoxes();
			getRogersIgniteBundlesPage().clickFirstAddToCart();
			getRogersIgniteBundlesPage().noPortInPopup();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
			reporter.reportLogWithScreenshot("Product in cart");
			getRogersIgniteBundlesPage().clkCollapse();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
			reporter.reportLogWithScreenshot("Product Added");
			getRogersIgniteBundlesPage().clkContinue();
			reporter.reportLogWithScreenshot("continue");
			getRogersIgniteBundlesPage().fourKTVPopup();
			getRogersIgniteBundlesPage().fourKContinue();
//			getRogersIgniteBundlesPage().clkCollapse();
			reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
			getRogersIgniteBundlesPage().clkCheckOut();
			reporter.reportLogWithScreenshot("Cart Summary");
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
			getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
			reporter.reportLogWithScreenshot("CheckOut cart summary");
			getRogersIgniteBundlesPage().customerWishtoContinue();

			reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
			reporter.reportLogWithScreenshot("Customer Profile");
			getCustomerProfilePage().clkContinue();
			reporter.reportLogWithScreenshot("Evaluation form");
			getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
			getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
			getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
			reporter.reportLogWithScreenshot("Evaluation form filled");
			getCreditCheckPage().clkAuthorize();
			reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
			reporter.reportLogWithScreenshot("Credit Check Information");
			getCreditCheckPage().clkContinue();
			reporter.reportLogWithScreenshot("Generate phone");
			getHomePhoneSelectionPage().clkGeneratePhoneNo();
			reporter.softAssert(getHomePhoneSelectionPage().verifySelectedNumber(),"Phone Number Selected","Phone Number Selection Failed");
			reporter.reportLogWithScreenshot("Phone Number Selected");
			getCreditCheckPage().goToPageBottom();
			getCreditCheckPage().clkContinue();
			reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
			reporter.reportLogWithScreenshot("Installation options");
			getCreditCheckPage().verifyInstallationOption();
			reporter.reportLogWithScreenshot("installation options");
			getCreditCheckPage().goToPageBottom();
			getCreditCheckPage().clickInPersonDelivery();
			reporter.reportLogWithScreenshot("IN PERSON DELIVERY");
			getPaymentOptionsPage().clkContinue();
			reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
			getCreditCheckPage().verifyBillingAndPaymentOption();
			reporter.reportLogWithScreenshot("front line");
			getCreditCheckPage().clickDigitalFrontline();
			reporter.reportLogWithScreenshot("card details");

			getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
			getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
			getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
			reporter.reportLogWithScreenshot("card details entered");
//			getPaymentOptionsPage().clkContinue();
//			reporter.reportLogWithScreenshot("submit order");
//			getRogersOVCheckoutPage().clkSubmit();
//			reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
			reporter.reportLogWithScreenshot("Order Placed");
		
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID_STB_3P(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

