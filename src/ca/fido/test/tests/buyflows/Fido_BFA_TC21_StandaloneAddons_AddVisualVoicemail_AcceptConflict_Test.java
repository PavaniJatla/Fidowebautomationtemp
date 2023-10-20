package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC21_StandaloneAddons_AddVisualVoicemail_AcceptConflict_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","SAABFA"})
    public void tc21_FidoSAAAddVisualVoicemailTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc21SAA_AddVoicemail.getUsername());
        getFidologinpage().clkContinueSignIn();
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc21SAA_AddVoicemail.getPassword());
        getReporter().reportLogWithScreenshot("Login Popup");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getFidoaccountoverviewpage().clkViewUsageManage();
        getReporter().reportLogPassWithScreenshot("Dashboard Page");
        getDriver().get(System.getProperty("AWSUrl") + "/phones/manage-addons");
        getReporter().hardAssert(getFidoCheckOutPage().verifyAddonsPage(),
                "Fido Standalone Addons Page Displayed","Fido Standalone Addons Page not Displayed");
        String newAddon = TestDataHandler.tc21SAA_AddVoicemail.getAddonName();
        getFidoCheckOutPage().selectAddon(newAddon);
        getReporter().reportLogPassWithScreenshot(  "New " +newAddon +"Addon Selected");
        getReporter().hardAssert(getFidoCheckOutPage().clkConflictContinueBtn(),
                "Clicked Continue on Addon Conflict Modal","Addon Conflict Modal not displayed");
        getReporter().hardAssert(getFidoorderreviewpage().isAddonReviewPageDisplayed(),
                "Addons Order Review Page Displayed","Addons Order Review Page Not Displayed");
        String addonOrderSummary = getFidoorderreviewpage().addonOrderSummary();
        getReporter().reportLogPassWithScreenshot("Addons Order Summary: " +addonOrderSummary);
        getFidoorderreviewpage().clkAddonsAgreementConsent();
        getReporter().reportLogPassWithScreenshot("Addon Agreement clicked");
        getFidoorderreviewpage().clkAddToPlanBtn();
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyAddonOrderConfirm(),
                "Addons Order Confirmation Page Displayed","Addons Order Confirmation Page Not Displayed");
        String OrderConfirmMessage = getFidoorderconfirmationpage().getOrderConfirmMsg();
        getReporter().reportLogPassWithScreenshot("Addons Order Confirmation Message: " +OrderConfirmMessage);
        getFidoorderconfirmationpage().clickBackToAddonBtn();
        getReporter().softAssert(getFidoCheckOutPage().verifyAddonsPage(),
                "Fido Standalone Addons Page Displayed","Fido Standalone Addons Page not Displayed");
        String selectedAddon = getFidoCheckOutPage().getSelectedAddon();
        getReporter().softAssert(selectedAddon.contains(newAddon),
                "Selected Addon is reflected in Addons page after submission","Selected Addon is not reflected");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
