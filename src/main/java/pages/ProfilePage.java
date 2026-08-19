package pages;

import com.microsoft.playwright.Locator;

public class ProfilePage extends BasePage {

    private final Locator burgerBtn = locator("//*[@class='button-burger__bar']");
    private final Locator userPanelSettingBtn = locator("//*[contains(@class,'user-panel__setting')]//*[@fill-rule]");
    private final Locator profileSettingsTabBtn = locator("//*[@data-id='profile-settings-tab-button']");
    private final Locator profileSettingsLogoutBtn = locator("//*[@data-id='profile-settings-logout-button']");
    private final Locator profileSettingsSubmitBtn = locator("//*[@data-id='profile-logout-submit-button']");

    public ProfilePage clickBurgerButton() {
        burgerBtn.click();
        return this;
    }

    public ProfilePage clickUserPanelSetting() {
        userPanelSettingBtn.click();
        return this;
    }

    public ProfilePage clickProfileSettingsTab() {
        profileSettingsTabBtn.click();
        return this;
    }

    public ProfilePage clickLogoutButton() {
        profileSettingsLogoutBtn.click();
        return this;
    }

    public ProfilePage clickSubmitLogoutButton() {
        profileSettingsSubmitBtn.click();
        return this;
    }
}