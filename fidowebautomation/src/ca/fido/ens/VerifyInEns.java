package ca.fido.ens;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;

import ca.fido.pages.ens.EnsHomePage;
import ca.fido.pages.ens.EnsNotificationViewPage;
import ca.fido.test.base.BaseTestClass;
import ca.fido.testdatamanagement.TestDataHandler;
import utils.Reporter;

public class VerifyInEns extends BaseTestClass{

	protected EnsHomePage ensHomePage;
	protected EnsNotificationViewPage ensNoteViewPage;
	protected Reporter reporter;
	
	public VerifyInEns(WebDriver driver, EnsHomePage ensHomePage,EnsNotificationViewPage ensNoteViewPage,Reporter reporter) {

		this.ensHomePage = ensHomePage;
		this.ensNoteViewPage = ensNoteViewPage;
		this.reporter = reporter;
	}

	private void startVerify() {

		String strEnsUrl = "";
		if (TestDataHandler.config.getFidoURL().contains("qa06"))
		{
			strEnsUrl = TestDataHandler.config.getEnsURL06();
		}else if (TestDataHandler.config.getFidoURL().contains("qa01")) {
			strEnsUrl = TestDataHandler.config.getEnsURL01();
		}else if(TestDataHandler.config.getFidoURL().contains("qa05")
				|| TestDataHandler.config.getFidoURL().contains("qa02"))
		{
			strEnsUrl = TestDataHandler.config.getEnsURL02();
		}else if(TestDataHandler.config.getFidoURL().contains("qa07"))
		{
			strEnsUrl = TestDataHandler.config.getEnsURL01();
		}

		ensHomePage.openNewTabForEns(strEnsUrl);
		reporter.reportLogWithScreenshot("Ens Window");
	}
	
	private void loginToEns() {
		
		this.ensHomePage.setEmail(TestDataHandler.config.getEnsLoginEmail());
		this.ensHomePage.clkBtnNext();
		this.ensHomePage.setPassword(TestDataHandler.config.getEnsPassword());
		this.ensHomePage.clkBtnSignIn();
	}

	public String getVerifyCode(String strPhoneNum) throws ClientProtocolException, IOException {

		this.startVerify();
		this.loginToEns();
		
		this.ensNoteViewPage.clkMenuNotifViewer();
		this.ensNoteViewPage.clkBtnSearchNotification();
		this.ensNoteViewPage.clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = ensNoteViewPage.getNotificationCode();
		this.reporter.reportLogWithScreenshot("Got message notification code.");
		this.ensNoteViewPage.clkBtnOk();
		this.ensNoteViewPage.closeEnsWindow();
		return strVerifyCode;
	}
	
	
	public String getAccountUserName(String strPhoneNum) throws ClientProtocolException, IOException {

		this.startVerify();
		this.loginToEns();
		
		this.ensNoteViewPage.clkMenuNotifViewer();
		this.ensNoteViewPage.clkBtnSearchNotification();
		this.ensNoteViewPage.clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = ensNoteViewPage.getNotificationCode();
		this.reporter.reportLogWithScreenshot("Got message notification code.");
		this.ensNoteViewPage.clkBtnOk();
		this.ensNoteViewPage.closeEnsWindow();
		return strVerifyCode;
	}
	
	public void getEmailVerifyPage(String strAccountId) throws ClientProtocolException, IOException {
		this.startVerify();
		this.loginToEns();
		
		this.ensNoteViewPage.clkMenuNotifViewer();
		this.ensNoteViewPage.clkBtnSearchNotification();
		this.ensNoteViewPage.clkLnkHtmlForEmailVerify(strAccountId);		
		this.ensNoteViewPage.switchToNewTab(2);		
	}
	
}
