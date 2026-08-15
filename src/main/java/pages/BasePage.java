package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PageManager;

public abstract class BasePage {
    protected final Page page = PageManager.getPage();
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Locator locator(String selector) {
        return page.locator(selector);
    }

    protected void clickWithWait(Locator locator, String elementName) {
        logger.info("Waiting for and clicking on: {}", elementName);
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10_000));
        locator.click();
    }
}
