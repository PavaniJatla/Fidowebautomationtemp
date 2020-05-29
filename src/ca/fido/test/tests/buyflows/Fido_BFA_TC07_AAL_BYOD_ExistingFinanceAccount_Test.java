package ca.fido.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * TC07 - Fido - Validate user able to perform AAL BYOD using existing finance account
 * 
 * Login to Fido.ca using valid credentials
 * Click on AAL button 
 * select a plan and Click continue
 * select a calling option and Click continue
 * Select any addon's and click continue
 * Enter the caller ID and click Continue
 * Select a number and click continue
 * Click Submit and Order confirmation page should be displayed
 * 
 * @author Saurav.Goyal
 */
public class Fido_BFA_TC07_AAL_BYOD_ExistingFinanceAccount_Test extends BaseTestClass{

	@Test
	public void aalBYODFlowTest() {
		reporter.reportLogWithScreenshot("Fido Home Page");
		//Need to delete below lines from 39 to 46 , added due to AWS link
		getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
		getDriver().findElement(By.xpath("//a[@id='proceed-link']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.testCase07.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.testCase07.getPassword());
		reporter.reportLogWithScreenshot("Login overlay");
		fido_login_page.clkLoginInFrame();
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Error");
		reporter.reportLogWithScreenshot("Account Overview page");
		fido_account_overview_page.clkLnkAddALine();
		reporter.reportLogWithScreenshot("Clicked on add a line");
		fido_account_overview_page.clkButtonAddALine();
		reporter.reportLogWithScreenshot("Modal dialogue appeared");
		Assert.assertTrue(fido_build_plan_page.verifyContinueDeviceCostButton(),"Fido plan config page is displayed");
		reporter.reportLogPass("Fido plan config page");
		fido_build_plan_page.clkFirstTierChooseYourDataAAL();
		reporter.reportLogPass("First tier selected in choose your data");
		fido_build_plan_page.clkContinueYourDataAAL();
		reporter.reportLogPass("Continue button on choose your data clicked");
		fido_build_plan_page.clkContinueAddOnsAAL();
		reporter.reportLogPass("Continue button on choose your add-ons clicked");
		fido_build_plan_page.enterFirstName();
		fido_build_plan_page.enterSecondName();
		fido_build_plan_page.clkContinueEnterUserNameAAL();
		reporter.reportLogPass("Continue button on enter user's name clicked");
		fido_build_plan_page.selectCityForChooseYourTelephoneNum("TOR");
		fido_build_plan_page.clkChooseNumberContinueButton();
		reporter.reportLogPass("Continue button on choose your telephone number clicked");
		fido_build_plan_page.clkContinueBelowCartSummary();
		//fido_order_review_page.verifyCheckBoxTermsAndCondition();
		fido_order_review_page.clkTermsNConditionsConsentAAL();
		fido_order_review_page.setContractDigitalCopyEmail(TestDataHandler.testCase07.getUsername());
		fido_order_review_page.clkSubmitMyOrder();
		reporter.hardAssert(fido_order_confirmation_page.verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
		reporter.reportLogWithScreenshot("Order Confirmation page");
		
	}
	
	@Parameters({"strBrowser", "strLanguage", "strGroupName"})
	@BeforeTest
    public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, String strGroupName, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getFidoURL(), strBrowser,strLanguage, strGroupName,  method);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}