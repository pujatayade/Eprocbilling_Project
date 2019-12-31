package com.qa.pages.items;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.qa.base.Test_Base;
import com.qa.util.ExcelGetData;
import com.qa.util.Test_Util;

@Listeners
public class Add_Stock_Categories extends Test_Base {

	@FindBy(name = "CategoryID")
	WebElement Category_Code;

	@FindBy(xpath = "//*[@id='CategoryDescription']")
	WebElement Category_Description;

	@FindBy(id = "StockType")
	WebElement Stock_Type;

	@FindBy(id = "DefaultTaxCatID")
	WebElement Default_Tax_Category;

	@FindBy(name = "StockAct")
	WebElement Stock_GL_Code;

	@FindBy(name = "WIPAct")
	WebElement WIP_GL_Code;

	@FindBy(name = "MaterialUseageVarAc")
	WebElement Usage_Variance_GL_Code;

	@FindBy(linkText = "Add or Modify Stock Categories")
	WebElement Add_Stock_Categories;

	@FindBy(name = "submit")
	WebElement Enter_Information;

	@FindBy(xpath = "//*[@id='BodyWrapDiv']//preceding::table")
	WebElement Table;

	public Add_Stock_Categories() {
		PageFactory.initElements(driver, this);
	}

	public String validate__Add_Stock_Categories_Title() {
		return driver.getTitle();
	}

	public boolean validate_Table() {
		return Table.isDisplayed();
	}

	public void locate_Web_table() {
		List<WebElement> tr = Table.findElements(By.tagName("tr"));
		System.out.println("total no of rows" + tr.size());

		for (WebElement row : tr) {
			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				System.out.print(col.getText() + "\t");
			}
			System.out.println();
		}

	}

	public void Add_Stocks(String Sheet_name, int Row,int col) throws Exception {
		
		
		Category_Code.sendKeys(ExcelGetData.getData(Sheet_name, 0, 1));
		System.out.println("111");

		Thread.sleep(3000);
		Category_Description.sendKeys(ExcelGetData.getData(Sheet_name, 0, 2));
		System.out.println("222");
		Test_Util.HandleDropDown(Stock_Type, ExcelGetData.getData(Sheet_name, 0, 3));
		System.out.println("333");
		Test_Util.HandleDropDown(Default_Tax_Category, ExcelGetData.getData(Sheet_name, 0, 4));
		System.out.println("444");
		Test_Util.HandleDropDown(Stock_GL_Code, ExcelGetData.getData(Sheet_name, 0, 5));
		System.out.println("555");
		Test_Util.HandleDropDown(WIP_GL_Code, ExcelGetData.getData(Sheet_name, 0, 6));
		System.out.println("666");
		Test_Util.HandleDropDown(Usage_Variance_GL_Code, ExcelGetData.getData(Sheet_name, 0, 7));
		System.out.println("777");

	}

	public void Click_On_Enter_Information() {
		Enter_Information.click();
	}
	
}
