package insuranceCalc_Motorcycle;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_Motorcycle extends TestBase {

	@Test
	public void errorMessage_cylinderCap() throws InterruptedException {
		test.info("error test has started");
		home.clickOnMotorCycle().enterCylinderCap("333333");
		test.log(Status.PASS, "Cylinder Capacity is entered");
		String actualErrorMsg = vehData.getErrorMessageOnCylinderCap();
		String ExpectedErrormsg = "Must be a number between 1 and 2000";
		System.out.println(actualErrorMsg);
		Assert.assertEquals(actualErrorMsg, ExpectedErrormsg, "error message is not valid");
		Thread.sleep(2000);
	}
	
	@Test
	public void verifyModelDD() {
		home.clickOnMotorCycle();
		List<String> actualVal = vehData.getDD_model();
		List<String> expectedVal = Arrays.asList("- please select -" ,"Scooter" ,"Three-Wheeler" ,"Moped" ,"Motorcycle");
		test.info("Expected Val is ->"+expectedVal);
		Assert.assertEquals(actualVal, expectedVal, "Error in the DD");
	}
	
	@Test
	public void verifyMakeDD() {
		home.clickOnMotorCycle();
		List<String> actualVal = vehData.getDD_make();
		List<String> expectedVal = Arrays.asList("(.*)please select(.*)", "Audi", "BMW", "Ford", "Honda", "Mazda", "Mercedes Benz", "Nissan", "Opel", "Porsche", "Renault", "Skoda", "Suzuki", "Toyota", "Volkswagen", "Volvo");
		test.info("Expected Val is ->"+expectedVal);
		Assert.assertEquals(actualVal, expectedVal, "Error in the DD");
	}
	
	@Test
	public void verifyNumberofSeatDD() {
		home.clickOnMotorCycle();
		List<String> actualVal = vehData.getDD_numberofseats();
		List<String> expectedVal = Arrays.asList("- please select -", "1", "2", "3");
		test.info("Expected Val is ->"+expectedVal);
		Assert.assertEquals(actualVal, expectedVal, "Error in the DD");
	}
	
	
}
