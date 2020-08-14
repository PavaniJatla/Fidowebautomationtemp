package ca.fido.pages;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;
import utils.FormFiller;


public class FidoCreateUserPage extends BasePageClass {

	public FidoCreateUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id ="email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='confirmEmail' or @id='cemail']")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath="//input[@id='firstName' or @id='fname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastName' or @id='lname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='phone' or @name='phoneno']")
	WebElement txtPhone;

	@FindBy(xpath="//input[@class='ute-btn-primary ute-sm pull-right']")
	WebElement btnUserProfileNext;
	
	@FindBy(xpath="//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@callback='setAddressData' and @addresstype='billing']")
	WebElement txtHomeAddress;
	
	@FindBy(xpath="//div[@class='pca pcalist']/div[contains(@class,'pcalastitem')]/span[@class='pcadescription']/..")
	WebElement lblAddressResult;
	
	/**
	 * Set the dynamic Email address at both the Email and Confirm Email text boxes on user creation page
	 * @author chinnarao.vattam 
	 */
	public void setCommunicationDetails(){
		String strEmail = FormFiller.generateEmail();
		reusableActions.getWhenReady(txtEmail, 3).clear();
		reusableActions.getWhenReady(txtEmail,3).sendKeys(strEmail);
		reusableActions.getWhenReady(txtConfirmEmail, 3).clear();
		reusableActions.getWhenReady(txtConfirmEmail,3).sendKeys(strEmail);
	}
	
	/**
	 * Set the dynamic Email address at the Email on user creation page for SSP flow
	 * @author chinnarao.vattam 
	 */
	public void setEmail(){
		String strEmail = FormFiller.generateEmail();
		reusableActions.getWhenReady(txtEmail, 3).clear();
		reusableActions.getWhenReady(txtEmail,3).sendKeys(strEmail);
	}
	/**
	 * Set the dynamic first name on user creation page
	 * @author chinnarao.vattam 
	 */
	public void setFirstName(){
		String strName = FormFiller.generateRandomName();
		String strFname="Fido"+ strName;
		reusableActions.getWhenReady(txtFirstName, 3).clear();
		reusableActions.getWhenReady(txtFirstName,3).sendKeys(strFname);
	}
	
	/**
	 * Set the dynamic last name on user creation page
	 * @author chinnarao.vattam 
	 */
	public void setLastName(){
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		String strName = FormFiller.generateRandomName();
		String strLname="Automation"+ strName+ randomInt;
		reusableActions.getWhenReady(txtLastName, 3).clear();
		reusableActions.getWhenReady(txtLastName,3).sendKeys(strLname);
	}
	
	/**
	 * Set the dynamic phone number on user creation page
	 * @author chinnarao.vattam 
	 */
	public void setPhone() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		reusableActions.getWhenReady(txtPhone, 3).clear();
		reusableActions.getWhenReady(txtPhone,3).sendKeys(strPhoneNumber);
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
		txtHomeAddress.sendKeys(homeAddress);
		txtHomeAddress.sendKeys("a");
		txtHomeAddress.sendKeys(Keys.BACK_SPACE);
		reusableActions.staticWait(3000);
		reusableActions.executeJavaScriptClick(lblAddressResult);
		reusableActions.staticWait(3000);
	}
	
}