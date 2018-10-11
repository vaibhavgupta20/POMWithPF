package util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
			String reportPath = Constants.REPORTS_PATH + fileName;

			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);

			extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "3.13.0").addSystemInfo("Environment", "QA");
		}
		return extent;
	}
}
