package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

import java.util.List;

public class FidoOVPlanConfigPage extends BasePageClass {

    @FindBy(xpath = "//span[contains(@class,'cartSummary')]")
    WebElement cartSummaryLabel;

    @FindBy(xpath = "//p[@data-test='stepper-0-completed-step-label']")
    WebElement deviceTitleLabel;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-2-edit-step-selection-option-infinite-')]//label[1]")
    List<WebElement> dataOptions;

    @FindBy(xpath = "//button[@data-test='stepper-1-edit-step-continue-button']")
    WebElement preCartDeviceCostContinueButton;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-1-edit-step-selection-option-')]//label[1]")
    List<WebElement> devicesTiers;

    @FindBy(xpath = "//button[@data-test='stepper-2-edit-step-continue-button']")
    WebElement preCartDataOptionContinueButton;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-3-edit-step-selection-option-')]//label[1]")
    List<WebElement> talkOptions;

    @FindBy(xpath = "//button[@data-test='stepper-3-edit-step-continue-button']")
    WebElement preCartTalkOptionContinueButton;

    @FindBy(xpath = "//button[@data-test='stepper-4-edit-step-continue-button']")
    WebElement preCartAddonsContinueButton;

    @FindBy(xpath = "//div[@id='ds-stepper-id-1-completedContent-2']//ds-icon")
    WebElement preCartDataOptionCheckedIcon;

    @FindBy(xpath = "//div[@id='ds-stepper-id-1-completedContent-3']//ds-icon")
    WebElement preCartTalkOptionCheckedIcon;

    @FindBy(xpath = "//div[@id='ds-stepper-id-1-completedContent-4']//ds-icon")
    WebElement preCartAddonsCheckedIcon;

    @FindBy(xpath = "//input[@id='ds-form-input-id-0']/parent::div")
    WebElement callerFirstNameField;

    @FindBy(xpath = "//input[@id='ds-form-input-id-0']")
    WebElement callerFirstNameInput;

    @FindBy(xpath = "//input[@id='ds-form-input-id-1']/parent::div")
    WebElement callerLastNameField;

    @FindBy(xpath = "//input[@id='ds-form-input-id-1']")
    WebElement callerLastNameInput;

    @FindBy(xpath = "//button[@data-test='stepper-5-edit-step-continue-button' and not(@aria-disabled)]")
    WebElement callerIdContinueButton;

    @FindBy(xpath = "//button[@data-test='build-plan-checkout-flow-button' and not(@aria-disabled)]")
    WebElement continueButtonOnCartSummary;

    @FindBy(xpath = "//span[contains(text(),'Créer forfait') or contains(text(),'Build Plan')]")
    WebElement buildPlanInBreadCrumb;

    @FindBy(xpath = "//nav[@class='ds-breadcrumb']")
    WebElement breadCrumb;

    @FindBy(xpath="//p[contains(.,'Financing options')]")
    WebElement txtFinancingOptions;

    @FindBy(xpath = "(//label[contains(@class,'ds-radioLabel')])[2]")
    WebElement noTermRadioBtn;

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public FidoOVPlanConfigPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies if Plan config page is loaded successfully
     *
     * @return true if plan config page is loaded, else false
     * @author Veranika.Siadach
     */
    public boolean ifPlanConfigPageLoaded() {
        return reusableActions.isElementVisible(cartSummaryLabel, 30);
    }

    /**
     * This method will verify device title on Plan config Page
     *
     * @param deviceName String of device name
     * @return true if device title is displayed else false
     * @author Veranika.Siadach
     */
    public boolean verifyDeviceTitle(String deviceName) {
        return deviceTitleLabel.getText().equalsIgnoreCase(deviceName);
    }

    /**
     * Select data option on Plan config page
     *
     * @param dataOptionIndex String value of data option to be selected
     * @author Veranika.Siadach
     */
    public void selectDataOptionAndClickContinueButton(String dataOptionIndex) {
        int stepper = 2;
        String xpathValue = createXpathWithInputData(dataOptionIndex, stepper);

        if (Integer.parseInt(dataOptionIndex) == 0) {
            reusableActions.clickWhenVisible(preCartDataOptionContinueButton, 30);
        } else {
            reusableActions.clickWhenVisible(By.xpath(xpathValue), 40);
            reusableActions.clickWhenVisible(preCartDataOptionContinueButton, 40);
        }
    }

    /**
     * Selects talk option and verifies if addons stepper continue button is displayed
     *
     * @return true if data option is selected, else false
     * @author Veranika.Siadach
     */
    public boolean isDataOptionSelected() {
        return reusableActions.isElementVisible(preCartDataOptionCheckedIcon);
    }

    /**
     * Clicks on NO TERM radio button in device cost stepper
     *
     * @author Veranika.Siadach
     */
    public void clkRadioButtonNoTerm() {
        reusableActions.waitForElementVisibility(txtFinancingOptions, 30);
        reusableActions.scrollToElement(txtFinancingOptions);
        reusableActions.clickWhenVisible(noTermRadioBtn);
    }

    /**
     * Select Device Cost tier on Plan config page and clicks on continue button
     *
     * @param deviceCostIndex String value of Device Cost to be selected
     * @author Veranika.Siadach
     */
    public void selectDeviceCostAndClickOnContinueButton(String deviceCostIndex) {
        int stepper = 1;
        if (Integer.parseInt(deviceCostIndex) == 1) {
            clkRadioButtonNoTerm();
        }

        String planIndex = getUpdatedDeviceCostIndex(deviceCostIndex);
        String xpathValue = createXpathWithInputData(planIndex, stepper);

        if (Integer.parseInt(planIndex) != 0) {
            reusableActions.clickWhenVisible(By.xpath(xpathValue), 60);
        }
        reusableActions.clickWhenVisible(preCartDeviceCostContinueButton, 30);
    }

    /**
     * This method sets the value for deviceCostIndex
     *
     * @param deviceCostIndex String value of deviceCostIndex
     * @return return the String value of index
     * @author Veranika.Siadach
     */
    public String getUpdatedDeviceCostIndex(String deviceCostIndex) {
        if ((deviceCostIndex == null) || (deviceCostIndex.isEmpty()) || (Integer.parseInt(deviceCostIndex) > devicesTiers.size() - 1)) {
            deviceCostIndex = "0";
            return deviceCostIndex;
        }
        return deviceCostIndex;
    }

    /**
     * Selects talk option and verifies if addons stepper continue button is displayed
     *
     * @return true if talk option is selected, else false
     * @author Veranika.Siadach
     */
    public boolean isTalkOptionSelected() {
        boolean result;

        if (reusableActions.isElementVisible(preCartTalkOptionCheckedIcon)) {
            result = reusableActions.isElementVisible(preCartAddonsContinueButton, 30);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Selects talk option and verifies if addons stepper continue button is displayed
     *
     * @param talkOptionIndex String value of talk option to be selected
     *                        return boolean true if continue button is displayed in addons stepper else false
     * @return true if addons continue button is visible, else false
     * @author Veranika.Siadach
     */
    public boolean verifyTalkOptionSelectionAndAddonsContinueButton(String talkOptionIndex) {
        int stepper = 3;
        String xpathValue = createXpathWithInputData(talkOptionIndex, stepper);

        if (Integer.parseInt(talkOptionIndex) == 0) {
            reusableActions.clickWhenVisible((preCartTalkOptionContinueButton), 20);
        }
        if (Integer.parseInt(talkOptionIndex) == 1) {
            reusableActions.clickWhenVisible(By.xpath(xpathValue), 30);
            reusableActions.clickWhenVisible(preCartTalkOptionContinueButton);
        }
        return reusableActions.isElementVisible(preCartAddonsContinueButton, 30);
    }

    /**
     * This method sets the value for dataOptionIndex for regular plans
     *
     * @param dataOptionIndex String value of dataOptionIndex
     * @return the String value of index
     * @author Veranika.Siadach
     */
    public String getUpdatedDataOptionIndex(String dataOptionIndex) {
        if ((dataOptionIndex == null) || (dataOptionIndex.isEmpty()) || (Integer.parseInt(dataOptionIndex) > dataOptions.size() - 1)) {
            dataOptionIndex = "0";
            return dataOptionIndex;
        }
        return dataOptionIndex;
    }

    /**
     * Creates an xpath for the provided stepper with index value which is passed as parameter
     *
     * @param xpathValue string value of device cost, data option and talk option stepper
     * @param stepper    String value of the stepper index
     * @return String value of an xpath
     * @author Veranika.Siadach
     */
    public String createXpathWithInputData(String xpathValue, int stepper) {
        String xpath;

        if (stepper == 1) {
            xpath = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + xpathValue + "')]//label[1]";
        } else if (stepper == 2) {
            xpath = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-infinite-" + xpathValue + "')]//label[1]";
        } else if (stepper == 3) {
            xpath = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + xpathValue + "')]//label[1]";
        } else {
            xpath = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + xpathValue + "')]//label[1]";
        }
        return xpath;
    }

    /**
     * This method sets the value for talkOptionIndex
     *
     * @param talkOptionIndex String value of talkOptionIndex
     * @return String value of index
     * @author Veranika.Siadach
     */
    public String getUpdatedTalkOptionIndex(String talkOptionIndex) {
        if ((talkOptionIndex == null) || (talkOptionIndex.isEmpty()) || (Integer.parseInt(talkOptionIndex) > talkOptions.size() - 1)) {
            talkOptionIndex = "0";
            return talkOptionIndex;
        }
        return talkOptionIndex;
    }

    /**
     * Click continue on Addons Section
     *
     * @author Veranika.Siadach
     */
    public void clickPreCartAddonsContinueButton() {
        reusableActions.clickWhenVisible(preCartAddonsContinueButton);
    }

    /**
     * Fill caller id form and click on the 'Continue' button after giving first name and last name details
     *
     * @author Veranika.Siadach
     */
    public void populateCallerAndClkContinueCallerId() {
        enterFirstName();
        enterLastName();
        clkContinueCallerId();
    }

    /**
     * Click on the 'Continue' button after giving first name and last name details
     *
     * @author Veranika.Siadach
     */
    public void clkContinueCallerId() {
        reusableActions.waitForElementVisibility(callerIdContinueButton, 20);
        reusableActions.getWhenReady(callerIdContinueButton).click();
    }

    /**
     * Enter First name on the phone plans page
     *
     * @author Veranika.Siadach
     */
    public void enterFirstName() {
        String strFirstName = FormFiller.generateRandomName();
        reusableActions.getWhenReady(callerFirstNameField, 30).click();
        callerFirstNameInput.sendKeys(strFirstName);
    }

    /**
     * Enter Last name on the phone plans page
     *
     * @author Veranika.Siadach
     */
    public void enterLastName() {
        String strLastName = FormFiller.generateRandomName();
        reusableActions.getWhenReady(callerLastNameField, 30).click();
        callerLastNameInput.sendKeys(strLastName);
    }

    /**
     * Click continue on cart summary in Plan config page
     *
     * @author Veranika.Siadach
     */
    public void clickCartSummaryContinueButton() {
        reusableActions.waitForElementVisibility(preCartAddonsCheckedIcon);
        reusableActions.javascriptScrollByVisibleElement(continueButtonOnCartSummary);
        reusableActions.executeJavaScriptClick(continueButtonOnCartSummary);
    }

    /**
     * This method will verify BreadCrumb on Plan config Page
     *
     * @param deviceName String of device name
     * @return true if breadcrumb is displayed fine else false
     * @author Veranika.Siadach
     */
    public boolean verifyBreadCrumb(String deviceName) {
        return reusableActions.isElementVisible(buildPlanInBreadCrumb) && breadCrumb.getText().toUpperCase().contains((deviceName).toUpperCase());
    }
}
