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
 * This script will change the Prepaid CTN , runs on English and French both
 * @author Mirza.Kamran
 */
public class FidoSS_Regression_TC009_PrePaidChangeCTN extends BaseTestClass{
	
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
	public void prePaidDashBoardChangeCTN() {
		
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc006009.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc006009.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page.");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("click wireless badge");
		String oldCTN=fido_wireless_dashboard_prepaid_page.getTheExistingCTN();
		fido_wireless_dashboard_prepaid_page.clickChangeCTN();
		reporter.reportLogWithScreenshot("Clicked on change CTN");
		reporter.softAssert(fido_change_CTN_page.waitForChangeMyNumberPageToLoad(),
							"Change my number page loaded",
							"Change my number page not loaded");
		reporter.softAssert(fido_change_CTN_page.verifylblChangeMyNumberHeaderIsVisible(),
							"Change my number header is displayed",
							"Change my number header is not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelKeepInMinddetailsIsVisible(),
							"Label keep in mind details is displayed",
							"Label keep in mind details is not displayed");
		reporter.softAssert(fido_change_CTN_page.verifylblChangeCTNBannerDetailsIsVisible(),
							"Label change CTN banner is visibile",
							"Label change CTN banner is  not visibile");
		reporter.softAssert(fido_change_CTN_page.verifySelectBoxProvinceAndCityIsVisible(),
							"Province selecbox is visible",
							"Province selecbox is  not visible");
		Map<String, String> callingAreaDetails = fido_change_CTN_page.selectCallingProvinceAndCity();
		reporter.reportLogWithScreenshot("Calling Province and city selected");
		fido_change_CTN_page.clickFindAvailableNumbers();
		reporter.reportLogWithScreenshot("Click find available numbers");
		reporter.softAssert(fido_change_CTN_page.verifyPickANewNumberPageLoaded(),
							"Pick a new number page loaded",
							"Pick a new number page  not loaded");
		String newCTN=fido_change_CTN_page.selectNewNumber(0);
		reporter.reportLogWithScreenshot("New number selected");
		fido_change_CTN_page.clickSelectNumber();		
		fido_change_CTN_page.verifyReviewYourNewNumberPageLoaded();
		reporter.reportLogWithScreenshot("Review New number page");
		reporter.softAssert(fido_change_CTN_page.verifyNewNumberDetails(oldCTN, newCTN),
							"New Number Details page",
							"New Number Details page  not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyProvinceAndCityOnConfirmationPage(
									callingAreaDetails.get("province"),callingAreaDetails.get("city")),
							"Confirmation page loaded",
							"Confirmation page loaded  not displayed");
		//reporter.softAssert(fido_change_CTN_page.verifyEmailSentLabelOnConfirmationPage(),"Label email sent on confirmation page","label email sent on confirmation page is not displayed");
		fido_change_CTN_page.clickButtonConfirm();
		reporter.reportLogWithScreenshot("CTN change success page");
		reporter.softAssert(fido_change_CTN_page.verifyTheCTNChangeSuccessPage(newCTN),
							"CTN change success page",
							"CTN change success page not displayed");		
		reporter.softAssert(fido_change_CTN_page.verifyLabelThatsAllIsDisplayed(),
							"Thats all label is displayed",
							"Thats all label is  not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelYourChangeWillbeDoneInfewMinsIsDisplayed(),
							"Change will be done in few mins label",
							"Change will be done in few mins label  not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyNewLabelConfirmationSpanIsDisplayed(),
							"Confirmation span is displayed",
							"Confirmation span is  not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelLocalToDetailsIsDisplayed(),
							"Label local to details is displayed",
							"Label local to details is  not displayed");
		//reporter.softAssert(fido_change_CTN_page.verifyLabelEmailConfirmationOnFinalPageIsDisplayed(),"Email confirmation on final page is displayed","Email confirmation on final page is  not displayed");
		reporter.softAssert(fido_change_CTN_page.verifyLabelChangingWillAffectYourBillIsDisplayed(),
							"Changing will affect your bill is displayed",
							"Changing will affect your bill is not displayed");			
		fido_change_CTN_page.clkBackToMyAccount();
		reporter.reportLogWithScreenshot("click back to my account page");
		fido_account_overview_page.clkCtnBadge();		
						
	}
	
	

}
