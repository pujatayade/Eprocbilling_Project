package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.Test_Base;
import com.qa.pages.Home_Page;
import com.qa.pages.Login_Page;

@Listeners(com.qa.listeners.Custom_listeners.class)
public class Login_Page_Test extends Test_Base {
	Login_Page login_page;
	Home_Page home_page;

	public Login_Page_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		login_page = new Login_Page();
	}

	@Test(priority = 1, groups="Smoke")
	public void loginPageTitle_Test() {
		log.info("check title of loginpage");
		String title = login_page.validate_Login_Page_Title();
		Assert.assertEquals(title, "webERP Login screen");
		log.info("title page is correct");
	}

	@Test(priority = 2, groups="Smoke")
	public void Logo_Test() {
		log.info("check logo is available");
		boolean flag = login_page.validate_logo();
		Assert.assertTrue(flag);
		log.info("logo is available");

	}

	@Test(priority = 3, groups="Smoke")
	public void company_wordTest() {
		log.info("check companyword is visible");
		boolean flag = login_page.validatecompany_word();
		Assert.assertTrue(flag);
		log.info("companyword is visible");
	}

	@Test(priority = 1, groups="Regression")
	public void Username_Word_Test() {
		log.info("Check username is visible");
		String actual = login_page.validate_username_word();
		String expected = "User name:";
		Assert.assertEquals(actual, expected);
		log.info("username is visible");
		

	}

	@Test(priority = 2, groups="Regression")
	public void Username_Place_Holder_Test() {
		log.info("Check username placeholder is visible");
		String actual = login_page.validate_Username_Place_Holder();
		String expected = "User name";
		Assert.assertEquals(actual, expected);
		log.info("username placeholder is visible");
	}

	@Test(priority = 3, groups="Regression")
	public void password_wordTest() {
		log.info("check password is visible");
		String actual = login_page.validatepassword_word();
		String expected = "Password:";
		Assert.assertEquals(actual, expected);
		log.info("password is visible");
	}

	@Test(priority = 8)
	public void Password_Place_Holder_Test() {
		log.info("check password placeholder is visible");
		String actual = login_page.validate_Password_Place_Holder();
		String expected = "Password";
		Assert.assertEquals(actual, expected);
		log.info("password placeholder is visible");
	}

	@Test(priority = 9)
	public void Login_Test() {
		home_page = login_page.validate_Login(prop.getProperty("Username"), prop.getProperty("Password"));
		log.info("user can login");
	}

	@Test(priority = 10)
	public void Blank_Login_Test() {
		home_page = login_page.validate_Login(prop.getProperty(""), prop.getProperty(""));
		log.info("Please enter username and password");
		log.info("username and password is blank");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
