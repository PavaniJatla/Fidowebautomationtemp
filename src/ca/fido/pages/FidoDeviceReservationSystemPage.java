package ca.fido.pages;


import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Hashtable;
import java.util.Map;

public class FidoDeviceReservationSystemPage extends BasePageClass {

	public FidoDeviceReservationSystemPage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy (xpath = "//input[@class='btn' and (@value='Reserve a phone' or @value='Réserver un téléphone')]")
	WebElement btnReserveAPhone;

	@FindBy (xpath = "//input[@class='btn' and (@value='Back To My Account' or @value='Retour à mon compte')]")
	WebElement btnBackToMyAccount;
	
	@FindBy (xpath = "//h4[contains(text(),'Fido Number') or contains(text(),'Numéro Fido')]/parent::td/parent::tr/following-sibling::tr//select")
	WebElement selectFidoNumber;
	
	@FindBy (xpath = "//span[text()='Phone model:' or text()='Modèle de téléphone:']/parent::h4/parent::td/parent::tr/following-sibling::tr//select[contains(@name,'deviceFamilyListId')]")
	WebElement selectPhoneFamilyModel;
	
	@FindBy (xpath = "//span[text()='Phone model:' or text()='Modèle de téléphone:']/parent::h4/parent::td/parent::tr/following-sibling::tr//select[contains(@name,'deviceListId')]")
	WebElement selectPhoneModel;
	
	@FindBy(className = "resContactEmail")
	WebElement txtReservationContactEmail;
	
	@FindBy(xpath = "//input[@value='Next' or @value='Suivant']")
	WebElement btnNext;
	
	@FindBy(xpath = "//span[@id=\"mainBlock:formBlock:pickUpLoc\"]//input[@value='Next' or @value='Suivant']")
	WebElement btnNextOnPickUpLocationSection;
	
	@FindBy(id = "postcode")
	WebElement txtPostalCode;
	
	@FindBy(id = "proximity")
	WebElement selectPostalCodeWithin;
	
	@FindBy(xpath = "//select[@id='proximity']/parent::td/following-sibling::td/input[@value='Go' or @value='Aller']")
	WebElement btnGoFindAStoreByPostalCode;
	
	@FindBy(xpath = "//td[@id=\"storeHighlight_1\"]")
	WebElement rowFirstStore;
	

	@FindBy(id ="agree")
	WebElement chkAgreeTnC;

	@FindBy(xpath = "//input[@value='Reserve' or @value='Réserver']")
	WebElement btnReserve;

	@FindBy(xpath = "//h3[@class='introHeaderTextCong']")
	WebElement labelReservationConfirmed;

	@FindBy(xpath = "//a[text()='Cancel Reservation' or text()='Annuler la réservation']")
	WebElement lnkCancelReservation;
	
	@FindBy(xpath = "//div[@id=\"fancybox-wrap\"]//input[@value='YES' or @value='Oui']")
	WebElement btnYesOnOverlay;
	
	@FindBy(name = "sf_iframe")
	WebElement fraReserveADevice;
	
	@FindBy(id = "mainBlock:formBlock:deviceImage")
	WebElement imgPhone;
	
	@FindBy(id = "map_nrscanvas")
	WebElement divMapCanvas;
	
	@FindBy(id = "store_details")
	WebElement divStoreDetails;
	
	@FindBy(id = "storeName_selected")
	WebElement lblStoreNameSelected;
	
	@FindBy(id = "warningSelected")
	WebElement divNoteOnlyAccountHolderCanPickUp;
	
	//Review Page
	
	@FindBy(id="mainBlock:formBlock:deviceImageRevice")
	WebElement imgPhoneOnReviewPage;
	
	@FindBy(id = "secondLoc")
	WebElement divPickUpLocationAddress;
	
	@FindBy(id = "mainBlock:formBlock:devDescPanelId")
	WebElement labelPhoneModelName;
	
	@FindBy(xpath = "//table//h3[text()='MODALITÉS DU SERVICE DE RÉSERVATION DE PRODUIT' or text()='ONLINE PRODUCT RESERVATION SERVICE TERMS AND CONDITIONS']")
	WebElement divProductTnCText;
	
	@FindBy(xpath = "//table//b[text()='Reservation Contact Information' or text()='Contact pour la réservation']")
	WebElement lblreservationContactInforSection;
	
	@FindBy(xpath = "//table//b[text()='Account Details' or text()='Infos sur le compte']")
	WebElement lblAccountDetails;
	
	//Your reservation is confirmed section
	
	@FindBy(id="mainBlock:formBlock:theImageCong")
	WebElement imgPhoneOnReservationConfirmedPage;
	
	@FindBy(xpath = "//table//*[contains(text(),'Pickup Location') or contains(text(),'Magasin de livraison:')]")
	WebElement tablePickUpLocationDetails;
	
	@FindBy(xpath = "//table//*[contains(text(),'Account Details') or contains(text(),'Infos sur le compte')]")
	WebElement tableAccountDetails;
	

	
	/**
	 * Gets the selected value from the select box fido number
	 * @return string containing fido number
	 * @author Mirza.Kamran
	 */
	public String getSelectedFidoNumberIFrame() {
		reusableActions.waitForElementVisibility(selectFidoNumber);
		return reusableActions.getSelectedValue(selectFidoNumber);		
	}
	
	/**
	 * clicks on the button reserve a phone
	 * @author Mirza.Kamran
	 */
	public void clkReserveAPhoneButtonIFrame() {
		reusableActions.waitForElementTobeClickable(btnReserveAPhone, 30);
		reusableActions.executeJavaScriptClick(btnReserveAPhone);
	}
	
	/**
	 * Checks if the button Reserve phone is displayed
	 * @return true of the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public Boolean isReserveAPhoneButtonDisplayedIFrame() {
		return btnReserveAPhone.isDisplayed();
	}
	/**
	 * select model and config for the  phone device to be reserved
	 * @return HasTable containing values for "PhoneFamilyDetails" and "PhoneModel"
	 * @author Mirza.Kamran 
	 */
	public Map<String, String> selectPhoneModelAndConfigIFrame() {
		reusableActions.selectWhenReady(selectPhoneFamilyModel,1);
		reusableActions.staticWait(2000);
		reusableActions.waitForElementTobeClickable(selectPhoneModel, 10);
		reusableActions.selectWhenReady(selectPhoneModel, 0);
		Map<String, String> dictPhoneDetails = new Hashtable<String, String>();
		dictPhoneDetails.put("PhoneFamilyDetails", reusableActions.getSelectedValue(selectPhoneFamilyModel));
		dictPhoneDetails.put("PhoneModel", reusableActions.getSelectedValue(selectPhoneModel));
		return dictPhoneDetails;
	}
	
	/**
	 * Sets the email details for the reservation contact details section
	 * @param strEmail string containing email 
	 * @author Mirza.Kamran
	 */
	public void setReservationContactEmailIFrame(String strEmail) {
		reusableActions.enterText(txtReservationContactEmail, strEmail, 30);
	}
	
	/**
	 * Selects the pick up location's postal code and within range
	 * @param strPostalCode string postal code
	 * @param strWithinRange string within range
	 * @author Mirza.Kamran
	 */
	public void selectPickUpLocationPostalCodeAndWithInRangeIFrame(String strPostalCode, String strWithinRange) {
		reusableActions.waitForElementVisibility(txtPostalCode, 30);
		reusableActions.waitForElementTobeClickable(txtPostalCode, 30);
		reusableActions.enterText(txtPostalCode, strPostalCode, 20);
		reusableActions.staticWait(2000);		
		reusableActions.selectWhenReadyByVisibleText(selectPostalCodeWithin, strWithinRange);
	}
	
	/**
	 * Clicks on the Go button on pick up location page
	 * @author Mirza.Kamran
	 */
	public void clkGoFindAStoreByPickUpLocationIFrame() {				
		reusableActions.waitForElementTobeClickable(btnGoFindAStoreByPostalCode, 60);
		reusableActions.executeJavaScriptClick(btnGoFindAStoreByPostalCode);
		reusableActions.staticWait(5000);//buffer static added on purpose to stabelize the script
	}
	
	/**
	 * Clicks on select a store first option
	 * @author Mirza.Kamran
	 * @return true if the store is selected successfully else false
	 */
	public boolean clkSelectAStoreFirstOptionIFrame() {
		reusableActions.waitForElementVisibility(rowFirstStore, 60);
		reusableActions.waitForElementTobeClickable(rowFirstStore, 30);
		
		if(rowFirstStore.isDisplayed())
		{
		  reusableActions.executeJavaScriptClick(rowFirstStore);
		  reusableActions.staticWait(4000);
		  //reusableActions.javascriptScrollByVisibleElement(rowFirstStore);
		  return true;
		}else
		{
			return false;
		}		
	}
	
	/**
	 * Clicks the next button on device reservation flow
	 * @author Mirza.Kamran
	 */
	public void clkNextIFrame() {
		reusableActions.waitForElementTobeClickable(btnNext, 30);
		reusableActions.executeJavaScriptClick(btnNext);
		//reusableActions.clickWhenReady(btnNext);
	}

	/**
	 * Clicks the check box to accept TnC
	 * @author Mirza.Kamran
	 */
	public void clkIAgreeToTnCCheckBoxIFrame() {
		reusableActions.waitForElementTobeClickable(chkAgreeTnC, 30);
		reusableActions.executeJavaScriptClick(chkAgreeTnC);
	}
	
	/**
	 * Clicks on the reserve button
	 * @author Mirza.Kamran
	 */
	public void clkReserveButtonIFrame() {
		reusableActions.waitForElementTobeClickable(btnReserve, 30);
		reusableActions.executeJavaScriptClick(btnReserve);
	}
	
	/**
	 * Clicks on the button back to my account
	 * @author Mirza.Kamran
	 */
	public void clkBackToMyaccountButtonIFrame() {
		reusableActions.waitForElementTobeClickable(btnBackToMyAccount, 60);
		reusableActions.executeJavaScriptClick(btnBackToMyAccount);
	}
	
	/**
	 * Clicks yes on the are you sure overlay
	 * @author Mirza.Kamran
	 */
	public void clkYesButtonOnAreYouSureOverLayIFrame() {
		try {
			reusableActions.waitForElementTobeClickable(btnYesOnOverlay, 60);
			reusableActions.executeJavaScriptClick(btnYesOnOverlay);	
		}catch (Exception e) {
			System.out.println("Supressed the java script exception whenever it occurs on firefox");
		}
		
	}

	/**
	 * Switches to the reserve a device iframe
	 * @author Mirza.Kamran
	 */
	public void switchToIFrame() {
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraReserveADevice, 120);
		
	}

	/**
	 * Checks if already reserved devices are available, then it cancels the reservations
	 * @author Mirza.Kamran
	 */
	public void cancelAllDeviceReservationBeforeReservingANewOneIFrame() {	
		while (lnkCancelReservation.isDisplayed()) {
			reusableActions.clickIfAvailable(lnkCancelReservation);
			reusableActions.waitForElementTobeClickable(btnYesOnOverlay, 10);
			reusableActions.javascriptScrollByVisibleElement(btnYesOnOverlay);
			try {
			reusableActions.executeJavaScriptClick(btnYesOnOverlay);
			}catch (Exception e) {
				System.out.println("Supress Java script error whenever it occurs on firefox");
			}
			reusableActions.staticWait(2000);
		}
		
	}
	
	/**
	 * Checks if the Phone image is displayed on Phone selection section
	 * @return true if the phone image is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyThePhoneImageIsLoadedIFrame() {
		return imgPhone.isDisplayed();
	}
	
	/**
	 * Checks if the store details is displayed below the map after selction
	 * @return true if the store details displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyStoreDetailsIsDisplayedBelowTheMapAfterAddressIsSelectedIFrame() {
		return divStoreDetails.isDisplayed() && lblStoreNameSelected.isDisplayed();
	}
	
	/**
	 * Checks if the warning note is displayed after Address is selected
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyWarningNoteIsDisplayedAfterAddressIsSelectedIFrame() {
		return divNoteOnlyAccountHolderCanPickUp.isDisplayed();
	}
	
	/**
	 * Checks if the map section is displayed
	 * @return true if the map is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMapSectionIsDisplayedIFrame() {	
		return divMapCanvas.isDisplayed();
		
	}
	
	
	/**
	 * Checks if the phone image is displayed on review page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfPhoneImageIsDisplayedOnReviewPageIFrame() {
		return imgPhoneOnReviewPage.isDisplayed();
	}
	
	
	/**
	 * Checks if the pick up location is displaye don review page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfSectionPickUpLocationIsDisplayedOnReviewPageIFrame() {
		return divPickUpLocationAddress.isDisplayed();
	}
	
	/**
	 * Checks if the Phone model details are displayed on review page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfPhoneModelDetailsIsDisplayedOnReviewPageIFrame() {
		return labelPhoneModelName.isDisplayed();
	}
	
	
	/**
	 * Checks if the T and C details are displayed on review page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfTermsAndConditionsSectionIsDisplayedOnReviewPageIFrame() {
		return divProductTnCText.isDisplayed();
	}
	
	
	/**
	 * Checks if the Contact info details are displayed on review page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfContactInfoSectionIsDisplayedOnReviewPageIFrame() {
		return lblreservationContactInforSection.isDisplayed();
	}
	
	
	/**
	 * Checks if the Account details are displayed on review page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfLabelAccountDetailsIsDisplayedOnReviewPageIFrame() {
		return lblAccountDetails.isDisplayed();
	}
	
	//Your reservation is confirmed section
	
	/**
	 * Checks if the Phone image is displayed on Reservation confirmed page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfPhoneImageIsDisplayedOnRservationConfirmedPageIFrame() {
		reusableActions.waitForElementVisibility(imgPhoneOnReservationConfirmedPage, 60);
		return imgPhoneOnReservationConfirmedPage.isDisplayed();
	}
	
	/**
	 * Checks if the Pick up location is displayed on Reservation confirmed page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfTablePickUpLocationIsDisplayedOnReservationConfirmationPageIFrame() {
		return tablePickUpLocationDetails.isDisplayed();
	}
	
	/**
	 * Checks if the Account details is displayed on Reservation confirmed page
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfTableAccountDetailsIsDisplayedOnReservationConfirmationPageIFrame() {
		return tableAccountDetails.isDisplayed();
	}

	/**
	 * Performs click on the next button on the Pick up section
	 * @author Mirza.Kamran
	 */
	public void clkNextOnPickUpSectionIFrame() {
		reusableActions.staticWait(4000);
		reusableActions.waitForElementTobeClickable(btnNextOnPickUpLocationSection, 30);
		reusableActions.executeJavaScriptClick(btnNextOnPickUpLocationSection);
		
	}
	
	
}
