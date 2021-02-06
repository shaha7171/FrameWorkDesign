package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPageObjects extends TestBase {

	public EnterProductDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="startdate")
	WebElement date_startdate;
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	@FindBy(id="meritrating")
	WebElement dd_meritrating;
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	//Optional Product
	@FindBy(xpath="//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chk_OptionalProducts;
	
	@FindBy(id="courtesycar")
	WebElement dd_courtesycar;
	@FindBy(id="nextselectpriceoption")
	WebElement btn_nextselectpriceoption;
	@FindBy(id="preventerinsurancedata")
	WebElement btn_preventerinsurancedata;
	
	
	public void enterProductData(HashMap<String,String> testData) throws Exception {
		date_startdate.sendKeys(testData.get("Product_startdate"));
		cm.selectDDValue(dd_insurancesum,testData.get("Product_insurancesum"));
		cm.selectDDValue(dd_damageinsurance, testData.get("Product_damageinsurance"));
		cm.selectRadioBtnVal(chk_OptionalProducts,testData.get("Product_OptionalProducts"));
		
		test.info("Successfully enetered product data");
	}
	
	public void clickOn_NextSelectPriceOption() {
		btn_nextselectpriceoption.click();
		test.info("Clicked on the product data next button page is navigating to next select price option ");
	}
	
}
