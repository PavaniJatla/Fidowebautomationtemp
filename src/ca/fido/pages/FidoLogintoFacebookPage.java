package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoLogintoFacebookPage extends BasePageClass {
	

	public FidoLogintoFacebookPage(WebDriver driver) {
		super(driver);
	}
	//note: the Continue to Facebook button didn't show anymore after R619
	@FindBy (xpath = "//button[contains(text(),'Continue to Facebook')]")
	WebElement btnContinueToFacebook;
	
	@FindBy (xpath = "//span[@class='_50f6']")
	WebElement logIntoFacebook;
	
	/**
	 * Check if the Continue To Facebook button present or not
	 * @return boolean
	 */
	public boolean isContinueBtnPresent() {
		return reusableActions.isElementVisible(btnContinueToFacebook);
	}
	
	/**
	 * Click on Continue to Facebook button
	 * @author ning.xue
	 */
	public void clkBtnContinueToFacebook() {
		reusableActions.getWhenVisible(btnContinueToFacebook,20).click();
	}
	
	/**
	 * Verify Facebook page is load or not
	 * @return boolean
	 */
	public boolean verifyFacebookPage() {
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		return reusableActions.isElementVisible(logIntoFacebook, 40);
	}
}
