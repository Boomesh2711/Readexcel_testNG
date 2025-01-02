package LoginTestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class extent {
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("D:\\Workspace\\DemoProject\\test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void testMethod() {
        test = extent.createTest("My Test");
        test.pass("Test passed");
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }
}
