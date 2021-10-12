package ca.fido.test.tests.buyflowsoneview;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
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
        getReporter().softAssert(getFidoOVPlanConfigPage().verifyDeviceTile(deviceName), "Device tile is correct", "Device tile is not correct");
        getReporter().reportLogPassWithScreenshot("Plan Config page loaded successfully");

        getFidoOVPlanConfigPage().selectDataOptionAndClickContinueButton(getFidoOVPlanConfigPage().getUpdatedDataOptionIndex(TestDataHandler.tc01AalByodFinancingBopisShipping.getDataOptionIndex()));
        getReporter().reportLogPassWithScreenshot("Data option selected");

        getReporter().hardAssert(getFidoOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getFidoOVPlanConfigPage().getUpdatedTalkOptionIndex(TestDataHandler.tc01AalByodFinancingBopisShipping.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
//        getFidoOVPlanConfigPage().clickPreCartAddonsContinueButton();
//        getFidoOVPlanConfigPage().clkContinueCallerID();
//        getFidoOVPlanConfigPage().clickCartSummaryContinueButton();

        //---------------------------------------Checkout pages----------------------------------------------
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
