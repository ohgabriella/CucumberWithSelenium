package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;


public class BaseApi {


    private static String URL_API = "http://api.exchangeratesapi.io/v1/";
    public Response response;


    public void requestGet() {
        response = RestAssured
                .given()
                .filter(new RequestLoggingFilter())
                .baseUri(URL_API)
                .when()
                .queryParam("access_key", "1ec264523cf4775a5014895ab154372e")
                .queryParam("symbols", "USD, BRL, EUR")
                .get("latest")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
