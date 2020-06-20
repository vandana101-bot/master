package com.ct.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Vandana
 *
 */
public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	protected void waitForVisibility(WebElement element) throws Error{
	       new WebDriverWait(driver, 30)
	            .until(ExpectedConditions.visibilityOf(element));
	}
}
