package LoginTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BothIncorrect {
    @Test
    @Parameters({"uName", "pass"})
    public void loginwithBothIncorrect(@Optional("defaultUsername")String uName, String pass) {

        System.out.println("Login with correct username");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);
        Pom.UserName(driver).sendKeys(uName);
        Pom.Password(driver).sendKeys(pass);
        Pom.LoginButton(driver).click();
        driver.quit();
    }
}
