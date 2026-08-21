package ui.pages;

import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    private final Locator loginBtn = locator("(//*[contains(@class,'header-right__login')])[1]");
    private final Locator registerBtn = locator("//*[@data-gtm-id='ga_header_click_btn_registration']");
    private final Locator payInBtn = locator("//*[@data-id='header-cashbox-link']");
    private final Locator headerSearchBtn = locator("(//*[@class='header-search__icon-wrap']//*[@class])[1]");
    private final Locator searchInputFld = locator("//*[contains(@class,'ui-input__body')]//*[@type]");
    private final Locator searchGameCount = locator("(//*[@class='searching-lists__title']//span)[2]");
    private final Locator searchGamePresent = locator("(//*[@class='searching-lists__games']//li)[1]");
    private final Locator closedModalWindow = locator("(//*[@data-id='modal-header-close-button']/./*)[1]");

    public HomePage clickLoginButton() {
        clickWithWait(loginBtn, "Login Button");
        return this;
    }

    public HomePage clickRegisterButton() {
        clickWithWait(registerBtn, "Register Button");
        return this;
    }

    public HomePage clickHeaderSearchButton() {
        clickWithWait(headerSearchBtn, "Search game Tab");
        return this;
    }

    public HomePage fillSearchInput(String productName) {
        searchInputFld.fill(productName);
        return this;
    }

    public HomePage clickCloseModalButton() {
        clickWithWait(closedModalWindow, "[x] Modal Button");
        return this;
    }

    public boolean isPayInButtonVisible() {
        return payInBtn.isVisible();
    }

    public boolean isLoginButtonVisible() {
        return loginBtn.isVisible();
    }

    public String getSearchGameCountText() {
        return searchGameCount.textContent().trim();
    }

    public boolean isSearchGamePresent() {
        return searchGamePresent.isVisible();
    }
}