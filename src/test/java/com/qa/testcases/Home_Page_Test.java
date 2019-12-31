package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Test_Base;
import com.qa.pages.Home_Page;
import com.qa.pages.Login_Page;
import com.qa.pages.items.Items_Page;

public class Home_Page_Test extends Test_Base {

	Login_Page login_page;
	Home_Page home_page;
	Items_Page items_page;

	public Home_Page_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		login_page = new Login_Page();
		home_page = login_page.validate_Login(prop.getProperty("Username"), prop.getProperty("Password"));
		items_page = new Items_Page();
	}
/*
	@Test(priority = 1)
	public void Home_Page_TitleTest() {
		String title = home_page.validate_Home_Page_Title();
		Assert.assertEquals(title, "Main Menu");
		System.out.println("123");

	}*/

	@Test(priority = 2)
	public void validate_EProcBilling_Word() {
		log.info("check Eprocbillingword is visible");
		String actual = home_page.validate_EProcBilling_Word();
		String expected = " EPROCBILLING";
		Assert.assertEquals(actual, expected);
		log.info("Eprocbilling is visible");
	}

	@Test(priority = 3)
	public void Click_On_Items() {
		log.info("check user click on items page");
		items_page = home_page.Click_On_Items();
		log.info("user click on items page");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
