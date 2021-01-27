package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class FidoOrderConfirmationPage extends BasePageClass {

	public FidoOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	@FindAll({
		@FindBy(xpath ="//ins[@translate='global.label.orderConfirmation']"),
		@FindBy(xpath ="//h1[@id='bfa-page-title']")
	})	
	WebElement infoOrderConfirm;
	
	//@FindBy(xpath="//div[contains(@class,'thanksForOrder')]//span[contains(@checkout-res,'checkout_thank_you')]")
	@FindAll({
		@FindBy(xpath="//div[contains(@class,'thanksForOrder')]//span[contains(@checkout-res,'checkout_thank_you')]"),
		@FindBy(xpath="//h1[text()='THANKS FOR YOUR ORDER!' or text()='MERCI POUR VOTRE COMMANDE!']"),
		@FindBy(xpath="//p[text()='Thank you for your order!' or text()='Merci pour votre commande!']"),
		@FindBy(xpath="//*[contains(text(),'Order Confirmation') or contains(text(),'Confirmation de commande')]")
	})
	WebElement lblThankYou;

	/**
	 * Verify the coder completion by verifying the confirmation message
	 * @return true, if the Order confirmation page display the confirmation message, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyOrderConfirm() {
		  return reusableActions.isElementVisible(infoOrderConfirm, 60);
	}
	
	/**
	 * Validates whether the 'THANKS FOR YOUR ORDER!' message is displayed at the end of the flow
	 * @return true if message displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyThankYou() {
		return reusableActions.isElementVisible(lblThankYou, 60);
	}
}
