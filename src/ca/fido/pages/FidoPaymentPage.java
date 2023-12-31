package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class FidoPaymentPage extends BasePageClass {

	public FidoPaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[text()='Payment Details']")
	WebElement headerPaymentDetails;

	@FindBy(xpath = "//label[@for='Creditcard']/ins")
	WebElement rdoCreditCardOption;

	@FindBy(xpath = "//button[@aria-label='Automatic Payments']")
	WebElement rdoBankOption;

	@FindAll({
	@FindBy(xpath = "//a[@title='Account Overview']"),
	@FindBy(xpath = "//div[@class='modal-header hidden-xs']//button[@class='close square-close-icon']")})
	WebElement btnClosePayment;

	@FindBy(xpath = "//iframe[contains(@src,'semafone')]")
	WebElement fraSemaphone;
	//div[@class='cc-payment-section']//descendant::iframe

	@FindBy(xpath = "//input[contains(@aria-label,'Enter Payment Amount')]|//input[contains(@aria-label,'$')]")
	WebElement txtPaymentAmount;
	//div[@class='ute-pay-now-content ss-pay-now-payment-amount']//input[@id='amount']

	@FindBy(xpath = "//input[@id='pan']")
	WebElement 	txtCreditCardNumber;

	@FindBy(xpath = "//select[@id='expiry-date']")
	WebElement ddlExpiryMonth;
	//select[@id='expiry-date']

	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex position-relative ds-bgcolor-white ds-borders ng-tns-c106-7 ds-brcolor-black ds-color-black']")
	WebElement ddlExpiryDateContainer;

	@FindBy(xpath = "//input[@id='expiryDate' and @formcontrolname='expiryDate']")
	WebElement ddlExpiryDate;

	@FindBy(xpath  = "//select[@name='expYear']")
	WebElement ddlExpiryYear;

	@FindBy(xpath = "//input[@id='cvc' and @formcontrolname='cvc']/..")
	WebElement txtCvvContainer;

	@FindBy(xpath = "//input[@id='cvc' and @formcontrolname='cvc']")
	WebElement txtCVV;
	//input[@id='cvv']

	@FindBy(xpath = "//div[@class='d-flex flex-column flex-md-row justify-content-end mb-8']/button[contains(@class,'ds-button')]")
	WebElement btnReviewAndContinue;
	//input[@type="submit" and contains(@class,'continue')]

	@FindAll({
	@FindBy(xpath = "//div[contains(@class,'pay-now-button-primary')]/ins[@translate = \"global.cta.payNow\"]"),
	@FindBy(xpath = "//button[contains(@class,'w-100 w-sm-auto mr-md-24 mt-16 ds-button')]/span")})
	WebElement btnPayNow;

	@FindBy(xpath = "//span[contains(@class,'ds-color-success')]")
	WebElement msgPaymentConfirmation;
	//ins[@translate='global.label.paymentConfirmationHeading']

	@FindBy(xpath = "//a[@aria-label='Finish and return to your Overview dashboard']")
	WebElement btnPaymentConfirmation;
	//button[contains(@class,'col-xs-12 pay-now-button-secondary uppercase ds-button')]
	@FindBy(xpath = "//a[@aria-label='Finish and return to your Overview dashboard']")
	WebElement btnPaymentConfirmationMobile;

	@FindAll({
		@FindBy(xpath="//iframe[@id='sema']"),
		@FindBy(xpath="//div[contains(@class,'iframe')]//iframe")
	})
	WebElement frmCreditCard;
	
	@FindBy(xpath="//input[@id='maskedPan']")
	WebElement txtCreditCardNumberMasked;
	
	@FindBy(xpath="//input[@id='pan']")
	WebElement txtCreditCardNumberUnMasked;
	
	@FindBy(xpath="//select[@name='month']")
	WebElement ddlCreditCardExpiryMonth;
	
	@FindBy(xpath="//select[@name='year']")
	WebElement ddlCreditCardExpiryYear;
	
	@FindBy(xpath="//input[@id='securityCode']")
	WebElement txtCreditCardCVV;
	
	@FindBy(xpath="//span[@translate='btn_complete_order']/parent::button")
	WebElement btnCompleteOrder;

	@FindBy(xpath="//div[@class='d-flex flex-column flex-md-row justify-content-end mt-24 mb-8']/button/span")
	WebElement btnContinue;

	@FindBy(xpath="//input[@id='ds-radio-input-id-21']/parent::label//div[@class='ds-radioButton__outerCircle my-12']")
	WebElement rdoPayWithAnotherCC;
	
	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnSubmitMyOrder;
	
	@FindAll({
		@FindBy(xpath="//select[@name='month']"),
		@FindBy(xpath="//input[@formcontrolname='expiryDate']/parent::div")
	})
	WebElement ddlCreditCardExpiryMonthAndYear;
	
	@FindBy(xpath="//input[@formcontrolname='expiryDate']")
	WebElement lblDdlCreditCardExpiryMonthAndYear;
	
	@FindBy(xpath="//input[@formcontrolname='cvv']/parent::div")
	WebElement creditCardCvv;
	
	@FindBy(xpath="//input[@formcontrolname='cvv']")
	WebElement lblCreditCardCvv;
	
	@FindBy(xpath="//input[@formcontrolname='name']/parent::div")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@formcontrolname='name']")
	WebElement lblTxtFirstName;

	@FindBy(xpath = "//h1[@id='bfa-page-title' and contains(text(),'One Time Payment')]")
	WebElement otpPage;

	@FindBy(xpath = "//h1[@id='bfa-page-title' and contains(text(),'One Time Payment')]/following::div[@class='ds-price'][1]")
	WebElement otpAmount;

	/**
	 * verifies if Payment Details page is loaded correctly - by validating header
	 */
	public Boolean verifyPaymentDetailsPage() {
		reusableActions.waitForElementVisibility(headerPaymentDetails, 20);
		return reusableActions.isElementVisible(headerPaymentDetails);
	}

	/**
	 * Set the dynamic Name on the credit card
	 * @author Saurav.Goyal
	 */
	public void setCreditCardName(){
		String strName = FormFiller.generateRandomName();
		String strFname="Fido"+ strName;
		reusableActions.getWhenReady(txtFirstName, 3).click();
		reusableActions.getWhenReady(lblTxtFirstName,3).sendKeys(strFname);
	}
	
	/**
	 * Enter Credit Card Expiry month and year 
	 * @param monthAndYear in numbers like 0112,0212,....,1212
	 * @author Saurav.Goyal
	 */
	public void setCreditCardExpiryMonthAndYear(String monthAndYear) {
		reusableActions.getWhenReady(ddlCreditCardExpiryMonthAndYear, 10).click();
		reusableActions.getWhenReady(lblDdlCreditCardExpiryMonthAndYear,10).sendKeys(monthAndYear);
	}
	
	/**
	 * Enter Credit Card cvv number
	 * @param cvv in numbers like 011
	 * @author Saurav.Goyal
	 */
	public void setCreditCardCvv(String cvv) {
		reusableActions.getWhenReady(creditCardCvv, 10).click();
		reusableActions.getWhenReady(lblCreditCardCvv,10).sendKeys(cvv);
	}	
	
	/**
	 * Clicks on the 'Submit my order' button
	 * @author Saurav.Goyal
	 */
	public void clkSubmitMyOrder() {
		reusableActions.clickWhenReady(btnSubmitMyOrder);
		//reusableActions.waitForElementVisibility(btnSubmitMyOrder, 60);
	}
	
	/**
	 * Selects pay with another Credit card option radio button on the one time payment page
	 * @author Saurav.Goyal
	 */
	public void clkRadioPayWithAnotherCreditCard() {		
		reusableActions.getWhenReady(rdoPayWithAnotherCC,30).click();
	}
	
	/**
	 * Selects the Credit card option radio button on the payment page
	 * @author Aditya.Dhingra
	 */
	public void selectCreditCardOption() {
		reusableActions.getWhenReady(rdoCreditCardOption,20).click();
	}

	/**
	 * Selects the Credit card option radio button on the payment page
	 * @author Aditya.Dhingra
	 */
	public void selectBankOption() {
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenReady(rdoBankOption,20).click();
	}

	/**
	 * Selects the Credit card option radio button on the payment page
	 * @author Aditya.Dhingra
	 */
	public void clkClosePayments() {
		reusableActions.getWhenReady(btnClosePayment,20).click();
	}

	/**
	 * Set the payment amount on the payment page
	 * @param strPaymentAmount amount to be paid to buy the offer
	 * @author  Aditya.Dhingra
	 */
	public void setPaymentAmount(String strPaymentAmount) {
		reusableActions.getWhenReady(txtPaymentAmount,60).click();
		int len = 6;
		while(len > 0) {
			reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
			len--;
		}

		reusableActions.getWhenReady(txtPaymentAmount,5).sendKeys(strPaymentAmount);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.TAB);
	}

	/**
	 * Set the payment amount on the payment page
	 * @param strPaymentAmount amount to be paid to buy the offer
	 * @author  Aditya.Dhingra
	 */
	public void setPaymentAmountMobile(String strPaymentAmount) {
		reusableActions.getWhenReady(txtPaymentAmount,60).click();
		reusableActions.getWhenReady(txtPaymentAmount,5).clear();
		reusableActions.getWhenReady(txtPaymentAmount,5).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount,5).sendKeys(strPaymentAmount);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.TAB);
	}
	/**
	 * Set the credit card at semaphone frame on the payment page
	 * @param strCreditCard number of the credit card
	 * @author  Aditya.Dhingra
	 */
	public void setCreditCardNumberIFrame(String strCreditCard) {
		driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone));
		reusableActions.getWhenVisible(txtCreditCardNumber).click();
		reusableActions.getWhenReady(txtCreditCardNumber).sendKeys(strCreditCard);
		driver.switchTo().defaultContent();
	}

	/**
	 * Set the credit card at semaphone frame on the payment page
	 * @param strCreditCard number of the credit card
	 * @author  Aditya.Dhingra
	 */
	public void setCreditCardNumberIFrameMobile(String strCreditCard) {
		driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone));
		reusableActions.getWhenReady(txtCreditCardNumber).sendKeys(strCreditCard);
		driver.switchTo().defaultContent();
	}
	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV  CVV for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void setCVVNumber(String strCVV) {
		reusableActions.clickWhenVisible(txtCvvContainer);
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV  CVV for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void setCVVNumberMobile(String strCVV) {
		reusableActions.executeJavaScriptClick(txtCvvContainer);
		reusableActions.executeJavaScriptClick(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}
	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @param strMM expire month for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void selectExpiryMonth(String strMM) {
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @param strDATE expire month for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void selectExpiryDate(String strDATE) {
	//	reusableActions.executeJavaScriptClick(ddlExpiryDateContainer);
	//	reusableActions.executeJavaScriptClick(ddlExpiryDate);

		reusableActions.getWhenReady(ddlExpiryDate).sendKeys(strDATE);
		//reusableActions.selectWhenReady(ddlExpiryDate, strDATE);
	}

	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @param strMM expire month for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void selectExpiryMonthMobile(String strMM) {
		reusableActions.waitForElementVisibility(ddlExpiryMonth,20);
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}
	
	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void selectExpiryYear(String strYYYY) {
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void selectExpiryYearMobile(String strYYYY) {
		reusableActions.waitForElementVisibility(ddlExpiryYear,20);
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * clicks review and Continue button
	 * @author Mirza.Kamran
	 */
	public void clkReviewAndContinue() {
		//reusableActions.getWhenVisible(btnReviewAndContinue,30).sendKeys(Keys.ENTER);
		reusableActions.executeJavaScriptClick(btnReviewAndContinue);
	}
	
	/**
	 * Clicks on the pay now button
	 * @author Mirza.Kamran
	 */
	public void clkPayNow() {
		reusableActions.getWhenReady(btnPayNow,20).click();
	}
	
	/**
	 * Verifies Payment confirmation message is visible
	 * @return true if the message is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyPaymentConfirmation() {
		return reusableActions.isElementVisible(msgPaymentConfirmation,30);
		
	}

	/**
	 * Validated the credit card is valid or not
	 * @param strCCNumber Credit card number
	 * @param strCardType Credit card type
	 * @return true if the card is selected successfully else false
	 */
	public boolean validateCC(String strCCNumber, String strCardType){
		String ccType = null;
		if (strCardType == "MC")
			ccType = "imgMc";
		if (strCardType == "VI")
			ccType = "imgVisa";
		if (strCardType == "AX")
			ccType = "imgAmex";

		driver.switchTo().frame(fraSemaphone);
		reusableActions.clickWhenVisible(txtCreditCardNumber);
		txtCreditCardNumber.sendKeys(strCCNumber);
		reusableActions.staticWait(10000);
		driver.switchTo().defaultContent();
		if (reusableActions.getWhenReady(By.xpath("//img[@id='" + ccType + "']")).getAttribute("class").equals("card_selected"))
			return true;
		else
			return false;
	}
	
	/**
	 * Clicks on the payment confirmation button
	 * @author chinnarao.vattam
	 */
	public void clkPaymentConfirmation() {
		reusableActions.getWhenReady(btnPaymentConfirmation,60).click();
	}
	
	/**
	 * Clicks on the payment confirmation button mobile
	 * @author chinnarao.vattam
	 */
	public void clkPaymentConfirmationMobile() {
		reusableActions.getWhenReady(btnPaymentConfirmationMobile,60).click();	
	}
	
	/**
	 * Enters the Credit Card Number
	 * @param strCCNum Credit Card Number
	 * @param strCCMth Credit Card Expiry Month
	 * @param strCCYr Credit Card Expiry Year
	 * @param strCVV Credit Card Security Code or CVV
	 * @author rajesh.varalli1
	 */
	public void setCreditCardDetails(String strCCNum, String strCCMth, String strCCYr, String strCVV) {
		driver.switchTo().frame(frmCreditCard);
		reusableActions.staticWait(5000);
		txtCreditCardNumberMasked.click();
		txtCreditCardNumberUnMasked.click();
		txtCreditCardNumberUnMasked.sendKeys(strCCNum);
		driver.switchTo().defaultContent();
		
		reusableActions.selectWhenReady(ddlCreditCardExpiryMonth, strCCMth);
		
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCardExpiryYear, strCCYr);
		
		txtCreditCardCVV.sendKeys(strCVV);
	}
	
	/**
	 * Enters the Credit Card Number
	 * @param ccNumber Credit Card Number
	 * @author rajesh.varalli1
	 */
	public void setCreditCardNumber(String ccNumber) {
		driver.switchTo().frame(frmCreditCard);
		reusableActions.staticWait(5000);
		txtCreditCardNumber.click();
		txtCreditCardNumber.sendKeys(ccNumber);
		driver.switchTo().defaultContent();//checkout-res="checkout_credit_card_number"
	}
	
	/**
	 * Clicks on the 'COMPLETE ORDER' button
	 * @author rajesh.varalli1
	 */
	public void clkContinueOrder() {
		reusableActions.clickWhenReady(btnCompleteOrder);
	}

	/**
	 * Continue to proceed payment
	 * @author manpreet.kaur3
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue);
	}

	/**
	 * Verify the onetime payment page is getting displayed
	 * @return true if onetime payment page displayed else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyOneTimePaymentTitle() {
		reusableActions.waitForElementVisibility(otpPage,30);
		return reusableActions.isElementVisible(otpPage, 10);
	}

	/**
	 * This method gets One Time Payment Amount in OTP page
	 * @return One Time Payment Amount in OTP page
	 * @author subash.nedunchezhian
	 */
	public String getOneTimePaymentAmount(){
		reusableActions.scrollToElement(otpAmount);
		return otpAmount.getText().replaceAll("\\n", "");
	}
}
