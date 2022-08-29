package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC16 - Price plan change for an existing Multi line account from FIN to NOTERM(BYOD Plan-DTT) and Validating the downgrade fee
 * @author praveen.kumar7
 */

public class Fido_BFA_TC16_PPC_ML_FinInTerm_SelectingNoTermDTT_DowngradeFee_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"RegressionBFA","AALBFA","PPCBFA"})
    public void tc16_fidoPPCMLNonSE_FINInTerm_NOTERMPlanTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc16PPCMLFinInTermNotermPlan.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc16PPCMLFinInTermNotermPlan.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl") + "/phones/build-plan?flowType=ppc");
        getReporter().reportLogWithScreenshot("CTN selection modal is displayed");
        getFidodeviceconfigpage().selectSubscriber(TestDataHandler.tc16PPCMLFinInTermNotermPlan.getCtn());
        //--------------------------------------------Plan Config page--------------------------------------------------
        getReporter().hardAssert(getFidobuildplanpage().verifyPPCPlanConfigPage(),"PPC Build plan page is loaded successfully","PPC build plan page is not loaded");
        getFidobuildplanpage().clkChangePlan();
        getReporter().reportLogWithScreenshot("Clicked on Change Plan");
        getFidobuildplanpage().selectPlanType(TestDataHandler.tc16PPCMLFinInTermNotermPlan.getNewPlanType());
        getReporter().reportLogPassWithScreenshot("Plan Type is selected successfully and Downgradefee popup is displayed");
        getFidobuildplanpage().verifyDowngradeFeeModalAndClkContinue();
        getFidobuildplanpage().clkDataOption(TestDataHandler.tc16PPCMLFinInTermNotermPlan.getDataOptionIndex(), this.getClass().getSimpleName());
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getFidobuildplanpage().clkContinueOnExistingAddonModal();
        //--------------------------------------------Review Order page------------------------------------------------
        getReporter().reportLogPassWithScreenshot("Review order page loaded successfully");
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
        getReporter().reportLogWithScreenshot("Order Confirmation page");
    }

}
