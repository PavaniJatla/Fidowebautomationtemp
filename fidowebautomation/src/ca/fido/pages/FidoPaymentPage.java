package ca.fido.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;



public class FidoPaymentPage extends BasePageClass {

	public FidoPaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[@for='Creditcard']/ins")
	WebElement rdoCreditCardOption;

	@FindBy(xpath = "//div[@class='cc-payment-section']//descendant::iframe")
	WebElement fraSemaphone;

	@FindBy(id = "amount")
	WebElement txtPaymentAmount;

	@FindBy(name = "pan")
	WebElement txtCreditCardNumber;

	@FindBy(id = "expiry-date")
	WebElement ddlExpiryMonth;

	@FindBy(name = "expYear")
	WebElement ddlExpiryYear;

	@FindBy(id = "cvv")
	WebElement txtCVV;

	@FindBy(xpath = "//input[@type=\"submit\" and contains(@class,'continue')]")
	WebElement btnReviewAndContinue;

	@FindBy(xpath = "//div[contains(@class,'pay-now-button-primary')]/ins[@translate = \"global.cta.payNow\"]")
	WebElement btnPayNow;

	@FindBy(xpath = "//ins[@translate='global.label.paymentConfirmationHeading']")
	WebElement msgPaymentConfirmation;
	
	@FindBy(xpath = "//button[contains(@class,'pay-now-button-secondary uppercase col-md')]")
	WebElement btnPaymentConfirmation;
	   
	@FindBy(xpath="//iframe[@id='sema']")
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
	
	/**
	 * Selects the Credit card option radio button on the payment page
	 * @author Aditya.Dhingra
	 */
	public void selectCreditCardOption() {
		reusableActions.getWhenReady(rdoCreditCardOption,20).click();
	}
	
	/**
	 * Set the payment amount on the payment page
	 * @param strPaymentAmount amount to be paid to buy the offer
	 * @author  Aditya.Dhingra
	 */
	public void setPaymentAmount(String strPaymentAmount) {
		reusableActions.clickWhenVisible(txtPaymentAmount,60);
		reusableActions.getWhenReady(txtPaymentAmount).clear();
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.BACK_SPACE);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(strPaymentAmount);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.TAB);
		reusableActions.getWhenReady(txtPaymentAmount).sendKeys(Keys.TAB);
	}
	
	/**
	 * Set the credit card at semaphone frame on the payment page
	 * @param strCreditCard number of the credit card
	 * @author  Aditya.Dhingra
	 */
	public void setCreditCardNumberIFrame(String strCreditCard) {
		driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone));
		reusableActions.clickWhenVisible(txtCreditCardNumber);
		reusableActions.getWhenReady(txtCreditCardNumber).sendKeys(strCreditCard);
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV  CVV for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void setCVVNumber(String strCVV) {
		reusableActions.clickWhenVisible(txtCVV);
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
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author  Aditya.Dhingra
	 */
	public void selectExpiryYear(String strYYYY) {
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}
	
	/**
	 * clicks review and Continue button
	 * @author Mirza.Kamran
	 */
	public void clkReviewAndContinue() {
		reusableActions.getWhenVisible(btnReviewAndContinue).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Clicks on the pay now button
	 * @author Mirza.Kamran
	 */
	public void clkPayNow() {
		reusableActions.getWhenReady(btnPayNow).click();
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
	 * @author Mirza.Kamran
	 */
	public void clkPaymentConfirmation() {
		reusableActions.getWhenReady(btnPaymentConfirmation,60).click();
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
	 * Clicks on the 'COMPLETE ORDER' button
	 * @author rajesh.varalli1
	 */
	public void clkContinueOrder() {
		reusableActions.clickWhenReady(btnCompleteOrder);
	}
	
}
