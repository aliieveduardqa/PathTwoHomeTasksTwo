package tests;

import base.BaseTest;
import data.TestDataProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterPage;
import utils.DataGenerator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Epic("Web Shop Portal Automation")
@Feature("User Authentication and Interactions")
public class WebTests extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        profilePage = new ProfilePage();
    }

    @Test(description = "Verify successful user registration")
    @Story("Registration")
    public void testSuccessfulRegistration() {
        homePage.clickRegisterBtn();

        String uniqueEmail = DataGenerator.generateUniqueEmail("aliieveduardqa", "sharkscode.com");
        logger.info("Registering new user with email: {}", uniqueEmail);

        registerPage.registerEmailUser(uniqueEmail, "222222");

        assertThat(homePage.getPayInButton()).isVisible();
    }

    @Test(description = "Verify validation messages on empty login")
    @Story("Login validation")
    public void testLoginWithOutFields() {
        loginPage.clickSubmitLoginBtn();

        assertThat(loginPage.getErrorLoginInputLocator()).hasText("Обов'язкове поле");
        assertThat(loginPage.getErrorPasswordInputLocator()).hasText("Обов'язкове поле");
    }

    @Test(description = "Verify successful login using valid credentials",
            dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Story("Login")
    public void testSuccessfulLogin(String email, String password) {
        homePage.clickLoginBtn();
        loginPage.emailLogin(email, password);

        assertThat(homePage.getPayInButton()).isVisible();
    }

    @Test(description = "Verify successful logout functionality",
            dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Story("Logout")
    public void testLogout(String email, String password) {
        homePage.clickLoginBtn();
        loginPage.emailLogin(email, password);

        profilePage.logoutUser();

        assertThat(homePage.getLogoutButton()).isVisible();
    }

    @Test(description = "Verify searching for a specific product",
            dataProvider = "searchQueries", dataProviderClass = TestDataProvider.class)
    @Story("Search Engine")
    public void testSearchProduct(String searchQuery) {
        homePage.searchForProduct(searchQuery);

        homePage.getSearchCounterLocator().waitFor();

        String countText = homePage.getSearchCounterLocator().textContent().trim();
        int gameCount = Integer.parseInt(countText);

        logger.info("Games found: {}", gameCount);
        Assert.assertTrue(gameCount > 0, "Error: Number of games found must be greater than 0");

        assertThat(homePage.getSearchGamePresentLocator()).isVisible();
    }
}