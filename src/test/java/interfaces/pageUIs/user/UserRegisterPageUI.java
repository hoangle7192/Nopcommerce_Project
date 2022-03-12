package interfaces.pageUIs.user;

public class UserRegisterPageUI {
    public static final String REGISTER_BUTTON = "css=button#register-button";
    public static final String DYNAMIC_ERROR_MESSAGE_OF_FIELD = "xpath=//div[@class='form-fields']//span[@id='%s']";
    public static final String DYNAMIC_FIELD_TEXTBOX = "xpath=//input[@id='%s']";
    public static final String DYNAMIC_GENDER_RADIO_BUTTON = "xpath=//span[@class='%s']/child::input";
    public static final String DYNAMIC_DATE_OF_BIRTH_DROP_DOWN = "xpath=//div[@class='date-picker-wrapper']/child::select[@name='%s']";
    public static final String REGISTERED_SUCCESS_MESSAGE = "xpath=//div[text()='Your registration completed']";
    public static final String LOGOUT_BUTTON = "css=a.ico-logout";
    public static final String REGISTER_ERROR_MESSAGE = "xpath=//div[@class='page-body']//li[text()='The specified email already exists']";
}
