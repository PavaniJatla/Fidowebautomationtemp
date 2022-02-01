package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FidoChoosePhonePage extends BasePageClass {

	public FidoChoosePhonePage(WebDriver driver) {
		super(driver);		
	}

	public String strXpathViewDetails;

	@FindAll({
	@FindBy(xpath = "//span[contains(text(),'UPGRADE')]"),
	@FindBy(xpath = "//button[contains(@title,'Select')]")
	})
	WebElement upgradeMyDeviceButton;


	@FindBy(xpath = "//span[contains(text(),'ADD')]")
	WebElement addALineButton;

	@FindBy(xpath = "//input[contains(@name,'Tablets')]//following-sibling::div")
	WebElement tabletsCheckbox;

	@FindAll({
		@FindBy(xpath = "//div/h1[contains(@id,'bfa-page-title')]"),
		@FindBy(xpath = "//h2[@class='header-2 ng-scope']")
	})
	WebElement lblPhonesAndDevices;
	
	@FindBy(xpath = "//span[@price='0']/ancestor::div[@modelid]//button[@res='details_devicemodel' or @res='upgrade']")
	List<WebElement> btnZeroUpfrontDeviceDetails;
	
	//@FindBy(xpath = "//div[contains(@class,'phoneHeadingLabel')]/span")
	@FindBy(xpath = "//p[contains(@class,'text-title-5')]")
	List<WebElement> lblDeviceNames;
	
	@FindBy(xpath = "//button[@res='details_devicemodel' or @res='upgrade']")
	List<WebElement> btnDetails;
	
	@FindBy(xpath = "//div[contains(@class,'catalog-selector')]//span[@translate='device-manufacturer']")
	WebElement lblDeviceManufacturer;
	
	/**
	 * Validates that the Choose-Phones page load is successful
	 * @return true if the 'PHONES AND DEVICES' title displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChoosePhonesPageLoad() {
		return reusableActions.isElementVisible(lblPhonesAndDevices, 60);
	}
	
	/**
	 * Clicks on the 'Details' button against the first available device with '$0' upfront cost
	 * @author rajesh.varalli1
	 */
	public void selectFirstZeroUpfrontDeviceAvailable() {
		reusableActions.waitForElementVisibility(lblDeviceManufacturer,60);
		reusableActions.executeJavaScriptClick(btnZeroUpfrontDeviceDetails.get(0));
	}

	/**
	 * Method is used to create xpath for a particular device using device name
	 * @param deviceName Name of the Device needed
	 * @return xpath value of the device as a String
	 * @author praveen.kumar7
	 */
	public String createXpathWithDeviceName(String deviceName) {
		String verifyCPODevice = reusableActions.getWhenReady(By.xpath("(//a[contains(@title,'"+deviceName+"')])[1]/../preceding-sibling::div[1]"),40).getText().toLowerCase();
		if(verifyCPODevice.contains("certified")) {
			strXpathViewDetails =  "(//a[contains(@title,'"+deviceName+"')])[2]";
			return strXpathViewDetails;
		}
		else {
			return "(//a[contains(@title,'"+ deviceName +"')])[1]";
		}
	}

	/**
	 * Method is used to select the Tablets Checkbox
	 * @author sidhartha.vadrevu
	 */
	public void selectTabletsCheckbox() {
		reusableActions.waitForElementVisibility(tabletsCheckbox);
		reusableActions.scrollToElement(tabletsCheckbox);
		reusableActions.clickIfAvailable(tabletsCheckbox,10);
		reusableActions.staticWait(5000);
	}

	/**
	 * Selects by clicking on 'View Details' button against the device needed
	 * @param deviceName Name of the Device needed
	 * @return true if device found; else false
	 * @author rajesh.varalli1
	 */
	public boolean selectDevice(String deviceName) {
		reusableActions.waitForElementTobeClickable(reusableActions.getWhenReady(By.xpath("(//a[contains(@title,'"+deviceName+"')])[1]/../preceding-sibling::div[1]")),60);
			strXpathViewDetails = createXpathWithDeviceName(deviceName);
			if(reusableActions.isElementVisible(By.xpath(strXpathViewDetails),60)) {
				reusableActions.executeJavaScriptClick(driver.findElement(By.xpath(strXpathViewDetails)));
				return true;
			}
		return false;
	}

	/**
	 * Method is used to select Upgrade My Device button
	 * @author sidhartha.vadrevu
	 */
	public void selectUpgradeMyDeviceButton() {
		reusableActions.waitForElementVisibility(upgradeMyDeviceButton);
		reusableActions.clickIfAvailable(upgradeMyDeviceButton,10);
	}

	/**
	 * Method is used to select Add a Line Button
	 * @author sidhartha.vadrevu
	 */
	public void selectAddALineButton() {
		reusableActions.waitForElementVisibility(addALineButton);
		reusableActions.clickIfAvailable(addALineButton,10);
	}

	
	/**
	 * Selects the Subscriber on the Choose a line overlay and clicks Continue
	 * @param strCTN Subscriber phone number
	 * @author rajesh.varalli1 
	 */
	public void selectSubscriber(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		String strCtnXpath = "//div[@class='choose-ctn-modal']//div[text()='"+ strCTN +"']";
		
		if(reusableActions.isElementVisible(By.xpath(strCtnXpath))) {
			reusableActions.clickWhenReady(By.xpath(strCtnXpath));
			reusableActions.clickWhenReady(By.xpath("//button[@res='_continue']"));
		}
		
	}
		
}
	