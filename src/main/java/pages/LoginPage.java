package pages;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

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

    @Step("Login via Phone using: {phone}")
    public void phoneLogin(String phone, String password) {
        logger.info("Logging in with phone: {}", phone);
        phoneLoginBtn.click();
        phoneLoginInput.fill(phone);
        passLoginPhoneInput.fill(password);
        loginBtn.click();
    }

    @Step("Login via Email using: {email}")
    public void emailLogin(String email, String password) {
        logger.info("Logging in with email: {}", email);
        emailLoginBtn.click();
        emailLoginInput.fill(email);
        passLoginEmailInput.fill(password);
        loginBtn.click();
    }

    @Step("Click submit login button without filling fields")
    public void clickSubmitLoginBtn() {
        logger.info("Clicking submit login button");
        loginBtn.click();
    }

    public Locator getErrorLoginInputLocator() { return errorLoginInputMsg; }
    public Locator getErrorPasswordInputLocator() { return errorLoginPassInputMsg; }

    public String getErrorInputMessage() {
        return errorLoginInputMsg.textContent().trim();
    }

    public String getErrorPasswordInputMessage() {
        return errorLoginPassInputMsg.textContent().trim();
    }
}