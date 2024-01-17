package ca.fido.pages;
import ca.fido.pages.base.BasePageClass;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.FormFiller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FidoAccountOverviewPage extends BasePageClass {

	public FidoAccountOverviewPage(WebDriver driver) {
		super(driver);

	}

	public enum BillingAndPaymentsSubMenuOptions {
		ViewBill,
		MakePayment,
		SetAutomaticPayments,
		PaymentHistory
	}
	@FindBy(xpath = "//fss-financed-accessories-badge")
	WebElement badgeAccessories;

	@FindBy(xpath = "//fss-financed-accessories-badge//a[@title='View Accessories' or @title='Voir les accessoires']")
	WebElement btnFinancedAccessories;

	@FindBy (xpath="//span[@class='accountDivider']")
	WebElement ddlAccountSelection;

	@FindBy (xpath="//div[@class='col-xs-12 col-sm-3 vertical-divider payment-info']//ins")
	WebElement btnPayNow;
	
	@FindBy(xpath = "//div[contains(@class,'pay-now-button-section mobile pay-now-padding-0 visible-xs')]//ins")
	WebElement btnPayNowMobile;
	
	@FindBy (xpath="//ins[@translate='global.cta.payNow']")
	WebElement btnPayNowDefault;
	
	@FindBy (xpath="//div[contains(@class,'visible-xs')]//ins[@translate='global.cta.payNow']")
	WebElement btnPayNowDefaultMobile;

	@FindBy (xpath="//span[contains(text(),'View Usage & Manage') or contains(text(),'Voir et gérer l’utilisation')]")
	WebElement lnkViewUsageManage;

	//@FindBy (xpath="//a[contains(@aria-label,'usage and manage account') or contains(@aria-label,'internet et gérer le compte')]")
	@FindBy (xpath="//a[contains(@aria-label,'usage and manage account')]/span/span")
	WebElement lnkViewUsageManageMobile;

	@FindBy (xpath="//a[contains(@aria-label,'Make a payment') and contains(@class,'billing-payment')]/span")
	WebElement lnkMakepayment;

	@FindBy (xpath="//div[@ng-if='subscriberService.wireless']/a")
	WebElement badgeWireless;

	@FindBy (xpath="//h1[@class='welcome-text']")
	WebElement msgWelcome;

	@FindBy (xpath="//div[contains(@class,'account-balance')]")
	WebElement msgPaymentpage;


	@FindBy (xpath="//div[contains(@class,'ds-price__amountDollars')]")
	WebElement infoAccountBalance;

	@FindBy (xpath="//span[@class='ute-price']//ins")
	WebElement infoBalance;

	@FindBy(xpath="//span[@translate='global.cta.changeMethodOfPayment']")
	WebElement lnkChangeMethodOfPayment;

	@FindBy(xpath="//select[@ng-model='props.selectedPaymentOption']")
	WebElement ddlPaymentOption;

	@FindBy(xpath="//div[@class='modal-body']/div[@class='alert alert-success']//descendant::p")
	WebElement successTextPreAutPayment; 

	@FindBy(xpath="//button[@class='ute-btn-primary ute-sm']/ins[@translate='global.cta.okCool']")
	WebElement btnOkCool;

	@FindBy(xpath="//div[@class='row page-dashboard-service-section']//div[@ng-repeat='subscriberService in account.subscriberServices track by $index'][1]")
	WebElement divFirstCTNBadge;

	@FindBy(xpath="//li[@class='services bill-pay']//span[@class='down-arrow-span']")
	WebElement menuBillingAndPayments; 

	@FindBy(xpath="//span[@translate='global.label.paymentHistory']")
	WebElement subMenuPaymentHistory;

	@FindBy(xpath="//span[@translate='global.cta.viewBill']")
	WebElement subMenuViewBill;

	@FindBy(xpath="//span[@translate='global.label.setAutomaticPayment']")
	WebElement subMenuSetUpAutomaticPayment;

	@FindBy(xpath="//span[@translate='global.cta.makePayment_header_menu']")
	WebElement subMenuMakeAPayment;

	@FindBy(xpath="//a[contains(@aria-label,'Make a payment')]")
	WebElement btnMakeAPayment;

	@FindBy(xpath="//button/ins[@translate='global.cta.viewBill']")
	WebElement btnViewBill;

	@FindBy(id="billDate")
	WebElement ddlViewBill;

	@FindBy(id ="bbAppIFrame")
	WebElement frameViewBill;	

	@FindBy (xpath = "//ins[@translate='global.cta.refillNow']")
	WebElement btnRefillNow;

	@FindBy (xpath = "//div[@class='item content']")
	WebElement divCtnBadge;

	@FindBy (xpath = "//ins[@translate='global.label.profileAndSettings']")
	WebElement menuProfileNSetting;

	@FindBy (xpath = "//*[@translate='global.label.services']")
	WebElement menuUsageNService;

	@FindBy (xpath = "//div[@translate='global.label.services']")
	WebElement menuUsageNServicePrePaid;	

	@FindBy(xpath = "//ins[@translate='wireless.label.usageSummary']")
	WebElement lblUsageHeaderPrePaidDashboardPage;

	@FindAll({@FindBy(xpath = "//*[@class='subscription-number']")})
	List<WebElement> lnkCTNBadges;

	@FindBy (xpath = "//ins[@translate='global.label.accountSuspended']")
	WebElement msgAccountSuspended;

	@FindBy (xpath = "//ins[@translate='global.message.accountSuspendedWarning']")
	WebElement msgAccountSuspendedWarning;

	@FindBy (xpath = "//div[@class='row page-dashboard-service-section']//a[@class='btn']")
	WebElement btnService;

	@FindBy(xpath = "//ins[@translate='global.message.limitedAccessToMyAccountAlert']")
	WebElement msgAccountAccessLimited;

	@FindBy(xpath = "//ins[@translate='global.message.accountCancelledCX']")
	WebElement msgAccountCancelled;

	@FindBy (xpath = "//a[@ui-sref='myAccount.overview({accountNumber: selectedAccountNumber})']")
	WebElement menuOverview;

	@FindBy (xpath = "//button[contains(@aria-label,'Automatic Payments')]")
	WebElement btnAutomaticPayments;

	@FindBy (xpath = "//button[contains(@aria-label,'Payment History')]")
	WebElement btnPaymentHistory;

	@FindBy(xpath = "//span[contains(@class,'header')]//*[@translate='global.label.overview']")
	WebElement menuOverviewMobile;

	@FindAll({
	@FindBy(xpath = "//ds-expander//*[@data-text='Profile & Settings']"),
	@FindBy(xpath = "//*[@class='modal-dialog']//*[@translate='global.label.profileAndSettings']")})
	WebElement menuProfileAndSettingsMobile;

	@FindBy(xpath = "//ins[@translate='global.message.myAccountNoPaymentHistory']")
	WebElement labelNoPaymentMade;

	@FindBy(xpath="//*[@id='amount']")
	WebElement txtAmount;

	@FindBy(xpath = "//span[@translate='onboarding-module.close']")
	WebElement btnCloseAccountSetupProgress;

	//@FindBy(xpath = "//h1[@translate='global.label.profile']")
	@FindBy(xpath="(//span[text()='Contact & Billing'])[2]")
	WebElement lblHeaderProfileAndSettings;

	@FindBy(xpath = "//button/ins[@translate='global.cta.viewTransactions']")
	WebElement btnViewTransaction;

	@FindBy(xpath = "//ins[@translate='wireless.label.fidoTransactions']")
	WebElement btnFidoTransactions;

	@FindBy(xpath = "//ins[@translate='wireless.label.calls']")
	WebElement btnCalls;

	@FindBy(xpath="//div[@ng-show='signinService.getLoadingIndicator()' and @class='']")
	WebElement lblLoadingIndicator;

	@FindBy(xpath="//div[@class='recovery-error']")
	WebElement failLoginDiv;

	@FindBy(xpath = "//div/p[@class='learning-modal-title']")
	WebElement divGotANewLook;

	@FindBy(xpath = "//div[@class='modal-header']/button[@title='Close']")
	WebElement btnCloseOverlay;

	@FindBy (xpath = "//ins[@translate='global.label.mobile']")
	WebElement subMenuMobile;

	@FindBy(xpath = "//span[@translate='usageModule.title']")
	WebElement divUsageModuleHeader;

	@FindBy(xpath = "//td[@data-title=\"'wireless.label.transactionType' | translate\"]")
	WebElement cellTransactionType;

	@FindBy (xpath = "//li[@class='o-navLinkList__item clicktale-mask loginStates stateCookied stateActive']")
	WebElement lnkSignInAs;

	@FindBy (xpath = "//span[@class='ds-icon d-inline-flex fds-icon-add-circle']")
	WebElement lnkAddALine;

	@FindBy(xpath = "//ds-modal-container//a[contains(.,'Already') or contains(.,'Déjà')]")
	WebElement aalByodLnk;

	@FindBy(xpath = "//ds-modal-container//a[contains(.,'New') or contains(.,'Nouve')]")
	WebElement aalTermLnk;

	@FindBy (xpath = "//div[@class='onboarding-progress-bar']")
	WebElement lblProgressBar;

	@FindBy (xpath = "//button[@translate='onboarding-module.tasks.setRecoveryNumber.title']")
	WebElement btnSetUpMobileRecovery;

	@FindBy (xpath = "//button[@translate='onboarding-module.tasks.loginToAccount.title']")
	WebElement btnLoginToMyAccount;

	@FindBy (xpath = "//button[@translate='onboarding-module.tasks.setAutoPayment.title']")
	WebElement btnSetUpAutomaticPayments;

	@FindBy (xpath = "//button[@translate='onboarding-module.tasks.addContactEmail.title' or @translate='onboarding-module.tasks.verifyContactEmail.title']")
	WebElement btnSetContactInfo;

	@FindBy(xpath = "//div[@class='progress-bar']")
	WebElement progressBar;

	@FindBy(xpath = "//button[text()='Set Up Now' or text()='configurer']")
	WebElement btnSetupNowButton;

	@FindBy(xpath = "//h1[@translate='onboarding-module.tasks.setRecoveryNumber.title']")
	WebElement titleRecoveryNumber;
	
	@FindBy (xpath = "//fss-preauth-payment/div")
	WebElement lblAutoPayment;
	
	@FindBy (xpath = "//fss-preauth-payment//span[@class='ds-link__copy']")
	WebElement lnkEditAutoPayment;

	@FindBy (xpath = "//fss-account-detail//fss-preauth-payment//span[contains(text(),'Account balance will be automatically') or contains(text(),'Le solde du compte sera prélevé automatiquement du :')]")
	WebElement divAutoPaymentContainer;
	
	@FindBy(xpath = "//fss-account-detail//fss-preauth-payment//a[@aria-label='Change payment method' or @aria-label='Changer le mode de paiement']")
	WebElement btnPenIconForChangeAutoPaymentMethod;

	@FindBy(xpath = "//a[@title='Change payment method']")
	WebElement  inkPaymentMethod;

	@FindBy(xpath = "//h4//ins[@translate='payment-method.select-payment-method.setAutomaticPayment']")
	WebElement txtAutomaticPay;

	@FindBy(xpath = "//i[@class='fds-icon-close rds-icon-close']")
	WebElement btnAutomaticPayModelClose;

	@FindBy(xpath = "//fss-app-alert//p")
	WebElement divCLMNotification;

	@FindBy(xpath = "//fss-app-alert//a[contains(@title,'Make payment') or contains(@title,'Effectuer un paiement')]")
	WebElement  lnkMakePaymentCLMNotification;

	//@FindBy(xpath = "//dsa-subnav-desktop//span[@data-text='Profile & Settings' or @data-text='Profil et paramètres']")
	@FindBy(xpath="//dsa-subnav-desktop//span[@data-text='Settings' ]")
	WebElement subNavProfileAndSettings;

	@FindBy(xpath = "//h2[text()=' SORRY! ']")
	WebElement tempErrorHeader;

	@FindBy(xpath = "//button[@data-caption='Close']")
	WebElement tempErrorClose;

	@FindBy(xpath = "//dsa-subnav-desktop//span[@data-text='Account Overview' or @data-text='Aperçu du compte']")
	WebElement subNavAccountOverview;

	@FindAll({
		@FindBy(xpath = "//dsa-subnav-desktop//p[contains(text(),'Account Overview') or contains(text(),'Aperçu du compte')]"),
		@FindBy(xpath = "//dsa-subnav-desktop//p[text()='Account Overview' or text()='Aperçu du compte']")})
	WebElement headerAccountOverview;

	@FindBy(xpath = "//section[@class='fss-account-detail']")
	List<WebElement> lstOfAllAccounts;

	@FindAll({
	@FindBy(xpath = "//h1[contains(text(),'Your bill and account balance')]"),
	@FindBy(xpath = "//*[@translate='global.label.accountBillBalance']")
	})
	WebElement headerYourBillAndAccountBalance;

	@FindBy(xpath = "//ins[@translate='global.label.paymentHistory']")
	WebElement lnkPaymentHistory;

	@FindBy(xpath = "//fss-subscription-details/div/a[contains(text(),'Show all lines') or contains(text(),' Afficher toutes les lignes ')]")
	WebElement lnkShowAllLines;
	
	@FindBy(xpath = "//fss-subscription-details/div/a[contains(text(),'Hide all lines') or contains(text(),' Masquer toutes les lignes ')]")
	WebElement lnkHideAllLines;

	@FindBy(xpath = "//div[@class='fss-subscription-detail']")
	List<WebElement> lstCTNs;

	@FindBy(xpath = "//select[@id='selectCtn']")
	WebElement cmbSelectedCTNonDashboard;

	@FindBy(xpath = "//p[contains(text(),'Account Overview') or contains(text(),'Aperçu du compte')]")
	WebElement txtAccountOverview;

	@FindBy(xpath = "//ds-icon[@name='down']")
	WebElement subNavMobile;

	@FindBy(xpath = "//a[@href='#/my-account/overview']/ins[@translate='global.label.backToAccOverview']")
	WebElement lnkOverview;

	@FindBy (xpath="//ins[@translate='global.label.backToAccOverview']")
	WebElement lnkOverviewMobile;

	@FindBy(xpath = "//p[text()='Promise to Pay available' or text()='Vous devez reporter votre paiement?']")
	WebElement divPromiseToPayAvailable;

	@FindBy(xpath = "//span[text()='Set up Promise To Pay' or text()='Configurez une promesse de paiement.']")
	WebElement lnkSetUpPromiseToPay;

	@FindBy(xpath = "//select[@formcontrolname='paymentMethod']")
	WebElement selectPayType;

	@FindBy(xpath = "//select[@formcontrolname='paymentDate']")
	WebElement selectDate;

	@FindBy(xpath = "//*[@translate='promise-to-pay.setup-ptp.setup-btn']")
	WebElement btnSetUpPromise;

	@FindBy(xpath = "//h1[@translate='promise-to-pay.header']")
	WebElement headerSetUpPromise;

	@FindBy(xpath = "//span[@translate='promise-to-pay.setup-ptp.total-balance']")
	WebElement lblTotalBalanceToPay;

	@FindBy(xpath = "//select[@formcontrolname='paymentMethod']/parent::div")
	WebElement selectPayTypeDiv;

	@FindBy(xpath = "//*[@translate='promise-to-pay.success-ptp.header']")
	WebElement headerSetUpPromiseSuccessFul;
	
	@FindBy(xpath = "//*[@translate='promise-to-pay.success-ptp.done-btn']")
	WebElement btnDoneAfterSetUpPromiseSuccessFul;


	@FindBy (xpath = "//ds-modal//button[contains(@class,'-primary -large')]")
	WebElement winModalAAL;

	@FindBy(xpath = "//*[contains(@class,'billing-payment-section')]/a[1]")
	WebElement lblViewManageBill;

	@FindAll({
			@FindBy(xpath = "(//*[contains(@class,'d-inline-block')])[5]"),
			@FindBy(xpath = "//*[contains(@class,'list-inline')]/li[2]")
	})
	WebElement lblSavePDF;

	@FindAll({
			@FindBy(xpath = "(//*[contains(@class,'d-inline-block')])[9]"),
			@FindBy(xpath = "//*[contains(@translate,'global.label.saveBillPDF')]")
	})
	WebElement lblSaveYourBill;

	@FindAll({
			@FindBy(xpath = "//*[contains(text(),' Download bills ')]"),
			@FindBy(xpath = "//*[contains(@translate,'global.label.confirmAndSaveBills')]")
	})
	WebElement btnDownloadBill;

	@FindAll({
			@FindBy(xpath = "(//*[contains(@class,'d-inline-block')])[5]"),
			@FindBy(xpath = "//*[contains(@translate,'global.label.printPDF')]")
	})
	WebElement lblPrintPDF;

	@FindAll({
			@FindBy(xpath = "(//*[contains(@class,'d-inline-block')])[11]"),
			@FindBy(xpath = "//*[contains(@translate,'global.label.printBillPDF')]")
	})
	WebElement lblPrintYourBill;

	/**
	 * Click link "Add a line" in overview page.
	 * @author Saurav.Goyal
	 */
	public void clkLnkAddALine(String banNo) {
		reusableActions.clickWhenReady(By.xpath("//div[contains(@class,'add-another-line')]//a[contains(@title,'"+banNo+"')]"));
	}

	/**
	 * This method clicks on AAL link based on the flowType string in class name
	 * @param className
	 * @author praveen.kumar7
	 */
	public void clkAddALineLnkInModal(String className) {
		if(className.toUpperCase().contains("TERM")) {
			reusableActions.clickWhenReady(aalTermLnk);
		}
		else {
			reusableActions.clickWhenReady(aalByodLnk);
		}
	}

	/**
	 * Verify if the email name matches the email sent when register.
	 * @param strEmail string of registered email.
	 * @return true if match, else false.
	 * @author ning.xue
	 */
	public boolean verifyEmailInSignInAsLink(String strEmail) {
		reusableActions.waitForElementVisibility(lnkSignInAs, 100);
		String strEmailName = strEmail.substring(0, strEmail.indexOf('@')-1);
		List<WebElement> eleList = driver.findElements(By.xpath("//span[contains(text(),'" + strEmailName + "')]"));
		return eleList.size() > 0;
	}

	/**
	 * Check if the link "SIGN IN AS" is displayed. 
	 * @return true if the link displayed, else false.
	 * @author ning.xue
	 */
	public boolean isLnkSignInAsDisplayed() {
		return reusableActions.isElementVisible(lnkSignInAs);
	}

	/**
	 * Click link "Sign In As" in overview page.
	 * @author ning.xue
	 */
	public void clkLnkSignInAs() {
		reusableActions.waitForElementTobeClickable(lnkSignInAs, 100);
		reusableActions.getWhenReady(lnkSignInAs,30).click();
	}

	/**
	 * This will check if the label No payments made exists
	 * @return true if the label exists else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfAnyPaymentMade() {
		return !reusableActions.isElementVisible(labelNoPaymentMade);
	}

	/**
	 * Click on the menu Overview
	 * @author ning.xue
	 */
	public void clkMenuOverview() {
		reusableActions.waitForElementTobeClickable(menuOverview, 100);
		reusableActions.getWhenReady(menuOverview,30).click();
	}

	/**
	 * Click on the menu Overview
	 * @author sidhartha.vadrevu
	 */
	public void clkPaymentHistory() {
		reusableActions.waitForElementTobeClickable(btnPaymentHistory, 100);
		reusableActions.getWhenReady(btnPaymentHistory,30).click();
	}

	/**
	 * Click on Make a Payment Button
	 * @author sidhartha.vadrevu
	 */
	public void clkMakeAPayment() {
		reusableActions.scrollToElement(btnMakeAPayment);
		reusableActions.getWhenReady(btnMakeAPayment,30).click();
	}

	/**
	 * Click on the menu Billing and Payments
	 * @author ning.xue
	 */
	public void clkMenuBillingAndPayments() {
		try {
			reusableActions.waitForElementVisibility(menuBillingAndPayments, 60);
			reusableActions.getWhenReady(menuBillingAndPayments, 60).click();
			reusableActions.staticWait(3000);
		} catch (StaleElementReferenceException e) {
			reusableActions.waitForElementVisibility(menuBillingAndPayments, 60);
		}
	}

	public void clkPaymentHistoryOnMakePaymentPage() {
		reusableActions.clickWhenReady(btnPaymentHistory,40);
	}

	/**
	 * Validates if Payment History option is present on Payment Details page
	 */
	public Boolean verifyPaymentHistoryButton() {
		reusableActions.waitForElementVisibility(btnPaymentHistory, 40);
		return reusableActions.isElementVisible(btnPaymentHistory);
	}

	public void clkAutomaticPaymentsOnMakePaymentPage() {
		reusableActions.clickWhenReady(btnAutomaticPayments,40);
	}

	/**
	 * Click profile and Setting menu in overview page
	 * @author ning.xue
	 */
	public void clkMenuProfileNSetting() {
		boolean clickSuccess=false;
		int count=0;
		try {	
			while (count<=3 && !clickSuccess) {
				System.out.println("Attempt: "+(count+1)+" Profile and settings click");
				reusableActions.waitForElementTobeClickable(menuProfileNSetting, 360);
				// buffer static wait added to handle anomalies on firefox
				reusableActions.staticWait(4000);
				reusableActions.getWhenReady(menuProfileNSetting).click();		
				reusableActions.waitForElementVisibility(lblHeaderProfileAndSettings,60);
				if(reusableActions.isElementVisible(lblHeaderProfileAndSettings))
				{
					System.out.println("Profile and settings click successful in attempt: "+(count+1));
					clickSuccess=true;				
					break;

				}
				count++;
			}
		}catch (StaleElementReferenceException e) {
			String exceptionName[] = e.getClass().getCanonicalName().split("\\.");
			throw new WebDriverException("Failed due to  " + exceptionName[exceptionName.length - 1] + " on the \""
					+ Thread.currentThread().getStackTrace()[2].getMethodName() + "\"" + " action method");
		}

	}

	/**
	 * Click profile and Setting menu in overview page
	 * @author Mirza.Kamran
	 */
	public void clkMenuProfileNSettingMobile() {
		reusableActions.waitForElementTobeClickable(subNavMobile, 60);
		reusableActions.getWhenReady(subNavMobile).click();
		reusableActions.waitForElementTobeClickable(menuProfileAndSettingsMobile, 30);
		reusableActions.getWhenReady(menuProfileAndSettingsMobile).click();	
	}



	/**
	 * Click on the menu Usage Service
	 * @author Ning.Xue
	 */
	public void clkMenuUsageNService() {
		reusableActions.waitForElementTobeClickable(menuUsageNService,30);
		reusableActions.getWhenVisible(menuUsageNService, 30).click();

	}

	public void clkOverview() {
		reusableActions.getWhenVisible(lnkOverview, 60).click();
	}

	public void clkOverviewMobile() {
		reusableActions.getWhenVisible(lnkOverviewMobile, 60).click();
	}

	public void clkSubMenuMobile() {
		reusableActions.getWhenVisible(subMenuMobile, 60).click();
	}

	public void clkSubMenuMobileFromMenuUsageAndService() {
		boolean clickSuccess=false;
		int count=0;
		try {	
			while (count<=3 && !clickSuccess) {
				System.out.println("Attempt: "+(count+1)+" menu uasage and service");
				reusableActions.waitForElementTobeClickable(menuUsageNService, 360);					
				reusableActions.getWhenVisible(menuUsageNService, 30).click();	
				reusableActions.waitForElementVisibility(subMenuMobile,60);
				reusableActions.getWhenVisible(subMenuMobile, 60).click();
				if(reusableActions.isElementVisible(divUsageModuleHeader))
				{
					System.out.println("Usage and service page click successful in attempt: "+(count+1));
					clickSuccess=true;				
					break;

				}
				count++;
			}
		}catch (StaleElementReferenceException e) {
			String exceptionName[] = e.getClass().getCanonicalName().split("\\.");
			throw new WebDriverException("Failed due to  " + exceptionName[exceptionName.length - 1] + " on the \""
					+ Thread.currentThread().getStackTrace()[2].getMethodName() + "\"" + " action method");
		}	
	}

	/**
	 * Click on refillNow button in overview page for Fido pre-paid account.
	 * @author Ning.Xue
	 */
	public void clkBtnRefillNow() {
		reusableActions.getWhenReady(btnRefillNow, 20).click();
	}

	/**
	 * Click on Viw transaction button in overview page for Fido pre-paid account.
	 * @author Mirza.Kamran
	 */
	public void clkBtnViewTransaction() {
		reusableActions.getWhenReady(btnViewTransaction, 20).click();
	}

	/**
	 * Clicks on the btn Fido transactions
	 * @author Mirza.Kamran
	 */
	public void clkFidoTransactions() {
		int intCount=0;
		boolean transactionPgLoad = false;
		while(intCount<=3 && !transactionPgLoad) {
			System.out.println("Attemp :"+(intCount+1)+ "Click on Fido Transactions");
			reusableActions.clickWhenReady(btnFidoTransactions);
			if(reusableActions.isElementVisible(cellTransactionType)) {
				transactionPgLoad = true;
				break;
			}else
			{
				reusableActions.clickWhenReady(btnCalls);
				transactionPgLoad = false;
				intCount ++;
			}

		}

		if(!transactionPgLoad)
		{
			System.out.println("Seems the transaction didnt load correctly");
		}

	}
	
	/**
	 * click on CTN badge in overview page.
	 * @author Ning.Xue
	 */
	public void clkCtnBadge() {
		WebElement elmCtnBadge = getDriver().findElement(By.xpath("//div[@class='item content']"));
		reusableActions.getWhenReady(elmCtnBadge, 20).click();
		reusableActions.clickIfAvailable(btnCloseOverlay, 10);

	}

	/**
	 * click on CTN badge in overview page.
	 * @author Ning.Xue
	 */
	public void clkCtnBadge(String last4DigitCtn) {
		WebElement elmCtnBadge = getDriver().findElement(By.xpath("//div[@class='item content']//span[contains(text(),'" + last4DigitCtn +"')]"));
		reusableActions.getWhenReady(elmCtnBadge, 20).click();
		reusableActions.clickIfAvailable(btnCloseOverlay, 10);

	}

	/**
	 * checks if CTN badge is visible in overview page.
	 * @return true if the CTN badge is available else false
	 * @author Mirza.Kamran
	 */
	public boolean isCTNBadgeVisible() {
		return reusableActions.isElementVisible(divCtnBadge,10);
	}


	/**
	 * checks if Automatic Pay Text Display is visible in overview page.
	 * @return true if the text is available else false
	 * @author chinnarao.vattam
	 */
	public boolean isAutomaticPayTextDisplay() {
		return reusableActions.isElementVisible(txtAutomaticPay,60);
	}

	/**
	 * Click on Automatic Pay Model close button
	 * @author chinnarao.vattam
	 */
	public void clkAutomaticPayModelClose() {
		reusableActions.getWhenReady(btnAutomaticPayModelClose, 60).click();
	}


	/**
	 * Returns the dictionary collection of all the CTN users
	 * @return the map of CTNUsers
	 * @author Mirza.Kamran
	 */
	public Map<String, String>  getCTNUsers() {

		List<WebElement> ctnUsers=lnkCTNBadges;
		Map<String, String> dictionary = new HashMap<String, String>();
		Integer counter=1;
		for (WebElement webElement : ctnUsers) {
			dictionary.put("CTN"+counter, webElement.getText());
			counter++;
		}		

		return dictionary;
	}

	/**
	 * Click on the payNow button on the account overview page
	 * @author adittya.Dhingra 
	 */
	public void clkPayNow() {	
		boolean displayed=false;
		int counter=0;

		WebElement buttonPayNow=null;
		if(reusableActions.isElementVisible(btnPayNowDefault))
		{
			buttonPayNow= btnPayNowDefault;
		}else
		{
			buttonPayNow = lnkMakepayment;
		}

		while (counter<=3 && !displayed) {
			//Long wait time to make the page load 
			reusableActions.staticWait(10000);
			reusableActions.waitForElementVisibility(buttonPayNow,120);		
			reusableActions.waitForElementTobeClickable(buttonPayNow, 240);
			reusableActions.getWhenReady(buttonPayNow,120);    		
			reusableActions.executeJavaScriptClick(buttonPayNow);
			reusableActions.staticWait(3000);
			if(reusableActions.isElementVisible(txtAmount))
			{
				displayed=true;
			}

			counter++;
			reusableActions.staticWait(3000);
		}
	}


	/**
	 * Click on the payNow button on the account overview page
	 * @author adittya.Dhingra
	 */
	public void clkMakepayment() {
		reusableActions.getWhenReady(lnkMakepayment,60);
		reusableActions.clickWhenReady(lnkMakepayment,60);
	}

	/**
	 * Click on the payNow button on the account overview page
	 * @author adittya.Dhingra 
	 */
	public void clkPayNowMobile() {	
		boolean displayed=false;
		int counter=0;

		WebElement buttonPayNow=null;
		if(reusableActions.isElementVisible(btnPayNowDefaultMobile))
		{
			buttonPayNow= btnPayNowDefaultMobile;
		}else
		{
			buttonPayNow = btnPayNowMobile;
		}

		while (counter<=3 && !displayed) {
			//Long wait time to make the page load 
			reusableActions.staticWait(10000);
			reusableActions.waitForElementVisibility(buttonPayNow,120);		
			reusableActions.waitForElementTobeClickable(buttonPayNow, 240);
			reusableActions.getWhenReady(buttonPayNow,120);    		
			reusableActions.executeJavaScriptClick(buttonPayNow);
			reusableActions.staticWait(3000);
			if(reusableActions.isElementVisible(txtAmount))
			{
				displayed=true;
			}

			counter++;
			reusableActions.staticWait(3000);
		}
	}
	
	/**
	 * Selects the type of account from the Drop down on the account overview page
	 * @author adittya.Dhingra 
	 */
	public void clkAccountSelectionDropDown() {		
		reusableActions.getWhenReady(ddlAccountSelection,30).click();		
	}

	/**
	 * Click on the required service type on the account overview page
	 * @param strAccountType account to be selected by type
	 * @author adittya.Dhingra 
	 */
	public void selectAccountByType(String strAccountType) {		
		reusableActions.getWhenReady(By.xpath("//div[@class='account-div-cover']/span[text()='"+strAccountType+"']"),60).click();
	}

	/**
	 * select the account by the given BAN on the account overview page
	 * @param strAccountBAN ban of account to be selected
	 * @author adittya.Dhingra 
	 */
	public void selectAccountByBAN(String strAccountBAN) {		
		reusableActions.getWhenVisible(By.xpath("//div[@class='account-div-cover']/span[text()='"+strAccountBAN+"']"),10).click();
	}

	/**
	 * Click on the InternetBadge on the account overview page
	 * @author adittya.Dhingra 
	 */
	public void clkViewUsageManage() {
		reusableActions.waitForElementVisibility(lnkViewUsageManage,60);
		reusableActions.getWhenReady(lnkViewUsageManage,30).click();
	}

	/**
	 * Click on the InternetBadge on the account overview page
	 * @author adittya.Dhingra
	 */
	public void clkViewUsageManageMobile() {
		reusableActions.waitForElementVisibility(lnkViewUsageManageMobile,120);
		reusableActions.getWhenReady(lnkViewUsageManageMobile,30).click();
	}
	/**
	 * Click on the WirelessBadge on the account overview page
	 * @author chinnarao.vattam 
	 */
	public void clkWirelessBadge() {	
		try {
			reusableActions.waitForElementTobeClickable(badgeWireless, 300);
			reusableActions.executeJavaScriptClick(badgeWireless);
		}catch(StaleElementReferenceException ex)
		{
			reusableActions.waitForElementTobeClickable(badgeWireless, 300);
			reusableActions.executeJavaScriptClick(badgeWireless);
		}
	}
	/**
	 * Verify the Welcome heading on the account overview page
	 * @return true, if the account overview page display the Account Balance, else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifySuccessfulLoginOld() {
		String strBalance ="";
		try {
			//adding static buffers to avoid stale ref error
			reusableActions.staticWait(5000);			
//			 reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='account-balance-font-size']")),90);
			 strBalance = reusableActions.getWhenReady(By.xpath("//span[@class='account-balance-font-size']"),90).getText();
		}catch (StaleElementReferenceException e) {
//			reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='account-balance-font-size']")),90);
			reusableActions.staticWait(5000);
			strBalance = reusableActions.getWhenReady(By.xpath("//span[@class='account-balance-font-size']"),90).getText();
		}
     return NumberUtils.isCreatable(strBalance.replaceAll(",", "."));	
	}

	/**
	 * Verify the Welcome heading on the account overview page
	 * @return true, if the account overview page display the Account Balance, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySuccessfulLogin() {
		//reusableActions.executeJavaScriptClick(driver.findElement(By.xpath("//span[contains(text(),'Account Overview')]")));
		String strBalance ="";
		try {
			//adding static buffers to avoid stale ref error
			reusableActions.staticWait(5000);			
//			 reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='account-balance-font-size']")),90);
			//reusableActions.javascriptScrollByVisibleElement(driver.findElement(By.xpath("//div[contains(@class,'ds-price__amountDollars')]")));
			 strBalance = reusableActions.getWhenReady(By.xpath("//div[contains(@class,'ds-price__amountDollars')]"),90).getText();
		}catch (StaleElementReferenceException e) {
//			reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='account-balance-font-size']")),90);
			reusableActions.staticWait(5000);
			strBalance = reusableActions.getWhenReady(By.xpath("//div[contains(@class,'ds-price__amountDollars')]"),90).getText();
		}
     return NumberUtils.isCreatable(strBalance.replaceAll(",", ".").trim());	
	}

	/**
	 * Verify the 'Account Overview' heading is displayed on the account overview page
	 * @return true, if the 'Account Overview' is displayed, else false
	 * @author sidhartha.Vadrevu
	 */
	public boolean verifyLandingPageLoad() {
		reusableActions.waitForElementVisibility(txtAccountOverview, 40);
		return reusableActions.isElementVisible(txtAccountOverview);
	}
	
	/**
	 * Verify the Welcome heading on the account overview page
	 * @param strIntialBalance Intial Balance
	 * @param strLanguage Language.
	 * @return true, if the account overview page display the Welcome heading, else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyAccountPage(String strIntialBalance,String strLanguage ) {	
		reusableActions.getWhenReady(msgPaymentpage,90);
		if (strLanguage.equalsIgnoreCase("en"))
		{	
			String[] strBalanceValue= strIntialBalance.split("\\.");
			String strBalance= strBalanceValue[0];
			Integer intExpectedBalance= Integer.parseInt(strBalance)-1;
			String strExpectedBalance=Integer.toString(intExpectedBalance);
			reusableActions.getWhenVisible(By.xpath("//div[contains(text(),'"+strExpectedBalance+"')]"),180);
		}
		else
		{
			String[] strBalanceValue= strIntialBalance.split("\\,");
			String strBalance= strBalanceValue[0];
			Integer intExpectedBalance= Integer.parseInt(strBalance)-1;
			String strExpectedBalance=Integer.toString(intExpectedBalance);
			reusableActions.waitForElementVisibility((WebElement) By.xpath("//div[contains(text(),'"+strExpectedBalance+"')]"),180);
		}	
		return reusableActions.isElementVisible(msgPaymentpage,30);
	}

	/**
	 * Check if the login failed message displayed
	 * @return true if login fail message is displayed, otherwise false.
	 */
	public Boolean verifyLoginFailMsgIframe() {
		return reusableActions.isElementVisible(failLoginDiv, 10);
	}

	/**
	 * Click on the WirelessBadge on the account overview page
	 * @return the initial balance of the account
	 * @author chinnarao.vattam 
	 */
	public String getAccountBalanceBeforePayment() {    	
		String strIntialBalance=reusableActions.getWhenVisible(infoAccountBalance,30).getText();
		return strIntialBalance;
	}

	/**
	 * Click on the WirelessBadge on the account overview page
	 * @return the balance after payment of the account
	 * @author chinnarao.vattam 
	 */
	public String getAccountBalanceAfterpayment() {    	
		String strBalanceAfterpayment= reusableActions.getWhenVisible(infoAccountBalance,60).getText();
		return strBalanceAfterpayment;
	}

	/**
	 * Check if the automatic payment is set
	 * @return true if the auto payment is set, otherwise false
	 * @author ning.xue
	 */
	public boolean checkIfAutoPaymentIsSet() {
		return reusableActions.isElementVisible(lblAutoPayment, 10);
	}

	public void clkLnkEditAutoPayment() {
		reusableActions.getWhenReady(lnkEditAutoPayment, 10).click();
	}

	/**
	 * Verify whether the payment happened or not
	 * @param strIntialBalance initial balance of the account before payment 
	 * @param strBalanceAfterpay balance of the account after payment
	 * @param strPaymentAmount amount of the payment done
	 * @param strLanguage language of the application
	 * @return true, if the payment  happened, else false 
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyPayment(String strIntialBalance,String strBalanceAfterpay, String strPaymentAmount,String strLanguage ) { 

		if (strLanguage.equalsIgnoreCase("en"))
		{	
			Double intialBalance= Double.parseDouble(strIntialBalance);
			Double balanceAfterpay= Double.parseDouble(strBalanceAfterpay);
			Double paidAmt= intialBalance-balanceAfterpay;
			int paidAmount=paidAmt.intValue();
			if(strPaymentAmount.equals(Integer.toString(paidAmount)))
			{return  true;}
			else {return  false;}
		}
		else
		{
			Double intialBalance= Double.parseDouble(FormFiller.currencyConverter(strIntialBalance));
			Double balanceAfterpay= Double.parseDouble(FormFiller.currencyConverter(strBalanceAfterpay));
			Double paidAmt= intialBalance-balanceAfterpay;
			int paidAmount=paidAmt.intValue();
			if(strPaymentAmount.equals(Integer.toString(paidAmount)))
			{return  true;}
			else {return  false;}
		}  	
	}


	/**
	 * clicks on the link change method of payment
	 * @author Mirza.Kamran
	 */
	public void clkChangeMethodOfPayment() {
		reusableActions.waitForElementTobeClickable(lnkChangeMethodOfPayment, 120);
		reusableActions.getWhenReady(lnkChangeMethodOfPayment).click();				
	}

	/**
	 * Selects the payment option
	 * @param strValue string value for payment option
	 * @author Mirza.Kamran
	 */
	public void selectPaymentOption(String strValue) {
		reusableActions.waitForElementVisibility(ddlPaymentOption);
		reusableActions.selectWhenReady(ddlPaymentOption, strValue);    	
	}

	/**
	 * Verifies the account suspension message
	 * @return true if the message for account suspension is displayed ,else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAccountSuspension() {		
		return reusableActions.isElementVisible(msgAccountSuspended,30);

	}

	/**
	 * Verifies the account suspended warning is displayed or not
	 * @return true if the message is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAccountSuspendedWarning() {		
		return reusableActions.isElementVisible(msgAccountSuspendedWarning,10);

	}

	/**
	 * Verifies if the button for service is not visible
	 * @return true if the btnService is visible, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTheAbsenceOfService() {		
		return reusableActions.isElementVisible(btnService,10);

	}

	/**
	 * Clicks the first CTN badge visible
	 * @author Mirza.Kamran
	 */
	public void selectFirstCTNBadge() {	
		reusableActions.clickIfAvailable(divFirstCTNBadge);

	}

	/**
	 * To select sub-menu of billing and payments, need to click billing and payment menu before select any sub-menu.
	 * @param enumBillandPaymentOption Enum, sub-menu options of Billing And Payment menu
	 * @author Mirza.Kamran
	 */
	public void selectBillingAndpaymentsSubMenus(BillingAndPaymentsSubMenuOptions enumBillandPaymentOption) {	   
		switch(enumBillandPaymentOption)
		{
		case ViewBill:
			reusableActions.clickIfAvailable(subMenuViewBill);
			break;		   
		case MakePayment:
			reusableActions.clickIfAvailable(subMenuMakeAPayment);
			break;
		case PaymentHistory:
			reusableActions.clickIfAvailable(subMenuPaymentHistory);
			break;
		case SetAutomaticPayments:
			reusableActions.clickIfAvailable(subMenuSetUpAutomaticPayment);
			break;
		default:
			System.out.print("No sub menu matched in the billing and payment sub menu");
			break;
		}

	}

	/**
	 * To select sub-menu of billing and payments & open it in a new tab, need to click billing and payment menu before select any sub-menu.
	 * @param enumBillandPaymentOption Enum, sub-menu options of Billing And Payment menu
	 */
	public void selectBillingAndpaymentsSubMenuInNewTab(BillingAndPaymentsSubMenuOptions enumBillandPaymentOption) {
		switch(enumBillandPaymentOption)
		{
			case ViewBill:
				reusableActions.waitForElementTobeClickable(subMenuViewBill,60);
				reusableActions.getWhenReady(subMenuViewBill).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
				break;
			case MakePayment:
				reusableActions.waitForElementTobeClickable(subMenuMakeAPayment,60);
				reusableActions.getWhenReady(subMenuMakeAPayment).sendKeys(Keys.CONTROL,Keys.ENTER);
				break;
			case PaymentHistory:
				reusableActions.waitForElementTobeClickable(subMenuPaymentHistory,60);
				reusableActions.getWhenReady(subMenuPaymentHistory).sendKeys(Keys.CONTROL,Keys.ENTER);
				break;
			case SetAutomaticPayments:
				reusableActions.waitForElementTobeClickable(subMenuSetUpAutomaticPayment,60);
				reusableActions.getWhenReady(subMenuSetUpAutomaticPayment).sendKeys(Keys.CONTROL,Keys.ENTER);
				break;
			default:
				System.out.print("No sub menu matched in the billing and payment sub menu");
				break;
		}

	}

	/**
	 * Clicks on the Button view bill
	 * @author Mirza.Kamran
	 */
	public void clkViewBill() {
		reusableActions.clickIfAvailable(btnCloseAccountSetupProgress);
		reusableActions.staticWait(2000);	   
		reusableActions.clickIfAvailable(btnViewBill);

	}

	/**
	 * Wait for View Bill to become visible
	 * @author Mirza.Kamran
	 */
	public void waitforViewBillToLoad() {
		reusableActions.waitForElementTobeClickable(btnViewBill, 120);	  
	}


	/**
	 * Gets the CTN number displayed on the CTN badge
	 * @param strCTNDetails The CTN complete details as displayed 
	 * @return CTN number 
	 * @author Mirza.Kamran
	 */
	public String getPhoneNumberFromCTNbadge(String strCTNDetails) {

		Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
		String[] temp = strCTNDetails.split(" ");
		String contact = null;
		for(String item: temp)
		{
			Matcher match = pattern.matcher(item);
			if (match.matches()) {
				contact = item;
				break;
			}		      
		}
		return contact;

	}

	/**
	 * Checks if the cancelled CTN access limited is displayed on the account overview page
	 * @return true if the limited access message is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelledCTNAccountAccessLimitedMessage() {		
		return reusableActions.isElementVisible(msgAccountAccessLimited,30);

	}

	/**
	 * Checks if the cancelled CTN message is displayed below the your mobile account area
	 * @return true if the cancelled message is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAccountOverviewCalcelledWarningUnderYourMobileAccount() {		
		return reusableActions.isElementVisible(msgAccountCancelled,10);

	}

	/**
	 * Waits for paynow button to become clickable
	 * @author Mirza.Kamran
	 */
	public void waitForPayNowToBecomeClickable() {

		reusableActions.clickIfAvailable(btnCloseAccountSetupProgress);	
		if(reusableActions.isElementVisible(btnPayNowDefault))
		{
			reusableActions.waitForElementTobeClickable(btnPayNowDefault, 60);
		}else
		{
			reusableActions.waitForElementTobeClickable(btnPayNow, 60);
		}


	}
	
	/**
	 * Waits for paynow button to become clickable
	 * @author Mirza.Kamran
	 */
	public void waitForPayNowToBecomeClickableMobile() {

		reusableActions.clickIfAvailable(btnCloseAccountSetupProgress);	
		if(reusableActions.isElementVisible(btnPayNowDefaultMobile))
		{
			reusableActions.waitForElementTobeClickable(btnPayNowDefaultMobile, 60);
		}else
		{
			reusableActions.waitForElementTobeClickable(btnPayNowMobile, 60);
		}


	}

	/**
	 * Clicks on the CTN badge for the specified Subscriber number
	 * @param strCTN Subscriber number
	 * @author rajesh.varalli1
	 */
	public void clkSpecificCTNBadge(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		reusableActions.clickWhenVisible(By.xpath("//span[text()='"+ strCTN +"']/ancestor::a[@class='btn']"),30);
	}
	/**
	 * Clicks on the view usage and manage link
	 * @author Saurav.Goyal
	 */
	public void clkViewUsageAndManageLink(String ctn) {
		reusableActions.clickWhenVisible(By.xpath("//a[contains(@aria-label,'"+ctn+"')]"),30);
	}
	/**
	 * Waits until the Loading indicator disappears from the page
	 * @author rajesh.varalli1
	 */
	public void waitForAccountInfoLoading() {
		if(reusableActions.isElementVisible(lblLoadingIndicator)) {
			reusableActions.waitForElementVisibility(lblLoadingIndicator, 60);
		}
	}

	/**
	 * Scroll to middle of page
	 * @author Mirza.Kamran
	 */
	public void scrollToMiddleOfPage() {
		reusableActions.javascriptScrollToMiddleOfPage();

	}

	/**
	 * Clicks on usage and service for prepaid
	 * @author Mirza.Kamran
	 */
	public void clkMenuUsageNServicePrepaid() {		
		boolean clickSuccess=false;
		int count=0;
		try {	
			while (count<=3 && !clickSuccess) {
				System.out.println("Attempt: "+(count+1)+" Usage and service click");
				reusableActions.getWhenReady(menuUsageNServicePrePaid, 60).click();											
				if(reusableActions.isElementVisible(lblUsageHeaderPrePaidDashboardPage,60))
				{
					System.out.println("usage and services successful in attempt: "+(count+1));
					clickSuccess=true;				
					break;

				}
				count++;
			}
		}catch (StaleElementReferenceException e) {
			String exceptionName[] = e.getClass().getCanonicalName().split("\\.");
			throw new WebDriverException("Failed due to  " + exceptionName[exceptionName.length - 1] + " on the \""
					+ Thread.currentThread().getStackTrace()[2].getMethodName() + "\"" + " action method");
		}

	}

	/**
	 * View prepaid usage and services
	 * @author Mirza.Kamran
	 */
	public void clkViewUsageAndServices(String strBAN) {
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-details']//span[contains(text(),'View Usage & Manage') or contains(text(),'Voir l’utilisation et gérer')]")).click();

	}
	
	/**
	 * Scrolls to top of webpage
	 */
	public void scrollToTopOfPage() {
		reusableActions.javascriptScrollToTopOfPage();

	}

	/**
	 * Scrolls to bottom of webpage
	 */
	public void scrollToBottomOfPage() {
		reusableActions.javascriptScrollToBottomOfPage();		
	}

	/**
	 * Validate if the tasks in Onboarding widgets is displayed
	 * @return true if the progress and widgets is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAccountSetUpWidgetLoginToMyAccountPresent() {
		return reusableActions.isElementVisible(btnLoginToMyAccount,30);		 
	}

	/**
	 * Validate if the tasks in Onboarding widgets is displayed
	 * @return true if the progress and widgets is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAccountSetUpWidgetSetContactInfoPresent() {
		return reusableActions.isElementVisible(btnSetContactInfo,30);		 
	}

	/**
	 * Validate if the tasks in Onboarding widgets is displayed
	 * @return true if the progress and widgets is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAccountSetUpWidgetSetUpAutomaticPaymentPresent() {
		return reusableActions.isElementVisible(btnSetUpAutomaticPayments,30);		
	}
	/**
	 * Validate if the tasks in Onboarding widgets is displayed
	 * @return true if the progress and widgets is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAccountSetUpWidgetSetUpMobileRecoveryPresent() {
		return reusableActions.isElementVisible(btnSetUpMobileRecovery,30);		 

	}
	/**
	 * Validate if the tasks in Onboarding widgets is displayed
	 * @return true if the progress and widgets is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAccountSetUpProgressBarDisplayed() {
		return reusableActions.isElementVisible(lblProgressBar,30);

	}

	/**
	 * Checks if the setup for Mobile Recovery Number is Not done
	 * @return true if the recovery is not set; else false
	 * @author Mirza.Kamran
	 */
	public boolean checkIfSetUpMobileRecoveryNumberIsNotComplete() {			
		return (reusableActions.getWhenVisible(btnSetUpMobileRecovery,30).getAttribute("aria-label").toLowerCase().trim().contains("pending")
				||reusableActions.getWhenVisible(btnSetUpMobileRecovery,30).getAttribute("aria-label").toLowerCase().trim().contains("en attente"));
	}

	/**
	 * Checks if the setup for Mobile Recovery Number is done
	 * @return true if the recovery is set; else false
	 * @author Mirza.Kamran
	 */
	public boolean checkIfSetUpMobileRecoveryNumberIsComplete() {			
		return (reusableActions.getWhenVisible(btnSetUpMobileRecovery,30).getAttribute("aria-label").toLowerCase().trim().contains("complete")
				|| reusableActions.getWhenVisible(btnSetUpMobileRecovery,30).getAttribute("aria-label").toLowerCase().trim().contains("est terminé"));
	}

	/**
	 * Get the Set up progress percentage
	 * @return string value of percentage
	 * @author Mirza.Kamran
	 */
	public String getAccountSetUpProgressPercentage() {
		return reusableActions.getWhenReady(progressBar).getAttribute("aria-valuenow").trim().replaceAll(",", "");
	}

	/**
	 * Clicks on set uo recovery number
	 * @author Mirza.Kamran
	 */
	public void clkSetUpMobileRecoveryNumber() {
		reusableActions.clickIfAvailable(btnSetUpMobileRecovery);

	}

	/**
	 * Clicks set up now button 
	 * @author Mirza.Kamran
	 */
	public void clkSetUpNowButton() {
		reusableActions.clickWhenReady(btnSetupNowButton);
	}

	/**
	 * Checks if the title recovery is dispalyed
	 * @return true if the title is displayed
	 * @author Mirza.Kamran
	 */
	public boolean isTitleSetUpRecoveryDisplayed() {
		return reusableActions.isElementVisible(titleRecoveryNumber);
	}

	/**
	 * @author Mirza.Kamran
	 */
	public void clkPenIconForChangePaymentMethod() {
		if (reusableActions.isElementVisible(btnPenIconForChangeAutoPaymentMethod)) {
			reusableActions.getWhenReady(btnPenIconForChangeAutoPaymentMethod).click();
		}
	}

	/**
	 * @author chinnarao.vattam
	 */
	public void clkChangePaymentMethod() {
		reusableActions.getWhenReady(inkPaymentMethod).click();
	}


	/**
	 * 
	 * @return true if element visisble
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfAtleastOneUserHasAutoPaymentSet() {
		// TODO Auto-generated method stub
		return reusableActions.isElementVisible(divAutoPaymentContainer,20) 
				 && reusableActions.isElementVisible(btnPenIconForChangeAutoPaymentMethod);
	}

	/**
	 * Check if Credit limit exceeded notification is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCLMNotificationIsDisplayed() {		
		return reusableActions.isElementVisible(divCLMNotification);
	}

	/**
	 * Checks make payment link in CLM notification
	 * @return true if displayed else false
	 */
	public boolean verifyIfMakePaymentIsDisplayedCLMNotificationIsDisplayed() {
		
		return reusableActions.isElementVisible(lnkMakePaymentCLMNotification);
	}

	/**
	 * Click make payment link on CLM notification
	 * @author Mirza.Kamran
	 */
	public void clkMakePaymentOnCLMNotification() {
	reusableActions.getWhenReady(lnkMakePaymentCLMNotification).click();
		
	}

	/**
	 * Cheks if Sub Navigation shows Account Overview and Profile and Settings 
	 * @return true if both visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySubNavHasAOandPnSNavigationOptions() {		
		return (reusableActions.isElementVisible(subNavAccountOverview)
				&& reusableActions.isElementVisible(subNavProfileAndSettings));
	}

	/**
	 * Account overview is open by default
	 * @author Mirza.Kamran
	 */
	public boolean verifyAccountOverviewIsOpenByDefault() {
		return reusableActions.isElementVisible(headerAccountOverview);
	}


	/**
	 * Click profile and Setting menu in overview page
	 * @author Mirza.Kamran
	 */
	public void clkSubNavProfileAndSettings() {
		boolean clickSuccess=false;
		int count=0;
		try {	
			while (count<=3 && !clickSuccess) {
				System.out.println("Attempt: "+(count+1)+" Profile and settings click");
				reusableActions.waitForElementTobeClickable(subNavProfileAndSettings, 60);
				// buffer static wait added to handle anomalies on firefox
				reusableActions.staticWait(4000);
				reusableActions.getWhenReady(subNavProfileAndSettings).click();
				if (reusableActions.isElementVisible(tempErrorHeader)){
					reusableActions.clickWhenReady(tempErrorClose);
				}
				reusableActions.getWhenReady(lblHeaderProfileAndSettings,60).click();
				if(reusableActions.isElementVisible(lblHeaderProfileAndSettings))
				{
					System.out.println("Profile and settings click successful in attempt: "+(count+1));
					clickSuccess=true;				
					break;

				}
				count++;
			}
		}catch (StaleElementReferenceException e) {
			String exceptionName[] = e.getClass().getCanonicalName().split("\\.");
			throw new WebDriverException("Failed due to  " + exceptionName[exceptionName.length - 1] + " on the \""
					+ Thread.currentThread().getStackTrace()[2].getMethodName() + "\"" + " action method");
		}

	}
	
	/**
	 * Checks if PnS page is open
	 * @return true if open else false
	 * @author Mirza.Kamran
	 */
	public boolean isProfileAndSettingsPageDisplayed()
	{
	 return	reusableActions.isElementVisible(lblHeaderProfileAndSettings);
	}

	/**
	 * 
	 * @return
	 */
	public boolean validateCancelledBadgeAndThePlacementOfBadgeInAOpage(String strCancelledBAN) {	
		WebElement cancelledBadge = getDriver().findElement(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//span[contains(text(),'Cancelled') or contains(text(),' Fermé ')]"));
		WebElement accountType = getDriver().findElement(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//h2"));
		int xDiff = cancelledBadge.getLocation().x-accountType.getLocation().x;
		int yDiff = Math.abs(accountType.getLocation().y-cancelledBadge.getLocation().y);
		return (reusableActions.isElementVisible(cancelledBadge)
				&& (xDiff>50 && yDiff<=10));
	}

	public boolean validateBillingCTAButtonAndAALOfferForCancelledAccount(String strCancelledBAN) {
		
		return (reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'View all bills from past 18 months for account "+strCancelledBAN+"')]"),1))
				&& reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'Make a payment for mobile account "+strCancelledBAN+"')]"),1)
				&& !reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@title,'Add a line to mobile account')]"),1);
	}

	public boolean validateViewBillHistoryLink(String strCancelledBAN) {
		
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@title,'View all bills from past')]"));
	}

	public void clkViewBillHistoryink(String strCancelledBAN) {
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@title,'View all bills from past')]")).click();
		
	}

	/**
	 * Validates if the details of active account is displayed as expected
	 * @param strActiveBan string of Active BAN
	 * @return true if all details displayed as expected else false
	 * @author Mirza.Kamran
	 */
	public boolean validateDetailsForActiveAccounts(String strActiveBan) {
		//System.out.println("--------------------------------------------------1")+;
		
		return (reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strActiveBan+"')]/ancestor::section[@class='fss-account-detail']//ds-price"),1)
				&& reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strActiveBan+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'View and manage bill for internet account "+strActiveBan+"')]"), 1))
				&& reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strActiveBan+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label, 'Make a payment for internet account "+strActiveBan+"')]"), 1)
				&& !reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strActiveBan+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@title,'Add a line to mobile account')]"), 1);
	}

	/**
	 * validate account balance is not displayed for cancelled account
	 * @param strCancelledBan cancelled BAN
	 * @return true if the balance is not displayed
	 * @author Mirza.Kamran
	 */
	public boolean validateAccountBalanceNotDisplayedForCancelledAccount(String strCancelledBan) {		
		return !reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strCancelledBan+"')]/ancestor::section[@class='fss-account-detail']//ds-price"));
	}

	
	/**
	 * 
	 * @return
	 */
	public boolean validateUserIsDirectedToInvoiceHistoryPageSuccessFully() {
		
		return reusableActions.isElementVisible(headerYourBillAndAccountBalance);
	}

	/**
	 * 
	 * @param strCancelledBAN
	 * @return
	 */
	public boolean IsAnyCancelledAccountDisplayed(String strCancelledBAN) {
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strCancelledBAN+"')]/ancestor::section[@class='fss-account-detail']//span[contains(text(),'Cancelled') or contains(text(),' Fermé ')]"));
	}

	public void clkPaymentHistoryLink() {
		reusableActions.getWhenReady(lnkPaymentHistory).click();
	}

	public boolean verifyIfShowAllLinesLinkIsDisplayd(String strBAN) {		
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(text(),'Show all lines') or contains(text(),'Afficher toutes les lignes')]"));
	}
	
	public boolean validateIfMoreThan5CTNSDisplayedInTheViewAllCTNList(String strBAN)
	{
		List<WebElement> lstCTN = driver.findElements((By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//fss-subscription-details/div/ss-smooth-height/fss-subscription-detail//div[@class='subscription-number']")));
		return lstCTN.size()>5;
	}

	public void clkShowAllLinesLink() {
		reusableActions.getWhenReady(lnkShowAllLines).click();
		
	}
	
	public void clkHideAllLinesLink() {
		reusableActions.getWhenReady(lnkHideAllLines).click();
		
	}

	public boolean verifyIfAddLineLinkIsDisplayed(String strBAN) {	
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@title,'Add a line to mobile account') or contains(@title,'Ajouter une ligne au compte mobile')]"));
	}

	public boolean verifyAllCTNsPresentinTheBANwithCorrectNameNumberAndAddManageLink(String strBANIWithMoreThan5CTNS) {
		boolean allDetailsCorrect = false;
		
		for (WebElement ctnRow : lstCTNs) {					
			String subscriberName = ctnRow.findElement(By.xpath("//div[@class='subscription-name text-semi']")).getText();
			String strCTN = ctnRow.findElement(By.xpath("//div[@class='subscription-name text-semi']//following-sibling::div[@class='subscription-number']")).getText();
			String strCTNValue = strCTN.trim().replaceAll(" ", "").replaceAll("-", "");
			WebElement lnkUsage = getDriver().findElement(By.xpath("//div[@class='fss-subscription-detail']//a[contains(@aria-label,'"+strCTNValue+"')]"));
			if(!subscriberName.isEmpty()
				&& isCTNFormatCorrect(strCTN)
				&& reusableActions.isElementVisible(lnkUsage))					
					{
					allDetailsCorrect = true;
					}else
					{
						allDetailsCorrect =false;
						break;
					}
											
		}
		
		return allDetailsCorrect;
	}

	private boolean isCTNFormatCorrect(String strCTN) {
		return Pattern.matches("\\d{3}[\\s]\\d{3}-\\d{4}", strCTN);
	}

	/**
	 * 
	 * @param strBANIWithMoreThan5CTNS
	 * @return
	 */
	public boolean verifyIfUserReDirectsToCorrectCTNDashboard(String strBANIWithMoreThan5CTNS) {
		List<WebElement> lstCTNNumbers = driver.findElements(By.xpath("//fss-subscription-detail//div[@class='subscription-name text-semi']//following-sibling::div[@class='subscription-number']"));
		String []arrayCTNS = getAllCTNS(lstCTNNumbers);
		
		
		boolean dashboardvalidated = false;
		
		for (String strCTNValue : arrayCTNS) {
				reusableActions.clickIfAvailable(lnkShowAllLines); //click only when available
				//Click on the respective CTN
				
				clickCTNsViewUsageAndManageLink(strCTNValue.trim().replaceAll(" ", "").replaceAll("-", ""));
				
				if(IsCorrectDashboardOpen(strCTNValue))
				{
					dashboardvalidated =true;
					NavigateToAccountOverViewFromDashbOard();
				}else
				{
					dashboardvalidated =false;
					break;
				}
			
			
		}
		
		return dashboardvalidated;
	}
	
	public void NavigateToAccountOverViewFromDashbOard() {
		reusableActions.getWhenReady(By.xpath("//a[@title='Account Overview' or @title='Aperçu du compte']")).click();
		
	}

	public boolean IsCorrectDashboardOpen(String strCTNValue) {
		return reusableActions.getSelectedValue(cmbSelectedCTNonDashboard).trim().contains(strCTNValue.trim());
	}

	public void clickCTNsViewUsageAndManageLink(String strCTNValue) {

		reusableActions.getWhenReady(By.xpath("//div[@class='fss-subscription-detail']//a[contains(@aria-label,'"+strCTNValue+"')]")).click();
	}

	
	/**
	 * 
	 * @param lstCTNNumbers
	 * @return
	 */
	public String[] getAllCTNS(List<WebElement> lstCTNNumbers) {
		String[] arrayCTN = new String[lstCTNNumbers.size()];
		int counter=0;
		for (WebElement ctn : lstCTNNumbers) {
			arrayCTN[counter]=ctn.getText().trim();
			counter++;
		}
		return arrayCTN;
	}

	public void clkIfAvailableShowAllLinesLink() {
		reusableActions.clickIfAvailable(lnkShowAllLines);
		
	}

	public List<WebElement> getListOfCTNNumbers() {		
		return driver.findElements(By.xpath("//fss-subscription-detail//div[@class='subscription-name text-semi']//following-sibling::div[@class='subscription-number']"));
	}

	/**
	 * Clicks on View Usage and Manage string
	 * @param strCTN string value containing CTN
	 * @author Mirza.Kamran
	 */
	public void clkCTNsViewUsageAndManage(String strCTN) {
		reusableActions.staticWait(3000);
		reusableActions.getWhenReady(By.xpath("//div[@class='fss-subscription-detail']//a[contains(@aria-label,'"+strCTN+"')]")).click();
	}

	/**
	 * 
	 * @param strBAN
	 */
	public void clkViewBillNew(String strBAN) {
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'View and manage bill for') or contains(@aria-label,'la facture du compte')]"),30).click();
	}

	/**
	 * 
	 * @param strBAN
	 */
	public void clkPayNowNew(String strBAN) {
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'Make a payment for') or contains(@aria-label,'Faire un paiement')]")).click();
	}

	public void clkSetUpAutomaticPayments(String strBAN) {
		if (reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'Set up Automatic Payments for') or contains(@aria-label,'Configurer les paiements automatiques')]"))) {
			reusableActions.getWhenReady(By.xpath("//span[contains(text(),'"+strBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'Set up Automatic Payments for') or contains(@aria-label,'Configurer les paiements automatiques')]")).click();
		}
	}

	public void clkBtnRefillNowNew(String strBAN) {
		reusableActions.getWhenReady(By.xpath("//a[@aria-label='refill balance for prepaid account "+strBAN+"']")).click();
	}

	public void clkBtnViewTransactionsNew(String strBAN) {
		reusableActions.getWhenReady(By.xpath("//a[@aria-label='see most recent transactions for prepaid account "+strBAN+"']")).click();
	}
	
	public boolean verifyPromiseToPayLink() {		
		return reusableActions.isElementVisible(divPromiseToPayAvailable);
	}

	public boolean verifySetupPromiseToPayLinkSubMenu() {
		reusableActions.waitForElementVisibility(lnkSetUpPromiseToPay, 20);
		return reusableActions.isElementVisible(lnkSetUpPromiseToPay);
	}

	public void clkSetUpAPromiseToPay() {
		reusableActions.getWhenReady(lnkSetUpPromiseToPay).click();
	}

	public void selectHowWouldYouLikeToPromiseToPay(String strPaymentType) {	
		if(strPaymentType.contains("Credit Card"))
		{
		reusableActions.selectWhenReady(selectPayType, 0);
		}else
		{
			reusableActions.selectWhenReady(selectPayType, 1);
		}
		
	}

	public void clkPrepaidViewUsageAndManage(String strBAN) {
		reusableActions.getWhenReady(By.xpath("//a[@aria-label='refill balance for prepaid account "+strBAN+"']")).click();
	}
	
	public String selectWhenYouWillIkeToPayThePromise() {
		Select dropdown = new Select(selectDate);
		reusableActions.selectWhenReady(selectDate, dropdown.getOptions().size()-1);
		reusableActions.staticWait(1000);
		return reusableActions.getSelectedValue(selectDate);
	}

	public void clkSetUpPromise() {
		reusableActions.getWhenReady(btnSetUpPromise).click();
	}

	public boolean verifySetUpPromiseToPayPageIsLoaded() {	
		return (reusableActions.isElementVisible(headerSetUpPromise) && 
				reusableActions.isElementVisible(lblTotalBalanceToPay));
	}

	public boolean verifyPromiseToSetUpSuccessFul() {		
		return reusableActions.isElementVisible(headerSetUpPromiseSuccessFul,30);
				//&& reusableActions.getWhenReady(By.xpath("//*[@translate='promise-to-pay.success-ptp.th-1']/parent::div/following-sibling::div")).getText().trim().replace("$", "").replaceAll(",", ".").contains(strBalanceValue.replaceAll(",", "."))
				//&& reusableActions.getWhenReady(By.xpath("//*[@translate='promise-to-pay.success-ptp.th-2']/parent::div/following-sibling::div")).getText().trim().contains(strDate));
	}

	public void clkDoneSetUpPromiseAfterSuccess() {
		reusableActions.getWhenReady(btnDoneAfterSetUpPromiseSuccessFul).click();
	}

	public String getBalanceValueForPromise() {
		
		return reusableActions.getWhenReady(By.xpath("//*[@class='ds-price']")).getAttribute("aria-label").trim().replace("$", "");
	}
	
public boolean validateBillingCTAButtonAddLineForSuspendedAccount(String strSuspendedBAN) {
		
		return (reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strSuspendedBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'View and manage bill for mobile account')  or contains(@aria-label,'Voir et gérer la facture')]"),1)
				&& reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strSuspendedBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'Make a payment for') or contains(@aria-label,'Faire un paiement au')]"),1)
				&& !reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strSuspendedBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@title,'Add a line to mobile account') or contains(@title,'Ajouter une ligne au compte mobile')]"),1)
				&& !reusableActions.isElementVisible(By.xpath("//div[@class='fss-subscription-detail']")));
	}

	/**
	 * validates suspended account and checks if View Bill Button And Make A Payment Button Exist
	 * @author Rohit.Kumar
	 */
	public boolean validateAccountSuspendedWithViewBillButtonAndMakeAPaymentButtonExists(String strSuspendedBAN) {

		return (reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strSuspendedBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'View and manage bill for mobile account')  or contains(@aria-label,'Voir et gérer la facture')]"),1)
				&& reusableActions.isElementVisible(By.xpath("//span[contains(text(),'"+strSuspendedBAN+"')]/ancestor::section[@class='fss-account-detail']//a[contains(@aria-label,'Make a payment for') or contains(@aria-label,'Faire un paiement au')]"),1)
				&& reusableActions.isElementVisible(By.xpath("//span[contains(@title,'"+strSuspendedBAN+"')]/span"),1));
	}
	
	/**
	 * Clicks on View and Manage Bill lable
	 * @author Vedachalam.Vasudevan 
	 */
	public void clkViewManageBill() {
		reusableActions.clickWhenVisible(lblViewManageBill, 30);
	}
	
	/**
	 * Clicks on Save PDF link
	 * @author Vedachalam.Vasudevan
	 */
	public void clkSavePDF() {
		reusableActions.getWhenReady(lblSavePDF, 30).click();
	}
	
	/**
	 * Clicks on Save PDF link
	 * @author Vedachalam.Vasudevan
	 */
	public void clkPrintPDF() {
		reusableActions.getWhenReady(lblPrintPDF, 30).click();
	}
	
	/**
	 * Clicks on Save your bill link
	 * @author Vedachalam.Vasudevan
	 */
	public void clkSaveYourBill() {
		reusableActions.getWhenReady(lblSaveYourBill, 30).click();
	}
	
	
	/**
	 * Clicks on Save your bill link
	 * @author Vedachalam.Vasudevan
	 */
	public void clkPrintYourBill() {
		reusableActions.getWhenReady(lblPrintYourBill, 30).click();
	}
	
	
	/**
	 * Clicks on Download Bill link
	 * @author Vedachalam.Vasudevan
	 */
	public void clkDownloadBill() {
		reusableActions.getWhenReady(btnDownloadBill, 30).click();
	}
	
	/**
	 * verify that Bill download successfully
	 * @return true bill download successfully else false
	 * @author Vedachalam.Vasudevan
	 */
	public boolean verifyDownloadBill()	{
		return reusableActions.isElementVisible(By.xpath("//ds-modal-container[@aria-label='Success!']"), 20);  //ins[@translate='global.message.pdfDownloadSuccess']
	}

	public boolean IsAutoPaymentSetUp() {
		return reusableActions.isElementVisible(divAutoPaymentContainer,20) 
						 && reusableActions.isElementVisible(btnPenIconForChangeAutoPaymentMethod);
	}
	public boolean verifyFinancedAccessoriesIsDisplayed() {
		return reusableActions.isElementVisible(btnFinancedAccessories);

	}

	public void clkFinancedAccessories() {
		reusableActions.getWhenReady(btnFinancedAccessories).click();

	}
	
}
