package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoOVReviewOrderPage extends BasePageClass {

    @FindBy(xpath = "//h1[@id='bfa-page-title'][text()='Review Your Order' or contains(text(),'Vérifiez votre')]")
    WebElement orderReviewPageTitle;

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
        return reusableActions.isElementVisible(orderReviewPageTitle, 60);
    }

}
