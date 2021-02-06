package reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import testBase.TestBase;

public class PropertiesOperations extends TestBase{
	
	public static String getPropertyValueByKey(String key) throws IOException {
		//Loadind Data
		prop = new Properties();
		String propFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties";
		fis = new FileInputStream(propFilePath);
		prop.load(fis);
		//Reading Data
		String value = prop.get(key).toString();
		if(value.isEmpty()) {
			test.info("value is not defined");
		}
		
		return value;
	}

}
