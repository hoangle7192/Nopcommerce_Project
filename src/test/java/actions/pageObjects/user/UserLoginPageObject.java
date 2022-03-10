package actions.pageObjects.user;

import actions.commons.BasePage;
import interfaces.pageUIs.user.UserLoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {

    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToDynamicTextBox(String fieldName, String emailValue) {
        waitForElementVisible(driver, UserLoginPageUI.DYNAMIC_FIELD, fieldName);
        sendKeyToElement(driver, UserLoginPageUI.DYNAMIC_FIELD, emailValue, fieldName);
    }

    public void clickDynamicButton(String buttonName) {
        waitForElementClickable(driver, UserLoginPageUI.DYNAMIC_BUTTON, buttonName);
        clickToElement(driver, UserLoginPageUI.DYNAMIC_BUTTON, buttonName);
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getLoginErrorMessage() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
    }
}
