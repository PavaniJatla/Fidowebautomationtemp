package ca.fido.test.commonbusiness;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.annotations.Listeners;

@Listeners ({extentreport.ExtentListener.class
	, ca.fido.test.listeners.AnnotationTransformer.class 
	, extentreport.ExtentListener.class })

/**
 * Common business flows
 * @author Mirza.Kamran
 *
 */
public class CommonBusinessFlows {
		
	BaseTestClass baseTestClass; 
	public CommonBusinessFlows(BaseTestClass baseTestClass) {
		this.baseTestClass = baseTestClass;
	}

	/**
	 * Login to fido.ca flow, including verify error message after click login.
	 * @param strUserName for Application
	 * @param strPassword for Application
	 * @author Mirza.Kamran
	 */
	public void loginApplication(String strUserName, String strPassword) {		
		BaseTestClass.getFidologinpage().setUsernameInFrame(strUserName);
		BaseTestClass.getFidologinpage().setPasswordInFrame(strPassword);
		baseTestClass.getReporter().reportLogWithScreenshot("Login Credential is entered.");
		BaseTestClass.getFidologinpage().clkLoginInFrame();	
		
	}
	
	/**
	 * Resets the password back from the profile and setting page
	 * @param oldPassword for Application
	 * @param newPassword for Application
	 * @author Mirza.Kamran
	 */
	public void resetPasswordBack(String oldPassword, String newPassword) {
		baseTestClass.getReporter().reportLogWithScreenshot("Account overview page");
		BaseTestClass.getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		baseTestClass.getReporter().reportLogWithScreenshot("Click performed on profile and settings");
		BaseTestClass.getFidoprofileandsettingpage().clkChangePassword();				
		BaseTestClass.getFidoprofileandsettingpage().setNewPassword(oldPassword, newPassword);
		baseTestClass.getReporter().reportLogWithScreenshot("Password enetered , Old passowrd: "+oldPassword+" and New Password: "+newPassword);
		BaseTestClass.getFidoprofileandsettingpage().clkSaveButton();
	}
	
	
	public void navigateToDashBoardPageFromUsageAndBillings() {
		
	}
	
	public void scrollToMiddleOfWebPage() {
		BaseTestClass.getFidoaccountoverviewpage().scrollToMiddleOfPage();
	}
	

	public void scrollToTopOfWebPage() {
		BaseTestClass.getFidoaccountoverviewpage().scrollToTopOfPage();
	}
	

	public void scrollToBottomOfWebPage() {
		BaseTestClass.getFidoaccountoverviewpage().scrollToBottomOfPage();
	}
	
	/**
	 * Log out and re sign In
	  * @param strUserName for Application
	 * @param strPassword for Application
	 * @author Mirza.Kamran
	 */
	public void logOutAndResignIn(String strUserName, String strPassword) {			
		BaseTestClass.getFidologinpage().clkSignOut();
		baseTestClass.getReporter().reportLogWithScreenshot("Sign Out");
		baseTestClass.getReporter().reportLogWithScreenshot("Checking if easy login is displayed");
		if(BaseTestClass.getFidohomepage().isEasyloginDisplayed())
		{
			BaseTestClass.getFidohomepage().clkEasylogin();
			baseTestClass.getReporter().reportLogWithScreenshot("Easy login clicked");
		}
		baseTestClass.getReporter().reportLogWithScreenshot("Click on resign in");
		//BaseTestClass.getFidologinpage().clkResignInAs();
		baseTestClass.getReporter().reportLogWithScreenshot("Re Sign In");		
		BaseTestClass.getFidologinpage().switchToSignInFrame();
		BaseTestClass.getFidohomepage().clkNotUser();
		BaseTestClass.getFidologinpage().setUsernameInFrameAfterReSignIn(strUserName);
		BaseTestClass.getFidologinpage().setPasswordInFrame(strPassword);
		baseTestClass.getReporter().reportLogWithScreenshot("Login credentials entered");
		BaseTestClass.getFidologinpage().clkLoginInFrame();		
		baseTestClass.getReporter().hardAssert(!BaseTestClass.getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed");
		BaseTestClass.getFidologinpage().switchOutOfSignInFrame();
	}
	
	
	/**
	 * Log out and re sign In
	  * @param strUserName for Application
	 * @param strPassword for Application
	 * @author Mirza.Kamran
	 * @throws InterruptedException 
	 */
	public void logOutAndResignInMobile(String strUserName, String strPassword) throws InterruptedException {	
		baseTestClass.getReporter().reportLogWithScreenshot("Starting sign out scenario");
		BaseTestClass.getFidohomepage().clkNavMobile();
		baseTestClass.getReporter().reportLogWithScreenshot("Clicked Navigation elipsis");
		BaseTestClass.getFidologinpage().clkSignOutMobile();
		baseTestClass.getReporter().reportLogWithScreenshot("Sign Out clicked.");
		baseTestClass.getReporter().reportLogWithScreenshot("waiting to check easy login page is avaialable or not...");
		if(BaseTestClass.getFidohomepage().isEasyloginDisplayedMobile())
		{
			baseTestClass.getReporter().reportLogWithScreenshot("Easy login page is available");
			BaseTestClass.getFidohomepage().clkEasylogin();
			baseTestClass.getReporter().reportLogWithScreenshot("Easy login is clicked.");
		}
		baseTestClass.getReporter().reportLogWithScreenshot("Click Navigate To Mobile");
		Thread.sleep(10000);
		BaseTestClass.getFidohomepage().clkNavMobile();
		baseTestClass.getReporter().reportLogWithScreenshot("Navigation menu clicked.");
		BaseTestClass.getFidologinpage().clkResignInAsMobile();
		baseTestClass.getReporter().reportLogWithScreenshot("Clicked ReSign In");
		BaseTestClass.getFidologinpage().switchToSignInFrame();
		BaseTestClass.getFidologinpage().setUsernameAfterReSignInFrame(strUserName);
		BaseTestClass.getFidologinpage().setPasswordInFrame(strPassword);			
		BaseTestClass.getFidologinpage().clkLoginInFrameMobile();
		baseTestClass.getReporter().reportLogWithScreenshot("Relogin steps completed");
		BaseTestClass.getFidologinpage().switchOutOfSignInFrame();	
	}
	
	
	public void changeToManual() {
		baseTestClass.getReporter().reportLogWithScreenshot("Auto payement already set, remove it before changing MOP");
		BaseTestClass.getFidopaymentoptionspage().clkRemoveAutomaticPayment();
		BaseTestClass.getFidopaymentoptionspage().clkYesCancelButtonIfAskedForAreYouSureOption();
		BaseTestClass.getFidopaymentoptionspage().waitForRemovalOfAutoPaymentIsSuccessFulMessageToBeAvailable();
		baseTestClass.getReporter().reportLogWithScreenshot("Remove auto payment successful");
		BaseTestClass.getFidopaymentoptionspage().clkClose();
	}
	
	public void changeToCC() {
		BaseTestClass.getFidopaymentoptionspage().clkPaymentOption(TestDataHandler.paymentInfo.getPaymentType().getCredit());
		baseTestClass.getReporter().reportLogWithScreenshot("Change payment option to Credit card selected");
		BaseTestClass.getFidopaymentoptionspage().setCreditCardNumberOnChangeMOP(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		BaseTestClass.getFidopaymentoptionspage().setExpiryDate(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		BaseTestClass.getFidopaymentoptionspage().setCreditcardCVC(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		baseTestClass.getReporter().reportLogWithScreenshot("Credit card details entered");
		BaseTestClass.getFidopaymentoptionspage().clkContinue();
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheReviewCreditCardIsDisplayed(),
							"review credit card is displayed",
							"review credit card is not displayed");
		BaseTestClass.getFidopaymentoptionspage().clkConfirm();
		baseTestClass.getReporter().reportLogWithScreenshot("Verify the payment method set to credit card");
		baseTestClass.getReporter().hardAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		baseTestClass.getReporter().reportLogWithScreenshot("Change MOP Success message");
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		BaseTestClass.getFidopaymentoptionspage().clkCloseButton();
	}
	
	public void changeToBank() {
		BaseTestClass.getFidopaymentoptionspage().clkPaymentOption(TestDataHandler.paymentInfo.getPaymentType().getBank());
		baseTestClass.getReporter().reportLogWithScreenshot("Change method of payment to bank selected");
		BaseTestClass.getFidopaymentoptionspage().setBankTransitNumber(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
		BaseTestClass.getFidopaymentoptionspage().setInstitutionNumber(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
		BaseTestClass.getFidopaymentoptionspage().setAccountNumber(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber());
		BaseTestClass.getFidopaymentoptionspage().clkContinue();
		baseTestClass.getReporter().hardAssert(BaseTestClass.getFidopaymentoptionspage().verifyTnCPageIsOpen(),
							"T n C is displayed",
							"T n C is not displayed");
		BaseTestClass.getFidopaymentoptionspage().clkIAcceptTermsAndCondition();
		baseTestClass.getReporter().reportLogWithScreenshot("Bank info entered, T n C accepted");
		BaseTestClass.getFidopaymentoptionspage().clkContinue();
		baseTestClass.getReporter().reportLogWithScreenshot("Verify the payment method set to bank");
		baseTestClass.getReporter().hardAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		baseTestClass.getReporter().reportLogWithScreenshot("Change MOP Success message");
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		baseTestClass.getReporter().softAssert(BaseTestClass.getFidopaymentoptionspage().verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		
		//commenting the below check point due to stroy : DC-2754
		/* getReporter().softAssert(getFidopaymentoptionspage().verifyIfTheButtonPayBalanceIsDisplayed(),
							"Button pay balance is displayed",
							"Button pay balance is not displayed"); */
		BaseTestClass.getFidopaymentoptionspage().clkCloseButton();	
	}
	
}
