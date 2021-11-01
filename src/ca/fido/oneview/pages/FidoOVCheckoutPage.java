package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;


public class FidoOVCheckoutPage extends BasePageClass {

    public FidoOVCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[contains(@id,'ds-form-input-id')]")
    WebElement selectCity;

    @FindBy(xpath = "//ds-radio-button[@data-test='in-store-pickup']")
    WebElement rdoDeliveryMethodExpress;

    @FindBy(xpath = "//ds-radio-button[@data-test='proOnTheGo']")
    WebElement rdoDeliveryMethodProOnTheGo;

    @FindBy(xpath = "//ds-radio-button[@data-test='standard-delivery']")
    WebElement rdoDeliveryMethodStandard;

    @FindBy(xpath = "//button[@data-test='shipping-continue']")
    WebElement btnContinueShipping;

    @FindBy(xpath = "//store-list/div")
    WebElement expressLocations;

    @FindBy(xpath = "//button[@id='main-continue-button']")
    WebElement btnSubmit;

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

    @FindBy(xpath = "//ds-icon[@data-test='choose-number-complete']/following::div/p[1]")
    WebElement lblChooseNumber;

    @FindBy(xpath = "//ds-icon[@data-test='choose-number-complete']/following::div/p[3]")
    WebElement lblSelectedNumber;

    @FindBy(xpath = "//ds-radio-button[@data-test='from-value-same-shipping']")
    WebElement billingAddressShipping;

    @FindBy(xpath = "//ds-radio-button//following::div[@data-test='billing-address']")
    WebElement billingAddressShippingText;

    @FindBy(xpath = "//div[@data-test='delivery-information']//ds-form-field")
    WebElement shippingEmailFormField;

    @FindBy(xpath = "//input[@formcontrolname='emailAddressField']")
    WebElement inputEmailShipping;

    /**
     * Click on the shipping continue button
     *
     * @author Siarhei.Maiseichyk
     */
    public void clkShippingContinueButton() {
        reusableActions.javascriptScrollByVisibleElement(btnContinueShipping);
        reusableActions.executeJavaScriptClick(btnContinueShipping);
    }

    /**
     * Click on the Submit button under Cart Summary widget
     *
     * @author Siarhei.Maiseichyk
     */
    public void clkSubmitButton() {
        reusableActions.staticWait(3000);
        reusableActions.waitForElementTobeClickable(btnSubmit, 50);
        reusableActions.executeJavaScriptClick(btnSubmit);
    }

    /**
     * Clicks on the 'Continue' button after choosing available phone number
     *
     * @author Siarhei.Maiseichyk
     */
    public void clkChooseNumberContinueButton() {
        reusableActions.waitForElementVisibility(buttonChooseNumberContinue, 10);
        reusableActions.clickIfAvailable(buttonChooseNumberContinue, 10);
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
        reusableActions.selectWhenReadyByVisibleText(selectCity, cityName);
        reusableActions.waitForElementVisibility(buttonChooseNumberContinue, 10);
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

    /**
     * To verify 'Choose a number' label in the Choose a number stepper
     *
     * @return boolean value
     * @author Siarhei.Maiseichyk
     */
    public boolean verifyChooseNumberLabel() {
        reusableActions.javascriptScrollByVisibleElement(lblChooseNumber);
        return reusableActions.isElementVisible(lblChooseNumber);
    }

    /**
     * To verify selected phone number in the Choose a number stepper
     *
     * @return boolean value
     * @author Siarhei.Maiseichyk
     */
    public boolean verifySelectedPhoneNumber() {
        reusableActions.javascriptScrollByVisibleElement(lblSelectedNumber);
        return reusableActions.isElementVisible(lblSelectedNumber);
    }

    /**
     * To click on the Billing Address radio button in the Shipping stepper
     *
     * @return true if billing address is displayed, else false.
     * @author Siarhei.Maiseichyk
     */
    public boolean clkBillingAddress() {
        reusableActions.waitForElementTobeClickable(billingAddressShipping, 30);
        reusableActions.scrollToElement(billingAddressShipping);
        reusableActions.clickWhenReady(billingAddressShipping, 30);
        return reusableActions.isElementVisible(billingAddressShippingText, 10);
    }

    /**
     * To click on specified delivery method in the shipping stepper
     *
     * @param deliveryMethod delivery method
     * @author Siarhei.Maiseichyk
     */
    public void selectDeliveryMethod(String deliveryMethod) {
        switch (deliveryMethod.toUpperCase()) {
            case "STANDARD":
                reusableActions.waitForElementVisibility(rdoDeliveryMethodStandard, 5);
                reusableActions.clickWhenReady(rdoDeliveryMethodStandard);
                break;
            case "EXPRESS":
                reusableActions.waitForElementVisibility(rdoDeliveryMethodExpress, 5);
                reusableActions.clickWhenReady(rdoDeliveryMethodExpress, 30);
                reusableActions.waitForElementVisibility(expressLocations, 60);
                break;
            case "PRO":
                reusableActions.waitForElementVisibility(rdoDeliveryMethodProOnTheGo, 5);
                reusableActions.clickWhenReady(rdoDeliveryMethodProOnTheGo, 30);
                break;
            default:
                throw new IllegalArgumentException("Unknown shipping option was specified");
        }
    }

    /**
     * This method enters the value in email address field in shipping page
     *
     * @author Veranika.Siadach
     */
    public void setEmailShippingPage() {
        if (reusableActions.isElementVisible(shippingEmailFormField, 20)) {
           inputEmailShipping.sendKeys(FormFiller.generateEmail());
        }
    }
}