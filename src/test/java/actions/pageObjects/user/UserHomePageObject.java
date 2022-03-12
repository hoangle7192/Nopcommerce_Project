package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserHomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject clickToRegisterButton() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_BUTTON);
        clickToElement(driver, UserHomePageUI.REGISTER_BUTTON);
        return PageGenerateManager.getUserRegisterPage(driver);
    }

    public UserLoginPageObject clickToLoginButton() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_BUTTON);
        clickToElement(driver, UserHomePageUI.LOGIN_BUTTON);
        return PageGenerateManager.getUserLoginPage(driver);
    }

    public UserCustomerInfoPageObject clickMyAccountButton() {
        waitForElementClickable(driver, UserHomePageUI.MYACCOUNT_BUTTON);
        clickToElement(driver, UserHomePageUI.MYACCOUNT_BUTTON);
        return PageGenerateManager.getUserCustomerInfoPage(driver);
    }
}
