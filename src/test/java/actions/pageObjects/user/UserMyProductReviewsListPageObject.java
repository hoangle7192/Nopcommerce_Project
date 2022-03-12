package actions.pageObjects.user;

import actions.commons.BasePage;
import interfaces.pageUIs.user.UserMyProductReviewsListPageUI;
import org.openqa.selenium.WebDriver;

public class UserMyProductReviewsListPageObject extends BasePage {
    WebDriver driver;

    public UserMyProductReviewsListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getReviewTitle(String reviewTitleContent) {
        waitForElementVisible(driver, UserMyProductReviewsListPageUI.REVIEW_TITLE_CONTENT, reviewTitleContent);
        return getElementText(driver, UserMyProductReviewsListPageUI.REVIEW_TITLE_CONTENT, reviewTitleContent);
    }

    public String getReviewText(String reviewTitleContent) {
        waitForElementVisible(driver, UserMyProductReviewsListPageUI.REVIEW_TEXT_CONTENT, reviewTitleContent);
        return getElementText(driver, UserMyProductReviewsListPageUI.REVIEW_TEXT_CONTENT, reviewTitleContent);
    }

    public String getProductTitleName(String reviewTitleContent) {
        waitForElementVisible(driver, UserMyProductReviewsListPageUI.PRODUCT_TITLE_NAME, reviewTitleContent);
        return getElementText(driver, UserMyProductReviewsListPageUI.PRODUCT_TITLE_NAME, reviewTitleContent);
    }
}
