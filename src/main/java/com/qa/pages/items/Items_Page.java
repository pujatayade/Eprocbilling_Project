package com.qa.pages.items;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Test_Base;

public class Items_Page extends Test_Base {

	@FindBy(linkText = "Insert New Item")
	WebElement Insert_New_Item;

	@FindBy(xpath = "//*[@id=\"BodyWrapDiv\"]/form/div/table/tbody/tr[1]/td[1]/select")
	WebElement Stock_Category;

	@FindBy(name = "Search")
	WebElement Search_Now;
	
	@FindBy(xpath= "//*[@id=\"MessageContainerFoot\"]/div/b")
	WebElement info_message;

	public Items_Page() {
		PageFactory.initElements(driver, this);
	}

	public String validate_Items_Page_Title() {
		return driver.getTitle();
	}

	public void validate_Stock_Category(String stock_category) {
		Select select = new Select(Stock_Category);
		select.selectByVisibleText(stock_category);

	}

	public void validate_Search_Now_Color() {
		System.out.println("Before mouse over button color is: " + Search_Now.getCssValue("background-color"));
		Actions action = new Actions(driver);
		action.moveToElement(Search_Now).build().perform();
		System.out.println("After mouse over button color is: " + Search_Now.getCssValue("color"));

	}
	public boolean validate_info_message() {
		Search_Now.click();
		return Search_Now.isDisplayed();
	
	}

	public Insert_New_Item_Page Click_On_Insert_New_Item() {
		Insert_New_Item.click();
		return new Insert_New_Item_Page();
	}

}
