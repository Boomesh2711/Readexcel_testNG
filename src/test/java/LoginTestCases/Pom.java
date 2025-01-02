package LoginTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pom {

    public static WebElement element = null;

    public static WebElement UserName(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='username']"));
        return element;
    }

    public static WebElement Password(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='password']"));
        return element;
    }

    public static WebElement LoginButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@type='submit']"));
        return element;
    }

}

