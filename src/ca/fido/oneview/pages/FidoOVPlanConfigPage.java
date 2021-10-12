package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FidoOVPlanConfigPage extends BasePageClass {

    @FindBy(xpath = "//span[contains(@class,'cartSummary')]")
    WebElement cartSummaryLabel;

    @FindBy(xpath = "//p[@data-test='stepper-0-completed-step-label']")
    WebElement deviceTileLabel;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-2-edit-step-selection-option-infinite-')]//label[1]")
    List<WebElement> dataOptions;

    @FindBy(xpath = "//button[@data-test='stepper-2-edit-step-continue-button']")
    WebElement preCartDataOptionContinueButton;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-3-edit-step-selection-option-')]//label[1]")
    List<WebElement> talkOptions;

    @FindBy(xpath = "//button[@data-test='stepper-3-edit-step-continue-button']")
    WebElement preCartTalkOptionContinueButton;

    @FindBy(xpath = "//button[@data-test='stepper-4-edit-step-continue-button']")
    WebElement preCartAddonsContinueButton;

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
     * @return True if plan config page is loaded, else false
     * @author Veranika.Siadach
     */
    public boolean ifPlanConfigPageLoaded() {
        return reusableActions.isElementVisible(cartSummaryLabel, 30);
    }

    /**
     * This method will verify BreadCrumb on Plan config Page
     *
     * @param deviceName: String of device name
     * @return true if breadcrumb is displayed fine else false
     * @author Veranika.Siadach
     */
    public boolean verifyDeviceTile(String deviceName) {
        return deviceTileLabel.getText().equalsIgnoreCase(deviceName);
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
     * @param talkOptionIndex String value of talk option to be selected
     *                        return boolean true if continue button is displayed in addons stepper else false
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
}
