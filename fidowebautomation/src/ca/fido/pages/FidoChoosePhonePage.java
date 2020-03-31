package ca.fido.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoChoosePhonePage extends BasePageClass {

	public FidoChoosePhonePage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath = "//div/h1[@id='phonesDevices phonesDevicesFont']")
	WebElement lblPhonesAndDevices;
	
	@FindBy(xpath = "//span[@price='0']/ancestor::div[@modelid]//button[@res='details_devicemodel' or @res='upgrade']")
	List<WebElement> btnZeroUpfrontDeviceDetails;
	
	@FindBy(xpath = "//div[contains(@class,'phoneHeadingLabel')]/span")
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
		return reusableActions.isElementVisible(lblPhonesAndDevices);
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
	 * Selects by clicking on 'Details' button against the device needed 
	 * @param strDeviceName Name of the Device needed
	 * @return true if device found; else false
	 * @author rajesh.varalli1
	 */
	public boolean selectDevice(String strDeviceName) {
		reusableActions.waitForElementVisibility(lblDeviceManufacturer,100);
		for (int index = 0; index < lblDeviceNames.size(); index++) {
			if(lblDeviceNames.get(index).getText().toLowerCase().contains(strDeviceName.trim().toLowerCase())) {
				reusableActions.executeJavaScriptClick(btnDetails.get(index));
				return true;
			}
		}
		return false;
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
