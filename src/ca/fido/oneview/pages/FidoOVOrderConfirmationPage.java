package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoOVOrderConfirmationPage extends BasePageClass {

    @FindBy(xpath = "//h1[contains(@id,'bfa-page-title') and contains(.,'Confirmation')]")
    WebElement lblOrderConfirmation;

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
        reusableActions.staticWait(5000);
        return reusableActions.isElementVisible(lblOrderConfirmation, 60);
    }
}
