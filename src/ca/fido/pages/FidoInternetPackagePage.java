package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FidoInternetPackagePage extends BasePageClass {

	public FidoInternetPackagePage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//ins[@translate='global.label.exchangeHardware']")
	WebElement lnkExchangeHardware;
		
	@FindBy(xpath="//input[@id='equipmentSerialNumber']")
	WebElement txtEquipmentSerialNumber;
	
	
	@FindBy(xpath="//input[@id='newSerial']")
	WebElement txtNewSerial;
	
	
	@FindBy(xpath="//ins[@translate='global.cta.confirm']")
	WebElement btnConfirmTheExchange;
	
	@FindBy(xpath="//ins[@translate='global.cta.printReceipt2']")
	WebElement btnPrintReceipt;
	
	@FindBy(xpath="//ins[@translate='global.cta.printReceipt1']")
	WebElement lnkPrintReceiptTo;
	
	@FindBy(xpath="//span[@id='account-no']")
	WebElement txtAccountnumber;
	
	/**
	 * Click on ExchangeHardware link on the package page
	 * @author chinnarao.vattam
	 */	
	public void clkExchangeHardware() {						
		reusableActions.getWhenVisible(lnkExchangeHardware,40).click();
	}
	
	/**
	 * Set the old Equipment SerialNumber on Exchange modem popup
	 * @param strSerialNumber Serial Number to be change
	 * @author chinnarao.vattam
	 */
	public void setEquipmentSerialNumber(String strSerialNumber) {
		reusableActions.getWhenReady(txtEquipmentSerialNumber).clear();
		reusableActions.getWhenReady(txtEquipmentSerialNumber).click();
		reusableActions.getWhenReady(txtEquipmentSerialNumber).sendKeys(strSerialNumber);
	}
	
	/**
	 * Set the new Equipment SerialNumber on Exchange modem popup
	 * @param strSerialNumber Serial Number to be required
	 * @author chinnarao.vattam
	 */
	public void setNewSerial(String strSerialNumber) {
		reusableActions.getWhenReady(txtNewSerial).clear();
		reusableActions.getWhenReady(txtNewSerial).click();
		reusableActions.getWhenReady(txtNewSerial).sendKeys(strSerialNumber);
	}
		
	
	/**
	 * Click the one Confirm Exchange button on  Exchange modem popup
	 * @author chinnarao.vattam 
	 */
	public void clkConfirmTheExchange() {		
		reusableActions.getWhenVisible(btnConfirmTheExchange,60).click();
	}
	
	/**
	 * Click the Print Receipt button on  success modem exchange popup
	 * @author chinnarao.vattam 
	 */
	public void clkPrintReceipt() {	
		reusableActions.waitForElementVisibility(btnPrintReceipt,120);
		reusableActions.getWhenReady(btnPrintReceipt,180);
		reusableActions.getWhenReady(btnPrintReceipt,120).click();
	}
	
	/**
	 * Verify the print receipt link on the  modem exchange receipt page
	 * @return true when the link is visible ,else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyPrintReceiptLink() {		
		return reusableActions.isElementVisible(lnkPrintReceiptTo,20);
	}
	
	/**
	 * Verify the account number on the  modem exchange receipt page
	 * @param strAccount account number of the Internet connection
	 * @return true if the account is as same as the input account  ,else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyAcountNumberOnReceipt(String strAccount) {	
		String strActualAcc =reusableActions.getWhenVisible(txtAccountnumber,20).getText();
		if (strAccount.equalsIgnoreCase(strActualAcc))
		{
		return true; 
		}
		return false;
	}
}
