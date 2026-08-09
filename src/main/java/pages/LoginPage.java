package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    private final String phoneLoginBtn = "//*[@data-id='password-recovery-phone-tab-button']";
    private final String emailLoginBtn = "//*[@data-id='password-recovery-email-tab-button']";

    private final String phoneLoginInput = "//*[@name='auth_phone']";
    private final String passLoginPhoneInput = "//*[@name='password_phone']";

    private final String emailLoginInput = "//*[@name='auth_email']";
    private final String passLoginEmailInput = "//*[@name='password_email']";

    private final String loginBtn = "//*[contains(@class,'auth-form__submit')][1]";

    private final String errorLoginInputMsg = "(//*[@data-id='input-message-error'])[1]";
    private final String errorLoginPassInputMsg = "(//*[@data-id='input-message-error'])[2]";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void phoneLogin(String phone, String password) {
        page.locator(phoneLoginBtn).click();
        page.locator(phoneLoginInput).fill(phone);
        page.locator(passLoginPhoneInput).fill(password);
        page.locator(loginBtn).click();
    }

    public void emailLogin(String email, String password) {
        page.locator(emailLoginBtn).click();
        page.locator(emailLoginInput).fill(email);
        page.locator(passLoginEmailInput).fill(password);
        page.locator(loginBtn).click();
    }
    public void clickSubmitLogiBtn() {
        page.locator(loginBtn).click();
    }

    public Locator getErrorLoginInputLocator() {
        return page.locator(errorLoginInputMsg);
    }

    public Locator getErrorPasswordInputLocator() {
        return page.locator(errorLoginPassInputMsg);
    }

    public String getErrorInputMessage() {
        return page.locator(errorLoginInputMsg).textContent().trim();
    }

    public String getErrorPasswordInputMessage() {
        return page.locator(errorLoginPassInputMsg).textContent().trim();
    }
}