package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 *TC06 - FAAL BYOD - Regression - Fido AAL BYOD -AWS - e2e
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC06_AAL_BYOD_Test extends BaseTestClass{

	@Test(groups = {"RegressionBFA","AALBFA"})
	public void aalBYODFlowTest() {
		getReporter().reportLog("URL:" + System.getProperty("QaUrl"));
		getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
		getReporter().reportLogWithScreenshot("Fido Home Page");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc06AalByod.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc06AalByod.getPassword());
		getReporter().reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		//reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Error");
		getReporter().reportLogWithScreenshot("Account Overview page");
		//fido_account_overview_page.clkLnkAddALine();
		getReporter().reportLogWithScreenshot("Clicked on add a line");
		getFidoaccountoverviewpage().clkButtonAddALine();
		getReporter().reportLogWithScreenshot("Modal dialogue appeared");
		Assert.assertTrue(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		getReporter().reportLogPass("Fido plan config page");
		getFidobuildplanpage().clkFirstTierChooseYourDataAAL();
		getReporter().reportLogPass("First tier selected in choose your data");
		getFidobuildplanpage().clkContinueYourDataAAL();
		getReporter().reportLogPass("Continue button on choose your data clicked");
		getFidobuildplanpage().clkContinueAddOnsAAL();
		getReporter().reportLogPass("Continue button on choose your add-ons clicked");
		getFidobuildplanpage().enterFirstName();
		getFidobuildplanpage().enterSecondName();
		getFidobuildplanpage().clkContinueEnterUserNameAAL();
		getReporter().reportLogPass("Continue button on enter user's name clicked");
		getFidobuildplanpage().selectCityForChooseYourTelephoneNum("TOR");
		getFidobuildplanpage().clkChooseNumberContinueButton();
		getReporter().reportLogPass("Continue button on choose your telephone number clicked");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		getReporter().reportLogPass("Review Page");
		//fido_order_review_page.verifyCheckBoxTermsAndCondition();
		getFidoorderreviewpage().clkTermsNConditionsConsentAAL();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc06AalByod.getUsername());
		getFidoorderreviewpage().clkSubmitMyOrder();
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		getReporter().reportLogWithScreenshot("Order Confirmation page");
	}
	
	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
