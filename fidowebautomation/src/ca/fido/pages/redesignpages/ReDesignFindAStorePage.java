package ca.fido.pages.redesignpages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReDesignFindAStorePage extends BasePageClass {

  @FindBy(xpath = "//a[@class='fdl-logo']")
  private WebElement lnkHomeLogo;

  /**
   * Instantiates a new Re design find a store page.
   *
   * @param driver the driver
   */
  public ReDesignFindAStorePage(WebDriver driver) {
    super(driver);
  }

  /**
   * Clk home logo.
   */
  public void clkHomeLogo() {
    reusableActions.clickWhenVisible(lnkHomeLogo);
  }

}
