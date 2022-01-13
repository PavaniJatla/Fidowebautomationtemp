package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import ca.fido.test.helpers.StringHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FidoAddDataPage extends BasePageClass {


	public FidoAddDataPage(WebDriver driver) {
		super(driver);
	}
	//div[@class='modal-header purchase-data-modal-header']

	@FindBy(xpath = "//h2[@class='add-data-modal-title']")
	WebElement overlayMonthlyDataAddOn;

	@FindBy(xpath = "//h2[@class='add-data-modal-title']")
	WebElement overlayOTTDataAddOn;

	@FindAll({
			@FindBy(xpath = "//div[@class='selected-plan-details-item']"),
			@FindBy(xpath = "//div[@class='selected-plan-details-item']//h2")})
	List<WebElement> btnsSelectDataOnAddDataOverLay;
	//button[@class='ute-purchase-data-continue-btn']

	@FindAll({
			@FindBy(xpath = "//button//span[text()=' Continue ' or text()=' Continuer ']"),
			@FindBy(xpath = "//fds-button[@class='continue-button']")})
	WebElement btnContinueOnAddDataOverlay;
	//span[text()='Select amount' or text()='Sélectionnez le montant']
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement btnSelectAmount;

	@FindBy(xpath = "//ins[@translate='ute.purchaseData.continue']")
	WebElement btnContinueMonthlyAddOn;

	@FindAll({@FindBy(xpath = "//li[@class='list-group-item dropdown-item ng-star-inserted']")})
	List<WebElement> optionsSelectDataOnAddDataOverLay;

	@FindBy(xpath = "//img[@class='close-btn']")
	WebElement btnCloseMonthlyAddOnOverLay;

	@FindBy(xpath = "//span[@translate='purchaseData.purchasingPlansConfirmationModal.title' or text()='Confirm data purchase' or contains(text(),'Confirmez')]")
	WebElement msgConfirmPurchasing;
	//ins[@translate='ute.purchaseData.purchaseBtn']/parent::button

	@FindAll({
			@FindBy(xpath = "//button//span[text()='Purchase' or text()='Acheter']"),
			@FindBy(xpath = "//button[@data-caption='Purchase' or @data-caption='Acheter']")})
	WebElement btnPurchaseOnAddDataOverlay;

	@FindBy(xpath = "//span[contains(text(),'added') or contains(text(),'ajoutés!')]")
	WebElement msgSuccessOnAddDataOverlay;

	@FindBy(xpath = "//*[contains(text(),'Limit reached') or contains(text(),'Limite atteinte')]")
	WebElement msgLimitReached;

	@FindBy(xpath = "//button[@class='close ng-star-inserted' or contains(@class,'ds-modal__closeButton')]")
	WebElement btnCloseOnAddDataOverlay;

	@FindBy(xpath = "//ss-data-topup-dropdown")
	WebElement dropdown;

	@FindBy(xpath = "//button/span[text()='Select amount']")
	WebElement selectAmountInDropdown;

	@FindBy(xpath = "//ss-data-topup-dropdown//li")
	List<WebElement> listInDropdown;

	@FindBy(xpath = "//span[@class='data-plan-details']")
	WebElement lblPricePlanOnConfirmPage;

	/**
	 * Verify Overlay Monthly Data Add On Displayed
	 *
	 * @return true if the overlay displayed, otherwise false
	 * @author Mirza.Kamran
	 * @author Rama Arora
	 */
	public boolean verifyOverlayAddOnDisplayed() {

		WebElement strOverlaytitleText = reusableActions.getWhenReady(overlayMonthlyDataAddOn, 30);
		boolean b = reusableActions.isElementVisible(strOverlaytitleText, 30);
		String strDataValue = driver.findElement(By.xpath("//*[@class='select-data-plan-container']")).getText().trim();
		System.out.println(strDataValue);
		String[] strValues = strDataValue.split("\n");

		for (int i = 0; i < strValues.length-1; i++) {
			if (b == true) {
				return (strValues[i].contains("Select an amount and use the data until end of day") || strValues[i].equalsIgnoreCase("500 MB")
						|| strValues[i].equalsIgnoreCase("$10.00") || strValues[i].equalsIgnoreCase("2.5 GB") || strValues[i].equalsIgnoreCase("$25.00")  || strValues[i].equalsIgnoreCase("5 GB") || strValues[i].equalsIgnoreCase("$40.00"));
			} else {
				return false;
			}
		}
		return true;
	}

	
	/**
	 * Verify Overlay Monthly Data Add On Displayed
	 * @return true if the overlay displayed, otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyOverlayMonthlyDataAddOnDisplayed() {
		boolean b = verifyOverlayAddOnDisplayed();
		//String strOverlaytitleText = reusableActions.getWhenReady(overlayMonthlyDataAddOn, 30).getText().trim();
		/*return (strOverlaytitleText.toUpperCase().contains("MONTH")||strOverlaytitleText.toUpperCase().contains("MENSUELLE")
				);*/
		return b;
	} 
	
	/**
	 * Verify Overlay OTT Data Add On Displayed
	 * @return true if the overlay displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyOverlayOTTDataAddOnDisplayed() {
		String strOverlaytitleText = reusableActions.getWhenReady(overlayOTTDataAddOn, 30).getText().trim();
		return ((strOverlaytitleText.contains("One-time") || strOverlaytitleText.contains("DONNÉES"))
				&& (!strOverlaytitleText.contains("Month")||!strOverlaytitleText.contains("Mois")));
	} 
	
	/**
	 * Perform click on the first data button on add data overlay
	 * @author ning.xue
	 */
	public void clkTheFirstDataPlanBtnOnAddDataOverlay() {	
		if(reusableActions.isElementVisible(dropdown))
		{
			//reusableActions.getWhenReady(selectAmountInDropdown).click();
			reusableActions.getWhenReady(listInDropdown.get(0)).click();
		}else
		{
			reusableActions.getWhenReady(btnsSelectDataOnAddDataOverLay.get(0),60).click();
		}
		
		
	} 
	
	/**
	 * Perform click on continue button on add data overlay
	 * @author ning.xue
	 */
	public void clkContinueBtnOnAddDataOverlay() {		
		reusableActions.getWhenReady(btnContinueOnAddDataOverlay,20).click();
	} 
	
	/**
	 * clicks the select amount drop down
	 * @author Mirza.Kamran
	 */
	public void clkSelectAmountDropDown() {
		reusableActions.waitForElementTobeClickable(btnSelectAmount, 10);
		reusableActions.executeJavaScriptClick(btnSelectAmount);		
	}
	
	/**
	 * will perform click on the first data option in the select drop down option
	 * @author Mirza.Kamran
	 */
	public void clkTheFirstDataPlanOptionFromDropDown() {		
		reusableActions.getWhenReady(optionsSelectDataOnAddDataOverLay.get(0),60).click();
	}
	
	/**
	 * Perform click on the cancel button on Add data plan overlay
	 * @author Mirza.Kamran
	 */
	public void clkCancelButtonOnAddDataPlan() {		
		reusableActions.clickWhenReady(btnCloseMonthlyAddOnOverLay);
		reusableActions.staticWait(3000);
	} 
	
	/**
	 * Verify confirm purchasing message Displayed
	 * @return true if the message displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyConfirmPurchasingMsgDisplayed(String strLanguage,HashMap<String, String> speedPassPrice) {
		String textPricePlan = reusableActions.getWhenReady(lblPricePlanOnConfirmPage).getText().trim();
		String SpeedPassDataValue = "";
		String SpeedPassPriceValue = "";
		if(strLanguage.equals("en")) {
			if(textPricePlan.contains("GB")) {
				SpeedPassDataValue = textPricePlan.split("GB")[0];
				SpeedPassPriceValue = textPricePlan.split("for")[1].replaceAll("$", "");
			}else if(textPricePlan.contains("MB")) {
				SpeedPassDataValue = textPricePlan.split("MB")[0];
				SpeedPassPriceValue = textPricePlan.split("for")[1].replaceAll(",", ".").replaceAll("$", "");
			}
		}else if (strLanguage.equals("fr"))
		{
			if(textPricePlan.contains("Go")) {
				SpeedPassDataValue = textPricePlan.split("Go")[0];
				SpeedPassPriceValue = textPricePlan.split("pour ")[1].replaceAll(",", ".").replaceAll("$", "");
			}if(textPricePlan.contains("Mo")) {
			SpeedPassDataValue = textPricePlan.split("Mo")[0];
			SpeedPassPriceValue = textPricePlan.split("pour ")[1].replaceAll(",", ".").replaceAll("$", "");
		}
		}
		return (reusableActions.isElementVisible(msgConfirmPurchasing, 30));
				//&& speedPassPrice.get(SpeedPassDataValue.trim()).equals(getNumbersFromString(SpeedPassPriceValue).trim()));
	}

	/**
	 * Verify confirm purchasing message Displayed
	 * @return true if the message displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyConfirmPurchasingMsgDisplayed() {

		return reusableActions.isElementVisible(msgConfirmPurchasing, 30);
	}

	/**
	 * Perform click on purchase button on add data overlay
	 * @author ning.xue
	 */
	public void clkPurchaseBtnOnAddDataOverlay() {		
		reusableActions.getWhenReady(btnPurchaseOnAddDataOverlay,20).click();
	} 
	
	/**
	 * Check if limit reached message Displayed
	 * @return true if the message displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean isLimitReachedMsgDisplayed() {
		return reusableActions.isElementVisible(msgLimitReached, 30);
	}  
	
	/**
	 * Verify Add Data Success message Displayed
	 * @return true if the message displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyAddDataSuccessMsgDisplayed() {
		return reusableActions.isElementVisible(msgSuccessOnAddDataOverlay, 30);
	}  
	
	/**
	 * To get the value of added data
	 * @return double, value of added data
	 * @author ning.xue
	 */
	public double getValueAddedData() {
		String strDataAdded = msgSuccessOnAddDataOverlay.getText();
		double valueAddedData=0;		
		if(strDataAdded.contains("MB")
			||strDataAdded.contains("MO")) {
			valueAddedData = Double.parseDouble( StringHelpers.getNumbersFromString(strDataAdded.replace(",", ".")));
			valueAddedData = valueAddedData / 1000;
		}else
		{
			valueAddedData = Double.parseDouble( StringHelpers.getNumbersFromString(strDataAdded.replace(",", ".")));
		}
		
		return valueAddedData;
	}
	
	/**
	 * 
	 * @return String value added 
	 * @author Mirza.Kamran
	 */
	public String getAddedValueWithGBOrMB() {
		return msgSuccessOnAddDataOverlay.getText();
	}
	
	/**
	 * Perform click on close button on add data overlay
	 * @author ning.xue
	 */
	public void clkCloseBtnOnAddDataOverlay() {		
		reusableActions.getWhenReady(btnCloseOnAddDataOverlay,20).click();
		reusableActions.staticWait(3000);
	} 
	

	/**
	 * To click on the MDT if it's added less than 3 times.
	 * @param mapCountOfAlreadyAddedData Contains all added values and their count
	 * @return true if MDT added less than 3 times be found
	 */
	public boolean clkTheDataAddOnWhichAreNotAddedMoreThanThreeTime(Map<String, Integer> mapCountOfAlreadyAddedData) {
		boolean foundLessThanThree = false;
		reusableActions.waitForElementVisibility(btnsSelectDataOnAddDataOverLay.get(0), 60);
		for(WebElement btn: btnsSelectDataOnAddDataOverLay)
		{
			String addedvalue = StringHelpers.getNumbersFromString(btn.getText()).replaceAll(",", ".");
			if(mapCountOfAlreadyAddedData.containsKey(addedvalue))
			{
				if(mapCountOfAlreadyAddedData.get(addedvalue)<3)
				{
					btn.click();
					foundLessThanThree = true;
					break;
				}
			
			}else
			{
				btn.click();
				foundLessThanThree = true;
				break;
			}
		}
		return foundLessThanThree;
		
	}
	
	/**
	 * Clicks the data value required on the overlay
	 * @param strAddDataValue string data value to be selected
	 * @return true if the data value is found else false
	 * @author Mirza.Kamran
	 */
	public boolean clkTheDataAddOnValue(String strAddDataValue) {
		boolean found = false;
		reusableActions.waitForElementVisibility(btnsSelectDataOnAddDataOverLay.get(0), 60);
		for(WebElement btn: btnsSelectDataOnAddDataOverLay)
		{
			String addedvalue = StringHelpers.getNumbersFromString(btn.getText()).replaceAll(",", ".");
			if(addedvalue.trim().equals(strAddDataValue.trim()))
			{				
					btn.click();
					found = true;
					break;
			
			}
		}
		return found;
		
	}

	/**
	 *
	 * @return
	 * @param speedPassPrice
	 */
    public boolean verifyIfTopUpPriceIsCorrect(HashMap<String, String> speedPassPrice) {
		List<WebElement> AddOnsList = null;
		if (reusableActions.isElementVisible(dropdown)) {
			reusableActions.getWhenReady(selectAmountInDropdown).click();
			AddOnsList = listInDropdown;
		} else {
			AddOnsList =  btnsSelectDataOnAddDataOverLay;
		}


		for (int opt = 0; opt <= AddOnsList.size() - 1; opt++) {
			String SpeedPassDataValue = AddOnsList.get(opt).getText().split("\n")[0];
			String SpeedPassPriceValue = AddOnsList.get(opt).getText().split("\n")[1];
			SpeedPassDataValue = getNumbersFromString(SpeedPassDataValue);
			SpeedPassPriceValue = getNumbersFromString(SpeedPassPriceValue);
			if (!speedPassPrice.get(SpeedPassDataValue).equals(SpeedPassPriceValue)) {
				return false;
			}
		}

		return true;


	}

	/**
	 * This will extract the numbers from string
	 * @param strMatch complete string to be matched
	 * @return String number
	 */
	public String getNumbersFromString(String strMatch) {
		Pattern pattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
		Matcher match = pattern.matcher(strMatch.replaceAll(",", "."));
		match.find();
		return match.group();
	}


}
