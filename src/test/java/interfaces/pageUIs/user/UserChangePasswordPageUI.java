package interfaces.pageUIs.user;

public class UserChangePasswordPageUI {
    public static final String DYNAMIC_FIELD_TEXTBOX = "xpath=//input[@id='%s']";
    public static final String CHANGE_PASSWORD_BUTTON = "xpath=//button[text()='Change password']";
    public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
    public static final String DYNAMIC_HEADER_MENU_TITLE_LINK = "xpath=//ul[@class='top-menu notmobile']/child::li/child::a[contains(.,'%s')]";
    public static final String DYNAMIC_PRODUCT_OF_HEADER_MENU = "xpath=//a[contains(.,'%s')]/ancestor::ul[@class='top-menu notmobile']/child::li//a[contains(.,'%s')]";
}
