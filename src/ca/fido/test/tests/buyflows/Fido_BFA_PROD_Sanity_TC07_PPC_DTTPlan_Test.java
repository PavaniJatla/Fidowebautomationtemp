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
 * TC07 - PROD SANITY - [PPC] - PPC by selecting Data, Talk&Text Plan - Till Review order page
 * @author praveen.kumar7
 */

public class Fido_BFA_PROD_Sanity_TC07_PPC_DTTPlan_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("AWSPRODUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"PRODSanity"})
    public void fidoPPC_DTTPlanTest() {

        getFidologinpage().setUsernameInFrame(TestDataHandler.BFA_ProdTest_tc07_PPC_DTTPlan.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.BFA_ProdTest_tc07_PPC_DTTPlan.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");

        getFidoaccountoverviewpage().clkViewUsageAndManageLink(TestDataHandler.BFA_ProdTest_tc07_PPC_DTTPlan.getCtn());
        getReporter().reportLogWithScreenshot("Wireless Dashboard page");
        getFidowirelessdashboardpostpaidpage().clkChangePlan();

        getReporter().hardAssert(getFidobuildplanpage().verifyPlanConfigPage(),"PPC Build plan page is loaded successfully","PPC build plan page is not loaded");
        getFidobuildplanpage().clkChangePlan();
        getReporter().reportLogWithScreenshot("Clicked on Change Plan");
        getFidobuildplanpage().selectPlanType(TestDataHandler.BFA_ProdTest_tc07_PPC_DTTPlan.getNewPlanType());
        getReporter().reportLogPassWithScreenshot("Plan Type is selected successfully");
        getFidobuildplanpage().clkDataOption(TestDataHandler.BFA_ProdTest_tc07_PPC_DTTPlan.getDataOptionIndex(), this.getClass().getSimpleName());
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getFidoCheckOutPage().clkNoThanks();
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getFidobuildplanpage().clkContinueOnExistingAddonModal();

        getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel(),
                "Review Order page is displayed successfully", "Review Order page is not dislayed");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
