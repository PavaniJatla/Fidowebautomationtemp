package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC02 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with Standard Shipping(No Term plan)_E2E
 */

public class RogersBFA_TC02_NAC_NoTermPotgSSTest extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("AWSUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"RegressionBFA","SanityBFA","NACBFA"})
	public void rogersNACNoTermPotgSSTest() throws InterruptedException {

		// **************************Device catalog page*****************************************

		reporter.softAssert(getRogersDeviceCataloguePage().isRpotgBannerPresent(), "RPOTG Banner is present in the Device Catalog Page, verified by promo text", "RPOTG Banner is not present in the Device Catalog Page, verified by promo text");
		getRogersDeviceCataloguePage().clickRpotgBannerLearnMore();
		reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "RPOTG Learn More Modal is displayed", "Learn More Modal is not present");
		reporter.reportLogPassWithScreenshot("RPOTG Learn More Model");
		getRogersDeviceCataloguePage().clickCloseButtonOnModal();
		getRogersDeviceCataloguePage().clickCheckEligibilityRpotgBanner();
		reporter.reportLogPassWithScreenshot("RPOTG Check Eligibility Banner");
		getRogersDeviceCataloguePage().validateRpotgPostalCode(TestDataHandler.tc02NACNoTermPotgSS.getPostalCode());
		getRogersDeviceCataloguePage().clickCheckBtn();
		reporter.reportLogPassWithScreenshot("RPOTG: Postal Code & Check Eligibility Success");
		getRogersDeviceCataloguePage().clickContinueBtn();
		String postalCode = getRogersDeviceCataloguePage().verifyeligiblePostalCodeinBanner();
		reporter.hardAssert(postalCode.contains(TestDataHandler.tc02NACNoTermPotgSS.getPostalCode()), "RPOTG Banner has the eligible postal code displayed", "RPOTG Banner not displayed in banner");
		String deviceName = TestDataHandler.tc02NACNoTermPotgSS.getDeviceName();
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
		reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(), "Get started button on the modal is present", "Get started button on the modal is not present");
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(), "Clicked Get Started Button", "Get Started button not able to click");

		// ***************************Device config page************************************
		System.out.println(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner());
		System.out.println(TestDataHandler.tc02NACNoTermPotgSS.getPostalCode());
		reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc02NACNoTermPotgSS.getPostalCode()),
				"Eligible postal code verified in Device Catalog page Banner is carried on to Device Config Page Banner as expected", "Postal Code not matching");
		String rpotgLabelDeviceConfig = getRogersDeviceConfigPage().getRpotgLabelDeviceConfigPage();
		reporter.reportLogWithScreenshot("RPOTG Promo Label and subcopy verified in Device Config Page as" + "-->" + rpotgLabelDeviceConfig);
		String deviceNameDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceNameDeviceConfigPage().toUpperCase();
		String deviceSizeDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceSizeDeviceConfigPage().toUpperCase();
		String deviceColorDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceColorDeviceConfigPage().toUpperCase();
		String deviceInfoDeviceConfigPage = deviceNameDeviceConfigPage + " " + deviceSizeDeviceConfigPage + " " + deviceColorDeviceConfigPage;
		reporter.softAssert(getRogersDeviceConfigPage().verifyDefaultSizeSelected(), "Default value for size is selected", "Default value for size is not selected");
		reporter.reportLogPassWithScreenshot("Device Config Page" + "Device info:" + deviceInfoDeviceConfigPage);
		String pricingBlockValueDeviceConfigPage = getRogersDeviceConfigPage().getPricingBlockValueDeviceConfigPage();
		String pricePlanInfoDeviceConfigPage = getRogersDeviceConfigPage().getPricePlanValueDeviceConfigPage();
		reporter.softAssert(getRogersDeviceConfigPage().verifyBreadCrumb(),
				"BreadCrumb on Phone config page is working fine", "BreadCrumb is not working fine");
		String fullPriceDeviceConfigPage = getRogersDeviceConfigPage().getFullPrice();
		String promoBlockInformation = getRogersDeviceConfigPage().getPromoBlockText();
		reporter.reportLogPassWithScreenshot("Device config page Details" + "1. Price Block Value :"
				+ pricingBlockValueDeviceConfigPage + "2. Priceplan Info:" + pricePlanInfoDeviceConfigPage
				+ "3. Full Price:" + fullPriceDeviceConfigPage + "4. PromoBlock Info:" + promoBlockInformation);
		getRogersDeviceConfigPage().clickContinueButton();
		// ****************************Plan config// page***************************************
		System.out.print(getRogersPlanConfigPage().verifyeligiblePostalCodeinBanner());
		System.out.println(TestDataHandler.tc02NACNoTermPotgSS.getPostalCode());
		reporter.softAssert(getRogersPlanConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc02NACNoTermPotgSS.getPostalCode()),
				"Eligible postal code verified in Device Catalog & Device Config page POTG Banner is carried on to Plan Config Page Banner as expected",
				"Postal code not matching in Plan Config page");
		String rpotgLabelPlanConfig = getRogersPlanConfigPage().getRpotgLabelPlanConfigPage();
		reporter.reportLogWithScreenshot("RPOTG Label and subcopy verified in Plan Config Page verified as" + "--->" + rpotgLabelPlanConfig);
		reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
		getRogersPlanConfigPage().skipBPOOffer();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
		String monthlyFeesAmount = getRogersPlanConfigPage().getMonthlyFeesAmount();
		String oneTimeFeesAmount = getRogersPlanConfigPage().getOneTimeFeesAmount();
		reporter.reportLogPassWithScreenshot("Cart summary: Monthly & OneTimeFees" + monthlyFeesAmount + "&" + oneTimeFeesAmount);
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		// *****************************Create Profile Page*****************************************
		String totalMonthlyFees = getRogersCheckoutPage().getMonthlyFeeAfterTax();
		String oneTimeFee = getRogersCheckoutPage().getOneTimeFeeAfterTax();
		String purchaseIncludes = getRogersCheckoutPage().getPurchaseIncludesText();
		reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees" + totalMonthlyFees
				+ "2. oneTimeFee" + oneTimeFee + "3. Purchase Include" + purchaseIncludes);
		String labelRpotgPurchaseIncludesCheckout = getRogersCheckoutPage().getRpotgLabelPurchaseIncludes();
		reporter.softAssert(purchaseIncludes.contains(labelRpotgPurchaseIncludesCheckout),
				"RPOTG label verified in Purchase Includes section",
				"RPOTG label not availble in Purchase Includes section");
		reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present",
				"Create profile Title not present");
		String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
        String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
//		String firstName = getRogersCheckoutPage().setFirstNameCreateProfilepage("smisamvulamani");
//		String lastName = getRogersCheckoutPage().setLastNameCreateProfilepage("marichale");
		String fullNameCreateProfile = firstName + " " + lastName;
		String contactNumberCreateProfile = TestDataHandler.tc02NACNoTermPotgSS.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		String billingAddressCreateProfile = TestDataHandler.tc02NACNoTermPotgSS.getBillingAddress();
		getRogersCheckoutPage().setBillingAddressCreateProfile(billingAddressCreateProfile);
		getRogersCheckoutPage().getRpotgSuccessMessage();
		reporter.reportLogPassWithScreenshot(
				"Billing Address entered is eligible for RPOTG - Success message validated");
		getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
		reporter.reportLogPassWithScreenshot(
				"Create Profile Page details provided for Address,Shipping Address & Language Selected");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();

		// ***************Credit Evaluation Stepper***********//
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(), "CreditEvaluation Title verified", "CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc02NACNoTermPotgSS.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc02NACNoTermPotgSS.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc02NACNoTermPotgSS.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc02NACNoTermPotgSS.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc02NACNoTermPotgSS.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc02NACNoTermPotgSS.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc02NACNoTermPotgSS.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		getRogersCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersCheckoutPage().clkCreditEvalContinue();
//		reporter.softAssert(getRogersCheckoutPage().isCreditEvalPopupPresent(), "Credit Evaluation Popup Displayed",
//				"Credit Evaluation popup not disaplayed");
//		reporter.softAssert(getRogersCheckoutPage().isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed",
//				"Credit Evaluation Text not disaplayed on Modal");
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");

		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc02NACNoTermPotgSS.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();

		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc02NACNoTermPotgSS.getPaymentMethod());
		getRogersCheckoutPage().clkBillingContinueButton();

		// ***************Shipping Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ", "Billing Address is not selected");
		String addressShippingStepper = getRogersCheckoutPage().getShippingAddress();
		System.out.println(billingAddressCreateProfile+"and"+addressShippingStepper);
		reporter.softAssert(billingAddressCreateProfile.equals(addressShippingStepper), "Address in Shipping Stepper matches as entered in Create Profile stepper", "Address in Shipping Stepper not matches as entered in Create Profile stepper");
		getRogersCheckoutPage().clkDeliveryMethodStandard();
		reporter.reportLogPass("Standard Delivery selected");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		// ***************Order Review Page****************************************************
		reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present", "Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String totalMonthlyFeesReviewPage = getRogersReviewOrderPage().getMonthlyFeeAfterTax();
		reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage), "Total Monthly Fee after tax matches with checkout page", "Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesReviewPage = getRogersReviewOrderPage().getOneTimeFeeAfterTax();
		reporter.hardAssert(oneTimeFee.equals(oneTimeFeesReviewPage), "Total One time fee after tax matches with checkout page", "Total One time fee after tax not matches with checkout page");
		String puchaseIncludeReviewPage = getRogersReviewOrderPage().getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Order Review Page" + "1.Monthly Fees" + totalMonthlyFeesReviewPage + "2. OnetimeFees:" + oneTimeFeesReviewPage + "3.Purchase Include :" + puchaseIncludeReviewPage);
		String contactNameReviewPage = getRogersReviewOrderPage().getContactName();
		reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage), "Contact Name in Order Review Page matches as entered in Create Profile stepper", "Contact Name in Order Review Page not matches as entered in Create Profile stepper");
		String contactNumberReviewPage = getRogersReviewOrderPage().getContactNumber();
		reporter.softAssert(contactNumberCreateProfile.equals(contactNumberReviewPage), "Contact Number Matched", "Contact Number not matching");
		String contactEmailReviewPage = getRogersReviewOrderPage().getContactEmail();
		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage), "Contact email in Order Review Page matches as entered in Create Profile stepper", "Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		getRogersReviewOrderPage().clkFinancingConsentCheckbox();
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkEmailConsentCheckbox();
		reporter.reportLogPass("Email Communication consent box checked");
		getRogersReviewOrderPage().clkSubmitOrderBtn();
		//***********Onetime payment page***************
		reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
				"Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
		getRogersOneTimePaymentPage().setNameonCard();
		getRogersOneTimePaymentPage().switchToCreditCardIFrame();
		getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc02NACNoTermPotgSS.getCreditCardDetailsOTP());
		getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
		getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc02NACNoTermPotgSS.getExpiryDateOTP());
		getRogersOneTimePaymentPage().setCVV();
		reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
		getRogersOneTimePaymentPage().clkSubmitOrderBtn();
		// ************Order Confirmation Page***************************************************

		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
				"Order Confrimation Page Title Present", "Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyRpotgTitle(), "RPOTG Title verified",
				"RPOTG Title Not Present");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentDetailsTitle(),
				"Appointment Details Title verified", "Your Appointment Details Title Not present");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentDateTitle(),
				"Appointment Date Title Verified", "Appointment Date Title not Present");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentAddressTitle(),
				"Appointment Address Title Verified", "Appointment Address Title not present");
		String appointmentAddress = getRogersNACOrderConfirmationPage().getAppointmentAddressText();
		reporter.reportLogWithScreenshot("Appointment Address Details" + "-->" + appointmentAddress);
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyDeviceImage(),
				"Device Image Present in Confirmation Page", "Device Image not present");
		String totalMonthlyFeesConfirmationPage = getRogersNACOrderConfirmationPage().getMonthlyFeeAfterTax();
		reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),
				"Total Monthly Fee after tax matches with checkout page",
				"Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesConfirmationPage = getRogersNACOrderConfirmationPage().getOneTimeFeeAfterTax();
		reporter.hardAssert(oneTimeFee.equals(oneTimeFeesConfirmationPage),
				"Total One time fee after tax matches with checkout page",
				"Total One time fee after tax not matches with checkout page");
		String purchaseIncludesConfrimation = getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
		reporter.hardAssert(purchaseIncludesConfrimation.equals(puchaseIncludeReviewPage),
				"Purchase includes Matches in ORder Confirmation page", "Purchase Includes Not Matching");
		reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" + purchaseIncludesConfrimation);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}