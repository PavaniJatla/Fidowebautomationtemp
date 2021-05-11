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
 * This script will change the Prepaid CTN , runs on English and French both
 * @author Mirza.Kamran
 */
public class FidoSS_Regression_TC009_PrePaidChangeCTN extends BaseTestClass{
	
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
	
	@Test(groups = {"RegressionSS"})
	public void prePaidDashBoardChangeCTN() {
		
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc006009.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc006009.getPassword());
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
		String strCTN = TestDataHandler.tc006009.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("click wireless badge");
		String oldCTN=getFidowirelessdashboardprepaidpage().getTheExistingCTN();
		getFidowirelessdashboardprepaidpage().clickChangeCTN();
		getReporter().reportLogWithScreenshot("Clicked on change CTN");
		getReporter().hardAssert(getFidochangectnpage().waitForChangeMyNumberPageToLoad(),
							"Change my number page loaded",
							"Change my number page not loaded");
		getReporter().softAssert(getFidochangectnpage().verifylblChangeMyNumberHeaderIsVisible(),
							"Change my number header is displayed",
							"Change my number header is not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelKeepInMinddetailsIsVisible(),
							"Label keep in mind details is displayed",
							"Label keep in mind details is not displayed");
		getReporter().softAssert(getFidochangectnpage().verifylblChangeCTNBannerDetailsIsVisible(),
							"Label change CTN banner is visibile",
							"Label change CTN banner is  not visibile");
		getReporter().hardAssert(getFidochangectnpage().verifySelectBoxProvinceAndCityIsVisible(),
							"Province selecbox is visible",
							"Province selecbox is  not visible");
		Map<String, String> callingAreaDetails = getFidochangectnpage().selectCallingProvinceAndCity();
		getReporter().reportLogWithScreenshot("Calling Province and city selected");
		getFidochangectnpage().clickFindAvailableNumbers();
		getReporter().reportLogWithScreenshot("Click find available numbers");
		getReporter().hardAssert(getFidochangectnpage().verifyPickANewNumberPageLoaded(),
							"Pick a new number page loaded",
							"Pick a new number page  not loaded");
		String newCTN=getFidochangectnpage().selectNewNumber(0);
		getReporter().reportLogWithScreenshot("New number selected");
		getFidochangectnpage().clickSelectNumber();		
		getFidochangectnpage().verifyReviewYourNewNumberPageLoaded();
		getReporter().reportLogWithScreenshot("Review New number page");
		getReporter().hardAssert(getFidochangectnpage().verifyNewNumberDetails(oldCTN, newCTN),
							"New Number Details page",
							"New Number Details page  not displayed");
		getReporter().hardAssert(getFidochangectnpage().verifyProvinceAndCityOnConfirmationPage(
									callingAreaDetails.get("province"),callingAreaDetails.get("city")),
							"Confirmation page loaded",
							"Confirmation page loaded  not displayed");
		//getReporter().softAssert(getFidochangectnpage().verifyEmailSentLabelOnConfirmationPage(),"Label email sent on confirmation page","label email sent on confirmation page is not displayed");
		getFidochangectnpage().clickButtonConfirm();
		getReporter().reportLogWithScreenshot("CTN change success page");
		getReporter().hardAssert(getFidochangectnpage().verifyTheCTNChangeSuccessPage(newCTN),
							"CTN change success page",
							"CTN change success page not displayed");		
		getReporter().softAssert(getFidochangectnpage().verifyLabelThatsAllIsDisplayed(),
							"Thats all label is displayed",
							"Thats all label is  not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelYourChangeWillbeDoneInfewMinsIsDisplayed(),
							"Change will be done in few mins label",
							"Change will be done in few mins label  not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyNewLabelConfirmationSpanIsDisplayed(),
							"Confirmation span is displayed",
							"Confirmation span is  not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelLocalToDetailsIsDisplayed(),
							"Label local to details is displayed",
							"Label local to details is  not displayed");
		//getReporter().softAssert(getFidochangectnpage().verifyLabelEmailConfirmationOnFinalPageIsDisplayed(),"Email confirmation on final page is displayed","Email confirmation on final page is  not displayed");
		getReporter().softAssert(getFidochangectnpage().verifyLabelChangingWillAffectYourBillIsDisplayed(),
							"Changing will affect your bill is displayed",
							"Changing will affect your bill is not displayed");			
		getFidochangectnpage().clkBackToMyAccount();
		getReporter().reportLogWithScreenshot("click back to my account page");
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);		
						
	}
	
	

}
