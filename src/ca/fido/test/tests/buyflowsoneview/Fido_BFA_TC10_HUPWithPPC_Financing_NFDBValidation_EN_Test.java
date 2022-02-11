package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC10 - OV Fido HUP - Fido HUP with PPC - Validating NFDB error message when using FRAUD address in shipping stepper - EN - ON
 * @author praveen.kumar7
 */
public class Fido_BFA_TC10_HUPWithPPC_Financing_NFDBValidation_EN_Test extends BaseTestClass {

    @Test(groups = {"RegressionBFA", "RegressionOVBFA","OVHUPBFA"})
    public void tc10_HupWithPPC_NFDBValidation_EN_ON_Flow() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc10HUPWithPPC_NFDBValidation.getBanNo(), TestDataHandler.tc10HUPWithPPC_NFDBValidation.getContactId());
        getReporter().hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        getReporter().reportLogWithScreenshot("Fido Account overview page");
        getAccountOverViewPage().clkUpgradeMyDevice();

        String deviceName = TestDataHandler.tc10HUPWithPPC_NFDBValidation.getDeviceName();
        getReporter().hardAssert(getFidoOVChoosePhonePage().verifyDeviceTitleButton(TestDataHandler.tc10HUPWithPPC_NFDBValidation.getDeviceName()), "Phone catalogue page appeared successfully", "Phone catalogue page did not appear");
        getFidoOVChoosePhonePage().clickDeviceTitleButton(deviceName);
        getFidoOVChoosePhonePage().clickContinueButtonOnDashboardPhonePage(deviceName);

        //------------------------------------- Plan config page ---------------------------------------------
        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyPlanConfigPageLoad(), "Plan config page loaded successfully", "Plan config page not loaded");
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(TestDataHandler.tc10HUPWithPPC_NFDBValidation.getDeviceCostIndex());
        getReporter().reportLogPassWithScreenshot("Device cost option selected");

        getFidoOVPlanConfigPage().selectDataOptionAndClickContinueButton(getFidoOVPlanConfigPage().getUpdatedDataOptionIndex(TestDataHandler.tc10HUPWithPPC_NFDBValidation.getDataOptionIndex()));
        getReporter().reportLogPassWithScreenshot("Data option was selected");
        //getReporter().hardAssert(getFidoOVPlanConfigPage().verifyTalkOptionSelection(), "Talk option is selected and Addons page is in expanded state", "Addons page is not in expanded state");

        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getReporter().reportLogPassWithScreenshot("Addon option was selected");
        getFidoOVPlanConfigPage().clkContinueDeviceProtection();
        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();
        getReporter().reportLogWithScreenshot("Proceed to checkout page button was clicked");

        //-----------------------------------------Checkout page----------------------------------------
        getFidoOVCheckoutPage().selectDeliveryMethod("STANDARD");
        getReporter().reportLogPassWithScreenshot("Standard shipping option selected");
        getFidoOVCheckoutPage().clkNewAddress();
        getFidoOVCheckoutPage().enterNewAddress(TestDataHandler.tc10HUPWithPPC_NFDBValidation.getNewAddress());
        getReporter().reportLogWithScreenshot("Entered NFDB Address");
        getFidoOVCheckoutPage().clkShippingContinueButton();
        getReporter().hardAssert(getFidoOVCheckoutPage().verifyNFDBErrorMsg(), "NFDB error message is verified successfully", "NFDB error message is not verified successfully");
        getReporter().reportLogPassWithScreenshot("Customer is blocked due to fraudulent address");
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
