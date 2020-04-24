package ca.fido.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;
import ca.fido.test.helpers.StringHelpers;

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

	
	@FindBy (xpath = "//span[@translate='wireless.dashboard.quickActions.quickActions04']")
	WebElement lnkUpdateSimCard;
	
	@FindBy (xpath = "//input[@name='oldSimNumber']")
	WebElement txtOldSimNum;
	
	@FindBy (xpath = "//input[@name='newSimNumber']")
	WebElement txtNewSimNum;
	
	@FindBy (xpath = "//button[@translate='global.cta.next']")
	WebElement btnUpdateSimNext;
	
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
	
	//My Plan section
	@FindBy (xpath = "//div[contains(@class,'ss-plan-container-box ng-star-inserted') ]")
	WebElement divMyPlan;
	
	@FindBy (xpath="//h3[@class='ss-plan-container-sub-heading']")
	WebElement lblPlanNameheading;
	
	@FindBy (xpath = "//span[@class='ss-plan-container-data']")
	WebElement lblPlanData;
	
	@FindBy (xpath = "//button/span[text()='CHANGE PLAN' or text()='CHANGER DE FORFAIT']")
	WebElement btnChangePlan;	
	
	@FindBy (xpath = "//span[@translate='wireless.dashboard.myPlan.planDetailsModel.fullPlanDetails']")
	WebElement headerFullPlanDetailsOverlay;
	
	@FindBy (xpath = "//button[@aria-label='Close' or @aria-label='Fermer']")
	WebElement btnCloseFullPlanDetailsOverlay;
	
	@FindBy (xpath = "//span[@translate='wireless.dashboard.myPlan.talk']")
	WebElement divMyPlanTalkDetails;
	
	@FindBy (xpath = "//span[@translate='wireless.dashboard.myPlan.text']")
	WebElement divMyPlanText;
	
	@FindBy (xpath = "//img[@class='hours-data']")
	WebElement imgPlanBenefitsHoursOfData;
	
	@FindBy (xpath = "//img[@class='fido-xtra']")
	WebElement imgPlanBenefitsXtra;
	
	@FindBy (xpath = "//img[@class='fido-roam']")
	WebElement imgPlanBenefitsRoam;
	
	@FindBy (xpath = "//span[@translate='wireless.dashboard.myPlan.viewFullPlanCTA']")
	WebElement lnkViewFullPlan;
	
	//My device Section
	
	@FindBy (xpath = "//div[@translate='wirelessDashboard.deviceSection.deviceTitle']/parent::div/following-sibling::div[contains(@class,'device-wrapper')]")
	WebElement divMyDevice;
		
	@FindBy (xpath = "//span[@translate='wireless.dashboard.quickActions.quickActions03']")
	WebElement lnkReportLostOrStolenCard;
			
	//--- New data section on dashboard
	
	@FindBy (xpath = "//*[@class='ss-used-data-data-balance']/span[1]")
	WebElement divDataBalanceRemaining;
	
	@FindBy (xpath = "//div[@class='ss-data-section-total-volume']")
	WebElement divTotalData;
	
	@FindBy (xpath = "//p[contains(text(),'Minutes')]")
	WebElement txtRemainMinutes;
	
	@FindBy (xpath = "//h4[@class='talk-text-limited-heading']/span")
	WebElement spanRemainingMinutes;
	
	@FindBy (xpath = "//td[text()='Tout Temps' or text()='Anytime']")
	WebElement tdAnytime;
	
	@FindBy (xpath = "//td[contains(text(),'Soirs/w-end') or contains(text(),'Evenings')]")
	WebElement tdEvening;
	
	@FindBy (xpath = "//td[text()='Tout Temps' or text()='Anytime']/following-sibling::td[1]")
	WebElement tdAnytimeTotal;
	
	@FindBy (xpath = "//td[text()='Tout Temps' or text()='Anytime']/following-sibling::td[@class='usage-content']/div")
	WebElement divAnytimeUsed;
	
	@FindBy (xpath = "//div[@translate='usageModule.talkAndText.talkTextTitle']")
	WebElement divTalkNTextUsage;
	
	@FindBy (xpath = "//p[contains(text(),'remaining') or contains(text(),'restantes')]")
	WebElement limitedTalkUsage;
	
	@FindBy (xpath = "//span[text()='minutes']/parent::h4/following-sibling::p")
	WebElement unlimitedTalkUsage;
	
	@FindBy(xpath = "//div[@class='talk-text-usage']//span[contains(text(),'Textos') or contains(text(),'Text')]")
	WebElement divTextUsage;
	
	@FindBy (xpath = "//div[@class='talk-text-usage-wrap']//*[contains(text(),'Textos') or contains(text(),'Text')]")
	WebElement textUsageInTalkNTextOnly;
	
	@FindBy (xpath = "//td[contains(text(),'Picture') or contains(text(),'photo')]")
	WebElement tdPictureMsg;
	
	@FindBy (xpath = "//td[contains(text(),'Bundles') or contains(text(),'Trousses')]")
	WebElement tdBundlesMsg;
	
	@FindBy (xpath = "//td[contains(text(),'International') or contains(text(),'Internationaux')]")
	WebElement tdInternationalMsg;
	
	@FindBy(xpath = "//span[@translate='usageModule.nonRealTimeLabel']")
	WebElement divDataDelayedAlert;
	
	@FindBy(xpath = "//div[@class='ss-data-section-bill-cycle']")
	WebElement divBillCycle;
	
	@FindBy(xpath = "//span[@class='ss-plan-container-dollar-amount']")
	WebElement divSSPlanAmount;
	
	@FindBy(xpath = "//div[@class='ss-data-usage-bar-total-data']")
	WebElement divUsageBarValue;
	
	@FindBy(xpath = "//div[@class='ss-data-usage-bar-background']")
	WebElement divUsageBar;
	
	@FindBy (xpath = "//ins[contains(text(),'days remaining') or contains(text(),'jours à votre cycle')]")
	WebElement daysRemainingofBillCycle;
	
	@FindBy(xpath = "//button[@translate='wirelessDashboard.deviceSection.upgradeBtnText']")
	WebElement btnUpgradeDevice;
	
	@FindBy(xpath = "//a//span[@translate='wireless.dashboard.quickActions.quickActions05']")
	WebElement lnkChangeMyNumber;

	@FindBy (xpath = "//button[@translate='wirelessDashboard.deviceSection.reserveNewPhone']")
	WebElement btnReserveNewPhone;
	
	@FindBy (xpath = "//button[@translate='wirelessDashboard.deviceSection.modalMessages.statusReserve']")
	WebElement btnReserve;

	@FindBy (xpath = "//a/span[@translate='wireless.dashboard.quickActions.quickActions02']")
	WebElement lnkResetVoiceMailPassword;
	
	@FindBy (xpath = "//div[@cdktrapfocus]//button[@title='Close']")
	WebElement btnCloseOnPopup;
	
	@FindBy (xpath = "//span[@translate=\"wireless.dashboard.quickActions.quickActions03\"]")
	WebElement lnkReportLostOrStolen;
	
	@FindBy (xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions01\"]")
	WebElement lnkChangeCallDisplayName;

	@FindBy(xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions04\"]")
	WebElement lnkUpdateSIMCard;
	
	@FindBy(xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions07\"]")
	WebElement lnkRetreivePUKCode;
	
	@FindBy(xpath = "//a/span[@translate=\"wireless.dashboard.quickActions.quickActions05\"]")
	WebElement lnlChangeMyNumber;
	
	@FindBy(xpath = "//button[@class='ss-data-usage-ondemand-button']")
	WebElement lnkShowMyUsage;
	
	//=== Add data section for demoline accounts
	
	@FindBy(xpath = "//div[@class='ss-data-section-add-icon']/span[text()='+']")
	WebElement btnAddData;

	@FindBy(xpath = "//ins[@translate='ute.purchaseData.continue']/parent::button/parent::div/following-sibling::a/ins[@translate='ute.purchaseData.backBtn']/parent::a")
	WebElement btnCancelMonthlyDataPlan;	

	@FindBy (xpath = "//fds-link[@class='ng-star-inserted']")
	WebElement lnkReactivate;

	@FindBy (xpath = "//span[@translate='usageModule.manage']")
	WebElement lnkViewDetailsInUsageSection;
	
	@FindBy(xpath="//div[contains(@class,'wireless-dashboard')]/div[contains(@class,'wireless-title')]")
	WebElement lblMobileDashboardTitle;
	
	@FindBy(xpath="//span[@translate='wireless.dashboard.quickActions.quickActions08']")
	WebElement lnkRepairMobile;

	@FindBy(xpath = "//button[@translate='global.cta.continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h2[@translate='wireless.dashboard.quickActions.trackRepairClaim.heading']")
	WebElement lblGetHelpForYourPhoneOverlay;

	@FindBy(xpath = "//*[text()='Add data to avoid further overage charges']")
	WebElement lblAddDataToAvoidFurtherOverage;
	
	@FindBy(xpath = "//*[@class='ss-used-data-data-size']")
	WebElement lblOverageDataSize;

	@FindBy(xpath = "//*[@class='ss-used-data-overage-gradient']")
	WebElement lblUsedDataOverageGradient;
	
	@FindBy(xpath = "//img[@alt='Attention']")
	WebElement imgAttentionOverage;
	
	@FindBy(xpath = "//span[@translate='wireless.dashboard.myPlan.addOns']/ancestor::div[contains(@class,'addons')]//li")
	List<WebElement> lstMyPlanAddOns;

	@FindBy(xpath = "//*[@translate='usageModule.runningLow.title']") 
	WebElement lblYouAreRunningLow;
	
	@FindBy(xpath = "//div[@class='data-callout-wrapper running-low']")
	WebElement popOutRunningLow;
	
	@FindBy(xpath = "//span[@translate='usageModule.addData']")
	WebElement btnAddDataOnRunningLowPopOut;
	
	@FindBy(xpath = "//div[@class='data-callout-wrapper running-low']/div[@title='Close' or @title='Fermer']")
	WebElement btnCloseOnCallOut;
	
	/**
	 * Clicks on the add data button for demoline accounts only
	 * @author Mirza.Kamran
	 */
	public void clkAddDataButton() {
		reusableActions.getWhenReady(btnAddData).click();
	}

	
	/**
	 * Perform click on view details link in usage section
	 * @author ning.xue
	 */
	public void clkLinkViewDetailInUsage() {	
		reusableActions.waitForElementTobeClickable(lnkViewDetailsInUsageSection, 60);
		reusableActions.getWhenReady(lnkViewDetailsInUsageSection,20).click();
	}
		
	/**
	 * Clicks show my usage link if the dashborad displays this link
	 * @author Mirza.Kamran
	 */
	public void clkShowMyUsageIfVisible() {

		reusableActions.clickIfAvailable(lnkShowMyUsage, 10);
	}
	
	/**
	 * Close the overlay pop up for new look notification. 
	 * @author ning.xue
	 */
	public void closeOverlayPopup() {
		reusableActions.clickIfAvailable(btnCloseOnPopup, 30);
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
		return reusableActions.isElementVisible(lnkReactivate, 60);
	}
	
	/**
	 * click the link to reactivate account on wireless dashboard
	 * @author ning.xue
	 */
	public void clkLnkReactivate() { 
		reusableActions.getWhenReady(lnkReactivate, 60).click();		
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
		return reusableActions.isDisplayed(divTalkNTextUsage);
	} 
	
	/**
	 * checks talk usage is displayed in wireless dash board, talk could be unlimited or limited.
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyTalkUsageSectionofFullPlanIsDisplayed() {
		System.out.println("Talk usage details message is being checked");
		return (reusableActions.isDisplayed(limitedTalkUsage)
				||reusableActions.isDisplayed(unlimitedTalkUsage));
	}
	
	/**
	 * checks if talk plan is unlimited.
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyUnlimitedTalkUsageIsDisplayed() {
		System.out.println("Talk usage is unlimited or not being checked");
		return (reusableActions.isDisplayed(unlimitedTalkUsage));
	}
	
	/**
	 * checks talk usage is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkUsageDetailsofTalkTextOnlyPlanIsDisplayed() {
		System.out.println("Talk usage details is being checked");
		return reusableActions.isDisplayed(txtRemainMinutes);
	}	
	
	/**
	 * checks talk usage Anytime section detail is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkAnytimeUsageDetailsIsDisplayed() {
		System.out.println("Talk any time usage details is being checked");
		return reusableActions.isDisplayed(tdAnytime);
	}	
	
	/**
	 * checks talk evening and weekend usage section detail is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkEveningUsageDetailsIsDisplayed() {
		System.out.println("Talk evening and weekend usage details is being checked");
		return reusableActions.isDisplayed(tdEvening);
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
		return reusableActions.isDisplayed(divTextUsage);
	}	
	
	/**
	 * checks text usage of Talk and Text only plan is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyTextUsageDetailsOfTalkNTextOnlyIsDisplayed() {
		System.out.println("Text usage details is being checked");
		return reusableActions.isDisplayed(textUsageInTalkNTextOnly);
	}
	
	/**
	 * checks text usage picture message part is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyPictureMsgDetailsIsDisplayed() {
		System.out.println("Text usage details, picture message is being checked");
		return reusableActions.isDisplayed(tdPictureMsg);
	}	
	
	/**
	 * checks text usage bundles message part is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyBundlesMsgDetailsIsDisplayed() {
		System.out.println("Text usage details, bundles message is being checked");
		return reusableActions.isDisplayed(tdBundlesMsg);
	}	
	
	/**
	 * checks text usage International message part is displayed in wireless dash board
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyInternationalMsgDetailsIsDisplayed() {
		System.out.println("Text usage details, International message is being checked");
		return reusableActions.isDisplayed(tdInternationalMsg);
	}	
	
	/**
	 * checks text plan dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTextPlanDetailsSectionIsDisplayed() {
		System.out.println("text plans details is being checked");
		return reusableActions.isDisplayed(divMyPlanText);
	}	
	
	/**
	 * checks talk plan dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkPlanDetailsSectionIsDisplayed() {
		System.out.println("talk plans details is being checked");
		return reusableActions.isDisplayed(divMyPlanTalkDetails);
	}
	
	/**
	 * checks data delayed label in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelDataDelayedIsDisplayed() {
		System.out.println("Labeldata delayed is being checked");
		return reusableActions.isDisplayed(divDataDelayedAlert);
	} 
	
	/**
	 * checks Days remaining in bill cycle in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Ning.Xue
	 */
	public boolean verifyDaysRemainingInBillCycleIsDisplayed() {
		System.out.println("Days remaining in bill cycle is being checked");
		return reusableActions.isDisplayed(daysRemainingofBillCycle);
	}
	
	/**
	 * checks Total data section in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTotalDataInUsageSectionIsDisplayed() {
		try {
			System.out.println("Total data section is being checked");
			return reusableActions.isDisplayed(divTotalData);
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
		return Double.parseDouble(divTotalData.getText().trim()) == addedDataValue + previousTotalDataValue;
	}
		
	
	/**
	 * Verify total data in data usage section align with the total data in Manage Data page
	 * @param totalDataValue, the value of total data in data usage section
	 * @param totalDataInManageDataPage, the value of total data in manage data page, including plan data and add-ons.
	 * @return true, if the total data align with each other
	 * @author ning.xue
	 */
	public boolean verifyTotalDataAlignWithManageDataPage(double totalDataValue, double totalDataInManageDataPage) {
		return totalDataValue == totalDataInManageDataPage;
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
		return Double.parseDouble(divDataBalanceRemaining.getText().replaceAll(",", ".").trim());
	}
	
	/**
	 * Verify remaining data in data usage section reflected added data
	 * @param previousRemainingDataValue, the value of remaining data before add data
	 * @param addedDataValue, the value of successfully added data
	 * @return true, if the remaining data reflected added data
	 * @author ning.xue
	 */
	public boolean verifyRemainingDataReflectedAddedData(double previousRemainingDataValue, double addedDataValue) {
		return Double.parseDouble(divDataBalanceRemaining.getText().trim()) == addedDataValue + previousRemainingDataValue;
	}
	
	/**
	 * checks Usage Bar section in Data dashboard is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataDashBoardUsageBarIsDisplayed() {
		try {
			System.out.println("data balance Usage Bar is being checked");
			return (reusableActions.isDisplayed(divUsageBar) &&  reusableActions.isDisplayed(divUsageBarValue));
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
		reusableActions.clickIfAvailable(lnkViewFullPlan);
		reusableActions.waitForElementTobeClickable(headerFullPlanDetailsOverlay, 30);		
		if(!reusableActions.isElementVisible(headerFullPlanDetailsOverlay))
		{		
			
			System.out.println("View full plan details link did not open the expected overlay, please investigate");			
			return false;			
		}
		reusableActions.clickIfAvailable(btnCloseFullPlanDetailsOverlay);
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
		return reusableActions.isDisplayed(btnChangePlan);
				
	}
	
	/**
	 * checks My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyMobilePlanDashBoardSectionIsDisplayed() {
		System.out.println("My Mobile plan usage section is being checked");
		return reusableActions.isDisplayed(divMyPlan);
				
	}
	

	/**
	 * checks link view full plan details on My Mobile Plan section on dashboard page is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkViewFullPlanDetailsOnMyMobilePlanDashBoardSectionIsDisplayed() {
		System.out.println("Link  is being checked");
		return reusableActions.isDisplayed(lnkViewFullPlan);
				
	}
	
	
	/**
	 * This method will verify the Device details section
	 * @return returns boolean
	 * @author Mirza.Kamran
	 */
	public Boolean verifyMyDeviceDetails() {
				
	return reusableActions.isDisplayed(divMyDevice); 

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
		return reusableActions.isDisplayed(lnkChangeCallDisplayName);
	}
	
	/**
	 * Check if the link Chnage My Number is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkChangeMyNumberIsDisplayed() {
		return reusableActions.isDisplayed(lnkChangeMyNumber);
	}
	
	/**
	 * Check if the link Update Sim Card is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkUpdateSIMCardIsDisplayed() {
		return reusableActions.isDisplayed(lnkUpdateSimCard);
	}
		
	
	/**
	 * Check if the link Lost and found is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkReportLostOrStolenIsDisplayed() {
		return reusableActions.isDisplayed(lnkReportLostOrStolen);
	}
	
	
	/**
	 * Check if the link Retrieve PUK code is is displayed
	 * @return true when the link is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRetrievePUKCodeIsDisplayed() {
		return reusableActions.isDisplayed(lnkRetreivePUKCode);
	}
	
	/**
	 * This method will click on link and validate if the links are correct and new window is open 
	 * @param strLinkText The link name as visible on UI 
	 * @param strNewWindowTitle The title of the new window after the link is click
	 * @return boolean, true if the title matches.
	 * @author Mirza.Kamran
	 */
	public boolean clickAndVerifyLinkForNewWindow(String strLinkText, String strNewWindowTitle) {
		String parentHandle=reusableActions.getDriver().getWindowHandle();
		reusableActions.clickIfAvailable(By.partialLinkText(strLinkText));
		reusableActions.waitForNumberOfWindowsToBe(2);
		reusableActions.switchToNewWindow(parentHandle);
		if(reusableActions.getDriver().getTitle().trim().toLowerCase().equals(strNewWindowTitle.trim().toLowerCase()))
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
		return reusableActions.isDisplayed(lblMobileDashboardTitle);
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
		return reusableActions.isDisplayed(lnkRepairMobile);
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
	
	/**
	 * Clicks on the button continue on repair device overlay
	 * @return returns current window handle
	 * @author Mirza.Kamran
	 */
	public String clkButtonContinueOnRepairDeviceOverlay() {
		String strCurrenthandle = reusableActions.getDriver().getWindowHandle();
		reusableActions.clickWhenReady(btnContinue);
		reusableActions.staticWait(3000);// adding static buffer for firefox
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
		reusableActions.waitForNumberOfWindowsToBe(2, 60);
		reusableActions.switchToNewWindow(strParentWindowHandle);
		return reusableActions.getDriver().getCurrentUrl().trim().equals(strURL);
		
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
			if((row.getText().toLowerCase().contains("monthly data")&& row.getText().toLowerCase().contains("expires"))
				||(row.getText().toLowerCase().contains("mensuel")&& row.getText().toLowerCase().contains("expiration")))
			{
				cancelled++;
				
			}else if((row.getText().toLowerCase().contains("monthly data")&& !row.getText().toLowerCase().contains("expires"))
					||(row.getText().toLowerCase().contains("mensuel")&& !row.getText().toLowerCase().contains("expiration")))
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
	 * 
	 * @param mapCountOfAlreadyAddedData Contains all added values and their count
	 * @return
	 */
	public boolean clkTheDataAddOnWhichAreNotAddedMoreThanThreeTime(Map<String, Integer> mapCountOfAlreadyAddedData) {
		boolean foundLessThanThree = false;
		reusableActions.waitForElementVisibility(btnsSelectDataOnAddDataOverLay.get(0), 60);
		for(WebElement btn: btnsSelectDataOnAddDataOverLay)
		{
			String addedvalue = StringHelpers.getNumbersFromString(btn.getText());
			if(mapCountOfAlreadyAddedData.containsKey(addedvalue))
			{
				if(mapCountOfAlreadyAddedData.get(addedvalue)<3)
				{
					btn.click();
					foundLessThanThree = true;
					break;
				}
			
			}else
			{
				btn.click();
				foundLessThanThree = true;
				break;
			}
		}
		return foundLessThanThree;
		
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
}
