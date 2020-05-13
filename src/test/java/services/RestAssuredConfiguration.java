package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfiguration {

    public RequestSpecification getRequestSpecification(String baseUri, String basePAth, int basePort) {

        RestAssured.baseURI = baseUri;
        if (basePort != 0) {
            RestAssured.port = basePort;
        }
        RestAssured.basePath = basePAth;

        return RestAssured.given().contentType(ContentType.JSON);
    }

    public Response getResponsePost(RequestSpecification requestSpecification, String endpoint) {
        requestSpecification.log().all();
        Response response = requestSpecification.post(endpoint);
        response.then().log().all();
        return response;
    }

    public Response getResponseGet(RequestSpecification requestSpecification, String endpoint) {
        requestSpecification.log().all();
        Response response = requestSpecification.get(endpoint);
        response.then().log().all();
        return response;
    }
}
