package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RogersSolarisTVDashboardPage extends BasePageClass {

	public RogersSolarisTVDashboardPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//button[@aria-label='View more details about Ignite Flex 5']/span")
	WebElement btnViewMoreDetails;

	@FindBy(xpath="//button[@aria-label='Hide details about Ignite Flex 5']/following-sibling::ds-expander/descendant::div[@translate='global.label.additionalFeatures']")
	WebElement txtAdditionalFeature;

	@FindBy(xpath="//button[@aria-label='Hide details about Ignite Flex 5']/span")
	WebElement btnHideDetails;

	@FindBy(xpath="//button[@aria-label='Hide details about Ignite Flex 5']/following-sibling::ds-expander/descendant::div[@translate='global.label.additionalFeatures']/parent::div/descendant::li")
	WebElement listAdditionalFeature;


	@FindBy(xpath ="//span[text()=' TV '  or text() =' Télévision ']/ancestor::rss-subscription-detail-row//a[contains(@class,'ds-link')]//span[@role='text']")
	WebElement btnSolaristvBadge;
	
	@FindBy(xpath = "//div[@class='col-md-12 loading']")
	WebElement loaderTVdashboard;
	
	@FindBy(xpath = "//span[text()='View my channel lineup']")
	WebElement lnkViewMyChannelLineup;
    //ins[@usertype-translate='global.dashboard.tv.viewMyChannelLineup']
	//span[@translate='global.dashboard.tv.viewFlexChannels']

	@FindBy(xpath = "//span[@translate='global.modals.viewMyChannelsModal.viewAsPdf']")
	WebElement lnkViewAsPDF;
	//ins[@translate='global.modals.viewMyChannelsModal.viewAsPdf']

	@FindBy(xpath = "//embed[@id='plugin']")
	WebElement lnkPDFPage;

	@FindAll({@FindBy(xpath = "//span[text()='FR']"),
			@FindBy(xpath = "//div[@class='d-flex align-items-center container']//span[contains(text(),'Français')]")
	})
	WebElement lnkFR;

	@FindBy(xpath = "//button[@aria-label='View more details about your package' and @aria-expanded='false']/span")
	WebElement lnkMoreDetails;

	@FindBy(xpath = "//button[@aria-label='View more details about your package' and @aria-expanded='true']/span")
	WebElement lnkMoreDetailsExpanded;

	@FindBy(xpath = "//a[@class='contact-line__cta' and @href='tel:1 855 759-5856']/span")
	WebElement lnkCallUs;

	@FindBy(xpath = "//span[contains(@class,'ds-color-success')]")
	WebElement iconSuccessLTQModal;

	@FindBy(xpath = "//h1[@class='modal-header-copy']")
	WebElement headerLTQModal;

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.tvMDUPackageDisplayNumber']/ancestor::a[@href='tel:1 8557595856']")
	WebElement lnkCallUsLTQModal;

	@FindBy(xpath = "//h1[@class='modal-header-copy']/parent::div/following-sibling::div")
	WebElement txtLTQModalContent;

	@FindBy(xpath = " //span[contains(@class,'rds-icon-close')]")
	WebElement imgCloseLTQModal;

	@FindBy(xpath = "//div[@class='channels-container']")
	WebElement lstChannelList;
	//div[@class='channel-list-block']

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement popupCloseChannel;
	//button[@class='closeModalBtn']

	@FindBy(xpath = "//span[text()='View my Flex Channels']")
	WebElement lnkViewfelxChannels;
	//ins[@usertype-translate='global.dashboard.tv.viewMyFlexChannels']
	//span[@translate='global.dashboard.tv.viewLineup']

	@FindBy(xpath ="//a[contains(@aria-label,'View Offer') or contains(@aria-label,'View offer')]/span | //a[contains(@aria-label,'personnalisée')]/span")
	WebElement btnPersonalizedOffer;

	@FindBy(xpath = "//button[contains(@aria-label,'Change TV package') or  contains(@aria-label,'Modifier le forfait Télé')]")
	WebElement btnChangeTVPackage;
	//ins[@translate='global.cta.changeTVPackage']

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.manageChannelsAndThemePacks.buttonName']/ancestor::span[@role='text']")
	WebElement btnManageChannelsAndThemePacks;
	//ins[@translate='global.cta.addChannelsOrThemePacksTv']

	//@FindBy(xpath = "//span[contains(text(),'Continue')]/ancestor::a/span")
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	WebElement popupChangeTVPackage;
	//ins[@translate='global.cta.bysContinue']

	@FindBy(xpath = "//span[text()='Want to change your TV package?' or text()='Vous voulez changer votre forfait télé?']")
	WebElement headerChangepkg;

	//@FindBy(xpath = "//span[text()='Changing your TV package' or text()='Changer votre forfait Télé.']")
	@FindBy(xpath="//span[text()='Changes to your Ignite services']")
	WebElement headerChangeTVpkg;

	@FindBy(xpath = "//div[@class='popup-modal-body__content']")
	WebElement txtContactUsPopupModal;

	@FindBy(xpath = "//h2[contains(@class,'popup-modal-body__heading')]")
	WebElement headerChangeTVPkgContent;

	@FindBy(xpath = "//div[@class='popup-modal-body__content']/descendant::li")
	WebElement txtChangeTVPkgPopupModal;

	@FindBy(xpath = "//button[@aria-label='Cancel' or @aria-label='Annuler']")
	WebElement btnCancel;

	@FindBy(xpath = "//ds-icon[@name='call']/span[@role='img']")
	WebElement imgBookACallBack;

	@FindBy(xpath = "//span[text()='Book a call back' or text()='Fixer une heure de rappel']")
	WebElement lnkBookACallBack;

	@FindBy(xpath = "//ds-icon[@name='text']/span[@role='img']")
	WebElement imgLiveChat;

	@FindBy(xpath = "//span[contains(@bcKey, 'loggedIn')]/descendant::span[text()='Live Chat']")
	WebElement lnkLiveChat;

	@FindBy(xpath = "//a[contains(@aria-label, 'Contact')]")
	WebElement lnkContactUs;

	@FindBy(xpath = "//h1[@aria-labelledby='ariaPopupHeader']")
	WebElement popupContatUS;
	//div[@class='live-support']

	@FindBy(xpath = "//a[@id='ctaExchangeFlex']")
	WebElement lnkChangeFlexChannels;

	@FindBy(xpath = "//a[@id='ctaExchangeFlexMobile']")
	WebElement lnkChangeFlexChannelsMobile;

	@FindBy(xpath = "//input[@id='searchFilter_swapout']")
	WebElement infoChannelSwapoutSeach;

	@FindBy(id = "searchFilter_swapin")
	WebElement infoChannelSwapinSeach;

	@FindBy(xpath = "//button[@class='ute-btn-primary']")
	WebElement btnConfirmExchange;

	@FindBy(xpath = "//a[@aria-label='Exchange now']")
	WebElement btnExchangeNow;

	@FindBy(xpath = "//div[@id='tvPopupTitle']/i[@class='ute-icon']")
	WebElement infoSuccessIcon;	

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite TV Starter') or contains(normalize-space(.),'Télé Élan Découverte')]")
	WebElement txtIgniteTVStarter;
	 
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite TV Select') or contains(normalize-space(.),'Télé Élan Sélection')]")
	WebElement txtIgniteTVSelect;
	 
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite TV Premier') or contains(normalize-space(.),'Télé Élan Premier')]")
	WebElement txtIgniteTVPremier;
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite Flex 5') or contains(normalize-space(.),'Élan Flex 5')]")
	WebElement txtIgniteFlex5;
	 
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite Flex 10') or contains(normalize-space(.),'Élan Flex 10')]")
	WebElement txtIgniteFlex10;

	@FindBy(xpath="//span[contains(@class,'color-success')]")
	WebElement successMessageParentalControlAndPinReset;

	@FindBy(xpath="//span[contains(@class,'color-success')]")
	WebElement successRefreshYourIgniteTVBox;

	@FindBy(xpath="//span[contains(@class,'color-success')]")
	WebElement successResetPurchasePIN;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement btnOk;

	@FindBy(xpath = "//span[contains(text(),'Réinitialiser le NIP pour le contrôle parental') or contains(text(),'Reset Parental Control PIN')]/ancestor::span[@role='text']")
	WebElement lnkResetParentalConrolsAndPin;

	@FindBy(xpath = "//span[contains(text(),'Actualiser vos terminaux Télé Élan') or contains(text(),'Refresh') ]/ancestor::span[@role='text']")
	WebElement lnkRefreshYourIgniteTVBox;

	@FindBy(xpath = "//span[contains(text(),'Reset Purchase PIN') or contains(text(),'Réinitialiser le NIP d’achat')]/ancestor::span[@role='text']")
	WebElement lnkResetPurchasePIN;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnContinueParentalControlAndPinReset;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnRefreshYourIgniteTVBox;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnResetPurchasePIN;

	@FindBy(xpath = "//i[@class='ute-icon-button-right']")
	WebElement imgNext;
	
	@FindBy(xpath = "//i[@class='ute-icon-button-left']")
	WebElement imgPrevious;
		
	@FindBy(xpath = "//span[text()=' Home Monitoring '  or text() =' Système domotique ']/ancestor::rss-subscription-detail-row//a[contains(@class,'ds-link')]//span[@role='text']")
	WebElement btnSHMBadge;
	
	@FindBy(xpath = "//ins[@usertype-translate='global.dashboard.tv.digitalBoxes']")
	WebElement lblBoxHeader;

	@FindBy(xpath = "//ins[@translate='global.dashboard.tv.digitalBoxSettings']")
	WebElement lblBoxSettings;

	@FindBy(xpath = "//h1[@class='tv-dashboard-hdr' or text()='Ignite SmartStream']")
	WebElement lblHeaderTV;
	
	@FindBy(xpath = "//div[@class='col-md-12 loading']")
	WebElement ldrTVdashboard;
	
	@FindBy(xpath = "//div[@class='loading']")
	WebElement ldrThemepack2;
	
	@FindBy(xpath = "//h2[@class='all-channels__header']")
	WebElement txtFlexChannels;
	//h3[@class='copy-1 font-medium margin-0']

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement loaderTVDashboard;

	@FindBy(xpath = "//span[@id='ariaPopupHeader']")
	WebElement popupChangeTVPkg;

	
	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkResetParentalConrolsAndPin() {
		getReusableActionsInstance().staticWait(20000);
		getReusableActionsInstance().clickWhenReady(lnkResetParentalConrolsAndPin,40);
	}

	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkRefreshYourIgniteTVBox() {
		getReusableActionsInstance().clickWhenReady(lnkRefreshYourIgniteTVBox,40);
	}

	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkResetPurchasePIN() {
		getReusableActionsInstance().clickWhenReady(lnkResetPurchasePIN,40);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkContinueParentalControlAndPinReset() {
		getReusableActionsInstance().clickWhenReady(btnContinueParentalControlAndPinReset,90);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkRefreshYourIgniteTVBoxContinue() {
		getReusableActionsInstance().clickWhenReady(btnRefreshYourIgniteTVBox,90);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkResetPurchasePINContinue() {
		getReusableActionsInstance().clickWhenReady(btnResetPurchasePIN,90);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkOkContinue() {
		getReusableActionsInstance().clickWhenReady(btnOk,90);
	}

	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadge() {
		getReusableActionsInstance().waitForElementVisibility(btnSolaristvBadge,60);
		getReusableActionsInstance().executeJavaScriptClick(btnSolaristvBadge);

	}

	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadgeMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnSolaristvBadge,90);
		getReusableActionsInstance().executeJavaScriptClick(btnSolaristvBadge);
		getReusableActionsInstance().waitForPageLoad();
	}
	
	/**
	 * Verify the view my channel lineup link on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the view my channel lineup link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMyChannelLineup() {		
		return getReusableActionsInstance().isElementVisible(lnkViewMyChannelLineup);
	}

	/**
	 * Verify Exchange Now Button is present or not
	 * @return true if the Exchange Now button is present, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyExchangeNow() {
		return getReusableActionsInstance().isElementVisible(btnExchangeNow);
	}
	/**
	 * Click the view my channel lineup link on Solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkViewMyChannelLineup() {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='View my channel lineup']")));
		getReusableActionsInstance().getWhenReady(lnkViewMyChannelLineup, 30).click();
	}

	/**
	 * Verify the PDF link on MyChannelLineup popup
	 * @return true if the MyChannelLineup popup display the PDF link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPDF() {		
		return getReusableActionsInstance().isElementVisible(lnkPDFPage);
	}

	/**
	 * Click the PDF link on MyChannelLineup popup
	 * @return true if the PDF is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean clklAndVerifyViewPDF() {
		String mainWindow = getDriver().getWindowHandle();
		getReusableActionsInstance().getWhenReady(lnkViewAsPDF,90).click();
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
	 * Verify the channel list on MyChannelLineup popup
	 * @return true if the MyChannelLineup popup display the channel list, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChannelList() {		
		return getReusableActionsInstance().isElementVisible(lstChannelList,20);
	}

	/**
	 * Click on close button on MyChannelLineup popup
	 * @author chinnarao.vattam
	 */
	public void clkCloseChannelsPopup() {
		getReusableActionsInstance().getWhenReady(popupCloseChannel,40);
		getReusableActionsInstance().executeJavaScriptClick(popupCloseChannel);
	}

	/**
	 * Click the ViewfelxChannels link on Solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkViewflexChannels() {
		getReusableActionsInstance().waitForElementVisibility(lnkViewfelxChannels, 60);
		getReusableActionsInstance().getWhenReady(lnkViewfelxChannels,10).click();
	}

	
	/**
	 * verify the ViewfelxChannels link on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the ViewfelxChannels link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyViewfelxChannels() {		
		return getReusableActionsInstance().isElementVisible(lnkViewfelxChannels,20);
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackage() {
		//NL and FL  Provinces taking long loading time to pull the dashboard details
		getReusableActionsInstance().staticWait(20000);
		By btnChangeTVPkg = By.xpath("(//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100'])[7]");
		getReusableActionsInstance().getWhenReady(btnChangeTVPkg, 120).click();
	}

	/**
	 * Scroll to View Personalized Offer.
	 * @author Manpreet.kaur3
	 */
	public void scrollToViewPersonalizedOffer() {
		//WebElement btnChangeTVPkg = getDriver().findElement(By.xpath("//button[contains(@aria-label,'Change TV package') or  contains(@aria-label,'Modifier le forfait Télé')]"));
		getReusableActionsInstance().getWhenReady(btnPersonalizedOffer, 60);
		getReusableActionsInstance().scrollToElement(btnPersonalizedOffer);
		getReusableActionsInstance().staticWait(5000);
	}

	/**
	 * Clicks on the view personalized offer button.
	 * @author Manpreet.kaur3
	 */
	public void clkViewOfferBadge() {
		getReusableActionsInstance().getWhenReady(btnPersonalizedOffer, 10).click();
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackageLetency() {
		//NL and FL  Provinces taking long loading time to pull the dashboard details
		//getReusableActionsInstance().waitForElementInvisibility(loaderTVDashboard,120);
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().waitForElementVisibility(btnChangeTVPackage,120);
		//getReusableActionsInstance().executeJavaScriptClick(btnChangeTVPackage);
		getReusableActionsInstance().getWhenReady(btnChangeTVPackage, 60).click();
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackageMobile() {
		getReusableActionsInstance().staticWait(10000);
		By btnChangeTVPkg = By.xpath("//button[contains(@aria-label,'Change TV package') or  contains(@aria-label,'Modifier le forfait Télé')]");
		getReusableActionsInstance().getWhenReady(btnChangeTVPkg, 120).click();
		//getReusableActionsInstance().executeJavaScriptClick((WebElement) btnChangeTVPkg);
	}
	/**
	 * Click the Manage Channels And Theme Packs link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkManageChannelsAndThemePacks() {
		getReusableActionsInstance().waitForElementVisibility(btnManageChannelsAndThemePacks,120);
		getReusableActionsInstance().getWhenReady(btnManageChannelsAndThemePacks, 30).click();
	}

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannels() {
		getReusableActionsInstance().waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		getReusableActionsInstance().getWhenReady(lnkChangeFlexChannels, 60).click();
	}

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannelsMobile() {
		//getReusableActionsInstance().waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		//Need ti to pull channels from ATG
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		getReusableActionsInstance().executeJavaScriptClick(lnkChangeFlexChannels);
		/*WebElement lnkChangeFlexChannelsMobile = getDriver().findElement(By.xpath("//a[@id='ctaExchangeFlexMobile']"));
		getReusableActionsInstance().waitForElementVisibility(lnkChangeFlexChannelsMobile, 60);
		getReusableActionsInstance().waitForElementTobeClickable(lnkChangeFlexChannelsMobile, 60);
		getReusableActionsInstance().executeJavaScriptClick(lnkChangeFlexChannelsMobile);*/
	}
	/**
	 * To verify Exchange FlexChanne link
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyExchangeFlexChannelLink() {
		return getReusableActionsInstance().isElementVisible(lnkChangeFlexChannels, 10);
       }
	
	/**
	 * To verify Exchange FlexChanne link
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyFlexChannelcount(String strFlexChannels) {
		// 0, 5, 44 channels
		String strChannels=getReusableActionsInstance().getWhenReady(txtFlexChannels, 50).getText();
		String[] channels = strChannels.split("\\s+");
		return channels[0].equals(strFlexChannels);
       }

	/**
	 * Selects the solaris tv package name to be upgrade or downgrade 
	 * @param strPackageNameEn solaris tv package name to be upgrade or downgrade
	 * @param strPackageNameFr solaris tv package name to be upgrade or downgrade  
	 * @author chinnarao.vattam
	 */
	public void selectSolarisTVPackage(String strPackageNameEn, String strPackageNameFr) {
		By packageNameLocator = By.xpath("//div[@class='ng-star-inserted']//button[contains(@aria-label, '" + strPackageNameEn + "') or contains(@aria-label, '" + strPackageNameFr + "')]/span");
		if(getReusableActionsInstance().isElementVisible(packageNameLocator,60))
		{		
		getReusableActionsInstance().getWhenReady(packageNameLocator, 20);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
		 }
	   else
		{
	    getReusableActionsInstance().getWhenReady(imgNext, 60);
	    getReusableActionsInstance().executeJavaScriptClick(imgNext);
	    WebElement pkg = getDriver().findElement(packageNameLocator);
	    getReusableActionsInstance().getWhenReady(pkg, 60);
	    getReusableActionsInstance().executeJavaScriptClick(pkg);
		}
	}

	/**
	 * Click the ChangeTV Package button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkPopupChangeTVPackage() {
		getReusableActionsInstance().getWhenReady(popupChangeTVPackage, 90).click();
	}

	/**
	 * Verify the ChangeTV Package button on solaris TV dashboard page
	 * @return true if Continue btn is present, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyPopupChangeTVPackageContinueBtn() {
		return getReusableActionsInstance().isElementVisible(popupChangeTVPackage, 30);
	}

	/**
	 * Click the ChangeTV Package button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkPopupChangeTVPackageMobile() {
		getReusableActionsInstance().waitForElementVisibility(popupChangeTVPackage, 90);
		getReusableActionsInstance().executeJavaScriptClick(popupChangeTVPackage);
	}
	/**
	 * Verify the contact us popup on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the contat us popup , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifycontatUSPopUp() {		
		return getReusableActionsInstance().isElementVisible(popupContatUS, 50);
	}

	/**
	 * Click the confirm exchange button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkConfirmExchange() {		
		getReusableActionsInstance().clickWhenReady(btnConfirmExchange, 30);
	}

	/**
	 * Verify the successful exchange icon on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the successful exchange icon  , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccessIcon() {		
		return getReusableActionsInstance().isElementVisible(infoSuccessIcon, 180);
	}
	
	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyResetParentalControlsAndPinSuccess() {		
		return getReusableActionsInstance().isElementVisible(successMessageParentalControlAndPinReset, 90);
	}

	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifysuccessRefreshYourIgniteTVBox() {
		return getReusableActionsInstance().isElementVisible(successRefreshYourIgniteTVBox, 90);
	}

	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifysuccessResetPurchasePIN() {
		return getReusableActionsInstance().isElementVisible(successResetPurchasePIN, 90);
	}

	/**
	 * It will take the channel list and search those channels on the in channel list panel, if it is available it will select and add to the channel list 
	 * @param strInChannellist channel list and search those channels on the in channel list panel
	 * @author chinnarao.vattam
	 */
	public void swapInChannel(String[] strInChannellist) {
		String strInChannel[] = strInChannellist;
		for (String channel : strInChannel) {
			getReusableActionsInstance().getWhenReady(infoChannelSwapinSeach, 90).clear();
			getReusableActionsInstance().getWhenReady(infoChannelSwapinSeach, 10).sendKeys(channel);
			By channelLocator = By.xpath("//a[@title='" + channel + "']");
			getReusableActionsInstance().getWhenReady(channelLocator, 90).click();
			By btnChannelLocator = By.xpath("//a[@title='" + channel
					+ "']/ancestor::li[@class='tv-channel-li']//button[@class='select-channel-btn']");
			getReusableActionsInstance().getWhenReady(btnChannelLocator, 10).click();
				}
	}
/**
 * It will take the channel list and search those channels on the out channel list panel, if it is available it will select and delete from the channel list
 * @param strOutChannellist channel list and search those channels on the out channel list panel
 * @author chinnarao.vattam
 */
	public void swapOutChannel(String[] strOutChannellist) {
		String strOutChannel[] = strOutChannellist;
		for (String channel : strOutChannel) {
			getReusableActionsInstance().getWhenReady(infoChannelSwapoutSeach, 30).clear();
			getReusableActionsInstance().getWhenReady(infoChannelSwapoutSeach, 10).sendKeys(channel);
			//By channelLocator = By.xpath("//a[@title='" + channel + "']");
			getReusableActionsInstance().waitForElementStaleness(getDriver().findElement( By.xpath("//a[@title='" + channel + "']")),3);
			getReusableActionsInstance().getWhenReady(By.xpath("//a[@title='" + channel + "']"), 20).click();
			
			By btnChannelLocator = By.xpath("//a[@title='" + channel
					+ "']/ancestor::li[@class='tv-channel-li']//button[@class='select-channel-btn']");
			getReusableActionsInstance().getWhenReady(btnChannelLocator, 20).click();
		}
	}
	

	/**
	 * Verify the Ignite TV Starter Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVStarterPackage() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteTVStarter);
	}
	
	/**
	 * Verify the Ignite TV Select Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVSelectPackage() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteTVSelect);
	}
	
	
	/**
	 * Verify the Ignite TV Premier Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVPremierPackage() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteTVPremier);
	}
	
	/**
	 * Verify the Ignite Flex 5 Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite Flex 5 Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteFlex5Package() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteFlex5);
	}
	
	/**
	 * Verify the Ignite Flex 10 Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite Flex 10 Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteFlex10Package() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteFlex10);
	}

	/**
	 * Checks if view my channel line up is displayed
	 * @return treu if link displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewMyChannelLineUpDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lnkViewMyChannelLineup,60);
	}

	/**
	 * Checks if view my flex channel  is displayed
	 * @return treu if link displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewFlexChannelsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lnkViewfelxChannels,60);
	}

	/**
	 * Clicks on SHM Badge
	 * @author Mirza.Kamran
	 */
	public void clkSHMBadge() {
		getReusableActionsInstance().executeJavaScriptClick(btnSHMBadge);
	}

	

	/**
	 * verifies if the Tupelo Dashboard is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTupeloDashbaordIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblHeaderTV);
		
	}

	/**
	 * Verifies if the smart screen box is displayed
	 * @return true if the box is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyBoxCountIsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblBoxHeader);
	}

	/**
	 * Smart screen box settings is displayed
	 * @return true if the box settings is displayed
	 */
	public boolean verifyBoxSettingslsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblBoxSettings);
	}

	/**
	 * Verifies if Change Package Header is present
	 * @return true if Header is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangePackagePopupHeader() {
		return getReusableActionsInstance().isElementVisible(headerChangepkg, 20);
	}


	/**
	 * Gets the Change Tv Package - Contact Us Modal content
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyContactUsModalContent() {
		String contactUsContentDesired = "Great! Contact us or book a call back – we’ll help you with all the details.";
		String contactUsContentActual = getReusableActionsInstance().getWhenReady(txtContactUsPopupModal, 20).getText();
		if(contactUsContentActual.equals(contactUsContentDesired)){
			return true;
		}

	return false;
	}

	/**
	 * Verifies if Book a call back link is present
	 * @return true if Book a call back link is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyBookACallBack() {
		getReusableActionsInstance().waitForElementVisibility(imgBookACallBack, 10);
		return getReusableActionsInstance().isElementVisible(lnkBookACallBack, 20);

	}

	/**
	 * Verifies if Live Chat link is present
	 * @return true if Live Chat link is present else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyLiveChat() {
		getReusableActionsInstance().waitForElementVisibility(imgLiveChat, 10);
		return getReusableActionsInstance().isElementVisible(lnkLiveChat, 20);
	}


	/**
	 * Gets the Change Package - Contact Us Modal content
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyContactUsModalContentFR() {
		String contactUsContentDesired = "Super! Communiquez avec nous ou choisissez une heure de rappel et nous réglerons les détails avec vous.";
		String contactUsContentActual = getReusableActionsInstance().getWhenReady(txtContactUsPopupModal, 20).getText();
		if(contactUsContentActual.equals(contactUsContentDesired)){
			return true;
		}

		return false;
	}

	/**
	 * Select FR as language preference
	 * @author manpreet.kaur3
	 */
	public void clkFR() {
		getReusableActionsInstance().getWhenReady(lnkFR, 60).click();
	}

	/**
	 * Click More Details link
	 * @author Manpreet.Kaur3
	 */
	public void clkMoreDetails() {
		getReusableActionsInstance().getWhenReady(lnkMoreDetails, 20).click();
	}

	/**
	 * Verify More Details link is expanded
	 * @retun true if More Details link is expanded , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyMoreDetailsExpanded() {
		return getReusableActionsInstance().isElementVisible(lnkMoreDetailsExpanded, 20);
	}

	/**
	 * Verify the number is text or link for Bulk Tenant on TV Dashboard page
	 * @retun true if the number is clickable , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyCallUs() {
		return  getReusableActionsInstance().isElementVisible(lnkCallUs, 20);
	}

	/**
	 * Verify the LTQ modal
	 * @retun true if the success icon is visible , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyLTQModal() {
		getReusableActionsInstance().waitForElementVisibility(iconSuccessLTQModal, 20);
		return getReusableActionsInstance().isElementVisible(iconSuccessLTQModal);
	}

	/**
	 * Verify the LTQ modal Header
	 * @retun true if the LTQ modal Header is as per requirement , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyLTQModalHeader() {
		String expectedLTQHeader = "Add Channels & Theme Packs to your bundle.";
		String actualLTQHeader = getReusableActionsInstance().getWhenReady(headerLTQModal).getText();
		return actualLTQHeader.equals(expectedLTQHeader);
	}

	/**
	 * Verify the LTQ modal content
	 * @retun true if the LTQ modal copy is as per requirement , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyLTQModalContent() {
		String expectedLTQModalCopy = "Call us at 1 855 759-5856 and we'll help you with all the details";
		String actualLTQModalCopy = getReusableActionsInstance().getWhenReady(txtLTQModalContent).getText();
	    return actualLTQModalCopy.equals(expectedLTQModalCopy);
	}

	/**
	 * Verify LTQ modal Call Us Link
	 * @retun true if the LTQ modal Call Us is a Link , else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyLTQModalCallUsLink() {
		return getReusableActionsInstance().isElementVisible(lnkCallUsLTQModal);
	}

	/**
	 * Clicks on close icon on LTQ modal
	 * @author Manpreet.Kaur3
	 */
	public void clkCloseLTQMOdal() {
		getReusableActionsInstance().getWhenReady(imgCloseLTQModal, 10).click();
	}

	/**
	 * Verify the contact us popup on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the contat us popup , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChangeTVPackagePopUp() {
		return getReusableActionsInstance().isElementVisible(popupChangeTVPkg, 50);
	}
	/**
	 * Verifies if Change TV Package (PTM modal) Header is present
	 * @return true if Header is present else false
	 * @author manpreet.kaur3
	 */

	public boolean verifyChangeTVPackagePopupHeader() {
		return getReusableActionsInstance().isElementVisible(headerChangeTVpkg, 60);
	}

	/**
	 * Gets the Change TV Package Modal content header
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangeTVPackageModalContentHeader() {
		String changeTVPkgContentHeaderDesired = "We want to make your new service as similar to your current one as possible to give you the best experience! But please note that by making this change:";
		String changeTVPkgContentHeaderActual = getReusableActionsInstance().getWhenReady(headerChangeTVPkgContent, 20).getText();
		if(changeTVPkgContentHeaderActual.equals(changeTVPkgContentHeaderDesired)){
			return true;
		}

		return false;
	}

	/**
	 * Gets the Change TV Package content
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangeTVPackageModalContent() {
		String changeTVPkgContentDesired = "Added Standalone Channels or Theme Packs will be removed";
		String changeTVPkgContentActual = getReusableActionsInstance().getWhenReady(txtChangeTVPkgPopupModal, 20).getText();
		if(changeTVPkgContentActual.equals(changeTVPkgContentDesired)){
			return true;
		}

		return false;
	}

	/**
	 * Verify Cancel btn on Change TV Package Popup
	 * @return true if cancel btn is present, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangeTVPackageCancelBtn() {
		return getReusableActionsInstance().isElementVisible(btnCancel, 20);
	}

	/**
	 * Gets the Change TV Package Modal content header
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangeTVPackageModalContentHeaderFR() {
		String changeTVPkgContentHeaderDesired = "Nous voulons que vous puissiez profiter de la meilleure expérience qui soit avec votre nouveau service et que celui-ci soit comparable à que vous aviez précédemment! Toutefois, veuillez prendre note qu’en effectuant ce changement:";
		String changeTVPkgContentHeaderActual = getReusableActionsInstance().getWhenReady(headerChangeTVPkgContent, 40).getText();
		if(changeTVPkgContentHeaderActual.equals(changeTVPkgContentHeaderDesired)){
			return true;
		}

		return false;
	}

	/**
	 * Gets the Change TV Package content
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyChangeTVPackageModalContentFR() {
		String changeTVPkgContentDesired = "Les chaînes à la carte et les forfaits à thème auxquels vous êtes abonné sont retirés de votre compte.";
		String changeTVPkgContentActual = getReusableActionsInstance().getWhenReady(txtChangeTVPkgPopupModal, 20).getText();
		if(changeTVPkgContentActual.equals(changeTVPkgContentDesired)){
			return true;
		}

		return false;
	}

	public void clkViewMoreDetailsFlex5() {
		getReusableActionsInstance().getWhenReady(btnViewMoreDetails, 90).click();
	}

	public void clkHideDetailsFlex5() {
		getReusableActionsInstance().getWhenReady(btnHideDetails, 30).click();
	}

	public boolean verifyIgniteBoxPrice() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(txtAdditionalFeature);
		String additionalFeatureText = getReusableActionsInstance().getWhenReady(listAdditionalFeature, 30).getText();
		String[] subs= additionalFeatureText.split("\\$");
		if(subs.length > 1) {
			String[] finalPrice = subs[1].split(" ");
			if (finalPrice[0].equals("0")) {
				return false;
			}
		}
		return true;

	}


}
