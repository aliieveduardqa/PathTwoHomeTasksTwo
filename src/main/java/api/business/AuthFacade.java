package api.business;

import api.models.request.AuthRequest;
import api.models.request.RegistrationRequest;
import api.models.response.AuthResponse;
import api.services.AuthService;
import api.utils.SessionContext;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AuthFacade {

    private final AuthService authService = new AuthService();

    @Step("Register user and save to session")
    public Response emailRegisterAndSaveSession(String email, String password) {

        RegistrationRequest request = RegistrationRequest.builder()
                .email(email)
                .password(password)
                .build();

        Response response = authService.postRegister(request);

        if (response.statusCode() == 200) {
            AuthResponse authResponse = response.as(AuthResponse.class);
            if (authResponse.getUser() != null && authResponse.getUser().getToken() != null) {
                SessionContext.setToken(authResponse.getUser().getToken());
            }
        }
        return response;
    }

    @Step("Logout current user locally (stateless)")
    public void logout() {
        SessionContext.clear();
    }

    @Step("Login user")
    public Response emailLogin(String email, String password) {
        AuthRequest request = AuthRequest.builder()
                .email(email)
                .password(password)
                .build();

        Response response = authService.postLogin(request);

        if (response.statusCode() == 200) {
            AuthResponse authResponse = response.as(AuthResponse.class);

            if (authResponse.getUser() != null && authResponse.getUser().getToken() != null) {
                SessionContext.setToken(authResponse.getUser().getToken());
            }
        }
        return response;
    }
}