package base;

import com.microsoft.playwright.*;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.PageManager;

import java.nio.file.Paths;

public class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up Playwright and Browser...");
        playwright = Playwright.create();

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(ConfigReader.getBooleanProperty("headless"));

        String browserName = ConfigReader.getProperty("browser");
        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(options);
                break;
            case "webkit":
                browser = playwright.webkit().launch(options);
                break;
            default:
                browser = playwright.chromium().launch(options);
        }

        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        page = context.newPage();
        PageManager.setPage(page);

        String baseUrl = ConfigReader.getProperty("baseUrl");
        logger.info("Navigating to: {}", baseUrl);
        page.navigate(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test failed! Taking screenshot and saving trace.");
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            attachScreenshotToAllure(screenshot);

            String traceName = "test-output/traces/" + result.getName() + "_trace.zip";
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(traceName)));
            logger.info("Trace saved: {}", traceName);
        } else {
            logger.info("Test passed successfully.");
            context.tracing().stop();
        }

        PageManager.removePage();
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    @Attachment(value = "Page Screenshot on Failure", type = "image/png")
    public byte[] attachScreenshotToAllure(byte[] screenShot) {
        return screenShot;
    }
}