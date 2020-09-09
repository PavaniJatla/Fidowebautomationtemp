package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class FidoCreateUserPage extends BasePageClass {

	public FidoCreateUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='email' or @formcontrolname='email']/parent::div")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='email' or @formcontrolname='email']")
	WebElement lblTxtEmail;

	@FindBy(xpath="//input[@id='confirmEmail' or @id='cemail' or @formcontrolname='confirmEmail']/parent::div")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath="//input[@id='confirmEmail' or @id='cemail' or @formcontrolname='confirmEmail']")
	WebElement lbltxtConfirmEmail;

	@FindBy(xpath="//input[@id='firstName' or @id='fname' or @formcontrolname='firstName']/parent::div")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='firstName' or @id='fname' or @formcontrolname='firstName']")
	WebElement lblTxtFirstName;

	@FindBy(xpath="//input[@id='lastName' or @id='lname' or @formcontrolname='lastName']/parent::div")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='lastName' or @id='lname' or @formcontrolname='lastName']")
	WebElement lblTxtLastName;

	@FindBy(xpath="//input[@name='phone' or @name='phoneno' or @formcontrolname='contact']/parent::div")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@name='phone' or @name='phoneno' or @formcontrolname='contact']")
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
		@FindBy(xpath="//input[@callback='setAddressData' and @addresstype='billing']"),
		@FindBy(xpath="//r-address-auto-complete//input")	
	})
	WebElement lblTxtHomeAddress;
	
	@FindAll({
	@FindBy(xpath="//div[@class='pca pcalist']/div[contains(@class,'pcalastitem')]/span[@class='pcadescription']/.."),
	@FindBy(xpath="//div[@class='auto-suggest-list ng-star-inserted']//li[1]")
	})
	WebElement lblAddressResult;

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
 * Set the dynamic Email address at the Email on user creation page for SSP flow
 * @author chinnarao.vattam 
 */
public void setEmail(){
	String strEmail = FormFiller.generateEmail();
	reusableActions.getWhenReady(txtEmail, 3).click();
	reusableActions.getWhenReady(lblTxtPhone,3).sendKeys(strEmail);
}
/**
 * Set the dynamic first name on user creation page
 * @author chinnarao.vattam 
 */
public void setFirstName(){
	String strName = FormFiller.generateRandomName();
	String strFname="Fido"+ strName;
	reusableActions.getWhenReady(txtFirstName, 3).click();
	reusableActions.getWhenReady(lblTxtFirstName,3).sendKeys(strFname);
}

/**
 * Set the dynamic last name on user creation page
 * @author chinnarao.vattam 
 */
public void setLastName(){
	//Random randomGenerator = new Random();  
	//int randomInt = randomGenerator.nextInt(1000);
	String strName = FormFiller.generateRandomName();
	String strLname="Automation"+ strName;
	//String strLname="Automation"+ strName+ randomInt;
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
	reusableActions.getWhenReady(lblTxtPhone,3).sendKeys(strPhoneNumber);
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
	reusableActions.executeJavaScriptClick(btnContinue);
}

/**
 * Enters the home address in the field and selects from the result list
 * @param homeAddress Home Address
 * @author rajesh.varalli1
 */
public void setHomeAddress(String homeAddress) {
	reusableActions.getWhenReady(txtHomeAddress, 10).click();
	reusableActions.getWhenReady(lblTxtHomeAddress, 10).sendKeys(homeAddress);	
	//reusableActions.getWhenReady(lblTxtHomeAddress, 3).sendKeys("a");
	//reusableActions.getWhenReady(lblTxtHomeAddress, 3).sendKeys(Keys.BACK_SPACE);
	reusableActions.staticWait(3000);
	reusableActions.executeJavaScriptClick(lblAddressResult);
	reusableActions.staticWait(3000);
}

}