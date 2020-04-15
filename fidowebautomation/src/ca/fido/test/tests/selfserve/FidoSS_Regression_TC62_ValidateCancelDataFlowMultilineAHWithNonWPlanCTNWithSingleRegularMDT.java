package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * The test will Validate Cancel DataFlow Multiline AH With NonW Plan CTN With Single RegularMDT, 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC62_ValidateCancelDataFlowMultilineAHWithNonWPlanCTNWithSingleRegularMDT extends BaseTestClass{
	
	
	 	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test
	public void verifyAddDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		reporter.reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		fido_home_page.clkLogin();
	
		String	userName = TestDataHandler.tc6062.getUsername();
		String	password = TestDataHandler.tc6062.getPassword();
		
		fido_login_page.switchToSignInFrame();
		fido_login_page.setUsernameInFrame(userName);
		fido_login_page.setPasswordInFrame(password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		fido_login_page.clkLoginInFrame();		
		fido_login_page.switchOutOfSignInFrame();
		reporter.reportLogWithScreenshot("Account overview page");
		fido_account_overview_page.clkCtnBadge();
		reporter.reportLogWithScreenshot("Click on CTN badge");
		fido_wireless_dashboard_postpaid_page.clkShowMyUsageIfVisible();
		reporter.reportLogWithScreenshot("dashboard page loaded");
		Map<String, Integer> countOfActiveAndCancelledAddDataOnMyPlan = fido_wireless_dashboard_postpaid_page.getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection();			
		
		//4. Click on View details in usage dashboard
		reporter.softAssert(fido_data_management_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		Map<String, Integer> countOfActiveAndCancelledAddData = fido_data_management_page.getAllExistingAddDataCountCancelledAndActive();
		reporter.reportLogWithScreenshot("Manage Data page");
		//Comparisions Before Cancel:
		reporter.softAssert((countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled")==countOfActiveAndCancelledAddData.get("cancelled")
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("active")==countOfActiveAndCancelledAddData.get("active")
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("nonMTT")==countOfActiveAndCancelledAddData.get("nonMTT"))
				, "The number of cancelled and active add on macth on my plans and manage data page", 
				"The number of cancelled and active add on does not macth on my plans and manage data page");
		
		if((countOfActiveAndCancelledAddData.get("active")>=1))
		{
			fido_data_management_page.scrollToMiddle();
			reporter.reportLogWithScreenshot("Click on cancel MTT Link");
			fido_data_management_page.clkCancelMTTLink();			
			reporter.reportLogWithScreenshot("Click on Yes Remove Top Up");
			fido_data_management_page.clkYesRemoveTopUpButton();
			reporter.hardAssert(fido_data_management_page.isCancelSuccessdisplayed(),
					"Cancel MTT success",
					"MTT cancel not successful");
			reporter.reportLogWithScreenshot("Cancel successful");
			fido_data_management_page.clkCloseButtonOnCancelSuccessOverlay();
			reporter.reportLogWithScreenshot("Close overlay");
			
			fido_data_management_page.scrollToTop();
			fido_data_management_page.clkLinkBackOnManageDataOverlay();
			reporter.reportLogWithScreenshot("Back on dashboard");
			reporter.softAssert(fido_data_management_page.validateViewDetailsLink(),
					"'Data details' page is displayed after click on view details link",
					"'Data details' page is NOT displayed after click on view details link");
			//7. Verify that MDT is cancelled
			//7. Expires MMM DD - is displayed next to the cancelled MDT in manage data page and plan section
			reporter.softAssert(fido_data_management_page.verifyCancelledMDTInManageData(1,countOfActiveAndCancelledAddData.get("cancelled")),
					"Expires MMM DD - is displayed next to the cancelled MDT in manage data page",
					"Expires MMM DD - is NOT displayed next to the cancelled MDT in manage data page, plase investigate");	
											
			fido_data_management_page.clkLinkBackOnManageDataOverlay();
			reporter.reportLogWithScreenshot("Back on dashboard");
			fido_login_page.clkSignOut();
			reporter.reportLogWithScreenshot("Sign out done");
			fido_login_page.clkResignInAs();
			reporter.reportLogWithScreenshot("Click Re Sign In");
			fido_login_page.switchToSignInFrame();
			fido_login_page.setPasswordInFrame(password);
			reporter.reportLogWithScreenshot("Verify login with new password.");
			fido_login_page.clkLoginInFrame();
			fido_login_page.switchOutOfSignInFrame();
			//rechange to the original one
			if(fido_account_overview_page.verifySuccessfulLogin())
			{
				reporter.reportLogWithScreenshot("Click on CTN badge");
				fido_account_overview_page.clkCtnBadge();
				reporter.reportLogWithScreenshot("dashboard page");
				fido_wireless_dashboard_postpaid_page.scrollToMidOfDasboardPage();
				reporter.reportLogWithScreenshot("My Plan Details");
				//All the added OTT are reflected in total bucket,plan section and manage data page
				reporter.softAssert(fido_wireless_dashboard_postpaid_page.verifyCancelledAddedDataInMyPlan(1, countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled"))
						,"Expires MMM DD - is displayed next to the cancelled MDT in plan section",
						"Expires MMM DD - is NOT displayed next to the cancelled MDT in plan section");
				
			}
			
						
		}else
		{
			reporter.reportLogFail("No MTT to cancel, please add mtt and rerun the script");
		}
							

	}
	
}
