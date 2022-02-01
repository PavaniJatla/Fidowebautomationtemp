package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC09-OV-HUP-Care customer - Fido HUP with PPC and Standard shipping - EN - Quebec province
 * @author praveen.kumar7
 */
public class Fido_BFA_TC09_HUPWithPPC_ShipAddrDifferentThanBillingAddr_StdShipping_QC_Test extends BaseTestClass {

    @Test(groups = {"RegressionBFA", "RegressionOVBFA","OVHUPBFA"})
    public void tc09_HupWithPPC_StdShipping_EN_QC_Flow() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getBanNo(), TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getContactId());
        getReporter().hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        getReporter().reportLogWithScreenshot("Fido Account overview page");
        getAccountOverViewPage().clkUpgradeMyDevice();

        String deviceName = TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getDeviceName();
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyDeviceTitleButton(TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getDeviceName()), "Phone catalogue page appeared successfully", "Phone catalogue page did not appear");
        getFidoOVChoosePhonePage().clickDeviceTitleButton(deviceName);
        getFidoOVChoosePhonePage().clickContinueButtonOnDashboardPhonePage(deviceName);

        //------------------------------------- Plan config page ---------------------------------------------
        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyPlanConfigPageLoad(), "Plan config page loaded successfully", "Plan config page not loaded");
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getDeviceCostIndex());
        getReporter().reportLogPassWithScreenshot("Device cost option selected");

        getFidoOVPlanConfigPage().selectDataOptionAndClickContinueButton(getFidoOVPlanConfigPage().getUpdatedDataOptionIndex(TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getDataOptionIndex()));
        getReporter().reportLogPassWithScreenshot("Data option was selected");
        //getReporter().hardAssert(getFidoOVPlanConfigPage().verifyTalkOptionSelection(), "Talk option is selected and Addons page is in expanded state", "Addons page is not in expanded state");

        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getReporter().reportLogPassWithScreenshot("Addon option was selected");
        getFidoOVPlanConfigPage().clkContinueDeviceProtection();
        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();
        getReporter().reportLogWithScreenshot("Proceed to checkout page button was clicked");

        //--------------------------------------- Checkout pages ----------------------------------------------
        getFidoOVCheckoutPage().selectDeliveryMethod("STANDARD");
        getReporter().reportLogPassWithScreenshot("Standard shipping option selected");
        getFidoOVCheckoutPage().clkNewAddress();
        getFidoOVCheckoutPage().enterNewAddress(TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getNewAddress());
        getFidoOVCheckoutPage().clkShippingContinueButton();
        getReporter().reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getFidoOVCheckoutPage().clkSubmitButton();
        getReporter().reportLogPassWithScreenshot("Clicked submit button below cart summary");

        //-------------------------------------- Review Order Page --------------------------------------------
        getReporter().hardAssert(getFidoOVReviewOrderPage().verifyOrderReviewPageTitle(), "Order Review Page title is present", "Order Review Page title is not present");
        getReporter().reportLogPassWithScreenshot("Order Review Page");
        getFidoOVReviewOrderPage().clkPointsToMentionCheckbox();
        getFidoOVReviewOrderPage().clkBopisCheckbox();
        getReporter().reportLogPassWithScreenshot("Order Review Page: T&C");
        getFidoOVReviewOrderPage().clkSubmitOrderBtn();
        getReporter().reportLogWithScreenshot("Submit order button");

        //-------------------------------------- Order Confirmation Page --------------------------------------
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page is loaded", "Order Confirmation error");
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyBanOrderConfirmationPage(TestDataHandler.tc09HUPWithPPC_FinPlan_StdShipping_QCProv.getBanNo()),
                "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
        getReporter().reportLogWithScreenshot("Fido Order Confirmation page");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startOVSession(System.getProperty("OneViewUrl"), strBrowser, strLanguage, FidoEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), "", "", "", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
