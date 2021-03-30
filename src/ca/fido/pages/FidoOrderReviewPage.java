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

	@FindBy(xpath="(//ds-price[contains(@class,'d-inline-flex text-left ng-star-inserted')])[3]/div")
	WebElement oneTimePaymentPrice;
	
	//@FindBy(xpath="//div[contains(@class,'agreement-checkbox')")
	//@FindBy(xpath="//div[contains(@class,'terms-checkbox')]")
	@FindBy(xpath="//label[@for='dsa-terms-conditions-0-consent-0']")
	WebElement lblTermsNConditionsConsent;
	
	@FindBy(xpath="//div[@class='ds-terms-conditions__consent']//div[@class='ds-checkbox__box my-12']")
	List<WebElement> termsCheckBoxes;
	
	@FindBy(xpath="//div[contains(@class,'ds-checkbox__box my')]")
	WebElement chkBoxTermsNConditionsConsentAAL;
	
	@FindBy(xpath="//label[@for='physical-copy']")
	WebElement lblContractPhysicalCopy;

	@FindAll({
			@FindBy(xpath="//h1[@id='bfa-page-title']"),
			@FindBy(xpath="//span[@translate='hup_page_title_for.review']"),
			@FindBy(xpath="//span[@checkout-res='checkout_review_order']")
	})
	WebElement lblReviewPage;
	
	//@FindBy(xpath="//label[@for='digital-copy']")
	//@FindBy(xpath = "//label[@for='digital-copy' or @for='ds-radio-input-id-2']")
	
	@FindAll({
		@FindBy(xpath = "//div[@class='ds-terms-conditions__consent']//following-sibling::div//input[@id='ds-radio-input-id-11']//ancestor::ds-radio-button//div[@class='ds-radioButton__innerCircle']"),
		@FindBy(xpath = "//label[@for='digital-copy' or @for='ds-radio-input-id-2']"),
		@FindBy(xpath = "//ds-radio-button[@class='ds-radioButton']//label[@for='ds-radio-input-id-19']//div[@class='ds-radioButton__innerCircle']")
	})
	WebElement lblContractDigitalCopy;

	@FindAll({
			@FindBy(xpath = "//input[contains(@id,'ds-checkbox-id')]//following-sibling::div[contains(@class,'ds-checkbox__box')]"),
			@FindBy(xpath = "//input[contains(@id,'ds-radio-input-id-19')]//following-sibling::div[contains(@class,'ds-radioButton__outer')]"),
			@FindBy(xpath = "//input[contains(@id,'ds-radio-input-id-6')]//following-sibling::div[contains(@class,'ds-radioButton__outer')]")
	})
	WebElement chkBoxOrderCommunicationConsent;

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

	/*@FindBy(xpath = "(//div[contains(@class,'ds-price__amountDollars')])[3]//ancestor::div[2]")
	WebElement oneTimePayment;*/

	@FindBy(xpath = "//h1[@id]")
	WebElement oneTimePaymentText;
	
	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnSubmitMyOrder;

	@FindAll({
			@FindBy(xpath = "//label[@for='terms1']"),
			@FindBy(xpath = "//input[@name='agreementConsent']//following-sibling::div[contains(@class,'ds-checkbox__box my')]")
	})
	WebElement chkBoxAgreementConsent;

	@FindBy(xpath = "//input[@name='financingConsent']//following-sibling::div[contains(@class,'ds-checkbox__box my')]")
	WebElement chkBoxFinancingConsent;

	/**
	 * Clicks on the 'Submit my order' button
	 * @author Saurav.Goyal
	 */
	public void clkSubmitMyOrder() {
		reusableActions.clickWhenReady(btnSubmitMyOrder , 30);
	}
	
	/**
	 * Verify the check box for terms and conditions consent
	 * @return boolean true if the element is present else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyReviewPageLabel() {
		 return reusableActions.isElementVisible(lblReviewPage, 60);
	}
	
	/**
	 * Clicks on the Terms and Conditions checkbox for AAL
	 * @author Saurav.Goyal
	 */
	public void clkTermsNConditionsConsentAAL() {
		reusableActions.clickWhenVisible(chkBoxTermsNConditionsConsentAAL, 60);
	}

	/**
	 * Clicks on the Terms and Conditions checkbox financing concent
	 * @author Saurav.Goyal
	 */
	public void clkTermsNConditionsFinancingConsent() {
		reusableActions.clickWhenVisible(chkBoxFinancingConsent, 60);
	}

	/**
	 * Clicks on the Terms and Conditions checkbox agreement consent
	 * @author Saurav.Goyal
	 */
	public void clkTermsNConditionsAgreementConsent() {
		reusableActions.clickWhenVisible(chkBoxAgreementConsent , 60);
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
	 * Clicks on the checkbox order communication consent
	 * @author Saurav.Goyal
	 */
	public void setOrderCommunicationConsent() {
		reusableActions.clickWhenReady(chkBoxOrderCommunicationConsent , 30);
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
		if(reusableActions.isElementVisible(lblOrderProcessing , 60)) {
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
		//return reusableActions.isElementVisible(lblPaymentStep, 1);
		return reusableActions.isElementVisible(oneTimePaymentText,10);
	}

	/**
	 * Determines if payment is required or not
	 * @return true if 'Payment' appears in the Steps above; else false
	 * @author rajesh.varalli1
	 *//*
	public boolean isOneTimePaymentRequired() {
		String oneTimeValue = oneTimePayment.getAttribute("aria-label");
		Long payment = Long.parseLong(oneTimeValue);
		if (payment > 0) {
			return true;
		} else {
			return false;
		}

	}*/

}