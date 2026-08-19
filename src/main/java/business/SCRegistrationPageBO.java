package business;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegisterPage;

public class SCRegistrationPageBO {

    private static final Logger logger = LoggerFactory.getLogger(SCRegistrationPageBO.class);
    private final RegisterPage registerPage;

    public SCRegistrationPageBO() {
        this.registerPage = new RegisterPage();
    }

    @Step("Register new user via Email: {email}")
    public SCRegistrationPageBO registerEmailUser(String email, String password) {
        logger.info("Registering user via email: {}", email);
        registerPage.clickEmailTab()
                .fillEmail(email)
                .fillPassword(password)
                .clickRegistrationButton();
        return this;
    }

    @Step("Register new user via Phone: {phone}")
    public SCRegistrationPageBO registerPhoneUser(String phone, String password) {
        logger.info("Registering user via phone: {}", phone);
        registerPage.clickPhoneTab()
                .fillPhone(phone)
                .fillPassword(password)
                .clickRegistrationButton();
        return this;
    }

    @Step("Submit empty registration form")
    public SCRegistrationPageBO submitEmptyRegistrationForm() {
        logger.info("Clicking submit registration button without filling fields");
        registerPage.clickRegistrationButton();
        return this;
    }

    @Step("Get registration success message")
    public String getSuccessMessage() {
        return registerPage.getRegistrationResultText();
    }

    @Step("Get registration input error message")
    public String getRegistrationInputErrorMessage() {
        return registerPage.getErrorInputMessage();
    }

    @Step("Get registration password error message")
    public String getRegistrationPasswordErrorMessage() {
        return registerPage.getErrorPasswordInputMessage();
    }

}