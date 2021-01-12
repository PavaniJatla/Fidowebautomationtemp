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
		reporter.reportLog("URL:" + System.getProperty("AWSUrl"));
		reporter.reportLogWithScreenshot("Fido Home Page");
		//fido_home_page.clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc06AalByod.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc06AalByod.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		getFidologinpage().clkLoginInFrame();
		getFidologinpage().switchOutOfSignInFrame();
		//reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		//fido_account_overview_page.clkLnkAddALine();
		reporter.reportLogWithScreenshot("Clicked on add a line");
		getFidoaccountoverviewpage().clkButtonAddALine();
		reporter.reportLogWithScreenshot("Modal dialogue appeared");
		Assert.assertTrue(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		reporter.reportLogPass("Fido plan config page");
		getFidobuildplanpage().clkFirstTierChooseYourDataAAL();
		reporter.reportLogPass("First tier selected in choose your data");
		getFidobuildplanpage().clkContinueYourDataAAL();
		reporter.reportLogPass("Continue button on choose your data clicked");
		getFidobuildplanpage().clkContinueAddOnsAAL();
		reporter.reportLogPass("Continue button on choose your add-ons clicked");
		getFidobuildplanpage().enterFirstName();
		getFidobuildplanpage().enterSecondName();
		getFidobuildplanpage().clkContinueEnterUserNameAAL();
		reporter.reportLogPass("Continue button on enter user's name clicked");
		getFidobuildplanpage().selectCityForChooseYourTelephoneNum("TOR");
		getFidobuildplanpage().clkChooseNumberContinueButton();
		reporter.reportLogPass("Continue button on choose your telephone number clicked");
		getFidobuildplanpage().clkContinueBelowCartSummary();
		reporter.reportLogPass("Review Page");
		//fido_order_review_page.verifyCheckBoxTermsAndCondition();
		getFidoorderreviewpage().clkTermsNConditionsConsentAAL();
		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.tc06AalByod.getUsername());
		getFidoorderreviewpage().clkSubmitMyOrder();
		reporter.hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}
	
	@Parameters({"strBrowser", "strLanguage"})
	@BeforeMethod
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows,  method);
    }

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
