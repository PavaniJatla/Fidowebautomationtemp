package ca.fido.pages.redesignpages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RedesignLoginPage extends BasePageClass {

  /**
   * The Txt user name.
   */
  @FindBy(id = "username")
  WebElement txtUserName;
  /**
   * The Txt password.
   */
  @FindBy(id = "password")
  WebElement txtPassword;
  /**
   * The Chk remember me.
   */
  @FindBy(id = "rememberCheckbox")
  WebElement chkRememberMe;
  /**
   * The Btn header sign in.
   */
  @FindBy(xpath = "//button[@class='primary-button state-btn']")
  WebElement btnHeaderSignIn;
  /**
   * The Lbl user name err.
   */
  @FindBy(xpath = "//input[@id='username']/following::small")
  WebElement lblUserNameErr;
  /**
   * The Lbl password err.
   */
  @FindBy(xpath = "//input[@id='password']/following::small")
  WebElement lblPasswordErr;


  /**
   * The Sign in alert content.
   */
  @FindBy(xpath = "//a[contains(text(),'Skip >')]")
  WebElement signInAlertSkipEnglish;

  /**
   * The Sign in alert skip french.
   */
  @FindBy(xpath = "//a[contains(text(),'Sauter cette étape >')]")
  WebElement signInAlertSkipFrench;
  /**
   * The Btn not you.
   */
  @FindBy(xpath = "//button[@class='recovery-btn-input-show-hide']")//button[@class='recovery-btn-input-show-hide']
      WebElement btnNotYou;


  /**
   * The Btnsign out.
   */
  @FindBy(xpath = "//a[@class='m-navLink -dropdownNavbar m-nav-sub-links__title -max-width']")
  WebElement btnsignOut;


  /**
   * Gets txt user name.
   *
   * @return the txt user name
   */
  public WebElement getTxtUserName() {
    return txtUserName;
  }

  /**
   * Sets txt user name.
   *
   * @param txtUserName the txt user name
   */
  public void setTxtUserName(WebElement txtUserName) {
    this.txtUserName = txtUserName;
  }

  /**
   * Gets txt password.
   *
   * @return the txt password
   */
  public WebElement getTxtPassword() {
    return txtPassword;
  }

  /**
   * Sets txt password.
   *
   * @param txtPassword the txt password
   */
  public void setTxtPassword(WebElement txtPassword) {
    this.txtPassword = txtPassword;
  }

  /**
   * Gets chk remember me.
   *
   * @return the chk remember me
   */
  public WebElement getChkRememberMe() {
    return chkRememberMe;
  }

  /**
   * Gets btn header sign in.
   *
   * @return the btn header sign in
   */
  public WebElement getBtnHeaderSignIn() {
    return btnHeaderSignIn;
  }

  /**
   * Gets lbl user name err.
   *
   * @return the lbl user name err
   */
  public WebElement getLblUserNameErr() {
    return reusableActions.getWhenVisible(lblUserNameErr);
  }

  /**
   * Gets lbl password err.
   *
   * @return the lbl password err
   */
  public WebElement getLblPasswordErr() {
    return lblPasswordErr;
  }

  /**
   * Instantiates a new Redesign login page.
   *
   * @param driver the driver
   */
  public RedesignLoginPage(WebDriver driver) {
    super(driver);
  }


  /**
   * Clkbtn header signin.
   */
  public void clkbtnHeaderSignin() {
    this.btnHeaderSignIn.sendKeys(Keys.ENTER);
  }

  /**
   * Clk login button.
   */
  public void clkLoginButton() {
    this.btnHeaderSignIn.click();
  }


  /**
   * Login without user name password.
   */
  public void loginWithoutUserNamePassword() {
    this.btnHeaderSignIn.sendKeys(Keys.ENTER);
  }

  /**
   * Verify user name error msg boolean.
   *
   * @param expectedMsg the expected msg
   * @return the boolean
   */
  public Boolean verifyUserNameErrorMsg(String expectedMsg) {
    String actualResult = getLblUserNameErr().getText().trim();
    return reusableActions.verifyText(actualResult, expectedMsg);
  }

  /**
   * Verify password error msg boolean.
   *
   * @param expectedMsg the expected msg
   * @return the boolean
   */
  public Boolean verifyPasswordErrorMsg(String expectedMsg) {
    String actualResult = getLblPasswordErr().getText().trim();
    return reusableActions.verifyText(actualResult, expectedMsg);
  }

  /**
   * Verify btn log in text boolean.
   *
   * @param expectedText the expected text
   * @return the boolean
   */
  public Boolean verifyBtnLogInText(String expectedText) {
    String actualResult = getBtnLogInText();
    return reusableActions.verifyText(actualResult, expectedText);
  }

  /**
   * Get btn log in text string.
   *
   * @return the string
   */
  public String getBtnLogInText() {
    return getBtnHeaderSignIn().getText().trim();
  }

  /**
   * Write user name.
   *
   * @param strUserName the str user name
   */
  public void writeUserName(String strUserName) {
    txtUserName.sendKeys(strUserName);
  }

  /**
   * Write password.
   *
   * @param strPwd the str pwd
   */
  public void writePassword(String strPwd) {
    txtPassword.sendKeys(strPwd);
  }


  /**
   * Close signin alert.
   */
  public void waitForSigninAlterPopupEn() {
    reusableActions.getWhenVisible(signInAlertSkipEnglish, 10);

  }

  /**
   * Close signin alter popup en.
   */
  public void closeSigninAlterPopupEn() {
    reusableActions.getWhenVisible(signInAlertSkipEnglish, 10).click();

  }

  /**
   * Wait for signin alter popup fr.
   */
  public void waitForSigninAlterPopupFr() {
    reusableActions.getWhenVisible(signInAlertSkipFrench, 10);

  }

  /**
   * Close signin alter popup fr.
   */
  public void closeSigninAlterPopupFr() {
    reusableActions.getWhenVisible(signInAlertSkipFrench, 10).click();

  }

  /**
   * Verify signedin as boolean.
   *
   * @param strSignedAsLabel the str signed as label
   * @return the boolean
   */
  public boolean verifySignedinAs(String strSignedAsLabel) {
    String getSignedinLabel = reusableActions.getWhenVisible(btnNotYou).getText();
    if (getSignedinLabel.equals(strSignedAsLabel)) {
      return true;
    }
    return false;
  }

  /**
   * Clk signout.
   */
  public void clkSignout() {
    reusableActions.getWhenVisible(btnsignOut, 10).click();
  }
}
