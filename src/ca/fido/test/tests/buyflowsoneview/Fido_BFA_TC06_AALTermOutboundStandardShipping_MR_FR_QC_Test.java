package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC01-OV-AAL Fido add a line with TERM Outbound flow by selecting smartphone and standard shipping - E2E (MR - FR - QC)
 *
 * @author Siarhei.Maiseichyk
 */
public class Fido_BFA_TC06_AALTermOutboundStandardShipping_MR_FR_QC_Test extends BaseTestClass {

    @Test(groups = {"RegressionBFA", "RegressionOVBFA", "OVAALBFA"})
    public void aalTermOutboundStandardShippingFlow() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc06AAlTermOutboundStandardShipping.getBanNo(), TestDataHandler.tc06AAlTermOutboundStandardShipping.getContactId());
        getReporter().hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        getReporter().reportLogWithScreenshot("Fido Account overview page");
        getAccountOverViewPage().setLanguageFrench();
        getReporter().reportLogWithScreenshot("Language was changed to French");
        getAccountOverViewPage().skipNotification();
        getReporter().reportLogWithScreenshot("Notification from bell icon was skipped");
        getAccountOverViewPage().selectAddAWirelessLineButton();
        getReporter().reportLogWithScreenshot("Add a Wireless Line Button is Selected");
        getReporter().hardAssert(getFidoOVChoosePhonePage().isCreditEvaluationModalPresence(), "Credit Evaluation modal is present", "Credit Evaluation modal is not present");
        getReporter().hardAssert(getFidoOVChoosePhonePage().validateCustomerType(TestDataHandler.tc06AAlTermOutboundStandardShipping.getCustomerRiskLevel()),
                String.format("Given customer risk type %s matches the risk type %s from the credit evaluation modal", TestDataHandler.tc06AAlTermOutboundStandardShipping.getCustomerRiskLevel(), getFidoOVChoosePhonePage().checkCustomerType()),
                String.format("Given customer risk type %s does not match the risk type %s from the credit evaluation modal", TestDataHandler.tc06AAlTermOutboundStandardShipping.getCustomerRiskLevel(), getFidoOVChoosePhonePage().checkCustomerType()));
        getReporter().reportLogWithScreenshot("Credit Evaluation Modal");
        getFidoOVChoosePhonePage().clickDeviceAndPlanButtonOnCreditEvalModal();
        getReporter().reportLogWithScreenshot("Clicked on Device and Plan button");

        String deviceName = TestDataHandler.tc06AAlTermOutboundStandardShipping.getDeviceName();
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyDeviceTitleButton(deviceName), "Phone catalogue page appeared successfully", "Phone catalogue page did not appear");
        getFidoOVChoosePhonePage().clickDeviceTitleButton(deviceName);
        getFidoOVChoosePhonePage().clickContinueButtonOnDashboardPhonePage(deviceName);

        //------------------------------------- Plan config page ---------------------------------------------
        getReporter().hardAssert(getFidoOVPlanConfigPage().ifPlanConfigPageLoaded(), "Plan config page loaded successfully", "Plan config page not loaded");
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(TestDataHandler.tc06AAlTermOutboundStandardShipping.getDeviceCostIndex());
        getReporter().reportLogPassWithScreenshot("Device cost option selected");

        getFidoOVPlanConfigPage().selectOutboundDataOptionAndClickContinueButton(TestDataHandler.tc06AAlTermOutboundStandardShipping.getDataOptionIndex());
        getReporter().hardAssert(getFidoOVPlanConfigPage().isTalkOptionSelected(), "Talk option is selected and Addons page is in expanded state","Addons page is not in expanded state");
        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getReporter().reportLogPassWithScreenshot("Addon option was selected");

        getFidoOVPlanConfigPage().populateCallerAndClkContinueCallerId();
        getReporter().reportLogPassWithScreenshot("Caller ID was filled");

        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();
        getReporter().reportLogWithScreenshot("Proceed to checkout page button was clicked");

        //---------------------------------------Checkout pages----------------------------------------------
        getReporter().softAssert(getFidoOVCheckoutPage().isChooseNumberTitleDisplayed(), "Choose a number title displayed", "Choose a number title not displayed");
        getReporter().softAssert(getFidoOVCheckoutPage().verifyCheckOutPage(), "Select city select displayed", "Choose a number title not displayed");
        getReporter().softAssert(getFidoOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a new number / Use existing number tabs displayed", "Select a new number / Use existing number tabs are not displayed");

        getFidoOVCheckoutPage().selectCityDropdownOption(TestDataHandler.tc06AAlTermOutboundStandardShipping.getCtnCity());
        getReporter().reportLogPassWithScreenshot("City dropdown value selected successfully");

        getFidoOVCheckoutPage().selectFirstAvlPhoneNumber();
        getReporter().reportLogPassWithScreenshot("Selected first available phone Number");

        getReporter().softAssert(getFidoOVCheckoutPage().isFindMoreAvlNumbersButtonPresent(), "Find more available number button displayed", "Find more available number button not disaplayed");

        getFidoOVCheckoutPage().clkChooseNumberContinueButton();
        getReporter().hardAssert(getFidoOVCheckoutPage().isChooseNumberLabelDisplayed(), "Choose a number identification label displayed successfully", "Choose a number identification label not disaplayed");
        getReporter().hardAssert(getFidoOVCheckoutPage().isSelectedPhoneNumberDisplayed(), "Selected phone number label displayed successfully", "Choose a number identification Label not disaplayed");
        getReporter().reportLogPassWithScreenshot("Choose a number identification label and selected phone number are displayed");
        getReporter().hardAssert(getFidoOVCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ", "Billing Address is not selected");

        getFidoOVCheckoutPage().selectDeliveryMethod("STANDARD");
        getReporter().reportLogPassWithScreenshot("Standard delivery selected");

        getFidoOVCheckoutPage().clkShippingContinueButton();
        getReporter().reportLogPassWithScreenshot("Clicked continue button in shipping stepper");

        getFidoOVCheckoutPage().clkSubmitButton();
        getReporter().reportLogPassWithScreenshot("Clicked submit button below cart summary");

        //-------------------------------------- Review Order Page --------------------------------------------
        getReporter().hardAssert(getFidoOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page title is present", "Order Review Page title is not present");
        getReporter().reportLogPassWithScreenshot("Order Review Page");

        getFidoOVReviewOrderPage().clkPointsToMentionCheckbox();
        getFidoOVReviewOrderPage().clkBopisCheckbox();
        getReporter().reportLogPassWithScreenshot("Order Review Page: T&C");

        getFidoOVReviewOrderPage().clkSubmitOrderBtn();
        getReporter().reportLogWithScreenshot("Submit order button");

        //TODO: check
        if (getFidoOVReviewOrderPage().isPaymentRequired()) {
            getFidoOVReviewOrderPage().clkPreAuthorizedCreditCardTokenButton();
            getFidoOVReviewOrderPage().setCardName();
            getFidoOVReviewOrderPage().setTokenDetails(TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber3(),
                    TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryMonth3(),
                    TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryYear3());
            getReporter().reportLogWithScreenshot("Fido Payment Page");
            getFidoOVReviewOrderPage().clkSubmitPayment();
        }
        //-------------------------------------- Order Confirmation Page --------------------------------------
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page is loaded", "Order Confirmation error");
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyBanOrderConfirmationPage(TestDataHandler.tc06AAlTermOutboundStandardShipping.getBanNo()),
                "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
        getReporter().reportLogWithScreenshot("Fido Order Confirmation Page");
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
