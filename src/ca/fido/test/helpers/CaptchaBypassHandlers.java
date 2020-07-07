package ca.fido.test.helpers;

import java.io.IOException;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import ca.fido.testdatamanagement.TestDataHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.CookieFetcher;

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
	 * To Bypass Captcha for Self serve Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 * @throws IOException                throws IO Exceptions
	 */
		public void captchaBypassURLSelfserveFlows(String strUrl, String strLanguage) throws IOException {
			driver.get(strUrl+"?setLanguage="+ strLanguage );
		
		String strCookieUserName= TestDataHandler.config.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.config.getCookieUserPassword();
		
		String strBaseUrl = "";
		if(strUrl.substring(strUrl.length()-3).equalsIgnoreCase("ca")) {
			strBaseUrl = strUrl;
		} else {
			strBaseUrl = strUrl.substring(0, strUrl.lastIndexOf("ca")+2);
		}
		//Use https url in config.yml, replace https with http here will by pass the certificate issue
		//.replace("https", "http")
		Cookie captchBypass = new Cookie ("temp_token_f",
		CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strBaseUrl));			
		driver.manage().addCookie(captchBypass);
    }
	
	/**
	 * To Bypass Captcha for Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 * @throws IOException                throws IO Exceptions
	 */
	public void captchaBypassURLAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
				driver.get(strUrl+"/pages/api/selfserve/bypassrecaptcha");
				driver.get(strUrl+"?setLanguage="+ strLanguage);
        }
	
	public void captchaBypassURLAnonymousBuyFlowsa(String strUrl, String strLanguage) throws IOException {
      }

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 * @throws IOException                throws IO Exceptions
	 */
	public void captchaBypassURLLoginFlows(String strUrl, String strLanguage) throws IOException {
		driver.get(strUrl+"/pages/api/selfserve/bypassrecaptcha");		
		driver.get(strUrl+"?setLanguage="+ strLanguage );
		String strCookieUserName= TestDataHandler.fidoConfig.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.fidoConfig.getCookieUserPassword();			
		Cookie captchBypass = new Cookie ("temp_token_f",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl.replace("https", "http")));
		driver.manage().addCookie(captchBypass);
  }
	
}
