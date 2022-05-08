package testcase.user;

import actions.commons.BaseTest;
import actions.commons.PageGenerateManager;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import actions.reportConfigs.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Nopcommerce_Register extends BaseTest {
    public WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;

    protected String firstNameErrorMessage, lastNameErrorMessage, emailErrorMessage, passwordErrorMessage, confirmPasswordErrorMessage,
            registeredSuccessMessage, registerErrorMessage;
    public static String firstName, lastName, dayOfBirthDay, dayOfBirthMonth, dayOfBirthYear, emailValue, companyName, password,
            confirmPassword, wrongPassword;
    public static String emailValueMain, passwordMain;

    @Parameters({"browser", "urlName"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = getBrowserDriver(browserName, urlName);
        userHomePage = PageGenerateManager.getUserHomePage(driver);
        userRegisterPage = userHomePage.clickToRegisterButton();
    }

    @Test
    public void TC_01_Register_By_Empty_Data(Method method) {
        firstNameErrorMessage = "First name is required.";
        lastNameErrorMessage = "Last name is required.";
        emailErrorMessage = "Email is required.";
        passwordErrorMessage = "Password is required.";
        confirmPasswordErrorMessage = "Password is required.";

        ExtentTestManager.startTest(method.getName(), "TC_01_Register_By_Empty_Data");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Click To Register Button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Verify Error Message Of First Name");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("FirstName-error"), firstNameErrorMessage);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Verify Error Message Of Last Name");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("LastName-error"), lastNameErrorMessage);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Verify Error Message Of Email");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("Email-error"), emailErrorMessage);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Verify Error Message Of Password");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("Password-error"), passwordErrorMessage);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Verify Error Message Of Confirm Password");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("ConfirmPassword-error"), confirmPasswordErrorMessage);
    }

    @Test
    public void TC_02_Register_By_Invalid_Email(Method method) {
        emailValue = "test123@";
        emailErrorMessage = "Wrong email";

        ExtentTestManager.startTest(method.getName(), "TC_02_Register_By_Invalid_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userRegisterPage.enterToDynamicTextBox("Email", emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Click To Register Button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Verify Error Message Of Email");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("Email-error"), emailErrorMessage);
    }

    @Test
    public void TC_03_Register_By_Valid_Email(Method method) {
        firstName = "hoang";
        lastName = "le";
        dayOfBirthDay = "7";
        dayOfBirthMonth = "January";
        dayOfBirthYear = "1992";
        emailValueMain = "hoangle" + generateNumber() + "@gmail.com";
        companyName = "Freelancer";
        passwordMain = "hoangle01";
        confirmPassword = "hoangle01";

        registeredSuccessMessage = "Your registration completed";

        ExtentTestManager.startTest(method.getName(), "TC_03_Register_By_Valid_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Click To Gender Male Radio");
        userRegisterPage.clickToGenderRadio("male");

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To First Name TextBox: " + firstName);
        userRegisterPage.enterToDynamicTextBox("FirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Enter To Last Name TextBox: " + lastName);
        userRegisterPage.enterToDynamicTextBox("LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Select Date Of Birth Day: " + dayOfBirthDay);
        userRegisterPage.selectToDynamicDropDown("DateOfBirthDay", dayOfBirthDay);

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Select Date Of Birth Month: " + dayOfBirthMonth);
        userRegisterPage.selectToDynamicDropDown("DateOfBirthMonth", dayOfBirthMonth);

        ExtentTestManager.getTest().log(Status.INFO, "Step06: Select Date Of Birth Year: " + dayOfBirthYear);
        userRegisterPage.selectToDynamicDropDown("DateOfBirthYear", dayOfBirthYear);

        ExtentTestManager.getTest().log(Status.INFO, "Step07: Enter To Email TextBox: " + emailValueMain);
        userRegisterPage.enterToDynamicTextBox("Email", emailValueMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step08: Enter To Company TextBox: " + companyName);
        userRegisterPage.enterToDynamicTextBox("Company", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Step09: Enter To Password TextBox: " + passwordMain);
        userRegisterPage.enterToDynamicTextBox("Password", passwordMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step10: Enter To Confirm Password TextBox: " + confirmPassword);
        userRegisterPage.enterToDynamicTextBox("ConfirmPassword", confirmPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Step11: Click To Register Button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step12: Verify Registered Success Message");
        Assert.assertEquals(userRegisterPage.getRegisteredSuccessMessage(), registeredSuccessMessage);

        ExtentTestManager.getTest().log(Status.INFO, "Step13: Click To LogOut Button");
        userHomePage = userRegisterPage.clickToLogoutButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step14: Click To Register Button");
        userRegisterPage = userHomePage.clickToRegisterButton();
    }

    @Test
    public void TC_04_Register_By_Already_Exists_Email(Method method) {
        registerErrorMessage = "The specified email already exists";

        ExtentTestManager.startTest(method.getName(), "TC_04_Register_By_Already_Exists_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Click To Gender Male Radio");
        userRegisterPage.clickToGenderRadio("male");

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To First Name TextBox: " + firstName);
        userRegisterPage.enterToDynamicTextBox("FirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Enter To Last Name TextBox: " + lastName);
        userRegisterPage.enterToDynamicTextBox("LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Select Date Of Birth Day: " + dayOfBirthDay);
        userRegisterPage.selectToDynamicDropDown("DateOfBirthDay", dayOfBirthDay);

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Select Date Of Birth Month: " + dayOfBirthMonth);
        userRegisterPage.selectToDynamicDropDown("DateOfBirthMonth", dayOfBirthMonth);

        ExtentTestManager.getTest().log(Status.INFO, "Step06: Select Date Of Birth Year: " + dayOfBirthYear);
        userRegisterPage.selectToDynamicDropDown("DateOfBirthYear", dayOfBirthYear);

        ExtentTestManager.getTest().log(Status.INFO, "Step07: Enter To Email TextBox: " + emailValueMain);
        userRegisterPage.enterToDynamicTextBox("Email", emailValueMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step08: Enter To Company TextBox: " + companyName);
        userRegisterPage.enterToDynamicTextBox("Company", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Step09: Enter To Password TextBox: " + passwordMain);
        userRegisterPage.enterToDynamicTextBox("Password", passwordMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step10: Enter To Confirm Password TextBox: " + confirmPassword);
        userRegisterPage.enterToDynamicTextBox("ConfirmPassword", confirmPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Step11: Click To Register Button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step12: Verify Register Error Message");
        Assert.assertEquals(userRegisterPage.getRegisterErrorMessage(), registerErrorMessage);
    }

    @Test
    public void TC_05_Register_By_Password_Less_Than_Six_Character(Method method) {
        passwordErrorMessage = "Password must meet the following rules:\n" +
                "must have at least 6 characters";
        wrongPassword = "test";

        ExtentTestManager.startTest(method.getName(), "TC_05_Register_By_Password_Less_Than_Six_Character");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter Wrong Password To Password TextBox: " + wrongPassword);
        userRegisterPage.enterToDynamicTextBox("Password", wrongPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Click To Register Button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Verify Password Error Message");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("Password-error"), passwordErrorMessage);
    }

    @Test
    public void TC_06_Register_By_Confirm_Password_Un_Match_Password(Method method) {
        confirmPassword = "123456";
        confirmPasswordErrorMessage = "The password and confirmation password do not match.";

        ExtentTestManager.startTest(method.getName(), "TC_06_Register_By_Confirm_Password_Un_Match_Password");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Password TextBox: " + password);
        userRegisterPage.enterToDynamicTextBox("Password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To ConfirmPassword TextBox: " + confirmPassword);
        userRegisterPage.enterToDynamicTextBox("ConfirmPassword", confirmPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Register Button");
        userRegisterPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Verify Confirm Password Error Message");
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessageOfField("ConfirmPassword-error"), confirmPasswordErrorMessage);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
