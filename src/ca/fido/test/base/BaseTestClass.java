package ca.fido.test.base;

import ca.fido.oneview.pages.*;
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
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import extentreport.ExtentListener;
import extentreport.ExtentTestManager;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import utils.BrowserDrivers;
import utils.Reporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/*@Listeners ({ca.fido.test.listeners.TestListener.class , ca.fido.test.listeners.AnnotationTransformer.class , ca.fido.test.listeners.TestListener.class })*/


public class BaseTestClass {

	protected BrowserDrivers browserdriver;
	private Reporter reporter;
	private EyesRunner runner;
	protected static Eyes eyes;
	protected HashMap<String,String> xmlTestParameters;
	protected static final ThreadLocal<EnsHomePage> ensHomePageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<EnsNotificationViewPage> ensNoteViewPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<VerifyInEns> ensVerificationsThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoHomePage> FidoHomePageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoLoginPage> FidoLoginPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoAccountOverviewPage> FidoAccountOverviewPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoLogintoFacebookPage> FidoLogintoFacebookPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoAccountRegistrationPage> FidoAccountRegistrationPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoProfileAndSettingPage> FidoProfileAndSettingPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoPaymentOptionsPage> FidoPaymentOptionsPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoMakePaymentPage> FidoMakePaymentPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoRecoverPassOrNamePage> FidoRecoverPassOrNamePageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoPaymentHistoryPage> FidoPaymentHistoryPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoPrepaidLinkAccountPage> FidoPrepaidLinkAccountPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoInteracOnlinePage> FidoInteracOnlinePageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoCommunityPage> FidoCommunityPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoRefillPage> FidoRefillPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoWirelessDashboardPostpaidPage> FidoWirelessDashboardPostpaidPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoWirelessDashboardPrepaidPage> FidoWirelessDashboardPrepaidPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoAddDataPage> FidoAddDataPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoChangeCTNPage> FidoChangeCTNPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoReportLostOrStolenPage> FidoReportLostOrStolenPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoBillDetailsPage> FidoBillDetailsPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoResetVoiceMailPasswordPage> FidoResetVoiceMailPasswordPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoDeviceReservationSystemPage> FidoDeviceReservationSystemPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoDataManagementPage> FidoDataManagementPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoSetPasswordPage> FidoSetPasswordPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<CommonBusinessFlows> CommonBusinessFlowsThreadLocal = new ThreadLocal<>(); 
	protected static final  ThreadLocal<FidoPaymentPage> FidoPaymentPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoInternetDashboardPage> FidoInternetDashboardPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoInternetPackageChangeReviewOrderPage> FidoInternetPackageChangeReviewOrderPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoShopInternetPage> FidoShopInternetPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoCartSummaryPage> FidoCartSummaryPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoCreateUserPage> FidoCreateUserPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoCreditCheckPage> FidoCreditCheckPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoTechnicalInstallationPage> FidoTechnicalInstallationPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoOrderConfirmationPage> FidoOrderConfirmationPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<SSPFidoRetailerShopPage> FidoRetailerShopPageThreadLocal = new ThreadLocal<>();	
	protected static final  ThreadLocal<SSPFidoRetailerHomePage> FidoRetailerHomePageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<SSPFidoRetailerSearchResultsPage> FidoRetailerSearchResultsPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoInternetPackagePage> FidoInternetPackagePageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoChoosePhonePage> FidoChoosePhonePageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoChoosePlanPage> FidoChoosePlanPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoBuildPlanPage> FidoBuildPlanPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoChooseAddonsPage> FidoChooseAddonsPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoChooseNumberPage> FidoChooseNumberPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoOrderReviewPage> FidoOrderReviewPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoChooseSimPage> FidoChooseSimPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoShippingPage> FidoShippingPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<SSPFidoRetailerChampPage> FidoRetailerChampPageThreadLocal = new ThreadLocal<>();	
	protected static final  ThreadLocal<FidoDeviceConfigPage> FidoDeviceConfigPageThreadLocal = new ThreadLocal<>();
	protected static final  ThreadLocal<FidoCheckOutPage> FidoCheckOutPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoInternetUsagePage> FidoInternetUsagePageThreadLocal = new ThreadLocal<>();

	protected static final ThreadLocal<EnvironmentSelectionPage> environmentSelectionPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<AccountOverViewPage> accountOverViewPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoOVChoosePhonePage> fidoOVChoosePhonePageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoOVPlanConfigPage> fidoOVPlanConfigPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoOVCheckoutPage> fidoOVCheckoutPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoOVReviewOrderPage> fidoOVReviewOrderPageThreadLocal = new ThreadLocal<>();
	protected static final ThreadLocal<FidoOVOrderConfirmationPage> fidoOVOrderConfirmationPageThreadLocal = new ThreadLocal<>();

	protected static final ThreadLocal<FidoFinanceAccessoriesPage> FidoFinanceAccessoriesPageThreadLocal = new ThreadLocal<>();

	protected static final ThreadLocal<FidoShippingCartPage> FidoShippingCartPageThreadLocal = new ThreadLocal<>();

	protected boolean isDockerStarted = false;
	private CaptchaBypassHandlers captcha_bypass_handlers;
	private Map<String,String> sauceParameters;
	private Map<String,String> RunParameters;

	public BaseTestClass() {
		 browserdriver =  new BrowserDrivers();
		 
	}

	public Reporter getReporter() {
		return reporter;
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public HashMap<String, String> getXmlTestParameters() {
		return xmlTestParameters;
	}

	public void setXmlTestParameters(HashMap<String, String> xmlTestParameters) {
		this.xmlTestParameters = xmlTestParameters;
	}

	public CaptchaBypassHandlers getCaptcha_bypass_handlers() {
		return captcha_bypass_handlers;
	}

	public void setCaptcha_bypass_handlers(CaptchaBypassHandlers captcha_bypass_handlers) {
		this.captcha_bypass_handlers = captcha_bypass_handlers;
	}

	public Map<String, String> getSauceParameters() {
		return sauceParameters;
	}

	public void setSauceParameters(Map<String, String> sauceParameters) {
		this.sauceParameters = sauceParameters;
	}

	public Map<String, String> getRunParameters() {
		return RunParameters;
	}

	public void setRunParameters(Map<String, String> runParameters) {
		RunParameters = runParameters;
	}

	public static EnsHomePage getEnshomepage() {
		return ensHomePageThreadLocal.get();
	}

	public static EnsNotificationViewPage getEnsnoteviewpage() {
		return ensNoteViewPageThreadLocal.get();
	}

	public static VerifyInEns getEnsverifications() {
		return ensVerificationsThreadLocal.get();
	}

	public static FidoHomePage getFidohomepage() {
		return FidoHomePageThreadLocal.get();
	}

	public static FidoLoginPage getFidologinpage() {
		return FidoLoginPageThreadLocal.get();
	}

	public static FidoAccountOverviewPage getFidoaccountoverviewpage() {
		return FidoAccountOverviewPageThreadLocal.get();
	}

	public static FidoLogintoFacebookPage getFidologintofacebookpage() {
		return FidoLogintoFacebookPageThreadLocal.get();
	}

	public static FidoAccountRegistrationPage getFidoaccountregistrationpage() {
		return FidoAccountRegistrationPageThreadLocal.get();
	}

	public static FidoProfileAndSettingPage getFidoprofileandsettingpage() {
		return FidoProfileAndSettingPageThreadLocal.get();
	}

	public static FidoInternetUsagePage getFidoInternetUsagePage() {
		return FidoInternetUsagePageThreadLocal.get();
	}

	public static FidoPaymentOptionsPage getFidopaymentoptionspage() {
		return FidoPaymentOptionsPageThreadLocal.get();
	}

	public static FidoMakePaymentPage getFidomakepaymentpage() {
		return FidoMakePaymentPageThreadLocal.get();
	}

	public static FidoRecoverPassOrNamePage getFidorecoverpassornamepage() {
		return FidoRecoverPassOrNamePageThreadLocal.get();
	}

	public static FidoPaymentHistoryPage getFidopaymenthistorypage() {
		return FidoPaymentHistoryPageThreadLocal.get();
	}

	public static FidoPrepaidLinkAccountPage getFidoprepaidlinkaccountpage() {
		return FidoPrepaidLinkAccountPageThreadLocal.get();
	}

	public static FidoInteracOnlinePage getFidointeraconlinepage() {
		return FidoInteracOnlinePageThreadLocal.get();
	}

	public static FidoCommunityPage getFidocommunitypage() {
		return FidoCommunityPageThreadLocal.get();
	}

	public static FidoRefillPage getFidorefillpage() {
		return FidoRefillPageThreadLocal.get();
	}

	public static FidoWirelessDashboardPostpaidPage getFidowirelessdashboardpostpaidpage() {
		return FidoWirelessDashboardPostpaidPageThreadLocal.get();
	}

	public static FidoWirelessDashboardPrepaidPage getFidowirelessdashboardprepaidpage() {
		return FidoWirelessDashboardPrepaidPageThreadLocal.get();
	}

	public static FidoAddDataPage getFidoadddatapage() {
		return FidoAddDataPageThreadLocal.get();
	}

	public static FidoChangeCTNPage getFidochangectnpage() {
		return FidoChangeCTNPageThreadLocal.get();
	}

	public static FidoReportLostOrStolenPage getFidoreportlostorstolenpage() {
		return FidoReportLostOrStolenPageThreadLocal.get();
	}

	public static FidoBillDetailsPage getFidobilldetailspage() {
		return FidoBillDetailsPageThreadLocal.get();
	}

	public static FidoResetVoiceMailPasswordPage getFidoresetvoicemailpasswordpage() {
		return FidoResetVoiceMailPasswordPageThreadLocal.get();
	}

	public static FidoDeviceReservationSystemPage getFidodevicereservationsystempage() {
		return FidoDeviceReservationSystemPageThreadLocal.get();
	}

	public static FidoDataManagementPage getFidodatamanagementpage() {
		return FidoDataManagementPageThreadLocal.get();
	}

	public static FidoSetPasswordPage getFidosetpasswordpage() {
		return FidoSetPasswordPageThreadLocal.get();
	}

	public static CommonBusinessFlows getCommonbusinessflows() {
		return CommonBusinessFlowsThreadLocal.get();
	}

	public static FidoPaymentPage getFidopaymentpage() {
		return FidoPaymentPageThreadLocal.get();
	}

	public static FidoInternetDashboardPage getFidointernetdashboardpage() {
		return FidoInternetDashboardPageThreadLocal.get();
	}

	public static FidoInternetPackageChangeReviewOrderPage getFidointernetpackagechangerevieworderpage() {
		return FidoInternetPackageChangeReviewOrderPageThreadLocal.get();
	}

	public static FidoShopInternetPage getFidoshopinternetpage() {
		return FidoShopInternetPageThreadLocal.get();
	}

	public static FidoCartSummaryPage getFidocartsummarypage() {
		return FidoCartSummaryPageThreadLocal.get();
	}

	public static FidoCreateUserPage getFidocreateuserpage() {
		return FidoCreateUserPageThreadLocal.get();
	}

	public static FidoCreditCheckPage getFidocreditcheckpage() {
		return FidoCreditCheckPageThreadLocal.get();
	}

	public static FidoTechnicalInstallationPage getFidotechnicalinstallationpage() {
		return FidoTechnicalInstallationPageThreadLocal.get();
	}

	public static FidoOrderConfirmationPage getFidoorderconfirmationpage() {
		return FidoOrderConfirmationPageThreadLocal.get();
	}

	public static SSPFidoRetailerShopPage getFidoretailershoppage() {
		return FidoRetailerShopPageThreadLocal.get();
	}

	public static SSPFidoRetailerHomePage getFidoretailerhomepage() {
		return FidoRetailerHomePageThreadLocal.get();
	}

	public static SSPFidoRetailerSearchResultsPage getFidoretailersearchresultspage() {
		return FidoRetailerSearchResultsPageThreadLocal.get();
	}

	public static FidoInternetPackagePage getFidointernetpackagepage() {
		return FidoInternetPackagePageThreadLocal.get();
	}

	public static FidoChoosePhonePage getFidochoosephonepage() {
		return FidoChoosePhonePageThreadLocal.get();
	}

	public static FidoChoosePlanPage getFidochooseplanpage() {
		return FidoChoosePlanPageThreadLocal.get();
	}

	public static FidoBuildPlanPage getFidobuildplanpage() {
		return FidoBuildPlanPageThreadLocal.get();
	}

	public static FidoCheckOutPage getFidoCheckOutPage() {
		return FidoCheckOutPageThreadLocal.get();
	}

	public static FidoChooseAddonsPage getFidochooseaddonspage() {
		return FidoChooseAddonsPageThreadLocal.get();
	}

	public static FidoChooseNumberPage getFidochoosenumberpage() {
		return FidoChooseNumberPageThreadLocal.get();
	}

	public static FidoOrderReviewPage getFidoorderreviewpage() {
		return FidoOrderReviewPageThreadLocal.get();
	}

	public static FidoChooseSimPage getFidochoosesimpage() {
		return FidoChooseSimPageThreadLocal.get();
	}

	public static FidoShippingPage getFidoshippingpage() {
		return FidoShippingPageThreadLocal.get();
	}

	public static WebDriver getWebdriver() {
		return webDriverThreadLocal.get();
	}

	public static SSPFidoRetailerChampPage getFidoretailerchamppage() {
		return FidoRetailerChampPageThreadLocal.get();
	}

	public static FidoDeviceConfigPage getFidodeviceconfigpage() {
		return FidoDeviceConfigPageThreadLocal.get();
	}

	public static FidoFinanceAccessoriesPage getFidoFinanceAccessoriesPagePage() {
		return FidoFinanceAccessoriesPageThreadLocal.get();
	}

	public static EnvironmentSelectionPage getEnvironmentSelectionPage() {
		return environmentSelectionPageThreadLocal.get();
	}

	public static AccountOverViewPage getAccountOverViewPage() {
		return accountOverViewPageThreadLocal.get();
	}

	public static FidoOVChoosePhonePage getFidoOVChoosePhonePage() {
		return fidoOVChoosePhonePageThreadLocal.get();
	}

	public static FidoOVPlanConfigPage getFidoOVPlanConfigPage() {
		return fidoOVPlanConfigPageThreadLocal.get();
	}

	public static FidoOVCheckoutPage getFidoOVCheckoutPage() {
		return fidoOVCheckoutPageThreadLocal.get();
	}

	public static FidoOVReviewOrderPage getFidoOVReviewOrderPage() {
		return fidoOVReviewOrderPageThreadLocal.get();
	}

	public static FidoOVOrderConfirmationPage getFidoOVOrderConfirmationPage() {
		return fidoOVOrderConfirmationPageThreadLocal.get();
	}

	public static FidoShippingCartPage getFidoShippingCartPage() {
		return FidoShippingCartPageThreadLocal.get();
	}

	/**
	 * This method will initialize a hash map with the sauce parameters
	 * @param strBrowser string containing the browser name for sauce
	 * @param strGroupName string containing the project name which passing as build name for sauce
	 * @return hashmap with sauce capabilities
	 * @author Mirza.Kamran
	 */
	 private Map<String, String> initializeSauceParamsMap(String strBrowser,String strGroupName) {
		
		 Map<String,String> sauceOptions = new HashMap<String, String>();
		 sauceOptions.put(SauceCapabilities.seleniumVersion.toString(), TestDataHandler.sauceSettings.getSauceOptions().getSeleniumVersion());
		 sauceOptions.put(SauceCapabilities.maxDuration.toString(), TestDataHandler.sauceSettings.getSauceOptions().getMaxDuration());
		 sauceOptions.put(SauceCapabilities.commandTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getCommandTimeout());
		 sauceOptions.put(SauceCapabilities.idleTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getIdleTimeout());
		 //sauceOptions.put(SauceCapabilities.build.toString(), TestDataHandler.sauceSettings.getSauceOptions().getBuild());
		 sauceOptions.put(SauceCapabilities.build.toString(), strGroupName.toUpperCase());
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
			sauceParameters = initializeSauceParamsMap(browser,enumGroupName.toString());
		}
	    webDriverThreadLocal.set(browserdriver.driverInit(browser,sauceParameters, currentTestMethodName, enumGroupName.toString()));
		ExtentListener.setDriver(getDriver());
		System.out.println(strUrl + "----------------------------------------------------------------------------");
		captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
		switch(enumGroupName.toString().toLowerCase().trim()) {
			case "connectedhome_anonymous":
				getDriver().get(strUrl+"/pages/api/selfserve/bypassrecaptcha");
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
				getDriver().get(strUrl+"/internet/packages");
				break;

			case "connectedhome_login":
				/*getDriver().get(strUrl+"/pages/api/selfserve/bypassrecaptcha");
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);*/
				getDriver().get(strUrl+"/profile/signin"+"?setLanguage="+ language);
				break;

			case "selfserve":
			case "selfserve_login":
				getDriver().get(strUrl);
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
				getDriver().get(strUrl+"/profile/signin/"+ language );
				break;

			case "connectedhome_ssp":
				getDriver().get(strUrl);
				break;

			case "buyflows":
				getDriver().get(strUrl+"/phones");
				setCookie(strUrl);
				if(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("NAC_BYOD")) {
					getDriver().get(strUrl + "/phones/bring-your-own-device?flowType=byod" + "?setLanguage=" + language + "&?province=" + "ON");
					//captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
				} else if(currentTestMethodName.getName().contains("NAC")) { //HUP
					//getDriver().get(strUrl);
					getDriver().get(strUrl + "/phones" + "?setLanguage=" + language + "&province=" + "ON");
					//captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
					//getDriver().get(strUrl + "/phones"+ "?flowType=hup" + "&?setLanguage=" + language + "&?province=" + "ON");
				}else if(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("BFA_PROD")) {
					getDriver().get(strUrl);
					//captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
					getDriver().get(strUrl+"/profile/signin");
				} else{
					getDriver().get(strUrl);
					//captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
					getDriver().get(strUrl+"/profile/signin");
					//getDriver().get(strUrl + "/consumer/easyloginriverpage" + "?setLanguage=" + language + "&?province=" + "ON");
				}
				break;

			default :
				captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, language);
		}
		setImplicitWait(getDriver(), 10);
		getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		init(enumGroupName.toString().toLowerCase().trim());
	}

	/**
	 * To start a session using given url, browser, language and test case group name.
	 *
	 * @param strUrl                string of test url
	 * @param strBrowser            string of browser name
	 * @param strLanguage           string of language to use
	 * @param strGroupName          string of group name of the test case
	 * @param strContactID          string of contact id
	 * @param strAccNo              string of account number
	 * @param strLoginID            string of login id
	 * @param strLanID              string of lan id
	 * @param currentTestMethodName string of test method name
	 * @throws ClientProtocolException org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException             java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	public void startOVSession(String strUrl, String strBrowser, String strLanguage, String strGroupName, String strContactID, String strAccNo, String strLoginID, String strLanID, Method currentTestMethodName) throws ClientProtocolException, IOException {
		RunParameters = getExecutionParameters(strBrowser, strLanguage);
		String browser = RunParameters.get("Browser").toLowerCase();
		String language = RunParameters.get("Language").toLowerCase();
		if (browser.contains("sauce")) {
			sauceParameters = initializeSauceParamsMap(browser,strGroupName);
		}
		webDriverThreadLocal.set(browserdriver.driverInit(browser, sauceParameters, currentTestMethodName, strGroupName));
		System.out.println(strUrl + "----------------------------------------------------------------------------");
		captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
		captcha_bypass_handlers.chOneViewFlow(strUrl, strAccNo, strLoginID, strLanID, language, strContactID);
		setImplicitWait(getDriver(), 10);
		init(strGroupName);
	}

	/**
	 * To initiate the page objects based on test case group, will read group name from xml file.
	 * @param strGroupName string of group name.
	 */
	private void init(String strGroupName) {
		setReporter(new ExtentTestManager(getDriver()));
		CommonBusinessFlowsThreadLocal.set(new CommonBusinessFlows(this));
		switch(strGroupName) {
            case "selfserve":
            case "selfserve_login":
                FidoHomePageThreadLocal.set(new FidoHomePage(getDriver()));
                FidoLoginPageThreadLocal.set(new FidoLoginPage(getDriver()));
                FidoAccountOverviewPageThreadLocal.set(new FidoAccountOverviewPage(getDriver()));
                FidoLogintoFacebookPageThreadLocal.set(new FidoLogintoFacebookPage(getDriver()));
                FidoAccountRegistrationPageThreadLocal.set(new FidoAccountRegistrationPage(getDriver()));
                FidoProfileAndSettingPageThreadLocal.set(new FidoProfileAndSettingPage(getDriver()));
                FidoPaymentOptionsPageThreadLocal.set(new FidoPaymentOptionsPage(getDriver()));
                FidoMakePaymentPageThreadLocal.set(new FidoMakePaymentPage(getDriver()));
                FidoRecoverPassOrNamePageThreadLocal.set(new FidoRecoverPassOrNamePage(getDriver()));
                FidoPaymentHistoryPageThreadLocal.set(new FidoPaymentHistoryPage(getDriver()));
                FidoPrepaidLinkAccountPageThreadLocal.set(new FidoPrepaidLinkAccountPage(getDriver()));
                FidoInteracOnlinePageThreadLocal.set(new FidoInteracOnlinePage(getDriver()));
                FidoInternetDashboardPageThreadLocal.set(new FidoInternetDashboardPage(getDriver()));
                FidoCommunityPageThreadLocal.set(new FidoCommunityPage(getDriver()));
                FidoRefillPageThreadLocal.set(new FidoRefillPage(getDriver()));
                FidoWirelessDashboardPostpaidPageThreadLocal.set(new FidoWirelessDashboardPostpaidPage(getDriver()));
                FidoWirelessDashboardPrepaidPageThreadLocal.set(new FidoWirelessDashboardPrepaidPage(getDriver()));
                FidoAddDataPageThreadLocal.set(new FidoAddDataPage(getDriver()));
                FidoReportLostOrStolenPageThreadLocal.set(new FidoReportLostOrStolenPage(getDriver()));
                FidoChangeCTNPageThreadLocal.set(new FidoChangeCTNPage(getDriver()));
                FidoBillDetailsPageThreadLocal.set(new FidoBillDetailsPage(getDriver()));
                FidoResetVoiceMailPasswordPageThreadLocal.set(new FidoResetVoiceMailPasswordPage(getDriver()));
                FidoDeviceReservationSystemPageThreadLocal.set(new FidoDeviceReservationSystemPage(getDriver()));
                FidoDataManagementPageThreadLocal.set(new FidoDataManagementPage(getDriver()));
                FidoSetPasswordPageThreadLocal.set(new FidoSetPasswordPage(getDriver()));
                ensHomePageThreadLocal.set(new EnsHomePage(getDriver()));
                ensNoteViewPageThreadLocal.set(new EnsNotificationViewPage(getDriver()));
                ensVerificationsThreadLocal.set(new VerifyInEns(this));
                FidoFinanceAccessoriesPageThreadLocal.set(new FidoFinanceAccessoriesPage(getDriver()));
                break;
            case "connectedhome_login":
                FidoHomePageThreadLocal.set(new FidoHomePage(getDriver()));
                FidoLoginPageThreadLocal.set(new FidoLoginPage(getDriver()));
                FidoAccountOverviewPageThreadLocal.set(new FidoAccountOverviewPage(getDriver()));
				FidoBillDetailsPageThreadLocal.set(new FidoBillDetailsPage(getDriver()));
                FidoPaymentPageThreadLocal.set(new FidoPaymentPage(getDriver()));
                FidoInternetDashboardPageThreadLocal.set(new FidoInternetDashboardPage(getDriver()));
                FidoAccountRegistrationPageThreadLocal.set(new FidoAccountRegistrationPage(getDriver()));
                FidoInternetPackageChangeReviewOrderPageThreadLocal.set(new FidoInternetPackageChangeReviewOrderPage(getDriver()));
                FidoShopInternetPageThreadLocal.set(new FidoShopInternetPage(getDriver()));
                FidoCartSummaryPageThreadLocal.set(new FidoCartSummaryPage(getDriver()));
                FidoCreateUserPageThreadLocal.set(new FidoCreateUserPage(getDriver()));
                FidoCreditCheckPageThreadLocal.set(new FidoCreditCheckPage(getDriver()));
                FidoTechnicalInstallationPageThreadLocal.set(new FidoTechnicalInstallationPage(getDriver()));
                FidoPaymentOptionsPageThreadLocal.set(new FidoPaymentOptionsPage(getDriver()));
                FidoOrderConfirmationPageThreadLocal.set(new FidoOrderConfirmationPage(getDriver()));
                FidoInternetPackagePageThreadLocal.set(new FidoInternetPackagePage(getDriver()));
                FidoSetPasswordPageThreadLocal.set(new FidoSetPasswordPage(getDriver()));
                FidoInternetUsagePageThreadLocal.set(new FidoInternetUsagePage(getDriver()));
				FidoProfileAndSettingPageThreadLocal.set(new FidoProfileAndSettingPage(getDriver()));
				ensHomePageThreadLocal.set(new EnsHomePage(getDriver()));
                ensNoteViewPageThreadLocal.set(new EnsNotificationViewPage(getDriver()));
                ensVerificationsThreadLocal.set(new VerifyInEns(this));
                break;
            case "connectedhome_anonymous":
            case "connectedhome_ssp":
                FidoLoginPageThreadLocal.set(new FidoLoginPage(getDriver()));
                FidoHomePageThreadLocal.set(new FidoHomePage(getDriver()));
                FidoPaymentPageThreadLocal.set(new FidoPaymentPage(getDriver()));
                FidoInternetDashboardPageThreadLocal.set(new FidoInternetDashboardPage(getDriver()));
                FidoAccountRegistrationPageThreadLocal.set(new FidoAccountRegistrationPage(getDriver()));
                FidoInternetPackageChangeReviewOrderPageThreadLocal.set(new FidoInternetPackageChangeReviewOrderPage(getDriver()));
                FidoShopInternetPageThreadLocal.set(new FidoShopInternetPage(getDriver()));
                FidoCartSummaryPageThreadLocal.set(new FidoCartSummaryPage(getDriver()));
                FidoCreateUserPageThreadLocal.set(new FidoCreateUserPage(getDriver()));
                FidoCreditCheckPageThreadLocal.set(new FidoCreditCheckPage(getDriver()));
                FidoPaymentPageThreadLocal.set(new FidoPaymentPage(getDriver()));
                FidoTechnicalInstallationPageThreadLocal.set(new FidoTechnicalInstallationPage(getDriver()));
                FidoPaymentOptionsPageThreadLocal.set(new FidoPaymentOptionsPage(getDriver()));
                FidoOrderConfirmationPageThreadLocal.set(new FidoOrderConfirmationPage(getDriver()));
                FidoRetailerShopPageThreadLocal.set(new SSPFidoRetailerShopPage(getDriver()));
                FidoRetailerHomePageThreadLocal.set(new SSPFidoRetailerHomePage(getDriver()));
                FidoRetailerSearchResultsPageThreadLocal.set(new SSPFidoRetailerSearchResultsPage(getDriver()));
                FidoInternetPackagePageThreadLocal.set(new FidoInternetPackagePage(getDriver()));
                FidoRetailerChampPageThreadLocal.set(new SSPFidoRetailerChampPage(getDriver()));
                break;
            case "buyflows":
                FidoHomePageThreadLocal.set(new FidoHomePage(getDriver()));
                FidoLoginPageThreadLocal.set(new FidoLoginPage(getDriver()));
                FidoAccountOverviewPageThreadLocal.set(new FidoAccountOverviewPage(getDriver()));
                FidoWirelessDashboardPostpaidPageThreadLocal.set(new FidoWirelessDashboardPostpaidPage(getDriver()));
                FidoChoosePhonePageThreadLocal.set(new FidoChoosePhonePage(getDriver()));
                FidoChoosePlanPageThreadLocal.set(new FidoChoosePlanPage(getDriver()));
                FidoBuildPlanPageThreadLocal.set(new FidoBuildPlanPage(getDriver()));
                FidoChooseAddonsPageThreadLocal.set(new FidoChooseAddonsPage(getDriver()));
                FidoCartSummaryPageThreadLocal.set(new FidoCartSummaryPage(getDriver()));
                FidoCreateUserPageThreadLocal.set(new FidoCreateUserPage(getDriver()));
                FidoCreditCheckPageThreadLocal.set(new FidoCreditCheckPage(getDriver()));
                FidoChooseNumberPageThreadLocal.set(new FidoChooseNumberPage(getDriver()));
                FidoPaymentOptionsPageThreadLocal.set(new FidoPaymentOptionsPage(getDriver()));
                FidoOrderReviewPageThreadLocal.set(new FidoOrderReviewPage(getDriver()));
                FidoOrderConfirmationPageThreadLocal.set(new FidoOrderConfirmationPage(getDriver()));
                FidoChooseSimPageThreadLocal.set(new FidoChooseSimPage(getDriver()));
                FidoShippingPageThreadLocal.set(new FidoShippingPage(getDriver()));
                FidoPaymentPageThreadLocal.set(new FidoPaymentPage(getDriver()));
                FidoDeviceConfigPageThreadLocal.set(new FidoDeviceConfigPage(getDriver()));
                FidoCheckOutPageThreadLocal.set(new FidoCheckOutPage(getDriver()));
				FidoShippingCartPageThreadLocal.set(new FidoShippingCartPage(getDriver()));
				break;
            case "buyflowsoneview":
				environmentSelectionPageThreadLocal.set(new EnvironmentSelectionPage(getDriver()));
				accountOverViewPageThreadLocal.set(new AccountOverViewPage(getDriver()));
				fidoOVChoosePhonePageThreadLocal.set(new FidoOVChoosePhonePage(getDriver()));
				fidoOVPlanConfigPageThreadLocal.set(new FidoOVPlanConfigPage(getDriver()));
				fidoOVReviewOrderPageThreadLocal.set(new FidoOVReviewOrderPage(getDriver()));
				fidoOVOrderConfirmationPageThreadLocal.set(new FidoOVOrderConfirmationPage(getDriver()));
                fidoOVCheckoutPageThreadLocal.set(new FidoOVCheckoutPage(getDriver()));
                break;
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
		return webDriverThreadLocal.get();
	}
	
	
	/**
	 * To get parameters from XML file, it is called in TestListener.
	 * @return HashMap of test parameters
	 */
	public HashMap<String, String> getXMLParameters() {
		return xmlTestParameters;
	}

	public void initiateEyes() {
		// Initialize the Runner for your test.
		runner = new ClassicRunner();

		// Initialize the eyes SDK
		eyes = new Eyes(runner);

		// Raise an error if no API Key has been found.
		if ((System.getenv("APPLITOOLS_API_KEY")).isEmpty() || (System.getenv("APPLITOOLS_API_KEY")) == null) {
			throw new RuntimeException("No API Key found; Please set environment variable 'APPLITOOLS_API_KEY'.");
		}
	}

	public void reportVisualResult(TestResults result, RectangleSize viewportSize) {
		String resultStr;
		String url;
		String viewport;
		if (result == null) {
			resultStr = "Test aborted";
			url = "undefined";
		} else {
			url = result.getUrl();
			int totalSteps = result.getSteps();
			if (result.isNew()) {
				resultStr = "New Baseline Created: " + totalSteps + " steps";
			} else if (result.isPassed()) {
				resultStr = "All steps passed:     " + totalSteps + " steps";
			} else {
				resultStr = "Test Failed     :     " + totalSteps + " steps";
				resultStr += " matches=" +  result.getMatches();      /*  matched the baseline */
				resultStr += " missing=" + result.getMissing();       /* missing in the test*/
				resultStr += " mismatches=" + result.getMismatches(); /* did not match the baseline */
			}
		}
		if (viewportSize==null) {
			viewport = "default";
		} else {
			viewport = viewportSize.toString();
		}
		resultStr += "\n" + "for viewport: " + viewport + " results at " + "<a href=" + url + ">" + url + "/a>";
		reporter.reportLog(resultStr);
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

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext iTestContext) throws FileNotFoundException {
		TestDataHandler.dataInit(iTestContext.getSuite().getAllMethods());
	}

	public void setCookie(String strUrl) {
		Cookie cookie = new Cookie("QSI_SI_1Ycr2XA3syHKzWe_intercept", "true", ".fido.ca", "/phones", null);
		getDriver().manage().addCookie(cookie);
	}

}
