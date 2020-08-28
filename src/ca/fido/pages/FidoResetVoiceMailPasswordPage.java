package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * 
 * @author Mirza.Kamran
 *
 */
public class FidoResetVoiceMailPasswordPage extends BasePageClass {

	public FidoResetVoiceMailPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//ins[@translate='wireless.label.resetVoicemailPassword']")
	WebElement lblResetVoiceMailPasswordOnPasswordChangePage;

	@FindBy(xpath = "//span[@translate='wireless.label.resetVoicemailPassword']")
	WebElement lblResetVoiceMailPasswordOnConfirmationPage;
	
	@FindBy(xpath = "//ins[@translate='wireless.message.whereYouChangeYourPassword']")
	WebElement lblWhereYouChangeYourPassword;
	
	@FindBy(xpath = "//ins[@translate='wireless.message.enterNewPasswordDigitsMust']")
	WebElement lblPasswordDigits;
	
	@FindBy(xpath = "//input[@name='newPassword']")
	WebElement txtNewPassword;
	
	@FindBy(xpath = "//input[@name='confirmPassword']")
	WebElement txtConfirmPassword;
		
	@FindBy(xpath = "//button/ins[@translate='global.cta.submit']")
	WebElement btnSubmitVoiceMailPassword;
		
	@FindBy(xpath = "//span[@translate='wireless.message.taDaVoicemailChanged']")
	WebElement lblYourVoiceMailpassowrdHasChanged;
	
	@FindBy(xpath = "//span[@translate='wireless.message.newVoicemailPassword']")
	WebElement lblYourNewPasswordForCtnIs;
		
	@FindBy(xpath = "//span[@ng-bind='confirmedPassword']")
	WebElement lblNewVoiceMailPassWord;
	
	@FindBy(xpath = "//span[@translate='wireless.message.accessVoicemailPressOneKey']")
	WebElement lblToAccessFidoVoiceMailfromDevice;

	@FindBy(xpath = "//span[@translate='wireless.message.learnToChangePassword']")
	WebElement lblLearnHowToChangeFidoVoiceMailfromDevice;
	
	@FindBy(xpath = "//a[contains(@href,'https://www.fido.ca/consumer/content/postpaid-voice-messaging')]")
	WebElement lnkVoiceMailFAQ;
	
	@FindBy(xpath = "//ins[@translate='global.cta.backToAccount']")
	WebElement btnBackToMyAccount;
	
	
	/**
	 * checks if the label reset New Password is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelResetNewPasswordisDisplayedOnPasswordChangePage() {
		return lblResetVoiceMailPasswordOnPasswordChangePage.isDisplayed();
	}
	
	/**
	 * checks if the label reset New Password is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelResetNewPasswordisDisplayedOnChangeConfirmationPage() {
		return lblResetVoiceMailPasswordOnConfirmationPage.isDisplayed();
	}
	
	/**
	 * checks if the label where to change the voicemail Password is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelWhereToChangeTheVoiceMailPasswordisDisplayed() {
		return lblWhereYouChangeYourPassword.isDisplayed();
	}
	
	/**
	 * checks if the label voicemail Password Digit rule is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyVoiceMailPasswordDigitRuleIsDisplayed() {
		return lblPasswordDigits.isDisplayed();
	}
	
	/**
	 * Sets new password in the new password textbox
	 * @param strNewVoiceMailPassword new password string
	 * @author Mirza.Kamran
	 */
	public void setNewVoiceMailPassword(String strNewVoiceMailPassword) {
		reusableActions.getWhenReady(txtNewPassword).sendKeys(strNewVoiceMailPassword);
	}
	
	/**
	 * Sets new password in confirm password text box
	 * @param strConfirmVoiceMailPassword new voicemail password string
	 * @author Mirza.Kamran
	 */
	public void setConfirmVoiceMailPassword(String strConfirmVoiceMailPassword) {
		reusableActions.getWhenReady(txtConfirmPassword).sendKeys(strConfirmVoiceMailPassword);
	}
	
	/**
	 * Performs click on submit button
	 * @author Mirza.Kamran
	 */
	public void clkSubmit() {
		boolean clickSuccess=false;
		int counter=0;
		while (counter<=3 && !clickSuccess) {			
			reusableActions.waitForElementVisibility(btnSubmitVoiceMailPassword, 120);
			reusableActions.waitForElementTobeClickable(btnSubmitVoiceMailPassword, 120);
			reusableActions.executeJavaScriptClick(btnSubmitVoiceMailPassword);
			reusableActions.clickWhenReady(btnSubmitVoiceMailPassword, 10);
			if(btnBackToMyAccount.isDisplayed())
			{
				clickSuccess=true;
				break;
			}
			clickSuccess=false;
			counter++;
		}		
		
	}

	/**
	 * checks if the label Your Password has been changed is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelYourPasswordHasBeenChanged() {		
		return lblYourVoiceMailpassowrdHasChanged.isDisplayed();
	}

	/**
	 * checks if the label To access fido voicemail from device.. is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelToAccessFidoVoiceMailfromDevice() {		
		return lblToAccessFidoVoiceMailfromDevice.isDisplayed();
	}
	
	/**
	 * checks if the label learn how to change fido voicemail from device is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelLearnHowToChangeFidoVoiceMailfromDevice() {		
		return lblLearnHowToChangeFidoVoiceMailfromDevice.isDisplayed();
	}
	
	/**
	 * checks if the Link voice mail FAQ is displayed 
	 * @return true if the link is present else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkVoiceMailFAQ() {		
		return lnkVoiceMailFAQ.isDisplayed();
	}

	/**
	 * checks if the label Your new password for (CTN) is.. is displayed 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelYourNewPasswordForCTNIs() {		
		return lblYourNewPasswordForCtnIs.isDisplayed();
	}
	
	/**
	 * verifies if the new passcode matches the value displayed on final page
	 * @param strVoiceMailNewPassword voice mail password value generated at run time 
	 * @return true of the voice mail password matches else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyNewPasswordDisplayed(String strVoiceMailNewPassword) {
		
		return reusableActions.getWhenReady(lblNewVoiceMailPassWord).getText().trim().contains(strVoiceMailNewPassword);		
	}

	/**
	 * Clicks on back to my account button
	 * @author Mirza.Kamran
	 */
	public void clkBackToMyAccountPageButton() {
		reusableActions.clickWhenReady(btnBackToMyAccount);
		
	}

	/**
	 * Waits for the confirmation page to load
	 * @author Mirza.Kamran
	 */
	public void waitForBackBtnVisible() {
		reusableActions.waitForElementVisibility(btnBackToMyAccount, 30);
		
	}
}
