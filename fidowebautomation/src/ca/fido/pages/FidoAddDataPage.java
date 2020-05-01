package ca.fido.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;
import ca.fido.test.helpers.StringHelpers;


public class FidoAddDataPage extends BasePageClass {

	public FidoAddDataPage(WebDriver driver) {
		super(driver);		
	}
	//div[@class='modal-header purchase-data-modal-header']
	@FindBy(xpath = "//h2[@class='add-data-modal-title']")
	WebElement overlayMonthlyDataAddOn;
	
	@FindBy(xpath = "//h2[@class='add-data-modal-title']")
	WebElement overlayOTTDataAddOn;
	
	@FindAll({@FindBy(xpath = "//div[@class='selected-plan-details-item']//h2")})
	List<WebElement> btnsSelectDataOnAddDataOverLay;
	//button[@class='ute-purchase-data-continue-btn']
	@FindBy(xpath = "//fds-button[@class='continue-button']")
	WebElement btnContinueOnAddDataOverlay;
	
	@FindBy(xpath = "//span[text()='Select amount' or text()='Sélectionnez le montant']")
	WebElement cboSelectAmount;
	
	@FindBy(xpath = "//ins[@translate='ute.purchaseData.continue']")
	WebElement btnContinueMonthlyAddOn;
	
	@FindAll({@FindBy(xpath = "//span[@class='ui-select-choices-row-inner']/div")})
	List<WebElement> optionsSelectDataOnAddDataOverLay;
	
	
	@FindBy(xpath = "//img[@class='close-btn']")
	WebElement btnCloseMonthlyAddOnOverLay;
	
	@FindBy (xpath = "//span[@translate='purchaseData.purchasingPlansConfirmationModal.title']")
	WebElement msgConfirmPurchasing;
	//ins[@translate='ute.purchaseData.purchaseBtn']/parent::button
	@FindBy (xpath = "//button[@data-caption='Purchase']")
	WebElement btnPurchaseOnAddDataOverlay;
	
	@FindBy (xpath = "//span[contains(text(),'added') or contains(text(),'ajoutés!')]")
	WebElement msgSuccessOnAddDataOverlay;
	
	@FindBy (xpath = "//ins[contains(text(),'Limit reached') or contains(text(),'Limite atteinte')]")
	WebElement msgLimitReached;
	
	@FindBy (xpath = "//button[@class='close ng-star-inserted']")
	WebElement btnCloseOnAddDataOverlay;
	
	
	/**
	 * Verify Overlay Monthly Data Add On Displayed
	 * @return true if the overlay displayed, otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyOverlayAddOnDisplayed() {
		String strOverlaytitleText = reusableActions.getWhenReady(overlayMonthlyDataAddOn, 30).getText().trim();
		return (strOverlaytitleText.toUpperCase().contains("MONTH")||strOverlaytitleText.toUpperCase().contains("MENSUELLE")
				|| strOverlaytitleText.equalsIgnoreCase("Data") || strOverlaytitleText.equalsIgnoreCase("DONNÉES"));
	} 
	
	/**
	 * Verify Overlay Monthly Data Add On Displayed
	 * @return true if the overlay displayed, otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyOverlayMonthlyDataAddOnDisplayed() {
		String strOverlaytitleText = reusableActions.getWhenReady(overlayMonthlyDataAddOn, 30).getText().trim();
		return (strOverlaytitleText.toUpperCase().contains("MONTH")||strOverlaytitleText.toUpperCase().contains("MENSUELLE")
				);
	} 
	
	/**
	 * Verify Overlay OTT Data Add On Displayed
	 * @return true if the overlay displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyOverlayOTTDataAddOnDisplayed() {
		String strOverlaytitleText = reusableActions.getWhenReady(overlayOTTDataAddOn, 30).getText().trim();
		return ((strOverlaytitleText.equalsIgnoreCase("Data") || strOverlaytitleText.equalsIgnoreCase("DONNÉES"))
				&& (!strOverlaytitleText.contains("Month")||!strOverlaytitleText.contains("Mois")));
	} 
	
	/**
	 * Perform click on the first data button on add data overlay
	 * @author ning.xue
	 */
	public void clkTheFirstDataPlanBtnOnAddDataOverlay() {		
		reusableActions.getWhenReady(btnsSelectDataOnAddDataOverLay.get(0),60).click();
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
		reusableActions.getWhenReady(cboSelectAmount, 60).click();		
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
		double valueAddedData = Double.parseDouble( StringHelpers.getNumbersFromString(strDataAdded.replace(",", ".")));		
		if(strDataAdded.substring(strDataAdded.length()-2).equalsIgnoreCase("MB")
			||strDataAdded.substring(strDataAdded.length()-2).equalsIgnoreCase("MO")) {
			valueAddedData = valueAddedData / 1000;
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
			String addedvalue = StringHelpers.getNumbersFromString(btn.getText());
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
}
