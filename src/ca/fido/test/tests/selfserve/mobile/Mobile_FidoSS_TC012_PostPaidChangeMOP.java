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
	
	
	@Test(groups = {"MobileSanitySS","MobileBillingAndPaymentsSS"})
	public void mobilePostPaidChangeMOP() {
		getFidohomepage().clkNavMobile();
		getReporter().reportLogWithScreenshot("Launched the Navgation card");	
		getFidohomepage().clkLoginMobile();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc121315.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrameMobile();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		String strBAN = TestDataHandler.tc121315.getaccountDetails().getBan();
		getFidoaccountoverviewpage().clkViewBillNew(strBAN);
		getReporter().reportLogWithScreenshot("View bill page is open");
		getFidobilldetailspage().clkChangePaymentMethod();
		//getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyPaymentMethodModalDisplayed(),
				"Change payment method modal displayed.",
				"Change payment method modal didn't display as expected.");
		getReporter().reportLogWithScreenshot("Change Method of payment overlay");
		if(getFidopaymentoptionspage().isAutopaymentAlreadySet())
		{
			getReporter().reportLogWithScreenshot("Auto payement already set, remove it before changing MOP");
			getFidopaymentoptionspage().clkRemoveAutomaticPayment();
			getFidopaymentoptionspage().clkYesCancelButtonIfAskedForAreYouSureOption();
			getFidopaymentoptionspage().waitForRemovalOfAutoPaymentIsSuccessFulMessageToBeAvailable();
			getReporter().reportLogWithScreenshot("Auto payment successful");
			getFidopaymentoptionspage().clkClose();
			getFidobilldetailspage().clkChangePaymentMethod();
		}
		getFidopaymentoptionspage().clkPaymentOptionMobile(TestDataHandler.paymentInfo.getPaymentType().getCredit());
		getReporter().reportLogWithScreenshot("Change payment option to Credit card selected");
		getFidopaymentoptionspage().setCreditCardNumberOnChangeMOP(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		getFidopaymentoptionspage().setExpiryDate(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		getFidopaymentoptionspage().setCreditcardCVCMobile(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		getReporter().reportLogWithScreenshot("Credit card details entered");
		getFidopaymentoptionspage().clkContinue();
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheReviewCreditCardIsDisplayed(),
							"review credit card is displayed",
							"review credit card is not displayed");
		getFidopaymentoptionspage().clkConfirm();
		getReporter().reportLogWithScreenshot("Verify the payment me		thod set to credit card");
		getReporter().hardAssert(getFidopaymentoptionspage().verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		
		//commenting the below check point due to story : DC-2754
		/* getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheButtonPayBalanceIsDisplayed(),
							"Button pay balance is displayed",
							"button pay balanc is not displayed"); */
		getFidopaymentoptionspage().clkCloseButton();		
		getFidobilldetailspage().clkAccountOverviewMobile();
		getReporter().reportLogWithScreenshot("Account overview page");
		//getFidoaccountoverviewpage().clkChangeMethodOfPayment();
		getFidoaccountoverviewpage().clkPenIconForChangePaymentMethod();
		getReporter().reportLogWithScreenshot("Change method of payment");
		getCommonbusinessflows().scrollToMiddleOfWebPage();
		getFidopaymentoptionspage().clkPaymentOptionMobile(TestDataHandler.paymentInfo.getPaymentType().getBank());
		getReporter().reportLogWithScreenshot("Change method of payment to bank selected");
		getFidopaymentoptionspage().setBankTransitNumberMobile(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
		getFidopaymentoptionspage().setInstitutionNumberMobile(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
		getFidopaymentoptionspage().setAccountNumberMobile(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber());
		getFidopaymentoptionspage().clkContinue();
		getReporter().hardAssert(getFidopaymentoptionspage().verifyTnCPageIsOpenMobile(),
							"T n C is displayed",
							"T n C is not displayed");
		getFidopaymentoptionspage().clkIAcceptTermsAndCondition();
		getReporter().reportLogWithScreenshot("Bank info entered, T n C accepted");
		getFidopaymentoptionspage().clkContinue();
		getReporter().reportLogWithScreenshot("Verify the payment method set to bank");
		getReporter().hardAssert(getFidopaymentoptionspage().verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		
		//commenting the below check point due to stroy : DC-2754
		/* getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheButtonPayBalanceIsDisplayed(),
							"Button pay balance is displayed",
							"Button pay balance is not displayed"); */
		getFidopaymentoptionspage().clkCloseButton();		
				
		
	}
	
	

}
