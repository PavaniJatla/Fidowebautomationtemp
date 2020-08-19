package ca.fido.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;
import utils.FormFiller;

public class FidoPaymentOptionsPage extends BasePageClass {

	public FidoPaymentOptionsPage(WebDriver driver) {
		super(driver);
	}

	public enum PayOptions {
	    Bank,
	    Creditcard,
	    Interac
	  }
	//--------- New elements after change in Method of payment
	
	@FindBy(xpath = "//p[text()='Credit Card' or text()='Carte de Crédit']")
	WebElement btnCreditCard;
	
	@FindBy(xpath = "//fds-chip/a//p[text()='Credit Card' or text()='Carte de Crédit' or text()='Switch to credit card']")
	WebElement btnSwitchToCreditCard;
		
	@FindBy(xpath = "//fds-chip/a//p[text()='Bank Account' or text()='Compte bancaire' or text()='Switch to bank account' or text()='Passer à un compte bancaire']")
	WebElement btnSwitchToBank;
	
	@FindBy(xpath = "//p[text()='Bank Account' or text()='Compte bancaire' or text()='Switch to bank account' or text()='Passer à un compte bancaire']")
	WebElement btnBankAccount;
	
	@FindBy(id = "expiryDate")
	WebElement txtExpiryDate;
	
	@FindBy(xpath = "//button[@title='Continue' or @title='Continuer']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//ins[@translate='payment-method.review-payment-method.confirmAccountDetails']")
	WebElement lblConfirmAccountDetails;
	
	@FindBy(xpath = "//div[contains(@class,'payment-info-container')]")
	WebElement divCardDetailsOnReviewCreditCardPag;

	@FindBy(xpath = "//button[@title='Confirm' or @title='Confirmer']")
	WebElement btnConfirm;
	
	@FindBy(className ="tnc-container")
	WebElement lblTnCContainer;
	
	@FindBy(xpath = "//ins[@translate='payment-method.terms-conditions.tnc']")
	WebElement lbltnCHeader;
	
	@FindBy(xpath = "//label[@class='a-checkbox']")
	WebElement chkAcceptTnC;
	
	@FindBy(id="transitNumber")
	WebElement txtTransitNumber;
	
	@FindBy(id="institutionNumber")
	WebElement txtInstitutionNumber;
	
	@FindBy(id="accountNumber")
	WebElement txtAcountNumber;
	
	@FindBy(xpath = "//div[@class='a-input semafone-cc-parent']//descendant::iframe")
	WebElement frameCreditCardNumberText;
	
	@FindBy(xpath = "//ins[@translate='payment-method.payment-method-success.successAutomaticPayments']")
	WebElement lblSuccessYouAreSignedUpForAutomaticPayments;
	
	@FindBy(xpath = "//ins[@translate='payment-method.endingIn']")
	WebElement lblPaymentMethodEndingInText;
	
	@FindBy(xpath = "//ins[@translate='payment-method.payment-method-success.futureBillsPaid']")
	WebElement lblYourFutureBillText;
	
	@FindBy(xpath = "//ins[@translate='payment-method.automaticPaymentTakeEffect']")
	WebElement lblAutomaticPayementEffect;
	
	@FindBy(xpath = "//div/fds-button/button[contains(@title,'Balance') or contains(@title,'Payer Le solde de')]")
	WebElement btnPaybalance;

	@FindBy(xpath = "//div/fds-button/button[@title='Close' or @title='Fermer']")
	WebElement btnClose;
	
	@FindBy(xpath = "//ins[@translate='payment-method.change-payment-method.autoPay']")
	WebElement lblAutomaticPayments;
	
	@FindBy(xpath = "//a[@title='Cancel automatic payments' or @title='Annuler les paiements automatiques']")
	WebElement btnRemoveAutomaticPayment;
	
	@FindBy(xpath = "//ins[@translate='payment-method.change-payment-method.on']")
	WebElement lblAutomaticPaymentOn;
	
	@FindBy(xpath = "//button[@title='Yes, Cancel' or @title='Oui, Annuler']")
	WebElement btnYesCancelAutomaticPayments;
	
	@FindBy(xpath = "//ins[@translate='payment-method.cancel-payment-method.cancelAutomaticPayments']")
	WebElement lblAreYourSure;
	
	@FindBy(xpath = "//button[@title='Yes, Cancel' or @title='Oui, Annuler']")
	WebElement btnYesCancel;
	
	@FindBy(xpath = "//ins[@translate='payment-method.payment-method-success.successMannualPayments']")
	WebElement lblSwitchToManualSuccess;
	
	@FindBy(xpath = "//button[@title='Close' or @title='Fermer']")
	WebElement btnCloseAfterSwitchToManual;
	//----------------- old page object webelements -------------------------
	@FindBy(xpath = "//select[@ng-model='props.selectedPaymentOption']")
	WebElement ddlPaymentMode;	
	//select[@class='ute-input-select ng-pristine ng-untouched ng-valid']
	@FindBy(xpath = "//label[@for='paper_method']")
	WebElement rdoPaperbill;

	@FindBy(xpath = "//button[@translate='global.cta.confirm']")
	WebElement btnPaymentConfirm;
	
	@FindAll({
		@FindBy(xpath = "//div[@class='semafone-container']//descendant::iframe"),
		@FindBy(xpath = "//div[@class='ute-input-text']//descendant::iframe")
	})
	WebElement fraSemaphone;  
	
	@FindBy(xpath="//div[@class='cc-payment-section']//descendant::iframe")
	WebElement fraCC;

	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;

	@FindAll({
		@FindBy(xpath = "//select[@name='ccExpiryMonth']"),
		@FindBy(xpath = "//select[@name='month']")
	})
	WebElement ddlExpiryMonth;

	@FindAll({
		@FindBy(xpath = "//select[@name='ccExpiryYear']"),
		@FindBy(xpath = "//select[@name='year']")
	})
	WebElement ddlExpiryYear;

	@FindAll({
		@FindBy(name = "cvv"),
		@FindBy(name = "securityCode")
	})
	WebElement txtCVV;
	
	@FindBy(id = "cvc")
	WebElement txtCVC;
	
	@FindBy(xpath="//*[@id='amount']")
	WebElement txtAmount;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//ins[@translate='global.cta.updatePaymentMethod']")
	WebElement btnUpdatePaymentMethod;
	
	@FindBy(name="transitCode")
	WebElement txtTransitCode;
	
	@FindBy(id="bank-code")
	WebElement txtBankCode;
	
	@FindBy(id="account-number")
	WebElement txtbankAccountNumber;
	
	@FindBy(xpath="//label[@for='agree-to-terms-and-conditions']")
	WebElement chkAgreeTermsAndCond;
	
	@FindBy(xpath = "//*[@id='terms-conditions-scroll']/ins/div/ins/p[7]")
	WebElement lbltermsAndConditionBottom;
	
	@FindBy(xpath="//input[@value='Review & continue']")
	WebElement btnReviewAndContinue;

	@FindBy(xpath="//ins[@translate='global.cta.payNow']")
	WebElement btnPayNow;
	
	@FindBy(xpath="//ins[@translate='global.label.paymentConfirmationHeading']")
	WebElement lblPaymentReceived;
	
	@FindBy(xpath="//ins[@translate='global.cta.done']")
	private WebElement btnDone;
	
	@FindBy(xpath="//select[@id='nacPaymentMethod']")
	WebElement ddlPaymentMethod;
	
	@FindBy(xpath="//span[@checkout-res='checkout_pay_submit']/parent::button")
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@id='agree-to-terms-and-conditions']")
	WebElement chkIAgreeTnCBuyFlowChequing;

	@FindBy(xpath = "//ins/p[contains(text(),'I/We acknowledge that I/we have read, understood and accepted')]")
	WebElement divTnCBottom;
	

	//--------------------------------------------------------------------------------
	
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param strPaymentMode  payment mode of the pay to buy the offer
	 * @author chinnarao.vattam 
	 */
	public void selectPaymentMode(String strPaymentMode) {
		reusableActions.waitForElementVisibility(ddlPaymentMode, 90);
		reusableActions.selectWhenReadyByVisibleText(ddlPaymentMode, strPaymentMode);
	}
	

	/**
	 * This will select the payment type
	 * @param strPaymentMode String containing the payment type name
	 * @author Mirza.Kamran
	 */
	public void clkPaymentOption(String strPaymentMode) {
		switch (strPaymentMode) {
		case "Credit Card":
			clkButtonCreditCard();
			break;

		case "Bank Account":
			clkButtonBankAccount();
			break;
		default:
			break;
		}
	}
	
	
	
	/**
	 * perform click on the Credit card payment type button
	 * @author Mirza.Kamran
	 */
	public void clkButtonCreditCard() {
		reusableActions.clickWhenReady(btnCreditCard);
	}
	
	/**
	 * Perform click on the bank Account Button
	 */
	public void clkButtonBankAccount() {
		reusableActions.clickWhenReady(btnBankAccount);
	}
	
	
	/**
	 * Click on the Paper bill radio button on the make payment page
	 * @author Chinnarao.vattam
	 */
	public void clkPaperbill() {		
		reusableActions.getWhenReady(rdoPaperbill, 30).click();
	}

	/**
	 * Click on the  Confirm button on the make payment page
	 * @author Chinnarao.vattam
	 */
	public void clkPaymentConfirm() {
		reusableActions.getWhenReady(btnPaymentConfirm, 60).click();
	}

	/**
	 * Set the transit code for  Pre-Auth Debit card
	 * @param strTransitCode  bank transit code of the account
	 * @author chinnarao.vattam
	 */
	public void setBankTransitCode(String strTransitCode) {
		reusableActions.clickWhenVisible(txtTransitCode);
		reusableActions.getWhenReady(txtTransitCode).sendKeys(strTransitCode);
	}
	
	
	/**
	 *  Set the transit number for  bank
	 * @param strTransitNumber  bank transit code of the account
	 * @author Mirza.Kamran
	 */
	public void setBankTransitNumber(String strTransitNumber) {
		reusableActions.clickWhenVisible(txtTransitNumber);
		reusableActions.getWhenReady(txtTransitNumber).sendKeys(strTransitNumber);
	}
	/**
	 * Set the bank code for  Pre-Auth Debit card
	 * @param strBankCode bank code of the account
	 * @author chinnarao.vattam
	 */
	public void setBankCode(String strBankCode) {
		reusableActions.clickWhenVisible(txtBankCode);
		reusableActions.getWhenReady(txtBankCode).sendKeys(strBankCode);
	}
	
	/**
	 * Set the institution number
	 * @param strInstitutionNumber bank code of the account
	 * @author Mirza.Kamran
	 */
	public void setInstitutionNumber(String strInstitutionNumber) {
		reusableActions.clickWhenVisible(txtInstitutionNumber);
		reusableActions.getWhenReady(txtInstitutionNumber).sendKeys(strInstitutionNumber);
	}
	
	/**
	 * Set the account number for Pre-Auth Debit card
	 * @param strBankAccountNumber account number of the debit card
	 * @author chinnarao.vattam
	 */
	public void setBankAccountNumer(String strBankAccountNumber) {
		reusableActions.clickWhenVisible(txtbankAccountNumber);
		reusableActions.getWhenReady(txtbankAccountNumber).sendKeys(strBankAccountNumber);
	}

	/**
	 * Set the account number for Bank payment option 
	 * @param strBankAccountNumber account number of the debit card
	 * @author Mirza.Kamran
	 */
	public void setAccountNumber(String strBankAccountNumber) {
		reusableActions.clickWhenVisible(txtAcountNumber);
		reusableActions.getWhenReady(txtAcountNumber).sendKeys(strBankAccountNumber);
	}
	
	/**
	 * Set the account number for Bank payment option 
	 * @param strBankAccountNumber account number of the debit card
	 * @author Mirza.Kamran
	 */
	public void setAccountNumberOnBuyFlow(String strBankAccountNumber) {
		reusableActions.clickWhenVisible(By.id("account-number"));
		reusableActions.getWhenReady(By.id("account-number")).sendKeys(strBankAccountNumber);
	}
	
	/**
	 * click on  the Terms and Conditions check box on make payment page
	 * @author chinnarao.vattam
	 */
	public void clkAgreeTermsAndCondition() {		
		reusableActions.scrollToElementAndClick(lbltermsAndConditionBottom);
		reusableActions.getWhenReady(chkAgreeTermsAndCond,120);
	}
	
	/**
	 * Checks if the T and C page is open
	 * @return true if the T and C page is available, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTnCPageIsOpen() {
		return (lblTnCContainer.isDisplayed() && (lbltnCHeader.isDisplayed()));
	}
	
	/**
	 * click on  the Terms and Conditions check box on change payment option page
	 * @author Mirza.Kamran
	 */
	public void clkIAcceptTermsAndCondition() {				
		reusableActions.staticWait(1000);
		reusableActions.clickIfAvailable(chkAcceptTnC);
	}
	
	/**
	 * Verify the "Payment"  page
	 * @return true, if the payment page has launched, else false
	 */
	public boolean verifyPaymentPage() {
		reusableActions.waitForElementVisibility(fraSemaphone, 90);
		return reusableActions.isElementVisible(fraSemaphone);
	}
	
	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of the Pre-Auth credit card 
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumber(String strAccountNumber) {	
		driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone,100));	
		reusableActions.waitForElementVisibility(txtCardNumber,120);
		reusableActions.executeJavaScriptClick(txtCardNumber);
		reusableActions.getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
		driver.switchTo().defaultContent();
	}

	/**'
	 * set the credit card number details 
	 * @param strAccountNumber String containing credit card number
	 * @author Mirza.Kamran
	 */
	public void setCreditCardNumberOnChangeMOP(String strAccountNumber) {	
		driver.switchTo().frame(reusableActions.getWhenVisible(frameCreditCardNumberText));		
		reusableActions.clickWhenVisible(txtCardNumber);
		reusableActions.getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYY);
	}

	/**
	 * Selects the expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {		
		String strMM = FormFiller.generateMonth();		
		reusableActions.waitForElementVisibility(ddlExpiryMonth, 30);
		//reusableActions.javascriptScrollByVisibleElement(ddlExpiryMonth);
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}
	

	/**
	 * Sets the expiry date in DDMM format
	 * @param strExpiryYear Credit card expiry date 
	 * @author Mirza.Kamran
	 */
	public void setExpiryDate(String strExpiryYear)
	{
		String strDDMM=FormFiller.generateMonth()+ strExpiryYear;
		if(strDDMM.length()==5)
		{
			strDDMM="0"+strDDMM;
		}
		reusableActions.enterText(txtExpiryDate, strDDMM, 10);
	}
	
	/**
	 * Set the dynamic CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVV() {
		String strCVV = FormFiller.generateCVVNumber();
		reusableActions.getWhenReady(txtCVV,20).click();
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}
	
	/**
	 * Set the dynamic CVV for credit card
	 * @author Mirza.Kamran
	 */
	public void setCVC() {
		String strCVV = FormFiller.generateCVVNumber();
		reusableActions.clickWhenVisible(txtCVC);
		reusableActions.getWhenReady(txtCVC).sendKeys(strCVV);
	}
	

	
	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}

	/**
	 * Selects the expire month for Pre-Auth credit card
	 * @param strMM expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardxpiryMonth(String strMM) {
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditcardCVV(String strCVV) {
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}
	
	/**
	 * Set the CVV for  card
	 * @param strCVC CVC for credit card
	 * @author Mirza.Kamran
	 */
	public void setCreditcardCVC(String strCVC) {
		reusableActions.clickWhenVisible(txtCVC);
		reusableActions.getWhenReady(txtCVC).sendKeys(strCVC);
	}
	
	/**
	 * Set the payment amount on Fido payment page
	 * @param strAmount payment amount to buy the Fido Internet offer
	 * @author kamran.Mirza
	 */
	public void setPaymentAmount(String strAmount){
		reusableActions.enterText(txtAmount,strAmount, 30);		
	}
	
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment page
	 * @param payOption payment mode of the pay to buy the offer
	 * @author kamran.Mirza
	 */
	public void selectHowWouldYouLikeToPay(PayOptions payOption) {
		reusableActions.clickIfAvailable(By.xpath("//label[@for='"+payOption.toString()+"']/ins"));
	}
	
	/**
	 * Click on update on the payment page
	 * @author aditya.Dhingra
	 */	
	public void clkUpdate() {
		reusableActions.getWhenReady(btnUpdate).click();
	}
	
	/**
	 * Click om continue payment button
	 * @author Mirza.Kamran
	 */
	public void clkContinue() {
		reusableActions.getWhenReady(btnContinue).click();
	}
	
	/**
	 * checks if the review credit card details is displayed
	 * @return true if the label review credit card details is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheReviewCreditCardIsDisplayed() {
		return lblConfirmAccountDetails.isDisplayed();
	}
	
		
	/**
	 * clicks on the confirm button
	 * @author Mirza.Kamran
	 */
	public void clkConfirm() {
		reusableActions.getWhenReady(btnConfirm).click();
	}
	
	/**
	 * checks if the label success message is displayed
	 * @return true if the label success message is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelSuccessMessageIsDisplayed() {
		return lblSuccessYouAreSignedUpForAutomaticPayments.isDisplayed();
	}
	
	/**
	 * checks if the label your future bills message is displayed
	 * @return true if the label your future bills is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelYourFutureBillsIsDisplayed() {
		return lblYourFutureBillText.isDisplayed();
	}
	
	/**
	 * checks if the label your your paymentMethod ending  message is displayed
	 * @return true if the label your paymentMethod ending is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelPaymentMethodEndingInIsDisplayed() {
		return lblPaymentMethodEndingInText.isDisplayed();
	}
	
	/**
	 * checks if the label your Automatic payment effect message is displayed
	 * @return true if the label your Automatic payment effect is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelAutomaticPaymentEffectIsDisplayed() {
		return lblAutomaticPayementEffect.isDisplayed();
	}
		
	/**
	 * checks if the button Pay Balance is displayed
	 * @return true if the button pay balance is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheButtonPayBalanceIsDisplayed() {
		return btnPaybalance.isDisplayed();
	}
	
	/**
	 * Click on close button on Change MOP overlay success page
	 * @author Mirza.Kamran
	 */	
	public void clkCloseButton() {
		reusableActions.waitForElementTobeClickable(btnClose, 60);
		reusableActions.executeJavaScriptClick(btnClose);
	}
	
	
	/**
	 * Click on update payment method on the payment page
	 * @author aditya.Dhingra
	 */	
	public void clkUpdatePaymentMethod() {
		reusableActions.getWhenReady(btnUpdatePaymentMethod).click();
	}
	
	//TODO method not used
	public void clkReviewAndContinueButton()
	{
		reusableActions.clickWhenReady(btnReviewAndContinue);
	}
	
	//TODO method not used
	public void clkPayNow()
	{
		reusableActions.clickWhenReady(btnPayNow);
	}
	
	//TODO method not used
	public boolean verifyPaymentSuccessful() {		
		String strText=reusableActions.getWhenVisible(lblPaymentReceived).getText();
		if(strText.contains("We received your payment. Thanks!"))
		{
			
			reusableActions.clickIfAvailable(btnDone);
			return true;
		}else
		{
			return false;
		}
	}


	/**
	 * Checks if the automatic payment option is already set ON
	 * @return true of the automatic payment is already on else false
	 * @author Mirza.Kamran
	 */
	public boolean isAutopaymentAlreadySet() {		
		return (reusableActions.isElementVisible(lblAutomaticPaymentOn)
				&& reusableActions.isElementVisible(lblAutomaticPayments)) ;
	}

	/**
	 * Clicks remove automatic payment button
	 * @author Mirza.Kamran
	 */
	public void clkRemoveAutomaticPayment() {
		reusableActions.waitForElementVisibility(btnRemoveAutomaticPayment);
		reusableActions.waitForElementTobeClickable(btnRemoveAutomaticPayment, 60);
		reusableActions.executeJavaScriptClick(btnRemoveAutomaticPayment);		
	}

	/**
	 * waits of the removal of Auto Payment is successful message to turn up
	 * @author Mirza.Kamran
	 */
	public void waitForRemovalOfAutoPaymentIsSuccessFulMessageToBeAvailable() {
		
		reusableActions.waitForElementVisibility(lblSwitchToManualSuccess, 60);
		
	}

	/**
	 * Click the close button
	 * @author Mirza.Kamran
	 */
	public void clkClose() {
		reusableActions.waitForElementTobeClickable(btnCloseAfterSwitchToManual, 30);
		reusableActions.executeJavaScriptClick(btnCloseAfterSwitchToManual);
		
	}

	/**
	 * clicks on yes cancel if the option are you sure is popped up
	 * @author Mirza.Kamran
	 */
	public void clkYesCancelButtonIfAskedForAreYouSureOption() {
		reusableActions.staticWait(3000);
		if(lblAreYourSure.isDisplayed())
		{
			reusableActions.getWhenReady(btnYesCancel).click();
		}
		
	}
	
	/**
	 * Selects the Payment Method as 'Invoive (manual payments)'
	 * @author rajesh.varalli1
	 */
	public void setManualPaymentMethod() {
		reusableActions.selectWhenReady(ddlPaymentMethod, "invoice");
	}
	
	/**
	 * Clicks on the 'Submit' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmit() {
		reusableActions.clickWhenReady(btnSubmit , 60);
		//reusableActions.waitForElementVisibility(btnSubmit, 100);
	}

	/**
	 * Clicks on I agree T n C on Buy flow Chequing options
	 */
	public void clkIAgreePreAuthorizeTAndConditionsOnBuyFlowPaymentOptions() {	
		
		
		reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//label[@for='agree-to-terms-and-conditions']")), 30);
		reusableActions.clickWhenReady(By.xpath("//label[@for='agree-to-terms-and-conditions']"), 10);
	}


	public void scrollToBottomOfTnC() {
		reusableActions.scrollToElement(divTnCBottom);
	}


	public void clkSwitchCreditCard() {
		reusableActions.waitForElementTobeClickable(btnSwitchToCreditCard,30);
		reusableActions.clickWhenReady(btnSwitchToCreditCard);
		
	}


	public void clkSwitchToBank() {
		reusableActions.clickWhenReady(btnSwitchToBank);
		
	}

}