package ca.fido.test.listeners;
import com.relevantcodes.extentreports.LogStatus;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;
import extentreport.ExtentManager;
import extentreport.ExtentTestManager;
import extentreport.FileUpload;
import extentreport.SendEmail;
import utils.SauceLabsUtils;

import java.io.IOException;
import java.util.HashMap;
import javax.mail.MessagingException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class TestListener extends BaseTestClass implements ITestListener , ISuiteListener, IInvokedMethodListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	} 

	//Before starting all tests, below method runs.
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println(" in onStart test " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.getDriver());
	}

	// After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println(" in onFinish method " + iTestContext.getName());
		// Do tier down operations for extentreports reporting! 		
		ExtentTestManager.endTest();			
		ExtentManager.getReporter().flush();

	} 

	@Override
	public void onTestStart(ITestResult iTestResult) {
		String sauceSessionId;
		System.out.println(" in onTestStart method " +  getTestMethodName(iTestResult) + " start");
		//Start operation for extentreports.
		String fullTestClassName[] = iTestResult.getMethod().getTestClass().getName().split("\\.");
		//Get XMLTest Parameters from BaseTest and assign to local webdriver variable.
		Object xmlTestParams = iTestResult.getInstance();
		HashMap<String, String> xmlTestParameters = ((BaseTestClass) xmlTestParams).getXMLParameters();
		String testClassName = fullTestClassName[fullTestClassName.length-1] +"_" + xmlTestParameters.get("strBrowser") +"_" + xmlTestParameters.get("strLanguage").toUpperCase();
		if(xmlTestParameters.get("strExecutionType") != null) {
			testClassName += "_"+xmlTestParameters.get("strExecutionType");
		}
		ExtentTestManager.startTest(testClassName,iTestResult.getName());	
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTestClass) testClass).getDriver(); 
		if(xmlTestParameters.get("strBrowser").contains("sauce")) {
			((JavascriptExecutor)driver).executeScript("sauce:job-name="+getTestMethodName(iTestResult));
			sauceSessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
			String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sauceSessionId, getTestMethodName(iTestResult));
			System.out.println(message);
			String[] strLinks = SauceLabsUtils.getSauceJobLinks(sauceSessionId);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Video Started", "<iframe width=\"597\" height=\"448\" src=\""+ strLinks[0] +"&width=597&height=448\">\r\n" + 
					"</iframe>");
			ExtentTestManager.getTest().log(LogStatus.INFO, "", "<a href='"+ strLinks[1] +"' target='_blank'>Click here for Detailed SauceLabs report</a>");
		}
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		try {
			System.out.println(" in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
			//Extentreports log operation for passed tests.
			Object testClass = iTestResult.getInstance();
			WebDriver driver = ((BaseTestClass) testClass).getDriver();        
			HashMap<String, String> xmlTestParameters = ((BaseTestClass) testClass).getXMLParameters();
			if(xmlTestParameters.get("strBrowser").contains("sauce"))
			{
				((JavascriptExecutor) driver).executeScript("sauce:job-result=" + "passed");
			}      
		} finally {		//Added finally block So that it will update the extent report without any issues irrespective of the whether the try block will execute with any exception or not
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed"); 
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println(" in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");

		//Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();
		String base64Screenshot="";
		WebDriver webDriver = null;
		try {        		        
			webDriver = ((BaseTestClass) testClass).getDriver();
			Object xmlTestParams = iTestResult.getInstance();
			HashMap<String, String> xmlTestParameters = ((BaseTestClass) xmlTestParams).getXMLParameters();
			if(xmlTestParameters.get("strBrowser").contains("sauce"))
			{
				((JavascriptExecutor) webDriver).executeScript("sauce:job-result=" + "failed");
			}
			//Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		finally {				//Added finally block So that it will update the extent report without any issues irrespective of the whether the try block will execute with any exception or not
			if(!base64Screenshot.isEmpty()) {
				//Extentreports log and screenshot operations for failed tests.
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ "Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}	
			}else {
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed : " + iTestResult.getName(),
							"Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}	
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {   
		System.out.println(" in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");

		// Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();
		WebDriver webDriver = null; 
		String base64Screenshot = "";
		try {
			webDriver = ((BaseTestClass) testClass).getDriver();
			Object xmlTestParams = iTestResult.getInstance();
			HashMap<String, String> xmlTestParameters = ((BaseTestClass) xmlTestParams).getXMLParameters();
			if(xmlTestParameters.get("strBrowser").contains("sauce"))
			{
				((JavascriptExecutor) webDriver).executeScript("sauce:job-result=" + "skipped");
			}
			// Take base64Screenshot screenshot.
			base64Screenshot = "data:image/png;base64,"+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {				//Added finally block So that it will update the extent report without any issues irrespective of the whether the try block will execute with any exception or not
			if(!base64Screenshot.isEmpty()) {
				// Extentreports log operation for skipped tests.
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)
							+ "Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}
			}else {
				if(iTestResult.getThrowable().getMessage().startsWith("Custom Exception")) {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;")+"\"");
				}else {
					ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case " + "\""+  iTestResult.getName()+"\"" + " has Skipped for re-execution" ,
							"Exception occured: " + iTestResult.getThrowable().getMessage().split("Build")[0].replace("<", "&lt;").replace("\"", ""));
				}
			}

		}
	} 



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}


	/**
	 * This listener method is invoked before a method is invoked by TestNG
	 */
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	/**
	 * This listener method is invoked after a method is invoked by TestNG
	 */
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if(testResult.getMethod().isTest()) {
			if(testResult.getStatus() == ITestResult.SUCCESS) {
				if(ExtentTestManager.getFailFlag()) {
					Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
					Reporter.getCurrentTestResult().setThrowable(new AssertionError("Assertion Failed"));
				}
			}
		}
	}


	@Override
	public void onStart(ISuite suite) {	 
		TestDataHandler.dataInit(suite.getName());
		System.out.println("Data File Initialized");
	}

	@Override
	public void onFinish(ISuite suite) {


		try {

			String strResPath= FileUpload.extentReportsUpload();
			SendEmail.sendEmail(suite.getName(), strResPath);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
