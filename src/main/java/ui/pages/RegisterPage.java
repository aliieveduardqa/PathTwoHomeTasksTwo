package ui.pages;

import com.microsoft.playwright.Locator;

public class RegisterPage extends BasePage {

    private final Locator phoneRegistrationBtn = locator("//*[@data-gtm-id='ga_registration_click_btn_choose_methode_phone']");
    private final Locator emailRegistrationBtn = locator("//*[@data-gtm-id='ga_registration_click_btn_choose_methode_email']");

    private final Locator phoneRegistrationInput = locator("//*[@name='reg_phone']");
    private final Locator emailRegistrationInput = locator("//*[@name='reg_email']");

    private final Locator passwordInput = locator("//*[@data-id='register-password-input']");
    private final Locator registrationBtn = locator("//*[contains(@class,'reg-form__submit')][1]");

    private final Locator errorRegistrationInputMsg = locator("(//*[@data-id='input-message-error'])[1]");
    private final Locator errorRegistrationPassInputMsg = locator("(//*[@data-id='input-message-error'])[2]");
    private final Locator registrationResult = locator("//*[contains(@class,'body-title-title-medium-b')][1]");

    public RegisterPage clickPhoneTab() {
        clickWithWait(phoneRegistrationBtn, "Phone Registration Tab");
        return this;
    }

    public RegisterPage clickEmailTab() {
        clickWithWait(emailRegistrationBtn, "Email Registration Tab");
        return this;
    }

    public RegisterPage fillPhone(String phone) {
        phoneRegistrationInput.fill(phone);
        return this;
    }

    public RegisterPage fillEmail(String email) {
        emailRegistrationInput.fill(email);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    public RegisterPage clickRegistrationButton() {
        registrationBtn.click();
        return this;
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