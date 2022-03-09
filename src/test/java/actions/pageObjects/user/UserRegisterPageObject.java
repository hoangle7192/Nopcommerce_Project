package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserRegisterPageUI;
import org.openqa.selenium.WebDriver;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

    }

    public String getDynamicErrorMessageOfField(String errorFieldName) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_ERROR_MESSAGE_OF_FIELD, errorFieldName);
        return getElementText(driver, UserRegisterPageUI.DYNAMIC_ERROR_MESSAGE_OF_FIELD, errorFieldName);
    }

    public void enterToDynamicTextBox(String fieldName, String emailValue) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_FIELD, fieldName);
        sendKeyToElement(driver, UserRegisterPageUI.DYNAMIC_FIELD, emailValue, fieldName);
    }

    public void clickToGenderRadio(String genderValue) {
        waitForElementClickable(driver, UserRegisterPageUI.DYNAMIC_GENDER, genderValue);
        clickToElement(driver, UserRegisterPageUI.DYNAMIC_GENDER, genderValue);
    }

    public void selectDynamicDateOfBirth(String dateOfBirthProperty, String selectItemName) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_DATE_OF_BIRTH, dateOfBirthProperty);
        selectItemInDefaultDropDown(driver, UserRegisterPageUI.DYNAMIC_DATE_OF_BIRTH, selectItemName, dateOfBirthProperty);
    }

    public String getRegisteredSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
    }

    public UserHomePageObject clickToLogoutButton() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        return PageGenerateManager.getUserHomePage(driver);
    }

    public String getRegisterErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_ERROR_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_ERROR_MESSAGE);
    }
}
