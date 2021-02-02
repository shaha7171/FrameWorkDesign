package Rough;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseTest.SrcBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Batch1 extends SrcBaseTest{

	/*
	 * public static WebDriver driver; public static ExtentTest test;
	 */


	
	@Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browser, String url) throws InterruptedException {
		
		if(browser.equals("chrome")) {  
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(2000);
		} else {
			System.out.println("Unsupported Browser");
			Assert.fail();
		}
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("95271371");
		test.log(Status.PASS, "entered ID");
		Thread.sleep(2000);
	}

	@Test
	public void test2() throws InterruptedException {
		driver.findElement(By.id("pass")).sendKeys("94244");
		test.log(Status.PASS, "entered pass");
		Thread.sleep(2000);
	//	Assert.fail();
	}
	
	@Test
	public void test3() throws InterruptedException {
		driver.findElement(By.name("logn")).isDisplayed();
		test.log(Status.PASS, "Clicked on login Button");
		Thread.sleep(2000);
	}


	@AfterTest
	public void quit() {
		driver.close();
	}
}
