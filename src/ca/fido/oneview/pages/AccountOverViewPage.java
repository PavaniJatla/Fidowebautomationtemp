package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AccountOverViewPage extends BasePageClass {

    @FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde'  or text()='Total Balance']")
    WebElement infoBalanceLabel;

    @FindBy(xpath = "//div[contains(@class,'other-services')]//t[contains(.,'Wireless') or contains(.,'Sans-fil')]")
    WebElement addNewWirelessLineButton;

    @FindBy(xpath = "//a[@id='language-changed']")
    WebElement linkFrench;

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'View all alerts') or contains(text(), 'Voir toutes les alertes')]"),
            @FindBy(xpath = "//div[@class='agent-notifications-popup ng-star-inserted']")
    })
    WebElement viewAllAlerts;

    @FindBy(xpath = "//agent-notifications")
    WebElement notificationBell;

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

    /**
     * This method clicks on French link at the bottom of the screen
     * @author Siarhei.Maiseichyk
     */
    public void setLanguageFrench() {
        reusableActions.executeJavaScriptClick(linkFrench);
    }

    /**
     * To skip notification panel with a bell icon
     * @author Siarhei.Maiseichyk
     */
    public void skipNotification() {
        reusableActions.waitForElementVisibility(notificationBell, 20);
        if (reusableActions.isElementVisible(viewAllAlerts, 1)) {
            notificationBell.click();
        }
    }
}
