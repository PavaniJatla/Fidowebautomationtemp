package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

import java.util.Arrays;
import java.util.List;


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

	@FindBy(xpath = "//button[@data-test='choose-number-continue']")
	WebElement buttonChooseNumberContinue;

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
		reusableActions.waitForElementVisibility(btnSubmit , 30);
		reusableActions.scrollToElementAndClick(btnSubmit);
		//reusableActions.clickWhenReady(btnSubmit,30);
	}

	/**
	 * Clicks on the 'Continue' button for enter user's name
	 * @author Saurav.Goyal
	 */
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
    	reusableActions.selectWhenReady(selectCity,cityName);

    }
}