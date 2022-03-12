package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.user.UserProductReviewsPageUI;
import org.openqa.selenium.WebDriver;

public class UserProductReviewsPageObject extends BasePage {
    WebDriver driver;

    public UserProductReviewsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToReviewTitleTextBox(String reviewTitle) {
        waitForElementVisible(driver, UserProductReviewsPageUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, UserProductReviewsPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void enterToReviewProductTextArea(String reviewText) {
        waitForElementVisible(driver, UserProductReviewsPageUI.REVIEW_PRODUCT_TEXTAREA);
        sendKeyToElement(driver, UserProductReviewsPageUI.REVIEW_PRODUCT_TEXTAREA, reviewText);
    }

    public void chooseToRatingRadioButton(String ariaLabel) {
        waitForElementClickable(driver, UserProductReviewsPageUI.RATING_RADIO_BUTTON, ariaLabel);
        clickToElement(driver, UserProductReviewsPageUI.RATING_RADIO_BUTTON, ariaLabel);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserProductReviewsPageUI.SUBMIT_BUTTON);
        clickToElement(driver, UserProductReviewsPageUI.SUBMIT_BUTTON);
    }

    public UserCustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, UserProductReviewsPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserProductReviewsPageUI.MY_ACCOUNT_LINK);
        return PageGenerateManager.getUserCustomerInfoPage(driver);
    }
}
