package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;
import utils.FormFiller;

public class FidoCreditCheckPage extends BasePageClass {

	public FidoCreditCheckPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//select[@id='creditCheckYear' or @id='dobyear']")
	WebElement ddlDOBYear;

	@FindBy(xpath="//select[@id='creditCheckMonth' or @id='dobmonth']")
	WebElement ddlDOBMonth;

	@FindBy(xpath="//select[@id='creditCheckDay' or @id='dobday']")
	WebElement ddlDOBDay;

	@FindBy(id = "firstIdOption")
	WebElement ddlFirstIdOption;

	@FindBy(xpath = "//select[(@ng-model='driverLicense.dlProvince' or @ng-model='obj.drivingLicenseProvince') and (@name='dlProvince' or @name='province')]")
	WebElement ddlDlProvince;

	@FindBy(xpath="//select[@name='dlExpiryYear' or @name='dlYear']")
	WebElement ddlDlExpiryYear;

	@FindBy(xpath="//select[@name='dlExpiryMonth' or @name='dlMonth']")
	WebElement ddlDlExpiryMonth;

	@FindBy(xpath="//select[@name='dlExpiryDay' or @name='dlExpiryDate']")
	WebElement ddlDlExpiryDay;

	@FindBy(xpath="//input[@id='dlLicenseNumber' or @name='dlCardNumber']")
	WebElement txtDlLicenseNumber;

	@FindBy(name = "secondIdOption1")
	WebElement ddlSecondIdOption;

	@FindBy(xpath = "//input[@id='ppNumber' and @ng-model='passport.ppNumber']")
	WebElement txtPpNumber;

	@FindBy(name = "ppExpiryYear")
	WebElement ddlPasspoartExpiryYear;

	@FindBy(name = "ppExpiryMonth")
	WebElement ddlPasspoartExpiryMonth;

	@FindBy(name = "ppExpiryDay")
	WebElement ddlPasspoartExpiryDay;

	@FindBy(xpath = "//label[@for='credit_check_consent' or @for='creditCheckBox']")
	WebElement lblCreditCheckConsent;
 
	@FindBy(name = "submit")
	WebElement btnCreditCheckSubmit;
	
	@FindBy(xpath="//iframe[@id='sema']")
	WebElement frmCreditCard;
	
	@FindBy(xpath="//input[@id='maskedPan']")
	WebElement txtCreditCardNumberMasked;
	
	@FindBy(xpath="//input[@id='pan']")
	WebElement txtCreditCardNumber;
	
	@FindBy(xpath="//select[@name='month']")
	WebElement ddlCreditCardExpiryMonth;
	
	@FindBy(xpath="//select[@name='year']")
	WebElement ddlCreditCardExpiryYear;
	
	@FindBy(xpath="//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	@FindBy(xpath="//label[@for='consentSecurityDeposit']")
	WebElement lblSecurityDepositConsent;
	
	@FindBy(xpath="//p[@class='msgLoad' and @checkout-res='checkout_creditCheck_is_processing']")
	WebElement lblCreditCheckProcessing;

	/**
	 * Set dynamic date of birth year on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		reusableActions.waitForElementVisibility(ddlDOBYear, 120);
		String strDOBYear = FormFiller.generateDOBYear();
		reusableActions.selectWhenReady(ddlDOBYear, strDOBYear);
	}

	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = "0" + FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlDOBMonth, strDOBMonth.substring(strDOBMonth.length()-2));
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
	 * Selects the Province for the driving license on Credit check page
	 * @param strDlProvince province of the driver's license
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseProvince(String strDlProvince) {
		reusableActions.waitForElementVisibility(ddlDlProvince, 20);
		reusableActions.selectWhenReady(ddlDlProvince, strDlProvince);
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
		reusableActions.waitForElementVisibility(ddlPasspoartExpiryYear, 30);
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
		System.out.println("HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		driver.switchTo().frame(frmCreditCard);
		reusableActions.staticWait(5000);
		txtCreditCardNumberMasked.click();
		txtCreditCardNumber.click();
		txtCreditCardNumber.sendKeys(ccNumber);
		driver.switchTo().defaultContent();//checkout-res="checkout_credit_card_number"
	}
	
	/**
	 * Selects the Credit Card Expiry month
	 * @param month in numbers like 01,02,....,12
	 * @author rajesh.varalli1
	 */
	public void setCreditCardExpiryMonth(String month) {
		reusableActions.selectWhenReady(ddlCreditCardExpiryMonth, month);
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
		reusableActions.getWhenReady(txtDlLicenseNumber, 10).sendKeys(strLicenseNumber);
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
	 * Clicks on the Security Deposit Consent checkbox if appears and then clicks Continue
	 * @author rajesh.varalli1
	 */
	public void setSecurityDepositConsent() {
		if(reusableActions.isElementVisible(lblSecurityDepositConsent, 5)) {
			reusableActions.clickWhenReady(lblSecurityDepositConsent);
			reusableActions.clickWhenReady(btnContinue);
		}
	}

}