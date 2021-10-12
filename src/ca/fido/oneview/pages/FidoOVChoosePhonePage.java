package ca.fido.oneview.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoOVChoosePhonePage extends BasePageClass {

    @FindBy(xpath = "//ds-modal[contains(@class, 'ds-modal d-flex flex-column ds-bgcolor-white')]")
    WebElement creditEvaluationModal;

    @FindBy(xpath = "//button[@data-test='modal-credit-evaluation-accept']")
    WebElement btnDeviceAndPlanOnCreditEvalModal;

    @FindBy(xpath = "//button[@data-test='modal-credit-evaluation-decline']")
    WebElement btnPlanOnlyOnCreditEvalModal;

    @FindBy(xpath = "//th[contains(text(), 'Security deposit')]//following-sibling::td")
    WebElement securityDepositAmount;

    @FindBy(xpath = "//th[contains(text(), 'Credit limit')]//following-sibling::td")
    WebElement creditLimitAmount;

    @FindBy(xpath = "//th[contains(text(), 'Risk Level')]//following-sibling::td")
    WebElement riskLevel;

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
        return reusableActions.isElementVisible(creditEvaluationModal);
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
        String[] security = securityDepositAmount.getText().split("\\$");
        String[] clmValue = creditLimitAmount.getText().split("\\$");
        double securityDeposit = Double.parseDouble(security[1]);
        double clm = Double.parseDouble(clmValue[1]);
        String risk = riskLevel.getText();

        if (securityDeposit <= 0 && clm <= 0 && risk.equalsIgnoreCase("Low")) {
            customerType = "Low Risk";
        } else if (securityDeposit == 300 && (clm > 0 && clm < 450) && risk.equalsIgnoreCase("Medium")) {
            customerType = "Medium Risk";
        } else if (securityDeposit == 500 && clm >= 450 && risk.equalsIgnoreCase("High")) {
            customerType = "High Risk";
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
}
