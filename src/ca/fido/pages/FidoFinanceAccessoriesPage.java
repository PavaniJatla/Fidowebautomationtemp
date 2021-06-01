package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import ca.fido.test.helpers.CurrencyHelpers;
import ca.fido.test.helpers.DateHelpersFunctions;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Mirza.Kamran
 *
 */
public class FidoFinanceAccessoriesPage extends BasePageClass {

	public FidoFinanceAccessoriesPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//h1[text()='Fido Payment Program For Accessories' or text()='Programme De Paiement Fido Pour Les Accessoires']")
	WebElement headerFinancedAccessories;

	@FindBy(xpath = "//span[text()='Total monthly payment: ' or text()='Paiement mensuel total : ']/parent::div//ds-price")
	WebElement lblTotalMonthlyFinPayment;

	@FindBy(xpath = "//ss-accessories-balance//span[contains(text(),'Monthly financing payment:') or contains(text(),' Paiement mensuel pour le financement:')]/parent::div//ds-price")
	WebElement lblMonthlyFinPayment;

	@FindBy(xpath = "//ss-accessories-balance//span[contains(text(),'Monthly financed taxes:') or contains(text(),'Taxes mensuelles sur le financement')]/parent::div//ds-price")
	WebElement lblMonthlyFinTaxes;

	@FindBy(xpath = "//ss-accessories-balance//span[contains(text(),'Total remaining balance: ') or contains(text(),'Solde restant total : ')]/parent::div//ds-price")
	WebElement lblTotalRemainingFinBalance;

	@FindBy(xpath = "//ss-accessories-balance//span[contains(text(),' Remaining balance: ') or contains(text(),'Solde restant :')]/parent::div//ds-price")
	WebElement lblRemainingFinBalance;

	@FindBy(xpath = "//ss-accessories-balance//span[contains(text(),'Remaining financed taxes:') or contains(text(),'Taxes restantes du financement :')]/parent::div//ds-price")
	WebElement lblRemainingFinTaxes;

	@FindBy(xpath = "//ss-accessories-details//span[contains(text(),' Your balance will be $0') or contains(text(),' Votre solde sera de 0 $ le : ')]")
	WebElement lblFinEnding;

	@FindBy(xpath = "//span[contains(text(),'Accessory purchase date:') or contains(text(),'Date d’achat de l’accessoire :')]")
	WebElement lblStarted;

	@FindBy(xpath = "//span[contains(text(),'Financing term:') or contains(text(),' Identifiant de l’entente : ')]")
	WebElement lblAgreementID;

	@FindBy(xpath = "//span[contains(text(),'Financing term:') or contains(text(),'Durée du financement :')]")
	WebElement lblFinTerm;

	@FindBy(xpath = "//ss-accessories-details//span[contains(text(),' Monthly financing payment: ') or contains(text(),'Paiement mensuel pour le financement:')]/following-sibling::ds-price")
	WebElement lblMnthlyFinPayments;

	@FindBy(xpath = "//span[contains(text(),'Balance remaining:') or contains(text(),'Solde restant :')]/following-sibling::span")
	WebElement lblBalanceRemaining;

	@FindBy(xpath = "//button[@title='See more details about your accessory agreement' or @title='Voir plus de détails sur votre entente pour accessoires']")
	WebElement btnSeeMoreDetails;


	@FindBy(xpath = "//div[contains(@class,'accessory-item')]")
	List<WebElement> paneAccecoryItem;

	@FindBy(xpath = "//div[contains(@class,'accessory-item')]/img")
	List<WebElement> paneAccessoryImage;

	@FindBy(xpath = "//div[contains(@class,'accessory-item')]/div")
	List<WebElement> paneAccecoryDetails;


	@FindBy(xpath = "//h2[contains(text(),'Your balance will be $0 on:') or contains(text(),'Votre solde sera de 0 $ le : ')]")
	WebElement modalHeaderYourFinBalanceWillBeZeroOn;

	@FindBy(xpath = "//ss-accessories-details-modal//span[contains(text(),'Accessory purchase date:') or contains(text(),'Date d’achat de l’accessoire :')]/following-sibling::span")
	WebElement modalAccessoryPurchaseDate;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Agreement ID:' or text()='Identifiant de l’entente :']/following-sibling::span")
	WebElement modalAgreementID;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Financing term:' or text()='Durée du financement :']/following-sibling::span")
	WebElement modalFinTerm;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Total monthly payment: ' or text()='Paiement mensuel total : ']/following-sibling::ds-price")
	WebElement modalTotalMonthlyFin;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Monthly financing payment: ' or text()='Paiement mensuel pour le financement: ']/following-sibling::ds-price")
	WebElement modalMonthlyFinPayment;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Monthly financed taxes: ' or text()='Taxes mensuelles sur le financement : ']/following-sibling::ds-price")
	WebElement modalFinTaxes;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Total remaining balance: ' or text()='Solde restant total : ']/following-sibling::ds-price")
	WebElement modalTotalRemFinBal;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Remaining balance: ' or text()='Solde restant : ']/following-sibling::ds-price")
	WebElement modalRemFinBal;

	@FindBy(xpath = "//ss-accessories-details-modal//span[text()='Remaining financed taxes: ' or text()='Taxes restantes du financement : ']/following-sibling::ds-price")
	WebElement modalRemFinTax;

	@FindBy(xpath = "//ss-accessories-details-modal//button[@title='Close' or @title='Fermer']")
	WebElement btnCloseModal;


	public boolean isAccessoryPageOpen(){
		return reusableActions.isElementVisible(headerFinancedAccessories);

	}

	public boolean validateTotalMonthlyFinancingPayment(){
		String strValue =reusableActions.getWhenReady(lblTotalMonthlyFinPayment).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateMonthlyFinancingPayment(){
		String strValue =reusableActions.getWhenReady(lblMonthlyFinPayment).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateMonthlyFinancedTaxes(){
		String strValue =reusableActions.getWhenReady(lblMonthlyFinTaxes).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateTotalRemainingFinancingBalance(){
		String strValue =reusableActions.getWhenReady(lblTotalRemainingFinBalance).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateRemainingFinancingBalance(){
		String strValue =reusableActions.getWhenReady(lblRemainingFinBalance).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateRemainingFinancedTaxes(){
		String strValue =reusableActions.getWhenReady(lblRemainingFinTaxes).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}


	public boolean validateFinancingEnding(){
		String strValue =reusableActions.getWhenReady(lblFinEnding).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).trim().split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
	}
	public boolean validateStarted(){
		String strValue =reusableActions.getWhenReady(lblStarted).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
	}
	public boolean validateAgreementID(){
		String strValue =reusableActions.getWhenReady(lblAgreementID).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).trim().split(":")[1].trim().split(" ")[0].trim();
		return NumberUtils.isDigits(strValue);
	}
	public boolean validateFinancingTerm(){
		return reusableActions.isElementVisible(lblFinTerm);
	}


	public boolean validateMonthlyFinancingPaymentOfAnAgreement(){
		String strValue =reusableActions.getWhenReady(lblMnthlyFinPayments).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateBalanceRemaining(){
		String strValue =reusableActions.getWhenReady(lblBalanceRemaining).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public void clkBtnSeeMoreDetails(){

		reusableActions.getWhenReady(btnSeeMoreDetails).click();
	}

	public boolean validateYourFinancingBalanceWillBeZeroOn(){
		String strValue =reusableActions.getWhenReady(modalHeaderYourFinBalanceWillBeZeroOn).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
	}

	public boolean validateAccessoryPurchaseDate(){
		String strValue =reusableActions.getWhenReady(modalAccessoryPurchaseDate).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return DateHelpersFunctions.isValidDAte(strValue);
	}
	public boolean validateAgreementIDOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalAgreementID).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return NumberUtils.isDigits(strValue);
	}
	public boolean validateFinancingTermOndetailsModal(){
		return reusableActions.isElementVisible(modalFinTerm);
	}
	public boolean validateTotalMonthlyFinancingPaymentOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalTotalMonthlyFin).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateMonthlyFinancingPaymentOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalMonthlyFinPayment).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateMonthlyFinancedTaxesOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalFinTaxes).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateTotalRemainingFinancingBalanceOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalTotalRemFinBal).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateRemainingFinancingBalanceOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalRemFinBal).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateRemainingFinancedTaxesOndetailsModal(){
		String strValue =reusableActions.getWhenReady(modalRemFinTax).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public void clickCLoseModal(){
		reusableActions.getWhenReady(btnCloseModal).click();
	}

	public boolean validateAccessoryContentAndImageDisplayedCorrectly(){
		int countOfAccessories = paneAccecoryItem.size();
		if(countOfAccessories== paneAccessoryImage.size()
				&& countOfAccessories== paneAccecoryDetails.size()){ return true; }
		else {return false;}

	}

}