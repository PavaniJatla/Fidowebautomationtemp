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

public class FidoSS_Regression_TC044_PostpaidAccHolderUpdateContactInfo extends BaseTestClass{	

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
	

	@Test(groups = {"RegressionSS","ProfileAndSettingSS"})
	public void postPaidPaymentViewAndUpdateContactInfo() throws InterruptedException, ParseException {
		
		//getFidohomepage().clkLogin();
		//getFidologinpage().switchToSignInFrame();
		getFidologinpage().setUsernameInFrame(TestDataHandler.tc104447.getUsername());
		getFidologinpage().setPasswordInFrame(TestDataHandler.tc104447.getPassword());
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
		getFidoaccountoverviewpage().clkSubNavProfileAndSettings();
		Hashtable<String, String> existingContactDetailsDict = getFidoprofileandsettingpage().getOldContactDetails();
		getReporter().reportLogWithScreenshot("profile and setting page");
		getFidoprofileandsettingpage().clkUpdateContactDetails();	
		getReporter().reportLogWithScreenshot("update contact details view");
		String strNewEmail = FormFiller.generateEmail();
		String strNewMobilePhone = FormFiller.generatePhoneNumber();
		String strNewHomePhone = FormFiller.generatePhoneNumber();
		String strNewBusinessPhone = FormFiller.generatePhoneNumber();
		
		getFidoprofileandsettingpage().setEmail(strNewEmail);
		getFidoprofileandsettingpage().setMobilePhone(strNewMobilePhone);
		getFidoprofileandsettingpage().setHomePhone(strNewHomePhone);
		getFidoprofileandsettingpage().setBusinessPhone(strNewBusinessPhone);
		getReporter().reportLogWithScreenshot("New contact details entered");
		getFidoprofileandsettingpage().saveContactDetails();		
		getReporter().reportLogWithScreenshot("new contact details saved");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyEmailUpdated(existingContactDetailsDict.get("email"), strNewEmail),
							"Email updated successfully",
							"Email did not update correctly, please investigate");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyMobilePhoneUpdated(existingContactDetailsDict.get("mobilePhone"), strNewMobilePhone),
							"Mobile phone updated",
							"Mobile phone did not update");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyHomePhoneUpdated(existingContactDetailsDict.get("homePhone"), strNewHomePhone),
							"home phone updated",
							"home phone didn't update");
		getReporter().softAssert(getFidoprofileandsettingpage().verifyBusinessPhoneUpdated(existingContactDetailsDict.get("businessPhone"), strNewBusinessPhone),
							"business phone updated",
							"business phone didn't update");		
		getReporter().reportLogWithScreenshot("Contact details updated.");
									
	}

}
