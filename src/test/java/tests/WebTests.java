package tests;

import base.BaseTest;
import business.*;
import data.TestDataProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

@Epic("Web Shop Portal Automation")
@Feature("User Authentication and Interactions")
public class WebTests extends BaseTest {

    private SCHomePageBO scHomePageBO;
    private SCLoginPageBO scLoginPageBO;
    private SCRegistrationPageBO scRegistrationPageBO;
    private SCProfilePageBO scProfilePageBO;

    @BeforeMethod
    public void initBusinessObjects() {
        scHomePageBO = new SCHomePageBO();
        scLoginPageBO = new SCLoginPageBO();
        scRegistrationPageBO = new SCRegistrationPageBO();
        scProfilePageBO = new SCProfilePageBO();
    }

    @Test(
            description = "Verify successful user registration",
            dataProvider = "registrationData",
            dataProviderClass = TestDataProvider.class
    )
    @Story("Registration")
    public void testSuccessfulRegistration(String email, String password) {
        scHomePageBO.openRegistrationForm();

        scRegistrationPageBO.registerEmailUser(email, password);

        scHomePageBO.closeModalWindow()
                .closeModalWindow();

        Assert.assertTrue(scHomePageBO.isUserLoggedIn(),
                "Pay In button should be visible after successful registration");
    }

    @Test(description = "Verify validation messages on empty login")
    @Story("Login validation")
    public void testLoginWithOutFields() {
        scHomePageBO.openLoginForm();
        scLoginPageBO.submitEmptyLoginForm();

        Assert.assertEquals(scLoginPageBO.getLoginErrorMessage(), "Обов'язкове поле",
                "Incorrect login input error message");
        Assert.assertEquals(scLoginPageBO.getPasswordErrorMessage(), "Обов'язкове поле",
                "Incorrect password input error message");
    }

    @Test(description = "Verify validation messages on empty Registration fields")
    @Story("Registration validation")
    public void testRegistrationWithOutFields() {
        scHomePageBO.openRegistrationForm();
        scRegistrationPageBO.submitEmptyRegistrationForm();

        Assert.assertEquals(scLoginPageBO.getLoginErrorMessage(), "Обов'язкове поле",
                "Incorrect login input error message");
        Assert.assertEquals(scLoginPageBO.getPasswordErrorMessage(), "Обов'язкове поле",
                "Incorrect password input error message");
    }

    @Test(
            description = "Verify successful login using valid credentials",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class)
    @Story("Login")
    public void testSuccessfulLogin(String email, String password) {
        scHomePageBO.openLoginForm();
        scLoginPageBO.loginViaEmail(email, password);

        Assert.assertTrue(scHomePageBO.isUserLoggedIn(),
                "Pay In button should be visible after successful login");
    }

    @Test(
            description = "Verify successful logout functionality",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class)
    @Story("Logout")
    public void testLogout(String email, String password) {
        scHomePageBO.openLoginForm();
        scLoginPageBO.loginViaEmail(email, password);

        scProfilePageBO.logoutUser();

        Assert.assertTrue(scHomePageBO.isLoginButtonVisible(),
                "Login button should be visible after logout");
    }

    @Test(
            description = "Verify searching for a specific product",
            dataProvider = "searchQueries",
            dataProviderClass = TestDataProvider.class)
    @Story("Search Engine")
    public void testSearchProduct(String searchQuery) {
        scHomePageBO.searchForProduct(searchQuery);

        String countText = scHomePageBO.getSearchGamesCount();
        int gameCount = Integer.parseInt(countText);

        logger.info("Games found: {}", gameCount);

        Assert.assertTrue(gameCount > 0, "Error: Number of games found must be greater than 0");
        Assert.assertTrue(scHomePageBO.isSearchedGameFound(), "Search game result should be visible on the list");
    }
}