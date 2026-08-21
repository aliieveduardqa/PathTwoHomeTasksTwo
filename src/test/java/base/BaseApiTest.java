package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseApiTest {

    protected RequestSpecification baseSpec;

    public BaseApiTest() {
        baseSpec = new RequestSpecBuilder()
                .setBaseUri("https://apiv2.stage.slotcity.ua")
                .setContentType("application/json")
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
