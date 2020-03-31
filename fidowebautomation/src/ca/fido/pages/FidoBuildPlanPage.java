package ca.fido.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoBuildPlanPage extends BasePageClass {

	public FidoBuildPlanPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath = "//div[@class='features-section' or @class='features-section dataSectionEmpty']/button")
	WebElement btnAdd;
	
	@FindBy(xpath = "//button[@translate='_continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//span[@translate='createAccount']/parent::button")
	WebElement btnCreateAnAccount;
	
	@FindBy(xpath = "//span[@translate='login-cta']/parent::button")
	WebElement btnLogin;
	
	@FindBy(xpath = "//div[contains(@class,'current-balance-container')]//span[contains(@ng-if,'planCategory') and contains(@res,'category')]")
	WebElement lblCurrentPlanCategory;
	
	@FindBy(xpath = "//span[contains(@class,'ui-slider-handle')]")
	WebElement planSlider;
	
	@FindBy(xpath = "//button[@translate='btn_continue_to_addons']")
	WebElement btnContinueToAddons;
	
	List<String> planCategory = Arrays.asList("category-SMALL","category-MEDIUM","category-LARGE","category-EXTRALARGE","category-2XLARGE");
	
	@FindBy(xpath = "//a[@res='keep-existing']")
	WebElement lnkKeepExisting;
	
	@FindBy(xpath = "//span[@res='keep-existing']/parent::button")
	WebElement btnKeepExistingPlan;
	
	@FindBy(xpath = "//div[@res='build-your-phone']")
	WebElement lblBuildYourPlan;
	
	@FindBy(xpath = "//button[@translate='bpo_redeem_offer']")
	WebElement btnGetThisOffer;
	
	/**
	 * Clicks on the 'Add' button against the first available price plan
	 * @return true if at least a plan is available; else false
	 * @author rajesh.varalli1
	 */
	public boolean selectFirstAvailablePricePlan() {
		if(reusableActions.isElementVisible(btnAdd, 30)) {
			reusableActions.executeJavaScriptClick(btnAdd);
			return true;
		}
		return false;
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		if(handleTodayOfferOverlay()) {
			reusableActions.clickWhenVisible(btnContinue,30);
		}
		reusableActions.waitForElementVisibility(btnContinue, 40);
	}
	
	/**
	 * Clicks on the 'CREATE AN ACCOUNT' button on the overlay modal
	 * @author rajesh.varalli1
	 */
	public void clkCreateAccount() {
		reusableActions.clickWhenVisible(btnCreateAnAccount);
	}
	
	/**
	 * Clicks on the 'LOG IN' button on the overlay modal
	 * @author rajesh.varalli1
	 */
	public void clkLogin() {
		reusableActions.clickWhenVisible(btnLogin);
		reusableActions.staticWait(3000);
	}
	
	/**
	 * Selects the next high tier price plan than the current price plan.
	 * @author rajesh.varalli1
	 * @return return value of assertion
	 */
	public boolean selectHigherPricePlan() {
		reusableActions.javascriptScrollToMiddleOfPage();
		String curPlnCat = lblCurrentPlanCategory.getAttribute("res");
		
		for (int index = planCategory.indexOf(curPlnCat)+1; index < planCategory.size(); index++) {
			reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='" + planCategory.get(index) + "']"),60));
			if(selectFirstAvailablePricePlan()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Selects the next low tier price plan than the current price plan.
	 * @author rajesh.varalli1
	 * @return return value of assertion
	 */
	public boolean selectLowerPricePlan() {
		reusableActions.javascriptScrollToMiddleOfPage();
		String curPlnCat = lblCurrentPlanCategory.getAttribute("res");
		
		for (int index = planCategory.indexOf(curPlnCat)-1; index >= 0; index--) {
			reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='" + planCategory.get(index) + "']"),60));
			if(selectFirstAvailablePricePlan()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Selects the plan type category by moving the Slider bar
	 * @param planCat Type of the plan
	 * @author rajesh.varalli1
	 */
	public void selectPlanCategory(String planCat) {
		reusableActions.getWhenReady(planSlider, 60);
		
		if(planCat.trim().toUpperCase().contains("DATA")) {
			planCat = "FID_FIN2";
		} else {
			planCat = "TALKTEXT_F";
		}
		
		reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='category-" + planCat + "']"),60));
	}
		
	/**
	 * Clicks on the 'Continue to Add-ons' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinueToAddons() {
		if(handleTodayOfferOverlay()) {
			reusableActions.clickWhenVisible(btnContinueToAddons,30);
		}
		reusableActions.waitForElementVisibility(btnContinueToAddons, 40);
	}
	
	/**
	 * Selects the Existing Plan
	 * @author rajesh.varalli1
	 */
	public void keepExistingPlan() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(lnkKeepExisting, 40));
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnKeepExistingPlan, 30));
		//reusableActions.clickIfAvailable(By.xpath("//button[@translate='bpo_redeem_offer']"));
	}
	
	/**
	 * Handles the ONLINE OFFERS overlay by clicking on 'Get this offer' button and 
	 * clicking on 'Continue to Addons' button after.
	 * @return true if no overlay is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean handleTodayOfferOverlay() {
		if(reusableActions.isElementVisible(btnGetThisOffer, 3)) {
			reusableActions.clickWhenReady(btnGetThisOffer);
			reusableActions.clickWhenVisible(By.xpath("//button[@translate='continue_to_addons']"), 10);
			return false;
		} else {
			return true;
		}
	}
	
	public void selectDataPlanCategory() {
		reusableActions.getWhenReady(planSlider, 60);
		reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='category-FID_FIN2']")));
	}
}