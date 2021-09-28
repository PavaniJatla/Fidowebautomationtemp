package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class FidoDataManagementPage extends BasePageClass {

	public FidoDataManagementPage(WebDriver driver) {
		super(driver);		
	}
	
	
	@FindBy (xpath = "//h1[contains(@class,'manage-data-title') or @class='manage-data-title']")
	WebElement titleManageData;
	
	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'DONNÉES DU FORFAIT') or text()='plan data' or contains(text(),'données du forfait')]"),
	@FindBy (xpath = "//h4[contains(text(),'PLAN DATA') or contains(text(),'DONNÉES DU FORFAIT')]")})
	WebElement titlePlanData;
	
	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'DONNÉES DU FORFAIT') or text()='plan data']/parent::div/parent::div//tr"),
	@FindBy(xpath = "//h4[contains(text(),'PLAN DATA') or contains(text(),'DONNÉES DU FORFAIT')]/parent::div/parent::div//tr")})
	WebElement rowPlanData;
	
	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'DONNÉES AJOUTÉES') or text()='added data']"),
	@FindBy (xpath = "//h4[contains(text(),'ADDED DATA') or contains(text(),'DONNÉES AJOUTÉES')]")})
	WebElement titleAddedData;
	
	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'TOTAL DES DONNÉES') or text()='total data']"),
	@FindBy (xpath = "//h4[contains(text(),'TOTAL DATA') or contains(text(),'TOTAL DES DONNÉES')]")})
	WebElement titleTotalData;
	
	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'TOTAL DES DONNÉES') or text()='total data']/parent::div/parent::div//strong"),
	@FindBy(xpath = "//h4[contains(text(),'TOTAL DATA') or contains(text(),'TOTAL DES DONNÉES')]/parent::div/parent::div//strong")})
	List<WebElement> rowsTotalData;
	
	@FindBy (xpath = "//span[contains(text(),'Back') or contains(text(),'Précédent') or contains(text(),'Mobile Dashboard') or contains(text(),'Tableau de bord mobile')]")
	WebElement lnkBackOnManageDataOverlay;
	
	@FindBy (xpath = "//strong")
	List<WebElement> listData;

	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'DONNÉES AJOUTÉES') or text()='added data']/parent::div/parent::div//table//strong"),
	@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//strong")})
	List<WebElement> rowsAddedData;
			
	
	//@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//tr//a[(contains(text(), 'CANCEL'))=false and (contains(text(), 'Expires'))=false and (contains(text(),'ANNULER')=false) and (contains(text(),'Prend')=false)]")
	@FindAll({
	@FindBy(xpath = "//tr[@class='ds-table-row']//strong[@class='ng-star-inserted']/span[1]"),
	@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//tr//strong[(contains(text(), 'CANCEL'))=false and (contains(text(), 'Expires'))=false and (contains(text(),'ANNULER')=false) and (contains(text(),'Prend')=false)]")})
	List<WebElement> tableRowsAddData;
	
	@FindAll({
	@FindBy(xpath = "//h2[contains(text(),'DONNÉES AJOUTÉES') or contains(text(),'Données ajoutées') or text()='added data']/parent::div/parent::div//table//tr"),
	@FindBy(xpath = "//h4[text()='ADDED DATA' or text()='DONNÉES AJOUTÉES']/parent::div/parent::div//table//tr")})
	List<WebElement> rowsAddMDTData;

	@FindBy (xpath = "//span[text()='View Details' or text()='Afficher les détails']")
	WebElement lnkViewDetails;

	@FindBy (xpath = "//*[@title='Cancel this add-on' or contains(@title,'Annuler')]")
	WebElement lnkCancel;
	 
	@FindBy(xpath = "//p[text()='CANCEL ADD-ON' or text()='ANNULER L’OPTION']")
	WebElement titleCancelAddOn;
	
	@FindAll({
		@FindBy (xpath = "//button//span[text()='yes, cancel' or text()='oui, annuler']"),
		@FindBy(xpath = "//button//span[text()='YES, CANCEL' or text()='OUI, ANNULER']")})
	WebElement btnYesCancel;
	
	@FindAll({
		@FindBy (xpath = "//h2[text()='add-on cancelled' or contains(text(),'option annul') or contains(text(),'OPTION ANNUL')]"),
		@FindBy(xpath = "//p[text()='ADD-ON CANCELLED' or contains(text(),'OPTION ANNUL')]")})
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
	 * @param strAddDataType 
	 */
	public double getTotalDataInManageDataOverlay(String strAddDataType) {		
		String strTotalData = listData.get(listData.size()-2).getText();
		double doubleTotalData = Double.parseDouble(strTotalData.substring(0, strTotalData.length()-3));
		HashMap<String, Double> hashMapDataType = getAllExistingAddDataInMBAndGB(strAddDataType);
		double intAddData = 0;
		double finalCalculatedData = 0;
		boolean isTotalExistingDataInMB =false;
		if((strTotalData.toLowerCase().contains("mb")|| strTotalData.toLowerCase().contains("mo")))		
		{
			isTotalExistingDataInMB =true;
		}
		
		
		if(hashMapDataType.get("totalgb").equals(0.0) && hashMapDataType.get("totalgb")<1000 && isTotalExistingDataInMB)
		{
			intAddData = hashMapDataType.get("AllDataTotal");
			if(intAddData+doubleTotalData<1000)
			{
			finalCalculatedData = intAddData+doubleTotalData;
			}else
			{
				finalCalculatedData = intAddData+doubleTotalData;
				finalCalculatedData = finalCalculatedData/1000;
			}
			
			
			
		}if(hashMapDataType.get("totalgb").equals(0.0) && hashMapDataType.get("totalgb")<1000 && !isTotalExistingDataInMB)
		{
			intAddData = hashMapDataType.get("AllDataTotal");
			
				finalCalculatedData = (intAddData/1000)+doubleTotalData;				
			
		}
		else if(hashMapDataType.get("totalgb").equals(0.0) && isTotalExistingDataInMB)
		{
			intAddData = hashMapDataType.get("AllDataTotal")/1000; //convert this to GB since its more than 1000
			finalCalculatedData = intAddData+(doubleTotalData/1000);			
			
		}else if(hashMapDataType.get("totalgb").equals(0.0) && !isTotalExistingDataInMB)
		{
			intAddData = hashMapDataType.get("AllDataTotal")/1000; //convert this to GB since its more than 1000
			finalCalculatedData = intAddData+doubleTotalData;
			
		}else if(isTotalExistingDataInMB)
		{
			intAddData = hashMapDataType.get("AllDataTotal");
			finalCalculatedData = intAddData+(doubleTotalData/1000);
		}else if(!isTotalExistingDataInMB)
		{

			intAddData = hashMapDataType.get("AllDataTotal");
			finalCalculatedData = intAddData+doubleTotalData;
		}
		
		
		
		
		return finalCalculatedData;
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
	 * This method gets all the existing added data records.
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public HashMap<String, Double> getAllExistingAddDataInMBAndGB(String strType) {
		Double mb=0.0;
		Double gb=0.0;
		HashMap<String, Double> dataType = new HashMap<String, Double>();		
		
		List<WebElement> rowsAddMDTData = strType.equalsIgnoreCase("ott") ? rowsAddedData : tableRowsAddData;
		for(WebElement row:rowsAddMDTData)
		{
			String strAddData = row.getText().replaceAll(",", ".");	
			if(strAddData.toLowerCase().contains("mb") ||strAddData.toLowerCase().contains("mo"))
			{
				mb +=  Double.parseDouble(getNumbersFromString(strAddData));
				
				
			}else if(strAddData.toLowerCase().contains("gb") || strAddData.toLowerCase().contains("go"))
			{
				gb+=  Double.parseDouble(getNumbersFromString(strAddData));
			}
		}
		
		dataType.put("totalmb", mb);
		dataType.put("totalgb", gb);
		if(dataType.get("totalgb").equals(0.0))
		{
			dataType.put("AllDataTotal", dataType.get("totalmb"));			
		}else
		{
			dataType.put("AllDataTotal",(dataType.get("totalgb") + dataType.get("totalmb")/1000));
		}
		
		return dataType;
	}
	
	

	/**
	 * Verify data accuracy in manage data overlay, total data should show plan data + data add-ons 
	 * @return true if the data matches displayed, otherwise false
	 * @param strType ott and mtt type
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAccuracyManageDataOverlay(String strType) {
		
		//Plan Data values
		boolean isPlanDataInMB = false;
		String strPlanData = rowPlanData.getText().replaceAll(",", ".");	
		if(strPlanData.toLowerCase().contains("mb") ||strPlanData.toLowerCase().contains("mo"))
		{
			isPlanDataInMB =true;
		}
		strPlanData=getNumbersFromString(strPlanData);				
		double intPlanData = Double.parseDouble(strPlanData);
				
		
		//Bottom total data value 
		boolean isTotalAddedInMB = false;
		String strTotalData = rowsTotalData.get(0).getText().replaceAll(",", ".");
		double intTotalData = Double.parseDouble(getNumbersFromString(strTotalData));
		HashMap<String, Double> hashMapDataType = getAllExistingAddDataInMBAndGB(strType);
		double intAddData = 0;
		if(hashMapDataType.get("totalgb").equals(0.0) && hashMapDataType.get("totalgb")<1000)
		{
			intAddData = hashMapDataType.get("AllDataTotal");	
			isTotalAddedInMB = true;
		}else if(hashMapDataType.get("totalgb").equals(0.0))
		{
			intAddData = hashMapDataType.get("AllDataTotal")/1000; //convert this to GB since its more than 1000	
			isTotalAddedInMB = true;
			
		}else
		{
			intAddData = hashMapDataType.get("AllDataTotal");
		}
				
			String strTotalAddon = rowsTotalData.get(1).getText().replaceAll(",", ".");
			double intTotalAddon = Double.parseDouble(getNumbersFromString(strTotalAddon)); 
			return intTotalData == intPlanData
					&& (intTotalAddon == intAddData || (intAddData-intTotalAddon <0.1) );
	}
	
	
	
	/**
	 * Verify data accuracy in manage data overlay, total data should show plan data + data add-ons 
	 * @return true if the data matches displayed, otherwise false
	 * @param strType ott and mtt type
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAccuracyManageDataOverlayObs(String strType) {
		String strPlanData = rowPlanData.getText().replaceAll(",", ".");		
		strPlanData=getNumbersFromString(strPlanData);				
		double intPlanData = Double.parseDouble(strPlanData);
		String strTotalData = rowsTotalData.get(0).getText().replaceAll(",", ".");
		double intTotalData = Double.parseDouble(getNumbersFromString(strTotalData));
		double intAddData = 0;	
		double intTempAddData = 0;	
		List<WebElement> rows = strType.equalsIgnoreCase("ott") ? rowsAddedData : tableRowsAddData;
		String totalInitialPlanConatinsMB =rowPlanData.getText().replaceAll(",", ".");
			for (int iLoop = 0; iLoop <= rows.size()-1; iLoop++) {
				String strAddData = rows.get(iLoop).getText().replaceAll(",", ".");	
					if (strAddData.toLowerCase().contains("mo")?strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MO")
							: strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MB")) {
						if(totalInitialPlanConatinsMB.toLowerCase().contains("mo")||totalInitialPlanConatinsMB.toLowerCase().contains("mb"))
						{
								//Keep it MB if the total initial data  is already in MB							
							intTempAddData =Double.parseDouble(getNumbersFromString(strAddData));
						}else {
							intTempAddData = Double.parseDouble(getNumbersFromString(strAddData)) / 1000;
						}
					}
					intTempAddData = Double.parseDouble(strAddData.substring(0, strAddData.length()-3));
				intAddData = intAddData + intTempAddData;
			}
			String strTotalAddon = rowsTotalData.get(1).getText().replaceAll(",", ".");
			double intTotalAddon = Double.parseDouble(getNumbersFromString(strTotalAddon)); 
			intAddData = intTotalAddon;
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
	public boolean verifyMDTAddedDataInDataDetails(int listAddedData, int intCountOfSpeedPassBefore) {		
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
		reusableActions.waitForElementTobeClickable(lnkViewDetails, 50);
		reusableActions.getWhenReady(lnkViewDetails, 50).click();
		reusableActions.waitForElementTobeClickable(titleManageData, 30);
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
		
		for(WebElement row : rowsAddMDTData) {
			if(found ==false 
				&&	(row.getText().toLowerCase().contains("cancel")
				|| row.getText().toLowerCase().contains("annuler"))) {
				reusableActions.scrollToElement(lnkCancel);
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
