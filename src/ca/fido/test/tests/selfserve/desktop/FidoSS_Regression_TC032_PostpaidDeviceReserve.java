package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC032_PostpaidDeviceReserve extends BaseTestClass {

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void postpaidReserveNewPhone() {
		getReporter().reportLogWithScreenshot("Home Page");
        getReporter().reportLog("Home Page Launched");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc2732.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc2732.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page.");
		String strCTNDetails = getFidoaccountoverviewpage().getCTNUsers().get("CTN1");
		String strCTNContact=strCTNDetails.replaceAll("[^0-9]", "");
		String strCTN = TestDataHandler.tc2732.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Wireless DashBoard Page");
		getFidowirelessdashboardpostpaidpage().clkBtnReserveNewPhone();
		getFidowirelessdashboardpostpaidpage().clkBtnReserve();
		getFidodevicereservationsystempage().switchToIFrame();
		getReporter().reportLogWithScreenshot("Reserve device frame page");
		getFidodevicereservationsystempage().cancelAllDeviceReservationBeforeReservingANewOneIFrame();		
		String strSelectedFidoNumber = getFidodevicereservationsystempage().getSelectedFidoNumberIFrame();
		getReporter().reportLogWithScreenshot("Number selected");
		getReporter().hardAssert(strCTNContact.equals(strSelectedFidoNumber),
							"The CTN numbers matched",
							"The CTN numbers mismatched");
		if(getFidodevicereservationsystempage().isReserveAPhoneButtonDisplayedIFrame()) {
			getFidodevicereservationsystempage().clkReserveAPhoneButtonIFrame();				
		}
		getReporter().hardAssert(getFidodevicereservationsystempage().verifyThePhoneImageIsLoadedIFrame(),
							"The phone image is displayed",
							"The phone image is not loaded");
		getFidodevicereservationsystempage().setReservationContactEmailIFrame(FormFiller.generateEmail());
		getReporter().reportLogWithScreenshot("reservation contact email set");
		getFidodevicereservationsystempage().clkNextIFrame();
		getReporter().reportLogWithScreenshot("Pick Up address page");
		String strPostalCode="M8V2L4";
		String strWithinRange="10 KM";
		getFidodevicereservationsystempage().selectPickUpLocationPostalCodeAndWithInRangeIFrame(strPostalCode, strWithinRange);
		getFidodevicereservationsystempage().clkGoFindAStoreByPickUpLocationIFrame();
		getReporter().reportLogWithScreenshot("Pick up location is set");
		
		getReporter().hardAssert(getFidodevicereservationsystempage().verifyMapSectionIsDisplayedIFrame(),
							"The Map is displayed on Pick up address page",
							"Map is not displayed"); 		
		getReporter().softAssert(getFidodevicereservationsystempage().clkSelectAStoreFirstOptionIFrame(),
							"Store address selected",
							"Store addres not selected, please investigate");
		getReporter().reportLogWithScreenshot("Pick Up address selected");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyStoreDetailsIsDisplayedBelowTheMapAfterAddressIsSelectedIFrame(),
							"Store details is displayed after selection",
							"Store details is not displayed below map after selection");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyWarningNoteIsDisplayedAfterAddressIsSelectedIFrame(),
							"Note is displayed after address is selected",
							"Warning note is not displayed");
		getFidodevicereservationsystempage().clkNextOnPickUpSectionIFrame();
		//review section
		getReporter().reportLogWithScreenshot("Review page");
		getReporter().hardAssert(getFidodevicereservationsystempage().verifyIfPhoneImageIsDisplayedOnReviewPageIFrame(),
							"Phone image is displayed",
							"The phone image is not loaded on review page it seems, please investigate");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyIfPhoneModelDetailsIsDisplayedOnReviewPageIFrame(),
							"The Phone model details displayed",
							"The Phone model details not displayed");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyIfContactInfoSectionIsDisplayedOnReviewPageIFrame(),
							"Contact Info section displayed on review page",
							"Contact info section not displayed on review page");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyIfLabelAccountDetailsIsDisplayedOnReviewPageIFrame(),
							"Account details displayed on review page",
							"Account details not displayed");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyIfSectionPickUpLocationIsDisplayedOnReviewPageIFrame(),
							"Pick up location is displayed",
							"Pick up location not displayed");
		getReporter().hardAssert(getFidodevicereservationsystempage().verifyIfTermsAndConditionsSectionIsDisplayedOnReviewPageIFrame(),
							"T & C displayed",
							"T & C not displayed");
		getFidodevicereservationsystempage().clkIAgreeToTnCCheckBoxIFrame();		
		getFidodevicereservationsystempage().clkReserveButtonIFrame();
		
		//reservation confirm section
		getReporter().reportLogWithScreenshot("Reservation confirmation page");
		getReporter().hardAssert(getFidodevicereservationsystempage().verifyIfPhoneImageIsDisplayedOnRservationConfirmedPageIFrame(),
							"Phone image is displayed on Reservation confirmation page",
							"Phone image not displayed");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyIfTableAccountDetailsIsDisplayedOnReservationConfirmationPageIFrame(),
							"Account details is displayed",
							"Account details is not displayed");
		getReporter().softAssert(getFidodevicereservationsystempage().verifyIfTablePickUpLocationIsDisplayedOnReservationConfirmationPageIFrame(),
							"Pick up location is displayed",
							"Pick up location not displayed");		
		getFidodevicereservationsystempage().clkBackToMyaccountButtonIFrame();
		getReporter().reportLogWithScreenshot("After click on back to my account button");
		getFidodevicereservationsystempage().clkYesButtonOnAreYouSureOverLayIFrame();
		getReporter().reportLogWithScreenshot("Reserve device flow complete.");
	}
}
