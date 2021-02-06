package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionsPageObjects extends TestBase {
	
	@FindBy(id="nextsendquote")
	WebElement btn_NextToQuote;
	public SelectPriceOptionsPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPriceofSelectedOption(String plan) {
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
	}
	
	public void selectPriceOptionPlan(String plan) {
		String dataXpath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
		driver.findElement(By.xpath(dataXpath)).click();
		test.info("Selected radio button for given price");
	}
	
	public void clickOnNextQuoteBtn() {
		btn_NextToQuote.click();
		test.info("Clicked on the Select Price Options next button now Page is navigating to Send Quote page");
	}
}
