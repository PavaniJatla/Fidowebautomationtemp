package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class FidoInternetPackageChangeReviewOrderPage extends BasePageClass {

	public FidoInternetPackageChangeReviewOrderPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath ="//div[@id='terms-conditions']")
WebElement termsAndConditionsFido;

@FindBy(xpath="//input[@id='tos_consent']")
WebElement termsAndConditionsSspFido;


@FindBy(xpath="//li[contains(text(),'819 994 6591')]")
WebElement lnkUnsubscribe;

@FindBy(xpath ="//p[contains(text(),'I/we may contact my/our financial institution or visit www.cdnpay.ca.')]")
   	WebElement lnkPAC;


@FindBy(xpath="//*[contains(@translate,'label.reviewConsent')]")
WebElement chkConsentCheckbox;




@FindAll({
@FindBy(xpath = "//label[(@for='agree-to-terms-and-conditions')]"),
	@FindBy(xpath="//ins[@translate='global.label.preAuthChequingTermsConditionsConsent2']")})
	WebElement chkConsentCheckboxPAC;

@FindBy(xpath="//input[@name='submit']")
WebElement btnSubmit;

@FindBy(name="submit")
WebElement btnEditIcon;

@FindBy(xpath="//div[@data-package='review']//i")
WebElement btnEditPackage;

	//ins[@translate='global.label.paymentDetails']/following-sibling::a/i
	//a[@ute-tracking='internet:package:editcheckout:internet']/i
	//button[contains(@ute-tracking,'ok')]
@FindBy(xpath ="//ins[@translate='global.label.paymentDetails']/parent::h4/a/i[@class='ute-icon-edit ute-md']")
WebElement btnEditPayment;

@FindBy(xpath ="//button[@class='ute-btn-primary']")
WebElement btnYes;

/**
 * Verify the plan information on the order review page
 * @param strBandwidth bandwidth of the package to be selected
 * @return true, if the the order review page displays the order package value, else false
 * @author Aditya.Dhingra
 */
public boolean verifyPlanInfomation(String strBandwidth) {
  return reusableActions.isElementVisible(By.xpath("//div[@data-inout='{orderSummary: orderSummary, forms: forms}']//h4[contains(text(),' "+strBandwidth+"')]"),90);
}

/**
 * Verify the presence of the agreement on the order review page
 * @return true, if the the order review page displays agreement, else false
 * @author Aditya.Dhingra
 */
public boolean verifyFidoTermsAndConditions() {
	return reusableActions.isElementVisible(termsAndConditionsFido,180);
}

	/**
	 * Verify the presence of the agreement on the order review page
	 * @return true, if the the order review page displays agreement, else false
	 * @author Aditya.Dhingra
	 */
	public boolean verifyFidoTermsAndConditionsMobile() {
		reusableActions.javascriptScrollToMiddleOfPage();
		return reusableActions.isElementVisible(termsAndConditionsFido,180);
	}
public boolean verifyFidoTermsAndConditionsSsp() {
	return reusableActions.isElementVisible(termsAndConditionsSspFido);
}

/**
 * Click on the Consent check box on the order review page
 * @author Aditya.Dhingra
 */
public void chkConsentCheckbox() {
	reusableActions.javascriptScrollByVisibleElement(lnkUnsubscribe);
	reusableActions.getWhenReady(chkConsentCheckbox).click();
}

public void chkConsentCheckboxPAC() {
	reusableActions.scrollToElement(chkConsentCheckboxPAC);
	reusableActions.waitForElementVisibility(chkConsentCheckboxPAC,60);
	reusableActions.getWhenReady(chkConsentCheckboxPAC).click();
}
/**
 * Verify the presence of the agreement on the order review page
 * @return true, if the submit button is enables and visible, else false
 * @author Aditya.Dhingra
 */
public boolean verifySubmitButtonEnabled() {
	return reusableActions.isElementVisible(btnSubmit);
}

/**
 * Click on the submit button on the order review page
 * @author Aditya.Dhingra
 */
public void clkReviewSubmitButton() {
	reusableActions.waitForElementVisibility(btnSubmit,60);
	//reusableActions.javascriptScrollByVisibleElement(btnSubmit);
	reusableActions.getWhenReady(btnSubmit,10).click();
}
public void clkscrollToElement() {
	reusableActions.waitForElementVisibility(lnkUnsubscribe,120);
	reusableActions.javascriptScrollByVisibleElement(lnkUnsubscribe);
}



public void clkscrollToEndOfAgreement(){
	reusableActions.waitForElementVisibility(lnkPAC,120);
	reusableActions.javascriptScrollByVisibleElement(lnkPAC);
}

/**
 * Click on the Consent check box on the order review page
 * @author Aditya.Dhingra
 */
public void chkAgreementConsentCheckbox() {
	reusableActions.waitForElementVisibility(chkConsentCheckbox, 30);
	//reusableActions.javascriptScrollByVisibleElement(chkConsentCheckbox);
	reusableActions.executeJavaScriptClick(chkConsentCheckbox);
}

public void clkEdit() {
	reusableActions.clickWhenReady(btnEditIcon);
	
}

/**
 * perform click on Edit payment option
 * @author Mirza.Kamran
 */
public void clickEditPaymentIcon() {
	reusableActions.waitForElementVisibility(btnEditPayment,60);
	reusableActions.clickWhenReady(btnEditPayment);
	
}

public void clickEditPackage() {
	reusableActions.waitForElementVisibility(btnEditPackage,60);
	reusableActions.clickWhenReady(btnEditPackage);
}

/**
 * Click yes on Edit Payment confirmation Overlay
 */
public void clickYesOnEditPaymentOverLay() {
	reusableActions.waitForElementVisibility(btnYes);
	reusableActions.clickWhenReady(btnYes);
	
}

}
