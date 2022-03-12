package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        String projectPath = System.getProperty("user.dir");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register?returnurl=%2F");
    }

    @Test
    public void tc() {
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        String text = driver.findElement(By.xpath("//span[@id='Password-error']")).getText();
        System.out.println(text);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
