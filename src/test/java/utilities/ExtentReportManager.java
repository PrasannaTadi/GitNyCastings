package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    //private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            try {
                ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
                extent = new ExtentReports();
                extent.attachReporter(reporter);
            } catch (Exception e) {
                System.err.println("Failed to initialize ExtentReports:");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return extent;
    }
}

