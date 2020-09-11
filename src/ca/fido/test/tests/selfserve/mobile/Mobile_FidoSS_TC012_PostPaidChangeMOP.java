package ca.fido.test.tests.selfserve.mobile;

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
 * @author Mirza.Kamran
 *
 */
public class Mobile_FidoSS_TC012_PostPaidChangeMOP extends BaseTestClass{

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
	
	
	@Test(groups = {"MobileSanitySS","SSBillingAndPayments"})
	public void mobilePostPaidChangeMOP() {
		fido_home_page.clkNavMobile();
		reporter.reportLogWithScreenshot("Launched the Navgation card");	
		fido_home_page.clkLoginMobile();
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		fido_login_page.setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();	
		reporter.hardAssert(!fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		fido_login_page.switchOutOfSignInFrame();
		reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkChangeMethodOfPayment();
		reporter.reportLogWithScreenshot("Change Method of payment overlay");
		if(fido_payment_options_page.isAutopaymentAlreadySet())
		{
			reporter.reportLogWithScreenshot("Auto payement already set, remove it before changing MOP");
			fido_payment_options_page.clkRemoveAutomaticPayment();
			fido_payment_options_page.clkYesCancelButtonIfAskedForAreYouSureOption();
			fido_payment_options_page.waitForRemovalOfAutoPaymentIsSuccessFulMessageToBeAvailable();
			reporter.reportLogWithScreenshot("Auto payment successful");
			fido_payment_options_page.clkClose();
			fido_account_overview_page.clkChangeMethodOfPayment();
		}
		fido_payment_options_page.clkPaymentOption(TestDataHandler.paymentInfo.getPaymentType().getCredit());
		reporter.reportLogWithScreenshot("Change payment option to Credit card selected");
		fido_payment_options_page.setCreditCardNumberOnChangeMOP(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		fido_payment_options_page.setExpiryDate(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		fido_payment_options_page.setCreditcardCVC(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		reporter.reportLogWithScreenshot("Credit card details entered");
		fido_payment_options_page.clkContinue();
		reporter.softAssert(fido_payment_options_page.verifyIfTheReviewCreditCardIsDisplayed(),
							"review credit card is displayed",
							"review credit card is not displayed");
		fido_payment_options_page.clkConfirm();
		reporter.reportLogWithScreenshot("Verify the payment me		thod set to credit card");
		reporter.hardAssert(fido_payment_options_page.verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		reporter.softAssert(fido_payment_options_page.verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		reporter.softAssert(fido_payment_options_page.verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		reporter.softAssert(fido_payment_options_page.verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		
		//commenting the below check point due to stroy : DC-2754
		/* reporter.softAssert(fido_payment_options_page.verifyIfTheButtonPayBalanceIsDisplayed(),
							"Button pay balance is displayed",
							"button pay balanc is not displayed"); */
		fido_payment_options_page.clkCloseButton();
		
		fido_account_overview_page.clkChangeMethodOfPayment();
		reporter.reportLogWithScreenshot("Change method of payment");
		fido_payment_options_page.clkPaymentOption(TestDataHandler.paymentInfo.getPaymentType().getBank());
		reporter.reportLogWithScreenshot("Change method of payment to bank selected");
		fido_payment_options_page.setBankTransitNumber(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
		fido_payment_options_page.setInstitutionNumber(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
		fido_payment_options_page.setAccountNumber(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber());
		fido_payment_options_page.clkContinue();
		reporter.hardAssert(fido_payment_options_page.verifyTnCPageIsOpen(),
							"T n C is displayed",
							"T n C is not displayed");
		fido_payment_options_page.clkIAcceptTermsAndCondition();
		reporter.reportLogWithScreenshot("Bank info entered, T n C accepted");
		fido_payment_options_page.clkContinue();
		reporter.reportLogWithScreenshot("Verify the payment method set to bank");
		reporter.hardAssert(fido_payment_options_page.verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		reporter.softAssert(fido_payment_options_page.verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		reporter.softAssert(fido_payment_options_page.verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		reporter.softAssert(fido_payment_options_page.verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		
		//commenting the below check point due to stroy : DC-2754
		/* reporter.softAssert(fido_payment_options_page.verifyIfTheButtonPayBalanceIsDisplayed(),
							"Button pay balance is displayed",
							"Button pay balance is not displayed"); */
		fido_payment_options_page.clkCloseButton();		
				
		
	}
	
	

}
