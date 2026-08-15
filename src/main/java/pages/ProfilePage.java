package pages;

import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

public class ProfilePage extends BasePage {

    private final Locator burgerBtn = locator("//*[@class='button-burger__bar']");
    private final Locator userPanelSettingBtn = locator("//*[contains(@class,'user-panel__setting')]//*[@fill-rule]");
    private final Locator profileSettingsTabBtn = locator("//*[@data-id='profile-settings-tab-button']");
    private final Locator profileSettingsLogoutBtn = locator("//*[@data-id='profile-settings-logout-button']");
    private final Locator profileSettingsSubmitBtn = locator("//*[@data-id='profile-logout-submit-button']");

    @Step("Logout user from profile")
    public void logoutUser() {
        logger.info("Logging out user");
        burgerBtn.click();
        userPanelSettingBtn.click();
        profileSettingsTabBtn.click();
        profileSettingsLogoutBtn.click();
        profileSettingsSubmitBtn.click();
    }
}