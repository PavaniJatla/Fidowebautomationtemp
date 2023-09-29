package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC22_StandaloneAddons_RemoveVisualVoicemail_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","SAABFA"})
    public void tc22_FidoSAARemoveVisualVoicemailTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc22SAA_RemoveVoicemail.getUsername());
        getFidologinpage().clkContinueSignIn();
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc22SAA_RemoveVoicemail.getPassword());
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
        String newAddon = TestDataHandler.tc22SAA_RemoveVoicemail.getAddonName();
        getFidoCheckOutPage().selectAddon(newAddon);
        getReporter().reportLogPassWithScreenshot(   "Addon Getting Removed " +newAddon);
        getReporter().hardAssert(getFidoorderreviewpage().isAddonReviewPageDisplayed(),
                "Addons Order Review Page Displayed","Addons Order Review Page Not Displayed");
        getFidoorderreviewpage().clkRemoveBtn();
        getReporter().hardAssert(getFidoorderreviewpage().clkRemovalModalBtn(),
                "Clicked Remove on Addon Removal Modal","Addon Removal Modal not displayed");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyAddonOrderConfirm(),
                "Addons Remove Confirmation Page Displayed","Addons Remove Confirmation Page Not Displayed");
        String removeConfirmMessage = getFidoorderconfirmationpage().getOrderConfirmMsg();
        getReporter().reportLogPassWithScreenshot("Addons Remove Confirmation Message: " +removeConfirmMessage);
        getFidoorderconfirmationpage().clickBackToAddonBtn();
        getReporter().hardAssert(getFidoCheckOutPage().verifyAddonsPage(),
                "Fido Standalone Addons Page Displayed after Add-on Removal","Fido Standalone Addons Page not Displayed after Add-on Removal");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
