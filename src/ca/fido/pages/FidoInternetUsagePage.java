package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FidoInternetUsagePage extends BasePageClass {

	public FidoInternetUsagePage(WebDriver driver) {
		super(driver);}


		@FindBy(xpath = "//ins[@translate='global.label.dailyUsage']")
		WebElement txtDailyUsage;

	@FindBy(xpath="//div[@class='ct-chart ute-chart']")
	WebElement txtDailyUsageChart;

	@FindBy(xpath="//ins[@translate='global.label.dailyBreakdown']")
	WebElement txtDailyBreakdown;

	@FindBy(xpath="//table[@class='table ute-table table-centred ng-table']")
	WebElement tblDailyBreakdownChart;

	@FindBy(xpath="//ins[@translate='global.label.monthlyUsage']")
	WebElement txtMonthlyUsage;

	@FindBy(xpath="//div[@class='ct-chart ute-chart']")
	WebElement txtMonthlyUsageChart;

	@FindBy(xpath="//ins[@translate='global.label.monthlyBreakdown']")
	WebElement txtMonthlyBreakdown;

	@FindBy(xpath="//table[@class='table ute-table table-centred ng-table']")
	WebElement tblMonthlyBreakdownChart;

	@FindBy(xpath="//ins[@translate='global.label.internetUsageNotificationSubheading']")
	WebElement btnUsageHistory;

	@FindBy(xpath="//ins[@translate='global.label.internetUsageMonthlySubheading']")
	WebElement btnMonthlyUsage;

	@FindBy(xpath="//table[@class='table ute-table table-centred ng-table']")
	WebElement tblUsageHistory;


	/**
	 * Click on the Usage History button
	 * @author Chinnarao.Vattam
	 */
	public void clkUsageHistory() {
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenReady(btnUsageHistory,60);
		reusableActions.executeJavaScriptClick(btnUsageHistory);
	}

	/**
	 * Click on the Monthly Usage button
	 * @author Manpreet.kaur3
	 */
	public void clkMonthlyUsage() {
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenReady(btnMonthlyUsage,60);
		reusableActions.executeJavaScriptClick(btnMonthlyUsage);
	}

	/**
	 * Check if the text DAILY USAGE is displayed.
	 * @return true if text DAILY USAGE  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIntrnetDailyUsage() {
		return reusableActions.isElementVisible(txtDailyUsage,90);
	}

	/**
	 * Check if the Daily Usage Chart is displayed.
	 * @return true if Daily Usage Chart  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDailyInternetUsageChart() {
		reusableActions.waitForElementVisibility(txtDailyUsageChart,60);
		return reusableActions.isElementVisible(txtDailyUsageChart,30);
	}


	/**
	 * Check if the text Daily Breakdown is displayed.
	 * @return true if text Daily Breakdown  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDailyBreakdown() {
		return reusableActions.isElementVisible(txtDailyBreakdown,90);
	}

	/**
	 * Check if the Daily Breakdown Chart is displayed.
	 * @return true if Daily Breakdown Chart  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDailyBreakdownChart() {
		reusableActions.staticWait(2000);
		reusableActions.javascriptScrollToMiddleOfPage();
		return reusableActions.isElementVisible(tblDailyBreakdownChart,60);
	}

	/**
	 * Check if the text Monthly USAGE is displayed.
	 * @return true if text Monthly USAGE  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMonthlyInternetUsage() {
		return reusableActions.isElementVisible(txtMonthlyUsage,90);
	}

	/**
	 * Check if the Monthly Usage Chart is displayed.
	 * @return true if Monthly Usage Chart  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMonthlyUsageChart() {
		return reusableActions.isElementVisible(txtMonthlyUsageChart,30);
	}


	/**
	 * Check if the text Monthly Breakdown is displayed.
	 * @return true if text Monthly Breakdown  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMonthlyBreakdown() {
		reusableActions.waitForElementVisibility(txtMonthlyBreakdown,60);
		return reusableActions.isElementVisible(txtMonthlyBreakdown,30);
	}

	/**
	 * Check if the Monthly Breakdown Chart is displayed.
	 * @return true if Monthly Breakdown Chart  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMonthlyBreakdownChart() {
		reusableActions.staticWait(2000);
		reusableActions.javascriptScrollToMiddleOfPage();
		return reusableActions.isElementVisible(tblMonthlyBreakdownChart,90);
	}

	/**
	 * Check if the Usage History Chart is displayed.
	 * @return true if Usage History Chart  displayed, otherwise false
	 * @author chinnarao.vattam
	 */
	public boolean verifyUsageHistory() {
		reusableActions.javascriptScrollToMiddleOfPage();
		return reusableActions.isElementVisible(tblUsageHistory,30);
	}
}
