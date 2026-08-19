package business;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class SCHomePageBO {

    private static final Logger logger = LoggerFactory.getLogger(SCHomePageBO.class);
    private final HomePage homePage;

    public SCHomePageBO() {
        this.homePage = new HomePage();
    }

    @Step("Open Login form")
    public SCHomePageBO openLoginForm() {
        logger.info("Opening Login form");
        homePage.clickLoginButton();
        return this;
    }

    @Step("Open Registration form")
    public SCHomePageBO openRegistrationForm() {
        logger.info("Opening Registration form");
        homePage.clickRegisterButton();
        return this;
    }

    @Step("Search for product: {productName}")
    public SCHomePageBO searchForProduct(String productName) {
        logger.info("Searching for product: {}", productName);

        homePage.clickHeaderSearchButton()
                .fillSearchInput(productName);
        return this;
    }

    @Step("Close modal window")
    public SCHomePageBO closeModalWindow() {
        logger.info("Closing modal window");
        homePage.clickCloseModalButton();
        return this;
    }

    @Step("Check if Pay In button is visible")
    public boolean isUserLoggedIn() {
        return homePage.isPayInButtonVisible();
    }

    @Step("Check if Login button is visible")
    public boolean isLoginButtonVisible() {
        return homePage.isLoginButtonVisible();
    }

    @Step("Get search results count")
    public String getSearchGamesCount() {
        return homePage.getSearchGameCountText();
    }

    @Step("Check if searched game is present in results")
    public boolean isSearchedGameFound() {
        return homePage.isSearchGamePresent();
    }
}