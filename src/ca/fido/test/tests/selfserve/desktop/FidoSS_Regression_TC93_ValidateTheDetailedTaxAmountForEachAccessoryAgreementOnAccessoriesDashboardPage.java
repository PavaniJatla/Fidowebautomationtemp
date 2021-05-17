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


public class FidoSS_Regression_TC93_ValidateTheDetailedTaxAmountForEachAccessoryAgreementOnAccessoriesDashboardPage extends BaseTestClass{

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
    public void validateTheDetailedTaxAmountForEachAccessoryAgreementOnAccessoriesDashboardPage() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
        getReporter().reportLogWithScreenshot("DashBoard verification started");
        getFidohomepage().clkLogin();

        String userName = "";
        String password = "";
        userName = TestDataHandler.tc93.getUsername();
        password = TestDataHandler.tc93.getPassword();
        String strCTN = TestDataHandler.tc93.getaccountDetails().getCtn();
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
        //4. The accessories entry point widget should be displayed for the eligible CTN on AO page as per copy.
        getCommonbusinessflows().scrollToMiddleOfWebPage();
        getReporter().reportLogWithScreenshot("CTN and accessories view");
        getReporter().hardAssert(getFidoaccountoverviewpage().verifyFinancedAccessoriesIsDisplayed(),
                "Financed Accessories Is visible",
                "Financed Accessories is not visible");
        getCommonbusinessflows().scrollToTopOfWebPage();
        getFidoaccountoverviewpage().clkFinancedAccessories();

        //5. The user will be presented with the Non-Sim Accessory Dashboard
        // (Accessories Images and description as expected) with the tax breakdown of the prices
        // and CTA button to see more details.
        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().isAccessoryPageOpen(),
                "the Non-Sim Accessory Dashboard is diaplayed",
                "the Non-Sim Accessory Dashboard is not visible");


        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateTotalMonthlyFinancingPayment(),
                "Total Monthly Finance Payment validated",
                "Total Monthly Finance Payment is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateMonthlyFinancingPayment(),
                "Monthly Finance Payment validated",
                "Monthly Finance Payment is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateMonthlyFinancedTaxes(),
                "Monthly Finance Taxes Payment validated",
                "Monthly Finance Taxes Payment is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateTotalRemainingFinancingBalance(),
                "Total Monthly Finance Balance validated",
                "Total Monthly Finance Balance is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateRemainingFinancingBalance(),
                "Remaining Financing Balance validated",
                "Remaining Financing Balance is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateRemainingFinancedTaxes(),
                "Remaining Financed Taxes validated",
                "Remaining Financed Taxes is NOT validated");

        //Accessories:
        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateFinancingEnding(),
                "Financing Ending date is validated",
                "Financing Ending date  is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateStarted(),
                "Started date is validated",
                "Started date is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateAgreementID(),
                "Agreement ID is  validated",
                "Agreement ID is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateFinancingTerm(),
                "Financing Term period validated",
                "Financing Term period is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateMonthlyFinancingPaymentOfAnAgreement(),
                "Monthly Financing Payment Of An Agreement is validated",
                "Monthly Financing Payment Of An Agreement is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateBalanceRemaining(),
                "Balance remaining is validated",
                "Balance remaining is NOT validated");

        getFidoFinanceAccessoriesPagePage().clkBtnSeeMoreDetails();

        getReporter().reportLogWithScreenshot("Accessories details modal view");


        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateYourFinancingBalanceWillBeZeroOn(),
                "You fincance balance will be zero on is validated on details modal",
                "You fincance balance will be zero on is NOT validated on details modal");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateAccessoryPurchaseDate(),
                "Accessory purchase date is validated",
                "Accessory purchase date is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateAgreementIDOndetailsModal(),
                "AgreementID On details Modal is validated",
                "AgreementID On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateFinancingTermOndetailsModal(),
                "Financing Term On details Modal is validated",
                "Financing Term On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateTotalMonthlyFinancingPaymentOndetailsModal(),
                "Total Monthly Financing Payment On details Modal is validated",
                "Total Monthly Financing Payment On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateMonthlyFinancingPaymentOndetailsModal(),
                "Monthly Financing Payment On details Modal is validated",
                "Monthly Financing Payment On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateMonthlyFinancedTaxesOndetailsModal(),
                "Monthly Financed Taxes On details Modal is validated",
                "Monthly Financed Taxes On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateTotalRemainingFinancingBalanceOndetailsModal(),
                "Total Remaining Financing Balance On details Modal is validated",
                "Total Remaining Financing Balance On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateRemainingFinancingBalanceOndetailsModal(),
                "Remaining Financing Balance On details Modal is validated",
                "Remaining Financing Balance On details Modal is NOT validated");

        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateRemainingFinancedTaxesOndetailsModal(),
                "Remaining Financed Taxes On details Modal is validated",
                "Remaining Financed Taxes On details Modal is NOT validated");

        getFidoFinanceAccessoriesPagePage().clickCLoseModal();

        getCommonbusinessflows().scrollToMiddleOfWebPage();
        getReporter().reportLogWithScreenshot("Accessories details view");
        getReporter().softAssert(getFidoFinanceAccessoriesPagePage().validateAccessoryContentAndImageDisplayedCorrectly(),
                "Accessory Content And Image Displayed Correctly",
                "Accessory Content And Image needs investigation");




    }


}
