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
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;

/**
 * This test case got a notice that Facebook login will no longer available in July, 2019!!!
 * So it may not be use after July.
 * @author ning.xue
 *
 */
public class FidoSS_Sanity_TC_01_AnonymousUserSignWithFacebookLogin extends BaseTestClass{

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
	public void userSignWithFacebookLogin() {
		fido_home_page.clkLogin();
		fido_login_page.clkLoginWithFb();
		if (fido_loginto_facebook_page.isContinueBtnPresent()) {
			fido_loginto_facebook_page.clkBtnContinueToFacebook();	
		}		
		Assert.assertTrue(fido_loginto_facebook_page.verifyFacebookPage());
	}

}
