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
import utils.FormFiller;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


public class FidoBuildPlanPage extends BasePageClass {

	public String xpath;
	public int stepper;
	String planType = TestDataHandler.tc17AALTabletsStandardShipping.getNewPlanType();

	public FidoBuildPlanPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath = "(//div[@class='features-section' or @class='features-section dataSectionEmpty']/button)[3]")
	WebElement btnAdd;
	
	@FindBy(xpath = "//button[@translate='_continue']")
	WebElement btnContinue;
	
	////f-cart-summary//button[contains(@class,'-primary -large') or @id='main-continue-button']//span[contains(@class,'ds-no-overflow mw-100')]
	//@FindBy(xpath = "//button[@id='main-continue-button']")
	@FindBy(xpath = "//button[@class='w-100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large' or @data-test='build-plan-checkout-flow-button']")
	WebElement btnContinueBelowCartSummary;

	@FindBy(xpath="//input[@id='email' or (contains(@formcontrolname,'email') and  not(contains(@formcontrolname,'Confirm')))]/parent::div")
	WebElement txtEmail;
	
	@FindBy(xpath = "//label[@aria-label='NOTERM_false']")
	WebElement lblNoTermTierDeviceCost;

	@FindBy(xpath = "//ds-checkbox[@data-test='keep-current-plan-checkbox']//label")
	WebElement keepMyCurrentPlanButton;

	@FindBy(xpath="//ds-checkbox[@data-test='vdp-checkbox']")
	WebElement vdpCheckBox;

	@FindBy(xpath = "//div[contains(@class,'ds-radioLabel') and contains(.,'full')]/parent::label")
	WebElement noTermRadioBtn;

	@FindBy(xpath = "//button[contains(@data-test,'stepper-1-edit-step-continue')]")
	WebElement btnContinueDeviceCost;

	@FindBy(xpath = "//button[contains(@data-test,'stepper-2-edit-step-continue')]")
	WebElement btnContinuePlanStepper;

	@FindAll({
		@FindBy(xpath = "//button[contains(@title,'Continue to')]"),
		@FindBy(xpath = "//ds-modal[contains(@data-test,'upfront-edge-return-modal')]//button[contains(@title,'Continue')]")
	})
	WebElement deviceBalancePopUp;

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
	
	List<String> planCategory = Arrays.asList("category-SMALL","category-MEDIUM","category-LARGE","category-EXTRALARGE","category-2XLARGE");
	
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

	@FindBy(xpath = "//span[contains(@class,'m-navLink__chevron')]/parent::a[@role='button']")
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
			String xpathDataOption = createXpath(stepper,dataOptionIndex);
			By dataOptionXpath = By.xpath(xpathDataOption);
			//reusableActions.staticWait(5000);
			reusableActions.javascriptScrollToTopOfPage();
			reusableActions.clickIfAvailable(dataOptionXpath,10);
			if(className.toUpperCase().contains("_PPC_") && className.toUpperCase().contains("DOWNGRADE") && !(Integer.parseInt(dataOptionIndex)==0)) {
				verifyDowngradeFeeModalAndClkContinue();
			}
			else if(className.toUpperCase().contains("_PPC_") && !(className.toUpperCase().contains("DOWNGRADE"))) {
				reusableActions.waitForElementTobeClickable(btnContinueDataOption,40);
			}
			reusableActions.clickWhenReady(btnContinueDataOption, 30);
		} else {
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
		reusableActions.clickWhenReady(btnBasicPlan,20);
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

}