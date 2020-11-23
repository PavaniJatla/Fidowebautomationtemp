package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class FidoCreditCheckPage extends BasePageClass {

	public FidoCreditCheckPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//select[@id='creditCheckYear' or @id='dobyear' or @data-test='dob-select-year']")
	WebElement ddlDOBYear;

	@FindBy(xpath="//select[@id='creditCheckMonth' or @id='dobmonth' or @data-test='dob-select-month']")
	WebElement ddlDOBMonth;

	@FindBy(xpath="//select[@id='creditCheckDay' or @id='dobday' or @data-test='dob-select-day']")
	WebElement ddlDOBDay;

	@FindBy(xpath="//select[@id='firstIdOption']")
	WebElement ddlFirstIdOption;

	@FindBy(xpath = "//select[(@ng-model='driverLicense.dlProvince' or @ng-model='obj.drivingLicenseProvince') and (@name='dlProvince' or @name='province') or @formcontrolname='province']")
	WebElement ddlDlProvince;
	
	@FindBy(xpath = "//select[@formcontrolname='thirdId']")
	WebElement idType;

	@FindBy(xpath="//select[@name='dlExpiryYear' or @name='dlYear']")
	WebElement ddlDlExpiryYear;

	@FindBy(xpath="//select[@name='dlExpiryMonth' or @name='dlMonth']")
	WebElement ddlDlExpiryMonth;

	@FindBy(xpath="//select[@name='dlExpiryDay' or @name='dlExpiryDate']")
	WebElement ddlDlExpiryDay;

	@FindBy(xpath="//input[@id='dlLicenseNumber' or @name='dlCardNumber' or @formcontrolname='number']/parent::div")
	WebElement txtDlLicenseNumber;
	
	@FindBy(xpath="//input[@id='dlLicenseNumber' or @name='dlCardNumber' or @formcontrolname='number']")
	WebElement lblTxtDlLicenseNumber;

	@FindBy(xpath="//select[@name='secondIdOption1']")
	WebElement ddlSecondIdOption;

	@FindBy(xpath = "//input[@id='ppNumber' and @ng-model='passport.ppNumber']")
	WebElement txtPpNumber;
	
	@FindBy(xpath="//ds-form-field[@data-test='license-number-expiry']//input[@formcontrolname='expiryDate']/parent::div")
	WebElement txtdLExpiryDate;
	
	@FindBy(xpath="//ds-form-field[@data-test='license-number-expiry']//input[@formcontrolname='expiryDate']")
	WebElement lblTxtdLExpiryDate;
	
	@FindBy(xpath="//select[@name='ppExpiryYear']")
	WebElement drLExpiryDate;
	
	@FindBy(xpath="//select[@name='ppExpiryYear']")
	WebElement lblDrLExpiryDate;
	
	@FindBy(xpath="//select[@name='ppExpiryYear']")
	WebElement ddlPasspoartExpiryYear;

	@FindBy(xpath="//select[@name='ppExpiryMonth']")
	WebElement ddlPasspoartExpiryMonth;

	@FindBy(xpath="//select[@name='ppExpiryDay']")
	WebElement ddlPasspoartExpiryDay;

	@FindAll({
		@FindBy(xpath = "//label[@for='credit_check_consent' or @for='creditCheckBox']"),
		@FindBy(xpath = "//div[contains(@class,'ds-checkbox__box')]")
	})
	WebElement lblCreditCheckConsent;
 
	@FindBy(xpath="//input[@name='submit']")
	WebElement btnCreditCheckSubmit;
	
	@FindBy(xpath="//div[contains(@class,'iframe')]//iframe")
	WebElement frmCreditCard;
	
	@FindBy(xpath="//input[@id='maskedPan']")
	WebElement txtCreditCardNumberMasked;
	
	@FindBy(xpath="//input[@id='pan']")
	WebElement txtCreditCardNumber;

	@FindAll({
		@FindBy(xpath="//select[@name='month']"),
		@FindBy(xpath="//input[@formcontrolname='expiryDate']/parent::div")
	})
	WebElement ddlCreditCardExpiryMonthAndYear;
	
	@FindBy(xpath="//input[@formcontrolname='expiryDate']")
	WebElement lblDdlCreditCardExpiryMonthAndYear;
	
	@FindBy(xpath="//select[@name='year']")
	WebElement ddlCreditCardExpiryYear;
	
	@FindAll({
		@FindBy(xpath="//span[@checkout-res='checkout_continue_lbl']/parent::button"),
		@FindBy(xpath="//button[@data-test='credit-eval-continue']")
	})
	WebElement btnContinue;
	
	@FindBy(xpath="//button[@data-test='modal-credit-evaluation-accept']")
	WebElement buttonSecurityDepositConsentAccept;
	
	@FindAll({
		@FindBy(xpath="//p[@class='msgLoad' and @checkout-res='checkout_creditCheck_is_processing']"),
		@FindBy(xpath="class='ds-modal__heading text-title-3 mb-24'")
	})
	WebElement lblCreditCheckProcessing;

	/**
	 * Set dynamic date of birth year on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		reusableActions.waitForElementVisibility(ddlDOBYear, 60);
		String strDOBYear = FormFiller.generateDOBYear();
		reusableActions.selectWhenReady(ddlDOBYear, strDOBYear);
	}

	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateMonth();
		reusableActions.waitForElementVisibility(ddlDOBMonth, 30);
		reusableActions.selectWhenReady(ddlDOBMonth, strDOBMonth);
	}
	
	public void selectDOBMonthSingleDigit() {
		String strDOBMonth = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlDOBMonth,strDOBMonth);
	}

	/**
	 * Set dynamic date of birth date on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDay() {
		String strDOBDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlDOBDay, strDOBDay);
	}

	/**
	 * Selects the first identification on Credit check page
	 * @param strFirstIdOption first identification of the user for credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectFirstIdOption(String strFirstIdOption) {
		reusableActions.waitForElementVisibility(ddlFirstIdOption, 20);
		reusableActions.selectWhenReady(ddlFirstIdOption, strFirstIdOption);
	}

	/**
	 * Selects identification type of the customer
	 * @param identificationType identificationType customer is providing
	 * @author Saurav.Goyal
	 */
	public void selectIdType(String identificationType) {
		reusableActions.waitForElementVisibility(idType, 20);
		reusableActions.selectWhenReady(idType, identificationType);
	}
	
	/**
	 * Selects the Province for the driving license on Credit check page
	 * @param strDlProvince province of the driver's license
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseProvince(String strDlProvince) {
		reusableActions.waitForElementVisibility(ddlDlProvince, 20);
		reusableActions.selectWhenReady(ddlDlProvince, strDlProvince);
	}

	/**
	 * Set expiry date for the driving license
	 * @param	dlExpiryDate : expiry date of the Driving license
	 * @author Saurav.Goyal
	 */
	public void setDrivingLicenseExpiry() {
		String dlExpiryDate = "23/12/2036";
		reusableActions.getWhenReady(txtdLExpiryDate, 10).click();
		reusableActions.getWhenReady(lblTxtdLExpiryDate, 10).sendKeys(dlExpiryDate);
	}
	
	/**
	 * Set dynamic expire year for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReady(ddlDlExpiryYear, strYYYY);
	}

	/**
	 * Set dynamic expire month for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryMonth() {
		String strDOBMonth = "0" + FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlDlExpiryMonth, strDOBMonth.substring(strDOBMonth.length()-2));
	}

	
	public void selectDrivingLicenseExpiryMonthSingleDigit() {
		String strDOBMonth = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlDlExpiryMonth, strDOBMonth);
	}
	/**
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryDay() {
		String expiryDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlDlExpiryDay, expiryDay, 20);
	}

	/**
	 * Set dynamic license number for British Columbia  on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumber() {
		String strLicenseNumber = FormFiller.generateLicenseNumber();
		reusableActions.getWhenReady(txtDlLicenseNumber, 10).clear();
		reusableActions.getWhenReady(txtDlLicenseNumber, 20).sendKeys(strLicenseNumber);
	}

	/**
	 * Selects the second identification on Credit check page
	 * @param strSecondIdOption second identification of the user for credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectSecondIdOption(String strSecondIdOption) {
		reusableActions.selectWhenReady(ddlSecondIdOption, strSecondIdOption, 20);
	}

	/**
	 * Set dynamic passport number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setPassportNumber() {
		String strPassportNumber = FormFiller.generatePassportNumber();
		reusableActions.waitForElementVisibility(txtPpNumber, 20);
		reusableActions.getWhenReady(txtPpNumber, 10).clear();
		reusableActions.getWhenReady(txtPpNumber, 30).sendKeys(strPassportNumber);
	}

	/**
	 * Set dynamic expire year for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryYear() {
		String strPasspoartExpiryYear = FormFiller.generateExpiryYear();
		reusableActions.waitForElementVisibility(ddlPasspoartExpiryYear, 20);
		reusableActions.selectWhenReady(ddlPasspoartExpiryYear, strPasspoartExpiryYear);
	}

	/**
	 * Set dynamic expire month for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPasspoartExpiryMonth() {
		String strPasspoartExpiryMonth = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlPasspoartExpiryMonth, strPasspoartExpiryMonth);
	}

	/**
	 * Set dynamic expire day for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPasspoartExpiryDay() {
		String strExpiryDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlPasspoartExpiryDay, strExpiryDay,30);
	}

	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditCheckConsent() {
		reusableActions.getWhenReady(lblCreditCheckConsent).click();		
	}
	
	/**
	 * Verify the Credit check Consent check box on Credit check page
	 * @return true, if the credit check consent box is visible, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCreditCheckConsent() {
		reusableActions.waitForElementVisibility(lblCreditCheckConsent, 90);
		return reusableActions.isElementVisible(lblCreditCheckConsent);
	}

	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditCheckSubmit() {
		reusableActions.getWhenReady(btnCreditCheckSubmit, 90).click();
	}
	
	/**
	 * Enters the Credit Card Number
	 * @param ccNumber Credit Card Number
	 * @author rajesh.varalli1
	 */
	public void setCreditCardNumber(String ccNumber) {
		reusableActions.javascriptScrollByVisibleElement(ddlDOBYear);
		driver.switchTo().frame(frmCreditCard);
		reusableActions.staticWait(5000);
		txtCreditCardNumber.click();
		txtCreditCardNumber.sendKeys(ccNumber);
		driver.switchTo().defaultContent();//checkout-res="checkout_credit_card_number"
	}
	
	/**
	 * Enter Credit Card Expiry month and year 
	 * @param monthAndYear in numbers like 0112,0212,....,1212
	 * @author Saurav.Goyal
	 */
	public void setCreditCardExpiryMonthAndYear(String monthAndYear) {
		reusableActions.getWhenReady(ddlCreditCardExpiryMonthAndYear, 10).click();
		reusableActions.getWhenReady(lblDdlCreditCardExpiryMonthAndYear,10).sendKeys(monthAndYear);
	}
	
	/**
	 * Selects the Credit Card Expiry year
	 * @param year of expir
	 * @author rajesh.varalli1
	 */
	public void setCreditCardExpiryYear(String year) {
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCardExpiryYear, year);
	}
	
	/**
	 * Set dynamic license number based on the Province on Credit check page
	 * @param province of address
	 * @author rajesh.varalli1
	 */
	public void setDrivingLicenseNumber(String province) {
		String strLicenseNumber = FormFiller.generateLicenseNumber(province);
		reusableActions.getWhenReady(txtDlLicenseNumber, 10).click();
		reusableActions.getWhenReady(lblTxtDlLicenseNumber, 10).sendKeys(strLicenseNumber);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue);
	}
	
	/**
	 * Waits until the Credit Check processing is complete
	 * @author rajesh.varalli1
	 */
	public void waitForCreditCheckProcessing() {
		if(reusableActions.isElementVisible(lblCreditCheckProcessing,30)) {
			reusableActions.waitForElementVisibility(lblCreditCheckProcessing, 60);
		}
	}
	
	/**
	 * Clicks on the accept button of Security Deposit Consent if appears
	 * @author rajesh.varalli1
	 */
	public void clkBtnSecurityDepositConsentAccept() {
		if(reusableActions.isElementVisible(buttonSecurityDepositConsentAccept, 60)) {
			reusableActions.clickWhenReady(buttonSecurityDepositConsentAccept , 10);
		}
	}

}