package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FidoCartSummaryPage extends BasePageClass {

	public FidoCartSummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@id='edit-cart']")
	WebElement lnkShoppingCartEdit;
	
	@FindBy(xpath="//ins[@translate='global.cta.delete']")
	WebElement lnkShoppingCartDelete;
	
	@FindBy(xpath="//a[contains(@title,'Remove Fido Internet')]")
	WebElement btnConfirmRemovalOfCart;
	
	
	@FindBy(xpath="//ins[@translate='global.message.emptyCart']")
	WebElement infoEmptyCart;
	
	@FindBy(xpath="//div[@class='summary-containter']")
	WebElement infoSummaryCart;
		
	@FindBy(xpath="//div[@class='ng-star-inserted']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']")
	WebElement btnConfiramRemoval;
	
	
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
		reusableActions.getWhenReady(btnConfirmRemovalOfCart, 30).click();
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
	 * Verify the  "your cart is empty" text on the cart Summary page
	 * @return true, if the cart Summary page has "your cart is empty" text, else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifySummaryCart() {
		return reusableActions.isElementVisible(infoSummaryCart,30);
	}
	
	/**
	 * Clicks on checkout button on the cart Summary page
	 * @author chinnarao.vattam 
	 */
	public void clkConfiramRemoval() {
		reusableActions.getWhenReady(btnConfiramRemoval, 20).click();
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
		reusableActions.getWhenReady(btnInternetCheckout, 120).click();
	}

	/**
	 * Clicks on checkout button on the cart Summary page
	 * @author chinnarao.vattam
	 */
	public void clkInternetCheckoutMobile() {
		reusableActions.waitForElementVisibility(btnInternetCheckout,120);
		reusableActions.executeJavaScriptClick(btnInternetCheckout);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue,60);
	}
}