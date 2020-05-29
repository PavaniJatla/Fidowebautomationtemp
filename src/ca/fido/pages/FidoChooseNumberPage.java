package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoChooseNumberPage extends BasePageClass {

	public FidoChooseNumberPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//span[@checkout-res='checkout_select_new_number']")
	WebElement btnSelectNewNumber;
	
	@FindBy(xpath="//span[@checkout-res='checkout_use_existing_number']")
	WebElement btnUseExistingNumber;
	
	@FindBy(xpath="//button[@name='button_avail' and contains(@ng-click,'getAvailableNumbers')]")
	WebElement btnFindAvailableNumbers;
	
	@FindBy(xpath="//select[@name='selectedCity']")
	WebElement ddlCity;
	
	@FindBy(xpath="//div[contains(@class,'ctn-available-numbers')]//label")
	WebElement lblAvailableNumbers;
	
	@FindBy(xpath="//button[@name='button_continue']")
	WebElement btnContinue;
	
	/**
	 * Clicks on the 'Select a number for your new phone' button
	 * @author rajesh.varalli1
	 */
	public void clkSelectNewNumber() {
		reusableActions.clickWhenReady(btnSelectNewNumber);
		reusableActions.staticWait(2000);
	}
	
	/**
	 * Clicks on the 'Use an existing number' button
	 * @author rajesh.varalli1
	 */
	public void clickUseExistingNumber() {
		reusableActions.clickWhenReady(btnUseExistingNumber);
	}

	/**
	 * Selects the city to find the phone number
	 * @param city Name of the City
	 * @author rajesh.varalli1
	 */
	public void selectCity(String city) {
		reusableActions.selectWhenReadyByVisibleText(ddlCity, city.toUpperCase());
	}
	
	/**
	 * Clicks on the 'FIND AVAILABLE NUMBERS' button
	 * @author rajesh.varalli1
	 */
	public void clkFindAvailableNumbers() {
		reusableActions.scrollToElementAndClick(btnFindAvailableNumbers);
	}
	
	/**
	 * Selects the First option in the list of Phone Numbers displayed
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailableNumber() {
		reusableActions.executeJavaScriptClick(lblAvailableNumbers);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue);
	}
	
}
