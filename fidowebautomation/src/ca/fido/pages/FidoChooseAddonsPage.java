package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoChooseAddonsPage extends BasePageClass {

	public FidoChooseAddonsPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//button[@translate='_continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//span[@translate='ppc_checkout_review_checkout']/ancestor::div[contains(@class,'hidden-xs summary-strip')]/button")
	WebElement btnCheckOut;
	
	@FindBy(xpath="//button[@translate='btn_continue_to_shipping']")
	WebElement btnContinueToShipping;
	
	@FindBy(xpath="//div[contains(@class,'new-addons-title ng-scope')]")
	WebElement lblChooseAddonsTitle;
	
	@FindBy(xpath="//button[@translate='_get_it']")
	WebElement btnGetIt;
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.waitForElementVisibility(lblChooseAddonsTitle, 60);
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnContinue,30));
		reusableActions.waitForElementVisibility(btnContinue,40);
	}
	
	/**
	 * Clicks on the 'Check Out' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkCheckOut() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnCheckOut,30));
		reusableActions.waitForElementVisibility(btnCheckOut,40);
	}
		
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinueToShipping() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnContinueToShipping,30));
		reusableActions.waitForElementVisibility(btnContinueToShipping,120);
	}
	
	/**
	 * Selects any available add-on
	 * @author rajesh.varalli1
	 */
	public void selectAnyAddon() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnGetIt, 60));
	}
	
}
