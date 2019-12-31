package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Test_Base;
import com.qa.pages.items.Items_Page;

public class Home_Page extends Test_Base {
	
	@FindBy(id="AppInfoCompanyDiv")
	WebElement EProcBilling_Word;
	
	@FindBy(linkText="Items")
	WebElement Items;
	
	public Home_Page() {
		PageFactory.initElements(driver, this);
	}

	public String validate_Home_Page_Title() {
		return driver.getTitle();
	}

	public String validate_EProcBilling_Word() {
		return EProcBilling_Word.getText();

	}
	
	public Items_Page Click_On_Items() {
		Items.click();
		return new Items_Page();
	}
}
