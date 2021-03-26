package ca.fido.test.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieFetcher;

import java.io.IOException;
import java.util.Date;

public class CaptchaBypassHandlers {
	
	private WebDriver driver;
	AppiumDriver<MobileElement> adriver;
	public CaptchaBypassHandlers(WebDriver driver) {
		this.driver = driver;
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
		System.out.print(driver.getCurrentUrl());
		driver.manage().addCookie(captchBypass);
  }

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 */
	public String generateCookieFetchURL(String strUrl) {
		String strCookieFetchURL=null;
		String cookieEnv=null;
		if (strUrl.contains("qa1.") || strUrl.contains("qa5.") || strUrl.contains("qa6.") || strUrl.contains("qa7.")) {
			cookieEnv = "https://qa0" + strUrl.split("qa")[1].charAt(0);
		} else if (strUrl.contains("qa2.")) {
			cookieEnv = "https://qa03";
		} else if (strUrl.contains("qa3.")) {
			cookieEnv = "https://qa04";
		} else if (strUrl.contains("qa4.")) {
			cookieEnv = "https://qa02";
		} else {
			cookieEnv = System.getProperty("CookieFetcherMapping");
		}
		strCookieFetchURL = cookieEnv + "-mservices.fido.ca/v1/user/recaptchaBypass/login";
		return strCookieFetchURL;
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 */
	public String generateCookieRegistrationURL(String strUrl) {
		String strCookieRegistrationURL=null;
		String cookieEnv=null;
		if (strUrl.contains("qa1.") || strUrl.contains("qa5.") || strUrl.contains("qa6.") || strUrl.contains("qa7.")) {
			cookieEnv = "https://qa0" + strUrl.split("qa")[1].charAt(0);
		} else if (strUrl.contains("qa2.")) {
			cookieEnv = "https://qa03";
		} else if (strUrl.contains("qa3.")) {
			cookieEnv = "https://qa04";
		} else if (strUrl.contains("qa4.")) {
			cookieEnv = "https://qa02";
		} else {
			cookieEnv = System.getProperty("CookieFetcherMapping");
		}

		strCookieRegistrationURL = cookieEnv + "-mservices.fido.ca/v1/user/recaptchaBypass/register";
		return strCookieRegistrationURL;
	}
}
