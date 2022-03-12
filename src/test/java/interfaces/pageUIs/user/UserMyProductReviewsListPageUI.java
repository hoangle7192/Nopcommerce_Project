package interfaces.pageUIs.user;

public class UserMyProductReviewsListPageUI {
    public static final String REVIEW_TITLE_CONTENT = "xpath=//div[@class='review-title']/strong[text()='%s']";
    public static final String REVIEW_TEXT_CONTENT = "xpath=//strong[text()='%s']/parent::div[@class='review-title']/parent::div/following-sibling::div/child::div";
    public static final String PRODUCT_TITLE_NAME = "xpath=//strong[text()='%s']/parent::div[@class='review-title']/parent::div/following-sibling::div//a";
}
