package com.qa.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Test_Base;

public class Test_Util extends Test_Base {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 30;

	public static void HandleDropDown(WebElement XpathOfDropDown, String Value) {

		Select select = new Select(XpathOfDropDown);
		select.selectByVisibleText(Value);

	}
}
