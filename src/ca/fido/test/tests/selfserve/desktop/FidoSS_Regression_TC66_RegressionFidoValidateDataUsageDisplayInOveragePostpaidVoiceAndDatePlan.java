package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
1. Navigate to Fido.ca
2. login with valid credentials.
3. Click on Usage and service tab 
4. Validate Data Overage details 

1. Fido.ca landing page is opened successfully.
2. Account overview page must be displayed.
3. Usage and service page should be displayed.
4. Data overage size, call out message and Overage details should be displayed


 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC66_RegressionFidoValidateDataUsageDisplayInOveragePostpaidVoiceAndDatePlan extends BaseTestClass{
			 	
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
	public void validateDemolineValidateUTEwirelessDashboardPageWithOverageDemoline() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {		
		getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		//getFidohomepage().clkLogin();
		String userName = "";
		String password = "";
	
		userName = TestDataHandler.tc66.getUsername();
		password = TestDataHandler.tc66.getPassword();		
		//getFidologinpage().switchToSignInFrame();
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
		String strCTN = TestDataHandler.tc66.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
//		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		getReporter().reportLogWithScreenshot("dashboard page loaded");
		getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyYouHaveAnOverageUsageBarOrGradientIsDisplayed(),
						"Data overage usage  gradient is displayed",
						"Data overage usage gradient is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLabelDataOverageSizeIsDisplayed(),
						"Data overage size is displayed",
						"Data overage size is not displayed");
		getReporter().reportLogWithScreenshot("Attention Exclamation symbol for overage");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyAttentionOverageSymbolIsDisplayed(),
						"Attention Exclamation symbol is displayed for overage", 
						"Attention Exclamation symbol is not displayed for overage");		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTalkPlanDetailsSectionIsDisplayed(),
						"Talk plan is displayed",
						"Talk plan is not displayed");		
					
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalDataInUsageSectionIsDisplayed(),
						"Data Section is displayed",
						"Data section is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLabelDataDelayedIsDisplayed(),
						"Data delay message display.",
						"Data delay message didn't displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDaysRemainingInBillCycleIsDisplayed(),
						"Label N days reming for Bill cycle is displayed",
						"Label N days remaining for Bill cycle is not displayed");
		
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDaysRemainingInBillCycleIsDisplayed(),
						"Days remaining in bill cycle",
						"Days remaining in bill cycle is not displayed");
		getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTalkNTextUsageModuleIsDisplayed(),
						"Talk & Text usage module is displayed",
						"Talk & Text usage module is not displayed, please investigate");			
		
	}
	
}
