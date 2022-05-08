package testcase.user;

import actions.commons.BaseTest;
import actions.pageObjects.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demoMavenSurefirePlugin extends BaseTest {

    WebDriver driver;
    UserRegisterPageObject userRegisterPage;

    @Parameters({"browser","url"})
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        System.out.println("env: " + url);
    }

    @Test
    public void TC01() {
    }

    @Test
    public void TC02() {
    }

    @Test
    public void TC03() {
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
