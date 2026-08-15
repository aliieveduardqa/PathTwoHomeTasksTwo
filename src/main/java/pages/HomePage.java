package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage extends BasePage {

    private final Locator loginBtn = locator("(//*[contains(@class,'header-right__login')])[1]");
    private final Locator registerBtn = locator("//*[@data-id='header-register-click']");
    private final Locator payInBtn = locator("//*[@data-id='header-cashbox-link']");
    private final Locator headerSearchBtn = locator("(//*[@class='header-search__icon-wrap']//*[@class])[1]");
    private final Locator searchInputFld = locator("//*[contains(@class,'ui-input__body')]//*[@type]");
    private final Locator searchGameCount = locator("(//*[@class='searching-lists__title']//span)[2]");
    private final Locator searchGamePresent = locator("(//*[@class='searching-lists__games']//li)[1]");

    public void clickLoginBtn() {
        clickWithWait(loginBtn);
    }

    public void clickRegisterBtn() {
        clickWithWait(registerBtn);
    }

    public Locator getPayInButton() {
        return payInBtn;
    }

    public Locator getLogoutButton() {
        return loginBtn;
    }

    public void searchForProduct(String productName) {
        headerSearchBtn.click();
        searchInputFld.fill(productName);
    }

    public Locator getSearchCounterLocator() {
        return searchGameCount;
    }

    public Locator getSearchGamePresentLocator() {
        return searchGamePresent;
    }
}