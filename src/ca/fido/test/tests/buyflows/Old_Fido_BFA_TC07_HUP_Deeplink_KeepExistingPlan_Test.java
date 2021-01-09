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
// * TC05- Fido- Validate user able to perform HUP Deeplink Flow - keep existing plan(Financing only)
// * 
// * Deeplink to " https://www.fido.ca/hup/#/choose-phone"  in fido
// * Enter the valid login credentials and click on login
// * select a device 
// * Select  " Keep existing plan " option and click continue
// * Select any addon's(optional) and click continue
// * Select the shipping address as Billing address and continue
// * Review your order and click on complete order
// * 
// * @author rajesh.varalli1
// */
//public class Old_Fido_BFA_TC07_HUP_Deeplink_KeepExistingPlan_Test extends BaseTestClass{
//
//	@Test
//	public void ppcUpgradeTierFlow() {
//		getDriver().get(TestDataHandler.bfaConfig.getHupURL());
//		getFidologinpage().switchToSignInFrame();
//		getFidologinpage().setUsernameInFrame(TestDataHandler.testCase04.getUsername());
//		getFidologinpage().setPasswordInFrame(TestDataHandler.testCase04.getPassword());
//		getReporter().reportLogWithScreenshot("Login overlay");
//		getFidologinpage().clkLoginInFrame();
//		getFidologinpage().switchOutOfSignInFrame();
//		getFidochoosephonepage().selectSubscriber(TestDataHandler.testCase04.getCtn());
//		getReporter().hardAssert(getFidochoosephonepage().selectDevice(TestDataHandler.testCase04.getNewDevice()),"Device Found and Selected","Device Not Found");
//		getFidobuildplanpage().keepExistingPlan();
//		getFidobuildplanpage().clkContinueToAddons();
//		getFidochooseaddonspage().clkContinueToShipping();
//		getFidoshippingpage().selectHomeAddress();
//		getFidoshippingpage().clkContinueToOrderReview();
//		getFidoorderreviewpage().clkTermsNConditionsConsent();
//		getFidoorderreviewpage().setContractDigitalCopyEmail(TestDataHandler.testCase04.getUsername());
//		if(getFidoorderreviewpage().isPaymentRequired()) {
//			getFidoorderreviewpage().clkContinueToPayment();
//			getFidopaymentpage().setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
//												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
//												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
//												   TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
//			getFidopaymentpage().clkContinueOrder();
//		} else {
//			getFidoorderreviewpage().clkCompleteOrder();
//		}
//		getFidoorderreviewpage().waitForOrderProcessing();
//		getReporter().hardAssert(getFidoorderconfirmationpage().verifyThankYou(), "Order Confirmed", "Order Confirmation Error");
//		getReporter().reportLogWithScreenshot("Order Confirmation page");
//	}
//	
//	@Parameters({"strBrowser", "strLanguage"})
//	@BeforeMethod
//    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
//		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
//		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, FidoEnums.GroupName.buyflows ,  method);
//    }
//
//	@AfterMethod(alwaysRun = true)
//    public void afterTest() {
//    	closeSession();
//    }
//
//}
