package com.qa.pages.items;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.Test_Base;
import com.qa.util.Test_Util;

public class Insert_New_Item_Page extends Test_Base {
	@FindBy(name = "StockID")
	WebElement Item_code;

	@FindBy(name = "Description")
	WebElement Part_Description;

	@FindBy(id = "ItemPicture")
	WebElement Image;

	@FindBy(name = "CategoryID")
	WebElement Category;

	@FindBy(name = "EOQ")
	WebElement Quantity;

	@FindBy(name = "Volume")
	WebElement Volume;

	@FindBy(name = "GrossWeight")
	WebElement Weight;

	@FindBy(name = "NetWeight")
	WebElement Net_Weight;

	@FindBy(name = "Units")
	WebElement Unit;

	@FindBy(name = "MBFlag")
	WebElement Labour;

	@FindBy(name = "Discontinued")
	WebElement COB;

	@FindBy(xpath = "//*[@id=\"BodyWrapDiv\"]/form/div/table/tbody/tr[15]/td[2]/select")
	WebElement Control;

	@FindBy(name = "Serialised")
	WebElement Serialised;

	@FindBy(name = "Perishable")
	WebElement Perishable;

	@FindBy(name = "DecimalPlaces")
	WebElement Display_Quantity;

	@FindBy(name = "BarCode")
	WebElement Bar_Code;

	@FindBy(name = "DiscountCategory")
	WebElement Discount;

	@FindBy(name = "TaxCat")
	WebElement Tax_Category;
	
	@FindBy(linkText = "Add or Modify Stock Categories")
	WebElement Add_Stock_Categories;

	public Insert_New_Item_Page() {
		PageFactory.initElements(driver, this);
	}

	public String validate_Insert_New_Item_Page_Title() {
		return driver.getTitle();
	}

	public void Add_New_Item(String code, String Des, String ct, String quan, String vol, String wt, String netwt,
			String units, String labour, String cob, String control, String ser, String per, String qty, String bar,
			String dis, String tax) throws IOException, InterruptedException {

		Item_code.sendKeys(code);
		Part_Description.sendKeys(Des);
		String path=System.getProperty("user.dir");
		System.out.println(path);
		Runtime.getRuntime().exec(path+"\\ProjectFile1.exe");
		Thread.sleep(3000);

		Test_Util.HandleDropDown(Category, ct);
		Quantity.sendKeys(quan);
		Volume.sendKeys(vol);
		Weight.sendKeys(wt);
		Net_Weight.sendKeys(netwt);
		Test_Util.HandleDropDown(Unit, units);

		Test_Util.HandleDropDown(Labour, labour);

		Test_Util.HandleDropDown(COB, cob);

		Test_Util.HandleDropDown(Control, control);

		Test_Util.HandleDropDown(Serialised, ser);

		Test_Util.HandleDropDown(Perishable, per);

		Display_Quantity.sendKeys(qty);
		Bar_Code.sendKeys(bar);
		Discount.sendKeys(dis);
		Tax_Category.sendKeys(tax);

	}
	 public Add_Stock_Categories Click_On_Add_Stock_Categories() {
	    	Add_Stock_Categories.click();
	    	return new Add_Stock_Categories();
	    	
	    }
}
