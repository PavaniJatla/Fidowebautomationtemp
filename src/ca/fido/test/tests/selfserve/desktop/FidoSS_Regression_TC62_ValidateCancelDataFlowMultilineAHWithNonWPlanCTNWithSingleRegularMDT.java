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
import java.util.Map;

/**
 * The test will Validate Cancel DataFlow Multiline AH With NonW Plan CTN With Single RegularMDT, 
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC62_ValidateCancelDataFlowMultilineAHWithNonWPlanCTNWithSingleRegularMDT extends BaseTestClass{
	
	
	 	
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
	public void verifyCancelDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
		getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
		getFidohomepage().clkLogin();
	
		String	userName = TestDataHandler.tc6062.getUsername();
		String	password = TestDataHandler.tc6062.getPassword();
		
		getFidologinpage().switchToSignInFrame();
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
		String strCTN = TestDataHandler.tc6062.getaccountDetails().getCtn();
		getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
		getReporter().reportLogWithScreenshot("Click on CTN badge");
		getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
		getReporter().reportLogWithScreenshot("dashboard page loaded");
		Map<String, Integer> countOfActiveAndCancelledAddDataOnMyPlan = getFidowirelessdashboardpostpaidpage().getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection();			
		
		//4. Click on View details in usage dashboard
		getReporter().hardAssert(getFidodatamanagementpage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		Map<String, Integer> countOfActiveAndCancelledAddData = getFidodatamanagementpage().getAllExistingAddDataCountCancelledAndActive();
		getReporter().reportLogWithScreenshot("Manage Data page");
		//Comparisions Before Cancel:
		getReporter().hardAssert((countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled").intValue()==countOfActiveAndCancelledAddData.get("cancelled").intValue()
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("active").intValue()==countOfActiveAndCancelledAddData.get("active").intValue()
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("nonMDT").intValue()==countOfActiveAndCancelledAddData.get("nonMDT").intValue())
				, "The number of cancelled and active add on macth on my plans and manage data page", 
				"The number of cancelled and active add on does not macth on my plans and manage data page");
		
		if((countOfActiveAndCancelledAddData.get("active")>=1))
		{
//			getFidodatamanagementpage().scrollToMiddle();
			getReporter().reportLogWithScreenshot("Click on cancel MDT Link");
			getFidodatamanagementpage().clkCancelMDTLink();			

			getReporter().reportLogWithScreenshot("Click on Yes Remove Top Up");
			getFidodatamanagementpage().clkYesRemoveTopUpButton();
			getReporter().hardAssert(getFidodatamanagementpage().isCancelSuccessdisplayed(),
					"Cancel MDT success",
					"MDT cancel not successful");
			getReporter().reportLogWithScreenshot("Cancel successful");
			getFidodatamanagementpage().clkCloseButtonOnCancelSuccessOverlay();
			getReporter().reportLogWithScreenshot("Close overlay");
			
			getFidodatamanagementpage().scrollToTop();
			getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
			getReporter().reportLogWithScreenshot("Back on dashboard");
			getReporter().hardAssert(getFidodatamanagementpage().validateViewDetailsLink(),
					"'Data details' page is displayed after click on view details link",
					"'Data details' page is NOT displayed after click on view details link");
			//7. Verify that MDT is cancelled
			//7. Expires MMM DD - is displayed next to the cancelled MDT in manage data page and plan section
			getReporter().softAssert(getFidodatamanagementpage().verifyCancelledMDTInManageData(1,countOfActiveAndCancelledAddData.get("cancelled")),
					"Expires MMM DD - is displayed next to the cancelled MDT in manage data page",
					"Expires MMM DD - is NOT displayed next to the cancelled MDT in manage data page, plase investigate");	
											
			getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
			getReporter().reportLogWithScreenshot("Back on dashboard");
			getCommonbusinessflows().logOutAndResignIn(userName,password);
			//rechange to the original one
			if(getFidoaccountoverviewpage().verifySuccessfulLogin())
			{
				getReporter().reportLogWithScreenshot("Click on CTN badge");
				getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
				getReporter().reportLogWithScreenshot("dashboard page");
				getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();
				getReporter().reportLogWithScreenshot("My Plan Details");
				//All the added OTT are reflected in total bucket,plan section and manage data page
				getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyCancelledAddedDataInMyPlan(1, countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled"))
						,"Expires MMM DD - is displayed next to the cancelled MDT in plan section",
						"Expires MMM DD - is NOT displayed next to the cancelled MDT in plan section");
				
			}
				
		}else
		{
			getReporter().reportLogFail("No MDT to cancel, please add mdt and rerun the script");
		}
							

	}
	
}
