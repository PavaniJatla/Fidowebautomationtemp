package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;



/**
 * 
 * @author Ning.Xue
 *
 */
public class FidoSetPasswordPage extends BasePageClass {

	public FidoSetPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinue;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement inputPassword;
	
	@FindBy (xpath = "//input[@name='confirmPassword']")
	WebElement inputConfirmPassword;
	
	@FindBy (xpath = "//button[@translate='ute.easy.login.registration.password.setPassword']")
	WebElement btnSetPassword;
	
	@FindBy (xpath = "//span[@translate='ute.easy.login.registration.complete.header']")
	WebElement msgRegistrationComplete;
	
	@FindBy (xpath = "//button[@translate='ute.easy.login.registration.complete.goToOverview']")
	WebElement btnGotoOverview;
	
	@FindBy (xpath = "//img[@alt='Set password' or @alt='Enregister le mot de passe']")
	WebElement btnSetPasswordInEmail;
	
	/**
	 * To click set password button in email details page
	 * @author ning.xue
	 */
	public void clkBtnSetPasswordInEmail() {
		reusableActions.clickWhenReady(By.xpath("//img[@alt='Set password' or @alt='Enregister le mot de passe']"), 30);
	}
	
	/**
	 * Switch driver to set password tab
	 * @param intTabIndex, integer, the index of the tab
	 * @author ning.xue
	 */
	public void switchToSetPasswordTab(int intTabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		getDriver().switchTo().window(tabs.get(intTabIndex));
	}
	
	/**
	 * Click on the province for the data 
	 * @param strProvince, string of province with first letter capital
	 * @author ning.xue
	 */
	public void clkRadioBtnProvince(String strProvince) {
		reusableActions.clickWhenReady(By.xpath("//ins[contains(text(),'" + strProvince + "')]"), 20);
	}

	/**
	 * To click Continue button in email details page
	 * @author ning.xue
	 */
	public void clkBtnContinueForSetPassword() {
		reusableActions.clickWhenReady(btnContinue, 30);
	}
	
	/**
	 * To set password in set password page
	 * @param strPassword, string of the password
	 */
	public void setPassword(String strPassword) {
		reusableActions.getWhenReady(inputPassword, 30).click();
		reusableActions.getWhenReady(inputPassword, 30).sendKeys(strPassword);
	}
	
	/**
	 * To set password in set password page
	 * @param strPassword, string of the password
	 */
	public void setConfirmPassword(String strPassword) {
		reusableActions.getWhenReady(inputConfirmPassword, 30).click();
		reusableActions.getWhenReady(inputConfirmPassword, 30).sendKeys(strPassword);
	}
	
	/**
	 * To click set password button in set password page
	 * @author ning.xue
	 */
	public void clkBtnSetPassword() {
		reusableActions.clickWhenReady(btnSetPassword, 30);
	} 
	
	/**
	 * Check if the registration completed message is displayed.
	 * @return true if message displayed, else false.
	 */
	public boolean verifyMsgReigistrationCompleteIsDisplayed() {
		return reusableActions.isElementVisible(msgRegistrationComplete, 20);
	}
	
	/**
	 * To click "Go to overview" button in set password page
	 * @author ning.xue
	 */
	public void clkBtnGotoOverview() {
		reusableActions.clickWhenReady(btnGotoOverview, 30);
	} 
}
