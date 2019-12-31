package com.qa.testcases.items;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

import junit.framework.Assert;

public class Add_Stock_Categories_Test extends Test_Base {
	Login_Page login_page;
	Home_Page home_page;
	Items_Page items_page;
	Insert_New_Item_Page insert_new_item_page;
	ExcelRead excelRead;
	String SheetName = "Categories data";
	Test_Util test_utils;
	Add_Stock_Categories add_stock_categories;

	public Add_Stock_Categories_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		login_page = new Login_Page();
		home_page = login_page.validate_Login(prop.getProperty("Username"), prop.getProperty("Password"));
		items_page = home_page.Click_On_Items();
		insert_new_item_page = items_page.Click_On_Insert_New_Item();
		add_stock_categories = insert_new_item_page.Click_On_Add_Stock_Categories();
		driver.navigate().to("https://javaclassesinpune.com/projects/eprocbilling/StockCategories.php");

	}

	@Test(priority = 1)
	public void Add_Stock_Categories_Title_Test() {
		log.info("check title page of addstock categories");
		String title = add_stock_categories.validate__Add_Stock_Categories_Title();
		String expected = "Inventory Categories Maintenance";
		Assert.assertEquals(title, expected);
		log.info("title page of addstock categories is correct");
	}

	@Test(priority = 2)
	public void Table_Test() {
		log.info("check webtable is available");
		add_stock_categories.validate_Table();
		log.info("webtable is available");
	}

	@Test(priority = 3)
	public void locate_Web_table_Test() {
		log.info("check webtable");
		add_stock_categories.locate_Web_table();
		log.info("webtable is correct");
		
	}

	/*@DataProvider
	public Object[][] get_TestData() {
		Object data[][] = ExcelRead.getTestData(SheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "get_TestData")
	public void Add_New_Item_Test(String Sheet_name, int Row,int col) throws Exception {

		add_stock_categories.Add_Stocks(Sheet_name, Row, col);
		System.out.println("mmm");
	}*/

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
