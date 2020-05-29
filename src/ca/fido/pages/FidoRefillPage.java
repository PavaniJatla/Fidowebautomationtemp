package ca.fido.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;

public class FidoRefillPage extends BasePageClass {

	public FidoRefillPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy (xpath = "//div[@class='pp-airtime-balance']//span[@class='ute-price']")
	WebElement balanceAmount;

	@FindBy(xpath = "//ins[@translate=\"wireless.label.readySetRefill\"]")
	WebElement lblReadysetRefill;
	
	@FindBy(xpath = "//prepaid-refill-page-header//following-sibling::div//ins[@translate=\"wireless.label.setUpAutoPayPlan\"]")
	WebElement lnkRecurringAutoRefill;
	
	@FindBy(xpath = "//prepaid-refill-page-header//following-sibling::div//ins[@translate='wireless.label.setUpAutoRefillBalance']")
	WebElement lnkLowbalanceAutoRefill;
	
	@FindBy(xpath = "//prepaid-refill-page-header//following-sibling::div//ins[@translate='wireless.label.oneTimeRefill']")
	WebElement lnkOneTimeRefill;
	
	@FindBy (xpath = "//ins[@translate='global.label.paymentMethodCode.CC']")
	WebElement lblPayByCreditCard;
	
	@FindBy (xpath = "//ins[@translate='global.label.paymentMethodCode.IN']")
	WebElement lblPayByinterac;
	
	@FindBy (xpath = "//div[contains(@ng-show,'Creditcard')]//span//ins[@translate='global.cta.cancel']")
	WebElement lnkCancel;
	
	@FindBy (xpath = "//button[@translate='global.cta.continue']")
	WebElement btnOneTimeRefillContinue;
	
	@FindBy(xpath = "//prepaid-refill-page-header//following-sibling::div//ins[@translate='wireless.label.redeemVoucher']")
	WebElement lnkRedeemVoucher;

	@FindBy(xpath = "//span[@ng-bind='subscriberNumber | prepaidRefillPageCTN']")
	WebElement lblSubscriberNumber;

	@FindBy(xpath = "//div[@class='pp-airtime-balance']")
	WebElement divAirTimeBalance;

	@FindBy(xpath = "//select[@name='refillBalance']")
	WebElement cmbRefillWhenMyBalanceIs;

	@FindBy(xpath = "//select[@name='selectedRefillAmount']")
	WebElement cmbRefillAmount;

	@FindBy(xpath = "//button/ins[text()='Continue'  or text()='Continuer']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//button[@ng-click='checkInteracPaymentEligibility()']/ins[@translate='global.cta.continue']")
	WebElement btnPayByInteracContinue;
	
	@FindBy(xpath = "//button[@translate='global.cta.continue']")
	WebElement btnContinuerecurringAutoPay;

	@FindBy(xpath = "//div[@ng-show='CreditCardRegistrationStatus']")
	WebElement lblCreditCardRegistrationStatus;
	
	@FindBy(xpath = "//ins[@translate='wireless.message.registeredCreditCard']")
	WebElement lblRegisteredCard;

	@FindBy(xpath = "//ins[@translate=\"global.label.whenToCharge\"]")
	WebElement lblReviewYourText;

	@FindBy(xpath = "//div[@class='dollar-amount'")
	WebElement lblLowBalanceAutoRefill;
	
	@FindBy(xpath = "//ins[@translate='wireless.message.agreeFidoTermsRegisterCard']")
	WebElement lblTnC;

	@FindBy(xpath = "//div[@ng-bind='refillAmount.rechargeAmount | currency']")
	WebElement divRefillAmount;

    @FindBy(xpath = "//div[@ng-bind='gst | currency']")
    WebElement divGST;
        
    @FindBy(xpath = "//div[@ng-bind='pst | currency']")
    WebElement divPST;
    
    @FindBy(xpath = "//strong[@ng-bind='totalAmount | currency']")
    WebElement divTotalAmount;
    
    @FindBy(xpath = "//button[text()='Submit' or text()='Soumettre']")
    WebElement btnSubmit;    
    
    @FindBy(xpath = "//span[@translate='wireless.label.successCheers']")
    WebElement lblYourRefillIsComplete;
    
    @FindBy(xpath = "//span[@translate='global.label.confirmationEmail']")
    WebElement lblConfirmationEmail;
            
    @FindBy(xpath = "//button[@translate='global.cta.backToAccount']")
    WebElement btnBacktoMyAccount;
    
    @FindBy(xpath = "//button/ins[@translate='wireless.label.stopAutoPayment']")
    WebElement btnStopAutoPayment;
    
    @FindBy(xpath = "//div[@ng-show='stopAutoPaymentNotifier===true']")
    WebElement lnlStopPaymentSuccessNotifier;
    
    @FindBy(xpath = "//p[@class='fido-tick-icon-secondary']")
    WebElement lblAddAmountAtLowPrice;
        
    @FindBy(xpath = "//div[@ng-show='stopAutoPaymentNotifier===true']")
    WebElement lblStopPaymentSuccessNotifier;
        
    @FindBy(xpath = "//ins[@translate='wireless.label.areYouSureYouWantToStopAutoPayments']")
    WebElement lblOverlayAreYouSureToStopAutoPayment;
    
    @FindBy(xpath = "//button/ins[@translate='global.cta.yesStop']")
    WebElement btnYesStop;
    
    @FindBy(xpath ="//ins[@translate='wireless.message.setUpAutoRefillError']")
    WebElement lblWarning;

    @FindBy(xpath ="//form[@name='form']//descendant::iframe")
    WebElement fraCC;

    @FindBy(xpath ="//input[@class='semafonemandatory']")
    WebElement txtCardNumber;
        
	@FindBy(id = "expiry-date")
	WebElement ddlExpiryMonth;

	@FindBy(name = "expYear")
	WebElement ddlExpiryYear;

	@FindBy(id = "cvv")
	WebElement txtCVV;
	
	@FindBy (xpath = "//ins[@translate='wireless.message.agreeFidoTermsRegisterCard']")
	WebElement chkFidoTerms;
	
	@FindBy (xpath = "//div[@ng-bind='refillAmount | currency']")
	WebElement refillAmount;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.setUpAutoPayPlan']/parent::tab-heading//p[@class='fido-tick-icon']")
	WebElement lblFidoTickIconRecurringAutoRefill;
	
    /**
     * Gets the balance amount 
     * @return string containing the balance amount
     */
    public String getBalanceAmount() {
    	reusableActions.waitForElementVisibility(balanceAmount, 30);
    	String balance = balanceAmount.getAttribute("price").trim();
    	return balance;
    }
    
    /**
     * This method will click on the balance auto refill tab on the for prepaid accounts
     * It uses multi attempt logic 
     * @author Mirza.Kamran
     */
    public void clkLowBalanceAutoRefill() {
    	Integer attemp = 0;
    	Boolean clickSuccess = false;
    	
    	while (attemp <= 3 && !clickSuccess) {
    		
    		reusableActions.waitForElementVisibility(lnkLowbalanceAutoRefill);
    		reusableActions.javascriptScrollToMiddleOfPage();
    		reusableActions.waitForElementTobeClickable(lnkLowbalanceAutoRefill, 60);
        	reusableActions.executeJavaScriptClick(lnkLowbalanceAutoRefill);   	
        	reusableActions.waitForPageLoad();
        	
        	if(reusableActions.isDisplayed(lblWarning))
        	{
        		reusableActions.executeJavaScriptClick(lnkRecurringAutoRefill);
        		reusableActions.waitForPageLoad();
        		reusableActions.executeJavaScriptClick(lnkLowbalanceAutoRefill);
        		if(reusableActions.isDisplayed(cmbRefillWhenMyBalanceIs)
        		    	&& reusableActions.isDisplayed(cmbRefillAmount)
        		    	&& (reusableActions.isDisplayed(btnContinue)||reusableActions.isDisplayed(btnStopAutoPayment)))
        		{
            		clickSuccess=true;
            		break;
            	}else
            	{
            		clickSuccess=false;
            		attemp++;
            	}        		
        		
        	}else if(reusableActions.isDisplayed(cmbRefillWhenMyBalanceIs)
    		    	&& reusableActions.isDisplayed(cmbRefillAmount)
    		    	&& (reusableActions.isDisplayed(btnContinue)||reusableActions.isDisplayed(btnStopAutoPayment)))
        	{
        		clickSuccess=true;
        		break;
        	}else
        	{
        		clickSuccess=false;
        		attemp++;
        	}
			
		}    	
    	
    	//static buffer added since already saved cc needs some synch 
    	reusableActions.staticWait(3000);
    }

    /**
     * This will perform click on the recurring auto refill tab
     * @author Mirza.Kamran
     */
    public void clkRecurringAutoRefill() {
    	reusableActions.javascriptScrollToMiddleOfPage();
    	reusableActions.waitForElementTobeClickable(lnkRecurringAutoRefill, 60);
    	reusableActions.executeJavaScriptClick(lnkRecurringAutoRefill);
    	reusableActions.waitForPageLoad();
    }
    
    /**
     * Clicks on the button Stop Auto Payment
     * @author Mirza.Kamran
     */
    public void clkStopAutoPayment() {
    	reusableActions.executeJavaScriptClick(btnStopAutoPayment);
    	reusableActions.waitForPageLoad();
    }
    
    /**
     * Clicks on the button submit
     * @author Mirza.Kamran
     */
    public void clkSubmit() {
    	reusableActions.executeJavaScriptClick(btnSubmit);
    	reusableActions.waitForPageLoad();
    }
    
    /**
     * Clicks back to my account button
     * @author Mirza.Kamran
     */
    public void clkBacktoMyAccount() {
    	reusableActions.executeJavaScriptClick(btnBacktoMyAccount);
    	reusableActions.waitForPageLoad();
    }
    
    /**
     * Clicks on One time refill button
     * @author Mirza.Kamran
     */
    public void clkOneTimeRefill() {
    	reusableActions.waitForElementTobeClickable(lnkOneTimeRefill, 30);
    	reusableActions.executeJavaScriptClick(lnkOneTimeRefill);
    }
    
    /**
     * Select the radio of PayByCreditCard.
     * @author Mirza.Kamran
     */
    public void selectPayByCreditCard() {
    	reusableActions.waitForElementVisibility(lblPayByCreditCard);
    	reusableActions.waitForElementTobeClickable(lblPayByCreditCard, 30);
    	reusableActions.executeJavaScriptClick(lblPayByCreditCard);
    }
    
    /**
     * Select the radio of Pay by interac.
     */
    public void selectPayByInterac() {
    	reusableActions.clickWhenReady(lblPayByinterac,10);
    }
    
    /**
     * Check the authorize terms by clicking on the text.
     * @author Mirza.Kamran
     */
    public void chkAuthorizeTerms() {
    	reusableActions.clickWhenReady(chkFidoTerms, 10);
    }
    
    /**
     * click the continue button in OneTimeRefill flow
     * @author Mirza.Kamran
     */
    public void clkBtnOneTimeRefillContinue() {
    	reusableActions.executeJavaScriptClick(btnOneTimeRefillContinue);
    }
    
    /**
     * To get refill amount in the order review 
     * @return String of refill amount 
     */
    public String getRefillAmount() {
    	reusableActions.waitForPageLoad();
    	reusableActions.waitForElementVisibility(refillAmount);
    	if (reusableActions.isDisplayed(refillAmount)) {
        	return refillAmount.getText();
    	}
    	return null;
    }
    
    /**
     * Clicks on the button yes stop
     * @author Mirza.Kamran 
     */
    public void clkYesOnStopAutoPaymentOverlay() {
    	reusableActions.executeJavaScriptClick(btnYesStop);
    }

    /**
     * Perform clicks on the button continue
     * @author Mirza.Kamran
     */
    public void clkContinue() {
    	reusableActions.executeJavaScriptClick(btnContinue);
    	reusableActions.waitForPageLoad();
    }
        
    /**
     * Perform clicks on the button continue
     * @author Mirza.Kamran
     */
    public void clkRecurringAutoPayContinue() {
    	reusableActions.executeJavaScriptClick(btnContinuerecurringAutoPay);
    }
    
    /**
     * This method will set values for pre-paid auto refill
     * @author Mirza.Kamran    
     */
    public void selectAutoRefillDetails() {
    	
    	reusableActions.selectWhenReady(cmbRefillWhenMyBalanceIs,0);
    	reusableActions.selectWhenReady(cmbRefillAmount, 0);    	    	
    	
    }
    
    
    /**
     * Verifies if the button Continue is displayed
     * @return true if the button is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyButtonContinueIsDisplayed() {
    	return reusableActions.isDisplayed(btnContinue);
    }
    
    /**
     * Verifies if the combobox Refill Amount is displayed
     * @return true if the combobox is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyComboRefillAmountIsDisplayed() {
    	return reusableActions.isDisplayed(cmbRefillAmount);
    }
    
    /**
     * Verifies if the combobox refill when my balance is displayed
     * @return true if the combobox is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyComboRefillWhenMyBalanceIsDisplayed() {
    	return reusableActions.isDisplayed(cmbRefillWhenMyBalanceIs);
    }
    
    
    /**
     * Verifies if the Label Credit Card Registration is displayed
     * @return true if the label is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyLabelCreditCardRegistrationIsDisplayed() {
    	return reusableActions.isDisplayed(lblCreditCardRegistrationStatus);
    }
    
    
    /**
     * Verifies if the Div Air time balance is displayed
     * @return true if the Div is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyDivAirTimeBalanceIsDisplayed() {
    	return reusableActions.isDisplayed(divAirTimeBalance);
    }
    
    /**
     * Verifies if the labelSubscriber Number is displayed
     * @return true if the label is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyLabelSubscriberNumberIsDisplayed() {
    	return reusableActions.isDisplayed(lblSubscriberNumber);
    }
    
    
    /**
     * Verifies if the label Ready set refill is displayed
     * @return true if the label is displayed else false
     * @author Mirza.Kamran
     */
    public boolean verifyLabelReadySetRefillIsDisplayed() {
    	return reusableActions.isDisplayed(lblReadysetRefill);
    }
    
    
    /**
     * Compared the sum addition with the value displayed in plan summary section
     * @return true if refill amount matches ,else false
     */
    public Boolean verifyPlanSummarySumValuesMatch() {
    	        	    
    	if(!getTotalCalculationsOfPlanSummary().equals(Float.parseFloat(getTotalSummaryAmountFromPlanSummarySection())))    	
    		{
    			System.out.println("The Sum additon values mismatch on the plan summary details section, please investigate");
    				return false;
    		}
    	return true;
    }
    
    /**
     * returns the sum addition of refill amount + gstHST + pstQST  from the Plan summary page
     * @return float value containing  addition total amount
     * @author Mirza.Kamran
     */
    public Float getTotalCalculationsOfPlanSummary()
    {
    	return Float.parseFloat(getRefillAmountFromPlanSummarySection())
 			   +Float.parseFloat(getGstHstPlanSummarySection())
 			   +Float.parseFloat(getPstQstPlanSummarySection());
    }
    
    
    /**
     * Gets the Total amount from Plan summary section
     * @return string containing the total amount value
     * @author Mirza.Kamran
     */
    public String getTotalSummaryAmountFromPlanSummarySection() {
    	return reusableActions.getWhenReady(divTotalAmount).getText().split("\\$")[1];
    }
    
    /**
     * Gets the Refill AMount from application
     * @return string containing the refill amount value
     * @author Mirza.Kamran
     */
    public String getRefillAmountFromPlanSummarySection() {
    	return reusableActions.getWhenReady(divRefillAmount).getText().split("\\$")[1];
    }
    
    /**
     * Gets the gst hst amount from application
     * @return string containing the gst hst value
     * @author Mirza.Kamran
     */
    public String getGstHstPlanSummarySection() {
    	return reusableActions.getWhenReady(divGST).getText().split("\\$")[1];
    }
    
    
    /**
     * Gets the Pst Qst from application
     * @return string containing the Pst Qst value
     * @author Mirza.Kamran
     */
    public String getPstQstPlanSummarySection() {
    	return reusableActions.getWhenReady(divPST).getText().split("\\$")[1];
    }
    
            
    /**
     * Verifies if the auto refill is submitted successfully
     * @return true if auto refill submitted successfully else false
     * @author Mirza.Kamran
     */
    public Boolean verifyAutoRefillSubmittedSuccessFully() {
    	if(reusableActions.isElementVisible(btnBacktoMyAccount, 10)
    		&& reusableActions.isElementVisible(lblYourRefillIsComplete)
    		&& reusableActions.isElementVisible(lblConfirmationEmail)
    		)
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
    
    /**
     * Verifies if the one time refill is submitted successfully
     * @return true if one time refill submitted successfully else false
     * @author Mirza.Kamran
     */
    public Boolean verifyOneTimeRefillSubmittedSuccessFully() {
    	if(reusableActions.isElementVisible(btnBacktoMyAccount, 10)
    		&& reusableActions.isElementVisible(lblYourRefillIsComplete))
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
    
    /**
     * Verifies if the auto refill is stopped successfully
     * @return true if auto refill stopped successfully else false
     * @author Mirza.Kamran
     */
    public Boolean verifyAutoRefillStoppedSuccessfully() {
    	String lblStopSuccesstext=reusableActions.getWhenReady(lblStopPaymentSuccessNotifier).getText();
    	if(!reusableActions.isDisplayed(lblStopPaymentSuccessNotifier)
    		&& lblStopSuccesstext==null	)
    	{
    		System.out.println("Auto refill stopped label is not displayed, please investigate");
    		return false;
    	}
    	return true;
    }

    /**
     * Sets the Credit card number
     * @param strAccountNumber String credit card account number
     * @author Mirza.Kamran
     */
	public void setCreditCardNumber(String strAccountNumber) {
		
		driver.switchTo().frame(reusableActions.getWhenVisible(fraCC));
		reusableActions.waitForElementTobeClickable(txtCardNumber, 20);
		reusableActions.executeJavaScriptClick(txtCardNumber);
		reusableActions.getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
		driver.switchTo().defaultContent();	
	}
	

	public void selectExpiryMonth(String strMonth) {	
		reusableActions.waitForElementTobeClickable(ddlExpiryMonth, 30);
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryMonth, strMonth);
		
	}
	
	/**
	 * Selects the credit card expiry year
	 * @param strYYYY string value containing Credit card expiry year
	 * @author Mirza.Kamran
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		reusableActions.waitForElementTobeClickable(ddlExpiryYear, 30);
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
		
	}

	/**
	 * To set 3 or 4 digit cvv of credit card, send TAB is for move focus to element checkFidoTerms
	 * @param strCVV, string of 3 or 4 digit number.
	 */
	public void setCreditcardCVV(String strCVV) {
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV, 10).sendKeys(strCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(Keys.TAB);
	}
	
	/**
	 * This method will check if the credit card details are already saved or not
	 * @return return the boolean value for credit card registered or not
	 * @author Mirza.Kamran
	 */
	public Boolean isCardAlreadyRegistered() {
		//
		reusableActions.staticWait(3000);
		if(!reusableActions.isDisplayed(lblRegisteredCard)) {
			System.out.println("Label card already registred is not displayed, please investigate");
			return false;
		}
		
		return true;
	}
	
	/**
	 * This method will click the TnC check box
	 * @author Mirza.Kamran
	 */
	public void clkTnC() {
		reusableActions.clickWhenReady(lblTnC,10);
		
	}

	/**
	 * The Auto Refill is already set
	 * @return true if the auto refill is already set else false
	 * @author Mirza.Kamran
	 */
	public boolean isRecurringAutoRefillAlreadySet() {		
		return reusableActions.isDisplayed(lblFidoTickIconRecurringAutoRefill);
	}

	/**
	 * Clicks on the continue button on pay by interac section
	 * @author Mirza.Kamran
	 */
	public void clkPayByInteracContinue() {
		reusableActions.executeJavaScriptClick(btnPayByInteracContinue);
		
	}
}
