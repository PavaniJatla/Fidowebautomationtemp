//package ca.fido.test.tests.buyflows;
//
//import ca.fido.test.base.BaseTestClass;
//import ca.fido.test.helpers.FidoEnums;
//import ca.fido.testdatamanagement.TestDataHandler;
//import org.apache.http.client.ClientProtocolException;
//import org.testng.ITestContext;
//import org.testng.annotations.*;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//
///**
// * TC02-Fido-Validate User able to perform NAC Flow - Single Line BYOP
// * 
// * Launch Fido.ca
// * Click on Shop -- plans
// * Click on BYOP 
// * Select a BYOP plan for the device and click continue on add ons
// * Choose Addon's(optional) and click continue
// * Cart summary page is displayed and click on continue
// * Enter the necessary details for profile creation and click on continue
// * Enter the credit card and Personal ID details
// * Select a number for the device and click on save
// * select any payment option and click on submit
// * Review your order and click on continue
// * 
// * @author rajesh.varalli1
// *
// */
//public class Old_Fido_BFA_TC08_NAC_SL_BYOP_Test extends BaseTestClass{
//
//	@Test
//	public void fidoSingleLineNacBYOP() {
//		getFidohomepage().clkShop();
//		getFidohomepage().clkPlans();
//		getReporter().reportLogWithScreenshot("Choose Plans page");
//		getFidochooseplanpage().clkAllPlans();
//		getReporter().reportLogWithScreenshot("All plans displayed");
//		getFidochooseplanpage().selectFirstAvailablePricePlan();
//		getReporter().reportLogWithScreenshot("Mobile Plans page");		
//		getFidochooseplanpage().clkContinue();
//		getReporter().reportLogWithScreenshot("Existing Customer and new to Fido overlay");
//		getFidobuildplanpage().clkCreateAccount();
//		getReporter().reportLogWithScreenshot("Choose SIM page");
//		getFidochossesimpage().clkContinue();
//		getReporter().reportLogWithScreenshot("Cart Summary page");
//		getFidocartsummarypage().clkContinue();
//		getFidocreateuserpage().setCommunicationDetails();
//		getFidocreateuserpage().setFirstName();
//		getFidocreateuserpage().setLastName();
//		getFidocreateuserpage().setPhone();
//		getFidocreateuserpage().setHomeAddress(TestDataHandler.testCase02.getBillingAddress());
//		getReporter().reportLogWithScreenshot("Create User page");
//		getFidocreateuserpage().clkContinue();
//		getFidocreditcheckpage().selectDOBYear();
//		getFidocreditcheckpage().selectDOBMonth();
//		getFidocreditcheckpage().selectDOBDay();
//		getFidocreditcheckpage().setCreditCardNumber(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber());
//		getFidocreditcheckpage().setCreditCardExpiryMonthAndYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth());
//		getFidocreditcheckpage().setCreditCardExpiryYear(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear());
//		getFidocreditcheckpage().selectDrivingLicenseProvince(TestDataHandler.testCase02.getDlProvinceCode());
//		getFidocreditcheckpage().setDrivingLicenseNumber(TestDataHandler.testCase02.getDlProvinceCode());
//		getFidocreditcheckpage().selectDrivingLicenseExpiryYear();
//		getFidocreditcheckpage().selectDrivingLicenseExpiryMonth();
//		getFidocreditcheckpage().selectDrivingLicenseExpiryDay();
//		getFidocreditcheckpage().clkCreditCheckConsent();
//		getReporter().reportLogWithScreenshot("Credit Evaluation page");
//		getFidocreditcheckpage().clkContinue();
//		getFidocreditcheckpage().waitForCreditCheckProcessing();
//		getFidocreditcheckpage().clkBtnSecurityDepositConsentAccept();
//		getFidochoosenumberpage().clkSelectNewNumber();
//		getFidochoosenumberpage().selectCity(TestDataHandler.testCase02.getCtnCity());
//		getFidochoosenumberpage().clkFindAvailableNumbers();
//		getFidochoosenumberpage().selectFirstAvailableNumber();
//		getReporter().reportLogWithScreenshot("Choose Phone Number page");
//		getFidochoosenumberpage().clkContinue();
//		getFidopaymentoptionspage().setManualPaymentMethod();
//		getReporter().reportLogWithScreenshot("Payment Options page");
//		getFidopaymentoptionspage().clkSubmit();
//		getFidoorderreviewpage().clkTermsNConditionsConsent();
//		getFidoorderreviewpage().setContractDigitalCopyEmail();
//		getReporter().reportLogWithScreenshot("Order Review page");
//		getFidoorderreviewpage().clkContinueToPayment();
//		getReporter().reportLogWithScreenshot("Waiting for Order Confirmation");
//		getFidoorderreviewpage().waitForOrderProcessing();
//		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
//		getReporter().reportLogWithScreenshot("Order Confirmation Page");
//	}
//	
//	@Parameters({"strBrowser", "strLanguage"})
//	@BeforeMethod
//    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
//		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
//    }
//
//	@AfterMethod(alwaysRun = true)
//    public void afterTest() {
//    	closeSession();
//    }
//
//}
