package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Sanity_TC_10_UserAddNumberForRecovery extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","ProfileAndSettingSS","RecoverSS"})
	public void userAddNumberForRecovery() {
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		String userName = TestDataHandler.tc104447.getUsername();
		String password = TestDataHandler.tc104447.getPassword();
		getFidologinpage().setUsernameInFrame(userName);
		getFidologinpage().setPasswordInFrame(password);
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		try {
			getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
			getReporter().reportLogWithScreenshot("menu profile and settings selected");
		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
			getReporter().reportLogWithScreenshot("menu profile and settings selected");
		}
		getReporter().reportLogWithScreenshot("Profile and Settings page");
		getFidoprofileandsettingpage().clkSetRcvryNumber();
		getReporter().reportLogWithScreenshot("Set recovery number");
		String strTestingTab = getDriver().getWindowHandle();
		String strPhoneNumber =  TestDataHandler.tc104447.getaccountDetails().getMobilePhone();
		String strRecoveryNumber = TestDataHandler.tc104447.getaccountDetails().getRecoveryNumber();
		getFidoprofileandsettingpage().switchToSetRecoveryNumIFrame();
		getFidoprofileandsettingpage().setPhoneNumberIframe(strPhoneNumber);
		getReporter().reportLogWithScreenshot("Recovery Number");
		getFidoprofileandsettingpage().clkBtnContinueIframe();
		getReporter().reportLogWithScreenshot("click button continue");
		//Will open a new tab for ENS, to get verification code from ENS		
		try {
			getReporter().reportLogWithScreenshot("ENS verification process start");
			String strVerifyCode = getEnsverifications().getVerifyCode(strRecoveryNumber);
			getDriver().switchTo().window(strTestingTab);
			getFidoprofileandsettingpage().switchToSetRecoveryNumIFrame();
			getFidoprofileandsettingpage().setVerifyCodeIframe(strVerifyCode);
			getReporter().reportLogWithScreenshot("Set verify code");
			getFidoprofileandsettingpage().clkBtnVerifyMeIframe();
			getReporter().reportLogWithScreenshot("Button verify me clicked");
			getReporter().hardAssert(getFidoprofileandsettingpage().verifySuccessConfirmationMsg(), 
								"Recovery phone number set successfully",
								"Got error when setting recovery phone number");
			getFidoprofileandsettingpage().clkBtnContinueToMyAccountIframe();
			getFidoprofileandsettingpage().switchOutofSetRecoveryNumIframe();
			getReporter().reportLogWithScreenshot("Click button continue to my account");
//			getFidohomepage().clkMenuMyAccountAfterLogin();
//			getReporter().reportLogWithScreenshot("Click Menu My Account after login");
			getFidoaccountoverviewpage().clkSubNavProfileAndSettings();

			getReporter().hardAssert(getFidoprofileandsettingpage().verifyRecoveryNumberSetSuccessfully(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
								"recovery number set successfully",
								"Recovery number did not set successfully");
			getReporter().reportLogWithScreenshot("Verify recovery number set in profile and settings page.");
			
		} catch (IOException e) {
			getReporter().reportLogFail(e.getMessage());
			
			
		}
	}

}
