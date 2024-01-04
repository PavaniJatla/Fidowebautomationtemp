package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.support.FindBys;

public class RogersInternetDashboardPage extends BasePageClass {

	public RogersInternetDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//section[@class='internet-my-usage'] | //h1[text()= ' Internet ']")
	WebElement txtInternetUsage;

	@FindBy(xpath = "//span[@translate='global.selfServe.legacyDashboard.internet.dailyUsage']")
	WebElement txtDailyUsage;

	@FindBy(xpath = "//span[@translate='global.selfServe.legacyDashboard.internet.monthlyUsage']")
	WebElement txtMonthlyUsage;

	@FindBy(xpath = "//span[@data-test-id='myr-internetMyPackage-managePackage']")
	WebElement btnChangeInternetPackage;


	@FindBy(xpath = "//span[text()=' Internet ']/ancestor::rss-subscription-detail-row//a[contains(@class,'ds-link')]//span[@role='text']")
	WebElement btnSolarisInternetBadge;

	@FindAll({
			@FindBy(xpath = "//h1[@class='-mb8']"),
			@FindBy(xpath = "//div[@rchapiexposer='global.cta.at']")})
	WebElement infoInternet;

	@FindBy(xpath = "//*[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large ng-star-inserted']")
	WebElement lnkInternetUsageAlerts;

	@FindBy(xpath = "//*[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large ng-star-inserted']")
	//@FindBy(xpath = "//*[@usertype-translate='global.label.usageAndAlerts' or @translate='global.dashboard.internet.usage']")
	WebElement infoUsageAndAlerts;

	@FindBy(xpath = "//div[contains(@class,'change-internet-button')]//button")
	WebElement btnSolChangeInternetPackage;
	//span[@translate='global.dashboard.common.changeInternetPackage']

	@FindBy(xpath = "//h1[contains(text(), \"Setup & Install\")] | //p[contains(text(), \"Select your device\")]")
	WebElement txtIgniteWifiHub;

	@FindBy(xpath = "//div[@class='live-support']")
	WebElement popupContatUS;

	@FindBy(xpath = "//h1[@aria-labelledby='ariaPopupHeader']")
	WebElement popupContatUSInternetDowngrade;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
	WebElement popUpInternetPopup;

	//@FindBy(xpath = "//span[@id='ariaChangeWifiPassword']/ancestor::span[@role='text']")
	@FindAll({@FindBy(xpath = "//span[contains(text(), \"change your WiFi pass\")]"),
			@FindBy(xpath = "//a[@aria-label='Change your WiFi password. The link will open a new tab in your browser.']//span[@class='ds-icon d-inline-flex rds-icon-open-new']")})

	WebElement btnWifiPassword;

	@FindBy(xpath = "//div[@id='terms-conditions']")
	WebElement infoAgreement;

@FindAll({
		@FindBy(xpath = "//span[contains(text(),'Continue')]"),
		@FindBy(xpath = "//button[@aria-label='Keep existing']")
})
	    WebElement btnInternetChangeOK;
@FindBy(xpath= "//button[@aria-label='Keep existing']")
WebElement btnInternetcontinue;


	@FindBy(xpath = "//a[contains(@aria-label, '1.5 Gbps')]/span/ancestor::div[@class='sai-vertical-tile-component']//div[@class='vertical-tile__internet']//label[contains(@title,'Add for $5')]")
	WebElement btnSmartstreamPack;

	@FindBy(xpath = "//button[contains(@class,'-primary -large ng-star-inserted')]")
	WebElement btnSAInternetChangeOK;

	@FindBy(xpath = "//i[@class='ute-icon-button-right']")
	WebElement imgNext;

	@FindBy(xpath = "//i[@class='ute-icon-button-left']")
	WebElement imgPrevious;

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersInternet;

	@FindBy(xpath = "//div[@class='preloader loading-secondary']")
	WebElement popupLoadingFingersMobile;

	@FindBy(xpath = "//div[@class='owl-item active']//ins[@translate='global.cta.select']")
	WebElement btnSelectInternetPackageMobile;

	@FindBy(xpath = "//a[@href='#']/img")
	WebElement btnVaButton;

	@FindBy(xpath = "//h1[@translate='global.label.internet']")
	WebElement txtInternet;

	@FindBy(xpath = "//a[@href='#' and @class='mat-menu-trigger va-header-ham-button']")
	WebElement btnVaMenu;
	//a[@class='mat-menu-trigger va-header-ham-button']

	@FindBy(xpath = "//button[@id='va-menu-minimum-button']")
	WebElement btnVAMininmize;

	@FindBy(xpath = "//iframe[@id='va-iframe']")
	WebElement ifrmVA;


	@FindBy(xpath = "//div[@id='va-welcome-header']")
	WebElement txtVaWelcome;

	@FindBy(xpath = "//input[@id='va-welcome-input']")
	WebElement txtVaCustomerName;

	@FindBy(xpath = "//button[@id='va-welcome-send-button']")
	WebElement btnVaWelcomeSend;

	@FindBy(xpath = "//input[@name='va-welcome-input']")
	WebElement selVaTopicList;

	@FindBy(xpath = "//button[@id='va-menu-close-button']")
	WebElement btnVAClose;

	@FindBy(xpath = "//div[@id='va-chat-canned-responses1']")
	WebElement btnVAOptions;

	@FindBy(xpath = "//a[@href='#' and  text()='Ignite Internet']")
	WebElement optsIgniteInternet;

	@FindBy(xpath = "//div[@id='va-chat-canned-responses4']")
	WebElement optsInternetIssues;

	@FindBy(xpath = "//h1[@class='smart-stream-opt-in-modal__header']")
	WebElement headerSmartStreamModal;

	@FindBy(xpath = "//a[contains(@aria-label,'Reject')]/span")
	WebElement btnNoThanks;

	@FindBy(xpath = "//a[contains(@aria-label,'continue')]/span/span")
	WebElement btnContinue;

	@FindBy(xpath = "//button[@aria-label='See more details about your internet package' and @aria-expanded='false']/span")
	WebElement lnkShowDetails;

	@FindBy(xpath = "//button[@aria-label='See more details about your internet package' and @aria-expanded='true']")
	WebElement lnkHideDetails;

	@FindBy(xpath = "//a[@class='contact-line__cta' and @href='tel:1 855 759-5856']/span")
	WebElement lnkCallUs;

	@FindBy(xpath = "//span[text()='Want to change your internet package?' or text()='Vous voulez changer votre forfait Internet?']")
	WebElement headerChangepkg;

	@FindBy(xpath = "//div[@class='popup-modal-body__content']")
	WebElement txtContactUsPopupModal;

	@FindBy(xpath = "//ds-icon[@name='call']/span[@role='img']")
	WebElement imgBookACallBack;

	@FindBy(xpath = "//span[text()='Book a call back' or text()='Fixer une heure de rappel']")
	WebElement lnkBookACallBack;

	@FindBy(xpath = "//ds-icon[@name='text']/span[@role='img']")
	WebElement imgLiveChat;

	@FindBy(xpath = "//div[@class='live-chat-section d-flex align-items-center']/descendant::span[text()='Live Chat']")
	WebElement lnkLiveChat;

	@FindBy(xpath = "//div[@class='popup-modal-component']")
	WebElement divInvalidOfferPopup;

	@FindBy(xpath = "//h2[text()='Offer invalid' or text()='Offre non valide']")
	WebElement txtInvalidOffer;

	@FindBy(xpath = "//button[@aria-label='View Ignite Internet in entered province']")
	WebElement btnViewPkgs;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-info-circle ds-color-info']")
	WebElement imgInfoIconPTMmodal;

	@FindBy(xpath = "//span[text()='Changes to your Ignite services']")
	WebElement headerPTMmodal;

	@FindBys({@FindBy(xpath = "//div[contains(@class, 'popup-modal-body__content')]//ul//li[1]"),
			@FindBy(xpath = "//div[contains(@class, 'popup-modal-body__content')]//ul//li[2]")})
	WebElement txtContentPTMModel;
	
	
	/**
	 * Verify the Internet usage on the Internet dashboard page
	 *
	 * @return true if the Internet usage displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetUsage() {
		return getReusableActionsInstance().isElementVisible(txtInternetUsage, 30);
	}

	public boolean verifyDailyUsage() {
		return getReusableActionsInstance().isElementVisible(txtDailyUsage, 30);
	}

	public boolean verifyMonthlyUsage() {
		return getReusableActionsInstance().isElementVisible(txtMonthlyUsage, 30);
	}

	public boolean verifyInternetUsageMobile() {
		return getReusableActionsInstance().isElementVisible(txtInternetUsage, 90);
	}

	/**
	 * Verify the Internet usage on the Internet dashboard page
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkChangeInternetPackage() {
		getReusableActionsInstance().getWhenReady(btnChangeInternetPackage, 90).click();
	}

	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkSolarisInternetBadge() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisInternetBadge, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnSolarisInternetBadge);

	}

	public void clkChangeInternetPkg() {
		getReusableActionsInstance().staticWait(2000);
		By btnChangeIntPkg = By.xpath("(//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100'])[3]");
				getReusableActionsInstance().getWhenReady(btnChangeIntPkg ,120).click();

	}

	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetBadgeMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().waitForElementVisibility(btnSolarisInternetBadge, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnSolarisInternetBadge);
	}

	/**
	 * Verify the Internet header text on the Solaris Internet dashboard
	 *
	 * @return true if the Internet heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternet() {
		return getReusableActionsInstance().isElementVisible(infoInternet, 40);
	}

	/**
	 * Click on the Internet Usage Alerts link on solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetUsageAlerts() {
		getReusableActionsInstance().waitForElementVisibility(lnkInternetUsageAlerts, 60);
		getReusableActionsInstance().executeJavaScriptClick(lnkInternetUsageAlerts);

	}

	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dashboard
	 *
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyUsageAndAlerts() {
		return getReusableActionsInstance().isElementVisible(infoUsageAndAlerts, 30);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dashboard
	 *
	 * @author chinnarao.vattam
	 */
	public void clkInternetPopup() {
		getReusableActionsInstance().clickIfAvailable(popUpInternetPopup, 10);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dashboard
	 *
	 * @author chinnarao.vattam
	 */
	public void clkIgniteInternetOption() {
		getReusableActionsInstance().clickIfAvailable(optsIgniteInternet, 60);
	}

	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dashboard
	 *
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetIssues() {
		return getReusableActionsInstance().isElementVisible(optsInternetIssues, 30);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dashboard
	 *
	 * @author chinnarao.vattam
	 */
	public void clkWifiPassword() {
		getReusableActionsInstance().clickIfAvailable(btnWifiPassword, 60);
	}

	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dashboard
	 *
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyChangeWifiPassword() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		return getReusableActionsInstance().isElementVisible(btnWifiPassword, 30);
	}

	/**
	 * Click the PDF link on MyChannelLineup popup
	 *
	 * @return true if the PDF is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean SwitchIgnitewifiPage() {
		String mainWindow = getDriver().getWindowHandle();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2);
		getReusableActionsInstance().switchToNewWindow(mainWindow);
		//the page is moving to new window
		getReusableActionsInstance().staticWait(1000);
		return true;
	}

	public boolean verifyIgniteWifiHub() {
		return getReusableActionsInstance().isElementVisible(txtIgniteWifiHub, 90);
	}

	/**
	 * Click the Change Internet Package button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkSolChangeInternetPackage() {
		getReusableActionsInstance().staticWait(5000);
		By btnSolChangeInternetPackage = By.xpath("//div[contains(@class,'change-internet-button')]//button");
		getReusableActionsInstance().getWhenReady(btnSolChangeInternetPackage, 90);
		WebElement changePkg = getDriver().findElement(btnSolChangeInternetPackage);
		getReusableActionsInstance().clickWhenReady(changePkg);
		//getReusableActionsInstance().waitForElementVisibility(btnSolChangeInternetPackage, 120);
		//getReusableActionsInstance().getWhenReady(btnSolChangeInternetPackage, 60).click();
	}

	/**
	 * verify the Change Internet Package button on Solaris Internet dashboard is present or not
	 *
	 * @return true if button is not present, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangeInternetPackageBtnNotPresent() {
		return !(getReusableActionsInstance().isElementVisible(btnSolChangeInternetPackage, 10));
	}

	/**
	 * Click the Change Internet Package button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkSolChangeInternetPackageMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnSolChangeInternetPackage, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnSolChangeInternetPackage);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetChangeOK() {
		getReusableActionsInstance().clickIfAvailable(btnInternetChangeOK, 30);
		getReusableActionsInstance().staticWait(3000);
	}

	public void clkInternetchangebtn(){
		getReusableActionsInstance().clickIfAvailable(btnInternetcontinue, 30);
		getReusableActionsInstance().staticWait(3000);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkSmartstreamPack() {
		getReusableActionsInstance().getWhenReady(btnSmartstreamPack, 90).click();
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkSAInternetChangeOK() {
		getReusableActionsInstance().clickIfAvailable(btnSAInternetChangeOK, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetPage() {
		return getReusableActionsInstance().isElementVisible(txtInternet, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkVAButton() {
		getReusableActionsInstance().getWhenReady(btnVaButton, 10).click();

	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkVAMenu() {
		getReusableActionsInstance().getWhenReady(btnVaMenu, 20).click();
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkVAMinimize() {
		getReusableActionsInstance().getWhenReady(btnVAMininmize, 10).click();

	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkVAClose() {
		getReusableActionsInstance().getWhenReady(btnVAClose, 10).click();

	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVAButton() {
		return getReusableActionsInstance().isElementVisible(btnVaButton, 10);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaWelcome() {
		return getReusableActionsInstance().isElementVisible(txtVaWelcome, 90);
	}

	/**
	 * To switch to the iframe
	 *
	 * @author chinnarao.vattam
	 */
	public void switchToVAIFrame() {
		getDriver().switchTo().frame(ifrmVA);
//		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaTopicList() {
		return getReusableActionsInstance().isElementVisible(selVaTopicList, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaWelcomeSend() {
		return getReusableActionsInstance().isElementVisible(btnVaWelcomeSend, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVAOptions() {
		return getReusableActionsInstance().isElementVisible(btnVAOptions, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dashboard
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clkVaWelcomeSend() {
		getReusableActionsInstance().getWhenReady(btnVaWelcomeSend, 10);
		getReusableActionsInstance().executeJavaScriptClick(btnVaWelcomeSend);
	}


	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifycontatUSPopUp() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingers, 60);
		return getReusableActionsInstance().isElementVisible(popupContatUS, 20);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyContactUSInternetDowngrade() {
		if (getReusableActionsInstance().isElementVisible(popupLoadingFingersInternet, 30)) {
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersInternet, 60);
		}
		return getReusableActionsInstance().isElementVisible(popupContatUSInternetDowngrade, 20);
	}

	/**
	 * Checks if the pop up contact us is visible
	 *
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyContactUSInternetDowngradeInternet() {
		getReusableActionsInstance().waitForElementVisibility(popupContatUSInternetDowngrade, 60);
		return getReusableActionsInstance().isElementVisible(popupContatUSInternetDowngrade, 20);
	}


	/**
	 * Select the  Internet Package on change Internet package page
	 *
	 * @param strPackageNameEn Internet package to be selected
	 * @param strPackageNameFr Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageOld(String strPackageNameEn, String strPackageNameFr) {
		By btnPackageSelection = By.xpath("//span[contains(normalize-space(text()),'" + strPackageNameEn + "') or contains(normalize-space(text()),'" + strPackageNameFr + "')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		if (getReusableActionsInstance().isElementVisible(btnPackageSelection, 60)) {
			getReusableActionsInstance().getWhenReady(btnPackageSelection, 30).click();
		} else {
			getReusableActionsInstance().getWhenReady(imgNext, 90).click();
			getReusableActionsInstance().isElementVisible(btnPackageSelection, 60);
			getReusableActionsInstance().getWhenReady(btnPackageSelection, 30).click();
		}
	}


	/**
	 * Select Solaris Internet Package
	 *
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage(String strPackageNameEn, String strPackageNameFr) {
		getReusableActionsInstance().staticWait(3000);
		By packageNameLocator = By.xpath("//button[contains(@aria-label, '" + strPackageNameEn + "') or contains(@aria-label,'" + strPackageNameFr + "')]/span");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().clickWhenReady(pkg, 60);
	}

	/**
	 * Select Solaris Internet Package
	 *
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMobile(String strPackageNameEn, String strPackageNameFr) {
		getReusableActionsInstance().staticWait(3000);
		By packageNameLocator = By.xpath("//a[contains(@aria-label, '" + strPackageNameEn + "')]/span");
		//By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='change-internet-sai-tile__row']//button[contains(@aria-label,'Add Ignite Internet')]/span");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}

	/**
	 * Select Solaris Internet Package
	 *
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectStandAloneInternetPackage(String strPackageNameEn, String strPackageNameFr) {
		//By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='internet-bundle-tile__row']//button[contains(@aria-label,'Add Ignite Internet')]");
		By packageNameLocator = By.xpath("//a[contains(@aria-label, '" + strPackageNameEn + "')]/span");
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(packageNameLocator, 60);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}

	/**
	 * Select the  Internet Package on change Internet package page
	 *
	 * @param strPackageNameEn Internet package to be selected
	 * @param strPackageNameFr Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectInternetPackageMobile(String strPackageNameEn, String strPackageNameFr) {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersMobile, 120);
		By btnPackageSelection = By.xpath("//span[contains(normalize-space(text()),'" + strPackageNameEn + "') or contains(normalize-space(text()),'" + strPackageNameFr + "')]");
		if (getReusableActionsInstance().isElementVisible(btnPackageSelection, 60)) {
			getReusableActionsInstance().getWhenReady(btnSelectInternetPackageMobile, 30).click();
		} else {
			getReusableActionsInstance().getWhenReady(imgNext, 90).click();
			getReusableActionsInstance().isElementVisible(btnPackageSelection, 60);
			getReusableActionsInstance().getWhenReady(btnSelectInternetPackageMobile, 30).click();
		}
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersMobile, 120);
	}

	/**
	 * Select the  Internet Package on change Internet package page for migration flow
	 *
	 * @param strPackageName Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMigration(String strPackageName) {
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName
				+ "') or contains(normalize-space(text()),'Élan Internet gigabit')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingers, 90);
		getReusableActionsInstance().getWhenReady(packageNameLocator, 60).click();
	}

	/**
	 * Select Solaris Internet Package
	 *
	 * @param strPackageName package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage1(String strPackageName) {
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName + "') or contains(normalize-space(text()),'Élan Internet 150i')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90).click();
	}

	/**
	 * Verify Smart Stream Modal
	 *
	 * @retun true if smart stream modal present
	 * @author Manpreet.Kaur3
	 */
	public boolean verifySmartStreamHeader() {
		return getReusableActionsInstance().isElementVisible(headerSmartStreamModal, 30);
	}

	/**
	 * Close Smart Stream Modal
	 *
	 * @author Manpreet.Kaur3
	 */
	public void clkOnNoThanks() {
		getReusableActionsInstance().waitForElementVisibility(btnNoThanks, 30);
		getReusableActionsInstance().getWhenReady(btnNoThanks, 20).click();

	}


	public void clkContinueToChangeInternetPackage() {
		getReusableActionsInstance().waitForElementVisibility(btnContinue, 20);
		getReusableActionsInstance().getWhenReady(btnContinue, 20).click();
	}

	/**
	 * Click Show Details link
	 *
	 * @author Manpreet.Kaur3
	 */
	public void clkShowDetails() {
		getReusableActionsInstance().getWhenReady(lnkShowDetails, 20).click();
	}

	/**
	 * Verify Show Details link is expanded
	 *
	 * @retun true if Hide Details link is visible , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyShowDetailsExpanded() {
		return getReusableActionsInstance().isElementVisible(lnkHideDetails, 20);
	}

	/**
	 * Verify the number is text or link for Bulk Tenant
	 *
	 * @retun true if the number is clickable , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyCallUs() {
		return getReusableActionsInstance().isElementVisible(lnkCallUs, 20);
	}

	/**
	 * Verifies if Change Package Header is present
	 *
	 * @return true if Header is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangePackagePopupHeader() {
		return getReusableActionsInstance().isElementVisible(headerChangepkg, 20);
	}

	/**
	 * Gets the Change Package - Contact Us Modal content
	 *
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyContactUsModalContent() {
		String contactUsContentDesired = "Great! Contact us or book a call back – we’ll help you with all the details.";
		String contactUsContentActual = getReusableActionsInstance().getWhenReady(txtContactUsPopupModal, 20).getText();
		if (contactUsContentActual.equals(contactUsContentDesired)) {
			return true;
		}

		return false;
	}

	/**
	 * Verifies if Book a call back link is present
	 *
	 * @return true if Book a call back link is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyBookACallBack() {
		getReusableActionsInstance().waitForElementVisibility(imgBookACallBack, 10);
		return getReusableActionsInstance().isElementVisible(lnkBookACallBack, 20);

	}

	/**
	 * Verifies if Live Chat link is present
	 *
	 * @return true if Live Chat link is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyLiveChat() {
		getReusableActionsInstance().waitForElementVisibility(imgLiveChat, 10);
		return getReusableActionsInstance().isElementVisible(lnkLiveChat, 20);
	}

	/**
	 * Gets the Change Package - Contact Us Modal content
	 *
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyContactUsModalContentFR() {
		String contactUsContentDesired = "Super! Communiquez avec nous ou choisissez une heure de rappel et nous réglerons les détails avec vous.";
		String contactUsContentActual = getReusableActionsInstance().getWhenReady(txtContactUsPopupModal, 20).getText();
		if (contactUsContentActual.equals(contactUsContentDesired)) {
			return true;
		}

		return false;
	}

	/**
	 * Verifies the Invalid TNAC offer popup
	 *
	 * @return true if popup present, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyInvalidTnacOfferPopup() {
		getReusableActionsInstance().waitForElementVisibility(divInvalidOfferPopup, 40);
		return getReusableActionsInstance().isElementVisible(txtInvalidOffer, 10);

	}

	public void clkViewPkgs() {
		getReusableActionsInstance().waitForElementVisibility(btnViewPkgs, 10);
		getReusableActionsInstance().getWhenReady(btnViewPkgs).click();
		getReusableActionsInstance().staticWait(5000);
	}

	/**
	 * Verifies if PTM modal is present
	 *
	 * @return true if present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyInfoIconPTMmodal() {
		return getReusableActionsInstance().isElementVisible(imgInfoIconPTMmodal, 60);
	}

	/**
	 * Verifies if PTM modal Header is present
	 *
	 * @return true if Header is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyPTMmodalHeader() {
		return getReusableActionsInstance().isElementVisible(headerPTMmodal, 20);
	}

	/**
	 * Gets the PTM modal content
	 *
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyPTMmodalContent1() {
		By txtPTMModalCont1 = By.xpath("//div[contains(@class, 'popup-modal-body__content')]//ul//li[1]");
		String contactUsContentDesired = "Your new Ignite services will replace your existing services and promotions.";
		String txtPTMModalCont1Actual = getReusableActionsInstance().getWhenReady(txtPTMModalCont1, 20).getText();
		if (txtPTMModalCont1Actual.equals(contactUsContentDesired)) {
			return true;
		}
		return false;
	}

	public boolean verifyPTMmodalContent2() {
		By txtPTMModalCont2 = By.xpath("//div[contains(@class, 'popup-modal-body__content')]//ul//li[2]");
		String contactUsContentDesired = "Any existing add-ons or additional Ignite Entertainment Boxes will remain on your account.";
		String txtPTMModalCont2Actual = getReusableActionsInstance().getWhenReady(txtPTMModalCont2, 20).getText();
		if (txtPTMModalCont2Actual.equals(contactUsContentDesired)) {
			return true;
		}
		return false;
	}
}
