package ca.fido.pages;

import ca.fido.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
/**
 * This page is created for Fido community forum, it support English only for now. 
 * Update should be done later to support French.
 * @author ning.xue
 *
 */
public class FidoCommunityPage extends BasePageClass {

	public FidoCommunityPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//a[@title='Community Forums']")
	WebElement lnkFidoCommunity;

	@FindBy (xpath = "//li[contains(text(),'forums')]")
	WebElement menuForums;
	
	@FindBy (css = "a[href*='Get-Started']")
	WebElement forumsGetStarted;
	
	@FindBy (xpath = "//li[contains(text(),'forums')]//a[contains(text(),'Phones and Devices')]")
	WebElement forumsPhoneNDevices;
	
	@FindBy (xpath = "//li[contains(text(),'forums')]//a[contains(text(),'General Support')]")
	WebElement forumsGeneralSupport;
	
	@FindBy (xpath = "//li[contains(text(),'forums')]//a[contains(text(),'Fido Home Internet')]")
	WebElement forumsFidoHomeInternet;
	
	@FindBy (xpath = "//li[contains(text(),'forums')]//a[contains(text(),'Apps')]")
	WebElement forumsApps;
	
	@FindBy (xpath = "//a[contains(text(),'Tips and Tricks')]")
	WebElement forumsTipsNTricks;
	
	@FindBy (xpath = "//a[contains(text(),'Community Feedback Zone')]")
	WebElement forumsCommunityFdbkZone;
	
	@FindBy (xpath = "//a[contains(text(),'Community Archives')]")
	WebElement forumsCommunityArchives;
	
	@FindBy (xpath = "//a[contains(text(),'Library')]//parent::li")
	WebElement menuLibrary;
	
	@FindBy (xpath = "//a[contains(text(),'Getting Started')]")
	WebElement libraryGetStarted;
	
	@FindBy (xpath = "//a[contains(text(),'Library')]//parent::li//a[contains(text(),'General Support')]")
	WebElement libraryGeneralSupport;
	
	@FindBy (xpath = "//a[contains(text(),'Library')]//parent::li//a[contains(text(),'Phones and Devices')]")
	WebElement libraryPhoneNDevices;
	
	@FindBy (xpath = "//li[contains(text(),'Library')]//a[contains(text(),'Apps')]")
	WebElement libraryApps;
	
	@FindBy (xpath = "//li[contains(text(),'Library')]//a[contains(text(),'Fido Home Internet')]")
	WebElement libraryFidoHomeInternet;
	
	@FindBy (xpath = "//a[contains(text(),'blog')]//parent::li")
	WebElement menuBlog;
	
	@FindBy (xpath = "//a[contains(text(),'Fido News')]")
	WebElement blogFidoNews;
	
	@FindBy (xpath = "//a[contains(text(),'Community Spotlight')]")
	WebElement blogCommunitySpotight;
	
	@FindBy (xpath = "//a[contains(text(),'Community News')]")
	WebElement blogCommunityNews;
	
	@FindBy (xpath = "//a[contains(text(),'Events')]")
	WebElement blogEvents;
	
	@FindBy (xpath = "//a[contains(text(),'Tips & Tricks')]")
	WebElement blogTipsNTricks;
	
	@FindBy (xpath = "//a[contains(text(),'Fido XTRA')]//parent::li")
	WebElement blogFidoXtra;
	
	@FindBy (xpath = "//li[@class='nav-item quick-links']")
	WebElement menuQuickLinks;
	
	@FindBy (xpath = "//li[@class='nav-item quick-links']//a[contains(text(),'Get Started')]")
	WebElement quickLinksGetStart;
	
	@FindBy (xpath = "//a[contains(text(),'OS Upgrade Schedule')]")
	WebElement quickLinksOSUpgdSchdl;
	
	@FindBy (xpath = "//a[contains(text(),'OS Upgrade Process')]")
	WebElement quickLinksOSUpgdProcess;
	
	@FindBy (xpath = "//a[contains(text(),'MVP program')]")
	WebElement quickLinksMvpProgram;
	
	@FindBy (xpath = "//a[contains(text(),'Meet the Crew')]")
	WebElement quickLinksMeetCrew;
	
	@FindBy (xpath = "//a[contains(text(),'Introduce Yourself')]")
	WebElement quickLinksIntroduceYslf;
	
	@FindBy (xpath = "//a[contains(text(),'Community Guidelines')]")
	WebElement quickLinksCommunityGuideline;
	
	@FindBy (xpath = "//a[contains(text(),'Community Terms of Use')]")
	WebElement quickLinksComTermsOfUse;
	
	@FindBy (xpath = "//a[contains(text(),'Sign In')]")
	WebElement lnkSignIn;
	
	public void clkFidoCommunity() {
		reusableActions.scrollToElementAndClick(lnkFidoCommunity);
	}
	
	public Boolean verifyMenuForums() {
		Actions action = new Actions(getDriver());
		action.moveToElement(menuForums).build().perform();
		Boolean visable = reusableActions.isElementVisible(forumsGetStarted)
						&& reusableActions.isElementVisible(forumsPhoneNDevices)
						&& reusableActions.isElementVisible(forumsGeneralSupport)
						&& reusableActions.isElementVisible(forumsFidoHomeInternet)
						&& reusableActions.isElementVisible(forumsApps)
						&& reusableActions.isElementVisible(forumsTipsNTricks)
						&& reusableActions.isElementVisible(forumsCommunityFdbkZone)
						&& reusableActions.isElementVisible(forumsCommunityArchives);
						
		return visable;
	}
	
	public Boolean verifyMenuLibrary() {
		Actions action = new Actions(getDriver());
		action.moveToElement(menuLibrary).build().perform();
		Boolean visable = reusableActions.isElementVisible(libraryGetStarted)
						&& reusableActions.isElementVisible(libraryGeneralSupport)
						&& reusableActions.isElementVisible(libraryPhoneNDevices)
						&& reusableActions.isElementVisible(libraryApps)
						&& reusableActions.isElementVisible(libraryFidoHomeInternet);
						
		return visable;
	}
	
	public Boolean verifyMenuBlog() {
		Actions action = new Actions(getDriver());
		action.moveToElement(menuBlog).build().perform();
		Boolean visable = reusableActions.isElementVisible(blogFidoNews)
						&& reusableActions.isElementVisible(blogCommunitySpotight)
						&& reusableActions.isElementVisible(blogCommunityNews)
						&& reusableActions.isElementVisible(blogEvents)
						&& reusableActions.isElementVisible(blogTipsNTricks)
						&& reusableActions.isElementVisible(blogFidoXtra);
						
		return visable;
	}
	
	public Boolean verifyMenuQuickLinks() {
		Actions action = new Actions(getDriver());
		action.moveToElement(menuQuickLinks).build().perform();
		Boolean visable = reusableActions.isElementVisible(quickLinksGetStart)
						&& reusableActions.isElementVisible(quickLinksOSUpgdSchdl)
						&& reusableActions.isElementVisible(quickLinksOSUpgdProcess)
						&& reusableActions.isElementVisible(quickLinksMvpProgram)
						&& reusableActions.isElementVisible(quickLinksMeetCrew)
						&& reusableActions.isElementVisible(quickLinksIntroduceYslf)
						&& reusableActions.isElementVisible(quickLinksCommunityGuideline)
						&& reusableActions.isElementVisible(quickLinksComTermsOfUse);
						
		return visable;
	}
	
	public void clkSignIn() {
		reusableActions.getWhenVisible(lnkSignIn).click();
	}
	
}
