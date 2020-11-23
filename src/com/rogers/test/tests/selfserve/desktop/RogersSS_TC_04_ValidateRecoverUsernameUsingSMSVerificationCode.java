package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This test case has a precondition which is the recovery number for the profile have to be set before this TC execute. 
 * Which means TC04 and TC009 should share the same data and for the first execution, we have to run TC009 before running TC04.
 * @author mirza.kamran
 *
 */
public class RogersSS_TC_04_ValidateRecoverUsernameUsingSMSVerificationCode extends BaseTestClass {
	

	private String strRecoveredUserName;
	private String strPassword;

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"TC04"})
	public void validateRecoverUsernameUsingSMSVerificationCode() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clkForgotUsernameIframe();
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		getRogersRecoverPassOrNamePage().clkUseYourAccountInfoInsteadLink();
		String strAccountNumber = TestDataHandler.tc060809.getAccountDetails().getBan();
		String strPostcode =  TestDataHandler.tc060809.getAccountDetails().getPostalcode();
		String strDOB =  TestDataHandler.tc060809.getAccountDetails().getDob();
		strPassword = TestDataHandler.tc060809.getPassword();
		getRogersRecoverPassOrNamePage().setAccountNumber(strAccountNumber);
		getRogersRecoverPassOrNamePage().setPostCode(strPostcode);
		getRogersRecoverPassOrNamePage().setDOB(strDOB);
		reporter.reportLogWithScreenshot("Set Account, post code and DOB number for recover user name.");
		getRogersRecoverPassOrNamePage().clkBtnContinue();
		reporter.reportLogWithScreenshot("Click on Text as recovery option");
		//getRogersRecoverPassOrNamePage().clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		
		//Will open a new tab for ENS, to get verification code from ENS		
		try {
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc060809.getAccountDetails().getRecoveryNumber();
			String recoveryCode = ensVerifications.getAccountUserName(strPhoneNum);			
			getDriver().switchTo().window(strTestingTab);			
			reporter.reportLogWithScreenshot("Close the Overlay");
			getRogersRecoverPassOrNamePage().switchToSetCodeIframe();
			getRogersRecoverPassOrNamePage().setRecoveryCode(recoveryCode);
			getRogersRecoverPassOrNamePage().clkBtnContinue();
			strRecoveredUserName= getRogersRecoverPassOrNamePage().getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName);
			getRogersRecoverPassOrNamePage().setNewPassword(strPassword);
			getRogersRecoverPassOrNamePage().setConfirmPassword(strPassword);
			getRogersRecoverPassOrNamePage().clkBtnContinue();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRogersRecoverPassOrNamePage().isPasswordRestSuccessForRecoveredUsernameOrPwd(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		getRogersRecoverPassOrNamePage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRogersRecoverPassOrNamePage().switchToDefaultContent();
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"username successfully recovered", "username NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");		
						
	}

}
