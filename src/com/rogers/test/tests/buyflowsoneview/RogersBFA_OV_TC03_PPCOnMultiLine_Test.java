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
 * TC03-OV-PPC_Multiline Account_Validate if user is able to place an order in PPC flow for both lines_EN
 *  
 * @author Saurav.Goyal
 *
 */
public class RogersBFA_OV_TC03_PPCOnMultiLine_Test extends BaseTestClass {

	@Test
	public void ppcOnMultiLineFlowTest() {
		environment_selection_page.presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		environment_selection_page.selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		reporter.hardAssert(account_over_view_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview page");
		reporter.hardAssert(account_over_view_page.verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase03.getCtn()), "Select CTN Passed", "Select CTN Failed");
		account_over_view_page.clkCloseBtnAssignDataManager();
		//account_over_view_page.clkBtnOkOneViewDialoue();
		rogersOV_wireless_details_page.verifyWirelessPageLoad();
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		rogersOV_wireless_details_page.clickChangePlanButton();
		reporter.reportLogWithScreenshot("Change share plan page");
		rogersOV_ChangeSharePlan_page.clickEditButton();
		reporter.reportLogWithScreenshot("Choose Plan page");
		rogersOV_ChoosePlan_page.clkSharedLineOne();
		rogersOV_ChoosePlan_page.selectPlanCategory(TestDataHandler.buyFlowsOVtestCase03.getNewPlanCategory());
		rogersOV_ChoosePlan_page.selectFirstAvailablePlan();
		rogersOV_ChoosePlan_page.verifyAndClickDowngradeFeeContinue();
		rogersOV_ChoosePlan_page.clkSharedLineTwo();
		rogersOV_ChoosePlan_page.selectPlanCategory(TestDataHandler.buyFlowsOVtestCase03.getNewPlanCategory());
		rogersOV_ChoosePlan_page.selectFirstAvailablePlan();
		rogersOV_ChoosePlan_page.verifyAndClickDowngradeFeeContinue();
		rogersOV_ChoosePlan_page.clkCheckout();
		reporter.reportLogWithScreenshot("Choose add ons page");
		rogersOV_choose_addons_page.clkCheckout();
		reporter.reportLogWithScreenshot("Order Review page");
		order_Review_Page.selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase03.getUsername());
		reporter.reportLogWithScreenshot("Order Review page");
		if(order_Review_Page.isPaymentRequired()) {
			order_Review_Page.clkContinue();
			rogersOV_payment_page.setCreditCardDetails(TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getNumber(), 
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryYear(),
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getCVV());
			reporter.reportLogWithScreenshot("Rogers Payment Page");
			rogersOV_payment_page.clkSubmit();
		} else {
			order_Review_Page.clkSubmitOrder();
		}
		reporter.hardAssert(order_Confirmation_Page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
		reporter.hardAssert(order_Confirmation_Page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase03.getContactID(),TestDataHandler.buyFlowsOVtestCase03.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}