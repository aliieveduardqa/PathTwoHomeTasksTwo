package ui.business;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.LoginPage;

public class SCLoginPageBO {

    private static final Logger logger = LoggerFactory.getLogger(SCLoginPageBO.class);

    private final LoginPage loginPage;

    public SCLoginPageBO() {
        this.loginPage = new LoginPage();
    }

    @Step("Login via Phone using: {phone}")
    public SCLoginPageBO loginViaPhone(String phone, String password) {
        logger.info("Logging in with phone: {}", phone);
        loginPage.clickPhoneTab()
                .fillPhone(phone)
                .fillPhonePassword(password)
                .clickLoginButton();
        return this;
    }

    @Step("Login via Email using: {email}")
    public SCLoginPageBO loginViaEmail(String email, String password) {
        logger.info("Logging in with email: {}", email);
        loginPage.clickEmailTab()
                .fillEmail(email)
                .fillEmailPassword(password)
                .clickLoginButton();
        return this;
    }

    @Step("Submit empty login form")
    public SCLoginPageBO submitEmptyLoginForm() {
        logger.info("Clicking submit login button without filling fields");
        loginPage.clickLoginButton();
        return this;
    }

    @Step("Submit empty registration form from login screen")
    public SCLoginPageBO submitEmptyRegistrationForm() {
        logger.info("Clicking submit registration button without filling fields");
        loginPage.clickRegistrationButton();
        return this;
    }

    @Step("Get login input error message")
    public String getLoginErrorMessage() {
        return loginPage.getErrorInputMessage();
    }

    @Step("Get password input error message")
    public String getPasswordErrorMessage() {
        return loginPage.getErrorPasswordInputMessage();
    }
}
