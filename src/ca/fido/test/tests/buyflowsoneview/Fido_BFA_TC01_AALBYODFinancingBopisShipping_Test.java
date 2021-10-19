package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC01-OV-AAL Fido add a line with BYOD and BOPIS shipping - E2E (LR- EN - ON)
 *
 * @author Veranika.Siadach
 */
public class Fido_BFA_TC01_AALBYODFinancingBopisShipping_Test extends BaseTestClass {

    @Test(groups = {"RegressionBFA", "RegressionOVBFA", "OVAALBFA"})
    public void aalByodFinancingBopisShippingFlow() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc01AalByodFinancingBopisShipping.getBanNo(), TestDataHandler.tc01AalByodFinancingBopisShipping.getContactId());
        getReporter().hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        getReporter().reportLogWithScreenshot("Fido Account overview page");

        getAccountOverViewPage().selectAddAWirelessLineButton();
        getReporter().reportLogWithScreenshot("Add a Wireless Line Button is Selected");
        getReporter().hardAssert(getFidoOVChoosePhonePage().isCreditEvaluationModalPresence(), "Credit Evaluation modal is present", "Credit Evaluation modal is not present");
        getReporter().hardAssert(getFidoOVChoosePhonePage().validateCustomerType(TestDataHandler.tc01AalByodFinancingBopisShipping.getCustomerRiskLevel()),
                String.format("Given customer risk type %s matches the risk type %s from the credit evaluation modal", TestDataHandler.tc01AalByodFinancingBopisShipping.getCustomerRiskLevel(), getFidoOVChoosePhonePage().checkCustomerType()),
                String.format("Given customer risk type %s does not match the risk type %s from the credit evaluation modal", TestDataHandler.tc01AalByodFinancingBopisShipping.getCustomerRiskLevel(), getFidoOVChoosePhonePage().checkCustomerType()));
        getReporter().reportLogWithScreenshot("Credit Evaluation Modal");
        getFidoOVChoosePhonePage().clickPlanOnlyButtonOnCreditEvalModal();
        getReporter().reportLogWithScreenshot("Clicked on Plan only button");

        //-------------------------------------Plan config page---------------------------------------------
        String deviceName = TestDataHandler.tc01AalByodFinancingBopisShipping.getDeviceName();
        getReporter().hardAssert(getFidoOVPlanConfigPage().ifPlanConfigPageLoaded(), "Plan config page loaded successfully", "Plan config page not loaded");
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyDeviceTitle(deviceName), "Device title is correct", "Device title is not correct");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDataOptionAndClickContinueButton(getFidoOVPlanConfigPage().getUpdatedDataOptionIndex(TestDataHandler.tc01AalByodFinancingBopisShipping.getDataOptionIndex()));
        getReporter().reportLogPassWithScreenshot("Data option was selected");

        getReporter().hardAssert(getFidoOVPlanConfigPage().isTalkOptionSelected(), "Talk option is selected and Addons page is in expanded state", "Addons page is not in expanded state");
        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getReporter().reportLogPassWithScreenshot("Addon option was selected");

        getFidoOVPlanConfigPage().populateCallerAndClkContinueCallerId();
        getReporter().reportLogPassWithScreenshot("Caller ID was filled");

        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();
        getReporter().reportLogWithScreenshot("Proceed to checkout page button was clicked");

        //---------------------------------------Checkout pages----------------------------------------------
        getReporter().softAssert(getFidoOVCheckOutPage().isChooseNumberTitleDisplayed(), "Choose a number title displayed", "Choose a number title not disaplayed");
        getReporter().softAssert(getFidoOVCheckOutPage().verifyCheckOutPage(), "Select city select displayed", "Choose a number title not disaplayed");
        getReporter().softAssert(getFidoOVCheckOutPage().isChooseNumberTabsDisplayed(), "Select a new number / Use existing number tabs displayed", "Select a new number / Use existing number tabs are not displayed");

        getFidoOVCheckOutPage().selectCityDropdownOption(TestDataHandler.tc01AalByodFinancingBopisShipping.getCtnCity());
        getReporter().reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");

        getFidoOVCheckOutPage().selectFirstAvlPhoneNumber();
        getReporter().reportLogPassWithScreenshot("Selected First Available Phone Number");

        getReporter().softAssert(getFidoOVCheckOutPage().isFindMoreAvlNumbersButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");

        getFidoOVCheckOutPage().clkChooseNumberContinueButton();

        //--------------------------------------Review Order Page--------------------------------------------
        getReporter().hardAssert(getFidoOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page title is present", "Order Review Page title is not present");
        getReporter().reportLogPassWithScreenshot("Order Review Page");

        getFidoOVReviewOrderPage().clkPointsToMentionCheckbox();
        getFidoOVReviewOrderPage().clkEmailConsentCheckbox();
        getReporter().reportLogPassWithScreenshot("Order Review Page: T&C");

        getFidoOVReviewOrderPage().clkSubmitOrderBtn();
        getReporter().reportLogWithScreenshot("Submit order button");

        //--------------------------------------Order Confirmation Page--------------------------------------
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page is loaded", "Order Confirmation error");
        getReporter().hardAssert(getFidoOVOrderConfirmationPage().verifyBanOrderConfirmationPage(TestDataHandler.tc01AalByodFinancingBopisShipping.getBanNo()),
                "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
        getReporter().reportLogWithScreenshot("Rogers Order Confirmation Page");
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
