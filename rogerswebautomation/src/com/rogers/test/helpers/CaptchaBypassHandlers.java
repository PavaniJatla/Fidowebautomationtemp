package com.rogers.test.helpers;

import java.io.IOException;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.rogers.testdatamanagement.TestDataHandler;

import utils.CookieFetcher;

public class CaptchaBypassHandlers {
	
	private WebDriver driver;
	public CaptchaBypassHandlers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * To Bypass Captcha for Self serve Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
		public void captchaBypassURLSelfserveFlows(String strUrl, String strLanguage) throws IOException {
			driver.get(strUrl+"?setLanguage="+ strLanguage );
		
		String strCookieUserName= TestDataHandler.config.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.config.getCookieUserPassword();
		
		String strBaseUrl = "";
		if(strUrl.substring(strUrl.length()-3).equalsIgnoreCase("com")) {
			strBaseUrl = strUrl;
		} else {
			strBaseUrl = strUrl.substring(0, strUrl.lastIndexOf("com")+3);
		}
		//Use https url in config.yml, replace https with http here will by pass the certificate issue	
		Cookie captchBypass = new Cookie ("temp_token_r",
		CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strBaseUrl));			
		driver.manage().addCookie(captchBypass);
    }
	
	/**
	 * To Bypass Captcha for Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
				driver.get(strUrl+"/pages/api/selfserve/bypassrecaptcha");
				driver.get(strUrl+"?setLanguage="+ strLanguage );
        }

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLLoginFlows(String strUrl, String strLanguage) throws IOException {
		driver.get(strUrl+"/pages/api/selfserve/bypassrecaptcha");		
		driver.get(strUrl+"?setLanguage="+ strLanguage );
		String strCookieUserName= TestDataHandler.config.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.config.getCookieUserPassword();			
		Cookie captchBypass = new Cookie ("temp_token_r",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl));
		driver.manage().addCookie(captchBypass);
  }
	
}
