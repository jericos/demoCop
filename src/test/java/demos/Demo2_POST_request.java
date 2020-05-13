package demos;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo2_POST_request {

    @Test
    void  RegistrationSuccessful() {

        //especificar  base URI

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        // request object
        RequestSpecification httprequest = RestAssured.given();

        // request payload sending along with post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "aJnXYZ");
        requestParams.put("LastName", "XJshnXYZ");
        requestParams.put("UserName", "PringoksXYZ");
        requestParams.put("Password", "JddohnXYZ");
        requestParams.put("Email", "JofYsZ@gmail.com");

        httprequest.header("Content-Type", "application/json");
        httprequest.body(requestParams.toJSONString());

        // response object
        Response response = httprequest.request(Method.POST, "/register");

        // imprimimos response en la consola
        String responseBody = response.getBody().asString();
        System.out.println("Response body is : " + responseBody);

        //status code validation
        int statusCode = response.statusCode();
        System.out.println("Status code is : " + statusCode);
        Assert.assertEquals(statusCode, 201);

        //success code validation
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

        //status line validation
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
    }
}
