package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC09_POM_PromoCodeHWFin_HUPWithPPCUsingFinancingAutoPayPlan_StdShipping_High_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @Test(groups = {"RegressionBFA","HUPBFA","POM"})
    public void tc09_POMPromoCodeHWFinFidoHUPWithPPCFinancingAutoPayPlanStdShippingHighRiskAcctTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc09HupPpcFinancingStandardShipping.getUsername());
        getFidologinpage().clkContinueSignIn();
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc09HupPpcFinancingStandardShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl")+"/phones?flowType=hup&?setLanguage=EN&?province=ON");
        getReporter().reportLogWithScreenshot("Fido Choose Phones Page");
        String deviceName = TestDataHandler.tc09HupPpcFinancingStandardShipping.getNewDevice();
        getFidochoosephonepage().selectDevice(deviceName);
        getReporter().reportLogWithScreenshot("Device " + deviceName + " Selected");
        getReporter().reportLogWithScreenshot("Fido Device Configuration page loaded");
        getReporter().hardAssert(getFidodeviceconfigpage().verifyContinueButton(),"Continue button is displayed","Continue button is not displayed");
        String deviceCost = getFidodeviceconfigpage().getDeviceFullPrice();
        String financeProgramCredit = "0.0";
        financeProgramCredit = getFidodeviceconfigpage().getFinanceProgramCreditPrice();
        getFidodeviceconfigpage().clickContinueButton();
        // ***************************Promo Section************************************
        getFidobuildplanpage().clkPromoSection();
        getReporter().reportLogWithScreenshot("Promo Section Displayed");
        getFidobuildplanpage().setPromoCode(TestDataHandler.tc09HupPpcFinancingStandardShipping.getPromoCode());
        getReporter().reportLogWithScreenshot("Promo Code Entered");
        getFidobuildplanpage().clkCheckPromoBtn();
        getReporter().hardAssert(getFidobuildplanpage().verifyPromoSuccessMsg(),
                "Promo Code Applied Successfully", "Promo Code Not Applied");
        getFidobuildplanpage().clickContinuePromoModal();
        getFidobuildplanpage().clkContinueDeviceCost();
        //String deviceCostIndex = TestDataHandler.tc11HupPpcFinancingExpressShipping.getDeviceCostIndex();
        //getFidobuildplanpage().clkDeviceCost(deviceCostIndex);
        getReporter().reportLogWithScreenshot("Plan Config Page Device Cost option selected");
        getFidobuildplanpage().clkDeviceBalancePopUp();
        getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        //getReporter().hardAssert(getFidobuildplanpage().verifyAutoPayPlanSelection(getFidobuildplanpage().getAutoPayPlanIndex("MSF"),this.getClass().getSimpleName()),
        //        "Autopay plan is selected successfully","Autopay plan is not selected");
        //getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        //getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getFidobuildplanpage().clkContinueDataOption();
        getReporter().reportLogWithScreenshot("Plan Config Page Talk Options selected");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clkContinueDeviceProtection();
        getReporter().hardAssert(getFidobuildplanpage().verifyCartLineItem(),
                "Promo Code and Discount amount Line Item displayed","Promo code line item not displayed");
        getReporter().hardAssert(getFidobuildplanpage().verifyAutoPayDiscountInCartSummary(),"AutoPay discount is added in cart summary",
                "AutoPay is not added in cart summary");
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        String expectedDownPayment = getFidocreditcheckpage().setDownPaymentUpfrontEdge(TestDataHandler.tc09HupPpcFinancingStandardShipping.getRiskClass(),deviceCost,financeProgramCredit);
        getReporter().reportLog("Expected DownPayment: <b> " +expectedDownPayment +"</b>");
        getReporter().hardAssert(getFidopaymentoptionspage().verifyAutoPaymentPage(),"Autopay payment page is displayed","Autopay payment page is not displayed");
        getFidopaymentoptionspage().enterBankDetails();
        getFidopaymentoptionspage().clkAutoPayConsentCheckBox();
        getReporter().reportLogWithScreenshot("AutoPay Enrolled - Bank Method");
        getFidopaymentoptionspage().billingOptionClkContinue();
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        getReporter().softAssert(getFidocreditcheckpage().verifyDownPaymentAmt(expectedDownPayment),
                "Downpayment amount is displayed correctly", "Downpayment amount is not displayed correctly");
        String deliveryMethod = TestDataHandler.tc09HupPpcFinancingStandardShipping.getShippingType();
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
        getReporter().hardAssert(getFidobuildplanpage().verifyCartLineItem(),
                "Promo Code and Discount amount Line Item displayed","Promo code line item not displayed");
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected on review page");
        if(isPaymentRequired) {
            getReporter().reportLogWithScreenshot("OneTime payment page displayed");
            getReporter().softAssert(getFidopaymentpage().verifyOneTimePaymentTitle(),
                    "One Time Payment Page displayed","One Time Payment Page Not displayed");
            String otpAmount = getFidopaymentpage().getOneTimePaymentAmount();
            getReporter().reportLogWithScreenshot("One Time Payment Amount = " +otpAmount);
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
