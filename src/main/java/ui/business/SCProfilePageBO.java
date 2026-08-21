package ui.business;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.ProfilePage;

public class SCProfilePageBO {

    private static final Logger logger = LoggerFactory.getLogger(SCProfilePageBO.class);

    private final ProfilePage profilePage;

    public SCProfilePageBO() {
        this.profilePage = new ProfilePage();
    }

    @Step("Logout user from profile")
    public SCProfilePageBO logoutUser() {
        logger.info("Logging out user");
        profilePage.clickBurgerButton()
                .clickUserPanelSetting()
                .clickProfileSettingsTab()
                .clickLogoutButton()
                .clickSubmitLogoutButton();
        return this;
    }
}