package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_TC_003_IgniteNACDualPlayWithout4KTVExpressCheckout extends BaseTestClass{
	 @Test @Parameters("strBrowser")
	    public void endToEndFlowAnonymousCustomerTriplePlayTest(String browser){
			getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
			getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress(),browser);
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
			reporter.reportLogWithScreenshot("Service Availability");
			getRogersIgniteBundlesPage().clkContinue();
		    getRogersIgniteBundlesPage().clkTVCheckbox();
			getRogersIgniteBundlesPage().clkInternetCheckbox();
			getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
			reporter.reportLogWithScreenshot("Triple Play Selected");
			getRogersIgniteBundlesPage().clkShowOffers();
			getRogersIgniteBundlesPage().selectOptout(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
			getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
			getRogersIgniteBundlesPage().activateHomePhoneltrPopUp();
			getRogersIgniteBundlesPage().clkCollapse();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
			reporter.reportLogWithScreenshot("Product Added");
			getRogersIgniteBundlesPage().clkContinue();
			getRogersIgniteBundlesPage().fourKTVPopup();
			getRogersIgniteBundlesPage().fourKContentPopup();
			getRogersIgniteBundlesPage().clkCollapse();
			reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
			getRogersIgniteBundlesPage().clkCheckOut();
			reporter.reportLogWithScreenshot("Cart Summary");
			getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
			getRogersIgniteBundlesPage().customerWishtoContinue();
	        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
	        reporter.reportLogWithScreenshot("Customer Profile");
			getCustomerProfilePage().clkContinue();
			//getCreditCheckPage().setDOB(TestDataHandler.anonymousData.contactDetails.getYearOfBirth(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth());
			getCreditCheckPage().clkCollapse();
			getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());	
			//getCreditCheckPage().setIDs(TestDataHandler.anonymousData.contactDetails.getFirstID(),TestDataHandler.anonymousData.contactDetails.getProvince(),TestDataHandler.anonymousData.contactDetails.getIdExpiryYear(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth(),TestDataHandler.anonymousData.contactDetails.getLicenseNo(),TestDataHandler.anonymousData.contactDetails.getSecondID(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
			getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
			getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
			getCreditCheckPage().clkAuthorize();
			reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
			reporter.reportLogWithScreenshot("Credit Check Information");
			getCreditCheckPage().clkContinue();
			//getHomePhoneSelectionPage().clkGeneratePhoneNo();
			//reporter.softAssert(getHomePhoneSelectionPage().verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
			//reporter.reportLogWithScreenshot("Phone Number Selected");
			//getHomePhoneSelectionPage().clkContinue();
			//getFulfillmentPage().clkFirstAvailableAppointment();
			//reporter.reportLogWithScreenshot("Appointment Selected");
			getFulfillmentPage().selectChkboxAgreeCondition();
			reporter.reportLogWithScreenshot("Fulfillment Page");
			getFulfillmentPage().clkContinue();
			getPaymentOptionsPage().selectPaymentOption(TestDataHandler.anonymousData.contactDetails.getPaymentOption());
			reporter.reportLogWithScreenshot("Payment Option Selected");
			getPaymentOptionsPage().clkContinue();
			getRogersOVOrderReviewPage().expandMonthlyBill();
			reporter.reportLogWithScreenshot("Monthly Bill");
			//getRogersOVOrderReviewPage().expandOneTimeFees();
			reporter.reportLogWithScreenshot("One Time Fees");
			getRogersOVOrderReviewPage().clkSubmit();
			reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
			reporter.reportLogWithScreenshot("Order Placed");
			
	    }
	    
		@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	        startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,strGroupName, TestDataHandler.anonymousData.contactDetails.getContactIDforDualPlay(),"",TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
		
		}

		@AfterMethod(alwaysRun = true)
		public void afterTest() {
			closeSession();
		}

	}


