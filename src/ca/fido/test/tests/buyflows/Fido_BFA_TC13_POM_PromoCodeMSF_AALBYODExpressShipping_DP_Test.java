package ca.fido.test.tests.buyflows;

import ca.fido.test.base.BaseTestClass;
import ca.fido.test.helpers.FidoEnums;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Fido_BFA_TC13_POM_PromoCodeMSF_AALBYODExpressShipping_DP_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)@Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser ,strLanguage, FidoEnums.GroupName.buyflows ,  method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"RegressionBFA","AALBFA","POM"})
    public void tc13_POMPromoCodeMSFFidoAALBYODExpressShippingDPAddonTest() {
        getFidologinpage().setUsernameInFrame(TestDataHandler.tc13AALBYODExpressShipping.getUsername());
        getFidologinpage().clkContinueSignIn();
        getFidologinpage().setPasswordInFrame(TestDataHandler.tc13AALBYODExpressShipping.getPassword());
        getReporter().reportLogWithScreenshot("Login overlay");
        getFidologinpage().clkLoginInFrame();
        getFidologinpage().switchOutOfSignInFrame();
        //getReporter().hardAssert(getFidoaccountoverviewpage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl") + "/phones/bring-your-own-device?flowType=aal");
        getReporter().hardAssert(getFidobuildplanpage().verifyContinueBtnPlanStepper(),"Fido plan config page is displayed" , "Fido plan config page is not displayed");
        getReporter().reportLogWithScreenshot("Fido plan config page");
        //getFidochoosephonepage().selectAddALineButton();
        //getReporter().reportLogPassWithScreenshot("Add a Line Button Selected");
        //getFidobuildplanpage().clkDeviceBalancePopUp();
        //getReporter().reportLogWithScreenshot("Continue on Device balance pop-up is selected");
        // ***************************Promo Section************************************
        getFidobuildplanpage().clkPromoSection();
        getReporter().reportLogWithScreenshot("Promo Section Displayed");
        getFidobuildplanpage().setPromoCode(TestDataHandler.tc13AALBYODExpressShipping.getPromoCode());
        getReporter().reportLogWithScreenshot("Promo Code Entered");
        getFidobuildplanpage().clkCheckPromoBtn();
        getReporter().hardAssert(getFidobuildplanpage().verifyPromoSuccessMsg(), "Promo Code Applied Successfully", "Promo Code Not Applied");
        getFidobuildplanpage().clickContinuePromoModal();
        // ***************************Plan Builder page************************************
        String dataOptionIndex = TestDataHandler.tc13AALBYODExpressShipping.getDataOptionIndex();
        getFidobuildplanpage().clkDataOption(dataOptionIndex, this.getClass().getSimpleName());
        //getFidobuildplanpage().clkNoBPOOfferButtonTalkOptions();
        getReporter().reportLogWithScreenshot("Plan Config Page Data Options selected");
        getFidobuildplanpage().selectBYODdpAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection Addon option is selected");
        getFidobuildplanpage().enterDPIMEI(TestDataHandler.tc13AALBYODExpressShipping.getDpIMEI());
        getReporter().reportLogPassWithScreenshot("DP Addon IMEI Entered");
        getFidobuildplanpage().setDPDeviceStorage(TestDataHandler.tc13AALBYODExpressShipping.getDpDeviceStorage());
        getReporter().reportLogPassWithScreenshot("DP Addon Device Storage Selected");
        getFidobuildplanpage().setDPDeviceColor(TestDataHandler.tc13AALBYODExpressShipping.getDpDeviceColor());
        getReporter().reportLogPassWithScreenshot("DP Addon Device Color Selected");
        getFidobuildplanpage().clkDpEligCheckBtn();
        getReporter().hardAssert(getFidobuildplanpage().verifyEligibilityMsg(),"Entered IMEI is eligible for Device Protection Addon","Entered IMEI is not eligible");
        getFidobuildplanpage().clkContinueAddOns();
        getReporter().reportLogWithScreenshot("Plan Config Page Addons Options selected");
        getFidobuildplanpage().clickeSIMContinueButton();
        getFidobuildplanpage().clkContinueCallerID();
        getReporter().reportLogWithScreenshot("Called ID information entered and continue button pressed");
        getReporter().hardAssert(getFidobuildplanpage().verifyCartLineItem(),"Promo Code and Discount amount Line Item displayed","Promo code line item not displayed");
        getReporter().hardAssert(getFidobuildplanpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String dpAddon = getFidobuildplanpage().getDeviceProtectionAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection - " +dpAddon);
        getFidobuildplanpage().clkContinueBelowCartSummary();
        getReporter().reportLogWithScreenshot("Plan Config Page Checkout Button selected");
        String cityName = TestDataHandler.tc13AALBYODExpressShipping.getCityName();
        getFidoCheckOutPage().selectCityForChooseYourTelephoneNum(cityName);
        getReporter().reportLogWithScreenshot("City Name and available phone number selected");
        getFidopaymentoptionspage().clickSkipAutopay();
        getReporter().hardAssert(getFidoCheckOutPage().verifyShippingLabelCheckOutPage() , "Shipping label displayed"  ,"Shipping label not displayed");
        String deliveryMethod = TestDataHandler.tc13AALBYODExpressShipping.getShippingType();
        getFidoCheckOutPage().clkShippingType(deliveryMethod);
        if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
            getReporter().reportLogWithScreenshot("Express Shipping selected");
            getReporter().hardAssert(getFidoCheckOutPage().verifyMapOnCheckOutPage() , "Bopis Map displayed" , "Bopis Map not displayed");
        } else {
            getReporter().reportLogWithScreenshot("Shipping selected");
        }
        getFidoCheckOutPage().clkShippingContinueButton();
        getFidoCheckOutPage().clksaveAndContinueBtnCheckoutPage();
        getReporter().reportLogWithScreenshot("Selecting submit on Checkout");
        getFidoCheckOutPage().clkSubmitButton();
        boolean isPaymentRequired = getFidoorderreviewpage().verifyPaymentRequired();
        getReporter().hardAssert(getFidoorderreviewpage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String deviceProtectionAddon = getFidoorderreviewpage().getDeviceProtectionAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
        getFidoorderreviewpage().clkTermsNConditionsAgreementConsent();
        //getFidoorderreviewpage().clkTermsNConditionsFinancingConsent();
        getFidoorderreviewpage().setOrderCommunicationConsent();
        getReporter().reportLogWithScreenshot("Terms and conditions clicked");
        getFidoorderreviewpage().clkSubmitMyOrder();
        getReporter().reportLogPass("Submit button selected");
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

}
