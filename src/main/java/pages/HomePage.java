package pages;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

public class HomePage extends BasePage {

    private final Locator loginBtn = locator("(//*[contains(@class,'header-right__login')])[1]");
    private final Locator registerBtn = locator("//*[@data-gtm-id='ga_header_click_btn_registration']");
    private final Locator payInBtn = locator("//*[@data-id='header-cashbox-link']");
    private final Locator headerSearchBtn = locator("(//*[@class='header-search__icon-wrap']//*[@class])[1]");
    private final Locator searchInputFld = locator("//*[contains(@class,'ui-input__body')]//*[@type]");
    private final Locator searchGameCount = locator("(//*[@class='searching-lists__title']//span)[2]");
    private final Locator searchGamePresent = locator("(//*[@class='searching-lists__games']//li)[1]");

    private final Locator closedModalWindow = locator("(//*[@data-id='modal-header-close-button']/./*)[1]");

    @Step("Click on Login Button")
    public void clickLoginBtn() {
        clickWithWait(loginBtn, "Login Button");
    }

    @Step("Click on Register Button")
    public void clickRegisterBtn() {
        clickWithWait(registerBtn, "Register Button");
    }

    @Step("Search for product: {productName}")
    public void searchForProduct(String productName) {
        logger.info("Searching for product: {}", productName);
        headerSearchBtn.click();
        searchInputFld.fill(productName);
    }

    @Step("Click on Closed Modal Button")
    public void clickClosedModalBtn() {
        clickWithWait(closedModalWindow, "[x] Modal Button");
    }

    public Locator getPayInButton() { return payInBtn; }
    public Locator getLogoutButton() { return loginBtn; }
    public Locator getSearchCounterLocator() { return searchGameCount; }
    public Locator getSearchGamePresentLocator() { return searchGamePresent; }
}