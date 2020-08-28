package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * This page is for complete the report lost and stolen flow as well as reactivate the device.
 * @author Ning.Xue
 *
 */
public class FidoReportLostOrStolenPage  extends BasePageClass {

	
	public FidoReportLostOrStolenPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//button[@class='ute-btn-primary dashboard-continue-button']")
	WebElement btnReportLostContinue;
	
	@FindBy (xpath = "//div[@class='row hidden-xs']//button")
	WebElement btnSuspend;
	
	@FindBy (xpath = "//p[@translate='wireless.message.okayItsGood']")
	WebElement msgSuspendConfirm;
	
	@FindBy (xpath = "//p[@translate='wireless.message.deviceServicesReactivated']")
	WebElement msgReactivateConfirm;
	
	@FindBy (xpath = "//span[@class='hidden-xs']/button")
	WebElement btnReactivateDevice;
	
	/**
	 * Click on continue button in report lost or stolen flow.
	 * @author Ning.Xue
	 */
	public void clkBtnReportLostContinue() {
		reusableActions.waitForElementTobeClickable(btnReportLostContinue,60);
		reusableActions.executeJavaScriptClick(btnReportLostContinue);
	}
	
	/**
	 * Click on Suspend button in report lost or stolen flow.
	 * @author Ning.Xue
	 */
	public void clkBtnSuspend() {

		reusableActions.getWhenVisible(btnSuspend, 30).click();
	}
	
	/**
	 * Verify suspend confirm message for report lost or stolen flow.
	 * @return true if the confirm message is visible, other wise false.
	 * @author Ning.Xue
	 */
	public Boolean verifySuspendConfirmMessage() {
		reusableActions.staticWait(8000);
		return reusableActions.isElementVisible(msgSuspendConfirm, 30);
	}
	
	/**
	 * Verify reactivation confirm message for reactivate my device flow.
	 * @return true if the confirm message is visible, other wise false.
	 * @author Ning.Xue
	 */
	public Boolean verifyReactivateConfirmMessage() {
		reusableActions.waitForElementVisibility(msgReactivateConfirm, 80);
		return reusableActions.isElementVisible(msgReactivateConfirm, 30);
	}
	
	
	/**
	 * Click on ReactivateMyDevice button in reactivate my device flow page.
	 * @author Ning.Xue
	 */
	public void clkBtnReactivateDevice() {

		reusableActions.getWhenVisible(btnReactivateDevice, 30).click();
	}
}
