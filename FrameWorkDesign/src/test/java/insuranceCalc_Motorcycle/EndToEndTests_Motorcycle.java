package insuranceCalc_Motorcycle;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTests_Motorcycle extends TestBase {
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	@Test(dataProvider="vehData")
	public void insuranceCalculate(Object obj1) throws Exception {
		
		//Here explicitly we have converted Object Data in to hashmap
		@SuppressWarnings("unchecked")
		HashMap<String,String> testData = (HashMap<String, String>) obj1;
		
		test.log(Status.INFO, "Test Data which we have used: "+ testData);
		home.clickOnMotorCycle();
		vehData.enterVehicleData(testData);
		vehData.clickOnNextBtn_EnterVehData();
		insData.enterInsurantData(testData);
		insData.clickOn_NextEnterProductData();
		prodData.enterProductData(testData);
		prodData.clickOn_NextSelectPriceOption();
		
		System.out.println(priceOptions.getPriceofSelectedOption("Gold"));
		System.out.println(priceOptions.getPriceofSelectedOption("Silver")); 
		System.out.println(priceOptions.getPriceofSelectedOption("Platinum"));
		System.out.println(priceOptions.getPriceofSelectedOption("Ultimate"));
		
		Assert.assertEquals(priceOptions.getPriceofSelectedOption("Gold"), testData.get("PriceValidation_Gold"),"Pricings are not matching");
		Assert.assertEquals(priceOptions.getPriceofSelectedOption("Silver"), testData.get("PriceValidation_Silver"),"Pricings are not matching");
		Assert.assertEquals(priceOptions.getPriceofSelectedOption("Platinum"), testData.get("PriceValidation_Platinum"),"Pricings are not matching");
		Assert.assertEquals(priceOptions.getPriceofSelectedOption("Ultimate"), testData.get("PriceValidation_Ultimate"),"Pricings are not matching");
		
		priceOptions.selectPriceOptionPlan(testData.get("SelectOption"));
		priceOptions.clickOnNextQuoteBtn();
	} 
//Using Data Provider
	@DataProvider (name = "vehData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}
}
