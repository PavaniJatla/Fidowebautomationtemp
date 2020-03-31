package ca.fido.pages.redesignpages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedesignFooterPage extends BasePageClass {


  /**
   * The Why fido.
   */
  String whyFido = "WHY FIDO";
  /**
   * The Store locator.
   */
  String storeLocator = "STORE LOCATOR";
  /**
   * The Contact us.
   */
  String contactUs = "CONTACT US";
  /**
   * The Site map.
   */
  String siteMap = "SITE MAP";
  /**
   * The Privacy terms.
   */
  String privacyTerms = "PRIVACY & TERMS";
  /**
   * The Accessibility.
   */
  String accessibility = "ACCESSIBILITY";
  /**
   * The Crtc code.
   */
  String crtcCode = "CRTC CODE";
  /**
   * The Careers.
   */
  String careers = "CAREERS";
  /**
   * The Facebook.
   */
  String facebook = "Facebook";
  /**
   * The Instagram.
   */
  String instagram = "Instagram";
  /**
   * The Twitter.
   */
  String twitter = "Twitter";
  /**
   * The Youtube.
   */
  String youtube = "YouTube";
  /**
   * The Logo.
   */
  String logo = "logo";


  //variables
  @FindBy(xpath = "//div[@class='m-column1']//li[1]//a")
  private WebElement lnkFooterWhyFido;

  @FindBy(xpath = "//div[@class='m-column1']//li[2]//a")
  private WebElement lnkFooterStoreLocator;

  @FindBy(xpath = "//div[@class='m-column1']//li[3]//a")
  private WebElement lnkFooterContactUs;

  @FindBy(xpath = "//div[@class='m-column1']//li[4]//a")
  private WebElement lnkFooterSiteMap;

  @FindBy(xpath = "//div[@class='m-column2']//li[1]//a")
  private WebElement lnkFooterPrivacyTerms;

  @FindBy(xpath = "//div[@class='m-column2']//li[2]//a")
  private WebElement lnkFooterAccessibility;

  @FindBy(xpath = "//div[@class='m-column2']//li[3]//a")
  private WebElement lnkFooterCrtcCODE;

  @FindBy(xpath = "//div[@class='m-column2']//li[4]//a")
  private WebElement lnkFooterCareers;

  @FindBy(xpath = "//div[@class='m-social']//li[1]//a")
  private WebElement lnkFooterSocialMediaFacebook;

  @FindBy(xpath = "//div[@class='m-social']//li[2]//a")
  private WebElement lnkFooterocialMediaInstagram;

  @FindBy(xpath = "//div[@class='m-social']//li[3]//a")
  private WebElement lnkFooterSocialMediaTwitter;

  @FindBy(xpath = "//div[@class='m-social']//li[4]//a")
  private WebElement lnkFooterSocialMediaYoutube;

  @FindBy(xpath = "//div[@class='col m-logoContainer']//a")
  private WebElement lnkFooterlogo;

  @FindBy(xpath = "//a[@class='m-navLink -navbar']//span[@class='m-navLink__chevron fds-icon-down']")
  private WebElement lnkProvinceDropDown;


  /**
   * Instantiates a new Redesign footer page.
   *
   * @param driver the driver
   */
  public RedesignFooterPage(WebDriver driver) {
    super(driver);
  }


  /**
   * Clk why fido.
   */
  /*
   * Click Footer column 1 List1
   **/
  public void clkWhyFido() {
    reusableActions.clickWhenReady(lnkFooterWhyFido, 10);
  }

  /**
   * Clk store locator.
   */
  /*
   * Click Footer column 1 List2
   **/
  public void clkStoreLocator() {
    reusableActions.clickWhenReady(lnkFooterStoreLocator, 10);
  }

  /**
   * Clk contact us.
   */
  /*
   * Click Footer column 1 List3
   **/
  public void clkContactUs() {
    reusableActions.clickWhenReady(lnkFooterContactUs, 10);
  }

  /**
   * Clk site map.
   */
  /*
   * Click Footer column 1 List4
   **/
  public void clkSiteMap() {
    reusableActions.clickWhenReady(lnkFooterSiteMap, 10);
  }

  /**
   * Clk privacy terms.
   */
  /*
   * Click Footer column 2 List1
   **/
  public void clkPrivacyTerms() {
    reusableActions.clickWhenReady(lnkFooterPrivacyTerms, 10);
  }

  /**
   * Clk accessibility.
   */
  /*
   * Click Footer column 2 List2
   **/
  public void clkAccessibility() {
    reusableActions.clickWhenReady(lnkFooterAccessibility, 10);
  }

  /**
   * Clk crtc code.
   */
  /*
   * Click Footer column 2 List3
   **/
  public void clkCrtcCODE() {
    reusableActions.clickWhenReady(lnkFooterCrtcCODE, 10);
  }

  /*
   * Click Footer column 2 List4
   */

  /**
   * Clk careers.
   */
  public void clkCareers() {
    reusableActions.clickWhenReady(lnkFooterCareers, 10);
  }

  /*
   * Click Footer Social media  List1
   */

  /**
   * Clk footer social media facebook.
   */
  public void clkFooter_SocialMedia_Facebook() {
    reusableActions.getWhenVisible(lnkFooterSocialMediaFacebook, 10).sendKeys(Keys.ENTER);
  }

  /*
   * Click Footer Social media  List2
   */

  /**
   * Clk footer social media instagram.
   */
  public void clkFooter_SocialMedia_Instagram() {
    reusableActions.clickWhenReady(lnkFooterocialMediaInstagram, 10);

  }

  /*
   * Click Footer Social media  List3
   */

  /**
   * Clk footer social media twitter.
   */
  public void clkFooter_SocialMedia_Twitter() {
    reusableActions.clickWhenReady(lnkFooterSocialMediaTwitter, 10);

  }

  /*
   * Click Footer Social media  List4
   */

  /**
   * Clk footer social media youtube.
   */
  public void clkFooter_SocialMedia_Youtube() {
    reusableActions.clickWhenReady(lnkFooterSocialMediaYoutube, 10);

  }


  /**
   * Clk footer logo.
   */
  public void clkFooterLogo() {
    reusableActions.getWhenVisible(lnkFooterlogo, 10).sendKeys(Keys.ENTER);
  }

  /**
   * Select footer logo web element.
   *
   * @return the web element
   */
  public WebElement selectFooterLogo() {
    return reusableActions.getWhenReady(lnkFooterlogo, 10);
  }



  public boolean verifyURL(String strActualURL, String strExpectedURL) {
    return reusableActions.verifyText(strActualURL,strExpectedURL);
  }

 /*
   * Verify tooltip boolean.
   *
   * @param strExpected the strExpected
   * @param strActual   the strActual
   * @return the boolean
   *//*
  public boolean verifyTooltip(String strExpected, String strActual) {


    if (strActual.equals(strExpected)) {
      return true;
    } else {
      throwError(strActual, strExpected);
    }
    return false;
  }

  private boolean verifyElementText(String strExpected, String strActual) {

    if (strActual.equals(strExpected)) {
      return true;
    } else {
      throwError(strActual, strExpected);
    }

    return false;
  }
*/

  /**
   * Verify text by element boolean.
   *
   * @param strSelectedLinkName         the element name
   * @param strExpectedLinkName the expected element name
   * @return the boolean
   */
  public boolean verifyTextByElement(String strSelectedLinkName, String strExpectedLinkName) {

    if (strSelectedLinkName.equals(whyFido)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterWhyFido.getText());
    } else if (strSelectedLinkName.equals(storeLocator)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterStoreLocator.getText());
    } else if (strSelectedLinkName.equals(contactUs)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterContactUs.getText());
    } else if (strSelectedLinkName.equals(siteMap)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterSiteMap.getText());
    } else if (strSelectedLinkName.equals(privacyTerms)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterPrivacyTerms.getText());
    } else if (strSelectedLinkName.equals(accessibility)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterAccessibility.getText());
    } else if (strSelectedLinkName.equals(crtcCode)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterCrtcCODE.getText());
    } else if (strSelectedLinkName.equals(careers)) {
      return reusableActions.verifyText(strExpectedLinkName, lnkFooterCareers.getText());
    }

    return false;
  }


  /**
   * This generic method can be validating the tooltip for actual and expected tooltip from browser and yml file and it returns boolean value.
   * <p>
   * Expected elementName
   * <p>
   * "Why Fido"
   * "STORE LOCATOR"
   * "CONTACT US"
   * "SITE MAP"
   * "PRIVACY and TERMS"
   * "ACCESSIBILITY"
   * "CRTC CODE"
   * "CAREERS"
   * "Facebook"
   * "Instagram"
   * "Twitter"
   * "Youtube"
   * "logo"
   *
   * @param elementName     the element name
   * @param expectedTooltip the expected tooltip
   * @return boolean boolean
   */
  public boolean verifyToolTipByElementName(String elementName, String expectedTooltip) {

    if (elementName.equals(whyFido)) {
      reusableActions.scrollToElement(lnkFooterWhyFido);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterWhyFido));
    } else if (elementName.equals(storeLocator)) {
      reusableActions.scrollToElement(lnkFooterStoreLocator);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterStoreLocator));
    } else if (elementName.equals(contactUs)) {
      reusableActions.scrollToElement(lnkFooterContactUs);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterContactUs));
    } else if (elementName.equals(siteMap)) {
      reusableActions.scrollToElement(lnkFooterSiteMap);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterSiteMap));
    } else if (elementName.equals(privacyTerms)) {
      reusableActions.scrollToElement(lnkFooterPrivacyTerms);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterPrivacyTerms));
    } else if (elementName.equals(accessibility)) {
      reusableActions.scrollToElement(lnkFooterAccessibility);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterAccessibility));
    } else if (elementName.equals(crtcCode)) {
      reusableActions.scrollToElement(lnkFooterCrtcCODE);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getWhenVisible(lnkFooterCrtcCODE, 10).getAttribute("title"));
    } else if (elementName.equals(careers)) {
      reusableActions.scrollToElement(lnkFooterCareers);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getTitle(lnkFooterCareers));
    } else if (elementName.equals(facebook)) {
      reusableActions.scrollToElement(lnkFooterSocialMediaFacebook);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getWhenVisible(lnkFooterSocialMediaFacebook, 10).getAttribute("title"));
    } else if (elementName.equals(instagram)) {
      reusableActions.scrollToElement(lnkFooterocialMediaInstagram);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getWhenVisible(lnkFooterocialMediaInstagram, 10).getAttribute("title"));
    } else if (elementName.equals(twitter)) {
      reusableActions.scrollToElement(lnkFooterSocialMediaTwitter);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getWhenVisible(lnkFooterSocialMediaTwitter, 10).getAttribute("title"));
    } else if (elementName.equals(youtube)) {
      reusableActions.scrollToElement(lnkFooterSocialMediaYoutube);
      return reusableActions.verifyText(expectedTooltip, reusableActions.getWhenVisible(lnkFooterSocialMediaYoutube, 10).getAttribute("title"));
    } else if (elementName.equals(logo)) {
      return reusableActions.verifyText(expectedTooltip, reusableActions.getWhenVisible(lnkFooterlogo, 20).getAttribute("title"));
    }
    return false;
  }

  /**
   * This method can click the element based on given parameters.
   * <p>
   * Expected elementName
   * <p>
   * "Why Fido"
   * "STORE LOCATOR"
   * "CONTACT US"
   * "SITE MAP"
   * "PRIVACY and TERMS"
   * "ACCESSIBILITY"
   * "CRTC CODE"
   * "CAREERS"
   * "Facebook"
   * "Instagram"
   * "Twitter"
   * "Youtube"
   * "logo"
   *
   * @param elementName the element name
   */
  public void clickElementByName(String elementName) {

    if (elementName.equals(whyFido)) {
      clkWhyFido();
    } else if (elementName.equals(storeLocator)) {
      clkStoreLocator();
    } else if (elementName.equals(contactUs)) {
      clkContactUs();
    } else if (elementName.equals(siteMap)) {
      clkSiteMap();
    } else if (elementName.equals(privacyTerms)) {
      clkPrivacyTerms();
    } else if (elementName.equals(accessibility)) {
      clkAccessibility();
    } else if (elementName.equals(crtcCode)) {
      clkCrtcCODE();
    } else if (elementName.equals(careers)) {
      clkCareers();
    } else if (elementName.equals(facebook)) {
      clkFooter_SocialMedia_Facebook();
    } else if (elementName.equals(instagram)) {
      clkFooter_SocialMedia_Instagram();
    } else if (elementName.equals(twitter)) {
      clkFooter_SocialMedia_Twitter();
    } else if (elementName.equals(youtube)) {
      clkFooter_SocialMedia_Youtube();
    } else if (elementName.equals("logo")) {
      clkFooterLogo();
    }
  }
}
