package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.FormFiller;


public class FidoOVCheckOutPage extends BasePageClass {

	public FidoOVCheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//agm-map")
	WebElement mapBopis;

	@FindBy(xpath = "//select[contains(@id,'ds-form-input-id')]")
	WebElement selectCity;

	@FindBy(xpath = "//p[@data-test='step-title-shipping']")
	WebElement lblShippingPickUp;

	@FindBy(xpath = "//ds-radio-button[@data-test='in-store-pickup']")
	WebElement rdoDeliveryMethodExpress;

	@FindBy(xpath = "//ds-radio-button[@data-test='proOnTheGo']")
	WebElement rdoDeliveryMethodProOnTheGo;

	@FindBy(xpath = "//ds-radio-button[@data-test='standard-delivery']")
	WebElement rdoDeliveryMethodStandard;

	@FindBy(xpath = "//button[@data-test='shipping-continue']")
	WebElement btnContinueShipping;

	@FindBy(xpath = "//button[@id='main-continue-button']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@data-test='delivery-information']//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtEmailShipping;

	@FindBy(xpath = "//ds-step[@id='step-3']//h2")
	WebElement chooseNumberTitle;

	@FindBy(xpath = "(//button[contains(@id,'ds-tabs')])[1]")
	WebElement selectNewNumberTab;

	@FindBy(xpath = "(//button[contains(@id,'ds-tabs')])[2]")
	WebElement useAnExistingNumberTab;

	@FindBy(xpath = "//ds-radio-group[@formcontrolname='newNumber']/div/div[1]")
	WebElement rdoChoosePhoneNumber;

	@FindBy(xpath = "//div[@class='my-16']/button")
	WebElement btnFindMoreAvlNumber;

	@FindBy(xpath = "//button[@data-test='choose-number-continue']")
	WebElement buttonChooseNumberContinue;
	/**
	 * This method enters the value in email address field in shipping page
	 * @author praveen.kumar7
	 */
	public void setEmailBopis() {
		if (reusableActions.isElementVisible(txtEmailShipping, 20)) {
			reusableActions.getWhenReady(txtEmailShipping, 20).click();
			reusableActions.getWhenReady(By.xpath("//div[@data-test='delivery-information']//div[contains(@class,'ds-formField__inputContainer')]//input"), 10).sendKeys(FormFiller.generateEmail());
			reusableActions.staticWait(2000);
		}
	}

	/**
	 * Verify map on the checkout page
	 * @return boolean true if page loaded else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyMapOnCheckOutPage() {
		return reusableActions.isElementVisible(mapBopis, 60);
	}

	/**
	 * Verify if the label is displayed or not
	 *
	 * @return boolean true if shipping label loaded else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyShippingLabelCheckOutPage() {
		return reusableActions.isElementVisible(lblShippingPickUp, 60);
	}

	/**
	 * Click on the required shipping option
	 * @author Saurav.Goyal
	 */
	public void clkShippingType(String deliveryMethod) {
		if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(rdoDeliveryMethodExpress, 30);
		} else if (deliveryMethod.equalsIgnoreCase("PRO")) {
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(rdoDeliveryMethodProOnTheGo, 30);
		} else {
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(rdoDeliveryMethodStandard, 30);
		}
	}

	/**
	 * Click on the shipping continue button
	 * @author Saurav.Goyal
	 */
	public void clkShippingContinueButton() {
			reusableActions.clickWhenReady(btnContinueShipping,30);
	}

	/**
	 * Click on the Submit button
	 * @author Saurav.Goyal
	 */
	public void clkSubmitButton() {
		//reusableActions.waitForElementTobeClickable(btnSubmit , 60);
		reusableActions.javascriptScrollToTopOfPage();
		//reusableActions.javascriptScrollByCoordinates(0,-50);
		reusableActions.clickWhenReady(btnSubmit,30);
		//reusableActions.clickWhenReady(btnSubmit,30);
	}

	/**
	 * Clicks on the 'Continue' button for enter user's name
	 * @author Saurav.Goyal
	 *///input[@id='pan']
	public void clkChooseNumberContinueButton() {
		reusableActions.waitForElementVisibility(buttonChooseNumberContinue, 120);
		reusableActions.clickIfAvailable(buttonChooseNumberContinue, 120);
	}

	/**
     * This method will select the city for which connection is required
     * @param cityName is name of the city
     * @author Saurav.Goyal
     */
    public void selectCityForChooseYourPhoneNum(String cityName) {
    	reusableActions.getWhenReady(selectCity, 30).click();
    	reusableActions.selectWhenReadyByVisibleText(selectCity,cityName);
    	reusableActions.waitForElementVisibility(buttonChooseNumberContinue,10);
    	reusableActions.clickWhenReady(buttonChooseNumberContinue, 5);
    }

	/**
	 * Verify if the checkout page loaded
	 *
	 * @return boolean true if page loaded else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyCheckOutPage() {
		return reusableActions.isElementVisible(selectCity, 60);
	}

	/**
	 * To verify Choose A Number Title in the Choose a Number stepper
	 *
	 * @return True or False
	 * @author Siarhei.Maiseichyk
	 */
	public boolean isChooseNumberTitleDisplayed() {
		return reusableActions.isElementVisible(chooseNumberTitle, 60);
	}

	/**
	 * To verify 'Select a new number' and 'Use an existing number' tabs are present in the Choose a Number stepper and return boolean value.
	 *
	 * @return True or False
	 * @author Siarhei.Maiseichyk
	 */
	public boolean isChooseNumberTabsDisplayed() {
		return (reusableActions.isElementVisible(selectNewNumberTab) && reusableActions.isElementVisible(useAnExistingNumberTab));
	}

	/**
	 * Select specified city in 'Select a city dropdown'
	 *
	 * @param cityName value from yaml file.
	 * @author Siarhei.Maiseichyk
	 */
	public void selectCityDropdownOption(String cityName) {
		reusableActions.getWhenReady(selectCity, 30).click();
		reusableActions.selectWhenReadyByVisibleText(selectCity,cityName);
		reusableActions.waitForElementVisibility(buttonChooseNumberContinue,10);
	}

	/**
	 * To click on the first available phone number radio button in the Choose a Number stepper
	 *
	 * @author Siarhei.Maiseichyk
	 */
	public void selectFirstAvlPhoneNumber() {
		reusableActions.getWhenReady(rdoChoosePhoneNumber, 80).click();
	}

	/**
	 * To verify 'Find more available numbers' button in the Choose a Number stepper
	 *
	 * @return True or false
	 * @author Siarhei.Maiseichyk
	 */
	public boolean isFindMoreAvlNumbersButtonPresent() {
		return reusableActions.isElementVisible(btnFindMoreAvlNumber);
	}
}