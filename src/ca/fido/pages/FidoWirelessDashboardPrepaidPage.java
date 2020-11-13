package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class have all the pre paid wireless Dashboard page elements and corresponding methods which are used in test cases.
 * Web elements and corresponding method will be added continuously according to test cases needs.
 * @author Mirza.Kamran
 *
 */
public class FidoWirelessDashboardPrepaidPage extends BasePageClass {

	public FidoWirelessDashboardPrepaidPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//div[@class='item content']")
	WebElement divCtnBadge;
	
	@FindBy(xpath = "//div[@class='usage-dial']//span[@translate='wireless.label.data' and @class='txt']")
	WebElement divData;	

	@FindBy(xpath = "//div[@class='usage-dial']//span[@translate='wireless.label.talk' and @class='txt']")
	WebElement divTalk;
	
	@FindBy(xpath = "//div[@class='usage-dial']//span[@translate='wireless.label.text' and @class='txt']")
	WebElement divText;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.myPlan']")
	WebElement lblMyPlan;
	
	@FindBy(xpath = "//ins[@translate='global.label.myDevice']")
	WebElement lblMyDevice;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.myBalance']")
	WebElement lblMyBalance;
		
	@FindBy(xpath = "//div[@class='ute-dashboard-mydevice-sub-heading']")
	WebElement lblMyDeviceName;

	@FindBy(xpath="//div[@class='row ute-dashboard-services-header-content']//ins[@translate='wireless.label.approx']/ancestor::div[contains(@class,'ute-my-balance-approx')]//preceding-sibling::div//div[@class='dollar-amount']")
	WebElement divMyBalanceCurrenyAmount;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.approx']")
	WebElement divMyBalanceApprox;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.approx']/ancestor::div[contains(@class,'ute-my-balance-approx')]/following-sibling::div[contains(@class,'ute-my-balance-expires')]")
	WebElement divMyBalanceExpiresOn;
	
	@FindBy(xpath = "//div[contains(@class,'ute-my-balance-auto-refill')]")
	WebElement divMyBalanceScheduleAutomaticRefills;
	
	@FindBy(xpath = "//div[@ng-show='autoRefillSubscriptionInfo.autoRefillBalance.registeredFlag']//a//ins[@translate='global.cta.change']")
	WebElement btnChangeAutoRefills;
	
	@FindBy(xpath = "//div[@ng-show='autoRefillSubscriptionInfo.autoPayPlan.registeredFlag || autoRefillSubscriptionInfo.autoRefillBalance.registeredFlag']//a//button//ins[@translate='global.cta.refillNow']")
	WebElement btnMyBalanceRefillNow;
	
	@FindBy(xpath = "//div[contains(@class,'ute-dashboard-service-sub-heading')]")
	WebElement lblMyPlanName;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.features']")
	WebElement lblMyPlanFeatures;
	
	@FindBy(xpath = "//ins[@translate='wireless.label.features']/ancestor::div[@class='row']")
	WebElement divMyPlanFeaturesSections;

	@FindBy(xpath = "//ins[@translate='wireless.label.myExtras']")
	WebElement lblMyPlanExtras;

	@FindBy(xpath = "//ins[@translate='wireless.message.theEstimatedValuesBelowDoNotIncludeDiscountsAndCredits']")
	WebElement lblMyPlanExtimatedValuesCaution;
	
	@FindBy(xpath = "//select[@name='selectedCTN']/parent::div/following-sibling::div//ins[@translate='global.cta.changeNumber']")
	WebElement lnkChangeMyNumber;

	@FindBy(xpath = "//select[@name='selectedCTN']")
	WebElement cboSelectedCTN;
			
	@FindBy (xpath = "//ins[@translate='global.cta.reportLostStolenPhone']/parent::a")
	WebElement lnkReportLostOrStolen;
	
	@FindBy (xpath = "//button[@class='ute-btn-primary hidden-xs']")
	WebElement btnReactivateDevice;

	@FindBy(xpath = "//ins[@translate='global.cta.shopForAccessories']")
	WebElement lnkShopForAccessories;
	
	@FindBy(xpath = "//a[@href='#/my-account/retrievePUK']")
	WebElement lnkRetreivePUKCode;
	
	@FindBy(xpath = "//img[@class='close-btn']")
	WebElement btnCloseMonthlyAddOnOverLay;
	
	@FindBy(xpath="//div[contains(@class,'wireless-dashboard')]/div[contains(@class,'wireless-title')]")
	WebElement lblMobileDashboardTitle;
	
	@FindBy(xpath="//ins[@translate='wireless.dashboard.quickActions.quickActions08']")
	WebElement lnkRepairMobile;

	@FindBy(xpath = "//a[@translate='global.cta.continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h2[@translate='wireless.dashboard.quickActions.trackRepairClaim.heading']")
	WebElement lblGetHelpForYourPhoneOverlay;
	
	/**
	 * Click on the link report lost or stolen.
	 * @author Ning.Xue
	 */
	public void clkLnkReportLostOrStolen() {

		reusableActions.getWhenVisible(lnkReportLostOrStolen, 30).click();
	}
	
	/**
	 * Check if there has ReactivateMyDevice button in wireless dash board page.
	 * @return true if service suspended else false
	 * @author Ning.Xue
	 */
	public Boolean isServiceSuspended() {
		return reusableActions.isElementVisible(btnReactivateDevice, 60);
	}
	
	/**
	 * Click on ReactivateMyDevice button in wireless dash board page.
	 * @author Ning.Xue
	 */
	public void clkBtnReactivateDevice() {

		reusableActions.getWhenVisible(btnReactivateDevice, 30).click();
	}
	
	/***
	 * This method will validate the Data dashboard details
	 * @return boolean value based on verification 
	 * @author Mirza.Kamran
	 */
	public Boolean verifyDataDashboardIsDisplayed() {
		
		return  reusableActions.isElementVisible(divData);
		
	}
	
	/***
	 * This method will validate the Talk dashboard details
	 * @return boolean value based on verification 
	 * @author Mirza.Kamran
	 */
	public Boolean verifyTalkDashboardDetails() {
		
		return  reusableActions.isElementVisible(divTalk);
	}	
	
	/**
	 * This method will validate the Text dashboard details
	 * @return boolean value based on verification 
	 * @author Mirza.Kamran
	 */
	public Boolean verifyTextDashboardDetails() {
		
		return  reusableActions.isElementVisible(divText);
	}
	
		
	/**
	 * This method will verify the My balance details section
	 * @return true if the My balance label displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelMyBalanceIsdisplayed() {
		return reusableActions.isElementVisible(lblMyBalance);
	}
	
	/**
	 * This method will verify the My balance currency amount details section
	 * @return true if the My balance currency amount label displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyBalanceCurrencyAmountIsdisplayed() {
		return reusableActions.isElementVisible(divMyBalanceCurrenyAmount);
	}
	
	/**
	 * This method will verify the My balance approx div is displayed in details section
	 * @return true if the My balance approx label displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyBalanceApproxIsDisplayed() {
		return reusableActions.isElementVisible(divMyBalanceApprox);
	}
	
	/**
	 * This method will verify the My balance expires On details section
	 * @return true if the My balance expires On label displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyBalanceExpiresOnIsDisplayed() {
		return reusableActions.isElementVisible(divMyBalanceExpiresOn);
	}
	
	/**
	 * This method will verify the My balance schedule Automatically refill details section
	 * @return true if the My balance schedule automatic refills label displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyBalanceScheduleAutomaticRefillsIsDisplayed() {
		return reusableActions.isElementVisible(divMyBalanceScheduleAutomaticRefills);
	}
	
	/**
	 * This method will verify button change auto refills is displayed in My balance details section
	 * @return true if button change auto refills is displayed in the My balance displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyButtonChangeAutoRefillsIsDisplayed() {
		return reusableActions.isElementVisible(btnChangeAutoRefills);
	}
	
	/**
	 * This method will verify the button My balance refill now is displayed in the details section
	 * @return true if the button My balance refill now displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyButtonMybalanceRefillNowIsDisplayed() {
		return reusableActions.isElementVisible(btnMyBalanceRefillNow);
	}
	

	/**
	 * This will check if the My Plan label is displayed
	 * @return true of the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelMyPlanIsDisplayed() {
		return reusableActions.isElementVisible(lblMyPlan);
	}
	
	/**
	 * This will check if the My Plan name label is displayed
	 * @return true of the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelMyPlanNameIsDisplayed() {
		return reusableActions.isElementVisible(lblMyPlanName);
	}
	
	/**
	 * This will check if the My Plan Features label is displayed
	 * @return true of the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelMyPlanfeaturesIsDisplayed() {
		return reusableActions.isElementVisible(lblMyPlanFeatures);
	}
	
	/**
	 * This will check if the My Plan extras label is displayed
	 * @return true of the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelMyPlanExtrasIsDisplayed() {
		return reusableActions.isElementVisible(lblMyPlanExtras);
	}
	
	/**
	 * This will check if the My Plan estimated values label is displayed
	 * @return true of the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLabelMyPlanEstimatedValuesIsDisplayed() {
		return reusableActions.isElementVisible(lblMyPlanExtimatedValuesCaution);
	}
	
	
	/**
	 * This method will verify the Device details section
	 * @return returns boolean
	 * @author Mirza.Kamran
	 */
	public Boolean verifyMyDeviceDetails() {
		
		Boolean match = false;	
		reusableActions.waitForElementVisibility(lblMyDevice, 10);
		reusableActions.javascriptScrollByVisibleElement(lblMyDevice);
		reusableActions.staticWait(2000);
		//reusableActions.javascriptScrollScrollByVisibleElement(driver.findElement(By.partialLinkText("Retrieve PUK Code")));

		if(reusableActions.isElementVisible(lblMyDevice,60)
		   && reusableActions.isElementVisible(lblMyDeviceName,60)) 
		{					
			match=true;
		}else
		{
			match=false;
		}
		
		  return match;
	}
	
	
	/**
	 * This method will validate the links if they are valid or not 
	 * @param element parameter for passing link text
	 * @return boolean return value based on validation
	 * @author Mirza.Kamran
	 */
	public Boolean verifyifLinkIsValid(WebElement element)
    {     	
	     String url = "";
	     HttpURLConnection huc = null;
	     int respCode = 200;
	     Boolean validated=false;             
             
         url = element.getAttribute("href");        
         System.out.println(url);
     
         if(url == null || url.isEmpty()){
         System.out.println("URL is either not configured for anchor tag or it is empty");         
         }
             
         url=url.replace("https", "http");
         try {
             huc = (HttpURLConnection)(new URL(url).openConnection());
             
             huc.setRequestMethod("HEAD");
             
             huc.connect();
             
             respCode = huc.getResponseCode();
             
             if(respCode >= 400){
                 System.out.println(url+" is a broken link");
                 validated=false;
             }
             else{
            	 validated=true;
             }
                 System.out.println(url+" is a valid link");
             }
                 
         catch (MalformedURLException e) {
        	 validated=false;
             e.printStackTrace();
         } catch (IOException e) {
        	 validated=false;            
             e.printStackTrace();
         }
         System.out.print("link valid"); 
         return validated;
    }

	/**
	 * This method will click on link and validate if the links are correct and new window is open 
	 * @param elementLink The link name as visible on UI 
	 * @param strNewWindowTitleEn The title oe new window after the link is click in english
	 * @param strNewWindowTitleFrench The title on new window after the link is click in french
	 * @return boolean value
	 * @author Mirza.Kamran
	 */
	public boolean clickAndVerifyLinkForNewWindow(WebElement elementLink, String strNewWindowTitleEn,String strNewWindowTitleFrench) {		
		
		String parentHandle=driver.getWindowHandle();
		//WebElement lnk=driver.findElement(By.partialLinkText(strLinkText));
		reusableActions.waitForElementVisibility(elementLink);
		reusableActions.scrollToElementAndClick(elementLink);
		//reusableActions.moveToElementAndClick(lnk,10);
		reusableActions.waitForPageLoad();
		reusableActions.waitForNumberOfWindowsToBe(2,10);
		reusableActions.staticWait(5000);
		if(!(driver.getWindowHandles().size()>1))
		{
			reusableActions.executeJavaScriptClick(elementLink);
			reusableActions.waitForPageLoad();
			reusableActions.waitForNumberOfWindowsToBe(2,10);
			reusableActions.staticWait(5000);
		}
		reusableActions.switchToNewWindow(parentHandle);
		reusableActions.staticWait(5000);
		if(driver.getTitle().trim().toLowerCase().equals(strNewWindowTitleEn.trim().toLowerCase())
		|| driver.getTitle().trim().toLowerCase().equals(strNewWindowTitleFrench.trim().toLowerCase())
		|| driver.getCurrentUrl().trim().toLowerCase().contains(strNewWindowTitleFrench.trim().toLowerCase()))
		{
			reusableActions.closeCurrentWindow();
			reusableActions.staticWait(2000);
			reusableActions.switchToMainWindow(parentHandle);
			return true;
		}else
		{
			return false;
		}			
	}
	
	/**
	 * Check if the Shop for accessories link is valid
	 * @return true if the link is valid else fals
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkShopForAccessoriesIsValid() {		
		return clickAndVerifyLinkForNewWindow(lnkShopForAccessories,"Accessories | Fido","Phones");
	}
	
	/**
	 * This method will validate if the given link exist on the page
	 * @param strLinkName Link name 
	 * @return boolean value
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLinkExists(String strLinkName) {
		return reusableActions.isElementVisible(By.partialLinkText(strLinkName));
	}

	/**
	 * Check if the link Lost and found is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkReportLostOrStolenIsDisplayed() {
		return reusableActions.isElementVisible(lnkReportLostOrStolen);
	}
	
	/**
	 * Check if the link Shop for accessories is displayed
	 * @return true when the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkShopForAccessoriesIsDisplayed() {
		return reusableActions.isElementVisible(lnkShopForAccessories);
	}
	
	/**
	 * Check if the link Retreive PUK code is is displayed
	 * @return true when the link is displayed, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRetrievePUKCodeIsDisplayed() {
		return reusableActions.isElementVisible(lnkRetreivePUKCode);
	}
	
	/**
	 * This method will perform click on defualt CTN badge
	 * @author Mirza.Kamran
	 */
	public void clkCtnBadge() {

		reusableActions.getWhenVisible(divCtnBadge, 30).click();
	}
	
	
	/**
	 * This method will fetch the existing CTN value
	 * @return string value with CTN number
	 * @author Mirza.Kamran
	 */
	public String getTheExistingCTN() {
		
		return reusableActions.getWhenReady(cboSelectedCTN).getText();		
	}
	
	/**
	 * This method with click on the Change CTN link
	 * @author Mirza.Kamran
	 */
	public void clickChangeCTN() {
		reusableActions.clickWhenReady(lnkChangeMyNumber);
	}
	
	/** 
	 * Checks if the lost or stolen link is valid
	 * @return true if the link is not broken or invalid else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkLostAndStolenIsValid() {
		return verifyifLinkIsValid(lnkReportLostOrStolen);
	}
	
	/**
	 * Check if the link retrieve PUK code is valid
	 * @return true when the link is link is not broken or invalid  else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRetreivePUKCode() {
		return reusableActions.isElementVisible(lnkRetreivePUKCode);
	}

	/**
	 * This will scroll to middle of page
	 * @author Mirza.Kamran
	 */
	public void scrollToMiddleOfPage() {
		reusableActions.javascriptScrollToMiddleOfPage();
		
	}

	/**
	 * Scroll to bottom of page
	 * @author Mirza.Kamran
	 */
	public void scrolltoBottomOfPage() {
		reusableActions.javascriptScrollToBottomOfPage();		
	}
	
	/**
	 * Verify link repair device is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLinkRepairMyDeviceIsDisplayed() {
		return reusableActions.isElementVisible(lnkRepairMobile);
	}
	
	/**
	 * Clicks on Repair device link
	 * @author Mirza.Kamran
	 */
	public void clkRepairDeviceLink() {
		reusableActions.clickWhenReady(lnkRepairMobile);
	}
	
	
	/**
	 * Verify Overlay for repair device is displayed
	 * @return true if the overlay is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyOverlayForRepairDeviceIsDisplayed() {
		return reusableActions.isElementVisible(lblGetHelpForYourPhoneOverlay,60);
	}
	
	/**
	 * Clicks on the button continue on repair device overlay
	 * @return returns current window handle
	 * @author Mirza.Kamran
	 */
	public String clkButtonContinueOnRepairDeviceOverlay() {
		String strCurrenthandle = driver.getWindowHandle();
		reusableActions.clickWhenReady(btnContinue);
		return strCurrenthandle;
	}
	
	/**
	 * Verifies if the Bright Star new tab and url match
	 * @param strParentWindowHandle Window handle of parent 
	 * @param strURL URL of brightstar
	 * @return true if the new tab is open and url matches
	 * @author Mirza.Kamran
	 */
	public boolean verifyBrightStarNewTabAndURL(String strParentWindowHandle, String strURL) {
		reusableActions.waitForNumberOfWindowsToBe(2, 60);
		reusableActions.switchToNewWindow(strParentWindowHandle);
		return (driver.getCurrentUrl().trim().contains(strURL.trim())
				|| strURL.contains(driver.getCurrentUrl().trim()));
		
	}
}
