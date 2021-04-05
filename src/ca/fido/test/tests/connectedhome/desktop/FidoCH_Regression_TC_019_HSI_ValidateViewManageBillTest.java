package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.pages.FidoInternetUsagePage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the pay now functionality for Fido.ca   
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Click on pay now option besides Internet icon in dashboard.
 *2. Fill in the amount and the required credit card/bank details.
 *3. Click on the internet icon in dashboard.
 *4. Click on Review and Confirm
 *5. Click on confirm button.
 *6. Verify that message conveying successful payment is displayed.
 *
 **/

public class FidoCH_Regression_TC_019_HSI_ValidateViewManageBillTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","FidoHSIDashboardCH"})
	public void checkFidoHSIPayNowFunctionality() {
		/*getReporter().reportLogWithScreenshot("Launched the Home Page");
		getFidohomepage().clkShop();
		getFidohomepage().clkHomeInternet();
		getReporter().reportLogWithScreenshot("Launched the packages Page");
		getFidoshopinternetpage().selectInternetPlan(TestDataHandler.fidoHSIAccount.getaccountDetails().getDowngradeDataPlan(),TestDataHandler.fidoHSIAccount.getaccountDetails().getUpgradePlanCost());
		getReporter().reportLogWithScreenshot("Launched the serviceability check page");
		getFidoshopinternetpage().clkLoginAtServicebilityModel();*/
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getReporter().reportLogWithScreenshot("Launched the SignIn popup");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsernamePay());
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentials");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		String accountBalanceBeforePayment=getFidoaccountoverviewpage().getAccountBalanceBeforePayment();
		getReporter().reportLogWithScreenshot("Launched the Account overview Page");
		getFidoaccountoverviewpage().clkPayNow();
		getReporter().reportLogWithScreenshot("Launched the payment widget");
		getFidopaymentpage().setPaymentAmount(TestDataHandler.fidoHSIAccount.getaccountDetails().getPayment());
		getReporter().reportLogWithScreenshot("set the payment amount");
		getFidopaymentpage().selectCreditCardOption();
		getReporter().reportLogWithScreenshot("set the Credit Card Option");
		getFidopaymentpage().selectBankOption();
		getReporter().reportLogWithScreenshot("set the Bank Option");
		getFidopaymentpage().clkClosePayments();
		getFidoaccountoverviewpage().clkMenuBillingAndPayments();
		getFidoaccountoverviewpage().clkChangePaymentMethod();
		getReporter().hardAssert(getFidoaccountoverviewpage().isAutomaticPayTextDisplay(),"Automatic Pay model has Displayed","Automatic Pay model hasn't Displayed");
		getReporter().reportLogWithScreenshot("Setup Automatic Payments");
		getFidoaccountoverviewpage().clkAutomaticPayModelClose();
		getFidointernetdashboardpage().clkUsageNService();
		getFidointernetdashboardpage().clkInternetService();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getReporter().hardAssert(getFidointernetdashboardpage().verifyIfDailyUsageLinkVisible(),"Daily Usage link has Displayed","Daily Usage link hasn't Displayed");
		getFidointernetdashboardpage().clkDailyUsage();
		//getReporter().softAssert(getFidoInternetUsagePage().verifyIntrnetDailyUsage(),"Daily Usage has Displayed","Daily Usage hasn't Displayed");
		//getReporter().softAssert(getFidoInternetUsagePage().verifyDailyInternetUsageChart(),"Daily Usage Chart has Displayed","Daily Usage Chart hasn't Displayed");
		getReporter().softAssert(getFidoInternetUsagePage().verifyDailyBreakdown(),"Daily Usage breakdown has Displayed","Daily Usage breakdown  hasn't Displayed");
		//getReporter().softAssert(getFidoInternetUsagePage().verifyDailyBreakdownChart(),"Daily Usage table has Displayed","Daily Usage table hasn't Displayed");
		getFidointernetdashboardpage().clkUsageNService();
		getFidointernetdashboardpage().clkInternetService();
		getReporter().reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getReporter().hardAssert(getFidointernetdashboardpage().verifyIfMonthlyUsageLinkVisible(),"Monthly Usage link has Displayed","Monthly Usage link hasn't Displayed");
		getFidointernetdashboardpage().clkMonthlyUsage();
		getReporter().softAssert(getFidoInternetUsagePage().verifyMonthlyInternetUsage(),"Monthly Usage has Displayed","Monthly Usage hasn't Displayed");
		getReporter().softAssert(getFidoInternetUsagePage().verifyMonthlyUsageChart(),"Monthly Usage Chart has Displayed","Monthly Usage Chart hasn't Displayed");
		getReporter().softAssert(getFidoInternetUsagePage().verifyMonthlyBreakdown(),"Monthly Usage breakdown has Displayed","Monthly Usage breakdown hasn't Displayed");
		getReporter().softAssert(getFidoInternetUsagePage().verifyMonthlyBreakdownChart(),"Monthly Usage table has Displayed","Monthly Usage table hasn't Displayed");
		getFidoInternetUsagePage().clkUsageHistory();
		getReporter().softAssert(getFidoInternetUsagePage().verifyUsageHistory(),"Monthly Usage history has Displayed","Monthly Usage history hasn't Displayed");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method)
			throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.connectedhome_login,method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
