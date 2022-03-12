package testcase.user;

import actions.commons.BaseTest;
import actions.commons.PageGenerateManager;
import actions.pageObjects.user.*;
import actions.reportConfigs.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Nopcommerce_MyAccount extends BaseTest {
    WebDriver driver;
    UserHomePageObject userHomePage;
    UserLoginPageObject userLoginPage;
    UserCustomerInfoPageObject userCustomerInfoPage;
    UserAddressesListPageObject userAddressesListPage;
    UserAddressEditPageObject userAddressEditPage;
    UserChangePasswordPageObject userChangePasswordPage;
    UserCategoryPageObject userCategoryPage;
    UserProductDetailsPageObject userProductDetailsPage;
    UserProductReviewsPageObject userProductReviewsPage;
    UserMyProductReviewsListPageObject userMyProductReviewsListPage;

    String firstNameValue, lastNameValue, emailValue, companyValue, countryValue, state, city, address1, address2, zip, phoneNumber, faxNumber;
    public static String newPasswordMain;
    String confirmPassword, changePasswordSuccessMessage;
    String productTitleName;
    String reviewTitle, reviewText;

    @Parameters({"browser", "urlName"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = getBrowserDriver(browserName, urlName);
        userHomePage = PageGenerateManager.getUserHomePage(driver);
        userLoginPage = userHomePage.clickToLoginButton();
        userLoginPage.enterToDynamicTextBox("Email", Nopcommerce_Register.emailValueMain);
        userLoginPage.enterToDynamicTextBox("Password", Nopcommerce_Register.passwordMain);
        userLoginPage.clickDynamicButton("Log in");
        userHomePage = PageGenerateManager.getUserHomePage(driver);
        userCustomerInfoPage = userHomePage.clickMyAccountButton();
    }

    @Test
    public void TC_01_Customer_Info(Method method) {
        Nopcommerce_Register.firstName = "hoa";
        Nopcommerce_Register.lastName = "hong";
        Nopcommerce_Register.dayOfBirthDay = "16";
        Nopcommerce_Register.dayOfBirthMonth = "October";
        Nopcommerce_Register.dayOfBirthYear = "1916";
        Nopcommerce_Register.emailValue = "hoahong" + generateNumber() + "@gmail.com";
        Nopcommerce_Register.companyName = "hoahong company";

        ExtentTestManager.startTest(method.getName(), "TC_01_Customer_Info");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Click To Gender Radio");
        userCustomerInfoPage.clickToDynamicGenderRadio("gender-female");

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To FirstName TextBox");
        userCustomerInfoPage.enterToDynamicFieldTextBox("FirstName", Nopcommerce_Register.firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Enter To LastName TextBox");
        userCustomerInfoPage.enterToDynamicFieldTextBox("LastName", Nopcommerce_Register.lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Select DateOfBirthDay DropDown");
        userCustomerInfoPage.selectToDynamicDropDown("DateOfBirthDay", Nopcommerce_Register.dayOfBirthDay);

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Select DateOfBirthMonth DropDown");
        userCustomerInfoPage.selectToDynamicDropDown("DateOfBirthMonth", Nopcommerce_Register.dayOfBirthMonth);

        ExtentTestManager.getTest().log(Status.INFO, "Step06: Select DateOfBirthYear DropDown");
        userCustomerInfoPage.selectToDynamicDropDown("DateOfBirthYear", Nopcommerce_Register.dayOfBirthYear);

        ExtentTestManager.getTest().log(Status.INFO, "Step07: Enter To Email TextBox");
        userCustomerInfoPage.enterToDynamicFieldTextBox("Email", Nopcommerce_Register.emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step08: Enter To Company TextBox");
        userCustomerInfoPage.enterToDynamicFieldTextBox("Company", Nopcommerce_Register.companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Step09: Click To Save Button");
        userCustomerInfoPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step10: Verify Gender Radio Is Selected");
        userCustomerInfoPage.isGenderRadioButtonSelected("gender-female");

        ExtentTestManager.getTest().log(Status.INFO, "Step11: Verify Attribute Value Of FirstName TextBox");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfFieldTextBox("FirstName", "value"), Nopcommerce_Register.firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Step12: Verify Attribute Value Of LastName TextBox");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfFieldTextBox("LastName", "value"), Nopcommerce_Register.lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Step13: Verify Attribute Value Of DateOfBirthDay DropDown");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfDateOfBirthDropDown("DateOfBirthDay"), Nopcommerce_Register.dayOfBirthDay);

        ExtentTestManager.getTest().log(Status.INFO, "Step14: Verify Attribute Value Of DateOfBirthMonth DropDown");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfDateOfBirthDropDown("DateOfBirthMonth"), Nopcommerce_Register.dayOfBirthMonth);

        ExtentTestManager.getTest().log(Status.INFO, "Step15: Verify Attribute Value Of DateOfBirthYear DropDown");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfDateOfBirthDropDown("DateOfBirthYear"), Nopcommerce_Register.dayOfBirthYear);

        ExtentTestManager.getTest().log(Status.INFO, "Step16: Verify Attribute Value Of Email TextBox");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfFieldTextBox("Email", "value"), Nopcommerce_Register.emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step17: Verify Attribute Value Of Company TextBox");
        Assert.assertEquals(userCustomerInfoPage.getDynamicAttributeValueOfFieldTextBox("Company", "value"), Nopcommerce_Register.companyName);
    }

    @Test
    public void TC_02_Address(Method method) {
        firstNameValue = "cus";
        lastNameValue = "tomer";
        emailValue = "customer" + generateNumber() + "@gmail.com";
        companyValue = "company";
        countryValue = "United States";
        state = "AP (Armed Forces Pacific)";
        city = "arizona";
        address1 = "address1 ly thai to arizona";
        address2 = "address2 ly thai to arizona";
        zip = "123456";
        phoneNumber = "0905414441";
        faxNumber = "0905414442";

        ExtentTestManager.startTest(method.getName(), "TC_02_Address");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Click To Addresses Page Link");
        userCustomerInfoPage.clickToDynamicPageListLink(driver, "Addresses");
        userAddressesListPage = PageGenerateManager.getUserAddressesListPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Click To AddNew Button");
        userAddressEditPage = userAddressesListPage.clickToAddNewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Enter To Address_FirstName TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_FirstName", firstNameValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Enter To Address_LastName TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_LastName", lastNameValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Enter To Address_Email TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_Email", emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Enter To Address_Company TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_Company", companyValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step06: Select Address_CountryId DropDown");
        userAddressEditPage.selectToDynamicFieldDropDown("Address_CountryId", countryValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step07: Select To Address_StateProvinceId DropDown");
        userAddressEditPage.selectToDynamicFieldDropDown("Address_StateProvinceId", state);

        ExtentTestManager.getTest().log(Status.INFO, "Step08: Enter To Address_City TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_City", city);

        ExtentTestManager.getTest().log(Status.INFO, "Step09: Enter To Address_Address1 TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_Address1", address1);

        ExtentTestManager.getTest().log(Status.INFO, "Step10: Enter To Address_Address2 TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_Address2", address2);

        ExtentTestManager.getTest().log(Status.INFO, "Step11: Enter To Address_ZipPostalCode TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_ZipPostalCode", zip);

        ExtentTestManager.getTest().log(Status.INFO, "Step12: Enter To Address_PhoneNumber TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_PhoneNumber", phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Step13: Enter To Address_FaxNumber TextBox");
        userAddressEditPage.enterToDynamicFieldTextBox("Address_FaxNumber", faxNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Step14: Click To Save Button");
        userAddressesListPage = userAddressEditPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step15: Verify firstName and lastName");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("name"), firstNameValue + " " + lastNameValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step16: Verify emailValue");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("email"), emailValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step17: Verify phoneNumber");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("phone"), phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Step18: Verify faxNumber");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("fax"), faxNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Step19: Verify companyValue");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("company"), companyValue);

        ExtentTestManager.getTest().log(Status.INFO, "Step20: Verify address1");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("address1"), address1);

        ExtentTestManager.getTest().log(Status.INFO, "Step21: Verify address2");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("address2"), address2);

        ExtentTestManager.getTest().log(Status.INFO, "Step22: Verify city-state-zip");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("city-state-zip"), city + ", " + state + ", " + zip);

        ExtentTestManager.getTest().log(Status.INFO, "Step23: Verify countryValue");
        Assert.assertEquals(userAddressesListPage.getDynamicInfo("country"), countryValue);
    }

    @Test
    public void TC_03_Change_Password(Method method) {
        newPasswordMain = "345678";
        confirmPassword = "345678";
        changePasswordSuccessMessage = "Password was changed";

        ExtentTestManager.startTest(method.getName(), "TC_03_Change_Password");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Click To Change Password Page Link");
        userAddressesListPage.clickToDynamicPageListLink(driver, "Change password");
        userChangePasswordPage = PageGenerateManager.getUserChangePasswordPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Enter To OldPassword TextBox");
        userChangePasswordPage.enterToDynamicFieldTextBox("OldPassword", Nopcommerce_Register.passwordMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Enter To NewPassword TextBox");
        userChangePasswordPage.enterToDynamicFieldTextBox("NewPassword", newPasswordMain);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Enter To ConfirmNewPassword TextBox");
        userChangePasswordPage.enterToDynamicFieldTextBox("ConfirmNewPassword", confirmPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Click To Change Password Button");
        userChangePasswordPage.clickToChangePasswordButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Verify Change Password Is Successes");
        Assert.assertEquals(userChangePasswordPage.getChangePasswordSuccessMessage(), changePasswordSuccessMessage);
    }

    @Test
    public void TC_04_My_Product_Review(Method method) {
        productTitleName = "Digital Storm VANQUISH 3 Custom Performance PC";
        reviewTitle = "Review about Digital Storm VANQUISH 3 Custom Performance PC";
        reviewText = "This is my favourite product. It's very cheap and good. I love it very much";

        ExtentTestManager.startTest(method.getName(), "TC_04_My_Product_Review");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Hover Mouse To Header Menu: Computers");
        //userChangePasswordPage.refreshPage(driver);
        userChangePasswordPage.hoverMouseToDynamicHeaderMenuTitleLink("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Click To Computers Link");
        userCategoryPage = userChangePasswordPage.clickToDynamicProductOfHeaderMenuTitleLink("Computers", "Desktops");

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Click To Product Title Name");
        userProductDetailsPage = userCategoryPage.clickToProductTitleLink(productTitleName);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Click To Add Your Review Link");
        userProductReviewsPage = userCategoryPage.clickToAddYourReviewLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Enter To Review Title Content");
        userProductReviewsPage.enterToReviewTitleTextBox(reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Step06: Enter To Review Text Content");
        userProductReviewsPage.enterToReviewProductTextArea(reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Step07: Choose Rating Radio Button");
        userProductReviewsPage.chooseToRatingRadioButton("Good");

        ExtentTestManager.getTest().log(Status.INFO, "Step08: Click To Submit Review Button");
        userProductReviewsPage.clickToSubmitReviewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step09: Click To My Account Link");
        userCustomerInfoPage = userProductReviewsPage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step10: Click To My product reviews Link");
        userCustomerInfoPage.clickToDynamicPageListLink(driver, "My product reviews");
        userMyProductReviewsListPage = PageGenerateManager.getMyProductReviewsListPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step11: Verify Review Title Content");
        Assert.assertEquals(userMyProductReviewsListPage.getReviewTitle(reviewTitle), reviewTitle);

        ExtentTestManager.getTest().log(Status.INFO, "Step12: Verify Review Text Content");
        Assert.assertEquals(userMyProductReviewsListPage.getReviewText(reviewTitle), reviewText);

        ExtentTestManager.getTest().log(Status.INFO, "Step13: Verify Product Title Name");
        Assert.assertEquals(userMyProductReviewsListPage.getProductTitleName(reviewTitle), productTitleName);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitDriver();
    }
}
