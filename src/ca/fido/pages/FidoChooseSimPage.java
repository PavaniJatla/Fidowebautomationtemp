package ca.fido.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ca.fido.pages.base.BasePageClass;


public class FidoChooseSimPage extends BasePageClass {

	public FidoChooseSimPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath="//ins[@res='buy_a_sim_card']/parent::label")
	WebElement lblGetFreeSimCard;
	
	@FindBy(xpath="//button[@translate='_continue']")
	WebElement btnContinue;
	
	/**
	 * Clicks on the 'Get a free SIM card' option
	 * @author rajesh.varalli1
	 */
	public void clkGetFreeSimCard() {
		reusableActions.clickWhenVisible(lblGetFreeSimCard);
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue);
	}
}
