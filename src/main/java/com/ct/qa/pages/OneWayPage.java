package com.ct.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Vandana
 *
 */
public class OneWayPage extends HomePage{

	@FindBy(xpath="//*[@id='FromTag']")
	private WebElement fromTextBox;
	
	@FindBy(xpath="//*[@id='ToTag']")
	private WebElement toTextBox;
		
	@FindBy(xpath="//input[@id='DepartDate']")
	private WebElement calender;
	
	@FindBy(className = "ui-datepicker-year")
	private WebElement calYear;
	
	@FindBy(className = "ui-datepicker-month")
	private WebElement calMonth;
	
	@FindBy(className = "nextMonth")
	private WebElement nextButtonOnCal;
	
	@FindBy(className = "calendar")
	private WebElement calDateChart;
	
	@FindBy(xpath="//select[@id='Adults']")
	private WebElement adultSelect;
	
	@FindBy(xpath="//select[@id='Childrens']")
	private WebElement childrenSelect;
	
	@FindBy(xpath="//*[@id='Infants']")
	private WebElement infantSelect;
	
	@FindBy(xpath="//*[@id='SearchBtn']")
			private WebElement clickSearchFlight;
	
	private WebDriverWait wait=new WebDriverWait(driver, 30);
	
	public OneWayPage(WebDriver driver) {
		super(driver);
	}
	
	

	public void openCalender() {
		calender.click();
	}
	
	public void insertFromCity(String cityName) {
		wait.until(ExpectedConditions.visibilityOf(fromTextBox));
		fromTextBox.click();
		fromTextBox.sendKeys(cityName);
		String fromOptiosXapth = "//ul[@id='ui-id-1']/li";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fromOptiosXapth)));
        fromTextBox.sendKeys(Keys.ENTER);
	}
	
	public void insertToCity(String cityName) {
		wait.until(ExpectedConditions.visibilityOf(toTextBox));
		toTextBox.click();
		toTextBox.sendKeys(cityName);
		String toOptiosXapth = "//ul[@id='ui-id-2']/li";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toOptiosXapth)));
		toTextBox.sendKeys(Keys.ENTER);
	}
	
	public void selectAdults(String adult) {
		
		Select dropdown = new Select(adultSelect);
		dropdown.selectByVisibleText(adult);
		
	}
	
	public void selectChildren(String child) {
		Select dropdown1= new Select(childrenSelect);
		dropdown1.selectByVisibleText(child);
	}
	
	public void selectInfant(String infant) {
		Select infantdropdown=new Select(infantSelect);
		infantdropdown.selectByVisibleText(infant);
	}
	
	public void clickSearch() {
		clickSearchFlight.click();
	}
	
		

		

	public void selectDate(String date,String month, String year) {
		
		while (!calYear.getText().equals(year)) 
		{
			nextButtonOnCal.click();
		}
		
		while (!calMonth.getText().equalsIgnoreCase(month)) 
		{
			nextButtonOnCal.click();
		}

		List<WebElement> rows,cols;
		rows=calDateChart.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) 
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) 
			{
				String caldt=cols.get(j).getText();
				if (caldt.equals(date)) 
				{
					cols.get(j).click();
					break;
				}
			}
		}

	}
	
}
