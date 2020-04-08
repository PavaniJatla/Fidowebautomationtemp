package ca.fido.pages;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ca.fido.pages.base.BasePageClass;



public class FidoDataManagementPage extends BasePageClass {

	public FidoDataManagementPage(WebDriver driver) {
		super(driver);		
	}
	
	
	@FindBy (xpath = "//h1[@class='manage-data-title mb-10 ng-star-inserted']")
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

	@FindBy (xpath = "//span[@translate='usageModule.manage']")
	WebElement lnkViewDetails;

	@FindBy (xpath = "//*[text()='Cancel' or text()='Annuler']")
	WebElement lnkCancel;
	 
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
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAccuracyManageDataOverlay() {
		String strPlanData = rowPlanData.getText();		
		strPlanData=getNumbersFromString(strPlanData);				
		double intPlanData = Double.parseDouble(strPlanData);
				
		String strTotalData = rowsTotalData.get(0).getText();
		double intTotalData = Double.parseDouble(getNumbersFromString(strTotalData));
		double intAddData = 0;
		
			for (int iLoop = 0; iLoop <= rowsAddedData.size()-1; iLoop++) {
				String strAddData = rowsAddedData.get(iLoop).getText();				
				if (strAddData.toLowerCase().contains("mo")?strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MO")
						: strAddData.substring(strAddData.length()-2).equalsIgnoreCase("MB")) {
					intAddData = intAddData / 1000;					
				}
				intAddData = intAddData + Double.parseDouble(strAddData.substring(0, strAddData.length()-3));
			}
			String strTotalAddon = rowsTotalData.get(1).getText();
			double intTotalAddon = Double.parseDouble(getNumbersFromString(strTotalAddon)); 
			return intTotalData == intPlanData 
					&& intTotalAddon == intAddData;
	}
	
	public String getNumbersFromString(String strMatch) {
		Pattern p = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
        Matcher m = p.matcher(strMatch);  
        m.find();
        return m.group();
	}
	
	/**
	 * 
	 * @return
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
	 * This method gets the Speed pass count
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public int getAllExistingAddOTTCount() {
		return rowsAddedData.size();
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
	
}
