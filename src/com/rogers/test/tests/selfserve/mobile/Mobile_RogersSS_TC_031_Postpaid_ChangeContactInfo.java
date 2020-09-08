package com.rogers.test.tests.selfserve.mobile;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;      
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import utils.FormFiller;


public class Mobile_RogersSS_TC_031_Postpaid_ChangeContactInfo extends BaseTestClass {

	private String strAltEmail;

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validateUserChangeContactInformation() {		
		rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc013132.getUsername();
    	String strPassword = TestDataHandler.tc013132.getPassword();
    	String strBan = TestDataHandler.tc013132.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc013132.getAccountDetails().getContactemail();
    	strAltEmail = FormFiller.generateEmail();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(strUsername);
		rogers_login_page.setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select BAN.");
            rogers_account_overview_page.selectAccount(strBan);
        }
		reporter.reportLogWithScreenshot("Account overveiew page");    	
		rogers_account_overview_page.clkLnkProfileNSettingsMobile();
		reporter.reportLogWithScreenshot("Profile & Settings page");
		common_business_flows.scrollToMiddleOfWebPage();
		rogers_profile_and_settings_page.clkCloseFeedbackIfAvailableMobile();
    	rogers_profile_and_settings_page.clkBtnContactInfomation();
    	
    	//Add Contact email, can't be the same as user name!!!
		rogers_profile_and_settings_page.clkBtnChangeEmailMobile();
		//rogers_profile_and_settings_page.clkBtnAddEmailMobile();
    	String strNewEmail="";
    	if(rogers_profile_and_settings_page.getContactEmailMobile().toLowerCase().contains(strEmail.toLowerCase()))
    	{
        	rogers_profile_and_settings_page.setContactEmailMobile(strAltEmail);
        	strNewEmail=strAltEmail;
     
    	}else
    	{
        	rogers_profile_and_settings_page.setContactEmailMobile(strEmail);
        	strNewEmail=strEmail;
    	}
    	reporter.reportLogWithScreenshot("Contact email information is entered.");
    	rogers_profile_and_settings_page.clkBtnAddContactEmailContinue();
    	rogers_profile_and_settings_page.clkBtnAddContactEmailSubmit();    
		reporter.reportLogWithScreenshot("Contact email information submitted.");
	    reporter.softAssert((rogers_profile_and_settings_page.clkBtnAddContactEmailFinish()
	    		&& rogers_profile_and_settings_page.verifyContactEmailSuccessfullySet(strNewEmail)),
				"Contact email was successfully add", 
				"Add contact email failed");	    
    	    	    
    	//Update home number, can't be the same as what it already has!!!
    	rogers_profile_and_settings_page.clkLnkUpdateHomeNumberMobile();
    	String strHomePhoneNumer = FormFiller.generateRandomNumber(10);
    	rogers_profile_and_settings_page.setHomePhoneMobile(strHomePhoneNumer);
    	reporter.reportLogWithScreenshot("Home phone number is entered.");
    	rogers_profile_and_settings_page.clkBtnUpdateHomeNumberContinue();
    	rogers_profile_and_settings_page.clkBtnUpdateHomeNumberSubmit();
		reporter.reportLogWithScreenshot("Home phone number inflormation submitted.");
    	reporter.softAssert((rogers_profile_and_settings_page.clkBtnUpdateHomeNumberFinish()
    			&& rogers_profile_and_settings_page.verifyHomeNumber(strHomePhoneNumer.substring(strHomePhoneNumer.length()-4))),
    			"Home phone number was successfully updated",
    			"Update home phone number failed");    	
    	
    	//Add business number, can't be the same as what it already has!!!
    	rogers_profile_and_settings_page.clkLnkAddBusinessNumberMobile();
    	String strBusinessNumer = FormFiller.generateRandomNumber(10);
    	rogers_profile_and_settings_page.setBusinessPhoneMobile(strBusinessNumer);
    	reporter.reportLogWithScreenshot("Business number is entered.");
    	rogers_profile_and_settings_page.clkBtnAddBusinessNumberContinue();
    	rogers_profile_and_settings_page.clkBtnAddBusinessNumberSubmit();  
		reporter.reportLogWithScreenshot("Business phone number inflormation submitted.");
    	reporter.softAssert((rogers_profile_and_settings_page.clkBtnAddBusinessNumberDone()
    			&& rogers_profile_and_settings_page.verifyBusinessNumber(strBusinessNumer.substring(strBusinessNumer.length()-4))),
				"Business phone number was successfully Added", 
				"Add business phone number failed");
    	
    	//Change contact language, have to change language!!!
    	String newLanguage="";
    	String existingLanguage = rogers_profile_and_settings_page.getExistingLanguageMobile();
    	if(existingLanguage.contains("English")
    	||existingLanguage.contains("Anglais"))
    	{
    		newLanguage = existingLanguage.contains("English") ? "French": "Français";
    		
    		rogers_profile_and_settings_page.clkLnkChangeContactLanguageMobile();
    		rogers_profile_and_settings_page.clkLanguage(newLanguage);
    	}else
    	{
    		newLanguage = existingLanguage.contains("French") ? "English": "Anglais";
    		rogers_profile_and_settings_page.clkLnkChangeContactLanguageMobile();
    		rogers_profile_and_settings_page.clkLanguage(newLanguage);
    	}    	    	
    	rogers_profile_and_settings_page.clkBtnChangelanguageSubmit();    	
		reporter.reportLogWithScreenshot("Change contact language inflormation submitted.");
    	reporter.softAssert((rogers_profile_and_settings_page.clkBtnChangeLanguageDone()
    			&& rogers_profile_and_settings_page.verifyLanguageSetSuccessfully(newLanguage)),
				"Change language was done successfully", 
				"Change language did not happen successfully");
    	
	}

}
