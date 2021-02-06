package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObjects extends TestBase {
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="nav_automobile")
	WebElement AutomobileLink;
	
	@FindBy(id="nav_truck")
	WebElement TruckLink;
	
	@FindBy(id="nav_motorcycle")
	WebElement MotorcycleLink;
	
	@FindBy(id="nav_camper")
	WebElement CamperLink;

	public EnterVehicleDataPageObjects clickOnMotorCycle() {
		MotorcycleLink.click();
		return new EnterVehicleDataPageObjects();
	}

}
