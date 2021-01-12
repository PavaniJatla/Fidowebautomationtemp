package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC028_PostpaidSuspendCtnDashboard extends BaseTestClass {

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
	
	
	@Test (groups = {"RegressionSS","DashboardSS"})
	public void postpaidSuspendedCTN() {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc28.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc28.getPassword());
		String strBan = TestDataHandler.tc28.getaccountDetails().getBan();		
		getReporter().reportLogWithScreenshot("After click on Login");	
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		
		getCommonbusinessflows().scrollToMiddleOfWebPage();
		getReporter().reportLogWithScreenshot("Suspended CTN account overview page");
		getReporter().hardAssert(getFidoaccountoverviewpage().validateBillingCTAButtonAddLineForSuspendedAccount(strBan),
				"CTN, View usage and manage and add line is not displayed for suspended account",
				"Suspended account overview page seems invalid, please investigate");
		
	}
}
