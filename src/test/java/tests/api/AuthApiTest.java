package tests.api;

import api.business.AuthFacade;
import api.models.request.PromoCodeRequest;
import api.models.response.PromoCodeResponse;
import api.services.PromoCodeService;
import api.utils.SessionContext;
import base.BaseApiTest;
import data.TestDataProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("API e2e Tests")
@Feature("User Authentication and Promo Flow")
public class AuthApiTest extends BaseApiTest {

    private AuthFacade authFacade;
    private PromoCodeService promoCodeService;

    @BeforeMethod
    public void setup() {
        RestAssured.requestSpecification = baseSpec;
        authFacade = new AuthFacade();
        promoCodeService = new PromoCodeService();
    }

    @AfterMethod
    public void tearDown() {
        SessionContext.clear();
    }

    @Test(description = "1. Verify successful user registration", dataProvider = "registrationData", dataProviderClass = TestDataProvider.class)
    @Story("Registration")
    public void testUserRegistration(String email, String password) {
        var response = authFacade.emailRegisterAndSaveSession(email, password);

        Assert.assertEquals(response.statusCode(), 200, "Registration failed");
        Assert.assertNotNull(SessionContext.getToken(), "Token was not saved to session context");
    }

    @Test(description = "2. Verify successful logout", dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Story("Logout")
    public void testUserLogout(String email, String password) {
        authFacade.emailLogin(email, password);
        var response = authFacade.logout();

        Assert.assertEquals(response.statusCode(), 200, "Logout failed");
    }

    @Test(description = "3. Verify successful login for existing user", dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Story("Login")
    public void testUserLogin(String email, String password) {
        var response = authFacade.emailLogin(email, password);

        Assert.assertEquals(response.statusCode(), 200, "Login failed");
        Assert.assertNotNull(SessionContext.getToken(), "Token was not updated in session after login");
    }

    @Test(description = "4. Verify promo code application and bonus activation for an existing user", dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Story("Promo Code")
    public void testApplyPromoCode(String email, String password) {
        var loginResponse = authFacade.emailLogin(email, password);
        Assert.assertEquals(loginResponse.statusCode(), 200, "Precondition failed: Login was unsuccessful");

        PromoCodeRequest promoPayload = PromoCodeRequest.builder().code("075D800A28").build();

        var response = promoCodeService.postApplyPromoCode(promoPayload, SessionContext.getToken());

        Assert.assertEquals(response.statusCode(), 200, "HTTP Status should be 200");

        PromoCodeResponse promoResponse = response.as(PromoCodeResponse.class);

        Assert.assertTrue(promoResponse.isStatus(), "Response status should be true");
        Assert.assertFalse(promoResponse.getPromotions().isEmpty(), "Promotions list should not be empty");

    }


}