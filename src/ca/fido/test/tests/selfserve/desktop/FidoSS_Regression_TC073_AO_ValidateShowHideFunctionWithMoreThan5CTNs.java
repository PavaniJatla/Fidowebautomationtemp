package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * works on French and English both
 * @author Mirza.Kamran
 * 
 * 
 * "1. Navigate to Fido.ca
2. Sign in with proper credentials.
3.Validate the link is present to expand the CTNs
4.Click on the View all lines CTA link
5.Validate the CTNs are displayed as per mock
6.Click on the Manage & Usage link
7.Validate the Add a Line link present on the last row of the table in AO page
8.Validate the Hide all lines link is present to hide the tabular view of the CTNs and click on it"	

"1.Fido.ca is up and running
2.User is displayed with Account Overview page with hidden view of CTNs associated with the BAN
3.View all lines CTA link is displayed to show the CTNs in expanded view
4.Expanded view of CTNs are displayed in tabular format and animated as per CDK .
5.User is displayed with all CTNs present in the BAN with the details as below
  a.First Name and Last Name of Subscriber
  b.10 digits CTN with format(xxx) xxx-xxxx
  c.Manage & Usage link(for each CTN)
6.User is directed to the corresponding CTN's Fido Wireless Dashboard as expected 
7.Add a Line link is displayed as expected
8.Hidden view of CTNs is displayed and animated as per CDK"
 * 
 * 
 *
 */
public class FidoSS_Regression_TC073_AO_ValidateShowHideFunctionWithMoreThan5CTNs extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession("https://qa4.fido.ca", strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	

	@Test(groups = {"AccountOverviewSS"})
	public void validateShowHideFunctionWithMoreThan5CTNs() {
		//getDriver().get(System.getProperty("QaUrl")+"/self-serve/overview");
		getFidohomepage().clkLogin();
		getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc73.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc73.getPassword());
		String strBANIWithMoreThan5CTNS = TestDataHandler.tc73.getaccountDetails().getBan();
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

		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfShowAllLinesLinkIsDisplayd(strBANIWithMoreThan5CTNS), 
				"View all lines CTA link is displayed to show the CTNs in expanded view",
				"View all lines CTA link is NOT displayed it seems");
		getReporter().reportLogWithScreenshot("Show all lines link displayed");
		getFidoaccountoverviewpage().clkShowAllLinesLink();
		getReporter().reportLogWithScreenshot("Clicked on Show all lines link");
		getReporter().hardAssert(getFidoaccountoverviewpage().validateIfMoreThan5CTNSDisplayedInTheViewAllCTNList(strBANIWithMoreThan5CTNS), 
				"More than 5 CTN's are listed correctly",
				"It seems the count of CTN is not more than 5");
	
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyAllCTNsPresentinTheBANwithCorrectNameNumberAndAddManageLink(strBANIWithMoreThan5CTNS),
				"User name , 10 digits CTN format xxx xxx-xxxx and Manage usage link is present for each CTN",
				"User name , 10 digits CTN format xxx xxx-xxxxand Manage usage link seems the format is incorrect for either of them");
		
		
		List<WebElement> lstCTNNumbers =  getFidoaccountoverviewpage().getListOfCTNNumbers();
		String []arrayCTNS = getFidoaccountoverviewpage().getAllCTNS(lstCTNNumbers);

		for (String strCTNValue : arrayCTNS) {
				

				//Click on the respective CTN				
				getFidoaccountoverviewpage().clickCTNsViewUsageAndManageLink(strCTNValue.trim().replaceAll(" ", "").replaceAll("-", ""));
				
				getReporter().hardAssert(getFidoaccountoverviewpage().IsCorrectDashboardOpen(strCTNValue),
						"User is directed to the corresponding CTN : "+strCTNValue+" Fido Wireless Dashboard as expected",
						"It seems the User didint get directed to the CTN "+strCTNValue+"  Fido Wireless Dashboard as expected, ");
				getReporter().reportLogWithScreenshot("Dashboard for CTN : "+strCTNValue);
				getFidoaccountoverviewpage().NavigateToAccountOverViewFromDashbOard();
				getFidoaccountoverviewpage().clkShowAllLinesLink();						
			}
		
		
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfUserReDirectsToCorrectCTNDashboard(strBANIWithMoreThan5CTNS),
				"User is directed to the corresponding CTN's Fido Wireless Dashboard as expected",
				"It seems the User didint get directed to the corresponding CTN's Fido Wireless Dashboard as expected, ");		
		getFidoaccountoverviewpage().clkShowAllLinesLink();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfAddLineLinkIsDisplayed(strBANIWithMoreThan5CTNS),
				"Add a line link is displayed",
				"Add a line link is NOT displayed");
		getFidoaccountoverviewpage().clkHideAllLinesLink();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfShowAllLinesLinkIsDisplayd(strBANIWithMoreThan5CTNS), 
				"View all lines CTA link is displayed to show the CTNs in expanded view",
				"View all lines CTA link is NOT displayed it seems");
		getReporter().reportLogWithScreenshot("Show all lines link displayed");
							
	}
	
	

}
