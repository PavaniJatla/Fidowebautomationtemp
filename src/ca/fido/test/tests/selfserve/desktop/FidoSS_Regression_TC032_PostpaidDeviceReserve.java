package ca.fido.test.tests.selfserve.desktop;

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
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import utils.FormFiller;

public class FidoSS_Regression_TC032_PostpaidDeviceReserve extends BaseTestClass {

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void postpaidReserveNewPhone() {
		reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc2732.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc2732.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		
		reporter.reportLogWithScreenshot("Account overview page.");
		String strCTNDetails = fido_account_overview_page.getCTNUsers().get("CTN1");
		String strCTNContact=strCTNDetails.replaceAll("[^0-9]", "");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Wireless DashBoard Page");
		fido_wireless_dashboard_postpaid_page.clkBtnReserveNewPhone();
		fido_wireless_dashboard_postpaid_page.clkBtnReserve();
		fido_device_reservation_system_page.switchToIFrame();
		reporter.reportLogWithScreenshot("Reserve device frame page");
		fido_device_reservation_system_page.cancelAllDeviceReservationBeforeReservingANewOneIFrame();		
		String strSelectedFidoNumber = fido_device_reservation_system_page.getSelectedFidoNumberIFrame();
		reporter.reportLogWithScreenshot("Number selected");
		reporter.hardAssert(strCTNContact.equals(strSelectedFidoNumber),
							"The CTN numbers matched",
							"The CTN numbers mismatched");
		if(fido_device_reservation_system_page.isReserveAPhoneButtonDisplayedIFrame()) {
			fido_device_reservation_system_page.clkReserveAPhoneButtonIFrame();				
		}
		reporter.hardAssert(fido_device_reservation_system_page.verifyThePhoneImageIsLoadedIFrame(),
							"The phone image is displayed",
							"The phone image is not loaded");
		fido_device_reservation_system_page.setReservationContactEmailIFrame(FormFiller.generateEmail());
		reporter.reportLogWithScreenshot("reservation contact email set");
		fido_device_reservation_system_page.clkNextIFrame();
		reporter.reportLogWithScreenshot("Pick Up address page");
		String strPostalCode="M8V2L4";
		String strWithinRange="10 KM";
		fido_device_reservation_system_page.selectPickUpLocationPostalCodeAndWithInRangeIFrame(strPostalCode, strWithinRange);
		fido_device_reservation_system_page.clkGoFindAStoreByPickUpLocationIFrame();
		reporter.reportLogWithScreenshot("Pick up location is set");
		
		reporter.hardAssert(fido_device_reservation_system_page.verifyMapSectionIsDisplayedIFrame(),
							"The Map is displayed on Pick up address page",
							"Map is not displayed"); 		
		reporter.softAssert(fido_device_reservation_system_page.clkSelectAStoreFirstOptionIFrame(),
							"Store address selected",
							"Store addres not selected, please investigate");
		reporter.reportLogWithScreenshot("Pick Up address selected");
		reporter.softAssert(fido_device_reservation_system_page.verifyStoreDetailsIsDisplayedBelowTheMapAfterAddressIsSelectedIFrame(),
							"Store details is displayed after selection",
							"Store details is not displayed below map after selection");
		reporter.softAssert(fido_device_reservation_system_page.verifyWarningNoteIsDisplayedAfterAddressIsSelectedIFrame(),
							"Note is displayed after address is selected",
							"Warning note is not displayed");
		fido_device_reservation_system_page.clkNextOnPickUpSectionIFrame();
		//review section
		reporter.reportLogWithScreenshot("Review page");
		reporter.hardAssert(fido_device_reservation_system_page.verifyIfPhoneImageIsDisplayedOnReviewPageIFrame(),
							"Phone image is displayed",
							"The phone image is not loaded on review page it seems, please investigate");
		reporter.softAssert(fido_device_reservation_system_page.verifyIfPhoneModelDetailsIsDisplayedOnReviewPageIFrame(),
							"The Phone model details displayed",
							"The Phone model details not displayed");
		reporter.softAssert(fido_device_reservation_system_page.verifyIfContactInfoSectionIsDisplayedOnReviewPageIFrame(),
							"Contact Info section displayed on review page",
							"Contact info section not displayed on review page");
		reporter.softAssert(fido_device_reservation_system_page.verifyIfLabelAccountDetailsIsDisplayedOnReviewPageIFrame(),
							"Account details displayed on review page",
							"Account details not displayed");
		reporter.softAssert(fido_device_reservation_system_page.verifyIfSectionPickUpLocationIsDisplayedOnReviewPageIFrame(),
							"Pick up location is displayed",
							"Pick up location not displayed");
		reporter.hardAssert(fido_device_reservation_system_page.verifyIfTermsAndConditionsSectionIsDisplayedOnReviewPageIFrame(),
							"T & C displayed",
							"T & C not displayed");
		fido_device_reservation_system_page.clkIAgreeToTnCCheckBoxIFrame();		
		fido_device_reservation_system_page.clkReserveButtonIFrame();
		
		//reservation confirm section
		reporter.reportLogWithScreenshot("Reservation confirmation page");
		reporter.hardAssert(fido_device_reservation_system_page.verifyIfPhoneImageIsDisplayedOnRservationConfirmedPageIFrame(),
							"Phone image is displayed on Reservation confirmation page",
							"Phone image not displayed");
		reporter.softAssert(fido_device_reservation_system_page.verifyIfTableAccountDetailsIsDisplayedOnReservationConfirmationPageIFrame(),
							"Account details is displayed",
							"Account details is not displayed");
		reporter.softAssert(fido_device_reservation_system_page.verifyIfTablePickUpLocationIsDisplayedOnReservationConfirmationPageIFrame(),
							"Pick up location is displayed",
							"Pick up location not displayed");		
		fido_device_reservation_system_page.clkBackToMyaccountButtonIFrame();
		reporter.reportLogWithScreenshot("After click on back to my account button");
		fido_device_reservation_system_page.clkYesButtonOnAreYouSureOverLayIFrame();
		reporter.reportLogWithScreenshot("Reserve device flow complete.");
	}
}
