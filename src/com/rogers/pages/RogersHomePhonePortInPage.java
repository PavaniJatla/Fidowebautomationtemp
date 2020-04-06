package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersHomePhonePortInPage extends BasePageClass {

	public RogersHomePhonePortInPage(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath = "//div[@class='ds-formField__wrapper']")
	WebElement txtHomePhoneNumberFormFiled;
	
	@FindBy(xpath = "//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtHomePhoneNumberFormcontainer;
	
	
	@FindBy(xpath = "//input[@name='phoneNumber']")
	WebElement txtHomePhoneNumber;
	
	@FindBy(xpath = "//span[@translate='global.common.checkEligibility']")
	WebElement btnPhoneNumberEligibiltyCheck;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large ng-star-inserted']")
	WebElement btnConfirmPhone;
	
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-check-circle ds-color-success']")
	WebElement imgPhoneNumberVerificationSuccess;	
	
	
	@FindBy(xpath ="//div[@class='col-sm-6']//input[contains(@class,'ds-input w-100 text-copy pt-16 ds-bgcolor-transparent cdk-text-field-autofill-monitored')]")
	WebElement txtFirstName;

	@FindBy(xpath ="//div[@class='col-sm-6 mt-16 mt-sm-0']//input[contains(@class,'ds-input w-100 text-copy pt-16 ds-bgcolor-transparent cdk-text-field-autofill-monitored')]")
	WebElement txtLastName;
	
	@FindBy(xpath ="//input[contains(@id,'canada-post-address-complete-')]")
	WebElement txtInvoiceAddress;
	
	@FindBy(xpath ="//div[contains(@class,'current-phone-provider')]//input[contains(@class,'ds-input w-100 text-copy pt-16 ds-bgcolor-transparent cdk-text-field-autofill-monitored')]")
	WebElement txtCurrentPhoneNumber;
	
	
	@FindBy(id = "accountNumber")
	WebElement txtAccountNumberOrIMEI;
	
	@FindBy(xpath = "//button[@class='ute-btn-primary']//ins[@translate='global.common.buttons.continue']")
	WebElement btnConfirmPhoneNumber;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	
	/**
	 * Set Home phone number on the Home phone Port-in page
	 * @param strPhoneNumber phone number for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setHomePhoneNumber(String strPhoneNumber) {
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,120);
		reusableActions.getWhenReady(txtHomePhoneNumberFormFiled, 30).click();
		reusableActions.getWhenReady(txtHomePhoneNumberFormcontainer, 30).click();		
		reusableActions.getWhenReady(txtHomePhoneNumber, 40).clear();
		reusableActions.getWhenReady(txtHomePhoneNumber, 60).sendKeys(strPhoneNumber);
	}
	
	/**
	 * validate the home phone number success image
	 * @return true, if the success image displayed, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean   verifyPhoneNumberSuccess() {
		return reusableActions.isElementVisible(imgPhoneNumberVerificationSuccess, 60);
	}

	
	/**
	 * Click to Home phone number eligibility Check button on the Home phone Port-in page to validate the entered number
	 * @author Chinnarao.Vattam
	 */
	public void clkPhoneNumberEligibiltyCheck() {
		reusableActions.getWhenReady(btnPhoneNumberEligibiltyCheck, 120).click();
	}
	
	/**
	 * Click to Home phone phone confirm button
	 * @author Chinnarao.Vattam
	 */
	public void clkPhoneCheck() {
		reusableActions.getWhenReady(btnConfirmPhone, 120).click();
	}
	
	/**
	 * Set First Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setFirstName() {
		String strName = FormFiller.generateRandomName();
		String strFname="Rogersaa" + strName;
		reusableActions.waitForElementVisibility(imgPhoneNumberVerificationSuccess, 30);
		reusableActions.executeJavaScriptClick(txtFirstName);
		reusableActions.getWhenReady(txtFirstName, 10).sendKeys(strFname);
	}
	
	/**
	 * Set Last Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		String strLname="Automation" + strName;
		reusableActions.executeJavaScriptClick(txtLastName);
		reusableActions.getWhenReady(txtLastName, 3).sendKeys(strLname);
	}
	
	/**
	 * Set Last Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setCurrentPhoneNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();		
		reusableActions.executeJavaScriptClick(txtCurrentPhoneNumber);
		reusableActions.getWhenReady(txtCurrentPhoneNumber, 10).sendKeys(strPhoneNumber);
	}
	
	
	/**
	 * Set Invoice Address on the Home phone Port-in page 
	 * @param strInvoiceAddress for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setInvoiceAddress(String strInvoiceAddress) {
		reusableActions.executeJavaScriptClick(txtInvoiceAddress);
		reusableActions.getWhenReady(txtInvoiceAddress, 3).clear();
		reusableActions.getWhenReady(txtInvoiceAddress, 3).sendKeys(strInvoiceAddress);
		reusableActions.getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtInvoiceAddress).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Set Account Number or IMEI on the Home phone Port-in page
	 * @param strAccountNumberorIMEI Account Number or IMEI   for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setAccountNumberOrIMEI(String strAccountNumberorIMEI) {
		reusableActions.getWhenReady(txtAccountNumberOrIMEI, 3).clear();
		reusableActions.getWhenReady(txtAccountNumberOrIMEI, 3).sendKeys(strAccountNumberorIMEI);
	}
	
	/**
	 * Click to Confirm Phone Number button on the Home phone Port-in page to confirm the home phone details
	 * @author Chinnarao.Vattam
	 */
	public void clkConfirmPhoneNumber() {
		reusableActions.getWhenReady(btnConfirmPhoneNumber, 30).click();
	}
}
