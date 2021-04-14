package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import ca.fido.test.tests.connectedhome.desktop.FidoCH_Regression_TC_006_HSIServiceabilityLiveChatTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class FidoShopInternetPage extends BasePageClass {

	public FidoShopInternetPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='button-new']")
	WebElement lnkCheckAvailability;

	@FindBy(xpath = "//input[@id='addressLookup']")
	WebElement txtAddressLookup;
	
	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex position-relative ds-borders ds-bgcolor-white ds-brcolor-black ds-color-black']")
	WebElement txtAddressLookupContainer;
	
	@FindBy(xpath = "//ins[@translate='global.cta.checkAvailability']")
	WebElement btnCheckAvailability;

	@FindBy(xpath = "//button[@class='mr-sm-16 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnAvailabilityCheck;
	
	@FindBy(xpath = "//div[@class='col-xs-6 col-sm-3 modal-serviceability-options modal-serviceability-options-gap-first']/img[@class='modal-serviceability-image']")
	WebElement btnBuyOnline;
	
	@FindBy(xpath = "//button[@class='w-100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -large ng-star-inserted']")
	WebElement btnBuyNow;

	@FindAll({@FindBy(xpath = "//button[@title='Buy Fido Home Internet now']"),
			@FindBy(xpath = "//a[@title='Buy Fido Home Internet now']")})
	WebElement btnBuyNowReskin;
	//button[@class='w-100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large ng-star-inserted']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']
	
	@FindBy(xpath = "//a[@title='Live Chat with an agent' or @titile='']")
	WebElement btnliveChat;
		
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']/ins[@translate='global.cta.updateCart']")
	WebElement btnUpdateCart;
	
	@FindBy(xpath = "//div[@id='bc-frame']")
	WebElement popupLiveChat;
	
	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-minimize']")
	WebElement btnMinumizeChat;
	
	@FindBy(xpath = "//div[@class='bc-minimize-container']/div")
	WebElement btnMaxmizeChat;
	
	@FindBy(xpath = "//div[@class='bc-minimize-state bc-minimize-state-ended']")
	WebElement btnShadowMaxmizeChat;
	
	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-menulist']")
	WebElement btnCloseChat;

	@FindBy(xpath = "//input[@name='vn']")
	WebElement txtVaName;

	@FindBy(xpath = "//textarea[@name='iq']")
	WebElement txtInitialQuestion;

	@FindBy(xpath = "//div[@class='bc-headmenu-item bc-headbtn-close']")
	WebElement btnCloseChatConfirm;
	//div[@class='bc-headbtn-icon bc-headbtn-close-icon']
	//div[@class='bc-headbtn-label bc-headbtn-close-label']

	@FindBy(xpath = "//div[@class='bc-headmenu']")
	WebElement mnBcHeadMenu;

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
	
	@FindBy(xpath="//*[@translate='global.cta.continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='bc-frame' and contains(@style,'block')]")
	WebElement popupChat;
	
	@FindBy(xpath="//span[@class='ds-icon d-inline-flex fds-icon-error ds-color-error']")
	WebElement iconUnavailable;
	
	@FindBy(xpath="//span[@class='ds-icon d-inline-flex fds-icon-phone']")
	WebElement iconCustomercare;
	
	@FindBy(xpath="//button[@title='Check another address']")
	WebElement btnCheckAnotherAddress;
	
	@FindBy(xpath="//p[@class='ng-star-inserted']")
	WebElement txtUnavailableInProvince;
	
	@FindBy(xpath="//button[@title='Cancel']")
	WebElement btnCancel;
	
	@FindBy(xpath="//button[@title='Yes']")
	WebElement btnYes;

	@FindBy(xpath="//ds-icon[@name='location']")
	WebElement iconLocation;

	@FindBy(xpath="//button[@title='Log into Fido My Account']")
	WebElement btnLogin;


	@FindBy(xpath="//div[@id='undefined']//h2[@class='-left text-title-2']")
	WebElement txtPackagesPage;
	//div[@id='undefined']//h2[@class='-left text-title-2 ds-color-black']

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
		reusableActions.getWhenReady(txtAddressLookup,60).clear();
		reusableActions.getWhenReady(txtAddressLookup, 20).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.TAB);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.SPACE);
		reusableActions.getWhenVisible(By.xpath("//div[@class='pcaitem pcafirstitem pcalastitem pcaselected']"));
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * To set the Lookup address on the service ability Lookup popup
	 * @param strAddress address to check the service ability
	 * @author chinnarao.vattam
	 */
	public void setInternetAddressLookup(String strAddress) {		
		reusableActions.getWhenReady(txtAddressLookupContainer,60).click();
		reusableActions.getWhenReady(txtAddressLookup,60).clear();
		reusableActions.getWhenReady(txtAddressLookup, 20).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.TAB);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.SPACE);
		//reusableActions.getWhenVisible(By.xpath("//div[@class='pcaitem pcafirstitem pcalastitem pcaselected']"));
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * To set the Lookup address on the service ability Lookup popup
	 * @param strAddress address to check the service ability
	 * @author chinnarao.vattam
	 */
	public void setAddressLookupMobile(String strAddress) {		
		reusableActions.getWhenReady(txtAddressLookup,60).clear();
		reusableActions.getWhenReady(txtAddressLookup, 20).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.TAB);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.SPACE);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
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
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkLoginAtServicebilityModel() {
		reusableActions.clickWhenReady(btnLogin, 90);
	}


	/**
	 * Click on availability confirmation button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkServiceAvailabilityCheck() {
		reusableActions.waitForElementVisibility(btnAvailabilityCheck, 60);
		reusableActions.waitForElementTobeClickable(btnAvailabilityCheck, 60);
		reusableActions.getWhenReady(btnAvailabilityCheck, 60).click();
	}
	
	/**
	 * Click on availability confirmation button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkCheckAvailabilityConfirmation() {
		reusableActions.waitForElementVisibility(btnCheckAvailability, 120);
		reusableActions.waitForElementTobeClickable(btnCheckAvailability, 120);
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
	 * Click on buy online button on the buy options popup
	 * @author chinnarao.vattam
	 */
	public void clkBuyNow() {
		if (reusableActions.isElementVisible(btnBuyNow,90))
		{
			reusableActions.clickWhenReady(btnBuyNow, 20);
		}
		else if (reusableActions.isElementVisible(frmMultipleAddresses,30))
		{
			reusableActions.getWhenReady(rdoMultipleAddressesOptionOne, 10).click();
			reusableActions.getWhenReady(btnSpecificaddress, 40).click();
			reusableActions.clickWhenReady(btnBuyNow, 60);
		} 		
		else if (reusableActions.isElementVisible(frmMultipleAddresses,30))
		{   			
			reusableActions.getWhenReady(rdoMultipleAddressesOptionTwo, 10).click();
			reusableActions.getWhenReady(btnSpecificaddress, 60).click();
			reusableActions.clickWhenReady(btnBuyNow, 60);
		}
		else 		
			throw new NoSuchElementException("Given Address dosen't have the service");	
	}
	
	/**
	 * Click on buy online button on the buy options popup
	 * @author chinnarao.vattam
	 */
	public void clkBuyNowReskin() {
		//To bypass captcha manually
			reusableActions.getWhenReady(btnBuyNowReskin, 90).click();	}
	
	/**
	 * Click on availability confirmation button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkLiveChat() {
		// this wait is mandatory , please do not remove it 	
		
		reusableActions.waitForElementTobeClickable(btnliveChat, 60);
		reusableActions.getWhenReady(btnliveChat, 60).click();
	}
	/**
	 * Select the plan based on the cost of the plan on shop Internet page for existing customer
	 * @param strPlanCost cost of the plan to be selected
	 * @author chinnarao.vattam
	 */
	public void selectPlanForExistingCustomer(String strPlanCost) {
		By planLocator = By.xpath("//ins[contains(text(),'" + strPlanCost+ "')]/ancestor::div[@class='new-ts-package-cost']//button[@id='add-button-0']");
		reusableActions.waitForElementInvisibility(btnContinueForInternet,180);
		reusableActions.getWhenReady(planLocator, 60).click();
	}
	
	/**
	 * Select the plan the plan on shop Internet page
	 * @author chinnarao.vattam
	 */
	public void selectPlan() {
		reusableActions.getWhenReady(By.xpath("//button[@id='add-button-0']"), 60).click();		
	}


	/**
	 * Select the plan the plan on shop Internet page
	 * @param strDowngradeDataPlan of the plan to be selected
	 * @param strUpgradePlanCost cost of the plan to be selected
	 * @author chinnarao.vattam
	 */
	public void selectInternetPlan(String strDowngradeDataPlan, String strUpgradePlanCost) {
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+ strDowngradeDataPlan+"')]/ancestor::div[@class='dsa-rate-card ds-shadow px-12']//div[contains(@aria-label,'"+strUpgradePlanCost+"')]/ancestor::div[@class='dsa-rate-card__price px-4 py-24 px-md-12']//a[@class='w-100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large ng-star-inserted']"), 60).click();
	}

	/**
	 * Select the plan the plan on shop Internet page
	 * @param strDowngradeDataPlan of the plan to be selected
	 * @param strUpgradePlanCost cost of the plan to be selected
	 * @author chinnarao.vattam
	 */
	public void selectInternetPlanRetry(String strDowngradeDataPlan, String strUpgradePlanCost) {
		reusableActions.getWhenReady(iconLocation, 30);
		reusableActions.executeJavaScriptClick(iconLocation);
		//reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+ strDowngradeDataPlan+"')]/ancestor::div[@class='dsa-rate-card ds-shadow px-12']//div[contains(@aria-label,'"+strUpgradePlanCost+"')]/ancestor::div[@class='dsa-rate-card__price px-4 py-24 px-md-12']//a[@class='w-100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large ng-star-inserted']"), 60).click();
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
		return reusableActions.isElementVisible(By.xpath("//div[@class='subtotal-holder']//span[@price='" + strPlanCost+"']"), 30);
	}

	public boolean  verifyBcHeadMenu() {
		reusableActions.staticWait(6000);
		return reusableActions.isElementVisible(mnBcHeadMenu, 30);
	}

	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyIconUnavailable() {
		reusableActions.waitForElementVisibility(iconUnavailable, 30);
		return reusableActions.isElementVisible(iconUnavailable, 10);
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyCheckAnotherAddress() {
		return reusableActions.isElementVisible(btnCheckAnotherAddress, 10);
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyIconCustomercare() {
		return reusableActions.isElementVisible(iconCustomercare, 10);
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyAvailabilityCheck() {
		return reusableActions.isElementVisible(btnAvailabilityCheck, 30);
	}
	
	
	/**
	 * Click on minimize button on the chat popup
	 * @author chinnarao.vattam
	 */
	public void clkCheckAnotherAddress()  {		
		reusableActions.getWhenReady(btnCheckAnotherAddress,30).click();
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyUnavailableInProvince() {
		return reusableActions.isElementVisible(txtUnavailableInProvince, 30);
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyCancel() {
		return reusableActions.isElementVisible(btnCancel, 10);
	}
	
	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyYes() {
		return reusableActions.isElementVisible(btnYes, 30);
	}
		
	/**
	 * Click on minimize button on the chat popup
	 * @author chinnarao.vattam
	 */
	public void clkCancel()  {		
		reusableActions.getWhenReady(btnCancel,30).click();
	}

	/**
	 * Click on update cart button on the buy options popup
	 * @return true, if the checkout page shows the download speed of the selected package , else false
	 * @author chinnarao.vattam
	 */	
	public boolean  verifyPackagesPage() {
		return reusableActions.isElementVisible(txtPackagesPage, 90);
	}
	
	/**
	 * Click on minimize button on the chat popup
	 * @author chinnarao.vattam
	 */
	public void clkYes()  {		
		reusableActions.getWhenReady(btnYes,30).click();
	}
	

	/**
	 * Click on update cart button on the live chat popup
	 * @return true, if the checkout page shows the live chat popup , else false
	 * @author chinnarao.vattam
	 */
		public boolean  verifyLiveChat() {
			reusableActions.staticWait(4000);
		return reusableActions.isElementVisible(popupLiveChat, 30);
	}

	public boolean  verifyVaName() {
		return reusableActions.isElementVisible(txtVaName, 30);
	}

	public boolean  verifyInitialQuestion() {
		return reusableActions.isElementVisible(txtInitialQuestion, 30);
	}

		/**
		 * Click on minimize button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkMinimizeChat()  {		
			reusableActions.getWhenReady(btnMinumizeChat,30).click();
		}
		
		/**
		 * Click on maxmize button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkMaximizeChat()  {	
			reusableActions.getWhenReady(btnMaxmizeChat,30).click();
		}

		/**
		 * Click on close button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkCloseChat()  {
			reusableActions.staticWait(5000);
			reusableActions.isElementVisible(popupChat,30);
			reusableActions.waitForElementVisibility(btnCloseChat,30);
			reusableActions.executeJavaScriptClick(btnCloseChat);
		}

		/**
		 * Click on close button on the chat popup
		 * @author chinnarao.vattam
		 */
		public void clkCloseChatConfirm()  {
			reusableActions.waitForElementVisibility(btnCloseChatConfirm,60);
			reusableActions.getWhenVisible(btnCloseChatConfirm,10).click();
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
		reusableActions.waitForElementVisibility(btnpackselectedNContinue, 90);
		reusableActions.getWhenReady(btnpackselectedNContinue, 20).click();
    }

	public void clickContinue() {
		reusableActions.getWhenReady(btnContinue,90).click();
		
	}
}
