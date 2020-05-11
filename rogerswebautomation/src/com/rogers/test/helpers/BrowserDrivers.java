package com.rogers.test.helpers;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.rogers.test.helpers.RogersEnums.OS;
import com.rogers.testdatamanagement.TestDataHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDrivers {


    private static OS os = null;
    private WebDriver driver;

	/*
	 * To initiate the driver
	 * @param strBrowser                 string of browser name
	 * @param currentTestMethodName 
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	public WebDriver driverInit(String strBrowser, Method currentTestMethodName, String strGroupName) throws ClientProtocolException, IOException {
	    os=getOS();
		switch(strBrowser.toLowerCase().trim()) {			
		case "firefox":				
			firefoxInit(strBrowser); 
			break;	
			
		case "headlesschrome":
			headlesschromeInit(strBrowser);
         break;            

		case "remoteFirefox":
			remoteFirefoxInit(strBrowser);
			break;
							
		case "chrome":	
			chromeInit(strBrowser, strGroupName);
		    break;
			
		case "remotechrome":
			remoteChromeInit(strBrowser);
			break; 
			
		case "msEdge":
			msEdgeInit(strBrowser);
	        break;    
			
		 case "saucechrome" :
	     {    
	    	 sauceInit("chrome",currentTestMethodName);	    	         
	      break;
	     }
		 case "saucefirefox" :
	     {    
	    	 sauceInit("firefox",currentTestMethodName);	    	         
	      break;
	     }
	     
		 case "sauceedge" :
	     {    
	    	 sauceInit("microsoftedge",currentTestMethodName);	    	         
	      break;
	     }
		 

		default :
			WebDriverManager.chromedriver().setup();
			setDriver(new FirefoxDriver());
		}
		
		return driver;
	}

	
	
	



	


	
	
	/**
	 * To initiate the firefox driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void firefoxInit(String strBrowser) throws ClientProtocolException, IOException {		
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions  mfOptions = new FirefoxOptions();
			mfOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			setDriver(new FirefoxDriver(mfOptions)); 				
	}
	
	/**
	 * To initiate the headless Chrome driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void headlesschromeInit(String strBrowser) throws ClientProtocolException, IOException {
         DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
         URL url1 = new URL("http://localhost:4444/wd/hub");
         driver = new RemoteWebDriver(url1,capabilities1);         
	}
	
	/**
	 * To initiate the remote Firefox driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void remoteFirefoxInit(String strBrowser) throws ClientProtocolException, IOException {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions  rmfOptions = new FirefoxOptions();			
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setPlatform(Platform.WINDOWS);
		    capabilities.setBrowserName("firefox");	
		    rmfOptions.merge(capabilities);
			driver = new RemoteWebDriver(new URL("http://10.18.97.209:4444/wd/hub"),rmfOptions );
			setDriver(driver);		
	}
	
	/**
	 * To initiate the Chrome driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void chromeInit(String strBrowser, String strGroupName) throws ClientProtocolException, IOException {
			//WebDriverManager.chromedriver().setup();		
			WebDriverManager.chromedriver().version("79.0.3945.36").setup();
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.addArguments("disable-infobars");
			if (strGroupName.equalsIgnoreCase("selfserve_login")) {
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
			}	
		    setDriver(new ChromeDriver(options));    
	}
	
	/**
	 * To initiate the remote Chrome driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void remoteChromeInit(String strBrowser) throws ClientProtocolException, IOException {
			ChromeOptions rcrOptions = new ChromeOptions();
			// rcrOptions.addArguments("--start-maximized");
			rcrOptions.addArguments("--kiosk");
			rcrOptions.addArguments("--incognito");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setPlatform(Platform.WINDOWS);
			capability.setBrowserName("chrome");
			capability.setCapability(ChromeOptions.CAPABILITY, rcrOptions);
			driver = new RemoteWebDriver(new URL("http://10.18.97.209:4444/wd/hub"), capability);
			setDriver(driver);		
	}
	
	/**
	 * To initiate the edge driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void msEdgeInit(String strBrowser) throws ClientProtocolException, IOException {
			System.setProperty("webdriver.edge.driver","C:\\Users\\chinnarao.vattam\\Downloads\\edgedriver_win32\\msedgedriver.exe");
	    	ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Beta\\Application\\msedge.exe");
	        EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
	        driver = new EdgeDriver(edgeOptions);	     
	}
	
	/**
	 * To initiate the sauce driver
	 * @param strBrowser                 string of browser name
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	private void sauceInit(String strBrowserName,Method currentTestMethodName) throws ClientProtocolException, IOException {
		   
		   String sauceUserName = System.getenv("SAUCE_USERNAME");// TestDataHandler.sauceSettings.getSauceUser();
	       String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");// TestDataHandler.sauceSettings.getSauceKey();       
	       String sauceURL = "https://ondemand.saucelabs.com/wd/hub";       
	       MutableCapabilities sauceOpts = new MutableCapabilities();
	       sauceOpts.setCapability("username", sauceUserName);
	       sauceOpts.setCapability("accessKey", sauceAccessKey);
	       sauceOpts.setCapability("seleniumVersion", TestDataHandler.sauceSettings.getSauceOptions().getSeleniumVersion());
	       sauceOpts.setCapability("name", currentTestMethodName.getName());	                               
	       sauceOpts.setCapability("maxDuration", TestDataHandler.sauceSettings.getSauceOptions().getMaxDuration());               
	       sauceOpts.setCapability("commandTimeout", TestDataHandler.sauceSettings.getSauceOptions().getCommandTimeout());
	       sauceOpts.setCapability("idleTimeout", TestDataHandler.sauceSettings.getSauceOptions().getIdleTimeout());       
	       sauceOpts.setCapability("build", TestDataHandler.sauceSettings.getSauceOptions().getBuild());  
		   sauceOpts.setCapability("browserName", strBrowserName);
		   switch (strBrowserName.toLowerCase()) {
			case "chrome":							    
			     sauceOpts.setCapability("browserVersion", TestDataHandler.sauceSettings.getMutableChromeCapabilities().getBrowserVersion());  				       
			     sauceOpts.setCapability("platformVersion", TestDataHandler.sauceSettings.getMutableChromeCapabilities().getPlatformVersion());
				break;
			case "firefox":
				 sauceOpts.setCapability("browserVersion", TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getBrowserVersion());  				       
			     sauceOpts.setCapability("platformVersion", TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getPlatformVersion());		
				break;
			case "microsoftedge":
				 sauceOpts.setCapability("browserVersion", TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getBrowserVersion());  				       
			     sauceOpts.setCapability("platformVersion", TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getPlatformVersion());
				break;
		
		}
		             
	       driver = new RemoteWebDriver(new URL(sauceURL), sauceOpts);	       	       	      
	}
	
	
	
	/**
	 * gets the OS type
	 * @return enum containing OS value
	 * @author Mirza.Kamran
	 */
	  public static OS getOS() {
	        if (os == null) {
	            String operSys = System.getProperty("os.name").toLowerCase();
	            if (operSys.contains("win")) {
	                os = OS.WIN;
	            } else if (operSys.contains("nix") || operSys.contains("nux")
	                    || operSys.contains("aix")) {
	                os = OS.LIN;
	            } else if (operSys.contains("mac")) {
	                os = OS.MAC;
	            }
	        }
	        return os;
	    }
	
	

	/**
	 * This method will set up the browser stack
	 * @author Mirza.Kamran
	 * @throws MalformedURLException 
	 */
	public void setupBrowserStack(String strTestName) throws MalformedURLException {
		  String username = "ning28";
		  String automateKey = "pgaiJjgQMZERUe51d4ky";
		  String url = "https://" + username + ":" + automateKey + "@hub-cloud.browserstack.com/wd/hub";		  
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "77.0");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("project", "Self-Serve Test");
		    caps.setCapability("name", strTestName);
		    caps.setCapability("browserstack.local", "true");
		    caps.setCapability("browserstack.console", "verbose");
		    caps.setCapability("browserstack.debug", "true");
		    caps.setCapability("idleTimeout", "200");
		    caps.setCapability("browserstack.networkLogs", "true");
		    driver = new RemoteWebDriver(new URL(url), caps);
		    driver.manage().window().maximize();
		
	}
	
	/**
	 * BrowserStack REST API to access and update information about test.
	 * @param strStatus
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void mark(String strStatus) throws ClientProtocolException, IOException, URISyntaxException  {
		  URI uri = new URI("https://ning28:pgaiJjgQMZERUe51d4ky@api.browserstack.com/automate/sessions/"
		  			+ ((RemoteWebDriver)driver).getSessionId() + ".json");
		  HttpPut putRequest = new HttpPut(uri);
		  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add((new BasicNameValuePair("status", strStatus)));
		  nameValuePairs.add((new BasicNameValuePair("reason", "")));
		  putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		  HttpClientBuilder.create().build().execute(putRequest);
		}
	
	/**
	 * To set the web driver
	 * @param driver WebDriver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
}
