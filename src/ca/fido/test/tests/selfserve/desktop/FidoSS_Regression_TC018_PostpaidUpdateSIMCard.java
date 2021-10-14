package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC018_PostpaidUpdateSIMCard extends BaseTestClass{
	
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
	public void postpaidUpdateSIMCard() {
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc18.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc18.getPassword());
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
		String strCTN = TestDataHandler.tc18.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("After click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkLnkUpdateSimCard();
		getReporter().reportLogWithScreenshot("Click on Link : Update Sim card");
		String strOldSimNum = TestDataHandler.tc18.getaccountDetails().getSimCardNumber();
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getFidowirelessdashboardpostpaidpage().setOldSimNum(strOldSimNum);
		//String strNewSimNum = FormFiller.generateSIMNumber();
		String strNewSimNum = "370102000617860";
		getFidowirelessdashboardpostpaidpage().setNewSimNum(strNewSimNum);
		getReporter().reportLogWithScreenshot("Fill old and new sim card details");
		getFidowirelessdashboardpostpaidpage().clkBtnUpdateSimNext();
		getReporter().reportLogWithScreenshot("Click Button update SIM card Next button");
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyUpdateSimReview(strOldSimNum, strNewSimNum),
				"SIM review successful",
				"SIM review is not successful, please investigate");	
		getReporter().reportLogWithScreenshot("Update SIM card review page.");
	}

}
