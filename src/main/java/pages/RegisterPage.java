package pages;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

public class RegisterPage extends BasePage {

    private final Locator phoneRegistrationBtn = locator("(//*[contains(@class,'auth-tabs__btn')])[1]");
    private final Locator emailRegistrationBtn = locator("(//*[contains(@class,'auth-tabs__btn')])[2]");

    private final Locator phoneRegistrationInput = locator("//*[@name='reg_phone']");
    private final Locator passRegistrationPhoneInput = locator("//*[@data-id='register-password-input']");

    private final Locator emailRegistrationInput = locator("//*[@name='reg_email']");
    private final Locator passRegistrationEmailInput = locator("//*[@data-id='register-password-input']");

    private final Locator registrationBtn = locator("//*[contains(@class,'reg-form__submit')][1]");

    private final Locator errorRegistrationInputMsg = locator("(//*[@data-id='input-message-error'])[1]");
    private final Locator errorRegistrationPassInputMsg = locator("(//*[@data-id='input-message-error'])[2]");

    private final Locator registrationResult = locator("//*[contains(@class,'body-title-title-medium-b')][1]");

    @Step("Register new user via Phone: {phone}")
    public void registerPhoneUser(String phone, String password) {
        logger.info("Registering user via phone: {}", phone);
        phoneRegistrationBtn.click();
        phoneRegistrationInput.fill(phone);
        passRegistrationPhoneInput.fill(password);
        registrationBtn.click();
    }

    @Step("Register new user via Email: {email}")
    public void registerEmailUser(String email, String password) {
        logger.info("Registering user via email: {}", email);
        emailRegistrationBtn.click();
        emailRegistrationInput.fill(email);
        passRegistrationEmailInput.fill(password);
        registrationBtn.click();
    }

    public String getRegistrationResultText() {
        return registrationResult.textContent().trim();
    }

    public String getErrorInputMessage() {
        return errorRegistrationInputMsg.textContent().trim();
    }

    public String getErrorPasswordInputMessage() {
        return errorRegistrationPassInputMsg.textContent().trim();
    }
}