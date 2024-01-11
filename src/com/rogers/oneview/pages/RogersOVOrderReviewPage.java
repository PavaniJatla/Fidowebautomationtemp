package com.rogers.oneview.pages;
import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersOVOrderReviewPage  extends BasePageClass {

	public RogersOVOrderReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//label[@for='shieldTermsCheckbox']")
	WebElement chbShieldTerms;
	
	@FindBy(xpath = "//*[text()='Monthly Bill' or text()='Facture mensuelle']/ancestor::button")
	WebElement monthlyBill;
	
	@FindBy(xpath = "//*[text()='One-Time Fees and Credits' or text()='Frais et crédits uniques']")
	WebElement oneTimeFees;
	
	@FindBy(xpath = "//span[@translate='global.cta.submit']/ancestor::button | //span[text()='Submit' or text()='Soumettre']/ancestor::button")
	WebElement submitButton;

	@FindBy(xpath="//h1[@translate='global.label.reviewYourOrder' or text()='Vérifier votre commande']")
	WebElement OrderReviewHeader;
	
	@FindBy(xpath = "//span[text()='Campaign Codes' or text()='Codes de campagne']/ancestor::button")
	WebElement campaignCodes;
	
	@FindBy(xpath = "//span[contains(text(),'Enter campaign code') or contains(text(),' Entrez le code de campagne')]/ancestor::div[1]")
	WebElement campaignCodesContainer;
	
	@FindBy(xpath = "//span[contains(text(),'Enter campaign code') or contains(text(),' Entrez le code de campagne')]/ancestor::div[1]//input")
	WebElement campaignCodesInput;
	
	@FindBy(xpath = "//span[text()='Apply' or text()='Appliquer']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement apply;
	
	@FindBy(xpath = "//*[@translate='global.selfServe.reviewConfirm.totalMonthlyFees']/parent::div")
//	@FindBy(xpath = "//p[text()='Total after taxes']/following::div[@class='ds-price']")
	WebElement totalMonthlyFees;
	
	@FindBy(xpath = "//label[@for='termsCheckbox']")
	WebElement chbTerms;
	
	@FindBy(xpath = "//label[@for='upfrontTermsCheckbox']")
	WebElement chbUpfrontTerms;
	
	@FindBy(xpath = "//input[@name='customerEmail']")
	WebElement txtCustomerEmail;
	
	@FindBy(xpath = "//label[@class='check-label']")
	List<WebElement> termsCheckBoxes;
	
	@FindAll({
		@FindBy(xpath = "//input[@id='ds-radio-input-id-32']/parent::label"),
		@FindBy(xpath = "//input[@id='digital-copy']/../label")})
	WebElement rdbtnEmail;

	@FindAll({
			@FindBy(xpath = "//h1[contains(text(),'One-time payment') or contains(.,'Paiement unique')]"),
			@FindBy(xpath = "//span[@checkout-res='checkout_step_pay']")
	})
	WebElement lblPaymentStep;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	////span[@checkout-res='checkout_submit_order']/parent::button
	//button[@data-dtname='reviewOrder-submit']
	@FindBy(xpath = "//span[@checkout-res='checkout_submit_order']/parent::button")
	WebElement btnSubmitOrder;

	@FindBy(xpath = "//span[@translate='global.cta.submit']/ancestor::button")
	WebElement submitOrder;

	@FindBy(xpath="//p[contains(text(),'Monthly charges')]")
	WebElement monthlyChargeDetails;

	@FindBy(xpath="//div[@translate='global.label.carriedOver']")
	WebElement internetAddonCarriedOver;

	@FindBy(xpath = "//span[text()='CUSTOMER WILL BE ACTIVATED ON FIBRE']")
	WebElement fibreActivationTag;

	@FindBy(xpath = "//h1[@translate='global.label.reviewYourOrder']")
	WebElement orderReviewHeader;

	/**
	 * Verify order review page is loaded properly
	 * @return true if page loaded else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyOrderReviewPage() {
		return getReusableActionsInstance().isElementVisible(rdbtnEmail, 120);
	}

	/**
	 * Expand Monthly Bill
	 * @author chinnarao.vattam
	 */	
	public void expandMonthlyBill() {
		getReusableActionsInstance().clickWhenReady(monthlyBill,120);
	}
	/**
	 * Expand Monthly Bill
	 * @author chinnarao.vattam
	 */	
	public void expandOneTimeFees() {
		if(getReusableActionsInstance().isElementVisible(oneTimeFees,120))
		getReusableActionsInstance().javascriptScrollByVisibleElement(oneTimeFees);
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickWhenReady(oneTimeFees,120);
	}
	/**
	 * Click Submit Button  
	 * @author chinnarao.vattam
	 */	
	public void clkSubmit() {	
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(submitButton, 100);
		getReusableActionsInstance().executeJavaScriptClick(submitButton);
		getReusableActionsInstance().staticWait(10000);
	}

	public void clkReview(){
		getReusableActionsInstance().waitForElementVisibility(OrderReviewHeader,120);
	}
	/**
	 * Verify Monthly Charges Appear
	 * @return true if Monthly Charges Appear, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyMonthlyCharges() {
	if(getReusableActionsInstance().isElementVisible(totalMonthlyFees,120)){
		WebElement btn=getReusableActionsInstance().getWhenReady(totalMonthlyFees);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		return true;
	}else
		return false;
	}
	
	/**
	 * Clicks on all 'Terms and Agreement' checkbox
	 * @author Saurav.Goyal
	 */
	public void clkAllTermsAgreementCheckboxs() {
		getReusableActionsInstance().waitForAllElementsVisible(termsCheckBoxes, 60);
		for(WebElement element:termsCheckBoxes) {
			getReusableActionsInstance().waitForElementVisibility(element, 60);
			getReusableActionsInstance().clickWhenReady(element,60);
		}
	}
	
	/**
	 * Clicks on the 'Terms and Agreement' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkTermsAgreementCheckbox() {
		getReusableActionsInstance().waitForElementVisibility(chbTerms, 100);
		getReusableActionsInstance().clickWhenReady(chbTerms,100);
	}
	
	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 * @param strEmail string email
	 */
	public void selectEmailDigitalCopy(String strEmail) {
		getReusableActionsInstance().clickWhenVisible(rdbtnEmail,30);
		if(getReusableActionsInstance().isElementVisible(txtCustomerEmail)) {
			txtCustomerEmail.sendKeys(strEmail);
		}
	}
	
	/**
	 * Determines if payment is required or not
	 * @return true if 'Payment' appears in the Steps above; else false
	 * @author rajesh.varalli1
	 */
	public boolean isPaymentRequired() {
		return getReusableActionsInstance().isElementVisible(lblPaymentStep, 30);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().clickWhenReady(btnContinue,60);
	}
	
	/**
	 * Clicks on the 'Submit Order' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmitOrder() {
		getReusableActionsInstance().clickWhenVisible(btnSubmitOrder,60);
	}

	/**
	 * Click Submit Button for Channel/ThemePack change
	 * @author Aditi.Jain
	 */
	public void clickSubmitOrder() {
		getReusableActionsInstance().waitForElementVisibility(submitOrder, 90);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(submitOrder);

	}

	/**
	 * To verify internet addons in the order review page
	 * @return true if carried over internet addon is available else return false
	 * @author Dani.Dominic
	 */
	public boolean verifyCarriedOverInternetAddon() {
		getReusableActionsInstance().waitForElementTobeClickable(monthlyChargeDetails,120);
		getReusableActionsInstance().executeJavaScriptClick(monthlyChargeDetails);
		getReusableActionsInstance().waitForElementVisibility(internetAddonCarriedOver, 60);
		return	getReusableActionsInstance().isElementVisible(internetAddonCarriedOver);
	}

	public boolean verifyFibreActivationTag() {
		getReusableActionsInstance().waitForElementVisibility(fibreActivationTag,30);
		return getReusableActionsInstance().isElementVisible(fibreActivationTag);
	}

	public boolean verifyOrderReviewHeader() {
		return getReusableActionsInstance().isElementVisible(orderReviewHeader, 100);
	}

}

