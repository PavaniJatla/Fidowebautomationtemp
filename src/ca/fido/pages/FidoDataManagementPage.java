package ca.fido.pages;


import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;



public class FidoDataManagementPage extends BasePageClass {

	public FidoDataManagementPage(WebDriver driver) {
		super(driver);		
	}
	
	
	@FindBy (xpath = "//h1[@class='manage-data-title mb-10 ng-star-inserted' or @class='manage-data-title']")
	WebElement titleManageData;
	
	@FindBy (xpath = "//h4[contains(text(),'PLAN DATA') or contains(text(),'DONNÉES DU FORFAIT')]")
	WebElement titlePlanData;
	
	@FindBy(xpath = "//h4[contains(text(),'PLAN DATA') or contains(text(),'DONNÉES DU FORFAIT')]/parent::div/parent::div//tr")
	WebElement rowPlanData;
	
	@FindBy (xpath = "//h4[contains(text(),'ADDED DATA') or contains(text(),'DONNÉES AJOUTÉES')]")
	WebElement titleAddedData;
	
	
	@FindBy (xpath = "//h4[contains(text(),'TOTAL DATA') or contains(text(),'TOTAL DES DONNÉES')]")
	WebElement titleTotalData;
	
	@FindBy(xpath = "//h4[contains(text(),'TOTAL DATA') or contains(text(),'TOTAL DES DONNÉES')]/parent::div/parent::div//strong")
	List<WebElement> rowsTotalData;
	
	@FindBy (xpath = "//span[contains(text(),'Back') or contains(text(),'Précédent')]")
	WebElement lnkBackOnManageDataOverlay;
	
	@FindBy (xpath = "//strong")
	List<WebElement> listData;

	@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//strong")
	List<WebElement> rowsAddedData;
	
	
	//@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//tr//strong[(contains(text(), 'CANCEL'))=false and (contains(text(), 'Expires'))=false and (contains(text(),'ANNULER')=false) and (contains(text(),'Prend')=false)]")
	@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//tr//a[(contains(text(), 'CANCEL'))=false and (contains(text(), 'Expires'))=false and (contains(text(),'ANNULER')=false) and (contains(text(),'Prend')=false)]")
	List<WebElement> tableRowsAddData;
	
	@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//tr")
	List<WebElement> rowsAddMDTData;

	@FindBy (xpath = "//span[@translate='usageModule.manage']")
	WebElement lnkViewDetails;

	@FindBy (xpath = "//a[@title='Cancel this add-on' or contains(@title,'Annuler')]")
	WebElement lnkCancel;
	 
	@FindBy(xpath = "//p[text()='CANCEL ADD-ON' or text()='ANNULER L’OPTION']")
	WebElement titleCancelAddOn;
	
	@FindBy(xpath = "//button//span[text()='YES, CANCEL' or text()='OUI, ANNULER']")
	WebElement btnYesCancel;
	
	@FindBy(xpath = "//p[text()='ADD-ON CANCELLED' or contains(text(),'OPTION ANNUL')]")
	WebElement titleAddOnCancelled;
	
	@FindBy(xpath = "//button[@title='Close' or @title='FERMER']//span[contains(text(),'FERMER') or contains(text(),'Close')]/parent::span/parent::button")
	WebElement btnCloseAddOnCancelled;
	
	/**
	 * Verify manage data overlay Displayed
	 * @return true if the overlay displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyManageDataOverlayDisplayed() {
		return reusableActions.isElementVisible(titleManageData, 60);
	}   
	
	/**
	 * Verify plan data in manage data overlay Displayed
	 * @return true if the plan data displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyPlanDataInManageDataOverlayDisplayed() {
		reusableActions.staticWait(6000);
		return reusableActions.isElementVisible(titlePlanData, 60);
	} 
	
	/**
	 * Verify added data in manage data overlay Displayed
	 * @return true if the added data displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyAddedDataInManageDataOverlayDisplayed() {
		return reusableActions.isElementVisible(titleAddedData, 30);
	} 
	
	/**
	 * Verify total data in manage data overlay Displayed
	 * @return true if the total data displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyTotalDataInManageDataOverlayDisplayed() {
		return reusableActions.isElementVisible(titleTotalData, 30);
	} 
	
	/**
	 * To get the value of total data in manage data overlay.
	 * @return double, the value of plan data plus add-ons.
	 * @author ning.xue
	 */
	public double getTotalDataInManageDataOverlay() {
		String strTotalData = listData.get(listData.size()-2).getText();
		double doubleTotalData = Double.parseDouble(strTotalData.substring(0, strTotalData.length()-3));
		String strAddData = listData.get(listData.size()-1).getText();
		double doubleAddData = Double.parseDouble(strAddData.substring(1, strAddData.length()-3));
		if (strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MB")) {
			doubleAddData = doubleAddData / 1000;
		}
		return doubleTotalData + doubleAddData;
	}
	
	/**
	 * Perform click on view details link in usage section
	 * @author ning.xue
	 */
	public void clkLinkBackOnManageDataOverlay() {			
		reusableActions.getWhenReady(lnkBackOnManageDataOverlay,20).click();
		reusableActions.staticWait(6000);
	}
	
	/**
	 * Verify data accuracy in manage data overlay, total data should show plan data + data add-ons 
	 * @return true if the data matches displayed, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyDataAccuracyInManageDataOverlay() {
		String strPlanData = listData.get(0).getText();
		double intPlanData = Double.parseDouble(strPlanData.substring(0, strPlanData.length()-3));
		String strTotalData = listData.get(listData.size()-2).getText();
		double intTotalData = Double.parseDouble(strTotalData.substring(0, strTotalData.length()-3));
		double intAddData = 0;
		if (listData.size() > 2) {
			int flag = 1;
			for (int iLoop = 1; iLoop <= listData.size()-3; iLoop++) {
				String strAddData = listData.get(iLoop).getText();
				
				if (strAddData.toLowerCase().contains("go")?strAddData.substring(strAddData.length()-2).equalsIgnoreCase("GO")
						: strAddData.substring(strAddData.length()-2).equalsIgnoreCase("GB")
						&& flag == 1) {
					intAddData = intAddData / 1000;
					flag = 0;
				}
				intAddData = intAddData + Double.parseDouble(strAddData.substring(0, strAddData.length()-3));
			}
			String strTotalAddon = listData.get(listData.size()-1).getText();
			double intTotalAddon = Double.parseDouble(strTotalAddon.substring(0, strTotalAddon.length()-3)); 
			return intTotalData == intPlanData 
					&& intTotalAddon == intAddData;
		} else {
			return intTotalData == intPlanData; 
		}

	}

	/**
	 * Verify data accuracy in manage data overlay, total data should show plan data + data add-ons 
	 * @return true if the data matches displayed, otherwise false
	 * @param strType ott and mtt type
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAccuracyManageDataOverlay(String strType) {
		String strPlanData = rowPlanData.getText();		
		strPlanData=getNumbersFromString(strPlanData);				
		double intPlanData = Double.parseDouble(strPlanData);
				
		String strTotalData = rowsTotalData.get(0).getText();
		double intTotalData = Double.parseDouble(getNumbersFromString(strTotalData));
		double intAddData = 0;		
		List<WebElement> rows = strType.equalsIgnoreCase("ott") ? rowsAddedData : tableRowsAddData;
		
			for (int iLoop = 0; iLoop <= rows.size()-1; iLoop++) {
				String strAddData = rows.get(iLoop).getText();				
				if (strAddData.toLowerCase().contains("mo")?strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MO")
						: strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MB")) {
					intAddData = Double.parseDouble(getNumbersFromString(strAddData)) / 1000;					
				}
				intAddData = intAddData + Double.parseDouble(strAddData.substring(0, strAddData.length()-3));
			}
			String strTotalAddon = rowsTotalData.get(1).getText();
			double intTotalAddon = Double.parseDouble(getNumbersFromString(strTotalAddon)); 
			return intTotalData == intPlanData 
					&& intTotalAddon == intAddData;
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
	
	/**
	 * Verify if the "Cancel" link is not displayed for added data.
	 * @return true, if "Cancel" link is not displayed, otherwise, false.
	 * @author Mirza.Kamran
	 */
	public boolean verifyNoCancelLinkDisplayedForAddedData() {
		return !reusableActions.isElementVisible(lnkCancel);
	} 
	
	/**
	 * Verifies if the added data is displayed separately in data details
	 * @return true if the new added count plus previous records matches total records else false
	 * @param listAddedData int, new added record count
	 * @param intCountOfSpeedPassBefore int, the previous record
	 * @author Mirza.Kamran
	 */
	public boolean verifyAddedDataInDataDetails(int listAddedData, int intCountOfSpeedPassBefore) {
		int totalSpeedPass = getAllExistingAddOTTCount();
		return totalSpeedPass == listAddedData + intCountOfSpeedPassBefore;
		
	}

	/**
	 * Verifies if the added data is displayed separately in data details
	 * @return true if the new added count plus previous records matches total records else false
	 * @param listAddedData int, new added record count
	 * @param intCountOfSpeedPassBefore int, the previous record
	 * @author Mirza.Kamran
	 */
	public boolean verifyMTTAddedDataInDataDetails(int listAddedData, int intCountOfSpeedPassBefore) {		
		int totalSpeedPass = getAllExistingAddMTTCount();
		return totalSpeedPass == listAddedData + intCountOfSpeedPassBefore;
		
	}
	
	/**
	 * Returns count of all MTT add ons
	 * @return int count
	 * @author Mirza.Kamran
	 */
	private int getAllExistingAddMTTCount() {		
		return tableRowsAddData.size();
	}

	/**
	 * This method gets the Speed pass count
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public int getAllExistingAddOTTCount() {
		return rowsAddedData.size();
	}

	/**
	 * This method gets the ADD data count
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public int getAllExistingAddDataCount() {
		reusableActions.staticWait(5000);
		return tableRowsAddData.size();
	}

	/**
	 * This method gets all the existing added data records.
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public HashMap<String, Integer> getAllExistingAddDataCountCancelledAndActive() {
		int active=0;
		int cancelled=0;
		int nonMTT=0;
		HashMap<String, Integer> addData = new HashMap<String, Integer>();
		for(WebElement row:rowsAddMDTData)
		{
			if(row.getText().toLowerCase().contains("cancel") ||row.getText().toLowerCase().contains("annuler"))
			{
				active++;
				
			}else if(row.getText().toLowerCase().contains("expires") || row.getText().toLowerCase().contains("prend"))
			{
				cancelled++;
			}else
			{
				nonMTT++;
			}
		}
		
		addData.put("active", active);
		addData.put("cancelled", cancelled);
		addData.put("nonMDT", nonMTT);
		return addData;
	}
	
	/**
	 * This method gets the MDT values and their counts already added in the view details
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public HashMap<String, Integer> getCountOfAllExistingAddedDataValues() {
				
		HashMap<String, Integer> addedDataValues = new HashMap<String, Integer>();
		for(WebElement row:tableRowsAddData)
		{		
			int addedValueCount=0;
			String strAddedValue = getNumbersFromString(row.getText());
			if(addedDataValues.containsKey(strAddedValue))
			{
				addedValueCount =	addedDataValues.get(strAddedValue);
				addedValueCount++;
				addedDataValues.put(strAddedValue, addedValueCount);
			}else
			{
				addedDataValues.put(strAddedValue, 1);
			}
			
		}
		
	
		return addedDataValues;
	}
	
	/**
	 * Verifies View Details link 
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean validateViewDetailsLink() {
		boolean isDisplayed=false;
		reusableActions.waitForElementTobeClickable(lnkViewDetails, 30);
		reusableActions.getWhenReady(lnkViewDetails, 50).click();
		if(reusableActions.isElementVisible(titleManageData,30)
			&& reusableActions.isElementVisible(titlePlanData, 30)	)
		{				
			isDisplayed=true;	
			
		}		
		return isDisplayed;
	}

	/**
	 * Checks if the cancel is displayed for all mtt add data
	 * @return true if all the add data has cancel button else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelIsDisplayedForAllMTTData() {
		Boolean found = true;
		for(WebElement row : rowsAddedData) {
			if(!row.getText().toLowerCase().contains("cancel")
				|| !row.getText().toLowerCase().contains("annuler")) {
				found = false;
				break;
			}
		}
		return found;
	}
	
	/**
	 * Checks if the cancel is displayed for all existing active ane newly added
	 * @param intExistingActive, integer, the number of existing active MDT,
	 * @param intNewlyAddedMDTAddOns, integer, the number of newly added MDT.
	 * @return true if all the add data has cancel button else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelIsDisplayedForAllActiveAndNewlyAddMDTData(int intExistingActive, int intNewlyAddedMDTAddOns) {	
		int countTotal = 0;			
		for(WebElement row : rowsAddMDTData) {
			if(row.getText().toLowerCase().contains("cancel")
				|| row.getText().toLowerCase().contains("annuler")) {
				countTotal++;
			}
		}
		return countTotal== (intExistingActive+intNewlyAddedMDTAddOns);
	}


	/**
	 * Clicks on the cancel MDT link
	 * @author Mirza.Kamran
	 */
	public void clkCancelMDTLink() {
		Boolean found = false;
		for(WebElement row : tableRowsAddData) {
			if(found ==false 
				&&	(row.getText().toLowerCase().contains("cancel")
				|| row.getText().toLowerCase().contains("annuler"))) {
				lnkCancel.click();
				found = true;
				break;
			}
		}
		
	}

	/**
	 * Clicks on Yes cancel on Overlay
	 * @author Mirza.Kamran
	 */
	public void clkYesRemoveTopUpButton() {
		reusableActions.clickIfAvailable(btnYesCancel);		
	}

	/**
	 * Verify if the canceled MDT is showing as canceled in manage data page.
	 * @param countOfNewlyCancelled, the number of records for newly canceled MDT.
	 * @param countOfPreviousCancelled, the number of records for previous canceled MDT.
	 * @return true if the count match else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelledMDTInManageData(int countOfNewlyCancelled, int countOfPreviousCancelled) {
		int cancelled= getAllExistingAddDataCountCancelledAndActive().get("cancelled");
		return (cancelled==(countOfNewlyCancelled+countOfPreviousCancelled));
	}

	/**
	 * Clicks on the close overlay
	 * @author Mirza.Kamran
	 */
	public void clkCloseButtonOnCancelSuccessOverlay() {
		reusableActions.getWhenReady(btnCloseAddOnCancelled).click();
	}

	/**
	 * Check if  MDT is cancelled successfully.
	 * @return true if the cancelled is successful
	 * @author Mirza.Kamran
	 */
	public boolean isCancelSuccessdisplayed() {		
		return reusableActions.isElementVisible(titleAddOnCancelled,30);
	}

	/**
	 * Scrolls to the top of the page
	 * @author Mirza.Kamran
	 */
	public void scrollToTop() {
	reusableActions.javascriptScrollToTopOfPage();
		
	}

	/**
	 * Scrolls to middle of page
	 */
	public void scrollToMiddle() {
		reusableActions.javascriptScrollToMiddleOfPage();
		
	}
	
	
	
}
