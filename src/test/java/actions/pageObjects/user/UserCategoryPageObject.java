package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserCategoryPageUI;
import org.openqa.selenium.WebDriver;

public class UserCategoryPageObject extends BasePage {
    WebDriver driver;

    public UserCategoryPageObject(WebDriver driver) {
        this.driver = driver;

    }

    public UserProductDetailsPageObject clickToProductTitleLink(String productTitleName) {
        waitForElementClickable(driver, UserCategoryPageUI.PRODUCT_TITLE_NAME, productTitleName);
        clickToElement(driver, UserCategoryPageUI.PRODUCT_TITLE_NAME, productTitleName);
        return PageGenerateManager.getProductDetailsPage(driver);
    }

    public UserProductReviewsPageObject clickToAddYourReviewLink() {
        waitForElementVisible(driver, UserCategoryPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, UserCategoryPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGenerateManager.getProductReviewsPage(driver);
    }
}
