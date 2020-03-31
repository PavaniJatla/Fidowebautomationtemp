package ca.fido.ssp.pages;
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
	
	@FindBy(xpath="//input[@id='passwordInput']")
	WebElement txtPassword;
	
	@FindBy(xpath="//span[@id='submitButton']")
	WebElement btnSubmitButton;
	
	@FindBy(xpath="//span[@class='ds-inputLabel d-block ds-no-overflow']")
	WebElement txtDealerCode;
	
	
	//input[@formcontrolname='dealerCode']
	
	
   
		
}
