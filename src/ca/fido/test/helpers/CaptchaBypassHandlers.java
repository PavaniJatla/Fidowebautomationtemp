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
	 * @param strGroupName 				 string Group Name 	
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
		String strCookieUserName= "rogers"+ new Date().getDay()+new Date().getHours()+intRandom+"@hmail.com";//TestDataHandler.fidoConfig.getCookieUserName();
		String strCookieUserPassword= strCookieUserName;//Not a sensitive information  //TestDataHandler.fidoConfig.getCookieUserPassword();			
		Cookie captchBypass = new Cookie ("temp_token_f",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl));//.replace("https", "http")));
		System.out.print(driver.getCurrentUrl());
		driver.manage().addCookie(captchBypass);
  }
	
}
