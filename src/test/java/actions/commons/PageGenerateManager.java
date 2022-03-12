package actions.commons;

import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;

public class PageGenerateManager {

    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserAddressesListPageObject getUserAddressesListPage(WebDriver driver) {
        return new UserAddressesListPageObject(driver);
    }

    public static UserAddressEditPageObject getUserAddressEditPage(WebDriver driver) {
        return new UserAddressEditPageObject(driver);
    }

    public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
        return new UserChangePasswordPageObject(driver);
    }

    public static UserCategoryPageObject getCategoryPage(WebDriver driver) {
        return new UserCategoryPageObject(driver);
    }

    public static UserProductDetailsPageObject getProductDetailsPage(WebDriver driver) {
        return new UserProductDetailsPageObject(driver);
    }

    public static UserProductReviewsPageObject getProductReviewsPage(WebDriver driver) {
        return new UserProductReviewsPageObject(driver);
    }

    public static UserMyProductReviewsListPageObject getMyProductReviewsListPage(WebDriver driver) {
        return new UserMyProductReviewsListPageObject(driver);
    }
}
