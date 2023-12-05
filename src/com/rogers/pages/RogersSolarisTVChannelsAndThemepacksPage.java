package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersSolarisTVChannelsAndThemepacksPage extends BasePageClass {

	public RogersSolarisTVChannelsAndThemepacksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@id='tab-themepack']")
	WebElement btnThemepacksTab;

	@FindBy(xpath = "//button[@aria-label='Add Prime Time Pack to cart']/span")
	WebElement btnAddPrimePack;

	@FindBy(xpath = "//button[@aria-label='Remove Prime Time Pack from cart']")
	WebElement btnRemovePrimePack;

	@FindBy(xpath ="//button[@aria-label='Continue']/span | //button[@aria-label='Continuer']/span")
	WebElement btnMiniCartContinue;

	@FindBy(xpath ="//a[@aria-label='No, I don’t have a 4K TV']/span | //a[@aria-label='Non, il n’a pas de téléviseur 4K']/span")
	WebElement btnNoIDontHave4K;

	@FindBy(xpath="//span[text()='Continue' or text()='Continuer']")
	WebElement btnContinueFromThemepacks;
	//ins[@translate='global.cta.continue']

	@FindBy(xpath = "//span[contains(text(),'Yes, I have a 4k TV') or contains(text(),'Oui, il a un téléviseur 4K')]")
	WebElement btnYesIHave4K;
	//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@usertype-translate='global.cta.yesIHave4K']

	@FindBy(xpath = "//span[contains(text(),'Yes, I have a 4k TV') or contains(text(),'ai un téléviseur 4k')]")
	WebElement btnYesIHave4KMobile;
	//span[contains(text(),'Yes, they do') or contains(text(),'Oui, ils le font')]
	//span[contains(text(),'Yes, I have a 4k TV') or contains(text(),'ai un téléviseur 4k')]

	@FindBy(xpath = "//span[@translate='global.cta.continue']")
	WebElement btn4KContent;
	//ds-icon[@name='chevron-right']/ancestor::button
	//button[contains(@class,'continue-btn-4k')]//ins[@translate='global.cta.continue']

	@FindBy(xpath = "//span[contains(text(), 'have a 4k TV')] | //button[contains(@aria-label,'Add 4K') or contains(@aria-label,'4K')]/span")
	WebElement btnAdd4kContent;

	//@FindBy(xpath = "//span[@translate='global.cta.bysSwapLaterContinue']")
	@FindBy(xpath="//span[text()='Continue']")
	WebElement btnExchangeLater;
	//ins[@translate='global.cta.bysSwapLaterContinue']

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//div[@class='channel-list-row']//button[@class='ute-btn-primary ute-sm ute-short']//ins")
	List<WebElement> addParticularChannelToCart;
	
	@FindBy(xpath = "//div[@class='channel-list-row']//button[@class='ute-btn-primary ute-sm ute-short']//ins")
	WebElement addChannelToCart1;

	@FindBy(xpath = "//span[contains(text(),'FAITHTV') or contains(text(),'Baby TV')]/ancestor::tr//span[@translate='global.cta.add']/..")
	WebElement addChannelToCart;
	//Baby TV

	@FindBy(xpath = "//input[@id='searchTyping_']")
	WebElement iconSearch;

	@FindBy(xpath = "//select[@aria-describedby='formfield-5-a11yDescription formfield-5-messages']")
	WebElement selGenres;

	@FindBy(xpath = "//span[@class='genre-dropdown-component']/descendant::select")
	WebElement drpdwnGenre;

	@FindBy(xpath = "//button[contains(@id,'remove-channel')]//ins")
	WebElement removeParticularChannelFromCart;
	
	@FindBy(xpath = "//button[@id='remove-themepack-button']")
	WebElement removeParticularThemePackFromCart;
	
	@FindBy(xpath = "//h4[@class='added-removed-header']//i[@class='ute-icon-chevron-up']")
	WebElement chevronUp;

	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set ute-btn')]//ins[@translate='global.cta.removeChannel']")
	WebElement buttonRemoveChannelFromAlert;
	
	@FindBy(xpath = "//button[@name='tab-themepack']")
	WebElement tabThemePacks;
	//ins[@translate='global.label.bysThemePacksTab']/ancestor::h2

	@FindBy(xpath = "//button[contains(@id,'add-themepack')]//ins[@translate='global.cta.add']")
	List<WebElement> addThemePack;
	
	@FindBy(xpath = "//button[@id='add-themepack-button']")
	List<WebElement> addThemePackListOnManageChannelsAndThemePacks;

	@FindBy(xpath="//button[contains(@aria-label,'Hollywood Suite')]")
	WebElement addThemePackClassicTVThemePacks;
	//h3[@class='themepack-detail__header']//span[contains(text(),'Classic TV & Movies')]/ancestor::div[@class='themepack-detail channels-container']//span[@translate='global.cta.add']/ancestor::button

	@FindBy(xpath="//button[contains(@aria-label,'Prime Time Pack')]")
	WebElement addThemePackClassicTVThemePacks4plus1;
	//h3[@class='header-1 font-regular margin-0' and contains(text(),'Super Sports Pack (TP)')]/ancestor::div[@class='row theme-header']//button[@id='add-themepack-button']
	
	@FindBy(xpath = "//span[@translate= 'global.modals.conflictWarnings.themepackToFlexWarning.primaryButton']/ancestor::span[@role='text']")
	WebElement yesContinueOnExistingChannelAlert;
	//button[@class='ute-btn-primary ute-md']

	@FindBy(xpath = "//span[@translate='global.cta.confirmChanges']")
	WebElement clkConfirmChangesOnManageChannelsAndThemePacks;
	//ins[@usertype-translate='global.cta.confirmChanges']

	@FindBy(xpath = "//div[@class='tv-channel-body']//ins[@translate='global.cta.remove']")
	WebElement btnRemoveFromYourChanges;	
	
	@FindBy(xpath = "//div[@class='solaris-loader']")
	WebElement ldrThemepackChannel;
	
	@FindBy(xpath = "//div[@class='preloader loading-secondary']")
	WebElement ldrThemepack;
		
	@FindBy(xpath = "//span[@class='ute-icon-search noClickIcon']")
	WebElement btnSearchChannel;
	
	/**
	 * Click on add button of the first pack in theme pack in manage channels and theme pack
	 * @author chinnarao.vattam	 
	 */
	public void clkAddButtonOnThemePackListOnManageChannelsAndThemePacks() {
		//Taking more time to load all the themepacks from ATG
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementVisibility(addThemePackClassicTVThemePacks, 120);
		getReusableActionsInstance().executeJavaScriptClick(addThemePackClassicTVThemePacks);
	}		
	
	/**
	 * Click on add button of the first pack in theme pack in manage channels and theme pack
	 * @author chinnarao.vattam	 
	 */
	public void clkAddButtonOnThemePackListOnManageChannelsAndThemePacks4plus1() {
		//Taking more time to load all the themepacks from ATG
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().waitForElementVisibility(addThemePackClassicTVThemePacks4plus1, 120);
		getReusableActionsInstance().executeJavaScriptClick(addThemePackClassicTVThemePacks4plus1);
	}
	/**
	 * Click on remove from your changes Manage channels and theme packs
	 * @author Saurav.Goyal	 
	 */
	public void clkRemoveFromYourChanges() {
		getReusableActionsInstance().getWhenReady(btnRemoveFromYourChanges, 120).click();
	}	
	
	
	/**
	 * Click on Confirm changes While adding channels in Manage channels and theme packs
	 * @author chinnarao.vattam	 
	 */
	public void clkConfirmChangesOnManageChannelsAndThemePacks() {
		//Taking more time to load all the themepacks from ATG
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(clkConfirmChangesOnManageChannelsAndThemePacks, 120).click();
	}	
	
	/**
	 * Add first channel from the list
	 * @author chinnarao.vattam	 
	 */
	public void addChannel() {
		By addChannel = By.xpath("//span[contains(text(),'FAITHTV') or contains(text(),'Baby TV')]/ancestor::tr//span[@translate='global.cta.add']/ancestor::span[@role='text']");
		getReusableActionsInstance().getWhenReady(addChannel, 180).click();
	}
	
	/**
	 * Add first channel from the list
	 * @param strInChannel  available channel
	 * @author chinnarao.vattam	 
	 */
	public void searchChannel(String strInChannel) {
		getReusableActionsInstance().waitForElementVisibility(iconSearch,120);
		getReusableActionsInstance().getWhenReady(iconSearch,20).click();
		getReusableActionsInstance().getWhenReady(iconSearch, 30).sendKeys(strInChannel);
		getReusableActionsInstance().getWhenReady(btnSearchChannel,30).click();
	}

	/**
	 * Add first channel from the list
	 * @param strGenres  available Genres
	 * @author chinnarao.vattam
	 */
	public void SelectChannelGenres(String strGenres) {
		getReusableActionsInstance().waitForElementVisibility(drpdwnGenre,60);
		getReusableActionsInstance().selectWhenReadyByVisibleText(drpdwnGenre, strGenres);
	}

	/**
	 * Add first channel from the list
	 * @author chinnarao.vattam	 
	 */
	public void addChannelThemepack() {
		//Taking more time to load all the themepacks from ATG
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementInvisibility(ldrThemepack, 90);
		getReusableActionsInstance().getWhenReady(addThemePackClassicTVThemePacks, 90).click();
	}
	
	/**
	 * Remove an added channel
	 * @author Saurav.Goyal	 
	 */
	public void removeChannel() {
		getReusableActionsInstance().getWhenReady(removeParticularChannelFromCart, 120).click();
	}	
	
	
	/**
	 * Remove a theme pack
	 * @author Saurav.Goyal	 
	 */
	public void removeThemePack() {
		getReusableActionsInstance().getWhenReady(removeParticularThemePackFromCart, 120).click();
	}	
	
	/**
	 * Click button to Remove channel in the alert
	 * @author Saurav.Goyal	 
	 */
	public void clkButtonRemoveChannelFromAlert() {
		getReusableActionsInstance().getWhenReady(buttonRemoveChannelFromAlert, 180).click();
	}	
	
	
	/**
	 * Click theme pack tab
	 * @author chinnarao.vattam	 
	 */
	public void clkThemePacks() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().waitForElementTobeClickable(btnThemepacksTab, 180);
		getReusableActionsInstance().executeJavaScriptClick(btnThemepacksTab);
	}	
	
	/**
	 * Add first theme pack
	 * @author Saurav.Goyal	 
	 */
	public void addThemePacks() {
		getReusableActionsInstance().waitForElementVisibility(addThemePack.get(0), 180);
		getReusableActionsInstance().getWhenReady(addThemePack.get(0), 90).click();
	}	
	
	/**
	 * Click continue on existing channel alert window
	 * @author chinnarao.vattam	 
	 */
	public void clkContinueOnExistingChannelAlertWindow() {
		getReusableActionsInstance().waitForElementVisibility(yesContinueOnExistingChannelAlert, 120);
		getReusableActionsInstance().getWhenReady(yesContinueOnExistingChannelAlert, 120).click();
	}	
		
	/**
	 * Click on the ExchangeLater button 
	 * @author chinnarao.vattam
	 */
	public void clkExchangeLater() {
		getReusableActionsInstance().getWhenReady(btnExchangeLater, 180).click();
	}

	/**
	 * Click on the ExchangeLater button
	 * @author chinnarao.vattam
	 */
	public void clkExchangeLaterMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnExchangeLater, 180);
		getReusableActionsInstance().executeJavaScriptClick(btnExchangeLater);
	}

	/**
	 * Click on the continue from theme packs button
	 * @author chinnarao.vattam
	 */
	public void clkContinueFromThemepacks() {
		//Need time to load all the TV packages
		getReusableActionsInstance().staticWait(10000);
		//getReusableActionsInstance().waitForElementVisibility(addParticularChannelToCart.get(0), 240);
		getReusableActionsInstance().getWhenReady(btnContinueFromThemepacks, 120);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().executeJavaScriptClick(btnContinueFromThemepacks);
	}

	/**
	 * Click on the continue from theme packs button
	 * @author chinnarao.vattam
	 */
	public void clkContinueFromThemepacksMobile() {
		//Need time to load all the TV packages
		getReusableActionsInstance().staticWait(7000);
		getReusableActionsInstance().waitForElementVisibility(btnContinueFromThemepacks, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnContinueFromThemepacks);
	}
	/**
	 * Click on the "YesIHave4K" button
	 * @author chinnarao.vattam
	 */
	public void clkYesIHave4K() {
		getReusableActionsInstance().waitForElementVisibility(btnYesIHave4K, 90);
		getReusableActionsInstance().getWhenReady(btnYesIHave4K, 90).click();
	}

	/**
	 * Click on the "No I dont have 4K" button
	 * @author manpreet.kaur3
	 */
	public void clkNoIDontHave4K() {
		getReusableActionsInstance().waitForElementVisibility(btnNoIDontHave4K, 90);
		getReusableActionsInstance().getWhenReady(btnNoIDontHave4K, 90).click();
	}

	/**
	 * Click on the "YesIHave4K" button
	 * @author chinnarao.vattam
	 */
	public void clkYesIHave4KMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnYesIHave4KMobile, 90);
		getReusableActionsInstance().getWhenReady(btnYesIHave4KMobile, 90).click();
	}

	/**
	 * Click on the "4KContent" button
	 * @author chinnarao.vattam
	 */
	public void clk4KContent() {
		getReusableActionsInstance().waitForElementVisibility(btnAdd4kContent, 120);
		getReusableActionsInstance().waitForElementVisibility(btn4KContent, 30);
		getReusableActionsInstance().getWhenReady(btn4KContent, 30).click();
	}


	/**
	 * Click on the "Add Prime Pack" button
	 * @author manpreet.kaur3
	 */
	public void clkAddPrimePack() {
		getReusableActionsInstance().getWhenReady(btnAddPrimePack,60);
		getReusableActionsInstance().clickWhenReady(btnAddPrimePack,10);
	}

	/**
	 * Verify "Remove" Prime Pack button
	 * @author manpreet.kaur3
	 */
	public boolean verifyPrimePackAdded() {
		getReusableActionsInstance().staticWait(5000);
		return getReusableActionsInstance().isElementVisible(btnRemovePrimePack, 30);
	}

	/**
	 * Click on the "Continue" button on MiniCart
	 * @author manpreet.kaur3
	 */
	public void clkContinueMiniCart() {
		getReusableActionsInstance().getWhenReady(btnMiniCartContinue, 60);
		getReusableActionsInstance().clickWhenReady(btnMiniCartContinue,10);
	}
}
