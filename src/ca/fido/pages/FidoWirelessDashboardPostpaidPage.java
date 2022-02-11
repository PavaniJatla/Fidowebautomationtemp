package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * This class have all the post paid wireless Dashboard page elements and corresponding methods which are used in test cases.
 * Web elements and corresponding method will be added continuously according to test cases needs.
 * @author ning.xue
 *
 */
public class FidoWirelessDashboardPostpaidPage extends BasePageClass {

	public FidoWirelessDashboardPostpaidPage(WebDriver driver) {
		super(driver);
	}

	@FindAll({		
	@FindBy(xpath = "//span[text()='Update SIM Card ' or text()='Mettre à jour la carte SIM']"),
	@FindBy (xpath = "//span[@translate='wireless.dashboard.quickActions.quickActions04']")})
	WebElement lnkUpdateSimCard;
	
	@FindBy (xpath = "//input[@name='oldSimNumber']")
	WebElement txtOldSimNum;
	
	@FindBy (xpath = "//input[@name='newSimNumber']")
	WebElement txtNewSimNum;
	
	@FindBy (xpath = "//button[@translate='global.cta.next']")
	WebElement btnUpdateSimNext;

	@FindBy (xpath = "//div[@class='heads-up-section']")
	WebElement headsUpSection;
	
	@FindBy (xpath = "//div[@translate='page.update-sim-card.review']")
	WebElement titleReview;
	
	@FindBy (xpath = "//div[@class='review-page-oldsim-number']")
	WebElement reviewOldSim;
	
	@FindBy (xpath = "//input[@name='newSimNumber']")
	WebElement reviewNewSim;	
	
	@FindBy (xpath = "//button[@translate='page.update-sim-card.update-sim-btn']")
	WebElement btnUpdateSim;	
	
	@FindBy (xpath = "//a[.//ins[@translate='global.label.changePackage']]")
	WebElement lnkChangePackage;
	
	@FindBy (xpath="//ins[@translate='global.cta.confirm']/parent::button")
	WebElement btnConfirmPackageChange;
	
	@FindBy (xpath="//ins[@translate='global.label.cannotProceed']")
	WebElement popupDowngrade;
	
	@FindBy (xpath="//div[@ng-show=\"productInfo!=='LOADING' && productInfo!=='ERROR'\"]")
	WebElement infoPlan;
	
	@FindBy (xpath="//div[@ng-if='usageSummary && !usageSummary.error']")
	WebElement infoUsage;
	
	@FindBy (xpath="//div[@ng-if=\"dailyChartStatus==='SUCCESS'\"]")
	WebElement infoDailyUsageChart;
	
	@FindBy (xpath="//ins[@translate='global.cta.continue']")
	WebElement btnContinueForInternet;
	
	@FindBy (xpath = "//ins[@translate='global.cta.checkAvailability']")
	WebElement btnCheckAvailability;

	@FindBy (xpath = "//span[@translate=\"global.label.changeCallerIdHeading\"]")
	WebElement lblHeaderChangeCallDisplayName;
	
	@FindBy (xpath = "//span[@//span[@translate='global.cta.cancel']]")
	WebElement btnCancelHeaderChangeCallDisplayName;
		
	@FindBy (xpath = "//ins[@translate='global.cta.cancel']")
	WebElement btnCancelLostOrStolen;

	@FindBy (xpath = "//select[@id='selectCtn']")
	WebElement drpSelectAnotherLine;

	@FindBy(xpath = "//a[@title='Reactivate your service now.' or @title='top-banner.reactivate-suspended-service-cta-alt']")
	WebElement reactiveService;
	
	//My Plan section
	@FindAll({
			@FindBy(xpath = "//div[contains(@class,'ss-plan-container-header')]//h2"),
			@FindBy(xpath = "//div[contains(@class,'ss-plan-container-box ng-star-inserted') ]")
	})
	WebElement divMyPlan;
	
	@FindBy (xpath="//h3[@class='ss-plan-container-sub-heading']")
	WebElement lblPlanNameheading;
	
	@FindBy (xpath = "//span[@class='ss-plan-container-data']")
	WebElement lblPlanData;
	
	@FindAll({
		@FindBy(xpath = "//div[@class='ss-plan-container-box']//a"),
	    @FindBy (xpath = "//button/span[text()='CHANGE PLAN' or text()='CHANGER DE FORFAIT']")})
	WebElement btnChangePlan;	
	
	@FindBy(xpath = "//span[@translate='wireless.dashboard.myPlan.changePlanCTA' or text()='Upgrade Plan' or text()='Améliorez votre plan']")
	WebElement btnChangePlanMobile;
	
	@FindBy (xpath = "//*[@translate='wireless.dashboard.myPlan.planDetailsModel.fullPlanDetails' or text()='full plan details' or text()='détails du plan']")
	WebElement headerFullPlanDetailsOverlay;

	@FindAll({
			@FindBy(xpath = "//button[@title='Close' or @title='Fermer' or @title='Close my plan']"),
			@FindBy(xpath = "//button[@aria-label='Close' or @aria-label='Fermer' or @title='Close my plan']")
	})
	WebElement btnCloseFullPlanDetailsOverlay;

	@FindBy (xpath = "//*[@translate='wireless.dashboard.myPlan.talk' or @translate='usageModule.talkAndText.talkTextTitle' or @class='talk-text-container']")
	WebElement divMyPlanTalkDetails;
	
	@FindBy(xpath = "//*[@translate='usageModule.talkAndText.unlimited' or contains(@class,'talk-and-text-unlimited')]")
	WebElement divTalkAndTextMobile;
	
	@FindAll({
		@FindBy (xpath = "//ss-talk-text//span[contains(text(),'Texts')]"),
		@FindBy (xpath = "//*[@translate='wireless.dashboard.myPlan.text' or contains(@class,'text-usage ')]")
	})
	WebElement divMyPlanText;
	
	@FindBy (xpath = "//img[contains(@class,'hours-data')]")
	WebElement imgPlanBenefitsHoursOfData;
	
	@FindBy (xpath = "//img[contains(@class,'fido-xtra')]")
	WebElement imgPlanBenefitsXtra;
	
	@FindBy (xpath = "//img[contains(@class,'fido-roam')]")
	WebElement imgPlanBenefitsRoam;
	
	@FindBy (xpath = "//span[@translate='wireless.dashboard.myPlan.viewFullPlanCTA' or text()='View full plan details' or contains(text(),'Voir les détails du plan')]")
	WebElement lnkViewFullPlan;
	
	//My device Section
	@FindAll({
	@FindBy(xpath = "//*[@translate='wirelessDashboard.deviceSection.deviceTitle' or text()='my device' or text()='Programme de paiement Fido' or text()='Fido Payment Program']/parent::div//following-sibling::div[contains(@class,'device-wrapper')]"),
	@FindBy (xpath = "//div[@translate='wirelessDashboard.deviceSection.deviceTitle']/parent::div/following-sibling::div[contains(@class,'device-wrapper')]")})
	WebElement divMyDevice;

	@FindBy(xpath = "//h2[@class='ss-device-header mb-0 ng-star-inserted']")
	WebElement headerFidoPaymentProgram;

	@FindBy(xpath = "//div[contains(@aria-label,'Device financing payment') or contains(@aria-label,'Paiement de financement de l’appareil')]")
	WebElement txtDeviceFinancingRemainingBalance;

	@FindBy(xpath = "//span[contains(text(),'Remaining Fido Payment Program balance') or contains(text(),'Solde restant du Programme de paiement Fido')]")
	WebElement txtPaymentProgramBalance;

	@FindBy(xpath = "//span[contains(text(),'Fido Payment Program agreement start date') or contains(text(),'Date de début de l’entente du Programme de paiement Fido')]")
	WebElement txtPaymentAgreementStartDate;

	@FindBy(xpath = "//span[contains(text(),'Fido Payment Program agreement end date') or contains(text(),'Date de fin de l’entente du Programme de paiement Fido')]")
	WebElement txtPaymentAgreementEndDate;

	@FindBy(xpath = "//*[contains(text(),'Find out your exclusive deals') or contains(text(),'Découvrez vos offres exclusives')]")
	WebElement txtFindOutYourExclusiveDeals;

	@FindAll({
			@FindBy(xpath = "//*[contains(text(),'get a new device') or contains(text(),'obtenir un nouvel appareil')]"),
			@FindBy (xpath = "//span[text()='get a new device' or text()='obtenir un nouvel appareil']/ancestor::a")})
	WebElement lnkGetANewDevice;


	@FindBy(xpath = "//*[contains(text(),'A price plan change may be required') or contains(text(),'Un changement de forfait pourrait être requis')]")
	WebElement txtAPricePlanChangeMayBeRequired;

	@FindBy(xpath = "//*[contains(text(),'View Fido Payment Program details') or contains(text(),'Voir les détails sur le Programme de paiement Fido')]")
	WebElement lnkViewFidoPaymentProgramDetails;

	
	@FindAll({		
		@FindBy(xpath = "//span[text()='Report lost or stolen device' or text()='Signaler la perte ou le vol d’un appareil']"),
		@FindBy (xpath = "//span[@translate='wireless.dashboard.quickActions.quickActions03']")})	
	WebElement lnkReportLostOrStolenCard;
			
	//--- New data section on dashboard
	
	@FindBy (xpath = "//span[@class='ss-plan-container-data ng-star-inserted']")
	WebElement divDataBalanceRemaining;
	
	@FindBy (xpath = "//div[@class='ss-data-section-total-volume']")
	WebElement divTotalData;
	
	@FindBy (xpath = "//p[contains(text(),'Minutes')]")
	WebElement txtRemainMinutes;
	
	@FindBy (xpath = "//h4[@class='talk-text-limited-heading']/span")
	WebElement spanRemainingMinutes;
	

	@FindAll({
			@FindBy(xpath = "//ss-talk-text/div//span"),
			@FindBy (xpath = "//ss-talk-text/div//span[contains(text(),'minutes')]")})
	WebElement talkRemainingMinutes;
	
	@FindBy (xpath = "//ss-talk-text/div/p[contains(text(),'Text')]")
	WebElement textRemaining;
	
	@FindBy (xpath = "//td[text()='Tout Temps' or text()='Anytime']")
	WebElement tdAnytime;
	
	@FindBy (xpath = "//td[contains(text(),'Soirs/w-end') or contains(text(),'Evenings')]")
	WebElement tdEvening;
	
	@FindBy (xpath = "//td[text()='Tout Temps' or text()='Anytime']/following-sibling::td[1]")
	WebElement tdAnytimeTotal;
	
	@FindBy (xpath = "//td[text()='Tout Temps' or text()='Anytime']/following-sibling::td[@class='usage-content']/div")
	WebElement divAnytimeUsed;

	@FindAll({
			@FindBy(xpath = "//*[contains(text(),'talk & text')]"),
			@FindBy(xpath = "//*[contains(text(),'talk & text details')]")
	})
	WebElement divTalkNTextUsage;
	
	@FindBy (xpath = "//p[contains(text(),'remaining') or contains(text(),'restantes')]")
	WebElement limitedTalkUsage;
	
	@FindAll({		
	@FindBy(xpath = "//div[@class='talk-text-usage']//span[text()='minutes']"),
	@FindBy (xpath = "//span[text()='minutes']/parent::h4/following-sibling::p")})
	WebElement unlimitedTalkUsage;
	
	@FindBy(xpath = "//div[@class='talk-text-usage']//span[contains(text(),'Textos') or contains(text(),'Text')]")
	WebElement divTextUsage;

	@FindAll({
			@FindBy(xpath = "//span[contains(text(),'Texts')]"),
			@FindBy(xpath = "//th[contains(text(),'Text')]")
	})
	WebElement textUsageInTalkNTextOnly;
	
	@FindBy (xpath = "//td[contains(text(),'Picture') or contains(text(),'photo')]")
	WebElement tdPictureMsg;
	
	@FindBy (xpath = "//td[contains(text(),'Bundles') or contains(text(),'Trousses')]")
	WebElement tdBundlesMsg;
	
	@FindBy (xpath = "//td[contains(text(),'International') or contains(text(),'Internationaux')]")
	WebElement tdInternationalMsg;
	
		
	@FindAll({
	@FindBy(xpath = "//ss-non-realtime"),
	@FindBy(xpath = "//*[@translate='usageModule.nonRealTimeLabel']")})
	WebElement divDataDelayedAlert;
	
	@FindBy(xpath = "//div[@class='ss-data-section-bill-cycle']")
	WebElement divBillCycle;
	
	@FindBy(xpath = "//span[@class='ss-plan-container-dollar-amount']")
	WebElement divSSPlanAmount;
	
	@FindBy(xpath = "//div[@class='ss-data-usage-bar-total-data']")
	WebElement divUsageBarValue;
	
	@FindBy(xpath = "//div[@class='ss-data-usage-bar-background']")
	WebElement divUsageBar;
	
	@FindBy (xpath = "//*[contains(text(),'days remaining') or contains(text(),'votre cycle')]")
	WebElement daysRemainingofBillCycle;

	@FindAll({
			@FindBy(xpath = "//button[@translate='wirelessDashboard.deviceSection.upgradeBtnText']"),
			@FindBy(xpath = "//div[contains(@class,'device-content-box')]//a[contains(@class,'-primary -large')]")
	})
	WebElement btnUpgradeDevice;
	
	@FindAll({		
	@FindBy(xpath = "//span[text()='Change my number' or text()='Changer mon numéro']"),
	@FindBy(xpath = "//a//span[@translate='wireless.dashboard.quickActions.quickActions05']")})
	WebElement lnkChangeMyNumber;

	@FindBy (xpath = "//button[@translate='wirelessDashboard.deviceSection.reserveNewPhone']")
	WebElement btnReserveNewPhone;
	
	@FindBy (xpath = "//button[@translate='wirelessDashboard.deviceSection.modalMessages.statusReserve']")
	WebElement btnReserve;

	@FindAll({		
		@FindBy(xpath = "//span[text()='Reset voicemail password' or text()='Réinitialiser le mot de passe pour la messagerie vocale']"),
		@FindBy (xpath = "//a/span[@translate='wireless.dashboard.quickActions.quickActions02']")})	
	WebElement lnkResetVoiceMailPassword;
	
	@FindBy (xpath = "//button[@class='ds-modal__closeButton ds-button ds-corners ds-pointer text-center mw-100 -icon d-inline-flex justify-content-center align-items-center -large ng-star-inserted'][@title='Close']")
	WebElement btnCloseOnPopup;
	
	@FindAll({		
	@FindBy(xpath = "//span[text()='Report lost or stolen device' or text()='Signaler la perte ou le vol d’un appareil']"),
	@FindBy (xpath = "//span[@translate=\"wireless.dashboard.quickActions.quickActions03\"]")})
	WebElement lnkReportLostOrStolen;
	
	@FindAll({
	@FindBy(xpath = "//span[text()='Change call display name' or text()='Modifier le nom d’affichage des appels']"),
	@FindBy (xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions01\"]")})
	WebElement lnkChangeCallDisplayName;

	@FindAll({		
	@FindBy(xpath = "//span[text()='Update SIM Card' or text()='Mettre à jour la carte SIM']"),
	@FindBy(xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions04\"]")})
	WebElement lnkUpdateSIMCard;
	
	@FindAll({
	@FindBy(xpath = "//span[text()='Retrieve PUK Code' or text()='Obtenir un code PUK']"),	
	@FindBy(xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions07\"]")})
	WebElement lnkRetreivePUKCode;
	
	@FindAll({
	@FindBy(xpath = "//span[text()='Change my number' or text()='Changer mon numéro']"),
	@FindBy(xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions05\"]")})
	WebElement lnlChangeMyNumber;

	@FindBy(xpath = "//a//span[contains(text(),'View Details')]")
	WebElement lnkShowMyUsageTotalPlan;
	
	@FindAll({@FindBy(xpath = "//div[@class='selected-plan-details-item']//h2")})
	List<WebElement> btnsSelectDataOnAddDataOverLay;
	//=== Add data section for demoline accounts
	
	@FindBy(xpath = "//div[@class='ss-data-section-add-icon']/span[text()='+']")
	WebElement btnAddData;

	@FindBy(xpath = "//ins[@translate='ute.purchaseData.continue']/parent::button/parent::div/following-sibling::a/ins[@translate='ute.purchaseData.backBtn']/parent::a")
	WebElement btnCancelMonthlyDataPlan;	

	@FindAll({
	@FindBy(xpath = "//a[@title='Reactivate your service now.']"),
	@FindBy (xpath = "//fds-link[@class='ng-star-inserted']")})
	WebElement lnkReactivate;

	@FindBy (xpath = "//span[@translate='usageModule.manage' or text()='View Details' or text()='Afficher les détails']")
	WebElement lnkViewDetailsInUsageSection;
	
	@FindBy(xpath="//div[contains(@class,'wireless-dashboard')]/div[contains(@class,'wireless-title')]")
	WebElement lblMobileDashboardTitle;
	

	@FindBy(xpath="//span[text()='Repair, trade or device protection request']")
	WebElement lnkRepairMobile;

	@FindBy(xpath = "//*[text()=' Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//*[text()='Repair, trade-in or device protection?' or text()='Réparer ou échanger votre appareil']")
	WebElement lblGetHelpForYourPhoneOverlay;

	@FindBy(xpath = "//*[text()='Add data to avoid further overage charges']")
	WebElement lblAddDataToAvoidFurtherOverage;
	
	@FindBy(xpath = "//*[@class='ss-used-data-data-size']")
	WebElement lblOverageDataSize;

	@FindBy(xpath = "//*[@class='ss-used-data-overage-gradient']")
	WebElement lblUsedDataOverageGradient;
	
	@FindBy(xpath = "//img[@alt='Attention']")
	WebElement imgAttentionOverage;
	@FindAll({
			@FindBy(xpath = "//ss-manage-data//child::div[contains(@class,'section ng-star-inserted')]//div[contains(@class,'col-md-9 section-body')]//div[@class='ng-star-inserted']//table"),
			@FindBy (xpath = "//div[contains(@class,'ss-plan-container-addons-holder')]//li"),
			@FindBy(xpath = "//span[@translate='wireless.dashboard.myPlan.addOns']/ancestor::div[contains(@class,'addons')]//li")})
	List<WebElement> lstMyPlanAddOns;

	@FindBy(xpath = "//*[@translate='usageModule.runningLow.title' or @class='ss-data-usage-bar-background']") 
	WebElement lblYouAreRunningLow;
	
	@FindBy(xpath = "//div[@class='data-callout-wrapper running-low']")
	WebElement popOutRunningLow;
	
	@FindBy(xpath = "//span[@translate='usageModule.addData']")
	WebElement btnAddDataOnRunningLowPopOut;
	
	@FindBy(xpath = "//div[@class='data-callout-wrapper running-low']/div[@title='Close' or @title='Fermer']")
	WebElement btnCloseOnCallOut;

	@FindBy(xpath = "//a/span[@translate='wireless.dashboard.myPlan.viewDetailsCTA' or text()='View details']")
	WebElement lnkViewDetailsMyPlan;
	
	@FindBy(xpath = "//button[@title='Voir les détails des appels et textos' or @title='View Talk and Text details']")
	WebElement lnkViewDetailsTalkAndText;

	@FindBy(xpath = "//span[text()='Repair or trade-in device' or text()='Réparer ou échanger un appareil']")
	WebElement lnkRepairOrTradeInMyDevice;

	@FindBy(xpath = "//span[text()=' Thank you for bringing your device ' or text()='Merci d’avoir apporté votre appareil']")
	WebElement msgMyDeviceThanks;

    @FindBy(xpath = "//*[@class=\"col m-grid\"]")
	WebElement lblDashboadBottomView;

	@FindBy(xpath = "//span[@class='device-balance d-flex flex-column']//div[@class='ds-price']")
	WebElement txtDeviceRemainingBalance;

	@FindBy(xpath = "//span[@class='ss-device-name pr-sm-8 ng-star-inserted']")
	WebElement txtDeviceName;

	@FindBy(xpath = "//strong[@class='ng-star-inserted']")
	WebElement txtSubsidyEndDate;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']/div/span[2]")
	WebElement txtActivationDate;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[2]//span[2]")
	WebElement txtFidoPaymentProgramBalance;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[3]/div//div[1]")
	WebElement txtFidoProgramBalanceTotal;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[3]/div[2]//div")
	WebElement txtFidoProgramBalanceBase;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[3]/div[3]//div")
	WebElement txtFidoProgramBalanceTax;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[4]/div//div[1]")
	WebElement txtTotalMonthlyFidoProgramPayment;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[4]/div[2]//div")
	WebElement txtMonthlyFidoProgramPayment;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[4]/div[3]//div")
	WebElement txtMonthlyFinancedTaxes;

	@FindBy(xpath = "//div[@class='ss-device-detail-modal']//div[4]/div[4]/span[2]")
	WebElement txtMonthsRemaining;

	@FindBy(xpath = "//button[@id='ds-accordion-panel-0-heading-0']")
	WebElement FidoPaymentProgramDetailsHeader;

	@FindBy(xpath = "//div[@id='ds-accordion-panel-0-body-0']//p")
	WebElement FidoPaymentProgramDetailsHeaderParagraph;

	@FindBy (xpath = "//*[@class='talk-text-wrapper talk-text-usage-only ng-star-inserted']")
	WebElement divWirelessTalkNTextUsage;

	/**
	 * Clicks on the add data button for demoline accounts only
	 * @author Mirza.Kamran
	 */
	public void clkAddDataButton() {
		reusableActions.staticWait(50000);
		reusableActions.getWhenReady(btnAddData).click();
	}

	
	/**
	 * Perform click on view details link in usage section
	 * @author ning.xue
	 */
	public void clkLinkViewDetailInUsage() {	
		//reusableActions.waitForElementTobeClickable(lnkShowMyUsageTotalPlan, 60);
		reusableActions.getWhenReady(lnkShowMyUsageTotalPlan,20).click();
	}
		
	/**
	 * Clicks show my usage link if the dashborad displays this link
	 * @author Mirza.Kamran
	 */
	public void clkShowMyUsageIfVisible() {
		if (reusableActions.isElementVisible(lnkShowMyUsageTotalPlan) == true) {
			reusableActions.getWhenReady(lnkShowMyUsageTotalPlan,5).click();
		}
		//reusableActions.clickIfAvailable(lnkShowMyUsageTotalPlan, 5);
		/*reusableActions.clickIfAvailable(By.xpath("//span[contains(@class,'ds-icon d-inline-flex fds-icon-close')]"));
		if (reusableActions.isElementVisible(By.xpath("//span[contains(@class,'ds-icon d-inline-flex fds-icon-close')]")) == true) {
			reusableActions.waitForElementVisibility(lnkShowMyUsageTotalPlan,5);
			reusableActions.clickIfAvailable(lnkShowMyUsageTotalPlan, 5);
		}*/

	}
	
	/**
	 * Close the overlay pop up for new look notification. 
	 * @author ning.xue
	 */
	public void closeOverlayPopup() {
		reusableActions.clickIfAvailable(btnCloseOnPopup, 10);
	}
	
	/**
	 * Performs click on the link Change package
	 * @author Mirza.Kamran
	 */
	public void clkChangePackage() {

		reusableActions.getWhenVisible(lnkChangePackage).click();
	}
	
	/**
	 * Click the link report lost or stolen on wireless dash board
	 * @author ning.xue
	 */
	public void clkLnkReportLostOrStolen() {
		reusableActions.getWhenReady(lnkReportLostOrStolenCard, 30).click();
	}
	
	/**
	 * Check if there has ReactivateMyDevice button in wireless dash board page.
	 * @return true if the serive is suspended else false
	 * @author Ning.Xue
	 */
	public Boolean isServiceSuspended() {
		return reusableActions.isElementVisible(By.xpath("//a[@title='Reactivate your service now.']"), 60);
	}
	
	/**
	 * click the link to reactivate account on wireless dashboard
	 * @author ning.xue
	 */
	public void clkLnkReactivate() {
		reusableActions.waitForElementVisibility(reactiveService);
		reusableActions.getWhenReady(reactiveService, 60).click();
	}
	
	/**
	 * Click the Reserve a New Phone button on wireless dash board
	 * @author ning.xue
	 */
	public void clkBtnReserveNewPhone() {
		reusableActions.getWhenReady(btnReserveNewPhone, 120).click();
	}
	
	/**
	 * Click reserve button in reserve a new phone flow pop up.
	 * @author ning.xue
	 */
	public void clkBtnReserve() {
		reusableActions.getWhenReady(btnReserve, 30).click();
	}


	/**
	 * Selects HSI package by bandwidth 
	 * @param strBandwidth string containing the bandwidth value
	 * @author Mirza.Kamran
	 */
	public void selectHSIPackageByBandwidth(String strBandwidth) {
		
		reusableActions.getWhenVisible(By.xpath("//span[@ng-bind='tier.speed.download' and text()='"+strBandwidth+"']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//button[contains(@ng-click,'offerChange')]"),20).click();
	
	}
	
	/**
	 * Selects the HSI package by Data
	 * @param strBandwidth string value containing the Bandwidth
	 * @param strData string value containing Data
	 * @author Mirza.Kamran
	 */
	public void selectHSIPackageByData(String strBandwidth, String strData ) {
		
		reusableActions.getWhenVisible(By.xpath("//span[@ng-bind='tier.speed.download' and text()='"+strBandwidth+"']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//b[@ng-bind-template='"+strData+"']"),10).click();
	
	}
	
	/**
	 * Clicks on the button Confirm package change
	 * @author Mirza.Kamran
	 */
	public void clkConfirmPackageChange() {
		
		reusableActions.getWhenVisible(btnConfirmPackageChange).click();
		
	}
		
	/**
	 * Verifies Downgrade pop up is visible 
	 * @return true if the pop up is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDowngradePopup(){
		return reusableActions.isElementVisible(popupDowngrade);
	}
	
	/**
	 * Verifies if info plan is visible
	 * @return true if the info plan is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfPlanInformationLoaded() {
		return reusableActions.isElementVisible(infoPlan);
	}
	
	/**
	 * Verifies if info usage is visible
	 * @return true if the info usage is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfUsageInfoDisplayed() {
		return reusableActions.isElementVisible(infoUsage);
	}
	
	/**
	 * Verifies if the usage chart is visible else false
	 * @return true if the usage chart is visible
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfDailyUsageChartVisible() {
		return reusableActions.isElementVisible(infoDailyUsageChart);
	}
	
	/**
	 * Clicks on the button Check Availability 
	 * @author Mirza.Kamran
	 */
	public void clkContinueForInternet() {
		reusableActions.waitForElementInvisibility(btnCheckAvailability);
		reusableActions.getWhenVisible(btnContinueForInternet,30).click();
		
	} 
	
	/**
	 * checks talk and text usage model is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyTalkNTextUsageModuleIsDisplayed() {
		System.out.println("Talk & Text usage module is being checked");
		return reusableActions.isElementVisible(divTalkNTextUsage);
	}

	/**
	 * checks talk and text usage model is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Rama Arora
	 */
	public boolean verifyWirelessTalkNTextUsageModuleIsDisplayed() {
		System.out.println("Talk & Text usage module is being checked");
		return reusableActions.isElementVisible(divWirelessTalkNTextUsage);
	}

	/**
	 * checks talk usage is displayed in wireless dash board, talk could be unlimited or limited.
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyTalkUsageSectionofFullPlanIsDisplayed() {
		System.out.println("Talk usage details message is being checked");
		return (reusableActions.isElementVisible(limitedTalkUsage)
				||reusableActions.isElementVisible(unlimitedTalkUsage));
	}
	
	/**
	 * checks if talk plan is unlimited.
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyUnlimitedTalkUsageIsDisplayed() {
		System.out.println("Talk usage is unlimited or not being checked");
		return (reusableActions.isElementVisible(unlimitedTalkUsage));
	}
	
	/**
	 * checks talk usage is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkUsageDetailsofTalkTextOnlyPlanIsDisplayed() {
		System.out.println("Talk usage details is being checked");
		return reusableActions.isElementVisible(txtRemainMinutes);
	}	
	
	/**
	 * checks talk usage Anytime section detail is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkAnytimeUsageDetailsIsDisplayed() {
		System.out.println("Talk any time usage details is being checked");
		return reusableActions.isElementVisible(tdAnytime);
	}	
	
	/**
	 * checks talk evening and weekend usage section detail is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkEveningUsageDetailsIsDisplayed() {
		System.out.println("Talk evening and weekend usage details is being checked");
		return reusableActions.isElementVisible(tdEvening);
	}	
	
	/**
	 * checks talk usage detail data accuracy in wireless dash board
	 * @return true if the remaining time equal to total time minus used time, otherwise false
	 * @author Ning.Xue
	 */
	public boolean verifyLimitedTalkUsageDetailsAccuracy() {
		System.out.println("Limited Talk plan usage details is being checked");
		Integer intRemainTime = Integer.parseInt(reusableActions.getWhenReady(spanRemainingMinutes).getText());
		Integer intTotalTime = Integer.parseInt(reusableActions.getWhenReady(tdAnytimeTotal).getText());
		String strTimeUsed = reusableActions.getWhenReady(divAnytimeUsed).getText();
		Integer intUsedTime = Integer.parseInt(strTimeUsed.substring(0, strTimeUsed.length()-8));
		return intRemainTime == intTotalTime - intUsedTime;
	}	
	
	/**
	 * checks text usage is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyTextUsageDetailsOfFullPlanIsDisplayed() {
		System.out.println("Text usage details is being checked");
		return reusableActions.isElementVisible(divTextUsage);
	}	
	
	/**
	 * checks text usage of Talk and Text only plan is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyTextUsageDetailsOfTalkNTextOnlyIsDisplayed() {
		System.out.println("Text usage details is being checked");
		return reusableActions.isElementVisible(textUsageInTalkNTextOnly);
	}
	
	/**
	 * checks text usage picture message part is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyPictureMsgDetailsIsDisplayed() {
		System.out.println("Text usage details, picture message is being checked");
		return reusableActions.isElementVisible(tdPictureMsg);
	}	
	
	/**
	 * checks text usage bundles message part is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyBundlesMsgDetailsIsDisplayed() {
		System.out.println("Text usage details, bundles message is being checked");
		return reusableActions.isElementVisible(tdBundlesMsg);
	}	
	
	/**
	 * checks text usage International message part is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyInternationalMsgDetailsIsDisplayed() {
		System.out.println("Text usage details, International message is being checked");
		return reusableActions.isElementVisible(tdInternationalMsg);
	}	
	
	/**
	 * checks text plan dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTextPlanDetailsSectionIsDisplayed() {
		System.out.println("text plans details is being checked");
		//return reusableActions.isElementVisible(By.xpath("//*[@translate='wireless.dashboard.myPlan.text' or contains(@class,'text-usage ')]"),60);
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'Text')]"),60);

	}	
	
	/**
	 * checks talk plan dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkPlanDetailsSectionIsDisplayed() {
		System.out.println("talk plans details is being checked");
		return reusableActions.isElementVisible(divMyPlanTalkDetails,60);
	}
	
	/**
	 * checks data delayed label in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelDataDelayedIsDisplayed() {
		System.out.println("Labeldata delayed is being checked");
		return reusableActions.isElementVisible(divDataDelayedAlert);
	} 
	
	/**
	 * checks Days remaining in bill cycle in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyDaysRemainingInBillCycleIsDisplayed() {
		System.out.println("Days remaining in bill cycle is being checked");
		return reusableActions.isElementVisible(daysRemainingofBillCycle);
	}
	
	/**
	 * checks Total data section in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTotalDataInUsageSectionIsDisplayed() {
		try {
			System.out.println("Total data section is being checked");
			return reusableActions.isElementVisible(divTotalData);
		}catch (TimeoutException te) {
			te.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Get the value of total data in usage section
	 * @return double, the value of total data
	 * @author ning.xue
	 */
	public double getValueTotalData() {
		reusableActions.waitForElementVisibility(divTotalData, 60);
		return Double.parseDouble(divTotalData.getText().replaceAll(",", ".").trim());
	}
	
	/**
	 * Verify total data in data usage section reflected added data
	 * @param previousTotalDataValue, the value of total data before add data
	 * @param addedDataValue, the value of added data
	 * @return true, if the total data reflected added data
	 * @author ning.xue
	 */
	public boolean verifyTotalDataReflectedAddedData(double previousTotalDataValue, double addedDataValue) {
		double diff=0;
		double totalDataValue = Double.parseDouble(divTotalData.getText().trim().replaceAll(",", "."));
		double addition = (addedDataValue + previousTotalDataValue);
		if(totalDataValue>addition)
		{
			diff=totalDataValue-addition;
		}else
		{
			diff=addition-totalDataValue;
		}
		return totalDataValue == addition || (diff<=0.1);
				
	}
		
	
	/**
	 * Verify total data in data usage section align with the total data in Manage Data page
	 * @param totalDataValue, the value of total data in data usage section
	 * @param totalDataInManageDataPage, the value of total data in manage data page, including plan data and add-ons.
	 * @return true, if the total data align with each other
	 * @author ning.xue
	 */
	public boolean verifyTotalDataAlignWithManageDataPage(double totalDataValue, double totalDataInManageDataPage) {
		double diff=0;
		if(totalDataValue>totalDataInManageDataPage)
		{
			diff=totalDataValue-totalDataInManageDataPage;
		}else
		{
			diff=totalDataInManageDataPage-totalDataValue;
		}
		return totalDataValue == totalDataInManageDataPage || (diff<=0.1);
	}
	
	/**
	 * checks of the remaining GB section in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataDashBoardSectionDataBalanceRemainingIsDisplayed() {

		return reusableActions.isElementVisible(divDataBalanceRemaining, 60);

	}
	
	/**
	 * Get the value of remaining data in usage section
	 * @return double, the value of remaining data
	 * @author ning.xue
	 */
	public double getValueRemainingData() {
		reusableActions.waitForElementVisibility(divDataBalanceRemaining, 60);
		return Double.parseDouble(divDataBalanceRemaining.getText().replaceAll("GB", "").trim());
	}
	
	/**
	 * Verify remaining data in data usage section reflected added data
	 * @param previousRemainingDataValue, the value of remaining data before add data
	 * @param addedDataValue, the value of successfully added data
	 * @return true, if the remaining data reflected added data
	 * @author ning.xue
	 */
	public boolean verifyRemainingDataReflectedAddedData(double previousRemainingDataValue, double addedDataValue) {
		double diff=0;
		double totalDataValue = Double.parseDouble(divDataBalanceRemaining.getText().replaceAll(",", ".").trim());
		double addition = (addedDataValue + previousRemainingDataValue);
		if(totalDataValue>addition)
		{
			diff=totalDataValue-addition;
		}else
		{
			diff=addition-totalDataValue;
		}
		return totalDataValue == addition || (diff<=0.1);
				
	}
	
	/**
	 * checks Usage Bar section in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataDashBoardUsageBarIsDisplayed() {
		try {
			System.out.println("data balance Usage Bar is being checked");
			return (reusableActions.isElementVisible(divUsageBar) &&  reusableActions.isElementVisible(divUsageBarValue));
		}catch (TimeoutException te) {
			te.printStackTrace();
			return false;
		}
	}	
	
	/**
	 * verifies if the Change plan button is opening the correct window
	 * @return true if the button is working else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyChangePlanButton()
	{
		reusableActions.clickIfAvailable(btnChangePlan);
		reusableActions.staticWait(3000);
		if(!getDriver().getTitle().equals("Price plan change"))
		{			
			System.out.println("Change plan window not open, please investigate");
			return false;
		}
		
		getDriver().navigate().back();
		return true;
	}
	
	/***
	 * This method will verify view full plan details
	 * @return returns boolean
	 * @author Mirza.Kamran
	 */
	public Boolean verifyViewFullPlanDetails()
	{						
		//reusableActions.getWhenReady(lnkViewFullPlan).click();
		reusableActions.clickIfAvailable(lnkViewFullPlan,3000);
		reusableActions.waitForElementTobeClickable(headerFullPlanDetailsOverlay, 30);		
		if(!reusableActions.isElementVisible(headerFullPlanDetailsOverlay))
		{		
			
			System.out.println("View full plan details link did not open the expected overlay, please investigate");			
			return false;			
		}
		reusableActions.getWhenReady(btnCloseFullPlanDetailsOverlay).click();
		return true;
	}
	

	/**
	 * checks Plan benefits options on My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyPlanBenefitsInMyMobilePlanDashBoardSectionIsDisplayed() {
		System.out.println("Plan benefits is being checked");
		return (reusableActions.isElementVisible(imgPlanBenefitsHoursOfData)
				|| reusableActions.isElementVisible(imgPlanBenefitsRoam)
				|| reusableActions.isElementVisible(imgPlanBenefitsXtra));
				
	}
	
	
	/**
	 * checks link view full plan details on My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyButtonChangePlanMyMobilePlanDashBoardSectionIsDisplayed() {
		System.out.println("Button change Plan  is being checked");
		return reusableActions.isElementVisible(btnChangePlan);
				
	}
	
	/**
	 * checks link view full plan details on My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyButtonChangePlanMyMobilePlanDashBoardSectionIsDisplayedMobile() {
		System.out.println("Button change Plan  is being checked");
		return reusableActions.isElementVisible(btnChangePlanMobile);
				
	}
	
	
	/**
	 * checks My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyMobilePlanDashBoardSectionIsDisplayed() {
		System.out.println("My Mobile plan usage section is being checked");
		reusableActions.staticWait(3000);
		return reusableActions.isElementVisible(divMyPlan);
				
	}
	

	/**
	 * checks link view full plan details on My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkViewFullPlanDetailsOnMyMobilePlanDashBoardSectionIsDisplayed() {
		System.out.println("Link  is being checked");
		return reusableActions.isElementVisible(lnkViewFullPlan);
				
	}
	
	
	/**
	 * This method will verify the Device details section
	 * @return returns boolean
	 * @author Mirza.Kamran
	 */
	public Boolean verifyMyDeviceDetails() {
				
	return reusableActions.isElementVisible(divMyDevice);

		}
	
	
	/**
	 * This method will validate the links if they are valid or not 
	 * @param strLinkName parameter for passing link text
	 * @return boolean return value based on validation
	 * @author Mirza.Kamran
	 */
	public Boolean verifyifLinkIsValid(String strLinkName)
    {     
     String url = "";
     HttpURLConnection huc = null;
     int respCode = 200;
     Boolean validated=false;
           
     WebElement lnkElement = reusableActions.getWhenReady(By.partialLinkText(strLinkName));
             
         url = lnkElement.getAttribute("href");        
         System.out.println(url);
     
         if(url == null || url.isEmpty()){
         System.out.println("URL is either not configured for anchor tag or it is empty");
         validated=false;
         }
                
         
         try {
             huc = (HttpURLConnection)(new URL(url).openConnection());
             
             huc.setRequestMethod("HEAD");
             
             huc.connect();
             
             respCode = huc.getResponseCode();
             
             
             if(respCode >= 400){
                 System.out.println(url+" is a broken link");
                 validated=false;
             }
             else{
            	 validated=true;
             }
                 System.out.println(url+" is a valid link");
             }
                 
         catch (MalformedURLException e) {
        	 validated=false;
             e.printStackTrace();
         } catch (IOException e) {
        	 validated=false;            
             e.printStackTrace();
         }
         
         return validated;
    }
	
	/**
	 * Verifies if the given link exists in page or not
	 * @param strLinkName The Partial or complete Link text as displayed on the UI
	 * @return true if the link is visible else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLinkExists(String strLinkName) {
		return reusableActions.isElementVisible(By.partialLinkText(strLinkName));
	}

	/**
	 * Check if the link Change call display name is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkChangeCalldisplayNameIsDisplayed() {
		System.out.println("If the account is not suspended the Chnage Call display name is displayed");
		return reusableActions.isElementVisible(lnkChangeCallDisplayName);
	}
	
	/**
	 * Check if the link Chnage My Number is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkChangeMyNumberIsDisplayed() {
		return reusableActions.isElementVisible(lnkChangeMyNumber);
	}
	
	/**
	 * Check if the link Update Sim Card is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkUpdateSIMCardIsDisplayed() {
		return reusableActions.isElementVisible(lnkUpdateSimCard);
	}
		
	
	/**
	 * Check if the link Lost and found is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkReportLostOrStolenIsDisplayed() {
		return reusableActions.isElementVisible(lnkReportLostOrStolen);
	}
	
	
	/**
	 * Check if the link Retrieve PUK code is is displayed
	 * @return true when the link is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRetrievePUKCodeIsDisplayed() {
		return reusableActions.isElementVisible(lnkRetreivePUKCode);
	}
	
	/**
	 * This method will click on link and validate if the links are correct and new window is open 
	 * @param strLinkText The link name as visible on UI 
	 * @param strNewWindowTitle The title of the new window after the link is click
	 * @return boolean, true if the title matches.
	 * @author Mirza.Kamran
	 */
	public boolean clickAndVerifyLinkForNewWindow(String strLinkText, String strNewWindowTitle) {
		String parentHandle=driver.getWindowHandle();
		reusableActions.clickIfAvailable(By.partialLinkText(strLinkText));
		reusableActions.waitForNumberOfWindowsToBe(2);
		reusableActions.switchToNewWindow(parentHandle);
		if(driver.getTitle().trim().toLowerCase().equals(strNewWindowTitle.trim().toLowerCase()))
		{
			reusableActions.closeCurrentWindow();
			reusableActions.switchToMainWindow(parentHandle);
			return true;
		}else
		{
			return false;
		}			
	}	

	
	/**
	 * Click on Update SIM card link
	 * @author ning.xue
	 */
	public void clkLnkUpdateSimCard() {

		reusableActions.getWhenVisible(lnkUpdateSimCard, 30).click();
	}
	
	/**
	 * To input the 20 digit old SIM card number to the input area. 
	 * Note: system will validate the SIM card number. It must be the real SIM number. 
	 * @param oldSimNum, String, old SIM card number
	 * @author ning.xue
	 */
	public void setOldSimNum(String oldSimNum) {
		reusableActions.getWhenReady(txtOldSimNum, 30).clear();
		reusableActions.getWhenReady(txtOldSimNum).sendKeys(oldSimNum);
	}
	
	/**
	 * To input the 20 digit new SIM card number to the input area.
	 * The new SIM card number can be any dumb 20 digit number
	 * @param newSimNum, String, new SIM card number.
	 * @author ning.xue
	 */
	public void setNewSimNum(String newSimNum) {
		reusableActions.getWhenReady(txtNewSimNum, 30).clear();
		reusableActions.getWhenReady(txtNewSimNum).sendKeys(newSimNum);
	}
	
	/**
	 * Click on Next button in update SIM flow
	 * @author ning.xue
	 */
	public void clkBtnUpdateSimNext() {

		reusableActions.getWhenVisible(btnUpdateSimNext, 20).click();
	}
	//div[@class='heads-up-section']

	/**
	 * To verify if the heads up section is visible.
	 * @return true when all the condition match, otherwise false.
	 * @author Sidhartha.vadrevu
	 */
	public Boolean verifyHeadsUpSection() {
		return reusableActions.isElementVisible(headsUpSection, 30);
	}

	/**
	 * To verify if the review page opened and check if the SIM card number are the same as inputed in previous step.
	 * @param oldSimNum, String, old SIM card number
	 * @param newSimNum, String, new SIM card number
	 * @return true when all the condition match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyUpdateSimReview(String oldSimNum, String newSimNum) {
		if (reusableActions.isElementVisible(titleReview, 30)
				&& reusableActions.getWhenReady(reviewOldSim).getText().trim().equalsIgnoreCase(oldSimNum)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Click on Update SIM button
	 * @author ning.xue
	 */
	public void clkBtnUpdateSim() {

		reusableActions.getWhenVisible(btnUpdateSim, 20).click();
		reusableActions.staticWait(5000);
	}

	/**
	 * Click on the change My Number link on the postpaid dashboard page
	 * @author Mirza.Kamran
	 */
	public void clickChangeCTN() {
		reusableActions.clickWhenReady(lnkChangeMyNumber);
		reusableActions.staticWait(10000);
		
	}
	
	/**
	 * Clicks on the link Reset Voice mail password
	 * @author Mirza.Kamran
	 */
	public void clickUpdateVoiceMailPassword() {
		reusableActions.waitForElementTobeClickable(lnkResetVoiceMailPassword, 240);
		reusableActions.clickWhenReady(lnkResetVoiceMailPassword);
	}
	
	/**
	 * Clicks on the 'UPGRADE DEVICE' button
	 * @author rajesh.varalli1
	 */
	public void clickUpgradeDevice() {
		reusableActions.clickWhenReady(btnUpgradeDevice, 60);
	}
	
	/**
	 * Validates if the Wireless Dashboard page is loaded successfully
	 * @return true if '...Mobile dashboard' header is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessDashboardPageLoad() {
		return reusableActions.isElementVisible(lblMobileDashboardTitle,60);
	}
	
	/**
	 * Clicks on the 'Change Plan' button
	 * @author rajesh.varalli1
	 */
	public void clkChangePlan() {
		reusableActions.executeJavaScriptClick(btnChangePlan);
	}

	/**
	 * Scroll to Mid of Dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToMidOfDasboardPage() {
		reusableActions.javascriptScrollToMiddleOfPage();
		
	}

	/**
	 * Scroll to bottom of page
	 * @author Mirza.Kamran
	 */
	public void scrollToBottomOfPage() {
		reusableActions.javascriptScrollToBottomOfPage();
		
	}

	/**
	 * Verify link repair device is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRepairMyDeviceIsDisplayed() {
		return reusableActions.isElementVisible(lnkRepairMobile);
	}
	
	/**
	 * Verify link repair or trade in my device is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRepairOrTradeInMyDeviceIsDisplayed() {
		return reusableActions.isElementVisible(lnkRepairOrTradeInMyDevice);
	}
	
	/**
	 * Clicks on Repair or trade in device link
	 * @author Mirza.Kamran
	 */
	public void clkRepairOrTradeInDeviceLink() {
		reusableActions.clickWhenReady(lnkRepairOrTradeInMyDevice);
	}
	
	/**
	 * Clicks on Repair device link
	 * @author Mirza.Kamran
	 */
	public void clkRepairDeviceLink() {
		reusableActions.clickWhenReady(lnkRepairMobile);
	}
	
	
	/**
	 * Verify Overlay for repair device is displayed
	 * @return true if the overlay is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyOverlayForRepairDeviceIsDisplayed() {
		return reusableActions.isElementVisible(lblGetHelpForYourPhoneOverlay,60);
	}

	public boolean verifyDashboadBottomVeiw() {
		return reusableActions.isElementVisible(lblDashboadBottomView,60);
	}

	/**
	 * Clicks on the button continue on repair device overlay
	 * @return returns current window handle
	 * @author Mirza.Kamran
	 */
	public String clkButtonContinueOnRepairDeviceOverlay() {
		String strCurrenthandle = driver.getWindowHandle();
		reusableActions.clickWhenReady(btnContinue);
		reusableActions.staticWait(5000);// adding static buffer for firefox
		return strCurrenthandle;
	}
	
	/**
	 * Verifies if the Bright Star new tab and url match
	 * @param strParentWindowHandle Window handle of parent 
	 * @param strURL URL of brightstar
	 * @return true if the new tab is open and url matches
	 * @author Mirza.Kamran
	 */
	public boolean verifyBrightStarNewTabAndURL(String strParentWindowHandle, String strURL) {
		reusableActions.waitForNumberOfWindowsToBe(2, 80);
		reusableActions.switchToNewWindow(strParentWindowHandle);
		return (driver.getCurrentUrl().trim().contains(strURL)||
 				strURL.contains(driver.getCurrentUrl().trim()));
		
	}

	/**
	 * Data overage usage bar for demo-line overage scenarios
	 * @return true if the bar is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyYouHaveAnOverageUsageBarOrGradientIsDisplayed() {
		
		return reusableActions.isElementVisible(lblUsedDataOverageGradient);
	}
	
	/**
	 * Label on pop up "Add data to avoid further overage"
	 * @return true if the pop up is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelDataOverageSizeIsDisplayed() {
		
		return reusableActions.isElementVisible(lblOverageDataSize);
	}

	/**
	 * Verifies if the Add data button is displayed
	 * @return true if the add data button is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAddDataButtonIsDisplayed() {		
		return reusableActions.isElementVisible(btnAddData);
	}

	/**
	 * Attention symbol for overage is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAttentionOverageSymbolIsDisplayed() {		
		return reusableActions.isElementVisible(imgAttentionOverage);
	}

	/**
	 * To get the number of existing add on 
	 * @return integer, the number of existing add on.
	 */
	public int getAllExistingAddOns() {		
		return lstMyPlanAddOns.size();
	}
	
	/**
	 * Verifies if the added data is displayed separately in data details
	 * @return true if the new added count plus previous records matches total records else false
	 * @param listAddedData int, new added record count
	 * @param intCountOfSpeedPassBefore int, the previous record
	 * @author Mirza.Kamran
	 */
	public boolean verifyAddedDataInMyPlan(int listAddedData, int intCountOfSpeedPassBefore) {
		int totalSpeedPass = getAllExistingAddOns();		
		return totalSpeedPass == listAddedData + intCountOfSpeedPassBefore;
		
	}

	/**
	 * To get total number of all added data including canceled and active ones in my plan section.
	 * @return HasMap of active and canceled MDT records and nonMDT records.
	 * @author Mirza.Kamran
	 */
	public HashMap<String, Integer> getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection() {				
		int active=0;
		int cancelled=0;
		int nonMDT=0;
		HashMap<String, Integer> addData = new HashMap<String, Integer>();
		for(WebElement row:lstMyPlanAddOns)
		{
			if((/*row.getText().toLowerCase().contains("monthly data")&& */row.getText().contains("Expires"))
				||(/*row.getText().toLowerCase().contains("mensuel")&&*/ row.getText().contains("Prend")))
			{
				cancelled++;
				
			}else if((/*row.getText().toLowerCase().contains("monthly data")&&*/ row.getText().toLowerCase().contains("cancel"))
					||(/*row.getText().toLowerCase().contains("mensuel")&&*/ row.getText().toLowerCase().contains("Annuler")))
			{
				active++;
			}else
			{
				nonMDT++;
			}
		}
		
		addData.put("active", active);
		addData.put("cancelled", cancelled);
		addData.put("nonMDT", nonMDT);
		return addData;		
	}

	/**
	 * Verify the record of canceled MDT in my plan section.
	 * @param countOfNewlyCancelled, the record of newly canceled MDT in this run.
	 * @param countOfPreviousCancelled, the record of previous canceled MDT before run.
	 * @return true if the newly canceled MDT id included in the record.
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelledAddedDataInMyPlan(int countOfNewlyCancelled, int countOfPreviousCancelled) {
		int cancelled= getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection().get("cancelled");
		return (cancelled==(countOfNewlyCancelled+countOfPreviousCancelled));
	}

	/**
	 * Checks if the running low usage bar is displayed
	 * @return true if the usage bar running low is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isRunningLowUsageBarDisplayed() {
	
		return reusableActions.isElementVisible(lblYouAreRunningLow);
	}

	/**
	 * Checks if the running low Add data pop out is displayed
	 * @return true if the Add data pop out for running low is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isRunningLowPopOutAddDataDisplayed() {		
		return (reusableActions.isElementVisible(popOutRunningLow)
				&& reusableActions.isElementVisible(btnAddDataOnRunningLowPopOut)
				&& reusableActions.isElementVisible(btnCloseOnCallOut));
	}


	/**
	 * Verifies if the talk mins remaining is displayed
	 * @return true if the remaining minutes is displayed
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkRemainingMinutesIsDisplayed() {
		return reusableActions.isElementVisible(talkRemainingMinutes);
	}
	
	/**
	 * Verifies if the text mins remaining is displayed
	 * @return true if the text remaining is displayed
	 * @author Mirza.Kamran
	 */
	public boolean verifyTextRemainingIsDisplayed() {
		return reusableActions.isElementVisible(textRemaining);
	}


	/**
	 * Clicks on the view details link
	 * @author Mirza.Kamran
	 */
	public void clkViewDetailsMyPlan() {
		reusableActions.getWhenReady(lnkViewDetailsMyPlan).click();
	}
	
	/**
	 * Checks if talk and text section for mobile is displayed
	 * @return
	 */
	public boolean verifyTalkandTextPlanDetailsSectionIsDisplayedMobile() {		
		return reusableActions.isElementVisible(divTalkAndTextMobile);
	}


	/**
	 * Verifies if view details displayed below talk and text
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewDetailsIsDisplayedBelowTalkAndTextUnlimited() {
		return reusableActions.isElementVisible(lnkViewDetailsTalkAndText);
	}

	/**
	 * Check if the Remaining Fido Payment Program balance exists
	 * @return true if the balance is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isPaymentProgramBalanceVisible() {
		return reusableActions.isElementVisible(txtPaymentProgramBalance, 60);
	}

	/**
	 * Check if the Fido Payment Program agreement start date exists
	 * @return true if the start date is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isPaymentAgreementStartDateVisible() {
		return reusableActions.isElementVisible(txtPaymentAgreementStartDate, 60);
	}

	/**
	 * Check if the Fido Payment Program agreement end date exists
	 * @return true if the end date is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isPaymentAgreementEndDateVisible() {
		return reusableActions.isElementVisible(txtPaymentAgreementEndDate, 60);
	}


	/**
	 * Return the remaining balance for the device financing payment
	 * @return String of the remaining balance in the format: $xx.xx
	 * @author Rohit.Kumar
	 */
	public boolean getDeviceFinancingRemainingBalance() {
		return txtDeviceFinancingRemainingBalance.getAttribute("aria-label").replaceAll("[^0-9\\.," +
				"]", "").replace(",", ".").contains("0.00");
	}



	/**
	 * Check if the Fido Payment Program header exists
	 * @return true if the header is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isFidoPaymentProgramVisible() {
		System.out.println("Header: " + headerFidoPaymentProgram.getText());
		return reusableActions.isElementVisible(headerFidoPaymentProgram, 60);
	}

	/**
	 * Check if the "Find out your exclusive deals" text exists
	 * @return true if the text is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isFindOutYourExclusiveDealsTextVisible() {
		//System.out.println(txtFindOutYourExclusiveDeals.getText());
		return reusableActions.isElementVisible(txtFindOutYourExclusiveDeals, 60);
	}

	/**
	 * Check if the "get a new device link" exists
	 * @return true if the link is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isGetANewDeviceLinkVisible() {
		return reusableActions.isElementVisible(lnkGetANewDevice, 60);
	}

	/**
	 * Check if the "a price plan change may be required" text exists
	 * @return true if the text is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isPricePlanChangeMayBeRequiredTextVisible() {
		return reusableActions.isElementVisible(txtAPricePlanChangeMayBeRequired, 60);
	}

	/**
	 * Check if the "view fido payment program details" link exists
	 * @return true if the link is visible else false
	 * @author Rohit.Kumar
	 */
	public Boolean isViewFidoPaymentProgramDetailsLinkVisible() {
		return reusableActions.isElementVisible(lnkViewFidoPaymentProgramDetails, 60);
	}

/**
	 * checks if the thanks message is displayed in My Device Dashboard
	 * @return true if the element is displayed else false
	 * @author Rajat.Sharma
	 */
	public boolean verifyMyDeviceThanksMessageIsDisplayed() {

		return reusableActions.isElementVisible(msgMyDeviceThanks, 60);

	}

	/**
	 * checks if the Get A New Device link is displayed in My Device Dashboard
	 * @return true if the element is displayed else false
	 * @author Rajat.Sharma
	 */
	public boolean verifyMyDeviceGetANewDeviceLnkIsDisplayed() {

		return reusableActions.isElementVisible(lnkGetANewDevice, 60);

	}

	/**
	 * checks if the Device remaining balance exits
	 * @return true if the amount is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyDeviceRemainingExists() {

		String deviceBalance = txtDeviceRemainingBalance.getAttribute("aria-label").replaceAll("[^0-9\\$.," +
				"]", "").replace(",", ".");

		return deviceBalance.contains("$");
	}

    /**
     * Verify the 'UPGRADE DEVICE' button Exists
     * @author Rohit.Kumar
     */
    public boolean verifyUpgradeDeviceButtonExists() {

        return reusableActions.isElementVisible(btnUpgradeDevice, 60);
    }

	/**
	 * Verify the device name Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyDeviceNameExists() {

		return reusableActions.isElementVisible(txtDeviceName, 60);
	}

	/**
	 * Verify the Subsidy End Date Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifySubsidyEndDateExists() {

		return reusableActions.isElementVisible(txtSubsidyEndDate, 60);
	}

//////

	/**
	 * click Fido Payment Program Details Link
	 * @author Rohit.Kumar
	 */
	public void ClickFidoPaymentProgramDetailsLink() {

		reusableActions.waitForElementTobeClickable(lnkViewFidoPaymentProgramDetails, 240);
		reusableActions.clickWhenReady(lnkViewFidoPaymentProgramDetails);
	}


	/**
	 * Verify the Activation Date Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyActivationDateExists() {

		return reusableActions.isElementVisible(txtActivationDate, 60);
	}


	/**
	 * Verify Fido Payment Program Balance Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyFidoPaymentProgramBalanceExists() {

		return reusableActions.isElementVisible(txtFidoPaymentProgramBalance, 60);
	}


	/**
	 * Verify Fido Payment Program Balance Total Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyFidoPaymentProgramBalanceTotalExists() {

		return reusableActions.isElementVisible(txtFidoProgramBalanceTotal, 60);
	}

	/**
	 * Verify Fido Payment Program Balance Base Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyFidoPaymentProgramBalanceBaseExists() {

		return reusableActions.isElementVisible(txtFidoProgramBalanceBase, 60);
	}

	/**
	 * Verify Fido Payment Program Balance Tax Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyFidoPaymentProgramBalanceTaxExists() {

		return reusableActions.isElementVisible(txtFidoProgramBalanceTax, 60);
	}


	/**
	 * Verify Fido Total Monthly Payment Program Payment Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyTotalMonthlyFidoPaymentProgramPaymentExists() {

		return reusableActions.isElementVisible(txtTotalMonthlyFidoProgramPayment, 60);
	}

	/**
	 * Verify Fido Monthly Payment Program Payment Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyMonthlyFidoPaymentProgramPaymentExists() {

		return reusableActions.isElementVisible(txtMonthlyFidoProgramPayment, 60);
	}


	/**
	 * Verify Fido Monthly Financed Tax Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyMonthlyFinancedTaxesExists() {

		return reusableActions.isElementVisible(txtMonthlyFinancedTaxes, 60);
	}

	/**
	 * Verify Fido Months Remaining Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyMonthRemainingExists() {

		return reusableActions.isElementVisible(txtMonthsRemaining, 60);
	}

	/**
	 * click Fido Payment Program Details Header
	 * @author Rohit.Kumar
	 */
	public void ClickFidoPaymentProgramDetails() {

		reusableActions.waitForElementTobeClickable(FidoPaymentProgramDetailsHeader, 240);
		reusableActions.clickWhenReady(FidoPaymentProgramDetailsHeader);
	}


	/**
	 * Verify Legal Copy for Financing Program Exists
	 * @author Rohit.Kumar
	 */
	public boolean verifyLegalCopyForFinancialProgramExists() {

		return reusableActions.isElementVisible(FidoPaymentProgramDetailsHeaderParagraph, 60);
	}

	/**
	 * Select values from dropdown 'Select Another Line'
	 * @author sidhartha.vadrevu
	 */
	public void setDrpSelectAnotherLine(String changedCTNValue) {
		new Select(drpSelectAnotherLine).selectByValue(changedCTNValue);
	}

}
