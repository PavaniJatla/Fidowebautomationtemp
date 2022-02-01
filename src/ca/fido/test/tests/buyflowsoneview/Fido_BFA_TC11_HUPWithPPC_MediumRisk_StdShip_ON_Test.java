package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC09-OV-Fido - HUP with PPC for a medium risk customer and Standard shipping option - EN - ON
 * @author praveen.kumar7
 */
public class Fido_BFA_TC11_HUPWithPPC_MediumRisk_StdShip_ON_Test extends BaseTestClass {

    @Test(groups = {"RegressionBFA", "RegressionOVBFA","OVHUPBFA"})
    public void tc11_HupWithPPC_MediumRisk_StdShipping_EN_ON_Flow() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getBanNo(), TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getContactId());
        getReporter().hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        getReporter().reportLogWithScreenshot("Fido Account overview page");
        getAccountOverViewPage().clkUpgradeMyDevice();

        String deviceName = TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getDeviceName();
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyDeviceTitleButton(TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getDeviceName()), "Phone catalogue page appeared successfully", "Phone catalogue page did not appear");
        getFidoOVChoosePhonePage().clickDeviceTitleButton(deviceName);
        getFidoOVChoosePhonePage().clickContinueButtonOnDashboardPhonePage(deviceName);

        //------------------------------------- Plan config page ---------------------------------------------
        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyPlanConfigPageLoad(), "Plan config page loaded successfully", "Plan config page not loaded");
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getDeviceCostIndex());
        getReporter().reportLogPassWithScreenshot("Device cost option selected");

        getFidoOVPlanConfigPage().selectDataOptionAndClickContinueButton(getFidoOVPlanConfigPage().getUpdatedDataOptionIndex(TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getDataOptionIndex()));
        getReporter().reportLogPassWithScreenshot("Data option was selected");
        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyTalkOptionSelection(), "Talk option is selected and Addons page is in expanded state", "Addons page is not in expanded state");

        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getReporter().reportLogPassWithScreenshot("Addon option was selected");
        getFidoOVPlanConfigPage().clkContinueDeviceProtection();
        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();
        getReporter().reportLogWithScreenshot("Proceed to checkout page button was clicked");

        //--------------------------------------- Checkout pages ----------------------------------------------
        getFidoOVCheckoutPage().selectDeliveryMethod("STANDARD");
        getReporter().reportLogPassWithScreenshot("Standard Delivery selected");
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

        getFidoOVReviewOrderPage().clkPreAuthorizedCreditCardTokenButton();
        getFidoOVReviewOrderPage().setCardName();
        getFidoOVReviewOrderPage().setTokenDetails(TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber3(),
                TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryMonth3(),
                TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryYear3());
        getReporter().reportLogWithScreenshot("Fido Payment Page");
        getFidoOVReviewOrderPage().clkSubmitPayment();

        //-------------------------------------- Order Confirmation Page --------------------------------------
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page is loaded", "Order Confirmation error");
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyBanOrderConfirmationPage(TestDataHandler.tc11HUPWithPPC_MediumRisk_StdShipping.getBanNo()),
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
