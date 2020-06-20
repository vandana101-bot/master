package com.ct.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ct.qa.base.TestBase;
import com.ct.qa.constants.HomePageConstant;
import com.ct.qa.constants.LoginConstant;
import com.ct.qa.pages.ListingPage;
import com.ct.qa.pages.LoginPage;
import com.ct.qa.pages.OneWayPage;
import com.ct.qa.util.TestUtil;

/*
 * @author Vandana
 */

public class OneWaySearchTestForLoginUser extends TestBase{
	
	private OneWayPage oneWayPage;
	private LoginPage loginPage;
	private ListingPage listingPage;
    private Object[][] testData;
    private String userName;

	public OneWaySearchTestForLoginUser(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		testData=TestUtil.getTestData(HomePageConstant.ONEWAY_SHEET_NAME.getMessage());
		oneWayPage = new OneWayPage(driver);	
	}
	
	@Test(priority=1)
	public void openLoginPageTest(){
		oneWayPage.openLoginPage();
	    loginPage=new LoginPage(driver);
	}
	
	
	@Test(priority=2)
	public void loginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, LoginConstant.LOGIN_TITLE.getMessage());
	}

	
	@Test(priority=3)
	public void loginTest(){
		Object[][] testData=TestUtil.getTestData(LoginConstant.LOGIN_SHEET_NAME.getMessage());
		userName=(String)testData[0][0];
		String password=(String)testData[0][1];
		loginPage.login(userName, password);
	}
	
	
	@Test(priority=4)
	public void isUserLogin(){
	 Assert.assertEquals(userName, loginPage.getUserNameTextAfterLogin());	
	}
	
	@Test(priority=5)
	public void doFromAndToInputTest(){
		String source=(String)testData[0][0];
		String destination=(String)testData[0][1];
		oneWayPage.insertFromCity(source);
		oneWayPage.insertToCity(destination);	
	}
	
	@Test(priority=6)
	public void doDateSelectionTest(){
		String departDate=(String)testData[0][2];
		String departMonth=(String)testData[0][3];
		String departYear=(String)testData[0][4];
		System.out.println("departDate " +departDate);
		System.out.println("departMonth "+departMonth);
		System.out.println(departYear);
		
		oneWayPage.openCalender();
		oneWayPage.selectDate(departDate,departMonth,departYear);
	}
	
	@Test(priority=7)
	public void doPassangerInputTest(){
		String adult=(String)testData[0][5];
		String children=(String)testData[0][6];
		String infant=(String)testData[0][7];
	
		
		oneWayPage.selectAdults(adult);
		oneWayPage.selectChildren(children);
		oneWayPage.selectInfant(infant);
	}
	
	
	@Test(priority=8)
	public void searchFlightTest(){
		oneWayPage.clickSearch();
		listingPage=new ListingPage(driver);
	}
	
	
	@Test(priority=9)
	public void isListingPageLoaded(){
		Assert.assertEquals(true, listingPage.isListingPageOpen());
	}
	
	@AfterClass
	public void tearDown(){
    	driver.quit();
	}
	
	

}
