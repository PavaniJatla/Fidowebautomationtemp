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
 * TC04 - PROD SANITY - [AAL BYOD] - Add a line by choosing Data,Talk&Text plan and BOPIS  Shipping - Till Review order page
 * @author praveen.kumar7
 */

public class Fido_BFA_PROD_Sanity_TC04_AALBYOD_DTTPlan_ExpressShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("AWSPRODUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"PRODSanity"})
    public void fidoAALByod_FinancePlan_ExpressShippingTest() {

        getFidologinpage().setUsernameInFrame(TestDataHandler.BFA_ProdTest_tc04_AALBYOD_ExpressShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.BFA_ProdTest_tc04_AALBYOD_ExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");

        getFidoaccountoverviewpage().clkLnkAddALine(TestDataHandler.BFA_ProdTest_tc04_AALBYOD_ExpressShipping.getBan());
        getFidoaccountoverviewpage().clkAddALineLnkInModal(this.getClass().getSimpleName());

        getReporter().hardAssert(getFidobuildplanpage().verifyContinueBtnPlanStepper(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
        getReporter().reportLogWithScreenshot("Fido plan config page");
        getFidobuildplanpage().clkDataOption(TestDataHandler.BFA_ProdTest_tc04_AALBYOD_ExpressShipping.getDataOptionIndex(), this.getClass().getSimpleName());
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("BPO offer Selected");
        getFidoCheckOutPage().clkNoThanks();
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueDeviceProtection();
        getReporter().reportLogWithScreenshot("CallerId Stepper");
        getFidobuildplanpage().clkContinueCallerID();
        getReporter().reportLogWithScreenshot("Called ID information entered and continue button pressed");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");

        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(TestDataHandler.BFA_ProdTest_tc04_AALBYOD_ExpressShipping.getCityName());
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.BFA_ProdTest_tc04_AALBYOD_ExpressShipping.getShippingType();
        getFidoCheckOutPage().clkBtnNoThanks();
        getFidoCheckOutPage().clkNoThanks();
        getFidoCheckOutPage().clkBtnNoThanks();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getFidoCheckOutPage().setEmailBopis();
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map is displayed" , "Bopis Map is not displayed");
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
