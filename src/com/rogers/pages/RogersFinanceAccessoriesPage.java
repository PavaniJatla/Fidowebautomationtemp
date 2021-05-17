package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.test.helpers.CurrencyHelpers;
import com.rogers.test.helpers.DateHelpersFunctions;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Mirza.Kamran
 *
 */
public class RogersFinanceAccessoriesPage extends BasePageClass {

	public RogersFinanceAccessoriesPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//h1[text()='Financed accessories' or text()='Accessoires financés']")
	WebElement headerFinancedAccessories;
	
	@FindBy(xpath = "//span[text()='Total monthly financing payment: ' or text()='Total mensuel du paiement pour le financement : ']/parent::div//ds-price")
	WebElement lblTotalMonthlyFinPayment;

	@FindBy(xpath = "//rss-accessories-balance//span[contains(text(),'Monthly financing payment:') or contains(text(),'Paiement mensuel pour le financement :')]/parent::div//ds-price")
	WebElement lblMonthlyFinPayment;

	@FindBy(xpath = "//rss-accessories-balance//span[contains(text(),'Monthly financed taxes:') or contains(text(),'Taxes mensuelles sur le financement')]/parent::div//ds-price")
	WebElement lblMonthlyFinTaxes;

	@FindBy(xpath = "//rss-accessories-balance//span[contains(text(),'Total remaining financing balance:') or contains(text(),'Solde total du financement :')]/parent::div//ds-price")
	WebElement lblTotalRemainingFinBalance;

	@FindBy(xpath = "//rss-accessories-balance//span[contains(text(),'Remaining financing balance:') or contains(text(),'Solde restant du financement :')]/parent::div//ds-price")
	WebElement lblRemainingFinBalance;

	@FindBy(xpath = "//rss-accessories-balance//span[contains(text(),'Remaining financed taxes:') or contains(text(),'Taxes restantes du financement :')]/parent::div//ds-price")
	WebElement lblRemainingFinTaxes;

	@FindBy(xpath = "//span[contains(text(),'Financing ending:') or contains(text(),'Fin du financement :')]")
	WebElement lblFinEnding;

			@FindBy(xpath = "//span[contains(text(),'Started:') or contains(text(),'Début :')]")
			WebElement lblStarted;

			@FindBy(xpath = "//span[contains(text(),'Agreement ID:') or contains(text(),'ID de l’entente :')]")
			WebElement lblAgreementID;

			@FindBy(xpath = "//span[contains(text(),'Financing term:') or contains(text(),'Durée du financement :')]")
			WebElement lblFinTerm;

			@FindBy(xpath = "//rss-accessories-details//span[contains(text(),' Monthly financing payment: ') or contains(text(),' Paiement mensuel pour le financement : ')]/following-sibling::ds-price")
			WebElement lblMnthlyFinPayments;

			@FindBy(xpath = "//span[contains(text(),'Balance remaining:') or contains(text(),'Solde restant :')]/following-sibling::span")
			WebElement lblBalanceRemaining;

			@FindBy(xpath = "//button[@title='See more details about your accessory financing agreement' or @title='Voir plus de détails sur votre entente de financement d’accessoires']")
			WebElement btnSeeMoreDetails;


			@FindBy(xpath = "//div[contains(@class,'accessory-item')]")
			List<WebElement> paneAccecoryItem;

			@FindBy(xpath = "//div[contains(@class,'accessory-item')]/img")
			List<WebElement> paneAccessoryImage;

			@FindBy(xpath = "//div[contains(@class,'accessory-item')]/div")
			List<WebElement> paneAccecoryDetails;


			@FindBy(xpath = "//h2[contains(text(),'Your financing balance will be $0 on:') or contains(text(),'Votre solde de financement sera de 0 $ le :')]")
			WebElement modalHeaderYourFinBalanceWillBeZeroOn;

			@FindBy(xpath = "//span[contains(text(),'Accessory purchase date:') or contains(text(),'Date d’achat de l’accessoire :')]/following-sibling::span")
			WebElement modalAccessoryPurchaseDate;

			@FindBy(xpath = "//span[text()='Agreement ID:' or text()='Identifiant de l’entente :']/following-sibling::span")
			WebElement modalAgreementID;

			@FindBy(xpath = "//span[text()='Financing term:' or text()='Durée du financement :']/following-sibling::span")
			WebElement modalFinTerm;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Total monthly financing payment: ' or text()='Total mensuel du paiement pour le financement : ']/following-sibling::ds-price")
			WebElement modalTotalMonthlyFin;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Monthly financing payment: ' or text()='Paiement mensuel pour le financement : ']/following-sibling::ds-price")
			WebElement modalMonthlyFinPayment;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Monthly financed taxes: ' or text()='Taxes mensuelles sur le financement : ']/following-sibling::ds-price")
			WebElement modalFinTaxes;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Total remaining financing balance: ' or text()='Solde total du financement : ']/following-sibling::ds-price")
			WebElement modalTotalRemFinBal;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Remaining financing balance: ' or text()='Solde restant du financement : ']/following-sibling::ds-price")
			WebElement modalRemFinBal;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Remaining financed taxes: ' or text()='Taxes restantes du financement : ']/following-sibling::ds-price")
			WebElement modalRemFinTax;

			@FindBy(xpath = "//button[@title='Close' or @title='Fermer']")
			WebElement btnCloseModal;


			public boolean isAccessoryPageOpen(){
				return getReusableActionsInstance().isElementVisible(headerFinancedAccessories);

			}



			public boolean validateTotalMonthlyFinancingPayment(){
				String strValue =getReusableActionsInstance().getWhenReady(lblTotalMonthlyFinPayment).getText().trim();
				strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
				strValue= CurrencyHelpers.removeMonth(strValue);
				return CurrencyHelpers.validateCurrency(strValue);
			}

	public boolean validateMonthlyFinancingPayment(){
		String strValue =getReusableActionsInstance().getWhenReady(lblMonthlyFinPayment).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateMonthlyFinancedTaxes(){
		String strValue =getReusableActionsInstance().getWhenReady(lblMonthlyFinTaxes).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateTotalRemainingFinancingBalance(){
		String strValue =getReusableActionsInstance().getWhenReady(lblTotalRemainingFinBalance).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateRemainingFinancingBalance(){
		String strValue =getReusableActionsInstance().getWhenReady(lblRemainingFinBalance).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateRemainingFinancedTaxes(){
		String strValue =getReusableActionsInstance().getWhenReady(lblRemainingFinTaxes).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}


	public boolean validateFinancingEnding(){
		String strValue =getReusableActionsInstance().getWhenReady(lblFinEnding).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
	}
	public boolean validateStarted(){
		String strValue =getReusableActionsInstance().getWhenReady(lblStarted).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
	}
	public boolean validateAgreementID(){
		String strValue =getReusableActionsInstance().getWhenReady(lblAgreementID).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return NumberUtils.isDigits(strValue);
	}
	public boolean validateFinancingTerm(){
		return getReusableActionsInstance().isElementVisible(lblFinTerm);
	}


	public boolean validateMonthlyFinancingPaymentOfAnAgreement(){
		String strValue =getReusableActionsInstance().getWhenReady(lblMnthlyFinPayments).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public boolean validateBalanceRemaining(){
		String strValue =getReusableActionsInstance().getWhenReady(lblBalanceRemaining).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public void clkBtnSeeMoreDetails(){

				getReusableActionsInstance().getWhenReady(btnSeeMoreDetails).click();
	}

	public boolean validateYourFinancingBalanceWillBeZeroOn(){
		String strValue =getReusableActionsInstance().getWhenReady(modalHeaderYourFinBalanceWillBeZeroOn).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
	}

	public boolean validateAccessoryPurchaseDate(){
		String strValue =getReusableActionsInstance().getWhenReady(modalAccessoryPurchaseDate).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return DateHelpersFunctions.isValidDAte(strValue);
	}
	public boolean validateAgreementIDOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalAgreementID).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return NumberUtils.isDigits(strValue);
	}
	public boolean validateFinancingTermOndetailsModal(){
		return getReusableActionsInstance().isElementVisible(lblFinTerm);
	}
	public boolean validateTotalMonthlyFinancingPaymentOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalTotalMonthlyFin).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateMonthlyFinancingPaymentOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalMonthlyFinPayment).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateMonthlyFinancedTaxesOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalFinTaxes).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		strValue= CurrencyHelpers.removeMonth(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateTotalRemainingFinancingBalanceOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalTotalRemFinBal).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateRemainingFinancingBalanceOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalRemFinBal).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}
	public boolean validateRemainingFinancedTaxesOndetailsModal(){
		String strValue =getReusableActionsInstance().getWhenReady(modalRemFinTax).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
		return CurrencyHelpers.validateCurrency(strValue);
	}

	public void clickCLoseModal(){
		getReusableActionsInstance().getWhenReady(btnCloseModal).click();
	}

	public boolean validateAccessoryContentAndImageDisplayedCorrectly(){
		int countOfAccessories = paneAccecoryItem.size();
		if(countOfAccessories== paneAccessoryImage.size()
		&& countOfAccessories== paneAccecoryDetails.size()){ return true; }
		else {return false;}

	}

}