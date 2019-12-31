package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Test_Base;
import com.qa.util.ExcelGetData;

public class Login_Page extends Test_Base {

	@FindBy(id = "login_logo")
	WebElement logo;

	@FindBy(xpath = "//*[@id=\"login_box\"]/form/div/span[1]")
	WebElement company_word;

	@FindBy(xpath = "//*[@id=\"login_box\"]/form/div/span[1]/select")
	WebElement EProcbiling_Word;

	@FindBy(xpath = "//*[@id=\"login_box\"]/form/div/span[2]")
	WebElement username_word;

	@FindBy(name = "UserNameEntryField")
	WebElement username;

	@FindBy(name = "UserNameEntryField")
	WebElement Username_Place_Holder;

	@FindBy(xpath = "//*[@id=\"login_box\"]/form/div/span[3]")
	WebElement password_word;

	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@type='password']")
	WebElement Password_Place_Holder;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Login;

	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	public String validate_Login_Page_Title() {
		return driver.getTitle();
	}

	public boolean validate_logo() {
		return logo.isDisplayed();
	}

	public boolean validatecompany_word() {
		return company_word.isDisplayed();
	}

	public void select_EProcbiling() {
		Select select = new Select(EProcbiling_Word);
		select.selectByVisibleText("EProcBiling");

	}

	public String validate_username_word() {
		return username_word.getText();

	}

	public String validate_Username_Place_Holder() {
		return Username_Place_Holder.getAttribute("placeholder");

	}

	public String validatepassword_word() {
		return password_word.getText();

	}

	public String validate_Password_Place_Holder() {
		return Password_Place_Holder.getAttribute("placeholder");

	}

	public Home_Page validate_Login(String UN, String PW) {
		username.sendKeys(UN);
		Password.sendKeys(PW);
		Login.click();
		return new Home_Page();
	}
}

/*	}
public Home_Page validate_Login(String login,String UN, String PW) {
	try {
	username.sendKeys(ExcelGetData.getData(login, 0,0));
	Password.sendKeys(ExcelGetData.getData(login, 0,1));
	}catch(Exception e) {
		e.printStackTrace();
	}
	Login.click();
	return new Home_Page();
}*/


