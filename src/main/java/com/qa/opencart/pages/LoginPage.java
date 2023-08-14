package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtilNew;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtilNew eleUtil;
	
	// 1 . private By locators/elemets
	// 2 . Page Constructors
	// 3 . Page actions/methods
	
	private By email_Id = By.id("input-email");
	private By password = By.id("input-password");
	private By login_Btn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtilNew(driver);
	}
	
	public String getLoginPageTitle() {
		
		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page title is:" + title);
		return title;
	}
	
	public String getLoginPageURL() {
		
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login Page title is:" + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("App creds are: " + username + ":" + pwd);
		eleUtil.waitForElementVisible(email_Id, AppConstants.SHORT_TIME_OUT).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(login_Btn);
		//return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		return new AccountsPage(driver);
		
	}
	
}
