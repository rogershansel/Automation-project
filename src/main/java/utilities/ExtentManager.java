package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReporter() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/extentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            System.out.println("Extent Report will be saved to: " + reportPath);
        }

        return extent;
    }
}