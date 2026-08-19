package pages;

import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    private final Locator phoneLoginBtn = locator("//*[@data-id='password-recovery-phone-tab-button']");
    private final Locator emailLoginBtn = locator("//*[@data-id='password-recovery-email-tab-button']");

    private final Locator phoneLoginInput = locator("//*[@name='auth_phone']");
    private final Locator passLoginPhoneInput = locator("//*[@name='password_phone']");

    private final Locator emailLoginInput = locator("//*[@name='auth_email']");
    private final Locator passLoginEmailInput = locator("//*[@name='password_email']");

    private final Locator loginBtn = locator("//*[contains(@class,'auth-form__submit')][1]");
    private final Locator registrationBtn = locator("//*[contains(@class,'reg-form__submit')][1]");

    private final Locator errorLoginInputMsg = locator("(//*[@data-id='input-message-error'])[1]");
    private final Locator errorLoginPassInputMsg = locator("(//*[@data-id='input-message-error'])[2]");

    public LoginPage clickPhoneTab() {
        phoneLoginBtn.click();
        return this;
    }

    public LoginPage clickEmailTab() {
        emailLoginBtn.click();
        return this;
    }

    public LoginPage fillPhone(String phone) {
        phoneLoginInput.fill(phone);
        return this;
    }

    public LoginPage fillPhonePassword(String password) {
        passLoginPhoneInput.fill(password);
        return this;
    }

    public LoginPage fillEmail(String email) {
        emailLoginInput.fill(email);
        return this;
    }

    public LoginPage fillEmailPassword(String password) {
        passLoginEmailInput.fill(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginBtn.click();
        return this;
    }

    public LoginPage clickRegistrationButton() {
        registrationBtn.click();
        return this;
    }

    public String getErrorInputMessage() {
        return errorLoginInputMsg.textContent().trim();
    }

    public String getErrorPasswordInputMessage() {
        return errorLoginPassInputMsg.textContent().trim();
    }
}