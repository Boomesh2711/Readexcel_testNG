package LoginTestCases;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CorrectUserName {
    static WebDriver driver;
    static ExtentReports extent;
    static ExtentTest test;

    @Test
    @Parameters({"uName","pass"})

    public void loginwithCorrectUserName(@Optional("defaultUsername")String uName, String pass) {

        System.out.println("Login with correct username");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        extent = new ExtentReports(" D:\\repoprtusername.html", true);
        test = extent.startTest("Login with correct username");

        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);
       // driver.navigate().refresh();
        WebElement a =driver.findElement(By.xpath("//h5[text()='Login']"));
        System.out.println("The heading of the page: "+a.getText());
     //   Pom.UserName(driver).click();
        Pom.UserName(driver).sendKeys(uName);
        Pom.Password(driver).sendKeys(pass);
        Pom.LoginButton(driver).click();
        driver.quit();
    }
}
