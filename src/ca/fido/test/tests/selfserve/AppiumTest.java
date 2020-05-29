package ca.fido.test.tests.selfserve;

import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
 
import io.appium.java_client.remote.MobileCapabilityType;
 
public class AppiumTest {
  @Test
  public void f() throws MalformedURLException {
        
      
         WebDriver driver; 
         DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
         capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
         capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_29");
         capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
         capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
         capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15000);
         driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         driver.get("https://www.rogers.com");
         driver.quit();
  }
}
 