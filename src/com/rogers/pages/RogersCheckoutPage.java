package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class RogersCheckoutPage extends BasePageClass {
	public RogersCheckoutPage(WebDriver driver){super(driver);}

	@FindBy(xpath = "//h1[@id='bfa-page-title']")
	WebElement checkoutTitle;

	//***Cart summary*****

    @FindBy(xpath="(//div[contains(@class,'totalRow d-flex align-items-center')])[1]")
    WebElement monthlyFeeAfterTax;

    @FindBy(xpath="(//div[contains(@class,'dsa-orderTable__totalRow d-flex align-items-center')])[2]")
    WebElement oneTimeFeeAfterTax;

    @FindBy(xpath="//div[contains(@class,'dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty')]")
    WebElement purchaseIncludes;

    @FindBy(xpath="//span[contains(@class,'px-24 ds-borders ds-bgcolor-white ds-label px-8 mw-100 ng-star-inserted')]")
	WebElement labelRpotg;

    //****Create Profile stepper*****

	@FindBy(xpath = "//h2[@data-test='personal-info-title']")
	WebElement createProfileTitle;

	@FindBy(xpath = "(//div[contains(.,'E-mail Address')])[11]")
	WebElement emailCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement inputEmail;

	@FindBy(xpath = "(//div[contains(.,'Confirm E-mail Address')])[11]")
	WebElement confirmEmailCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='confirmEmail']")
	WebElement inputConfirmEmail;

	@FindBy(xpath = "(//div[contains(.,'First Name')])[11]")
	WebElement firstNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement inputFirstName;

	@FindBy(xpath = "(//div[contains(.,'Last Name')])[11]")
	WebElement lastNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement inputLastName;

	@FindBy(xpath = "(//div[contains(.,'Contact Number')])[11]")
	WebElement contactNumberCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='contact']")
	WebElement inputContactNumber;

	@FindBy(xpath = "(//div[contains(.,'Billing Address')])[13]")
	WebElement billingAddressCreateProfile;

	@FindBy(xpath = "(//div[contains(.,'Billing Address')])[13]/input")
	WebElement inputBillingAddress;

	@FindBy(xpath = "//div[contains(@class,'auto-suggest-list ng-star-inserted')]")
	WebElement billingAddressSelection;

	@FindBy(xpath = "//span[contains(@class,'text-semi text-italic')]")
	WebElement successMessageRpotg;

	@FindBy(xpath = "//div[@class='ds-radioLabel__container ml-8 text-body my-12'][contains(.,'Use billing address')]")
	WebElement useBillingAddressRadioBtnCreateProfile;

	@FindBy(xpath = "//label[@for='ds-radio-input-id-3']")
	WebElement languageEnglishRadioBtnCreateProfile;

	@FindBy(xpath = "//ngx-recaptcha2[@data-test='recaptcha']//iframe[@role='presentation']")
	WebElement fraGoolgeRecaptcha;
	
	@FindBy(xpath = "//button[@data-test='personal-info-continue']")
	WebElement btnGotoCreditEvalStepper;

	//***Create Profile stepper****

	@FindBy(xpath = "//*[@data-test='credit-eval-title']")
	WebElement creditEvaluationTitle;

	@FindBy(xpath="//*[@id='step-2-open']/form//p[contains(text(),'Date of Birth')]")
	WebElement dateOfBirthLabel;

	@FindBy(xpath="//*[@id='step-2-open']/form/div[1]/ds-form-field/div[1]/div[1]")
	//@FindBy(xpath="//ds-form-field[@data-test='credit-eval-dob']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-bgcolor-errorField ds-brcolor-error']")
	WebElement txtDOB;

	//@FindBy(xpath= "//*[@id='step-2-open']/form/div[1]/ds-form-field/div[1]/div[1]/input[@format='DD/MM/YYYY']")
	@FindBy(xpath= "//ds-form-field[@data-test='credit-eval-dob']//input[@formcontrolname='dateOfBirth']")
	WebElement inputTxtDOB;

	@FindBy(xpath= "//select[@data-test='dob-select-year']")
	WebElement inputYearDOB;
	
	@FindBy(xpath= "//*[@data-test='dob-select-month']")
	WebElement inputMonthDOB;
	
	@FindBy(xpath= "//*[@data-test='dob-select-day']")
	WebElement inputDayDOB;
	
	@FindBy(xpath="//*[@id='step-2-open']/form//p[contains(text(),'Credit Card')]")
	WebElement creditCardTitle;

	@FindBy(xpath="//*[@class='ds-inputLabel d-block ds-no-overflow']/span[contains(text(),'Card Number')]")
	WebElement cardNumberLabel;

	@FindBy(xpath = "//*[@class='ds-formField__wrapper']//iframe")
	WebElement fraSemaphone;

	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;

	@FindBy(xpath = "//*[@class='d-flex']//input/..")
	WebElement txtExpiryDate;

	@FindBy(xpath = "//*[@class='d-flex']//input")
	WebElement inputExpiryDate;

	@FindBy(xpath = "//*[@id='step-2-open']/form//p[contains(text(),'ID')]")
	WebElement idLabel;

	@FindBy(xpath = "//option[@value='PASSPORT']/..")
	WebElement dropdownidclick;

	@FindBy(xpath = "//input[@formcontrolname='passport']/..")
	WebElement txtPasportNumber;

	@FindBy(xpath = "//input[@formcontrolname='passport']")
	WebElement inputPasportNumber;

	@FindBy(xpath = "//div[@class='ds-checkbox__box my-12']")
	WebElement chkCreditAuthorization;

	@FindBy(xpath = "//button[@data-test='credit-eval-continue']")
	WebElement btnCreditEvalContinue;

	@FindBy(xpath = "//ds-modal-container")
	WebElement popCreditEval;

	@FindBy(xpath = "//ds-modal-container//p[contains(text(),'Credit Evaluation')]")
	WebElement txtCreditEval;

	@FindBy(xpath = "//*[@id='ds-stepper-id-2-completedContent-1']//div[@class='w-100']/p")
	WebElement identificationLabel;
	
	@FindBy(xpath = "//span[@id='recaptcha-anchor']")
	WebElement radioCheckboxCreateProfile;

	@FindBy(xpath = "//div[@id='step-3-open']/h2")
	WebElement chooseNumberTitle;

	@FindBy(xpath = "//button[@id='ds-tabs-2-tab-0']")
	WebElement selectaNewNumberTab;

	@FindBy(xpath = "//button[@id='ds-tabs-2-tab-1']")
	WebElement useAnExistingNumberTab;

	//@FindBy(xpath = "//select[@id='ds-form-input-id-13']")
	@FindBy(xpath = "//ds-form-field[@data-test='choose-number-city']//select")
	WebElement cityDropdown;

	@FindBy(xpath = "//label[@for='ds-radio-input-id-13']//div[@class='ds-radioButton__outerCircle my-12']")
	WebElement rdoChosePhoneNumber;

	@FindBy(xpath = "//div[@class='my-16']/button")
	WebElement btnFindMoreAvlNumber;


	@FindBy(xpath = "//button[@data-test='choose-number-continue']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']")
	WebElement btnChooseNumberContinue;

	@FindBy(xpath = "//*[@id='ds-stepper-id-2-completedContent-2']//div[@class='w-100']/p[@class='text-body']")
	WebElement lblChooseaNumber;

	//***Billing & Payment Options stepper

	@FindBy(xpath = "//h2[contains(@data-test,'payment-method-title')]")
	WebElement billingOptionsTitle;

	@FindBy(xpath = "//select[@formcontrolname='method']")
	WebElement drpSelectPaymentMethod;

	@FindBy(xpath = "//input[@formcontrolname='name']/..")
	WebElement txtNameOnCard;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	WebElement inputNameOnCard;

	@FindBy(xpath = "//input[@formcontrolname='expiryDate']/..")
	WebElement txtBillingExpiryDate;

	@FindBy(xpath = "//input[@formcontrolname='expiryDate']")
	WebElement inputBillingExpiryDate;

	@FindBy(xpath = "//input[@formcontrolname='cvv']/..")
	WebElement txtCVVNumber;

	@FindBy(xpath = "//input[@formcontrolname='cvv']")
	WebElement inputCVVNumber;

	@FindBy(xpath = "//button[@data-test='add-card-btn']")
	WebElement btnAddCard;

	@FindBy(xpath = "//p[@class='text-body text-bold mb-8']")
	WebElement txtCreditDetails;

	@FindBy(xpath = "//button[@data-test='payment-method-continue']")
	WebElement btnBillingContinueButton;

	//*****Shipping stepper******

	@FindBy(xpath="//ds-radio-button[@data-test='from-value-same-shipping']/label")
	WebElement billingAddressShipping;
	
	@FindBy(xpath="//ds-radio-button[@data-test='from-value-same-shipping']/parent::div//p")
	WebElement prepopulatedShippingAddress;
	
	@FindBy(xpath="//div[@data-test='delivery-information']//p[@class='text-body']/button/..")
	WebElement contactNumberDetails;
	
	@FindBy(xpath="//span[@data-test='email-address']")
	WebElement prepopulatedEmailId;

	@FindBy(xpath="//p[text()='Delivery Method']")
	WebElement deliveryMethodHeader;
	
	@FindBy(xpath ="//ds-radio-button[@data-test='standard-delivery']/label")
	WebElement deliveryMethodStandard;

	@FindBy(xpath="//span[@data-test='email-address']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//td[last()-1]/button[@class='w-100 h-100 p-6 p-sm-16']")
	WebElement selDate;

	@FindBy(xpath = "//div[last()][@class='mb-16 w-50 ng-star-inserted']//following::span[@class='ds-selection__label ds-no-overflow text-body mb-0 w-100 py-12 px-16 px-md-24']")
	WebElement selTime;

	@FindBy(xpath = "//button[@data-test='shipping-continue']")
	WebElement continueBtnShipping;
	
	@FindBy(xpath ="//p[@class='text-body-sm my-8'][1]")
	WebElement appointmentDate;
	
	@FindBy(xpath ="//p[@class='text-body-sm my-8'][2]")
	WebElement appointmentTime;

	@FindBy(xpath = "//button[contains(@id,'main-continue-button')]")
	WebElement submitBtnCheckoutPage;

	@FindBy(xpath = "//p[@class='text-body mb-8']")
	WebElement txtBillingDetails;

	@FindBy(xpath = "//ds-accordion-panel[@data-test='shipping-delivery-options']//button")
	WebElement viewAnotherOption;
	
	@FindBy(xpath = "//div[@class='QSIPopOver SI_5Asif8K9VkSJZM9_PopOverContainer'][1]//span[text()='No, thanks']")
	WebElement btnNoThanks;
	
	
	
	/**
	 * To get the Title of post checkout page
	 * @return checkoutTitle
	 * @author nimmy.george
	 */

	public WebElement getCheckoutTitle()
	{
		reusableActions.getWhenReady(checkoutTitle);
		return checkoutTitle;
	}

	/**
	 * This method will get the total monthly fees amount after tax from the cart summary
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

	public String getMonthlyFeeAfterTax() { 
		reusableActions.waitForElementVisibility(createProfileTitle, 50);
		reusableActions.javascriptScrollByVisibleElement(monthlyFeeAfterTax);
		return monthlyFeeAfterTax.getText().replaceAll("\\n",""); }

	/**
	 * This method will get the total one time fees amount after tax from the cart summary
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

	public String getOneTimeFeeAfterTax() { return oneTimeFeeAfterTax.getText().replaceAll("\\n",""); }

	/**
	 * This method will get the purchase includes section displayed below the cart summary
	 * @return String : Return the purchase includes text displayed below the cart summary
	 * @author nimmy.george
	 */

	public String getPurchaseIncludesText(){ return reusableActions.getWhenReady(purchaseIncludes,10).getText().trim().replaceAll("\\n", " "); }

	/**
	 * This method will get the RPOTG label from the purchase includes section displayed below the cart summary
	 * @return String : Return the RPOTG label from the the cart summary
	 * @author nimmy.george
	 */

	public String getRpotgLabelPurchaseIncludes(){ return reusableActions.getWhenReady(labelRpotg,10).getText().trim(); }


	/**
	 * To Verify Title of Create Profile stepper
	 * @return boolean value
	 * @author nimmy.george
	 */
	public boolean  verifyCreateProfileTitle() { 
		reusableActions.javascriptScrollToTopOfPage();
		if(reusableActions.getWhenReady(createProfileTitle,30)!= null)
			return true;
				else
					return false;
					}
	

	/**
	 * Enter the email on the Create Profile stepper, email address field
	 * @return the generated email address
	 * @author nimmy.george
	 */

	public String setEmailCreateProfile() {
		reusableActions.clickWhenReady(emailCreateProfile);
		reusableActions.getWhenReady(inputEmail,40).sendKeys(FormFiller.generateEmail());
		return reusableActions.getWhenReady(inputEmail,40).getAttribute("value");
	}

	/**
	 * Enter the email on the Create Profile stepper, confirm email address field
	 * @param confirmEmail email address to create a profile
	 * @author nimmy.george
	 */

	public void confirmEmailCreateProfile(String confirmEmail) {
		reusableActions.clickWhenReady(confirmEmailCreateProfile);
		reusableActions.getWhenReady(inputConfirmEmail, 3).sendKeys(confirmEmail);
	}

	/**
	 * Enter the firstName on the Create Profile stepper, First Name field
	 *@return FirstName
	 * @author nimmy.george
	 */

	public String setFirstNameCreateProfile() {

		reusableActions.clickWhenReady(firstNameCreateProfile);
		reusableActions.getWhenReady(inputFirstName,3).sendKeys(FormFiller.generateRandomName());
		return reusableActions.getWhenReady(inputFirstName,20).getAttribute("value");
	}
	
	/**
	 * Enter the firstName on the Create Profile stepper, First Name field [AVS DATA]
	 * @return FirstName Value
	 * @param firstName xpath
	 * @author karthic.hasan
	 */

	public String setFirstNameCreateProfilepage(String firstName) {
		reusableActions.clickWhenReady(firstNameCreateProfile);
		reusableActions.getWhenReady(inputFirstName,3).sendKeys(firstName);
		return reusableActions.getWhenReady(inputFirstName,20).getAttribute("value");
	}

	/**
	 * Enter the lastName on the Create Profile stepper, Last Name field [AVS DATA]
	 * @return LastName
	 * @param lastName xpath
	 * @author karthic.hasan
	 */

	public String setLastNameCreateProfilepage(String lastName) {
		reusableActions.clickWhenReady(lastNameCreateProfile);
		reusableActions.getWhenReady(inputLastName,3).sendKeys(lastName);
		return reusableActions.getWhenReady(inputLastName,20).getAttribute("value");
	}

	
	public void clkNoThanks()
	{
		reusableActions.clickIfAvailable(btnNoThanks,10);
	}
	/**
	 * Enter the lastName on the Create Profile stepper, Last Name field
	 * @return LastName
	 * @author nimmy.george
	 */

	public String setLastNameCreateProfile() {
		reusableActions.clickWhenReady(lastNameCreateProfile);
		reusableActions.getWhenReady(inputLastName,3).sendKeys(FormFiller.generateRandomName());
		return reusableActions.getWhenReady(inputLastName,20).getAttribute("value");
	}

	/**
	 * Enter the contact number on the Create Profile stepper, Contact number field
	 * @return contactNumber Contact number to create a profile
	 * @param contactNumber from yml file
	 * @author nimmy.george
	 */

	public String setContactNumberCreateProfile(String contactNumber) {
		reusableActions.clickWhenReady(contactNumberCreateProfile);
		reusableActions.getWhenReady(inputContactNumber,3).sendKeys(contactNumber);
		return reusableActions.getWhenReady(inputContactNumber,20).getAttribute("value").trim();
	}

	/**
	 * Enter the Billing Address on the Create Profile stepper, Billing Address field and select it from the dropdown
	 * @return billingAddress Billing Address to create a profile
	 * @param billingAddress from yaml file
	 * @author nimmy.george
	 */

	public String setBillingAddressCreateProfile(String billingAddress) {
		reusableActions.clickWhenReady(billingAddressCreateProfile);
		reusableActions.getWhenReady(inputBillingAddress,3).sendKeys(billingAddress);
		billingAddressSelection.click();
		return reusableActions.getWhenReady(inputBillingAddress,20).getAttribute("value");
	}

	/**
	 * To get the RPOTG success message for the eligible billing address
	 *
	 * @author nimmy.george
	 */

	public void getRpotgSuccessMessage() {
		reusableActions.getWhenReady(successMessageRpotg);
	}

	/**
	 * To click on the Use billing address radio button in the Create Profile stepper
	 * @author nimmy.george
	 */

	public void clkUseBillingAddressRadioBtnCreateProfile() {
		reusableActions.clickWhenReady(useBillingAddressRadioBtnCreateProfile,3);
	}

	/**
	 * To click on the Language English radio button in the Create Profile stepper
	 * @author nimmy.george
	 */

	public void clkLanguageEnglishRadioBtnCreateProfile() {
		reusableActions.clickWhenReady(languageEnglishRadioBtnCreateProfile,3);
	}

	/**
	 * Switch to Credit Card Iframe in Create Profile  stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchToRecaptchaIFrame() { 
		driver.switchTo().frame(reusableActions.getWhenVisible(fraGoolgeRecaptcha));
		System.out.println("Switched to iframe");
		}

	/**
	 * To click on the I'm not robot in the Create Profile stepper.
	 * @author nimmy.george
	 */

	public void clkImNotRombotCheckbox() {
		reusableActions.waitForPageLoad();
		reusableActions.moveToElementAndClick(radioCheckboxCreateProfile,10);
	}

	/**
	 * Switch out of Google Iframe in Create profile stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchOutOfGoogleIFrame() { driver.switchTo().defaultContent(); }
	
	/**
	 * To click "Continue" button in Create profile stepper, that takes you to Credit Evaluation stepper
	 * @author nimmy.george
	 */
	public void clkBtnGotoCreditEvalStepper() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-test='personal-info-continue']")));
		reusableActions.clickWhenReady(btnGotoCreditEvalStepper, 40);
	}

	/**
	 * To Verify the Title of Credit Evaluation stepper 
	 * @return True or false
	 * author Karthic.Hasan
	 */

	public boolean verifyCreditEvaluationTitle() {
		//reusableActions.getWhenReady(creditEvaluationTitle);
		if(reusableActions.isElementVisible(creditEvaluationTitle,30))
		{
		reusableActions.javascriptScrollByVisibleElement(creditEvaluationTitle);
		   return true;
		}
		else 
	        return false;
	}

//	/**
//	 * To select DOB dropdown from Credit Evaluation stepper 
//	 * @param strDOB from yaml file
//	 * author Karthic.Hasan
//	 */
//
//	public void setDateOfBirth(String strDOB) {
//		reusableActions.getWhenReady(txtDOB).click();
//		reusableActions.getWhenVisible(inputTxtDOB).sendKeys(strDOB);
//	}

	
	/**
	 * Switch to Credit Card Iframe in Credit Evaluation stepper
	 * @author Karthic.hasan
	 */

	public void switchToCreditCardIFrame() { driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone)); }

	/**
	 * Enter the Credit Card Number on the Credit Evaluation stepper, Credit Card Field
	 *@param strAccountNumber xpath
	 * @author karthic.hasan
	 */

	public void setCreditCardNumberIFrame(String strAccountNumber) {
		reusableActions.getWhenReady(txtCardNumber, 90);
		reusableActions.getWhenReady(txtCardNumber, 30).sendKeys(strAccountNumber);
	}


	/**
	 * Switch out of Credit Card Iframe in Credit Evaluation stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchOutOfCreditCardIFrame() { driver.switchTo().defaultContent(); }

	/**
	 * Enter the Expiry Date on the Credit Evaluation stepper, Expiry Date Field
	 * @param strExpiryDate xpath
	 * @author karthic.hasan
	 */

	public void setExpiryDate(String strExpiryDate) {
		reusableActions.staticWait(4000);
		reusableActions.getWhenReady(txtExpiryDate).click();
		reusableActions.getWhenReady(inputExpiryDate, 10).sendKeys(strExpiryDate);
	}
	/**
	 * Select DOB-Year Dropdown Option on the Credit Evaluation stepper.
	 * @param strYear from Yaml file 
	 * @author karthic.hasan
	 */

	public void selectYearDropdownOption(String strYear) {
		
		reusableActions.waitForElementVisibility(inputYearDOB, 20);
		reusableActions.clickWhenReady(inputYearDOB);
		reusableActions.selectWhenReady(inputYearDOB, strYear);

	}
	/**
	 * Select DOB-Month Dropdown Option on the Credit Evaluation stepper.
	 * @param strMonth from Yaml file
	 * @author karthic.hasan
	 */

	public void selectMonthDropdownOption(String strMonth) {
		try
		{
			reusableActions.waitForElementVisibility(inputMonthDOB, 20);
			reusableActions.clickWhenReady(inputMonthDOB);
			reusableActions.selectWhenReady(inputMonthDOB, strMonth);
		}catch (Exception e) {
			clkNoThanks();
			reusableActions.waitForElementVisibility(inputMonthDOB, 20);
			reusableActions.clickWhenReady(inputMonthDOB);
			reusableActions.selectWhenReady(inputMonthDOB, strMonth);
		
		}
			
	}
	/**
	 * Select DOB-Date Dropdown Option on the Credit Evaluation stepper.
	 * @param strDay from yaml file
	 * @author karthic.hasan
	 */

	public void selectDayDropdownOption(String strDay) {
		try
		{
			reusableActions.waitForElementVisibility(inputDayDOB, 20);
			reusableActions.clickWhenReady(inputDayDOB);
			reusableActions.selectWhenReady(inputDayDOB, strDay);
		
		}
		catch (Exception e) {
		
			clkNoThanks();
			reusableActions.waitForElementVisibility(inputDayDOB, 20);
			reusableActions.clickWhenReady(inputDayDOB);
			reusableActions.selectWhenReady(inputDayDOB, strDay);
		}
	}

	/**
	 * Select Dropdown Option on the Credit Evaluation stepper, Id Dropdown Field
	 * @param selectYourIdOption value from yaml file
	 * @author karthic.hasan
	 */

	public void selectDropdownOption(String selectYourIdOption) {
		reusableActions.waitForElementVisibility(dropdownidclick, 20);
		reusableActions.clickWhenReady(dropdownidclick);
		reusableActions.selectWhenReady(dropdownidclick, selectYourIdOption);
	}

	/**
	 * Enter the Passport Number on the Credit Evaluation Stepper , Passport NumberField
	 * @param strPasportNumber from Yaml file
	 * @author karthic.hasan
	 */

	public void setPassportNumber(String strPasportNumber) {
		// reusableActions.javascriptScrollByVisibleElement(txtPasportNumber);
		reusableActions.clickWhenReady(txtPasportNumber);
		reusableActions.getWhenReady(inputPasportNumber, 3).sendKeys(strPasportNumber);
	}

	/**
	 * To click on the Authorization Checkbox in the Create Profile stepper
	 * @author karthic.hasan
	 */

	public void clkCreditAuthorizationChkBox() 
	{
		reusableActions.getWhenReady(chkCreditAuthorization).click(); 
		}

	/**
	 * To click on the Credit Evaluation Continue button in the Credit Evaluation stepper
	 * @author karthic.hasan
	 */

	public void clkCreditEvalContinue() { reusableActions.getWhenReady(btnCreditEvalContinue).click(); }

	/**
	 * To verify Credit Evaluation popup is present in the Credit Evaluation stepper
	 * @return True or False
	 * @author karthic.hasan
	 */
	public boolean isCreditEvalPopupPresent() { return reusableActions.isElementVisible(popCreditEval); }

	/**
	 * To verify Credit Evaluation text is present in the Credit Evaluation Model and return Boolean value.
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isCreditEvalTextOnModalPresent() { return reusableActions.isElementVisible(txtCreditEval); }

	/**
	 * WaitUntill Credit Evaluation text get invisible from the Credit Evaluation Model
	 * @author karthic.hasan
	 */

	public void waitUntilCreditEvalPopupClose() { reusableActions.waitForElementVisibility(identificationLabel); }

	/**
	 * To verify Credit Evaluation Identification Label is present in the Credit Evaluation stepper
	 * @author karthic.hasan
	 */
	public boolean isIdentificationLabel() {
		reusableActions.waitForElementVisibility(identificationLabel, 50);
		reusableActions.javascriptScrollByVisibleElement(identificationLabel);
		return reusableActions.isElementVisible(identificationLabel);
	}

	/**
	 * To verify Choose A Number Title in the Choose a Number stepper
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isChooseaNumberTitleDisplayed() { return reusableActions.isElementVisible(chooseNumberTitle); }

	/**
	 * To verify Select A Number Tab UseAnExistingNumber Tab is present in the Choose a Number stepper and return boolean value.
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isChooseNumberTabsDisplayed() {
		return (reusableActions.isElementVisible(selectaNewNumberTab) && reusableActions.isElementVisible(useAnExistingNumberTab));
	}

	/**
	 * Select City Dropdown Option on the Choose a Number stepper, City Dropdown Field
	 * @param selectYourOption value from yaml file.
	 * @author karthic.hasan
	 */

	public void selectCityDropdownOption(String selectYourOption) {
		reusableActions.waitForElementVisibility(cityDropdown, 20);
		reusableActions.clickWhenReady(cityDropdown);
		reusableActions.selectWhenReadyByVisibleText(cityDropdown, selectYourOption);
	}

	/**
	 * To click on the first Available Phone number Radio button in the Choose a Number stepper
	 * @author karthic.hasan
	 */

	public void clkChosePhoneNumber() {
		reusableActions.getWhenReady(rdoChosePhoneNumber, 60).click();
	}

	/**
	 * To verify Find More Avaialble Number Button in the Choose a Number stepper
	 * @return True or false
	 * @author karthic.hasan
	 */

	public boolean isFindMoreAvlNumberButtonPresent() {
		return reusableActions.isElementVisible(btnFindMoreAvlNumber);
	}

	/**
	 * To click on the Choose Number button in the Credit Evaluation stepper
	 * @author karthic.hasan
	 */

	public void clkChooseNumberbutton() {
		reusableActions.javascriptScrollByVisibleElement(cityDropdown);
		reusableActions.getWhenReady(btnChooseNumberContinue, 60).click();
	}

	/**
	 * To verify Choose A Number Label in the Choose a Number stepper 
	 * @return boolean value
	 * @author karthic.hasan
	 */

	public boolean isChooseaNumberLabelDisplayed() {
		reusableActions.javascriptScrollByVisibleElement(lblChooseaNumber);
		return reusableActions.isElementVisible(lblChooseaNumber);
	}

	/**
	 * To Verify the Title of Billing Options stepper Displayed 
	 * @return True or False Boolean Value.
	 * @author nimmy.george
	 */

	public boolean isBillingOptionsTitleDisplayed() {
		reusableActions.getWhenReady(billingOptionsTitle);
		return reusableActions.isElementVisible(billingOptionsTitle);
	}

	/**
	 * To verify Payment Method Dropdown is Present in the Billing Payment option stepper
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isPaymentMethodDropdownPresent() {
		return reusableActions.isElementVisible(drpSelectPaymentMethod);
	}

	/**
	 * To Select Payment Method from Billing Payment option stepper
	 * @param strPaymentMethod from yaml file.
	 * @author karthic.hasan
	 */	
	public void selectPaymentMethodDropdownOption(String strPaymentMethod) {

		reusableActions.scrollToElementAndClick(drpSelectPaymentMethod);
		reusableActions.selectWhenReady(drpSelectPaymentMethod, strPaymentMethod);

	}

	/**
	 * Enter Name on Card in the Billing Payment Option Stepper , Name on Card Field
	 * @param strNameOnCard from yaml file.
	 * @author karthic.hasan
	 */

	public void setNameOnCard(String strNameOnCard) {
		reusableActions.staticWait(2000);
		reusableActions.getWhenReady(txtNameOnCard).click();
		reusableActions.getWhenVisible(inputNameOnCard).sendKeys(strNameOnCard);
	}

	/**
	 * Enter Billing Expiry Date in the Billing Payment Option Stepper , Expir Date Field
	 *@param strBillingExpiryDate from Yaml file
	 * @author karthic.hasan
	 */
	public void setBillingExpiryDate(String strBillingExpiryDate) {
		reusableActions.getWhenReady(txtBillingExpiryDate).click();
		reusableActions.staticWait(1000);
		reusableActions.getWhenReady(inputBillingExpiryDate, 10).sendKeys(strBillingExpiryDate);
	}

	/**
	 * Enter CVVNumber in the Billing Payment Option Stepper , CVV Number Field
	 * @param strCVVNumber from yaml file.
	 * @author karthic.hasan
	 */

	public void setCVVNumber(String strCVVNumber) {
		reusableActions.getWhenReady(txtCVVNumber).click();
		reusableActions.staticWait(1000);
		reusableActions.getWhenReady(inputCVVNumber, 10).sendKeys(strCVVNumber);
	}

	/**
	 * To click Add Card button in the Billing Payment Option stepper
	 * @author karthic.hasan
	 */

	public void clkAddCard() {
		reusableActions.getWhenReady(btnAddCard).click();
	}

	/**
	 * To verify Card Details displayed in the Billing Payment option stepper
	 *@return True or False
	 * @author karthic.hasan
	 */

	public boolean isCardDetailsDisplayed() {
		return reusableActions.isElementVisible(txtCreditDetails,30);
	}

	/**
	 * To click Billing Payment Continue Button from the Billing Payment Option stepper
	 * @author karthic.hasan
	 */

	public void clkBillingContinueButton() {
		reusableActions.getWhenReady(btnBillingContinueButton).click();
	}

	/**
	 * To click on the Billing Address radio button in the Shipping stepper
	 * @return true if selected, else false.
	 * @author nimmy.george
	 */

	public boolean clkBillingAddress() {
		reusableActions.scrollToElementAndClick(billingAddressShipping);
		//reusableActions.clickWhenReady(billingAddressShipping,3);
		billingAddressShipping.isSelected();
		return true;
	}

	
	/**
     * to get the Complete Address from the Shipping Stepper
     * @return The Complete Address
     ** @author karthic.hasan
     */
    public String getShippingAddress() {
    	reusableActions.javascriptScrollToTopOfPage();
        return reusableActions.getWhenReady(prepopulatedShippingAddress).getText();
    }
    
    /**
	 * This method will get Complete Contact Number details from Shipping Stepper
	 * @return Complete Contact Number from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getContactNumber() { 
		reusableActions.javascriptScrollByVisibleElement(contactNumberDetails);
   	    reusableActions.staticWait(3000);
		return contactNumberDetails.getText().replaceAll("\\n",""); 
	}
    
    /**
     * to get the Email ID from the Shipping Stepper
     * @return the Email ID
     * @author karthic.hasan
     */
    public String getEmailId() {
    	reusableActions.javascriptScrollToTopOfPage();
        return reusableActions.getWhenReady(prepopulatedEmailId).getText();
    }  
    
	/**
	 * To click on Standard Delivery Method in the shipping stepper
	 * @author nimmy.george
	 */

	public void clkDeliveryMethodStandard() {
		reusableActions.javascriptScrollByVisibleElement(deliveryMethodHeader);
		if(reusableActions.isElementVisible(viewAnotherOption))
		{
		System.out.println("inside loop");
		reusableActions.scrollToElementAndClick(viewAnotherOption);
		reusableActions.clickWhenReady(deliveryMethodStandard);
		
		}
		else {
			reusableActions.clickWhenReady(deliveryMethodStandard,30);
		}
		
	}

	/**
	 * To Select Date from the Shipping stepper
	 * @author karthic.hasan
	 */

	public void selectDate() {
		//reusableActions.javascriptScrollByVisibleElement(selDate);
		reusableActions.moveToElementAndClick(selDate, 3);
	}

	/**
	 * To Select Time from the Shipping stepper
	 * @author karthic.hasan
	 */

	public void selectTime() {
		reusableActions.moveToElementAndClick(selTime, 3);
	}

	/**
	 * To click continue button in the shipping stepper
	 *
	 * @author nimmy.george
	 */


	public void clkContinueBtnShipping() {
		//wait.until(ExpectedConditions.elementToBeClickable(continueBtnShipping));
        //reusableActions.javascriptScrollByVisibleElement(continueBtnShipping);
		reusableActions.clickWhenVisible(continueBtnShipping, 30);
	}

	
	/**
	 * This method will get Appointment Date from Shipping Stepper
	 * @return String having Appointment Date from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getAppointmentDate() { 
		reusableActions.javascriptScrollByVisibleElement(appointmentDate);
   	    reusableActions.staticWait(3000);
		return appointmentDate.getText().replaceAll("\\n",""); 
	}

	/**
	 * This method will get Appointment Time from Shipping Stepper
	 * @return String having Appointment Time from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getAppointmentTime() { 
		reusableActions.javascriptScrollByVisibleElement(appointmentTime);
   	    reusableActions.staticWait(3000);
		return appointmentTime.getText().replaceAll("\\s",""); 
	}
	
    /**
     * To click on submit button below cart summary in the checkout page, that takes you to Order Review Page
     *
     * @author nimmy.george
     */

    public void clksubmitBtnCheckoutPage(){
        reusableActions.moveToElementAndClick(submitBtnCheckoutPage,20);
    }

	/**
	 * To verify Billing Details in the Billing Payment option stepper
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean verifyBillingDetails() {
		return reusableActions.isElementVisible(txtBillingDetails);
	}


}