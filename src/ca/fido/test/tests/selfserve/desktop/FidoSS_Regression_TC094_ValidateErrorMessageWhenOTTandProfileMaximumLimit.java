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
import java.util.HashMap;
import java.util.Map;

/**
 * The test will verify demo-line account add data flow and manage data page,
 * as well as verify the total data and data accuracy in manage data page.
 * @author Mirza.Kamran
 *
 */
public class FidoSS_Regression_TC094_ValidateErrorMessageWhenOTTandProfileMaximumLimit extends BaseTestClass{



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

    @Test(groups = {"RegressionSS","DashboardSS"})
    public void verifyAddDataOnDemolineDashBoard() throws SSLHandshakeException, ClientProtocolException, IOException, InterruptedException {
        getReporter().reportLogWithScreenshot("DashBoard verification for Account : Demoline started");
        //getFidohomepage().clkLogin();

        String	userName = TestDataHandler.tc094.getUsername();
        String	password = TestDataHandler.tc094.getPassword();

        //getFidologinpage().switchToSignInFrame();
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
        String strCTN = TestDataHandler.tc094.getaccountDetails().getCtn();
        getFidoaccountoverviewpage().clkCTNsViewUsageAndManage(strCTN);
        getReporter().reportLogWithScreenshot("Click on CTN badge");
        getFidowirelessdashboardpostpaidpage().clkShowMyUsageIfVisible();
        getReporter().reportLogWithScreenshot("dashboard page loaded");

        getReporter().hardAssert(getFidodatamanagementpage().validateViewDetailsLink(),
                "'Data details' page is displayed after click on view details link",
                "'Data details' page is NOT displayed after click on view details link");
        getReporter().reportLogWithScreenshot("View details page opened");
        getCommonbusinessflows().scrollToMiddleOfWebPage();
        getReporter().reportLogWithScreenshot("Manage data page middle view");
        int countOfExistSpeedPass = getFidodatamanagementpage().getAllExistingAddDataCount();
        getCommonbusinessflows().scrollToTopOfWebPage();
        Map<String, Integer> countOfAlreadyAddedData = getFidodatamanagementpage().getCountOfAllExistingAddedDataValues();
        getFidodatamanagementpage().clkLinkBackOnManageDataOverlay();
        Map.Entry<String,Integer> entry = countOfAlreadyAddedData.entrySet().iterator().next();
        String strAddOnValue = entry.getKey();
        Integer intValue = entry.getValue();

        if(!(countOfExistSpeedPass>9) && intValue!=3) {
            for(int itr=1;itr<=(3-intValue);itr++)
            {
                completeAddDataFlow(strAddOnValue);
                getReporter().hardAssert(getFidoadddatapage().verifyAddDataSuccessMsgDisplayed(),
                        "Add data success message is displayed",
                        "Add data success message is not displayed");
                getReporter().reportLogWithScreenshot("Add data success modal.");
                getFidoadddatapage().clkCloseBtnOnAddDataOverlay();
            }
        }


        //Add extra time
        completeAddDataFlow(strAddOnValue);
        getReporter().hardAssert(getFidoadddatapage().isLimitReachedMsgDisplayed(),
                "Limit reached message is displayed for Add MDT/ OTT more than 3 times and more than 10 times",
                "Limit reached message is NOT displayed for Add MDT/ OTT more than 3 times and more than 10 times");
        getReporter().reportLogWithScreenshot("Limit Reached Overlay displayed");
        getFidoadddatapage().clkCloseBtnOnAddDataOverlay();

    }

    public void completeAddDataFlow(String strDataValue) {
        HashMap<String, String> speedPassPrice = new HashMap<String, String>();
        speedPassPrice.put("500", "10.00");
        speedPassPrice.put("2.5", "25.00");
        speedPassPrice.put("5", "40.00");
        getFidowirelessdashboardpostpaidpage().clkAddDataButton();
        getReporter().hardAssert(getFidoadddatapage().verifyOverlayMonthlyDataAddOnDisplayed(),
                "Monthly data add on overlay is displayed",
                "Monthly data add on overlay is not displayed");
        getReporter().reportLogWithScreenshot("Add monthly data add on overlay");

        getFidoadddatapage().clkTheDataAddOnValue(strDataValue);
        getFidoadddatapage().clkContinueBtnOnAddDataOverlay();
        getReporter().hardAssert(getFidoadddatapage().verifyConfirmPurchasingMsgDisplayed(System.getProperty("Language"),
                        speedPassPrice),
                "Confirm purchasing on overlay is displayed",
                "Confirm purchasing on overlay is not displayed");
        getReporter().reportLogWithScreenshot("Confirm purchasing on add data overlay");
        getFidoadddatapage().clkPurchaseBtnOnAddDataOverlay();
    }

}
