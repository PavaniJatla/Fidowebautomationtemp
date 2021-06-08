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


public class FidoSS_Regression_TC90_ValidateFidoUserWithDeviceSubsidyAcctHolderProfile_ON extends BaseTestClass{

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,
                strLanguage, FidoEnums.GroupName.selfserve,method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }

    @Test(groups = {"DashboardSS"})
    public void postPaidDashBoardValidateFullyFinancedDevice() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
        getReporter().reportLogWithScreenshot("DashBoard verification started");
        getFidohomepage().clkLogin();
        getFidologinpage().switchToSignInFrame();
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc90.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc90.getPassword());
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
        //getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
        getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(TestDataHandler.tc90.getaccountDetails().getCtn());
        getReporter().reportLogWithScreenshot("Click on CTN badge");
        getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
        getReporter().reportLogWithScreenshot("dashboard page loaded");

        getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();

        getReporter().reportLogWithScreenshot("Validate device details Section");


        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMyDeviceDetails(),
                "My Device section is visible",
                "My Device section is not visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDeviceRemainingExists(),
                "The balance remaining exists",
                "The balance remaining does not exist");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyUpgradeDeviceButtonExists(),
                "Upgrade My Device Button Exists",
                "Upgrade My Device Button Does Not Exist");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDeviceNameExists(),
                "The Device Name Exists",
                "The Device Name Does Not Exist");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifySubsidyEndDateExists(),
                "The Subsidy End date Exists",
                "The Subsidy End date Does Not Exist");


    }


}
