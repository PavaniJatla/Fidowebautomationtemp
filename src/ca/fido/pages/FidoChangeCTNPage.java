package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;



/**
 * This class have all the pre paid wireless Dashboard page elements and corresponding methods which are used in test cases.
 * Web elements and corresponding method will be added continuously according to test cases needs.
 * @author Mirza.Kamran
 *
 */
public class FidoChangeCTNPage extends BasePageClass {

	public FidoChangeCTNPage(WebDriver driver) {
		super(driver);
	}

	@FindAll({
			@FindBy(xpath = "//h1[@class='text-title-1 ng-star-inserted']"),
			@FindBy(xpath = "//ins[@translate='wireless.label.changePhoneNumberHeading']")
	})
	WebElement lblChangeMyNumberHeader;

	@FindAll({
			@FindBy(xpath = "//p[text()=' Keep in mind: ']"),
			@FindBy(xpath = "//ins[@translate='global.message.changeCtnKeepinMind']")
	})
	WebElement lblKeepInMind;
	
	@FindBy(xpath = "//ins[@translate='global.message.changeCtnBannerLine1']")
	WebElement lblChangeCTNBannerLineOne;
	
	@FindBy(xpath = "//ins[@translate='global.message.changeCtnBannerLine2']")
	WebElement lblChangeCTNBannerLineTwo;

	@FindAll({
			@FindBy(xpath = "//select[@id='province']"),
			@FindBy(xpath = "//select[@ng-model='data.provinceSelected']")
	})
	WebElement cboProvince;

	@FindAll({
			@FindBy(xpath = "//select[@title='select city']"),
			@FindBy(xpath = "//select[@name='cityName']")
	})
	WebElement cboCity;

	@FindAll({
			@FindBy(xpath = "//span[contains(text(),' Find available numbers ')]"),
			@FindBy(xpath = "//ins[@translate='wireless.label.findAvailableNumber']")
	})
	WebElement btnFindAvailableNumber;

	@FindAll({
			@FindBy(xpath = "//h1[text()='Pick a new number.']"),
			@FindBy(xpath = "//ins[@translate='global.label.pickNewNumberHeadingRevamp']")
	})
	WebElement lblPickupNewNumberHeader;
	
	@FindBy(xpath = "//ins[@translate=\"wireless.message.refreshMessageAlt\"]")
	WebElement lblBannerText;	
	

	@FindBy(xpath = "//ins[@translate='global.message.changeCtnKeepinMind']")
	WebElement lblkeepInMindBanner;

	@FindAll({
			@FindBy(xpath = "//div[contains(@class,'number-list-container')]"),
			@FindBy(xpath = "//div[@class='row phone-list-new']")
	})
	WebElement divNewNumberList;
	
	@FindBy(xpath = "//input[@name='phoneNumber']/parent::div/label")
	WebElement rdoNewPhoneNumberList;

	@FindAll({
			@FindBy(xpath = "//a[@title='Select number' or @title='Veuillez choisir un numéro']"),
			@FindBy(xpath = "//ins[@translate='global.cta.cancel']/parent::a/parent::div/preceding-sibling::div//input[@value='select number' or @value='Veuillez choisir un numéro']")
	})
	WebElement btnSelectNumber;

	@FindAll({
	@FindBy(xpath = "//h1[text()='Review your new number.']"),
	@FindBy(xpath = "//ins[@translate='global.label.reviewNewNumber']")
	})
	WebElement lblReviewNumberHeader;

	@FindAll({
			@FindBy(xpath = "//h2"),
			@FindBy(xpath = "//ins[@translate='global.label.reviewPhoneNumberDescriptionNew']")
	})
	WebElement lblReviewPhoneNumberDescriptionNew;

	@FindBy(xpath = "//ins[@translate='global.message.rememberMsg']")
	WebElement lblRememberMessage;
	
	@FindBy(xpath = "//span[@class='currNum-Value']")
	WebElement lblCurrentNumber;
	
	@FindBy(xpath = "//span[@class='currNum-Value newNumValue-mobile']")
	WebElement lblNewNumber;

	@FindAll({
	@FindBy(xpath = "//span[@class='text-bold text-capitalize']"),
	@FindBy(xpath = "//ins[@translate='global.label.localTo']/parent::div/div")
	})
	WebElement divLocalTo;
	
	@FindBy(xpath = "//ins[@translate='global.label.confirmationMailReview']")
	WebElement lblConfirmationEmailWillBeSentTo;

	@FindAll({
	@FindBy(xpath = "//span[text()=' Confirm ' or text()=' Confirmer ']"),
	@FindBy(xpath = "//input[@value='Confirm' or @value='Confirmer']")
	})
	WebElement btnConfirm;

	@FindAll({
	@FindBy(xpath = "//h1[@class='text-title-1']"),
	@FindBy(xpath = "//ins[@translate='wireless.label.thatsAllFolks']")
	})
	WebElement lblThatsAllHeader;

	@FindAll({
	@FindBy(xpath = "//ss-telephone-number-change-alert//div[contains(@class,'mw-content')]//child::span//strong"),
	@FindBy(xpath = "//ins[@translate='wireless.message.yourChangeWillBeDone']")
	})
	WebElement lblHeaderYourChangeWillbeDoneInFewMins;

	@FindAll({
	@FindBy(xpath = "//ss-telephone-number-change-alert//div[contains(@class,'mw-content')]//child::span"),
	@FindBy(xpath = "//ins[@translate='wireless.message.yourChangeWillBeDone']/parent::div//following-sibling::div[contains(@class,'change-ctn-new-number')]//span[@class='ctn-new-number']")
	})
	WebElement spanNewNumberConfirmation;

	@FindBy(xpath = "//h1//following-sibling::span//span")
	WebElement spanNewNumberDashboard;

	@FindAll({
			@FindBy(xpath = "//a[@variant='secondary']"),
			@FindBy(xpath = "//button[@translate='global.cta.backToAccount']")
	})
	WebElement btnBackToMyAccount;

	@FindBy(xpath = "//div[contains(@class,'talk-text-usage-heading')]")
	WebElement talkTextHeadingDashboardPage;

	@FindBy(xpath = "//div[contains(@class,'wireless-title-dropdown-container')]")
	WebElement headingDashboardPage;

	@FindAll({
	@FindBy(xpath = "//div[contains(@class,'ng-star-inserted')]//p[contains(text(),'Local to:')]"),
	@FindBy(xpath = "//div[@class='confirmPage']//ins[@translate='global.label.localTo']/parent::div/div")
	})
	WebElement lblLocalToOnConfirmationPage;

	@FindAll({
	@FindBy(xpath = "//div[contains(@class,'ng-star-inserted')]//p[contains(text(),'Confirmation')]"),
	@FindBy(xpath = "//ins[@translate='global.label.confirmationEmail']")
	})
	WebElement lblEmailConfirmationOnFinalPage;

	@FindAll({
	@FindBy(xpath = "//button[contains(@title,'expand/hide for details')]"),
	@FindBy(xpath = "//ins[@translate='wireless.label.howChangeWillAffectAlt']")
	})
	WebElement lblChangingWillAffectYourBill;
	
	@FindBy(xpath = "//div[@class='row error-message-wrapper']")
	WebElement lblErrorMessage;
	
	@FindBy(xpath = "//div[@id='skipNavigation']//a[@title='English']")
	WebElement lnkLanguageSwitchEnglish;
	
	/**
	 * This method with help in synch for page load and verify if the change CTN [age loaded successfully
	 * @return boolean value for status of page load
	 * @author Mirza.Kamran
	 */
	public Boolean waitForChangeMyNumberPageToLoad() {
		reusableActions.waitForPageLoad();
		if(!reusableActions.isElementVisible(lblErrorMessage))
		{
			reusableActions.waitForElementVisibility(btnFindAvailableNumber);
			reusableActions.waitForElementTobeClickable(btnFindAvailableNumber,60);
			waitForDropDownToLoad(cboProvince,60);	
			waitForDropDownToLoad(cboCity,60);
			return true;
			
		}else
		{
			System.out.println("The error label is displayed on change CTN page, please investigate");
			return false;
		}
	}
	
	/**
	 * verify if the label change my number header is visible
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifylblChangeMyNumberHeaderIsVisible() {
		return reusableActions.isElementVisible(lblChangeMyNumberHeader);
	}
	
	/**
	 * verify if the label keep in mind details is visible
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelKeepInMinddetailsIsVisible() {
		return reusableActions.isElementVisible(lblKeepInMind);
	}
	
	/**
	 * verify if the label change CTN details  is visible
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifylblChangeCTNBannerDetailsIsVisible() {
		return (reusableActions.isElementVisible(lblChangeCTNBannerLineOne)
				        && reusableActions.isElementVisible(lblChangeCTNBannerLineTwo));

	}
	
	/**
	 * verify if the label change my number header is visible
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifySelectBoxProvinceAndCityIsVisible() {
		return(reusableActions.isElementVisible(cboProvince)
		        && reusableActions.isElementVisible(cboCity));
	}

	/**FidoSS_Regression_TC022_PostPaidChangeCTN
	 * This method will select the Province and City where the customer will be dialing more frequently
	 * @return map of province and city details
	 * @author Mirza.Kamran
	 */
	public Map<String, String> selectCallingProvinceAndCity() {
		reusableActions.scrollToElement(cboProvince);
		Map<String, String> map=new Hashtable<String, String>();
		new Select(cboProvince).selectByVisibleText("Ontario");
		//reusableActions.selectWhenReady(cboProvince," Ontario ");
		waitForDropDownToLoad(cboCity,60);
		new Select(cboCity).selectByVisibleText("Toronto")  ;
		//reusableActions.selectWhenReady(cboCity, " Toronto ");
		map.put("province",reusableActions.getSelectedValue(cboProvince));
		map.put("city",reusableActions.getSelectedValue(cboCity));
		
		return map;
	}
	
	/**
	 * This method will wait for the dropdwon to load with values
	 * @param element Web element (dropdown.combobox, weblist)
	 * @param intTimeOutSecs timeout value
	 * @author Mirza.Kamran
	 */
	public void waitForDropDownToLoad(WebElement element, int intTimeOutSecs) {
		Select dropDown = new Select(element);
		int count = 0;
		boolean loaded = false;
		while (count < intTimeOutSecs && !loaded) {
		  if(dropDown.getOptions().size()>1)
		  {
			  loaded=true;
			  break;
		  }else
		  {
			  loaded=false;
			  count++;
			  reusableActions.staticWait(1000);
		  }
		}		
	}
	
	/**
	 * This method will click on the FindAvailable Number button
	 * @author Mirza.Kamran
	 */
	public void clickFindAvailableNumbers() {
		reusableActions.waitForElementTobeClickable(btnFindAvailableNumber, 10);		
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.executeJavaScriptClick(btnFindAvailableNumber);
	}
	
	/**
	 * This method will verify if Pick and new number page is loaded and elements available
	 * @return will return true if page loaded successfully and all elements available, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyPickANewNumberPageLoaded() {
		reusableActions.waitForPageLoad();
		reusableActions.waitForElementVisibility(btnSelectNumber);
		reusableActions.waitForElementVisibility(lblPickupNewNumberHeader,300);
		reusableActions.waitForElementVisibility(divNewNumberList,300);
		if(reusableActions.isElementVisible(lblPickupNewNumberHeader)	
			&& reusableActions.isElementVisible(divNewNumberList))
		{
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method will select the new CTN number 
	 * @param intIndex the index value to select the CTN number (1-7)
	 * @return returns the selected number (String) value
	 * @author Mirza.Kamran
	 */
	public String selectNewNumber(int intIndex) {
		String newCTNString="";
		List<WebElement> newNumbers=driver.findElements(By.xpath("//ds-radio-group[@aria-label='Choose phone number']//div//ds-radio-button//div[@id]"));
		if(newNumbers.size()>0)
		{
			newCTNString=reusableActions.getWhenReady(newNumbers.get(intIndex)).getText();
			reusableActions.clickIfAvailable(newNumbers.get(intIndex));	
			return newCTNString;
		}else
		{
			return null;
		}		
	}
	
	/**
	 * Click select CTN Number button
	 * @author Mirza.Kamran
	 */
	public void clickSelectNumber() {
		reusableActions.clickIfAvailable(btnSelectNumber);
	}
	
	/**
	 * Verify the new number details for review
	 * @return will return true if all elements available on review page else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyReviewYourNewNumberPageLoaded() {
		reusableActions.waitForPageLoad();		
		if(reusableActions.isElementVisible(lblReviewNumberHeader)
				&& reusableActions.isElementVisible(lblReviewPhoneNumberDescriptionNew))
		{
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method will verify details after new number change
	 * @param strOldCTN old CTN value
	 * @param strNewCTN new CTN value after change
	 * @return true if numbers values match as expected, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyNewNumberDetails(String strOldCTN, String strNewCTN) {
		if(!strOldCTN.equalsIgnoreCase(strNewCTN))
		{
			return true;
		}else
		{
			return false;
		}				
	}
	
	/**
	 * This method will verify province and city on the confirmation page
	 * @param strProvince  new Province where frequent calls made
	 * @param strCity  new City where frequent calls made
	 * @return true if numbers values match as expected, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyProvinceAndCityOnConfirmationPage( String strProvince, String strCity) {
		String localTo=reusableActions.getWhenReady(divLocalTo).getText();
		if(localTo.contains(strProvince)
			&& localTo.contains(strCity))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * This method will verify Email sent label on the confirmation page
	 * @return true if numbers values match as expected, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyEmailSentLabelOnConfirmationPage() {
		return reusableActions.isElementVisible(lblConfirmationEmailWillBeSentTo);
	}
	
	/**
	 * Click the confirm button
	 * @author Mirza.Kamran
	 */
	public void clickButtonConfirm() {
		reusableActions.clickWhenReady(btnConfirm);
	}
	
	/**
	 * Verify the CTN Number change is successful 
	 * @param strNewNumber the new number selected  
	 * @return will return true if all details match else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTheCTNChangeSuccessPage(String strNewNumber) {
		reusableActions.waitForPageLoad();		
		reusableActions.waitForElementVisibility(btnBackToMyAccount, 60);
		if(reusableActions.getWhenReady(spanNewNumberConfirmation).getText().trim().contains(strNewNumber))
		{
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Verify the CTN Number change is successful
	 * @param strNewNumber the new number selected
	 * @return will return true if all details match else false
	 * @author Sidhartha.vadrevu
	 */
	public boolean verifyTheCTNChangeDashboardPage(String strNewNumber) {
		reusableActions.waitForPageLoad();
		reusableActions.waitForElementVisibility(headingDashboardPage,60);
		if(reusableActions.getWhenReady(spanNewNumberDashboard).getText().trim().contains(strNewNumber))
		{
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method will verify if the element Label Thats all is displayed 
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelThatsAllIsDisplayed() {
		return reusableActions.isElementVisible(lblThatsAllHeader);
	}
	
	/**
	 * This method will verify if the element Label YourChangeWillbeDoneInfewMins is displayed 
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelYourChangeWillbeDoneInfewMinsIsDisplayed() {
		return reusableActions.isElementVisible(lblHeaderYourChangeWillbeDoneInFewMins);
	}
	
	
	/**
	 * This method will verify if the element spanNewNumberConfirmation is displayed 
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyNewLabelConfirmationSpanIsDisplayed() {
		return reusableActions.isElementVisible(spanNewNumberConfirmation);
	}
	
	
	/**
	 * This method will verify if the element LabelLocalToDetails is displayed 
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelLocalToDetailsIsDisplayed() {
		return reusableActions.isElementVisible(lblLocalToOnConfirmationPage);
	}
	
	
	/**
	 * This method will verify if the element Label email confirmation  is displayed 
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelEmailConfirmationOnFinalPageIsDisplayed() {
		return reusableActions.isElementVisible(lblEmailConfirmationOnFinalPage);
	}
	
	/**
	 * This method will verify if the element Label ChangingWillAffectYourBill is displayed 
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLabelChangingWillAffectYourBillIsDisplayed() {
		return reusableActions.isElementVisible(lblChangingWillAffectYourBill);
	}
	
	/**
	 * Click on the Back to my account button
	 * @author Mirza.Kamran
	 */
	public void clkBackToMyAccount() {
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.clickWhenReady(btnBackToMyAccount);
	}
}
