package ca.fido.test.commonbusiness;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.annotations.Listeners;

@Listeners ({ca.fido.test.listeners.TestListener.class 
	, ca.fido.test.listeners.AnnotationTransformer.class 
	, ca.fido.test.listeners.TestListener.class })

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
		baseTestClass.fido_login_page.setUsernameInFrame(strUserName);
		baseTestClass.fido_login_page.setPasswordInFrame(strPassword);
		baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered.");
		baseTestClass.fido_login_page.clkLoginInFrame();	
		
	}
	
	/**
	 * Resets the password back from the profile and setting page
	 * @param oldPassword for Application
	 * @param newPassword for Application
	 * @author Mirza.Kamran
	 */
	public void resetPasswordBack(String oldPassword, String newPassword) {
		baseTestClass.reporter.reportLogWithScreenshot("Account overview page");
		baseTestClass.fido_account_overview_page.clkSubNavProfileAndSettings();
		baseTestClass.reporter.reportLogWithScreenshot("Click performed on profile and settings");
		baseTestClass.fido_profile_and_setting_page.clkChangePassword();				
		baseTestClass.fido_profile_and_setting_page.setNewPassword(oldPassword, newPassword);
		baseTestClass.reporter.reportLogWithScreenshot("Password enetered , Old passowrd: "+oldPassword+" and New Password: "+newPassword);
		baseTestClass.fido_profile_and_setting_page.clkSaveButton();
	}
	
	
	public void navigateToDashBoardPageFromUsageAndBillings() {
		
	}
	
	public void scrollToMiddleOfWebPage() {
		baseTestClass.fido_account_overview_page.scrollToMiddleOfPage();
	}
	

	public void scrollToTopOfWebPage() {
		baseTestClass.fido_account_overview_page.scrollToTopOfPage();
	}
	

	public void scrollToBottomOfWebPage() {
		baseTestClass.fido_account_overview_page.scrollToBottomOfPage();
	}
	
	/**
	 * Log out and re sign In
	  * @param strUserName for Application
	 * @param strPassword for Application
	 * @author Mirza.Kamran
	 */
	public void logOutAndResignIn(String strUserName, String strPassword) {			
		baseTestClass.fido_login_page.clkSignOut();
		baseTestClass.reporter.reportLogWithScreenshot("Sign Out");
		baseTestClass.reporter.reportLogWithScreenshot("Checking if easy login is displayed");
		if(baseTestClass.fido_home_page.isEasyloginDisplayed())
		{
			baseTestClass.fido_home_page.clkEasylogin();
			baseTestClass.reporter.reportLogWithScreenshot("Easy login clicked");
		}
		baseTestClass.reporter.reportLogWithScreenshot("Click on resign in");
		baseTestClass.fido_login_page.clkResignInAs();
		baseTestClass.reporter.reportLogWithScreenshot("Re Sign In");		
		baseTestClass.fido_login_page.switchToSignInFrame();
//		baseTestClass.fido_home_page.clkNotUser();
		baseTestClass.fido_login_page.setUsernameInFrameAfterReSignIn(strUserName);
		baseTestClass.fido_login_page.setPasswordInFrame(strPassword);
		baseTestClass.reporter.reportLogWithScreenshot("Login credentials entered");
		baseTestClass.fido_login_page.clkLoginInFrame();		
		baseTestClass.reporter.hardAssert(!baseTestClass.fido_login_page.verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed");
		baseTestClass.fido_login_page.switchOutOfSignInFrame();
	}
	
	
	/**
	 * Log out and re sign In
	  * @param strUserName for Application
	 * @param strPassword for Application
	 * @author Mirza.Kamran
	 * @throws InterruptedException 
	 */
	public void logOutAndResignInMobile(String strUserName, String strPassword) throws InterruptedException {	
		baseTestClass.reporter.reportLogWithScreenshot("Starting sign out scenario");
		baseTestClass.fido_home_page.clkNavMobile();
		baseTestClass.reporter.reportLogWithScreenshot("Clicked Navigation elipsis");
		baseTestClass.fido_login_page.clkSignOutMobile();
		baseTestClass.reporter.reportLogWithScreenshot("Sign Out clicked.");
		baseTestClass.reporter.reportLogWithScreenshot("waiting to check easy login page is avaialable or not...");
		if(baseTestClass.fido_home_page.isEasyloginDisplayedMobile())
		{
			baseTestClass.reporter.reportLogWithScreenshot("Easy login page is available");
			baseTestClass.fido_home_page.clkEasylogin();
			baseTestClass.reporter.reportLogWithScreenshot("Easy login is clicked.");
		}
		baseTestClass.reporter.reportLogWithScreenshot("Click Navigate To Mobile");
		Thread.sleep(10000);
		baseTestClass.fido_home_page.clkNavMobile();
		baseTestClass.reporter.reportLogWithScreenshot("Navigation menu clicked.");
		baseTestClass.fido_login_page.clkResignInAsMobile();
		baseTestClass.reporter.reportLogWithScreenshot("Clicked ReSign In");
		baseTestClass.fido_login_page.switchToSignInFrame();
		baseTestClass.fido_login_page.setUsernameAfterReSignInFrame(strUserName);
		baseTestClass.fido_login_page.setPasswordInFrame(strPassword);			
		baseTestClass.fido_login_page.clkLoginInFrameMobile();
		baseTestClass.reporter.reportLogWithScreenshot("Relogin steps completed");
		baseTestClass.fido_login_page.switchOutOfSignInFrame();	
	}
	
	
	public void changeToManual() {
		baseTestClass.reporter.reportLogWithScreenshot("Auto payement already set, remove it before changing MOP");
		baseTestClass.fido_payment_options_page.clkRemoveAutomaticPayment();
		baseTestClass.fido_payment_options_page.clkYesCancelButtonIfAskedForAreYouSureOption();
		baseTestClass.fido_payment_options_page.waitForRemovalOfAutoPaymentIsSuccessFulMessageToBeAvailable();
		baseTestClass.reporter.reportLogWithScreenshot("Remove auto payment successful");
		baseTestClass.fido_payment_options_page.clkClose();
	}
	
	public void changeToCC() {
		baseTestClass.fido_payment_options_page.clkPaymentOption(TestDataHandler.paymentInfo.getPaymentType().getCredit());
		baseTestClass.reporter.reportLogWithScreenshot("Change payment option to Credit card selected");
		baseTestClass.fido_payment_options_page.setCreditCardNumberOnChangeMOP(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		baseTestClass.fido_payment_options_page.setExpiryDate(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		baseTestClass.fido_payment_options_page.setCreditcardCVC(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		baseTestClass.reporter.reportLogWithScreenshot("Credit card details entered");
		baseTestClass.fido_payment_options_page.clkContinue();
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheReviewCreditCardIsDisplayed(),
							"review credit card is displayed",
							"review credit card is not displayed");
		baseTestClass.fido_payment_options_page.clkConfirm();
		baseTestClass.reporter.reportLogWithScreenshot("Verify the payment method set to credit card");
		baseTestClass.reporter.hardAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		baseTestClass.reporter.reportLogWithScreenshot("Change MOP Success message");
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		baseTestClass.fido_payment_options_page.clkCloseButton();
	}
	
	public void changeToBank() {
		baseTestClass.fido_payment_options_page.clkPaymentOption(TestDataHandler.paymentInfo.getPaymentType().getBank());
		baseTestClass.reporter.reportLogWithScreenshot("Change method of payment to bank selected");
		baseTestClass.fido_payment_options_page.setBankTransitNumber(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
		baseTestClass.fido_payment_options_page.setInstitutionNumber(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
		baseTestClass.fido_payment_options_page.setAccountNumber(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber());
		baseTestClass.fido_payment_options_page.clkContinue();
		baseTestClass.reporter.hardAssert(baseTestClass.fido_payment_options_page.verifyTnCPageIsOpen(),
							"T n C is displayed",
							"T n C is not displayed");
		baseTestClass.fido_payment_options_page.clkIAcceptTermsAndCondition();
		baseTestClass.reporter.reportLogWithScreenshot("Bank info entered, T n C accepted");
		baseTestClass.fido_payment_options_page.clkContinue();
		baseTestClass.reporter.reportLogWithScreenshot("Verify the payment method set to bank");
		baseTestClass.reporter.hardAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelSuccessMessageIsDisplayed(),
							"Change MOP Success message displayed",
							"Change MOP Success message not displayed");
		baseTestClass.reporter.reportLogWithScreenshot("Change MOP Success message");
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelYourFutureBillsIsDisplayed(),
							"Label your future bill is displayed",
							"Label your future bill is not displayed");
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelPaymentMethodEndingInIsDisplayed(),
							"Payment method ending in displayed",
							"Payment method ending in not displayed");
		baseTestClass.reporter.softAssert(baseTestClass.fido_payment_options_page.verifyIfTheLabelAutomaticPaymentEffectIsDisplayed(),
							"label automatic payment effects displayed",
							"label automatic payment effects not displayed");
		
		//commenting the below check point due to stroy : DC-2754
		/* reporter.softAssert(fido_payment_options_page.verifyIfTheButtonPayBalanceIsDisplayed(),
							"Button pay balance is displayed",
							"Button pay balance is not displayed"); */
		baseTestClass.fido_payment_options_page.clkCloseButton();	
	}
	
}
