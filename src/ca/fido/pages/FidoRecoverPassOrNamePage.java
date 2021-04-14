package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class FidoRecoverPassOrNamePage extends BasePageClass {
	
	public FidoRecoverPassOrNamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//img[@src='assets/images/password-icon.png']")
	WebElement btnPassword;
	
	@FindBy (xpath = "//img[@src='assets/images/userName-icon.png']")
	WebElement btnUserName;
	
	@FindBy (xpath = "//img[@src='assets/images/both-icon.png']")
	WebElement btnBoth;
	
	@FindBy (xpath = "//input[@formcontrolname='emailAddress']")
	WebElement txtEmailAddress;

	@FindAll({
			@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continuer')]/ancestor::button"),
			@FindBy (xpath = "//button[contains(text(),'Continue') or contains(text(),'Continuer')]"),
			@FindBy (xpath = "//button[@class='primary-button state-btn']"),
			@FindBy (xpath = "//button[contains(@class,'primary-button state-btn')]")
	})
	WebElement btnContinue;
	
	@FindBy (xpath = "//div[@class='email-recovery-method']/button")
	WebElement btnEmailNow;
	
	@FindBy (xpath = "//div[@class='sms-recovery-method']/button")
	WebElement btnTextNow;
	
	@FindBy (xpath = "//input[@formcontrolname='smsCode']")
	WebElement txtCode;
	
	@FindBy (xpath = "//button[@class='primary-button state-btn']")
	WebElement btnVerifyMe;
	
	@FindBy (xpath = "//input[@id='password' or @formcontrolname='newPassword']")
	WebElement txtNewPass;

	@FindBy (xpath = "//input[@formcontrolname='newPassword']/parent::div")
	WebElement lblNewPass;
	
	@FindBy (xpath = "//input[@id='confirmPassword' or @formcontrolname='confirmPassword']")
	WebElement txtConfirmNewPass;

	@FindBy (xpath = "//input[@formcontrolname='confirmPassword']/parent::div")
	WebElement lblConfirmNewPass;
	
	@FindBy (xpath = "//button[@class='primary-button state-btn']")
	WebElement btnSetPassword;

	@FindBy(xpath = "//button[text()='Text Now' or text()='Envoyer un texto']")
	WebElement btnTextToRecovery; 
	
	@FindBy(xpath = "//*[@id='signin-interceptor-modal']//iframe")
	WebElement iframe;

	@FindBy(xpath = "//button[@class='primary-button state-btn' or text()='LOG IN TO MY ACCOUNT' or contains(text(),' MON COMPTE')]")
	WebElement btnLogInToMyAccount;

	@FindBy(xpath = "//span[text()='Your password has been reset!' or contains(text(),'Votre mot de passe a')]")
	WebElement txtYourPasswordHasBeenReset;
	
	@FindBy(xpath = "//i[@class='rogers-icon-circle-x']")
	WebElement btnCloseWeHaveTextedUserNameOverlay;

	@FindBy(xpath = "//input[@formcontrolname='accountNumber']")
	WebElement txtAcountNumber;
	
	@FindBy (xpath = "//td[contains(text(),'Your username is') or contains(text(),'utilisateur est')]")
	WebElement lblYourUsername;
	
	@FindBy (xpath = "//img[@alt='Return to sign in' or @alt='Ouvrir une session']")
	WebElement btnReturnToSignin;

	@FindBy(xpath = "//td[text()=' Verification code: ' or contains(text(),'Code de v')]/parent::tr/following-sibling::tr/td")
	WebElement lblYourVerificationCode;

	@FindBy(xpath = "//input[@formcontrolname='username' or @title=\"Enter your email to receive a verification code\"]")
	WebElement txtUsername;

	@FindBy(xpath = "//ds-code-input/div/div[1]/input")
	WebElement inputCode;

	@FindBy(xpath = "//h1//span[text()='Success!' or contains(text(),'ussi!')]")
	WebElement lblYourPasswordHasBeenReset;

	@FindBy(xpath = "//span[text()='Create a new My Account password for: ' or contains(text(),'ez un nouveau mot de passe MonRogers pour')]/following-sibling::span")
	WebElement lblSetPasswordForUserName;


	@FindBy(xpath = "//button[@title='Go to your Fido My Account']")
	WebElement btnGoToMyFido;

	@FindBy(xpath = "//a[text()='Use your account information instead.'or contains(text(),'t les renseignements de votre compte')]")
	WebElement lnkUseYourAccountInfoInstead;

	@FindBy(xpath = "//input[@formcontrolname='postalCode']/parent::div")
	WebElement lblPostCode;

	@FindBy(xpath = "//input[@formcontrolname='postalCode']")
	WebElement txtPostCode;

	@FindBy(xpath = "//input[@formcontrolname='dob']/parent::div")
	WebElement lblDOB;

	@FindBy(xpath = "//input[@formcontrolname='dob']")
	WebElement txtDOB;

	@FindBy(xpath = "//input[@formcontrolname='accountNumber']/parent::div")
	WebElement lblAccountNumber;

	public void clkBtnPassword() {
		reusableActions.getWhenVisible(btnPassword).click();
	}
	
	/**
	 * Click on the UserName button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnUserName() {
		reusableActions.getWhenVisible(btnUserName).click();
	}
	
	/**
	 * Click on Both button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnBoth() {
		reusableActions.getWhenVisible(btnBoth).click();
	}
	
	/**
	 * Input user name (email address) to the text area.
	 * @param strUsername, String, use email address as user name.
	 * @author ning.xue
	 */
	public void setEmailAddress(String strUsername) {
		reusableActions.getWhenReady(txtEmailAddress).clear();
		reusableActions.getWhenReady(txtEmailAddress).sendKeys(strUsername);
	}
	
	/**
	 * Click continue button  user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnContinue() {
		reusableActions.getWhenVisible(btnContinue).click();
	}
	//For captcha bypass
	public void sendEnter() {
		reusableActions.getWhenVisible(btnContinue).sendKeys(Keys.ENTER);
		reusableActions.getWhenVisible(btnContinue).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click EmailNow button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnEmailNowIfAvailable() {
		if (reusableActions.isElementVisible(btnEmailNow, 5)) {
			reusableActions.getWhenVisible(btnEmailNow).click();
		}
		
	}
	
	/**
	 * Click TextNow button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnTextNow() {
		reusableActions.getWhenVisible(btnTextNow).click();
	}
	
	/**
	 * Input verification code to the text area in user name and password recovery flow.
	 * @param strCode, String of verification code
	 * @author Ning.Xue
	 */
	public void setCode(String strCode) {
		//reusableActions.getWhenReady(txtCode).clear();
		reusableActions.getWhenReady(txtCode).sendKeys(strCode);
	}
	
	/**
	 * Click VerifyMe button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnVerifyMe() {
		reusableActions.getWhenVisible(btnVerifyMe).click();
	}
	
	/**
	 * Input NewPassword to the new password text area in user name and password recovery flow.
	 * @param strNewPass, String of new password
	 * @author Ning.Xue
	 */
	public void setNewPassword(String strNewPass) {
		reusableActions.getWhenReady(lblNewPass).click();
		//getReusableActionsInstance().getWhenReady(txtNewPass).clear();
		reusableActions.getWhenReady(txtNewPass).sendKeys(strNewPass);
	}
	
	/**
	 * Input ConfirmPassword to the confirm password text area in user name and password recovery flow.
	 * @param strNewPass String of new password
	 * @author Ning.Xue
	 */
	public void setConfirmPassword(String strNewPass) {
		reusableActions.getWhenReady(lblConfirmNewPass).click();
		//getReusableActionsInstance().getWhenReady(txtConfirmNewPass).clear();
		reusableActions.getWhenReady(txtConfirmNewPass).sendKeys(strNewPass);
	}
	
	/**
	 * Click SetPassword button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnSetPassword() {
		reusableActions.waitForElementTobeClickable(btnSetPassword, 20);
		reusableActions.executeJavaScriptClick(btnSetPassword);
		//reusableActions.getWhenReady(btnSetPassword).click();		
	}

	/**
	 * Click on text to recovery
	 * @author Mirza.Kamran
	 */
	public void clkTextToAsRecoveryOption() {
		reusableActions.getWhenReady(btnTextToRecovery).click();
		
	}

	/**
	 * Switches to the iframe for setting code
	 * @author Mirza.Kamran
	 */
	public void switchToSetCodeIframe() {		
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(iframe, 30);
	}

	/**
	 *Click on Verify Me
	 *@author Mirza.Kamran 
	 */
	public void clickVerifyMe() {
		reusableActions.getWhenReady(btnVerifyMe).click();
		
	}

	/**
	 * Click into my account
	 * @author Mirza.Kamran
	 */
	public void clkLogInToMyAccount() {
		reusableActions.getWhenReady(btnLogInToMyAccount).click();
	}

	/**
	 * Is password reset success displayed
	 * @return true if password reset successful else false
	 * @author Mirza.Kamran
	 */
	public boolean isPasswordRestSuccessIsDisplayed() {		
		return reusableActions.isElementVisible(txtYourPasswordHasBeenReset);
	}

	/**
	 * Switches back to default content
	 * @author Mirza.Kamran
	 */
	public void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Clicks on Close button we have texted username overlay
	 * @author Mirza.Kamran
	 */
	public void clkBtnCloseWeHaveTextedUserNameOverlay() {		
		reusableActions.clickWhenReady(btnCloseWeHaveTextedUserNameOverlay);
	}

	/**
	 * Sets the account number for recovery
	 * @param strAccountNumber, String, account number(CTN)
	 * @author Mirza.Kamran
	 */
	public void setAccountNumber(String strAccountNumber) {
		reusableActions.waitForElementTobeClickable(lblAccountNumber, 30);
		reusableActions.getWhenReady(lblAccountNumber).click();
		//reusableActions.getWhenReady(txtAcountNumber).clear();
		reusableActions.getWhenReady(txtAcountNumber).sendKeys(strAccountNumber);
	}

	/**
	 * To get the recovery user name
	 * @return String, the recovered user name
	 * @author ning.xue
	 */
	public String getRecoveryUsername() {	
		String strMsg = lblYourUsername.getText();
		return strMsg.substring(strMsg.indexOf(":")+1).trim();
	}

	/**
	 * Click button "Return to Signin"
	 * @author ning.xue
	 */
	public void clkBtnReturnToSignin() {
		reusableActions.getWhenReady(btnReturnToSignin).click();
	}
	
	/**
	 * Switch driver to set password tab
	 * @param intTabIndex, integer, the index of the tab
	 * @author ning.xue
	 */
	public void switchToSigninPage(int intTabIndex) {	
		intTabIndex=3;
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		getDriver().switchTo().window(tabs.get(intTabIndex));
	}

	public String getVerificationCode() {
		String strMsg = reusableActions.getWhenReady(lblYourVerificationCode).getText();
		return strMsg.trim();
	}

	/**
	 * Sets the username for password recovery
	 * @param strUsername username
	 * @author Mirza.Kamran
	 */
	public void setUsernameIFrame(String strUsername) {
		reusableActions.getWhenVisible(txtUsername).sendKeys(strUsername);

	}

	/**
	 * @param strRecoveredUserName
	 *
	 */
	public void setVerificationCode(String strRecoveredUserName) {

		reusableActions.getWhenReady(inputCode).sendKeys(strRecoveredUserName);
	}

	/**
	 * Is password reset success displayed
	 * @return true if password reset successful else false
	 * @author Mirza.Kamran
	 */
	public boolean isPasswordSuccessfullySet() {
		return reusableActions.isElementVisible(lblYourPasswordHasBeenReset);
	}

	public void clkGoToMyFido() {
		reusableActions.getWhenReady(btnGoToMyFido,60).click();
	}

	/**
	 * gets the username
	 * @author Mirza.Kamran
	 * @return string value username
	 */
	public String getRecoveryUsernameNew() {
		return reusableActions.getWhenReady(lblSetPasswordForUserName).getText().trim();

	}

	/**
	 * Clicks on the account link
	 * @author Mirza.Kamran
	 */
	public void clkUseYourAccountInfoInsteadLink() {
		reusableActions.getWhenReady(lnkUseYourAccountInfoInstead).click();
	}

	/**
	 * Sets the Postcode number for recovery
	 * @param strPostcode, String, postcode
	 * @author Mirza.Kamran
	 */
	public void setPostCode(String strPostcode) {
		reusableActions.getWhenReady(lblPostCode).click();
		//getReusableActionsInstance().getWhenReady(txtPostCode).clear();
		reusableActions.getWhenReady(txtPostCode).sendKeys(strPostcode);

	}

	/**
	 * Sets the DOB  for recovery
	 * @param strDOB, String, DOB
	 * @author Mirza.Kamran
	 */
	public void setDOB(String strDOB) {
		reusableActions.getWhenReady(lblDOB).click();
		//getReusableActionsInstance().getWhenReady(txtDOB).clear();
		reusableActions.getWhenReady(txtDOB).sendKeys(strDOB);
	}
}
