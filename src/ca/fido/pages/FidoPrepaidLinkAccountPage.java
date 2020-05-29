package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoPrepaidLinkAccountPage extends BasePageClass {

	public FidoPrepaidLinkAccountPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//ins[@translate='global.label.connectMyAccountLink']")
	WebElement headerConnectMyAccount;
	
	@FindBy (xpath = "//label[@for='link-prepaid-customer']")
	WebElement labelPrepaidService;
	
	@FindBy (xpath = "//input[@id='linkAccountPrepaidPhoneNo']")
	WebElement inputPhoneNum;
	
	@FindBy (xpath = "//ins[@translate='global.cta.sendCode']")
	WebElement btnSendCode;
	
	/**
	 * Verifies the header of connect my account for prepaid account displayed
	 * @return true if the header is displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyHeaderConnectMyAccountDisplayed() {
		return reusableActions.isElementVisible(headerConnectMyAccount, 10);
	}
	
	/**
	 * Click radio button "I have prepaid service."
	 * @author ning.xue
	 */	
	public void clkLabelPrepaidService() {
		reusableActions.clickWhenReady(labelPrepaidService,2);
	}
	
	/**
	 * Enters the prepaid CTN to link
	 * @param strPrepaidCtn, String, Fido prepaid phone number
	 * @author ning.xue
	 */
	public void setFidoPrepaidCtn(String strPrepaidCtn) {
		reusableActions.getWhenReady(inputPhoneNum, 10).clear();
		reusableActions.getWhenReady(inputPhoneNum,3).sendKeys(strPrepaidCtn);
	}

	/**
	 * Click button "Send me a code."
	 * @author ning.xue
	 */	
	public void clkBtnSendMeCode() {
		reusableActions.clickWhenReady(btnSendCode,2);
	}
}
