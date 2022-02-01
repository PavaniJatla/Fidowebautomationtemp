package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//t[contains(.,'Upgrade') or contains(.,'Rehausse')]/ancestor::a")
    WebElement linkUpgrade;


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
        reusableActions.javascriptScrollToBottomOfPage();
        reusableActions.executeJavaScriptClick(addNewWirelessLineButton);
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

    /**
     * Clicks on the 'Upgrade My Device' button
     * @author praveen.kumar7
     */
    public void clkUpgradeMyDevice() {
        reusableActions.waitForElementVisibility(linkUpgrade ,30);
        reusableActions.executeJavaScriptClick(linkUpgrade);
        reusableActions.waitForElementInvisibilityNOException(linkUpgrade,30);
    }

}
