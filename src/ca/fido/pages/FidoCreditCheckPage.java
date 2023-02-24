package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//select[contains(@formcontrolname,'thirdId')]")
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

	@FindBy(xpath = "//input[@name='birthCertificateNumber']")
	WebElement txtBirthCertificate;

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

	@FindAll({
			@FindBy(xpath = "(//div[contains(@class,'button-container')]//button)[2]"),
			@FindBy(xpath = "//div[contains(@class,'button-container')]//button[contains(.,'No,')]")
	})
	WebElement btnClkNoThanks;

	@FindAll({
			@FindBy(xpath = "//dsa-order-table//*[contains(text(),'Down payment')]/parent::div/following-sibling::div/span"),
			@FindBy(xpath = "//ds-modal//p[@data-test='modal-credit-evaluation-downpayment']"),
			@FindBy(xpath = "//ds-modal//*[@data-test='modal-credit-evaluation-section']//*[contains(@class,'text-right')]/p[2]")
	})
	WebElement downPaymentAmt;

	@FindBy(xpath = "//button[@title='Accept' or contains(@title,'accepte')]")
	WebElement acceptButton;

	/**
	 * Set dynamic date of birth year on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		reusableActions.staticWait(5000);
		reusableActions.waitForElementVisibility(ddlDOBYear, 20);
		String strDOBYear = FormFiller.generateDOBYear();
		reusableActions.selectWhenReady(ddlDOBYear, strDOBYear , 30);
	}

	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateMonth();
		reusableActions.waitForElementVisibility(ddlDOBMonth, 30);
		reusableActions.selectWhenReady(ddlDOBMonth, strDOBMonth);
		//clkNoThanks();
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
	 * @author Saurav.Goyal
	 */
	public void setDrivingLicenseExpiry() {
		String dlExpiryDate = "12/23/2023";
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
	 * Set dynamic expire year for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryYear(String strYYYY) {
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

	public void selectDrivingLicenseExpiryMonthSingleDigit(String strDOBMonth) {
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
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryDay(String expiryDay) {
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
	 * Set dynamic BirthCertificate number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setBirthCertificate(String strBirthCertificateNumber) {
		reusableActions.waitForElementVisibility(txtBirthCertificate, 20);
		reusableActions.getWhenReady(txtBirthCertificate, 10).clear();
		reusableActions.getWhenReady(txtBirthCertificate, 30).sendKeys(strBirthCertificateNumber);
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

	/**
	 * This method clicks on No Thanks button in survey modal if available
	 * @author praveen.kumar7
	 */
	public void clkNoThanks() {
		if((reusableActions.isElementVisible(btnClkNoThanks,5)) ||
				(reusableActions.isElementVisible(By.xpath("//div[contains(@class,'button-container')]//button[contains(.,'No,')]"),5))) {
			reusableActions.executeJavaScriptClick(btnClkNoThanks);
		}
	}

	/**
	 * This method calculates expected mandatory down payment amount(deviceCost-upfrontEdgeAmt) based on Risk
	 * @param financeProgramCredit finance program credit for the device
	 * @param deviceCost full price of the device
	 * @param riskClass HIGH/MEDIUM risk
	 * @author Vedachalam.Vasudevan
	 */
	public String setDownPaymentUpfrontEdge(String riskClass, String deviceCost,String financeProgramCredit) {
		double mandatoryDownPayment = (Double.parseDouble(deviceCost)) - (Double.parseDouble(financeProgramCredit) * 24);
		if (riskClass.toUpperCase().contains("HIGH")) {
			double expectedDownPayment = (mandatoryDownPayment / 100.0) * 40.0;
			//return String.valueOf(expectedDownPayment);
			return modifyMandatoryDownPayment(expectedDownPayment);
		} else if (riskClass.toUpperCase().contains("MEDIUM")) {
			double expectedDownPayment = (mandatoryDownPayment / 100.0) * 20.0;
			//return String.valueOf(expectedDownPayment);
			return modifyMandatoryDownPayment(expectedDownPayment);
		} else return "0";
	}

	/**
	 * Method substring decimal value of down Payment to two digit
	 * @param downPay
	 * @return Expected down payment
	 * @author Vedachalam.Vasudevan
	 */
	public String modifyMandatoryDownPayment(Double downPay) {
		String downPayment = String.valueOf(downPay);
		int decimal=0;
		String[] modify = downPayment.split("\\.");
		if(modify[1].length() >= 3) {
			char secondDecimal = modify[1].charAt(1);
			char thirdDecimal = modify[1].charAt(2);
			if (Integer.parseInt(String.valueOf(thirdDecimal)) >= 5) {
				decimal = Integer.parseInt(String.valueOf(secondDecimal)) + 1;
			} else {
				decimal = Integer.parseInt(String.valueOf(secondDecimal));
			}
			downPayment = modify[0] + "." + modify[1].substring(0, 1) + decimal;
		}
		return downPayment;
	}

	/**
	 * This method verifies if mandatory downpayment amount is displayed properly
	 * @param expectedDownPayment min DownPayment for the device
	 * @return true if deposit is displayed correctly, else false
	 * @author Vedachalam.Vasudevan
	 */
	public boolean verifyDownPaymentAmt(String expectedDownPayment) {
		reusableActions.scrollToElement(downPaymentAmt);
		String actualDownPayment = reusableActions.getWhenReady(downPaymentAmt, 20).getText().trim().replace("$", "");
		System.out.println(actualDownPayment);
		if (actualDownPayment.contains(expectedDownPayment) || actualDownPayment.replace(",", ".").contains(expectedDownPayment)) {
			reusableActions.scrollToElement(downPaymentAmt);
			System.out.println(actualDownPayment);
			return true;
		}
		return false;
	}

	/**
	 * This method clicks on the Accpet button in security deposit modal
	 * @author Vedachalam.Vasudevan
	 */
	public void clkAcceptButton() {
		if(reusableActions.isElementVisible(acceptButton, 20)) {
			reusableActions.getWhenReady(acceptButton, 20).click();
		}
	}

}