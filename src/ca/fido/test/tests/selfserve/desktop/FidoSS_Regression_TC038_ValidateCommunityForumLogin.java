package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class FidoSS_Regression_TC038_ValidateCommunityForumLogin  extends BaseTestClass{

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
	
	@Test
	public void validateCommunityForumLogin() {
		fido_home_page.clkContactUs();
		fido_Community_Page.clkFidoCommunity();
		Assert.assertTrue(fido_Community_Page.verifyMenuForums()
					&& fido_Community_Page.verifyMenuLibrary()
					&& fido_Community_Page.verifyMenuBlog()
					&& fido_Community_Page.verifyMenuQuickLinks());
		fido_Community_Page.clkSignIn();
		
	}
}
