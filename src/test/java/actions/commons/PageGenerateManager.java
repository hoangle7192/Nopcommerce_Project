package actions.commons;

import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerateManager {

    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }
}
