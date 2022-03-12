package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserAddressesListPageUI;
import org.openqa.selenium.WebDriver;

public class UserAddressesListPageObject extends BasePage {
    WebDriver driver;

    public UserAddressesListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressEditPageObject clickToAddNewButton() {
        waitForElementClickable(driver, UserAddressesListPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, UserAddressesListPageUI.ADD_NEW_BUTTON);
        return PageGenerateManager.getUserAddressEditPage(driver);
    }

    public String getDynamicInfo(String fieldName) {
        String info = null;
        waitForElementVisible(driver, UserAddressesListPageUI.DYNAMIC_INFO, fieldName);
        String value = getElementText(driver, UserAddressesListPageUI.DYNAMIC_INFO, fieldName);
        String[] values = value.split(":");
        if(values.length == 1) {
            info =  values[0].trim();
        } else if(values.length == 2) {
            info = values[1].trim();
        }
        return info;
    }
}
