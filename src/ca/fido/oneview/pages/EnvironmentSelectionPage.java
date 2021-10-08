package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnvironmentSelectionPage extends BasePageClass {

    @FindBy(xpath = "//app-ov-entry-form/form")
    WebElement enterValuesForm;

    @FindBy(xpath = "//input[@id='account-number']")
    WebElement accountNumber;

    @FindBy(xpath = "//input[@id='contact-id']")
    WebElement contactId;

    @FindBy(xpath = "//input[@id='agent-roles']")
    WebElement userRoles;

    @FindBy(xpath = "//select[@id='target-url']")
    WebElement targetUrl;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement launchBtn;

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public EnvironmentSelectionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select the environment on environment selection page
     *
     * @param accountNumber to of the user logging in
     * @param contactId     to of the user logging in
     * @author Veranika.Siadach
     */
    public void launchOneView(String accountNumber, String contactId) {
        enterAccountNumber(accountNumber);
        enterContactId(contactId);
        enterUserRoles("CSR,BRT Authorized CSR-3,Oneview Pilot-1,Oneview Pilot-2,Oneview Pilot-4,Oneview BRT-1,Oneview BRT-2,Oneview BRT-3,Oneview BRT-4,R76,BT User,R21,R39,R60,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310,BRT Authorized CSR-1,BRT Authorized CSR-3,BRT Authorized CSR-4,IgniteLearningLabAdditiveRole");

        String env = System.getProperty("OneViewEnv").substring(4);
        selectOneViewUrl(env);
        launchOneView();
    }

    /**
     * Enter account number
     *
     * @param accountNumberValue to of the user logging in
     * @author Veranika.Siadach
     */
    public void enterAccountNumber(String accountNumberValue) {
        reusableActions.waitForElementVisibility(enterValuesForm, 60);
        accountNumber.sendKeys(accountNumberValue);
    }

    /**
     * Enter user contact id
     *
     * @param userContactId to of the user logging in
     * @author Veranika.Siadach
     */
    public void enterContactId(String userContactId) {
        reusableActions.waitForElementVisibility(enterValuesForm, 30);
        contactId.sendKeys(userContactId);
    }

    /**
     * Enter userRoles
     *
     * @param userRoleValue user role
     * @author Veranika.Siadach
     */
    public void enterUserRoles(String userRoleValue) {
        reusableActions.waitForElementVisibility(enterValuesForm, 30);
        userRoles.sendKeys(userRoleValue);
    }

    /**
     * Select one view url
     *
     * @param env to select on one view portal
     * @author Veranika.Siadach
     */
    public void selectOneViewUrl(String env) {
        reusableActions.javascriptScrollByVisibleElement(targetUrl);
        String url = "https://" + env.toLowerCase() + "-oneview.fido.ca";
        reusableActions.selectWhenReadyByVisibleText(targetUrl, url);
    }

    /**
     * Launch OneView
     *
     * @author Veranika.Siadach
     */
    public void launchOneView() {
        reusableActions.waitForElementVisibility(launchBtn, 30);
        reusableActions.clickWhenReady(launchBtn,30);
    }
}
