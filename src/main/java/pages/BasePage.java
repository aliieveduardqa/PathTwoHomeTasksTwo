package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.PageManager;

public abstract class BasePage {
    protected final Page page = PageManager.getPage();

    protected Locator locator(String selector) {
        return page.locator(selector);
    }

    protected void clickWithWait(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10_000));
        locator.click();
    }

}
