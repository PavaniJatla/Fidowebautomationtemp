package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOverViewPage extends BasePageClass {

    @FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde'  or text()='Total Balance']")
    WebElement infoBalanceLabel;

    @FindBy(xpath = "//div[contains(@class,'other-services')]//t[contains(.,'Wireless') or contains(.,'Sans-fil')]")
    WebElement addNewWirelessLineButton;

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public AccountOverViewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * To verify the successful login
     *
     * @return true if the balance label is present ; else false
     * @author Veranika.Siadach
     */
    public boolean verifySuccessfulLogin() {
        return reusableActions.isElementVisible(infoBalanceLabel, 60);
    }

    /**
     * Selects the Add a Wireless Line Button on the account dashboard
     *
     * @author Veranika.Siadach
     */
    public void selectAddAWirelessLineButton() {
        reusableActions.javascriptScrollToBottomOfPage();
        reusableActions.waitForElementVisibility(addNewWirelessLineButton);
        reusableActions.clickWhenReady(addNewWirelessLineButton, 45);
    }
}
