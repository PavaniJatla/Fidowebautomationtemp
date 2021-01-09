package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC025_PostpaidLostOrStolen extends BaseTestClass {

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
	
	@Test(groups = {"RegressionSS","DashboardSS"}) 
	public void postpaidLostOrStolen() {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc25.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc25.getPassword());
		getReporter().reportLogWithScreenshot("After click on Login");
		getFidologinpage().clkLoginInFrame();	
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Account overview page");
		String strCTN = TestDataHandler.tc25.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("After click on CTN badge");
		if(getFidowirelessdashboardpostpaidpage().isServiceSuspended()) {
			getReporter().reportLogWithScreenshot("Service suspended view");
			getFidowirelessdashboardpostpaidpage().clkLnkReactivate();
			getReporter().reportLogWithScreenshot("After click on link reactivate");
			getFidoreportlostorstolenpage().clkBtnReactivateDevice();
			getReporter().reportLogWithScreenshot("After click on Button reactivate device");
			getReporter().hardAssert(getFidoreportlostorstolenpage().verifyReactivateConfirmMessage(),
					"Reactivate confirmation Message is displayed",
					"Reactivate confirmation message is not displayed");
			getFidoaccountoverviewpage().clkMenuOverview();
			getReporter().reportLogWithScreenshot("Menu Overview clicked.");
			getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
			getReporter().reportLogWithScreenshot("After click on CTN badge");
		} 
		getFidowirelessdashboardpostpaidpage().clkLnkReportLostOrStolen();
		getReporter().reportLogWithScreenshot("After clcik on link report Lost or Stolen");
		getFidoreportlostorstolenpage().clkBtnReportLostContinue();
		getReporter().reportLogWithScreenshot("Report lost suspend");
		getFidoreportlostorstolenpage().clkBtnSuspend();
		getReporter().reportLogWithScreenshot("After click on Button Suspend");
		getReporter().hardAssert(getFidoreportlostorstolenpage().verifySuspendConfirmMessage(),
							"Suspend Confirmation message is displayed",
							"Suspend Confirmation message is not displayed");
		
		//Successfully suspend the device, now need to reactivate the device
		getFidoaccountoverviewpage().clkMenuOverview();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Navigating back to Overview page and click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkLnkReactivate();		
		getFidoreportlostorstolenpage().clkBtnReactivateDevice();
		getReporter().reportLogWithScreenshot("After click on button Reactivate");
		getReporter().hardAssert(getFidoreportlostorstolenpage().verifyReactivateConfirmMessage(),
							"Reactivate confirmation Message is displayed",
							"Reactivate confirmation message is not displayed");
	}

}
