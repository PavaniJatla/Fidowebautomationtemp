package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class FidoChooseNumberPage extends BasePageClass {

	public FidoChooseNumberPage(WebDriver driver) {
		super(driver);		
	}

	@FindAll({
		@FindBy(xpath="//span[@checkout-res='checkout_select_new_number']"),
		@FindBy(xpath="//button[contains(@id,'ds-tabs-2-tab-0')]//div")
	})
	WebElement btnSelectNewNumber;
	
	@FindBy(xpath="//span[@checkout-res='checkout_use_existing_number']")
	WebElement btnUseExistingNumber;
	
	@FindBy(xpath="//button[@name='button_avail' and contains(@ng-click,'getAvailableNumbers')]")
	WebElement btnFindAvailableNumbers;
	
	@FindAll({
		@FindBy(xpath="//select[@name='selectedCity']"),
		@FindBy(xpath="//ds-form-field[@data-test='choose-number-city']//select")
	})
	WebElement ddlCity;
	
	@FindBy(xpath="(//ds-radio-group[@formcontrolname='newNumber']//div[@class='ds-radioButton__innerCircle'])[1]")
	WebElement lblAvailableNumbers;
	
	@FindBy(xpath="//button[@data-test='choose-number-continue']")
	WebElement btnContinueChooseANumberSection;
	
	@FindBy(xpath="//button[@data-test='choose-number-continue' and @disabled='true']")
	WebElement disabledBtnContinueChooseANumberSection;
	
	/**
	 * Clicks on the 'Select a number for your new phone' button
	 * @author rajesh.varalli1
	 */
	public void clkSelectNewNumber() {
		reusableActions.clickWhenReady(btnSelectNewNumber,30);
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
		reusableActions.waitForElementTobeClickable(btnContinueChooseANumberSection, 30);
		reusableActions.executeJavaScriptClick(lblAvailableNumbers);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinueChooseANumberSection);
	}
	
}
