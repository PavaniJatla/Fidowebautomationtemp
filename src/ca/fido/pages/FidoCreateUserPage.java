package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class FidoCreateUserPage extends BasePageClass {

	public FidoCreateUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='email' or (contains(@formcontrolname,'email') and  not(contains(@formcontrolname,'Confirm')))]/parent::div")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='email' or (contains(@formcontrolname,'email') and  not(contains(@formcontrolname,'Confirm')))]")
	WebElement lblTxtEmail;

	@FindBy(xpath="//input[@id='confirmEmail' or @id='cemail' or contains(@formcontrolname,'Confirm')]/parent::div")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath="//input[@id='confirmEmail' or @id='cemail' or contains(@formcontrolname,'Confirm')]")
	WebElement lbltxtConfirmEmail;

	@FindBy(xpath="//input[@id='firstName' or @id='fname' or @formcontrolname='firstName']/parent::div")
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id='firstName' or @id='fname' or @formcontrolname='firstName']")
	WebElement lblTxtFirstName;

	@FindBy(xpath="//input[@id='lastName' or @id='lname' or @formcontrolname='lastName']/parent::div")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='lastName' or @id='lname' or @formcontrolname='lastName']")
	WebElement lblTxtLastName;

	@FindBy(xpath="//input[@name='phone' or @name='phoneno' or contains(@formcontrolname,'contact')]/parent::div")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@name='phone' or @name='phoneno' or contains(@formcontrolname,'contact')]")
	WebElement lblTxtPhone;

	@FindBy(xpath="//input[@class='ute-btn-primary ute-sm pull-right']")
	WebElement btnUserProfileNext;

	@FindAll({
		@FindBy(xpath="//span[@checkout-res='checkout_continue_lbl']/parent::button"),
		@FindBy(xpath="//button[@data-test='personal-info-continue']")
	})		
	WebElement btnContinue;

	@FindAll({
		@FindBy(xpath="//input[@callback='setAddressData' and @addresstype='billing']"),
		@FindBy(xpath="//r-address-auto-complete//input//parent::div")	
	})
	WebElement txtHomeAddress;
	
	@FindAll({
		@FindBy(xpath="//r-address-auto-complete//input"),
		@FindBy(xpath="(//ul[@role='listbox']//li)[1]"),
	})
	WebElement lblTxtHomeAddress;
	
	@FindAll({
		@FindBy(xpath="//ul[@role='listbox']//li[not(contains(.,'Addresses'))]")
	})
	WebElement lblAddressResult;


	/**
	 * Verify if the create user profile page loaded or not
	 * @author Saurav.Goyal
	 */
	public boolean verifyCreateUserProfilePage(){
		return reusableActions.isElementVisible(txtEmail, 60);

	}

	/**
	 * Set the dynamic Email address at both the Email and Confirm Email text boxes on user creation page
	 * @author chinnarao.vattam 
	 */
	public void setCommunicationDetails(){
		String strEmail = FormFiller.generateEmail();
		reusableActions.getWhenReady(txtEmail, 10).click();
		reusableActions.getWhenReady(lblTxtEmail,3).sendKeys(strEmail);
		reusableActions.getWhenReady(txtConfirmEmail, 3).click();
		reusableActions.getWhenReady(lbltxtConfirmEmail,3).sendKeys(strEmail);
}

	/**
	 * Set the dynamic Email address at both the Email and Confirm Email text boxes on user creation page
	 * @author chinnarao.vattam
	 */
	public void setCommunicationDetails(String strEmail){
		reusableActions.getWhenReady(txtEmail, 10).click();
		reusableActions.getWhenReady(lblTxtEmail,3).sendKeys(strEmail);
		reusableActions.getWhenReady(txtConfirmEmail, 3).click();
		reusableActions.getWhenReady(lbltxtConfirmEmail,3).sendKeys(strEmail);
	}

/**
 * Set the dynamic Email address at the Email on user creation page for SSP flow
 * @author chinnarao.vattam 
 */
public void setEmail(){
	String strEmail = FormFiller.generateEmail();
	reusableActions.getWhenReady(txtEmail, 10).click();
	reusableActions.getWhenReady(lblTxtEmail,3).sendKeys(strEmail);
}
/**
 * Set the dynamic first name on user creation page
 * @author chinnarao.vattam 
 */
public void setFirstName(){
	String strName = FormFiller.generateRandomName();
	String strFname="Fido"+ strName;
	reusableActions.getWhenReady(txtFirstName, 60).click();
	lblTxtFirstName.sendKeys(strFname);
}

	/**
	 * Set the dynamic first name on user creation page
	 * @author chinnarao.vattam
	 */
	public void setFirstName(String strName){
		String strFname="Fido"+ strName;
		reusableActions.getWhenReady(txtFirstName, 60).click();
		reusableActions.getWhenReady(lblTxtFirstName,3).sendKeys(strFname);
	}

/**
 * Set the dynamic last name on user creation page
 * @author chinnarao.vattam 
 */
public void setLastName(){
	String strName = FormFiller.generateRandomName();
	String strLname="Automation"+ strName;
	reusableActions.getWhenReady(txtLastName, 3).click();
	lblTxtLastName.sendKeys(strLname);
}

	/**
	 * Set the dynamic last name on user creation page
	 * @author chinnarao.vattam
	 */
	public void setLastName(String strName){
		String strLname="Automation"+ strName;
		reusableActions.getWhenReady(txtLastName, 3).click();
		reusableActions.getWhenReady(lblTxtLastName,3).sendKeys(strLname);
	}

/**
 * Set the dynamic phone number on user creation page
 * @author chinnarao.vattam 
 */
public void setPhone() {
	String strPhoneNumber = FormFiller.generatePhoneNumber();
	reusableActions.getWhenReady(txtPhone, 3).click();
	reusableActions.getWhenReady(lblTxtPhone,3).sendKeys("1001000067");
}

	/**
	 * Set the dynamic phone number on user creation page
	 * @author chinnarao.vattam
	 */
	public void setPhone(String strPhoneNumber) {
		reusableActions.getWhenReady(txtPhone, 3).click();
		reusableActions.getWhenReady(lblTxtPhone,3).sendKeys(strPhoneNumber);
	}

	/**
	 * Set a specific phone number on user creation page
	 * @author Saurav.Goyal
	 */
	public void setSpecificPhoneNumber(String contactNumber) {
		reusableActions.getWhenReady(txtPhone, 30).click();
		//reusableActions.getWhenReady(lblTxtPhone,3).sendKeys(contactNumber);
		lblTxtPhone.sendKeys(contactNumber);
	}

/**
 * Clicks on the 'Next' button on user creation page
 * @author chinnarao.vattam 
 */
public void clkUserProfileNext() {
	reusableActions.executeJavaScriptClick(btnUserProfileNext);
}

/**
 * Clicks on the 'Next' button on user creation page for existing customer
 * @author chinnarao.vattam 
 */
public void clkUserProfileNextForExistingCustomer() {
	reusableActions.waitForElementVisibility(btnUserProfileNext, 30);
	reusableActions.executeJavaScriptClick(btnUserProfileNext);
}

/**
 * Clicks on the 'Continue' button
 * @author rajesh.varalli1
 */
public void clkContinue() {
	reusableActions.scrollToElement(btnContinue);
	reusableActions.waitForElementTobeClickable(btnContinue , 30);
	reusableActions.executeJavaScriptClick(btnContinue);
}

/**
 * Enters the home address in the field and selects from the result list
 * @param homeAddress Home Address
 * @author rajesh.varalli1
 */
public void setHomeAddress(String homeAddress) {
	reusableActions.javascriptScrollByVisibleElement(txtFirstName);
	reusableActions.getWhenReady(txtHomeAddress, 10).click();
	lblTxtHomeAddress.sendKeys(homeAddress);
	//reusableActions.getWhenReady(lblTxtHomeAddress,10).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	//reusableActions.executeJavaScriptClick(lblAddressResult);
	if(reusableActions.isElementVisible(lblAddressResult,10)) {
		reusableActions.executeJavaScriptClick(lblAddressResult);
	}
}

}