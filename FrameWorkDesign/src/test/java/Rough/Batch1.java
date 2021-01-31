package Rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Batch1 {

	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1() {
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void test2() {
		driver.get("https://www.gmail.com/");
	}
	
	@Test
	public void test3() {
		driver.get("https://www.gmail.com/");
	}
	
	@Test
	public void test4() {

		driver.get("https://www.gmail.com/");

	}

	@AfterTest
	public void test5() {

		driver.close();

	}
}
