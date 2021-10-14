package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
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
	
	@FindBy(xpath = "//p[text()='Credit Card' or contains(text(),'credit card') or contains(text(),'Carte de Cr')]/ancestor::a")
	WebElement btnCreditCard;
	
	@FindBy(xpath = "//fds-chip/a//p[text()='Credit Card' or contains(text(),'Carte de Cr') or text()='Switch to credit card']")
	WebElement btnSwitchToCreditCard;
		
	@FindBy(xpath = "//fds-chip/a//p[text()='Bank Account' or text()='Compte bancaire' or text()='Switch to bank account' or contains(text(),'un compte bancaire')]")
	WebElement btnSwitchToBank;
	
	@FindBy(xpath = "//p[text()='Bank Account' or text()='Compte bancaire' or text()='Switch to bank account' or contains(text(),'un compte bancaire')]")
	WebElement btnBankAccount;
	
	@FindBy(xpath = "//input[@id = 'expiryDate' and @formcontrolname='expiryDate']")
	WebElement txtExpiryDate;
	
	/*@FindBy(xpath = "//button[@title='Continue' or @title='Continuer']")
	WebElement btnContinue;*/
	
	@FindBy(xpath = "//ins[@translate='payment-method.review-payment-method.confirmAccountDetails']")
	WebElement lblConfirmAccountDetails;
	
	@FindBy(xpath = "//div[contains(@class,'payment-info-container')]")
	WebElement divCardDetailsOnReviewCreditCardPag;

	@FindBy(xpath = "//button[@title='Confirm' or @title='Confirmer']")
	WebElement btnConfirm;
	
	@FindBy(className ="tnc-container")
	WebElement lblTnCContainer;
	
	@FindBy(xpath = "//*[contains(@class,'tnc-container')]")
	WebElement lblTnCContainerMobile;
	
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
	
	@FindBy(xpath = "//*[@id = 'transitNumber']")
	WebElement txtTransitNumberMobile;
	
	@FindBy(xpath = "//*[@id = 'institutionNumber']")
	WebElement txtInstitutionNumberMobile;
	
	@FindBy(xpath = "//*[@id = 'accountNumber']")
	WebElement txtAcountNumberMobile;
	
	@FindBy(xpath = "//div[@class='a-input semafone-cc-parent']//descendant::iframe")
	WebElement frameCreditCardNumberText;

	@FindBy(xpath = "//ss-semafone-credit-card[@class='semafone-cc']//descendant::iframe")
	WebElement iframeCreditCardNumberText;

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

	@FindBy(xpath = "//a[@title='Cancel automatic payments' or @title='Annuler les paiements automatiques']")
	WebElement btnRemoveAutomaticPayment;
	
	@FindBy(xpath = "//*[contains(text(),'Account balance will be automatically charged to:')]")
	WebElement lblCurrentPaymentOn;
	
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
		@FindBy(xpath = "//input[@name='cvv']"),
		@FindBy(name = "securityCode")
	})
	WebElement txtCVV;
	
	@FindBy(xpath = "//*[@id = 'cvc' and @formcontrolname='cvc']")
	WebElement txtCVC;
	
	@FindBy(xpath = "//*[@id = 'cvc' and @formcontrolname='cvc']")
	WebElement txtCVCMobile;
	
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
	
	@FindAll({
		@FindBy(xpath="//select[@id='nacPaymentMethod']"),
		@FindBy(xpath="//select[@data-test='select-payment-option']")
	})
	WebElement ddlPaymentMethod;
	
	@FindAll({
		@FindBy(xpath="//span[@checkout-res='checkout_pay_submit']/parent::button"),
		@FindBy(xpath="//button[@id='main-continue-button']")
	})
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@id='agree-to-terms-and-conditions']")
	WebElement chkIAgreeTnCBuyFlowChequing;

	@FindBy(xpath = "//ins/p[contains(text(),'I/We acknowledge that I/we have read, understood and accepted')]")
	WebElement divTnCBottom;
	
	@FindBy(xpath = "//button[@data-test='payment-method-continue']")
	WebElement btnBillingOptionClkContinue;
	
	@FindBy (xpath = "//*[contains(text(),' Current payment method: ')]")
	WebElement modalPaymentMethod;

	@FindBy(xpath = "//p[text()='2. Review' or text()='2. Vérification']")
	WebElement lblReview;

	@FindBy(xpath = "//span[contains(text(),'Change to manual payments')]/ancestor::label")
	WebElement optManualPayments;

	@FindAll({
			@FindBy(xpath = "//button[@title='payment.auto.manual.step-1.continue']"),
			@FindBy(xpath = "//span[text()=' Continue ']")})
	WebElement btnContinue;

	@FindBy(xpath = "//button[@title='Yes, cancel automatic payments']")
	WebElement btnYesCancelAutoPayment;

	@FindBy(xpath = "//button[@title='No, don’t cancel']")
	WebElement btnCancelAutomaticPayments;

	@FindBy(xpath = "//ss-payment-message//span[contains(text(),'Done')]//ancestor::a")
	WebElement btnChangePaymentDone;

	@FindBy(xpath = "//ss-payment-message//span[contains(text(),'Done')]//ancestor::a")
	WebElement btnManualChangePaymentDone;

	@FindBy(xpath = "//a[@class='ml-8 ds-link ds-pointer d-inline-flex outline-none mw-100 -cta' or contains(text(),'Configurer les paiements automatiques')]")
	WebElement lnkSetUpAutomaticPaymentMethod;

	@FindBy(xpath = "//rss-quick-links//span[contains(text(),'Set up automatic payments') or contains(text(),'Configurer les paiements automatiques')]")
	WebElement lnkSetUpAutoPayment;

	@FindAll({
			@FindBy(xpath = "//span[contains(text(),' Use a different credit card for automatic payments ') or contains(text(),' de crédit ')]/ancestor::label"),
			@FindBy(xpath = "//span[contains(text(),' Use a credit card for automatic payments ') or contains(text(),' Effectuer des paiements automatiques à partir d’un compte de carte de crédit ')]/ancestor::label")
	})
	WebElement optCardAccount;

	@FindBy(xpath = "//button[@class='w-100 w-sm-auto ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large' or @title='Continuer']")
	WebElement btnContinueSetCC;

	@FindBy(xpath = "//button[@class='w-100 w-sm-auto mr-md-24 mt-16 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large' or @title='Continuer']")
	WebElement btnContinueReview;


	@FindBy(xpath = "//p[text()=' Success! Starting next month your bill payments will be made automatically. ' or text()='C’est réussi! À partir du mois prochain, vos paiements de facture se feront automatiquement.']")
	WebElement lblYouAutomaticPaymentWillStart;

	@FindBy (xpath = "//*[@translate='ute.payment.method.payment_method' or @translate='ute.payment.method.will_auto_charge' or contains(text(),'Will be automatically charged to:') or contains(text(),'Mode de paiement:') or contains(text(),'Sera porté automatiquement à :') or text()='Payment method:' or text()='Mode de paiement:']")
	WebElement lblAutoPayment;



	@FindBy(xpath = "//ds-icon[@class='-size-48']")
	WebElement imgCC;

	@FindBy(xpath = "//span[contains(text(),'Pay through your bank') or contains(text(),' Paiement par services bancaires')]/ancestor::label")
	WebElement divBank;

	@FindBy(xpath = "//span[contains(text(),'Pay with credit card, Visa Debit') or contains(text(),'Paiement par carte de crédit, carte Visa Débit ou carte')]/ancestor::label")
	WebElement divCredit;

	//--------------------------------------------------------------------------------
	
	/**
	 * Verify if the payment method modal is displayed
	 * @return true if the modal displayed, else false.
	 * @author ning.xue
	 */
	public boolean verifyPaymentMethodModalDisplayed() {
		return reusableActions.isElementVisible(modalPaymentMethod, 30);
	}
	
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
	 * This will select the payment type
	 * @param strPaymentMode String containing the payment type name
	 * @author Mirza.Kamran
	 */
	public void clkPaymentOptionMobile(String strPaymentMode) {
		switch (strPaymentMode) {
		case "Credit Card":
			clkButtonCreditCardAccountMobile();
			break;

		case "Bank Account":
			clkButtonBankAccountMobile();
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
		reusableActions.executeJavaScriptClick(btnCreditCard);
	}
	
	/**
	 * Perform click on the bank Account Button
	 */
	public void clkButtonBankAccount() {
		reusableActions.getWhenReady(btnBankAccount).click();
	}
	
	/**
	 * Perform click on the bank Account Button
	 */
	public void clkButtonBankAccountMobile() {
		//reusableActions.scrollToElement(btnBankAccount);
		reusableActions.executeJavaScriptClick(btnBankAccount);
	}
	
	/**
	 * Perform click on the bank Account Button
	 */
	public void clkButtonCreditCardAccountMobile() {
		try {
		//reusableActions.scrollToElement(btnCreditCard);		
		reusableActions.executeJavaScriptClick(btnCreditCard);
		}
		catch (Exception e) {
			// TODO: supressing error to debug mobile execution
		}
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
	 * @Rama Arora
	 * @return true or false review cc details
	 */
	public boolean isReviewCCDetailsPageDisplayed() {
		// TODO Auto-generated method stub
		return reusableActions.isElementVisible(lblReview);
	}

	/**
	 * Click on Switch to manual payments
	 * @author Rama Arora
	 */
	public void clkSwitchToManualPayments() {
		reusableActions.isElementVisible(optManualPayments, 60);
		reusableActions.executeJavaScriptClick(optManualPayments);
	}

	/**
	 * Clicks on the 'Yes, cancel automatic payments' button
	 * @author Rama Arora
	 */
	public void clkYesCancelAutomaticPayment() {
		reusableActions.staticWait(4000);
		reusableActions.clickIfAvailable(btnContinue);
		/*reusableActions.clickIfAvailable(btnCancelAutomaticPayments,30);
		reusableActions.staticWait(4000);
		reusableActions.clickIfAvailable(btnContinue);*/
		reusableActions.clickIfAvailable(btnYesCancelAutoPayment);
	}

	/**
	 * Clicks on the button change payment done
	 * @author Rama Arora
	 */
	public void clkButtonDoneChangePayment() {
		reusableActions.staticWait(5000);
		//reusableActions.getWhenReady(btnManualChangePaymentDone,60).click();
		reusableActions.executeJavaScriptClick(btnManualChangePaymentDone);

	}

	/**
	 * Clicks on the 'Billing and Payment' then 'Set up automatic payment' option
	 * @author Rama Arora
	 */
	public void clkSetUpAutomaticPaymentMethod() {
		//getReusableActionsInstance().waitForElementVisibility(lnkBillingAndPayment);
		//getReusableActionsInstance().clickIfAvailable(lnkBillingAndPayment);
		reusableActions.getWhenReady(lnkSetUpAutomaticPaymentMethod,60).click();
	}

	/** click on Set up Payment link
	 * @ Rama ARora
	 *//*
	public void clkSetUpAutoPaymentQuickLink() {
		reusableActions.waitForElementTobeClickable(lnkSetUpAutoPayment, 60);
		reusableActions.getWhenReady(lnkSetUpAutoPayment).click();
	}*/

	/**
	 * Click on CC card radio button
	 * @author Rama Arora
	 */
	public void clkUseCCForAutomaticPayments() {
		reusableActions.waitForElementVisibility(optCardAccount, 60);
		reusableActions.executeJavaScriptClick(optCardAccount);
	}

	/*
	 *  @Rama Arora
	 */
	public void clkContinueSettingCC() {
		reusableActions.getWhenReady(btnContinueSetCC).click();
	}

	/**
	 * Clicks on continue button on Review page
	 * @author Rama Arora
	 */
	public void clkContinueOnReviewPg() {
		reusableActions.getWhenReady(btnContinueReview).click();

	}

	/**
	 * verify if the label success header is displayed
	 * @return true if the label is displayed hence false
	 * @author Rama Arora
	 */
	public boolean verifySuccessMessageIsDisplayed() {
		return reusableActions.isElementVisible(lblYouAutomaticPaymentWillStart,120);
	}

	/**
	 * Click on Done button
	 * @author Rama Arora
	 */
	public void clkOnDone() {
		reusableActions.staticWait(5000);
		//reusableActions.getWhenReady(btnChangePaymentDone).click();
		reusableActions.executeJavaScriptClick(btnChangePaymentDone);
	}

	/**
	 * Checks if the auto payment option is set successfully to CC
	 * @return true if the payment option is set successfully
	 * @author Rama Arora
	 */
	public boolean verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage() {
		// buffer static wait added for pageload
		reusableActions.staticWait(4000);
		reusableActions.waitForElementVisibility(lblCurrentPaymentOn, 50);
		reusableActions.staticWait(2000);
		return (reusableActions.isElementVisible(lblCurrentPaymentOn,20)
				&& reusableActions.isElementVisible(imgCC,20));
	}

	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param payOption payment option to pay to buy Internet offer
	 * @author Rama Arora
	 */
	public void selectHowWouldYouLikeToPayNew(PayOptions payOption) {
		//writing the below element in method since we want to dynamically generate this at run time
		if(payOption.toString().toLowerCase().equals("bank"))
		{

			reusableActions.getWhenReady(divBank).click();

		}else if(payOption.toString().toLowerCase().equals("creditcard"))
		{
			//getReusableActionsInstance().javascriptScrollByVisibleElement(divCredit);
			reusableActions.getWhenReady(divCredit).click();

		}

	}

	/**
	 * Click on the continue button
	 * @author Mirza.Kamran
	 */
	public void clkContinue() {
		reusableActions.waitForElementTobeClickable(btnContinue, 60);
		reusableActions.executeJavaScriptClick(btnContinue);
	}

	/**
	 *  Set the transit number for  bank
	 * @param strTransitNumber  bank transit code of the account
	 * @author Mirza.Kamran
	 */
	public void setBankTransitNumberMobile(String strTransitNumber) {
		reusableActions.clickWhenVisible(txtTransitNumberMobile);
		reusableActions.getWhenReady(txtTransitNumberMobile).sendKeys(strTransitNumber);
	}
	
	
	/**
	 * Set the institution number
	 * @param strInstitutionNumber bank code of the account
	 * @author Mirza.Kamran
	 */
	public void setInstitutionNumberMobile(String strInstitutionNumber) {
		reusableActions.clickWhenVisible(txtInstitutionNumberMobile);
		reusableActions.getWhenReady(txtInstitutionNumberMobile).sendKeys(strInstitutionNumber);
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
	public void setAccountNumberMobile(String strBankAccountNumber) {
		reusableActions.clickWhenVisible(txtAcountNumberMobile);
		reusableActions.getWhenReady(txtAcountNumberMobile).sendKeys(strBankAccountNumber);
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
		return (reusableActions.isElementVisible(lblTnCContainer) && (reusableActions.isElementVisible(lbltnCHeader)));
	}
	
	/**
	 * Checks if the T and C page is open
	 * @return true if the T and C page is available, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTnCPageIsOpenMobile() {
		return (reusableActions.isElementVisible(lblTnCContainerMobile) && (reusableActions.isElementVisible(lbltnCHeader)));
	}
	
	/**
	 * click on  the Terms and Conditions check box on change payment option page
	 * @author Mirza.Kamran
	 */
	public void clkIAcceptTermsAndCondition() {				
		reusableActions.staticWait(1000);
		reusableActions.getWhenReady(chkAcceptTnC).click();
	}
	
	/**
	 * click on  the Terms and Conditions check box on change payment option page
	 * @author Mirza.Kamran
	 */
	public void clkIAcceptTermsAndConditionMobile() {				
		reusableActions.staticWait(1000);
		reusableActions.getWhenReady(chkAcceptTnC).click();
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
		//driver.switchTo().frame(reusableActions.getWhenVisible(frameCreditCardNumberText));
		driver.switchTo().frame(reusableActions.getWhenVisible(iframeCreditCardNumberText));
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
		String str2DigitYear = strExpiryYear.substring(2);
		String strMMYY=FormFiller.generateMonth()+ str2DigitYear;
		if(strMMYY.length()==3)
		{
			strMMYY="0"+strMMYY;
		}
		reusableActions.getWhenReady(txtExpiryDate,10).click();
		reusableActions.getWhenReady(txtExpiryDate,10).sendKeys(strMMYY);
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
	 * Set the CVV for  card
	 * @param strCVC CVC for credit card
	 * @author Mirza.Kamran
	 */
	public void setCreditcardCVCMobile(String strCVC) {
		reusableActions.clickWhenVisible(txtCVCMobile);
		reusableActions.getWhenReady(txtCVCMobile).sendKeys(strCVC);
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
	
/*	*//**
	 * Click om continue payment button
	 * @author Mirza.Kamran
	 *//*
	public void clkContinue() {
		reusableActions.getWhenReady(btnContinue).click();
	}*/
	
	/**
	 * checks if the review credit card details is displayed
	 * @return true if the label review credit card details is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheReviewCreditCardIsDisplayed() {
		return reusableActions.isElementVisible(lblConfirmAccountDetails);
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
		return reusableActions.isElementVisible(lblSuccessYouAreSignedUpForAutomaticPayments);
	}
	
	/**
	 * checks if the label your future bills message is displayed
	 * @return true if the label your future bills is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelYourFutureBillsIsDisplayed() {
		return reusableActions.isElementVisible(lblYourFutureBillText);
	}
	
	/**
	 * checks if the label your your paymentMethod ending  message is displayed
	 * @return true if the label your paymentMethod ending is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelPaymentMethodEndingInIsDisplayed() {
		return reusableActions.isElementVisible(lblPaymentMethodEndingInText);
	}
	
	/**
	 * checks if the label your Automatic payment effect message is displayed
	 * @return true if the label your Automatic payment effect is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheLabelAutomaticPaymentEffectIsDisplayed() {
		return reusableActions.isElementVisible(lblAutomaticPayementEffect);
	}
		
	/**
	 * checks if the button Pay Balance is displayed
	 * @return true if the button pay balance is displayed, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfTheButtonPayBalanceIsDisplayed() {
		return reusableActions.isElementVisible(btnPaybalance);
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
		reusableActions.staticWait(5000);
		return (reusableActions.isElementVisible(lblCurrentPaymentOn)) ;
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
		if(reusableActions.isElementVisible(lblAreYourSure))
		{
			reusableActions.getWhenReady(btnYesCancel).click();
		}
		
	}
	
	/**
	 * Selects the Payment Method as 'Invoive (manual payments)'
	 * @author rajesh.varalli1
	 */
	public void setManualPaymentMethod() {
		reusableActions.staticWait(5000);
		reusableActions.waitForElementTobeClickable(ddlPaymentMethod , 40);
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.selectWhenReady(ddlPaymentMethod, "INVOICE");
	}
	
	/**
	 * click continue on billing Option for NAC flow
	 * @author Saurav.Goyal
	 */
	public void billingOptionClkContinue() {
		reusableActions.clickWhenReady(btnBillingOptionClkContinue , 30);
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
