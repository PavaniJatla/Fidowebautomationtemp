package ca.fido.test.tests.selfserve;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC039_TC40_ValidateTheErrorMessageWhileLinkingCancelledOrSuspendedBANWhichIsNotLinkedToAnyLegacyProfile extends BaseTestClass{
	
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage", "strGroupName" })
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, strGroupName,method);			
	}
	
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { TestDataHandler.tc39.getaccountDetails().getBan()+"#"
        						+TestDataHandler.tc39.getaccountDetails().getPostalCode() },
        					{ TestDataHandler.tc40.getaccountDetails().getBan()+"#"
        						+TestDataHandler.tc40.getaccountDetails().getPostalCode() } };
    }
	
	@Test(dataProvider = "data-provider") 
	public void acctHolderValidateRegisterFlowWithCancelledOrSuspended(String strUserDetails) {
		reporter.reportLogWithScreenshot("Home Page");
		fido_home_page.clkLogin();
		fido_login_page.switchToSignInFrame();
		fido_login_page.clkRegisterIframe();
		reporter.reportLogWithScreenshot("Registration Page opened");
		fido_account_registration_page.clkRegisterNow();
		fido_account_registration_page.pageRefresh();		
		reporter.reportLogWithScreenshot("Account Holder option to select");
		fido_account_registration_page.clkAccountHolder();		
		fido_account_registration_page.setFidoAccountNumber(strUserDetails.split("#")[0].trim());
		fido_account_registration_page.setPostalCode(strUserDetails.split("#")[1].trim());
		reporter.reportLogWithScreenshot("Account number and post code entered");
		fido_account_registration_page.clkContinueAccountRegister();			
		reporter.reportLogWithScreenshot("Error Page");
		reporter.hardAssert(fido_account_registration_page.verifyErrorMsgDisplayedForCancelledAndSuspendedAccount()
				,"Error message displayed"
				,"Error message displayed");		
	}
		

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
}
