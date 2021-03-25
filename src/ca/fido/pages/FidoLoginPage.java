package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class FidoLoginPage extends BasePageClass {

	public FidoLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@formcontrolname='password']/parent::div")
	WebElement lblPassword;

	@FindBy(xpath = "//iframe[contains(@src,'/pages/easylogin-fido/signin/')]")
	WebElement fraSignIn;

	@FindBy(xpath = "//a[@title='user name' or @class='m-navLink -navbar -login']")
	WebElement lnkUserName;
		
	@FindAll({
	@FindBy(xpath = "//span[@class='m-mobileNavLink__caption user-loggedin']"),
	@FindBy(xpath = "//span[@class=\"m-mobileNavLink__icon fds-icon-account\"]/parent::a")})
	WebElement lnkUserNameMobile;
		
	@FindBy(xpath = "//*[@id='skipNavigation' or contains(@class,'o-headerNavDropdown')]//a[@id='f_logoutAction' or @title='Sign out' or @title='Fermer la session']")	
	WebElement lnkSignOut;
	
	@FindAll({
	@FindBy(xpath = "//header[contains(@class,'headerMobile')]//a[@title='Sign Out' or @title='Sign out' ]"),
	@FindBy(xpath = "//a[@title='Sign Out']")})
	WebElement lnkSignOutMobile;
	
	@FindAll({		
	@FindBy(xpath = "//header[contains(@class,'headerDesk')]//span[contains(text(),'Sign in as') or contains(text(),'Ouvrir une session')]"),
	@FindBy(xpath = "//div[@class='fdl-navbar-nav']//li[contains(@class,'stateActive')]/a//span[contains(text(),'Sign in') or contains(text(),'Ouvrir une session')]")})
	WebElement lnkReSignInAs;
	
	@FindBy(xpath = "//nav[@nav-id='main']//li[contains(@class,'loginStates stateCookied stateActive')]/a[@aria-label='Sign in to My Fido']//span[contains(text(),'Sign in as')]")
	WebElement lnlResignInAsMobile;
	
	
	@FindBy(xpath = "//button[contains(@class,'primary-button state-btn') or @title='Sign in' or @title='Ouvrir une session']")
	WebElement btnLogIn;

	@FindBy(xpath = "(//a[ @class = 'primary-link right-spec'])[02]")
	WebElement btnSkip;
	
	@FindBy(xpath = "//a[@class = 'btn-logIn-facebook']")
	WebElement btnLoginWithFb;

	@FindAll(
			{
	@FindBy(xpath = "//span[text()='Register' or contains(text(),'inscrire')]"),
	@FindBy(xpath = "//img[@src='assets/images/icon-register.png']//parent::i")})
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

	@FindBy(xpath="//li[contains(@class,'o-mobileNavLinkList__item loginStates stateAnonymous')]//a[contains(@class,'signin-interceptor')]//span[@class='m-mobileNavLink__caption']")
	WebElement lnkLogInMobile;
	
	@FindBy(xpath = "//ins[@translate='global.message.accountPageInitializing']")
	WebElement lblPageLoading;
	
	@FindBy (xpath = "//div[@class='recovery-error']")
	WebElement lblErrorMsg;

	@FindBy(xpath = "//span[text()='Forgot username' or contains(text(),'utilisateur oubli')]")
	WebElement lnkForgotUserName;

	@FindBy(xpath = "//input[@id='username']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement lblUserName;

	@FindBy(xpath = "//span[text()='Forgot password ' or contains(text(),'Mot de passe oubli')]")
	WebElement lnkForgotPassword;

	/**
	 * Set the user name on login page
	 * @param strUsername user name to be login
	 * @author Aditya.Dhingra
	 */
	public void setUsernameInFrame(String strUsername) {
		reusableActions.getWhenReady(txtUsername,90).clear();
		//reusableActions.getWhenReady(txtUsername,10).click();
		reusableActions.getWhenReady(txtUsername,10).sendKeys(strUsername);
	}
	
	
	/**
	 * Set the user name on login page
	 * @param strUsername user name to be login
	 * @author Mirza.Kamran
	 */
	public void setUsernameInFrameAfterReSignIn(String strUsername) {
		if(reusableActions.isElementVisible(txtUsername)) {
			reusableActions.getWhenReady(txtUsername,90).clear();
			//reusableActions.getWhenReady(txtUsername,10).click();
			reusableActions.getWhenReady(txtUsername,10).sendKeys(strUsername);
		  }
		}
	/**
	 * Set the user name on login page
	 * @param strUsername user name to be login
	 * @author Mirza.Kamran
	 */
	public void setUsernameAfterReSignInFrame(String strUsername) {
		if(reusableActions.isElementVisible(txtUsername))
		{
		reusableActions.getWhenReady(txtUsername,90).clear();
		//reusableActions.getWhenReady(txtUsername,10).click();
		reusableActions.getWhenReady(txtUsername,10).sendKeys(strUsername);
		}
	}
	
	/**
	 * Switch to SignIn iframe
	 * @author ning.xue
	 */
	public void switchToSignInFrame() {
		reusableActions.getWhenReady(fraSignIn,10);
		getDriver().switchTo().frame(fraSignIn);
//		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 120);		
	}
	
	/**
	 * Switch to SignIn iframe
	 * @author ning.xue
	 */
	public void switchToSignInFrameMobile() {
		reusableActions.executeJavaScriptClick(lnkLogInMobile);
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 30);		
	}
	
	/**
	 * Set the user password on login page
	 * @param strPassword user password to be login
	 * @author Aditya.Dhingra
	 */
	public void setPasswordInFrame(String strPassword) {
		reusableActions.clickIfAvailable(lblPassword);
		reusableActions.getWhenReady(txtPassword,10).clear();
		reusableActions.getWhenVisible(txtPassword,30).click();
		reusableActions.getWhenReady(txtPassword).sendKeys(strPassword);
	}


	/**
	 * Click on the login button
	 * @author Chinnarao.Vattam
	 */
	public void clkLoginInFrame() {		
		reusableActions.getWhenReady(btnLogIn,60).click();	  
	}
	

	
	/**
	 * Click on the login button
	 * @author Mirza.Kamran
	 */
	public void clkLoginInFrameMobile() {		
		reusableActions.getWhenReady(btnLogIn,60).click();	
		reusableActions.staticWait(5000);
		reusableActions.clickIfAvailable(btnLogIn); //optonal;
	}
	
	/**
	 * Check if the login failed error message is displayed.
	 * @return true if error message displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyIfErrorMsgIsDisplayedInFrame() {
		return reusableActions.isElementVisible(lblErrorMsg);
	}
	
	/**
	 * Switch out of SignIn iframe
	 * @author ning.xue
	 */
	public void switchOutOfSignInFrame() {	
		reusableActions.clickIfAvailable(btnSkip, 30);
		driver.switchTo().defaultContent();	

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
	 * Clicks on Forgot Password iframe
	 * @author Mirza.Kamran
	 */
	public void clkForgotPasswordIframe() {

		reusableActions.getWhenReady(lnkForgotPassword).click();

	}

	/**
	 * Click on SignOut in header Navigation bar after login
	 * @author ning.xue
	 */
	public void clkSignOut() {	
		reusableActions.waitForElementTobeClickable(lnkUserName, 30);
		reusableActions.getWhenReady(lnkUserName).click();
		reusableActions.waitForElementVisibility(lnkSignOut, 20);
		reusableActions.clickWhenReady(lnkSignOut);

	}
	
	
	/**
	 * Click on SignOut in header Navigation bar after login
	 * @author ning.xue
	 */
	public void clkSignOutMobile() {	
		reusableActions.getWhenReady(lnkUserNameMobile).click();
		reusableActions.waitForElementVisibility(lnkSignOutMobile, 20);
		reusableActions.getWhenReady(lnkSignOutMobile).click();

	}
	/**
	 * Click on ResignInAs in header Navigation bar after user logout
	 * @author ning.xue
	 */
	public void clkResignInAs() {	
		
		//updated in 920 ----		
		//reusableActions.getWhenReady(By.xpath("//div[@id='skipNavigation']//span[contains(text(),'Sign in as')]"), 20).click();
		reusableActions.getWhenReady(By.xpath("//header[contains(@class,'headerDesk')]//span[contains(text(),'Sign in as') or contains(text(),'Ouvrir une session en tant que ')]"), 20).click();
		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			if(!reusableActions.isElementVisible(fraSignIn))
			{
				reusableActions.waitForElementTobeClickable(lnkReSignInAs, 120);
				reusableActions.javascriptScrollByVisibleElement(lnkReSignInAs);
				reusableActions.executeJavaScriptClick(lnkReSignInAs);
				reusableActions.staticWait(3000);
				if(reusableActions.isElementVisible(fraSignIn))
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
	
	/**
	 * Click on ResignInAs in header Navigation bar after user logout
	 * @author Mirza.Kamran
	 */
	public void clkResignInAsMobile() {
		reusableActions.getWhenReady(lnlResignInAsMobile).click();
	}

	/**
	 * Is username field displayed
	 * @return true fi displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isUserNameDisplayed() {	
		return reusableActions.isElementVisible(txtUsername);
	}
}
