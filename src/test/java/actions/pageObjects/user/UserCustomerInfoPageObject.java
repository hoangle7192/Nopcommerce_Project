package actions.pageObjects.user;

import actions.commons.BasePage;
import interfaces.pageUIs.user.UserCustomerInfoPageUI;
import org.openqa.selenium.WebDriver;

public class UserCustomerInfoPageObject extends BasePage {
    WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToDynamicGenderRadio(String genderName) {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, genderName);
        clickToElement(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, genderName);
    }

    public void enterToDynamicFieldTextBox(String fieldName, String enterValue) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_FIELD_TEXTBOX, fieldName);
        sendKeyToElement(driver, UserCustomerInfoPageUI.DYNAMIC_FIELD_TEXTBOX, enterValue, fieldName);
    }

    public void selectToDynamicDropDown(String dateOfBirthProperty, String selectItemName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_DATE_OF_BIRTH_DROP_DOWN, dateOfBirthProperty);
        selectItemInDefaultDropDown(driver, UserCustomerInfoPageUI.DYNAMIC_DATE_OF_BIRTH_DROP_DOWN, selectItemName, dateOfBirthProperty);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
    }

    public boolean isGenderRadioButtonSelected(String genderName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, genderName);
        return isElementSelected(driver, UserCustomerInfoPageUI.DYNAMIC_GENDER_RADIO_BUTTON, genderName);
    }

    public String getDynamicAttributeValueOfFieldTextBox(String fieldName, String attributeName) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_FIELD_TEXTBOX, fieldName);
        return getElementAttributeValue(driver, UserCustomerInfoPageUI.DYNAMIC_FIELD_TEXTBOX, attributeName, fieldName);
    }

    public String getDynamicAttributeValueOfDateOfBirthDropDown(String dateOfBirthProperty) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_DATE_OF_BIRTH_DROP_DOWN, dateOfBirthProperty);
        return getSelectedItemInDefaultDropDown(driver, UserCustomerInfoPageUI.DYNAMIC_DATE_OF_BIRTH_DROP_DOWN, dateOfBirthProperty);
    }
}
