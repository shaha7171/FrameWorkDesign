package Tests;

import org.testng.annotations.Test;

import pages.LoginPageObject;
import testBase.TestBase;

public class rough extends TestBase{
	LoginPageObject loginPage = new LoginPageObject();
	
	@Test
	public void test1() throws InterruptedException {

		loginPage.login("administrator@localhost.com", "administrator");
		Thread.sleep(2000);
	}

	@Test
	public void test2() throws InterruptedException {
		
		loginPage.login("client@localhost.com", "admin@123");
		Thread.sleep(2000);
	//	Assert.fail();
	}
	
	@Test
	public void test3() throws InterruptedException {
		
		loginPage.login("client@localhost.com", "admin@123");
		Thread.sleep(2000);
	}


}
