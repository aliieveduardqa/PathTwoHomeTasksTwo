package api.services;

import api.models.request.AuthRequest;
import api.models.request.RegistrationRequest;
import api.utils.SessionContext;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthService {

    @Step("Send POST request to /auth/register with email: {request.email}")
    public Response postRegister(RegistrationRequest request) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/auth/v2/register");
    }

    @Step("Send POST request to /auth/login with email: {request.email}")
    public Response postLogin(AuthRequest request) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/auth/login");
    }

}