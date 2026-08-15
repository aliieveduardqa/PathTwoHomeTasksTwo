package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage {
    private final Page page;

    private final String loginBtn = "(//*[contains(@class,'header-right__login')])[1]";
    private final String registerBtn = "//*[@data-id='header-register-click']";
    private final String payInBtn = "//*[@data-id='header-cashbox-link']";

    private final String headerSearchBtn = "(//*[@class='header-search__icon-wrap']//*[@class])[1]";
    private final String searchInputFld = "//*[contains(@class,'ui-input__body')]//*[@type]";

    private final String searchGameCount = "(//*[@class='searching-lists__title']//span)[2]";
    private final String searchGamePresent = "(//*[@class='searching-lists__games']//li)[1]";


    public HomePage(Page page) {
        this.page = page;
    }

    public void clickLoginBtn() {
        Locator loginButton = page.locator(loginBtn);
        loginButton.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(10_000));
        loginButton.click();
    }

    public void clickRegisterBtn() {
        Locator registerButton = page.locator(registerBtn);
        registerButton.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(10_000));
        registerButton.click();
    }

    public Locator getPayInButton() {
        return page.locator(payInBtn);
    }

    public Locator getLogoutButton() {
        return page.locator(loginBtn);
    }

    public void searchForProduct(String productName) {
        page.locator(headerSearchBtn).click();
        page.locator(searchInputFld).fill(productName);
    }

    public Locator getSearchCounterLocator() {
        return page.locator(searchGameCount);
    }

    public Locator getSearchGamePresentLocator() {
        return page.locator(searchGamePresent);
    }
}