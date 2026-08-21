package api.services;

import api.models.request.PromoCodeRequest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PromoCodeService {

    @Step("Send POST request to /promo/apply with code: {request.promoCode}")
    public Response postApplyPromoCode(PromoCodeRequest request, String token) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post("/promocodes/activate");
    }
}