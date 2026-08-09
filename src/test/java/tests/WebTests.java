package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterPage;
import utils.DataGenerator;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WebTests extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
        registerPage = new RegisterPage(page);
        profilePage = new ProfilePage(page);
    }

    @Test
    public void testSuccessfulRegistration() {
        page.waitForTimeout(5_000);
        homePage.clickRegisterBtn();
        String uniqueEmail = DataGenerator.generateUniqueEmail("aliieveduardqa", "sharkscode.com");
        System.out.println("Registering user with email: " + uniqueEmail);
        registerPage.registerEmailUser(uniqueEmail, "222222");
        assertThat(homePage.getPayInButton()).isVisible();
    }

    @Test
    public void testLoginWithOutFields() {
        page.waitForTimeout(5_000);
        loginPage.clickSubmitLogiBtn();
        assertThat(loginPage.getErrorLoginInputLocator()).hasText("Обов'язкове поле");
        assertThat(loginPage.getErrorPasswordInputLocator()).hasText("Обов'язкове поле");
    }

    @Test
    public void testSuccessfulLogin() {
        page.waitForTimeout(5_000);
        homePage.clickLoginBtn();
        loginPage.emailLogin("aliieveduardqa+1@sharkscode.com", "111111");
        assertThat(homePage.getPayInButton()).isVisible();
    }

    @Test
    public void testLogout() {
        page.waitForTimeout(5_000);
        homePage.clickLoginBtn();
        loginPage.emailLogin("aliieveduardqa+1@sharkscode.com", "111111");
        profilePage.logoutUser();
        assertThat(homePage.getLogoutButton()).isVisible();
    }

    @Test
    public void testSearchProduct() {
        page.waitForTimeout(5_000);

        String searchQuery = "Gate of olympus";
        homePage.searchForProduct(searchQuery);

        homePage.getSearchCounterLocator().waitFor();
        String countText = homePage.getSearchCounterLocator().textContent().trim();
        int gameCount = Integer.parseInt(countText);
        Assert.assertTrue(gameCount > 0, "Error: Number of games found must be greater than 0");

        assertThat(homePage.getSearchGamePresentLocator()).isVisible();

    }


}