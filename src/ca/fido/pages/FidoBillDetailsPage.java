package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class FidoBillDetailsPage extends BasePageClass {

	public FidoBillDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	public enum BillinAndPaymentsOpt {
		ViewBill,
		MakePayment,
		ChangePaymentMethod,
		PaymentHistory

	}	

	@FindBy (xpath="//span[@class='accountDivider']")
	WebElement ddlAccountSelection;
	
	@FindBy (xpath="//div/button[@href='#/my-account/pay-now']")
	WebElement btnPayNow;
	
	@FindBy (xpath="//div[@ng-if='subscriberService.internet']/a/div/div[@class='item arrow']")
	WebElement badgeInternet;
	
	@FindBy (xpath="//div[@ng-if='subscriberService.wireless']/a")
	WebElement badgeWireless;
	
	@FindBy (xpath="//h1[@translate='global.label.welcomeText']")
	WebElement msgWelcome;
	
	@FindBy (xpath="//span[@class='account-balance-font-size']")
	WebElement infoAccountBalanceBeforePayment;
	
	@FindBy (xpath="//span[@class='account-balance-font-size']")
	WebElement infoAccountBalanceAfterpayment;
	
	@FindBy(xpath="//span[@translate='global.cta.changeMethodOfPayment']")
	WebElement lnkChangeMethodOfPayment;
	
	@FindBy(xpath="//select[@ng-model='props.selectedPaymentOption']")
	WebElement ddlPaymentOption;
	
	@FindBy(xpath="//div[@class='modal-body']/div[@class='alert alert-success']//descendant::p")
	WebElement successTextPreAutPayment; 
	
	@FindBy(xpath="//button[@class='ute-btn-primary ute-sm']/ins[@translate='global.cta.okCool']")
	WebElement btnOkCool;
	
	@FindBy(xpath="//div[@class='row page-dashboard-service-section']//div[@ng-repeat='subscriberService in account.subscriberServices track by $index'][1]")
	WebElement divFirstCTNBadge;
	
	@FindBy(xpath="//li[@class='services bill-pay']//span[@class='down-arrow-span']")
	WebElement menuBillingAndPayments; 
	
	@FindBy(xpath="//span[@translate='global.cta.viewBill']")
	WebElement subMenuViewBill;
	
	@FindBy(xpath="//span[@translate='global.cta.makePayment_header_menu']")
	WebElement subMenuMakeAPayment;
	
	@FindBy(xpath="//span[@translate='global.cta.changePaymentMethod_header_menu']")
	WebElement subMenuChangePaymentMethod;
	
	@FindBy(xpath="//span[@translate='global.label.paymentHistory']")
	WebElement subMenuPaymentHistory;
	
	@FindBy(xpath="//button/ins[@translate='global.cta.viewBill']")
	WebElement btnViewBill;

	@FindAll({
			@FindBy(xpath = "//select[@id='ds-form-input-id-1']"),
			@FindBy(id = "billDate")
	})
	WebElement ddlViewBill;
	
	@FindBy(id ="bbAppIFrame")
	WebElement frameViewBill;
	
	@FindBy(xpath = "//*[@id='billDate']")
	WebElement ddlViewBillMobile;
	
	@FindBy(xpath = "//*[@id='bbAppIFrame']")
	WebElement frameViewBillMobile;
	
	@FindBy(xpath = "//div[@class='amount ng-scope']")
	WebElement divBillValue;
		
	@FindBy(xpath = "//*[@id='bb-bs-bill-total']//div[@class='text-right title-right-part']/bb-amount")
	WebElement divBillValueNew;
		
	@FindBy(xpath = "//div[@class='visible-mobile hidden-desktop']//bb-amount")
	WebElement divBillValueNewMobile;
	
	@FindBy(xpath = "//div[@class='amount ng-scope']")
	WebElement divBillValueTaxes;
	
	@FindBy(xpath="//div[@class='summary-bar-title ng-binding']")
	WebElement lblBillSummaryTitle;
	
	@FindBy(xpath = "//div[@class='total-row sub-total row']")
	WebElement lblSubTotal;
	
	//On french as well the text is same 
	@FindBy(xpath = "//div[text()='Balance brought forward']/following-sibling::div")
	WebElement lblBalanceForward;
	
	//On french as well the text is same 
	@FindBy(xpath = "//div[text()='Account charges & credits']/following-sibling::div")
	WebElement lblAccountChargesAndCredits;
	
	//same for french
	@FindBy(xpath = "//div[text()='Total to pay']/following-sibling::div")
	WebElement lblTotalToPay;
	
	@FindBy(xpath = "//div[@class='row page-dashboard-service-section']//a[@class='btn']")
	WebElement btnCTNUsers;
	
	//same for french
	@FindBy(xpath = "//section[@class=\"welcome-area\"]//a/i/following-sibling::span[@id=\"save_desktop\" and text()='Save / Print this bill (PDF)']")
	WebElement lnkSaveOrPrintBill;

	
	@FindBy(xpath = "//*[@id='bill-summary-head']//span[@ng-if='!service']")
	WebElement divBillHeader;	
	
	@FindBy (xpath = "//ins[@translate='global.cta.refillNow']")
	WebElement btnRefillNow;
	
	@FindBy (xpath = "//div[@class='item content']")
	WebElement divCtnBadge;
	
	@FindBy(xpath = "//ins[@translate='global.message.myAccountNoBill']")
	WebElement lblNoBillLabel;
	
	@FindBy(xpath = "//*[@id='bb-bill-summary-page']//bb-bs-grand-total//span[text()='Total' or text()='']/parent::div/bb-amount")
	WebElement lblTotalToPayNew;

	@FindBy(xpath = "//ins[@translate='global.cta.change']")
	WebElement lnlChangePaymentMethod;

	@FindAll({
		@FindBy(xpath = "//li//a//ins[@translate='global.label.overview']"),
		@FindBy(xpath = "//ins[@translate='global.label.overview']")})
	WebElement lnkAccountOverview;
	
	@FindBy(xpath = "//*[@id='skipNavigationAngularMob']//ins[@translate='global.label.overview']")
	WebElement lnkAccountOverviewMobile;
	
	@FindBy(xpath = "//*[@class='modal-dialog']//*[@translate='global.label.overview']")
	WebElement lnkAccountOverviewOnModal;
	
	@FindBy(xpath = "//p[@class='bill-error-msg1' and (contains(text(),\"Il semble que nous ayons des\") or  contains(text(),\"Looks like we are having system issues\"))]")
	WebElement lblNoBillErrorMsg;

	@FindBy(xpath = "//h1[text()='Print']")
	WebElement titlePrintBillWindow;
	
	/**
	 * Click on refillNow button in overview page for Fido pre-paid account.
	 * @author Ning.Xue
	 */
    public void clkBtnRefillNow() {
	   reusableActions.getWhenReady(btnRefillNow, 20).click();
    }
    
    /**
     * click on CTN badge in overview page.
     * @author Ning.Xue
     */
	public void clkCtnBadge() {

		reusableActions.getWhenVisible(divCtnBadge, 30).click();
	}
	

   /**
    * Selects billing and payment sub menus
    * @param enumBillandPayopt enum values of billing and payment options
    * @author Mirza.Kamran
    */
   public void selectBillingAndPaymentsSubMenus(BillinAndPaymentsOpt enumBillandPayopt) {
	   reusableActions.clickIfAvailable(menuBillingAndPayments);
	   
	   switch(enumBillandPayopt)
	   {
		    case ViewBill:
		    	reusableActions.clickIfAvailable(subMenuViewBill);
			    break;		   
			case MakePayment:
				reusableActions.clickIfAvailable(subMenuMakeAPayment);
				break;
			case PaymentHistory:
				 reusableActions.clickIfAvailable(subMenuPaymentHistory);
				break;
			case ChangePaymentMethod:
				reusableActions.clickIfAvailable(subMenuChangePaymentMethod);
				break;
			default:
				break;
	   }
	   
   }   
   
   /**
    * Clicks on the button View Bill
    * @author Mirza.Kamran
    */
   public void clkViewBill() {
	   reusableActions.clickIfAvailable(btnViewBill);
	   
   }
   
   /**
    * Gets the addition of all the bill values mentioned on the CTN badges inside the Bill section
    * @return Double value containing the sum of all CTN bills
    * @author Mirza.Kamran
    */
   public Double getCTNBilltotal() {
	    getDriver().switchTo().defaultContent();
	    getDriver().switchTo().frame(frameViewBill);
		List<WebElement> ctnTotal=driver.findElements(By.xpath("//*[@id='detail-list']//b[@class='serviceSubTotalB total-amount ng-binding']"));		
		Double total=0.00;
		for(WebElement ele:ctnTotal) {			
			total=total+Double.parseDouble(ele.getText().split("\\$")[1]);
		}
		
		return total;
	}
   
   /**
    * Get the total CTN count on Bill Details page
    * @return Integer value containing the count of CTN badges displayed on Bill details page
    * @author Mirza.Kamran
    */
   public Integer getCTNBillCount() {
	   ///=== commented the old code =====Not deleting this for time being
	    getDriver().switchTo().defaultContent();
	    getDriver().switchTo().frame(frameViewBill);	    
		//List<WebElement> ctnTotal=driver.findElements(By.xpath("//*[@id='detail-list']//b[@class='serviceSubTotalB total-amount ng-binding']"));				
		List<WebElement> ctnSubTotal=driver.findElements(
				By.xpath("//div[@class='product-header']/span[contains(text(),'Mobile') or contains(text(),'Phone')]"));
		return ctnSubTotal.size();
	}
  
   /**
    * Get the total CTN count on Bill Details page
    * @return Integer value containing the count of CTN badges displayed on Bill details page
    * @author Mirza.Kamran
    */
   public Integer getCTNBillCountMobile() {
	   ///=== commented the old code =====Not deleting this for time being
	    getDriver().switchTo().defaultContent();
	    getDriver().switchTo().frame(frameViewBillMobile);	    
		//List<WebElement> ctnTotal=driver.findElements(By.xpath("//*[@id='detail-list']//b[@class='serviceSubTotalB total-amount ng-binding']"));				
		List<WebElement> ctnSubTotal=driver.findElements(
				By.xpath("//div[@class='product-header']/span[contains(text(),'Mobile') or contains(text(),'Phone')]"));
		return ctnSubTotal.size();
	}
  
   
   /**
    * Gets the first selected option of View Bill Drop down
    * @return the string containing the selected value of drop down view bill
    * @author Mirza.Kamran
    */
   public String getsTheSelectedValueInViewBillDropDown() {
	   reusableActions.waitForElementTobeClickable(ddlViewBill, 30);
	   reusableActions.staticWait(5000); //buffer waits for mobile scenarios
	   Select dropdown = new Select(ddlViewBill);		
	   return dropdown.getFirstSelectedOption().getText();
   }
   
   /**
    * Gets the first selected option of View Bill Drop down
    * @return the string containing the selected value of drop down view bill
    * @author Mirza.Kamran
    */
   public String getsTheSelectedValueInViewBillDropDownMobile() {
	   reusableActions.waitForElementTobeClickable(ddlViewBillMobile, 30);
	   reusableActions.staticWait(5000); //buffer waits for mobile scenarios
	   Select dropdown = new Select(ddlViewBillMobile);		
	   return dropdown.getFirstSelectedOption().getText();
   }
   
   /**
    * Gets the Bill AMount from the View Bill Drop Down on Bill Details page
    * @return string value containing the Bill amount from the view Bill drop down
    * @author Mirza.Kamran 
    */
   public String getBillAmountFromViewBillDropDown() {	   
	   String value = getsTheSelectedValueInViewBillDropDown().split("-")[0].trim();
	   value = value.replace("\n","").replace("$","");
	   return value;
   }     
   
   /**
    * Gets the Bill AMount from the View Bill Drop Down on Bill Details page
    * @return string value containing the Bill amount from the view Bill drop down
    * @author Mirza.Kamran 
    */
   public String getBillAmountFromViewBillDropDownMobile() {	   
	   return getsTheSelectedValueInViewBillDropDownMobile().split("-")[0].trim();	   
   }     
   
   /**
    * Selects the older Bill  from the View Bill Drop Down on Bill Details page
    * @return string value containing bill from the view Bill drop down
    * @author Mirza.Kamran 
    */
   public String selectOlderBillViewBillDropDown() {	   
	   Select dropdown = new Select(ddlViewBill);	
	   dropdown.selectByIndex(1);
	   return dropdown.getFirstSelectedOption().getText();
   }    
   
   /**
    * Selects the older Bill  from the View Bill Drop Down on Bill Details page
    * @return string value containing bill from the view Bill drop down
    * @author Mirza.Kamran 
    */
   public String selectOlderBillViewBillDropDownMobile() {	   
	   Select dropdown = new Select(ddlViewBillMobile);	
	   dropdown.selectByIndex(1);
	   return dropdown.getFirstSelectedOption().getText();
   }  
   
   /**
    * Checks if the label no bill is displayed
    * @return true if the label is displayed else false
    * @author Mirza.Kamran
    */
   public boolean isLabelComingSoonDisplayed()
   {
	   reusableActions.waitForElementVisibility(lblNoBillLabel, 300);
	   return reusableActions.isElementVisible(lblNoBillLabel);
	 
   }
   
   
   
   /**
    * Gets the Bill cycle form the View Bill drop down
    * @return String value containing the Bill Cycle Value
    * @author Mirza.Kamran
    */
   public String getBillCycleFromViewBillDropDown() {
	   return getsTheSelectedValueInViewBillDropDown().split("-")[1].trim();
   }
   
   /**
    * Gets the date from the Bill cycle Text in View Bill Drop down
    * @param strBillCycleText String containing Bill cycle text
    * @return returns String containing the date value
    * @throws ParseException Date parsing exception
    * @author Mirza.Kamran
    */
   public String getDateFromBillCycleTextInViewBillDropDown(String strBillCycleText) throws ParseException {
	   try {
		   Date date=new SimpleDateFormat("MMMM dd, yyyy").parse(strBillCycleText);	    
		   DateFormat dateFormat = new SimpleDateFormat("MMM dd");  
		   return dateFormat.format(date);
	   }catch(ParseException e)
	   {
		   Date date=new SimpleDateFormat("dd MMMM, yyyy",Locale.CANADA_FRENCH).parse(strBillCycleText);	    
		   DateFormat dateFormat = new SimpleDateFormat("MMM dd");  
		   return dateFormat.format(date);		   		  
	   }catch(Exception e)
	   {
		   return null;
	   }
   }

   /**
    * Gets the My Bill Value from the Bill Details View
    * @return Bill Value from the My Bill Box section
    * @author Mirza.Kamran
    */
   public String getMyBillValueDetails() {
	   
	   //===commenting the old code below ================
	   //return reusableActions.getWhenReady(divBillValue).getText().trim();
	   reusableActions.staticWait(5000);
	   return reusableActions.getWhenReady(divBillValueNew).getAttribute("amount").trim();
   }
   
   /**
    * Gets the My Bill Value from the Bill Details View
    * @return Bill Value from the My Bill Box section
    * @author Mirza.Kamran
    */
   public String getMyBillValueDetailsMobile() {
	   
	   //===commenting the old code below ================
	   //return reusableActions.getWhenReady(divBillValue).getText().trim();
	   return reusableActions.getWhenReady(divBillValueNewMobile).getAttribute("amount").trim();
   }
   
   /**
    * Gets the Bill Sub Total value 
    * @return double containing the Bill Sub Total value
    * @author Mirza.Kamran
    */
   public double getBillSubTotal() {
	   String strSubTotal = reusableActions.getWhenReady(lblSubTotal).getText();	    
	   return Double.parseDouble(strSubTotal.split("\\$")[1].trim());
   }
   
   /**
    * Gets the Bill balance forward value if displayed
    * @return Double value containing the Bill balance forward if displayed else returns 0
    * @author Mirza.Kamran
    */
	public double getBillBalanceForward() {
		 if(reusableActions.isElementVisible(lblBalanceForward))
		 {
			 return Double.parseDouble(reusableActions.getWhenReady(lblBalanceForward).getText().split("\\$")[1].split("Details")[0].trim());
		 }else
		 {
			 return 0;
		 }
		   		 
		 }
	
		/**
	    * Gets the Bill Account Charge Credit value if displayed
	    * @return Double value containing the Account charge credits if displayed else returns 0
	    * @author Mirza.Kamran
	    */
	 public double getBillAccountChargeCredits() {
		 if(reusableActions.isElementVisible(lblAccountChargesAndCredits))
		 {
			 return Double.parseDouble(reusableActions.getWhenReady(lblAccountChargesAndCredits).getText().split("\\$")[1].split("Details")[0].trim());
		 }else
		 {
			 return 0;
		 }
		   
	 }
 
	 
	 /**
	  * Gets the total to pay value from bill details page
	  * @return double value containing the total to pay bill value
	  */
	 public double getTotalToPayValue() {		 
		 // Double totaltoPay = Double.parseDouble(reusableActions.getWhenReady(lblTotalToPay).getText().split("\\$")[1].trim());
		 Double totaltoPay = Double.parseDouble(reusableActions.getWhenReady(lblTotalToPayNew).getAttribute("amount").trim());
		  DecimalFormat format = new DecimalFormat("##.00");		    
		  return Double.parseDouble(format.format(totaltoPay));
	 }
	 
	 /**
	  * Switches to the iframe View Bill
	  * @author Mirza.Kamran 
	  */
	 public void switchToFrameViewBill() {
		 getDriver().switchTo().frame(frameViewBill);
	 }
	 
	 /**
	  * Switches to the iframe View Bill
	  * @author Mirza.Kamran 
	  */
	 public void switchToFrameViewBillMobile() {
		 getDriver().switchTo().frame(frameViewBillMobile);
	 }
	 
	 /**
	  * Switches to the Default frame
	  * @author Mirza.Kamran
	  */
	 public void switchToDefaultContent() {
		 getDriver().switchTo().defaultContent();
	 }
   	
	 /**
	  * Checks if the Link save or print is Visible 
	  * @return true if the link is visible else false
	  * @author Mirza.Kamran
	  */
	 public Boolean verifyLinkSaveOrPrintBillIsPresent() {
		 return reusableActions.isElementVisible(lnkSaveOrPrintBill);
	 }
	 

	 
	/**
	 * Verifies if the Bill value in My Bill View Box matches the value in the view bill drop down
	 * @param strBillValueMain The string value of bill mentioned in the My Bill view Box
	 * @param strBillAmountInDropDowm string The value of bill mentioned in the view bill Drop down
	 * @return true if the bill values match else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfBillValueInMainViewAndBillAmountInDropdownMatch(String strBillValueMain,String strBillAmountInDropDowm) {
		return strBillValueMain.trim().contains(strBillAmountInDropDowm.trim());
	}
	 
	
	
	/**
	 * Compares the sum addition calculated value with the Total Bill value displayed 
	 * @param strSum Double value calculated bill sum
	 * @param strTotalToPay Double value as displayed on the bill details
	 * @return true if the values match else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfAddedSumValueMatchesTheTotalBillValueDisplayed(Double strSum,Double strTotalToPay) {
		return strSum.equals(strTotalToPay);		
	}
	
	/**
	 * Compares the sum of individual CTN bill values addition matches the sub total value displayed in the Bill section
	 * @param strSubTotal Double value containing the sub total values
	 * @return true if the CTN Bill value matches else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyAllCTNBillsMatchesTheSubTotalValue(Double strSubTotal) {
		return getCTNBilltotal().equals(strSubTotal);
	}
	
	/**
	 * verifies if the total CTN displayed on the Bills page is equal to the total CTN badges displayed on account overview page
	 * @param totalCTN Integer value of total CTN displayed on account overview page
	 * @return true if the count matches else false
	 *@author Mirza.Kamran
	 */
	public Boolean verifyCTNBillCountMatchesTheTotalCTNFromOverviewPage(Integer totalCTN) {
		return getCTNBillCount().equals(totalCTN);		
	}
	
	/**
	 * verifies if the total CTN displayed on the Bills page is equal to the total CTN badges displayed on account overview page
	 * @param totalCTN Integer value of total CTN displayed on account overview page
	 * @return true if the count matches else false
	 *@author Mirza.Kamran
	 */
	public Boolean verifyCTNBillCountMatchesTheTotalCTNFromOverviewPageMobile(Integer totalCTN) {
		return getCTNBillCountMobile().equals(totalCTN);		
	}
	
   /**
    * This methods parses and extracts the phone numbers from the CTN badges
    * @param strCTNDetails String text value displayed in CTN badge
    * @return string containing the CTN phone numbers, else null
    * @author Mirza.Kamran
    */
	public String getPhoneNumberFromCTNbadge(String strCTNDetails) {
	      	      
	      Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
	      String[] temp = strCTNDetails.split(" ");
	      String contact = "";
	      Boolean found = false;
	      for(String item: temp)
	      {
	    	  Matcher match = pattern.matcher(item);
	    	  if (match.matches()) {
	    		  contact = item;
	    		  found = true;
	    		  break;
		      }		      
	      }
	      
	      if(found)
	      {
	    	  return contact;
	      }else
	      {
	    	  return null;
	      } 
	      	      
	 }

	/**
	 * 
	 */
	public void clkChangePaymentMethod() {
	reusableActions.getWhenReady(lnlChangePaymentMethod,30).click();
	
	}

	/**
	 * 
	 */
	public void clkAccountOverview() {
		reusableActions.staticWait(5000);
		reusableActions.getWhenReady(lnkAccountOverview,30).click();
	}
	 
	/**
	 * 
	 */
	public void clkAccountOverviewMobile() {
		reusableActions.getWhenReady(lnkAccountOverviewMobile).click();
		reusableActions.waitForElementTobeClickable(lnkAccountOverviewOnModal, 30);
		reusableActions.getWhenReady(lnkAccountOverviewOnModal).click();
	}
	
	   /**
	    * Checks if the label "no bill Error Msg" is displayed
	    * @return true if the label is displayed else false
	    * @author Karthic.Hasan
	    */
	public boolean verifyBillErrorMsg() {
		return reusableActions.isElementVisible(lblNoBillErrorMsg);
	}

	
	public void switchToPrintWindow(String strParentWindowHandle) {
		reusableActions.switchToNewWindow(strParentWindowHandle);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isPrintBillPDFpresent() {	
		reusableActions.waitForNumberOfWindowsToBe(2, 60);
		return getDriver().getWindowHandles().toArray().length>1;
	}
	  
}
