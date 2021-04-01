package ca.fido.test.tests.selfserve.desktop;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * The test will do Validation BYOD dashboard
 * 1. Sign in to Fido.ca
 * 2.Click on CTN
 * 3.Verify BYOD dashboard
 *
 * @author Rajat.Sharma
 */
public class FidoSS_TC087_ValidateFidoUserWithBYOD_DeviceSubscriberProfile extends BaseTestClass {


    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,
                strLanguage, FidoEnums.GroupName.selfserve, method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }

    @Test(groups = {"DashboardSS"})
    public void postPaidDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
        getReporter().reportLogWithScreenshot("DashBoard verification started");
        getFidohomepage().clkLogin();

        String userName = "";
        String password = "";


        userName = TestDataHandler.tc1122.getUsername();
        password = TestDataHandler.tc1122.getPassword();
        String strCTN = TestDataHandler.tc1122.getaccountDetails().getCtn();
        getFidologinpage().switchToSignInFrame();
        getFidologinpage().setUsernameInFrame(userName);
        getFidologinpage().setPasswordInFrame(password);
        getReporter().reportLogWithScreenshot("Login Credential is entered.");
        getFidologinpage().clkLoginInFrame();
        getReporter().hardAssert(!getFidologinpage().verifyIfErrorMsgIsDisplayedInFrame(),
                "Login proceed without error.",
                "Login failed with error.");
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(),
                "Login succeed.",
                "Failed to login.");
        getReporter().reportLogWithScreenshot("Account overview page");
        getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
        getReporter().reportLogWithScreenshot("Click on CTN badge");
        getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
        getReporter().reportLogWithScreenshot("dashboard page loaded");
        getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyMyDeviceThanksMessageIsDisplayed(),
                "Dashboard Section My Device Thanks message is Displayed",
                "Dashboard Section My Device Thanks message is not Displayed");
        getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyMyDeviceGetANewDeviceLnkIsDisplayed(),
                "Get A New Device Link is displayed",
                "Get A New Device Link  is not displayed");

    }

}
