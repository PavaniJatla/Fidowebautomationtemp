package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoHomePage extends BasePageClass {

	public FidoHomePage(WebDriver driver) {
		super(driver);		
	}

	//@FindBy(xpath="//a[contains(@class,'signin-interceptor') and @href]")
	@FindBy(xpath="//a[contains(@class,'signin-interceptor') or @class='m-navLink -navbar -login']")
	WebElement lnkLogIn;
	
	@FindBy(xpath="//a[@class='m-navLink']//span[@class='m-navLink__chevron fds-icon-down']")
	WebElement lnkShop;	
	
	@FindBy(xpath="//a[@href='/pages/#/internet' and @class='m-navLink -dropdown']")
	WebElement lnkHomeInternet;
			
	@FindBy(xpath="//a[contains(text(),'Skip >')]")
	WebElement lnkSkipAd;
	
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
	
	@FindBy(xpath="//button[@class='fcl-header-mobilenav']")
	WebElement lnkNavMobile;
	
	@FindBy(xpath="//li[@class='o-mobileNavLinkList__item -separator']//a[@title='Shop']")
	WebElement lnkShopMobile;	
	
	@FindBy(xpath="//li[@class='o-mobileNavDropdown__item']//a[@title='Home Internet']")
	WebElement lnkHomeInternetMobile;
	
	@FindBy(xpath="//button[@class='button-new']")
	WebElement btnCheckAvailabilityMobile;
	
	@FindBy(xpath="//div[@class='recovery-header container']")
	WebElement overlayRecoveryHeaderContainerMobile;
	
	@FindBy(xpath="//div[@class='fdl-navmain-inner']//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkMyAccountMobile;
	
	@FindBy (xpath = "//a[@title='Contact us']")
	WebElement lnkContactUsMobile;
	
	@FindBy (xpath = "//a[@class='m-navLink my-fido-account']/span")
	WebElement menuMyAccountAfterLoginMobile;
	
	@FindBy(xpath="//a[@title='Phones' or @title='Téléphones et appareils']")
	WebElement lnkPhonesMobile;
	
	@FindBy(xpath="//a[@title='Plans' or @title='Forfaits']")
	WebElement lnkPlansMobile;
	
	@FindBy(xpath = "//ins[@translate='global.label.internetHome']")
	WebElement menuHomeInternetMobile;
	
	@FindBy(xpath = "//a[@href='/consumer/easyloginriverpage']")
	WebElement linkeasyloginMobile;
	
	/**
	 * To launch Fido home page, this method will be used to replace production page in recover user name flow.
	 * @param url, String, the url of Fido home page
	 * @author ning.xue
	 */
	public void launchHomePage(String url) {
		reusableActions.navigateToPage(url);
	}
	
	/**
	 * Click on myAccount button on the home page
	 * @author aditya.Dhingra
	 */	
	public void clkMyAccount() {
		reusableActions.clickWhenReady(lnkMyAccount,2);
	}
	
	/**
	 * Click on myAccount button on the home page
	 * @author aditya.Dhingra
	 */	
	public void clkEasylogin() {
		reusableActions.getWhenReady(linkeasylogin,2).click();
	}

	/**
	 * Click on Login button on the home page
	 * @author aditya.Dhingra
	 */	
	public void clkLogin() {						
		reusableActions.getWhenVisible(lnkLogIn,40).click();
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShop() {
		reusableActions.waitForElementTobeClickable(lnkShop,120);
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
	public void skipRecoveryOverlay() {
		if(reusableActions.isElementVisible(overlayRecoveryHeaderContainer,20))
		{
			reusableActions.clickIfAvailable(lnkSkipAd,20);			
		}
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

	/**
	 * Click on myAccount button on the home page
	 * @author chinnarao.vattam
	 */	
	public void clkkMobileNavMobile() {
		reusableActions.clickWhenReady(lnkNavMobile,20);
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShopMobile() {		
		reusableActions.getWhenReady(lnkShopMobile,10).click();
		reusableActions.staticWait(2000);
	}
	
	/**
	 * Click the Digital TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkHomeInternetMobile() {	
		reusableActions.waitForElementVisibility(lnkHomeInternetMobile,20);
		reusableActions.executeJavaScriptClick(lnkHomeInternetMobile);
	}
	
	/**
	 * Click on skip recovery overlay
	 * @author chinnarao.vattam
	 */
	public void clkCheckAvailabilityMobile() {
			reusableActions.clickIfAvailable(btnCheckAvailabilityMobile,20);			
	}
	
	/**
	 * Click on link ContactUs in Fido home page.
	 * @author chinnarao.vattam
	 */
	public void clkContactUsMobile() {
		reusableActions.scrollToElementAndClick(lnkContactUsMobile);
	}
	
	/**
	 * Click on the menu MY ACCOUNT when user is already login
	 * @author chinnarao.vattam
	 */
	public void clkMenuMyAccountAfterLoginMobile() { 
		reusableActions.getWhenVisible(menuMyAccountAfterLoginMobile, 20).click();
	}
	
	/**
	 * Clicks on the 'Phones' menu under the 'Shop' menu
	 * @author chinnarao.vattam
	 */
	public void clkPhonesMobile() {
		reusableActions.clickWhenReady(lnkPhonesMobile);
	}
	
	/**
	 * Clicks on the 'Plans' menu under the 'Shop' menu
	 * @author chinnarao.vattam
	 */
	public void clkPlansMobile() {
		reusableActions.clickWhenReady(lnkPlansMobile);
	}
	
	/**
	 * Clicks on the 'internet' menu under the 'Shop' menu
	 * @author chinnarao.vattam
	 */
	public void clkHomeInternetMenuMobile() {
		reusableActions.clickWhenReady(menuHomeInternetMobile);
	}
		
}
