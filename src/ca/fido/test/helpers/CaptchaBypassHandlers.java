package ca.fido.test.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieFetcher;

import java.io.IOException;
import java.util.Date;

public class CaptchaBypassHandlers {

	private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	AppiumDriver<MobileElement> adriver;

	public CaptchaBypassHandlers(WebDriver driver) {
		webDriverThreadLocal.set(driver);
	}

	public CaptchaBypassHandlers(AppiumDriver<MobileElement> adriver) {
		this.adriver = adriver;
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 * @throws IOException               throws IO Exceptions
	 */
	public void captchaBypassURLLoginFlows(String strUrl, String strLanguage) throws IOException {						
		@SuppressWarnings("deprecation")	
		 int strMin = new Date().getMinutes();
		strMin = strMin/15;
		int intRandom=0;
		if(strMin>=0 && strMin <1)
		{
			intRandom = 1;
		}else if(strMin>=1 && strMin <2)
		{
			intRandom = 2;	
		}else if(strMin>=2 && strMin < 3)
		{
			intRandom = 3;
		}else if(strMin>=3 && strMin <4)
		{
			intRandom = 4;
		}
		@SuppressWarnings("deprecation")
		String strCookieUserName= "rogers"+ new Date().getDay()+new Date().getHours()+intRandom+"@hmail.com";//TestDataHandler.fidoConfig.getCookieUserName();
		String strCookieUserPassword= strCookieUserName;//Not a sensitive information  //TestDataHandler.fidoConfig.getCookieUserPassword();
		String strCookieFetchURL = generateCookieFetchURL(strUrl);
		String strCookieRegistrationURL = generateCookieRegistrationURL(strUrl);
		String strCookieFileType = "fido";
		String strCookieName = "temp_token_f";
		Cookie captchBypass = new Cookie (strCookieName ,CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl, strCookieFetchURL, strCookieRegistrationURL , strCookieFileType , strCookieName));
		System.out.print(getDriver().getCurrentUrl());
		getDriver().manage().addCookie(captchBypass);
  }

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 */
	public String generateCookieFetchURL(String strUrl) {
		String strCookieFetchURL=null;
		String cookieEnv = envMapping(strUrl);
		strCookieFetchURL = cookieEnv + ".qa01.eks.rogers.com/api/recaptcha/v1/user/recaptchaBypass/login";
		return strCookieFetchURL;
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 */
	public String generateCookieRegistrationURL(String strUrl) {
		String strCookieRegistrationURL=null;
		String cookieEnv = envMapping(strUrl);
		strCookieRegistrationURL = cookieEnv + ".qa01.eks.rogers.com/api/recaptcha/v1/user/recaptchaBypass/register";
		return strCookieRegistrationURL;
	}

	/**
	 * To give the QA env mapping
	 * @param strUrl String of test url
	 * @return String of url starter after mapping
	 */
	public String envMapping(String strUrl) {
		String cookieEnv=null;
		if (strUrl.contains("qa1.") || strUrl.contains("qa5.") || strUrl.contains("qa6.") || strUrl.contains("qa7.")) {
			cookieEnv = "https://ute" + strUrl.split("qa")[1].charAt(0);
		} else if (strUrl.contains("qa2.")) {
			cookieEnv = "https://ute3";
		} else if (strUrl.contains("qa3.")) {
			cookieEnv = "https://ute4";
		} else if (strUrl.contains("qa4.")) {
			cookieEnv = "https://ute2";
		} else {
			cookieEnv = System.getProperty("CookieFetcherMapping");
		}
		return cookieEnv;
	}

	/**
	 * To Bypass Captcha for login Flows
	 *
	 * @param strUrl           string of test url
	 * @param strAccNo         string of account number
	 * @param strLoginID       string of login id
	 * @param strLanID         string of lan id
	 * @param strLanguage      string of language to use
	 * @param strContactID     string of contact id
	 */
	public void chOneViewFlow(String strUrl, String strAccNo, String strLoginID, String strLanID, String strLanguage, String strContactID) {
		String oneViewUrl = "";
		if (strLoginID.isEmpty())
			oneViewUrl = strUrl;
		else if (strContactID.equals(""))
			oneViewUrl = CaptchaBypassHandlers.urlOneViewExistingCustomer(strUrl, strLoginID, strLanID, strAccNo, strLanguage);
		else
			oneViewUrl = CaptchaBypassHandlers.chOneViewNacUrl(strUrl, strLoginID, strLanID, strLanguage, strContactID);
		System.out.println(oneViewUrl + "----------------------------------------------------------------------------");
		getDriver().get(oneViewUrl);
	}

	/**
	 * Get url for one view flow
	 *
	 * @param strUrl           string of test url
	 * @param strLoginID       string of login id
	 * @param strLanID         string of lan id
	 * @param strAccNo         string of account number
	 * @param strLanguage      string of language to use
	 */
	public static String urlOneViewExistingCustomer(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage) {
		String queryParam = "LoginId=" + strLoginID + "&UserRole=CSR,BRT%20Authorized%20CSR-3,Oneview Pilot-1,Oneview Pilot-2,Oneview Pilot-4,Oneview BRT-1,Oneview BRT-2,Oneview BRT-3,Oneview BRT-4,R76,BT User,R21,R39,R60,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310,BRT Authorized CSR-1,BRT Authorized CSR-3,BRT Authorized CSR-4&AccNo=" + strAccNo + "&Target=UTE&TimeStamp=2021-07-25T11:29:45.442-04:00&Lang=" + strLanguage + "&AppId=CRM&li=" + strLanID;

		return strUrl + queryParam;
	}

	/**
	 * Get url for NAC one view flow
	 *
	 * @param strUrl           string of test url
	 * @param strLoginID       string of login id
	 * @param strLanID         string of lan id
	 * @param strLanguage      string of language to use
	 * @param strContactID     string of contact id
	 */
	public static String chOneViewNacUrl(String strUrl, String strLoginID, String strLanID, String strLanguage, String strContactID) {
		String queryParam = "LoginId=" + strLoginID + "64&UserRole=CSR,Oneview Pilot-1,Oneview BRT-1,R76,BT User,R33,R45,R21,R75,R77,R180,R182,R252,R47,R52,R54,R55,R65,R68,R75,R77,R246,Telesales,R188,R252,R261,R167,R306,R307,R304,R311,BRT Authorized CSR-3,BRT Authorized CSR-4,Ignite Learning Lab Additive Role&IntID=&Target=UTE&TimeStamp=2021-05-16T11:29:45.4412-04:00&Lang=" + strLanguage + "&AppId=CRM&li=" + strLanID + "&AccNo=&ContactID=" + strContactID + "&targetURL=IgniteNAC";

		return strUrl + queryParam;
	}

	private WebDriver getDriver(){
		return webDriverThreadLocal.get();
	}
}
