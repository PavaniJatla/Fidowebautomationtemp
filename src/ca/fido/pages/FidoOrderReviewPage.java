package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class FidoOrderReviewPage extends BasePageClass {

	public FidoOrderReviewPage(WebDriver driver) {
		super(driver);		
	}
	
	//@FindBy(xpath="//div[contains(@class,'agreement-checkbox')")
	//@FindBy(xpath="//div[contains(@class,'terms-checkbox')]")
	@FindBy(xpath="//label[@for='terms1']")
	WebElement lblTermsNConditionsConsent;
	
	@FindBy(xpath="//div[@class='ds-terms-conditions__consent']//div[@class='ds-checkbox__box my-12']")
	List<WebElement> termsCheckBoxes;
	
	@FindBy(xpath="//div[contains(@class,'ds-checkbox__box my')]")
	WebElement chkBoxTermsNConditionsConsentAAL;
	
	@FindBy(xpath="//label[@for='physical-copy']")
	WebElement lblContractPhysicalCopy;
	
	//@FindBy(xpath="//label[@for='digital-copy']")
	//@FindBy(xpath = "//label[@for='digital-copy' or @for='ds-radio-input-id-2']")
	
	@FindAll({
		@FindBy(xpath = "//div[@class='ds-terms-conditions__consent']//following-sibling::div//input[@id='ds-radio-input-id-11']//ancestor::ds-radio-button//div[@class='ds-radioButton__innerCircle']"),
		@FindBy(xpath = "//label[@for='digital-copy' or @for='ds-radio-input-id-2']"),
		@FindBy(xpath = "//ds-radio-button[@class='ds-radioButton']//label[@for='ds-radio-input-id-19']//div[@class='ds-radioButton__innerCircle']")
	})
	WebElement lblContractDigitalCopy;
	
	@FindBy(xpath="//span[@translate='btn_continue_to_payment']//parent::button")
	WebElement btnContinueToPayment;
	
	@FindBy(xpath="//p[@class='msgLoad' and @checkout-res='checkout_waiting_msg']")
	WebElement lblOrderProcessing;
	
	//span[@translate='btn_complete_order' or @translate='btn_continue_to_payment'  ]/parent::button
	@FindBy(xpath="//span[@translate='btn_complete_order' or @translate='btn_continue_to_payment']/parent::button")
	WebElement btnCompleteOrder;
	
	//@FindBy(xpath="//input[@id='email']")
	@FindBy(xpath="//input[@id='email' or @id='ds-form-input-id-4']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_step_pay']")
	WebElement lblPaymentStep;
	
	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnSubmitMyOrder;
	
	
	/**
	 * Clicks on the 'Submit my order' button
	 * @author Saurav.Goyal
	 */
	public void clkSubmitMyOrder() {
		reusableActions.clickWhenReady(btnSubmitMyOrder);
		//reusableActions.waitForElementVisibility(btnSubmitMyOrder, 60);
	}
	
	/**
	 * Verify the check box for terms and conditions consent
	 * @return boolean true if the element is present else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyCheckBoxTermsAndCondition() {
		if(reusableActions.isElementVisible(chkBoxTermsNConditionsConsentAAL, 60))
			return true;
		else
			return false;
	}
	
	/**
	 * Clicks on the Terms and Conditions checkbox for AAL
	 * @author Saurav.Goyal
	 */
	public void clkTermsNConditionsConsentAAL() {
		reusableActions.clickWhenVisible(chkBoxTermsNConditionsConsentAAL, 60);
	}
	
	/**
	 * Clicks on the Terms and Conditions checkbox
	 * @author rajesh.varalli1
	 */
	public void clkTermsNConditionsConsent() {
			reusableActions.clickWhenVisible(lblTermsNConditionsConsent, 60);
	}
	
	/**
	 * Clicks on all 'Terms and Agreement' checkbox for NAC flow
	 * @author Saurav.Goyal
	 */
	public void clkAllTermsAgreementCheckboxsNAC() {
		reusableActions.waitForAllElementsVisible(termsCheckBoxes, 60);
		for(WebElement element:termsCheckBoxes) {
			reusableActions.waitForElementVisibility(element, 30);
			reusableActions.clickWhenReady(element,30);
		}
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
		if(reusableActions.isElementVisible(txtEmailAddress,10)) {
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
			reusableActions.waitForElementVisibility(lblOrderProcessing, 60);
		}
	}
	
	/**
	 * Clicks on the 'COMPLETE ORDER' button
	 * @author rajesh.varalli1
	 */
	public void clkCompleteOrder() {
		reusableActions.clickWhenReady(btnCompleteOrder,30);
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