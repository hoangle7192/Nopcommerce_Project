package testcase.user;

import actions.commons.BaseTest;
import actions.commons.PageGenerateManager;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import actions.reportConfigs.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Nopcommerce_Login extends BaseTest {
    WebDriver driver;
    UserHomePageObject userHomePage;
    UserLoginPageObject userLoginPage;

    protected String emailErrorMessage, loginErrorMessage;

    @Parameters({"browser","urlName"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = getBrowserDriver(browserName, urlName);
        userHomePage= PageGenerateManager.getUserHomePage(driver);
        userLoginPage = userHomePage.clickToLoginButton();
    }

    @Test
    public void TC_01_Login_With_Empty_Data(Method method) {
        Nopcommerce_Register.emailValue = "";
        Nopcommerce_Register.password = "";
        emailErrorMessage = "Please enter your email";

        ExtentTestManager.startTest(method.getName(), "TC_01_Login_With_Empty_Data");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To Password TextBox");
        userLoginPage.enterToDynamicTextBox("Password", Nopcommerce_Register.password);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Login Button");
        userLoginPage.clickDynamicButton("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Verify Email Error Message");
        Assert.assertEquals(userLoginPage.getEmailErrorMessage(), emailErrorMessage);
    }

    @Test
    public void TC_02_Login_With_Invalid_Email(Method method) {
        Nopcommerce_Register.emailValue = "123@";
        emailErrorMessage = "Wrong email";

        ExtentTestManager.startTest(method.getName(), "TC_02_Login_With_Invalid_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Click To Login Button");
        userLoginPage.clickDynamicButton("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Verify Email Error Message");
        Assert.assertEquals(userLoginPage.getEmailErrorMessage(), emailErrorMessage);
    }

    @Test
    public void TC_03_Login_With_UnRegister_Email(Method method) {
        Nopcommerce_Register.emailValue = "test123@gmail.com";
        Nopcommerce_Register.password = "123456";
        loginErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        ExtentTestManager.startTest(method.getName(), "TC_03_Login_With_UnRegister_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To Password TextBox");
        userLoginPage.enterToDynamicTextBox("Password", Nopcommerce_Register.password);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Login Button");
        userLoginPage.clickDynamicButton("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Verify Login Error Message");
        Assert.assertEquals(userLoginPage.getLoginErrorMessage(), loginErrorMessage);
    }

    @Test
    public void TC_04_Login_With_Registered_Email_And_Password_Empty(Method method) {
        Nopcommerce_Register.password = "";
        loginErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";

        ExtentTestManager.startTest(method.getName(), "TC_04_Login_With_Registered_Email_And_Password_Empty");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValueMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To Password TextBox");
        userLoginPage.enterToDynamicTextBox("Password", Nopcommerce_Register.password);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Login Button");
        userLoginPage.clickDynamicButton("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Verify Login Error Message");
        Assert.assertEquals(userLoginPage.getLoginErrorMessage(), loginErrorMessage);
    }

    @Test
    public void TC_05_Login_With_Registered_Email_And_Password_Invalid(Method method) {
        Nopcommerce_Register.password = "147147";
        loginErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";

        ExtentTestManager.startTest(method.getName(), "TC_05_Login_With_Registered_Email_And_Password_Invalid");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValueMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To Password TextBox");
        userLoginPage.enterToDynamicTextBox("Password", Nopcommerce_Register.password);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Login Button");
        userLoginPage.clickDynamicButton("Log in");

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Verify Login Error Message");
        Assert.assertEquals(userLoginPage.getLoginErrorMessage(), loginErrorMessage);
    }

    @Test
    public void TC_06_Login_With_Registered_Email_And_Password_Valid(Method method) {

        ExtentTestManager.startTest(method.getName(), "TC_06_Login_With_Registered_Email_And_Password_Valid");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To Email TextBox");
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValueMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To Password TextBox");
        userLoginPage.enterToDynamicTextBox("Password", Nopcommerce_Register.passwordMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Login Button");
        userLoginPage.clickDynamicButton("Log in");
        userHomePage = PageGenerateManager.getUserHomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitDriver();
    }
}
