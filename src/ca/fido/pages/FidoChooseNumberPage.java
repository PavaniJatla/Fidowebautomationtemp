package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//button[@data-test='search-available-number-button']")
	WebElement searchNumberBtn;

	@FindBy(xpath="//button[@data-test='choose-number-continue']")
	WebElement btnContinueChooseANumberSection;
	
	@FindBy(xpath="//button[@data-test='choose-number-continue' and @disabled='true']")
	WebElement disabledBtnContinueChooseANumberSection;

	@FindAll({
			@FindBy(xpath = "(//div[contains(@class,'button-container')]//button)[2]"),
			@FindBy(xpath = "//div[contains(@class,'button-container')]//button[contains(.,'No')]")
	})
	WebElement btnClkNoThanks;

	@FindBy(xpath = "//p[contains(text(),'Use an existing number') or contains(text(),'Utilisez un numéro actuel')]")
	WebElement existingNumberTab;

	@FindBy(xpath = "//ds-form-field[@data-test='choose-number-existing-number']")
	WebElement existingNumberField;

	@FindBy(xpath = "//input[@formcontrolname='existingNumber']")
	WebElement inputPortInNumber;

	@FindBy(xpath = "//span[contains(text(),'Vérifiez la disponibilité') or contains(text(),'Check availability')]")
	WebElement btnCheckEligibility;

	@FindBy(xpath = "//span[@data-test='port-in-success' or @data-test='Bonne nouvelle']")
	WebElement successPortInMessage;

	@FindAll({
			@FindBy(xpath = "//button[contains(@data-test,'stepper-6')]"),
			@FindBy(xpath = "//button[@data-test='caller-id-continue']")

	})
	WebElement continueCallerID;

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
		reusableActions.waitForElementVisibility(btnContinueChooseANumberSection , 30);
		reusableActions.scrollToElement(ddlCity);
		reusableActions.selectWhenReady(ddlCity, 81 ,30);
		//city.toUpperCase()
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
		reusableActions.waitForElementTobeClickable(searchNumberBtn, 30);
		reusableActions.clickWhenReady(searchNumberBtn);
		reusableActions.executeJavaScriptClick(lblAvailableNumbers);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinueChooseANumberSection);
		//clkNoThanks();
	}

	/**
	 * This method clicks on No Thanks button in survey modal if available
	 * @author praveen.kumar7
	 */
	public void clkNoThanks() {
		if ((reusableActions.isElementVisible(btnClkNoThanks, 5)) ||
				(reusableActions.isElementVisible(By.xpath("//div[contains(@class,'button-container')]//button[contains(.,'No,')]"), 5))) {
			reusableActions.executeJavaScriptClick(btnClkNoThanks);
		}
	}

	/**
	 * This method clicks on Use an Existing Number Tab in Choose Number Stepper
	 * @author subash.nedunchezhian
	 */
	public void clkExistingNumberTab(){
		reusableActions.executeJavaScriptClick(existingNumberTab);
	}

	/**
	 * This method enters PortInNumber from yaml file in Existing Number input field
	 * @author subash.nedunchezhian
	 */
	public void setExistingPortInNumber(String eligiblePortInNumber){
		reusableActions.clickWhenReady(existingNumberField);
		reusableActions.executeJavaScriptClick(inputPortInNumber);
		inputPortInNumber.clear();
		inputPortInNumber.sendKeys(eligiblePortInNumber);
	}

	/**
	 * This method clicks on Check Eligibility button in Choose Number stepper
	 * @author subash.nedunchezhian
	 */
	public void clkCheckEligibilityBtn(){
		reusableActions.clickWhenVisible(btnCheckEligibility);
	}

	/**
	 * This method check PortIn Eligible success message after checking the port-in eligibility
	 * @return True if entered number is eligible for port-in or False if not eligible.
	 * @author subash.nedunchezhian
	 */
	public boolean verifyPortInSuccess(){
		return reusableActions.isElementVisible(successPortInMessage);
	}

	/**
	 * This method clicks on Continue button in Choose Number stepper
	 * @author subash.nedunchezhian
	 */
	public void clkContinueChooseNumber(){
		reusableActions.clickWhenReady(btnContinueChooseANumberSection);
	}

	/**
	 * This method Clicks on the 'Continue' button for saving First name and last name
	 * @author sonali.Bansal
	 */
	public void clkCallerIDContinueBtn() {
		reusableActions.clickWhenReady(continueCallerID, 30);
	}
}
