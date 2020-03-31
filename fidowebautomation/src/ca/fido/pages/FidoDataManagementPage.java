package ca.fido.pages;


import java.util.List;

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
	
	@FindBy (xpath = "//h4[contains(text(),'ADDED DATA') or contains(text(),'DONNÉES AJOUTÉES')]")
	WebElement titleAddedData;
	
	@FindBy (xpath = "//h4[contains(text(),'TOTAL DATA') or contains(text(),'TOTAL DES DONNÉES')]")
	WebElement titleTotalData;
	
	@FindBy (xpath = "//span[contains(text(),'Back') or contains(text(),'Précédent')]")
	WebElement lnkBackOnManageDataOverlay;
	
	@FindBy (xpath = "//strong")
	List<WebElement> listData;
	 
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
				if (strAddData.substring(strAddData.length()-2).equalsIgnoreCase("GB")
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
	
}
