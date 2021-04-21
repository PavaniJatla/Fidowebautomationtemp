package ca.fido.ssp.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SSPFidoRetailerShopPage extends BasePageClass {

	public SSPFidoRetailerShopPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(id ="cfa_username")
	WebElement txtUserName;
	
	@FindBy(id ="cfa_password")
	WebElement txtPassword;
	
	@FindBy(id ="cfa_passwordLabel")
	WebElement txtPasswordLabel;
	
	@FindBy(id ="cfa_dealerCode")
	WebElement txtDealerCode;
	
	@FindBy(id ="cfa_dealerCodeLabel")
	WebElement txtDealerCodeLabel;
	
	@FindBy(xpath ="//button[@class='newSignIn signIn submitButton binded']")
	WebElement btnLogIn;
	
	@FindBy(xpath ="//button[@class='button displayaslink']/ancestor::div[@id='cfa_online_policy_agreement']//button[@id='cfa_online_policy_acceptBtn']")
	WebElement btnSecurityPopup;
	
	/**
	 * set the username on the ssp.fido retailer page	
	 * @param strUsername is the user name of the retailer 
	 */
	public void setUserName(String strUsername) {
		reusableActions.getWhenReady(txtUserName).clear();
		reusableActions.getWhenReady(txtUserName).click();
		reusableActions.getWhenReady(txtUserName).sendKeys(strUsername);
	}
	
	/**
	 * set the password on the ssp.fido retailer page	
	 * @param strPassword is the password of the retailer 
	 */
	public void setPassword(String strPassword) {
		reusableActions.getWhenReady(txtPasswordLabel,10).click();
		txtPassword.sendKeys(strPassword);
	}
	
	/**
	 * set the dealer code of the retailer 
	 * @param strDealerCode is the dealer code of the retailer 
	 */
	public void setDealerCode(String strDealerCode) {
		reusableActions.getWhenReady(txtDealerCodeLabel,10).click();
		txtDealerCode.sendKeys(strDealerCode);
	}
	
	/**
	 * Click on the login button on the retailer page of ssp.fdo.ca
	 */
	public void clkLogin() {
		reusableActions.getWhenReady(btnLogIn, 30).click();						
    }
	
	/**
	 * Click on the accept button on the Security Popup
	 */
	public void clkSecurityAccept() {		
		reusableActions.clickIfAvailable(btnSecurityPopup,60);
								
    }
	
			
}
