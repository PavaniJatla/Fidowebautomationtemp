package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This test will check the change method of payment functionality
 * works on French and English both
 * @author Rama Arora
 *
 */
public class FidoSS_TC012_PostPaidChangeMOP extends BaseTestClass{

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


	@Test(groups = {"SanitySS","BillingAndPaymentsSS"})
	public void postPaidChangeMOP() {
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(),
				"Login proceed without error.",
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
				"Login succeed.",
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		/*String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().scrollToTopOfPage();
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");
		getFidoaccountoverviewpage().clkChangePaymentMethod();
        getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");
		//sgetFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().reportLogWithScreenshot("Change Method of payment overlay");*/
		if(getFidopaymentoptionspage().isAutopaymentAlreadySet())
		{
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getReporter().reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
			getFidoaccountoverviewpage().clkChangePaymentMethod();
			getFidopaymentoptionspage().clkSwitchToManualPayments();
			//getFidopaymentoptionspage().clkContinue();
			getFidopaymentoptionspage().clkContinue();
			getFidopaymentoptionspage().clkContinue();
			//getFidopaymentoptionspage().clkButtonDoneChangePayment();
			getReporter().reportLogWithScreenshot("Account overveiew page");
			getFidopaymentoptionspage().clkYesCancelAutomaticPayment();
			getReporter().reportLogWithScreenshot("Switch to manual completed");
			getDriver().navigate().refresh();
			getReporter().reportLogWithScreenshot("Account overveiew page page refresh");
			getFidopaymentoptionspage().clkSetUpAutomaticPaymentMethod();
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getFidopaymentoptionspage().clkUseCCForAutomaticPayments();
			//getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());

			String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() +
					TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);
			getFidomakepaymentpage().selectCreditcardExpiryYear(strDDMM);
			getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			getFidomakepaymentpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());

			getReporter().reportLogWithScreenshot("CC details entered");
			getFidomakepaymentpage().clkReviewAndContinueButton();
			//getFidopaymentoptionspage().clkContinueSettingCC();
			getReporter().hardAssert(getFidopaymentoptionspage().isReviewCCDetailsPageDisplayed(),
					"CC Details encrypted msg displayed",
					"CC Details encrypted msg NOT displayed");
			getReporter().reportLogWithScreenshot("CC secured details");

			getFidomakepaymentpage().clkPayNow();
			//getFidopaymentoptionspage().clkContinueOnReviewPg();
			getReporter().hardAssert(getFidopaymentoptionspage().verifySuccessMessageIsDisplayed(),
					"Set up auto payment is successful",
					"Set up auto payment is not successful");
			getReporter().reportLogWithScreenshot("Payment complete page.");

			getFidopaymentoptionspage().clkOnDone();
			//check payment method on overview page
			getDriver().navigate().refresh();
			getReporter().hardAssert(getFidopaymentoptionspage().verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
					,"Auto payment CC details displayed on the account overview page"
					,"Auto payment CC details NOT displayed on the account overview page");
			getReporter().reportLogWithScreenshot("Account overview page, check the payment method.");
		}else
		{
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getFidopaymentoptionspage().clkSetUpAutomaticPaymentMethod();
			getReporter().reportLogWithScreenshot("Set auto payment overlay");
			getFidoaccountoverviewpage().scrollToMiddleOfPage();
			getFidopaymentoptionspage().clkUseCCForAutomaticPayments();
			//getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());

			String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() +
					TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);
			getFidomakepaymentpage().selectCreditcardExpiryYear(strDDMM);
			getFidorefillpage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			getFidomakepaymentpage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());

			getReporter().reportLogWithScreenshot("CC details entered");
			getFidomakepaymentpage().clkReviewAndContinueButton();
			//getFidopaymentoptionspage().clkContinueSettingCC();
			getReporter().hardAssert(getFidopaymentoptionspage().isReviewCCDetailsPageDisplayed(),
					"CC Details encrypted msg displayed",
					"CC Details encrypted msg NOT displayed");
			getReporter().reportLogWithScreenshot("CC secured details");

			getFidomakepaymentpage().clkPayNow();
			//getFidopaymentoptionspage().clkContinueOnReviewPg();
 			getReporter().hardAssert(getFidopaymentoptionspage().verifySuccessMessageIsDisplayed(),
					"Set up auto payment is successful",
					"Set up auto payment is not successful");
			getReporter().reportLogWithScreenshot("Payment complete page.");

			getFidopaymentoptionspage().clkOnDone();
			//check payment method on overview page
			getDriver().navigate().refresh();
			getReporter().hardAssert(getFidopaymentoptionspage().verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
					,"Auto payment CC details displayed on the account overview page"
					,"Auto payment CC details NOT displayed on the account overview page");
			getReporter().reportLogWithScreenshot("Account overview page, check the payment method.");
		}
/*
		getCommonbusinessflows().changeToCC();
		getFidobilldetailspage().clkAccountOverview();
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");

		//Change CC to bank
		getReporter().reportLogWithScreenshot("Change method of payment from CC to BANK");
		getCommonbusinessflows().changeToBank();
		getFidobilldetailspage().clkAccountOverview();
		getReporter().reportLogWithScreenshot("Account overview page");
		getFidoaccountoverviewpage().scrollToBottomOfPage();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");*/

	}



}

