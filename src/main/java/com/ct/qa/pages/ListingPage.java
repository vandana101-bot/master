package com.ct.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Vandana
 *
 */
public class ListingPage {

	@FindBy(xpath = "//div[@class='col flex flex-middle']")
	WebElement listingSearchHeadeForNewApp;

	@FindBy(xpath = "//div[@id='ResultContainer_1_1']/section[@class='primaryBar container sticky']")
	WebElement listingSearchHeadeForoldApp;

	public ListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean isListingPageOpen() {
		
	  boolean result=false;
		try {
			result=listingSearchHeadeForNewApp.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.print("New Page NOt Found");
		}

		try {
			result=listingSearchHeadeForoldApp.isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.print("Old Page NOt Found");
		}

		return result;
	}

}
