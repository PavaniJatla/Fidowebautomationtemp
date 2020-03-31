package ca.fido.pages.redesignpages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RedesignHeaderPage extends BasePageClass {

  /**
   * The Lnk home logo.
   */
  @FindBy(xpath = "//a[@class='fcl-logo']")
  public WebElement lnkHomeLogo;
  /**
   * The Lnk provinces.
   */
  //Changed on 06092019
  //@FindBy(xpath = "//ul[@class='o-navLinkList']/li[1]//a")
  @FindBy(xpath = "//li[1]//a[@class='m-navLink -navbar']")
  public WebElement lnkProvinces;
  /**
   * The Lnk language.
   */
  //Changed on 06092019
  //@FindBy(xpath = "//ul[@class='o-navLinkList']/li[2]//a")
  @FindBy(xpath = "//li[2]//dsa-header-link[1]//a[1]")
  public WebElement lnkLanguage;
  /**
   * The Lnk find a store.
   */
  @FindBy(xpath = "//span[@class= 'm-navLink__icon fds-icon-locate-store']//parent::a")
  public WebElement lnkFindAStore;
  /**
   * The Lnk shop.
   */
  //Changed on 06092019
  //@FindBy(xpath = "//nav[@class='fcl-header-navigation']/ul[@class='o-navLinkList']/li[1]/a")
  @FindBy(xpath = "//li[1]//a[@class='m-navLink']")
  public WebElement lnkShop;
  /**
   * The Lnk my account.
   */
  //Changed on 06092019
  //@FindBy(xpath = "//nav[@class='fcl-header-navigation']/ul[@class='o-navLinkList']/li[2]/a")
  @FindBy(xpath = "//nav[@class='col fcl-header-navigation']/ul[@class='o-navLinkList']/li[2]/a")
  public WebElement lnkMyAccount;
  /**
   * The Lnk support.
   */
  //Changed on 06092019
  //@FindBy(xpath = "//nav[@class='fcl-header-navigation']/ul[@class='o-navLinkList']/li[3]/a")
  @FindBy(xpath = "//nav[@class='col fcl-header-navigation']/ul[@class='o-navLinkList']/li[3]/a")
  public WebElement lnkSupport;
  /**
   * The Fra sign in.
   */
  //@FindBy(xpath = "//div[@class='el-modal ng-star-inserted']//iframe")
  @FindBy(xpath = "//iframe[contains(@src,'/pages/easylogin-fido/signin/')]")
  public WebElement fraSignIn;
  
  /**
   * The Lnk sign in.
   */
  @FindBy(xpath = "//a[contains(@class,'login')]")
  public WebElement lnkSignIn;
  /**
   * The Lnk header.
   */
  @FindBy(tagName = "header")
  public WebElement lnkHeader;
  /**
   * The Lst shops.
   */
  //Changed on 06092019
  //@FindBy(xpath = "//nav[@class='fcl-header-navigation']//ul[starts-with(@class,'o-headerNavDropdown')]//a")
  @FindBy(xpath = "//nav[@class='col fcl-header-navigation']//ul[starts-with(@class,'o-headerNavDropdown')]//a")
  public List<WebElement> lstShops;

  /**
   * Gets lst provinces.
   *
   * @return the lst provinces
   */
  public List<WebElement> getLstProvinces() {
    return lnkProvinces.findElements(By.xpath("//following-sibling::ul[starts-with(@class,'o-headerNavDropdown -navbar')]//a"));
  }

  public WebElement lblProvince() {
    return lnkProvinces.findElement((By.xpath("//span[contains(@class,'m-navLink__caption')]")));
  }

  /**
   * Clk lnk shop.
   */
  public void clkLnkShop() {
    reusableActions.getWhenVisible(lnkShop).sendKeys(Keys.ENTER);
  }


  /**
   * Gets lst shops.
   *
   * @return the lst shops
   */
  public List<WebElement> getLstShops() {
    reusableActions.waitForAllElementsVisible(lstShops, TIME_OUT_SECONDS);
    return lstShops;
  }


  /**
   * Clk lnk my account.
   */
  public void clkLnkMyAccount() {
    reusableActions.getWhenVisible(lnkMyAccount).sendKeys(Keys.ENTER);
  }

  /**
   * Clk lnk provinces.
   */
  public void clkLnkProvinces() {
    reusableActions.getWhenVisible(lnkProvinces).sendKeys(Keys.ENTER);
  }

  /**
   * Get lnk provinces lbl txt string.
   *
   * @return the string
   */
  public String getLnkProvincesLblTxt() {
    return reusableActions.getLblTxt(lnkProvinces).trim();
  }

  /**
   * Gets lnk language tooltip.
   *
   * @return the lnk language tooltip
   */
  public String getLnkLanguageTooltip() {
    return reusableActions.getTitle(reusableActions.getWhenReady(lnkLanguage)).trim();
  }

  /**
   * Gets lnk shop tooltip.
   *
   * @return the lnk shop tooltip
   */
  public String getLnkShopTooltip() {
    return reusableActions.getTitle(reusableActions.getWhenReady(lnkShop)).trim();
  }

  /**
   * Gets lnk language text.
   *
   * @return the lnk language text
   */
  public String getLnkLanguageText() {
    return (reusableActions.getWhenReady(lnkLanguage)).getText().trim();
  }

  /**
   * Clk lnk support.
   */
  public void clkLnkSupport() {
    reusableActions.getWhenVisible(lnkSupport).sendKeys(Keys.ENTER);
  }

  /**
   * Gets lnk support tooltip.
   *
   * @return the lnk support tooltip
   */
  public String getLnkSupportTooltip() {
    return reusableActions.getTitle(reusableActions.getWhenReady(lnkSupport)).trim();
  }

  /**
   * Gets lnk my account tooltip.
   *
   * @return the lnk my account tooltip
   */
  public String getLnkMyAccountTooltip() {
    return reusableActions.getTitle(reusableActions.getWhenReady(lnkMyAccount)).trim();
  }

  /**
   * Clk lnk home logo.
   */
  public void clkLnkHomeLogo() {
    reusableActions.getWhenVisible(lnkHomeLogo).sendKeys(Keys.ENTER);
  }

  /**
   * Instantiates a new Redesign header.
   *
   * @param driver the driver
   */
  public RedesignHeaderPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Clk find a store link.
   */
  public void clkFindAStoreLink() {
    reusableActions.getWhenVisible(lnkFindAStore, 10).sendKeys(Keys.ENTER);
  }


  /**
   * Open sig in page.
   */
  public void openSigInPage() {
    reusableActions.getWhenVisible(lnkSignIn).sendKeys(Keys.ENTER);
    getDriver().switchTo().frame(reusableActions.getWhenReady(fraSignIn));
  }

  /**
   * Select province.
   *
   * @param provinceName the province name
   */
  public void selectProvince(String provinceName) {
    reusableActions.getWhenVisible(lnkProvinces).sendKeys(Keys.ENTER);
    for (WebElement province : getLstProvinces()) {
      reusableActions.waitForAllElementsVisible(getLstProvinces(), 10);
      if (province.getAttribute("title").trim().equalsIgnoreCase(provinceName)) {
        reusableActions.moveToElementAndClick(province, 10);
        verifyLnkProvinceName(provinceName);
        break;
      }
    }
  }

  /**
   * Switch to english.
   */
  public void switchToEnglish() {
    if (reusableActions.getWhenVisible(lnkLanguage).getText().equalsIgnoreCase("EN")) {
      clkLnkLanguage();
    }
  }

  /**
   * Clk lnk language.
   */
  public void clkLnkLanguage() {
    reusableActions.getWhenVisible(lnkLanguage).sendKeys(Keys.ENTER);
  }

  /**
   * Switch to french.
   */
  public void switchToFrench() {
    if (getLnkLanguageText().equalsIgnoreCase("FR")) {
      clkLnkLanguage();
    }
    reusableActions.waitForTextToBePresentInElement(lnkLanguage, "EN", 10);
  }

  /**
   * Get all shops name array list.
   *
   * @return the array list
   */
  public ArrayList<String> getAllShopsName() {
    ArrayList<String> actual = new ArrayList<String>();
    for (WebElement shop : getLstShops()) {
      actual.add(shop.getText().trim());
    }
    actual.sort(Comparator.naturalOrder());
    return actual;
  }

  /**
   * Get all shops title array list.
   *
   * @return the array list
   */
  public ArrayList<String> getAllShopsTitle() {
    ArrayList<String> actual = new ArrayList<String>();
    for (WebElement shop : getLstShops()) {
      actual.add(reusableActions.getTitle(shop).trim());
    }
    actual.sort(Comparator.naturalOrder());
    return actual;
  }


  /**
   * Header is displayed boolean.
   *
   * @return the boolean
   */
  public Boolean headerIsDisplayed() {
    return reusableActions.isElementVisible(lnkHeader);
  }


  /**
   * Verify lnk province name boolean.
   *
   * @param expectedProvinceName the expected province name
   * @return the boolean
   */
  public Boolean verifyLnkProvinceName(String expectedProvinceName) {
    String actualResult = reusableActions.getLblTxt(lnkProvinces).trim();
    return reusableActions.verifyText(actualResult, expectedProvinceName);
  }

  /**
   * Verify lnk province code boolean.
   *
   * @param expectedProvinceCode the expected province code
   * @return the boolean
   */
  public Boolean verifyLnkProvinceCode(String expectedProvinceCode) {
    String actualResult = reusableActions.getWhenVisible(lnkProvinces).getText().trim();
    return reusableActions.verifyText(actualResult, expectedProvinceCode);
  }

  /**
   * Verify lnk support tooltip boolean.
   *
   * @param expectedToolTip the expected tool tip
   * @return the boolean
   */
  public Boolean verifyLnkSupportTooltip(String expectedToolTip) {
    String actualResult = getLnkSupportTooltip();
    return reusableActions.verifyText(actualResult, expectedToolTip);
  }

  /**
   * Verify lnk language tooltip boolean.
   *
   * @param expectedToolTip the expected tool tip
   * @return the boolean
   */
  public Boolean verifyLnkLanguageTooltip(String expectedToolTip) {
    String actualResult = getLnkLanguageTooltip();
    return reusableActions.verifyText(actualResult, expectedToolTip);
  }

  /**
   * Verify lnk language text boolean.
   *
   * @param expectedText the expected text
   * @return the boolean
   */
  public Boolean verifyLnkLanguageText(String expectedText) {
    String actualResult = getLnkLanguageText();
    return reusableActions.verifyText(actualResult, expectedText);
  }

  /**
   * Verify lnk shop tooltip boolean.
   *
   * @param expectedText the expected text
   * @return the boolean
   */
  public Boolean verifyLnkShopTooltip(String expectedText) {
    String actualResult = getLnkShopTooltip();
    return reusableActions.verifyText(actualResult, expectedText);
  }

  /**
   * Verify shops name boolean.
   *
   * @param expectedShopsNameList the expected shops name list
   * @return the boolean
   */
  public Boolean verifyShopsName(List<?> expectedShopsNameList) {
    List<?> actual = getAllShopsName();
    return reusableActions.verifyList(actual, expectedShopsNameList);
  }

  /**
   * Verify shops title boolean.
   *
   * @param expectedShopsNameList the expected shops name list
   * @return the boolean
   */
  public Boolean verifyShopsTitle(List<?> expectedShopsNameList) {
    List<?> actual = getAllShopsTitle();
    return reusableActions.verifyList(actual, expectedShopsNameList);
  }

  /**
   * Verify lnk my account tool tip boolean.
   *
   * @param expected the expected
   * @return the boolean
   */
  public Boolean verifyLnkMyAccountToolTip(String expected) {
    String actual = getLnkMyAccountTooltip();
    return reusableActions.verifyText(actual, expected);
  }

  /**
   * Get lst provinces tooltips list.
   *
   * @return the list
   */
  public List<String> getLstProvincesTooltips() {
    List<String> provinceTitles = new ArrayList<String>();
    for (WebElement province : getLstProvinces()) {
      provinceTitles.add(province.getText());
    }
    return provinceTitles;
  }

  /**
   * Verify provinces tooltip boolean.
   *
   * @param expectedTooltips the expected tooltips
   * @return the boolean
   */
  public Boolean verifyProvincesTooltip(List<?> expectedTooltips) {
    List<?> actual = getLstProvincesTooltips();
    return reusableActions.verifyList(actual, expectedTooltips);
  }

  /**
   * Verify find a store tooltip boolean.
   *
   * @param expectedTooltip the expected tooltip
   * @return the boolean
   */
  public Boolean verifyFindAStoreTooltip(String expectedTooltip) {
    String actual = getLnkFindAStoreTooltip();
    return reusableActions.verifyText(actual, expectedTooltip);
  }

  /**
   * Get lnk find a store tooltip string.
   *
   * @return the string
   */
  public String getLnkFindAStoreTooltip() {
    return reusableActions.getTitle(reusableActions.getWhenVisible(lnkFindAStore)).trim();
  }

  /**
   * Get current province code string.
   *
   * @return the string
   */
  public String getCurrentProvinceCode() {
    return reusableActions.getWhenReady(lnkProvinces).getText().trim();
  }


  /**
   * Check login state boolean.
   *
   * @param strLang        the str lang
   * @param strSignInTitle the str sign in title
   * @return the boolean
   */
  public boolean checkLoginState(String strLang, String strSignInTitle) {

    if (strLang.equals("EN")) {

      if (getLoginTitle().equals(strSignInTitle)) {
        //User is not signin.
        return true;
      }
    } else if (strLang.equals("FR")) {

      if (getLoginTitle().equals(strSignInTitle)) {
        //User is not signin.
        return true;
      }
    }
    return false;
  }

  /**
   * Gets login title.
   *
   * @return the login title
   */
  public String getLoginTitle() {

    return reusableActions.getTitle(lnkSignIn);
  }
}
