package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This script will change the Post paid CTN , runs on English and French both
 * @author Mirza.Kamran
 */
public class FidoSS_Regression_TC022_PostPaidChangeCTN extends BaseTestClass{
	
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
	
	@Test(groups = {"RegressionSS","DashboardSS"})
	public void postPaidDashBoardChangeCTN() {
		
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc1122.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc1122.getPassword());
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
		String oldCTN=getFidoaccountoverviewpage().getCTNUsers().get("CTN1").replaceAll(" ", "").replaceAll("-", "");
		String strCTN = TestDataHandler.tc1122.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);	
		getReporter().reportLogWithScreenshot("Clicked on Wireless badge");
//		getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
		getFidowirelessdashboardpostpaidpage().clickChangeCTN();
		getReporter().reportLogWithScreenshot("Click on Change CTN");
		getReporter().hardAssert(getFidochangectnpage().waitForChangeMyNumberPageToLoad(),
							"Change my number page loaded",
							"Change my number page didn't load");
		getReporter().softAssert(getFidochangectnpage().verifylblChangeMyNumberHeaderIsVisible(),
							"Change my number header is visible.",
							"Change mu number header is not visible.");
		getReporter().softAssert(getFidochangectnpage().verifyLabelKeepInMinddetailsIsVisible(),
							"Label keep in mind details is displayed",
							"Label keep in mind details is not displayed");
/*		getReporter().softAssert(getFidochangectnpage().verifylblChangeCTNBannerDetailsIsVisible(),
							"Label change CTN banner is visibile",
							"Label change CTN banner is not visibile");*/
		getReporter().softAssert(getFidochangectnpage().verifySelectBoxProvinceAndCityIsVisible(),
							"Province selecbox is visible",
							"Province selecbox is not visible");
		Map<String, String> callingAreaDetails = getFidochangectnpage().selectCallingProvinceAndCity();
		getReporter().reportLogWithScreenshot("Select calling province and city");
		
		getFidochangectnpage().clickFindAvailableNumbers();
		getReporter().reportLogWithScreenshot("Find Available Numbers");
		getReporter().hardAssert(getFidochangectnpage().verifyPickANewNumberPageLoaded(),
							"Pick a new number page loaded",
							"Pick a new number page not loaded");
		String newCTN = getFidochangectnpage().selectNewNumber(0);	
		getReporter().reportLogWithScreenshot("Select New number");
		getFidochangectnpage().clickSelectNumber();
		getReporter().hardAssert(getFidochangectnpage().verifyReviewYourNewNumberPageLoaded(),
							"Review your number page loaded",
							"Review your number page didn't load");
		
		getReporter().hardAssert(getFidochangectnpage().verifyNewNumberDetails(oldCTN, newCTN),
							"New Number Details page",
							"Some error on new number details page");
		getReporter().hardAssert(getFidochangectnpage().verifyProvinceAndCityOnConfirmationPage(
									callingAreaDetails.get("province"),callingAreaDetails.get("city")),
							"Confirmation page loaded",
							"Confirmation page error it seems");
		//getReporter().softAssert(getFidochangectnpage().verifyEmailSentLabelOnConfirmationPage(),"Email sent label on confirmation page","Email sent label on confirmation page not shown");
		getFidochangectnpage().clickButtonConfirm();
		getReporter().reportLogWithScreenshot("After Click on button confirm");
		getReporter().hardAssert(getFidochangectnpage().verifyTheCTNChangeSuccessPage(newCTN),
							"CTN change success page",
							"CTN change success page not displayed");		
		getReporter().softAssert(getFidochangectnpage().verifyLabelThatsAllIsDisplayed(),
							"Thats all label is displayed",
							"Thats all label not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelYourChangeWillbeDoneInfewMinsIsDisplayed(),
							"Change will be done in few mins label is displayed",
							"Change will be done in few mins label is not displayed.");
		getReporter().softAssert(getFidochangectnpage().verifyNewLabelConfirmationSpanIsDisplayed(),
							"Confirmation span is displayed",
							"Confirmation span is not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelLocalToDetailsIsDisplayed(),
							"Label local to details is displayed",
							"label local to details is not displayed");
		//getReporter().softAssert(getFidochangectnpage().verifyLabelEmailConfirmationOnFinalPageIsDisplayed(),"Email confirmation on final page is displayed","Email confirmation on final page is not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelChangingWillAffectYourBillIsDisplayed(),
							"Changing will affect your bill is displayed",
							"Changing will affect your bill is not displayed");		
		getFidochangectnpage().clkBackToMyAccount();
		getReporter().reportLogWithScreenshot("After click on back to my account");
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);		
		getReporter().reportLogWithScreenshot("After click on wireless badge");						
	}
	
	

}
