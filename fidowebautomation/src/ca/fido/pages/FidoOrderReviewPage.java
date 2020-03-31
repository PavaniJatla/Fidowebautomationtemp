package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoOrderReviewPage extends BasePageClass {

	public FidoOrderReviewPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//div[contains(@class,'agreement-checkbox')]//label")
	WebElement lblTermsNConditionsConsent;
	
	@FindBy(xpath="//label[@for='physical-copy']")
	WebElement lblContractPhysicalCopy;
	
	@FindBy(xpath="//label[@for='digital-copy']")
	WebElement lblContractDigitalCopy;
	
	@FindBy(xpath="//span[@translate='btn_continue_to_payment']//parent::button")
	WebElement btnContinueToPayment;
	
	@FindBy(xpath="//p[@class='msgLoad' and @checkout-res='checkout_waiting_msg']")
	WebElement lblOrderProcessing;
	
	@FindBy(xpath="//span[@translate='btn_complete_order']/parent::button")
	WebElement btnCompleteOrder;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_step_pay']")
	WebElement lblPaymentStep;
	
	/**
	 * Clicks on the Terms and Conditions checkbox
	 * @author rajesh.varalli1
	 */
	public void clkTermsNConditionsConsent() {
		reusableActions.clickWhenVisible(lblTermsNConditionsConsent, 120);
	}
	
	/**
	 * Clicks on the 'Mail a physical copy to my billing address' option for Contract
	 * @author rajesh.varalli1
	 */
	public void setContractPhysicalCopyMail() {
		reusableActions.clickWhenReady(lblContractPhysicalCopy);
	}
	
	/**
	 * Clicks on the 'Email a digital copy to ' option for Contract
	 * @author rajesh.varalli1
	 */
	public void setContractDigitalCopyEmail() {
		reusableActions.clickWhenReady(lblContractDigitalCopy);
	}
	
	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @param strEmail of customer
	 * @author rajesh.varalli1
	 */
	public void setContractDigitalCopyEmail(String strEmail) {
		reusableActions.clickWhenReady(lblContractDigitalCopy);
		if(reusableActions.isElementVisible(txtEmailAddress,1)) {
			txtEmailAddress.sendKeys(strEmail);
		}
	}
	
	/**
	 * Clicks on the 'Continue to Payment' button
	 * @author rajesh.varalli1
	 */
	public void clkContinueToPayment() {
		reusableActions.staticWait(2000);
		reusableActions.clickWhenReady(btnContinueToPayment);
	}
	
	/**
	 * Waits until the Order processing is complete
	 * @author rajesh.varalli1
	 */
	public void waitForOrderProcessing() {
		if(reusableActions.isElementVisible(lblOrderProcessing)) {
			reusableActions.waitForElementVisibility(lblOrderProcessing, 120);
		}
	}
	
	/**
	 * Clicks on the 'COMPLETE ORDER' button
	 * @author rajesh.varalli1
	 */
	public void clkCompleteOrder() {
		reusableActions.clickWhenReady(btnCompleteOrder);
	}
	
	/**
	 * Determines if payment is required or not
	 * @return true if 'Payment' appears in the Steps above; else false
	 * @author rajesh.varalli1
	 */
	public boolean isPaymentRequired() {
		return reusableActions.isElementVisible(lblPaymentStep, 1);
	}
}