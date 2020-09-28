package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersInternetCreditCheckPage extends BasePageClass {

	public RogersInternetCreditCheckPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-13']")
	WebElement ddlCreditCheckYear;
		
	@FindBy(xpath = "//select[@id='ds-form-input-id-14']")
	WebElement ddlCreditCheckMonth;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-15']")
	WebElement ddlCreditCheckDay;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-16']")
	WebElement ddlFirstID;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-19']")
	WebElement ddlProvince;
		
	@FindBy(xpath = "//select[@id='ds-form-input-id-20']")
	WebElement ddlExpiryYear;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-21']")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//select[@id='ds-form-input-id-22']")
	WebElement ddlExpiryDay;
		
	@FindBy(xpath = "//input[@id='ds-form-input-id-18']")
	WebElement txtLicenseNumber;
	  	
	@FindBy(xpath = "//select[@id='ds-form-input-id-17']")
	WebElement ddlSecondIdOption;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-23']")
	WebElement txtPasportNumber;
		
	@FindBy(xpath = "//select[@id='ds-form-input-id-24']")
	WebElement ddlPassportExpiryYear;
		
	@FindBy(xpath = "//select[@id='ds-form-input-id-25']")
	WebElement ddlPassportExpiryMonth;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-26']")
	WebElement ddlPassportExpiryDay;
		
	@FindBy(xpath = "//label[@for='ds-checkbox-id-0']")
	WebElement chkConsent;
		
	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnCreditCheckSubmit;
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c3-40')]//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainer;
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c3-45')]//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerPasportNumber;
				
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersnew;
	
	/**
	 * To verify the Credit Check Year drop down to verify the Credit Evalution Page
	 * @return true if it the credit check page displays the Credit Check Year drop down, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCreditEvalutionPage() {
		reusableActions.waitForElementVisibility(ddlCreditCheckYear, 180);
		return	reusableActions.isElementVisible(ddlCreditCheckYear);
	}
	
	/**
	 * Set dynamic date of birth year on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		reusableActions.waitForElementVisibility(ddlCreditCheckYear,20);
		String strDOBYear = FormFiller.generateDOBYear();
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCheckYear, strDOBYear);
	}
	
	/**
	 * Set dynamic date of birth year on Credit check page for an existing customer
	 * @param strDOBYear year of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYearExistingCustomer(String strDOBYear) {
		reusableActions.waitForElementVisibility(ddlCreditCheckYear,20);
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCheckYear, strDOBYear);
	}
	
	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateNameOfMonth();
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCheckMonth, strDOBMonth);
	}
	
	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @param strDOBMonth month of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonthExistingCustomer(String strDOBMonth) {
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCheckMonth, strDOBMonth);
	}
	
	/**
	 * Set dynamic date of birth date on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDay() {
		String strDOBDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCheckDay, strDOBDay);
	}
	
	/**
	 * Set dynamic date of birth date on Credit check page
	 * @param strDOBDay date of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDayExistingCustomer(String strDOBDay) {
		reusableActions.selectWhenReady(ddlCreditCheckDay, strDOBDay);
	}
	
	/**
	 * Selects the first identification on Credit check page
	 * @param strFirstID first identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectFirstID(String strFirstID) {
		reusableActions.selectWhenReadyByVisibleText(ddlFirstID, strFirstID);
	}
	
	/**
	 * Selects the Province for the driving license on Credit check page
	 * @param strProvince province for the driver's license 
	 * @author Chinnarao.Vattam
	 */
	public void selectProvince(String strProvince) {
		reusableActions.selectWhenReadyByVisibleText(ddlProvince, strProvince);
	}
	
	/**
	 * Set dynamic expire year for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear,strYYYY);
	}
	
	/**
	 * Select expire year year
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYearwithSpace() {
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='dlExpiryYear']")));
		listbox.selectByIndex(2);
	}
	
	
	/**
	 * Select expire year
	 * @param strYYYY Expire year
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYearYYYY(String strYYYY) {
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}
	
	/**
	 * Set dynamic expire month for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryDay, strDD);
	}
	
	/**
	 * Set dynamic license number for British Columbia  on Credit check page
	 * @param province of address
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumber(String province) {
		String strLicenseNumber = FormFiller.generateLicenseNumber(province);
		reusableActions.waitForElementVisibility(txtContainer,180);
		reusableActions.getWhenReady(txtContainer,10).click();		
		reusableActions.getWhenReady(txtLicenseNumber, 30).clear();
		reusableActions.getWhenReady(txtLicenseNumber, 3).sendKeys(strLicenseNumber);
	}
	
	/**
	 * Selects the second identification on Credit check page
	 * @param strSecondIDOption second identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectSecondIDOption(String strSecondIDOption) {
		reusableActions.waitForElementVisibility(ddlSecondIdOption, 20);
		reusableActions.selectWhenReadyByVisibleText(ddlSecondIdOption, strSecondIDOption);
	}
	 
	/**
	 * Set dynamic passport number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setPassportNumber() {
		String strPasportNumber = FormFiller.generatePassportNumber();
		reusableActions.waitForElementVisibility(txtContainerPasportNumber,180);
		reusableActions.getWhenReady(txtContainerPasportNumber,10).click();
		reusableActions.getWhenReady(txtPasportNumber, 60).clear();
		reusableActions.getWhenReady(txtPasportNumber, 3).sendKeys(strPasportNumber);
	}

	/**
	 * Set dynamic expire year for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReadyByVisibleText(ddlPassportExpiryYear, strYYYY);
	}
	
	/**
	 * Set dynamic expire month for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		reusableActions.selectWhenReadyByVisibleText(ddlPassportExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expire day for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReadyByVisibleText(ddlPassportExpiryDay, strDD);
	}
	
	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsent() {
		reusableActions.getWhenReady(chkConsent, 120).click();
	}

	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentMobile() {
		reusableActions.executeJavaScriptClick(chkConsent);
	}
	
	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmit() {
		reusableActions.executeJavaScriptClick(chkConsent);
	}
	
	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmitMobile() {
		reusableActions.getWhenReady(btnCreditCheckSubmit, 30);
		reusableActions.executeJavaScriptClick(btnCreditCheckSubmit);
	}

}