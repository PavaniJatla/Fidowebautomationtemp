package com.rogers.test.helpers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import utils.CookieFetcher;

public class CaptchaBypassHandlers {
	
	private WebDriver driver;
	public CaptchaBypassHandlers(WebDriver driver) {
		this.driver = driver;
	}
		
	/**
	 * To Bypass Captcha for Legacy Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLLegacyAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.get(strUrl+"?setLanguage="+ strLanguage );
        }
	
	/**
	 * To Bypass Captcha for Legacy login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassUrlLoginFlows(String strUrl, String strLanguage) throws IOException {		
		
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
		
		
		Cookie captchBypass = new Cookie ("temp_token_r",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl));
		driver.manage().addCookie(captchBypass);
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void chOnewviewFlows(String strUrl, String strAccNo,  String strLoginID, String strLanID, String strLanguage,String strBrowser,  Method currentTestMethodName ,String strContactID) throws IOException {
		String oneViewUrl="";
		if(strContactID.equals(""))
		oneViewUrl= CaptchaBypassHandlers.urlOneViewExistingCustomer(strUrl, strLoginID, strLanID, strAccNo, strLanguage);	
		else
			oneViewUrl=CaptchaBypassHandlers.urlOneViewMigration(strUrl, strLoginID, strLanID, strAccNo, strLanguage, strContactID);	
		System.out.println(oneViewUrl + "----------------------------------------------------------------------------");	
		driver.get(oneViewUrl);
  }
	
	public static String  urlOneViewExistingCustomer(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage) {
		String queryParam="";
		if(!strAccNo.startsWith("C"))
		    queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,R76,BTUser,R33,R45,R47,R52,R54,R55,R65,R68,R75,R77,R246,R252,R261,R167,R306,R307,R304,R311,BRT Authorized CSR-3,BRT Authorized CSR-4&AccNo="+strAccNo+"&Target=UTE&TimeStamp=2020-10-03T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID;
		else
			queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Ignite Learning Lab Additive Role,R252&IntID=&AccNo=&Target=UTE&TimeStamp=2020-01-20T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID+"&ContactID="+strAccNo+"&targetURL=IgniteNAC&connid=";
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}

	public static String urlOneViewAnonymous(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage) {
		String queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Ignite Learning Lab Additive Role,R252&IntID=&AccNo=&Target=UTE&TimeStamp=2020-01-20T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID+"&ContactID="+strAccNo+"&targetURL=IgniteNAC&connid=";
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}
	public static String urlOneViewMigration(String strUrl, String strLoginID, String strLanID, String strAccNo,String strLanguage,String strContactID) {
		String queryParam="LoginId="+ strLanID+"&UserRole=CSR,OneviewBRT-1,R76,BT User,R33,R45,R47,R52,R54,R55,R65,R68,R75,R77,R246,R252,R261,R167,R306,R307,R304,R311,BRT Authorized CSR-3,BRT Authorized CSR-4,Ignite Learning Lab Additive Role&AccNo="+strAccNo+"&Target=UTE&TimeStamp=2020-02-18T11:29:45.442-04:00&ContactID="+strContactID+"&Lang="+strLanguage+"&AppId=CRM&li="+strLoginID;
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}
	
}