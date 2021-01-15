package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;



public class FidoShippingPage extends BasePageClass {

	public FidoShippingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@checkout-res='checkout_billing_address']")
	WebElement lblHomeAddress;

	@FindAll({
		@FindBy(xpath = "//span[@translate='btn_continue_to_review']"),
		@FindBy(xpath = "//span[@checkout-res='btn_continue_to_review']")
	})
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
		reusableActions.waitForElementVisibility(btnContinueToOrderReview,40);
		reusableActions.clickWhenReady(btnContinueToOrderReview,60);
	}

	/**
	 * This method is to verify the shipping page is loaded or not
	 * @return true is element is visible else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyShippingPage() {
		return reusableActions.isElementVisible(btnContinueToOrderReview,60);
	}
}
