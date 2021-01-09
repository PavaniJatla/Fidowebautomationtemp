package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
/**
 * To validate bill notification in Billing and Setting section of Profile and Settings page, 
 * the validation depends on set the mobile phone number in contact preference, if the mobile phone is set, 
 * it will verify the bill notification area of the number and on/off switch, otherwise, it will set the mobile
 * phone first, then verify bill notification area.
 * @author ning.xue
 *
 */
public class FidoSS_Regression_TC047_PostpaidAccHolderValidateBillNotification extends BaseTestClass {

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
	

	@Test(groups = {"RegressionSS","ProfileAndSettingSS"})
	public void postpaidVerifyBillNotification() {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		String strUserName = TestDataHandler.tc104447.getUsername();
		getFidologinpage().setUsernameInFrame(strUserName);
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc104447.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page.");
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("menu profile and settings selected");

		String strGetMobileNum = getFidoprofileandsettingpage().getMobilePhoneNum();
		//check if the mobile phone is set or not
		if (strGetMobileNum.equalsIgnoreCase("None")) {
			getFidoprofileandsettingpage().clkUpdateContactDetails();
			getReporter().reportLogWithScreenshot("Update contact details selected");
			String mobilePhoneNum = TestDataHandler.tc104447.getaccountDetails().getMobilePhone();
			getFidoprofileandsettingpage().setEmail(strUserName);
			getFidoprofileandsettingpage().setMobilePhone(mobilePhoneNum);
			getFidoprofileandsettingpage().saveContactDetails();		
			getReporter().reportLogWithScreenshot("Bill Notification after add mobile phone number in contact details.");
			
			getReporter().hardAssert(getFidoprofileandsettingpage().verifyBillNotificationUpdateSuccessfully(mobilePhoneNum),
								"Bill notification show successfully with mobile phone set.",
								"Some issue with bill notification area with mobile phone set.");
			getFidoprofileandsettingpage().scrollToProfileAndSettingsMiddlePage();
			getReporter().reportLogWithScreenshot("Verify bill notification section with mobile phone set.");
		} else {			
			getReporter().hardAssert(getFidoprofileandsettingpage().verifyBillNotificationUpdateSuccessfully(strGetMobileNum),
								"Bill notification show successfully with mobile phone set.",
								"Some issue with bill notification area with mobile phone set.");
			getFidoprofileandsettingpage().scrollToProfileAndSettingsMiddlePage();
			getReporter().reportLogWithScreenshot("Verify bill notification section with mobile phone set.");
			//To clear the MobilePhone setting.
			getFidoprofileandsettingpage().clkUpdateContactDetails();
			getReporter().reportLogWithScreenshot("Update contact details selected");
			getFidoprofileandsettingpage().clearMobilePhone();
			getFidoprofileandsettingpage().saveContactDetails();	
			
			getReporter().reportLogWithScreenshot("Bill Notification after cleared mobile phone in Contact details.");
			//verify bill notification area again for no mobile phone set.
			getReporter().hardAssert(getFidoprofileandsettingpage().verifyBillNotificationWithoutMobilePhoneSet(),
					"Bill notification without mobile",
					"Some issue with bill notification area without mobile phone");
			getFidoprofileandsettingpage().scrollToProfileAndSettingsMiddlePage();
			getReporter().reportLogWithScreenshot("Verify bill notification section without mobile phone set.");
		}

	}
}
