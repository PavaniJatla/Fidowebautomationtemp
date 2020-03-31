package ca.fido.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;

public class FidoProfileAndSettingPage extends BasePageClass {
	
	public FidoProfileAndSettingPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy (xpath = "//ins[@translate='global.label.profileAndSettings']")
	WebElement lnkProfileNSetting;
	
	
	@FindBy (xpath = "//a[contains(@ui-sref,'myAccount.overview')]")
	WebElement lnkOverview;	
	
	//@FindBy(xpath = "//span[text()='Update recovery number']")
	@FindBy (xpath = "//div[@class='sms-recovery']//a")	
	WebElement lnkSetRcvryNumber;
	
	@FindBy (xpath = "//iframe[contains(@src,'/pages/easylogin-fido/sms/input/')]")
	WebElement iframeSmsRecovery;
	
	@FindBy (xpath = "//input[@formcontrolname='phoneNumber']")
	WebElement txtPhoneNumber;
	
	@FindBy (xpath = "//div[@class='recovery-content']//button")
	WebElement btnContinue;
	
	@FindBy (xpath = "//div[@class='flex-item recovery-content']//div[@class='flex-item']/button")
	WebElement btnVerifyMe;
	
	//verified, the xpath can work both for EN and Fr.
	@FindBy (xpath = "//span[contains(text(),'confirmation')]")
	WebElement divVerifyText;
	
	@FindBy(xpath = "//ajs-address")
	WebElement lblAddress;	
	
	@FindBy(xpath = "//label[contains(text(),'Billing address')]/parent::div/parent::div")
	WebElement lblBillingAddress;
	
	
	@FindBy(xpath = "//label[text()='Bill type:' or text()='Type de facture :']/parent::div/following-sibling::div")
	WebElement lblBillType;
	
	@FindBy(id="addressLookup")
	WebElement txtEnterNewAddress;
	 
	@FindBy(xpath = "//button[@data-caption]")
	WebElement btnContinueChangeAddress;
	
	@FindBy(className = "new-address")
	WebElement lblNewAddressNameOnOverlay;
	 
	@FindBy(xpath = "//button[@data-caption]")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[text()='PROCESSING...' or contains(text='En traitement')]")
	WebElement divProcessing;
	
	@FindBy(xpath =  "//span[text()='Update billing address' or text()='Modifier l’adresse de facturation']")
	WebElement lnkUpdateBillingAddress;
	
	@FindBy(xpath = "//*[@class='modal-title success']")
	WebElement lblAddressUpdateSuccessful;
	
	@FindBy(xpath = "//button[@data-caption]")
	WebElement btnDoneAddressUpdate;
	
	@FindBy(xpath = "//div[@class='new-address new-address-success']")
	WebElement lblNewUpatedAddressConfirmationOnOverlay;
	
	@FindBy(xpath = "//*[@id=\"billing-address-modal\"]//h2[@class='modal-title']']")
	WebElement lblChangeAddressModalHeaderTitle;

	@FindBy(xpath = "//*[@id=\"contactInfoSection\"]//div[@class='row fds-row contact-email-row']")
	WebElement divEmailAddress;
	
	@FindBy(xpath = "//*[@id='contactInfoSection']//label[text()='Mobile phone:' or text()='Téléphone mobile :']//ancestor::div[@class='row fds-row']")
	WebElement divMobilePhone;
	
	@FindBy(xpath = "//*[@id='contactInfoSection']//label[text()='Home phone:' or text()='Téléphone résidentiel :']//ancestor::div[@class='row fds-row']")
	WebElement divHomePhone;
	
	@FindBy(xpath = "//*[@id='contactInfoSection']//label[text()='Business phone:' or text()='Téléphone professionnel :']//ancestor::div[@class='row fds-row']")
	WebElement divBusinessPhone;
	
	@FindBy(xpath = "//*[@id='contactInfoSection']//label[text()='Language:' or text()='Langue :']//ancestor::div[@class='row fds-row']")
	WebElement divLanguage;
	
	//verified, the xpath can work both for EN and Fr.
	@FindBy(xpath = "//div[contains(text(),'7890')]")      //Number To be update
	WebElement divRecoveryNumber;
	
	//Text is the only unique feature for this element
	@FindBy(xpath = "//span[text()='Update contact preferences' or text()='Modifier les préférences de communication']")
	WebElement lnkUpdateContact;
	
	//Text is the only unique feature for this element
	@FindBy(xpath = "//span[text()='Change username' or text()='Modifier le nom d’utilisateur']")
	WebElement lnkChangeUsername;
	
	//Text is the only unique feature for this element
	@FindBy(xpath = "//span[text()='Change password' or text()='Modifier le mot de passe']")
	WebElement lnkChangePassword;
	
	@FindBy(id="mobilePhone")
	WebElement txtMobilePhone;
	
	@FindBy(id="new-email")
	WebElement txtUserName;
	
	@FindBy(id="confirm-email")
	WebElement txtConfirmUserName;
	
	@FindBy(id="current-password")
	WebElement txtCurrentPassword;
	
	@FindBy(id="new-password")
	WebElement txtNewPassword;
	
	@FindBy(id="confirm-password")
	WebElement txtReEnterNewPassword;
	
	@FindBy(id="emailAddress")
	WebElement txtEmail;
	
	@FindBy(id="homePhone")
	WebElement txtHomePhone;
	
	@FindBy(id="businessPhone")
	WebElement txtBusinessPhone;
	
	@FindBy(id="businessExtn")
	WebElement txtBusinessExtn;
	
	@FindBy(xpath = "//button/span[text()='Save' or text()='Sauvegarder' or text()='ENREGISTRER']")
	WebElement btnSave;
	
	@FindBy (xpath = "//input[@formcontrolname='smsPin']")
	WebElement txtVerifyCode;
	
	@FindBy (xpath = "//iframe[contains(@src,'/pages/easylogin-fido/sms/input/')]")
	WebElement iframeVerifyCode;
	
	@FindBy(xpath = "//label[text()='Password:' or text()='Mot de passe :']/parent::div/following-sibling::div[contains(text(),'•')]")
	WebElement divPassword;
	
	@FindBy(xpath = "//div[@id='contactInfoSection']//p")
	WebElement lblContactPrefUpdateRights;
	
	@FindBy(xpath = "//fidoss-billing-info//p")
	WebElement lblBillingAddressUpdateRightsInfo;
	
	//For the pop up when there has api error.
	@FindBy(xpath = "//span[contains(text(),'Close')]")
	WebElement btnClosePopup;
	
	@FindBy (xpath = "//span[@class='nowrap']")
	WebElement notePhoneNumber;
	
	//@FindBy (xpath = "//span[@class='switch-pane ng-star-inserted']//following-sibling::small")
	@FindBy(xpath = "//span[contains(@class,'switch-pane')]//following-sibling::small")
	WebElement switchOnOff;
	
	@FindBy (xpath = "//span[contains(@class,'switch-pane')]/parent::span")
	WebElement checkFlag;	
	
	@FindBy (xpath = "//ins/strong[text()='Contact Preferences' or text()='Préférences de communication']")
	WebElement billNotiWithoutMobPhone;
	
	@FindBy (xpath = "//button[@class='secondary-button']")
	WebElement btnContinueToMyAccount;

	public void clkProfileNSetting() {
		reusableActions.getWhenReady(lnkProfileNSetting,60).click();		
	}
	/**
	 * Temporary method, used to close API error pop up.
	 */
	public void clkBtnClosePopup() {
		if(reusableActions.isElementVisible(btnClosePopup, 30)) {
			reusableActions.getWhenReady(btnClosePopup).click();	
		}	
	}
	
	/**
	 * Click on the link to set recovery number in Profile Settings page.
	 * @author ning.xue
	 */
	public void clkSetRcvryNumber() {

		reusableActions.waitForElementVisibility(lnkSetRcvryNumber, 20);
		reusableActions.executeJavaScriptClick(lnkSetRcvryNumber);
	}
	
	/**
	 * To switch to the set recovery number iframe
	 * @author ning.xue
	 */
	public void switchToSetRecoveryNumIFrame() {
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(iframeSmsRecovery, 10);
	}
	
	/**
	 * Input phone number for set recovery number flow.
	 * @param strPhoneNum, String of phone number.
	 * @author ning.xue
	 */
	public void setPhoneNumberIframe(String strPhoneNum) {
		reusableActions.getWhenReady(txtPhoneNumber,20).clear();
		reusableActions.getWhenReady(txtPhoneNumber,2).sendKeys(strPhoneNum);		
	}
	
	/**
	 * Click continue button in set recovery number flow.
	 * @author ning.xue
	 */
	public void clkBtnContinueIframe() {
		reusableActions.getWhenReady(btnContinue,20).click();
	}	
	
	/**
	 * Input the verify code got from ENS here.
	 * @param strVerifyCode, String of verify code.
	 * @author ning.xue
	 */
	public void setVerifyCodeIframe(String strVerifyCode) {
		reusableActions.getWhenReady(txtVerifyCode, 30).clear();
		reusableActions.getWhenReady(txtVerifyCode).sendKeys(strVerifyCode);
	}
	
	/**
	 * Click on the button verifyMe in set recovery number flow.
	 * @author ning.xue
	 */
	public void clkBtnVerifyMeIframe() {
		reusableActions.getWhenReady(btnVerifyMe).click();
	}	
	
	/**
	 * Verify set recovery number is done successfully confirmation message.  
	 * @return true if it is success, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifySuccessConfirmationMsg() {
		return reusableActions.isElementVisible(divVerifyText, 40);
	}
	
	/**
	 * Click on the button CONTINUE TO MY ACCOUNT after successfully set recovery number.
	 * @author ning.xue
	 */
	public void clkBtnContinueToMyAccountIframe() {
		reusableActions.getWhenReady(btnContinueToMyAccount).click();
	}
	
	/**
	 * To switch out of the set recovery number iframe
	 * @author ning.xue
	 */
	public void switchOutofSetRecoveryNumIframe() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Click on link of updateBillingAddress.
	 * @author ning.xue
	 */
	public void clkUpdateBillingAddress() {
		reusableActions.clickIfAvailable(lnkUpdateBillingAddress, 20);
		
	}
	
	/**
	 * Click on link of update contact details.
	 * Add static wait because after toggle on/off switch there has an overlay and it needs some processing time.
	 * @author ning.xue
	 */
	public void clkUpdateContactDetails() {
		reusableActions.staticWait(3000);
		reusableActions.executeJavaScriptClick(lnkUpdateContact);

	}
	
	/**
	 * verifies if the link Update Contact is present on profile and setting page
	 * @return true if link present else false
	 * @author Mirza.Kamran
	 */
	public Boolean isLnkUpdateContactPresent() {
		 
		return reusableActions.isDisplayed(lnkUpdateContact);
				
	}
	
	/**
	 * verifies if the link Update Billing address is present on profile and setting page
	 * @return true if link present else false
	 * @author Mirza.Kamran
	 */
	public Boolean isLnkUpdateBillingAddressPresent() {		
		return reusableActions.isDisplayed(lnkUpdateBillingAddress);

	}
	
	/**
	 * Performs click on Change User Name
	 * @author Mirza.Kamran
	 */
	public void clkChangeUserName() {
		reusableActions.clickIfAvailable(lnkChangeUsername);
		
	}
	
	/**
	 * To check if the Change username link is present on the Profile and setting page
	 * @return true if the link is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean isChangeUserNameLinkPresent() {
		
			return reusableActions.isDisplayed(lnkChangeUsername);	
		
	}
	
	/**
	 * Performs click on Change password 
	 * @author Mirza.Kamran
	 */
	public void clkChangePassword() {
		
		reusableActions.staticWait(2000);
		Integer reattempt=0;
		Boolean found=false;
		
		while (reattempt<3 && !found) {
			
			reusableActions.executeJavaScriptClick(lnkChangePassword);

			try {
				reusableActions.waitForElementVisibility(getDriver().findElement(By.id("current-password")),30);
				if(reusableActions.getDriver().findElement(By.id("current-password")).isDisplayed())
				{
					found=true;
					break;
				}
				reattempt++;
				reusableActions.staticWait(1000);
			}catch(NoSuchElementException e)
			{
				found=false;
				reattempt++;
			}
			
		}		
	}	
	
	/**
	 * Gets the address details 
	 * @return String containing address details
	 * @author Mirza.Kamran
	 */
	public String getOldAddress() {
		System.out.println("Search for old address");
		return reusableActions.getWhenVisible(lblAddress, 20).getText();
	}
	
	/**
	 * gets the Existing address from profile and setting page
	 * @param strUserName String containing UserName
	 * @return string containing address
	 * @author Mirza.Kamran
	 */
	public String getExistingAddress(String strUserName) {
		return reusableActions.getWhenVisible(By.xpath("//label[text()='Username:']/parent::div/following-sibling::div[text()='"+strUserName+"']")).getText();
	}
	
	/**
	 * verifies if label contact preference section is displayed
	 * @return true if lblContactPrefUpdateRights is displayed else false
	 */
	public boolean verifySubscriberAccountContactPreferenceSection() {
		return reusableActions.getWhenReady(lblContactPrefUpdateRights).isDisplayed();
				
	}
	
	/**
	 * Verifies if the Label 'Billing settings can only be updated by the account holder.' is present 
	 * @return true if the label is present else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySubscriberAccountBillingAddressSection() {
		return reusableActions.isDisplayed(lblBillingAddressUpdateRightsInfo);
	}
	
	/**
	 * Gets the old contact details into a HasTable
	 * @return Hashtable containing all the OLD contacts details
	 * @author Mirza.Kamran
	 */
	public Hashtable<String, String> getOldContactDetails() {
		Hashtable<String, String> dict =new Hashtable<String, String>();
		dict.put("email", this.getEmail());
		dict.put("mobilePhone", this.getMobilePhone());
		dict.put("homePhone", this.getHomePhone());
		dict.put("businessPhone", this.getBusinessPhone());
		dict.put("language", reusableActions.getWhenVisible(divLanguage).getText().trim());
		
		return dict;
	}
	
	/**
	 * To get the email from profile and settings page
	 * @return String email from profile and setting page
	 * @author Mirza.Kamran
	 */
	public String getEmail() {
		return reusableActions.getWhenVisible(divEmailAddress).getText().trim();
	}
	
	/**
	 *  To get the Home phone from profile and settings page
	 * @return String email from profile and setting page
	 * @author Mirza.Kamran
	 */
	public String getHomePhone() {
		return reusableActions.getWhenVisible(divHomePhone).getText().trim();
	}
	
	
	/**
	 *  To get the Mobile phone from profile and settings page
	 * @return String email from profile and setting page
	 * @author Mirza.Kamran
	 */
	public String getMobilePhone() {
		return reusableActions.getWhenVisible(divMobilePhone).getText().trim();
	}
	
	
	/**
	 *  To get the Business phone from profile and settings page
	 * @return String email from profile and setting page
	 * @author Mirza.Kamran
	 */
	public String getBusinessPhone() {
		return reusableActions.getWhenVisible(divBusinessPhone).getText().trim();
	}
	
	
	/**
	 * To set new email for contact preference.
	 * @param strNewEmail, String of new email address.
	 * @author ning.xue
	 */
	public void setEmail(String strNewEmail) {
		reusableActions.getWhenVisible(txtEmail).clear();
		reusableActions.getWhenVisible(txtEmail).sendKeys(strNewEmail);
	}
	
	/**
	 * To set mobile phone number for contact preference of Profile and Setting page.
	 * @param strMobilePhoneNum, String of mobile phone number
	 * @author ning.xue
	 */
	public void setMobilePhone(String strMobilePhoneNum) {
		//for Chrome
		reusableActions.getWhenVisible(txtMobilePhone, 30).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		//add for Firefox
		reusableActions.getWhenVisible(txtMobilePhone).clear();			
		reusableActions.getWhenVisible(txtMobilePhone).sendKeys(strMobilePhoneNum);
	}
	
	/**
	 * To clear mobile phone number for contact preference of Profile and Setting page.
	 * @author ning.xue
	 */
	public void clearMobilePhone() {
		//for Chrome
		reusableActions.getWhenVisible(txtMobilePhone).click();	
				reusableActions.getWhenVisible(txtMobilePhone, 30).clear();				
				//added extra for Firefox
				reusableActions.getWhenVisible(txtMobilePhone).click();	
				reusableActions.getWhenVisible(txtMobilePhone, 30).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				reusableActions.staticWait(1000);		
				reusableActions.getWhenVisible(txtMobilePhone).sendKeys("");
	}
	
	/**
	 * To set home phone number for contact preference of Profile and Setting page.
	 * @param strHomePhoneNum, String of home phone number
	 * @author ning.xue
	 */
	public void setHomePhone(String strHomePhoneNum) {
		reusableActions.getWhenVisible(txtHomePhone, 30).clear();
		reusableActions.getWhenVisible(txtHomePhone).sendKeys(strHomePhoneNum);
	}
	
	/**
	 * To set business phone number for contact preference of Profile and Setting page.
	 * @param strBusinessPhoneNum, String of business phone number
	 * @author ning.xue
	 */
	public void setBusinessPhone(String strBusinessPhoneNum) {
		reusableActions.getWhenVisible(txtBusinessPhone, 30).clear();
		reusableActions.getWhenVisible(txtBusinessPhone).sendKeys(strBusinessPhoneNum);
	}
	
	/**
	 * To set new username for contact preference of Profile and Setting page.
	 * @param strUserName String new username
	 * @author Mirza.Kamran
	 */
	public void setNewUserName(String strUserName)
	{
		reusableActions.getWhenVisible(txtUserName).sendKeys(strUserName);
		reusableActions.getWhenVisible(txtConfirmUserName).sendKeys(strUserName);		
		
	}
	
	/**
	 * To set new password for contact preference of Profile and Setting page. 
	 * @param strExistingPassword String containing existing password
	 * @param strNewPassword String containing new password to set
	 * @author Mirza.Kamran
	 */
	public void setNewPassword(String strExistingPassword,String strNewPassword)
	{	
		WebElement txtCurrentPwd =reusableActions.getWhenVisible(txtCurrentPassword);
		txtCurrentPwd.clear();
		txtCurrentPwd.click();
		setCharacterByCharacterTextInWebElement(txtCurrentPwd,strExistingPassword);
	        
	    WebElement txtNewPwd =reusableActions.getWhenVisible(txtNewPassword);
	    txtNewPwd.clear();
	    txtNewPwd.click();
		setCharacterByCharacterTextInWebElement(txtNewPwd,strNewPassword);
	    
	    WebElement txtReEnterNewPwd =reusableActions.getWhenVisible(txtReEnterNewPassword);
	    txtReEnterNewPwd.clear();
	    txtReEnterNewPwd.click();
		setCharacterByCharacterTextInWebElement(txtReEnterNewPwd,strNewPassword);
	    		
	}
	
	/**
	 * This method enters character by character in the webElement
	 * Sometimes firefox is not behaving as expected hence to handle that situation we need to eneter character by character
	 * @param element Text Input webelement
	 * @param strValue Any string value which we want to eneter character by character
	 * @author Mirza.Kamran
	 */
	public void setCharacterByCharacterTextInWebElement(WebElement element, String strValue) {
		 for (int itr = 0; itr < strValue.length(); itr++){
		        char cr = strValue.charAt(itr);
		        String str = new StringBuilder().append(cr).toString();
		        element.sendKeys(str);
		    }  
	}
	
	/**
	 * generic click on the save button
	 * @author Mirza.Kamran
	 */
	public void clkSaveButton() {
		reusableActions.clickIfAvailable(btnSave);
		reusableActions.staticWait(5000);
	}
	
	/**
	 * To click on save contact button
	 * @author Mirza.Kamran
	 */
	public void saveContactDetails() {
		reusableActions.clickIfAvailable(btnSave,10);
		reusableActions.staticWait(3000);
	}
	
	/**
	 *  To set new address on Profile and Setting page.
	 * @param strAddress String new address details
	 * @author Mirza.Kamran
	 */
	public void setNewAddress(String strAddress) {
		
		WebElement txtEnterNewAdd=reusableActions.getWhenReady(txtEnterNewAddress);
		txtEnterNewAdd.clear();
		txtEnterNewAdd.click();		
		setCharacterByCharacterTextInWebElement(txtEnterNewAdd,strAddress);
		reusableActions.staticWait(5000);
		reusableActions.getWhenReady(txtEnterNewAddress).sendKeys(Keys.ENTER);	
		reusableActions.staticWait(2000);

	}
	
	/**
	 * To click on button continue update new address on change address overlay
	 * @author Mirza.Kamran
	 */
	public void clkContinueUpdateNewAddress() {
		reusableActions.waitForElementTobeClickable(btnContinueChangeAddress, 30);
		reusableActions.clickIfAvailable(btnContinueChangeAddress, 10);
		
	}
	
	/**
	 * To click on Submit new address 
	 * @author Mirza.Kamran
	 */
	public void clkSubmitNewAddress() {
		reusableActions.getWhenReady(btnSubmit).click();
		
	}
	
	/**
	 * To wait for the page processing div to disappear
	 * @author Mirza.Kamran
	 */
	public void waitForProcessing() {
		reusableActions.waitForElementInvisibility(divProcessing);
		
	}
	
	/**
	 * To check if the address is updated successfully 
	 * @param strAddress String containing new address details
	 * @return true if address update label is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyAddressUpdatedSuccessFulOverlay(String strAddress)
	{
		if(reusableActions.getWhenReady(lblAddressUpdateSuccessful).isDisplayed()
			&& reusableActions.getWhenReady(lblNewAddressNameOnOverlay).getText().toUpperCase().contains(strAddress.toUpperCase()))
		{
			reusableActions.clickIfAvailable(btnDoneAddressUpdate);
			return true;
		}
		return false;
	}
	
	/**
	 * To verify if the address details got updated correctly on profile and settings page
	 * @param strAddress String containing new address details
	 * @return true if address details match else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyAddressUpdatedSuccessFullyOnProfileAndSettingsPg(String strAddress)
	{
		if(reusableActions.getWhenReady(lblAddress).getText().toUpperCase().contains(strAddress.substring(0,7).toUpperCase()))
		{
			return true;
		}			
		return false;
	}
	
	/**
	 * To verify if the address details got updated correctly on profile and settings page
	 * @param strAddress String containing new address details
	 * @return true if address details match else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyAddressUpdatedSuccessFullyOnProfileAndSettingsPgHSI(String strAddress)
	{
		if(reusableActions.getWhenReady(lblBillingAddress).getText().toUpperCase().contains(strAddress.substring(0,7).toUpperCase()))
		{
			return true;
		}			
		return false;
	}
	
	/**
	 * To get the mobile phone number from profile and settings page contact section
	 * @return string containing mobile phone number
	 * @author Mirza.Kamran
	 */
	
	public String getMobilePhoneNum() {
		String mobilePhone = reusableActions.getWhenVisible(divMobilePhone).getText().trim().split("\n")[1];
		return mobilePhone;
	}
	
	/**
	 * To verify if the email got updated correctly profile and settings page contact section
	 * @param strOldEmail string old email id
	 * @param strNewEmail string new email id
	 * @return true if new email id is updated
	 * @author Mirza.Kamran
	 */
	public Boolean verifyEmailUpdated(String strOldEmail,String strNewEmail) {
		String email=reusableActions.getWhenReady(divEmailAddress).getText().split("\n")[1].trim();
		if(email!=strOldEmail && email.equals(strNewEmail))			
			{
				return true;			
			}else
			{
				return false;
			}
					
	}
	
	/**
	 * To verify if the Mobile phone got updated correctly profile and settings page contact section
	 * @param strOldMobilePhone string old phone number
	 * @param strNewMobilePhone string new phone number
	 * @return true if new phone number id is updated
	 * @author Mirza.Kamran
	 */
	public Boolean verifyMobilePhoneUpdated(String strOldMobilePhone, String strNewMobilePhone) {
		String mobilePhone = reusableActions.getWhenReady(divMobilePhone).getText().split("\n")[1];
		mobilePhone = mobilePhone.substring(mobilePhone.length()-4,mobilePhone.length());				
		if(mobilePhone != strOldMobilePhone.substring(strOldMobilePhone.length()-4,strOldMobilePhone.length()) 
				&& mobilePhone.equals(strNewMobilePhone.substring(strNewMobilePhone.length()-4,strNewMobilePhone.length()))
		)
		{
			return true;			
		}else
		{
			return false;
		}
				
	}
	
	/**
	 * To verify if the Home phone got updated correctly profile and settings page contact section
	 * @param strOldHomePhone string old home phone number
	 * @param strNewHomePhone string new home phone number
	 * @return true if the new home phone number is updated correctly else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyHomePhoneUpdated(String strOldHomePhone, String strNewHomePhone) {		
		String homePhone=reusableActions.getWhenReady(divHomePhone).getText().split("\n")[1];
		homePhone=homePhone.substring(homePhone.length()-4,homePhone.length());			
		if(homePhone!=strOldHomePhone.substring(strOldHomePhone.length()-4,strOldHomePhone.length())
				&& homePhone.equals(strNewHomePhone.substring(strNewHomePhone.length()-4,strNewHomePhone.length())))
		{
			return true;			
		}else
		{
			return false;
		}
	}
	
	/**
	 * To verify if the Business phone got updated correctly profile and settings page contact section
	 * @param strOldBusinessPhone string old business phone number
	 * @param strNewBusinessPhone string new business phone number
	 * @return true if the new business phone number is updated correctly else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyBusinessPhoneUpdated(String strOldBusinessPhone,String strNewBusinessPhone) {		
		String businessPhone=reusableActions.getWhenReady(divBusinessPhone).getText().split("\n")[1];
		businessPhone=businessPhone.substring(businessPhone.length()-4,businessPhone.length());
		
		if(businessPhone!=strOldBusinessPhone.substring(strOldBusinessPhone.length()-4,strOldBusinessPhone.length())
		&& businessPhone.equals(strNewBusinessPhone.substring(strNewBusinessPhone.length()-4,strNewBusinessPhone.length())))
		{
			return true;			
		}else
		{
			return false;
		}
	}
			
	/**
	 * To verify if the user name got updated correctly profile and settings page 
	 * @param strUserName string new user name
	 * @return true if the user name is updated correctly else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyUserNameUpdatedSuccessFullyOnProfileAndSettingsPg(String strUserName)
	{
		try {
			if(reusableActions.isElementVisible((By.xpath("//label[text()='Username:'  or text()='Nom d’utilisateur :']/parent::div/following-sibling::div[text()='"+strUserName+"']")),60))
			{
				return true;				
			}
			return false;
		}catch(Exception e)
		{
			return true;
		}
	}
	
	/**
	 * To verify if the password got updated correctly profile and settings page
	 * @param strPassword string new password
	 * @return true if the password is updated correctly else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyPasswordUpdatedSuccessFullyOnProfileAndSettingsPg(String strPassword)
	{
		try {										
			reusableActions.waitForElementVisibility(divPassword);
			if(reusableActions.getWhenReady(divPassword).getText().trim().length() == strPassword.length())
			{
				return true;				
			}
			return false;
			
		}catch(Exception e)
		{
			return false;
		}		
	}	
	
	/**
	 * To verify if recovery number is set successfully. The phone number will show in Profile and Settings page.
	 * @param str4DigitPhone string four digit phone number
	 * @return true when the recovery number show on the page, other wise false. 
	 * @author ning.xue
	 */
	public Boolean verifyRecoveryNumberSetSuccessfully (String str4DigitPhone) {
		try {
			return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + str4DigitPhone + "')]"), 20);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Verify Bill Notification area when the mobile phone is not set.
	 * @return true when the message contains "Contact Preference" or corresponding French message show, otherwise false.
	 */
	public Boolean verifyBillNotificationWithoutMobilePhoneSet () {
		try {
			return reusableActions.isElementVisible(billNotiWithoutMobPhone);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * To verify bill notification after mobile phone number is set in contact preference, 
	 * it will check the last four digit of the phone number and toggle switch on, then check 
	 * if the class attribute of parent span is set to checked.
	 * @param strMobileNum, String mobile number which was add in the contact preference
	 * @return true when conditions match, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyBillNotificationUpdateSuccessfully(String strMobileNum) {
		reusableActions.waitForElementVisibility(notePhoneNumber, 30);
		String phoneNum = reusableActions.getWhenReady(notePhoneNumber, 30).getText().trim();
		reusableActions.staticWait(1000);
		reusableActions.executeJavaScriptClick(switchOnOff);
		reusableActions.staticWait(2000);
		String strCheckFlag = reusableActions.getWhenReady(checkFlag, 20).getAttribute("class");
		if (phoneNum.substring(phoneNum.length()-5).equalsIgnoreCase(strMobileNum.substring(phoneNum.length()-5))
				&& (strCheckFlag.equalsIgnoreCase("switch switch-medium checked")
						|| strCheckFlag.equalsIgnoreCase("switch switch-medium"))) {
			return true;
		}
		return false;
	}

	/**
	 * This will help scroll down to the bottom of the profile and settings page
	 * @author Mirza.Kamran
	 */
	public void scrollToProfileAndSettingsBottom() {
		reusableActions.javascriptScrollToBottomOfPage();
	}
	
	/**
	 * This will help scroll to the middle of the profile and settings page
	 * @author Mirza.Kamran
	 */
	public void scrollToProfileAndSettingsMiddlePage() {
		reusableActions.javascriptScrollToMiddleOfPage();
	}
}
