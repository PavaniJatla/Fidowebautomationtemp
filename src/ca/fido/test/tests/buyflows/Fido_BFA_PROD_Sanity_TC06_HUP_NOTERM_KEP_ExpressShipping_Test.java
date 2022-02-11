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
 * TC06 - PROD SANITY - [HUP] - HUP by choosing NOTERM cost option and BOPIS  Shipping - Till Review order page
 * @author praveen.kumar7
 */

public class Fido_BFA_PROD_Sanity_TC06_HUP_NOTERM_KEP_ExpressShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("AWSPRODUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"PRODSanity"})
    public void fidoHUP_NOTERM_KEP_ExpressShippingTest() {

        getFidologinpage().setUsernameInFrame(TestDataHandler.BFA_ProdTest_tc06_HUPNoTerm_KEP_ExpressShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.BFA_ProdTest_tc06_HUPNoTerm_KEP_ExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");

        getFidoaccountoverviewpage().clkViewUsageAndManageLink(TestDataHandler.BFA_ProdTest_tc06_HUPNoTerm_KEP_ExpressShipping.getCtn());
        getReporter().reportLogWithScreenshot("Wireless Dashboard page");
        getFidowirelessdashboardpostpaidpage().clickUpgradeDevice();

        getReporter().hardAssert(getFidochoosephonepage().verifyChoosePhonesPageLoad(), "Choose Phone page loaded", "Choose Phone page load error");
        getReporter().reportLogWithScreenshot("PHONES & DEVICES page");
        getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.BFA_ProdTest_tc06_HUPNoTerm_KEP_ExpressShipping.getNewDevice()),"Device Found and Selected","Device Not Found");
        getReporter().reportLogWithScreenshot("Required device is selected on the choose phone page " +TestDataHandler.BFA_ProdTest_tc06_HUPNoTerm_KEP_ExpressShipping.getNewDevice());
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Device config page loaded","Device config page not loaded");

        getReporter().reportLogWithScreenshot("Device config page");
        getFidoCheckOutPage().clkNoThanks();
        getFidodeviceconfigpage().clickContinueButton();
        getReporter().reportLogPass("Continue button clicked on the device config page");
        getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");

       getReporter().hardAssert(getFidobuildplanpage().verifyPlanConfigPage(),
               "Plan config page is laoded", "Plan config page is not loaded");
        getFidoCheckOutPage().clkNoThanks();
        getReporter().reportLogWithScreenshot("Fido plan config page");
        getFidobuildplanpage().clkRadioButtonNoTerm();
        getFidobuildplanpage().clkContinueDeviceCost();
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getFidobuildplanpage().clkContinueDataOption();
        getReporter().reportLogWithScreenshot("data option is selected");
        getFidobuildplanpage().clkContinueTalkOptions();
        getFidoCheckOutPage().clkNoThanks();
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Clicked on continue button in Addons stepper");
        getFidobuildplanpage().clkContinueDeviceProtection();
        getReporter().reportLogWithScreenshot("Device protectio");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.BFA_ProdTest_tc06_HUPNoTerm_KEP_ExpressShipping.getShippingType();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
        } else {
            getReporter().reportLogWithScreenshot("Shipping selected");
        }
        getFidoCheckOutPage().clkShippingContinueButton();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();

        getReporter().hardAssert(getFidoorderreviewpage().verifyReviewPageLabel(),
                "Review Order page is displayed successfully", "Review Order page is not dislayed");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
