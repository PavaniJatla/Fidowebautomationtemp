package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RogersSolarisRHPDashboardPage extends BasePageClass {

	public RogersSolarisRHPDashboardPage(WebDriver driver) {
		super(driver);
	}

	
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Home Phone')]"),
        @FindBy(xpath = "//span[@class='ds-icon rds-icon-home-phone']")})
	WebElement btnSolarisrhpBadge;

	@FindBy(xpath = "//ins[@translate='global.label.homePhoneDashboard']")
	WebElement infoSolarisrhpDashboard;

	@FindBy(xpath = "//h3[contains(@class,'rhp_feature-title')]")
	WebElement infoLegacyrhpDashboard;

@FindAll({
		@FindBy(xpath = "//span[contains(text(),'Configure your current features') or contains(text(),'Configuration des fonctions')]/ancestor::a"),
		@FindBy(xpath = "(//span[@class='ds-link__copy'])[71]")
})
	 WebElement lnkConfigureYourCurrentFeatures;
    //ins[@usertype-translate='global.cta.configureYourFeatures']


		//@FindBy(xpath = "//span[contains(text(),'Access your voicemail settings')] or contains(text(),'Paramètres de messagerie vocale')]/ancestor::a"),
		@FindBy(xpath = "(//span[@class='ds-link__copy'])[72]")
	 WebElement lnkAccessYourVoicemailSettings;
	//ins[@usertype-translate='global.cta.accessYourVoicemailSettings']


		@FindBy(xpath = "//button[@aria-label='Reset your voicemail password']")
	    WebElement lnkResetYourVoicemailPassword;
         //ins[@usertype-translate='global.cta.resetVoicemailPassword']

	@FindBy(xpath = "//a[@aria-label='Need help? Chat with a Rogers agent.']")
	WebElement lnkLiveChatOnRHPDashboard;

	@FindBy(xpath = "//button[@aria-label='Cancel']")
	WebElement btnCancelResetVoicemailpswd;

	@FindBy(xpath = "//a[@class='contact-line__cta' and @href='tel:1 855 759-5856']/span")
	WebElement lnkCallUs;

	@FindAll({
			@FindBy(xpath = "//h1[@class='-mb10 -mt30']"),
			@FindBy(xpath = "//h1[text() = 'Home Phone' or text() = 'Téléphonie résidentielle']"),
			@FindBy(xpath = "//p[@class='rch-home-phone-address']")})
	WebElement headerHomePage;


	/**
	 * Verifies the Home Phone Header
	 * @return true if Home Phone header is present, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyHomePhone() {
		return getReusableActionsInstance().isElementVisible(headerHomePage, 30);
	}

	/**
	 * Click on the Solaris RHP badge 
     * @param strBrowser - Browser
	 * @author Chinnarao.Vattam
	 */
	public void clkSolarisRHPBadge(String strBrowser ) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		getReusableActionsInstance().getWhenReady(btnSolarisrhpBadge, 30).click();
		}else
		{
			getReusableActionsInstance().clickWhenReady(btnSolarisrhpBadge, 60);
		}
	}

	/**
	 * To Verify the RHP Banner on the Legacy RHP dash board
	 * @return true if the package name is Home Phone ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyRHPBanner() {
		return getReusableActionsInstance().isElementVisible(infoLegacyrhpDashboard, 60);
	}

	/**
	 * Verify the configure your current features link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the configure your current features link, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyConfigureYourCurrentFeatures() {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Configure your current features') or contains(text(),'Configuration des fonctions')]/ancestor::a")));
		//getReusableActionsInstance().waitForElementVisibility(lnkConfigureYourCurrentFeatures, 60);
		return getReusableActionsInstance().isElementVisible(lnkConfigureYourCurrentFeatures, 30);
	}
	/**
	 * Verify the access your voice mail settings link onSolaris RHP dashboard
	 * @return true if the RHP dash board display the access your voice mail settings link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyAccessYourVoicemailSettings() {
		return getReusableActionsInstance().isElementVisible(lnkAccessYourVoicemailSettings, 60);
	}
	/**
	 * Verify the reset your voice mail password link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the reset your voice mail password link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyResetYourVoicemailPassword() {
		return getReusableActionsInstance().isElementVisible(lnkResetYourVoicemailPassword, 30);
	}
	/**
	 * Verify the live chat on RHP dashboard link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the live chat on RHP dashboard link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyLiveChatOnRHPDashboard() {
		return getReusableActionsInstance().isElementVisible(lnkLiveChatOnRHPDashboard);
	}

	/**
	 * Click the Configure Your Current Features link
	 * @return true if the Configure Your Current Features is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean clkConfigureYourCurrentFeatures() {
		String mainWindow = getDriver().getWindowHandle();
		getReusableActionsInstance().getWhenReady(lnkConfigureYourCurrentFeatures,90).click();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2);
		getReusableActionsInstance().switchToNewWindow(mainWindow);
		//the page is moving to new window
		getReusableActionsInstance().staticWait(1000);
		//getReusableActionsInstance().isElementVisible(lnkPDFPage);
		getReusableActionsInstance().closeCurrentWindow();
		getReusableActionsInstance().switchToMainWindow(mainWindow);
		//the page is moving to original window
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().waitForNumberOfWindowsToBe(1);
		return true;
	}

	/**
	 * Clicks on ConfigureYourCurrentFeatures
	 * @author chinnarao.vattam
	 */
	public void clkCancelResetVoicemailpswd() {
		getReusableActionsInstance().getWhenReady(btnCancelResetVoicemailpswd,60).click();
	}

	/**
	 * Click the Access Your Voicemail Settings link
	 * @return true if the Access Your Voicemail Settings is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean  clkAccessYourVoicemailSettings() {
		String mainWindow = getDriver().getWindowHandle();
		getReusableActionsInstance().getWhenReady(lnkAccessYourVoicemailSettings,90).click();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2);
		getReusableActionsInstance().switchToNewWindow(mainWindow);
		//the page is moving to new window
		getReusableActionsInstance().staticWait(1000);
		//getReusableActionsInstance().isElementVisible(lnkPDFPage);
		getReusableActionsInstance().closeCurrentWindow();
		getReusableActionsInstance().switchToMainWindow(mainWindow);
		//the page is moving to original window
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().waitForNumberOfWindowsToBe(1);
		return true;
	}

	/**
	 * Clicks on ResetYourVoicemailPassword
	 * @author chinnarao.vattam
	 */
	public void clkResetYourVoicemailPassword() {
		getReusableActionsInstance().getWhenReady(lnkResetYourVoicemailPassword,60).click();
	}

	/**
	 * Verify the number is text or link for Bulk Tenant on Home Phone Dashboard page
	 * @retun true if the number is clickable , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyCallUs() {
		return  getReusableActionsInstance().isElementVisible(lnkCallUs, 20);
	}


}
