package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoShippingCartPage extends BasePageClass {

    public FidoShippingCartPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath="//button[@data-test='proceed-to-checkout-btn']")
    WebElement proceedToCheckOut;

    public void clkproceedToCheckOut() {
        reusableActions.staticWait(5000);
        reusableActions.javascriptScrollByVisibleElement(proceedToCheckOut);
        reusableActions.executeJavaScriptClick(proceedToCheckOut);
        reusableActions.waitForElementInvisibilityNOException(proceedToCheckOut, 60);

    }
}
