package demos;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_Token {

    @Test
    public void postTokenTest() {

        // Define BaseURI
        RestAssured.baseURI = "https://servicewapdigitaldes0100.azurewebsites.net/ecom-onco/auth/v2";

        String resource = "3335e89d-f67a-4b6e-85e1-f32c5413e512";

        JSONObject requestParams = new JSONObject();
        requestParams.put("resource", resource);

        // Request Object
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        // Response
        Response response = httpRequest.request(Method.POST, "/token/");

        // ResponseBody
        String responseBody = response.getBody().asString();
        System.out.println("Response body is : " + responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("Status code is : " + statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
