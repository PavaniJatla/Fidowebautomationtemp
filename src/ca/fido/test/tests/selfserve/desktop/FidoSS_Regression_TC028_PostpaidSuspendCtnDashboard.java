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
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc28.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc28.getPassword());
		String strBan = TestDataHandler.tc28.getaccountDetails().getBan();
		String ctn = TestDataHandler.tc28.getaccountDetails().getCtn();
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
		getReporter().hardAssert(getFidoaccountoverviewpage().validateAccountSuspendedWithViewBillButtonAndMakeAPaymentButtonExists(strBan),
				"Account is suspended with view & manage bill and Make a Payment buttons visible",
				"Suspended account overview page seems invalid, please investigate");

		getFidoaccountoverviewpage().clickCTNsViewUsageAndManageLink(ctn);
		getReporter().reportLogWithScreenshot("Suspended CTN account Dashboard page");


		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyMyMobilePlanDashBoardSectionIsDisplayed(),
				"My Mobile Plan Dash Board Section Is visible",
				"My Mobile Plan Dash Board Section Is not visible");

		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyMyDeviceDetails(),
				"My Device Details Section Is visible",
				"My Device Details Section Is not visible");

		getReporter().hardAssert(!getFidowirelessdashboardpostpaidpage().verifyIfUsageInfoDisplayed(),
				"Usage Info Is Not visible",
				"Usage Info Is Visible - please investigate");




		
	}
}
