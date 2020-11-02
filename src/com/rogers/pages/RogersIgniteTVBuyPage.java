package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class RogersIgniteTVBuyPage extends BasePageClass {

	public RogersIgniteTVBuyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan Sélection') or contains(normalize-space(.),'Ignite TV Select')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.label.activateLater']")
	WebElement chkActivateLater;
	
	@FindBy(xpath ="//button[@class='ute-btn-secondary']//ins[@translate='global.cta.yes']")
	WebElement btnActivateLater;
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan Découverte') or contains(normalize-space(.),'Ignite TV Starter')]/ancestor::div[@class='box-shadow-targeted-offer']//ins[@translate='global.cta.addToCart']")
	WebElement btnSolarisStarterPackage;
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan ') or contains(normalize-space(.),'Ignite TV Popular')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']")
	WebElement btnSolarisSelectPackage;
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan ') or contains(normalize-space(.),'Ignite TV Popular')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']")
	WebElement btnSolarisPopularPackage;
	
	@FindBy(id = "addressLookup-modal")
	WebElement txaIgniteAddressLookup;

	@FindBy(xpath = "//ins[@translate='global.cta.check']")
	WebElement btnIgniteAddressLookupSubmit;
	
	@FindBy(xpath = "//div[@class='check-availability-btn']//ins[@translate='global.cta.checkAvailability']")
	WebElement btnIgniteCheckAvailability;

	@FindBy(xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//ds-checkbox[@ng-reflect-name=\"homephone\"]//div[contains(@class,'ds-checkbox__box')]")
	WebElement checkboxHomephone;
	
	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@translate='global.cta.continue']")
	WebElement btnGoodNewsContinue;
	
		
	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//ins[@translate='global.common.buttons.noThanksContinue']")
	WebElement btnNoThanksContinue;
	
	@FindBy(xpath = "//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForExistingNumber')]")
	WebElement btnKeepMyNumber;
	
	@FindBy(xpath = "//button[@class='continue-addon ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnHomePhoneContinue;
	//button[@class='continue-addon ds-button ds-focus ds-active -primary -large']
	
	@FindBy(xpath = "//input[@id='have4K-yes']")
	WebElement rdo4KTV;
	//label[@for='have4K-yes']

	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtEmailContainer;

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmail;


	@FindBy(xpath = "//h2[@class='dsa-billboard__copyHeading ng-star-inserted']")
	WebElement txtBundlesPage;

	@FindBy(xpath = "//span[@translate='global.modals.cartAbandonment.successModal.primaryButtonLabel']")
	WebElement btnOkay;

	@FindBy(xpath = "//button[@type='submit']//span[@translate='global.modals.cartAbandonment.triggerEmailModal.primaryButtonLabel']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='ds-checkboxLabel__container ml-8 text-body my-12']")
	WebElement clkEmailCheckbox;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span")
	WebElement clkContinue;

	@FindBy(xpath = "//h2[@translate='global.modals.cartAbandonment.triggerEmailModal.title']")
	WebElement popupEmailModal;


	@FindBy(xpath = "//a[@title='MyRogers' or @title='MonRogers' and @class='m-navLink ng-star-inserted']")
	WebElement lnkMyRogers;

	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnCheckout;
	//button[@class='mr-24 cart-summary-checkout ds-button ds-focus ds-active -primary -large']
	//button[@class='mr-24 cart-summary-checkout ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']
	
	@FindBy(xpath ="//div[@class='mt-auto w-100']//button[@aria-label='Order Rogers Ignite Starter online now' or @aria-label='Commandez Élan Découverte maintenant'] ")
	WebElement btnSolarisStarterPackageServiceability;	
	
	@FindBy(xpath ="//h3[contains(text(),'Ignite Starter') or contains(text(),'Élan Découverte')]/ancestor::div[@class='bundle-tile-row']//span[@translate='global.cta.addToCart']")
	WebElement btnSolarisStarterPackageNew;	
	//span[@translate='global.cta.addToCart']

	@FindBy(xpath ="//h3[contains(text(),'Ignite Starter') or contains(text(),'Élan Découverte')]/ancestor::div[@class='bundle-tile-row']//span[@translate='global.cta.addToCart']")
	WebElement btnSolarisStarterPackageMobile;	
	
	@FindBy(xpath = "(//div[@aria-label='$134.99 per m'])[2]")
	WebElement txtPackageCost;	
	
	@FindBy(xpath = "//p[@id='ds-modal-title-1']")
	WebElement popImportantInformation;
	   
	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnIUnderstand;	  
	
	@FindBy(xpath ="//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForNewNumber')]")
	WebElement rdoOptNewPhone;
	////(//div[@class='a-radio'])[2]//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForNewNumber')]
	
	@FindBy(xpath ="//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForExistingNumber')]")
	WebElement rdoOptNewPhoneEnable;
	
	@FindBy(xpath ="//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnOptPhone;
	//button[@class='ds-button ds-focus ds-active -primary -large']
	
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Starter') or contains(normalize-space(.),'Élan Découverte')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmStarterRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Select') or contains(normalize-space(.),'Élan Sélection')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmSelectRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Premier') or contains(normalize-space(.),'Élan Premier')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmPremierRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Popular') or contains(normalize-space(.),'Élan Populaire')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmPopularRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Flex 10') or contains(normalize-space(.),'Élan Flex 10')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmFlex10Ratecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Flex 5') or contains(normalize-space(.),'Élan Flex 5')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmFlex5Ratecard;
	
	@FindBy(xpath ="//ins[@translate='global.label.themePacksTab']/ancestor::h2[@class='solaris-tab-list-header']")
	WebElement tabThemePacksTab;
	
	@FindBy(xpath ="//ins[@translate='global.label.channelsTab']/ancestor::h2[@class='solaris-tab-list-header']")
	WebElement tabChannelsTab;
	
	@FindBy(xpath ="//ins[@translate='global.label.bundles']/ancestor::h2[@class='solaris-tab-list-header']")
	WebElement tabBundles;

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;

	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Starter Bundle') or contains(normalize-space(.),'Offre groupée Élan Découverte')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtStarterChannels;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Select Bundle') or contains(normalize-space(.),'Offre groupée Élan Sélection')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtSelectChannels;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Premier Bundle') or contains(normalize-space(.),'Offre groupée Élan Premier')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtPremierChannels;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Popular Bundle') or contains(normalize-space(.),'Offre groupée Élan Populaire')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtPopularChannels;	
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -tertiary -large -hasDsIcon']//following-sibling::button")
	WebElement buttonUpgradeNow;
	
	@FindBy(xpath = "//button[contains(@class,'stb-button increment')]//span[@class='ds-button__wrapper d-flex justify-content-center align-items-center']")
	WebElement buttonAddIgniteTVBoxes;
	//button[contains(@class,'stb-button increment')]//span[@class='ds-button__copy w-100']
		
	@FindBy(xpath = "//span[@translate='global.cta.updateCart']")
	WebElement buttonUpdateCart;
	
	@FindBy(xpath = "//ds-modal-container[contains(@id,'ds-modal-container')]")
	WebElement modalUpgradingToIgnitebundels;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement okayUpgradingToIgnitebundelsModal;
	
	@FindBy(xpath = "//i[contains(@class,'rch-icon-chevron-down')]")
	WebElement downChevronCartSummary;
	
	@FindBy(xpath = "//i[contains(@class,'rch-icon-chevron-up')]")
	WebElement upChevronCartSummary;
	
	@FindBy(xpath = "//div[contains(@class,'mini-cart-ss__body')]//tr[contains(@class,'cms-promotions-gwp ng-tns-c')]")
	WebElement gwpYourCart;
	
	@FindBy(xpath ="//input[contains(@id,'messageForExistingNumber')]//following-sibling::label")
	WebElement rdoKeepExistingPhoneNumber;
	
	/**
	 * Click Starter package button for anonymous customer
	 * @param	bundleName : name of the bundle package
	 * @author Saurav.Goyal
	 */
	public void selectSolarisBundlePackage(String bundleName) {
		String xpathBundlePackage="//div[@class='mt-auto w-100']//button[contains(@aria-label,'"+ bundleName +"')]//span[@translate='global.cta.addToCart']";
		reusableActions.clickWhenReady(By.xpath(xpathBundlePackage), 120);
	}
	
	/**
	 * To click on the chevron of your cart
	 * @author Saurav.Goyal
	 */
	public void clkChevronDownYourCart() {
		reusableActions.waitForElementVisibility(downChevronCartSummary, 120);
		reusableActions.clickWhenReady(downChevronCartSummary, 120);
	}


	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkHomephone() {
		reusableActions.getWhenReady(checkboxHomephone, 20).click();
	}
	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkHomephoneMobile() {
		reusableActions.waitForElementVisibility(checkboxHomephone, 60);
		reusableActions.executeJavaScriptClick(checkboxHomephone);
	}

	/**
	 * To click on the chevron of your cart
	 * @author Saurav.Goyal
	 */
	public void clkChevronUpYourCart() {
		reusableActions.getWhenReady(upChevronCartSummary, 120).click();
	}
	
	/**
	 * To verify gwp promotion in the cart summary
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
			reusableActions.waitForElementVisibility(gwpYourCart, 120);
			return	reusableActions.isElementVisible(gwpYourCart);
	}

	/**
	 * To verify Bundles Page
	 * @return true if the Bundles is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyBundlesPage() {
		reusableActions.waitForElementVisibility(txtBundlesPage, 120);
		return	reusableActions.isElementVisible(txtBundlesPage);
	}

	/**
	 * To verify Bundles Page
	 * @return true if the Bundles is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyBundlesPageMobile() {
		reusableActions.waitForElementVisibility(txtBundlesPage, 120);
		return	reusableActions.isElementVisible(txtBundlesPage);
	}
	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @param	bundleName : name of the bundle package
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPForStarterPackage(String bundleName) {
		String xpathBundlePackage = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[contains(@class,'d-flex')]/preceding-sibling::section//p";
		return	reusableActions.isElementVisible(By.xpath(xpathBundlePackage), 120);
	}

	/**
	 * To verify the Session expiry Model
	 * @return true if the Session expiry Model has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySessionModel() {
		//Session expiry time  2 minutes
		reusableActions.staticWait(120000);
		return reusableActions.isElementVisible(popupSessionModel,60);
	}

	/**
	 * Click the Continue button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkContinueSession() {
		reusableActions.getWhenReady(btnContinueSession, 20).click();
	}

	/**
	 * To click on the chevron of the starter bundel package
	 * @param	bundleName : name of the bundle package
	 * @author Saurav.Goyal
	 */
	public void clkChevronSolarisStarterPackageNew(String bundleName) {
		String xpathBundlePackage = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[@class='row']//following-sibling::div[contains(@class,'dsa-rate-card__detail')]//span[@class='ds-icon rds-icon-chevron-down']";
		reusableActions.getWhenReady(By.xpath(xpathBundlePackage), 120).click();
	}
	
	/**
	 * To click on the chevron of any given bundle package
	 * @param	bundleName : give the name of the bundle as parameter
	 * @author Saurav.Goyal
	 */
	public void clkChevronForBundle(String bundleName) {
		String bundleXpath = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[@class='row']//following-sibling::div[contains(@class,'dsa-rate-card__detail')]//span[@class='ds-icon rds-icon-chevron-down']";
		reusableActions.getWhenReady(By.xpath(bundleXpath), 120).click();
	}
	
	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyUpgradingToIgnitebundelsModal() {
			reusableActions.waitForElementVisibility(modalUpgradingToIgnitebundels, 120);
			return	reusableActions.isElementVisible(modalUpgradingToIgnitebundels);
	}
	
	/**
	 * To click okay on the modal Upgrading To Ignite bundels
	 * @author Saurav.Goyal
	 */
	public void clkOkayUpgradingToIgnitebundelsModal() {
		reusableActions.getWhenReady(okayUpgradingToIgnitebundelsModal, 120).click();
	}
	
	
	/**
	 * Click keep my existing phone number radio button
	 * @author Saurav.Goyal
	 */
	public void clkRadioOptKeepMyExistingPhoneNumber() {
		reusableActions.getWhenReady(rdoKeepExistingPhoneNumber, 60).click();
	}
	
	/**
	 * Click + to add STB ignite TV boxes
	 * @author Saurav.Goyal
	 */
	public void clkPlusAddIgniteTVBoxes() {
		reusableActions.waitForElementVisibility(buttonAddIgniteTVBoxes, 90);
		reusableActions.getWhenReady(buttonAddIgniteTVBoxes, 30).click();
	}
	
	/**
	 * To Click Update cart button
	 * @author Saurav.Goyal
	 */
	public void clkUpdateCart() {
		reusableActions.getWhenReady(buttonUpdateCart, 60).click();
	}
	
	/**
	 * Verify visibility of upgrade now button
	 * @return	boolean true if the element is present else false
	 * @author Saurav.Goyal 
	 */
	public boolean verifyButtonUpgradeNow() {		
		reusableActions.waitForElementVisibility(buttonUpgradeNow, 120);
		return	reusableActions.isElementVisible(buttonUpgradeNow);
	}
	
	/**
	 * click upgrade now button
	 * @author Saurav.Goyal 
	 */
	public void clkButtonUpgradeNow() {		
		reusableActions.getWhenReady(buttonUpgradeNow, 120).click();
	}

	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @param strAddress address to check the service availability 
	 * @author chinnarao.vattam
	 */
	public void setIgniteAddressLookup(String strAddress) {
		reusableActions.getWhenReady(txaIgniteAddressLookup, 3).clear();
		reusableActions.getWhenReady(txaIgniteAddressLookup, 3).sendKeys(strAddress);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmit() {
		reusableActions.getWhenReady(btnIgniteAddressLookupSubmit, 30).click();
	}
	
	/**
	 * Click Continue button on Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAvailability() {
		reusableActions.getWhenReady(btnIgniteCheckAvailability, 30).click();
	}
	
	/**
	 * Click Activate Later button
	 * @author chinnarao.vattam
	 */
	public void clkActivateLater() {
		reusableActions.clickWhenReady(chkActivateLater, 30);
	}

	/**
	 * Click No thanks, continue button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkConfirmActivateLater() {
		reusableActions.clickWhenReady(btnActivateLater, 30);
		
	}

	/**
	 * To select the  Ignite TV Starter package on ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackage() {
		reusableActions.clickWhenReady(btnSolarisStarterPackage, 60);
	}
	
	/**
	 * To select the  Ignite TV Select package 
	 * @author chinnarao.vattam
	 */
	public void selectSolarisSelectPackage() {
		//reusableActions.scrollToElementAndClick(btnSolarisSelectPackage);
		reusableActions.getWhenReady(btnSolarisSelectPackage, 60).click();
	}
	
	/**
	 * Click Continue on the  Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue, 60);
	}
	
	/**
	 * Click Continue on the  Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkGoodNewsContinue() {
		reusableActions.clickWhenReady(btnGoodNewsContinue, 30);
	}
	
	/**
	 * Click No thanks, continue button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkNoThanksContinue() {
		reusableActions.clickWhenReady(btnNoThanksContinue, 60);
	}

	/**
	 * To verify the home phone options
	 * @return true if the phone popup has launched, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyHomePhone() {
		reusableActions.waitForElementVisibility(btnHomePhoneContinue, 60);
		return	reusableActions.isElementVisible(btnHomePhoneContinue);
	}
	
	/**
	 * To verify the important information popup
	 * @return true if the information popup has launched, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyImportantInformation() {
		reusableActions.waitForElementVisibility(popImportantInformation, 60);
		return	reusableActions.isElementVisible(popImportantInformation);
	}
	
	/**
	 * Click the I understand button on the important information popup
	 * @author chinnarao.vattam
	 */
	public void clkIUnderstand() {
		reusableActions.getWhenReady(btnIUnderstand, 60).click();
	}
		
	/**
	 * Click Home phone button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkHomePhone() {
		reusableActions.waitForElementVisibility(btnHomePhoneContinue, 30);
		reusableActions.getWhenReady(btnHomePhoneContinue, 10).click();
	}

	/**
	 * Click Keep My Number button on port-in page
	 * @author chinnarao.vattam
	 */
	public void clkKeepMyNumber() {
		reusableActions.getWhenReady(btnKeepMyNumber, 90).click();
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void set4KTV() {	
		reusableActions.getWhenReady(rdo4KTV, 120);
		//reusableActions.scrollToElement(rdo4KTV);		
		reusableActions.executeJavaScriptClick(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void set4KTVMobile() {		
		reusableActions.executeJavaScriptClick(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verify4KTV() {
		return	reusableActions.isElementVisible(rdo4KTV,90);
	}
	
	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckout() {
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,90);
		reusableActions.getWhenReady(btnCheckout, 20).click();
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,90);
	}
	
	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckoutMobile() {
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,90);
		reusableActions.executeJavaScriptClick(btnCheckout);
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,90);
	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageNew() {
		reusableActions.waitForElementVisibility(btnSolarisStarterPackageNew, 180);
		reusableActions.getWhenReady(btnSolarisStarterPackageNew, 60).click();
	}
	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageMobile() {
		reusableActions.waitForElementVisibility(btnSolarisStarterPackageNew, 120);
		reusableActions.executeJavaScriptClick(btnSolarisStarterPackageNew);
		//reusableActions.getWhenReady(btnSolarisStarterPackageMobile, 60).click();
	}

	/**
	 * Click Starter package to check Service ability for Starter package
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageServiceability() {
		reusableActions.clickWhenReady(btnSolarisStarterPackageServiceability, 90);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verify4KTVSelection() {
		return	reusableActions.isElementVisible(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyOptNewPhone() {
		reusableActions.waitForElementVisibility(rdoOptNewPhone, 120);
		return	reusableActions.isElementVisible(rdoOptNewPhone);
	}
	
	/**
	 * Select the New Phone radio button
	 * @author chinnarao.vattam
	 */
	public void selectOptNewPhone() {
		reusableActions.getWhenReady(rdoOptNewPhone, 60).click();
		reusableActions.waitForElementVisibility(rdoOptNewPhoneEnable,60);		
	}

	/**
	 * Click the OptPhone button 
	 * @author chinnarao.vattam
	 */
	public void clickOptPhone() {
		reusableActions.clickWhenReady(btnOptPhone, 120);
	}

	/**
	 * Click the Channels button
	 * @author chinnarao.vattam
	 */
	public void clickChannels() {
		reusableActions.waitForElementVisibility(tabChannelsTab, 90);
		reusableActions.moveToElementAndClick(tabChannelsTab, 90);
	}

	/**
	 * Click the Bundles button
	 * @author chinnarao.vattam
	 */
	public void clickBundles() {
		reusableActions.waitForElementVisibility(tabBundles, 90);
		reusableActions.moveToElementAndClick(tabBundles, 30);
	}

	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @author chinnarao.vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtEmailContainer,30);
		reusableActions.getWhenReady(txtEmailContainer,10).click();
		reusableActions.clickWhenReady(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(strEmail);
	}

	/**
	 * Click the Okay button
	 * @author chinnarao.vattam
	 */
	public void clickOkay() {
		reusableActions.getWhenReady(btnOkay, 60).click();
	}

	/**
	 * Click the Submit button
	 * @author chinnarao.vattam
	 */

	public void clickSubmit() {
		reusableActions.clickWhenReady(btnSubmit, 20);
	}
	/**
	 * Click the Email Checkbox
	 * @author chinnarao.vattam
	 */
	public void clickEmailCheckbox() {
		reusableActions.clickWhenReady(clkEmailCheckbox, 20);
	}

	/**
	 * Click the Continue button
	 * @author chinnarao.vattam
	 */
	public void clickContinue() {
		reusableActions.clickWhenReady(clkContinue, 20);
	}

	/**
	 * Verify the Welcome back Popup
	 * @return true if Welcome back Popup  display when we back to bundle buy, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyWelcomeBackPopup() {
		return reusableActions.isElementVisible(clkContinue,30);
	}

	/**
	 * Verify the Email Modal
	 * @return true if Email Modal display the abondone action, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyEmailModal() {
		return reusableActions.isElementVisible(popupEmailModal,30);
	}

	/**
	 * Verify the Confirmation Modal
	 * @return true if Email Modal display the abondone action, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyConfirmation() {
		return reusableActions.isElementVisible(btnOkay,30);
	}

	/**
	 * Click the MyRogers link
	 * @author chinnarao.vattam
	 */
	public void clickMyRogers() {
		reusableActions.clickWhenReady(lnkMyRogers, 20);
	}
	/**
	 * Verify the Ignite TV Starter Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageRatecard() {		
		return reusableActions.isElementVisible(elmStarterRatecard);
	}
	
	/**
	 * Verify the Ignite TV Popular Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Popular Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageRatecard() {		
		return reusableActions.isElementVisible(elmPopularRatecard);
	}
	
	/**
	 * Verify the Ignite TV Select Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySelectPackageRatecard() {		
		return reusableActions.isElementVisible(elmSelectRatecard);
	}
	
	/**
	 * Verify the Ignite TV Premier Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageRatecard() {		
		return reusableActions.isElementVisible(elmPremierRatecard);
	}
	
	/**
	 * Verify the Ignite TV Starter Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageChannels() {		
		reusableActions.isElementVisible(txtStarterChannels);
		String strChannels = txtStarterChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("37 chaînes") || strChannels.equalsIgnoreCase("37 Channels"))
		return true;
		else 
	    return false;
	}
	
	/**
	 * Verify the Ignite TV Popular Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Popular Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageChannels() {		
		reusableActions.isElementVisible(txtPopularChannels);
		String strChannels = txtPopularChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("151 chaînes") || strChannels.equalsIgnoreCase("151 Channels"))
		return true;
		else 
	    return false;
	}
	
	/**
	 * Verify the Ignite TV Select Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySelectPackageChannels() {		
		reusableActions.isElementVisible(txtSelectChannels);
		String strChannels = txtSelectChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("119 chaînes") || strChannels.equalsIgnoreCase("119 Channels"))
		return true;
		else 
	    return false;
	}
	
	/**
	 * Verify the Ignite TV Premier Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageChannels() {		
		reusableActions.isElementVisible(txtPremierChannels);
		String strChannels = txtPremierChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("192 chaînes") || strChannels.equalsIgnoreCase("192 Channels"))
		return true;
		else 
	    return false;
	}
}
