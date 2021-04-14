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


public class FidoSS_Regression_TC18_ValidateDeviceSectionAndDeviceDetailsModalForCXWithSubsidyPaidOFF_SubscriberProfile_ON extends BaseTestClass{

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

        String userName = "";
        String password = "";


        userName = TestDataHandler.tc04_PostPaidFinancePaidOff.getUsername();
        password = TestDataHandler.tc04_PostPaidFinancePaidOff.getPassword();
        String strCTN = TestDataHandler.tc04_PostPaidFinancePaidOff.getaccountDetails().getCtn();
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
        //getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
        getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
        getReporter().reportLogWithScreenshot("Click on CTN badge");
        getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
        getReporter().reportLogWithScreenshot("dashboard page loaded");

        getFidowirelessdashboardpostpaidpage().scrollToMidOfDasboardPage();

        getReporter().reportLogWithScreenshot("Validate device details Section");


        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMyDeviceDetails(),
                "My Device section is visible",
                "My Device section is not visible");

        //validate user has subsidy paid in full

        //user will see you're eligible for a new device

        //user will see the cta to hup

        //user will not see the start and end dates

        //user will not have a link to device detail modal

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isFidoPaymentProgramVisible(),
                "Fido Payment Program Header is visible",
                "Fido Payment Program Header is not visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().getDeviceFinancingRemainingBalance(),
                "The balance remaining is $0.00",
                "The balance remaining is not $0.00");

        getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().isPaymentProgramBalanceVisible(),
                "Remaining Fido Payment Program balance is not visible",
                "Remaining Fido Payment Program balance is visible");

        getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().isPaymentAgreementStartDateVisible(),
                "Fido Payment Program agreement start date is not visible",
                "Fido Payment Program agreement start date is visible");

        getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().isPaymentAgreementEndDateVisible(),
                "Fido Payment Program agreement end date is not visible",
                "Fido Payment Program agreement end date is visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isFindOutYourExclusiveDealsTextVisible(),
                "Find out your exclusive deals text is visible",
                "Find out your exclusive deals is not visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isGetANewDeviceLinkVisible(),
                "Get a new device link is visible",
                "Get a new device link is not visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isPricePlanChangeMayBeRequiredTextVisible(),
                "A price plan change may be required text is visible",
                "A price plan change may be required text is not visible");

        getReporter().softAssert(!getFidowirelessdashboardpostpaidpage().isViewFidoPaymentProgramDetailsLinkVisible(),
                "link to device details modal is not visible",
                " link to device details modal is visible");



    }


}
