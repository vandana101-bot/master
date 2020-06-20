package com.ct.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ct.qa.base.TestBase;
import com.ct.qa.constants.LoginConstant;
import com.ct.qa.pages.HomePage;
import com.ct.qa.pages.LoginPage;
import com.ct.qa.util.TestUtil;

/*
 * @author Vandana
 */

public class LoginPageTest extends TestBase{
	private LoginPage loginPage;
	private HomePage homePage;

		public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		homePage = new HomePage(driver);	
	}
	
	@Test(priority=1)
	public void openLoginPageTest(){
		homePage.openLoginPage();
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
		String userName=(String)testData[0][0];
		String password=(String)testData[0][1];
		homePage = loginPage.login(userName, password);
	}
	
	
	@AfterClass
	public void tearDown(){
    	driver.quit();
	}
	
	
	
	

}
