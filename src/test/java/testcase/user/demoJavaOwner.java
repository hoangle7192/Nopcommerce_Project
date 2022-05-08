package testcase.user;

import actions.commons.BaseTest;
import actions.environment.EnvironmentConfig;
import actions.pageObjects.user.UserRegisterPageObject;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demoJavaOwner extends BaseTest {

    WebDriver driver;
    UserRegisterPageObject userRegisterPage;
    EnvironmentConfig environmentConfig;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        ConfigFactory.setProperty("env", System.getProperty("ENV"));
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriver(browserName, environmentConfig.url());

        System.out.println("environment: " + environmentConfig.url());
        System.out.println("environment: " + environmentConfig.getDBHostName());
        System.out.println("environment: " + environmentConfig.getDBUserName());
        System.out.println("environment: " + environmentConfig.getDBPassword());
        System.out.println("environment: " + environmentConfig.getClass());
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
