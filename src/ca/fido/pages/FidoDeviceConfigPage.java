package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FidoDeviceConfigPage extends BasePageClass {

	public FidoDeviceConfigPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath = "//span[contains(text(),'Appareils') or contains(text(),'Devices')]")
	WebElement devicesInHearder;
	
	@FindBy(xpath = "//button[@id='continue-button' or contains(@class,'-primary -large')]")
	WebElement continueButton;
	
	@FindBy(xpath = "//ds-modal-container")
	WebElement modalContainer;
	
	@FindBy(xpath = "//button[@id='trident-cta0' or @id='trident-cta-nac']")
	WebElement modalContainerGetStartedbutton;

	@FindBy(xpath = "//p[contains(.,'Add Accessories') or contains(.,'Ajoutez des accessoires')]/..")
	WebElement addAccessoriesOption;

	@FindBy(xpath = "//button[@id='continue-accessory-button']")
	WebElement btnContinueAccessories;

	@FindBy(xpath = "//accessory-view-details-modal")
	WebElement accessoryViewDetailsModal;

	@FindBy(xpath = "//div[@data-test='accessory-view-details-modal']//button[contains(.,'Add') or contains(.,'Ajouter')]")
	WebElement btnAddToCartAccessoriesViewDetailsModal;


	/**
	 * Selects the Subscriber on the Choose a line overlay and clicks Continue
	 * @param strCTN Subscriber phone number
	 * @author rajesh.varalli1
	 */
	public void selectSubscriber(String strCTN) {
		/*strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);*/
		String strCtnXpath = "//div[contains(@data-id,'"+ strCTN +"')]//label/span";

		if(reusableActions.isElementVisible(By.xpath(strCtnXpath))) {
			reusableActions.executeJavaScriptClick(driver.findElement(By.xpath(strCtnXpath)));
			reusableActions.clickWhenReady(By.xpath("//span[contains(text(),'Continue')]"));
		}
/*		reusableActions.clickIfAvailable(By.xpath(strCtnXpath),30);
		reusableActions.clickWhenReady(By.xpath("//button[@res='_continue']"));*/
	}

	/***
	 * This method will verify if the text 'devices' appears in the breadcrums section of the page
	 * @return boolean if the element devices is visible then return true else false
	 * @author sidhartha.vadrevu
	 */
	public boolean verifyDevicesInHeader() {
		reusableActions.waitForElementVisibility(devicesInHearder,10);
		return reusableActions.isElementVisible(devicesInHearder , 30);
	}

	/***
	 * This method will check the presence of continue button and will return true if present else false
	 * @return boolean if the Continue button is visible then return true else false
	 * @author saurav.goyal
	 */
	public boolean verifyContinueButton() {
		reusableActions.staticWait(5000);
		return reusableActions.isElementVisible(continueButton , 30);
	}
		
	/***
	 * Click on the continue button
	 * @author saurav.goyal
	 */
	public void clickContinueButton() {
		reusableActions.clickWhenReady(continueButton, 10);
	}
	
	/**
	 * This method check whether a Modal page is getting displayed or not
	 * @return a boolean value true if a modal window will appear else false
	 * @author saurav.goyal
	 */
	public boolean isModalDisplayed() {	
		return reusableActions.isElementVisible(modalContainer , 30);
	}
	
	/**
	 * This method verifies whether or not Get Started button is available in a model
	 * @return a boolean true if element is present else false
	 * @author saurav.goyal
	 */
	public boolean verifyGetStartedButtonOnModal() {	
		if(reusableActions.isElementVisible(modalContainerGetStartedbutton)) 
			return true; 
		else 
			return false;

	}
	
	/**
	 * This method clicks on a Get Started button in a Modal window
	 * @author saurav.goyal
	 */
	public void clickGetStartedButtonOnModal() {	
		reusableActions.clickIfAvailable(modalContainerGetStartedbutton);
	}

	/**
	 * This method verifies if accessories option is displayed
	 * @return true if Add accessories option is displayed, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyAddAccessoriesOption() {
		return reusableActions.isElementVisible(addAccessoriesOption);
	}

	/**
	 * This method clicks on Add accessories option
	 * @author praveen.kumar7
	 */
	public void clkAddAccessoriesOption() {
		reusableActions.clickWhenVisible(addAccessoriesOption);
	}

	/**
	 * This method add the accessories to the cart(From Recommended section and view details)
	 * @param accessoryCount
	 * @param accessory1
	 * @author praveen.kumar7
	 */
	public void addAccessoriesToCart(String accessoryCount, String accessory1) {
		if(accessoryCount.equalsIgnoreCase("MULTIPLE")) {
			//reusableActions.clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@title='Add']"));
			reusableActions.clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@data-test='add-to-cart']"));
			reusableActions.clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@data-test='view-details-accessory']"));
			reusableActions.waitForElementVisibility(accessoryViewDetailsModal);
			reusableActions.clickWhenVisible(btnAddToCartAccessoriesViewDetailsModal,10);
			reusableActions.javascriptScrollToTopOfPage();
			reusableActions.javascriptScrollByVisibleElement(reusableActions.getWhenReady(addAccessoriesOption));
		}
		else {
			reusableActions.clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@data-test='add-to-cart']"));
		}
	}

	/**
	 * This method clicks on continue button after selecting accessories
	 * @author praveen.kumar7
	 */
	public void clkContinueAccessories() {
		reusableActions.clickWhenVisible(btnContinueAccessories);

	}
	
}
	
	