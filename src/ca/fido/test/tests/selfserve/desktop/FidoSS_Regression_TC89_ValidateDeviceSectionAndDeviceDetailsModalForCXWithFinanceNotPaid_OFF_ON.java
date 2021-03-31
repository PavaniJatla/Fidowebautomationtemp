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


public class FidoSS_Regression_TC89_ValidateDeviceSectionAndDeviceDetailsModalForCXWithFinanceNotPaid_OFF_ON extends BaseTestClass{

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

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isPaymentProgramBalanceVisible(),
                "The Remaining Fido Payment Program balance is visible",
                "The Remaining Fido Payment Program balance is Not visible");


        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyDeviceRemainingExists(),
                "The Monthly balance remaining exists",
                "The Monthly balance remaining Does Not exist");


        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isPaymentAgreementStartDateVisible(),
                "Fido Payment Program agreement start date is Visible",
                "Fido Payment Program agreement start date is Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isPaymentAgreementEndDateVisible(),
                "Fido Payment Program agreement end date is visible",
                "Fido Payment Program agreement end date not visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().isViewFidoPaymentProgramDetailsLinkVisible(),
                "View Fido Payment Program Details Link is Visible",
                "View Fido Payment Program Details Link is Not Visible");


        getFidowirelessdashboardpostpaidpage().ClickFidoPaymentProgramDetailsLink();

        getReporter().reportLogWithScreenshot("Fido Payment Program Details Loaded");


        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyActivationDateExists(),
                "Activation Date is Visible",
                "Activation Date is Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyFidoPaymentProgramBalanceExists(),
                "Payment Program Balance is Visible",
                "Payment Program Balance is  Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyFidoPaymentProgramBalanceTotalExists(),
                "Fido Payment Program Balance is Visible",
                "Fido Payment Program Balance is  Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyFidoPaymentProgramBalanceBaseExists(),
                "Fido Payment Program Balance Base is Visible",
                "Fido Payment Program Balance Base is  Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyFidoPaymentProgramBalanceTaxExists(),
                "Fido Payment Program Balance Tax is Visible",
                "Fido Payment Program Balance Tax is  Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyTotalMonthlyFidoPaymentProgramPaymentExists(),
                "Fido Total Monthly Payment Program Payment is Visible",
                "Fido Total Monthly Payment Program Payment Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMonthlyFidoPaymentProgramPaymentExists(),
                "Fido Monthly Payment Program Payment is Visible",
                "Fido Monthly Payment Program Payment Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMonthlyFinancedTaxesExists(),
                "Fido Monthly Financed Taxes is Visible",
                "Fido Monthly Financed Taxes is Not Visible");

        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyMonthRemainingExists(),
                "Fido Monthly Remaining is Visible",
                "Fido Monthly Remaining is Not Visible");


        getFidowirelessdashboardpostpaidpage().ClickFidoPaymentProgramDetails();

        getReporter().reportLogWithScreenshot("Fido Payment Program Details Legal Copy");
        
        getReporter().softAssert(getFidowirelessdashboardpostpaidpage().verifyLegalCopyForFinancialProgramExists(),
                "Legal Copy for Financial is Visible",
                "Legal Copy for Financial  is Not Visible");
    }


}
