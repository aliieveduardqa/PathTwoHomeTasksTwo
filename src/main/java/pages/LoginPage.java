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

    private final Locator errorLoginInputMsg = locator("(//*[@data-id='input-message-error'])[1]");
    private final Locator errorLoginPassInputMsg = locator("(//*[@data-id='input-message-error'])[2]");

    public void phoneLogin(String phone, String password) {
        phoneLoginBtn.click();
        phoneLoginInput.fill(phone);
        passLoginPhoneInput.fill(password);
        loginBtn.click();
    }

    public void emailLogin(String email, String password) {
        emailLoginBtn.click();
        emailLoginInput.fill(email);
        passLoginEmailInput.fill(password);
        loginBtn.click();
    }

    public void clickSubmitLoginBtn() {
        loginBtn.click();
    }

    public Locator getErrorLoginInputLocator() {
        return errorLoginInputMsg;
    }

    public Locator getErrorPasswordInputLocator() {
        return errorLoginPassInputMsg;
    }

    public String getErrorInputMessage() {
        return errorLoginInputMsg.textContent().trim();
    }

    public String getErrorPasswordInputMessage() {
        return errorLoginPassInputMsg.textContent().trim();
    }
}