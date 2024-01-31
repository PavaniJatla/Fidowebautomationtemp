package ca.fido.test.commonbusiness;

import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import java.io.IOException;

public class VerifyInEns{
	BaseTestClass baseTestClass;

	public VerifyInEns(BaseTestClass baseTestClass) {
		this.baseTestClass = baseTestClass;
	}

	/**
	 * To launch the ENS URL, it will be different for different QA environment.
	 * @author ning.xue
	 */
	private void startVerify() {
		//baseTestClass.getEnshomepage().openNewTabForEns(TestDataHandler.config.getEnsURL());
		BaseTestClass.getEnshomepage().openNewTabForEns(System.getProperty("EnsUrl"));
		baseTestClass.getReporter().reportLogWithScreenshot("Ens Window");
	}

	private void startVerifyCH() {
		String strEnsStsUrl = "https://"+System.getenv("ENS_USERNAME")+":"+System.getenv("ENS_PASSWORD")+"@sts.rci.rogers.ca/adfs/ls/wia?client-request-id=5be570eb-c7e2-49f8-b3f5-57b29e72515f&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=LoginOptions%3D3%26estsredirect%3d2%26estsrequest%3drQQIARAA42KwEkzNKy5MNNEryk9PLSrWS87PLRLiEnhd8DT60fEfnpu_hm-aVxQYv4rRMKOkpKDYSl8fQ72-q1-wfnFGfrlvYmZeQGJ6ql5icklmft4hRtVQS6NUC4NE8yTdJEOjNF2TFDNLXctUE0tdI1NTizQzC9PkFBODC4yMLxgZbzGxBifm5hj9YjIpLcqzyk8sziy2ykvMTS22Kkm2Cnb09bEy0jMAi2Sm6KblF-UmllgVAJ2QWVySmlcyi1laPy-_JDMtMzkRZHlxWGZqeWoR1CmbmFUMEpNMkpOSgI5ISjbXNbEwMtNNMjVK1k00NElLTTE1sjBLsnzELJObmFdQlJpaopedWFpk7FCUnAn3aeIFFp5XLDwGzFYcHFwCDBIMCgw_WBgXsQKDqyCs5RBX_CXffuNzzyVWTGM4xarv6B7pFxrkFVTuEZhhXBWaUpGaGWCRZpSl7-0UkhSZWWFq6JruG-lraZlkYWtmZTiBjfcUG8MHNsYOdoZZ7Ay7OEkP7wO8DD_4pr08c3zLthNvPQA1&cbcxt=&username=&mkt=&lc=";
		BaseTestClass.getEnshomepage().openNewTabForEns(strEnsStsUrl);
		BaseTestClass.getFidologinpage().loadEnsUrl();
		baseTestClass.getReporter().reportLogWithScreenshot("Ens Window");
	}


	/**
	 * To login to ENS using operator name and password.
	 * @author ning.xue
	 */
	private void loginToEns() {

		BaseTestClass.getEnshomepage().setEmail(System.getenv("ENS_USERNAME"));
		BaseTestClass.getEnshomepage().clkBtnNext();
		BaseTestClass.getEnshomepage().setPassword(System.getenv("ENS_PASSWORD"));
		BaseTestClass.getEnshomepage().clkBtnSignIn();
	}

	/**
	 * To get the verify code in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, the recovery phone number
	 * @return String, the verification code.
	 * @throws ClientProtocolException     throws ClientProtocolException
	 * @throws IOException throws IOException
	 * @author ning.xue
	 */
	public String getVerifyCode(String strPhoneNum) throws ClientProtocolException, IOException {

		this.startVerify();
		this.loginToEns();

		BaseTestClass.getEnsnoteviewpage().clkMenuNotifViewer();
		BaseTestClass.getEnsnoteviewpage().clkBtnSearchNotification();
		BaseTestClass.getEnsnoteviewpage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsnoteviewpage().getNotificationCode();
		baseTestClass.getReporter().reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsnoteviewpage().clkBtnOk();
		BaseTestClass.getEnsnoteviewpage().closeEnsWindow();
		return strVerifyCode;
	}

	public void setVerificationCodeCH(String strAccountId, String verificationMethod) {
		if (BaseTestClass.getFidologinpage().verifyMFAScreenIsVisible()) {
			switch (verificationMethod) {
				case "email":
					setVerificationCodeEmail(strAccountId);
					break;
				case "sms":
					setVerificationCodeText();
					break;
			}
		}
	}

	public void setVerificationCodeText(){
		String browser = System.getProperty("Browser");
		String strPhoneNum = TestDataHandler.fidoHSIAccount.getaccountDetails().getPhoneNumber();
		baseTestClass.getReporter().reportLogWithScreenshot(browser);
		baseTestClass.getReporter().reportLogWithScreenshot("Click on SMS as recovery option");
		baseTestClass.getFidologinpage().clkTextOptionMFA();
		String strTestingTab = baseTestClass.getDriver().getWindowHandle();
		baseTestClass.getReporter().reportLogWithScreenshot("Launching ENS Portal");
		if(browser.contains("sauce")){
			this.startVerify();
			this.loginToEns();
		} else {
			this.startVerifyCH();
		}
		BaseTestClass.getEnsnoteviewpage().clkMenuNotifViewer();
		BaseTestClass.getEnsnoteviewpage().clkBtnSearchNotification();
		BaseTestClass.getEnsnoteviewpage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsnoteviewpage().getNotificationCode();
		baseTestClass.getReporter().reportLogWithScreenshot("Retrieved SMS verification code");
		BaseTestClass.getEnsnoteviewpage().clkBtnOk();
		BaseTestClass.getEnsnoteviewpage().closeEnsWindow();
		switchToMainWindowAndSetVerificationCode(strTestingTab,strVerifyCode);
	}

	public void setVerificationCodeEmail(String strAccountId) {
		String browser = System.getProperty("Browser");
		baseTestClass.getReporter().reportLogWithScreenshot(browser);
		baseTestClass.getReporter().reportLogWithScreenshot("Click on EMAIL as verification option");
		baseTestClass.getFidologinpage().clkEmailOptionMFA();
		String strTestingTab = baseTestClass.getDriver().getWindowHandle();
		baseTestClass.getReporter().reportLogWithScreenshot("Launching ENS Portal");
		if (browser.contains("sauce")) {
			this.startVerify();
			this.loginToEns();
		} else {
			this.startVerifyCH();
		}
		BaseTestClass.getEnsnoteviewpage().clkMenuNotifViewer();
		BaseTestClass.getEnsnoteviewpage().clkBtnSearchNotification();
		BaseTestClass.getEnsnoteviewpage().clkLnkHtmlForEmailVerify(strAccountId);
		BaseTestClass.getEnsnoteviewpage().switchToNewTab(2);
		String strVerificationCode = BaseTestClass.getEnsnoteviewpage().getVerificationCode();
		baseTestClass.getReporter().reportLogWithScreenshot("Email OTP successfully copied from MFA Window - ENS Portal");
		switchToMainWindowAndSetVerificationCode(strTestingTab, strVerificationCode);
	}

	private void switchToMainWindowAndSetVerificationCode(String strTestingTab, String strVerifyCode) {
		baseTestClass.getDriver().switchTo().window(strTestingTab);
		baseTestClass.getReporter().reportLogWithScreenshot("Close the Overlay");
		baseTestClass.getFidoprofileandsettingpage().setRecoveryCode(strVerifyCode);
		baseTestClass.getFidoprofileandsettingpage().clkBtnContinue();
		baseTestClass.getReporter().reportLogWithScreenshot("Continue to Account Overview");

	}

	/**
	 * To get the verify code in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, the recovery phone number
	 * @return String, the verification code.
	 * @throws ClientProtocolException     throws ClientProtocolException
	 * @throws IOException throws IOException
	 * @author sidhartha.vadrevu
	 */
	public String getSMSVerifyCode(String strPhoneNum) throws ClientProtocolException, IOException {

		this.startVerify();
		this.loginToEns();

		BaseTestClass.getEnsnoteviewpage().clkMenuNotifViewer();
		BaseTestClass.getEnsnoteviewpage().setEmailId(TestDataHandler.tc04To09.getaccountDetails().getEmail());
		BaseTestClass.getEnsnoteviewpage().clkBtnSearchNotification();
		BaseTestClass.getEnsnoteviewpage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strMainWindow = baseTestClass.getDriver().getWindowHandle();
		String strVerifyCode = BaseTestClass.getEnsnoteviewpage().getSMSNotificationCode(strMainWindow);
		baseTestClass.getReporter().reportLogWithScreenshot("Got message notification code.");
		//BaseTestClass.getEnsnoteviewpage().clkBtnOk();
		//BaseTestClass.getEnsnoteviewpage().closeEnsWindow();
		return strVerifyCode;
/*		String strVerifyCode = BaseTestClass.getEnsnoteviewpage().getNotificationCode();
		baseTestClass.getReporter().reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsnoteviewpage().clkBtnOk();
		BaseTestClass.getEnsnoteviewpage().closeEnsWindow();
		return strVerifyCode;*/
	}

	/**
	 * To get the email notification by clicking the html link in ENS, and switch to the new openned tab.
	 * @param strAccountId is string Account Id
	 * @throws ClientProtocolException throws ClientProtocolException
	 * @throws IOException throws IOException
	 * @author ning.xue
	 */
	public void getEmailVerifyPage(String strAccountId) throws ClientProtocolException, IOException {
		this.startVerify();
		this.loginToEns();

		BaseTestClass.getEnsnoteviewpage().clkMenuNotifViewer();
		BaseTestClass.getEnsnoteviewpage().clkBtnSearchNotification();
		baseTestClass.setImplicitWait(baseTestClass.getDriver(),2);
		BaseTestClass.getEnsnoteviewpage().clkLnkHtmlForEmailVerify(strAccountId);
		baseTestClass.setImplicitWait(baseTestClass.getDriver(),2);
		BaseTestClass.getEnsnoteviewpage().switchToNewTab(2);
	}


	/**
	 * To get the user name sent to the recovery number in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, String, recovery number.
	 * @return String, the verification code
	 */
	public String getAccountUserName(String strPhoneNum) {
		this.startVerify();
		this.loginToEns();

		BaseTestClass.getEnsnoteviewpage().clkMenuNotifViewer();
		BaseTestClass.getEnsnoteviewpage().clkBtnSearchNotification();
		BaseTestClass.getEnsnoteviewpage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsnoteviewpage().getUserName();
		baseTestClass.getReporter().reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsnoteviewpage().clkBtnOk();
		BaseTestClass.getEnsnoteviewpage().closeEnsWindow();
		return strVerifyCode;
	}

}
