package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoAccountRegistrationPage extends BasePageClass {

	public FidoAccountRegistrationPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//button[@class='ute-primary-button']")
	WebElement btnRegisterNow;
	
	@FindBy(xpath="//button[@translate='ute.easy.login.registration.accountHolder']")
	WebElement btnAccountHolder;
	
	@FindBy (xpath = "//button[@translate='ute.easy.login.registration.subscriber']")
	WebElement btnSubscriber;
	
	@FindBy(name="accountNumber")
	WebElement txtFidoAccountNumber;
	
	@FindBy(id="postalCode-field")
	WebElement txtPostalCode;
	
	@FindBy(xpath="//button[@class='ute-secondary-button']")
	WebElement btnContinueAccountRegister;	
	
	@FindBy (name = "phoneNumber")
	WebElement txtMobilePhoneNumber;
	
	@FindBy (xpath = "//button[@translate='ute.easy.login.common.continue']")
	WebElement btnContinueAfterPhoneNumber;
	
	@FindBy(name= "email")
	WebElement txtEmail;

	@FindBy(name= "confirmEmail")
	WebElement txtConfirmEmail;
		
	@FindBy(xpath="//button[@class='ute-secondary-button']")
	WebElement btnSecondaryButtonAccountRegister;
			
	@FindBy(xpath="//input[@class='form-control']")
	WebElement txtMailnatorEmail;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement btnMailnatorInbox;
	
	//mail.com
	@FindBy(id = "login-button")
	WebElement btnLoginMailDotCom;
	
	@FindBy(id = "login-email")
	WebElement txtMailDotComEmail;
	
	@FindBy(id = "login-password")
	WebElement txtMailDotComPassword;
	
	@FindBy(xpath="//button[@class='btn btn-block login-submit']")
	WebElement btnMailnatorAccountLogin;
	
	@FindBy(xpath="//span[@class='number bg']")
	WebElement btnUnreadMails;
	
	@FindBy(xpath="//div[@class='fdl-navmain-inner']//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkMyAccount; 
	
	@FindBy (xpath = "//div[@translate='ute.easy.login.registration.verify.header']")
	WebElement divVerificationEmailMsg;
	
	@FindBy (xpath = "//div[@class='elr-email-verify-info']//button[contains(text(),'SEND EMAIL') or contains(text(),'ENVOYER UN COURRIEL')]")
	WebElement btnSendEmail;

	@FindBy(xpath="//div[@translate='ute.easy.login.registration.account.eck6']")
	WebElement lblErroraccountcancelledOrSuspended; 
	
	@FindBy (xpath = "//div[@translate='ute.easy.login.registration.email.ecd5']")
	WebElement errorMsgEmailUsed;
	
	@FindBy (xpath = "//button[@translate='ute.easy.login.registration.prepaidCustomers']")
	WebElement btnPrepaidCustomer;
	
	@FindBy (xpath = "//input[@id='email']")
	WebElement inputEmail;
	
	@FindBy (xpath = "//input[@id='confirmEmail']")
	WebElement inputConfirmEmail;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement inputPassword;
	
	@FindBy (xpath = "//input[@id='confirmPassword']")
	WebElement inputConfirmPassword;
	
	@FindBy (xpath = "//ins[contains(text(),'Continue')]")
	WebElement btnContinuePrepaidReg;
	
	@FindBy (xpath = "//span[@class='font-heavy emailRegisteredRecently']")
	WebElement msgPrepaidEmailSent;
	
	@FindBy (xpath = "//ins[contains(text(),'Okay')]")
	WebElement btnPrepaidOkay;
	
	/**
	 * Click on the My Account link
	 * @author Mirza.Kamran
	 */
	public void clkMyAccount() {
		reusableActions.clickWhenReady(lnkMyAccount,2);
	}
	
	/**
	 * Clicks on the 'Register' link on the Sign-in overlay
	 * @author chinnarao.vattam 
	 */
	public void clkRegisterNow() {
		reusableActions.clickWhenReady(btnRegisterNow,2);
	}
	
	/**
	 * Clicks on the 'AccountHolder' button
	 * @author chinnarao.vattam 
	 */
	public void clkAccountHolder() {
		reusableActions.clickWhenReady(btnAccountHolder,2);
	}
	
	/**
	 * Clicks on the 'Subscriber' button 
	 * @author chinnarao.vattam 
	 */
	public void clkSubscriber() {
		reusableActions.clickWhenReady(btnSubscriber,2);
	} 
	
	/**
	 * Clicks on the 'Prepaid Customer' button 
	 * @author ning.xue
	 */
	public void clkPrepaidCustomer() {
		reusableActions.clickWhenReady(btnPrepaidCustomer,2);
	}
	
	/**
	 * Enters the email to register
	 * @param strFidoPrepaidEmail, String, Fido account email to register
	 * @author ning.xue
	 */
	public void setFidoPrepaidEmail(String strFidoPrepaidEmail) {
		reusableActions.getWhenReady(inputEmail, 10).clear();
		reusableActions.getWhenReady(inputEmail,3).sendKeys(strFidoPrepaidEmail);
	}
	
	/**
	 * Enters the confirm email to register
	 * @param strFidoPrepaidEmail, String, Fido account email to register
	 * @author ning.xue
	 */
	public void setConfirmFidoPrepaidEmail(String strFidoPrepaidEmail) {
		reusableActions.getWhenReady(inputConfirmEmail, 3).clear();
		reusableActions.getWhenReady(inputConfirmEmail,3).sendKeys(strFidoPrepaidEmail);
	} 
	
	/**
	 * Enters the password to register
	 * @param strFidoPrepaidPassword, String, Fido account password to register
	 * @author ning.xue
	 */
	public void setFidoPrepaidPassword(String strFidoPrepaidPassword) {
		reusableActions.getWhenReady(inputPassword, 3).clear();
		reusableActions.getWhenReady(inputPassword,3).sendKeys(strFidoPrepaidPassword);
	}
	
	/**
	 * Enters the confirm password to register
	 * @param strFidoPrepaidPassword, String, Fido account password to register
	 * @author ning.xue
	 */
	public void setConfirmFidoPrepaidPassword(String strFidoPrepaidPassword) {
		reusableActions.getWhenReady(inputConfirmPassword, 3).clear();
		reusableActions.getWhenReady(inputConfirmPassword,3).sendKeys(strFidoPrepaidPassword);
	} 
	
	/**
	 * Clicks on the 'continue' button in prepaid registration flow
	 * @author ning.xue
	 */
	public void clkBtnContinuePrepaidRegister() {
		reusableActions.clickWhenReady(btnContinuePrepaidReg,2);
	} 
	
	/**
	 * Clicks on the 'Okay' button in prepaid registration flow
	 * @author ning.xue
	 */
	public void clkBtnOkayPrepaidRegister() {
		reusableActions.clickWhenReady(btnPrepaidOkay,2);
	}
	
	/**
	 * Enters the Account Number
	 * @param strFidoAccountNumber valid Fido Account Number to be selected
	 * @author chinnarao.vattam
	 */
	public void setFidoAccountNumber(String strFidoAccountNumber) {
		reusableActions.getWhenReady(txtFidoAccountNumber, 3).clear();
		reusableActions.getWhenReady(txtFidoAccountNumber,3).sendKeys(strFidoAccountNumber);
	}
	
	/**
	 * Enters the Postal Code
	 * @param strPostalCode Valid Postal Code in A1A1A1 format 
	 * @author chinnarao.vattam
	 */
	public void setPostalCode(String strPostalCode) {
		reusableActions.getWhenReady(txtPostalCode, 3).clear();
		reusableActions.getWhenReady(txtPostalCode,3).sendKeys(strPostalCode);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author chinnarao.vattam
	 * @return true if successful else false
	 */
	public boolean clkContinueAccountRegister() {
				
		boolean clickSuccess=false;
		int count=0;
		while (count<=2 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Trying to find Ban and postcode");
			reusableActions.clickIfAvailable(btnContinueAccountRegister);			
			if(reusableActions.isElementVisible(lblErroraccountcancelledOrSuspended, 10))
			{				
				count++;
			}else {				
				clickSuccess=true;				
				break;
			}
			
		}
		return clickSuccess;
	}
	
	/**
	 * Check if the button "Send Email" is displayed
	 * @return true if the button displayed, else false.
	 * @author ning.xue
	 */
	public boolean isBtnSendEmailDisplayed() {
		return reusableActions.isElementVisible(btnSendEmail, 10);
	}
	
	/**
	 * Click on the button "Send Email"
	 * @author ning.xue
	 */
	public void clkBtnSendEmail() {
		reusableActions.clickWhenReady(btnSendEmail, 10);
	}
	
	/**
	 * Verifies the message for email sent to registered prepaid account email
	 * @return true if the message is displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyMsgDisplayedForEmailSentToPrepaidRegisteredEmail() {
		return reusableActions.isElementVisible(msgPrepaidEmailSent, 10);
	}
	
	/**
	 * Enters the email on the 'Enter email' field
	 * @param strEmail email address
	 * @author chinnarao.vattam
	 */
	public void setFidoEmail(String strEmail) {
		reusableActions.getWhenReady(txtEmail, 30).clear();
		reusableActions.getWhenReady(txtEmail,3).sendKeys(strEmail);
	}

	/**
	 * Enters the email on the 'Re-enter email' field
	 * @param strConfirmEmail email address for confirm
	 * @author chinnarao.vattam
	 */
	public void setFidoConfirmEmail(String strConfirmEmail) {
		reusableActions.getWhenReady(txtConfirmEmail, 3).clear();
		reusableActions.getWhenReady(txtConfirmEmail,3).sendKeys(strConfirmEmail);
	}
	
	/**
	 * Enters the phone number 
	 * @param strPhoneNumber of the user 
	 * @author chinnarao.vattam
	 */
	public void setPhoneNumber(String strPhoneNumber) {
		reusableActions.getWhenReady(txtMobilePhoneNumber, 3).clear();
		reusableActions.getWhenReady(txtMobilePhoneNumber,3).sendKeys(strPhoneNumber);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author chinnarao.vattam
	 */
	public void clkContinueAfterPhoneNumber() {
		reusableActions.clickWhenReady(btnContinueAfterPhoneNumber,30);
	}

	/**
	 * Clicks on the Account Register button
	 * @author chinnarao.vattam
	 */
	public void clkSecondaryButtonAccountRegister() {
		reusableActions.clickWhenReady(btnSecondaryButtonAccountRegister,2);
	}
	
	/**
	 * Opens up the URL to be open
	 * @param strSpecificURL specific url to be open
	 * @author chinnarao.vattam
	 */
	public void openSpecificUrl(String strSpecificURL) {
		reusableActions.openSpecificUrl(strSpecificURL,10);
	}

	/**
	 * Verifies the error message for cancelled and suspended account
	 * @return true if the error message is displayed otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyErrorMsgDisplayedForCancelledAndSuspendedAccount() {
		return reusableActions.isElementVisible(lblErroraccountcancelledOrSuspended);
	}

	/**
	 * Verify if the verification email sent message is displayed
	 * @return true if the message is displayed, otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyVerificationEmailMsgIsDisplayed() {
		return reusableActions.isElementVisible(divVerificationEmailMsg, 30);
	} 
	
	/**
	 * Verify if the error message "This email is being used by another My Account profile." is displayed
	 * @return true if the message is displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyErrorMsgEmailIsUsedIsDisplayed() {
		return reusableActions.isElementVisible(errorMsgEmailUsed, 30);
	}
		
	/**
	 * Refreshes the page
	 * @author Mirza.Kamran
	 */
	public void pageRefresh() {		
		reusableActions.staticWait(5000);
		reusableActions.getDriver().navigate().refresh();
	}
	
}
