package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class FidoMakePaymentPage extends BasePageClass {

	public FidoMakePaymentPage(WebDriver driver) {
		super(driver);
	}

	public enum MakePayOptions {
	    Bank,
	    Creditcard,
	    Interac
	  }
	
	@FindBy(xpath = "//select[@ng-model='props.selectedPaymentOption']")
	WebElement ddlPaymentMode;

	@FindBy(xpath = "//label[@for='paper_method']")
	WebElement rdoPaperbill;

	@FindBy(xpath = "//button[@translate='global.cta.confirm']")
	WebElement btnPaymentConfirm;
	
	@FindBy(xpath = "//div[@class='semafone-container']//descendant::iframe")
	WebElement fraSemaphone;  
	
	@FindBy(xpath="//ss-semafone-credit-card/iframe")
	WebElement fraCC;

	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;

	@FindBy(id = "expiry-date")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//div/input[@id='expiryDate']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement ddlExpiryYear;

	@FindBy(id = "cvv")
	WebElement txtCVV;
	
	@FindBy(xpath = "//*[@id = 'expiry-date']")
	WebElement ddlExpiryMonthMobile;

	@FindBy(xpath = "//*[@name = 'expYear']")
	WebElement ddlExpiryYearMobile;

	@FindBy(xpath = "//*[@id = 'cvv']")
	WebElement txtCVVMobile;
	
	@FindBy(xpath="//*[@id='ds-form-input-id-2']")
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
	
	@FindBy(xpath="//*[contains(text(),' Review and Continue ') or contains(@value,'rifier et continuer')]")
	WebElement btnReviewAndContinue;

	@FindBy(xpath="//button[@class='w-100 w-sm-auto mr-md-24 mt-16 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large' or contains(@value,' Pay Now ')]")
	WebElement btnPayNow;
	
	@FindBy(xpath="//div[@class='pay-now-modal']//input[@value='Review & continue' or contains(@value,'rifier et continuer')]")
	WebElement btnReviewAndContinueMobile;

	@FindBy(xpath="//div[@class='pay-now-modal']//ins[@translate='global.cta.payNow']")
	WebElement btnPayNowMobile;
	
	@FindBy(xpath="//ins[@translate='global.label.paymentConfirmationHeading']")
	WebElement lblPaymentReceived;

	@FindBy(xpath = "//ss-payment-message//span[contains(text(),'Done')]//ancestor::a")
	private WebElement btnDone;
	
	@FindBy(xpath="//div[@class='pay-now-modal']//ins[@translate='global.cta.payIntreac']")
	WebElement btnPayOntheInteracSite;
	
	@FindBy(xpath="//div[@class='pay-now-payment-text']")
	WebElement paymentAmount;
	
	@FindBy(xpath="//div[@ng-if='paymentReferenceNumberExists']//div[@class='pay-now-payment-text uppercase']")
	WebElement lblRefrenceNumber;
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12 hidden-xs']//ins[@translate='global.label.paymentHistoryView']")
	WebElement btnPaymentHistory;
	
	@FindBy(xpath="//div[@class='pay-now-modal']/div[@class='modal-header hidden-xs']/div/button[@class='close square-close-icon']")
	WebElement btnCloseMakePayment;
	
	
	@FindBy(xpath = "//div[@class='bank-section']")
	WebElement divBankPayment;
	
	@FindBy (xpath = "//div[@class='row pay-now-content' or //button[@id='ds-tabs-0-tab-0']]")
	WebElement paymentModal;
	
	@FindBy(xpath = "//div[contains(@class,'hidden-xs')]//ins[@translate='global.label.paymentHistoryView']")
	WebElement lnkPaymentHistoryOnConfirmationPageFooter;
	
	@FindBy(xpath = "//ins[@translate='global.label.paymentHistoryView']")
	WebElement lnkPaymentHistoryOnConfirmationPageFooterMobile;

	@FindBy(xpath = "//div/input[@id='expiryDate']")
	WebElement txtExpiry;

	@FindBy(xpath = "//div/input[@id='expiryDate']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement lblExpiry;

	@FindBy(xpath = "//input[@id='securityCode' or @formcontrolname='cvc']")
	WebElement txtSecurityCode;

	@FindBy(xpath = "//p[text()=' Thank you! We received your payment. ']")
	WebElement lblPaymentSuccessMsg;

	@FindBy(xpath = "//ss-payment-message//p[contains(text(),'A confirmation email will be sent')]")
	WebElement lblReferenceNumberNew;

	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of the Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumber(String strAccountNumber) {	
		driver.switchTo().frame(reusableActions.getWhenVisible(fraCC));
		reusableActions.clickWhenVisible(txtCardNumber);
		reusableActions.getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
		driver.switchTo().defaultContent();
	}

	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * Selects the expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVV() {
		String strCVV = FormFiller.generateCVVNumber();
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);

	}
	
	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYearMobile() {
		String strYYYY = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryYearMobile, strYYYY);
	}

	/**
	 * Selects the expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonthMobile() {
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryMonthMobile, strMM);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVVMobile() {
		String strCVV = FormFiller.generateCVVNumber();
		reusableActions.clickWhenVisible(txtCVVMobile);
		reusableActions.getWhenReady(txtCVVMobile).sendKeys(strCVV);

	}
	
	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		//reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
		reusableActions.getWhenReady(lblExpiry,20).click();
		reusableActions.getWhenVisible(txtExpiry, 30).clear();
		reusableActions.getWhenVisible(txtExpiry).sendKeys(strYYYY);
	}

	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYearMobile(String strYYYY) {
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYearMobile, strYYYY);
	}

	/**
	 * Validates the Payment is successful and the Payment Amount processed
	 * @param strAmount - Payment Amount
	 * @return true if Payment Success msg and amount displayed are correct; else false
	 * @Rama Arora
	 */
	public boolean verifyPaymentSuccessful(String strAmount) {
		reusableActions.waitForElementVisibility(lblPaymentSuccessMsg, 60);
		return (reusableActions.isElementVisible(lblPaymentSuccessMsg) &&
				lblReferenceNumberNew.getText().trim().replace("$", "").trim().contains(strAmount));
	}

	/**
	 * Returns the reference number after successful transactions
	 * @return string transaction reference number
	 * @author Rama Arora
	 */
	public String getTransactionReferenceNumberNew() {
		return reusableActions.getWhenReady(lblReferenceNumberNew).getText().trim();
	}

	/**
	 * Clicks on the 'Done' button
	 * @ Rama Arora
	 */
	public void clickDone() {
		reusableActions.staticWait(5000);
		reusableActions.executeJavaScriptClick(btnDone);
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
		//reusableActions.clickWhenVisible(txtCVV);
		txtSecurityCode.sendKeys(strCVV);
		/*reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(Keys.TAB);*/
	}
	
	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditcardCVVMobile(String strCVV) {
		reusableActions.clickWhenVisible(txtCVVMobile);
		reusableActions.getWhenReady(txtCVVMobile).sendKeys(strCVV);
	}
	
	/**
	 * Set the payment amount on Fido payment page
	 * @param strAmount amount to be paid
	 * @author chinnarao.vattam
	 */
	public void setPaymentAmount(String strAmount){
		//By rdoPaymentOptionLocater=By.xpath("//label[@for='"+enumPaymentOpt.toString()+"']/ins");
		//reusableActions.executeJavaScriptClick(rdoPaymentOption);
		reusableActions.getWhenReady(By.xpath("//ss-amount-field//ds-form-field//input")).click();
		//The default wrapper is not working on french henc added below line
		/*reusableActions.getWhenReady(txtAmount, 30).clear();
		reusableActions.enterText(txtAmount,Keys.chord(Keys.CONTROL,"a", Keys.DELETE), 30);	
		reusableActions.enterText(txtAmount,strAmount, 30);	*/
		reusableActions.getWhenReady(By.xpath("//ss-amount-field//ds-form-field//input")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));;
		//reusableActions.staticWait(1000);

		reusableActions.staticWait(3000);
		reusableActions.getWhenReady(By.xpath("//ss-amount-field//ds-form-field//input")).sendKeys(strAmount);
	}
	
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param interac payment option to pay to buy Internet offer
	 * @author Mirza.Kamran
	 */
	public void selectHowWouldYouLikeToPay(ca.fido.test.helpers.FidoEnums.MakePayOptions enumPaymentOpt) {
		//writing the below element in method since we want to dynamically generate this at run time
		By rdoPaymentOptionLocater=By.xpath("//label[@for='"+enumPaymentOpt.toString()+"']/ins");		
		WebElement rdoPaymentOption=driver.findElement(rdoPaymentOptionLocater);
		reusableActions.javascriptScrollByVisibleElement(rdoPaymentOption);//(rdoPaymentOption);
		reusableActions.executeJavaScriptClick(rdoPaymentOption);
	}
	
	/**
	 * Click on  the Review And Continue button on the make payment page
	 * @author Aditya.Dhingra
	 */
	public void clkReviewAndContinueButton()
	{	
		Actions act=new Actions(driver);		
		act.moveToElement(reusableActions.getWhenReady(btnReviewAndContinue)).click().build().perform();
	   
	}
	
	/**
	 * Click on  the Paynow button on the make payment page
	 * @author Aditya.Dhingra
	 */
	public void clkPayNow()
	{		
		Actions act=new Actions(driver);
		act.moveToElement(reusableActions.getWhenReady(btnPayNow)).click().build().perform();

	}
	
	/**
	 * Click on  the Review And Continue button on the make payment page
	 * @author Aditya.Dhingra
	 */
	public void clkReviewAndContinueButtonMobile()
	{	
		reusableActions.getWhenReady(btnReviewAndContinue).click();
	   
	}
	
	/**
	 * Click on  the Paynow button on the make payment page
	 * @author Aditya.Dhingra
	 */
	public void clkPayNowMobile()
	{		
		reusableActions.getWhenReady(btnPayNow).click();

	}
	
	/**
	 * Clicks on the button pay on Interac Site
	 * @author Mirza.Kamran
	 */
	public void clkPayOnInteracSite()
	{	
		Actions act=new Actions(driver);
		act.moveToElement(reusableActions.getWhenReady(btnPayOntheInteracSite)).click().build().perform();

	}	
	
	/**
	 * Clicks on view payment history button
	 * @author Mirza.Kamran
	 */
	public void clkViewPaymentHistory() {
		reusableActions.clickWhenReady(btnPaymentHistory);
		
	}
	
	/**
	 * Gets the refernce Number after the  payment is successful
	 * @return reference number from payment successful
	 * @author Mirza.Kamran
	 */
	public String getRefNumber()	{
		return reusableActions.getWhenReady(lblRefrenceNumber).getText();
	}
	
	/**
	 * Verifes if the payment is successful label is displayed
	 * @return true if the label payment is successful label is displayed
	 * @author Mirza.Kamran
	 */
	public Boolean verifyPaymentSuccessfulMessageDisplayed() {
						
		if(! reusableActions.isElementVisible(lblPaymentReceived)) {
			System.out.print("The Label payment received is not displayed it seems, please investigate");
			return false;
		}
		if(! (reusableActions.getWhenVisible(lblRefrenceNumber).getText()!=null 
			|| reusableActions.getWhenVisible(lblRefrenceNumber).getText()!=""))
		{	
			System.out.print("The Label reference Number is either null or empty it seems, please investigate");
			return false;
		}
		return true;
	}

	/**
	 * Cliks on the link 'Payment history' on the transaction confirmation page
	 * @author Mirza.Kamran
	 */
	public void clkPaymentHistoryLinkOnConfirmationPage() {
		reusableActions.clickWhenReady(lnkPaymentHistoryOnConfirmationPageFooter);
	}
	
	/**
	 * Cliks on the link 'Payment history' on the transaction confirmation page
	 * @author Mirza.Kamran
	 */
	public void clkPaymentHistoryLinkOnConfirmationPageMobile() {
		reusableActions.clickWhenReady(lnkPaymentHistoryOnConfirmationPageFooterMobile);
	}
	
	/**
	 * verifies if the bank section is visible
	 * @return true if the back section is visible
	 */
	public boolean verifyBankSection() {		
		return reusableActions.isElementVisible(divBankPayment);
	}

	/**
	 * clicks on Button Close Make Payment
	 */
	public void closePayNowModal() {
		reusableActions.clickIfAvailable(btnCloseMakePayment);		
	}
	
	/**
	 * Verify if the make payment modal is displayed
	 * @return true if the make payment modal displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyPaymentModalIsDisplayed() {
		return reusableActions.isElementVisible(paymentModal, 10);
	}
	
	/**
	 * Selects the bank details
	 * @param strBankName string bank name
	 * @author Karthic.Hasan
	 */
	public void selectBank(String strBankName) {		
		By lblBankName= By.xpath("//img[@alt='"+strBankName+"']");
		reusableActions.executeJavaScriptClick(getDriver().findElement(lblBankName));
		reusableActions.waitForNumberOfWindowsToBe(2, 30);
		reusableActions.staticWait(3000);
	}
	
	/**
	 * Switch to the new window 
	 * @param strParentWindowHandle parent window handle
	 * @author Karthic.Hasan
	 */
	public void switchToCIBCBankPage(String strParentWindowHandle) {
		reusableActions.switchToNewWindow(strParentWindowHandle);
	}

	/**
	 * Verfies if the new bank page is open successfully
	 * @param strWindowTitle the bank page title
	 * @return true if title matches else false
	 * @author Karthic.Hasan
	 */
	public boolean verifyBankPageOpenedSuccessfully(String strWindowTitle) {		
		return getDriver().getTitle().contains(strWindowTitle);
	}
}

