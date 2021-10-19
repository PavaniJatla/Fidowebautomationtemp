package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FidoOVChoosePhonePage extends BasePageClass {

    @FindBy(xpath = "//ds-modal[contains(@class, 'ds-modal d-flex flex-column ds-bgcolor-white')]")
    WebElement creditEvaluationModal;

    @FindBy(xpath = "//button[@data-test='modal-credit-evaluation-accept']")
    WebElement btnDeviceAndPlanOnCreditEvalModal;

    @FindBy(xpath = "//button[@data-test='modal-credit-evaluation-decline']")
    WebElement btnPlanOnlyOnCreditEvalModal;

    @FindBy(xpath = "//th[contains(text(), 'Downpayment') or contains(text(), 'Acompte')]//following-sibling::td")
    WebElement downpaymentPercent;

    @FindBy(xpath = "//th[contains(text(), 'Risk Level') or contains(text(), 'Niveau de risque')]//following-sibling::td")
    WebElement riskLevel;

    @FindBy(xpath = "//a[contains(@title,'View Details')]")
    List<WebElement> viewDetailsButtons;

    @FindBy(xpath = "//div[contains(@class, 'col-undefined col-xs-12')]/div[@class='row']")
    WebElement devicesCatalog;

    @FindBy(xpath = "//button[@title='Select' or @title='Continue' or @title='Continuer' or @title='Ship to home' or @title='Expédier à la maison']")
    WebElement continueButtonOnDashboardPhonePage;

    @FindBy(xpath = "//div[contains(@class, 'd-block mt-16')]//h1")
    WebElement titleOnDashboardPhonePage;

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public FidoOVChoosePhonePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check for the presence of Credit Evaluation Modal
     *
     * @return returns if the element is visible or not
     * @author Veranika.Siadach
     */
    public boolean isCreditEvaluationModalPresence() {
        return reusableActions.isElementVisible(creditEvaluationModal, 60);
    }

    /**
     * Validate whether the customer type of the provided data matches to the customer type deduced from the data provided on the Credit Evaluation Modal
     *
     * @param customerRiskLevel risk level
     * @return true if customer types match, false if they don't match
     * @author Veranika.Siadach
     */
    public boolean validateCustomerType(String customerRiskLevel) {
        String customerType = checkCustomerType();
        return customerRiskLevel != null && !customerRiskLevel.isEmpty() && customerType.matches(customerRiskLevel);
    }

    /**
     * Check the customer type based on the attribute values present on the Credit Evaluation Modal
     *
     * @return returns the customerType value
     * @author Veranika.Siadach
     */
    public String checkCustomerType() {
        String customerType = null;
        String risk = riskLevel.getText();
        double downpayment = Double.parseDouble(downpaymentPercent.getText().replace("%", ""));

        if (downpayment <= 19 && downpayment >= 0 && (risk.equalsIgnoreCase("Low") || risk.equalsIgnoreCase("Meugler"))) {
            customerType = "Low Risk";
        } else if (downpayment >= 20 && (risk.equalsIgnoreCase("Medium") || risk.equalsIgnoreCase("Moyen"))) {
            customerType = "Medium Risk";
        }

        return customerType;
    }

    /**
     * Click on the 'Device and Plan' Button from the Credit Evaluation Modal
     *
     * @author Veranika.Siadach
     */
    public void clickDeviceAndPlanButtonOnCreditEvalModal() {
        reusableActions.waitForElementVisibility(btnDeviceAndPlanOnCreditEvalModal);
        reusableActions.executeJavaScriptClick(btnDeviceAndPlanOnCreditEvalModal);
    }

    /**
     * Click on the 'Plan only' Button from the Credit Evaluation Modal
     *
     * @author Veranika.Siadach
     */
    public void clickPlanOnlyButtonOnCreditEvalModal() {
        reusableActions.waitForElementVisibility(btnPlanOnlyOnCreditEvalModal);
        reusableActions.executeJavaScriptClick(btnPlanOnlyOnCreditEvalModal);
    }

    /**
     * This method will verify that the device title CTA button is present or not
     *
     * @param deviceName name of the Device for which we want to verify device tile CTA button
     * @return boolean true if the CTA button is present else false
     * @author Veranika.Siadach
     */
    public boolean verifyDeviceTitleButton(String deviceName) {
        reusableActions.waitForElementVisibility(devicesCatalog, 80);
        reusableActions.waitForElementVisibility(viewDetailsButtons.get(0), 60);

        return reusableActions.isElementVisible(By.xpath(createXpathForViewDetailsButton(deviceName)), 60);
    }

    /**
     * This method creates Xpath of a particular CTA button
     *
     * @param deviceName name of the device used to create the xpath
     * @return a String value which is an xpath for a CTA button
     * @author Veranika.Siadach
     */
    public String createXpathForViewDetailsButton(String deviceName) {
        String xpathDeviceName = "//p[contains(@class,'text-title-5 ')][contains(text(),'" + deviceName + "')]";
        return xpathDeviceName + "/ancestor::div[@class='dsa-nacTile__top']//following-sibling::div//span[contains(@class,'ds-button__copy')]";
    }

    /**
     * This method Clicks on a device Title CTA button for a particular phone
     *
     * @param deviceName name of the Device to be used to generate Xpath
     * @author Veranika.Siadach
     */
    public void clickDeviceTitleButton(String deviceName) {
        reusableActions.scrollToElement(reusableActions.getWhenReady(By.xpath(createXpathForViewDetailsButton(deviceName))));
        reusableActions.clickWhenVisible(By.xpath(createXpathForViewDetailsButton(deviceName)), 30);
    }

    /**
     * Click on the continue button on Dashboard phone page
     *
     * @param deviceName name of the device
     * @author Veranika.Siadach
     */
    public void clickContinueButtonOnDashboardPhonePage(String deviceName) {
        reusableActions.waitForTextToBePresentInElement(titleOnDashboardPhonePage, deviceName.toUpperCase(), 30);
        reusableActions.clickWhenReady(continueButtonOnDashboardPhonePage);
    }
}
