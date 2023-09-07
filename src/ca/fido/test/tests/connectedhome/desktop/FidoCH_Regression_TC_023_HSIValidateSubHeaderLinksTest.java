package ca.fido.test.tests.connectedhome.desktop;

import ca.fido.pages.FidoAccountOverviewPage;
import ca.fido.pages.FidoBillDetailsPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test subheader navigation options / links on Internet Dashboard page
 * TC005_CH-24638_Fido Subheader is missing for Internet Customer_ON_CH_EN
 * @author nandan.master
 * <p>
 * Test steps:
 * <p>
 * 1. Load fido.ca url.
 * 2. Login with valid credentials
 * 3. Click on Shop --> Home Internet
 * 4. Validate if Internet Dashboard page is loading correctly
 * 5. Validate Profile & Settings menu option is present
 * 6. Click on Billing & Payments menu
 * 7. Select View Bill link from the menu options
 * 8. Validate the user is landed to Your Bill & Accounts page successfully
 * 9. Click on Billing & Payment submenu on the same page
 * 10. Select Make a Payment option & validate that the user is landed on Payments Page
 * 11. Navigate to the Internet Dashboard page
 * 12. Click on Billing & Payments menu
 * 13. Select Payments History link from the menu options
 * 14. Validate that the Payments History page is loaded correctly
 * 15. Go back and click on expand Usage & Services Menu
 * 16. Select Internet Services from menu options
 * 17. Validate if Internet Usage page is loaded correctly
 **/

public class FidoCH_Regression_TC_023_HSIValidateSubHeaderLinksTest extends BaseTestClass {

	@Test(groups = {"RegressionCH", "FidoHSIDashboardCH"})
	public void FidoCH_Regression_TC_023_HSIValidateSubHeaderLinks() throws InterruptedException {
		getReporter().reportLogWithScreenshot("Launched the sign in Page");
		getFidologinpage().setUsernameInFrame(TestDataHandler.fidoHSIAccount.getUsername());
		getReporter().reportLogWithScreenshot("Continue Login");
		getFidologinpage().clkContinueSignIn();
		getFidologinpage().setPasswordInFrame(TestDataHandler.fidoHSIAccount.getPassword());
		getReporter().reportLogWithScreenshot("Entered the account credentials");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidoaccountoverviewpage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
		getReporter().reportLogWithScreenshot("Launched the Account Page");
//		getDriver().get(System.getProperty("QaUrl") + "/internet/packages?icid=F_WIR_CNV_XD66OS"); --> shop option can be replaced by URL in case header links are not functional in QA env

		/* Note: To navigate through Shop options, user needs to make two attempts. Script to be modified once the issue is resolved. */
		getFidohomepage().clkShop();
		getReporter().reportLogWithScreenshot("Clicked on Shop option");
		getFidohomepage().clkHomeInternet();
		getReporter().reportLogWithScreenshot("Clicked on Home Internet from Shop options - #1");
		getReporter().softAssert(getFidoaccountoverviewpage().verifyLandingPageLoad(),
				"User is directed to Account Overview Page",
				"User is NOT directed to Account Overview Page as expected");
		getFidohomepage().clkShop();
		getFidohomepage().clkHomeInternet();
		getReporter().reportLogWithScreenshot("Clicked on Home Internet from Shop options - #2");
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfUsageInfoDisplayed(), "Verified the Internet Dashboard is loaded", "Internet Dashboard is NOT loaded as expected");

		getReporter().hardAssert(getFidointernetdashboardpage().verifyProfileNSettings(), "Verified Profile & Setting navigation on subheader", "Profile & Setting navigation on subheader not verified");

		getFidoaccountoverviewpage().clkMenuBillingAndPayments();
		getReporter().reportLogWithScreenshot("Clicked on Billing & Payment menu dropdown");
		getFidoaccountoverviewpage().selectBillingAndpaymentsSubMenus(FidoAccountOverviewPage.BillingAndPaymentsSubMenuOptions.ViewBill);
		getReporter().hardAssert(getFidoaccountoverviewpage().validateUserIsDirectedToInvoiceHistoryPageSuccessFully(),
				"User is directed to the Your Bill & Account Balance Page",
				"User is NOT directed to the Your Bill & Account Balance Page as expected");
		getFidobilldetailspage().selectBillingAndPaymentsSubMenus(FidoBillDetailsPage.BillinAndPaymentsOpt.MakePayment);
		getReporter().reportLogWithScreenshot("Clicked on Make payment link from Billing & Payments submenu");
		getReporter().hardAssert(getFidopaymentpage().verifyPaymentDetailsPage(),
				"Payment Details Page is loaded correctly",
				"Payment Details Page is NOT loaded as expected");

		getDriver().get(System.getProperty("QaUrl") + "/internet/packages");
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfUsageInfoDisplayed(), "Internet Dashboard page is loaded", "Internet Dashboard page is NOT loaded");

		getFidoaccountoverviewpage().clkMenuBillingAndPayments();
		getFidoaccountoverviewpage().selectBillingAndpaymentsSubMenus(FidoAccountOverviewPage.BillingAndPaymentsSubMenuOptions.PaymentHistory);
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyPaymentHistoryButton(),
				"User is directed to the Payments History page",
				"User is NOT directed to the Payments History page as expected");
		getDriver().navigate().back();

		getFidoaccountoverviewpage().clkMenuUsageNService();
		getReporter().reportLogWithScreenshot("Clicked on Usage & Services sub-nav ");
		getFidointernetdashboardpage().clkInternetService();
		getReporter().softAssert(getFidointernetdashboardpage().verifyIfUsageInfoDisplayed(), "Verified the Data Usage summary", "Data Usage summary Verification has failed");

	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, FidoEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
