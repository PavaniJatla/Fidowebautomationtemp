package ca.fido.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * This script will change the Post paid CTN , runs on English and French both
 * @author Mirza.Kamran
 */
public class FidoSS_Regression_TC022_PostPaidChangeCTN extends BaseTestClass{
	
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
	public void postPaidDashBoardChangeCTN() {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc1122.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc1122.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page.");
		String oldCTN=fido_account_overview_page.getCTNUsers().get("CTN1").split("\n")[1];
		fido_account_overview_page.clkCtnBadge();	
		reporter.reportLogWithScreenshot("Clicked on Wireless badge");
//		fido_wireless_dashboard_postpaid_page.closeOverlayPopup();
		fido_wireless_dashboard_postpaid_page.clickChangeCTN();
		reporter.reportLogWithScreenshot("Click on Change CTN");
		reporter.hardAssert(fido_change_CTN_page.waitForChangeMyNumberPageToLoad(),
							"Change my number page loaded",
							"Change my number page didn't load");
		reporter.softAssert(fido_change_CTN_page.verifylblChangeMyNumberHeaderIsVisible(),
							"Change my number header is visible.",
							"Change mu number header is not visible.");
		reporter.softAssert(fido_change_CTN_page.verifyLabelKeepInMinddetailsIsVisible(),
							"Label keep in mind details is displayed",
							"Label keep in mind details is not displayed");
		reporter.softAssert(fido_change_CTN_page.verifylblChangeCTNBannerDetailsIsVisible(),
							"Label change CTN banner is visibile",
							"Label change CTN banner is not visibile");
		reporter.softAssert(fido_change_CTN_page.verifySelectBoxProvinceAndCityIsVisible(),
							"Province selecbox is visible",
							"Province selecbox is not visible");
		Map<String, String> callingAreaDetails = fido_change_CTN_page.selectCallingProvinceAndCity();
		reporter.reportLogWithScreenshot("Select calling province and city");
		
		fido_change_CTN_page.clickFindAvailableNumbers();
		reporter.reportLogWithScreenshot("Find Available Numbers");
		reporter.hardAssert(fido_change_CTN_page.verifyPickANewNumberPageLoaded(),
							"Pick a new number page loaded",
							"Pick a new number page not loaded");
		String newCTN = fido_change_CTN_page.selectNewNumber(0);	
		reporter.reportLogWithScreenshot("Select New number");
		fido_change_CTN_page.clickSelectNumber();
		reporter.hardAssert(fido_change_CTN_page.verifyReviewYourNewNumberPageLoaded(),
							"Review your number page loaded",
							"Review your number page didn't load");
		
		reporter.hardAssert(fido_change_CTN_page.verifyNewNumberDetails(oldCTN, newCTN),
							"New Number Details page",
							"Some error on new number details page");
		reporter.hardAssert(fido_change_CTN_page.verifyProvinceAndCityOnConfirmationPage(
									callingAreaDetails.get("province"),callingAreaDetails.get("city")),
							"Confirmation page loaded",
							"Confirmation page error it seems");
		//reporter.softAssert(fido_change_CTN_page.verifyEmailSentLabelOnConfirmationPage(),"Email sent label on confirmation page","Email sent label on confirmation page not shown");
		fido_change_CTN_page.clickButtonConfirm();
		reporter.reportLogWithScreenshot("After Click on button confirm");
		reporter.hardAssert(fido_change_CTN_page.verifyTheCTNChangeSuccessPage(newCTN),
							"CTN change success page",
							"CTN change success page not displayed");		
		reporter.softAssert(fido_change_CTN_page.verifyLabelThatsAllIsDisplayed(),
							"Thats all label is displayed",
							"Thats all label not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelYourChangeWillbeDoneInfewMinsIsDisplayed(),
							"Change will be done in few mins label is displayed",
							"Change will be done in few mins label is not displayed.");
		reporter.softAssert(fido_change_CTN_page.verifyNewLabelConfirmationSpanIsDisplayed(),
							"Confirmation span is displayed",
							"Confirmation span is not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelLocalToDetailsIsDisplayed(),
							"Label local to details is displayed",
							"label local to details is not displayed");
		//reporter.softAssert(fido_change_CTN_page.verifyLabelEmailConfirmationOnFinalPageIsDisplayed(),"Email confirmation on final page is displayed","Email confirmation on final page is not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelChangingWillAffectYourBillIsDisplayed(),
							"Changing will affect your bill is displayed",
							"Changing will affect your bill is not displayed");		
		fido_change_CTN_page.clkBackToMyAccount();
		reporter.reportLogWithScreenshot("After click on back to my account");
		fido_account_overview_page.clkCtnBadge();		
		reporter.reportLogWithScreenshot("After click on wireless badge");						
	}
	
	

}
