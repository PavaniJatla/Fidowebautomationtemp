package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC14_HUPWithNoTermDeviceAndNoTermMultipleAccessories_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","HUPBFA"})
    public void fidoHUPWithNoTermDeviceAndNoTermMultipleAccessoriesFlowTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc14HupPpcFinancingStandardShipping.getUsername());
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc14HupPpcFinancingStandardShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        //getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl")+"/phones");
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc14HupPpcFinancingStandardShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getFidochoosephonepage().selectUpgradeMyDeviceButton();
        getReporter().reportLogPassWithScreenshot("Upgrade My Device Button Selected");
        //getReporter().hardAssert(getFidodeviceconfigpage().verifyDevicesInHeader(),"Page loading fine","Page is not loading");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyAddAccessoriesOption(),"Accessories option is displayed", "Accessories option is not displayed");
        getFidodeviceconfigpage().clkAddAccessoriesOption();
        getReporter().reportLogWithScreenshot("Accessories displayed successfully");
        getFidodeviceconfigpage().addAccessoriesToCart(TestDataHandler.tc14HupPpcFinancingStandardShipping.getAccessoriesCount(),
                TestDataHandler.tc14HupPpcFinancingStandardShipping.getAccessory1());
        getReporter().reportLogPassWithScreenshot("Accessories selected successfully");
        getFidodeviceconfigpage().clkContinueAccessories();
        //getFidobuildplanpage().clkContinueDeviceCost();
        //String deviceCostIndex = TestDataHandler.tc14HupPpcFinancingStandardShipping.getDeviceCostIndex();
        //getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        getFidobuildplanpage().clkRadioButtonNoTerm();
        getReporter().reportLogPass("No Term Tier selected in the Device cost");
        getFidobuildplanpage().clkContinueDeviceCost();
        getReporter().reportLogPass("Continue button on select your device cost clicked");
        //getFidobuildplanpage().clkContinueDataOption();
        /*getFidobuildplanpage().clkBasicTab();
        getFidobuildplanpage().selectBasicPlanAndClkContinueBtn(TestDataHandler.tc04NoTermStandardShipping.getDataOptionIndex(),this.getClass().getSimpleName());*/
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Accessories cost option stepper");
        getFidobuildplanpage().selectNoTermAccessoryCost();
        getReporter().reportLogWithScreenshot("NOTERM Accessories cost option is selected");
        getFidobuildplanpage().clkContinueAccessoriesCostSelection();
        getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc14HupPpcFinancingStandardShipping.getShippingType();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
        } else {
            getReporter().reportLogWithScreenshot("Shipping selected");
        }
        getFidoCheckOutPage().clkShippingContinueButton();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        boolean isPaymentRequired = getFidoorderreviewpage().verifyPaymentRequired();
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        //getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected on order review");
        if(isPaymentRequired) {
            getReporter().reportLogWithScreenshot("OneTime payment page displayed");
            getFidopaymentpage().setCreditCardName();
            getFidopaymentpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber2());
            getFidopaymentpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth2() + TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear2());
            getFidopaymentpage().setCreditCardCvv(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCvv2());
            getReporter().reportLogWithScreenshot("OneTime payment page displayed before submitting");
            getFidoorderreviewpage().clkSubmitMyOrder();
        }
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Thank you message Confirmed", "Thank you message Error");
        getReporter().hardAssert(getFidoorderconfirmationpage().verifyOrderConfirm(), "Order Confirmed", "Order Confirmation Error");
        getReporter().reportLogWithScreenshot("Order Confirmation page");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
