package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;



public class FidoShippingPage extends BasePageClass {

	public FidoShippingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@checkout-res='checkout_billing_address']")
	WebElement lblHomeAddress;

	@FindBy(xpath = "//span[@translate='btn_continue_to_review']")
	WebElement btnContinueToOrderReview;
	
	/**
	 * Selects the Home Address option for Shipping
	 * @author rajesh.varalli1
	 */
	public void selectHomeAddress() {
		reusableActions.clickWhenReady(lblHomeAddress, 60);
	}
	
	/**
	 * Clicks on the 'Continue to Order Review' button
	 * @author rajesh.varalli1
	 */
	public void clkContinueToOrderReview() {
		reusableActions.clickWhenReady(btnContinueToOrderReview);
		reusableActions.waitForElementVisibility(btnContinueToOrderReview,40);
	}
}
