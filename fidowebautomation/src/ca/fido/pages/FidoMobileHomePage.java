package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoMobileHomePage extends BasePageClass {

	public FidoMobileHomePage(WebDriver driver) {
		super(driver);		
	}

	
	@FindBy(xpath="//button[@class='fcl-header-mobilenav']")
	WebElement lnkMobileNav;
	
	@FindBy(xpath="//li[@class='o-mobileNavLinkList__item -separator']//a[@title='Shop']")
	WebElement lnkShop;	
	
	@FindBy(xpath="//li[@class='o-mobileNavDropdown__item']//a[@title='Home Internet']")
	WebElement lnkHomeInternet;
	
	@FindBy(xpath="//button[@class='button-new']")
	WebElement btnCheckAvailability;
	
	
	
	
			

	
	@FindBy(xpath="//div[@class='recovery-header container']")
	WebElement overlayRecoveryHeaderContainer;
	
	@FindBy(xpath="//div[@class='fdl-navmain-inner']//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkMyAccount;
	
	@FindBy (xpath = "//a[@title='Contact us']")
	WebElement lnkContactUs;
	
	@FindBy (xpath = "//a[@class='m-navLink my-fido-account']/span")
	WebElement menuMyAccountAfterLogin;
	
	@FindBy(xpath="//a[@title='Phones' or @title='Téléphones et appareils']")
	WebElement lnkPhones;
	
	@FindBy(xpath="//a[@title='Plans' or @title='Forfaits']")
	WebElement lnkPlans;
	
	@FindBy(xpath = "//ins[@translate='global.label.internetHome']")
	WebElement menuHomeInternet;
	
	@FindBy(xpath = "//a[@href='/consumer/easyloginriverpage']")
	WebElement linkeasylogin;
	

	
	/**
	 * Click on myAccount button on the home page
	 * @author aditya.Dhingra
	 */	
	public void clkkMobileNav() {
		reusableActions.clickWhenReady(lnkMobileNav,20);
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShop() {		
		reusableActions.getWhenReady(lnkShop,10).click();
		reusableActions.staticWait(2000);
	}
	
	/**
	 * Click the Digital TV option from shop dropdown list
	 * @author aditya.Dhingra 
	 */
	public void clkHomeInternet() {	
		reusableActions.waitForElementVisibility(lnkHomeInternet,20);
		reusableActions.executeJavaScriptClick(lnkHomeInternet);
	}
	
	/**
	 * Click on skip recovery overlay
	 * @author Mirza.Kamran
	 */
	public void clkCheckAvailability() {
			reusableActions.clickIfAvailable(btnCheckAvailability,20);			
	}
	
	/**
	 * Click on link ContactUs in Fido home page.
	 * @author ning.xue
	 */
	public void clkContactUs() {
		reusableActions.scrollToElementAndClick(lnkContactUs);
	}
	
	/**
	 * Click on the menu MY ACCOUNT when user is already login
	 * @author ning.xue
	 */
	public void clkMenuMyAccountAfterLogin() { 
		reusableActions.getWhenVisible(menuMyAccountAfterLogin, 20).click();
	}
	
	/**
	 * Clicks on the 'Phones' menu under the 'Shop' menu
	 * @author rajesh.varalli1
	 */
	public void clkPhones() {
		reusableActions.clickWhenReady(lnkPhones);
	}
	
	/**
	 * Clicks on the 'Plans' menu under the 'Shop' menu
	 * @author rajesh.varalli1
	 */
	public void clkPlans() {
		reusableActions.clickWhenReady(lnkPlans);
	}
	
	/**
	 * 
	 */
	public void clkHomeInternetMenu() {
		reusableActions.clickWhenReady(menuHomeInternet);
	}
		
}
