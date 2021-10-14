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
 * This test will check the change method of payment functionality
 * works on French and English both
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC071_AO_ValidateSubNav extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
/*
 * 1. Fido.ca up and running
2. The sign-in pop-up will be displayed
3. The account overview page will be displayed with the subnav (Account Overview + Profile & Settings)
Validate:
- Sub Nav have two options Account Overview and Profiles and Settings
- By default sub-nav is selected on Account Overview
4- User will be navigate to Profiles and Settings on old application	
 */
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	

	@Test(groups = {"AccountOverviewSS"})
	public void validateSubNav() {
		//getDriver().get(System.getProperty("QaUrl")+"/self-serve/overview");
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc121315.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc121315.getPassword());
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
				
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySubNavHasAOandPnSNavigationOptions(),
				"Sub Nav have two options Account Overview and Profiles and Settings",
				"Sub Nav doesnt have two options Account Overview and Profiles and Settings");
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyAccountOverviewIsOpenByDefault(),
				"By default sub-nav is selected on Account Overview",
				"By default sub-nav is NOT selected on Account Overview");
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("click on profile and settings");
		getReporter().hardAssert(getFidoaccountoverviewpage().isProfileAndSettingsPageDisplayed(),
				" User will be navigate to Profiles and Settings on old application",
				"It seems User did not navigate to Profiles and Settings on old application");
							
	}
	
	

}
