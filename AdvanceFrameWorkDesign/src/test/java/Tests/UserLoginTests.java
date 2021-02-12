package Tests;

import org.testng.annotations.Test;

import pages.LoginPageObject;
import testBase.TestBase;

@Test
public class UserLoginTests extends TestBase{
	LoginPageObject loginPage = new LoginPageObject();
	

	public void ManagerLoginTest() throws Throwable {
		
		loginPage.login("administrator@localhost.com", "administrator");
		Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel


	}
		public void ClientLoginTest() throws Throwable {
		
		loginPage.login("client@localhost.com", "admin@123");
		Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel

	}
	public void DesignerLoginTest() throws Throwable {
		
		loginPage.login("designer@localhost.com", "admin@123");
		Thread.sleep(2000); ////// not required, adding just to see tests are running in parallel
		assertEqualsString_custom("ExpectedTest", "ActualText", "LoginPageHomePage");

	}

}
