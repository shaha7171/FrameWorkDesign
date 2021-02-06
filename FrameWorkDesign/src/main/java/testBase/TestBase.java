package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.EnterInsurantDataPageObjects;
import pages.EnterProductDataPageObjects;
import pages.EnterVehicleDataPageObjects;
import pages.HomePageObjects;
import pages.SelectPriceOptionsPageObjects;
import reusableComponents.CommonMethods;
import reusableComponents.PropertiesOperations;

public class TestBase extends objectsClass{

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties prop;
	public static FileInputStream fis;

	public void LaunchBrowserAndNavigate() throws IOException {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("invalid browser");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@BeforeMethod
	public void setup() throws IOException {
		LaunchBrowserAndNavigate();
		home = new HomePageObjects(); 
		vehData = new EnterVehicleDataPageObjects();
		insData = new EnterInsurantDataPageObjects();
		prodData = new EnterProductDataPageObjects();
		priceOptions = new SelectPriceOptionsPageObjects(); 
		cm = new CommonMethods();
		
	}

	@AfterMethod
	public void close() {
		//driver.quit();
	}
}
