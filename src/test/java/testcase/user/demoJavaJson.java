package testcase.user;

import actions.commons.BaseTest;
import actions.pageObjects.user.UserRegisterPageObject;
import dataTest.Json.DataJson;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demoJavaJson extends BaseTest {

    WebDriver driver;
    UserRegisterPageObject userRegisterPage;
    DataJson dataJson;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        dataJson = DataJson.getDataJson();
        driver = getBrowserDriver(browserName, dataJson.getUrl());
        System.out.println("hostName: " + dataJson.getHostName());
        System.out.println("username: " + dataJson.getUserName());
        System.out.println("password: " + dataJson.getPassword());
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
