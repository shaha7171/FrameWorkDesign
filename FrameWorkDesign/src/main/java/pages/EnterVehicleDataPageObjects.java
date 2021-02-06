package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {
	
	public EnterVehicleDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="make")
	WebElement dd_make;
	@FindBy(id="model")
	WebElement dd_model;
	@FindBy(id="engineperformance")
	WebElement txt_engineperformance;
	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_cylindercap;
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cylindercap;
	@FindBy(id="dateofmanufacture")
	WebElement date_dateofmanufacture;
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;
	@FindBy(id="fuel")
	WebElement dd_typeOfFuel;
	@FindBy(id="listprice")
	WebElement txt_listprice;
	@FindBy(id="licenseplatenumber")
	WebElement txt_licenseplatenumber;
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	@FindBy(id="nextenterinsurantdata")
	WebElement btn_nextenterinsurantdata;
	
	
	public void enterCylinderCap(String cylindercap) {
		txt_cylindercap.sendKeys(cylindercap);
	}
	
	public String getErrorMessageOnCylinderCap() {
		return error_cylindercap.getText();
	}
	
	public List<String> getDD_model() {
		return cm.getDropdownOptionAsList(dd_model);
	}
	
	public List<String> getDD_make() {
		return cm.getDropdownOptionAsList(dd_make);
	}
	
	public List<String> getDD_numberofseats() {
		return cm.getDropdownOptionAsList(dd_numberofseats);
	}
	
	public void enterVehicleData(HashMap <String,String> testData) throws Exception {
		cm.selectDDValue(dd_make, testData.get("Vehicle_Make"));
		cm.selectDDValue(dd_model, testData.get("Vehicle_Model"));
		txt_cylindercap.sendKeys(testData.get("Vehicle_CylinderCapacity"));
		txt_engineperformance.sendKeys(testData.get("Vehicle_Enging Performance"));
		date_dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		cm.selectDDValue(dd_numberofseats,testData.get("Vehicle_No of Seats_motorcycle"));
		txt_listprice.sendKeys(testData.get("Vehicle_List Price"));
		txt_annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
		
		test.info("Successfully entered vehicle data");
	}
	
	public void clickOnNextBtn_EnterVehData() {
		btn_nextenterinsurantdata.click();
		test.info("clicked on the next button of Vehicle data page is navigating to insurant data");
	}
}
