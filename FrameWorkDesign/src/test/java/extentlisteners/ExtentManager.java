package extentlisteners;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.TestBase;



public class ExtentManager extends TestBase {
	/* public static ExtentReports extent; */
		//ExtentReports is defined in Batch 1 
	public static ExtentReports setupExtentReport() {
		
		Date d = new Date();
		String fileName = "Extent_Report_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
		String ReporterPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\"+fileName;
		
		/*
		 * SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss"); Date
		 * date = new Date();
		 */
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(ReporterPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("BuldingFramework");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("BuildReport");
		return extent;
		
		
	}

}
