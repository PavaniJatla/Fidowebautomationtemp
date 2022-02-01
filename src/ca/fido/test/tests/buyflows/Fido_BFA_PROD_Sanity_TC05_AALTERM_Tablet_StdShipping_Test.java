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
 * TC05 - PROD SANITY - [AAL TERM] - Add a line by selecting TABLET device - Till Review order page
 * @author praveen.kumar7
 */

public class Fido_BFA_PROD_Sanity_TC05_AALTERM_Tablet_StdShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("AWSPRODUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"PRODSanityy"})
    public void fidoAALTerm_Tablet_StdShippingTest() {

        getFidologinpage().setUsernameInFrame(TestDataHandler.BFA_ProdTest_tc05_AALTERM_Tablet_StdShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.BFA_ProdTest_tc05_AALTERM_Tablet_StdShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");

        getFidoaccountoverviewpage().clkLnkAddALine(TestDataHandler.BFA_ProdTest_tc05_AALTERM_Tablet_StdShipping.getBan());
        getFidoaccountoverviewpage().clkAddALineLnkInModal(this.getClass().getSimpleName());

        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");;
        getFidochoosephonepage().selectDevice(TestDataHandler.BFA_ProdTest_tc05_AALTERM_Tablet_StdShipping.getNewDevice());

        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        getFidoCheckOutPage().clkNoThanks();
        getFidodeviceconfigpage().clickContinueButton();

        getFidobuildplanpage().clkContinueDeviceCost();
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is clicked");
        getFidoCheckOutPage().clkNoThanks();
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueDeviceProtection();
        getReporter().reportLogWithScreenshot("Called ID information a");
        getFidobuildplanpage().clkCallerIdContinueBtn();
        getReporter().reportLogWithScreenshot("All the steppers are in collapsed state");
        getFidobuildplanpage().clkContinueBelowCartSummary();

        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(TestDataHandler.BFA_ProdTest_tc05_AALTERM_Tablet_StdShipping.getCityName());
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        getFidoCheckOutPage().clkBtnNoThanks();
        getFidoCheckOutPage().clkNoThanks();
        getFidoCheckOutPage().clkBtnNoThanks();
        String deliveryMethod = TestDataHandler.BFA_ProdTest_tc05_AALTERM_Tablet_StdShipping.getShippingType();
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
