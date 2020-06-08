package ca.fido.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoTechnicalInstallationPage extends BasePageClass {

	public FidoTechnicalInstallationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//ins[@translate='global.label.fulfillmentTechInstall']")
	WebElement btnFulfillmentTechInstall;
	
	@FindBy(xpath ="//ins[contains(@translate,'label.fulfillmentShipToAddress')]")
	WebElement btnFulfillmentShipToAddress;
	
	@FindBy(xpath ="//div[@class='modal-content']")
	WebElement popupModelWindow;

	@FindBy(xpath ="//div[@class='modal-backdrop fade  in']")
	WebElement winModelContent;
	
	@FindBy(xpath ="//input[@id='10']/ancestor::td[@class='monday']")
	WebElement rdoTechInstallSlot;
	
	@FindBy(xpath ="//button[@translate='global.cta.confirm']")
	WebElement btnTechInstalConfirm;

	@FindBy(xpath ="//ins[@translate='global.label.orderConfirmation']")
	WebElement infoOrderConfirm;
	
	@FindBy(name = "submit")
	WebElement btnCreditCheckSubmit;
	
	@FindBy(xpath ="//ins[@translate='global.label.fulfillmentPickUpAtStore']")
	WebElement btnFulfillmentPickUp;

	@FindBy(xpath = "//ins[@translate='global.label.iUnderstandAbove']")
	WebElement chkIUnderstandAbove;
	
	@FindBy(xpath = "//ins[@translate='global.label.fulfillmentPickUpAtStore']")
	WebElement lnkPickUpAtStore;
	
	@FindBy(xpath = "//ins[@translate='global.label.iUnderstandAbove']")
	WebElement chkPickStoreConsent;
	
	@FindBy(xpath = "//input[@id='storeLocatorSearchInput']")
	WebElement txtClosestStore;

	
	
	public boolean verifyModelWindow() {
		reusableActions.waitForElementInvisibility(btnCreditCheckSubmit,30);
		return reusableActions.isElementVisible(popupModelWindow,60);
	}
	
	public void clkModelContent() {
		reusableActions.clickIfAvailable(winModelContent,10);
		reusableActions.clickIfAvailable(winModelContent,10);
	}
	
	/**
	 * Verify the "Fulfillment TechInstall" button on TechInstall on installation page
	 * @return true, if the TechInstall on installation page displays "Fulfillment TechInstall" button, else false
	 */
	public boolean verifyFulfillment() {
		reusableActions.waitForElementVisibility(btnFulfillmentTechInstall, 90);
		return reusableActions.isElementVisible(btnFulfillmentTechInstall);
	}
	
	/**
	 * Click the "Fulfillment TechInstall" button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkFulfillmentTechInstall() {
		reusableActions.getWhenReady(btnFulfillmentTechInstall,150).click();
	}
	
	/**
	 * Waits for fullfillment option
	 * @author Chinnarao.Vattam
	 */
	public void waitForFullfillmentPageToLoad() {
		reusableActions.waitForElementVisibility(btnFulfillmentShipToAddress, 150);
	}
	
	/**
	 * Click the "Fulfillment Ship To" button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkFulfillmentShipToAddress() {
		reusableActions.getWhenReady(btnFulfillmentShipToAddress,150).click();
	}
	
	/**
	 * Select the slot from the available list of slots from installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallSlot() {
		reusableActions.waitForElementVisibility(rdoTechInstallSlot, 60);
		reusableActions.scrollToElement(rdoTechInstallSlot);		
		reusableActions.getWhenReady(rdoTechInstallSlot,20).click();
	}
	
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstalConfirm() {
		reusableActions.getWhenReady(btnTechInstalConfirm,90).click();
		}

	/**
	 * Pick up as fulfillment option
	 * @author Mirza.Kamran
	 */
	public void clkFulfillmentPickUpFromShop() {
		reusableActions.getWhenReady(btnFulfillmentPickUp,150).click();
		
	}

	/**
	 * Clicks on I understand Above check box
	 * @author Mirza.Kamran
	 */
	public void clkIUnderstandAboveChekBox() {
		reusableActions.getWhenReady(chkIUnderstandAbove).click();
		
	}
	
	/**
	 * Clicks on PickUpAtStore link on techinstall page
	 * @author chinnarao.vattam
	 */
	public void clkPickUpAtStore() {
		reusableActions.getWhenReady(lnkPickUpAtStore,120).click();
		
	}
	
	/**
	 * To set the Lookup address on the service ability Lookup popup
	 * @param strAddress address to check the service ability
	 * @author chinnarao.vattam
	 */
	public void setAddressLookup(String strAddress) {		
		reusableActions.getWhenReady(txtClosestStore,5).clear();
		reusableActions.getWhenReady(txtClosestStore,5).click();		
		reusableActions.getWhenReady(txtClosestStore, 2).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtClosestStore).sendKeys(Keys.TAB);
		reusableActions.getWhenVisible(txtClosestStore).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtClosestStore).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtClosestStore).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtClosestStore).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Clicks on I understand check box for pick at store option
	 * @author chinnarao.vattam
	 */
	public void clkPickStoreConsent() {
		reusableActions.getWhenReady(chkPickStoreConsent,90).click();
		
	}
	
}
