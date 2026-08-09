package pages;

import com.microsoft.playwright.Page;

public class RegisterPage {
    private final Page page;

    private final String phoneRegistrationBtn = "//*[@data-id='password-recovery-phone-tab-button']";
    private final String emailRegistrationBtn = "//*[@data-id='password-recovery-email-tab-button']";

    private final String phoneRegistrationInput = "//*[@name='reg_phone']";
    private final String passRegistrationPhoneInput = "//*[@data-id='register-password-input']";

    private final String emailRegistrationInput = "//*[@name='reg_email']";
    private final String passRegistrationEmailInput = "//*[@data-id='register-password-input']";

    private final String registrationBtn = "//*[contains(@class,'reg-form__submit')][1]";

    private final String errorRegistrationInputMsg = "(//*[@data-id='input-message-error'])[1]";
    private final String errorRegistrationPassInputMsg = "(//*[@data-id='input-message-error'])[2]";

    private final String registrationResult = "//*[contains(@class,'body-title-title-medium-b')][1]";

    public RegisterPage(Page page) {
        this.page = page;
    }

    public void registerPhoneUser(String phone, String password) {
        page.click(phoneRegistrationBtn);
        page.fill(phoneRegistrationInput, phone);
        page.fill(passRegistrationPhoneInput, password);
        page.click(registrationBtn);
        page.click(registrationResult);
    }

    public void registerEmailUser(String email, String password) {
        page.click(emailRegistrationBtn);
        page.fill(emailRegistrationInput, email);
        page.fill(passRegistrationEmailInput, password);
        page.click(registrationBtn);
        page.click(registrationResult);
    }

    public String getRegistrationResultText() {
        return page.locator(registrationResult).textContent().trim();
    }

    public String getErrorInputMessage() {
        return page.locator(errorRegistrationInputMsg).textContent().trim();
    }

    public String getErrorPasswordInputMessage() {
        return page.locator(errorRegistrationPassInputMsg).textContent().trim();
    }


}