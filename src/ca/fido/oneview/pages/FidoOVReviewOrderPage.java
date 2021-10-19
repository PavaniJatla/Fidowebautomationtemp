package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoOVReviewOrderPage extends BasePageClass {

    @FindBy(xpath = "//h1[@id='bfa-page-title'][text()='Review Your Order' or contains(text(),'Vérifiez votre')]")
    WebElement orderReviewPageTitle;

    @FindBy(xpath = "//input[contains(@name,'points-to-mention-check')]/..")
    WebElement pointsToMentionCheck;

    @FindBy(xpath = "//input[contains(@id,'ds-checkbox-id-1')]/..")
    WebElement chEmailConsent;

    @FindBy(xpath ="//button[@title='Submit order' or @title='Soumettre la commande']")
    WebElement submitOrderBtn;

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
     * Click on the 'Email Communication Consent' checkbox
     *
     * @author Veranika.Siadach
     */
    public void clkEmailConsentCheckbox() {
        reusableActions.clickWhenReady(chEmailConsent, 5);
    }

    /**
     * Click on the 'Submit Order' button
     *
     * @author Veranika.Siadach
     */
    public void clkSubmitOrderBtn() {
        reusableActions.clickWhenReady(submitOrderBtn, 5);
    }
}
