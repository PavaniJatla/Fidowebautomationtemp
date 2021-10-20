package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class FidoOVReviewOrderPage extends BasePageClass {

    @FindBy(xpath = "//h1[@id='bfa-page-title'][text()='Review Your Order' or contains(text(),'Vérifiez votre')]")
    WebElement orderReviewPageTitle;

    @FindBy(xpath = "//input[contains(@name,'points-to-mention-check')]/..")
    WebElement pointsToMentionCheck;

    @FindBy(xpath = "//ds-checkbox[@data-test='bopis-consent']")
    WebElement chBopisConsent;

    @FindBy(xpath = "//button[@title='Submit order' or @title='Soumettre la commande']")
    WebElement submitOrderBtn;

    @FindBy(xpath = "//h1[contains(text(),'One Time Payment') or contains(.,'Paiement Unique')]")
    WebElement lblPaymentStep;

    @FindBy(xpath = "//ds-radio-button[contains(@data-test,'safe-send-radio-button')]")
    WebElement preAuthorizedCreditCardTokenBtn;

    @FindBy(xpath = "//ds-form-field[@data-test='name']")
    WebElement cardName;

    @FindBy(xpath = "//ds-form-field[@data-test='name']//input")
    WebElement inputCardName;

    @FindBy(xpath = "//ds-form-field[@data-test='number']//input")
    WebElement inputTokenNumber;

    @FindBy(xpath = "//ds-form-field[@data-test='expiry-date']//input")
    WebElement inputExpiryDate;

    @FindBy(xpath = "//ds-form-field[@data-test='cvv']//div[contains(@class, 'ds-formField__inputContainer')]")
    WebElement txtContainerCvv;

    @FindBy(xpath = "//ds-form-field[@data-test='cvv']//input")
    WebElement inputTxtCvv;

    @FindBy(xpath = "//button[@data-test='continue-btn']")
    WebElement btnSubmitPayment;

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public FidoOVReviewOrderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify the title of Order Review Page is present
     *
     * @return true if title of Order Review Page is present, else false
     * @author Veranika.Siadach
     */
    public boolean isOrderReviewPageTitlePresent() {
        return reusableActions.isElementVisible(orderReviewPageTitle, 80);
    }

    /**
     * Click on the 'Points To Mention' checkbox
     *
     * @author Veranika.Siadach
     */
    public void clkPointsToMentionCheckbox() {
        reusableActions.clickWhenReady(pointsToMentionCheck, 2);
    }

    /**
     * Click on the BOPIS checkbox
     *
     * @author Veranika.Siadach
     */
    public void clkBopisCheckbox() {
        reusableActions.clickIfAvailable(chBopisConsent, 10);
    }

    /**
     * Click on the 'Submit Order' button
     *
     * @author Veranika.Siadach
     */
    public void clkSubmitOrderBtn() {
        reusableActions.clickWhenReady(submitOrderBtn, 5);
    }

    /**
     * Determines if payment is required or not
     *
     * @return true if 'Payment' appears in the Steps above; else false
     * @author Veranika.Siadach
     */
    public boolean isPaymentRequired() {
        return reusableActions.isElementVisible(lblPaymentStep, 40);
    }

    /**
     * Clicks the pre-Authorized Credit Card Token Radio Button when available
     *
     * @author Veranika.Siadach
     */
    public void clkPreAuthorizedCreditCardTokenButton() {
        reusableActions.clickWhenVisible(preAuthorizedCreditCardTokenBtn, 60);
    }

    /**
     * Enter the firstName on the Create Profile stepper, First Name field
     *
     * @author Veranika.Siadach
     */

    public void setCardName() {
        reusableActions.clickWhenReady(cardName);
        reusableActions.getWhenReady(inputCardName, 10).sendKeys(FormFiller.generateRandomName() + FormFiller.generateRandomName());
    }

    /**
     * Sets the Token Number, Expiry Year and Expiry Month
     *
     * @param strTokenNumber Token Number
     * @param strCCExpMonth  Credit Card Expiry Month
     * @param strCCExpYear   Credit Card Expiry Year
     * @author Veranika.Siadach
     */
    public void setTokenDetails(String strTokenNumber, String strCCExpMonth, String strCCExpYear) {
        inputTokenNumber.click();
        inputTokenNumber.sendKeys(strTokenNumber);

        inputExpiryDate.click();
        reusableActions.getWhenReady(inputExpiryDate, 10).sendKeys(strCCExpMonth + strCCExpYear);

        setCvv();
    }

    /**
     * Set the dynamic CVV for Pre-Auth credit card
     *
     * @author Veranika.Siadach
     */
    public void setCvv() {
        String strCVV = FormFiller.generateCVVNumber();
        reusableActions.waitForElementVisibility(txtContainerCvv, 50);
        reusableActions.getWhenReady(txtContainerCvv, 10).click();
        inputTxtCvv.click();
        reusableActions.getWhenReady(inputTxtCvv).sendKeys(strCVV);
    }

    /**
     * Clicks on the 'Submit' button
     *
     * @author Veranika.Siadach
     */
    public void clkSubmitPayment() {
        reusableActions.waitForElementVisibility(btnSubmitPayment);
        reusableActions.executeJavaScriptClick(btnSubmitPayment);
    }
}
