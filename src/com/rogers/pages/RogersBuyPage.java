package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersBuyPage extends BasePageClass {

	public RogersBuyPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[contains(text(),'Ignite Internet speed') or contains(text(),'Vitesse Internet Élan')]")
	WebElement btnIgniteInternetSpeed;	

	@FindBy(xpath = "//span[contains(text(),'Exchange Flex Channels') or contains(text(),'Échanger chaînes flexibles')]/ancestor::a")
	WebElement btnExchangeFlexChannel;

	@FindBy(xpath = "//label[@for='existingActiveAddress-1']")
	WebElement rdoSecondAddress;

	// tv#/packages
	@FindBy(xpath = "//a[@data-smartserviceability-config='{ \"lob\": \"dtv\", \"data\": { \"package\": \"QDPA\" } }']")
	WebElement lnkDigitalTVPackage;

	@FindBy(xpath = "//input[@id='addressLookupField-0']")
	WebElement txtAddressLookup;

	@FindBy(id = "addressLookupSubmit-0")
	WebElement btnAddressLookupSubmit;

	@FindBy(xpath = "//div[@class='pcaitem pcafirstitem pcalastitem pcaselected']")
	WebElement linkOption;
	
	
	@FindBy(xpath = "//i[@class='rui-icon-success']")
	WebElement infoDTVAvailabilitySuccess;

	// rogers-internet
	@FindBy(xpath = "//a[@class='contact-online-link ways-to-change-cta']")
	WebElement btnBuyOnline;
	
	@FindBy(xpath = "(//div//a[@class='rogers-btn-solid'])[4]")
	WebElement btnControlPackage;
	
	@FindBy(xpath = "//button[@id='inpage-nav-button']")
	WebElement btnInternetMenuMobile;
	
	
		
	/**
	 * To select the solaris bundle package
	 * @param strBundleName is the desired solaris package name of the Rogers's customer
	 * @author chinnarao.vattam 
	 */
	public void selectSolarisBundlePackage(String strBundleName) {		
		By bundleNameLocator = By.xpath("//span[contains(text(),'Select') or contains(text(),' Populaire')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']");
		getReusableActionsInstance().clickWhenReady(bundleNameLocator, 60);
	}
	
	/**
	 * Select the solaris bundle package
	 * @param strBundleName Bundle Name
	 * @author Mirza.Kamran
	 */
	public void selectSolarisBundlePackage1(String strBundleName) {
		
		By bundleNameLocator = By.xpath("//span[contains(text(),'"+ strBundleName+ "')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']");
		getReusableActionsInstance().clickWhenReady(bundleNameLocator, 60);
	}
	//or contains(text(),'Sélection')

	/**
	 * To select the Internet Speed from Ignite bundle package
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteInternetSpeed() {
			getReusableActionsInstance().getWhenReady(btnIgniteInternetSpeed, 40).click();
	}

	/**
	 * To select the Exchange Flex Channel from Ignite bundle package
	 * @author chinnarao.vattam 
	 */
	public void clkExchangeFlexChannel() {
		getReusableActionsInstance().getWhenReady(btnExchangeFlexChannel, 90).click();
       }
	
	
	/**
	 * To select the DTV Package from the shop menu
	 * @author chinnarao.vattam 
	 */
	public void clkDTVPackage() {				
		getReusableActionsInstance().getWhenReady(lnkDigitalTVPackage, 30).click();
	}
	
/**
 * To set the Lookup address on the service ability Lookup page
 * @param strAddress is the address of the service required locality
 * @author chinnarao.vattam
 */
	public void setAddressLookup(String strAddress) {
		getReusableActionsInstance().getWhenReady(txtAddressLookup,60).clear();
		getReusableActionsInstance().getWhenReady(txtAddressLookup, 10).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.TAB);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click the Lookup Submit button to check service availability 
	 * @author chinnarao.vattam
	 */
	public void clkAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnAddressLookupSubmit, 30).click();
	}

	/**
	 * To verify the  DTV Availability Success popup after the address lockup
	 * @return true if the Availability Success popup is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDTVAvailabilitySuccess() {
		return getReusableActionsInstance().isElementVisible(infoDTVAvailabilitySuccess, 90);
	}

	/**
	 * To verify the  Internet Menu for Mobile
	 * @return true if the Availability of Internet Menu is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyInternetMenuMobile() {
		return getReusableActionsInstance().isElementVisible(btnInternetMenuMobile, 90);
	}

	/**
	 * To select the Internet package on the Internet buy page
	 * @param strInternetBundle internet bundle to be select to buy
	 * @author chinnarao.vattam 
	 */
	public void selectInternetPackage(String strInternetBundle) {
		WebElement  bundleLocator = (WebElement)getDriver().findElement(By.xpath("//p[@class='rate-card-data desktop-rate-details']/strong[contains(text(),'"+ strInternetBundle+ "')]/ancestor::div[@id='main-box']//a[@class='btn ways-to-buy']"));
		getReusableActionsInstance().waitForElementVisibility(bundleLocator,30);
		getReusableActionsInstance().executeJavaScriptClick(bundleLocator);
	}	
	
	/**
	 * To select the Home Monitering package on the Internet buy page
	 * @param strHomeMoniteringEn Home Monitering bundle to be select to buy
	 * @param strHomeMoniteringFr Home Monitering bundle to be select to buy
	 * @author chinnarao.vattam 
	 */
	public void selectHomeMoniteringPackage(String strHomeMoniteringEn, String strHomeMoniteringFr ) {
		By packageNameLocator = By.xpath("//h3[contains(text(),'"+strHomeMoniteringEn+ "') or contains(text(),'"+ strHomeMoniteringFr+ "')]/ancestor::div[@class='package-tile']//div[@class='how-to-get-it']//a[@class='rogers-btn-solid']");
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().waitForElementVisibility(pkg, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(packageNameLocator, 30);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}
	
	/**
	 * Click on BuyOnline button on buy options Popup
	 * @author chinnarao.vattam 
	 */
	public void clkBuyOnline() {
		getReusableActionsInstance().getWhenReady(btnBuyOnline, 30).click();
	}

	}
	

