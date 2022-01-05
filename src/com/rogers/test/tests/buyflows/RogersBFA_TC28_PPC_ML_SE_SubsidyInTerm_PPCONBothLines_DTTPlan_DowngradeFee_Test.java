package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC28 - Price plan change for an existing multi line shared account(for both lines) from Subsidy to financing_selecting Data, Talk and Text plan_Validating downgrade fee
 * @author praveen.kumar7
 */

public class RogersBFA_TC28_PPC_ML_SE_SubsidyInTerm_PPCONBothLines_DTTPlan_DowngradeFee_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","PPCBFA","RegressionOnlineBFA"})
    public void rogersPPC_TC28_MLSE_SubsidyInTerm_PPCONBothLines_DTTPlanTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl")+"/build-plan?flowType=ppc");
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getCtn());
        getRogersDeviceCataloguePage().clkContinueBtnPPCShareNonShareModal();
        //--------------------------------------------Plan Config page----------------------------------------------
        reporter.hardAssert(getRogersPlanConfigPage().verifyPPCPlanConfigPage(),"PPC Build plan page is loaded successfully","PPC build plan page is not loaded");
        getRogersPlanConfigPage().clkChangePlan();
        reporter.reportLogWithScreenshot("Clicked on Change Plan");
        getRogersPlanConfigPage().selectPlanType(TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getNewPlanType(),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Plan Type is selected successfully");
        getRogersPlanConfigPage().verifyDowngradeFeeModalAndClkContinue();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogWithScreenshot("Addons option selected");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        reporter.hardAssert(getRogersPlanConfigPage().verifyAdditionalLinePageDisplayed(),
                "Additional line option page is displayed", "Additional line option page is not disaplayed");
        getRogersPlanConfigPage().changePlanForAdditionalLine("FIN_DATA_TALK_TEXT","1");
        reporter.reportLogWithScreenshot("Additional line data and talk selected");
        getRogersPlanConfigPage().clkAddToCartAndProceedToCheckout(this.getClass().getSimpleName(), TestDataHandler.tc28PPCMLSESubsidyPlanToDTTPLan.getNewPlanType());
        //-----------------------------------------Review Order Page----------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present", "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Terms and conditions accepted");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------------------------Order Confirmation Page------------------------------------------------
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(),
                "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");

    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}
