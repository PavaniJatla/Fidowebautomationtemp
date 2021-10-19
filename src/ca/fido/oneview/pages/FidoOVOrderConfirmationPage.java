package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoOVOrderConfirmationPage extends BasePageClass {

    @FindBy(xpath = "//h1[contains(@id,'bfa-page-title') and contains(.,'Confirmation')]")
    WebElement lblOrderConfirmation;

    @FindBy(xpath = "//span[(@class='text-bold')]")
    WebElement banOrderConfirmation;

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public FidoOVOrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates whether the Order Confirmation page has loaded
     *
     * @return true if 'Order Confirmation' header displayed; else false
     * @author Veranika.Siadach
     */
    public boolean verifyOrderConfirmationPageLoad() {
        return reusableActions.isElementVisible(lblOrderConfirmation, 80);
    }

    /**
     * Validates whether BAN shown in the Order Confirmation page matches to the BAN of the account given
     * @return true if 'Order Confirmation' header displayed; else false
     * @author rajesh.varalli1
     */
    public boolean verifyBanOrderConfirmationPage(String banNo) {
        String ban = reusableActions.getWhenReady(banOrderConfirmation).getText().trim();
        if (ban.equalsIgnoreCase(banNo)) {
            return true;
        } else {
            return false;
        }
    }
}
