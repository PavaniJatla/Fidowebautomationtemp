package ca.fido.ssp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;


public class SSPFidoRetailerSearchResultsPage extends BasePageClass {

	public SSPFidoRetailerSearchResultsPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//div[@class='searchResults']")
	WebElement elmsearchResults;
		
	@FindBy(id="uteLink0")
	WebElement lnkView;

	@FindBy(xpath="//div[@id='popupValidateId']")
	WebElement popupCustomerAuthRemainder;
	
	@FindBy(xpath="//button[@class='button cta continuePopupValidateId']")
	WebElement btnContinue;
	
	
	/**
	 * Verify the search results for the given account 
	 * @return the account details of the user based on the give account and postal code
	 */
	public boolean verifysearchResults() {		
		return reusableActions.isElementVisible(elmsearchResults,30);
	}
	
	/**
	 * Click on the view button
	 */
	public void clkView() {		
		reusableActions.getWhenVisible(lnkView,60).click();								
    }
	
	/**
	 * Verify the Customer Auth Remainder popup presence 
	 * @return trues if the Auth Remainder popup present on the user account details page, else false
	 */
	public boolean verifyCustomerAuthRemainder() {	
		reusableActions.waitForElementVisibility(popupCustomerAuthRemainder,60);
		return reusableActions.isElementVisible(popupCustomerAuthRemainder);
	}
	
	/**
	 * click on Continue to redirect the fido account page from ssp home page
	 */
	public void clkContinue() {		
		reusableActions.getWhenVisible(btnContinue,120).click();		
    }

		
}
