package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC05-OV-AAL Fido add a line with NO TERM Outbound flow by selecting smartphone and BOPIS shipping - E2E (LR - EN - ON)
 *
 * @author Veranika.Siadach
 */
public class Fido_BFA_TC05_AALNoTermOutboundBopisShipping_LR_EN_ON_Test extends BaseTestClass {

    @Test(groups = {"RegressionBFA", "RegressionOVBFA", "OVAALBFA"})
    public void aalNoTermOutboundStandardShippingLrEnOnFlow() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc05AalNoTermOutboundBopisShipping.getBanNo(), TestDataHandler.tc05AalNoTermOutboundBopisShipping.getContactId());
        getReporter().hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        getReporter().reportLogWithScreenshot("Fido Account overview page");

        getAccountOverViewPage().selectAddAWirelessLineButton();
        getReporter().reportLogWithScreenshot("Add a Wireless Line Button is Selected");
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyCreditEvaluationModalPresence(), "Credit Evaluation modal is present", "Credit Evaluation modal is not present");
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyCustomerType(TestDataHandler.tc05AalNoTermOutboundBopisShipping.getCustomerRiskLevel()),
                String.format("Given customer risk type %s matches the risk type %s from the credit evaluation modal", TestDataHandler.tc05AalNoTermOutboundBopisShipping.getCustomerRiskLevel(), getFidoOVChoosePhonePage().checkCustomerType()),
                String.format("Given customer risk type %s does not match the risk type %s from the credit evaluation modal", TestDataHandler.tc05AalNoTermOutboundBopisShipping.getCustomerRiskLevel(), getFidoOVChoosePhonePage().checkCustomerType()));
        getReporter().reportLogWithScreenshot("Credit Evaluation Modal");
        getFidoOVChoosePhonePage().clickDeviceAndPlanButtonOnCreditEvalModal();
        getReporter().reportLogWithScreenshot("Clicked on Device and Plan button");

        String deviceName = TestDataHandler.tc05AalNoTermOutboundBopisShipping.getDeviceName();
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyDeviceTitleButton(deviceName), "Phone catalogue page appeared successfully", "Phone catalogue page did not appear");
        getFidoOVChoosePhonePage().clickDeviceTitleButton(deviceName);
        getFidoOVChoosePhonePage().clickContinueButtonOnDashboardPhonePage(deviceName);

        //------------------------------------- Plan config page ---------------------------------------------
        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyPlanConfigPageLoad(), "Plan config page loaded successfully", "Plan config page not loaded");
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(TestDataHandler.tc05AalNoTermOutboundBopisShipping.getDeviceCostIndex());
        getReporter().reportLogPassWithScreenshot("Device cost option selected");

        getFidoOVPlanConfigPage().selectOutboundDataOptionAndClickContinueButton(TestDataHandler.tc05AalNoTermOutboundBopisShipping.getDataOptionIndex());
        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyTalkOptionSelection(), "Talk option is selected and Addons page is in expanded state", "Addons page is not in expanded state");
        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getReporter().reportLogPassWithScreenshot("Addon option was selected");

        getFidoOVPlanConfigPage().populateCallerAndClkContinueCallerId();
        getReporter().reportLogPassWithScreenshot("Caller ID was filled");

        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();
        getReporter().reportLogWithScreenshot("Proceed to checkout page button was clicked");

        //--------------------------------------- Checkout pages ----------------------------------------------
        getReporter().softAssert(getFidoOVCheckoutPage().isChooseNumberTitleDisplayed(), "Choose a number title displayed", "Choose a number title not displayed");
        getReporter().softAssert(getFidoOVCheckoutPage().verifyCheckOutPage(), "Select city select displayed", "Choose a number title not displayed");
        getReporter().softAssert(getFidoOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a new number / Use existing number tabs displayed", "Select a new number / Use existing number tabs are not displayed");

        getFidoOVCheckoutPage().selectCityDropdownOption(TestDataHandler.tc05AalNoTermOutboundBopisShipping.getCtnCity());
        getReporter().reportLogPassWithScreenshot("City dropdown value selected successfully");

        getFidoOVCheckoutPage().selectFirstAvlPhoneNumber();
        getReporter().reportLogPassWithScreenshot("Selected first available phone Number");

        getReporter().softAssert(getFidoOVCheckoutPage().isFindMoreAvlNumbersButtonPresent(), "Find more available number button displayed", "Find more available number button not disaplayed");

        getFidoOVCheckoutPage().clkChooseNumberContinueButton();
        getReporter().hardAssert(getFidoOVCheckoutPage().verifyChooseNumberLabel(), "Choose a number identification label displayed successfully", "Choose a number identification label not disaplayed");
        getReporter().hardAssert(getFidoOVCheckoutPage().verifySelectedPhoneNumber(), "Selected phone number label displayed successfully", "Choose a number identification Label not disaplayed");
        getReporter().reportLogPassWithScreenshot("Choose a number identification label and selected phone number are displayed");
        getReporter().hardAssert(getFidoOVCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ", "Billing Address is not selected");

        getFidoOVCheckoutPage().selectDeliveryMethod("EXPRESS");
        getReporter().reportLogPassWithScreenshot("Express Delivery selected");

        getFidoOVCheckoutPage().setEmailShippingPage();
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
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyBanOrderConfirmationPage(TestDataHandler.tc05AalNoTermOutboundBopisShipping.getBanNo()),
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
