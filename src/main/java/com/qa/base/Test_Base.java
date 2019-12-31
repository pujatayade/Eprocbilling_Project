package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.listeners.Track_Changes_In_Application;
import com.qa.util.Test_Util;

public class Test_Base {

	public static WebDriver driver = null;
	public static Properties prop;
	public static Logger log;
	public static Workbook book;
	public static Sheet sheet;

	public Test_Base() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Dattatray\\eclipse-workspace\\Eprobiling1\\"
					+ "src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			System.out.println("config.properties file not found");
			// e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		log = Logger.getLogger(Test_Base.class);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		String browser = prop.getProperty("Browser");

		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver64bit.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid browser name in property file");
		}
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        Track_Changes_In_Application trackchange = new Track_Changes_In_Application();
        eventDriver.register(trackchange);
       /* System.out.println("eventlistener");*/
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Test_Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Test_Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void failed(String testmethodName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File(System.getProperty("user.dir")+"/ScreenShots/"+testmethodName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
