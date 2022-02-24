package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FormFiller;

import java.util.ArrayList;
import java.util.List;

public class RogersPlanConfigPage extends BasePageClass {
    public String xpathDeviceName;

    public RogersPlanConfigPage(WebDriver driver) {
        super(driver);
    }

    String xpathDcDoTo;
    String dataProtectionOption;

    @FindBy(xpath = "(//label[contains(@class,'ds-radioLabel')])[2]")
    WebElement noTermRadioBtn;

    @FindBy(xpath = "(//div[contains(@id,'ds-radio-input-id')])[1]")
    WebElement financingRadioBtn;

    @FindBy(xpath = "//button[@data-test='stepper-2-edit-step-continue-button']/preceding-sibling::button")
    WebElement showMoreDetails;

    @FindBy(xpath = "//ds-selection[contains(@data-test,'stepper-1-edit-step-selection-option-')]//label[1]")
    List<WebElement> noOfDeviceTiers;

    @FindAll({
            @FindBy(xpath = "//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-infinite-')]//label[1]"),
            @FindBy(xpath = "//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-individual-')]//label[1]"),
            @FindBy(xpath = "//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-talkAndText-')]")
    })
    List<WebElement> noofDataOptions;

    @FindBy(xpath = "//ds-selection[contains(@data-test,'stepper-3-edit-step-selection-option-')]//label[1]")
    List<WebElement> noOfTalkOptions;

    @FindBy(xpath = "//span[text()='Monthly device financing payment' or text()='Paiement mensualité']")
    WebElement financingOptionCheck;

    @FindBy(xpath = "//span[contains(text(),'with Upfront') or contains(text(),'avec Voie')]")
    WebElement upfrontOptionCheck;

    @FindBy(xpath = "//button[contains(@class,'active text-semi')]")
    WebElement deviceProtectiontab;

    @FindBy(xpath = "//button[contains(@class,'active text-semi')]//following-sibling::button")
    WebElement longDistancetab;

    @FindBy(xpath = "//nav[@class='ds-breadcrumb']")
    WebElement breadCrumb;

    @FindBy(xpath = "(//div[contains(@class,'dsa-orderTable')])[1]")
    WebElement monthlyFeesCartSummarySection;

    @FindBy(xpath="//p[contains(.,'Financing options')]")
    WebElement txtFinancingOptions;

    @FindBy(xpath = "//button[@data-test='stepper-1-edit-step-continue-button']")
    WebElement preCartDeviceCostContinueButton;

    @FindBy(xpath = "//button[@data-test='stepper-2-edit-step-continue-button']")
    WebElement preCartDataOtionContinueButton;

    @FindBy(xpath = "//button[@data-test='stepper-3-edit-step-continue-button']")
    WebElement preCartTalkOptionContinueButton;

    @FindBy(xpath = "//button[@data-test='stepper-4-edit-step-continue-button']")
    WebElement preCartAddonsContinueButton;

    @FindBy(xpath = "//ds-form-field[@data-test='caller-id-first-name']")
    WebElement frmCallerIdFirstName;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement setFirstName;

    @FindBy(xpath = "//ds-form-field[@data-test='caller-id-last-name']")
    WebElement frmCallerIdLastName;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement setLastName;

    @FindBy(xpath = "//button[contains(@data-test,'stepper-5')]")
    WebElement continueCallerID;

    @FindBy(xpath = "//div[contains(@class,'ds-step__content ds-border-bottom ds-brcolor-concrete p-16 p-md-24 ds-bgcolor-misty')]//button[contains(@class,'primary -large')]")
    WebElement preCartSummaryContinueButton;

    @FindBy(xpath = "//div[contains(@class,'ds-step__hide ng-trigger ng-trigger-bodyExpansion ds-step__show')]//button[contains(@class,'primary -large')]")
    WebElement preCartSummaryContinueButtonTalkOptions;

    @FindBy(xpath = "//ds-step[@id='stepper-addons']//div[contains(@class,'d-flex flex-row-reverse')]//button")
    WebElement preCartSummaryContinueButtonAddOns;

    @FindBy(xpath = "//button[@data-test='build-plan-checkout-flow-button']")
    WebElement continueButtonOnCartSummary;

    @FindBy(xpath = "//button[contains(@data-test,'bpo-offer-modal') or @id='get-bpo-offer-button']")
    WebElement getBPOOffer;

    @FindAll({
            @FindBy(xpath = "//button[@data-test='bpo-offer-modal-button-primary']"),
            @FindBy(xpath = "//button[@id='Skip the Offer']"),
            @FindBy(xpath = "//div[@class='ds-modal__footer mb-24 mb-sm-40']//button[contains(@class,'-tertiary -large')]")
    })
    WebElement skipBPOOfferOnDeviceProtection;

    @FindBy(xpath = "//div[@class='d-flex flex-row']")
    List<WebElement> buildPlanDetails;

    @FindBy(xpath = "//div[contains(@class,'dsa-orderTable__row')]")
    List<WebElement> cartSummaryElements;

    @FindBy(xpath = "(//div[contains(@class,'dsa-orderTable__totalRow')])[1]")
    WebElement monthlyFeesAmount;

    @FindBy(xpath = "(//div[contains(@class,'dsa-orderTable__totalRow')])[2]")
    WebElement oneTimeFeesAmount;

    //@FindBy(xpath = "//p[contains(text(),'1.')]//following-sibling::r-data-block-selection//input[@checked='checked']//following-sibling::span//span[contains(@class,'dsa-selection__caption')]")
    @FindBy(xpath = "//p[contains(text(),'1.')]/./following-sibling::div/div[@class='pb-16 ng-star-inserted']//input[@checked='checked']//following-sibling::span//span[contains(@class,'dsa-dataBlock__tileLeftFeatureInfo text-body-sm ds-color-grey ng-star-inserted')]")
    WebElement priceForSelectedDeviceCost;

    //@FindBy(xpath = "//div[@class='dsa-promoBlock ds-bgcolor-misty ng-star-inserted']")
    @FindBy(xpath = "//div[@class='dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty']")
    WebElement promoBlock;

    @FindBy(xpath = "//div[@class='dsa-dataBlock']//div[contains(text(), 'upfront savings') or contains(text(),'sur le montant initial')]")
    WebElement tierLabel;

    @FindAll({
            @FindBy(xpath = "//span[contains(text(),' Téléphones ') or contains(text(),' Phones Preview - QA1 ')]"),
            @FindBy(xpath = "//span[contains(text(),'Appareils') or contains(text(),'Devices')]")
    })
    WebElement devicesInBreadCrumb;

    @FindBy(xpath = "//span[contains(text(),'Créer forfait') or contains(text(),'Build Plan')]")
    WebElement buildPlanInBreadCrumb;

    @FindBy(xpath = "//span[contains(text(),'No Device Protection') or contains(text(),'Aucune protection de l’appareil')]")
    WebElement noDeviceProtection;

    @FindBy(xpath = "//button[@id='ds-stepper-id-1-editButtonId-1']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']")
    WebElement editButtonDeviceCost;

    @FindBy(xpath = "//span[contains(text(),'Plans') or contains(text(),'Forfaits')]")
    WebElement plansInBreadCrumb;

    @FindBy(xpath = "//span[contains(text(),'Apportez votre propre appareil') or contains(text(),'Bring Your Own Device')]")
    WebElement bringYourOwnDeviceInBreadCrumb;

    @FindBy(xpath = "//ds-checkbox//div[@class='ds-checkbox__box my-12']")
    WebElement checkBoxKeepMyCurrentPlan;

    @FindBy(xpath = "//ds-modal")
    WebElement modalToDoWithOldPhone;

    @FindBy(xpath = "//ds-modal//button[contains(@title,'Continue')]")
    WebElement btnContinueOnModalToDoWithOldPhone;

    @FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]/parent::ds-checkbox")
    List<WebElement> checkBoxAdditionalLineOPtion;

    @FindBy(xpath = "//button[contains(@data-test,'add-to-cart')]")
    WebElement btnAddToCart;

    @FindBy(xpath = "//button[contains(@id,'main-continue-button')]")
    WebElement btnProceedToCheckout;

    @FindBy(xpath = "//p[contains(.,'Basic Plans') or contains(.,'De base')]/ancestor::button")
    WebElement btnBasicPlan;

    @FindBy(xpath = "//p[contains(@data-test,'stepper-2-completed')]/following-sibling::div//p")
    WebElement planData;

    @FindBy(xpath = "//ds-checkbox[@data-test='vdp-checkbox']")
    WebElement vdpCheckBox;

    @FindBy(xpath = "//div[contains(@class,'dsa-infoWidget__ctnInfo')]//span[contains(@class,'dsa-infoWidget__ctnCopy')]")
    WebElement infoWidgetCtnCopy;

    @FindBy(xpath = "//button[@data-test='stepper-0-edit-step-continue-button']")
    WebElement btnChangePlan;

    @FindBy(xpath = "//ds-modal[@data-test='ppc-sharedNonShared-modal']")
    WebElement ppcSharedNonSharedModal;

    @FindBy(xpath = "//label[contains(@class,'dsa-selection')][contains(.,'existing') or contains(.,'actuel')]")
    WebElement lblSelectExistingPlan;

    @FindBy(xpath = "//label[contains(@class,'dsa-selection')][contains(.,'Create a shared plan') or contains(.,'forfait partagé')]")
    WebElement lblSelectSharedPlan;

    @FindBy(xpath = "//button[@data-test='shared-nonshared-continue']")
    WebElement btnPPCShareNonShareContune;

    @FindBy(xpath = "//p[contains(.,'Individu')]")
    WebElement txtIndividualTab;

    @FindBy(xpath = "//button[@data-test='ppc-ctnSelection-modal-add']")
    WebElement btnAddInModal;

    @FindBy(xpath = "//button[@data-test='ppc-choosePrimaryLine-modal-Continue']")
    WebElement btnSelectPrimaryLineModalContinue;

    @FindBy(xpath = "//h1[contains(.,'Select Plan Options') or contains(.,'Sélectionner un forfait')]")
    WebElement titleAdditionalLinePage;

    @FindBy(xpath = "//select[@data-test='additional-plan-types-option']")
    WebElement planTypeDropDown;

    @FindBy(xpath="//button[contains(@class,'plan-dropdown')]")
    WebElement dataDropDown;

    @FindBy(xpath = "//select[@data-test='additional-talk-option']")
    WebElement talkDropDown;

    @FindBy(xpath = "//button[@data-test='downgrade-modal-proceed']")
    WebElement btnDowngradeFeeModalConitnue;

    @FindBy(xpath = "//button[@data-test='addons-removal-modal-button-primary']")
    WebElement btnExistingAddonModalContinue;

    @FindBy(xpath = "//input[@value='FIN_DATA_TALK_TEXT']/..")
    WebElement labelDTTPlanType;

    @FindBy(xpath = "//input[@value='FIN_TALK_TEXT']/..")
    WebElement labelTTPlanType;

    @FindBy(xpath = "//input[@value='NOTERM']/..")
    WebElement labelNotermPlanType;

    @FindBy(xpath = "//button[contains(@class,'dsa-cartSummary')]")
    WebElement btnCartSummaryDropDown;

    @FindBy(xpath = "//button[@data-test='stepper-5-edit-step-continue-button']")
    WebElement btnContinueAccessoriesCost;

    @FindBy(xpath = "//button[contains(@title,'Add Premium')]/preceding-sibling::button")
    WebElement btnContinueDeviceProtection;

    @FindBy(xpath = "//p[@data-test='stepper-2-edit-step-label']")
    WebElement txtSelectDataOption;

    @FindBy(xpath = "//div[@id='ds-stepper-id-1-completedContent-2']")
    WebElement completedDataOptionStepper;

    @FindBy(xpath = "//span[contains(text(),'Have a promo code') or contains(text(),'code promotionnel')]")
    WebElement promoSection;

    @FindBy(xpath = "//div[contains(@class,'ds-formField__wrapper')]/ancestor::ds-form-field")
    WebElement promoCodeField;

    @FindBy(xpath = "//input[contains(@class,'ds-input') and contains(@id,'ds-form-input-id')]")
    WebElement txtPromoCode;

    @FindBy(xpath = "//button[contains(@data-test,'promo-button-check') and contains(text(),'Check') or contains(text(),'Vérifier')]")
    WebElement btnCheckPromo;

    @FindBy(xpath = "//span[contains(@class,'text-body') and contains(text(),'added to cart') or contains(text(),' ajouté au panier')]")
    WebElement promoCodeSuccessMsg;

    @FindBy(xpath = "//span[contains(@class,'text-body') and contains(text(),'with promo code') or contains(text(),'avec le code promotionnel')]")
    WebElement promoCodeDuration;

    @FindBy(xpath = "//span[contains(text(),'Promo code:') or contains(text(),'Code promotionnel :')]//ancestor::div[contains(@class,'dsa-orderTable__row')]")
    WebElement promoCartLineItem;

    /**
     * Select Device Protection Header on Plan config page
     */
    public void selectDeviceProtectionHeaderTab() {
        getReusableActionsInstance().clickIfAvailable(deviceProtectiontab);
    }

    /**
     * This method verifies if the selected device section is displayed for selected device
     * @param deviceName String value of the device
     * @return a boolean true if selected device section is displayed else returns false
     * @author praveen.kumar7
     */
    public boolean verifySelectedDeviceSection(String deviceName) {
       return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'completed')]//p[contains(.,'" +deviceName+ "')]"),40);
    }

    /**
     * This method verifies if the selected device section is displayed for BYOD
     * @return a boolean true if BYOD device section is displayed else returns false
     * @author praveen.kumar7
     */
    public boolean verifyByodSelectedDeviceSection() {
        return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'completed')]//p[contains(.,'Bring') or contains(.,'Apportez')]"));
    }

    /**
     * Clicks on NO TERM radio button in device cost stepper
     * @author praveen.kumar7
     */
    public void clkRadioButtonNoTerm() {
        getReusableActionsInstance().waitForElementVisibility(txtFinancingOptions,30);
        getReusableActionsInstance().scrollToElement(txtFinancingOptions);
        getReusableActionsInstance().clickWhenVisible(noTermRadioBtn);
    }

    /**
     * Clicks on Show More details to expand Data stepper
     * @author praveen.kumar7
     */
    public void clickShowMoreDetails() {
        if(getReusableActionsInstance().isElementVisible(showMoreDetails,20)) {
            if (getReusableActionsInstance().getWhenReady(showMoreDetails).getAttribute("title").contains("Hide More Details")) {
                System.out.println("Show more details accordion already in expanded state");
            } else {
                getReusableActionsInstance().clickWhenVisible(showMoreDetails, 20);
            }
        }
    }

    /**
     * Creates an xpath for the provided stepper with index value which is passed as parameter
     * @param dC_DO_TO string value of device cost, data option and talk option stepper
     * @param stepper String value of the stepper index
     * @return String value of an xpath
     * @author praveen.kumar7
     */
    public String createXpathWithInputData(String dC_DO_TO,int stepper) {
        if (stepper == 1) {
            return xpathDcDoTo = "//ds-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + dC_DO_TO + "')]//label[1]";
        }
        else if (stepper == 2) {
            return xpathDcDoTo = "//ds-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-infinite-" + dC_DO_TO + "')]//label[1]";
        }
        else if(stepper == 3) {
            return xpathDcDoTo = "//ds-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + dC_DO_TO + "')]//label[1]";
        }
        else {
            return xpathDcDoTo = "//ds-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + dC_DO_TO + "')]//label[1]";
        }
    }

    /**
     * This method creates Xpath for protection plan
     *
     * @return returns a String value having xpath for the protection plan
     * @param    protectionPlanDetails : String value of protection plan
     * @author saurav.goyal
     */
    public String createXpathWithInputDataForProtectionPlan(String protectionPlanDetails) {
        //String xpathProtectionPlan = "//span[contains(text(),'" + protectionPlanDetails + "')]/ancestor::span";
        String xpathProtectionPlan = "//span[contains(text(),'" + protectionPlanDetails + "')]";
        return xpathProtectionPlan;
    }

    /**
     * This method sets the value for deviceCostIndex
     * @param deviceCostIndex String value of deviceCostIndex
     * @return returs the String value of index
     * @author praveen.kumar
     */
    public String getUpdatedDeviceCostIndex(String deviceCostIndex) {
        if((deviceCostIndex == null) || (deviceCostIndex.isEmpty()) || (Integer.parseInt(deviceCostIndex) > noOfDeviceTiers.size()-1)) {
            deviceCostIndex="0";
            return deviceCostIndex;
        }
        return deviceCostIndex;
    }

    /**
     * This method sets the value for dataOptionIndex
     * @param dataOptionIndex String value of dataOptionIndex
     * @return returns the String value of index
     * @author praveen.kumar
     */
    public String getupdatedDataOptionIndex(String dataOptionIndex) {
        if ((dataOptionIndex == null) || (dataOptionIndex.isEmpty()) || (Integer.parseInt(dataOptionIndex) > noofDataOptions.size()-1)) {
            dataOptionIndex = "0";
            return dataOptionIndex;
        }
        return dataOptionIndex;
    }

    /**
     * This method selects the individual data option and click on continue
     * @param dataOptionIndex String value of dataOptionIndex
     * @author praveen.kumar7
     */
    public void selectNonShareDataAndClkContinue(String dataOptionIndex) {
        if(Integer.parseInt(dataOptionIndex) == 0) {
            getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton, 30);
        }
        else {
            getReusableActionsInstance().clickWhenVisible(By.xpath("//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-individual-" + dataOptionIndex + "')]//label[1]"),40);
            getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton,40);
        }
    }

    /**
     * This method sets the value for talkOptionIndex
     * @param talkOptionIndex String value of talkOptionIndex
     * @return returs the String value of index
     * @author praveen.kumar7
     */
    public String getupdatedTalkOptionIndex(String talkOptionIndex) {
        if ((talkOptionIndex == null) || (talkOptionIndex.isEmpty()) || (Integer.parseInt(talkOptionIndex) > noOfTalkOptions.size()-1)) {
            talkOptionIndex = "0";
            return talkOptionIndex;
        }
        return talkOptionIndex;
    }

    /**
     * Select Device Cost tier on Plan config page and clicks on continue button
     * @param    deviceCostIndex : String value of Device Cost to be selected
     * @author praveen.kumar7
     */
    public void selectDeviceCostAndClickOnContinueButton(String deviceCostIndex) {
        int stepper = 1;
        String xpathDcDoTo = createXpathWithInputData(deviceCostIndex, stepper);
        if (Integer.parseInt(deviceCostIndex) == 0) {
            getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton, 30);
        } else {
            getReusableActionsInstance().clickWhenVisible(By.xpath(xpathDcDoTo), 60);
            getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton, 30);
        }
    }

    /**
     * Select No term Device Cost on Plan config page
     *
     * @author saurav.goyal
     */
    public void setCheckBoxKeepMyCurrentPlan() {
        getReusableActionsInstance().clickWhenReady(checkBoxKeepMyCurrentPlan, 30);
    }

    /**
     * Select data option on Plan config page
     * @param    dataOptionIndex : String value of data option to be selected
     * @author praveen.kumar7
     */
    public void selectDataOptionAndClickonContinueButton(String dataOptionIndex, String className) {
        if(noofDataOptions.size()!=1) {
            int stepper = 2;
            String xpathDcDoTo = createXpathWithInputData(dataOptionIndex, stepper);
            if (Integer.parseInt(dataOptionIndex) == 0) {
                getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton, 20);
            } else {
                getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo), 20));
                if (className.toUpperCase().contains("_PPC_") && className.toUpperCase().contains("DOWNGRADE")) {
                    getReusableActionsInstance().waitForElementTobeClickable(btnDowngradeFeeModalConitnue, 40);
                    getReusableActionsInstance().clickWhenReady(btnDowngradeFeeModalConitnue, 5);
                }
                else if(className.toUpperCase().contains("_PPC_")) {
                    getReusableActionsInstance().waitForElementTobeClickable(preCartDataOtionContinueButton, 40);
                    getReusableActionsInstance().staticWait(2000);
                }
                getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton);
            }
        }
        else {
            getReusableActionsInstance().clickIfAvailable(preCartDataOtionContinueButton,5);
        }
    }

    /**
     * This menthod selects basic plan based on the index value
     * @param dataOptionIndex : String value of data option to be selected
     * @author praveen.kumar7
     */
    public void selectBasicPlanAndClkContinueBtn(String dataOptionIndex) {
        getReusableActionsInstance().clickWhenVisible(By.xpath("//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-basic-"+dataOptionIndex+"')]//label"),20);
        getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton,20);
    }

    /**
     * This menthod selects basic plan based on the index value
     * @param dataOptionIndex : String value of data option to be selected
     * @author praveen.kumar7
     */
    public void selectBasicIndividualPlanAndClkContinueBtn(String dataOptionIndex) {
        getReusableActionsInstance().clickWhenVisible(By.xpath("//ds-selection[contains(@data-test,'stepper-2-edit-step-selection-option-individual-"+dataOptionIndex+"')]//label"),20);
        getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton,20);
    }

    /**
     * Select data option on Plan config page
     *
     * @return true if the difference between dataStrikedPriceValue and dataNonStrikedPriceValue is 1000 for MSF in gerenal it should be 10.00 but we have removed dot from that
     * @param    dataOption : String value of data option to be selected
     * @author saurav.goyal
     */
    public boolean verifyDataOptionMSFValue(String dataOption) {
        final String dataStrikedPrice;
        final String dataNonStrikedPrice;
        final int dataStrikedPriceValue;
        final int dataNonStrikedPriceValue;
        if (dataOption != null) {
            xpathDcDoTo = createXpathWithInputData(dataOption,3);
            List<WebElement> noOfTiers = getDriver().findElements(By.xpath(xpathDcDoTo));
            if (noOfTiers.size() == 1) {
                dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']")).getText();
                dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//p[@class='text-body-lg text-semi mb-0 ng-star-inserted']")).getText();
                dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
                dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
                if (dataStrikedPriceValue - dataNonStrikedPriceValue == 1000)
                    return true;
                else
                    return false;
            } else {
                dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(By.xpath(xpathDcDoTo + "[1]") + "//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']")).getText();
                dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//p[@class='text-body-lg text-semi mb-0 ng-star-inserted']")).getText();
                dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
                dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
                if (dataStrikedPriceValue - dataNonStrikedPriceValue == 1000)
                    return true;
                else
                    return false;

            }
        } else {
            xpathDcDoTo = "//p[contains(text(),'2.')]//following-sibling::div//div[@class='pb-16 ng-star-inserted'][1]//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']";
            dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo)).getText();
            dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//following-sibling::p")).getText();
            dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
            dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
            if (dataStrikedPriceValue - dataNonStrikedPriceValue == 1000)
                return true;
            else
                return false;

        }
    }

    /**
     * Selects talk option and verifies if addons stepper continue button is displayed
     * @param talkOptionIndex : String value of talk option to be selected
     * return boolean true if continue button is displayed in addons stepper else false
     * @author praveen.kumar7
     */
    public boolean verifyTalkOptionSelectionAndAddonsContinueButton(String talkOptionIndex) {
        clickGetBPOOffer();
        int stepper = 3;
        String xpathDcDoTo = createXpathWithInputData(talkOptionIndex, stepper);
        if(Integer.parseInt(talkOptionIndex) == 0) {
            getReusableActionsInstance().clickIfAvailable((preCartTalkOptionContinueButton),20);
        }
        if(Integer.parseInt(talkOptionIndex) == 1) {
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo),30);
            getReusableActionsInstance().clickIfAvailable(preCartTalkOptionContinueButton);
        }
        clickGetBPOOffer();
        return getReusableActionsInstance().isElementVisible(preCartAddonsContinueButton,30);
    }

    /**
     * This method creates Xpath for device protection option
     *
     * @param dataProtectionOption : String value of data protection option
     * @return returns a String value having xpath for data protection option
     * @author saurav.goyal
     */
    public String createXpathforDataProtectionOption(String dataProtectionOption) {
        dataProtectionOption = "//label[@class='dsa-radio']//span[text()='" + dataProtectionOption + "']";
        return dataProtectionOption;
    }

    /**
     * This method will Click Data Protection on Plan config page
     *
     * @param dataProtectionOption : String for the data Protection plan option
     * @author saurav.goyal
     */
    public void clickOptionInDataProtection(String dataProtectionOption) {
        if (dataProtectionOption != null && !dataProtectionOption.isEmpty()) {
            xpathDcDoTo = createXpathWithInputDataForProtectionPlan(dataProtectionOption);
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
        } else
            getReusableActionsInstance().clickIfAvailable(noDeviceProtection, 10);
    }

    /**
     * Verify tooltip in Data protection on Plan config page
     *
     * @param dataProtectionOption : This will verify the tooltip for the data protection option
     * @return String having tooltip value for that particular data protection option
     * @author saurav.goyal
     * check facing some issues
     */
    public String verifyToolTipInDataProtection(String dataProtectionOption) {
        String xpathProtectionPlan = createXpathWithInputDataForProtectionPlan(dataProtectionOption);
        return getReusableActionsInstance().getTitle(getDriver().findElement(By.xpath(xpathProtectionPlan))).trim();
    }

    /**
     * Click continue on Plan config page before cart summary
     *
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButton, 5);
    }

    /**
     * Click continue on modal what would you like to do with your old phone
     *
     * @author saurav.goyal
     */
    public void clickContinueOnModalToDoWithOldPhone() {
        if (getReusableActionsInstance().isElementVisible(modalToDoWithOldPhone, 10))
            getReusableActionsInstance().clickWhenReady(btnContinueOnModalToDoWithOldPhone, 5);
    }

    /**
     * Click continue on Plan config page before cart summary
     *
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButtonTalkOptions() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButtonTalkOptions, 5);
    }

    /*public boolean verifyFinancingRadioBtnIsSelected() {
        getReusableActionsInstance().isElementVisible(financingRadioBtn,30);
        getReusableActionsInstance().getWhenReady(c)
    }*/

    /**
     * This method clicks on downpaymment checkbox in device cost stepper
     * @author praveen.kumar7
     */
    public void clkDownPaymentChkBox() {
        getReusableActionsInstance().clickWhenReady(vdpCheckBox,30);
    }

    /**
     * Click continue on Device Cost Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartDeviceCostContinueButton() {
        getReusableActionsInstance().waitForElementVisibility(btnCartSummaryDropDown,50);
        getReusableActionsInstance().clickWhenReady(preCartDeviceCostContinueButton);
        getReusableActionsInstance().clickIfAvailable(btnContinueOnModalToDoWithOldPhone, 10);
    }

    /**
     * Click continue on Data Option Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartDataOptionContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartDataOtionContinueButton);
    }

    /**
     * Click continue on Talk Option Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartTalkOptionContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartTalkOptionContinueButton,10);
    }

    /**
     * Click continue on Addons Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartAddonsContinueButton() {
        clickGetBPOOffer();
        getReusableActionsInstance().clickIfAvailable(preCartAddonsContinueButton);
        clickGetBPOOffer();
    }

    /**
     * This method set the callerID details and clicks on continue button
     * @author praveen.kumar7
     */
    public void setUserNameCallerID() {
        getReusableActionsInstance().staticWait(3000);
        getReusableActionsInstance().executeJavaScriptClick(setFirstName);
        setFirstName.sendKeys(FormFiller.generateRandomName()+FormFiller.generateRandomName());
        getReusableActionsInstance().executeJavaScriptClick(setLastName);
        setLastName.sendKeys(FormFiller.generateRandomName()+FormFiller.generateRandomName());
        getReusableActionsInstance().clickWhenReady(continueCallerID, 30);
        clickGetBPOOffer();
    }

    /**
     * This method clicks on continue button in callerID
     * @author praveen.kumar7
     */
    public void clkCallerIDContinueBtnForTablet() {
        getReusableActionsInstance().clickWhenReady(continueCallerID, 30);
    }

    /**
     * Click continue on Plan config page before cart summary
     *
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButtonAddOns() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButtonAddOns, 5);
    }

    /**
     * This is to verify the data option price in cart summary
     *
     * @return boolean true if data price in cart summary matches with the selected data price else return false
     * @author saurav.goyal
     */
    public boolean verifyDataPriceOnCartSummary() {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains("data") || cartSummaryElement.getText().toLowerCase().contains("données")) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("data") || buildPlanElement.getText().toLowerCase().contains("données")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));
                    }
                }

            }
        }
        return false;
    }

    /**
     * This is to verify the talk option price on cart summary
     *
     * @return boolean true if talk price in cart summary matches with the selected talk price else return false
     * @author saurav.goyal
     */
    public boolean verifyTalkPriceOnCartSummary() {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains("calling") || cartSummaryElement.getText().toLowerCase().contains("appel")) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("calling") || buildPlanElement.getText().toLowerCase().contains("calling")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));
                    }
                }

            }
        }
        return false;
    }


    /**
     * This is to verify the protection price on cart summary
     *
     * @return boolean true if protection price in cart summary matches with the selected protection price else return false
     * @author saurav.goyal
     */
    public boolean verifyProtectionPriceOnCartSummary() {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains("protection") || cartSummaryElement.getText().toLowerCase().contains("protection")) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("protection") || buildPlanElement.getText().toLowerCase().contains("protection ")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));
                    }
                }

            }
        }
        return false;
    }

    /**
     * This is to verify the device price on cart summary
     *
     * @param deviceName : give the name of the device as given in the cart summary
     * @return boolean true if device price in cart summary matches with the selected device price else return false
     * @author saurav.goyal
     */
    public boolean verifyDevicePriceOnCartSummary(String deviceName) {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains(deviceName.toLowerCase())) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("Device cost") || buildPlanElement.getText().toLowerCase().contains("le coût de votre appareil")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));

                    }
                }
            }
        }
        return false;
    }

    /**
     * Click continue on cart summary in Plan config page
     *
     * @author saurav.goyal
     */
    public void clickCartSummaryContinueButton() {
        //clickGetBPOOffer();
        getReusableActionsInstance().javascriptScrollByVisibleElement(continueButtonOnCartSummary);
        getReusableActionsInstance().executeJavaScriptClick(continueButtonOnCartSummary);
        getReusableActionsInstance().waitForElementInvisibilityNOException(continueButtonOnCartSummary,60);
    }

    /**
     * This method select the additional line plan option and Clicks on proceed to checkout button
     * @author praveen.kumar7
     */
    public void selectAdditionalLinePlanOptions() {
        if(getReusableActionsInstance().isElementVisible(checkBoxAdditionalLineOPtion.get(0),40)) {
            getReusableActionsInstance().waitForElementTobeClickable(checkBoxAdditionalLineOPtion.get(0),40);
            for(WebElement ctnCheckBox : checkBoxAdditionalLineOPtion) {
                getReusableActionsInstance().clickWhenReady(ctnCheckBox);
            }
            getReusableActionsInstance().clickWhenReady(btnAddToCart);
            getReusableActionsInstance().scrollToElement(btnProceedToCheckout);
            getReusableActionsInstance().clickWhenReady(btnProceedToCheckout);
        }
    }

    /**
     * This method verifies if additional line option page is displayed
     * @return true if additional line option page title is present, else false
     * @author praveen.kumar7
     */
    public boolean verifyAdditionalLinePageDisplayed() {
        return getReusableActionsInstance().isElementVisible(titleAdditionalLinePage,30);
    }

    /**
     * This method selects the data and talk for the additional line
     * @param planType plan type to select in dropdown
     * @param additionalLineDataIndex Plan index for additional line
     * @author praveen.kumar7
     */
    public void changePlanForAdditionalLine(String planType, String additionalLineDataIndex) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(getReusableActionsInstance().getWhenReady(By.xpath("//span[contains(@class,'dsa-cartSummary')]")));
        getReusableActionsInstance().clickWhenVisible(planTypeDropDown,10);
        getReusableActionsInstance().selectWhenReady(planTypeDropDown,planType);
        getReusableActionsInstance().clickWhenVisible(dataDropDown,10);
        if(getReusableActionsInstance().isElementVisible(By.xpath("(//ul[@class='dropdown-menu-plan']//li)["+additionalLineDataIndex+"]"))) {
            getReusableActionsInstance().clickWhenVisible(By.xpath("(//ul[@class='dropdown-menu-plan']//li)["+additionalLineDataIndex+"]"));
        }
        else {
            getReusableActionsInstance().clickWhenVisible(By.xpath("(//ul[@class='dropdown-menu-plan']//li)[1]"));
        }
        getReusableActionsInstance().clickIfAvailable(talkDropDown);
        getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().selectWhenReady(talkDropDown,0);
    }

    /**
     * This method clicks on add to cart and proceed to checkout button in additional line option page
     * @author praveen.kumar7
     */
    public void clkAddToCartAndProceedToCheckout(String className, String newPlanType) {
        getReusableActionsInstance().clickWhenVisible(By.xpath("//button[contains(@id,'ds-accordion-panel')]"));
        getReusableActionsInstance().clickWhenReady(btnAddToCart);
        if(className.toUpperCase().contains("SUBSIDY") && newPlanType.equalsIgnoreCase("FINANCING")) {
            getReusableActionsInstance().staticWait(15000);
        }
        getReusableActionsInstance().waitForElementTobeClickable(btnProceedToCheckout,30);
        getReusableActionsInstance().clickWhenReady(btnProceedToCheckout);
    }

    /**
     * Select BPO offer on Plan config page
     *
     * @author saurav.goyal
     */
    public void clickGetBPOOffer() {
        getReusableActionsInstance().clickIfAvailable(getBPOOffer, 5);
    }

    /**
     * Select first edit button i.e. in device cost
     *
     * @author saurav.goyal
     */
    public void clickEditButtonDeviceCost() {
        getReusableActionsInstance().clickIfAvailable(editButtonDeviceCost, 5);
    }

    /**
     * skip BPO offer on Plan config page
     *
     * @author saurav.goyal
     */
    public void skipBPOOffer() {
        if (getReusableActionsInstance().isElementVisible(skipBPOOfferOnDeviceProtection, 10))
            getReusableActionsInstance().clickIfAvailable(skipBPOOfferOnDeviceProtection, 5);
    }

    /**
     * This method will get the monthly fees amount from the cart summary
     *
     * @return String having monthly fees amount from the cart summary
     * @author saurav.goyal
     */
    public String getMonthlyFeesAmount() {
        return getReusableActionsInstance().getWhenReady(monthlyFeesAmount,10).getText().replaceAll("\\n","");
    }

    @FindBy(xpath = "//p[contains(@data-test,'stepper-0-completed-step-device-name')]")
    WebElement deviceInfo;

    /**
     * This method will get the selected device info
     *
     * @return String having device info
     * @author nimmy.george
     */
    public String getDeviceInfo() {
        return deviceInfo.getText().toUpperCase();
    }

    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    WebElement labelRpotg;

    /**
     * This method will get Rpotg label info from the Plan config page
     *
     * @return labelRpotgInfo
     * @author nimmy.george
     */
    public String getRpotgLabelPlanConfigPage() {
        String labelRpotgInfo = labelRpotg.getText();
        return labelRpotgInfo;
    }

    /**
     * This method will get the one time fees amount from the cart summary
     *
     * @return String having one time fees amount from the cart summary
     * @author saurav.goyal
     */
    public String getOneTimeFeesAmount() {
        return getReusableActionsInstance().getWhenReady(oneTimeFeesAmount,10).getText().replaceAll("\\n","");
    }

    /**
     * This method will verify BreadCrumb on Plan config Page
     *
     * @param deviceName: String of device name
     * @return true if breadcrumb is displayed fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb(String deviceName) {
        if (getReusableActionsInstance().isElementVisible(devicesInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) && breadCrumb.getText().toUpperCase().contains((deviceName).toUpperCase())) {
            return true;
        }
        return false;
    }

    /**
     * This method verifies the BreadCrumb on Plan config Page for BYOD device
     * @return true if breadcrumb is displayed, else false
     * @author saurav.goyal
     */
    public boolean verifyAalByodBreadCrumb() {
        if(getReusableActionsInstance().isElementVisible(devicesInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) &&
                (breadCrumb.getText().toUpperCase().contains("BRING") || breadCrumb.getText().toUpperCase().contains("APPORTEZ"))) {
            return true;
        }
        return false;
    }

    /**
     * This method will verify BreadCrumb on Plan config Page for NAC BYOD
     *
     * @return true if breadcrumb is displayed fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb() {
        if (getReusableActionsInstance().isElementVisible(plansInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) && getReusableActionsInstance().isElementVisible(bringYourOwnDeviceInBreadCrumb))
            return true;
        return false;
    }

    /**
     * This method will verify the Device info on the plan config page
     *
     * @param deviceInfoConfigPage : String of device infor from config page
     * @param deviceName:          String of device name
     * @return boolean true if Device info on plan config page and matches with device info on device config page
     * @author saurav.goyal
     */
    public boolean verifyDeviceInfo(String deviceInfoConfigPage, String deviceName) {
        String deviceInfoXpath = "//p[contains(text(),'" + deviceName + "')]";
        if (getReusableActionsInstance().getWhenReady(By.xpath(deviceInfoXpath), 10).getText().replace(" ", "").toUpperCase().equalsIgnoreCase(deviceInfoConfigPage.replace(" ", "").toUpperCase()))
            return true;
        return false;
    }

    /**
     * This method will verify the default price on the device catalogue page with the default selected price on Plan config page
     *
     * @param downPriceValueCataloguePage : down price on device catalogue page
     * @return boolean: true if both the value will match else return false
     * @author saurav.goyal
     */
    public boolean verifyDefaultPrice(String downPriceValueCataloguePage) {
        if (getReusableActionsInstance().getWhenReady(priceForSelectedDeviceCost, 30).getText().toUpperCase().replace(" ", "").contains(downPriceValueCataloguePage.toUpperCase().replaceAll("/", "").replace(" ", "")))
            return true;
        return false;
    }

    /**
     * This method will get the promo block text from Plan config page displayed below the cart summary
     *
     * @return String : Return the promo block text from Plan config page displayed below the cart summary
     * @author Pranav.Shaligram
     */
    public String getPromoBlockText() {
        return getReusableActionsInstance().getWhenReady(promoBlock, 10).getText().trim().replaceAll("\\n", " ");
    }

    /**
     * This method will get the label text from Plan config page displayed on the tier
     *
     * @return String : Return label text from Plan config page displayed on the tier
     * @author Pranav.Shaligram
     */
    public String getLabelText() {
        return getReusableActionsInstance().getWhenReady(tierLabel, 10).getText().trim();
    }

    @FindBy(xpath = "//p[contains(@class,'dsa-info__contentBody text-body mb-0')]")
    WebElement eligiblePostalCodeinBanner;

    public String verifyeligiblePostalCodeinBanner() {
        getReusableActionsInstance().getWhenVisible(eligiblePostalCodeinBanner, 20);
        return eligiblePostalCodeinBanner.getText().replaceAll("\\s+", "");
    }

    /**
     * Checks for the selected device tier in plan config page
     * @return a String value of tieroption
     * @author praveen.kumar7
     */
    public String getDeviceCostTierSelected() {
        String tierOption="noterm";
        getReusableActionsInstance().scrollToElement(monthlyFeesCartSummarySection);
        if(getReusableActionsInstance().isElementVisible(upfrontOptionCheck,40)) {
            tierOption="upfront";
            return tierOption;
        }
        else if(getReusableActionsInstance().isElementVisible(financingOptionCheck,40)) {
            tierOption="financing";
            return tierOption;
        }
        else {
            return tierOption;
        }
    }

    /**
     * This method verifies if continue btn in device cost stepper is displayed or not
     * @return true if continue btn is displayed else false
     * @author praveen.kumar7
     */
    public boolean verifyDeviceCostContinueButton() {
        getReusableActionsInstance().scrollToElement(preCartDeviceCostContinueButton);
        return getReusableActionsInstance().isElementVisible(preCartDeviceCostContinueButton,30);
    }

    /**
     * This method verifies if continue btn in addons stepper is displayed or not
     * @return true if continue btn is displayed else false
     * @author praveen.kumar7
     */
    public boolean verifyTabletDataTalkOptionSelected() {
        getReusableActionsInstance().clickIfAvailable(preCartDataOtionContinueButton,10);
        getReusableActionsInstance().clickIfAvailable(preCartTalkOptionContinueButton,10);
        return getReusableActionsInstance().isElementVisible(preCartAddonsContinueButton,30);
    }

    /**
     * This method clicks on basic plan tab in plan config page
     * @author praveen.kumar7
     */
    public void clkBasicTab() {
        getReusableActionsInstance().clickWhenReady(btnBasicPlan,20);
    }

    /**
     * This method will get the data value and its respective MSF
     * @return List with plan data and msf value
     * @author praveen.kumar7
     */
    public List<String> getPlanData() {
        String dataBucket = "";
        String planPrice = "";
        List<String> planDetails = new ArrayList<String>();
        String data = getReusableActionsInstance().getWhenReady(planData, 20).getText().trim().replaceAll(" ", "");
        for (int i = 0; i < data.length(); i++) {
            if (!(data.charAt(i) == 'G')) {
                dataBucket = dataBucket.concat(Character.toString(data.charAt(i)));
            } else break;
        }
        planDetails.add(dataBucket);
        String planMSF[] = getReusableActionsInstance().getWhenReady(planData, 20).getText().trim().split("\\$");
        for (int i = 0; i < planMSF[1].length(); i++) {
            if (!(planMSF[1].charAt(i) == '.')) {
                planPrice = planPrice.concat(Character.toString(planMSF[1].charAt(i)));
            } else break;
        }
        planDetails.add(planPrice);
        return planDetails;
    }

    /**
     * This method verifies if info widget is properly displayed in plan config page
     * @return true if info widget is loaded successfully, else false
     * @author praveen.kumar7
     */
    public boolean verifyPPCPlanConfigPage() {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        return getReusableActionsInstance().isElementVisible(infoWidgetCtnCopy,30);
    }

    /**
     * This method verifies if PPC Shared-Nonshared modal is displayed in plan config page
     * @return true if PPC shared-nonshared modal is displayed, else false
     * @author praveen.kumar7
     */
    public boolean verifyPPCSharedNonSharedModal() {
        return getReusableActionsInstance().isElementVisible(ppcSharedNonSharedModal);
    }

    /**
     * This method clicks on make changes to current plan option
     * @author praveen.kumar7
     */
    public void clkMakeChangesToCurrentPlanInModal() {
        getReusableActionsInstance().clickWhenVisible(lblSelectExistingPlan);
    }

    /**
     * This method clicks on create shared group in modal
     * @author praveen.kumar7
     */
    public void clkCreateSharedGroupInModal() {
        getReusableActionsInstance().clickWhenVisible(lblSelectSharedPlan);
    }

    /**
     * This method clicks on continue button in PPC share-nonshare modal
     * @author praveen.kumar7
     */
    public void clkContinueInPPCShareNonShareModal() {
        getReusableActionsInstance().clickWhenVisible(btnPPCShareNonShareContune);
    }

    /**
     *  This method clicks on checkbox of the CTN passed as parameter
     * @param ctn2 string value of CTN2
     * @author praveen.kumar7
     */
    public void clkSecondLineCheckBox(String ctn2) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[contains(.,'"+ctn2+"') and contains(@id,'ds-checkbox')]/.."));
        getReusableActionsInstance().clickWhenReady(btnAddInModal,10);
    }

    /**
     * This menthod clicks on primary line radio button in select primary line modal
     * @param ctn1 to select in modal
     */
    public void clkRadioBtnPrimaryLine(String ctn1) {
        getReusableActionsInstance().clickWhenVisible(By.xpath("//div[contains(.,'"+ctn1+"') and contains(@class,'ds-radioLabel')]/.."));
    }

    /**
     * This method clicks on continue button in select primary line modal
     * @author praveen.kumar7
     */
    public void clkContinueInPrimaryLineSelectionModal() {
        getReusableActionsInstance().clickWhenVisible(btnSelectPrimaryLineModalContinue);
    }

    /**
     * This method clicks on Change plan CTA
     * @author praveen.kumar7
     */
    public void clkChangePlan() {
       getReusableActionsInstance().javascriptScrollByVisibleElement(infoWidgetCtnCopy);
       getReusableActionsInstance().clickIfAvailable(btnChangePlan);
    }

    /**
     * This method selects the plan type based on the input
     * @param planType plan type to be selected
     * @author praveen.kumar7
     */
    public void selectPlanType(String planType, String className) {
        switch (planType.toUpperCase()) {
            case "FINANCING":
                getReusableActionsInstance().clickWhenVisible(labelDTTPlanType);
                break;
            case "TALKTEXTFIN":
                getReusableActionsInstance().clickWhenVisible(labelTTPlanType);
                break;
            case "NOTERM":
                getReusableActionsInstance().clickWhenVisible(labelNotermPlanType);
                break;
            default:
                System.out.println("Invalid plan type - Default plan type is preselected");
        }
        getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton);
        if(!planType.equalsIgnoreCase("TALKTEXTFIN")) {
            if(className.toUpperCase().contains("DOWNGRADE")) {
                getReusableActionsInstance().waitForElementTobeClickable(btnDowngradeFeeModalConitnue,40);
            }
            else {
                getReusableActionsInstance().waitForElementVisibility(txtSelectDataOption,40);
                getReusableActionsInstance().waitForElementTobeClickable(preCartDataOtionContinueButton, 40);
                getReusableActionsInstance().staticWait(4000);
            }
        }
        else if(planType.equalsIgnoreCase("TALKTEXTFIN") && getReusableActionsInstance().isElementVisible(completedDataOptionStepper)) {
            getReusableActionsInstance().waitForElementTobeClickable(preCartTalkOptionContinueButton,20);
        }
        else getReusableActionsInstance().waitForElementTobeClickable(preCartDataOtionContinueButton,30);
    }

    /**
     * This method clicks on individual tab if present
     * @author praveen.kumar7
     */
    public void clkIndividualTab() {
        getReusableActionsInstance().clickIfAvailable(txtIndividualTab,10);
    }

    /**
     * This method clicks on continue button in downgrade fee modal
     * @author praveen.kumar7
     */
    public void verifyDowngradeFeeModalAndClkContinue() {
        getReusableActionsInstance().clickWhenVisible(btnDowngradeFeeModalConitnue);
    }

    /**
     * This method clicks on continue button in addon removal modal if present
     * @author praveen.kumar7
     */
    public void clkContinueOnExistingAddonModal() {
        getReusableActionsInstance().clickIfAvailable(btnExistingAddonModalContinue,10);
    }

    /**
     * This method verifies if plan config page loaded successfully or not
     * @return true if plan config page laoaded, else false
     * @author praveen.kumar7
     */
    public boolean verifyPlanConfigPage() {
      return getReusableActionsInstance().isElementVisible(btnCartSummaryDropDown,30);
    }

    /**
     * This method clicks on continue button in accessories cost selection stepper
     * @author praveen.kumar7
     */
    public void clkContinueAccessoriesCostSelection() {
        getReusableActionsInstance().clickWhenVisible(btnContinueAccessoriesCost);
    }

    /**
     * This method clicks on continue button in device protection modal if present
     * @author praveen.kumar7
     */
    public void clkContinueDeviceProtection() {
        getReusableActionsInstance().clickIfAvailable(btnContinueDeviceProtection,5);
    }

    /**
     * Clicks on the 'Promo Section' to enter Promo code
     * @author Subash.Nedunchezhian
     */
    public void clkPromoSection() {
        getReusableActionsInstance().waitForElementVisibility(promoSection, 20);
        getReusableActionsInstance().clickWhenVisible(promoSection);
    }

    /**
     * Enter the Promo code on Promo Input Field
     * @param promoCode Promo code from yaml file
     * @author Subash.Nedunchezhian
     */
    public void setPromoCode(String promoCode) {
        getReusableActionsInstance().getWhenReady(promoCodeField, 60).click();
        getReusableActionsInstance().getWhenReady(txtPromoCode,20).sendKeys(promoCode);
    }

    /**
     * Clicks on the 'Check' button to verify the Promo code
     * @author Subash.Nedunchezhian
     */
    public void clkCheckPromoBtn(){
        getReusableActionsInstance().waitForElementVisibility(btnCheckPromo);
        getReusableActionsInstance().clickWhenReady(btnCheckPromo);
    }

    /**
     * Validates the Success message of the Promotion
     * @return true if the 'PromoCode added to Cart' message displayed; else false
     * @author Subash.Nedunchezhian
     */
    public boolean verifyPromoSuccessMsg() {
        return getReusableActionsInstance().isElementVisible(promoCodeSuccessMsg, 60);
    }

    /**
     * Validates the Line Item of the Promotion in cart summary
     * @return true if the Promo code and discount amount line item displayed; else false
     * @author Subash.Nedunchezhian
     */
    public boolean verifyCartLineItem(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(promoCartLineItem);
        return getReusableActionsInstance().isElementVisible(promoCartLineItem);
    }

    /**
     * Validates the Discount Value and Duration of the Promotion
     * @return true if the 'Discount Value and Duration' message displayed; else false
     * @author Subash.Nedunchezhian
     */
    public boolean verifyPromoDuration(){
        return getReusableActionsInstance().isElementVisible(promoCodeDuration);
    }

}