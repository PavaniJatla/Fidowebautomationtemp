package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
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

	@FindBy (xpath="//span[@class='accountDivider']")
	WebElement ddlAccountSelection;

	@FindBy (xpath="//div[@class='col-xs-12 col-sm-3 vertical-divider payment-info']//ins")
	WebElement btnPayNow;

	@FindBy (xpath="//ins[@translate='global.cta.payNow']")
	WebElement btnPayNowDefault;

	@FindBy (xpath="//div[@class='list-item']//a[@href='#/my-account/internet']")
	WebElement badgeInternet;	
	//div[@ng-if='subscriberService.internet']/a/div/div[@class='item arrow']

	@FindBy (xpath="//div[@ng-if='subscriberService.wireless']/a")
	WebElement badgeWireless;

	@FindBy (xpath="//h1[@class='welcome-text']")
	WebElement msgWelcome;

	@FindBy (xpath="//span[@class='account-balance-font-size']")
	WebElement infoAccountBalance;

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

	@FindAll({@FindBy(xpath = "//div[@class='row page-dashboard-service-section']//a[@class='btn']")})
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

	@FindBy(xpath = "//span[contains(@class,'header')]//*[@translate='global.label.overview']")
	WebElement menuOverviewMobile;

	@FindBy(xpath = "//*[@class='modal-dialog']//*[@translate='global.label.profileAndSettings']")
	WebElement menuProfileAndSettingsMobile;

	@FindBy(xpath = "//ins[@translate='global.message.myAccountNoPaymentHistory']")
	WebElement labelNoPaymentMade;

	@FindBy(xpath="//*[@id='amount']")
	WebElement txtAmount;

	@FindBy(xpath = "//span[@translate='onboarding-module.close']")
	WebElement btnCloseAccountSetupProgress;

	@FindBy(xpath = "//h1[@translate='global.label.profile']")
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

	@FindBy (xpath = "//span[@class='new-line-name']")
	WebElement lnkAddALine;

	//@FindBy (xpath = "//span[@translate='aal.cta.addALineFlowDevice']/parent::button/preceding-sibling::div//span")
	//@FindBy (xpath = "//span[@translate='aal.cta.addALineFlow']/parent::button")
	@FindBy (xpath = "//ds-modal//button[contains(@class,'-primary -large')]")
	WebElement buttonAALCurrentPhone;

	@FindBy (xpath = "//div[@class='modal-body']//div[@class='btn-padding hidden-xs']//following-sibling::button")
	WebElement buttonAALNewPhone;

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


	/**
	 * Click button "Add a line" on modal dialogue window.
	 * @author Saurav.Goyal
	 */
	public void clkButtonAALNewPhone() {
		reusableActions.waitForElementTobeClickable(buttonAALNewPhone, 100);
		reusableActions.getWhenReady(buttonAALNewPhone,30).click();
	}

	/**
	 * Click button "Add a line" on modal dialogue window.
	 * @author Saurav.Goyal
	 */
	public void clkButtonAddALine() {
		reusableActions.waitForElementTobeClickable(buttonAALCurrentPhone, 100);
		reusableActions.getWhenReady(buttonAALCurrentPhone,30).click();
	}

	/**
	 * Click link "Add a line" in overview page.
	 * @author Saurav.Goyal
	 */
	public void clkLnkAddALine() {
		reusableActions.waitForElementTobeClickable(lnkAddALine, 100);
		reusableActions.getWhenReady(lnkAddALine,30).click();
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
	 * Click on the menu Billing and Payments
	 * @author ning.xue
	 */
	public void clkMenuBillingAndPayments() {
		try {
			reusableActions.waitForElementVisibility(menuBillingAndPayments,60);
			reusableActions.getWhenReady(menuBillingAndPayments,60).click();
		}catch (StaleElementReferenceException e) 
		{
			reusableActions.waitForElementVisibility(menuBillingAndPayments,60);
		}
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
		reusableActions.waitForElementTobeClickable(menuOverviewMobile, 60);
		reusableActions.getWhenReady(menuOverviewMobile).click();
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
		try {
		reusableActions.getWhenReady(divCtnBadge, 20);
		reusableActions.getWhenReady(divCtnBadge, 20).click();
		//		reusableActions.clickIfAvailable(btnCloseOverlay, 5);
		}catch (StaleElementReferenceException e) {
			reusableActions.waitForElementTobeClickable(divCtnBadge, 20);
			reusableActions.getWhenReady(divCtnBadge, 20).click();
		}
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
			buttonPayNow = btnPayNow;
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
	public void clkInternetBadge() {
		reusableActions.waitForElementVisibility(badgeInternet,60);
		reusableActions.getWhenReady(badgeInternet,30).click();
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
	public boolean verifySuccessfulLogin() {
		String strBalance ="";
		try {
//			 reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='account-balance-font-size']")),90);
			 strBalance = reusableActions.getWhenReady(By.xpath("//span[@class='account-balance-font-size']"),90).getText();
		}catch (StaleElementReferenceException e) {
//			reusableActions.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='account-balance-font-size']")),90);
			strBalance = reusableActions.getWhenReady(By.xpath("//span[@class='account-balance-font-size']"),90).getText();
		}
     return NumberUtils.isCreatable(strBalance.replaceAll(",", "."));	
	}

	/**
	 * Verify the Welcome heading on the account overview page
	 * @param strIntialBalance Intial Balance
	 * @param strLanguage Language.
	 * @return true, if the account overview page display the Welcome heading, else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyAccountPage(String strIntialBalance,String strLanguage ) {	
		reusableActions.getWhenReady(msgWelcome,90);
		if (strLanguage.equalsIgnoreCase("en"))
		{	
			String[] strBalanceValue= strIntialBalance.split("\\.");
			String strBalance= strBalanceValue[0];
			Integer intExpectedBalance= Integer.parseInt(strBalance)-1;
			String strExpectedBalance=Integer.toString(intExpectedBalance);
			reusableActions.getWhenVisible(By.xpath("//span[contains(text(),'"+strExpectedBalance+"')]"),180);
		}
		else
		{
			String[] strBalanceValue= strIntialBalance.split("\\,");
			String strBalance= strBalanceValue[0];
			Integer intExpectedBalance= Integer.parseInt(strBalance)-1;
			String strExpectedBalance=Integer.toString(intExpectedBalance);
			reusableActions.waitForElementVisibility((WebElement) By.xpath("//span[contains(text(),'"+strExpectedBalance+"')]"),180);
		}	
		return reusableActions.isElementVisible(msgWelcome,30);	
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
		String strIntialBalance=reusableActions.getWhenVisible(infoAccountBalance,3).getText();
		return strIntialBalance;
	}

	/**
	 * Click on the WirelessBadge on the account overview page
	 * @return the balance after payment of the account
	 * @author chinnarao.vattam 
	 */
	public String getAccountBalanceAfterpayment() {    	
		String strBalanceAfterpayment= reusableActions.getWhenVisible(infoAccountBalance,3).getText();
		return strBalanceAfterpayment;
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
		return reusableActions.getWhenReady(progressBar).getAttribute("aria-valuenow").trim();
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
}