package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InternetDashboardPage  extends BasePageClass {

	public InternetDashboardPage(WebDriver driver) {
		super(driver);
	}

	//@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted'] | //span[text()='Continuer' or text()='Continue']/ancestor::button")
	@FindBy(xpath="(//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100'])[11]")
	WebElement btnContnue;

	@FindBy(xpath="(//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100'])[5]")
	WebElement Continuebtn;

	@FindBy(xpath = "//div[@class='nsm-dialog success nsm-dialog-open']//preceding::i[@class='rch-icon']")
	WebElement imgSuccess;

	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnSuccessOk;


	//@FindBy(xpath = "(//span[@translate='global.cta.select']//ancestor::button)[2]")
	@FindBy(xpath="(//button[contains(@class,'ds-button ds-corners ds-pointer text-center mw-100')])[3]")
	WebElement packageName;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFinger;

	@FindBy(xpath = "//div[@class='header self-serve-header']")
	WebElement icnHeader;

	@FindBy(xpath = "//div[@class='footer']")
	WebElement icnFooter;

	@FindBy(xpath = "//span[text()='Back to Overview' or text()='Retourner à l’aperçu']")
	WebElement btnBackToAccountOverview;

	@FindBy(xpath = "//span[text()='View your usage and alerts' or text()='Consulter votre historique d’utilisation et vos avis' ]")
	WebElement btnUsageAndAlerts;

	@FindBy(xpath = "//a[@href='https://www.rogers.com/consumer/internet/mesh-whole-home-wifi-network?ipn=1']")
	WebElement lnkLearnMoreWallToWallWifi;

	@FindBy(xpath = "//a[@href='/customer/support/article/understanding-wi-fi']")
	WebElement lnkUnderstandingWifi;

	@FindBy(xpath = "//a[@href='/customer/support/article/tips-for-placing-eeros']")
	WebElement lnkTipsForPlacingEero;

	@FindBy(xpath = "//a[@href='/customer/support/article/internet-speedtest']")
	WebElement lnkTestInternetSpeed;

	@FindBy(xpath = "//a[@href='/customer/support/article/how-to-optimize-your-internet-speed-and-wi-fi']")
	WebElement lnkHowToOptimizeSpeed;

	@FindBy(xpath = "//a[@href='/consumer/support/internet/IgniteInternet']")
	WebElement lnkGoToSupportSection;

	@FindBy(xpath="//span[(contains(text(),'Change internet package') or contains(text(),'Changer de forfait Internet')) or @translate='global.dashboard.common.changePackage']/ancestor::button")
	WebElement btnChangeInternetPackage;

	@FindBy(xpath = "//span[text()='Sélectionner' or text()='Select']/ancestor::button")
	WebElement btnSelectPackage;

	@FindBy(xpath="(//span[text()='Sélectionner' or text()='Select']/ancestor::button)[1]")
	WebElement firstLowestPackage;

	@FindBy(xpath="//div[text() ='Ignite TV Flex 20 + Sports']/ancestor::div[4]/ancestor::div[3]/child::div[2]/preceding::*[text()='Select'][1]")
	WebElement btnIgnite10Select;

	@FindBy(xpath = "//span[contains(text(),'Exchange later')]/ancestor::button")
	WebElement ExchangeLaterBtn;

	@FindBy(xpath = "//span[text()='Continue']")
	WebElement btnContnueReset;

	@FindBy(xpath = "//p[text()='Select Change Date' or text()='Sélectionner la date du changement' ]/ancestor::div//span[text()='Continue' or text()='Continuer']")
	WebElement btnContinueChangeDate;

	@FindBy(xpath = "//p[contains(text(),'Immédiatement') or contains(text(),'Immediately')]/parent::div/preceding-sibling::div[contains(@class,'ds-radioButton')]")
	WebElement btnImmediateBill;

	@FindBy(xpath="//span[contains(text(),'Add SmartStream') or contains(text(),'Ajouter le service Diffusion futée')]/ancestor::button")
	WebElement btnAddSmartStream;

	@FindBy(xpath="//span[contains(text(),'Select') or contains(text(),'Sélectionner')]/ancestor::button")
	WebElement btnSmartStreamSelect;

	@FindBy(xpath="//span[contains(text(),'Continue') or contains(text(),'Continuer')]/ancestor::button")
	WebElement btnContinueAddingStream;


	@FindBy(xpath="//div[@class='text-body text-bold text-uppercase']")
	WebElement currentSmartStream;

	String smartstreamTitle = "//div[@class='smartStream-tile__bundle-name']";
	String smartstreamSelect = "//span[@translate='global.cta.select']/ancestor::button";

	@FindBy(xpath = "//p[contains(text(),'Immediately')]/parent::div/preceding-sibling::div")
	WebElement rdImmediate;

	//@FindBy(xpath = "//button[contains(@class, 'expander ds-color-black ds-button ')]")
	@FindBy(xpath = "//*[text()='More details about this bundle']")
	WebElement expandMoreDetails;

	@FindBy(xpath = "//button[contains(@class, 'expander ds-color-black pl-16 ds-button ')]")
	WebElement expandSeeFullDetails;

	@FindBy(xpath = "//div[text() ='Ignite TV Flex 10']/following::*[text()='150 Mbps'][1]/parent::span/parent::span")
	WebElement downloadSpeed;

	@FindBy(xpath="(//span[text()='Sélectionner' or text()='Select']/ancestor::button)[4]")
	WebElement igniteTVPremiumPackage;

	@FindBy(xpath="//span[@translate='global.dashboard.internet.pods.addPods']/ancestor::button")
	WebElement addPodsButton;

	@FindBy(xpath="(//span[@translate='global.cta.addToCart']/ancestor::button)[1]")
	WebElement addPodToCart;

	@FindBy(xpath="(//span[@translate='global.cta.addToCart']/ancestor::button)[2]")
	WebElement addRestrictedPodToCart;

	//@FindBy(xpath="//span[@class='ds-icon d-inline-flex rds-icon-plus']/ancestor::button")
	@FindBy(xpath = "//div[@class='d-flex flex-row justify-content-center']/child::button[contains(@class,'tile-button increment p-0 tile-button-pod increment-pod active-pod ds-button ')]/child::span")
	WebElement plusButtonToAddPod;

	@FindBy(xpath = "(//div[@class='d-flex flex-row justify-content-center']/child::button[contains(@class,'tile-button increment p-0 tile-button-pod increment-pod active-pod ds-button ')]/child::span)[2]")
	WebElement plusButtonToAddRestrictedPod;

	@FindBy(xpath="//span[@class='ds-icon d-inline-flex rds-icon-minus']/ancestor::button")
	WebElement minusButtonToRemovePod;

	@FindBy(xpath = "(//button[contains(@class,'ds-button ds-corners')])[4]")
	WebElement changePackageBtn;

          // @FindAll({
				  // @FindBy(xpath = "(//button[contains(@class, ' ds-pointer text-center mw-100 ')])[2]"),
				   @FindBy(xpath = "//span[@translate='global.cta.loadOffer']//ancestor::button")
		//   })
	        WebElement Offersbutton;

	@FindBy(xpath="(//span[@class='ds-selection__label ds-no-overflow text-body mb-0 w-100'])[2] ")
	WebElement Productionbtn;

	@FindBy(xpath="(//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large text-no-decoration'])[2]")
	WebElement btnProceed;

	@FindBy(xpath="//p[contains(text(), 'Reached maximum')]")
	WebElement maximumLimitReached;

	@FindBy(xpath="(//p[contains(text(), 'Reached maximum')])[2]")
	WebElement secondMaximumLimitReached;


	@FindBy(xpath="//span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueButton;

	@FindBy(xpath="//span[contains(text(),'The customer understands that someone 18 years of age or older must be present to receive the equipment delivery') or contains(text(),'Le client convient qu’une personne d’au moins 18 ans doit être présente pour recevoir l’équipement')]")
	WebElement customerUnderstandCheckbox;


	@FindBy(xpath = "//*[text()=' Streaming ' or text() = ' Diffusion ']/preceding-sibling::div[@class='ds-checkbox__box my-12']")
	WebElement chkBtnSmartStreamSelect;

	@FindBy(xpath = "//span[text()='Load offers' or text()='Charger les offres']")
	WebElement btnLoadOffers;

	@FindBy(xpath = "(//span[@translate='global.cta.select' and contains(text(),'Select')])[4]/ancestor::button")
	WebElement btnSelectSmartStream;

	@FindBy(xpath = "//span[text()='Ignite 2.5 Gbps Ultd + Streaming']/ancestor::div[3]/following-sibling::div/child::rch-bundle-price/child::div/child::div[5]/child::button")
	WebElement btnViewDetails;

	@FindBy(xpath = "//span[text()='Pricing details' or text()='Détails sur la tarification']/ancestor::div[3]")
	WebElement collapsePricingDetails;

	@FindBy(xpath = "//span[text()='Package Details' or text()='Détails du forfait']/ancestor::div[3]")
    WebElement expandPackageDetails;

	@FindBy(xpath = "//p[text()='Remove Pods']")
	WebElement RemovePods;


	@FindBy(xpath = "//span[contains(text(), 'Customer has ')]")
	WebElement  IgniteWiFiPod;

	@FindBy(xpath = "//span[@translate='global.label.internetAddOns.banner']")
	WebElement  Restricted;
	@FindBy(xpath = "//h1[@translate='global.checkout.fulfillment.title']")
	WebElement  installationOption;
	@FindBy(xpath = "//h1[@translate='global.label.OrderReview']")
	WebElement  OrderReview;

	@FindBy(xpath = "//li[contains(text(),'Download speeds') or contains(text(),'Location de la passerelle')]")
	WebElement DownloadSpeedReview;

    @FindBy(xpath = "//li[contains(text(),'Upload speeds') or contains(text(),'Vitesses de téléversement')]")
    WebElement UploadSpeedReview;

	@FindBy(xpath = "//span[text()='Change package']")
	WebElement changePackageBtnEN;

	@FindBy(xpath = "//span[text()='Changer de forfait']")
	WebElement changePackageBtnFR;

	@FindBy(xpath = "//span[@translate='global.dashboard.internet.speedsUpTo']")
	WebElement internetSpeeds;

	@FindBy(xpath = "//span[contains(text(),'View offers') or contains(text(),'Voir les offres')]")
	WebElement viewOffer;

	@FindAll({
			@FindBy(xpath = "//*[text()='BEST']/following::*[text()='Select']/ancestor::button"),
			@FindBy(xpath = "//p[text()='Recommended Offer(s)']"),
			@FindBy(xpath = "//span[text()='MEILLEURE']"),
			@FindBy(xpath = "//span[text()='OFFRES RECOMMANDÉES']"),
	})
	WebElement recommendedOffer;


	@FindBy(xpath = "//span[contains(text(),'Exclusive Offer Available')]/parent::div/following-sibling::div/child::div[contains(@class,'-w16')]//span[contains(text(),'Select')]/ancestor::button")
	WebElement exclusiveOfferAvailable;

	@FindBy(xpath = "//span[@translate='global.dashboard.common.addIgniteSelfProtect']")
	WebElement addIgniteSelfProtect;

	@FindBy(xpath = "//span[@translate='global.cta.addToCart']/ancestor::button")
	WebElement addToCart;

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifLlnkLearnMoreWallToWallWifi() {
//		getReusableActionsInstance().waitForElementVisibility(lnkLearnMoreWallToWallWifi, 120);
//		WebElement btn=getReusableActionsInstance().getWhenReady(lnkLearnMoreWallToWallWifi,120);
//		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-100);
		return getReusableActionsInstance().isElementVisible(lnkLearnMoreWallToWallWifi,120);
	}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkUnderstandingWifi() {
		return getReusableActionsInstance().isElementVisible(lnkUnderstandingWifi,120);
	}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkTipsForPlacingEero() {
		return getReusableActionsInstance().isElementVisible(lnkTipsForPlacingEero,120);
	}


	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkTestInternetSpeed() {
		return getReusableActionsInstance().isElementVisible(lnkTestInternetSpeed,120);
	}


	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkHowToOptimizeSpeed() {
		return getReusableActionsInstance().isElementVisible(lnkHowToOptimizeSpeed,120);
	}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkGoToSupportSection() {
		return getReusableActionsInstance().isElementVisible(lnkGoToSupportSection,120);
	}


	/**
	 * Click the view usage and alerts button
	 * @author chinnarao.vattam
	 */
	public void clickbtnUsageAndAlerts() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnUsageAndAlerts,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnUsageAndAlerts,45);
	}

	/**
	 * Click the back to overview button which brings the account overview page up
	 * @author chinnarao.vattam
	 */
	public void clickBacktoAccountOverview() {
		getReusableActionsInstance().getWhenReady(btnBackToAccountOverview,120).click();
	}

	/**
	 *click continue for the ongoing activity on Internet dashboard page
	 * @author chinnarao.vattam
	 */
	public void clickContinue() {
		getReusableActionsInstance().getWhenReady(btnContnue,30).click();
	}

	public void clickContinuebtn(){
		getReusableActionsInstance().getWhenReady(Continuebtn,60).click();
	}

	/**
	 * Verify the result
	 * @return true if operation is successful, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccess() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFinger, 120);
		return getReusableActionsInstance().isElementVisible(imgSuccess);
	}

	/**
	 * Click "Ok" on success popup
	 * @author chinnarao.vattam
	 */
	public void clickSuccessOk() {
		getReusableActionsInstance().getWhenReady(btnSuccessOk, 120).click();
	}

	/**
	 * Verify the header availability
	 * @return true if header is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyHeader() {
		getReusableActionsInstance().waitForElementVisibility(icnHeader,120);
		return getReusableActionsInstance().isElementVisible(icnHeader);
	}

	/**
	 * Verify the footer availability
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFooter() {

		return getReusableActionsInstance().isElementVisible(icnFooter,120);
	}

	/**
	 * Go to Page bottom
	 * @author chinnarao.vattam
	 */
	public void goToPageBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}


	/**
	 * Go to Page bottom
	 * @author chinnarao.vattam
	 */
	public void goToPageMid() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();;
	}
	/*
	 * Clicks on change Internet package button
	 * @author suganya P
	 * */
	public void clickChangeInternetPackage() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnChangeInternetPackage, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnChangeInternetPackage, 120).click();
	}
	/*
	 * Selects the first lowest internet package
	 * @author suganya P
	 * */
	public void selectFirstLowestPackage() {
		WebElement btn = getReusableActionsInstance().getWhenReady(firstLowestPackage, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(firstLowestPackage, 60).click();
	}

	public void selectButtonIgnite10() {
		WebElement btn = getReusableActionsInstance().getWhenReady(btnIgnite10Select, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnIgnite10Select, 60).click();
	}
	/*
	 * Clicks continue on change Internet package
	 * @author suganay P
	 * */
	public void clickContinueChangeInternetPackage() {
		//getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
		getReusableActionsInstance().waitForElementTobeClickable(btnContnueReset, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnContnueReset);
	}
	/*
	 * Click on continue in Select billing date pop up
	 * @author suganya P
	 * */
	public void clickContinueOnSelectDateChange() {
		getReusableActionsInstance().waitForElementVisibility(btnContinueChangeDate,30);
		getReusableActionsInstance().getWhenReady(btnContinueChangeDate,60).click();
		getReusableActionsInstance().staticWait(15000);
	}
	/*Selects the Immediate Billing option
	 * @author suganya p
	 * */
	public void clickImmediateBill() {
		getReusableActionsInstance().clickWhenReady(btnImmediateBill,120);
		getReusableActionsInstance().staticWait(2000);
	}
	/*Clicks on add smart stream button
	 * @author suganya p
	 * */
	public void clickAddSmartStream() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnAddSmartStream, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnAddSmartStream, 120).click();
	}






	/*Choose the different plan
	 * @author aditi.jain
	 * */
	public void clickSelectSmartStreamChangeTier() {

		WebElement element = getReusableActionsInstance().getWhenReady(currentSmartStream);
		String[] currentTitle = element.getText().split(" ");
		String currentTitleLastWord = currentTitle[currentTitle.length - 1];

		List<WebElement> allSmartStreams = getDriver().findElements(By.xpath(smartstreamTitle));
		for (int i = 1; i <= allSmartStreams.size(); i++) {
			getReusableActionsInstance().staticWait(2000);
			if (getReusableActionsInstance().isElementVisible(btnContnue, 5)) {
				clickContinue();
			}

			WebElement smartStreamElement = getReusableActionsInstance().getWhenReady(By.xpath("(" + smartstreamTitle + ")" + "[" + i + "]"));

			String[] titles = smartStreamElement.getText().split(" ");
			String planToSelect = titles[titles.length - 1];

			if (!planToSelect.equalsIgnoreCase(currentTitleLastWord)) {
				int index = i / 2 + 1;
				WebElement selectISS = getReusableActionsInstance().getWhenReady(By.xpath("(" + smartstreamSelect + ")" + "[" + index + "]"));
				getReusableActionsInstance().scrollToElement(selectISS);
				getReusableActionsInstance().executeJavaScriptClick(selectISS);
				break;

			} else {
				i++;
			}


		}


	}


	/*Choose the first avaialble smart stream package
	 * @author suganya P
	 * */
	public void clickSelectSmartStream() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnSmartStreamSelect, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSmartStreamSelect,60).click(); }
	/*
	 * clicks continue on the Smart Stream
	 * @author suganya p
	 * */
	public void clickContinueAddingStream() {
		getReusableActionsInstance().getWhenReady(btnContinueAddingStream,60).click();
	}
	/* Selects the internet package based on the inputted package name
	 * @autho suganya P
	 * */
	public void selectInternetPackage(String strUpgradePlanEn, String strUpgradePlanFr) {

		By packageNameLocator = By.xpath("//p[contains(text(),'"+strUpgradePlanEn+"') or contains(text(),'"+strUpgradePlanFr+"')]/ancestor::div[@class='internet-tile__main']//span[contains(text(),'Select')]/ancestor::button");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 30);

		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}


	public void clickWalltoWallWifiLink(){
		getReusableActionsInstance().clickWhenReady(lnkLearnMoreWallToWallWifi);
	}



/*	public void selectIgniteTVFlex10() {
		getReusableActionsInstance().staticWait(5000);
		WebElement btn = getReusableActionsInstance().getWhenReady(btnIgniteTvFlex10, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(igniteTvFlex10, 60).click();
	}*/

	public void selectRadioImmediate()
	{
		getReusableActionsInstance().isElementVisible(rdImmediate, 60);
		getReusableActionsInstance().scrollToElementAndClick(rdImmediate);
		getReusableActionsInstance().clickWhenReady(rdImmediate,60);
	}

	/*public void selectMoreDetails()
	{
		getReusableActionsInstance().isElementVisible(expandMoreDetails, 60);
		getReusableActionsInstance().scrollToElementAndClick(expandMoreDetails);
		getReusableActionsInstance().clickIfAvailable(expandMoreDetails,60);
	}*/
	/*public void selectSeeFullDetails()
	{
		getReusableActionsInstance().isElementVisible(expandSeeFullDetails, 60);
		getReusableActionsInstance().scrollToElementAndClick(expandSeeFullDetails);
		getReusableActionsInstance().clickIfAvailable(expandSeeFullDetails,60);
	}*/

	public void selectDownloadSpeed()
	{
		getReusableActionsInstance().isElementVisible(downloadSpeed, 60);
		//getReusableActionsInstance().scrollToElementAndClick(downloadSpeed);
		getReusableActionsInstance().clickWhenReady(downloadSpeed,60);
	}


	//***********
	@FindBy(xpath="//span[contains(text(),'Current bundle')]/following-sibling::span")
	WebElement currentBundle;

	public void selectPlanUnderSameTvPackage(String internetPlan) {
		getReusableActionsInstance().staticWait(6000); /*To get the current tv bundle name and select the internet plan variation under the same tv bundle*/
		String tvPackage= currentBundle.getText();
		By planNameLocator = By.xpath("//div[contains(text(),'"+tvPackage.substring(10)+"')]/ancestor::div[@class='bundle-tile__body__row']/following-sibling::div//span[text()='"+internetPlan+"']");
		getReusableActionsInstance().getWhenReady(planNameLocator, 120);
		WebElement pkg = getDriver().findElement(planNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg); /*To click on Select button*/
		By selectLocator = By.xpath("//div[contains(text(),'"+tvPackage.substring(10)+"')]/ancestor::div[contains(@class,'bundle-tile__table')]/following-sibling::div//span[@translate='global.cta.select']");
		getReusableActionsInstance().getWhenReady(selectLocator, 20);
		WebElement button = getDriver().findElement(selectLocator);
		getReusableActionsInstance().executeJavaScriptClick(button);
	}

	/*
	 * Selects the internet plan variation form corresponding tv package
	 * @author suganya P
	 * */
	public void selectPlanUnderTvPackage(String tvPackage,String internetPlan) {
		getReusableActionsInstance().staticWait(6000);



		/*To click on internet plan*/
		By planNameLocator = By.xpath("//div[contains(text(),'"+tvPackage+"')]/ancestor::div[@class='bundle-tile__body__row']/following-sibling::div//span[text()='"+internetPlan+"']");
		getReusableActionsInstance().isElementVisible(planNameLocator, 120);
		WebElement pkg = getDriver().findElement(planNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);



		/*To click on Select button*/
		By selectLocator = By.xpath("//div[contains(text(),'"+tvPackage+"')]/ancestor::div[contains(@class,'bundle-tile__table')]/following-sibling::div//span[@translate='global.cta.select']");
		getReusableActionsInstance().getWhenReady(selectLocator, 20);
		WebElement button = getDriver().findElement(selectLocator);
		getReusableActionsInstance().executeJavaScriptClick(button);
	}

		public void ScrollTOBottom(){
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		}

		public void clickExchangeLaterButton(){
		getReusableActionsInstance().getWhenReady(ExchangeLaterBtn,60);
		getReusableActionsInstance().executeJavaScriptClick(ExchangeLaterBtn);

		}

	public void clickChangePackageButton() {
		getReusableActionsInstance().getWhenReady(changePackageBtn, 60);
		getReusableActionsInstance().executeJavaScriptClick(changePackageBtn);

	}

	public void clkOffersbutton(){
		getReusableActionsInstance().waitForElementVisibility(Offersbutton, 120);
		getReusableActionsInstance().executeJavaScriptClick(Offersbutton);
		getReusableActionsInstance().staticWait(1000);
	}

	public void clkProductionbtn(){
		getReusableActionsInstance().getWhenReady(Productionbtn,60);
		getReusableActionsInstance().executeJavaScriptClick(Productionbtn);
	}

	public void clkProceedbtn(){
		getReusableActionsInstance().getWhenReady(btnProceed,60);
		getReusableActionsInstance().executeJavaScriptClick(btnProceed);
	}

	public void selectUpgradeInternetPlan(String upgradeBundle, String intPackage){
		By changePlan= By.xpath("//div[contains(text(),'"+upgradeBundle+"')]/ancestor::div[@class='bundle-tile__main']/descendant::span[@translate='global.label.downloadSpeedValueUnit' and text()='"+intPackage+"']");
		//By changePlan= By.xpath("//p[contains(text(),'"+intPackage+"')]/ancestor::div[contains(@class,'internet-tile__table')]/following::div/button");
		WebElement changePlanElement= getDriver().findElement(changePlan);
		getReusableActionsInstance().waitForElementTobeClickable(changePlanElement,10);
		getReusableActionsInstance().executeJavaScriptClick(changePlanElement);
	}

	public void selectInternetPlan(String upgradeBundle){
		By changePlan= By.xpath("//div[contains(text(),'"+upgradeBundle+"')]/ancestor::div[@class='bundle-tile__main']/descendant::rch-bundle-price//span[@translate='global.cta.select']/ancestor::span[@role='text']");
//		By changePlan= By.xpath("//p[contains(text(),'"+upgradeBundle+"')]/ancestor::div[contains(@class,'internet-tile__table')]/following::div/button");
		getReusableActionsInstance().staticWait(10000);
		WebElement changePlanElement= getDriver().findElement(changePlan);
		getReusableActionsInstance().waitForElementTobeClickable(changePlanElement,10);
		getReusableActionsInstance().executeJavaScriptClick(changePlanElement);
	}

	public void selectTupeloDowngradeInternet(String intPackage){
		By downgradePackage = By.xpath("//span[text()='"+intPackage+"']/ancestor::div[@class='-w84 smartStream-tile__table']/following-sibling::div/child::rch-bundle-price/descendant::span[3]/descendant::span[text()='Select']");
		getReusableActionsInstance().getWhenReady(downgradePackage, 60);
		WebElement button = getDriver().findElement(downgradePackage);
		getReusableActionsInstance().executeJavaScriptClick(button);
	}

	public void clickCheckBoxSmartStream() {
		WebElement btn = getReusableActionsInstance().getWhenReady(chkBtnSmartStreamSelect, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(chkBtnSmartStreamSelect, 60).click();
	}

	public void clickLoadOffers() {
		getReusableActionsInstance().getWhenReady(btnLoadOffers, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnLoadOffers);

	}
	public void selectButtonAddSmartStream() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnSelectSmartStream, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectSmartStream,60).click(); }

	/*
	 * clicks  Select button
	 * @author Jarmanjeet.Batth
	 * */
	public void clickViewDetails() {
		getReusableActionsInstance().staticWait(5000);
		WebElement btn=getReusableActionsInstance().getWhenReady(btnViewDetails, 60);
		getReusableActionsInstance().scrollToElement(btnViewDetails);
		getReusableActionsInstance().clickWhenReady(btnViewDetails,60); }

	public void clickPackageDetails(){
		getReusableActionsInstance().waitForElementVisibility(expandPackageDetails, 60);
		getReusableActionsInstance().clickWhenReady(expandPackageDetails, 30);
//		getReusableActionsInstance().executeJavaScriptClick(expandPackageDetails);
	}

	public void clickPricingDetails(){
		getReusableActionsInstance().waitForElementVisibility(collapsePricingDetails, 60);
		getReusableActionsInstance().getWhenReady(collapsePricingDetails, 30).click();
	}

	/*
	 * clicks  Select button
	 * @author aditi.jain
	 * */
	public void clickSelectbutton() {

	//	getReusableActionsInstance().waitForElementVisibility(packageName, 60);
		getReusableActionsInstance().getWhenReady(packageName,60);
		getReusableActionsInstance().executeJavaScriptClick(packageName);
	}


	/*
	 * clicks  Add Pods Button
	 * @author aditi.jain
	 * */
	public void clickAddPodsButton() {
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().waitForElementVisibility(addPodsButton, 30);
		getReusableActionsInstance().scrollToElement(addPodsButton);
		getReusableActionsInstance().executeJavaScriptClick(addPodsButton);
	}

	/*
	 * clicks  Add To Cart For Pods
	 * @author aditi.jain
	 * */
	public void clickAddToCartForPods() {
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().scrollToElement(addPodToCart);
		getReusableActionsInstance().waitForElementVisibility(addPodToCart, 30);
		getReusableActionsInstance().executeJavaScriptClick(addPodToCart);
	}

	/*
	 * clicks  Continue Button
	 * @author aditi.jain
	 * */
	public void clickContinueButton() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(continueButton, 30);
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}

	/*
	 * clicks  Customer Understand Checkbox
	 * @author aditi.jain
	 * */
	public void clickCustomerUnderstandCheckbox() {
		getReusableActionsInstance().scrollToElement(customerUnderstandCheckbox);
		getReusableActionsInstance().waitForElementVisibility(customerUnderstandCheckbox, 30);
		getReusableActionsInstance().executeJavaScriptClick(customerUnderstandCheckbox);
	}

	/*
	 * clicks  Plus To Add Pod
	 * @author aditi.jain
	 * */
	public void clickPlusToAddPod() {
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().scrollToElement(plusButtonToAddPod);

		while(!getReusableActionsInstance().isElementVisible(maximumLimitReached, 10)){
			getReusableActionsInstance().waitForElementVisibility(plusButtonToAddPod, 45);
			getReusableActionsInstance().executeJavaScriptClick(plusButtonToAddPod);
			getReusableActionsInstance().waitForPageLoad();
		}
	}

	public void clickPlusToAddRestrictedPod() {
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().scrollToElement(plusButtonToAddRestrictedPod);

		while(!getReusableActionsInstance().isElementVisible(secondMaximumLimitReached, 10)){
			getReusableActionsInstance().waitForElementVisibility(plusButtonToAddRestrictedPod, 45);
			getReusableActionsInstance().executeJavaScriptClick(plusButtonToAddRestrictedPod);
			getReusableActionsInstance().waitForPageLoad();
		}
	}

	/*
	 * verify Maximum Limit Reached
	 * @author aditi.jain
	 * */
	public boolean verifyMaximumLimitReached() {
		return getReusableActionsInstance().isElementVisible(maximumLimitReached);
	}


	/*
	 * clicks  Minus To Remove Pod
	 * @author aditi.jain
	 * */
	public void clickMinusToRemovePod() {
		getReusableActionsInstance().scrollToElement(plusButtonToAddPod);
		getReusableActionsInstance().waitForElementVisibility(plusButtonToAddPod, 45);
		getReusableActionsInstance().executeJavaScriptClick(plusButtonToAddPod);
	}

	/*
	 * clicks  Add To Cart For Restricted Pods
	 * @author aditi.jain
	 * */
	public void clickAddToCartForRestrictedPods() {
		getReusableActionsInstance().scrollToElement(addRestrictedPodToCart);
		getReusableActionsInstance().waitForElementVisibility(addRestrictedPodToCart, 45);
		getReusableActionsInstance().executeJavaScriptClick(addRestrictedPodToCart);
	}
	/*
	 * verify Remove Pods
	 * @author aditi.jain
	 * */
	public boolean verifyRemovePods() {
		getReusableActionsInstance().waitForElementVisibility(RemovePods, 30);
		return getReusableActionsInstance().isElementVisible(RemovePods);

	}

	/*
	 * verify Remove Pods
	 * @author aditi.jain
	 * */
	public boolean verifyRemovePodsNotAppear() {
		getReusableActionsInstance().waitForElementVisibility(RemovePods, 15);
		return !getReusableActionsInstance().isElementVisible(RemovePods);

	}
	/*
	 * verify Ignite WiFi Pod
	 * @author aditi.jain
	 * */
	public boolean verifyIgniteWiFiPod() {
		getReusableActionsInstance().waitForPageLoad();
		//getReusableActionsInstance().scrollToElement(IgniteWiFiPod);
		getReusableActionsInstance().waitForElementVisibility(IgniteWiFiPod, 60);
		return getReusableActionsInstance().isElementVisible(IgniteWiFiPod);
	}
	/*
	 * verify second Maximum Limit Reached
	 * @author aditi.jain
	 * */
	public boolean verifySecondMaximumLimitReached() {
		return getReusableActionsInstance().isElementVisible(secondMaximumLimitReached);
	}
	/*
	 * verify  Restricted
	 * @author aditi.jain
	 * */
	public boolean verifyRestricted() {
		getReusableActionsInstance().waitForElementVisibility( Restricted, 30);
		return getReusableActionsInstance().isElementVisible( Restricted);
	}

	/*
	 * verify  Restricted
	 * @author aditi.jain
	 * */
	public boolean verifyRestrictedDoesNotAppear() {
//		getReusableActionsInstance().waitForElementInvisibility( Restricted, 15);
		if(getReusableActionsInstance().isElementVisible(Restricted,30)){
			return false;
		} else {
			return true;
		}
	}
	/*
	 * verify  installationOption
	 * @author aditi.jain
	 * */
	public boolean verifyInstallationOption() {
		getReusableActionsInstance().waitForElementVisibility( installationOption, 30);
		return getReusableActionsInstance().isElementVisible( installationOption);
	}
	/*
	 * verify  Order Review
	 * @author aditi.jain
	 * */
	public boolean verifyOrderReview() {
		getReusableActionsInstance().waitForElementVisibility( OrderReview, 30);
		return getReusableActionsInstance().isElementVisible( OrderReview);
	}

	public boolean verifyUsageAndAlerts() {
		getReusableActionsInstance().waitForElementVisibility( btnUsageAndAlerts, 30);
		return getReusableActionsInstance().isElementVisible( btnUsageAndAlerts);
	}

	public boolean verifyChangePackageButton() {
		getReusableActionsInstance().waitForElementVisibility( changePackageBtn, 30);
		return getReusableActionsInstance().isElementVisible( changePackageBtn);
	}

	public boolean verifyAddPodsButton() {
		getReusableActionsInstance().waitForElementVisibility( addPodsButton, 30);
		return getReusableActionsInstance().isElementVisible( addPodsButton);
	}

	public boolean verifyChangePackageButtonEN() {
		WebElement btn=getReusableActionsInstance().getWhenReady(changePackageBtnEN, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().waitForElementVisibility( changePackageBtnEN, 30);
		return getReusableActionsInstance().isElementVisible( changePackageBtnEN);
	}

	public boolean verifyChangePackageButtonFR() {
		WebElement btn=getReusableActionsInstance().getWhenReady(changePackageBtnFR, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().waitForElementVisibility( changePackageBtnFR, 30);
		return getReusableActionsInstance().isElementVisible( changePackageBtnFR);
	}

	/*
	 * verify  Order Review
	 * @author Jarmanjeet.Batth
	 * */

    public boolean verifyUploadSpeed() {
//        getReusableActionsInstance().waitForElementVisibility( UploadSpeedReview, 30);
		if(getReusableActionsInstance().isElementVisible(UploadSpeedReview, 30)){
			return true;
		}else {
			return false;
		}
    }

	public boolean verifyDownloadAndUploadSpeed() {
//		getReusableActionsInstance().scrollToElement(DownloadSpeedReview);
//		getReusableActionsInstance().scrollToElement(UploadSpeedReview);
		String download = getReusableActionsInstance().getElementText(DownloadSpeedReview);
		String upload = getReusableActionsInstance().getElementText(UploadSpeedReview);
		String[] d1 = download.split(":");
		System.out.println(d1[1]);
		String[] u1 = upload.split(":");
		System.out.println(u1[1]);
		Boolean areEqual = d1[1].equals(u1[1]);
		if (areEqual) {
			System.out.println("Download and Upload speed Symmetrical");
			return true;
		} else {
			System.out.println("Download and Upload speed is not Symmetrical");
			return false;
		}
	}
	/*
	Verifies whether download/upload speed section is displayed
	@author Sameer Ahuja
	 */
	public boolean verifyInternetSpeedDisplayed(){
		return  getReusableActionsInstance().isElementVisible(internetSpeeds, 30);
	}

	public void clickSelectButtonAsPerPackageName(String internetPkg)
	{
		/*To click on Select button*/
		By selectLocator = By.xpath("//span[contains(text(),'"+internetPkg+"')]/ancestor::div[contains(@class,'-w84 internet-tile__table')]/following-sibling::div//span[@translate='global.cta.select']//ancestor::button");
		getReusableActionsInstance().getWhenReady(selectLocator, 30);
		WebElement button = getDriver().findElement(selectLocator);
		getReusableActionsInstance().executeJavaScriptClick(button);
	}

	public void clickViewOffers() {
		getReusableActionsInstance().staticWait(20);
		//getReusableActionsInstance().waitForElementVisibility(viewOffer, 30);
		getReusableActionsInstance().executeJavaScriptClick(viewOffer);
	}

	public boolean verifyRecommendedOffer() {
		getReusableActionsInstance().scrollToElement(recommendedOffer);
		return getReusableActionsInstance().isElementVisible(recommendedOffer, 30);
	}

	public void selectRecommendedOffer() {
		getReusableActionsInstance().waitForElementVisibility(recommendedOffer, 30);
		getReusableActionsInstance().executeJavaScriptClick(recommendedOffer);
	}

	public void selectExclusiveOfferAvailable() {
		getReusableActionsInstance().waitForElementVisibility(exclusiveOfferAvailable, 30);
		getReusableActionsInstance().executeJavaScriptClick(exclusiveOfferAvailable);
	}

	public void selectIgniteSelfProtect() {
		getReusableActionsInstance().waitForElementVisibility(addIgniteSelfProtect, 30);
		getReusableActionsInstance().executeJavaScriptClick(addIgniteSelfProtect);
	}

	public void selectAddToCart() {
		getReusableActionsInstance().waitForElementVisibility(addToCart, 30);
		getReusableActionsInstance().executeJavaScriptClick(addToCart);
	}



}

