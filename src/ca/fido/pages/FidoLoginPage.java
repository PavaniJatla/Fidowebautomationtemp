package ca.fido.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoLoginPage extends BasePageClass {

	public FidoLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@formcontrolname='username']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//iframe[contains(@src,'/pages/easylogin-fido/signin/')]")
	WebElement fraSignIn;

	@FindBy(xpath = "//a[@title='user name']")
	WebElement lnkUserName;
	
	@FindBy(xpath = "//div[@id='skipNavigation']//a[@id='f_logoutAction']")
	WebElement lnkSignOut;
	
	@FindBy(xpath = "//div[@class='fdl-navbar-nav']//li[contains(@class,'stateActive')]/a//span[contains(text(),'Sign in') or contains(text(),'Ouvrir une session')]")
	WebElement lnkReSignInAs;
	
	@FindBy(xpath = "//button[contains(@class,'primary-button state-btn')]")
	WebElement btnLogIn;

	@FindBy(xpath = "(//a[ @class = 'primary-link right-spec'])[02]")
	WebElement btnSkip;
	
	@FindBy(xpath = "//a[@class = 'btn-logIn-facebook']")
	WebElement btnLoginWithFb;
	
	@FindBy(xpath = "//img[@src='assets/images/icon-register.png']//parent::i")
	WebElement lnkregister;
	
	@FindBy (xpath = "//a[@class='recovery-btn-back']")
	WebElement lnkForgotNameOrPass;
	
	@FindBy(xpath = "//a[@class='m-navLink' and @title='Support']")
	WebElement menuSupport;
	
	@FindBy(xpath = "//a[@role='menuitem' and @title='My Account']")
	WebElement menuMyAccount;
	
	@FindBy(xpath = "//div[@class='recovery-error']")
	WebElement lblUserOrPasswordNotRecognized;
	
	@FindBy(xpath = "//a[contains(@ui-sref,'myAccount.overview')]")
	WebElement lblOverView;

	@FindBy(xpath = "//ins[@translate='global.message.accountPageInitializing']")
	WebElement lblPageLoading;

	/**
	 * Set the user name on login page
	 * @param strUsername user name to be login
	 * @author Aditya.Dhingra
	 */
	public void setUsernameInFrame(String strUsername) {
		reusableActions.getWhenVisible(txtUsername,120).clear();
		reusableActions.getWhenVisible(txtUsername,60).click();
		reusableActions.getWhenVisible(txtUsername,60).sendKeys(strUsername);
	}
	
	/**
	 * Switch to SignIn iframe
	 * @author ning.xue
	 */
	public void switchToSignInFrame() {
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 120);
		
	}
	
	/**
	 * Set the user password on login page
	 * @param strPassword user password to be login
	 * @author Aditya.Dhingra
	 */
	public void setPasswordInFrame(String strPassword) {
		reusableActions.getWhenReady(txtPassword,10).clear();
		reusableActions.getWhenVisible(txtPassword,10).click();
		reusableActions.getWhenReady(txtPassword).sendKeys(strPassword);
	}


	/**
	 * Click on the login button
	 * @author Chinnarao.Vattam
	 */
	public void clkLoginInFrame() {		
		reusableActions.getWhenVisible(btnLogIn,10).click();	   
		reusableActions.clickIfAvailable(btnSkip,10);
	}
	
	/**
	 * Switch out of SignIn iframe
	 * @author ning.xue
	 */
	public void switchOutOfSignInFrame() {	
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();	
		reusableActions.waitForPageLoad();
		if(reusableActions.isElementVisible(lblPageLoading)) {
			reusableActions.waitForElementInvisibility(lblPageLoading, 180);
		}

	}
	
	/**
	 * Click on log in with Facebook button in login page 
	 * @author ning.xue
	 */
	public void clkLoginWithFb() {
		this.switchToSignInFrame();
		// Perform the click operation will open new window
		reusableActions.staticWait(5000);;
		reusableActions.getWhenReady(btnLoginWithFb, 60).click();
	}
	
	/**
	 * Click on register link in login page
	 * @author ning.xue
	 */
	public void clkRegisterIframe() {
		//Click the register link
		reusableActions.getWhenVisible(lnkregister).click();
	}
	
	/**
	 * Click on forgot username and/or password link in login page (login Iframe)
	 * @author ning.xue
	 */
	public void clkForgotPassOrNameIframe() {

		reusableActions.getWhenVisible(lnkForgotNameOrPass).click();
	}
	
	/**
	 * Click on SignOut in header Navigation bar after login
	 * @author ning.xue
	 */
	public void clkSignOut() {
		reusableActions.clickIfAvailable(lnkUserName);
		reusableActions.waitForElementVisibility(lnkSignOut, 20);
		reusableActions.clickIfAvailable(lnkSignOut);
		reusableActions.waitForPageLoad();
	}
	
	/**
	 * Click on ResignInAs in header Navigation bar after user logout
	 * @author ning.xue
	 */
	public void clkResignInAs() {	
		reusableActions.clickIfAvailable(By.xpath("//a[text()='My Account']"), 20);
		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			if(!reusableActions.isDisplayed(fraSignIn))
			{
				reusableActions.waitForElementTobeClickable(lnkReSignInAs, 120);
				reusableActions.javascriptScrollByVisibleElement(lnkReSignInAs);
				reusableActions.executeJavaScriptClick(lnkReSignInAs);
				reusableActions.staticWait(3000);
				if(reusableActions.isDisplayed(fraSignIn))
				{
					clickSuccess=true;
					break;
				}
				count++;
			}else
			{
				clickSuccess=true;
				break;
			}
			
		}
		
	}

}
