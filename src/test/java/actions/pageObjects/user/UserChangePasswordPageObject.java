package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserChangePasswordPageUI;
import org.openqa.selenium.WebDriver;

public class UserChangePasswordPageObject extends BasePage {
    WebDriver driver;

    public UserChangePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToDynamicFieldTextBox(String fieldName, String enterValue) {
        waitForElementVisible(driver, UserChangePasswordPageUI.DYNAMIC_FIELD_TEXTBOX, fieldName);
        sendKeyToElement(driver, UserChangePasswordPageUI.DYNAMIC_FIELD_TEXTBOX, enterValue, fieldName);
    }

    public void clickToChangePasswordButton() {
        waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public String getChangePasswordSuccessMessage() {
        waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
        return getElementText(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
    }

    public void hoverMouseToDynamicHeaderMenuTitleLink(String headerMenuTitle) {
        waitForElementVisible(driver, UserChangePasswordPageUI.DYNAMIC_HEADER_MENU_TITLE_LINK, headerMenuTitle);
        hoverMouseToElement(driver, UserChangePasswordPageUI.DYNAMIC_HEADER_MENU_TITLE_LINK, headerMenuTitle);
    }

    public UserCategoryPageObject clickToDynamicProductOfHeaderMenuTitleLink(String headerMenuTitle, String productOfHeaderMenu) {
        waitForElementClickable(driver, UserChangePasswordPageUI.DYNAMIC_PRODUCT_OF_HEADER_MENU, headerMenuTitle, productOfHeaderMenu);
        clickToElement(driver, UserChangePasswordPageUI.DYNAMIC_PRODUCT_OF_HEADER_MENU, headerMenuTitle, productOfHeaderMenu);
        return PageGenerateManager.getCategoryPage(driver);
    }
}
