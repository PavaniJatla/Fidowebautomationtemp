package ca.fido.ssp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;


public class SSPFidoRetailerHomePage extends BasePageClass {

	public SSPFidoRetailerHomePage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(id="uteFHSIButton")
	WebElement lnkInternet;
	
	@FindBy(xpath="//select[@id='uteFHSIButtonS']")
	WebElement slctEnvironment;
	
	@FindBy(xpath="//div[@id='cfa-signed-in']")
	WebElement bnrLogin;	
	
	@FindBy(id="combinedInput")
	WebElement txtAccountNumber;
	
	@FindBy(id="postalcode")
	WebElement txtPostalCode;
	
	@FindBy(id="searchButton")
	WebElement btnSearchButton;
	
	@FindBy(xpath="//ins[@translate='global.label.internetHome']")
	WebElement lnkFidoHomeInternet;
	
	@FindBy(xpath="//a[@id='manageProfileSkip']")
	WebElement lnkSkip;
	
    /**
     * Verify the Internet link on the fido.ca navigation bar
     * @return true, if the  Internet link present at the navigation bar else false
     */
	public boolean verifyFidoHomeInternet() {		
		return reusableActions.isElementVisible(lnkFidoHomeInternet,240);		
	}
	
	/**
	 * Click on the skip button on the feedback popup
	 */
	public void clkSkip() {		
		reusableActions.clickIfAvailable(lnkSkip,30);
								
    }
	
	/**
     * Verify the Internet link on the ssp.fido.ca home page navigation bar
     * @return true, if the  Internet link present at the navigation bar else false
     */
	public boolean verifyLoginBanner() {		
		return reusableActions.isElementVisible(bnrLogin,240);
	}
	/**
	 * click on the Internet link on the navigation bar
	 */
	public void clkInternet() {		
		reusableActions.getWhenVisible(lnkInternet,30).click();
								
    }
	
	/**
     * Verify the Internet link on the ssp.fido.ca home page navigation bar
     * @return true, if the  Internet link present at the navigation bar else false
     */
	public boolean verifyInternet() {		
		return reusableActions.isElementVisible(lnkInternet,30);
	}
	
	/**
	 * To set the postal code on the account details section on the ssp.fido home page
	 * @param strPostalCode set the postal code 
	 */
	public void setPostalCode(String strPostalCode) {
		reusableActions.getWhenReady(txtPostalCode).clear();
		reusableActions.getWhenReady(txtPostalCode).click();
		reusableActions.getWhenReady(txtPostalCode).sendKeys(strPostalCode);
	}
	
	/**
	 *  To set the account number on the account details section on the ssp.fido home page
	 * @param strAccountNumber set the account number
	 */
	public void setAccountNumber(String strAccountNumber) {
		reusableActions.getWhenReady(txtAccountNumber).clear();
		reusableActions.getWhenReady(txtAccountNumber).click();
		reusableActions.getWhenReady(txtAccountNumber).sendKeys(strAccountNumber);
	}
	
	/**
	 * Click on the search button on the ssp.fido home page to get the user details for the entered account
	 */
	public void clkSearchButton() {		
		reusableActions.getWhenVisible(btnSearchButton,30).click();
								
    }
		
	/**
	 * select the environment for the fido.ca on the ssp home page 
	 * @param strEnvironment set the environment to be used for the fido.ca
	 */
	public void selectEnvironment(String strEnvironment) {
		reusableActions.waitForElementVisibility(slctEnvironment, 20);
		reusableActions.selectWhenReady(slctEnvironment, strEnvironment,30);
	} 
	
		
}
