package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FidoInternetDashboardPage extends BasePageClass {

	public FidoInternetDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[.//ins[@translate='global.label.changePackage']]")
	WebElement lnkChangePackage;
	
	@FindBy(xpath="//ins[@translate='global.cta.confirm']/parent::button")
	WebElement btnConfirmPackageChange;
	
	@FindBy(xpath="//ins[@translate='global.label.cannotProceed']")
	WebElement popupDowngrade;
	
	@FindBy(xpath="//div[@class='package-item-dashboard']")
	WebElement infoPlan;
	
	@FindBy(xpath="//div[@class='col-sm-4 text-center']")
	WebElement infoUsage;
	
	@FindBy(xpath="//div[@ng-if=\"dailyChartStatus==='SUCCESS'\"]")
	WebElement infoDailyUsageChart;
	
	@FindBy(xpath="//a[@href='#/my-account/internet/usage/daily']")
	WebElement lnkDailyUsage;
	
	@FindBy(xpath="//a[@href='#/my-account/internet/usage/monthly']")
	WebElement lnkMonthlyUsage;
	
	@FindBy(xpath="//ins[@translate='global.cta.continue']")
	WebElement btnContinueForInternet;
	
	@FindBy(xpath = "//ins[@translate='global.cta.checkAvailability']")
	WebElement btnCheckAvailability;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement popupDowngradeWithSameDownloadSpead;
		
	//Data View
	@FindBy(xpath = "//div[@class='usage-dial']//span[@class='inner-circle']//span[text()='Data']")
	WebElement divDataCircle;
	
	@FindBy(xpath = "//span[text()='Data']//ancestor::div[@class=\"usage-dial\"]")
	WebElement divDataUsageArea;
	
	@FindBy(xpath ="//span[text()='Data']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//span[@class='amount']")
	WebElement divDataPlan;		

	@FindBy(xpath ="//span[text()='Data']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//span[@class='remaining']")
	WebElement divremainingDataPlan;

	@FindBy(xpath ="//span[text()='Data']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//ins[text()='View']")
	WebElement btnViewDataPlanDetails;
	
	@FindBy(xpath ="//span[text()='Data']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//ins[text()='Close']")
	WebElement btnClose;

	@FindBy(xpath ="//div[@collapse='dataIsCollapsed']//span[text()='Included']/parent::div/following-sibling::div//span[@class='usage-amount']//ins[@ng-switch-when='D']")
	WebElement divIncudedDataPlan;

	@FindBy(xpath ="//div[@collapse='dataIsCollapsed']//span[text()='My Usage']/parent::div/following-sibling::div//span[@class='usage-amount']//ins[@ng-switch-when='D']")
	WebElement divMyUsageData;

	@FindBy(xpath ="//div[@collapse='dataIsCollapsed']//span[text()='Remaining']/parent::div/following-sibling::div//span[@class='usage-amount']//ins[@ng-switch-when='D']")
	WebElement divremainingData;
	
	//Talk View - Obsolete
	@FindBy(xpath = "//div[@class='usage-dial']//span[@class='inner-circle']//span[text()='Talk']")
	WebElement divTalkCircle;
	
	@FindBy(xpath = "//span[text()='Talk']//ancestor::div[@class=\"usage-dial\"]")
	WebElement divTalkUsageArea;
	
	@FindBy(xpath ="//span[text()='Talk']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//span[@class='amount']")
	WebElement divTalkPlan;		
	
	@FindBy(xpath ="//span[text()='Talk']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//span[@class='remaining']")
	WebElement divTalkRemaining;		
	
	@FindBy(xpath ="//span[text()='Talk']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//ins[text()='View']")
	WebElement btnViewTalkPlanDetails;
	
	@FindBy(xpath ="//span[text()='Talk']//ancestor::div[@class='usage-dial']//span[@class='inner-circle']//ins[text()='Close']")
	WebElement btnTalkDetailsClose;
	
	@FindBy(xpath = "//b[@ng-bind-template='200  GB' or @ng-bind-template='200  GO']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//button[@ute-tracking='internet:package:selector:offerchange']")
	WebElement btnFidoHSIPlan;
	
	
	//Weekday talk - Obsolete	
	@FindBy(xpath = "//div[@collapse='dataIsCollapsed']//span[text()='Included']/parent::div/following-sibling::div//span[@class='usage-amount']//ins[@ng-switch-when='V']")
	WebElement divWeekDayIncludedTalk;
	
	@FindBy(xpath = "//div[@collapse='dataIsCollapsed']//span[text()='My Usage']/parent::div/following-sibling::div//span[@class='usage-amount']//ins[@ng-switch-when='V']")
	WebElement divWeekDayMyUsageTalk;
	
	@FindBy(xpath = "//div[@collapse='dataIsCollapsed']//span[text()='Remaining']/parent::div/following-sibling::div//span[@class='usage-amount']//ins[@ng-switch-when='V']")
	WebElement divWeekDayRemainingTalk;		
	
	//Evenings and weekends
	@FindBy(xpath = "//span[text()='Evenings and Weekends']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='Included']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divEveAndWeekEndsIncludedTalk;
	
	@FindBy(xpath = "//span[text()='Evenings and Weekends']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='My Usage']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divEveAndWeekEndsMyUsageTalk;
		
	//Text View
	@FindBy(xpath = "//div[@class='unlimited center']//span[text()='Text']")
	WebElement divTextCircle;
	
	@FindBy(xpath ="//span[text()='Text']//following-sibling::span[@class='subtxt']")
	WebElement divTextPlan;		
	
	//Pictute/Video Messages
	@FindBy(xpath = "//span[text()='Text']//ancestor::div[@class='usage-dial']//ins[text()='Picture/video Messages']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='Included']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divPicVidIncludedText;
	
	@FindBy(xpath = "//span[text()='Text']//ancestor::div[@class='usage-dial']//ins[text()='Picture/video Messages']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='My Usage']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divPicVidMyUsageText;
	
	//Bundle Messages
	@FindBy(xpath = "//span[text()='Text']//ancestor::div[@class='usage-dial']//ins[text()='Bundles Messages']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='Included']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divBundleMsgIncludedText;
			
	@FindBy(xpath = "//span[text()='Text']//ancestor::div[@class='usage-dial']//ins[text()='Bundles Messages']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='My Usage']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divBundleMsgMyUsageText;
	
	//International Messaging	
	@FindBy(xpath ="//span[text()='Text']//ancestor::div[@class='usage-dial']//ins[text()='International Messaging']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='Included']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divIntlMsgIncludedText;
	
	@FindBy(xpath = "//span[text()='Text']//ancestor::div[@class='usage-dial']//ins[text()='International Messaging']//ancestor::div[@ng-repeat='sum in category.dataArr']//span[text()='My Usage']/parent::div/following-sibling::div//span[@class='usage-amount']")
	WebElement divIntlMsgMyUsageText;
	
	@FindBy(xpath ="//div[@class='closingTongue usageNormal unlimited view']")
	WebElement btnViewTextPlanDetails;
	
	@FindBy(xpath ="//div[@class='closingTongue usageNormal unlimited']")
	WebElement btntextDetailsClose;
	
	@FindBy(xpath = "//span[text()='Text']//ancestor::div[@class='usage-dial']")
	WebElement divTextUsageArea;
	
	//My Plan section
	@FindBy(xpath = "//div[@class='ss-plan-container-box']")
	WebElement divMyPlan;
	
	@FindBy(xpath="//h3[@class='ss-plan-container-sub-heading']")
	WebElement lblPlanNameheading;

	@FindBy(xpath = "//span[@class='ss-plan-container-data']")
	WebElement lblPlanData;
	
	@FindBy(xpath = "//button/span[text()='CHANGE PLAN']")
	WebElement btnChangePlan;
	
	@FindBy(xpath = "ute-tracking='wirelesshome:upgradedevice'")
	WebElement btnUpgradeDevice;
	
	@FindBy(xpath = "//ins[text()='Reserve a new phone']")
	WebElement btnReserveANewDevice;
	
	@FindBy(xpath = "//div[@class=\"plan-details-modal\"]")
	WebElement divFullPlanDetailsOverlay;
	
	//My device Section	
	@FindBy(xpath = "//my-device[@class='my_device_wrapper']")
	WebElement divMyDevice;
	
	@FindBy(partialLinkText = "View full plan details")
	WebElement lnkViewFullPlanDetails;

	@FindBy(partialLinkText = "Change call display name")
	WebElement lnkChangeCallDisplayName;

	@FindBy(partialLinkText = "Reset voicemail password")
	WebElement lnkResetVoicemailPassword;

	@FindBy(partialLinkText = "Report lost or stolen device")
	WebElement lnkReportLostOrStolenCard;

	@FindBy(partialLinkText = "Update SIM Card")
	WebElement lnkUpdateSimCard;

	@FindBy(partialLinkText = "Change my number")
	WebElement lnkChangeMyNumber;
	
	@FindBy(partialLinkText = "Retrieve PUK Code")
	WebElement lnkRetreivePUKCode;
	
	//--- New data section on dashborad	
	@FindBy(xpath = "//div[@class='ss-used-data-data-balance']")
	WebElement divDataBalanceRemaining;
	
	@FindBy(xpath = "//div[@class='ss-data-section-total-volume']")
	WebElement divTotalData;
	
	@FindBy(xpath = "//div[@class='talk-usage']")
	WebElement divTalkUsagePlan;
	
	@FindBy(xpath = "//div[@class='text-usage']")
	WebElement divTextUsagePlan;
	
	@FindBy(xpath = "//span[text()='Data delayed by 12 hours']")
	WebElement divDataDelayedAlert;
	
	@FindBy(xpath = "//div[@class='ss-data-section-bill-cycle']")
	WebElement divBillCycle;

	@FindBy(xpath = "//a[@href='#/my-account/internet/usage/daily']")
	WebElement linkDailyUsage;

	@FindBy(xpath = "//a[@href='#/my-account/internet/usage/monthly']")
	WebElement linkMonthlyUsage;

	@FindBy (xpath = "//ins[@translate='global.label.services']")
	WebElement navUsageNService;

	@FindBy(xpath = "//ins[@translate='global.label.profileAndSettings']")
	WebElement navProfileNSettings;
	
	@FindBy (xpath = "//ins[@translate='global.label.internet']")
	WebElement navInternetService;
	
	@FindBy (xpath = "//ins[@translate='global.cta.manageSettings']")
	WebElement btnManageSettings;

	@FindBy (xpath = "//ins[@translate='global.cta.restartModem']")
	WebElement btnRestartModem;

	@FindBy (xpath = "//ins[@translate='global.label.internetPlans']")
	WebElement lblInternetPlans;

	@FindBy (xpath = "//div[@class='modal-margin-top']")
	WebElement mdlModemRestart;

	@FindBy (xpath = "//ins[@translate='global.cta.yesRestartModem']")
	WebElement btnYesRestartModem;

	@FindBy (xpath = "//ins[@translate='global.label.success']")
	WebElement mdlSuccess;


	/**
	 * Click the view/ChangePackage link from the top tile bar on Home page
	 * @author aditya.dhingra
	 */
	public void clkChangePackage() {
		reusableActions.waitForElementVisibility(lnkChangePackage,120);
		reusableActions.getWhenReady(lnkChangePackage,30);
		reusableActions.getWhenReady(lnkChangePackage,30).click();
		reusableActions.javascriptScrollToMiddleOfPage();
	}
	
	public void clkChangePackageSsp() {
		reusableActions.waitForElementVisibility(lnkChangePackage,120);
		reusableActions.getWhenReady(lnkChangePackage,90).click();
	}

	/**
	 * Select the HSI package provide the input package base on bandwidth
	 * @param strBandwidth bandwidth of the package to be selected 
	 * @author aditya.dhingra
	 */
	public void selectHSIPackageByBandwidth(String strBandwidth) {
		reusableActions.staticWait(5000);
		By packageNameLocator = By.xpath("//span[@ng-bind='tier.speed.download' and text()='"+strBandwidth+"']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//button[@ute-tracking='internet:package:selector:offerchange']//ins[@translate='global.cta.update']");
	    reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(packageNameLocator, 90).click();
	}

	/**
	 * Select the HSI package provide the input package base on bandwidth
	 * @param strBandwidth bandwidth of the package to be selected
	 * @author aditya.dhingra
	 */
	public void selectHSIPackageByBandwidthMobile(String strBandwidth) {
		By packageNameLocator = By.xpath("//span[@ng-bind='tier.speed.download' and text()='"+strBandwidth+"']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//button[@ute-tracking='internet:package:selector:offerchange']//ins[@translate='global.cta.update']");
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.staticWait(5000);
		WebElement pkg = driver.findElement(packageNameLocator);
		//reusableActions.staticWait(5000);
		reusableActions.getWhenReady(packageNameLocator, 120);
		reusableActions.executeJavaScriptClick(pkg);
	}

	/**
	 * Select the HSI package provide the input package base on data
	 * @param strBandwidth bandwidth of the package to be selected
	 * @param strData data of the package to be selected
	 * @author Chinnarao.vattam
	 */
	public void selectHSIPackageByDatafromSameSpeed(String strBandwidth, String strData ) {		
		reusableActions.getWhenVisible(By.xpath("//span[@ng-bind='tier.speed.download' and text()='"+strBandwidth+"']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//b[@ng-bind-template='"+strData+"']"),60).click();
	}
	
	public void selectHSIPackageByData(String strData ) {		
		reusableActions.getWhenVisible(By.xpath("//b[@ng-bind-template='"+strData+"']/ancestor::div[@class='twentyseventeen-internet-tier']/parent::div//button[@ute-tracking='internet:package:selector:offerchange']"),90).click();
	}
	
	public void selectHSIPackageByData() {
		reusableActions.getWhenVisible(btnFidoHSIPlan,60).click();
	}
	/**
	 * Click the confirm button on the change confirm popup
	 * @author aditya.dhingra
	 */
	public void clkConfirmPackageChange() {		
		reusableActions.getWhenVisible(btnConfirmPackageChange,60).click();
	}

	/**
	 * Click the confirm button on the change confirm popup
	 * @author chinnarao.vattam
	 */
	public void clkMonthlyUsage() {
		reusableActions.getWhenVisible(lnkMonthlyUsage,60).click();
	}

	/**
	 * Click the confirm button on the change confirm popup
	 * @author chinnarao.vattam
	 */
	public void clkDailyUsage() {
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenVisible(lnkDailyUsage,60).click();
	}

	/**
	 * Verify the  downgrade popup after the Internet dashboard page
	 * @return true, if the Downgrade popup displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDowngradePopup(){
		reusableActions.waitForElementVisibility(popupDowngrade, 60);
		return reusableActions.isElementVisible(popupDowngrade);
	}
	
	/**
	 * verifies/Waits to check if the plan information is loaded
	 * @return true when info plan is visible ,else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDowngradeWithSameDownloadSpead(){
		return reusableActions.isElementVisible(popupDowngradeWithSameDownloadSpead);
	}
	
	public boolean verifyIfPlanInformationLoaded() {
		return reusableActions.isElementVisible(infoPlan);
	}
	
	/**
	 * Verifies if the Usage Info is displayed
	 * @return true if the Usage info is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfUsageInfoDisplayed() {
		return reusableActions.isElementVisible(infoUsage);
	}
	
	/**
	 * Verifies if the daily usage chart is visible
	 * @return true if the Usage chart is visible
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfDailyUsageChartVisible() {
		return reusableActions.isElementVisible(infoDailyUsageChart);
	}

	/**
	 * Verifies if the daily usage link is visible
	 * @return true if the Usage link is visible
	 * @author chinnarao.vattam
	 */
	public boolean verifyIfDailyUsageLinkVisible() {
		return reusableActions.isElementVisible(lnkDailyUsage, 60);
	}
	
	/**
	 * Verifies if the daily Change Package link is visible
	 * @return true if the  Change Package link is visible
	 * @author chinnarao.vattam
	 */
	public boolean verifyIfChangePackageLinkVisible() {
		reusableActions.javascriptScrollToMiddleOfPage();
		return reusableActions.isElementVisible(lnkChangePackage);

	}
	
	/**
	 * Verifies if the Monthly usage link is visible
	 * @return true if the Monthly usage link is visible
	 * @author chinnarao.vattam
	 */
	public boolean verifyIfMonthlyUsageLinkVisible() {
		return reusableActions.isElementVisible(lnkMonthlyUsage);
	}
	
	/**
	 * Clicks the button Continue for internet
	 * @author Mirza.Kamran
	 */
	public void clkContinueForInternet() {
		//reusableActions.waitForElementInvisibility(btnCheckAvailability);
		reusableActions.getWhenVisible(btnContinueForInternet,60).click();
		
	}

	/**
	 * Click on the Usage Service navigation link
	 * @author chinnarao.vattam
	 */
	public void clkUsageNService() {
		//SSP to HSI handshake requires soem time
		reusableActions.staticWait(3000);
		reusableActions.getWhenReady(navUsageNService, 20).click();
	}

	/**
	 * Verifies Profile & Settings subheader option
	 * @author nandan.master
	 */
	public Boolean verifyProfileNSettings() {
		return reusableActions.isElementVisible(navProfileNSettings, 40);
	}
	
	/**
	 * Click on the Internet Service navigation link 
	 * @author chinnarao.vattam
	 */
	public void clkInternetService() {
		reusableActions.waitForElementTobeClickable(navInternetService, 30);
		reusableActions.getWhenReady(navInternetService, 30).click();
	}

	/**
	 * Click on the Manage Settings link 
	 * @author chinnarao. vattam
	 */
	public void clkManageSettings() {		
		reusableActions.getWhenVisible(btnManageSettings, 60).click();
	}

	/**
	 * Click on the Restart Modem link
	 * @author chinnarao. vattam
	 */
	public void clkRestartModem() {
		reusableActions.getWhenVisible(btnRestartModem, 60).click();
	}

	/**
	 * Click on the Yes,Restart Modem button
	 * @author chinnarao. vattam
	 */
	public void clkYesRestartModem() {
		reusableActions.getWhenVisible(btnYesRestartModem, 60).click();
	}


	/**
	 * Verifies if the Manage Settings is visible
	 * @return true if the Manage Settings is visible
	 * @author chinnarao. vattam
	 */
	public boolean verifyManageSettings() {
		return reusableActions.isElementVisible(btnManageSettings, 60);
	}

	/**
	 * Verifies if the Modem Restart model is visible
	 * @return true if the Modem Restart model is visible
	 * @author chinnarao. vattam
	 */
	public boolean verifyModemRestartModel() {
		return reusableActions.isElementVisible(mdlModemRestart);
	}

	/**
	 * Verifies if the Success model is visible
	 * @return true if the Success model is visible
	 * @author chinnarao. vattam
	 */
	public boolean verifySuccessModel() {
		return reusableActions.isElementVisible(mdlSuccess, 60);
	}

	/**
	 * Checks if the Label Internet  plans is visible
	 * @return true if the label is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifylblInternetPlans() {
		return reusableActions.isElementVisible(lblInternetPlans,30);
	}
	
	
	
}
