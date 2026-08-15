package pages;

import com.microsoft.playwright.Locator;

public class RegisterPage extends BasePage {

    private final Locator phoneRegistrationBtn = locator("//*[@data-id='password-recovery-phone-tab-button']");
    private final Locator emailRegistrationBtn = locator("//*[@data-id='password-recovery-email-tab-button']");

    private final Locator phoneRegistrationInput = locator("//*[@name='reg_phone']");
    private final Locator passRegistrationPhoneInput = locator("//*[@data-id='register-password-input']");

    private final Locator emailRegistrationInput = locator("//*[@name='reg_email']");
    private final Locator passRegistrationEmailInput = locator("//*[@data-id='register-password-input']");

    private final Locator registrationBtn = locator("//*[contains(@class,'reg-form__submit')][1]");

    private final Locator errorRegistrationInputMsg = locator("(//*[@data-id='input-message-error'])[1]");
    private final Locator errorRegistrationPassInputMsg = locator("(//*[@data-id='input-message-error'])[2]");

    private final Locator registrationResult = locator("//*[contains(@class,'body-title-title-medium-b')][1]");

    public void registerPhoneUser(String phone, String password) {
        phoneRegistrationBtn.click();
        phoneRegistrationInput.fill(phone);
        passRegistrationPhoneInput.fill(password);
        registrationBtn.click();
        registrationResult.click();
    }

    public void registerEmailUser(String email, String password) {
        emailRegistrationBtn.click();
        emailRegistrationInput.fill(email);
        passRegistrationEmailInput.fill(password);
        registrationBtn.click();
        registrationResult.click();
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