package ca.fido.pages.ens;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class EnsNotificationViewPage extends BasePageClass {

	public EnsNotificationViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//a[contains(text(),'Notification Viewer')]")
	WebElement menuNotificationViewer;
	
	@FindBy (xpath = "//input[@id='accountID']")
	WebElement txtAccountId;
	
	@FindBy (xpath = "//input[@value='Search Notificatons']")
	WebElement btnSearchNotification;

	@FindBy(xpath = "//div[@class='bd']/table/tbody/tr/td")
	WebElement notificationText;

	@FindBy(xpath = "//td[contains(text(),'Verification code')]//parent::tr//following-sibling::tr//td")
	WebElement notificationSMSText;

	@FindBy (xpath = "//button[contains(text(),'OK')]")
	WebElement btnOk;

	@FindBy(id="contactEmail")
	WebElement txtContactEmail;

	@FindBy (xpath = "//img[@alt='Set password']")
	WebElement btnSetPasswordInEmail;

	/**
	 * Click on menu Notification Viewer
	 * @author ning.xue 
	 */
	public void clkMenuNotifViewer() {
		reusableActions.getWhenVisible(menuNotificationViewer).click();
	}
	
	/**
	 * Set account ID for notification
	 * @param strAccountId, string of account ID
	 * @author ning.xue
	 */
	public void setAccountId(String strAccountId) {
		reusableActions.getWhenReady(txtAccountId).clear();
		reusableActions.getWhenReady(txtAccountId).sendKeys(strAccountId);
	}
	
	/**
	 * Click the button "Search Notification" in ENS page
	 * @author ning.xue
	 */
	public void clkBtnSearchNotification() {
		reusableActions.staticWait(3000);
		reusableActions.clickWhenVisible(btnSearchNotification);
	}
	/**
	 * To verify in email by clicking the html file image by locating the first(latest) record by account ID.
	 * @param strAccountId, string of account email
	 * @author ning.xue
	 */
	public void clkLnkHtmlForEmailVerify(String strAccountId) {
		reusableActions.waitForAllElementsVisible(driver.findElements(By.xpath("//td[contains(text(),'" + strAccountId + "')]")), 30);
		List<WebElement> lnkHtml = driver.findElements(By.xpath("//td[contains(text(),'" + strAccountId + "')]//following-sibling::td/a[@class='img_html_png']"));
		reusableActions.getWhenVisible(lnkHtml.get(0), 20).click();
		reusableActions.waitForNumberOfWindowsToBe(3, 20);
	}
	
	/**
	 * To get verify code in SMS by clicking the pdf file image by locating the first(latest) record by phone number.
	 * @param strPhoneNum, string of phone number
	 * @author ning.xue
	 */
	public void clkLnkPdfForSmsVerify(String strPhoneNum) {
		reusableActions.waitForAllElementsVisible(driver.findElements(By.xpath("//td[contains(text(),'" + strPhoneNum + "')]//following-sibling::td/a[@class='img_html_png']")), 30);
		List<WebElement> lnkHtml = driver.findElements(By.xpath("//td[contains(text(),'" + strPhoneNum + "')]//following-sibling::td/a[@class='img_html_png']"));
		reusableActions.getWhenVisible(lnkHtml.get(0)).click();
	}
	
	/**
	 * To get the notification code from the last 7 digital string.
	 * @return string, verification code, 
	 * @author ning.xue
	 */
	public String getNotificationCode() {
		reusableActions.staticWait(5000); 
		String strNotification = notificationText.getText();
		System.out.println("++++++++++++" + strNotification + "******************");
		String strCode = strNotification.substring(strNotification.length()-8);
		return strCode;
	}

	/**
	 * To get the notification code from the last 7 digital string.
	 * @return string, verification code,
	 * @author sidhartha.vadrevu
	 */
	public String getSMSNotificationCode(String mainWindow) {
		reusableActions.staticWait(5000);
		reusableActions.switchToNewWindow(mainWindow);
/*		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(2));*/
/*		List<WebElement> contents = getDriver().findElements(By.xpath("//td[@style='vertical-align: top;']//tbody//tr//td"));
		for (WebElement text : contents) {
			System.out.println(text.getText());
		}*/
		String strNotification = notificationSMSText.getText();
		System.out.println("++++++++++++" + strNotification + "******************");
		String strCode = strNotification.substring(strNotification.length()-8);
		closeCurrentWindow();
		closeEnsWindow();
		return strCode;
	}
	
	/**
	 * To get the notification email from t
	 * @return string, login username, 
	 * @author Mirza.Kamran
	 */
	public String getUserName() {
		reusableActions.staticWait(5000); 
		String strNotification = notificationText.getText();
		System.out.println("++++++++++++" + strNotification + "******************");
		String struserName = strNotification.split(": ")[1].trim();
		return struserName;
	}
	
	/**
	 * To click the OK button in the pdf pop up.
	 * @author ning.xue
	 */
	public void clkBtnOk() {
		reusableActions.clickWhenVisible(btnOk, 10);
	}
	
	/**
     * Sets the email id
     * @param strEmail, string, email to set.
     */
    public void setEmailId(String strEmail) {
    	reusableActions.getWhenReady(txtContactEmail).sendKeys(strEmail);
    }
    
    /**
	 * Switch to specific tab
	 * @param intTabIndex the index of the tab
	 */
	public void switchToNewTab(int intTabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(intTabIndex));
	}
	
	/**
	 * To click set password button in email details page
	 * @author ning.xue
	 */
	public void clkBtnSetPasswordInEmail() {
		reusableActions.clickWhenReady(btnSetPasswordInEmail, 30);
	}
	
	/**
	 * Close the ENS Window
	 * @author ning.xue
	 */
	public void closeEnsWindow() {
		reusableActions.closeCurrentWindow();
	}

	/**
	 * Close the ENS Window
	 * @author sidhartha.vadrevu
	 */
	public void closeCurrentWindow() {
		reusableActions.closeCurrentWindow();
	}

}
