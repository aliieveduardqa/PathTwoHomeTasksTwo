package pages;

import com.microsoft.playwright.Page;

public class ProfilePage {
    private final Page page;

    private final String burgerBtn = "//*[@class='button-burger__bar']";
    private final String userPanelSettingBtn = "//*[contains(@class,'user-panel__setting')]//*[@fill-rule]";
    private final String profileSettingsTabBtn = "//*[@data-id='profile-settings-tab-button']";
    private final String profileSettingsLogoutBtn = "//*[@data-id='profile-settings-logout-button']";
    private final String profileSettingsSubmitBtn = "//*[@data-id='profile-logout-submit-button']";


    public ProfilePage(Page page) {
        this.page = page;
    }

    public void logoutUser() {
        page.locator(burgerBtn).click();
        page.locator(userPanelSettingBtn).click();
        page.locator(profileSettingsTabBtn).click();
        page.locator(profileSettingsLogoutBtn).click();
        page.locator(profileSettingsSubmitBtn).click();
    }
}
