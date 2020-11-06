package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersOrderReviewPage extends BasePageClass {

	public RogersOrderReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ins[@translate='global.label.reviewHeading']")
	WebElement infoPackagechangeReview;

	@FindBy(xpath = "//ins[@translate='global.label.billingAddress']")
	WebElement infoPackagechangeBillingAddress;

	@FindBy(xpath = "//h1[@translate='global.label.OrderReview']")
	WebElement txtAgreementPageInternet;
	
	@FindBy(xpath = "//h3[@translate='global.label.OrderReview']")
	WebElement txtAgreementPageBuy;

	@FindBy(xpath = "//ins[@translate='global.label.reviewHeading']")
	WebElement infoAgreementMobile;

	@FindBy(xpath = "//div[@id='terms-conditions']")
	WebElement infoAgreement;

	@FindBy(xpath = "//li[contains(text(),'819 994 6591')]")
	WebElement lnkAgreementToEndExistingCustomer;	
	
	@FindBy(xpath = "//li[contains(text(),'819 994 6591')]")
	WebElement lnkAgreementToEnd;	
	
	@FindBy(xpath = "//div[@class='agreement-container']")
	WebElement lnkAgreementContainer;
	
	@FindBy(xpath = "//div[@class='additional-agreement-details__content']")
	WebElement lnkAgreementContent;
	
	@FindBy(xpath = "//li[@id='headingDetails4']//button[@class='button-link']")
	WebElement lnkAgreementPrivacyPolicy;

	@FindBy(xpath = "//li[@id='headingDetails4']//div[@class='ute-link cursor-hand']")
	WebElement lnkAgreementPrivacyPolicyTCMobile;

	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement clkChangeAcceptCheckbox;
	
	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement clkChangeAcceptCheckboxMigration;

	@FindBy(xpath = "//span[@translate='global.cta.submit']")
	WebElement clkSubmit;
	
	@FindBy(xpath = "//label[@for='tos_consent']")
	WebElement clkChangeAcceptCheckboxUpdate;

	@FindBy(xpath = "//label[@class='ds-checkboxLabel d-inline-flex align-items-start']")
	WebElement clkChangeAcceptCheckboxUpdateInternet;

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;

	@FindBy(xpath = "//input[@class='ute-btn-primary']")
	WebElement clkSubmitUpdate;
	//input[@name='submit]

	@FindBy(xpath = "//span[@translate='global.cta.submit']")
	WebElement clkSubmitUpdateInternet;
	
	@FindBy(xpath = "//label[@for='shieldTermsCheckbox']")
	WebElement chbShieldTerms;
	
	@FindBy(xpath = "//label[@for='termsCheckbox']")
	WebElement chbTerms;
	
	@FindBy(xpath = "//label[@for='upfrontTermsCheckbox']")
	WebElement chbUpfrontTerms;

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;

	//@FindBy(xpath = "//input[@id='digital-copy']/../label")
	//@FindBy(xpath = "//label[@for='cxEmail']")
	@FindAll({
		@FindBy(xpath = "//input[@id='cxEmail']/../label"),
		@FindBy(xpath = "//input[@id='digital-copy']/../label")})
	WebElement rdbtnEmail;
	
	@FindBy(xpath = "//button[@data-dtname='reviewOrder-submit']")
	WebElement btnSubmitOrder;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	@FindBy(xpath = "//input[@name='customerEmail']")
	WebElement txtCustomerEmail;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_step_pay']")
	WebElement lblPaymentStep;
	
	@FindBy(xpath = "//input[@id='birthDate']//following-sibling::div//span")
	WebElement clkDateOfBirthCalendarIcon;

	@FindBy(xpath = "//div[@class='owl-dt-calendar-main']")
	WebElement clkMainMenuCalendarYearChange;

	@FindBy(xpath = "//table[@class='owl-dt-calendar-table owl-dt-calendar-multi-year-table']//preceding-sibling::button//span")
	WebElement clkLeftControlButtonOnCalendar;	

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
	WebElement clkChevron;
	
	@FindBy(xpath = "//button[@data-target='#miniCollapse']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersInternet;	
	
	@FindBy(xpath = "//Span[@checkout-res='checkout_review_order']")
	WebElement lblReviewYourorder;	
	
	
	/**
	 * To verify the Rogers order review Page load
	 * @author Saurav.Goyal
	 */
	public void verifyOrderReviewPageLoadedSuccessfully() {
		reusableActions.waitForElementVisibility(lblReviewYourorder, 60);
	}
	
	
    /**
     * To click on the chevron on the payment page
     * @author Saurav.Goyal
     */
    public void clkChevronYourCart() {
        reusableActions.waitForElementVisibility(downChevronYourCart, 120);
        reusableActions.getWhenReady(downChevronYourCart, 120).click();
    }
    
	/**
	 * To verify gwp promotion in the payment page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		reusableActions.waitForElementVisibility(gwpYourCart, 60);
		return	reusableActions.isElementVisible(gwpYourCart);
	}

	/**
	 * To verify the Session expiry Model
	 * @return true if the Session expiry Model has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySessionModel() {
		//Session expiry time  2 minutes
		reusableActions.staticWait(120000);
		return reusableActions.isElementVisible(popupSessionModel,60);
	}

	/**
	 * Click the Continue button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkContinueSession() {
		reusableActions.getWhenReady(btnContinueSession, 20).click();
	}
	
	/**
	 * Enter date of birth	
	 * @author Saurav.Goyal
	 * @param dateOfBirth date to be selected
	 * Function not complete, need to be updated once the HTO functionality will be working
	 */
	public void enterDateOfbirth(String dateOfBirth) {
		reusableActions.waitForElementVisibility(clkDateOfBirthCalendarIcon,20); 
		reusableActions.getWhenReady(clkDateOfBirthCalendarIcon, 20).click();
		reusableActions.waitForElementVisibility(clkMainMenuCalendarYearChange,20); 
		reusableActions.getWhenReady(clkMainMenuCalendarYearChange, 20).click();
		if(!reusableActions.isElementVisible(By.xpath("//table[@class='owl-dt-calendar-table owl-dt-calendar-multi-year-table']//span[text()='1987']")))
		{
			reusableActions.waitForElementVisibility(clkLeftControlButtonOnCalendar,20); 
			reusableActions.getWhenReady(clkLeftControlButtonOnCalendar, 20).click();
		}
	}
	/**
	 * Verify the order review page
	 * @return true if the Agreement is present on the order review page, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAgreementPage() {
		return	reusableActions.isElementVisible(txtAgreementPageBuy, 60);
	}

	public boolean verifyAgreementPageTVMobile() {
		return	reusableActions.isElementVisible(infoAgreementMobile, 180);
	}

	/**
	 * Verify the order review page
	 * @return true if the Agreement is present on the order review page, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAgreementPageInternet() {
		return	reusableActions.isElementVisible(txtAgreementPageInternet, 90);
	}
	/**
	 * Verify the agreement block on the order review page
	 * @return true if the page displays the agreement , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAgreement() {
		return reusableActions.isElementVisible(infoAgreement, 90);
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdate() {		
		reusableActions.waitForElementVisibility(lnkAgreementToEndExistingCustomer, 50);
		//Javascript scroll used to support firefox (geckodriver)
		reusableActions.javascriptScrollByVisibleElement(lnkAgreementToEndExistingCustomer);	
		reusableActions.getWhenReady(clkChangeAcceptCheckboxUpdate, 90).click();
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdateTVMobile() {
		reusableActions.waitForElementVisibility(lnkAgreementToEndExistingCustomer, 30);
		reusableActions.javascriptScrollByVisibleElement(lnkAgreementToEnd);
		reusableActions.getWhenReady(clkChangeAcceptCheckboxUpdate, 30);
		reusableActions.executeJavaScriptClick(clkChangeAcceptCheckboxUpdate);
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdateInternet() {
		reusableActions.waitForElementVisibility(lnkAgreementPrivacyPolicy, 60);
		reusableActions.getWhenReady(lnkAgreementPrivacyPolicy, 30).click();		
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 30).sendKeys(Keys.PAGE_DOWN);
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenReady(clkChangeAcceptCheckboxUpdateInternet, 90).click();
	}
	
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdateInternetMobile() {
		reusableActions.waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		reusableActions.executeJavaScriptClick(lnkAgreementPrivacyPolicy);		
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		reusableActions.javascriptScrollByVisibleElement(lnkAgreementToEnd);
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 5).sendKeys(Keys.PAGE_DOWN);
		reusableActions.getWhenReady(clkChangeAcceptCheckboxUpdateInternet, 30);
		reusableActions.executeJavaScriptClick(clkChangeAcceptCheckboxUpdateInternet);
	}
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckbox() {
		reusableActions.waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		reusableActions.getWhenReady(lnkAgreementPrivacyPolicy, 10).click();		
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 30).sendKeys(Keys.PAGE_DOWN);
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);	
		reusableActions.getWhenReady(clkChangeAcceptCheckbox, 90).click();
	}
	
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxMobile() {
		reusableActions.waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		reusableActions.executeJavaScriptClick(lnkAgreementPrivacyPolicy);		
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		reusableActions.javascriptScrollByVisibleElement(lnkAgreementToEnd);
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		reusableActions.getWhenVisible(lnkAgreementPrivacyPolicy, 5).sendKeys(Keys.PAGE_DOWN);
		
		reusableActions.waitForElementVisibility(clkChangeAcceptCheckbox, 20);
		reusableActions.executeJavaScriptClick(clkChangeAcceptCheckbox);
	}
	
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxMigration() {
		reusableActions.waitForElementVisibility(lnkAgreementToEnd, 50);
		reusableActions.scrollToElement(lnkAgreementToEnd);	
		reusableActions.getWhenReady(clkChangeAcceptCheckboxMigration, 90).click();
	}
	
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmit() {
		reusableActions.getWhenReady(clkSubmit, 30).click();
	}
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitMobile() {
		reusableActions.waitForElementVisibility(clkSubmit, 30);
		reusableActions.executeJavaScriptClick(clkSubmit);
	}
	
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdate() {
		reusableActions.getWhenReady(clkSubmitUpdate, 100).click();
	}

	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateMobile() {
		reusableActions.waitForElementInvisibility(clkSubmitUpdate, 120);
		reusableActions.executeJavaScriptClick(clkSubmitUpdate);
	}
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateInternet() {
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.getWhenReady(clkSubmitUpdateInternet, 90).click();
	}
	
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateInternetMobile() {
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.waitForElementVisibility(clkSubmitUpdateInternet,30);
		reusableActions.executeJavaScriptClick(clkSubmitUpdateInternet);
	}
	
	/**
	 * Clicks on the 'Device Financing Agreement' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkShieldAgreementCheckbox() {
		reusableActions.clickWhenReady(chbShieldTerms,60);
	}

	/**
	 * Clicks on the 'Terms and Agreement' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkTermsAgreementCheckbox() {
		reusableActions.waitForElementVisibility(chbTerms, 60);
		reusableActions.clickWhenReady(chbTerms,60);
	}

	/**
	 * Clicks on the 'Upfront Terms' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkUpfrontTermsCheckbox() {
		reusableActions.clickWhenReady(chbUpfrontTerms,60);
	}

	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 */
	public void clkEmailDigitalCopy() {
		reusableActions.staticWait(3000);
		reusableActions.waitForElementVisibility(rdbtnEmail,60);
		reusableActions.clickWhenVisible(rdbtnEmail,60);
	}
	
	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 * @param strEmail string email
	 */
	public void selectEmailDigitalCopy(String strEmail) {
		reusableActions.clickIfAvailable(rdbtnEmail,30);
		if(reusableActions.isElementVisible(txtCustomerEmail)) {
			txtCustomerEmail.sendKeys(strEmail);
		}
	}
	
	/**
	 * Clicks on the 'Submit Order' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmitOrder() {
		reusableActions.clickWhenVisible(btnSubmitOrder,60);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue,60);
	}
	
	/**
	 * Determines if payment is required or not
	 * @return true if 'Payment' appears in the Steps above; else false
	 * @author rajesh.varalli1
	 */
	public boolean isPaymentRequired() {
		return reusableActions.isElementVisible(lblPaymentStep, 30);
	}
}