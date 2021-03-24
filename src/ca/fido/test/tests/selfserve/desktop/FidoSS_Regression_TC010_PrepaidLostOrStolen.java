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
 * Test script for report lost or stolen for Fido pre-paid account.
 * It will reactivate the device after suspend it. 
 * @author Ning.Xue
 *
 */
public class FidoSS_Regression_TC010_PrepaidLostOrStolen extends BaseTestClass {
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
	@Test(groups = {"RegressionSS","DashboardSS","PrepaidSS"})
	public void prepaidReportLostOrStolen() {
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc00101056.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc00101056.getPassword());
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
		String strCTN = TestDataHandler.tc00101056.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		if (getFidowirelessdashboardprepaidpage().isServiceSuspended()) {
			getReporter().reportLogWithScreenshot("The service seems is suspended, reactivating the same again");
			getFidowirelessdashboardprepaidpage().clkBtnReactivateDevice();
			getFidoreportlostorstolenpage().clkBtnReactivateDevice();
			getReporter().hardAssert(getFidoreportlostorstolenpage().verifyReactivateConfirmMessage(),
					"reactivate confirmation",
					"some issue with reactivate confirmation, please investigate");
			getFidoaccountoverviewpage().clkMenuUsageNService();
			getReporter().reportLogWithScreenshot("click menu usage and service");
		}
		getFidowirelessdashboardprepaidpage().clkLnkReportLostOrStolen();
		getReporter().reportLogWithScreenshot("Click on lnk report lost or stolen");
		getFidoreportlostorstolenpage().clkBtnReportLostContinue();
		getFidoreportlostorstolenpage().clkBtnSuspend();
		getReporter().reportLogWithScreenshot("After click on button suspend");
		getReporter().hardAssert(getFidoreportlostorstolenpage().verifySuspendConfirmMessage(),
							"Suspended successfully", 
							"Suspend is not successful");
		getReporter().reportLogWithScreenshot("Suspend confirmation page");
		//Successfully suspend the device, now need to reactivate the device
		getFidoaccountoverviewpage().clkMenuUsageNService();
		getReporter().reportLogWithScreenshot("menu usage and service");
		getFidowirelessdashboardprepaidpage().clkBtnReactivateDevice();
		getReporter().reportLogWithScreenshot("Clicking the button Reactivate Device");
		getFidoreportlostorstolenpage().clkBtnReactivateDevice();		
		getReporter().reportLogWithScreenshot("After click on button re activate device");
		getReporter().hardAssert(getFidoreportlostorstolenpage().verifyReactivateConfirmMessage(),
							"The Account reactivated sucessfully",
							"The acocunt didn't reactivate sucessfully");
	}

}
