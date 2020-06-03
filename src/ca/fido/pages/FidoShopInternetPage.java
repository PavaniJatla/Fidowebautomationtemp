package ca.fido.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import ca.fido.pages.base.BasePageClass;

public class FidoShopInternetPage extends BasePageClass {

	public FidoShopInternetPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='button-new']")
	WebElement lnkCheckAvailability;

	@FindBy(id = "addressLookup")
	WebElement txtAddressLookup;

	@FindBy(xpath = "//ins[@translate='global.cta.checkAvailability']")
	WebElement btnCheckAvailability;

	@FindBy(xpath = "//div[@class='col-xs-6 col-sm-3 modal-serviceability-options modal-serviceability-options-gap-first']/img[@class='modal-serviceability-image']")
	WebElement btnBuyOnline;

	@FindBy(xpath = "//div[@class='modal-chat bcStatic']")
	WebElement btnliveChat;
		
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']/ins[@translate='global.cta.updateCart']")
	WebElement btnUpdateCart;
	
	@FindBy(xpath = "//div[@id='bc-frame']")
	WebElement popupLiveChat;
	
	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-minimize']")
	WebElement btnMinumizeChat;
	
	@FindBy(xpath = "//div[@class='bc-minimize-state bc-minimize-state-idle']")
	WebElement btnMaxmizeChat;
	
	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-menulist']")
	WebElement btnCloseChat;
	
	@FindBy(xpath = "//div[@class='bc-headbtn-icon bc-headbtn-close-icon']")
	WebElement btnCloseChatConfirm;
	
	@FindBy(xpath = "//button[@class='ute-icon-search']")
	WebElement btnAvailabilitySearch;
	
	@FindBy(xpath = "//div[contains(@class,'pcaautocomplete pcatext') and not(contains(@style,'display: none'))]")
	WebElement infoAutosuggestAddress;
	
	@FindBy(xpath="//div[@class='modal fade']")
	WebElement popupBuyOnline;
	
	@FindBy(xpath="//a[@id='edit-cart']")
	WebElement lnkShoppingCartEdit;
	
	@FindBy(xpath="//ins[@translate='global.cta.continue']")
	WebElement btnContinueForInternet;
	
	@FindBy(xpath="//div[@class='modal-content']")
	WebElement frmMultipleAddresses;
	
	@FindBy(xpath="//label[@for='address-0']")
	WebElement rdoMultipleAddressesOptionOne;
	
	@FindBy(xpath="//label[@for='address-1']")
	WebElement rdoMultipleAddressesOptionTwo;
		
	@FindBy(xpath="//ins[@translate='global.cta.continue']/ancestor::button[@class='ute-btn-primary ute-sm']")
	WebElement btnSpecificaddress;
	
	@FindBy(xpath="//ins[@translate='global.cta.continue']")
	WebElement btnpackselectedNContinue;
	
	/**
	 * Click on Check availability button on Shop Internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckAvailability() {		
		reusableActions.getWhenReady(lnkCheckAvailability, 60).sendKeys(Keys.ENTER);
			}

	/**
	 * To set the Lookup address on the service ability Lookup popup
	 * @param strAddress address to check the service ability
	 * @author chinnarao.vattam
	 */
	public void setAddressLookup(String strAddress) {		
		reusableActions.getWhenReady(txtAddressLookup,5).clear();
		reusableActions.getWhenReady(txtAddressLookup,5).click();		
		setCharacterByCharacterTextInWebElement(txtAddressLookup,strAddress);
		reusableActions.staticWait(5000);
		reusableActions.getWhenReady(txtAddressLookup).sendKeys(Keys.ENTER);	
		reusableActions.staticWait(2000);
		
		/*
		reusableActions.getWhenReady(txtAddressLookup,5).clear();
		reusableActions.getWhenReady(txtAddressLookup, 2).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.TAB);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
		*/
	}
	
	
	/**
	 * This method enters character by character in the webElement
	 * Sometimes firefox is not behaving as expected hence to handle that situation we need to eneter character by character
	 * @param element Text Input webelement
	 * @param strValue Any string value which we want to eneter character by character
	 * @author Mirza.Kamran
	 */
	public void setCharacterByCharacterTextInWebElement(WebElement element, String strValue) {
		 for (int itr = 0; itr < strValue.length(); itr++){
		        char cr = strValue.charAt(itr);
		        String str = new StringBuilder().append(cr).toString();
		        element.sendKeys(str);
		    }  
	}

	/**
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkAvailabilitySearch() {	
		reusableActions.clickWhenReady(btnAvailabilitySearch, 30);
	}
	
	/**
	 * Click on availability confirmation button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkCheckAvailabilityConfirmation() {
		// this wait is mandatory , please do not remove it 	
		reusableActions.staticWait(3000);
		reusableActions.waitForElementTobeClickable(btnCheckAvailability, 60);
		reusableActions.getWhenReady(btnCheckAvailability, 60).click();
	}
	
	
	/**
	 * Click on buy online button on the buy options popup
	 * @author chinnarao.vattam
	 */
	public void clkBuyOnline() {
		if (reusableActions.isElementVisible(btnBuyOnline,90))
		{
			reusableActions.clickWhenReady(btnBuyOnline, 20);
		}
		else if (reusableActions.isElementVisible(frmMultipleAddresses,30))
		{
			reusableActions.getWhenReady(rdoMultipleAddressesOptionOne, 10).click();
			reusableActions.getWhenReady(btnSpecificaddress, 40).click();
			reusableActions.clickWhenReady(btnBuyOnline, 60);
		} 		
		else if (reusableActions.isElementVisible(frmMultipleAddresses,30))
		{   			
			reusableActions.getWhenReady(rdoMultipleAddressesOptionTwo, 10).click();
			reusableActions.getWhenReady(btnSpecificaddress, 60).click();
			reusableActions.clickWhenReady(btnBuyOnline, 60);
		}
		else 		
			throw new NoSuchElementException("Given Address dosen't have the service");	
	}
		
	/**
	 * Click on availability confirmation button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkLiveChat() {
		// this wait is mandatory , please do not remove it 	
		reusableActions.staticWait(3000);
		reusableActions.waitForElementTobeClickable(btnliveChat, 60);
		reusableActions.getWhenReady(btnliveChat, 60).click();
	}
	
		
	/**
	 * Select the plan based on the cost of the plan on shop Internet  page
	 * @author chinnarao.vattam
	 */
	public void verifyPlanInfomation() {
		//reusableActions.waitForElementInvisibility(popupBuyOnline);		
		reusableActions.getWhenReady(By.xpath("//button[@id='add-button-0']"), 30).click();
	}
	
	/**
	 * Select the plan based on the cost of the plan on shop Internet page for existing customer
	 * @param strPlanCost cost of the plan to be selected
	 * @author chinnarao.vattam
	 */
	public void verifyPlanInfomationForExistingCustomer(String strPlanCost) {
		//reusableActions.waitForElementInvisibility(btnContinueForInternet);
		reusableActions.staticWait(5000);
		reusableActions.getWhenReady(By.xpath("//ins[contains(text(),'" + strPlanCost+ "')]/ancestor::div[@class='new-ts-package-cost']//button[@id='add-button-0']"), 60).click();
	}
	
	/**
	 * Select the plan the plan on shop Internet page
	 * @author chinnarao.vattam
	 */
	public void selectPlan() {
		reusableActions.getWhenReady(By.xpath("//button[@id='add-button-0']"), 60).click();		
	}
	
	public void selectPlanforEdit() {
		reusableActions.getWhenReady(By.xpath("//button[@id='add-button-1']"), 60).click();		
	}
	

	/**
	 * Select the new plan based on the cost of the plan on shop Internet page 
	 * @author chinnarao.vattam
	 */
	public void selectNewPlan() {
		reusableActions.clickWhenReady(By.xpath("//button[@id='add-button-0']"), 60);
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @param strPlanCost cost of the plan to be selected
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */
	
	public boolean  verifyDownloadSpeed(String strPlanCost) {
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'" + strPlanCost+"')]"), 30);
	}

	/**
	 * Click on update cart button on the live chat popup
	 * @return true, if the checkout page shows the live chat popup , else false
	 * @author chinnarao.vattam
	 */
		public boolean  verifyLiveChat() {
		return reusableActions.isElementVisible(popupLiveChat, 30);
	}
	
		/**
		 * Click on minimize button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkMinumizeChat()  {		
			reusableActions.getWhenVisible(btnMinumizeChat,30).click();
		}
		
		/**
		 * Click on maxmize button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkMaxumizeChat()  {		
			reusableActions.getWhenVisible(btnMaxmizeChat,30).click();
		}

		/**
		 * Click on close button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkCloseChat()  {		
			reusableActions.getWhenVisible(btnCloseChat,30).click();
		}
		
		/**
		 * Click on close button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkCloseChatConfirm()  {		
			reusableActions.getWhenVisible(btnCloseChatConfirm,30).click();
		}

	/**
	 * Click on update cart button on the buy options popup
	 * @author chinnarao.vattam
	 */
	public void clkUpdateCart()  {		
		reusableActions.getWhenVisible(btnUpdateCart,30).click();
	}

	
	/**
	 * Clicks pack selected and continue button
	 */
	public void clkpackselectedNContinue() {
		reusableActions.getWhenReady(btnpackselectedNContinue, 30).click();						
    }

	public void clickContinue() {
		reusableActions.getWhenReady(By.xpath("//*[@translate='global.cta.continue']")).click();
		
	}
	////*[@translate='global.cta.buyNow']
}
