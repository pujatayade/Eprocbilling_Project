package com.qa.testcases.items;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Test_Base;
import com.qa.pages.Home_Page;
import com.qa.pages.Login_Page;
import com.qa.pages.items.Add_Stock_Categories;
import com.qa.pages.items.Insert_New_Item_Page;
import com.qa.pages.items.Items_Page;
import com.qa.util.ExcelRead;
import com.qa.util.Test_Util;

public class Insert_New_Item_Test extends Test_Base {
	Login_Page login_page;
	Home_Page home_page;
	Items_Page items_page;
	Insert_New_Item_Page insert_new_item_page;
	ExcelRead excelRead;
	String SheetName = "Items data";
	Test_Util test_utils;
	Add_Stock_Categories add_stock_categories;

	public Insert_New_Item_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		login_page = new Login_Page();
		home_page = login_page.validate_Login(prop.getProperty("Username"), prop.getProperty("Password"));
		items_page = home_page.Click_On_Items();
		insert_new_item_page = items_page.Click_On_Insert_New_Item();

	}

	@DataProvider
	public Object[][] get_TestData() {
		Object data[][] = ExcelRead.getTestData(SheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "get_TestData")
	public void Add_New_Item_Test(String code, String Des, String ct, String quan, String vol, String wt, String netwt,
			String units, String labour, String cob, String control, String ser, String per, String qty, String bar,
			String dis, String tax) throws IOException, InterruptedException {
		log.info("Add items in page");
		insert_new_item_page.Add_New_Item(code, Des, ct, quan, vol, wt, netwt, units, labour, cob, control, ser, per,
				qty, bar, dis, tax);
		log.info("items get added");

	}

	@Test(priority = 2)
	public void Click_On_Add_Stock_Categories_Test() {
		log.info("check click button");
		add_stock_categories = insert_new_item_page.Click_On_Add_Stock_Categories();
		log.info("button can be click");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
