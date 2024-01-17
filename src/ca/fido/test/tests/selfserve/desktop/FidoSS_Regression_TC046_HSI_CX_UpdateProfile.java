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
import java.text.ParseException;
import java.util.Hashtable;

public class FidoSS_Regression_TC046_HSI_CX_UpdateProfile extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve,method);			
	}
	

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
	//	closeSession();
	}
	

	@Test(groups = {"RegressionSS","ProfileAndSettingSS"})
	public void postPaidPaymentViewAndEditProfileContactsForHSI() throws InterruptedException, ParseException {
		
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc4246.getUsername());
		getFidologinpage().clkContinuebtn();
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc4246.getPassword());
		getReporter().reportLogWithScreenshot("Login Credential is entered.");
		getFidologinpage().clkLoginInFrame();
		getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(), 
				"Login proceed without error.", 
				"Login failed with error.");
		getFidologinpage().switchOutOfSignInFrame();
		getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), 
				"Login succeed.", 
				"Failed to login.");
		getReporter().reportLogWithScreenshot("Login Account overview page");
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		getReporter().reportLogWithScreenshot("menu profile and settings selected");
		Hashtable<String, String> existingContactDetailsDict=getFidoprofileandsettingpage().getOldContactDetails();
		
		getFidoprofileandsettingpage().clkUpdateContactDetails();	
		String strNewEmail = FormFiller.generateEmail();
		String strNewMobilePhone = FormFiller.generatePhoneNumber();
		String strNewHomePhone = FormFiller.generatePhoneNumber();
		String strNewBusinessPhone = FormFiller.generatePhoneNumber();
		getReporter().reportLogWithScreenshot("Update contact details");
		getFidoprofileandsettingpage().setEmail(strNewEmail);
		getFidoprofileandsettingpage().setMobilePhone(strNewMobilePhone);
		getFidoprofileandsettingpage().setHomePhone(strNewHomePhone);
		getFidoprofileandsettingpage().setBusinessPhone(strNewBusinessPhone);
		getReporter().reportLogWithScreenshot("new contact details entered");
		getFidoprofileandsettingpage().saveContactDetails();		
		getReporter().reportLogWithScreenshot("new contact details saved");		
		getReporter().softAssert(getFidoprofileandsettingpage().verifyEmailUpdated(existingContactDetailsDict.get("email"), strNewEmail),
							"The email updated on PnS page",
							"Email not updated on PnS, please investigate");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyMobilePhoneUpdated(existingContactDetailsDict.get("mobilePhone"), strNewMobilePhone),
							"Mobile phone update",
							"Mobile phone not updated");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyHomePhoneUpdated(existingContactDetailsDict.get("homePhone"), strNewHomePhone),
							"Home phone updated",
							"home phone not updated");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyBusinessPhoneUpdated(existingContactDetailsDict.get("businessPhone"), strNewBusinessPhone),
							"New business phone updated",
							"New business phone not updated");	
		getReporter().reportLogWithScreenshot("Update HSI account profile is done.");
									
	}

}
