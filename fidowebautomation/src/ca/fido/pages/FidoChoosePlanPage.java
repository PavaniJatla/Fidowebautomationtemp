package ca.fido.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoChoosePlanPage extends BasePageClass {

	public FidoChoosePlanPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath="//span[@translate='_select']/parent::div[@role='button']")
	WebElement btnSelect;
	
	@FindBy(xpath="//button[@translate='choose-addons-mini-cart-btn']")
	WebElement btnContinueToAddons;
	
	@FindBy(xpath="//div[@translate='ppc_change_plan_header']")
	WebElement lblChangeYourPlan;
	
	@FindBy(xpath="//span[@translate='_continue']/ancestor::div[contains(@class,'hidden-xs summary-strip')]/button")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[contains(@class,'blockerLoading')]/img[@alt='loading']")
	WebElement imgLoading;
	
	@FindBy(xpath="//span[@translate='ppc_accept_downgrade_fee']")
	WebElement btnDowngradeFeeContinue;
	
	
	public void clkPlanType(String planType) {
		switch (planType.trim().toUpperCase()) {
		case "SMALL":
			planType = "SMALL";
			break;

		case "MEDIUM":
			planType = "MEDIUM";
			break;

		case "LARGE":
			planType = "LARGE";
			break;

		case "XL":
			planType = "EXTRALARGE";
			break;

		case "XXL":
			planType = "2XLARGE";
			break;

		default:
			if(planType.toUpperCase().contains("DATA")) {
				planType = "FID_FIN2";
			} else if (planType.toUpperCase().contains("TALK")) {
				planType = "TALKTEXT_F";
			} else {
				planType = "BYOD";
			}
			break;
		}
		reusableActions.clickWhenVisible(By.xpath("//span[@res='category-"+ planType +"-title']/ancestor::a"));
	}
	
	/**
	 * Clicks on the 'Select' button against the first available price plan
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailablePricePlan() {
		reusableActions.executeJavaScriptClick(btnSelect);
	}
	
	/**
	 * Clicks on the 'CONTINUE TO ADD-ONS' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinueToAddons() {
		reusableActions.clickWhenVisible(btnContinueToAddons,30);
	}
	
	/**
	 * Validates if the Price Plan Page has loaded successfully
	 * @return true if 'Change Your Plan' header is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePlanPageLoad() {
		return reusableActions.isElementVisible(lblChangeYourPlan);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue,30);
	}
	
	/**
	 * Validates if the 'Downgrade Fee' overlay is displayed
	 * @return true if the 'Continue' button on the 'Downgrade Fee' overlay is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyDowngradeFeeOverlay() {
		return reusableActions.isElementVisible(btnDowngradeFeeContinue, 60);
	}
	
	/**
	 * Clicks on the 'Continue' button in the 'Downgrade Fee' overlay
	 * @author rajesh.varalli1
	 */
	public void clkDowngradeFeeContinue() {
		reusableActions.clickIfAvailable(btnDowngradeFeeContinue, 60);
	}
}
