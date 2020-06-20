package com.ct.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Vandana
 *
 */

public class LoginPage extends BasePage{
	
	
	private final String frameName="modal_window";
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement loginBtn;
	

	@FindBy(xpath="/html/body/div[1]/div/div/div/div/h1")
	WebElement loginPageTitle;
	
	@FindBy(xpath="//li[@class='menuItem listMenuContainer userAccountMenuContainer']/a/span[2]")
	WebElement userNameTextAfterLogin;

		
	public LoginPage(WebDriver driver){
		 super(driver);
		driver.switchTo().frame(frameName);
		PageFactory.initElements(driver, this);
	}
	

	public String getLoginPageTitle(){
	 waitForVisibility(loginPageTitle);
	  return loginPageTitle.getText();
	}
	
		
	public HomePage login(String un, String pwd){
		waitForVisibility(username);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(driver);
	}
	
	
	
	public String getUserNameTextAfterLogin() {
		waitForVisibility(userNameTextAfterLogin);
		return userNameTextAfterLogin.getText();
	}
	
	
}
