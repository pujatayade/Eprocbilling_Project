package com.qa.testcases.items;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Test_Base;
import com.qa.pages.Home_Page;
import com.qa.pages.Login_Page;
import com.qa.pages.items.Insert_New_Item_Page;
import com.qa.pages.items.Items_Page;

public class Items_Page_Test extends Test_Base {

	Login_Page login_page;
	Home_Page home_page;
	Items_Page items_page;
	Insert_New_Item_Page insert_new_item_page;

	public Items_Page_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		login_page = new Login_Page();
		home_page = login_page.validate_Login(prop.getProperty("Username"), prop.getProperty("Password"));
		items_page = home_page.Click_On_Items();
	}

	@Test(priority = 1)
	public void Items_Page_TitleTest() {
		String title = items_page.validate_Items_Page_Title();
		Assert.assertEquals(title, "Search Inventory Items");
		System.out.println("1");

	}

	@Test(priority = 2)
	public void Stock_Category_Test() throws InterruptedException {
		items_page.validate_Stock_Category("Telecomm");
		Thread.sleep(5000);
		System.out.println("2");
	}

	@Test(priority = 3)
	public void Search_Now_Test() {
		items_page.validate_Search_Now_Color();
		System.out.println("3");
	}

	@Test(priority = 4)
	public void info_message_test() {
		boolean flag = items_page.validate_info_message();
		Assert.assertTrue(flag);
		System.out.println("4");

	}

	@Test(priority = 5)
	public void Click_On_Insert_New_Item_Page() {
		insert_new_item_page = items_page.Click_On_Insert_New_Item();
		System.out.println("5");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
