package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class FidoSS_Regression_TC045_PostpaidSubscriberUpdateProfile extends BaseTestClass{

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
	public void postPaidSubscriberUpdateProfile() throws InterruptedException, ParseException {
		
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc4557.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc4557.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Login Account overview page");
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();	
		getReporter().reportLogWithScreenshot("menu profile and settings selected");
		getFidoprofileandsettingpage().scrollToProfileAndSettingsMiddlePage();
		getReporter().reportLogWithScreenshot("Check for links update contact, billing address");
		getReporter().hardAssert(!getFidoprofileandsettingpage().isLnkUpdateContactPresent(),
				"Link update contact is not present",
				"Link update contact is present");	
		
		//change DC-8049
		getReporter().softAssert(!getFidoprofileandsettingpage().verifySubscriberAccountContactPreferenceSection(),
				"Subscriber account contact preference section is not displayed",
				"Subscriber account cantact preference section is  displayed");		
		getReporter().softAssert(!getFidoprofileandsettingpage().isLnkUpdateBillingAddressPresent(),
				"Link update billing address is not present",
				"Link update billing address is present");	
		getFidoprofileandsettingpage().scrollToProfileAndSettingsMiddlePage();
		getReporter().reportLogWithScreenshot("Subscriber account billing address section");
		//change DC-8049
		getReporter().softAssert(!getFidoprofileandsettingpage().verifySubscriberAccountBillingAddressSection(),
				"Subscriber account billing address section is not  displayed",
				"Subscriber account billing address section is displayed");										
	}

}
