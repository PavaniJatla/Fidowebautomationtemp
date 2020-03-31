package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoOrderConfirmationPage extends BasePageClass {

	public FidoOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath ="//ins[@translate='global.label.orderConfirmation']")
	WebElement infoOrderConfirm;
	
	@FindBy(xpath="//div[contains(@class,'thanksForOrder')]//span[contains(@checkout-res,'checkout_thank_you')]")
	WebElement lblThankYou;

	/**
	 * Verify the coder completion by verifying the confirmation message
	 * @return true, if the Order confirmation page display the confirmation message, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyOrderConfirm() {
		  return reusableActions.isElementVisible(infoOrderConfirm, 40);
	}
	
	/**
	 * Validates whether the 'THANKS FOR YOUR ORDER!' message is displayed at the end of the flow
	 * @return true if message displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyThankYou() {
		return reusableActions.isElementVisible(lblThankYou, 100);
	}

}
