package ca.fido.test.tests.connectedhome.mobile;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;




/**
 * This class contains the test method to test the HSI upgrade flow for Fido.ca   
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Launch fido.ca url
 *2. Log into fido.ca url with valid credentials.
 *3. Click on the internet icon in dashboard.
 *4. Click on View/change internet package link.
 *5. Choose another internet package which is higher price than current package and click update.
 *6. User will be taken to the review order page
 *7. Scroll down to Additional agreement section, scroll all the way down and check the "I  have read ….." check box
 *8. Click submit.
 *
 **/

public class Mobile_FidoCH_Regression_TC_002_HSIPlanUpgradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoCableMobileCH"})
	public void checkFidoHSIPlanUpgradeMobile() {

		reporter.reportLogWithScreenshot("Launched the Home Page");
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navigation card");
		fido_home_page.clkLoginMobile();
		fido_login_page.switchToSignInFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn page");
		fido_login_page.setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameUpgrade());
		fido_login_page.setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentials");
		fido_login_page.clkLoginInFrame();
		
		reporter.hardAssert(!fido_account_overview_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		fido_account_overview_page.clkInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		fido_internet_dashboard_page.clkChangePackage();
		reporter.reportLogWithScreenshot("Launched the packages Page");		
		fido_internet_dashboard_page.selectHSIPackageByBandwidth(TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlan());
		reporter.reportLogWithScreenshot("Selected the package");
		fido_internet_dashboard_page.clkConfirmPackageChange();
		reporter.reportLogWithScreenshot("Order review page has launched");
		reporter.hardAssert(fido_internet_package_change_review_order_page.verifyPlanInfomation(TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlan()),"Verified the Plan Information","Plan Information Verification has failed");
	       reporter.reportLogWithScreenshot("Order review page has launched");
		reporter.hardAssert(fido_internet_package_change_review_order_page.verifyFidoTermsAndConditions(),"Verified the Terms And Conditions","Terms And Conditions Verification has failed");
		fido_internet_package_change_review_order_page.chkConsentCheckbox();
		reporter.reportLogWithScreenshot("Consent Check has Done");
		reporter.hardAssert(fido_internet_package_change_review_order_page.verifySubmitButtonEnabled(),"button enabled","button disabled");
		fido_internet_package_change_review_order_page.clkReviewSubmitButton();
		reporter.reportLogWithScreenshot("Order Success and order confirmation details");
		reporter.hardAssert(fido_order_confirmation_page.verifyOrderConfirm(), "Plan Upgrade success", "Plan Upgrade Failed");
	   }
	

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	startSession(System.getProperty("QaUrl"),strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login,  method);
	// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
