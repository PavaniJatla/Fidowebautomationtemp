package ca.fido.test.tests.connectedhome.desktop;

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

public class FidoCH_Regression_TC_013_HSIPlanUpgradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoHSIDashboardCH","ERM"})
	public void checkFidoHSIPlanUpgrade() {
		getReporter().reportLogWithScreenshot("Launched the SignIn page");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernameUpgrade());
		getReporter().reportLogWithScreenshot("Continue Login");
		getFidologinpage().clkContinueSignIn();
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentials");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		getFidoaccountoverviewpage().clkViewUsageManage();
		getReporter().reportLogWithScreenshot("Clicked on View Usage and manage Button to land to Internet Dashboard Page");
		getFidointernetdashboardpage().clkChangePackage();
		getReporter().reportLogWithScreenshot("Clicked on change Package button");
		getFidointernetdashboardpage().selectHSIPackageByBandwidth(TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlan());
		getReporter().reportLogWithScreenshot("Selected the 150 Mbps package to upgrade");
		getFidointernetdashboardpage().clkConfirmPackageChange();
		getReporter().reportLogWithScreenshot("Confirm Package Change to launch Order Review page");
		getReporter().softAssert(getFidointernetpackagechangerevieworderpage().verifyPlanInfomation(TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlan()),"Verified the Plan Information","Plan Information Verification has failed");
		getReporter().softAssert(getFidointernetpackagechangerevieworderpage().verifyFidoTermsAndConditions(),"Verified the Terms And Conditions","Terms And Conditions Verification has failed");
		getFidointernetpackagechangerevieworderpage().chkConsentCheckbox();
		getReporter().reportLogWithScreenshot("Consent Check has Done");
		getReporter().hardAssert(getFidointernetpackagechangerevieworderpage().verifySubmitButtonEnabled(),"button enabled","button disabled");
		getFidointernetpackagechangerevieworderpage().clkReviewSubmitButton();
		getReporter().reportLogWithScreenshot("Order Submitted");
		getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Plan Upgrade success", "Plan Upgrade Failed");
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
