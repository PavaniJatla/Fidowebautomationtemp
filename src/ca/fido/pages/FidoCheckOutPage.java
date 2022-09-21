package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;


public class FidoCheckOutPage extends BasePageClass {

	public FidoCheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//agm-map")
	WebElement mapBopis;

	@FindBy(xpath = "//select[contains(@id,'ds-form-input-id')]")
	WebElement selectCity;

	@FindBy(xpath = "//p[@data-test='step-title-shipping']")
	WebElement lblShippingPickUp;

	@FindAll({
			@FindBy(xpath = "//ds-radio-button[@data-test='in-store-pickup']"),
			@FindBy(xpath = "//p[contains(text(),'Express Pickup')]/ancestor::span[contains(@class,'ds-selection__label')]"),
			@FindBy(xpath = "//ds-selection[@data-test='shipping-option-inStorePickUP']//p[contains(text(),' Express Pickup – FREE')]")
	})
	WebElement rdoDeliveryMethodExpress;

	@FindBy(xpath = "//ds-radio-button[@data-test='proOnTheGo']")
	WebElement rdoDeliveryMethodProOnTheGo;

	@FindAll({
	@FindBy(xpath = "//ds-radio-button[@data-test='standard-delivery']"),
			@FindBy(xpath = "//ds-selection[@data-test='shipping-option-standard']//p[contains(text(),'Standard Delivery')]"),
			@FindBy(xpath = "//p[contains(text(),'Standard Delivery')]/ancestor::span[contains(@class,'ds-selection__label')]")
	})
	WebElement rdoDeliveryMethodStandard;

	@FindAll({
			@FindBy(xpath = "//span[contains(@class,'ds-button__copy text-button') and contains(.,'Change address')]"),
			@FindBy(xpath = "//button[@data-test='change-address-btn']//span[contains(text(),'Change address')]")
	})
	WebElement changeShipAddressbtn;

	@FindBy(xpath="//r-address-auto-complete//input//parent::div")
	WebElement txtHomeAddress;

	@FindAll({
			@FindBy(xpath="//r-address-auto-complete//input"),
			@FindBy(xpath="(//ul[@role='listbox']//li)[1]"),
	})
	WebElement lblTxtHomeAddress;

	@FindAll({
			@FindBy(xpath="//div[@class='pca pcalist']/div[contains(@class,'pcalastitem')]/span[@class='pcadescription']/.."),
			@FindBy(xpath="//ul[@role='listbox']//li[not(contains(.,'Addresses'))]"),
	})
	WebElement lblAddressResult;

	@FindBy(xpath = "//input[contains(@class,'ds-input') and contains(@id,'ds-form-input-id')]")
	WebElement inputNewShippingAddress;

	@FindBy(xpath = "//button[@data-test='edit-email-btn']//span[contains(text(),'edit')]")
	WebElement editEmail;

	@FindBy(xpath = "//input[contains(@formcontrolname,'emailAddressField') and contains(@id,'ds-form-input-id')]/parent::div")
	WebElement emailField;

	@FindBy(xpath = "//input[contains(@formcontrolname,'emailAddressField') and contains(@id,'ds-form-input-id')]")
	WebElement inputEmailShipping;

	@FindBy(xpath = "//div[@data-test='location-item']//span[contains(text(),'2')]")
	WebElement selectAnotherBOPISStore;

	@FindBy(xpath = "//div[@data-test='location-item']//span[contains(text(),'2')]/following::div[2]/p")
	WebElement selectedBOPISStoreLoc;

	@FindBy(xpath = "//button[@data-test='shipping-continue']")
	WebElement btnContinueShipping;

	@FindBy(xpath = "//button[@id='main-continue-button']")
	WebElement btnSubmit;

	@FindBy(xpath = "//button[@data-test='choose-number-continue']")
	WebElement buttonChooseNumberContinue;

	@FindBy(xpath = "//div[@data-test='delivery-information']//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtEmailShipping;

	@FindAll({
			@FindBy(xpath = "(//div[contains(@class,'button-container')]//button)[2]"),
			@FindBy(xpath = "//div[contains(@class,'button-container')]//button[contains(.,'No,')]")
	})
	WebElement btnClkNoThanks;

	@FindBy(xpath = "(//div[contains(@class,'button-container')]//button)[2]")
	WebElement btnNoThanks;

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
	 * Verify if the checkout page loaded
	 *
	 * @return boolean true if page loaded else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyCheckOutPage() {
		return reusableActions.isElementVisible(selectCity, 60);
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
			//reusableActions.staticWait(5000);
			reusableActions.executeJavaScriptClick(rdoDeliveryMethodExpress);
		} else if (deliveryMethod.equalsIgnoreCase("PRO")) {
			//reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(rdoDeliveryMethodProOnTheGo, 30);
		} else {
			//reusableActions.staticWait(5000);
			reusableActions.executeJavaScriptClick(rdoDeliveryMethodStandard);
		}
	}

	/**
	 * This method selects the another Express Pickup Store Location on Shipping page
	 * @author Subash.Nedunchezhian
	 */
	public void selectAnotherBOPISStore(){
		reusableActions.executeJavaScriptClick(selectAnotherBOPISStore);
	}
	/**
	 * This method gets the Express Pickup Store Location on Order Review page
	 *  @return String Express Pickup Store Location
	 * @author Subash.Nedunchezhian
	 */
	public String getSelectedBOPISStoreLoc(){
		return reusableActions.getWhenReady(selectedBOPISStoreLoc).getText().replaceAll("\\n", "");
	}

	/**
	 * Enter the new Shipping Address on the Shipping page and select it from the dropdown
	 * @param newShippingAddress from yaml file
	 * @author subash.nedunchezhian
	 */
	public void selectNewShippingAddress(String newShippingAddress) {
		reusableActions.executeJavaScriptClick(changeShipAddressbtn);
		reusableActions.executeJavaScriptClick(txtHomeAddress);
		lblTxtHomeAddress.sendKeys(newShippingAddress);
		//reusableActions.getWhenReady(lblTxtHomeAddress,10).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		reusableActions.executeJavaScriptClick(lblAddressResult);
		if (reusableActions.isElementVisible(lblAddressResult, 10)) {
			reusableActions.executeJavaScriptClick(lblAddressResult);
		}
	}
	/**
	 * This method clicks on Edit Email and enter new email address from FormFiller
	 * @author subash.nedunchezhian
	 */
	public void setNewEmailAddress(){
		reusableActions.clickWhenVisible(editEmail);
		reusableActions.getWhenReady(inputEmailShipping).clear();
		reusableActions.clickWhenReady(emailField);
		reusableActions.getWhenReady(inputEmailShipping).sendKeys(FormFiller.generateEmail());
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
    public void selectCityForChooseYourTelephoneNum(String cityName) {
    	reusableActions.getWhenReady(selectCity, 30).click();
    	reusableActions.selectWhenReadyByVisibleText(selectCity,cityName);
    	reusableActions.waitForElementVisibility(buttonChooseNumberContinue,10);
    	reusableActions.clickWhenReady(buttonChooseNumberContinue, 5);

    }

	/**
	 * This method clicks on No Thanks button in survey modal if available
	 * @author praveen.kumar7
	 */
	public void clkNoThanks() {
		if((reusableActions.isElementVisible(btnClkNoThanks,8)) ||
				(reusableActions.isElementVisible(By.xpath("//div[contains(@class,'button-container')]//button[contains(.,'No,')]"),5))) {
			reusableActions.executeJavaScriptClick(btnNoThanks);
		}
	}

	/**
	 * This method clicks on No Thanks button in survey modal if available
	 * @author praveen.kumar7
	 */
	public void clkBtnNoThanks() {
		reusableActions.clickIfAvailable(btnNoThanks,5);
	}
}