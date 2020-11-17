package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class FidoSS_Regression_TC032_ValidateAutoRegistrationPostpaid extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,
				strLanguage, FidoEnums.GroupName.selfserve_login,method);			
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"Autoregister"})
	public void validateUserChangeContactInformationAndBillingAddress() throws IOException {
		//String strURI = System.getProperty("test_URIautoRegister");
		//reporter.reportLog("URI:"+strURI);
		String strEmail = "";
		String strPassword = "";
		String strBan ="";
		//================= Email reminder code
		this.autoregisterUser("http://rdqa5.service.fido.ca/selfserve/FidoServices/AutoRegistrationService",strEmail,strBan);
		    
		 
		//Will open a new tab for ENS, to get verification code from ENS		
				reporter.reportLogWithScreenshot("ENS");
				try {
					ensVerifications.getEmailVerifyPage(strEmail);
					fido_set_password_page.clkBtnSetPasswordInEmail();
					//Another new page opened
					fido_set_password_page.switchToSetPasswordTab(3);
					fido_set_password_page.setPassword(strPassword);
					fido_set_password_page.setConfirmPassword(strPassword);
					reporter.reportLogWithScreenshot("Set password page.");
					fido_set_password_page.clkBtnSetPassword();
					reporter.hardAssert(fido_set_password_page.verifyMsgReigistrationCompleteIsDisplayed(),
							"Registration completed message displayed",
							"Registration completed message does Not displayed");
					reporter.reportLogWithScreenshot("Set password completed.");
					
				} catch (ClientProtocolException e) {
					reporter.reportLogWithScreenshot(e.getMessage());
				} catch (IOException e) {
					reporter.reportLogWithScreenshot(e.getMessage());
				}
				fido_set_password_page.clkBtnGotoOverview();
				reporter.hardAssert(fido_account_overview_page.verifyEmailInSignInAsLink(strEmail),
						"Registered email matches the name in Sign In As",
						"Registered email doesn't match the name in Sign In As");
				reporter.hardAssert(fido_account_overview_page.verifySuccessfulLogin(),
						"Registration success, login success.",
						"Didn't successfully login.");
				reporter.reportLogWithScreenshot("Account overview page");
			}
	
		public void autoregisterUser(String strURI, String strEmail,String strBan) throws IOException {
			InputStream inputStream;
	
				inputStream = new FileInputStream(
						new File(System.getProperty("user.dir") + "/test-data/fido/selfserve/SoapRequestFile.xml"));
				
			
			//FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/fido/selfserve/SoapRequestFile.xml"));
	         RestAssured.baseURI="http://rdqa5.service.fido.ca/selfserve/FidoServices/AutoRegistrationService";	      
	        
	         Response response = RestAssured.given()				
	        	.header("Content-Type", "text/xml")
			    .and().header("SOAPAction", "findSoapAction")			    					 
				.body(IOUtils.toString(inputStream,"UTF-8"))
				.when()
	            .post("/converter.asmx");
	            //.then()
	            //.statusCode(200)
	            //.and()
	            //.log().all()
	            //.extract().response();
	           int statusCode = response.getStatusCode();
				reporter.reportLog("Response:"+statusCode);
				reporter.reportLog("BODY:"+inputStream.toString());

	        XmlPath jsXpath= new XmlPath(response.asString());//Converting string into xml path to assert
	        String rate=jsXpath.getString("GetConversionRateResult");
	        System.out.println("rate returned is: " +  rate);
		}
		
	

}
