package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FidoDeviceConfigPage extends BasePageClass {

	public FidoDeviceConfigPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//button[@id='continue-button']")
	WebElement continueButton;
	
	@FindBy(xpath = "//ds-modal-container")
	WebElement modalContainer;
	
	@FindBy(xpath = "//button[@id='trident-cta0']")
	WebElement modalContainerGetStartedbutton;
	
	
	/***
	 * This method will check the presence of continue button and will return true if present else false
	 * @return boolean if the Continue button is visible then return true else false
	 * @author saurav.goyal
	 */
	public boolean verifyContinueButton() {	
		if(reusableActions.isElementVisible(continueButton)) 
			return true; 
		else 
			return false;

	}
		
	/***
	 * This method will verify the presence of continue button if it is available then it will click on the continue button and will return true else false
	 * @return boolean if the Continue button is visible then return true else false
	 * @author saurav.goyal
	 */
	public boolean clickContinueButton() {	
		if(reusableActions.isElementVisible(continueButton)) {
			reusableActions.clickIfAvailable(continueButton, 10);
			return true; 
		}else {
			return false;
		}
	}
	
	/**
	 * This method check whether a Modal page is getting displayed or not
	 * @return a boolean value true if a modal window will appear else false
	 * @author saurav.goyal
	 */
	public boolean isModalDisplayed() {	
		if(reusableActions.isElementVisible(modalContainer))
			return true;
		else
			return false;
	}
	
	/**
	 * This method verifies whether or not Get Started button is available in a model
	 * @return a boolean true if element is present else false
	 * @author saurav.goyal
	 */
	public boolean verifyGetStartedButtonOnModal() {	
		if(reusableActions.isElementVisible(modalContainerGetStartedbutton)) 
			return true; 
		else 
			return false;

	}
	
	/**
	 * This method clicks on a Get Started button in a Modal window
	 * @author saurav.goyal
	 */
	public void clickGetStartedButtonOnModal() {	
		reusableActions.clickIfAvailable(modalContainerGetStartedbutton);
	}
}
	
	