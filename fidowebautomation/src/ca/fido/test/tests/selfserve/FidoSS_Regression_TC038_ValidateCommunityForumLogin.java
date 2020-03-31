package ca.fido.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;

public class FidoSS_Regression_TC038_ValidateCommunityForumLogin  extends BaseTestClass{

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage", "strGroupName" })
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());	        
		startSession(TestDataHandler.config.getFidoURL(), strBrowser,
				strLanguage, strGroupName,method);			
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
