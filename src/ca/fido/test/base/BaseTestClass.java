package ca.fido.test.base;

import ca.fido.pages.*;
import ca.fido.pages.ens.EnsHomePage;
import ca.fido.pages.ens.EnsNotificationViewPage;
import ca.fido.ssp.pages.SSPFidoRetailerChampPage;
import ca.fido.ssp.pages.SSPFidoRetailerHomePage;
import ca.fido.ssp.pages.SSPFidoRetailerSearchResultsPage;
import ca.fido.ssp.pages.SSPFidoRetailerShopPage;
import ca.fido.test.commonbusiness.CommonBusinessFlows;
import ca.fido.test.commonbusiness.VerifyInEns;
import ca.fido.test.helpers.CaptchaBypassHandlers;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.test.helpers.FidoEnums.SauceCapabilities;
import ca.fido.testdatamanagement.TestDataHandler;
import extentreport.ExtentTestManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import utils.BrowserDrivers;
import utils.Reporter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/*@Listeners ({ca.fido.test.listeners.TestListener.class , ca.fido.test.listeners.AnnotationTransformer.class , ca.fido.test.listeners.TestListener.class })*/


public class BaseTestClass {

	private WebDriver driver;
	private AppiumDriver<MobileElement> adriver;
	public Reporter reporter;	
	protected HashMap<String,String> xmlTestParameters;
	public EnsHomePage ensHomePage;
	public EnsNotificationViewPage ensNoteViewPage;
	protected VerifyInEns ensVerifications;
	public FidoHomePage fido_home_page;
	public FidoLoginPage fido_login_page;
	public FidoAccountOverviewPage fido_account_overview_page;
	protected FidoLogintoFacebookPage fido_loginto_facebook_page;
	protected FidoAccountRegistrationPage fido_account_registration_page;
	public FidoProfileAndSettingPage fido_profile_and_setting_page;
	protected FidoPaymentOptionsPage fido_payment_options_page;
	protected FidoMakePaymentPage fido_make_payment_page;
	protected FidoRecoverPassOrNamePage fido_recover_pass_or_name_page;
	protected FidoPaymentHistoryPage fido_payment_history_page;
	protected FidoPrepaidLinkAccountPage fido_prepaid_link_account_page;
	protected FidoInternetDashboardPage fido_Internet_dashboard_page;
	protected FidoInteracOnlinePage fido_interac_online_page;
	protected FidoCommunityPage fido_Community_Page;
	protected FidoRefillPage fido_refill_page;
	protected FidoWirelessDashboardPostpaidPage fido_wireless_dashboard_postpaid_page;
	protected FidoWirelessDashboardPrepaidPage fido_wireless_dashboard_prepaid_page;
	protected FidoAddDataPage fido_add_data_page;
	protected FidoChangeCTNPage fido_change_CTN_page;
	protected FidoReportLostOrStolenPage fido_report_lost_or_stolen_page;
	protected FidoBillDetailsPage fido_bill_details_page;
	protected FidoResetVoiceMailPasswordPage fido_reset_voicemail_password_page;
	protected FidoDeviceReservationSystemPage fido_device_reservation_system_page;
	protected FidoDataManagementPage fido_data_management_page;
	protected FidoSetPasswordPage fido_set_password_page;
	protected boolean isDockerStarted = false;
	protected CommonBusinessFlows common_business_flows; 
	protected FidoPaymentPage fido_payment_page;
	protected FidoInternetDashboardPage fido_internet_dashboard_page;
	protected FidoInternetPackageChangeReviewOrderPage fido_internet_package_change_review_order_page;
	protected FidoShopInternetPage fido_Shop_internet_page;
	protected FidoCartSummaryPage fido_cart_summary_page;
	protected FidoCreateUserPage fido_create_user_page;
	protected FidoCreditCheckPage fido_credit_check_page;
	protected FidoTechnicalInstallationPage fido_technical_installation_page;
	protected FidoOrderConfirmationPage fido_order_confirmation_page;
	protected SSPFidoRetailerShopPage fido_ssp_retailer_shop_page;	
	protected SSPFidoRetailerHomePage fido_ssp_retailer_home_page;
	protected SSPFidoRetailerSearchResultsPage fido_ssp_retailer_search_results_page;
	protected FidoInternetPackagePage fido_internet_package_page;
	protected FidoChoosePhonePage fido_choose_phone_page;
	protected FidoChoosePlanPage fido_choose_plan_page;
	protected FidoBuildPlanPage fido_build_plan_page;
	protected FidoChooseAddonsPage fido_choose_addons_page;
	protected FidoChooseNumberPage fido_choose_number_page;
	protected FidoOrderReviewPage fido_order_review_page;
	protected FidoChooseSimPage fido_chosse_sim_page;
	protected FidoShippingPage fido_shipping_page;
	protected BrowserDrivers browserdriver;
	protected SSPFidoRetailerChampPage retailer_champ_page;	
	private CaptchaBypassHandlers captcha_bypass_handlers;
	protected FidoDeviceConfigPage fido_device_config_Page;
	private Map<String,String> sauceParameters;
	private Map<String,String> RunParameters;

	public BaseTestClass() {
		 browserdriver =  new BrowserDrivers();
		 
	}
	
	/**
	 * This method will initialize a hash map with the sauce parameters
	 * @param strBrowser string containing the browser name for sauce
	 * @return hashmap with sauce capabilities
	 * @author Mirza.Kamran
	 */
	 private Map<String, String> initializeSauceParamsMap(String strBrowser) {
		
		 Map<String,String> sauceOptions = new HashMap<String, String>();
		 sauceOptions.put(SauceCapabilities.seleniumVersion.toString(), TestDataHandler.sauceSettings.getSauceOptions().getSeleniumVersion());
		 sauceOptions.put(SauceCapabilities.maxDuration.toString(), TestDataHandler.sauceSettings.getSauceOptions().getMaxDuration());
		 sauceOptions.put(SauceCapabilities.commandTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getCommandTimeout());
		 sauceOptions.put(SauceCapabilities.idleTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getIdleTimeout());
		 sauceOptions.put(SauceCapabilities.build.toString(), TestDataHandler.sauceSettings.getSauceOptions().getBuild());
		 switch (strBrowser.toLowerCase()) {
         case "saucechrome":                            
             sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getPlatformName());                     
             sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getBrowserVersion());
             break;
         case "saucefirefox":                                       
             sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getPlatformName());                     
             sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getBrowserVersion());
             break;
         case "sauceedge":
             sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getPlatformName());                     
             sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getBrowserVersion());
             break;
         case "sauceandroidchrome":
        	 sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getPlatformName()); 
        	 sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getPlatformVersion()); 
        	 sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getAppiumVersion()); 
        	 sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceName()); 
        	 sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceOrientation()); 
        	 break;
		}
			 			  		        		
		return sauceOptions;
	}


	/** To start a session using given url, browser, language and test case group name.
	 * @param strUrl                     string of test url
	 * @param enumGroupName              string of group name of the test case
	 * @param currentTestMethodName 	 string of the current test name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */

	public void startSession(String strUrl, String strBrowser,  String strLanguage,FidoEnums.GroupName enumGroupName, Method currentTestMethodName) throws ClientProtocolException, IOException {
		RunParameters = getExecutionParameters(strBrowser, strLanguage);
		String browser = RunParameters.get("Browser");
		String language = RunParameters.get("Language");

	    if(browser.contains("sauce"))
		{
			sauceParameters = initializeSauceParamsMap(browser);
		}
		this.driver = browserdriver.driverInit(browser,sauceParameters, currentTestMethodName, enumGroupName.toString());
		System.out.println(strUrl + "----------------------------------------------------------------------------");
		captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
		switch(enumGroupName.toString().toLowerCase().trim()) {
			case "connectedhome_anonymous":
				driver.get(strUrl+"/pages/api/selfserve/bypassrecaptcha");
				driver.get(strUrl+"/consumer/easyloginriverpage"+"?setLanguage="+ language);break;

				case "connectedhome_login":
					driver.get(strUrl+"/pages/api/selfserve/bypassrecaptcha");
				driver.get(strUrl+"/consumer/easyloginriverpage"+"?setLanguage="+ language);
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
				break;

			case "selfserve":
			case "selfserve_login":
				driver.get(strUrl+"/consumer/easyloginriverpage"+"?setLanguage="+ language );
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
				break;
			case "connectedhome_ssp":
			case "buyflows": driver.get(strUrl);
				break;

			default :
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
		}

		setImplicitWait(getDriver(), 50);
		getDriver().manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		init(enumGroupName.toString().toLowerCase().trim());
	}


	/**
	 * To initiate the page objects based on test case group, will read group name from xml file.
	 * @param strGroupName string of group name.
	 */
	private void init(String strGroupName) {
		reporter = new ExtentTestManager(getDriver());	
		common_business_flows = new CommonBusinessFlows(this);
		switch(strGroupName) {
		
		case "selfserve":
		case "selfserve_login":
			
			fido_home_page = new FidoHomePage(driver);
			fido_login_page = new FidoLoginPage(driver);
			fido_account_overview_page = new FidoAccountOverviewPage(driver);
			fido_loginto_facebook_page = new FidoLogintoFacebookPage(driver);
			fido_account_registration_page = new FidoAccountRegistrationPage(driver);
			fido_profile_and_setting_page = new FidoProfileAndSettingPage(driver);
			fido_payment_options_page = new FidoPaymentOptionsPage(driver);
			fido_make_payment_page =new FidoMakePaymentPage(driver);
			fido_recover_pass_or_name_page = new FidoRecoverPassOrNamePage(driver);
			fido_payment_history_page = new FidoPaymentHistoryPage(driver);
			fido_prepaid_link_account_page = new FidoPrepaidLinkAccountPage(driver);
			fido_interac_online_page = new FidoInteracOnlinePage(driver);
			fido_Internet_dashboard_page = new FidoInternetDashboardPage(driver);
			fido_Community_Page = new FidoCommunityPage(driver);
			fido_refill_page = new FidoRefillPage(driver);
			fido_wireless_dashboard_postpaid_page = new FidoWirelessDashboardPostpaidPage(driver);
			fido_wireless_dashboard_prepaid_page = new FidoWirelessDashboardPrepaidPage(driver);
			fido_add_data_page = new FidoAddDataPage(driver);
			fido_report_lost_or_stolen_page = new FidoReportLostOrStolenPage(driver);
			fido_change_CTN_page = new FidoChangeCTNPage(driver);
			fido_bill_details_page = new FidoBillDetailsPage(driver);
			fido_reset_voicemail_password_page = new FidoResetVoiceMailPasswordPage(driver);
			fido_device_reservation_system_page =  new FidoDeviceReservationSystemPage(driver);	
			fido_data_management_page = new FidoDataManagementPage(driver);
			fido_set_password_page = new FidoSetPasswordPage(driver);
			ensHomePage = new EnsHomePage(driver);
			ensNoteViewPage = new EnsNotificationViewPage(driver);
			ensVerifications = new VerifyInEns(this);
			break;
			
		case "connectedhome_login":
			
			fido_home_page = new FidoHomePage(driver);
			fido_login_page = new FidoLoginPage(driver);
			fido_account_overview_page = new FidoAccountOverviewPage(driver);
			fido_payment_page = new FidoPaymentPage(driver);
			fido_internet_dashboard_page = new FidoInternetDashboardPage(driver);
			fido_account_registration_page= new FidoAccountRegistrationPage(driver);
			fido_internet_package_change_review_order_page= new FidoInternetPackageChangeReviewOrderPage(driver);
			fido_Shop_internet_page= new FidoShopInternetPage(driver);
			fido_cart_summary_page= new FidoCartSummaryPage(driver);
			fido_create_user_page= new FidoCreateUserPage(driver); 
			fido_credit_check_page= new FidoCreditCheckPage(driver);
			fido_technical_installation_page= new FidoTechnicalInstallationPage(driver);
			fido_payment_options_page= new FidoPaymentOptionsPage(driver);
			fido_order_confirmation_page= new FidoOrderConfirmationPage(driver);
			fido_internet_package_page=new FidoInternetPackagePage(driver); 
			break;

			case "connectedhome_anonymous":
			case "connectedhome_ssp":
				fido_home_page = new FidoHomePage(driver);
				fido_payment_page = new FidoPaymentPage(driver);
				fido_internet_dashboard_page = new FidoInternetDashboardPage(driver);
				fido_account_registration_page= new FidoAccountRegistrationPage(driver);
				fido_internet_package_change_review_order_page= new FidoInternetPackageChangeReviewOrderPage(driver);
				fido_Shop_internet_page= new FidoShopInternetPage(driver);
				fido_cart_summary_page= new FidoCartSummaryPage(driver);
				fido_create_user_page= new FidoCreateUserPage(driver);
				fido_credit_check_page= new FidoCreditCheckPage(driver);
				fido_payment_page = new FidoPaymentPage(driver);
				fido_technical_installation_page= new FidoTechnicalInstallationPage(driver);
				fido_payment_options_page= new FidoPaymentOptionsPage(driver);
				fido_order_confirmation_page= new FidoOrderConfirmationPage(driver);
				fido_ssp_retailer_shop_page= new SSPFidoRetailerShopPage(driver);
				fido_ssp_retailer_home_page= new SSPFidoRetailerHomePage(driver);
				fido_ssp_retailer_search_results_page= new SSPFidoRetailerSearchResultsPage(driver);
				fido_internet_package_page=new FidoInternetPackagePage(driver);
				retailer_champ_page= new SSPFidoRetailerChampPage(driver);
				break;

		case "buyflows":
			fido_home_page = new FidoHomePage(getDriver());
			fido_login_page = new FidoLoginPage(getDriver());
			fido_account_overview_page = new FidoAccountOverviewPage(getDriver());
			fido_wireless_dashboard_postpaid_page = new FidoWirelessDashboardPostpaidPage(getDriver());
			fido_choose_phone_page = new FidoChoosePhonePage(getDriver());
			fido_choose_plan_page = new FidoChoosePlanPage(getDriver());
			fido_build_plan_page = new FidoBuildPlanPage(getDriver());
			fido_choose_addons_page = new FidoChooseAddonsPage(getDriver());
			fido_cart_summary_page = new FidoCartSummaryPage(getDriver());
			fido_create_user_page = new FidoCreateUserPage(getDriver());
			fido_credit_check_page = new FidoCreditCheckPage(getDriver());
			fido_choose_number_page = new FidoChooseNumberPage(getDriver());
			fido_payment_options_page = new FidoPaymentOptionsPage(getDriver());
			fido_order_review_page = new FidoOrderReviewPage(getDriver());
			fido_order_confirmation_page = new FidoOrderConfirmationPage(getDriver());
			fido_chosse_sim_page = new FidoChooseSimPage(getDriver());
			fido_shipping_page = new FidoShippingPage(getDriver());
			fido_payment_page = new FidoPaymentPage(getDriver());
			fido_device_config_Page = new FidoDeviceConfigPage(getDriver());
			
		default:
			

		}	
		
		
	}

	
	/**
	 * To close session, quit driver and close every associated windows.
	 */
	public void closeSession() {			
		getDriver().quit();		
	}

	/**
	 * To set implicit wait for the test.
	 * @param driver   the web driver
	 * @param seconds  wait time by seconds
	 */
	public void setImplicitWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * To get the web driver in use.
	 * @return driver, WebDriver which is using
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	/**
	 * To get parameters from XML file, it is called in TestListener.
	 * @return HashMap of test parameters
	 */
	public HashMap<String, String> getXMLParameters() {
		return xmlTestParameters;
	}

	/** To start a session using given url, browser, language and test case group name.
	 * @param strLanguage    string of test Language
	 * @param strBrowser     string of browser name
	 * @return HashMap of test TestParameters
	 */
		public static HashMap<String, String>  getExecutionParameters(String strBrowser,String strLanguage) {
		if (System.getProperty("Browser") == null || System.getProperty("Browser").isEmpty())
		{
			System.setProperty("Browser", strBrowser);
		}
		if (System.getProperty("Language") == null ||  System.getProperty("Language").isEmpty())
		{
			System.setProperty("Language", strLanguage);
		}
		if(System.getProperty("Browser").equals("") && strBrowser.isEmpty())
		{
			System.setProperty("Browser", "chrome");
		}
		if(System.getProperty("Language").equals("") && strLanguage.isEmpty() )
		{
			System.setProperty("Language", "en");
		}
		strBrowser= System.getProperty("Browser");
		strLanguage= System.getProperty("Language");
		HashMap<String, String> TestParameters = new HashMap<>();
		TestParameters.put("Browser", strBrowser);
		TestParameters.put("Language", strLanguage );
		return TestParameters;
	}

}
