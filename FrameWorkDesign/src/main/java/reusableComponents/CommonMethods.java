package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class CommonMethods extends TestBase {

	// Verifying DropDown
	public List<String> getDropdownOptionAsList(WebElement element) {
		Select os = new Select(element);
		List<WebElement> list_WebElement_model = os.getOptions();
		List<String> actualContents = new ArrayList<String>();

		for (WebElement ref : list_WebElement_model) {
			actualContents.add(ref.getText());
		}
		test.log(Status.INFO, "Actual Values are " + actualContents);
		return actualContents;
	}

	// Selecting value from Dropdown
	public void selectDDValue(WebElement element, String ValueToBeSelected) throws Exception {
		Select os = new Select(element);
		try {
			os.selectByVisibleText(ValueToBeSelected);
			test.log(Status.INFO, "Value from DropDown is selected: " + ValueToBeSelected);
		} catch (Exception e) {
			throw new Exception("Value is not present in DD for WebElement: " + element);
		}
	}

	// Selecting Radio button value
	public void selectRadioBtnVal(List<WebElement> element, String RadioValue) {
		for (WebElement ref : element) {
			String val = ref.getText();
			if (val.equals(RadioValue)) {
				ref.click();
				test.info("Radio button is clicked for value: " + RadioValue);
				break;
			}
		}
	}

	// Selecting check box values
	public void selectCheckBxVals(List<WebElement> element, String check) {
		String[] strArray = check.split(",");
		for (String str : strArray) {
			for (WebElement ele : element) {
				if (ele.getText().equalsIgnoreCase(str)) {
					ele.click();
					test.info("Clicked on the radio value: " + str);
					break;
				}
			}
		}

	}

}
