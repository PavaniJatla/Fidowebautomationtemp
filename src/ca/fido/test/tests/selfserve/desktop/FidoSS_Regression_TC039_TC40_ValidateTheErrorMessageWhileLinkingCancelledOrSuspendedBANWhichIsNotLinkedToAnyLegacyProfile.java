package ca.fido.test.tests.selfserve.desktop;


import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC039_TC40_ValidateTheErrorMessageWhileLinkingCancelledOrSuspendedBANWhichIsNotLinkedToAnyLegacyProfile extends BaseTestClass{
	
	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {{ TestDataHandler.tc39.getaccountDetails().getEmail()+"#"
				+TestDataHandler.tc39.getaccountDetails().getBan()+"#"
				+TestDataHandler.tc39.getaccountDetails().getPostalCode() },
        						{ TestDataHandler.tc40.getaccountDetails().getEmail()+"#"
										+TestDataHandler.tc40.getaccountDetails().getBan()+"#"
        						+TestDataHandler.tc40.getaccountDetails().getPostalCode()} };
    }

	@Test(dataProvider = "data-provider",groups = {"RegressionSS","ProfileAndSettingSS","RegisterSS"}) 
	public void acctHolderValidateRegisterFlowWithCancelledOrSuspended(String strUserDetails) {
		getReporter().reportLogWithScreenshot("Home Page");
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().clkRegisterIframe();
		try {
		getReporter().reportLogWithScreenshot("Registration Page opened");
		//getFidoaccountregistrationpage().clkRegisterNow();
		getFidoaccountregistrationpage().pageRefresh();
		}catch (Exception e) {
			getReporter().reportLog(e.getMessage());
		}
		getReporter().reportLogWithScreenshot("Account Holder option to select");
		getFidoaccountregistrationpage().clkAccountHolder();
		//String strFidoEmailAddr = TestDataHandler.tc40.getaccountDetails().getEmail();
		getFidoaccountregistrationpage().setFidoEmailAddr(strUserDetails.split("#")[0].trim());
		getFidoaccountregistrationpage().setFidoAccountNumber(strUserDetails.split("#")[1].trim());
		getFidoaccountregistrationpage().setPostalCode(strUserDetails.split("#")[2].trim());
		getFidoaccountregistrationpage().setDOB();
		getReporter().reportLogWithScreenshot("Account number and post code entered");
		getFidoaccountregistrationpage().clkContinueAccountRegister();			
		getReporter().reportLogWithScreenshot("Error Page");
		getReporter().hardAssert(getFidoaccountregistrationpage().verifyErrorMsgDisplayedForCancelledAndSuspendedAccount()
				,"Error message displayed"
				,"Error message displayed");		
	}
		

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
}
