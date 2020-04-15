package ca.fido.ssp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;


public class SSPFidoRetailerChampPage extends BasePageClass {

	public SSPFidoRetailerChampPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//input[@name='loginfmt']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement btnNext;
	
	@FindBy(xpath="//input[@id='passwordInput']")
	WebElement txtPassword;
	
	@FindBy(xpath="//span[@id='submitButton']")
	WebElement btnSignIn;
	
	@FindBy(xpath="//div[@id='cdk-overlay-0']//button[contains(@class,'ds-button ds-corners ds-pointer')]")
	WebElement btnAccept;	
	
	@FindBy(xpath="//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtDealerCodeContainer;
	
	@FindBy(xpath="//span[contains(@class,'ds-formField__labelWrapper position-absolute')]")
	WebElement txtDealerCodeContainer1;
		
	@FindBy(xpath="//input[@id='ds-form-input-id-0']")
	WebElement txtDealerCode;

	@FindBy(xpath="//button[contains(@class,'ml-16 ds-button ds-corners ds-pointer')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//p[contains(text(),'Authorized Application') or contains(text(),'Application autorisée')]")
	WebElement txtAuthorized;
	
	
	
	/**
	 * To set the txtUsername
	 * @param strUsername user name 
	 * @author chinnarao.vattam
	 */
	public void setUsername(String strUsername) {
		reusableActions.getWhenReady(txtUsername,5).clear();
		reusableActions.getWhenReady(txtUsername, 2).sendKeys(strUsername);
	}
	
	/**
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkNext() {	
		reusableActions.getWhenReady(btnNext, 30).click();
	}
	
	/**
	 * To set the txtUsername
	 * @param strUsername user name 
	 * @author chinnarao.vattam
	 */
	public void setPassword(String strPassword) {
		reusableActions.getWhenReady(txtPassword,5).clear();
		reusableActions.getWhenReady(txtPassword, 2).sendKeys(strPassword);
	}
		
	/**
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkSignIn() {	
		reusableActions.getWhenReady(btnSignIn, 30).click();
	}

	/**
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkAccept() {	
		reusableActions.getWhenReady(btnAccept, 60).click();
	}
	
	/**
	 * To set the txtUsername
	 * @param strUsername user name 
	 * @author chinnarao.vattam
	 */
	public void setDealerCode(String strDealerCode) {
		reusableActions.waitForElementVisibility(txtDealerCodeContainer,60);
		reusableActions.executeJavaScriptClick(txtDealerCode);
		reusableActions.getWhenReady(txtDealerCode,10).clear();
		reusableActions.getWhenReady(txtDealerCode, 2).sendKeys(strDealerCode);
	}
	
	/**
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void clkSubmit() {	
		reusableActions.getWhenReady(btnSubmit, 30).click();
	}
	
	/**
     * Verify the text Authorized
     * @return true, if the  ssp launch page  present at the text Authorized else false
     */
	public boolean verifyAuthorized() {		
		return reusableActions.isElementVisible(txtAuthorized,60);
	}
	
	/**
	 * Click on availability button on the service ability Lookup popup
	 * @author chinnarao.vattam
	 */
	public void selSSPEnvironment(String strBandwidth) {		
		String mainWindow = driver.getWindowHandle();
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'Fido "+strBandwidth+"')]/ancestor::div[contains(@class,'ds-tile')]"),60).click();
		reusableActions.waitForNumberOfWindowsToBe(2);
		reusableActions.switchToNewWindow(mainWindow);	
	}
}
