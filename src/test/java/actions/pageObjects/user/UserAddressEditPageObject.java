package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserAddressEditPageUI;
import org.openqa.selenium.WebDriver;

public class UserAddressEditPageObject extends BasePage {
    WebDriver driver;

    public UserAddressEditPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToDynamicFieldTextBox(String fieldName, String enterValue) {
        waitForElementVisible(driver, UserAddressEditPageUI.DYNAMIC_FIELD_TEXTBOX, fieldName);
        sendKeyToElement(driver, UserAddressEditPageUI.DYNAMIC_FIELD_TEXTBOX, enterValue, fieldName);
    }

    public void selectToDynamicFieldDropDown(String fieldName, String selectValue) {
        waitForElementVisible(driver, UserAddressEditPageUI.DYNAMIC_FIELD_DROPDOWN, fieldName);
        selectItemInDefaultDropDown(driver, UserAddressEditPageUI.DYNAMIC_FIELD_DROPDOWN, selectValue, fieldName);
    }

    public UserAddressesListPageObject clickToSaveButton() {
        waitForElementClickable(driver, UserAddressEditPageUI.SAVE_BUTTON);
        clickToElement(driver, UserAddressEditPageUI.SAVE_BUTTON);
        return PageGenerateManager.getUserAddressesListPage(driver);
    }
}
