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
 * This test will check the change method of payment functionality
 * works on French and English both
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC075_AO_ValidateMakePaymentCTAinCLMNotification_BC extends BaseTestClass{

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
	
	

	@Test(groups = {"AccountOverviewSS"})
	public void validateMakePaymentCTAinCLMNotificationBC() {
//		getDriver().get(System.getProperty("QaUrl")+"/self-serve/overview");
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc75.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc75.getPassword());
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
				
		getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfCLMNotificationIsDisplayed(),
				"The user has atleast 1 active account which has already automatic payments option",
				"The user should have atleast 1 active account which has already automatic payments option");
		
		/*getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfMakePaymentIsDisplayedCLMNotificationIsDisplayed(),
				"The user has atleast 1 active account which has already automatic payments option",
				"The user should have atleast 1 active account which has already automatic payments option");
		
		getFidoaccountoverviewpage().clkMakePaymentOnCLMNotification();
		getFidoaccountoverviewpage().scrollToMiddleOfPage();
		getReporter().hardAssert(getFidomakepaymentpage().verifyPaymentModalIsDisplayed(),
				"Make payment modal displayed.",
				"Make payment modal didn't display as expected.");*/
							
	}
	
	

}
