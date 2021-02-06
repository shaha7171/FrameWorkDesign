package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsurantDataPageObjects extends TestBase {
	
	public EnterInsurantDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	@FindBy(id="lastname")
	WebElement txt_lastname;
	@FindBy(id="birthdate")
	WebElement date_birthdate;
	
	//Gender
	@FindBy(xpath="//input[@name='Gender']/parent::label")
	List<WebElement> rdo_Gender;
	
	@FindBy(id="streetaddress")
	WebElement txt_streetaddress;
	@FindBy(id="country")
	WebElement dd_country;
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	@FindBy(id="city")
	WebElement txt_city;
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	//Hobbies
	@FindBy(xpath="//input[@name='Hobbies']/parent::label")
	List<WebElement> chk_Hobbies;
	
	@FindBy(id="website")
	WebElement dd_website;
	@FindBy(name="Picture")
	WebElement txt_Picture;
	@FindBy(name="Open")
	WebElement btn_OpenPicture;
	@FindBy(id="preventervehicledata")
	WebElement btn_preventervehicledata;
	@FindBy(id="nextenterproductdata")
	WebElement btn_nextenterproductdata;

	public void enterInsurantData(HashMap<String,String> testData) throws Exception {
		txt_firstname.sendKeys(testData.get("Insurant_FirstName"));
		txt_lastname.sendKeys(testData.get("Insurant_LastName"));
		date_birthdate.sendKeys(testData.get("Insurant_birthdate"));
		cm.selectRadioBtnVal(rdo_Gender, testData.get("Insurant_gender"));
		cm.selectDDValue(dd_country, testData.get("Insurant_country"));
		txt_zipcode.sendKeys(testData.get("Insurant_zipcode"));
		txt_city.sendKeys("Khed");
		cm.selectDDValue(dd_occupation, testData.get("Insurant_occupation"));
		cm.selectCheckBxVals(chk_Hobbies,testData.get("Insurant_Hobby"));
		
		test.info("Successfully entered Insurant data");
	}
	
	public void clickOn_NextEnterProductData() {
		btn_nextenterproductdata.click();
		test.info("clicked on Insurant Data next button and page is navigating to prodcut data");
	}

}
