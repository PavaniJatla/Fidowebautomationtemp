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

	@FindBy(xpath = "//h1[contains(text(),'Confirmation')]/parent::div")
	WebElement addonOrderConfirm;

	@FindBy(xpath = "//h1[contains(text(),'Confirmation')]/following::div[1]")
	WebElement addonOrderConfirmMessage;

	@FindBy(xpath = "//span[contains(@class,'ds-button__copy text-button') and contains(.,'Back to add-ons')]")
	WebElement backToAddonBtn;

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

	/**
	 * This method verify the Confirmation title on Confirmation Page
	 *  @return true if Confirmation title displayed; else false
	 * @author subash.nedunchezhian
	 */
	public boolean verifyAddonOrderConfirm(){
		return reusableActions.isElementVisible(addonOrderConfirm,20);
	}

	/**
	 * This method gets the Confirmation message on Confirmation Page
	 * @return String text of Confirmation message
	 * @author subash.nedunchezhian
	 */
	public String getOrderConfirmMsg(){
		reusableActions.waitForElementVisibility(addonOrderConfirm,20);
		return reusableActions.getWhenReady(addonOrderConfirmMessage).getText().replaceAll("\\n", "");
	}

	/**
	 * This method clicks on Back To Addon button on Confirmation Page
	 * @author subash.nedunchezhian
	 */
	public void clickBackToAddonBtn(){
		reusableActions.clickWhenReady(backToAddonBtn,10);
	}
}
