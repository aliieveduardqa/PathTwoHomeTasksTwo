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
        logger.info("Step 1: Waiting for '{}' to be attached to the DOM", elementName);
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.ATTACHED)
                .setTimeout(10_000));

        logger.info("Step 2: Waiting for '{}' to become visible on the screen", elementName);
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        logger.info("Step 3: Clicking on '{}'", elementName);
        locator.click();
    }
}
