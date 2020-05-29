package ca.fido.pages.ens;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class EnsHomePage extends BasePageClass{

	public EnsHomePage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy (xpath = "//input[@type='email']")
	WebElement inputEmail;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement btnNext;
	
	@FindBy (xpath = "//input[@name='Password']")
	WebElement inputPassword;
	
	@FindBy (xpath = "//span[@class='submit']")
	WebElement btnSignIn;
	
	/**
	 * Open a new tab and launch ENS url.
	 * @param strEnsUrl, string of ENS url.
	 * @author ning.xue
	 */
	public void openNewTabForEns(String strEnsUrl) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.open()");
		reusableActions.waitForNumberOfWindowsToBe(2, 10);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(strEnsUrl);
	}
	
	/**
	 * Set the email on login page
	 * @param strEmail email to login
	 * @author ning.xue
	 */
	public void setEmail(String strEmail) {
		reusableActions.getWhenReady(inputEmail, 20).clear();
		reusableActions.getWhenReady(inputEmail).click();
		reusableActions.getWhenReady(inputEmail).sendKeys(strEmail);
	}
	
	/**
	 * Click on the next button
	 * @author ning.xue
	 */
	public void clkBtnNext() {		
		reusableActions.getWhenVisible(btnNext,10).click();
	}
	
	/**
	 * Set the password on login page
	 * @param strPassword password to login
	 * @author ning.xue
	 */
	public void setPassword(String strPassword) {

		if(reusableActions.isElementVisible(inputPassword)) {
			reusableActions.getWhenReady(inputPassword, 20).clear();
			reusableActions.getWhenReady(inputPassword).click();
			reusableActions.getWhenReady(inputPassword).sendKeys(strPassword);
		}
		
	}
	
	/**
	 * Click on the Sign In button
	 * @author ning.xue
	 */
	public void clkBtnSignIn() {	
		if(reusableActions.isElementVisible(btnSignIn)) {
		reusableActions.getWhenVisible(btnSignIn,10).click();
		}
	}
	
	 
}
