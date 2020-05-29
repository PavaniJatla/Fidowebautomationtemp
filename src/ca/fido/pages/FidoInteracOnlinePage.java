package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;



public class FidoInteracOnlinePage extends BasePageClass {

	public FidoInteracOnlinePage(WebDriver driver) {
		super(driver);
		
	}
		
	
	@FindBy (xpath="//a[@class='issuerLink']")
	WebElement imgChooseFinancialInstitution;
	
	@FindBy(xpath="//*[@id='clickable-controls']//td[text()='INVOICE NO']/following-sibling::td[@class='payvalue']")
	WebElement lblInvoiceNumber;
	
	@FindBy(xpath="//*[@id='clickable-controls']//td[text()='AMOUNT']/following-sibling::td[@class='payvalue']")
	WebElement lblAmount;
	
	@FindBy(name = "NOT_FUND")
	WebElement btnDontFundPayment;	

	@FindBy(name = "FUND")
	WebElement btnFundPayment;
	
	@FindBy(xpath="//ins[@translate='global.error.postBack.payment.interacError']")
	WebElement lblInteracError;
	
	@FindBy(id="IDEBIT_TRACK2")
	WebElement txtInteracID;
	
	@FindBy(xpath = "//*[@id='issuerForm']/div[1]/div[1]/h5")
	WebElement lblDataToBeSubmittedHeader;
	
	@FindBy (xpath = "//div[@id='main-message']")
	WebElement msgFromInterac;
	
	@FindBy (xpath = "//button[@id='details-button']")
	WebElement btnAdvance;
	
	@FindBy (xpath = "//a[@id='proceed-link']")
	WebElement lnkProceed;
	
	/**
	 * Check if the "your connection is not private" message displayed
	 * @return true if message displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean isMsgFromInteracDisplayed() {
		return reusableActions.isElementVisible(msgFromInterac, 10);
	}
	
	/**
	 * Clicks the advance button
	 * @author ning.xue
	 */
	public void clkBtnAdvance() {
		reusableActions.clickIfAvailable(btnAdvance);
		
	}
	
	/**
	 * Clicks the link to proceed
	 * @author ning.xue
	 */
	public void clkLinkProceed() {
		reusableActions.clickIfAvailable(lnkProceed);
		
	}
	
	/**
	 * Clicks the financial institution option on interac website
	 * @author Mirza.Kamran
	 */
	public void selectFinancialInstitution() {
		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && ! clickSuccess) {
			reusableActions.waitForElementVisibility(imgChooseFinancialInstitution);
			reusableActions.waitForElementTobeClickable(imgChooseFinancialInstitution, 60);		
			reusableActions.executeJavaScriptClick(imgChooseFinancialInstitution);
			if(reusableActions.isDisplayed(txtInteracID)){
				clickSuccess=true;
				break;
			}
			count++;
		}
		
		if(clickSuccess) {
			System.out.println("Financial institution click was successful");
		}
		
	}
	
	/**
	 * Clicks the Fund payment button
	 * @author Mirza.Kamran
	 */
	public void selectFundAPayment() {
		reusableActions.clickIfAvailable(btnFundPayment);
		
	}
	
	/**
	 * Sets the interac ID on the interac payment website
	 * @param strInteracID string containing interac ID
	 * @author Mirza.Kamran
	 */
	public void setInteracID(String strInteracID) {
		reusableActions.waitForElementVisibility(txtInteracID, 30);
		reusableActions.getWhenReady(txtInteracID).clear();
		reusableActions.getWhenReady(txtInteracID).sendKeys(strInteracID);	
		reusableActions.getWhenReady(lblDataToBeSubmittedHeader).click();
	}
	
}
    

