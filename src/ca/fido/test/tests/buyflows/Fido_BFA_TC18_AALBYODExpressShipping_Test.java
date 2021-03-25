package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC18_AALBYODExpressShipping_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","SanityBFA","AALBFA"})
    public void aALBYODStandardShippingFlowTest() {
        //getReporter().hardAssert(getFidohomepage().verifyHomePageLoaded() , "Home page loaded successfully" , "Home page not loaded successfully");
        getFidohomepage().clkLogin();
        getFidologinpage().switchToSignInFrame();
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc17AALTabletsStandardShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc17AALTabletsStandardShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        /*getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");*/
/*        getFidoaccountoverviewpage().clkViewUsageAndManageLink();
        getFidowirelessdashboardpostpaidpage().closeOverlayPopup();
        getReporter().hardAssert(getFidowirelessdashboardpostpaidpage().verifyWirelessDashboardPageLoad(), "Mobile Dashboard page loaded", "Mobile Dashboard page load error");
        getReporter().reportLogWithScreenshot("Mobile Dashboard page");*/
        //getDriver().get(System.getProperty("AWSUrl") + "/phones");
        getReporter().hardAssert(getFidobuildplanpage().verifyContinueDeviceCostButton(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
        getReporter().reportLogWithScreenshot("Fido plan config page");
        //getFidochoosephonepage().selectAddALineButton();
        //getReporter().reportLogPassWithScreenshot("Add a Line Button Selected");
        //getFidobuildplanpage().clkDeviceBalancePopUp();
        //getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        String dataOptionIndex = TestDataHandler.tc17AALTabletsStandardShipping.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueCallerID();
        getReporter().reportLogWithScreenshot("Called ID information entered and continue button pressed");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        String cityName = TestDataHandler.tc17AALTabletsStandardShipping.getCityName();
        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(cityName);
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        getFidoCheckOutPage().clkShippingType("STANDARD");
        getReporter().reportLogWithScreenshot("Shipping selected");
        getFidoCheckOutPage().clkShippingContinueButton();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
        getReporter().reportLogWithScreenshot("Order Confirmation page");
    }

}
