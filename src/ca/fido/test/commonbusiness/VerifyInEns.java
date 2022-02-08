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
	 * @throws ClientProtocolException 	throws ClientProtocolException
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

	/**
	 * To get the verify code in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, the recovery phone number
	 * @return String, the verification code.
	 * @throws ClientProtocolException 	throws ClientProtocolException
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
		BaseTestClass.getEnsnoteviewpage().clkLnkHtmlForEmailVerify(strAccountId);		
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
