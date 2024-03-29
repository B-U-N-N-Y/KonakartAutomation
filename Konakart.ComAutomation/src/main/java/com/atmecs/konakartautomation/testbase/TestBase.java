package com.atmecs.konakartautomation.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.atmecs.konakartautomation.constants.FilePath;
import com.atmecs.konakartautomation.constants.GridConnection;
import com.atmecs.konakartautomation.constants.LoadPropertyFile;
import com.atmecs.konakartautomation.extentreports.ExtentReport;
import com.atmecs.konakartautomation.utils.ReadPropertiesFile;

/**
 * This class operate to choose the driver
 * 
 * @author arjun.santra
 *
 */
public class TestBase extends ExtentReport {

	Properties baseClass;
	String url;
	public static String browser;
	int downloadFile;
	String con;
	LoadPropertyFile property = new LoadPropertyFile();

	@BeforeTest
	public void intitailizeBrowser() throws IOException {

		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url");
		browser = baseClass.getProperty("browser");
		con = baseClass.getProperty("connection");

		System.out.println("browser is " + browser);
		if (con.equals("normal")) {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

				driver = new ChromeDriver();
				driver.get(url);

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
				driver = new FirefoxDriver();
				driver.get(url);
			} else if (browser.equalsIgnoreCase("internet explorer")) {
				System.setProperty("webdriver.ie.driver", FilePath.IE_PATH);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
				driver = new InternetExplorerDriver(ieCaps);
			}
		} else if (con.equals("grid")) {
			WebDriver drv = GridConnection.GridCon(driver, browser);
			ExtentReport.driver = drv;
			driver.get(url);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		

	}

}
