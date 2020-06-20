package com.ct.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ct.qa.base.TestBase;

/**
 * 
 * @author Vandana
 *
 */
public class HomePage extends BasePage{

	@FindBy(xpath="//a[@id='userAccountLink']")
	WebElement userAccountLink;
	
	@FindBy(xpath="//li[@class='signInBlock']")
	WebElement SignInBtn;


	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void openLoginPage(){
		waitForVisibility(userAccountLink);
		userAccountLink.click();
		waitForVisibility(SignInBtn);
		SignInBtn.click();
	}
	
	
	
	
	
	

}
