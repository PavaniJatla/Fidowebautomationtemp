package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoCartSummaryPage extends BasePageClass {

	public FidoCartSummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@id='edit-cart']")
	WebElement lnkShoppingCartEdit;
	
	@FindBy(xpath="//ins[@translate='global.cta.delete']")
	WebElement lnkShoppingCartDelete;
	
	@FindBy(xpath="//ins[@translate='global.cta.confirmRemoval']")
	WebElement btnConfirmRemovalOfCart;
	
	@FindBy(xpath="//ins[@translate='global.message.emptyCart']")
	WebElement infoEmptyCart;
	
	@FindBy(xpath="//ins[@translate='global.cta.checkout']")
	WebElement btnCheckout;
	
	@FindBy(xpath="//button[@class='checkout-button ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnInternetCheckout;
	
	@FindBy(xpath="//span[@checkout-res='checkout_continue']/parent::button")
	WebElement btnContinue;


	/**
	 * Clicks on the edit link on the cart Summary page
	 * @author chinnarao.vattam 
	 */
	public void clkShoppingCartEdit() {
		reusableActions.waitForElementVisibility(lnkShoppingCartEdit,90);
		reusableActions.clickWhenReady(lnkShoppingCartEdit,90);
	}
	
	/**
	 * Clicks on the delete link on the cart Summary page
	 * @author chinnarao.vattam 
	 */
	public void clkShoppingCartDelete() {
		reusableActions.getWhenReady(lnkShoppingCartDelete, 30).click();
	}
	
	/**
	 * Clicks on the confirm removal button on the cart Summary page
	 * @author chinnarao.vattam 
	 */
	public void clkConfirmRemovalOfCart() {
		reusableActions.clickWhenReady(btnConfirmRemovalOfCart, 10);
	}
	
	/**
	 * Verify the  "your cart is empty" text on the cart Summary page
	 * @return true, if the cart Summary page has "your cart is empty" text, else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyEmptyCart() {
		return reusableActions.isElementVisible(infoEmptyCart);
	}
	
	/**
	 * Clicks on checkout button on the cart Summary page
	 * @author chinnarao.vattam 
	 */
	public void clkCheckout() {
		reusableActions.getWhenReady(btnCheckout, 90).click();
	}
	
	/**
	 * Clicks on checkout button on the cart Summary page
	 * @author chinnarao.vattam 
	 */
	public void clkInternetCheckout() {
		reusableActions.getWhenReady(btnInternetCheckout, 90).click();
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue,60);
	}
}