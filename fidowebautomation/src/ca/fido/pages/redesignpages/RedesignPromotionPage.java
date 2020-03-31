package ca.fido.pages.redesignpages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RedesignPromotionPage extends BasePageClass {

  @FindBy(xpath = "//a[@class='fcl-logo']")
  private WebElement lnkHomeLogo;

  /**
   * Instantiates a new Redesign promotion page.
   *
   * @param driver the driver
   */
  public RedesignPromotionPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Clk lnk home logo.
   */
  public void clkLnkHomeLogo() {
    reusableActions.clickWhenReady(lnkHomeLogo);
  }

}
