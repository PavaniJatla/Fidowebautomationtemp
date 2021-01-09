package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Sanity_TC_06_ValidateRecoverUsernameUsingAccountNumberBySMS extends BaseTestClass{
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

	
	@Test(groups = {"RegressionSS","ProfileAndSettingSS","RecoverSS"})
	public void tc06ValidtRecvUsrnameByAccNumUsingSms() {				
		getFidohomepage().clkLogin();
		getReporter().reportLogWithScreenshot("Login Page");
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkForgotPassOrNameIframe();	
		getReporter().reportLogWithScreenshot("Clicked on Forgot Password or username");
		getFidorecoverpassornamepage().clkBtnUserName();
		getReporter().reportLogWithScreenshot("Clicked on password button");
		String strAccountNumber = TestDataHandler.tc04To09.getaccountDetails().getBan();
		String strPassword = TestDataHandler.tc04To09.getPassword();
		getFidorecoverpassornamepage().setAccountNumber(strAccountNumber);
		getReporter().reportLogWithScreenshot("Set email id and click button continue");
		getFidorecoverpassornamepage().clkBtnContinue();		
		getReporter().reportLogWithScreenshot("Continue is clicked");
		//flow updated in May 20th release, no need to click text option.
		getFidorecoverpassornamepage().clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName = null;		
		
		String strPhoneNum = TestDataHandler.tc04To09.getaccountDetails().getRecoveryNumber();
		strRecoveredUserName = getEnsverifications().getAccountUserName(strPhoneNum);			
		getDriver().switchTo().window(strTestingTab);
		getReporter().reportLogWithScreenshot("Close the Overlay");
		getFidorecoverpassornamepage().switchToSetCodeIframe();
		getFidorecoverpassornamepage().clkBtnCloseWeHaveTextedUserNameOverlay();			

		//Login with username:  
		getFidohomepage().clkLogin();
		getReporter().reportLogWithScreenshot("Login Page");
		getFidorecoverpassornamepage().switchToDefaultContent();
		getFidologinpage().switchToSignInFrame();
		getCommonbusinessflows().loginApplication(strRecoveredUserName, strPassword);						
		getReporter().reportLogWithScreenshot("Login successful");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().reportLogWithScreenshot("Account overview page");
		
	}
	
	
}
