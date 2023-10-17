package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import ca.fido.testdatamanagement.TestDataHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.FormFiller;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


public class FidoBuildPlanPage extends BasePageClass {

	public String xpath;
	public int stepper;
	String planType = TestDataHandler.tc13AALBYODExpressShipping.getNewPlanType();

	public FidoBuildPlanPage(WebDriver driver) {
		super(driver);
	}

	List<WebElement> autoPayText = null;

	@FindBy(xpath = "//*[@id='bfa-page-title' and contains(text(),'Build Your Plan')]")
	WebElement buildPlanTitle;

	@FindBy(xpath = "(//div[@class='features-section' or @class='features-section dataSectionEmpty']/button)[3]")
	WebElement btnAdd;

	@FindBy(xpath = "//button[@translate='_continue']")
	WebElement btnContinue;

	////f-cart-summary//button[contains(@class,'-primary -large') or @id='main-continue-button']//span[contains(@class,'ds-no-overflow mw-100')]
	//@FindBy(xpath = "//button[@id='main-continue-button']")
	@FindBy(xpath = "//button[@class='w-100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large' or @data-test='build-plan-checkout-flow-button']")
	WebElement btnContinueBelowCartSummary;

	@FindBy(xpath = "//input[@id='email' or (contains(@formcontrolname,'email') and  not(contains(@formcontrolname,'Confirm')))]/parent::div")
	WebElement txtEmail;

	@FindBy(xpath = "//label[@aria-label='NOTERM_false']")
	WebElement lblNoTermTierDeviceCost;

	@FindBy(xpath = "//ds-checkbox[@data-test='keep-current-plan-checkbox']//label")
	WebElement keepMyCurrentPlanButton;

	@FindBy(xpath = "//ds-checkbox[@data-test='vdp-checkbox']/label")
	WebElement vdpCheckBox;

	@FindBy(xpath = "//div[contains(@class,'ds-radioLabel') and contains(.,'full')]/parent::label")
	WebElement noTermRadioBtn;

	@FindBy(xpath = "//button[contains(@data-test,'stepper-1-edit-step-continue')]")
	WebElement btnContinueDeviceCost;

	@FindBy(xpath = "//button[contains(@data-test,'stepper-2-edit-step-continue')]")
	WebElement btnContinuePlanStepper;

	@FindBy(xpath = "//ds-modal[contains(@data-test,'upfront-edge-return-modal')]//button[contains(@title,'Continue')]")
	WebElement deviceBalancePopUp;

	@FindBy(xpath = "//ds-modal//button[@data-test='modal-pom-continue']")
	WebElement btnContinueWithSeletecPlan;

	@FindBy(xpath = "//span[contains(text(),'View All Plans')]")
	WebElement viewAllPlansButton;

	@FindBy(xpath = "//button[@id='step-2-continue-button' or @data-test='stepper-2-edit-step-continue-button']")
	WebElement btnContinueDataOption;

	@FindBy(xpath = "//button[@id='step-3-continue-button' or @data-test='stepper-3-edit-step-continue-button']")
	WebElement btnContinueTalkOptions;

	@FindBy(xpath = "//button[@id='ds-tabs-0-tab-1']")
	WebElement btnDataAndTextPlan;

	@FindAll({
			@FindBy(xpath = "//button[@data-test='bpo-offer-modal-button-primary']"),
			@FindBy(xpath = "//button[contains(@title,'CONTINUE')]")
	})
	WebElement btnNoBPOOffer;

	@FindAll({
			@FindBy(xpath = "//button[@id='step-4-continue-button' or @data-test='stepper-4-edit-step-continue-button']"),
			@FindBy(xpath = "//button[contains(@id,'dummyContinueCta')]/span/span")
	})
	WebElement btnContinueAddOns;

	@FindBy(xpath = "//ds-radio-button[@data-test='stepper-5-radio-no']")
	WebElement eSIMOptNo;

	@FindBy(xpath = "//button[@data-test='stepper-5-continue-cta']")
	WebElement eSIMContinue;

	@FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
	WebElement callerIDContinue;

	@FindBy(xpath = "//span[@translate='createAccount']/parent::button")
	WebElement btnCreateAnAccount;

	@FindBy(xpath = "//span[@translate='login-cta']/parent::button")
	WebElement btnLogin;

	@FindBy(xpath = "//div[contains(@class,'current-balance-container')]//span[contains(@ng-if,'planCategory') and contains(@res,'category')]")
	WebElement lblCurrentPlanCategory;

	@FindBy(xpath = "//span[contains(@class,'ui-slider-handle')]")
	WebElement planSlider;

	@FindBy(xpath = "//button[@translate='btn_continue_to_addons']")
	WebElement btnContinueToAddons;

	List<String> planCategory = Arrays.asList("category-SMALL", "category-MEDIUM", "category-LARGE", "category-EXTRALARGE", "category-2XLARGE");

	@FindBy(xpath = "//a[@res='keep-existing']")
	WebElement lnkKeepExisting;

	@FindBy(xpath = "//span[@res='keep-existing']/parent::button")
	WebElement btnKeepExistingPlan;

	@FindBy(xpath = "//div[@res='build-your-phone']")
	WebElement lblBuildYourPlan;

	@FindBy(xpath = "//button[@translate='bpo_redeem_offer']")
	WebElement btnGetThisOffer;

	@FindBy(xpath = "//span[contains(@class,'dsa-cartSummary')]")
	WebElement txtCartSummary;

	@FindBy(xpath = "(//span[@class='dsa-selection__label ds-no-overflow text-body mb-0 d-inline-block w-100']//p)[1]")
	WebElement selectFirstTierChooseYourData;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement inputFirstName;

	@FindBy(xpath = "//ds-form-field[@data-test='caller-id-first-name']")
	WebElement frmFieldFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement inputLastName;

	@FindBy(xpath = "//ds-form-field[@data-test='caller-id-last-name']")
	WebElement frmFieldLastName;

	@FindBy(xpath = "//button[@id='step-5-continue-button' or @data-test='stepper-5-edit-step-continue-button']")
	WebElement buttonContinueUserName;

	@FindBy(xpath = "//select[contains(@id,'ds-form-input-id')]")
	WebElement selectCity;

	@FindBy(xpath = "//button[@data-test='choose-number-continue']")
	WebElement buttonChooseNumberContinue;

	@FindBy(xpath = "//img[@alt='Close']")
	WebElement closeDialogWindow;

	@FindBy(xpath = "//p[contains(.,'Basic plans') or contains(.,'Forfait de base')]/ancestor::button")
	WebElement btnBasicPlan;

	@FindAll({
	@FindBy(xpath = "//span[contains(@class,'m-navLink__chevron')]/parent::a[@role='button']"),
	@FindBy(xpath = "//a[@aria-label='Province']")
	})
	WebElement provinceDropDown;

	@FindBy(xpath = "//div[contains(@class,'dsa-infoWidget__ctnInfo')]//span[contains(@class,'dsa-infoWidget__ctnCopy')]")
	WebElement infoWidgetCtnCopy;

	@FindBy(xpath = "//button[@data-test='stepper-0-edit-step-continue-button']")
	WebElement btnChangePlan;

	@FindBy(xpath = "//button[@data-test='downgrade-modal-proceed']")
	WebElement btnDowngradeFeeModalConitnue;

	@FindBy(xpath = "//button[@data-test='addons-removal-modal-button-primary']//span")
	WebElement btnExistingAddonModalContinue;

	@FindBy(xpath = "//input[@value='FIN_DATA_TALK_TEXT']/..")
	WebElement labelDTTPlanType;

	@FindBy(xpath = "//input[@value='FIN_TALK_TEXT']/..")
	WebElement labelTTPlanType;

	@FindBy(xpath = "//input[@value='NOTERM']/..")
	WebElement labelNotermPlanType;

	@FindBy(xpath = "//button[@data-test='stepper-5-edit-step-continue-button']")
	WebElement btnContinueAccessoriesCost;

	@FindBy(xpath = "//button[contains(@title,'Device Protection')]/preceding-sibling::button")
	WebElement btnContinueDeviceProtection;

	@FindBy(xpath = "//button[contains(@class,'dsa-cartSummary')]")
	WebElement btnCartSummary;

	@FindBy(xpath = "//span[contains(text(),'Have a promo code') or contains(text(),'code promotionnel')]")
	WebElement promoSection;

	@FindBy(xpath = "//input[contains(@class,'ds-input') and contains(@id,'ds-form-input-id')]/ancestor::ds-form-field")
	WebElement promoCodeField;

	@FindBy(xpath = "//input[contains(@class,'ds-input') and contains(@id,'ds-form-input-id')]")
	WebElement txtPromoCode;

	@FindBy(xpath = "//button[contains(@data-test,'promo-button-check') and contains(text(),'Check') or contains(text(),'Vérifier')]")
	WebElement btnCheckPromo;

	@FindAll({
			@FindBy(xpath = "//ds-modal-container[@aria-label='Add promo code']//p[contains(text(),'Add promo code')]"),
			@FindBy(xpath = "//span[contains(@class,'text-body') and contains(text(),'added to your cart') or contains(text(),' ajoutée à votre panier')]")
	})
	WebElement promoCodeSuccessMsg;

	@FindBy(xpath = "//ds-modal-container[@aria-label='Add promo code']//button[@data-test='modal-pom-continue']")
	WebElement continueBtnPromo;
	@FindBy(xpath = "//span[contains(@class,'text-body') and contains(text(),'with promo code') or contains(text(),'avec le code promotionnel')]")
	WebElement promoCodeDuration;

	@FindBy(xpath = "//span[@data-test='promo-detail-info']/following::span[3]")
	WebElement regularPromoDetail;

	@FindAll({
			@FindBy(xpath = "//*[contains(text(),'Payment Program Promotion credit')]"),
			@FindBy(xpath = "//span[contains(text(),'Plan discount') or contains(text(),'Rabais sur le forfait')]//ancestor::div[contains(@class,'dsa-orderTable__row')]")
	})
	WebElement promoCartLineItem;

	@FindAll({
			@FindBy(xpath = "//span[@data-test='delete-promo-detail-info']"),
			@FindBy(xpath = "//span[@data-test='delete-promo']")
	})
	WebElement deletePromo;

	@FindBy(xpath = "//button[contains(@class,'ds-tablet')]//p[contains(text(),'Device Protection') or contains(text(),'Protection de l’appareil')]")
	WebElement deviceProtectionAddonTab;

	@FindBy(xpath = "//div[contains(@class,'ds-checkboxLabel')]//parent::label[contains(@title,'Device Protection') or contains(@title,'Protect supér appareil ')]")
	WebElement deviceProtectionAddon;

	@FindBy(xpath = "//span[contains(text(),'Protect supér appareil') or contains(text(),'Device Protection')]//ancestor::div[contains(@class,'dsa-orderTable__row')]")
	WebElement dpAddonCarLineItem;

	@FindBy(xpath = "//label[@aria-label='Device Protection' or contains(@aria-label,'Protection de l’appareil')]")
	WebElement BYODdpAddon;

	@FindBy(xpath = "//input[@formcontrolname='imei']/parent::div")
	WebElement dpimeiField;

	@FindBy(xpath = "//input[@formcontrolname='imei']")
	WebElement inputDPIMEI;

	@FindBy(xpath = "//div[@class='d-flex flex-row-reverse']//span[contains(text(),'Continue')]")
	WebElement dpIMEIContinue;

	@FindBy(xpath = "//select[@data-test='byod-equipment-storage']")
	WebElement inputDeviceStorage;

	@FindBy(xpath = "//select[@data-test='byod-equipment-color']")
	WebElement inputDeviceColor;

	@FindBy(xpath = "//button[@data-test='byod-check-eligibility-cta']")
	WebElement imeiEligCheckBtn;

	@FindBy(xpath = "//p[contains(.,'Your device is eligible') or contains(.,' Bonne nouvelle! Votre appareil est admissible')]")
	WebElement imeiSuccessEligibleMsg;

	@FindBy(xpath = "//label[@aria-label='No Device Protection' or contains(@aria-label,'Aucune protection de l’appareil')]")
	WebElement byodNoDeviceProtection;

	@FindBy(xpath = "//p[contains(.,'not eligible') or contains(.,'Votre appareil n’est pas admissible')]")
	WebElement imeiNotEligibleMsg;

	@FindBy(xpath = "//ds-modal-container//*[contains(text(),'Continue with selected plan')]")
	WebElement continueSelectedPlan;

	/**
	 * This method verifies if info widget is properly displayed in plan config page
	 * @return true if info widget is loaded successfully, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyPPCPlanConfigPage() {
		reusableActions.staticWait(15000);
		reusableActions.javascriptScrollToTopOfPage();
		return reusableActions.isElementVisible(infoWidgetCtnCopy,30);
	}

	/**
	 * Creates xpath to select multiple options among device cost, data options, talk options
	 * @param option is a String value given as input, which helps change xpath value for different options
	 * @author sidhartha.vadrevu
	 */
	public String createXpath(int stepper,String option) {
		if (stepper == 1 && stepper != 0) {
			//ds-radio-button[contains(@data-test,'device-payment-type-financing')]//div/div
			return "//ds-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-"+option+"')]/label";
		} else if(stepper == 2 && stepper != 0) {
			//reusableActions.scrollToElement(getDriver().findElement(By.xpath("//p[contains(text(),'All Plans Include')]")));
			reusableActions.javascriptScrollToTopOfPage();
				try {
					if(planType.equals("Data, Talk and Text plans") && planType != null && !planType.isEmpty()) {
						return "//ds-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-infinite-"+option+"')]/label";
					} else if (planType.equals("Data and Text only plans - No calls included") && planType != null && !planType.isEmpty() && reusableActions.isElementVisible(By.xpath("//button[contains(@id,'ds-tabs-0-tab-1')]"))) {
						reusableActions.clickWhenReady(By.xpath("//button[contains(@id,'ds-tabs-0-tab-1')]"));
						return "//ds-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-individual-"+option+"')]/label";
					} else if (planType.equals("Talk and Text plans") && planType != null && !planType.isEmpty() && reusableActions.isElementVisible(By.xpath("//button[contains(@id,'ds-tabs-0-tab-2')]"))) {
						reusableActions.clickWhenReady(By.xpath("//button[contains(@id,'ds-tabs-0-tab-2')]"));
						return "//ds-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-talkAndText-"+option+"')]/label";
					} else {
						return "//ds-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-infinite-"+option+"')]/label";
					}
				} catch (NullPointerException ex) {
					return "//ds-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-infinite-"+option+"')]/label";
				}
		}
		return xpath;
	}

	public String createXpath1(int stepper,String option, String devicePaymentType) {
		Method currentTestMethodName = null;
		if (stepper == 1 && stepper != 0) {
			if (currentTestMethodName.getName().contains("AAL")) {
				if(devicePaymentType.equalsIgnoreCase("Finance")) {
					reusableActions.clickWhenReady(By.xpath("//ds-radio-button[contains(@data-test,'device-payment-type-financing')]//div/div"));
				} else if (devicePaymentType.equalsIgnoreCase("Full Price")) {
					reusableActions.clickWhenReady(By.xpath("//ds-radio-button[contains(@data-test,'device-payment-type-fullPrice')]//div/div"));
				}
			}
			return "//dsa-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-"+option+"')]/label";
		} else if(stepper == 2 && stepper != 0) {
			reusableActions.scrollToElement(getDriver().findElement(By.xpath("//p[contains(text(),'All Plans Include')]")));
			try {
				if(planType.equals("Data, Talk and Text plans") && planType != null && !planType.isEmpty()) {
					return "//dsa-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-infinite-"+option+"')]/label";
				} else if (planType.equals("Data and Text only plans - No calls included") && planType != null && !planType.isEmpty() && reusableActions.isElementVisible(By.xpath("//button[contains(@id,'ds-tabs-0-tab-1')]"))) {
					reusableActions.clickWhenReady(By.xpath("//button[contains(@id,'ds-tabs-0-tab-1')]"));
					return "//dsa-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-individual-"+option+"')]/label";
				} else if (planType.equals("Talk and Text plans") && planType != null && !planType.isEmpty() && reusableActions.isElementVisible(By.xpath("//button[contains(@id,'ds-tabs-0-tab-2')]"))) {
					reusableActions.clickWhenReady(By.xpath("//button[contains(@id,'ds-tabs-0-tab-2')]"));
					return "//dsa-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-talkAndText-"+option+"')]/label";
				} else {
					return "//dsa-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-infinite-"+option+"')]/label";
				}
			} catch (NullPointerException ex) {
				return "//dsa-selection[contains(@data-test,'stepper-"+stepper+"-edit-step-selection-option-infinite-"+option+"')]/label";
			}
		}
		return xpath;
	}

	/**
	 * This method clicks on downpaymment checkbox in device cost stepper
	 * @author praveen.kumar7
	 */
	public void clkDownPaymentChkBox() {
		reusableActions.scrollToElement(vdpCheckBox);
		reusableActions.clickWhenReady(vdpCheckBox,30);
	}

	/**
	 * Clicks on the 'Keep My Current Plan' button for Device Cost Stepper
	 * @author Sidhartha.Vadrevu
	 */
	public void checkKeepMyCurrentPlanButton() {
		reusableActions.waitForElementTobeClickable(keepMyCurrentPlanButton,40);
		reusableActions.clickWhenVisible(keepMyCurrentPlanButton, 10);
	}

	/**
	 * Selects the xpath according to options provided. Clicks on the 'Continue' button for select your device cost.
	 * @param deviceCostIndex is a String value given as input, used to fetch required xpath
	 * @author Sidhartha.Vadrevu
	 */
	public void clkDeviceCost(String deviceCostIndex) {
		stepper = 1;
		if (deviceCostIndex != null && !deviceCostIndex.isEmpty()) {
			String xpathDeviceCost = createXpath(stepper,deviceCostIndex);
			By deviceCostXpath = By.xpath(xpathDeviceCost);
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(deviceCostXpath,10);
			reusableActions.clickWhenReady(btnContinueDeviceCost, 30);
		} else {
			String xpathDeviceCost = "//dsa-selection[contains(@data-test,'stepper-1-edit-step-selection-option-0')]/label";
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(By.xpath(xpathDeviceCost),10);
			reusableActions.clickWhenReady(btnContinueDeviceCost, 30);
		}
	}


	public void clkDeviceCost1(String deviceCostIndex, String devicePaymentType) {
		stepper = 1;
		if (deviceCostIndex != null && !deviceCostIndex.isEmpty()) {
			String xpathDeviceCost = createXpath1(stepper, deviceCostIndex, devicePaymentType);
			By deviceCostXpath = By.xpath(xpathDeviceCost);
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(deviceCostXpath,10);
			reusableActions.clickWhenReady(btnContinueDeviceCost, 30);
		} else {
			String xpathDeviceCost = "//dsa-selection[contains(@data-test,'stepper-1-edit-step-selection-option-0')]/label";
			reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(By.xpath(xpathDeviceCost),10);
			reusableActions.clickWhenReady(btnContinueDeviceCost, 30);
		}
	}


	/**
	 * Clicks on the 'Continue' button for select your device cost
	 * @author Saurav.Goyal
	 */
	public void clkNoTermTierInDeviceCost() {
		reusableActions.waitForElementVisibility(lblNoTermTierDeviceCost, 60);
		reusableActions.clickIfAvailable(lblNoTermTierDeviceCost, 10);
	}

	/**
	 * Clicks on the 'Continue' button for Device Balance pop-up
	 * @author Sidhartha.Vadrevu
	 */
	public void clkDeviceBalancePopUp() {
		reusableActions.clickIfAvailable(btnContinueWithSeletecPlan, 10);
		reusableActions.clickIfAvailable(deviceBalancePopUp, 10);
	}

	/**
	 * Clicks on NO TERM radio button in device cost stepper
	 * @author praveen.kumar7
	 */
	public void clkRadioButtonNoTerm() {
		reusableActions.scrollToElement(reusableActions.getWhenReady(By.xpath("//p[contains(.,'Financing options')]")));
		reusableActions.clickWhenReady(noTermRadioBtn,30);
	}

	/**
	 * Selects the xpath according to options provided. Clicks on the 'Continue' button for selected data option.
	 * @param dataOptionIndex is a String value given as input, used to fetch required xpath
	 * @author Sidhartha.Vadrevu
	 */
	public void clkDataOption(String dataOptionIndex, String className) {
		reusableActions.clickIfAvailable(viewAllPlansButton);
		stepper = 2;
		if (dataOptionIndex != null && !dataOptionIndex.isEmpty()) {
			String xpathDataOption = createXpath(stepper, dataOptionIndex);
			//By dataOptionXpath = By.xpath(xpathDataOption);
			if (Integer.parseInt(dataOptionIndex) == 0) {
				autoPayText = getDriver().findElements(By.xpath(xpathDataOption + "//div[@class='dsa-dataBlock']//*[contains(text(),'Automatic')]"));
				reusableActions.staticWait(5000);
				reusableActions.clickWhenVisible(btnContinueDataOption, 20);
			} else {
				autoPayText = getDriver().findElements(By.xpath(xpathDataOption + "//div[@class='dsa-dataBlock']//*[contains(text(),'Automatic')]"));
				reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(By.xpath(xpathDataOption), 20));
				if (className.toUpperCase().contains("_PPC_") && className.toUpperCase().contains("DOWNGRADE") && !(Integer.parseInt(dataOptionIndex) == 0)) {
					verifyDowngradeFeeModalAndClkContinue();
				} else if (className.toUpperCase().contains("_PPC_") && !(className.toUpperCase().contains("DOWNGRADE"))) {
					reusableActions.waitForElementTobeClickable(btnContinueDataOption, 40);
				}
				reusableActions.clickWhenReady(btnContinueDataOption, 30);
			}
		}else {
			String xpathDataOption;
			if (planType.equals("Data, Talk and Text plans")) {
				xpathDataOption = "//dsa-selection[contains(@data-test,'stepper-2-edit-step-selection-option-infinite-0')]/label";
			} else if (planType.equals("Data and Text only plans - No calls included")) {
				reusableActions.clickWhenReady(By.xpath("//button[contains(@id,'ds-tabs-0-tab-1')]"));
				xpathDataOption = "//dsa-selection[contains(@data-test,'stepper-2-edit-step-selection-option-individual-0')]/label";
			} else {
				reusableActions.clickWhenReady(By.xpath("//button[contains(@id,'ds-tabs-0-tab-2')]"));
				xpathDataOption = "//dsa-selection[contains(@data-test,'stepper-2-edit-step-selection-option-talkAndText-0')]/label";
			}
			//reusableActions.staticWait(5000);
			reusableActions.clickWhenReady(By.xpath(xpathDataOption),10);
			reusableActions.clickWhenReady(btnContinueDataOption, 30);
		}
	}

	/**
	 * Verifies the selection of Autopay plan
	 * @param dataOptionIndex - Index of the plan
	 * @param className - Class name of the test
	 * @return true if Autopay plan is selected, else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyAutoPayPlanSelection(String dataOptionIndex, String className) {
		clkDataOption(dataOptionIndex,className);
		return autoPayText.size()==1;
	}

	/**
	 * Verifies the autopay discount in the cart summary
	 * @return true if Autopay is applied in cart summary, else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyAutoPayDiscountInCartSummary() {
		return reusableActions.isElementVisible(By.xpath("(//span[contains(@class,'dsa-orderTable__strikeCopy')])[1]"));
	}

	/**
	 * This method gets the inxed value of the autopay discount plan
	 * @param autoPayDiscountType - Automatic payment discount type
	 * @return String value of autopay plan index
	 * @author Subash.Nedunchezhian
	 */
	public String getAutoPayPlanIndex(String autoPayDiscountType) {
		String dataOptionIndex = "";
		try {
			if (autoPayDiscountType.equalsIgnoreCase("MSF")) {
				if (getDriver().findElements(By.xpath("//label[contains(.,'Includes $')]")).size() > 0) {
					dataOptionIndex = getDriver().findElement(By.xpath("(//label[contains(.,'Includes $')])[1]/..")).getAttribute("data-test").split("infinite-")[1];
				} else {
					Assert.assertTrue(getDriver().findElements(By.xpath("//label[contains(.,'Includes $')]")).size() > 0, "No plan is displayed with Autopay MSF discount");
				}
			}
			if (autoPayDiscountType.equalsIgnoreCase("PERCENT")) {
				if (getDriver().findElements(By.xpath("//label[contains(.,'%') and contains(.,'Automatic')]")).size() > 0) {
					dataOptionIndex = getDriver().findElement(By.xpath("(//label[contains(.,'%') and contains(.,'Automatic')])[1]/..")).getAttribute("data-test").split("infinite-")[1];
				} else {
					Assert.assertTrue(getDriver().findElements(By.xpath("//label[contains(.,'%') and contains(.,'Automatic')]")).size() > 0, "No plan is displayed with Autopay Percent discount");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dataOptionIndex;
	}

	/**
	 * Clicks on the X - close Dialogue window
	 * @author Saurav.Goyal
	 */
	public void clkCloseDialogWindow() {
		reusableActions.clickIfAvailable(closeDialogWindow, 30);
	}
	
	/**
	 * Clicks on the 'Continue' button for enter user's name
	 * @author Saurav.Goyal
	 */
	public void clkChooseNumberContinueButton() {
		reusableActions.waitForElementVisibility(buttonChooseNumberContinue, 120);
		reusableActions.clickIfAvailable(buttonChooseNumberContinue, 120);
	}
	
	/**
     * This method will select the city for which connection is required
     * @param cityName is name of the city
     * @author Saurav.Goyal  
     */
    public void selectCityForChooseYourTelephoneNum(String cityName) {
    	reusableActions.getWhenReady(selectCity, 30).click();
    	reusableActions.selectWhenReady(selectCity,cityName);
    	
    }
    
	/**
	 * Clicks on the 'Continue' button for enter user's name
	 * @author Saurav.Goyal
	 */
	public void clkContinueEnterUserNameAAL() {
		reusableActions.waitForElementVisibility(buttonContinueUserName, 60);
		reusableActions.clickIfAvailable(buttonContinueUserName, 60);
	}
	
	/**
	 * Enter First name on the phone plans page
	 * @author Saurav.Goyal
	 */
	public void enterFirstName() {
		String strFirstName = FormFiller.generateRandomName();
		reusableActions.getWhenReady(frmFieldFirstName, 30).click();
		reusableActions.getWhenReady(inputFirstName, 3).sendKeys(strFirstName);
	}
	
	/**
	 * Enter Last name on the phone plans page
	 * @author Saurav.Goyal
	 */
	public void enterSecondName() {
		String strLastName = FormFiller.generateRandomName();
		reusableActions.getWhenReady(frmFieldLastName, 30).click();
		reusableActions.getWhenReady(inputLastName, 3).sendKeys(strLastName);
	}
	
	/**
	 * Select First tier of the Choose your data
	 * @author Saurav.Goyal
	 */
	public void clkFirstTierChooseYourDataAAL() {
		String xpath = "(//span[@class='dsa-selection__label ds-no-overflow text-body mb-0 d-inline-block w-100']//p)[1]";
		reusableActions.staticWait(5000);
		reusableActions.scrollToElement(driver.findElement(By.xpath(xpath)));
		reusableActions.executeJavaScriptClick(driver.findElement(By.xpath(xpath)));
	}

	/**
	 * Verify the 'Continue' button for select you device cost
	 * @return boolean true is the element is present else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyContinueDeviceCostButton() {
		return reusableActions.isElementVisible(btnContinueDeviceCost, 60);
	}

	/**
	 * Verify the 'Continue' button for plann stepper
	 * @return boolean true is the element is present else false
	 * @author praveen.kumar7
	 */
	public boolean verifyContinueBtnPlanStepper() {
		return reusableActions.isElementVisible(btnContinuePlanStepper, 60);
	}
	
	/**
	 * Clicks on the 'Continue' button for your data
	 * @author Saurav.Goyal
	 */
	public void clkContinueYourDataAAL() {
		//reusableActions.waitForElementVisibility(btnContinueDeviceCost, 60);
		reusableActions.clickIfAvailable(btnContinueDeviceCost, 60);
	}
	
	/**
	 * Clicks on the 'Continue' button for select your device cost
	 * @author Saurav.Goyal
	 */
	public void clkContinueDeviceCost() {
		//reusableActions.waitForElementVisibility(btnContinueDeviceCost, 30);
		reusableActions.clickWhenReady(btnContinueDeviceCost, 60);
	}
	
	/**
	 * Clicks on the 'Continue' button for select data option
	 * @author Saurav.Goyal
	 */
	public void clkContinueDataOption() {
		//reusableActions.waitForElementVisibility(btnContinueDataOption, 60);
		reusableActions.clickIfAvailable(btnContinueDataOption, 30);
	}
	
	/**
	 * Clicks on the 'Continue' button for select talk options
	 * @author Saurav.Goyal
	 */
	public void clkContinueTalkOptions() {
		reusableActions.clickIfAvailable(btnContinueTalkOptions, 10);
	}

	/**
	 * Clicks on data and text plan
	 * @author Saurav.Goyal
	 */
	public void clkDataAndTextPlan() {
		reusableActions.executeJavaScriptClick(btnDataAndTextPlan);
	}
	
	/**
	 * Click no, I don't want this BPO offer
	 * @author Saurav.Goyal
	 */
	public void clkNoBPOOfferButtonTalkOptions() {
		reusableActions.clickIfAvailable(btnNoBPOOffer, 5);
	}
	
	/**
	 * Clicks on the 'Continue' button for AddOns for AAL
	 * @author Saurav.Goyal
	 */
	public void clkContinueAddOnsAAL() {
		reusableActions.clickIfAvailable(btnContinueTalkOptions, 30);
	}
	
	/**
	 * Clicks on the 'Continue' button after giving first name and last name details. Tablet has default values which is covered with try/catch block.
	 * @author Sidhartha.Vadrevu
	 */
	public void clkContinueCallerID() {
		try {
			enterFirstName();
			enterSecondName();
			reusableActions.waitForElementVisibility(callerIDContinue, 20);
			reusableActions.executeJavaScriptClick(callerIDContinue);
		}catch (ElementClickInterceptedException except){
			reusableActions.waitForElementVisibility(callerIDContinue, 20);
			reusableActions.executeJavaScriptClick(callerIDContinue);
		}
	}

	/**
	 * Clicks on the 'Continue' button for select addons for new Page
	 * @author Saurav.Goyal
	 */
	public void clkContinueAddOns() {
		reusableActions.waitForElementTobeClickable(btnContinueAddOns,30);
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnContinueAddOns));
	}

	/**
	 * Click continue on eSIM Stepper in BYOD Plan config page
	 * @author subash.nedunchezhian
	 */
	public void clickeSIMContinueButton() {
		reusableActions.clickWhenVisible(eSIMOptNo,10);
		reusableActions.clickWhenReady(eSIMContinue, 5);
	}

	/**
	 * Clicks on the 'Continue' button at the bottom of the cart summary
	 * @author Saurav.Goyal
	 */
	public void clkContinueBelowCartSummary() {
		reusableActions.waitForElementTobeClickable(btnContinueBelowCartSummary, 30);
		//reusableActions.executeJavaScriptClick(btnContinueBelowCartSummary);
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.clickWhenReady(btnContinueBelowCartSummary);
		//reusableActions.waitForElementVisibility(txtEmail , 60);
	}
	
	/**
	 * Clicks on the 'Add' button against the first available price plan
	 * @return true if at least a plan is available; else false
	 * @author rajesh.varalli1
	 */
	public boolean selectFirstAvailablePricePlan() {
		if(reusableActions.isElementVisible(btnAdd, 30)) {
			reusableActions.executeJavaScriptClick(btnAdd);
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		if(handleTodayOfferOverlay()) {
			reusableActions.clickWhenVisible(btnContinue,30);
		}
		//reusableActions.waitForElementVisibility(btnContinue, 40);
	}
	
	/**
	 * Clicks on the 'CREATE AN ACCOUNT' button on the overlay modal
	 * @author rajesh.varalli1
	 */
	public void clkCreateAccount() {
		reusableActions.clickWhenVisible(btnCreateAnAccount);
	}
	
	/**
	 * Clicks on the 'LOG IN' button on the overlay modal
	 * @author rajesh.varalli1
	 */
	public void clkLogin() {
		reusableActions.clickWhenVisible(btnLogin);
		reusableActions.staticWait(3000);
	}
	
	/**
	 * Selects the next high tier price plan than the current price plan.
	 * @author rajesh.varalli1
	 * @return return value of assertion
	 */
	public boolean selectHigherPricePlan() {
		reusableActions.javascriptScrollToMiddleOfPage();
		String curPlnCat = lblCurrentPlanCategory.getAttribute("res");
		
		for (int index = planCategory.indexOf(curPlnCat)+1; index < planCategory.size(); index++) {
			reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='" + planCategory.get(index) + "']"),60));
			if(selectFirstAvailablePricePlan()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Selects the next low tier price plan than the current price plan.
	 * @author rajesh.varalli1
	 * @return return value of assertion
	 */
	public boolean selectLowerPricePlan() {
		reusableActions.javascriptScrollToMiddleOfPage();
		String curPlnCat = lblCurrentPlanCategory.getAttribute("res");
		
		for (int index = planCategory.indexOf(curPlnCat)-1; index >= 0; index--) {
			reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='" + planCategory.get(index) + "']"),60));
			if(selectFirstAvailablePricePlan()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Selects the plan type category by moving the Slider bar
	 * @param planCat Type of the plan
	 * @author rajesh.varalli1
	 */
	public void selectPlanCategory(String planCat) {
		reusableActions.getWhenReady(planSlider, 60);
		
		if(planCat.trim().toUpperCase().contains("DATA")) {
			planCat = "FID_FIN2";
		} else {
			planCat = "TALKTEXT_F";
		}
		
		reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='category-" + planCat + "']"),60));
	}
		
	/**
	 * Clicks on the 'Continue to Add-ons' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinueToAddons() {
		if(handleTodayOfferOverlay()) {
			reusableActions.clickWhenVisible(btnContinueToAddons,40);
		}
		//reusableActions.waitForElementVisibility(btnContinueToAddons, 60);
	}
	
	/**
	 * Selects the Existing Plan
	 * @author rajesh.varalli1
	 */
	public void keepExistingPlan() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(lnkKeepExisting, 40));
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnKeepExistingPlan, 30));
		//reusableActions.clickIfAvailable(By.xpath("//button[@translate='bpo_redeem_offer']"));
	}
	
	/**
	 * Handles the ONLINE OFFERS overlay by clicking on 'Get this offer' button and 
	 * clicking on 'Continue to Addons' button after.
	 * @return true if no overlay is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean handleTodayOfferOverlay() {
		if(reusableActions.isElementVisible(btnGetThisOffer, 60)) {
			reusableActions.clickWhenReady(btnGetThisOffer);
			reusableActions.clickWhenVisible(By.xpath("//button[@translate='continue_to_addons']"), 30);
			return false;
		} else {
			return true;
		}
	}
	
	public void selectDataPlanCategory() {
		reusableActions.getWhenReady(planSlider, 60);
		reusableActions.dragAndDrop(planSlider, reusableActions.getWhenReady(By.xpath("//div[@res='category-FID_FIN2']")));
	}

	/**
	 * This method clicks on basic plan tab in plan config page
	 * @author praveen.kumar7
	 */
	public void clkBasicTab() {
	    reusableActions.waitForElementVisibility(btnBasicPlan);
		reusableActions.executeJavaScriptClick(btnBasicPlan);
	}

	/**
	 * This menthod selects basic plan based on the index value
	 * @param dataOptionIndex : String value of data option to be selected
	 * @param className name of the class file
	 * @author praveen.kumar7
	 */
	public void selectBasicPlanAndClkContinueBtn(String dataOptionIndex,String className) {
		reusableActions.clickWhenVisible(By.xpath("//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-basic-"+dataOptionIndex+"')]//label[1]"),20);
		if(className.toUpperCase().contains("_PPC_")) {
			reusableActions.waitForElementTobeClickable(btnContinueDataOption,40);
		}
		reusableActions.clickWhenVisible(btnContinueDataOption,20);
	}

	/* This method will select the province based on the input
	* @param province
	* @author praveen.kumar7
	*/
	public void setProvince(String province) {
		reusableActions.waitForElementVisibility(txtCartSummary,30);
		reusableActions.clickWhenReady(provinceDropDown);
		reusableActions.staticWait(3000);
		reusableActions.clickWhenReady(By.xpath("//span[contains(@class,'m-navLink__chevron')]/parent::a[@role='button']/following-sibling::ul//a[@title='"+province+"']"),10);
	}

	/**
	 * This method clicks on Change plan CTA
	 * @author praveen.kumar7
	 */
	public void clkChangePlan() {
		reusableActions.javascriptScrollByVisibleElement(infoWidgetCtnCopy);
		reusableActions.clickIfAvailable(btnChangePlan);
	}

	/**
	 * This method selects the plan type based on the input
	 * @param planType plan type to be selected
	 * @author praveen.kumar7
	 */
	public void selectPlanType(String planType) {
		if(planType.equalsIgnoreCase("Financing")) {
			reusableActions.clickWhenVisible(labelDTTPlanType);
		}
		else if(planType.equalsIgnoreCase("TALKTEXTFIN")) {
			reusableActions.clickWhenVisible(labelTTPlanType);
		}
		else if(planType.equalsIgnoreCase("NOTERM")) {
			reusableActions.clickWhenVisible(labelNotermPlanType);
		}
		//reusableActions.clickWhenVisible(By.xpath("//dsa-selection[contains(@data-test,'stepper-1-edit-step-selection-option-')]//label[@aria-label='"+planType+"']"));
		reusableActions.clickWhenVisible(btnContinueDeviceCost);
		reusableActions.staticWait(15000);
	}

	/**
	 * This method clicks on continue button in downgrade fee modal
	 * @author praveen.kumar7
	 */
	public void verifyDowngradeFeeModalAndClkContinue() {
		reusableActions.waitForElementVisibility(btnDowngradeFeeModalConitnue,30);
		reusableActions.clickWhenVisible(btnDowngradeFeeModalConitnue);
	}

	/**
	 * This method clicks on continue button in addon removal modal if present
	 * @author praveen.kumar7
	 */
	public void clkContinueOnExistingAddonModal() {
		if(reusableActions.isElementVisible(btnExistingAddonModalContinue)) {
			reusableActions.executeJavaScriptClick(btnExistingAddonModalContinue);
		}
	}

	/**
	 * This method clicks on NOTERM accessory cost option
	 * @author praveen.kumar7
	 */
	public void selectNoTermAccessoryCost() {
		reusableActions.clickWhenReady(labelNotermPlanType);
	}

	/**
	 * This method clicks on continue button in accessories cost selection stepper
	 * @author praveen.kumar7
	 */
	public void clkContinueAccessoriesCostSelection() {
		reusableActions.clickWhenVisible(btnContinueAccessoriesCost);
	}

	/**
	 * This method clicks on continue button in device protection modal if present
	 * @author praveen.kumar7
	 */
	public void clkContinueDeviceProtection() {
		if (reusableActions.isElementVisible(btnContinueDeviceProtection,10)) {
			reusableActions.clickWhenVisible(btnContinueDeviceProtection, 5);
		}
	}

	/**
	 * This method clicks on continue button in caller ID stepper
	 * @author praveen.kumar7
	 */
	public void clkCallerIdContinueBtn() {
		reusableActions.waitForElementVisibility(callerIDContinue,30);
		reusableActions.clickWhenVisible(callerIDContinue,10);
	}

	/**
	 * This method verifies if plan config page is loaded successfully
	 * @return true if plan config page is loaded, else false
	 */
	public boolean verifyPlanConfigPage() {
		reusableActions.waitForElementTobeClickable(btnCartSummary, 50);
		return reusableActions.isElementVisible(btnCartSummary);
	}

	/**
	 * Clicks on the 'Promo Section' to enter Promo code
	 * @author Subash.Nedunchezhian
	 */
	public void clkPromoSection() {
		reusableActions.staticWait(15000);
		reusableActions.waitForElementVisibility(promoSection, 20);
		reusableActions.clickWhenReady(promoSection);
	}

	/**
	 * Enter the Promo code on Promo Input Field
	 * @param promoCode Promo code from yaml file
	 * @author Subash.Nedunchezhian
	 */
	public void setPromoCode(String promoCode) {
		//reusableActions.executeJavaScriptClick(promoCodeField);
		reusableActions.getWhenReady(promoCodeField,20).click();
		reusableActions.getWhenReady(txtPromoCode,30).click();
		txtPromoCode.sendKeys(promoCode);
	}

	/**
	 * Clicks on the 'Check' button to verify the Promo code
	 * @author Subash.Nedunchezhian
	 */
	public void clkCheckPromoBtn(){
		reusableActions.waitForElementVisibility(btnCheckPromo);
		reusableActions.clickWhenReady(btnCheckPromo);
	}

	/**
	 * Validates the Success message of the Promotion
	 * @return true if the 'PromoCode added to Cart' message displayed; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyPromoSuccessMsg() {
		return reusableActions.isElementVisible(promoCodeSuccessMsg, 60);
	}

	/**
	 * Clicks on the Continue button in Promo Modal
	 * @author Subash.Nedunchezhian
	 */
	public void clickContinuePromoModal(){
		reusableActions.isElementVisible(promoCodeSuccessMsg);
		reusableActions.clickWhenReady(continueBtnPromo);
	}

	/**
	 * Validates the Line Item of the Promotion in cart summary
	 * @return true if the Promo code and discount amount line item displayed; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyCartLineItem(){
		reusableActions.javascriptScrollByVisibleElement(promoCartLineItem);
		return reusableActions.isElementVisible(promoCartLineItem);
	}

	/**
	 * Validates the Discount Value and Duration of the Promotion
	 * @return true if the 'Discount Value and Duration' message displayed; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyPromoDuration(){
		return reusableActions.isElementVisible(promoCodeDuration);
	}

	/**
	 * Clicks on the 'Delete' button to remove the applied Promo code
	 * @author Subash.Nedunchezhian
	 */
	public void clickDeletePromo(){
		reusableActions.isElementVisible(deletePromo);
		reusableActions.clickWhenReady(deletePromo);
	}

	/**
	 * This method clicks on Device Protection Tab in Add-ons stepper
	 * @author Subash.Nedunchezhian
	 */
	public void selectDeviceProtectionAddon(){
		reusableActions.executeJavaScriptClick(deviceProtectionAddonTab);
		reusableActions.clickWhenReady(deviceProtectionAddon,20);
	}

	/**
	 * This method verifies the Device Protection Add-on added to Cart
	 * @return True if Device Protection Line Item is displayed in Cart summary; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyDPCartLineItem(){
		reusableActions.javascriptScrollByVisibleElement(dpAddonCarLineItem);
		return reusableActions.isElementVisible(dpAddonCarLineItem);
	}

	/**
	 * This method will get the Device Protection Addon amount from the cart summary
	 * @return String having Device Protection Addon and amount
	 * @author subash.nedunchezhian
	 */
	public String getDeviceProtectionAddon() {
		return dpAddonCarLineItem.getText().replaceAll("\\n", "");
	}

	/**
	 * This method clicks on Device Protection Tab in BYOD Add-ons stepper
	 * @author Subash.Nedunchezhian
	 */
	public void selectBYODdpAddon() {
		reusableActions.executeJavaScriptClick(deviceProtectionAddonTab);
		reusableActions.clickWhenReady(BYODdpAddon);
	}

	/**
	 * This method enters the IMEI/TacCode on IMEI Input Field
	 * @param tacCode IMEI/TacCode from yaml file
	 * @author Subash.Nedunchezhian
	 */
	public void enterDPIMEI(String tacCode) {
		reusableActions.clickWhenReady(dpimeiField, 20);
		reusableActions.getWhenReady(inputDPIMEI, 20).sendKeys(tacCode + FormFiller.generateRandomNumber(7));
		reusableActions.clickWhenReady(dpIMEIContinue);
	}

	/**
	 * This method selects the Device storage from the Storage Drop-down field
	 * @param dpStorage Storage from yaml file
	 * @author Subash.Nedunchezhian
	 */
	public void setDPDeviceStorage(String dpStorage) {
		reusableActions.clickWhenReady(inputDeviceStorage);
		reusableActions.selectWhenReady(inputDeviceStorage, dpStorage);
	}

	/**
	 * This method selects the Device color from the Color Drop-down field
	 * @param dpColor Color from yaml file
	 * @author Subash.Nedunchezhian
	 */
	public void setDPDeviceColor(String dpColor) {
		reusableActions.clickWhenReady(inputDeviceColor);
		reusableActions.selectWhenReady(inputDeviceColor, dpColor);
	}

	/**
	 * This method click on Check/Get My Quote button to validate Device Protection Eligibility of the IMEI
	 * @author Subash.Nedunchezhian
	 */
	public void clkDpEligCheckBtn() {
		reusableActions.clickWhenReady(imeiEligCheckBtn);
	}

	/**
	 * This method validates the Device Protection Eligibility(Success) message of the IMEI
	 * @return true if the 'Your device is eligible' message displayed; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyEligibilityMsg() {
		return reusableActions.isElementVisible(imeiSuccessEligibleMsg);
	}
	/**
	 * This method validates the Device Protection Not Eligibile(Failure) message of the IMEI
	 * @return true if the 'Your device is Not eligible' message displayed; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyNotEligibleMsg(){
		return reusableActions.isElementVisible(imeiNotEligibleMsg);
	}
	/**
	 * This method click on No Device Protection option in Add-on stepper
	 * @author Subash.Nedunchezhian
	 */
	public void selectNoDeviceProtection(){
		reusableActions.clickWhenReady(byodNoDeviceProtection);
	}

	/**
	 * This method gets Regular Promo Discount value and Promo Duration text on Device Config page
	 * @return Regular Promo Discount value and Promo Duration text
	 * @author subash.nedunchezhian
	 */
	public String getRegularPromoName(){
		return regularPromoDetail.getText().replaceAll("\\n", "");
	}

	/**
	 *
	 */
	public void differentPlanSelectionModal(){
		reusableActions.clickIfAvailable(continueSelectedPlan, 5);
	}

}