package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class CreditCheckPage  extends BasePageClass {

	public CreditCheckPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Date of Birth') or contains(text(),'Date de naissance')]/ancestor::div[@class='row']//span[text()='Année' or text()='Year']/ancestor::span/preceding-sibling::select")
	WebElement year;
	
	@FindBy(xpath = "//span[contains(text(),'Date of Birth') or contains(text(),'Date de naissance')]/ancestor::div[@class='row']//span[text()='Mois' or text()='Month']/ancestor::span/preceding-sibling::select")
	WebElement month;
	
	@FindBy(xpath = "//span[contains(text(),'Date of Birth') or contains(text(),'Date de naissance')]/ancestor::div[@class='row']//span[text()='Jour' or text()='Day']/ancestor::span/preceding-sibling::select")
	WebElement date;
	
	@FindBy(xpath = "//span[contains(text(),'Votre première pièce')or contains(text(),'Your first ID option')]/ancestor::span/preceding-sibling::select")
	WebElement iD;
	
	@FindBy(xpath = "//span[contains(text(),'Sélectionner une province')or contains(text(),'Select Province')]/ancestor::span/preceding-sibling::select")
	WebElement province;
	
	@FindBy(xpath = "//span[contains(text(),'ID options') or contains(text(),'Options d’identification')]/ancestor::div[@class='row']/parent::div//span[text()='Année' or text()='Year']/ancestor::span/preceding-sibling::select")
	WebElement licenseExpiryYear;
	
	@FindBy(xpath = "//span[contains(text(),'ID options') or contains(text(),'Options d’identification')]/ancestor::div[@class='row']/parent::div//span[text()='Mois' or text()='Month']/ancestor::span/preceding-sibling::select")
	WebElement licenseExpiryMonth;
	
	@FindBy(xpath = "//span[contains(text(),'ID options') or contains(text(),'Options d’identification')]/ancestor::div[@class='row']/parent::div//span[text()='Jour' or text()='Day']/ancestor::span/preceding-sibling::select")
	WebElement licenseExpiryDay;
	
	@FindBy(xpath = "//span[contains(text(),'2. ID')  or contains(text(),'identification (deux pie')]/parent::div/parent::div/parent::div//input/parent::div")
	WebElement licenseNoContainer;
	
	@FindBy(xpath = "//span[contains(text(),'2. ID')  or contains(text(),'identification (deux pie')]/parent::div/parent::div/parent::div//input")
	WebElement licenseNoInput;
	
	@FindBy(xpath = "//span[contains(text(),'Your second ID option') or contains(text(),'Deuxieme piece d’identite')]/ancestor::span/preceding-sibling::select")
	WebElement secondID;
	
	@FindBy(xpath = "//span[contains(text(),'Second ID') or contains(text(),'Deuxième pièce')]/parent::div/parent::div//input/parent::div")
	WebElement passportContainer;
	
	@FindBy(xpath = "//span[contains(text(),'Passport number') or contains(text(),'Numéro de passeport')]/ancestor::span/parent::div//input")
	WebElement passportInput;
	
	@FindBy(xpath = "//span[contains(text(),'Second ID option') or contains(text(),'Deuxième pièce')]/parent::div/parent::div//span[text()='Année' or text()='Year']/ancestor::span/preceding-sibling::select")
	WebElement passportExpiryYear;
	
	@FindBy(xpath = "//span[contains(text(),'Second ID option') or contains(text(),'Deuxième pièce')]/parent::div/parent::div//span[text()='Mois' or text()='Month']/ancestor::span/preceding-sibling::select")
	WebElement passportExpiryMonth;
	
	@FindBy(xpath = "//span[contains(text(),'Second ID option') or contains(text(),'Deuxième pièce')]/parent::div/parent::div//span[text()='Jour' or text()='Day']/ancestor::span/preceding-sibling::select")
	WebElement passportExpiryDay;
	
	@FindBy(xpath = "//span[contains(text(),'The customer authorizes') or contains(text(),'Le client autorise Rogers à obtenir des renseignements')]/parent::div/ancestor::ds-checkbox//div[1]")
	WebElement authorizecheckbox;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;
	/**
	 * Select Date of Birth
	 * @param yearofBirth is the Birth Year to set
	 * @param monthofBirth is the Birth Month to set
	 * @param dayofBirth is the Birth day to set
	 * @author Harpartap.Virk
	 */	
	public void setDOB(String yearofBirth,String monthofBirth,String dayofBirth) {	
		getReusableActionsInstance().selectWhenReadyByVisibleText(year, yearofBirth);
		getReusableActionsInstance().selectWhenReady(month,Integer.parseInt(monthofBirth));
		getReusableActionsInstance().selectWhenReadyByVisibleText(date, dayofBirth);
	}
	/**
	 * Select ID's Type and Details
	 * @param expiryYear is ID Expiry Year to set
	 * @param idExpiryMonth is ID Expiry Month to set
	 * @param idExpiryDay is the ID Expiry Day to set 
	 * @param passportNo is the Passport no. to set
	 * @author Harpartap.Virk
	 */	
	public void setPassport(String expiryYear, String idExpiryMonth,String idExpiryDay,String passportNo ) {	
		getReusableActionsInstance().javascriptScrollByVisibleElement(secondID);
		getReusableActionsInstance().selectWhenReady(secondID,3);
		getReusableActionsInstance().javascriptScrollByVisibleElement(passportContainer);
		getReusableActionsInstance().clickWhenReady(passportContainer);
		getReusableActionsInstance().javascriptScrollByVisibleElement(passportInput);
		getReusableActionsInstance().enterText(passportInput, passportNo, 30);
		getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryYear);
		getReusableActionsInstance().selectWhenReadyByVisibleText(passportExpiryYear, expiryYear);
		getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryMonth);
		getReusableActionsInstance().selectWhenReady(passportExpiryMonth,Integer.parseInt(idExpiryMonth));
		getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryDay);
		getReusableActionsInstance().selectWhenReadyByVisibleText(passportExpiryDay, idExpiryDay);
	}
	/**
	 * Select ID's Type and Details
	 * @param provinc is the Province to set
	 * @param expiryYear is ID Expiry Year to set
	 * @param idExpiryMonth is ID Expiry Month to set
	 * @param idExpiryDay is the ID Expiry Day to set 
	 * @param licenseNo is the DL No. to set
	 * @author Harpartap.Virk
	 */	
	public void setDriversLicense(String provinc,String expiryYear, String idExpiryMonth,String idExpiryDay,String licenseNo) {	
		//getReusableActionsInstance().selectWhenReadyByVisibleText(iD, iD1);
		getReusableActionsInstance().selectWhenReady(iD,2);
		getReusableActionsInstance().selectWhenReadyByVisibleText(province, provinc);
		getReusableActionsInstance().javascriptScrollByVisibleElement(licenseExpiryYear);
		getReusableActionsInstance().selectWhenReadyByVisibleText(licenseExpiryYear, expiryYear);
		getReusableActionsInstance().javascriptScrollByVisibleElement(licenseExpiryMonth);
		getReusableActionsInstance().selectWhenReady(licenseExpiryMonth,Integer.parseInt(idExpiryMonth));
		getReusableActionsInstance().javascriptScrollByVisibleElement(licenseExpiryDay);
		getReusableActionsInstance().selectWhenReadyByVisibleText(licenseExpiryDay, idExpiryDay);
		getReusableActionsInstance().javascriptScrollByVisibleElement(licenseNoContainer);
		getReusableActionsInstance().clickWhenReady(licenseNoContainer);
		getReusableActionsInstance().javascriptScrollByVisibleElement(licenseNoInput);
		getReusableActionsInstance().enterText(licenseNoInput, licenseNo, 30);
	}
	/**
	 * Verify Credit Check Information is correct
	 * @return true if Continue Button in Enable else return False
	 * @author Harpartap.Virk
	 */	
	public boolean verifyCreditInfo() {	
		return getReusableActionsInstance().isElementVisible(continueButton);
	}
	/**
	 * Click Continue Button after Credit Information Entered 
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {	
		getReusableActionsInstance().clickWhenReady(continueButton);
	}
	/**
	 * Click Authorization Checkbox 
	 * @author Harpartap.Virk
	 */	
	public void clkAuthorize() {	
		getReusableActionsInstance().clickWhenReady(authorizecheckbox);
	}
	/**
	 * Click Collapse(Down Arrow)
	 * @author Harpartap.Virk
	 */	
	public void clkCollapse() {
		getReusableActionsInstance().clickIfAvailable(collapse,60);
	}
}

