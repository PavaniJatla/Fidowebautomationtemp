package ca.fido.test.tests.visual;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.StitchMode;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.annotation.meta.Exclusive;
import java.io.IOException;
import java.lang.reflect.Method;

public class FIDOSS_TC01_ValidateCTNSelectorAndSubNavigationWirelessDashboardCDKVersionChange extends BaseTestClass {

    private static BatchInfo fidobatch;
    String strBrowser = "firefox";
    String strLanguage = "fr";

    @BeforeClass
    public static void setBatch(){
        // Must be before ALL tests (at Class-level)
        fidobatch = new BatchInfo("FidoVisualTest");
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,
                strLanguage, FidoEnums.GroupName.selfserve,method);
        initiateEyes();
        // Set Batch name
        eyes.setBatch(fidobatch);
        // Set branch name
        eyes.setBranchName("Fido CAM Visual Validation");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
        eyes.abortIfNotClosed();
    }

    @Test()
    public void validateFidoWirelessDashboardPage() throws InterruptedException {
        String userName = TestDataHandler.tc73.getUsername();
        String password = TestDataHandler.tc73.getPassword();
        String strMultiCTNBAN = TestDataHandler.tc73.getaccountDetails().getBan();
        String strCTNValue = TestDataHandler.tc73.getaccountDetails().getCtn();
        //capture the full page for validation
        eyes.setForceFullPageScreenshot(true);
        //stitch the page together using CSS
        eyes.setStitchMode(StitchMode.CSS);
        //set testname
        eyes.open(getDriver(),"Fido Pages", "TC01");
        Thread.sleep(5000);
        //getDriver().get(System.getProperty("QaUrl")+"/profile/signin");
        getReporter().reportLog("Fido Launch page, visual check point added");
        getFidohomepage().clkLogin();
        getReporter().reportLog("Sign In Overlay opened, add visual check point");
        getFidologinpage().switchToSignInFrame();
        getFidologinpage().setUsernameInFrame(userName);
        getFidologinpage().setPasswordInFrame(password);
        eyes.checkWindow("Fido Home Page");
        getReporter().reportLog("Details entered in Sign In Overlay, add visual check point");
        getFidologinpage().clkLoginInFrame();
        Thread.sleep(5000);
        try{
            eyes.checkWindow("Fido Phone Recovery Page");
            getFidologinpage().switchOutOfSignInFrame();
        } catch (StaleElementReferenceException e) {
            getFidologinpage().switchOutOfSignInFrame();
        }
        getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfShowAllLinesLinkIsDisplayd(strMultiCTNBAN),
                "View all lines CTA link is displayed to show the CTNs in expanded view",
                "View all lines CTA link is NOT displayed it seems");
        getFidoaccountoverviewpage().clkShowAllLinesLink();
        eyes.checkWindow("Fido Overview Page");
        getFidoaccountoverviewpage().clickCTNsViewUsageAndManageLink(strCTNValue);
        getReporter().hardAssert(getFidoaccountoverviewpage().IsCorrectDashboardOpen(String.valueOf(strCTNValue).replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1 $2-$3")),
                "User is directed to the corresponding CTN : "+strCTNValue+" Fido Wireless Dashboard as expected",
                "It seems the User didnt get directed to the CTN "+strCTNValue+"  Fido Wireless Dashboard as expected, ");
        getFidowirelessdashboardpostpaidpage().verifyTalkPlanDetailsSectionIsDisplayed();
        eyes.checkWindow("Fido Wireless Dashboard Page");
        getFidowirelessdashboardpostpaidpage().setDrpSelectAnotherLine("4168241327");
        getReporter().hardAssert(getFidoaccountoverviewpage().IsCorrectDashboardOpen(String.valueOf("4168241327").replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1 $2-$3")),
                "User is directed to the corresponding CTN : "+strCTNValue+" Fido Wireless Dashboard as expected",
                "It seems the User didnt get directed to the CTN "+strCTNValue+"  Fido Wireless Dashboard as expected, ");
        getFidowirelessdashboardpostpaidpage().verifyTalkPlanDetailsSectionIsDisplayed();
        eyes.checkWindow("Fido Wireless Dashboard Page for CTN2");
        getFidoaccountoverviewpage().NavigateToAccountOverViewFromDashbOard();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifyIfShowAllLinesLinkIsDisplayd(strMultiCTNBAN),
                "View all lines CTA link is displayed to show the CTNs in expanded view",
                "View all lines CTA link is NOT displayed it seems");
        getFidoaccountoverviewpage().clkShowAllLinesLink();
        eyes.checkWindow("Fido Overview Page after navigation from Wireless Dashboard Page");
        Thread.sleep(5000);
        TestResults result = eyes.close(false); //false means don't thow exception for failed tests
        reportVisualResult(result, null);
    }
}
