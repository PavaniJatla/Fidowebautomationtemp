package com.rogers.test.tests.buyflowsoneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC06-OV-HUP_Singleline Account_Validate if user is able to place an order in HUP flow with existing plan_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC06_HUPSingleLine_ChooseExistingPlan_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","SanityBFA","HupOvBFA"})
    public void hupSingleLineChooseExistingPlanFlow() {
		reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
		reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase06.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//getAccountOverViewPage().clkBtnOkOneViewDialoue();
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page not loaded" , "Wireless page not loaded" );
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Device upgrade button clicked");
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyChoosePhonePage() , "Choose Phone page loaded" , "Choose Phone page not loaded");
		getRogersOVChoosePhonePage().searchDevice(TestDataHandler.buyFlowsOVtestCase06.getNewDevice());
		getRogersOVChoosePhonePage().selectFirstAvailableDevice();
		reporter.hardAssert(getRogersOVBuildPlanPage().verifyBuildPlanPage() , "Build plan page loaded" , "Build plan page not loaded");
		reporter.reportLogWithScreenshot("Rogers Build Plan Page");
		getRogersOVBuildPlanPage().selectExistingPlan();
		reporter.reportLogWithScreenshot("Existing plan selected");
		getRogersOVBuildPlanPage().clkContinue();
		reporter.hardAssert(getRogersOVChooseAddonsPage().verifyChooseAddOnPage() , "Addons page loaded" , "Addons page not loaded");
		reporter.reportLogWithScreenshot("Rogers Additional line option page");
		getRogersOVChooseAddonsPage().clkContinueHUP();
		reporter.hardAssert(getRogersOVShippingPage().verifyShippingPage() , "Shipping page loaded" , "Shipping page not loaded");
		reporter.reportLogWithScreenshot("Rogers Shipping Page");
		getRogersOVShippingPage().clkRadioBillingAddress();
		getRogersOVShippingPage().setEmailIDAndSave();
		getRogersOVShippingPage().setPhoneNumberAndSave();
		getRogersOVShippingPage().clkSelectAvailableTime();
		getRogersOVShippingPage().clkReserve();
		reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        getRogersOVShippingPage().clkContinue();
		reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewPage() , "Order review page loaded" , "Order review page not loaded");
		reporter.reportLogWithScreenshot("Rogers Order review page");
        getRogersOVOrderReviewPage().clkAllTermsAgreementCheckboxs();
        getRogersOVOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase06.getUsername());
		reporter.reportLogWithScreenshot("Rogers Order Review Page after selecting terms and conditions");
        if(getRogersOVOrderReviewPage().isPaymentRequired()) {
        	getRogersOVOrderReviewPage().clkContinue();
        	getRogersOVPaymentPage().setCreditCardDetails(TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getNumber(),
   				 TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
   				 TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryYear(),
   				 TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getCVV());
        	reporter.reportLogWithScreenshot("Rogers Payment Page");
        	getRogersOVPaymentPage().clkSubmit();
        } else {
        	getRogersOVOrderReviewPage().clkSubmitOrder();
        }
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");		
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase06.getContactID(),TestDataHandler.buyFlowsOVtestCase06.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
  	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}